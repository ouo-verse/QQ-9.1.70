package com.tencent.qqperf.reporter.flow;

import com.tencent.mobileqq.debug.hodor.api.IQQHodorPrefApi;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.teamwork.api.ITDocAttaReporterApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.trace.g;
import com.tencent.util.AppSetting;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a {
    public static void a(String str, String str2) {
        QLog.d("PERF_LOG_TRAFFIC", e(), "NF." + str + " " + str2);
    }

    public static void b(String str, String str2, long j3) {
        c(str, str2, j3, 0L);
    }

    public static void c(String str, String str2, long j3, long j16) {
        QLog.d("PERF_LOG_TRAFFIC", e(), "tag = NF." + str + ", url = " + str2 + ", size = " + j3);
        if (!AppSetting.isPublicVersion()) {
            ((IQQHodorPrefApi) g.b(IQQHodorPrefApi.class)).collectNetFlowData(str2, j3, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static List<HashMap<String, String>> d() {
        ArrayList arrayList = new ArrayList();
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        for (String str : from.decodeStringSet("mmkv_downloader_report_key_set", new HashSet())) {
            Long valueOf = Long.valueOf(from.decodeLong("mmkv_downloader_report_key" + str, 0L));
            HashMap hashMap = new HashMap();
            hashMap.put("amount", String.valueOf(valueOf));
            hashMap.put(ITDocAttaReporterApi.REPORT_ACTION_PERFORMANCE, String.valueOf(from.decodeLong("mmkv_downloader_report_performance_key" + str, 0L)));
            hashMap.put("tag", str);
            arrayList.add(hashMap);
            from.encodeLong("mmkv_downloader_report_key" + str, 0L);
        }
        return arrayList;
    }

    private static int e() {
        if (AppSetting.isPublicVersion()) {
            return 2;
        }
        return 1;
    }
}
