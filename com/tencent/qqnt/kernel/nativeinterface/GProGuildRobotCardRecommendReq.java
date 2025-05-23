package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGuildRobotCardRecommendReq {
    public long channelId;
    public long guildId;

    public GProGuildRobotCardRecommendReq() {
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String toString() {
        return "GProGuildRobotCardRecommendReq{guildId=" + this.guildId + ",channelId=" + this.channelId + ",}";
    }

    public GProGuildRobotCardRecommendReq(long j3, long j16) {
        this.guildId = j3;
        this.channelId = j16;
    }
}
