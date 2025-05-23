package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class FileSet {
    public long createTime;
    public int expireLeftTime;
    public long expireTime;
    public int firstLevelItemCount;
    public boolean isLocalCreate;
    public long svrLastUpdateTimestamp;
    public long totalFileCount;
    public long totalFileSize;
    public String fileSetId = "";
    public String name = "";
    public String namePinyin = "";
    public Permission permission = new Permission();
    public ShareInfo shareInfo = new ShareInfo();
    public Picture cover = new Picture();
    public ArrayList<Uploader> uploaders = new ArrayList<>();
    public AIClusteringStatus aiClusteringStatus = new AIClusteringStatus();
    public String taskId = "";
    public UploadInfo uploadInfo = new UploadInfo();
    public DownloadInfo downloadInfo = new DownloadInfo();
    public FileSetListType transferType = FileSetListType.values()[0];
    public FileSetStatus status = FileSetStatus.values()[0];
    public FileSetUploadStatus uploadStatus = FileSetUploadStatus.values()[0];
    public FlashTransferPauseReason uploadPauseReason = FlashTransferPauseReason.values()[0];
    public FileSetDownloadStatus downloadStatus = FileSetDownloadStatus.values()[0];
    public FlashTransferPauseReason downloadPauseReason = FlashTransferPauseReason.values()[0];
    public String saveFileSetDir = "";
    public String localCoverPath = "";

    public AIClusteringStatus getAiClusteringStatus() {
        return this.aiClusteringStatus;
    }

    public Picture getCover() {
        return this.cover;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public DownloadInfo getDownloadInfo() {
        return this.downloadInfo;
    }

    public FlashTransferPauseReason getDownloadPauseReason() {
        return this.downloadPauseReason;
    }

    public FileSetDownloadStatus getDownloadStatus() {
        return this.downloadStatus;
    }

    public int getExpireLeftTime() {
        return this.expireLeftTime;
    }

    public long getExpireTime() {
        return this.expireTime;
    }

    public String getFileSetId() {
        return this.fileSetId;
    }

    public int getFirstLevelItemCount() {
        return this.firstLevelItemCount;
    }

    public boolean getIsLocalCreate() {
        return this.isLocalCreate;
    }

    public String getLocalCoverPath() {
        return this.localCoverPath;
    }

    public String getName() {
        return this.name;
    }

    public String getNamePinyin() {
        return this.namePinyin;
    }

    public Permission getPermission() {
        return this.permission;
    }

    public String getSaveFileSetDir() {
        return this.saveFileSetDir;
    }

    public ShareInfo getShareInfo() {
        return this.shareInfo;
    }

    public FileSetStatus getStatus() {
        return this.status;
    }

    public long getSvrLastUpdateTimestamp() {
        return this.svrLastUpdateTimestamp;
    }

    public String getTaskId() {
        return this.taskId;
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

    public UploadInfo getUploadInfo() {
        return this.uploadInfo;
    }

    public FlashTransferPauseReason getUploadPauseReason() {
        return this.uploadPauseReason;
    }

    public FileSetUploadStatus getUploadStatus() {
        return this.uploadStatus;
    }

    public ArrayList<Uploader> getUploaders() {
        return this.uploaders;
    }
}
