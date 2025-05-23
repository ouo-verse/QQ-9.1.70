package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class TopicReportReq {
    public long groupCode;
    public int reportType;

    public long getGroupCode() {
        return this.groupCode;
    }

    public int getReportType() {
        return this.reportType;
    }

    public String toString() {
        return "TopicReportReq{groupCode=" + this.groupCode + ",reportType=" + this.reportType + ",}";
    }
}
