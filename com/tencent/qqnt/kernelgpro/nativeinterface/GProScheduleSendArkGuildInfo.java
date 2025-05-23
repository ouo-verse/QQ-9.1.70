package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProScheduleSendArkGuildInfo {
    public long channelId;
    public long guildId;

    public GProScheduleSendArkGuildInfo() {
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String toString() {
        return "GProScheduleSendArkGuildInfo{guildId=" + this.guildId + ",channelId=" + this.channelId + ",}";
    }

    public GProScheduleSendArkGuildInfo(long j3, long j16) {
        this.guildId = j3;
        this.channelId = j16;
    }
}
