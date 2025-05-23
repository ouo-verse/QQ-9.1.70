package com.tencent.qqlive.module.videoreport.constants;

@Deprecated
/* loaded from: classes22.dex */
public enum ReportPolicy {
    REPORT_POLICY_NONE(false, false),
    REPORT_POLICY_EXPOSURE(false, true),
    REPORT_POLICY_CLICK(true, false),
    REPORT_POLICY_ALL(true, true);

    public final boolean reportClick;
    public final boolean reportExposure;

    ReportPolicy(boolean z16, boolean z17) {
        this.reportClick = z16;
        this.reportExposure = z17;
    }
}
