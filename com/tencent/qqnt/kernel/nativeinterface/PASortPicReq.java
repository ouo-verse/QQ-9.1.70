package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class PASortPicReq {
    public int seq;
    public int sortType;
    public RequestTimelineInfo requestTimeLine = new RequestTimelineInfo();
    public String albumId = "";

    public String getAlbumId() {
        return this.albumId;
    }

    public RequestTimelineInfo getRequestTimeLine() {
        return this.requestTimeLine;
    }

    public int getSeq() {
        return this.seq;
    }

    public int getSortType() {
        return this.sortType;
    }
}
