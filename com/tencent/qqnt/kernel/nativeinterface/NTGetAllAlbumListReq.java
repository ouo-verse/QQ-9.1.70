package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class NTGetAllAlbumListReq {
    public String attachInfo;
    public RequestTimelineInfo requestTimeLine;
    public int seq;

    public NTGetAllAlbumListReq() {
        this.requestTimeLine = new RequestTimelineInfo();
        this.attachInfo = "";
    }

    public String getAttachInfo() {
        return this.attachInfo;
    }

    public RequestTimelineInfo getRequestTimeLine() {
        return this.requestTimeLine;
    }

    public int getSeq() {
        return this.seq;
    }

    public String toString() {
        return "NTGetAllAlbumListReq{seq=" + this.seq + ",requestTimeLine=" + this.requestTimeLine + ",attachInfo=" + this.attachInfo + ",}";
    }

    public NTGetAllAlbumListReq(int i3, RequestTimelineInfo requestTimelineInfo, String str) {
        new RequestTimelineInfo();
        this.seq = i3;
        this.requestTimeLine = requestTimelineInfo;
        this.attachInfo = str;
    }
}
