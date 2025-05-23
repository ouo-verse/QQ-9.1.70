package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProDigestData {
    public int businessType;
    public long channelId;
    public long guildId;
    public long latestTimeStampMs;
    public long readTimeStampMs;
    public long unreadNum;
    public byte[] msgDigest = new byte[0];
    public String highLight = "";
    public String locationId = "";

    public int getBusinessType() {
        return this.businessType;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getHighLight() {
        return this.highLight;
    }

    public long getLatestTimeStampMs() {
        return this.latestTimeStampMs;
    }

    public String getLocationId() {
        return this.locationId;
    }

    public byte[] getMsgDigest() {
        return this.msgDigest;
    }

    public long getReadTimeStampMs() {
        return this.readTimeStampMs;
    }

    public long getUnreadNum() {
        return this.unreadNum;
    }

    public String toString() {
        return "GProDigestData{businessType=" + this.businessType + ",guildId=" + this.guildId + ",channelId=" + this.channelId + ",msgDigest=" + this.msgDigest + ",highLight=" + this.highLight + ",unreadNum=" + this.unreadNum + ",latestTimeStampMs=" + this.latestTimeStampMs + ",readTimeStampMs=" + this.readTimeStampMs + ",locationId=" + this.locationId + ",}";
    }
}
