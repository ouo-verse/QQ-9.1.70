package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProSimpleChannelInfo {
    public long channelId;
    public int hiddenPostChannel;
    public String name = "";

    public long getChannelId() {
        return this.channelId;
    }

    public int getHiddenPostChannel() {
        return this.hiddenPostChannel;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return "GProSimpleChannelInfo{channelId=" + this.channelId + ",name=" + this.name + ",hiddenPostChannel=" + this.hiddenPostChannel + ",}";
    }
}
