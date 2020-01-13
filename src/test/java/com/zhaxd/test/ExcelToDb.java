package com.zhaxd.test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.monitorjbl.xlsx.StreamingReader;

public class ExcelToDb {
    public void testLoad() {
        FileInputStream in = null;
        try {
            in = new FileInputStream("G:/exams0.xlsx");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Workbook wk = StreamingReader.builder().rowCacheSize(100) // 缓存到内存中的行数，默认是10
				.bufferSize(4096) // 读取资源时，缓存到内存的字节大小，默认是1024
				.open(in); // 打开资源，必须，可以是InputStream或者是File，注意：只能打开XLSX格式的文件
		Sheet sheet = wk.getSheetAt(0);
         //遍历所有的行
		for (Row row : sheet) {
			System.out.println("开始遍历第" + row.getRowNum() + "行数据：");
			// 遍历所有的列
			for (Cell cell : row) {
				System.out.print(cell.getStringCellValue() + " ");
			}
			System.out.println(" ");
		}
    }

public static void main(String[] args) throws Exception {
	ExcelToDb t = new ExcelToDb();
    t.testLoad();
}
}