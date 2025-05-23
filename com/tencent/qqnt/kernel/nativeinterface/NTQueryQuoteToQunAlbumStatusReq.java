package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class NTQueryQuoteToQunAlbumStatusReq {
    public String albumId;
    public long batchId;
    public String qunId;
    public RequestTimelineInfo requestTimeLine;
    public int seq;
    public ArrayList<QuoteToQunAlbumUnit> units;

    public NTQueryQuoteToQunAlbumStatusReq() {
        this.requestTimeLine = new RequestTimelineInfo();
        this.qunId = "";
        this.albumId = "";
        this.units = new ArrayList<>();
    }

    public String getAlbumId() {
        return this.albumId;
    }

    public long getBatchId() {
        return this.batchId;
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

    public ArrayList<QuoteToQunAlbumUnit> getUnits() {
        return this.units;
    }

    public NTQueryQuoteToQunAlbumStatusReq(int i3, RequestTimelineInfo requestTimelineInfo, String str, String str2, long j3, ArrayList<QuoteToQunAlbumUnit> arrayList) {
        this.requestTimeLine = new RequestTimelineInfo();
        this.qunId = "";
        this.albumId = "";
        new ArrayList();
        this.seq = i3;
        this.requestTimeLine = requestTimelineInfo;
        this.qunId = str;
        this.albumId = str2;
        this.batchId = j3;
        this.units = arrayList;
    }
}
