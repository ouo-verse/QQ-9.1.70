package com.tencent.biz.pubaccount.weishi.config.experiment;

import UserGrowth.stGrayPolicyInfo;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes32.dex */
public class f {
    public static Map<String, String> b(d dVar, String str) {
        stGrayPolicyInfo a16 = a(dVar, str);
        if (a16 != null) {
            return a16.params;
        }
        return null;
    }

    public static String c(d dVar, String str, String str2) {
        Map<String, String> map;
        String str3;
        stGrayPolicyInfo a16 = a(dVar, str);
        return (a16 == null || (map = a16.params) == null || (str3 = map.get(str2)) == null) ? "" : str3;
    }

    private static stGrayPolicyInfo a(d dVar, String str) {
        if (dVar != null) {
            return dVar.c(str);
        }
        return null;
    }
}
