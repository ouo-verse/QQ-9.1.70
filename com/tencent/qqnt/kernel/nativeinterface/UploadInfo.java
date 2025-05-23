package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class UploadInfo {
    public int failedCount;
    public int successCount;
    public long totalUploadedFileSize;

    public int getFailedCount() {
        return this.failedCount;
    }

    public int getSuccessCount() {
        return this.successCount;
    }

    public long getTotalUploadedFileSize() {
        return this.totalUploadedFileSize;
    }
}
