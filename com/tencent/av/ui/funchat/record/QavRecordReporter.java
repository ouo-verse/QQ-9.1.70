package com.tencent.av.ui.funchat.record;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import java.util.HashMap;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QavRecordReporter {

    /* renamed from: a, reason: collision with root package name */
    private static int f75820a = 0;

    /* renamed from: b, reason: collision with root package name */
    private static long f75821b = 0;

    /* renamed from: c, reason: collision with root package name */
    private static int f75822c = 0;

    /* renamed from: d, reason: collision with root package name */
    private static long f75823d = 0;

    /* renamed from: e, reason: collision with root package name */
    private static boolean f75824e = false;

    /* renamed from: f, reason: collision with root package name */
    private static int f75825f;

    /* renamed from: g, reason: collision with root package name */
    private static Throwable f75826g;

    public static void a() {
        if (QLog.isColorLevel()) {
            QLog.i("QavRecordReporter", 2, "onAudioTrackInitFail");
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("device_model", ah.s());
        hashMap.put(DTConstants.TAG.API, ah.t());
        hashMap.put("manufacture", ah.C());
        if (QLog.isColorLevel()) {
            QLog.i("QavRecordReporter", 2, "onAudioTrackInitFail  params=" + hashMap);
        }
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "av_record_audio_fail", !f75824e, 0L, 0L, hashMap, "", false);
    }

    public static void b(int i3, Throwable th5) {
        if (QLog.isColorLevel()) {
            QLog.i("QavRecordReporter", 2, "onError " + i3);
        }
        f75824e = true;
        f75825f = i3;
        f75826g = th5;
    }

    public static void c() {
        if (f75823d < 0) {
            f75823d = System.currentTimeMillis();
        }
        f75822c++;
    }

    public static void d(final int i3, final int i16, final int i17, final long j3) {
        final long currentTimeMillis = System.currentTimeMillis();
        final long j16 = f75821b;
        final long j17 = f75823d;
        final int i18 = f75820a;
        final int i19 = f75822c;
        if (QLog.isColorLevel()) {
            QLog.i("QavRecordReporter", 2, "onRecordEnd cores=" + i3 + ", fqc=" + i16 + ", start=" + j16 + ", end=" + currentTimeMillis + ", frames=" + i18 + ", stopType=" + i17 + ", mp4Start=" + j17 + ", mp4Frames=" + i19);
        }
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.av.ui.funchat.record.QavRecordReporter.1
            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                String format = String.format(Locale.getDefault(), "%.1f", Float.valueOf(i16 / 1000.0f));
                long j18 = currentTimeMillis;
                int i26 = (int) (((i18 * 1.0f) / ((float) (j18 - j16))) * 1000.0f);
                int i27 = (int) (((i19 * 1.0f) / ((float) (j18 - j17))) * 1000.0f);
                String format2 = String.format(Locale.getDefault(), "%.1f", Float.valueOf(((float) j3) / 1000.0f));
                int max = Math.max(0, i26);
                int max2 = Math.max(0, i27);
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("cores", String.valueOf(i3));
                hashMap.put("frequency", format);
                hashMap.put("videoFps", String.valueOf(max));
                hashMap.put("mp4Fps", String.valueOf(max2));
                hashMap.put("strDuration", format2);
                hashMap.put("stopType", String.valueOf(i17));
                if (QLog.isColorLevel()) {
                    QLog.i("QavRecordReporter", 2, "onRecordEnd  params=" + hashMap);
                }
                StatisticCollector statisticCollector = StatisticCollector.getInstance(BaseApplication.getContext());
                if (i17 != 3) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                statisticCollector.collectPerformance("", "av_record_fps", z16, j3, 0L, hashMap, "", false);
            }
        }, 5, null, false);
    }

    public static void e() {
        f75820a = 0;
        f75821b = System.currentTimeMillis();
        f75823d = -1L;
        f75822c = 0;
        f75824e = false;
        f75825f = 0;
        f75826g = null;
    }

    public static void f() {
        f75820a++;
    }

    public static void g(String str) {
        ReportController.o(null, "CliOper", "", "", str, str, 0, 0, "", "", "", "");
    }

    public static void h() {
        if (QLog.isColorLevel()) {
            QLog.i("QavRecordReporter", 2, "reportEnd");
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("param_FailCode", String.valueOf(f75825f));
        hashMap.put("device_model", ah.s());
        hashMap.put(DTConstants.TAG.API, ah.t());
        hashMap.put("manufacture", ah.C());
        hashMap.put("throwable", String.valueOf(f75826g));
        f75826g = null;
        if (QLog.isColorLevel()) {
            QLog.i("QavRecordReporter", 2, "reportEnd params=" + hashMap);
        }
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "av_record_report_end", !f75824e, 0L, 0L, hashMap, "", false);
    }
}
