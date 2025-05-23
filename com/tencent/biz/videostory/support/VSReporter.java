package com.tencent.biz.videostory.support;

import NS_COMM.COMM;
import NS_MINI_REPORT.REPORT$SingleDcData;
import android.support.annotation.NonNull;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.v;
import cooperation.qzone.QUA;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class VSReporter {

    /* renamed from: a, reason: collision with root package name */
    private static int f97125a;

    /* renamed from: b, reason: collision with root package name */
    private static long f97126b;

    public static void a() {
        long currentTimeMillis = (System.currentTimeMillis() / 1000) << 32;
        int i3 = f97125a;
        f97126b = currentTimeMillis | i3;
        f97125a = i3 + 1;
    }

    @NonNull
    public static String b(int i3, String... strArr) {
        if (strArr != null && strArr.length > i3) {
            return strArr[i3];
        }
        return "";
    }

    public static COMM.Entry c(String str, String str2) {
        COMM.Entry entry = new COMM.Entry();
        if (str != null) {
            entry.key.set(str);
        }
        if (str2 != null) {
            entry.value.set(str2);
        }
        return entry;
    }

    public static List<COMM.Entry> d(int i3, long j3, String str, long j16, String str2) {
        return new ArrayList(Arrays.asList(c("ret_code", String.valueOf(i3)), c("time_cost", String.valueOf(j3)), c("url", str), c("file_size", String.valueOf(j16)), c("element_id", str2)));
    }

    public static List<COMM.Entry> e(long j3, long j16) {
        return new ArrayList(Arrays.asList(c("ret_code", String.valueOf(j3)), c("time_cost", String.valueOf(j16))));
    }

    public static List<COMM.Entry> f(long j3, long j16, String str, long j17) {
        return new ArrayList(Arrays.asList(c("ret_code", String.valueOf(j3)), c("time_cost", String.valueOf(j16)), c("url", str), c("file_size", String.valueOf(j17))));
    }

    public static List<COMM.Entry> g(ArrayList<COMM.Entry> arrayList, HashMap<String, Object> hashMap) {
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        if (hashMap != null && hashMap.keySet().size() > 0) {
            for (String str : hashMap.keySet()) {
                arrayList.add(c(str, String.valueOf(hashMap.get(str))));
            }
        }
        return arrayList;
    }

    public static List<COMM.Entry> h(HashMap<String, Object> hashMap) {
        return g(null, hashMap);
    }

    public static List<COMM.Entry> i(HashMap<String, Object> hashMap) {
        if (hashMap != null && hashMap.keySet().size() > 0) {
            return j(h(hashMap));
        }
        return null;
    }

    public static List<COMM.Entry> j(List<COMM.Entry> list) {
        if (list != null) {
            list.add(c("unique_id", String.valueOf(l())));
        }
        return list;
    }

    public static List<COMM.Entry> k() {
        return new ArrayList(Arrays.asList(c("uin", String.valueOf(com.tencent.open.adapter.a.f().l())), c("timestamp", String.valueOf(System.currentTimeMillis())), c("qua", QUA.getQUA3()), c("version", AppSetting.f99554n), c("idfa", ""), c("idfv", "")));
    }

    public static long l() {
        return f97126b;
    }

    public static void m(String str, String str2, int i3, int i16, String... strArr) {
        n("", str, str2, i3, i16, strArr);
    }

    public static void n(String str, String str2, String str3, int i3, int i16, String... strArr) {
        ReportController.o(null, "dc00898", "", str, str2, str3, i3, i16, b(0, strArr), b(1, strArr), b(2, strArr), b(3, strArr));
    }

    public static void o(String str, String str2, int i3, int i16, String... strArr) {
        p("", str, str2, i3, i16, strArr);
    }

    public static void p(String str, String str2, String str3, int i3, int i16, String... strArr) {
        v.c(null, str, str2, str3, i3, i16, b(0, strArr), b(1, strArr), b(2, strArr), b(3, strArr));
    }

    public static void q(final String str, final List<COMM.Entry> list) {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.biz.videostory.support.VSReporter.1
            @Override // java.lang.Runnable
            public void run() {
                REPORT$SingleDcData rEPORT$SingleDcData = new REPORT$SingleDcData();
                rEPORT$SingleDcData.dcid.set(5);
                rEPORT$SingleDcData.type.set(String.valueOf(2));
                rEPORT$SingleDcData.report_data.add(VSReporter.c("event", str));
                rEPORT$SingleDcData.report_data.addAll(VSReporter.k());
                List list2 = list;
                if (list2 != null && !list2.isEmpty()) {
                    rEPORT$SingleDcData.report_data.addAll(list);
                }
                ((IMiniAppService) QRoute.api(IMiniAppService.class)).addMiniProgramReportData(rEPORT$SingleDcData);
            }
        });
    }
}
