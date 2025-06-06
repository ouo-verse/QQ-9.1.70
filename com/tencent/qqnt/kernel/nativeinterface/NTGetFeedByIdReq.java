package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class NTGetFeedByIdReq {
    public int seq;
    public RequestTimelineInfo requestTimeLine = new RequestTimelineInfo();
    public StCommonExt ext = new StCommonExt();
    public String qunId = "";
    public String feedId = "";
    public String albumId = "";
    public String batchId = "";

    public String getAlbumId() {
        return this.albumId;
    }

    public String getBatchId() {
        return this.batchId;
    }

    public StCommonExt getExt() {
        return this.ext;
    }

    public String getFeedId() {
        return this.feedId;
    }

    public String getQunId() {
        return this.qunId;
    }

    public RequestTimelineInfo getRequestTimeLine() {
        return this.requestTimeLine;
    }

    public int getSeq() {
        return this.seq;
    }

    public String toString() {
        return "NTGetFeedByIdReq{seq=" + this.seq + ",requestTimeLine=" + this.requestTimeLine + ",ext=" + this.ext + ",qunId=" + this.qunId + ",feedId=" + this.feedId + ",albumId=" + this.albumId + ",batchId=" + this.batchId + ",}";
    }
}
