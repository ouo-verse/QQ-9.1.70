package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProScheduleChannelInfo {
    public long channelId;
    public String channelName;
    public long guildId;
    public boolean hasJoin;
    public boolean isPrivate;
    public int type;

    public GProScheduleChannelInfo() {
        this.channelName = "";
    }

    public long getChannelId() {
        return this.channelId;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public boolean getHasJoin() {
        return this.hasJoin;
    }

    public boolean getIsPrivate() {
        return this.isPrivate;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "GProScheduleChannelInfo{channelId=" + this.channelId + ",type=" + this.type + ",guildId=" + this.guildId + ",channelName=" + this.channelName + ",isPrivate=" + this.isPrivate + ",hasJoin=" + this.hasJoin + ",}";
    }

    public GProScheduleChannelInfo(long j3, int i3, long j16, String str, boolean z16, boolean z17) {
        this.channelId = j3;
        this.type = i3;
        this.guildId = j16;
        this.channelName = str;
        this.isPrivate = z16;
        this.hasJoin = z17;
    }
}
