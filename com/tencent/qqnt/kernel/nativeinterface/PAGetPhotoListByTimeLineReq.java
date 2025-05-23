package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class PAGetPhotoListByTimeLineReq {
    public boolean canReadCache;
    public boolean enableCache;
    public int seq;
    public int sortType;
    public RequestTimelineInfo requestTimeLine = new RequestTimelineInfo();
    public StUser owner = new StUser();
    public String albumId = "";
    public String attachInfo = "";
    public TimeLineReqParam timeLineParam = new TimeLineReqParam();

    public String getAlbumId() {
        return this.albumId;
    }

    public String getAttachInfo() {
        return this.attachInfo;
    }

    public boolean getCanReadCache() {
        return this.canReadCache;
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

    public int getSortType() {
        return this.sortType;
    }

    public TimeLineReqParam getTimeLineParam() {
        return this.timeLineParam;
    }
}
