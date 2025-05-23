package com.tencent.mobileqq.richmedia.dc;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes18.dex */
public class DataReport {

    /* renamed from: b, reason: collision with root package name */
    private static HandlerThread f281558b;

    /* renamed from: c, reason: collision with root package name */
    private static DataReport f281559c;

    /* renamed from: a, reason: collision with root package name */
    private Handler f281560a = new Handler(f281558b.getLooper());

    /* compiled from: P */
    /* loaded from: classes18.dex */
    static class ReportTask implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        HashMap<String, String> f281561d;

        /* renamed from: e, reason: collision with root package name */
        String f281562e;

        public ReportTask(String str, HashMap<String, String> hashMap) {
            this.f281562e = str;
            this.f281561d = hashMap;
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap<String, String> hashMap;
            if (this.f281562e != null && (hashMap = this.f281561d) != null && !hashMap.isEmpty()) {
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, this.f281562e, true, 0L, 0L, this.f281561d, "");
                if (QLog.isColorLevel()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("eventCode:" + this.f281562e + "\n");
                    sb5.append(this.f281561d.toString());
                    QLog.i("DataReport", 2, sb5.toString());
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("DataReport", 2, "You must set mEventCode before report data!");
            }
        }
    }

    static {
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("Reportor-Tasker");
        f281558b = baseHandlerThread;
        baseHandlerThread.start();
        f281559c = new DataReport();
    }

    DataReport() {
    }

    public static DataReport a() {
        return f281559c;
    }

    public void b(ReportTask reportTask) {
        if (reportTask == null) {
            return;
        }
        this.f281560a.post(reportTask);
    }
}
