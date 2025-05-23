package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class NTDeleteQunFeedReq {
    public StCommonExt extInfo;
    public StFeed feed;
    public boolean isDeletePhoto;
    public RequestTimelineInfo requestTimeLine;
    public int seq;

    public NTDeleteQunFeedReq() {
        this.requestTimeLine = new RequestTimelineInfo();
        this.extInfo = new StCommonExt();
        this.feed = new StFeed();
    }

    public StCommonExt getExtInfo() {
        return this.extInfo;
    }

    public StFeed getFeed() {
        return this.feed;
    }

    public boolean getIsDeletePhoto() {
        return this.isDeletePhoto;
    }

    public RequestTimelineInfo getRequestTimeLine() {
        return this.requestTimeLine;
    }

    public int getSeq() {
        return this.seq;
    }

    public void setExtInfo(StCommonExt stCommonExt) {
        this.extInfo = stCommonExt;
    }

    public void setFeed(StFeed stFeed) {
        this.feed = stFeed;
    }

    public void setIsDeletePhoto(boolean z16) {
        this.isDeletePhoto = z16;
    }

    public void setRequestTimeLine(RequestTimelineInfo requestTimelineInfo) {
        this.requestTimeLine = requestTimelineInfo;
    }

    public void setSeq(int i3) {
        this.seq = i3;
    }

    public NTDeleteQunFeedReq(int i3, RequestTimelineInfo requestTimelineInfo, StCommonExt stCommonExt, StFeed stFeed, boolean z16) {
        this.requestTimeLine = new RequestTimelineInfo();
        this.extInfo = new StCommonExt();
        new StFeed();
        this.seq = i3;
        this.requestTimeLine = requestTimelineInfo;
        this.extInfo = stCommonExt;
        this.feed = stFeed;
        this.isDeletePhoto = z16;
    }
}
