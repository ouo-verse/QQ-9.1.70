package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class MatchKey {
    public int chatType;
    public String guildId;
    public long msgSeq;
    public String peerUid;

    public MatchKey() {
        this.peerUid = "";
        this.guildId = "";
    }

    public int getChatType() {
        return this.chatType;
    }

    public String getGuildId() {
        return this.guildId;
    }

    public long getMsgSeq() {
        return this.msgSeq;
    }

    public String getPeerUid() {
        return this.peerUid;
    }

    public String toString() {
        return "MatchKey{peerUid=" + this.peerUid + ",chatType=" + this.chatType + ",msgSeq=" + this.msgSeq + ",guildId=" + this.guildId + ",}";
    }

    public MatchKey(String str, int i3, long j3, String str2) {
        this.peerUid = str;
        this.chatType = i3;
        this.msgSeq = j3;
        this.guildId = str2;
    }
}
