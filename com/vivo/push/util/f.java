package com.vivo.push.util;

import android.text.TextUtils;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class f {
    public static boolean a(long j3, long j16) {
        u.d("ClientReportUtil", "report message: " + j3 + ", reportType: " + j16);
        com.vivo.push.b.x xVar = new com.vivo.push.b.x(j16);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(com.heytap.mcssdk.a.a.f36093c, String.valueOf(j3));
        String a16 = com.vivo.push.restructure.a.a().e().a();
        if (!TextUtils.isEmpty(a16)) {
            hashMap.put("remoteAppId", a16);
        }
        xVar.a(hashMap);
        com.vivo.push.m.a().a(xVar);
        return true;
    }

    public static boolean a(long j3, HashMap<String, String> hashMap) {
        com.vivo.push.b.x xVar = new com.vivo.push.b.x(j3);
        xVar.a(hashMap);
        xVar.d();
        com.vivo.push.m.a().a(xVar);
        return true;
    }
}
