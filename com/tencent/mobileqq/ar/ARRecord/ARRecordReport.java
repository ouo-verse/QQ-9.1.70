package com.tencent.mobileqq.ar.ARRecord;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ARRecordReport {

    /* renamed from: a, reason: collision with root package name */
    private static ARRecordReport f196966a;

    public static ARRecordReport a() {
        if (f196966a == null) {
            f196966a = new ARRecordReport();
        }
        return f196966a;
    }

    public void b(final boolean z16) {
        QLog.d("ARRecordReport", 2, String.format("reportActiveRecordStart inPreRecord=%s", Boolean.valueOf(z16)));
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.ar.ARRecord.ARRecordReport.2
            @Override // java.lang.Runnable
            public void run() {
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "ar_record_active_record_start", z16, 0L, 0L, new HashMap<>(), "");
            }
        }, 5, null, false);
    }

    public void c() {
        QLog.d("ARRecordReport", 2, "reportPreRecordStart");
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.ar.ARRecord.ARRecordReport.1
            @Override // java.lang.Runnable
            public void run() {
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "ar_record_pre_record_start", true, 0L, 0L, new HashMap<>(), "");
            }
        }, 5, null, false);
    }

    public void d(final int i3) {
        QLog.d("ARRecordReport", 2, String.format("reportRecordFail failType=%s", Integer.valueOf(i3)));
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.ar.ARRecord.ARRecordReport.4
            @Override // java.lang.Runnable
            public void run() {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("param_FailCode", String.valueOf(i3));
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "ar_record_record_fail", true, 0L, 0L, hashMap, "");
            }
        }, 5, null, false);
    }

    public void e(final int i3, final long j3) {
        QLog.d("ARRecordReport", 2, String.format("reportRecordSuccess successType=%s videoLength=%s", Integer.valueOf(i3), Long.valueOf(j3)));
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.ar.ARRecord.ARRecordReport.3
            @Override // java.lang.Runnable
            public void run() {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("param_FailCode", String.valueOf(i3));
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "ar_record_record_success", true, 0L, j3, hashMap, "");
            }
        }, 5, null, false);
    }
}
