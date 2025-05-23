package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProContact {
    public int chatType;
    public String guildId;
    public String peerUid;

    public GProContact() {
        this.peerUid = "";
        this.guildId = "";
    }

    public int getChatType() {
        return this.chatType;
    }

    public String getGuildId() {
        return this.guildId;
    }

    public String getPeerUid() {
        return this.peerUid;
    }

    public String toString() {
        return "GProContact{chatType=" + this.chatType + ",peerUid=" + this.peerUid + ",guildId=" + this.guildId + ",}";
    }

    public GProContact(int i3, String str, String str2) {
        this.chatType = i3;
        this.peerUid = str;
        this.guildId = str2;
    }
}
