package com.tencent.mobileqq.winkreport.crashreport;

/* compiled from: P */
/* loaded from: classes21.dex */
public interface IWinkCrashReportCallback {
    String getLogTag();

    void onAttachReport();

    void onCreateReport();

    void onCreateViewReport();

    void onCustomReport(int i3);

    void onDestroyReport();

    void onDestroyViewReport();

    void onHiddenChangedReport(boolean z16);

    void onPauseReport();

    void onResumeReport();

    void onViewCreatedReport();
}
