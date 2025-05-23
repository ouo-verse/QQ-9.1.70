package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SearchGroupFile {
    public long groupId;
    public int isInGroup;

    /* renamed from: id, reason: collision with root package name */
    public String f359214id = "";
    public String fileName = "";
    public String iconUrl = "";
    public String fileSize = "";
    public String tag = "";
    public String groupName = "";
    public String fileLink = "";
    public String joinGroupAuth = "";

    public String getFileLink() {
        return this.fileLink;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getFileSize() {
        return this.fileSize;
    }

    public long getGroupId() {
        return this.groupId;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getId() {
        return this.f359214id;
    }

    public int getIsInGroup() {
        return this.isInGroup;
    }

    public String getJoinGroupAuth() {
        return this.joinGroupAuth;
    }

    public String getTag() {
        return this.tag;
    }

    public String toString() {
        return "SearchGroupFile{id=" + this.f359214id + ",fileName=" + this.fileName + ",iconUrl=" + this.iconUrl + ",fileSize=" + this.fileSize + ",tag=" + this.tag + ",groupId=" + this.groupId + ",groupName=" + this.groupName + ",isInGroup=" + this.isInGroup + ",fileLink=" + this.fileLink + ",joinGroupAuth=" + this.joinGroupAuth + ",}";
    }
}
