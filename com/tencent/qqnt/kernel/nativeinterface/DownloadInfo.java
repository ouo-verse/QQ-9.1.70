package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class DownloadInfo implements Serializable {
    public int cancelCount;
    public int failedCount;
    public int pausedCount;
    long serialVersionUID = 1;
    public FileSetDownloadTaskStatus status = FileSetDownloadTaskStatus.values()[0];
    public int successCount;
    public long totalDownloadFileCount;
    public long totalDownloadedFileSize;
    public long totalFileSize;

    public int getCancelCount() {
        return this.cancelCount;
    }

    public int getFailedCount() {
        return this.failedCount;
    }

    public int getPausedCount() {
        return this.pausedCount;
    }

    public FileSetDownloadTaskStatus getStatus() {
        return this.status;
    }

    public int getSuccessCount() {
        return this.successCount;
    }

    public long getTotalDownloadFileCount() {
        return this.totalDownloadFileCount;
    }

    public long getTotalDownloadedFileSize() {
        return this.totalDownloadedFileSize;
    }

    public long getTotalFileSize() {
        return this.totalFileSize;
    }
}
