package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SimpleFileSetStatusInfo {
    public long completedFileCount;
    public long completedFileSize;
    public long failedFileCount;
    public boolean isLocalCreate;
    public long speed;
    public long timeRemain;
    public long totalTaskFileCount;
    public long totalTaskFileSize;
    public FileSetSimpleInfo fileSetSimpleInfo = new FileSetSimpleInfo();
    public FileSetSimpleStatus status = FileSetSimpleStatus.values()[0];
    public FileSetStatus fileSetStatus = FileSetStatus.values()[0];
    public FileSetUploadStatus uploadStatus = FileSetUploadStatus.values()[0];
    public FileSetDownloadStatus downloadStatus = FileSetDownloadStatus.values()[0];
    public FlashTransferPauseReason uploadPauseReason = FlashTransferPauseReason.values()[0];
    public FlashTransferPauseReason downloadPauseReason = FlashTransferPauseReason.values()[0];

    public long getCompletedFileCount() {
        return this.completedFileCount;
    }

    public long getCompletedFileSize() {
        return this.completedFileSize;
    }

    public FlashTransferPauseReason getDownloadPauseReason() {
        return this.downloadPauseReason;
    }

    public FileSetDownloadStatus getDownloadStatus() {
        return this.downloadStatus;
    }

    public long getFailedFileCount() {
        return this.failedFileCount;
    }

    public FileSetSimpleInfo getFileSetSimpleInfo() {
        return this.fileSetSimpleInfo;
    }

    public FileSetStatus getFileSetStatus() {
        return this.fileSetStatus;
    }

    public boolean getIsLocalCreate() {
        return this.isLocalCreate;
    }

    public long getSpeed() {
        return this.speed;
    }

    public FileSetSimpleStatus getStatus() {
        return this.status;
    }

    public long getTimeRemain() {
        return this.timeRemain;
    }

    public long getTotalTaskFileCount() {
        return this.totalTaskFileCount;
    }

    public long getTotalTaskFileSize() {
        return this.totalTaskFileSize;
    }

    public FlashTransferPauseReason getUploadPauseReason() {
        return this.uploadPauseReason;
    }

    public FileSetUploadStatus getUploadStatus() {
        return this.uploadStatus;
    }
}
