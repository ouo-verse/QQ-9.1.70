package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProFeedInfo {
    public long lastModifiedTime;
    public String feedId = "";
    public byte[] feed = new byte[0];

    public byte[] getFeed() {
        return this.feed;
    }

    public String getFeedId() {
        return this.feedId;
    }

    public long getLastModifiedTime() {
        return this.lastModifiedTime;
    }

    public String toString() {
        return "GProFeedInfo{feedId=" + this.feedId + ",feed=" + this.feed + ",lastModifiedTime=" + this.lastModifiedTime + ",}";
    }
}
