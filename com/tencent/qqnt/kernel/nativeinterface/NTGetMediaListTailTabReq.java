package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class NTGetMediaListTailTabReq {
    public String currentAlbumId;
    public String qunId;
    public RequestTimelineInfo requestTimeLine;
    public int seq;

    public NTGetMediaListTailTabReq() {
        this.requestTimeLine = new RequestTimelineInfo();
        this.qunId = "";
        this.currentAlbumId = "";
    }

    public String getCurrentAlbumId() {
        return this.currentAlbumId;
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
        return "NTGetMediaListTailTabReq{seq=" + this.seq + ",requestTimeLine=" + this.requestTimeLine + ",qunId=" + this.qunId + ",currentAlbumId=" + this.currentAlbumId + ",}";
    }

    public NTGetMediaListTailTabReq(int i3, RequestTimelineInfo requestTimelineInfo, String str, String str2) {
        new RequestTimelineInfo();
        this.seq = i3;
        this.requestTimeLine = requestTimelineInfo;
        this.qunId = str;
        this.currentAlbumId = str2;
    }
}
