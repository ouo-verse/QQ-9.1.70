package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class FileSetUploadProgressInfo {
    public long failedFileCount;
    public FileSet fileSet = new FileSet();
    public long timeRemain;
    public long totalFileCount;
    public long uploadSpeed;
    public long uploadedFileCount;
    public long uploadedFileSize;
    public long vipUploadSpeed;

    public long getFailedFileCount() {
        return this.failedFileCount;
    }

    public FileSet getFileSet() {
        return this.fileSet;
    }

    public long getTimeRemain() {
        return this.timeRemain;
    }

    public long getTotalFileCount() {
        return this.totalFileCount;
    }

    public long getUploadSpeed() {
        return this.uploadSpeed;
    }

    public long getUploadedFileCount() {
        return this.uploadedFileCount;
    }

    public long getUploadedFileSize() {
        return this.uploadedFileSize;
    }

    public long getVipUploadSpeed() {
        return this.vipUploadSpeed;
    }
}
