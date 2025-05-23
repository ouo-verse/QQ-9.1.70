package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class NTQuoteToQunAlbumReq {
    public long batchId;
    public int from;
    public int seq;
    public RequestTimelineInfo requestTimeLine = new RequestTimelineInfo();
    public String qunId = "";
    public String albumId = "";
    public ArrayList<QuoteToQunAlbumUnit> units = new ArrayList<>();
    public StFeed feed = new StFeed();

    public String getAlbumId() {
        return this.albumId;
    }

    public long getBatchId() {
        return this.batchId;
    }

    public StFeed getFeed() {
        return this.feed;
    }

    public int getFrom() {
        return this.from;
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

    public void setAlbumId(String str) {
        this.albumId = str;
    }

    public void setBatchId(long j3) {
        this.batchId = j3;
    }

    public void setFeed(StFeed stFeed) {
        this.feed = stFeed;
    }

    public void setFrom(int i3) {
        this.from = i3;
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

    public void setUnits(ArrayList<QuoteToQunAlbumUnit> arrayList) {
        this.units = arrayList;
    }
}
