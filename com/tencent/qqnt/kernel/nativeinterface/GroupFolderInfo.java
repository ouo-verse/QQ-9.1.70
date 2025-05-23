package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupFolderInfo {
    public int createTime;
    public long createUin;
    public String creatorName;
    public String folderId;
    public String folderName;
    public String modifyName;
    public int modifyTime;
    public long modifyUin;
    public String parentFolderId;
    public int totalFileCount;
    public long usedSpace;

    public GroupFolderInfo() {
        this.folderId = "";
        this.parentFolderId = "";
        this.folderName = "";
        this.creatorName = "";
        this.modifyName = "";
    }

    public int getCreateTime() {
        return this.createTime;
    }

    public long getCreateUin() {
        return this.createUin;
    }

    public String getCreatorName() {
        return this.creatorName;
    }

    public String getFolderId() {
        return this.folderId;
    }

    public String getFolderName() {
        return this.folderName;
    }

    public String getModifyName() {
        return this.modifyName;
    }

    public int getModifyTime() {
        return this.modifyTime;
    }

    public long getModifyUin() {
        return this.modifyUin;
    }

    public String getParentFolderId() {
        return this.parentFolderId;
    }

    public int getTotalFileCount() {
        return this.totalFileCount;
    }

    public long getUsedSpace() {
        return this.usedSpace;
    }

    public GroupFolderInfo(String str, String str2, String str3, int i3, int i16, long j3, String str4, int i17, long j16, String str5, long j17) {
        this.folderId = str;
        this.parentFolderId = str2;
        this.folderName = str3;
        this.createTime = i3;
        this.modifyTime = i16;
        this.createUin = j3;
        this.creatorName = str4;
        this.totalFileCount = i17;
        this.modifyUin = j16;
        this.modifyName = str5;
        this.usedSpace = j17;
    }
}
