package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class PAGetPhotoListByTimeLineRsp {
    public boolean isFromCache;
    public boolean nextHasMore;
    public boolean preHasMore;
    public int result;
    public int seq;
    public String errMs = "";
    public String traceId = "";
    public RequestTimelineInfo requestTimeLine = new RequestTimelineInfo();
    public AlbumInfo albumInfo = new AlbumInfo();
    public ArrayList<BatchInfo> batchList = new ArrayList<>();
    public ArrayList<StMedia> medias = new ArrayList<>();
    public String attachInfo = "";
    public PageEndMsg endMsg = new PageEndMsg();

    public AlbumInfo getAlbumInfo() {
        return this.albumInfo;
    }

    public String getAttachInfo() {
        return this.attachInfo;
    }

    public ArrayList<BatchInfo> getBatchList() {
        return this.batchList;
    }

    public PageEndMsg getEndMsg() {
        return this.endMsg;
    }

    public String getErrMs() {
        return this.errMs;
    }

    public boolean getIsFromCache() {
        return this.isFromCache;
    }

    public ArrayList<StMedia> getMedias() {
        return this.medias;
    }

    public boolean getNextHasMore() {
        return this.nextHasMore;
    }

    public boolean getPreHasMore() {
        return this.preHasMore;
    }

    public RequestTimelineInfo getRequestTimeLine() {
        return this.requestTimeLine;
    }

    public int getResult() {
        return this.result;
    }

    public int getSeq() {
        return this.seq;
    }

    public String getTraceId() {
        return this.traceId;
    }
}
