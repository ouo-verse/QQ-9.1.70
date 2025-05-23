package com.tencent.mobileqq.app.monitor;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes11.dex */
final class ReportType {
    private static final /* synthetic */ ReportType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final ReportType JOB_HIGH_FREQ_RUN;
    public static final ReportType JOB_RUN_TIME_HIGH;
    public static final ReportType JOB_WAIT_TIME_HIGH;
    public static final ReportType QUEUE_SIZE_HIGH;
    public static final ReportType REJECTED_EXECUTION;
    public static final ReportType RUNNING_TASK_COUNT_LOW;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41159);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ReportType reportType = new ReportType("RUNNING_TASK_COUNT_LOW", 0);
        RUNNING_TASK_COUNT_LOW = reportType;
        ReportType reportType2 = new ReportType("QUEUE_SIZE_HIGH", 1);
        QUEUE_SIZE_HIGH = reportType2;
        ReportType reportType3 = new ReportType("JOB_WAIT_TIME_HIGH", 2);
        JOB_WAIT_TIME_HIGH = reportType3;
        ReportType reportType4 = new ReportType("JOB_RUN_TIME_HIGH", 3);
        JOB_RUN_TIME_HIGH = reportType4;
        ReportType reportType5 = new ReportType("REJECTED_EXECUTION", 4);
        REJECTED_EXECUTION = reportType5;
        ReportType reportType6 = new ReportType("JOB_HIGH_FREQ_RUN", 5);
        JOB_HIGH_FREQ_RUN = reportType6;
        $VALUES = new ReportType[]{reportType, reportType2, reportType3, reportType4, reportType5, reportType6};
    }

    ReportType(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static ReportType valueOf(String str) {
        return (ReportType) Enum.valueOf(ReportType.class, str);
    }

    public static ReportType[] values() {
        return (ReportType[]) $VALUES.clone();
    }
}
