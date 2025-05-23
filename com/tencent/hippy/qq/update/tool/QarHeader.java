package com.tencent.hippy.qq.update.tool;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public class QarHeader extends QIO {
    public static final int QAR_VERSION = 1;
    private int countEx;
    private int hasEx;
    public int qarMark;
    public int version;
    public final int QAR_MARK = 1233211;
    private List<ExtensionFiled> exs = null;

    public boolean isQBDAvabile() {
        if (this.qarMark != 1233211) {
            return false;
        }
        return true;
    }

    public void md5Header(MessageDigest messageDigest) throws IOException {
        md5Int(messageDigest, 1233211);
        md5Int(messageDigest, this.version);
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

    public QarHeader readHeader(BufferedInputStream bufferedInputStream) throws Exception {
        this.qarMark = readInt(bufferedInputStream);
        this.version = readInt(bufferedInputStream);
        int readInt = readInt(bufferedInputStream);
        this.hasEx = readInt;
        if (readInt == 1) {
            this.countEx = readInt(bufferedInputStream);
            this.exs = new ArrayList();
            for (int i3 = 0; i3 < this.countEx; i3++) {
                String readString = readString(bufferedInputStream);
                String readString2 = readString(bufferedInputStream);
                ExtensionFiled extensionFiled = new ExtensionFiled();
                extensionFiled.setEx(readString, readString2);
                this.exs.add(extensionFiled);
            }
        }
        return this;
    }

    public void setExtensionFileds(List<ExtensionFiled> list) {
        this.exs = list;
        if (list != null && list.size() != 0) {
            this.hasEx = 1;
        } else {
            this.hasEx = 0;
        }
    }

    public void setHeader(int i3) {
        this.version = i3;
    }

    public void writeHeader(BufferedOutputStream bufferedOutputStream) throws IOException {
        writeInt(bufferedOutputStream, 1233211);
        writeInt(bufferedOutputStream, this.version);
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
}
