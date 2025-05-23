package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProDeleteInteractReq {
    public long channelId;
    public long guildId;
    public String psvFeedId = "";

    public long getChannelId() {
        return this.channelId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getPsvFeedId() {
        return this.psvFeedId;
    }

    public String toString() {
        return "GProDeleteInteractReq{psvFeedId=" + this.psvFeedId + ",guildId=" + this.guildId + ",channelId=" + this.channelId + ",}";
    }
}
