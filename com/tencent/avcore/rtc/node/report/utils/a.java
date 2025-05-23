package com.tencent.avcore.rtc.node.report.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static HashMap<String, String> a(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        String[] split = str.split("\\|");
        for (int i3 = 0; i3 < split.length - 1; i3 += 2) {
            hashMap.put(split[i3], split[i3 + 1]);
        }
        return hashMap;
    }

    public static void b(String str, String str2, HashMap<String, String> hashMap) {
        QQBeaconReport.start();
        QQBeaconReport.reportWithAppKey(str, "", str2, true, hashMap, true);
    }
}
