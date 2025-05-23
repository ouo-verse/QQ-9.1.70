package com.tencent.av;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public class VideoRecoveryReporter {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f72899a;

    public static void a() {
        try {
            QLog.d("VideoRecoveryReporter", 1, "reportNodeReportFail");
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.av.VideoRecoveryReporter.6
                @Override // java.lang.Runnable
                public void run() {
                    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "av_node_report_fail", true, 0L, 0L, new HashMap<>(), "");
                }
            }, 5, null, false);
        } catch (Throwable th5) {
            QLog.e("VideoRecoveryReporter", 1, "reportNodeReportFail fail.", th5);
        }
    }

    public static void b(final boolean z16) {
        try {
            QLog.d("VideoRecoveryReporter", 1, String.format("reportNodeReportRetry success=%s", Boolean.valueOf(z16)));
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.av.VideoRecoveryReporter.7
                @Override // java.lang.Runnable
                public void run() {
                    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "av_node_report_retry", z16, 0L, 0L, new HashMap<>(), "");
                }
            }, 5, null, false);
        } catch (Throwable th5) {
            QLog.e("VideoRecoveryReporter", 1, "reportNodeReportFail fail.", th5);
        }
    }

    public static void c() {
        try {
            QLog.d("VideoRecoveryReporter", 1, "reportVideoFullscreenNotificationRequest");
            f72899a = true;
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.av.VideoRecoveryReporter.4
                @Override // java.lang.Runnable
                public void run() {
                    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "av_fullscreen_notification_request", true, 0L, 0L, new HashMap<>(), "");
                }
            }, 5, null, false);
        } catch (Throwable th5) {
            QLog.e("VideoRecoveryReporter", 1, "reportVideoRecoveryRequest fail.", th5);
        }
    }

    public static void d() {
        try {
            if (f72899a) {
                f72899a = false;
            }
            QLog.d("VideoRecoveryReporter", 1, "reportVideoFullscreenNotificationResult");
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.av.VideoRecoveryReporter.5
                @Override // java.lang.Runnable
                public void run() {
                    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "av_fullscreen_notification_result", true, 0L, 0L, new HashMap<>(), "");
                }
            }, 5, null, false);
        } catch (Exception e16) {
            QLog.e("VideoRecoveryReporter", 1, "reportVideoRecoveryResult fail.", e16);
        }
    }

    public static void e(final int i3, final long j3) {
        try {
            QLog.d("VideoRecoveryReporter", 1, String.format("reportVideoRecoveryClose reason=%s duration=%s", Integer.valueOf(i3), Long.valueOf(j3)));
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.av.VideoRecoveryReporter.3
                @Override // java.lang.Runnable
                public void run() {
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("close_reason", String.valueOf(i3));
                    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "av_recovery_close2", true, j3, 0L, hashMap, "");
                }
            }, 5, null, false);
        } catch (Throwable th5) {
            QLog.e("VideoRecoveryReporter", 1, "reportVideoRecoveryClose fail.", th5);
        }
    }

    public static void f(final int i3, final long j3, final boolean z16) {
        try {
            QLog.d("VideoRecoveryReporter", 1, String.format("reportVideoRecoveryRequest source=%s interval=%s result=%s", Integer.valueOf(i3), Long.valueOf(j3), Boolean.valueOf(z16)));
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.av.VideoRecoveryReporter.1
                @Override // java.lang.Runnable
                public void run() {
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("source", String.valueOf(i3));
                    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "av_recovery_request2", z16, j3, 0L, hashMap, "");
                }
            }, 5, null, false);
        } catch (Throwable th5) {
            QLog.e("VideoRecoveryReporter", 1, "reportVideoRecoveryRequest fail.", th5);
        }
    }

    public static void g(final boolean z16, final long j3) {
        try {
            QLog.d("VideoRecoveryReporter", 1, String.format("reportVideoRecoveryResult result=%s timeCost=%s", Boolean.valueOf(z16), Long.valueOf(j3)));
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.av.VideoRecoveryReporter.2
                @Override // java.lang.Runnable
                public void run() {
                    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "av_recovery_result2", z16, j3, 0L, new HashMap<>(), "");
                }
            }, 5, null, false);
        } catch (Exception e16) {
            QLog.e("VideoRecoveryReporter", 1, "reportVideoRecoveryResult fail.", e16);
        }
    }
}
