package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class PhotoDetailInfo {
    public long creationTime;
    public long modificationTime;
    public long totalBytes;
    public String photoId = "";
    public String fileName = "";
    public WiFiPhotoFileType fileType = WiFiPhotoFileType.values()[0];

    public long getCreationTime() {
        return this.creationTime;
    }

    public String getFileName() {
        return this.fileName;
    }

    public WiFiPhotoFileType getFileType() {
        return this.fileType;
    }

    public long getModificationTime() {
        return this.modificationTime;
    }

    public String getPhotoId() {
        return this.photoId;
    }

    public long getTotalBytes() {
        return this.totalBytes;
    }
}
