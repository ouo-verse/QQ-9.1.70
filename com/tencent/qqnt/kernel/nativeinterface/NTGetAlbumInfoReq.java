package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class NTGetAlbumInfoReq {
    public String albumId;
    public String qunId;
    public RequestTimelineInfo requestTimeLine;
    public int seq;

    public NTGetAlbumInfoReq() {
        this.requestTimeLine = new RequestTimelineInfo();
        this.qunId = "";
        this.albumId = "";
    }

    public String getAlbumId() {
        return this.albumId;
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
        return "NTGetAlbumInfoReq{seq=" + this.seq + ",requestTimeLine=" + this.requestTimeLine + ",qunId=" + this.qunId + ",albumId=" + this.albumId + ",}";
    }

    public NTGetAlbumInfoReq(int i3, RequestTimelineInfo requestTimelineInfo, String str, String str2) {
        new RequestTimelineInfo();
        this.seq = i3;
        this.requestTimeLine = requestTimelineInfo;
        this.qunId = str;
        this.albumId = str2;
    }
}
