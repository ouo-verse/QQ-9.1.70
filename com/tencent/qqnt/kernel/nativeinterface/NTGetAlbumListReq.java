package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class NTGetAlbumListReq {
    public boolean canReadCache;
    public boolean enableCache;
    public int seq;
    public RequestTimelineInfo requestTimeLine = new RequestTimelineInfo();
    public String qunId = "";
    public String attachInfo = "";

    public String getAttachInfo() {
        return this.attachInfo;
    }

    public boolean getCanReadCache() {
        return this.canReadCache;
    }

    public boolean getEnableCache() {
        return this.enableCache;
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

    public void setAttachInfo(String str) {
        this.attachInfo = str;
    }

    public void setCanReadCache(boolean z16) {
        this.canReadCache = z16;
    }

    public void setEnableCache(boolean z16) {
        this.enableCache = z16;
    }

    public void setQunId(String str) {
        this.qunId = str;
    }

    public void setRequestTimeLine(RequestTimelineInfo requestTimelineInfo) {
        this.requestTimeLine = requestTimelineInfo;
    }

    public void setSeq(int i3) {
        this.seq = i3;
    }
}
