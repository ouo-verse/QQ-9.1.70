package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class PAGetPhotoListRsp {
    public int curIndex;
    public boolean hasMore;
    public boolean isFromCache;
    public int mediaNum;
    public int result;
    public int seq;
    public String errMs = "";
    public String traceId = "";
    public RequestTimelineInfo requestTimeLine = new RequestTimelineInfo();
    public AlbumInfo albumInfo = new AlbumInfo();
    public ArrayList<BatchInfo> batchList = new ArrayList<>();
    public ArrayList<StMedia> medias = new ArrayList<>();
    public String attachInfo = "";
    public StTimeLine timeLine = new StTimeLine();
    public MediaLbsAreaList mediaLbsAreaList = new MediaLbsAreaList();
    public ArrayList<Integer> opmask = new ArrayList<>();
    public PageEndMsg endMsg = new PageEndMsg();
    public RecommendMedia recommendMedia = new RecommendMedia();

    public AlbumInfo getAlbumInfo() {
        return this.albumInfo;
    }

    public String getAttachInfo() {
        return this.attachInfo;
    }

    public ArrayList<BatchInfo> getBatchList() {
        return this.batchList;
    }

    public int getCurIndex() {
        return this.curIndex;
    }

    public PageEndMsg getEndMsg() {
        return this.endMsg;
    }

    public String getErrMs() {
        return this.errMs;
    }

    public boolean getHasMore() {
        return this.hasMore;
    }

    public boolean getIsFromCache() {
        return this.isFromCache;
    }

    public MediaLbsAreaList getMediaLbsAreaList() {
        return this.mediaLbsAreaList;
    }

    public int getMediaNum() {
        return this.mediaNum;
    }

    public ArrayList<StMedia> getMedias() {
        return this.medias;
    }

    public ArrayList<Integer> getOpmask() {
        return this.opmask;
    }

    public RecommendMedia getRecommendMedia() {
        return this.recommendMedia;
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

    public StTimeLine getTimeLine() {
        return this.timeLine;
    }

    public String getTraceId() {
        return this.traceId;
    }
}
