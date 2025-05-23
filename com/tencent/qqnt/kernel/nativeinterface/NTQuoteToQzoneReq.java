package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class NTQuoteToQzoneReq {
    public String albumId;
    public String dstAlbumId;
    public long dstBatchId;
    public String dstDesc;
    public ArrayList<String> lloc;
    public String qunId;
    public RequestTimelineInfo requestTimeLine;
    public int seq;
    public long srcBatchId;

    public NTQuoteToQzoneReq() {
        this.requestTimeLine = new RequestTimelineInfo();
        this.qunId = "";
        this.albumId = "";
        this.lloc = new ArrayList<>();
        this.dstAlbumId = "";
        this.dstDesc = "";
    }

    public String getAlbumId() {
        return this.albumId;
    }

    public String getDstAlbumId() {
        return this.dstAlbumId;
    }

    public long getDstBatchId() {
        return this.dstBatchId;
    }

    public String getDstDesc() {
        return this.dstDesc;
    }

    public ArrayList<String> getLloc() {
        return this.lloc;
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

    public long getSrcBatchId() {
        return this.srcBatchId;
    }

    public String toString() {
        return "NTQuoteToQzoneReq{seq=" + this.seq + ",requestTimeLine=" + this.requestTimeLine + ",qunId=" + this.qunId + ",albumId=" + this.albumId + ",lloc=" + this.lloc + ",dstAlbumId=" + this.dstAlbumId + ",dstDesc=" + this.dstDesc + ",dstBatchId=" + this.dstBatchId + ",srcBatchId=" + this.srcBatchId + ",}";
    }

    public NTQuoteToQzoneReq(int i3, RequestTimelineInfo requestTimelineInfo, String str, String str2, ArrayList<String> arrayList, String str3, String str4, long j3, long j16) {
        this.requestTimeLine = new RequestTimelineInfo();
        this.qunId = "";
        this.albumId = "";
        new ArrayList();
        this.seq = i3;
        this.requestTimeLine = requestTimelineInfo;
        this.qunId = str;
        this.albumId = str2;
        this.lloc = arrayList;
        this.dstAlbumId = str3;
        this.dstDesc = str4;
        this.dstBatchId = j3;
        this.srcBatchId = j16;
    }
}
