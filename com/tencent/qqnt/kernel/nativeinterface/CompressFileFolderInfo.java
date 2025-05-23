package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class CompressFileFolderInfo {
    public FileSetDownloadStatus downloadStatus = FileSetDownloadStatus.values()[0];
    public String saveFileDirPath = "";
    public long totalFileCount;
    public long totalFileSize;

    public FileSetDownloadStatus getDownloadStatus() {
        return this.downloadStatus;
    }

    public String getSaveFileDirPath() {
        return this.saveFileDirPath;
    }

    public long getTotalFileCount() {
        return this.totalFileCount;
    }

    public long getTotalFileSize() {
        return this.totalFileSize;
    }
}
