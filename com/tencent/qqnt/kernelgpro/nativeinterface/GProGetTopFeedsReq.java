package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGetTopFeedsReq {
    public long channelId;
    public long guildId;
    public int serviceType;

    public long getChannelId() {
        return this.channelId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public int getServiceType() {
        return this.serviceType;
    }

    public String toString() {
        return "GProGetTopFeedsReq{guildId=" + this.guildId + ",channelId=" + this.channelId + ",serviceType=" + this.serviceType + ",}";
    }
}
