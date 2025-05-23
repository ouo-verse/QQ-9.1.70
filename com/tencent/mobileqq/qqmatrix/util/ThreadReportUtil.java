package com.tencent.mobileqq.qqmatrix.util;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqmatrix.threadleak.a;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes17.dex */
public class ThreadReportUtil {

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qqmatrix.util.ThreadReportUtil$1, reason: invalid class name */
    /* loaded from: classes17.dex */
    class AnonymousClass1 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f274136d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f274137e;

        @Override // java.lang.Runnable
        public void run() {
            String currentUin;
            for (HashMap<String, String> hashMap : this.f274136d) {
                if (QLog.isColorLevel()) {
                    QLog.d("ThreadReportUtil", 2, "[reportBeacon]:" + this.f274137e + " params = " + hashMap.toString());
                }
                ThreadReportUtil.c(hashMap);
                ThreadReportUtil.d(hashMap);
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                StatisticCollector statisticCollector = StatisticCollector.getInstance(BaseApplication.getContext());
                if (peekAppRuntime == null) {
                    currentUin = "";
                } else {
                    currentUin = peekAppRuntime.getCurrentUin();
                }
                statisticCollector.collectPerformance(currentUin, this.f274137e, true, 0L, 0L, hashMap, "");
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qqmatrix.util.ThreadReportUtil$2, reason: invalid class name */
    /* loaded from: classes17.dex */
    class AnonymousClass2 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ HashMap f274138d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f274139e;

        @Override // java.lang.Runnable
        public void run() {
            String currentUin;
            if (QLog.isColorLevel()) {
                QLog.d("ThreadReportUtil", 2, "reportBeaconByDay, params = " + this.f274138d.toString());
            }
            ThreadReportUtil.c(this.f274138d);
            ThreadReportUtil.d(this.f274138d);
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            StatisticCollector statisticCollector = StatisticCollector.getInstance(BaseApplication.getContext());
            if (peekAppRuntime == null) {
                currentUin = "";
            } else {
                currentUin = peekAppRuntime.getCurrentUin();
            }
            statisticCollector.collectPerformance(currentUin, this.f274139e, true, 0L, 0L, this.f274138d, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Map<String, String> map) {
        map.put("currentProcess", MobileQQ.processName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(HashMap<String, String> hashMap) {
        hashMap.put("realUin", a.f());
    }

    public static boolean e(final List<HashMap<String, String>> list, final String str) {
        if (list != null && list.size() != 0) {
            ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.qqmatrix.util.ThreadReportUtil.3
                @Override // java.lang.Runnable
                public void run() {
                    String currentUin;
                    for (HashMap<String, String> hashMap : list) {
                        if (QLog.isColorLevel()) {
                            QLog.d("ThreadReportUtil", 2, "[reportThreadInfo]:" + str + " params = " + hashMap.toString());
                        }
                        ThreadReportUtil.d(hashMap);
                        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                        StatisticCollector statisticCollector = StatisticCollector.getInstance(BaseApplication.getContext());
                        if (peekAppRuntime == null) {
                            currentUin = "";
                        } else {
                            currentUin = peekAppRuntime.getCurrentUin();
                        }
                        statisticCollector.collectPerformance(currentUin, str, true, 0L, 0L, hashMap, "");
                    }
                }
            }, 16, null, false, 1000L);
            return true;
        }
        return false;
    }
}
