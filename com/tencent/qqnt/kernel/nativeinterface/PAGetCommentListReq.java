package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class PAGetCommentListReq {
    public boolean canReadCache;
    public boolean enableCache;
    public int seq;
    public RequestTimelineInfo requestTimeLine = new RequestTimelineInfo();
    public StUser owner = new StUser();
    public String albumId = "";
    public String batchId = "";
    public String lloc = "";
    public String attachInfo = "";

    public String getAlbumId() {
        return this.albumId;
    }

    public String getAttachInfo() {
        return this.attachInfo;
    }

    public String getBatchId() {
        return this.batchId;
    }

    public boolean getCanReadCache() {
        return this.canReadCache;
    }

    public boolean getEnableCache() {
        return this.enableCache;
    }

    public String getLloc() {
        return this.lloc;
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
