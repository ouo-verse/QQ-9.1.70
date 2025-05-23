package com.tencent.mobileqq.triton.font;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.lang.CharEncoding;

/* compiled from: P */
/* loaded from: classes19.dex */
public class FontFileReader {
    private int current;
    private byte[] file;
    private int fsize;

    public FontFileReader(InputStream inputStream) throws IOException {
        init(inputStream);
    }

    public static String getFamilyName(String str) {
        if (str != null && str.length() > 0) {
            String replaceAll = new File(str).getName().replaceAll(" ", "_");
            try {
                TTFFile readTTF = readTTF(str);
                if (readTTF != null) {
                    if (readTTF.getFamilyNames() != null && !readTTF.getFamilyNames().isEmpty()) {
                        for (String str2 : readTTF.getFamilyNames()) {
                            if (str2 != null && !str2.matches(".*[\u4e00-\u9fff]+.*")) {
                                return str2;
                            }
                        }
                        return replaceAll;
                    }
                    if (readTTF.getFullName() != null && readTTF.getFullName().length() > 0) {
                        return readTTF.getFullName();
                    }
                }
                return replaceAll;
            } catch (IOException e16) {
                e16.printStackTrace();
                return replaceAll;
            }
        }
        return "";
    }

    private void init(InputStream inputStream) throws IOException {
        byte[] byteArray = IOUtils.toByteArray(inputStream);
        this.file = byteArray;
        this.fsize = byteArray.length;
        this.current = 0;
    }

    private byte read() throws IOException {
        int i3 = this.current;
        if (i3 < this.fsize) {
            byte[] bArr = this.file;
            this.current = i3 + 1;
            return bArr[i3];
        }
        throw new EOFException("Reached EOF, file size=" + this.fsize);
    }

    public static TTFFile readTTF(String str) throws IOException {
        TTFFile tTFFile = new TTFFile();
        tTFFile.readFont(new FontFileReader(str));
        return tTFFile;
    }

    public byte[] getAllBytes() {
        return this.file;
    }

    public int getCurrentPos() {
        return this.current;
    }

    public int getFileSize() {
        return this.fsize;
    }

    public byte readTTFByte() throws IOException {
        return read();
    }

    public int readTTFLong() throws IOException {
        return (int) ((((((readTTFUByte() << 8) + readTTFUByte()) << 8) + readTTFUByte()) << 8) + readTTFUByte());
    }

    public String readTTFString(int i3) throws IOException {
        int i16 = this.current;
        if (i3 + i16 <= this.fsize) {
            byte[] bArr = new byte[i3];
            System.arraycopy(this.file, i16, bArr, 0, i3);
            this.current += i3;
            return new String(bArr, (i3 <= 0 || bArr[0] != 0) ? "ISO-8859-1" : CharEncoding.UTF_16BE);
        }
        throw new EOFException("Reached EOF, file size=" + this.fsize);
    }

    public int readTTFUByte() throws IOException {
        byte read = read();
        if (read < 0) {
            return read + 256;
        }
        return read;
    }

    public long readTTFULong() throws IOException {
        return (((((readTTFUByte() << 8) + readTTFUByte()) << 8) + readTTFUByte()) << 8) + readTTFUByte();
    }

    public int readTTFUShort() throws IOException {
        return (readTTFUByte() << 8) + readTTFUByte();
    }

    public void seekSet(long j3) throws IOException {
        if (j3 <= this.fsize && j3 >= 0) {
            this.current = (int) j3;
            return;
        }
        throw new EOFException("Reached EOF, file size=" + this.fsize + " offset=" + j3);
    }

    public void skip(long j3) throws IOException {
        seekSet(this.current + j3);
    }

    public FontFileReader(String str) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File(str));
        try {
            init(fileInputStream);
        } finally {
            fileInputStream.close();
        }
    }

    public static TTFFile readTTF(InputStream inputStream) throws IOException {
        TTFFile tTFFile = new TTFFile();
        tTFFile.readFont(new FontFileReader(inputStream));
        return tTFFile;
    }

    public String readTTFString(int i3, int i16) throws IOException {
        int i17 = this.current;
        if (i3 + i17 <= this.fsize) {
            byte[] bArr = new byte[i3];
            System.arraycopy(this.file, i17, bArr, 0, i3);
            this.current += i3;
            return new String(bArr, CharEncoding.UTF_16BE);
        }
        throw new EOFException("Reached EOF, file size=" + this.fsize);
    }
}
