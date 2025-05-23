package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class FlashTransferTaskStatusInfo {
    public long completedFileCount;
    public long completedFileSize;
    public long failedFileCount;
    public boolean isLocalCreate;
    public long speed;
    public long timeRemain;
    public long totalFileCount;
    public long totalFileSize;
    public String fileSetId = "";
    public String name = "";
    public FileSetSimpleStatus status = FileSetSimpleStatus.values()[0];
    public FileSetStatus fileSetStatus = FileSetStatus.values()[0];
    public FileSetUploadStatus uploadStatus = FileSetUploadStatus.values()[0];
    public FileSetDownloadStatus downloadStatus = FileSetDownloadStatus.values()[0];
    public ArrayList<Uploader> uploaders = new ArrayList<>();
    public FileSetListType transferType = FileSetListType.values()[0];

    public long getCompletedFileCount() {
        return this.completedFileCount;
    }

    public long getCompletedFileSize() {
        return this.completedFileSize;
    }

    public FileSetDownloadStatus getDownloadStatus() {
        return this.downloadStatus;
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

    public boolean getIsLocalCreate() {
        return this.isLocalCreate;
    }

    public String getName() {
        return this.name;
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

    public long getTotalFileCount() {
        return this.totalFileCount;
    }

    public long getTotalFileSize() {
        return this.totalFileSize;
    }

    public FileSetListType getTransferType() {
        return this.transferType;
    }

    public FileSetUploadStatus getUploadStatus() {
        return this.uploadStatus;
    }

    public ArrayList<Uploader> getUploaders() {
        return this.uploaders;
    }
}
