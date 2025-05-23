package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class DownloadGroupFileParams {
    public String fileId;
    public long fileModelId;
    public String fileName;
    public long fileSize;

    public DownloadGroupFileParams() {
        this.fileId = "";
        this.fileName = "";
    }

    public String getFileId() {
        return this.fileId;
    }

    public long getFileModelId() {
        return this.fileModelId;
    }

    public String getFileName() {
        return this.fileName;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public DownloadGroupFileParams(String str, String str2, long j3, long j16) {
        this.fileId = str;
        this.fileName = str2;
        this.fileSize = j3;
        this.fileModelId = j16;
    }
}
