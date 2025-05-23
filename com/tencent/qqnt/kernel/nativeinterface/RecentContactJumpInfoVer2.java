package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class RecentContactJumpInfoVer2 {
    public int chatType;
    public String guildId;
    public boolean insertWhenNotExist;
    public int jumpType;
    public String peerUid;

    public RecentContactJumpInfoVer2() {
        this.peerUid = "";
        this.guildId = "";
    }

    public int getChatType() {
        return this.chatType;
    }

    public String getGuildId() {
        return this.guildId;
    }

    public boolean getInsertWhenNotExist() {
        return this.insertWhenNotExist;
    }

    public int getJumpType() {
        return this.jumpType;
    }

    public String getPeerUid() {
        return this.peerUid;
    }

    public String toString() {
        return "RecentContactJumpInfoVer2{peerUid=" + this.peerUid + ",guildId=" + this.guildId + ",chatType=" + this.chatType + ",jumpType=" + this.jumpType + ",insertWhenNotExist=" + this.insertWhenNotExist + ",}";
    }

    public RecentContactJumpInfoVer2(String str, String str2, int i3, int i16, boolean z16) {
        this.peerUid = str;
        this.guildId = str2;
        this.chatType = i3;
        this.jumpType = i16;
        this.insertWhenNotExist = z16;
    }
}
