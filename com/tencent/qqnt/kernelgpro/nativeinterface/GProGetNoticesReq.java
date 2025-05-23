package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGetNoticesReq {
    public long channelID;
    public long guildID;
    public int pageNum;
    public int serviceType;
    public GProStCommonExt extInfo = new GProStCommonExt();
    public String attachInfo = "";

    public String getAttachInfo() {
        return this.attachInfo;
    }

    public long getChannelID() {
        return this.channelID;
    }

    public GProStCommonExt getExtInfo() {
        return this.extInfo;
    }

    public long getGuildID() {
        return this.guildID;
    }

    public int getPageNum() {
        return this.pageNum;
    }

    public int getServiceType() {
        return this.serviceType;
    }

    public String toString() {
        return "GProGetNoticesReq{extInfo=" + this.extInfo + ",pageNum=" + this.pageNum + ",attachInfo=" + this.attachInfo + ",guildID=" + this.guildID + ",channelID=" + this.channelID + ",serviceType=" + this.serviceType + ",}";
    }
}
