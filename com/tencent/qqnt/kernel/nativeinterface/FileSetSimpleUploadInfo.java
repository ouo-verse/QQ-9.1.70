package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class FileSetSimpleUploadInfo {
    public long failedFileCount;
    public int firstLevelItemCount;
    public boolean isLocalCreate;
    public long timeRemain;
    public long totalFileCount;
    public long totalFileSize;
    public long uploadSpeed;
    public long uploadedFileCount;
    public long uploadedFileSize;
    public String fileSetId = "";
    public FileSetStatus fileSetStatus = FileSetStatus.values()[0];
    public AIClusteringStatus aiClusteringStatus = new AIClusteringStatus();
    public FileSetUploadStatus uploadStatus = FileSetUploadStatus.values()[0];
    public FileSetListType transferType = FileSetListType.values()[0];

    public AIClusteringStatus getAiClusteringStatus() {
        return this.aiClusteringStatus;
    }

    public long getFailedFileCount() {
        return this.failedFileCount;
    }

    public String getFileSetId() {
        return this.fileSetId;
    }

    public FileSetStatus getFileSetStatus() {
        return this.fileSetStatus;
    }

    public int getFirstLevelItemCount() {
        return this.firstLevelItemCount;
    }

    public boolean getIsLocalCreate() {
        return this.isLocalCreate;
    }

    public long getTimeRemain() {
        return this.timeRemain;
    }

    public long getTotalFileCount() {
        return this.totalFileCount;
    }

    public long getTotalFileSize() {
        return this.totalFileSize;
    }

    public FileSetListType getTransferType() {
        return this.transferType;
    }

    public long getUploadSpeed() {
        return this.uploadSpeed;
    }

    public FileSetUploadStatus getUploadStatus() {
        return this.uploadStatus;
    }

    public long getUploadedFileCount() {
        return this.uploadedFileCount;
    }

    public long getUploadedFileSize() {
        return this.uploadedFileSize;
    }
}
