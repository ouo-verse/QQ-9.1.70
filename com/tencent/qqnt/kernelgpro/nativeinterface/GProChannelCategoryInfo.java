package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProChannelCategoryInfo implements Serializable {
    public long channelId;
    public int channelIndex;
    long serialVersionUID = 1;

    public long getChannelId() {
        return this.channelId;
    }

    public int getChannelIndex() {
        return this.channelIndex;
    }

    public String toString() {
        return "GProChannelCategoryInfo{channelId=" + this.channelId + ",channelIndex=" + this.channelIndex + ",}";
    }
}
