package com.tencent.mobileqq.perf.report;

import android.text.TextUtils;
import com.tencent.mobileqq.perf.report.PerfFeature;
import com.tencent.mobileqq.perf.report.abtag.BuglyABManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static boolean f258012a;

    /* renamed from: b, reason: collision with root package name */
    public static String f258013b;

    /* renamed from: c, reason: collision with root package name */
    public static int f258014c;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f258015d;

    public static void a(Map<String, String> map) {
        if (!PerfFeature.b().isEmpty()) {
            map.put("FeatureFlag", TextUtils.join(", ", PerfFeature.b()));
        }
        String str = f258013b;
        if (!TextUtils.isEmpty(str)) {
            map.put("zPlanGameName", String.valueOf(str));
        }
        int i3 = f258014c;
        if (i3 != 0) {
            map.put("zPlanStatus", String.valueOf(i3));
        }
    }

    public static HashMap<String, String> b() {
        HashMap<String, String> hashMap = new HashMap<>();
        a(hashMap);
        return hashMap;
    }

    public static boolean c(String str, boolean z16) {
        try {
            return QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeBool("FeatureFlag_" + str, z16);
        } catch (Throwable th5) {
            QLog.e("FeatureFlag", 1, "readLastValue fail", th5);
            return false;
        }
    }

    private static void d(String str, boolean z16) {
        QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeBool("FeatureFlag_" + str, z16);
    }

    public static void e(boolean z16) {
        if (!z16 && f258015d) {
            QLog.d("FeatureFlag", 1, "updateZplanFilamentConfig ignore");
            return;
        }
        f258015d = true;
        if (z16) {
            PerfFeature.a(PerfFeature.CustomFlag.ZPlanFilament);
        } else {
            PerfFeature.d(PerfFeature.CustomFlag.ZPlanFilament);
        }
        BuglyABManager.ABTag aBTag = BuglyABManager.ABTag.ZPlanFilament;
        d(aBTag.name(), z16);
        BuglyABManager.a(aBTag.name(), z16);
        QLog.d("FeatureFlag", 1, "update filament config, ", Boolean.valueOf(z16));
    }
}
