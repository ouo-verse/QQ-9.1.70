package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProMsgTimeRange {
    public String endDate;
    public String startDate;

    public GProMsgTimeRange() {
        this.startDate = "";
        this.endDate = "";
    }

    public String getEndDate() {
        return this.endDate;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public void setEndDate(String str) {
        this.endDate = str;
    }

    public void setStartDate(String str) {
        this.startDate = str;
    }

    public String toString() {
        return "GProMsgTimeRange{startDate=" + this.startDate + ",endDate=" + this.endDate + ",}";
    }

    public GProMsgTimeRange(String str, String str2) {
        this.startDate = str;
        this.endDate = str2;
    }
}
