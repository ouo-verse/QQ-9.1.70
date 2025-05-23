package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProStSingleRecomReportInfo {
    public String reportID = "";
    public byte[] reportData = new byte[0];

    public byte[] getReportData() {
        return this.reportData;
    }

    public String getReportID() {
        return this.reportID;
    }

    public String toString() {
        return "GProStSingleRecomReportInfo{reportID=" + this.reportID + ",reportData=" + this.reportData + ",}";
    }
}
