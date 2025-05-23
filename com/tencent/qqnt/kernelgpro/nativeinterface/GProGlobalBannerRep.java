package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGlobalBannerRep {
    public String bannerId;
    public int bannerType;
    public long channelId;
    public long guildId;
    public long msgSeq;

    public GProGlobalBannerRep() {
        this.bannerId = "";
    }

    public String getBannerId() {
        return this.bannerId;
    }

    public int getBannerType() {
        return this.bannerType;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public long getMsgSeq() {
        return this.msgSeq;
    }

    public void setBannerId(String str) {
        this.bannerId = str;
    }

    public void setBannerType(int i3) {
        this.bannerType = i3;
    }

    public void setChannelId(long j3) {
        this.channelId = j3;
    }

    public void setGuildId(long j3) {
        this.guildId = j3;
    }

    public void setMsgSeq(long j3) {
        this.msgSeq = j3;
    }

    public String toString() {
        return "GProGlobalBannerRep{guildId=" + this.guildId + ",channelId=" + this.channelId + ",bannerType=" + this.bannerType + ",msgSeq=" + this.msgSeq + ",bannerId=" + this.bannerId + ",}";
    }

    public GProGlobalBannerRep(long j3, long j16, int i3, long j17, String str) {
        this.guildId = j3;
        this.channelId = j16;
        this.bannerType = i3;
        this.msgSeq = j17;
        this.bannerId = str;
    }
}
