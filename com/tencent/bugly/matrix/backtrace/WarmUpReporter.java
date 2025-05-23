package com.tencent.bugly.matrix.backtrace;

/* compiled from: P */
/* loaded from: classes5.dex */
public interface WarmUpReporter {

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public enum ReportEvent {
        WarmedUp,
        CleanedUp,
        WarmUpThreadBlocked,
        WarmUpFailed,
        WarmUpDuration,
        ConsumeRequestDuration,
        DiskUsage
    }

    void onReport(ReportEvent reportEvent, Object... objArr);
}
