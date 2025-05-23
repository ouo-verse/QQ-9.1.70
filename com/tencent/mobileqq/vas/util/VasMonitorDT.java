package com.tencent.mobileqq.vas.util;

import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes20.dex */
public class VasMonitorDT {
    public static final String TAG = "VasMonitorDT";

    public static void reportAuthResult(String str, int i3) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("authResult", String.valueOf(i3));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", str, false, 0L, -1L, hashMap, "", true);
    }

    public static void reportErrCode(String str, String str2) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("errCode", str2);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", str, false, 0L, -1L, hashMap, "", true);
    }
}
