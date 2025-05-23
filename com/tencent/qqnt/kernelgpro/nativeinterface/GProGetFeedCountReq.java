package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGetFeedCountReq {
    public long channelId;
    public long guildId;

    public long getChannelId() {
        return this.channelId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String toString() {
        return "GProGetFeedCountReq{guildId=" + this.guildId + ",channelId=" + this.channelId + ",}";
    }
}
