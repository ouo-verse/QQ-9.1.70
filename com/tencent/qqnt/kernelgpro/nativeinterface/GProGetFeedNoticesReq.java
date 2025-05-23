package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGetFeedNoticesReq {
    public String attachInfo = "";
    public long channelID;
    public long guildID;
    public int pageNum;
    public int reqScene;
    public int serviceType;

    public String getAttachInfo() {
        return this.attachInfo;
    }

    public long getChannelID() {
        return this.channelID;
    }

    public long getGuildID() {
        return this.guildID;
    }

    public int getPageNum() {
        return this.pageNum;
    }

    public int getReqScene() {
        return this.reqScene;
    }

    public int getServiceType() {
        return this.serviceType;
    }

    public String toString() {
        return "GProGetFeedNoticesReq{pageNum=" + this.pageNum + ",attachInfo=" + this.attachInfo + ",guildID=" + this.guildID + ",channelID=" + this.channelID + ",serviceType=" + this.serviceType + ",reqScene=" + this.reqScene + ",}";
    }
}
