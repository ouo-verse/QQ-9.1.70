package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProQQMsgListChannel {
    public long appid;
    public long avatarSeq;
    public long channelId;
    public String channelName;
    public int channelType;
    public long guildId;
    public String guildName;
    public long topTimestamp;

    public GProQQMsgListChannel() {
        this.guildName = "";
        this.channelName = "";
    }

    public long getAppid() {
        return this.appid;
    }

    public long getAvatarSeq() {
        return this.avatarSeq;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public int getChannelType() {
        return this.channelType;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getGuildName() {
        return this.guildName;
    }

    public long getTopTimestamp() {
        return this.topTimestamp;
    }

    public String toString() {
        return "GProQQMsgListChannel{guildId=" + this.guildId + ",channelId=" + this.channelId + ",topTimestamp=" + this.topTimestamp + ",guildName=" + this.guildName + ",channelName=" + this.channelName + ",avatarSeq=" + this.avatarSeq + ",channelType=" + this.channelType + ",appid=" + this.appid + ",}";
    }

    public GProQQMsgListChannel(long j3, long j16, long j17, String str, String str2, long j18, int i3, long j19) {
        this.guildId = j3;
        this.channelId = j16;
        this.topTimestamp = j17;
        this.guildName = str;
        this.channelName = str2;
        this.avatarSeq = j18;
        this.channelType = i3;
        this.appid = j19;
    }
}
