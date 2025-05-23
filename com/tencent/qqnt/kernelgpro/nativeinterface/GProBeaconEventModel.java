package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProBeaconEventModel {
    public boolean onlyReportFirst;
    public long reportCreateTime;
    public long timeCost;
    public String eventCode = "";
    public String traceId = "";
    public String source = "";

    public String getEventCode() {
        return this.eventCode;
    }

    public boolean getOnlyReportFirst() {
        return this.onlyReportFirst;
    }

    public long getReportCreateTime() {
        return this.reportCreateTime;
    }

    public String getSource() {
        return this.source;
    }

    public long getTimeCost() {
        return this.timeCost;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public String toString() {
        return "GProBeaconEventModel{eventCode=" + this.eventCode + ",traceId=" + this.traceId + ",reportCreateTime=" + this.reportCreateTime + ",timeCost=" + this.timeCost + ",onlyReportFirst=" + this.onlyReportFirst + ",source=" + this.source + ",}";
    }
}
