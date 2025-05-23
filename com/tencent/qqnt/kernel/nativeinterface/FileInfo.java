package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class FileInfo {
    public int height;
    public boolean isOriginal;
    public long size;
    public int time;
    public int width;
    public String md5 = "";
    public String sha1 = "";
    public ArrayList<String> cumulateSha1s = new ArrayList<>();
    public String fileName = "";
    public FileType fileType = new FileType();
    public String filePath = "";

    public ArrayList<String> getCumulateSha1s() {
        return this.cumulateSha1s;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public FileType getFileType() {
        return this.fileType;
    }

    public int getHeight() {
        return this.height;
    }

    public boolean getIsOriginal() {
        return this.isOriginal;
    }

    public String getMd5() {
        return this.md5;
    }

    public String getSha1() {
        return this.sha1;
    }

    public long getSize() {
        return this.size;
    }

    public int getTime() {
        return this.time;
    }

    public int getWidth() {
        return this.width;
    }

    public String toString() {
        return "FileInfo{size=" + this.size + ",md5=" + this.md5 + ",sha1=" + this.sha1 + ",cumulateSha1s=" + this.cumulateSha1s + ",fileName=" + this.fileName + ",fileType=" + this.fileType + ",filePath=" + this.filePath + ",width=" + this.width + ",height=" + this.height + ",time=" + this.time + ",isOriginal=" + this.isOriginal + ",}";
    }
}
