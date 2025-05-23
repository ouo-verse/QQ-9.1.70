package com.tencent.relation.common.report;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a {
    static IPatchRedirector $redirector_;

    private static String a() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return "";
        }
        return peekAppRuntime.getCurrentUin();
    }

    public static void b(String str, boolean z16, HashMap<String, String> hashMap) {
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(a(), str, z16, 0L, 0L, hashMap, "", false);
    }

    public static void c(String str, long j3, boolean z16, HashMap<String, String> hashMap) {
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(a(), str, z16, j3, 0L, hashMap, "", false);
    }
}
