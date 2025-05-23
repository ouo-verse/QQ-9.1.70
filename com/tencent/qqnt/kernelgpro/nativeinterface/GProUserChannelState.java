package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProUserChannelState {
    public long channelId;
    public long guildId;
    public int platform;
    public long tinyId;
    public int userState;
    public long userStateSeq;

    public GProUserChannelState() {
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public int getPlatform() {
        return this.platform;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public int getUserState() {
        return this.userState;
    }

    public long getUserStateSeq() {
        return this.userStateSeq;
    }

    public String toString() {
        return "GProUserChannelState{tinyId=" + this.tinyId + ",guildId=" + this.guildId + ",channelId=" + this.channelId + ",userStateSeq=" + this.userStateSeq + ",userState=" + this.userState + ",platform=" + this.platform + ",}";
    }

    public GProUserChannelState(long j3, long j16, long j17, long j18, int i3, int i16) {
        this.tinyId = j3;
        this.guildId = j16;
        this.channelId = j17;
        this.userStateSeq = j18;
        this.userState = i3;
        this.platform = i16;
    }
}
