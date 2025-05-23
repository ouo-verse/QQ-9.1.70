package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProStBusiReportInfo {
    public GProStRecomReportInfo recomReport = new GProStRecomReportInfo();
    public String traceID = "";

    public GProStRecomReportInfo getRecomReport() {
        return this.recomReport;
    }

    public String getTraceID() {
        return this.traceID;
    }

    public String toString() {
        return "GProStBusiReportInfo{recomReport=" + this.recomReport + ",traceID=" + this.traceID + ",}";
    }
}
