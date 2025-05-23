package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class RecentContactUnreadInfo {
    public int chatType;
    public String peerUid;
    public String uin;
    public int unreadCnt;
    public int unreadFlag;

    public RecentContactUnreadInfo() {
        this.peerUid = "";
        this.uin = "";
    }

    public int getChatType() {
        return this.chatType;
    }

    public String getPeerUid() {
        return this.peerUid;
    }

    public String getUin() {
        return this.uin;
    }

    public int getUnreadCnt() {
        return this.unreadCnt;
    }

    public int getUnreadFlag() {
        return this.unreadFlag;
    }

    public String toString() {
        return "RecentContactUnreadInfo{peerUid=" + this.peerUid + ",uin=" + this.uin + ",chatType=" + this.chatType + ",unreadCnt=" + this.unreadCnt + ",unreadFlag=" + this.unreadFlag + ",}";
    }

    public RecentContactUnreadInfo(String str, String str2, int i3, int i16, int i17) {
        this.peerUid = str;
        this.uin = str2;
        this.chatType = i3;
        this.unreadCnt = i16;
        this.unreadFlag = i17;
    }
}
