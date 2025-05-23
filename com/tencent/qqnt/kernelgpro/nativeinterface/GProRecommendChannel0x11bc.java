package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProRecommendChannel0x11bc implements Serializable {
    public GProChannelPresence channelPresence;
    public GProEssenceChannel essenceInfo;
    public int recommendType;
    long serialVersionUID;

    public GProRecommendChannel0x11bc() {
        this.serialVersionUID = 1L;
        this.essenceInfo = new GProEssenceChannel();
        this.channelPresence = new GProChannelPresence();
    }

    public GProChannelPresence getChannelPresence() {
        return this.channelPresence;
    }

    public GProEssenceChannel getEssenceInfo() {
        return this.essenceInfo;
    }

    public int getRecommendType() {
        return this.recommendType;
    }

    public String toString() {
        return "GProRecommendChannel0x11bc{essenceInfo=" + this.essenceInfo + ",channelPresence=" + this.channelPresence + ",recommendType=" + this.recommendType + ",}";
    }

    public GProRecommendChannel0x11bc(GProEssenceChannel gProEssenceChannel, GProChannelPresence gProChannelPresence, int i3) {
        this.serialVersionUID = 1L;
        this.essenceInfo = new GProEssenceChannel();
        new GProChannelPresence();
        this.essenceInfo = gProEssenceChannel;
        this.channelPresence = gProChannelPresence;
        this.recommendType = i3;
    }
}
