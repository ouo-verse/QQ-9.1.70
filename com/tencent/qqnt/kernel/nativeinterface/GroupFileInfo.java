package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupFileInfo {
    public int busId;
    public int deadTime;
    public int downloadTimes;
    public long elementId;
    public String fileId;
    public long fileModelId;
    public String fileName;
    public long fileSize;
    public boolean isFolder;
    public String localPath;
    public String md5;
    public int modifyTime;
    public String parentFolderId;
    public String sha;
    public String sha3;
    public int transStatus;
    public int transType;
    public int uploadTime;
    public long uploadedSize;
    public String uploaderLocalPath;
    public String uploaderName;
    public long uploaderUin;

    public GroupFileInfo() {
        this.fileId = "";
        this.fileName = "";
        this.sha = "";
        this.sha3 = "";
        this.md5 = "";
        this.uploaderName = "";
        this.localPath = "";
    }

    public int getBusId() {
        return this.busId;
    }

    public int getDeadTime() {
        return this.deadTime;
    }

    public int getDownloadTimes() {
        return this.downloadTimes;
    }

    public long getElementId() {
        return this.elementId;
    }

    public String getFileId() {
        return this.fileId;
    }

    public long getFileModelId() {
        return this.fileModelId;
    }

    public String getFileName() {
        return this.fileName;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public boolean getIsFolder() {
        return this.isFolder;
    }

    public String getLocalPath() {
        return this.localPath;
    }

    public String getMd5() {
        return this.md5;
    }

    public int getModifyTime() {
        return this.modifyTime;
    }

    public String getParentFolderId() {
        return this.parentFolderId;
    }

    public String getSha() {
        return this.sha;
    }

    public String getSha3() {
        return this.sha3;
    }

    public int getTransStatus() {
        return this.transStatus;
    }

    public int getTransType() {
        return this.transType;
    }

    public int getUploadTime() {
        return this.uploadTime;
    }

    public long getUploadedSize() {
        return this.uploadedSize;
    }

    public String getUploaderLocalPath() {
        return this.uploaderLocalPath;
    }

    public String getUploaderName() {
        return this.uploaderName;
    }

    public long getUploaderUin() {
        return this.uploaderUin;
    }

    public GroupFileInfo(long j3, String str, String str2, long j16, int i3, long j17, int i16, int i17, int i18, int i19, String str3, String str4, String str5, String str6, String str7, long j18, String str8, String str9, int i26, int i27, long j19, boolean z16) {
        this.fileModelId = j3;
        this.fileId = str;
        this.fileName = str2;
        this.fileSize = j16;
        this.busId = i3;
        this.uploadedSize = j17;
        this.uploadTime = i16;
        this.deadTime = i17;
        this.modifyTime = i18;
        this.downloadTimes = i19;
        this.sha = str3;
        this.sha3 = str4;
        this.md5 = str5;
        this.uploaderLocalPath = str6;
        this.uploaderName = str7;
        this.uploaderUin = j18;
        this.parentFolderId = str8;
        this.localPath = str9;
        this.transStatus = i26;
        this.transType = i27;
        this.elementId = j19;
        this.isFolder = z16;
    }
}
