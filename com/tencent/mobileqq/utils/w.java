package com.tencent.mobileqq.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes20.dex */
public class w {
    public static void a(String str, long j3, long j16, long j17, String str2) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("name", str);
        hashMap.put("timeCost", String.valueOf(j3));
        hashMap.put("beginTime", String.valueOf(j16));
        hashMap.put("endTime", String.valueOf(j17));
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("account", str2);
        }
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "timeCost", true, j3, 0L, hashMap, null);
    }
}
