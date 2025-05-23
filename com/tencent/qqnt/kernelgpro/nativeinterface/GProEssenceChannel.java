package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProEssenceChannel implements Serializable {
    public long channelId;
    public int channelType;
    public String recommend;
    long serialVersionUID;

    public GProEssenceChannel() {
        this.serialVersionUID = 1L;
        this.recommend = "";
    }

    public long getChannelId() {
        return this.channelId;
    }

    public int getChannelType() {
        return this.channelType;
    }

    public String getRecommend() {
        return this.recommend;
    }

    public void setChannelId(long j3) {
        this.channelId = j3;
    }

    public void setChannelType(int i3) {
        this.channelType = i3;
    }

    public void setRecommend(String str) {
        this.recommend = str;
    }

    public String toString() {
        return "GProEssenceChannel{channelId=" + this.channelId + ",channelType=" + this.channelType + ",recommend=" + this.recommend + ",}";
    }

    public GProEssenceChannel(long j3, int i3, String str) {
        this.serialVersionUID = 1L;
        this.channelId = j3;
        this.channelType = i3;
        this.recommend = str;
    }
}
