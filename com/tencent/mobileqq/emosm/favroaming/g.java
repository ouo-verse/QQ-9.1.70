package com.tencent.mobileqq.emosm.favroaming;

import com.tencent.mobileqq.emoticon.EmoticonOperateReport;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes6.dex */
public class g {
    public static void a(boolean z16, int i3, int i16) {
        String str;
        HashMap<String, String> hashMap = new HashMap<>();
        String str2 = "0";
        if (!z16) {
            str = "0";
        } else {
            str = "1";
        }
        hashMap.put("sucFlag", str);
        hashMap.put("retCode", String.valueOf(i3));
        hashMap.put("serverRetCode", String.valueOf(i16));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "FavEmoUploadLocal", false, 0L, 0L, hashMap, null);
        if (!z16) {
            str2 = String.valueOf(i3);
        }
        EmoticonOperateReport.reportEmoticonOperateMonitorAddStatus(str2, 1);
    }
}
