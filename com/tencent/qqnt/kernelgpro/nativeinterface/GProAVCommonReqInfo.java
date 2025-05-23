package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProAVCommonReqInfo {
    public long appId;
    public long channelId;
    public long guildId;

    public GProAVCommonReqInfo() {
    }

    public long getAppId() {
        return this.appId;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public void setAppId(long j3) {
        this.appId = j3;
    }

    public void setChannelId(long j3) {
        this.channelId = j3;
    }

    public void setGuildId(long j3) {
        this.guildId = j3;
    }

    public String toString() {
        return "GProAVCommonReqInfo{guildId=" + this.guildId + ",channelId=" + this.channelId + ",appId=" + this.appId + ",}";
    }

    public GProAVCommonReqInfo(long j3, long j16, long j17) {
        this.guildId = j3;
        this.channelId = j16;
        this.appId = j17;
    }
}
