package com.qzone.component.banner;

import android.util.SparseIntArray;
import com.qzone.common.account.LoginData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IQbossReportManager;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.report.lp.LpreportInfo_dc02910;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes39.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static final ConcurrentHashMap<String, Integer> f46568a = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, SparseIntArray> f46569b = new ConcurrentHashMap<>();

    public static void a(String str, int i3) {
        ConcurrentHashMap<String, Integer> concurrentHashMap = f46568a;
        Integer num = concurrentHashMap.get(str);
        if (num == null) {
            num = new Integer(0);
        }
        concurrentHashMap.put(str, Integer.valueOf(num.intValue() + 1));
        ConcurrentHashMap<String, SparseIntArray> concurrentHashMap2 = f46569b;
        SparseIntArray sparseIntArray = concurrentHashMap2.get(str);
        if (sparseIntArray == null) {
            sparseIntArray = new SparseIntArray();
            concurrentHashMap2.put(str, sparseIntArray);
        }
        sparseIntArray.put(i3, sparseIntArray.get(i3) + 1);
    }

    public static void b(String str, int i3) {
        LpreportInfo_dc02910 lpreportInfo_dc02910 = new LpreportInfo_dc02910();
        lpreportInfo_dc02910.index = i3;
        lpreportInfo_dc02910.operType = 2;
        lpreportInfo_dc02910.traceInfo = str;
        lpreportInfo_dc02910.operTimes = 1;
        lpreportInfo_dc02910.uin = LoginData.getInstance().getUin();
        LpReportManager.getInstance().reportToDC02910(lpreportInfo_dc02910, false, false);
        ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportClick(str, LoginData.getInstance().getUinString());
    }

    public static void c(String str) {
        ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportClose(str, LoginData.getInstance().getUinString());
    }

    public static void d(String str, int i3) {
        ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportExpose(str, LoginData.getInstance().getUinString());
    }

    public static void e() {
        for (Map.Entry<String, Integer> entry : f46568a.entrySet()) {
            ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportSlide(entry.getKey(), LoginData.getInstance().getUinString(), entry.getValue().intValue());
        }
        f46568a.clear();
        for (Map.Entry<String, SparseIntArray> entry2 : f46569b.entrySet()) {
            String key = entry2.getKey();
            SparseIntArray value = entry2.getValue();
            for (int i3 = 0; i3 < value.size(); i3++) {
                int keyAt = value.keyAt(i3);
                int i16 = value.get(keyAt);
                LpreportInfo_dc02910 lpreportInfo_dc02910 = new LpreportInfo_dc02910();
                lpreportInfo_dc02910.index = keyAt;
                lpreportInfo_dc02910.operTimes = i16;
                lpreportInfo_dc02910.operType = 9;
                lpreportInfo_dc02910.traceInfo = key;
                lpreportInfo_dc02910.uin = LoginData.getInstance().getUin();
                LpReportManager.getInstance().reportToDC02910(lpreportInfo_dc02910, false, false);
            }
        }
        f46569b.clear();
    }
}
