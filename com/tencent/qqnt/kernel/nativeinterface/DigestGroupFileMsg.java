package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class DigestGroupFileMsg {
    public int busId;
    public long deadTime;
    public long fileSize;
    public byte[] fileName = new byte[0];
    public String fileId = "";
    public byte[] fileSha1 = new byte[0];
    public byte[] ext = new byte[0];
    public byte[] fileMd5 = new byte[0];

    public int getBusId() {
        return this.busId;
    }

    public long getDeadTime() {
        return this.deadTime;
    }

    public byte[] getExt() {
        return this.ext;
    }

    public String getFileId() {
        return this.fileId;
    }

    public byte[] getFileMd5() {
        return this.fileMd5;
    }

    public byte[] getFileName() {
        return this.fileName;
    }

    public byte[] getFileSha1() {
        return this.fileSha1;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public String toString() {
        return "DigestGroupFileMsg{fileName=" + this.fileName + ",busId=" + this.busId + ",fileId=" + this.fileId + ",fileSize=" + this.fileSize + ",deadTime=" + this.deadTime + ",fileSha1=" + this.fileSha1 + ",ext=" + this.ext + ",fileMd5=" + this.fileMd5 + ",}";
    }
}
