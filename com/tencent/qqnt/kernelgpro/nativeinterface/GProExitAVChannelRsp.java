package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProExitAVChannelRsp {
    public long channelId;
    public long guildId;

    public GProExitAVChannelRsp() {
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String toString() {
        return "GProExitAVChannelRsp{guildId=" + this.guildId + ",channelId=" + this.channelId + ",}";
    }

    public GProExitAVChannelRsp(long j3, long j16) {
        this.guildId = j3;
        this.channelId = j16;
    }
}
