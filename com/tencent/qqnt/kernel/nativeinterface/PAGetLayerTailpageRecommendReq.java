package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class PAGetLayerTailpageRecommendReq {
    public boolean canReadCache;
    public boolean enableCache;
    public int seq;
    public RequestTimelineInfo requestTimeLine = new RequestTimelineInfo();
    public String currentAlbumId = "";
    public StUser owner = new StUser();

    public boolean getCanReadCache() {
        return this.canReadCache;
    }

    public String getCurrentAlbumId() {
        return this.currentAlbumId;
    }

    public boolean getEnableCache() {
        return this.enableCache;
    }

    public StUser getOwner() {
        return this.owner;
    }

    public RequestTimelineInfo getRequestTimeLine() {
        return this.requestTimeLine;
    }

    public int getSeq() {
        return this.seq;
    }
}
