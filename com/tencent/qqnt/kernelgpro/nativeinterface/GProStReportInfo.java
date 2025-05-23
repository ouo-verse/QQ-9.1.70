package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProStReportInfo {
    public String idd = "";
    public byte[] busiReport = new byte[0];

    public byte[] getBusiReport() {
        return this.busiReport;
    }

    public String getIdd() {
        return this.idd;
    }

    public String toString() {
        return "GProStReportInfo{idd=" + this.idd + ",busiReport=" + this.busiReport + ",}";
    }
}
