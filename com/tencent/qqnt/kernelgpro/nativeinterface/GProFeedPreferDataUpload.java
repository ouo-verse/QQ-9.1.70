package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProFeedPreferDataUpload {
    public GProDoFeedPreferReq preferReq = new GProDoFeedPreferReq();
    public GProStFeed feed = new GProStFeed();

    public GProStFeed getFeed() {
        return this.feed;
    }

    public GProDoFeedPreferReq getPreferReq() {
        return this.preferReq;
    }

    public String toString() {
        return "GProFeedPreferDataUpload{preferReq=" + this.preferReq + ",feed=" + this.feed + ",}";
    }
}
