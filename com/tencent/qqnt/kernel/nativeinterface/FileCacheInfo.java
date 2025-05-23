package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class FileCacheInfo {
    public long elementId;
    public String elementIdStr;
    public long fileKey;
    public String fileName;
    public long fileSize;
    public long fileTime;
    public CacheFileType fileType;
    public String path;
    public String previewPath;
    public String senderId;
    public String senderName;

    public FileCacheInfo() {
        this.elementIdStr = "";
        this.fileType = CacheFileType.values()[0];
        this.path = "";
        this.fileName = "";
        this.senderId = "";
        this.previewPath = "";
        this.senderName = "";
    }

    public long getElementId() {
        return this.elementId;
    }

    public String getElementIdStr() {
        return this.elementIdStr;
    }

    public long getFileKey() {
        return this.fileKey;
    }

    public String getFileName() {
        return this.fileName;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public long getFileTime() {
        return this.fileTime;
    }

    public CacheFileType getFileType() {
        return this.fileType;
    }

    public String getPath() {
        return this.path;
    }

    public String getPreviewPath() {
        return this.previewPath;
    }

    public String getSenderId() {
        return this.senderId;
    }

    public String getSenderName() {
        return this.senderName;
    }

    public FileCacheInfo(long j3, long j16, long j17, long j18, String str, CacheFileType cacheFileType, String str2, String str3, String str4, String str5, String str6) {
        this.elementIdStr = "";
        CacheFileType cacheFileType2 = CacheFileType.values()[0];
        this.fileSize = j3;
        this.fileTime = j16;
        this.fileKey = j17;
        this.elementId = j18;
        this.elementIdStr = str;
        this.fileType = cacheFileType;
        this.path = str2;
        this.fileName = str3;
        this.senderId = str4;
        this.previewPath = str5;
        this.senderName = str6;
    }
}
