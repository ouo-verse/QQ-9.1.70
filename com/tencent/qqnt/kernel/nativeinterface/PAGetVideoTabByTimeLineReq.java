package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class PAGetVideoTabByTimeLineReq {
    public boolean canReadCache;
    public boolean enableCache;
    public int seq;
    public RequestTimelineInfo requestTimeLine = new RequestTimelineInfo();
    public StUser owner = new StUser();
    public String attachInfo = "";
    public TimeLineReqParam timeLineParam = new TimeLineReqParam();

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

    public TimeLineReqParam getTimeLineParam() {
        return this.timeLineParam;
    }
}
