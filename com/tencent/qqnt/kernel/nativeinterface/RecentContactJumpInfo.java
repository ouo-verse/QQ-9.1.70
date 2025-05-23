package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class RecentContactJumpInfo {
    public int chatType;
    public String guildId;
    public int jumpType;
    public String peerUid;

    public RecentContactJumpInfo() {
        this.peerUid = "";
        this.guildId = "";
    }

    public int getChatType() {
        return this.chatType;
    }

    public String getGuildId() {
        return this.guildId;
    }

    public int getJumpType() {
        return this.jumpType;
    }

    public String getPeerUid() {
        return this.peerUid;
    }

    public String toString() {
        return "RecentContactJumpInfo{peerUid=" + this.peerUid + ",guildId=" + this.guildId + ",chatType=" + this.chatType + ",jumpType=" + this.jumpType + ",}";
    }

    public RecentContactJumpInfo(String str, String str2, int i3, int i16) {
        this.peerUid = str;
        this.guildId = str2;
        this.chatType = i3;
        this.jumpType = i16;
    }
}
