package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class File implements IKernelModel, Serializable {
    public int archiveIndex;
    public int cliFileIndex;
    public int depth;
    public int fileCount;
    public long fileSize;
    public boolean isCover;
    public boolean isCoverOriginal;
    public boolean isDir;
    public long svrLastUpdateTimestamp;
    long serialVersionUID = 1;
    public String fileSetId = "";
    public String cliFileId = "";
    public String compressedFileFolderId = "";
    public String indexPath = "";
    public String parentId = "";
    public FlashTransferFileType fileType = FlashTransferFileType.values()[0];
    public String name = "";
    public String namePinyin = "";
    public Picture thumbnail = new Picture();
    public PhysicalInfo physical = new PhysicalInfo();
    public String srvFileId = "";
    public String srvParentFileId = "";
    public FileDownLoadInfo downloadInfo = new FileDownLoadInfo();
    public String saveFilePath = "";
    public String searchRelativePath = "";
    public String diskRelativePath = "";
    public FileUploadInfo uploadInfo = new FileUploadInfo();
    public FileStatus status = FileStatus.values()[0];
    public FileUploadStatus uploadStatus = FileUploadStatus.values()[0];
    public FileDownloadStatus downloadStatus = FileDownloadStatus.values()[0];
    public FolderUploadInfo folderUploadInfo = new FolderUploadInfo();
    public FolderDownloadInfo folderDownloadInfo = new FolderDownloadInfo();
    public String sha1 = "";
    public String bookmark = "";
    public CompressFileFolderInfo compressFileFolderInfo = new CompressFileFolderInfo();
    public FlashTransferPauseReason uploadPauseReason = FlashTransferPauseReason.values()[0];
    public FlashTransferPauseReason downloadPauseReason = FlashTransferPauseReason.values()[0];

    public int getArchiveIndex() {
        return this.archiveIndex;
    }

    public String getBookmark() {
        return this.bookmark;
    }

    public String getCliFileId() {
        return this.cliFileId;
    }

    public int getCliFileIndex() {
        return this.cliFileIndex;
    }

    public CompressFileFolderInfo getCompressFileFolderInfo() {
        return this.compressFileFolderInfo;
    }

    public String getCompressedFileFolderId() {
        return this.compressedFileFolderId;
    }

    public int getDepth() {
        return this.depth;
    }

    public String getDiskRelativePath() {
        return this.diskRelativePath;
    }

    public FileDownLoadInfo getDownloadInfo() {
        return this.downloadInfo;
    }

    public FlashTransferPauseReason getDownloadPauseReason() {
        return this.downloadPauseReason;
    }

    public FileDownloadStatus getDownloadStatus() {
        return this.downloadStatus;
    }

    public int getFileCount() {
        return this.fileCount;
    }

    public String getFileSetId() {
        return this.fileSetId;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public FlashTransferFileType getFileType() {
        return this.fileType;
    }

    public FolderDownloadInfo getFolderDownloadInfo() {
        return this.folderDownloadInfo;
    }

    public FolderUploadInfo getFolderUploadInfo() {
        return this.folderUploadInfo;
    }

    public String getIndexPath() {
        return this.indexPath;
    }

    public boolean getIsCover() {
        return this.isCover;
    }

    public boolean getIsCoverOriginal() {
        return this.isCoverOriginal;
    }

    public boolean getIsDir() {
        return this.isDir;
    }

    public String getName() {
        return this.name;
    }

    public String getNamePinyin() {
        return this.namePinyin;
    }

    public String getParentId() {
        return this.parentId;
    }

    public PhysicalInfo getPhysical() {
        return this.physical;
    }

    public String getSaveFilePath() {
        return this.saveFilePath;
    }

    public String getSearchRelativePath() {
        return this.searchRelativePath;
    }

    public String getSha1() {
        return this.sha1;
    }

    public String getSrvFileId() {
        return this.srvFileId;
    }

    public String getSrvParentFileId() {
        return this.srvParentFileId;
    }

    public FileStatus getStatus() {
        return this.status;
    }

    public long getSvrLastUpdateTimestamp() {
        return this.svrLastUpdateTimestamp;
    }

    public Picture getThumbnail() {
        return this.thumbnail;
    }

    public FileUploadInfo getUploadInfo() {
        return this.uploadInfo;
    }

    public FlashTransferPauseReason getUploadPauseReason() {
        return this.uploadPauseReason;
    }

    public FileUploadStatus getUploadStatus() {
        return this.uploadStatus;
    }

    public void setArchiveIndex(int i3) {
        this.archiveIndex = i3;
    }

    public void setBookmark(String str) {
        this.bookmark = str;
    }

    public void setCliFileId(String str) {
        this.cliFileId = str;
    }

    public void setCliFileIndex(int i3) {
        this.cliFileIndex = i3;
    }

    public void setCompressFileFolderInfo(CompressFileFolderInfo compressFileFolderInfo) {
        this.compressFileFolderInfo = compressFileFolderInfo;
    }

    public void setCompressedFileFolderId(String str) {
        this.compressedFileFolderId = str;
    }

    public void setDepth(int i3) {
        this.depth = i3;
    }

    public void setDiskRelativePath(String str) {
        this.diskRelativePath = str;
    }

    public void setDownloadInfo(FileDownLoadInfo fileDownLoadInfo) {
        this.downloadInfo = fileDownLoadInfo;
    }

    public void setDownloadPauseReason(FlashTransferPauseReason flashTransferPauseReason) {
        this.downloadPauseReason = flashTransferPauseReason;
    }

    public void setDownloadStatus(FileDownloadStatus fileDownloadStatus) {
        this.downloadStatus = fileDownloadStatus;
    }

    public void setFileCount(int i3) {
        this.fileCount = i3;
    }

    public void setFileSetId(String str) {
        this.fileSetId = str;
    }

    public void setFileSize(long j3) {
        this.fileSize = j3;
    }

    public void setFileType(FlashTransferFileType flashTransferFileType) {
        this.fileType = flashTransferFileType;
    }

    public void setFolderDownloadInfo(FolderDownloadInfo folderDownloadInfo) {
        this.folderDownloadInfo = folderDownloadInfo;
    }

    public void setFolderUploadInfo(FolderUploadInfo folderUploadInfo) {
        this.folderUploadInfo = folderUploadInfo;
    }

    public void setIndexPath(String str) {
        this.indexPath = str;
    }

    public void setIsCover(boolean z16) {
        this.isCover = z16;
    }

    public void setIsCoverOriginal(boolean z16) {
        this.isCoverOriginal = z16;
    }

    public void setIsDir(boolean z16) {
        this.isDir = z16;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNamePinyin(String str) {
        this.namePinyin = str;
    }

    public void setParentId(String str) {
        this.parentId = str;
    }

    public void setPhysical(PhysicalInfo physicalInfo) {
        this.physical = physicalInfo;
    }

    public void setSaveFilePath(String str) {
        this.saveFilePath = str;
    }

    public void setSearchRelativePath(String str) {
        this.searchRelativePath = str;
    }

    public void setSha1(String str) {
        this.sha1 = str;
    }

    public void setSrvFileId(String str) {
        this.srvFileId = str;
    }

    public void setSrvParentFileId(String str) {
        this.srvParentFileId = str;
    }

    public void setStatus(FileStatus fileStatus) {
        this.status = fileStatus;
    }

    public void setSvrLastUpdateTimestamp(long j3) {
        this.svrLastUpdateTimestamp = j3;
    }

    public void setThumbnail(Picture picture) {
        this.thumbnail = picture;
    }

    public void setUploadInfo(FileUploadInfo fileUploadInfo) {
        this.uploadInfo = fileUploadInfo;
    }

    public void setUploadPauseReason(FlashTransferPauseReason flashTransferPauseReason) {
        this.uploadPauseReason = flashTransferPauseReason;
    }

    public void setUploadStatus(FileUploadStatus fileUploadStatus) {
        this.uploadStatus = fileUploadStatus;
    }
}
