package com.tencent.ttpic.baseutils.report;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ReportUtil {
    private static ReportListener listener = null;
    private static boolean sEnablePerfReport = false;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface ReportListener {
        void report(String str);
    }

    public static boolean isEnablePerfReport() {
        return sEnablePerfReport;
    }

    public static void report(String str) {
        ReportListener reportListener = listener;
        if (reportListener != null) {
            reportListener.report(str);
        }
    }

    public static void setEnablePerfReport(boolean z16) {
        sEnablePerfReport = z16;
    }

    public static void setListener(ReportListener reportListener) {
        listener = reportListener;
    }
}
