package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProRecentVisitChannelInfo {
    public long channelId;
    public GProChannel channelInfo = new GProChannel();
    public long updateTime;

    public long getChannelId() {
        return this.channelId;
    }

    public GProChannel getChannelInfo() {
        return this.channelInfo;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public String toString() {
        return "GProRecentVisitChannelInfo{channelId=" + this.channelId + ",channelInfo=" + this.channelInfo + ",updateTime=" + this.updateTime + ",}";
    }
}
