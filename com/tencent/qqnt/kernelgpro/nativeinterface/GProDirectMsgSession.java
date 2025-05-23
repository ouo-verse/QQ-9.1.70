package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProDirectMsgSession {
    public long channelId;
    public int channelType;
    public long guildId;
    public int msgNotifyType;
    public long msgTime;
    public int peerMemberType;
    public long srcGuildId;
    public String srcGuildName;
    public String srcMemberName;
    public String srcNickName;
    public long srcTinyId;

    public GProDirectMsgSession() {
        this.srcGuildName = "";
        this.srcMemberName = "";
        this.srcNickName = "";
    }

    public long getChannelId() {
        return this.channelId;
    }

    public int getChannelType() {
        return this.channelType;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public int getMsgNotifyType() {
        return this.msgNotifyType;
    }

    public long getMsgTime() {
        return this.msgTime;
    }

    public int getPeerMemberType() {
        return this.peerMemberType;
    }

    public long getSrcGuildId() {
        return this.srcGuildId;
    }

    public String getSrcGuildName() {
        return this.srcGuildName;
    }

    public String getSrcMemberName() {
        return this.srcMemberName;
    }

    public String getSrcNickName() {
        return this.srcNickName;
    }

    public long getSrcTinyId() {
        return this.srcTinyId;
    }

    public String toString() {
        return "GProDirectMsgSession{guildId=" + this.guildId + ",channelId=" + this.channelId + ",msgTime=" + this.msgTime + ",msgNotifyType=" + this.msgNotifyType + ",peerMemberType=" + this.peerMemberType + ",channelType=" + this.channelType + ",srcTinyId=" + this.srcTinyId + ",srcGuildId=" + this.srcGuildId + ",srcGuildName=" + this.srcGuildName + ",srcMemberName=" + this.srcMemberName + ",srcNickName=" + this.srcNickName + ",}";
    }

    public GProDirectMsgSession(long j3, long j16, long j17, int i3, int i16, int i17, long j18, long j19, String str, String str2, String str3) {
        this.guildId = j3;
        this.channelId = j16;
        this.msgTime = j17;
        this.msgNotifyType = i3;
        this.peerMemberType = i16;
        this.channelType = i17;
        this.srcTinyId = j18;
        this.srcGuildId = j19;
        this.srcGuildName = str;
        this.srcMemberName = str2;
        this.srcNickName = str3;
    }
}
