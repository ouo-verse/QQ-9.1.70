package com.tencent.hippy.qq.update.tool;

import com.tencent.hippy.qq.update.qarchive.tools.zip.ZipEntry;
import com.tencent.hippy.qq.update.qarchive.tools.zip.ZipOutputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public class QarBody extends QIO {
    public static final int TYPE_DIR = 2;
    public static final int TYPE_FILE = 1;
    public int countEx;
    public int type = -1;
    public String fileName = "";
    public long fileLength = -1;
    public long crc = -1;
    public int method = 8;
    public int hasEx = -1;
    public List<ExtensionFiled> exs = null;

    private boolean checkRequiredParam() {
        if (this.type == -1 || this.fileName.equals("") || this.hasEx == -1) {
            return false;
        }
        if (this.type == 1 && (this.fileLength == -1 || this.crc == -1)) {
            return false;
        }
        return true;
    }

    public void md5Body(MessageDigest messageDigest) throws IOException {
        if (!checkRequiredParam()) {
            return;
        }
        md5Int(messageDigest, this.type);
        md5String(messageDigest, this.fileName);
        md5Long(messageDigest, this.fileLength);
        md5Long(messageDigest, this.crc);
        md5Int(messageDigest, this.method);
        md5Int(messageDigest, this.hasEx);
        if (this.hasEx == 1) {
            int size = this.exs.size();
            this.countEx = size;
            md5Int(messageDigest, size);
            Iterator<ExtensionFiled> it = this.exs.iterator();
            while (it.hasNext()) {
                it.next().md5Ex(messageDigest);
            }
        }
    }

    public void md5BodyData(MessageDigest messageDigest, InputStream inputStream, byte[] bArr) throws IOException {
        while (true) {
            int read = inputStream.read(bArr);
            if (read > 0) {
                messageDigest.update(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    public QarBody readBody(InputStream inputStream) throws Exception {
        this.type = readInt(inputStream);
        this.fileName = readString(inputStream);
        this.fileLength = readLong(inputStream);
        this.crc = readLong(inputStream);
        this.method = readInt(inputStream);
        int readInt = readInt(inputStream);
        this.hasEx = readInt;
        if (readInt == 1) {
            this.countEx = readInt(inputStream);
            this.exs = new ArrayList();
            for (int i3 = 0; i3 < this.countEx; i3++) {
                String readString = readString(inputStream);
                String readString2 = readString(inputStream);
                ExtensionFiled extensionFiled = new ExtensionFiled();
                extensionFiled.setEx(readString, readString2);
                this.exs.add(extensionFiled);
            }
        }
        return this;
    }

    public void readBodyData(InputStream inputStream, ZipOutputStream zipOutputStream, byte[] bArr) throws IOException {
        ZipEntry zipEntry = new ZipEntry(this.fileName);
        zipEntry.setSize(this.fileLength);
        zipOutputStream.putNextEntry(zipEntry);
        long j3 = 0;
        while (true) {
            long j16 = 32768 + j3;
            long j17 = this.fileLength;
            if (j16 < j17) {
                inputStream.read(bArr);
                zipOutputStream.write(bArr, 0, 2048);
                j3 = j16;
            } else {
                int i3 = (int) (j17 - j3);
                byte[] bArr2 = new byte[i3];
                inputStream.read(bArr2);
                zipOutputStream.write(bArr2, 0, i3);
                return;
            }
        }
    }

    public void setBody(int i3, String str, long j3, long j16, int i16) {
        this.type = i3;
        this.fileLength = j3;
        this.fileName = str;
        this.crc = j16;
        this.method = i16;
    }

    public void setExtensionFileds(List<ExtensionFiled> list) {
        this.exs = list;
        if (list != null && list.size() != 0) {
            this.hasEx = 1;
        } else {
            this.hasEx = 0;
        }
    }

    public void writeBody(BufferedOutputStream bufferedOutputStream) throws IOException {
        if (!checkRequiredParam()) {
            return;
        }
        writeInt(bufferedOutputStream, this.type);
        writeString(bufferedOutputStream, this.fileName);
        writeLong(bufferedOutputStream, this.fileLength);
        writeLong(bufferedOutputStream, this.crc);
        writeInt(bufferedOutputStream, this.method);
        writeInt(bufferedOutputStream, this.hasEx);
        if (this.hasEx == 1) {
            int size = this.exs.size();
            this.countEx = size;
            writeInt(bufferedOutputStream, size);
            Iterator<ExtensionFiled> it = this.exs.iterator();
            while (it.hasNext()) {
                it.next().writeEx(bufferedOutputStream);
            }
        }
    }

    public void writeBodyData(BufferedOutputStream bufferedOutputStream, InputStream inputStream, byte[] bArr) throws IOException {
        while (true) {
            int read = inputStream.read(bArr);
            if (read > 0) {
                bufferedOutputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }
}
