package com.tencent.mobileqq.richmedia.ordersend;

import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c {
    public static void a(int i3, int i16) {
        boolean z16;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("totalSize", String.valueOf(i3));
        hashMap.put("mediaSize", String.valueOf(i16));
        StatisticCollector statisticCollector = StatisticCollector.getInstance(BaseApplication.getContext());
        if (i16 > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        statisticCollector.collectPerformance(null, "OrderMediaMsgMultiSeperate", z16, 0L, i3, hashMap, "");
    }

    public static void b(int i3, int i16) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(QQBrowserActivity.KEY_MSG_TYPE, String.valueOf(i3));
        hashMap.put("idType", String.valueOf(i16));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "OrderMediaMsgAddTimeout", false, 0L, 0L, hashMap, "");
    }

    public static void c(int i3, long j3) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("totalSize", String.valueOf(i3));
        hashMap.put(VasPerfReportUtils.WHILE_COST_TOTAL, String.valueOf(j3));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "OrderMediaMsgCompleteInfo", true, j3, i3, hashMap, "");
    }

    public static void d(int i3, boolean z16) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(QQBrowserActivity.KEY_MSG_TYPE, String.valueOf(i3));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "OrderMediaMsgSendTimeout", !z16, 0L, 0L, hashMap, "");
    }
}
