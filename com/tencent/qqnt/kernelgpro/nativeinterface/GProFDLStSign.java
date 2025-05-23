package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProFDLStSign {
    public long channelId;
    public long guildId;

    public GProFDLStSign() {
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String toString() {
        return "GProFDLStSign{guildId=" + this.guildId + ",channelId=" + this.channelId + ",}";
    }

    public GProFDLStSign(long j3, long j16) {
        this.guildId = j3;
        this.channelId = j16;
    }
}
