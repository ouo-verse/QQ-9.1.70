package com.tencent.component.network.downloader;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RangeDownloadReport {
    private long contentLength;
    private int rangeId;
    private long timeCost;
    private long timeCostData;
    private long timeCostHeader;

    public long getContentLength() {
        return this.contentLength;
    }

    public int getRangeId() {
        return this.rangeId;
    }

    public long getTimeCost() {
        return this.timeCost;
    }

    public long getTimeCostData() {
        return this.timeCostData;
    }

    public long getTimeCostHeader() {
        return this.timeCostHeader;
    }

    public void setContentLength(long j3) {
        this.contentLength = j3;
    }

    public void setRangeId(int i3) {
        this.rangeId = i3;
    }

    public void setTimeCost(long j3) {
        this.timeCost = j3;
    }

    public void setTimeCostData(long j3) {
        this.timeCostData = j3;
    }

    public void setTimeCostHeader(long j3) {
        this.timeCostHeader = j3;
    }
}
