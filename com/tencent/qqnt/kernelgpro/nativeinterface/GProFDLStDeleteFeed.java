package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProFDLStDeleteFeed {
    public GProFDLStChannelInfo channelInfo;
    public long createTime;
    public String feedId;
    public GProFDLStPoster poster;

    public GProFDLStDeleteFeed() {
        this.feedId = "";
        this.poster = new GProFDLStPoster();
        this.channelInfo = new GProFDLStChannelInfo();
    }

    public GProFDLStChannelInfo getChannelInfo() {
        return this.channelInfo;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public String getFeedId() {
        return this.feedId;
    }

    public GProFDLStPoster getPoster() {
        return this.poster;
    }

    public String toString() {
        return "GProFDLStDeleteFeed{feedId=" + this.feedId + ",poster=" + this.poster + ",createTime=" + this.createTime + ",channelInfo=" + this.channelInfo + ",}";
    }

    public GProFDLStDeleteFeed(String str, GProFDLStPoster gProFDLStPoster, long j3, GProFDLStChannelInfo gProFDLStChannelInfo) {
        this.feedId = "";
        this.poster = new GProFDLStPoster();
        new GProFDLStChannelInfo();
        this.feedId = str;
        this.poster = gProFDLStPoster;
        this.createTime = j3;
        this.channelInfo = gProFDLStChannelInfo;
    }
}
