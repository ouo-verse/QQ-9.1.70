package com.tencent.mobileqq.util;

import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class bw {
    public static void a(int i3, String str) {
        b("maskUinLoginResult", i3, str);
    }

    public static void b(String str, int i3, String str2) {
        String account;
        HashMap<String, String> hashMap = new HashMap<>();
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime == null) {
            account = "";
        } else {
            account = waitAppRuntime.getAccount();
        }
        hashMap.put("keyUin", account);
        hashMap.put("keyErrorCode", String.valueOf(i3));
        hashMap.put("keyQuickLoginResult", str);
        if (str2 == null) {
            str2 = "";
        }
        hashMap.put("keyErrorMsg", str2);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(account, "quickLoginReportEvent", false, 0L, 0L, hashMap, "");
    }

    public static void c(int i3, String str) {
        b("phoneLoginResult", i3, str);
    }
}
