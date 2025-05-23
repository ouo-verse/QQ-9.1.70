package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProReportRecentViewFeedReq {
    public String feedId = "";
    public int reportType;

    public String getFeedId() {
        return this.feedId;
    }

    public int getReportType() {
        return this.reportType;
    }

    public String toString() {
        return "GProReportRecentViewFeedReq{reportType=" + this.reportType + ",feedId=" + this.feedId + ",}";
    }
}
