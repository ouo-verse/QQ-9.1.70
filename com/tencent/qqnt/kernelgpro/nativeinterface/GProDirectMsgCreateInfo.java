package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProDirectMsgCreateInfo {
    public int channelType;
    public int msgNotifyType;
    public long msgTime;
    public long srcGuildId;
    public String srcGuildName;
    public String srcMemberName;
    public String srcNickName;
    public long srcTinyId;

    public GProDirectMsgCreateInfo() {
        this.srcGuildName = "";
        this.srcMemberName = "";
        this.srcNickName = "";
    }

    public int getChannelType() {
        return this.channelType;
    }

    public int getMsgNotifyType() {
        return this.msgNotifyType;
    }

    public long getMsgTime() {
        return this.msgTime;
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
        return "GProDirectMsgCreateInfo{srcTinyId=" + this.srcTinyId + ",srcGuildId=" + this.srcGuildId + ",srcGuildName=" + this.srcGuildName + ",srcMemberName=" + this.srcMemberName + ",srcNickName=" + this.srcNickName + ",msgTime=" + this.msgTime + ",msgNotifyType=" + this.msgNotifyType + ",channelType=" + this.channelType + ",}";
    }

    public GProDirectMsgCreateInfo(long j3, long j16, String str, String str2, String str3, long j17, int i3, int i16) {
        this.srcTinyId = j3;
        this.srcGuildId = j16;
        this.srcGuildName = str;
        this.srcMemberName = str2;
        this.srcNickName = str3;
        this.msgTime = j17;
        this.msgNotifyType = i3;
        this.channelType = i16;
    }
}
