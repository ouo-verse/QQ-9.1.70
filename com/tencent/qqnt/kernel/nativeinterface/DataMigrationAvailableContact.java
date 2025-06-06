package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class DataMigrationAvailableContact {
    public String avatarPath;
    public int chatType;
    public String peerName;
    public String peerUid;
    public String remark;

    public DataMigrationAvailableContact() {
        this.peerUid = "";
        this.peerName = "";
        this.remark = "";
        this.avatarPath = "";
    }

    public String getAvatarPath() {
        return this.avatarPath;
    }

    public int getChatType() {
        return this.chatType;
    }

    public String getPeerName() {
        return this.peerName;
    }

    public String getPeerUid() {
        return this.peerUid;
    }

    public String getRemark() {
        return this.remark;
    }

    public String toString() {
        return "DataMigrationAvailableContact{peerUid=" + this.peerUid + ",chatType=" + this.chatType + ",peerName=" + this.peerName + ",remark=" + this.remark + ",avatarPath=" + this.avatarPath + ",}";
    }

    public DataMigrationAvailableContact(String str, int i3, String str2, String str3, String str4) {
        this.peerUid = str;
        this.chatType = i3;
        this.peerName = str2;
        this.remark = str3;
        this.avatarPath = str4;
    }
}
