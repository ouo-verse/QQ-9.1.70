package com.tencent.tgpa.lite.g;

import com.huawei.hms.framework.common.hianalytics.HianalyticsBaseData;
import com.tencent.tgpa.lite.g.b;
import com.tencent.tgpa.lite.g.c;
import com.tencent.tgpa.lite.gradish.GradishWrapper;
import com.tenpay.ndk.CftSoLoader;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes26.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private static String f375978a;

    private static String a() {
        String str = f375978a;
        if (str != null) {
            return str;
        }
        String str2 = c.a(c.a.f375972b.a()) + "_" + com.tencent.tgpa.lite.c.a.b();
        f375978a = str2;
        return str2;
    }

    private static void b(HashMap<String, String> hashMap) {
        hashMap.put("vmp_number", a());
        hashMap.put("package_name", String.valueOf(a.c()));
        hashMap.put("report_time", c.a(c.a.f375973c.a()));
        hashMap.put("version_code", String.valueOf(26));
        hashMap.put("version_name", CftSoLoader.VERSION_1_2_6);
        hashMap.put("unique_id3", GradishWrapper.getCommonUniqueID2WithFlag());
        hashMap.put("xid", com.tencent.tgpa.lite.c.a.b());
        hashMap.put("oaid", String.valueOf(com.tencent.tgpa.lite.c.a.a()));
        hashMap.put("manufacturer", d.e());
        hashMap.put("model", d.f());
        hashMap.put("device_name", d.d());
        hashMap.put(HianalyticsBaseData.SDK_TYPE, "simple");
        hashMap.put("tgpa_id", com.tencent.tgpa.lite.f.a.c());
    }

    public static void a(HashMap<String, String> hashMap) {
        b(hashMap);
        hashMap.put("flagL2", GradishWrapper.getL2IDFlag());
        hashMap.put("debug_id", GradishWrapper.getDebugID());
        b.a(com.tencent.tgpa.lite.b.b.f375909c, b.EnumC9913b.f375968b, hashMap);
    }
}
