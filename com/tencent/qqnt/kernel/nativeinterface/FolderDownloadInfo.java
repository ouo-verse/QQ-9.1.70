package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class FolderDownloadInfo {
    public int cancelCount;
    public int downloadingCount;
    public int failedCount;
    public int partialDownloadCount;
    public int pausedCount;
    public int successCount;
    public int totalDownloadFileCount;
    public long totalDownloadedFileSize;
    public long totalFileSize;

    public int getCancelCount() {
        return this.cancelCount;
    }

    public int getDownloadingCount() {
        return this.downloadingCount;
    }

    public int getFailedCount() {
        return this.failedCount;
    }

    public int getPartialDownloadCount() {
        return this.partialDownloadCount;
    }

    public int getPausedCount() {
        return this.pausedCount;
    }

    public int getSuccessCount() {
        return this.successCount;
    }

    public int getTotalDownloadFileCount() {
        return this.totalDownloadFileCount;
    }

    public long getTotalDownloadedFileSize() {
        return this.totalDownloadedFileSize;
    }

    public long getTotalFileSize() {
        return this.totalFileSize;
    }
}
