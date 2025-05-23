package com.qq.e.comm.plugin.tangramsplash.report;

import android.text.TextUtils;
import com.qq.e.comm.plugin.base.ad.model.r;
import com.qq.e.comm.plugin.g.a.g;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b {
    public static void a(String str, String str2, boolean z16, long j3) {
        String str3 = z16 ? "yes" : "no";
        com.qq.e.comm.plugin.g.a.c.a(70001L, g.a("posId", str), g.a("displayCode", str2), g.a("unzipResult", str3));
        if (j3 > 0) {
            com.qq.e.comm.plugin.g.a.c.a(70002L, j3, g.a("posId", str), g.a("displayCode", str2), g.a("unzipResult", str3));
        }
    }

    public static String b(r rVar) {
        if (rVar == null) {
            return "unknown";
        }
        String bP = rVar.bP();
        if (TextUtils.isEmpty(bP)) {
            return "unknown";
        }
        return bP;
    }

    public static String a(r rVar) {
        if (rVar == null) {
            return "unknown";
        }
        String s16 = rVar.s();
        return TextUtils.isEmpty(s16) ? "unknown" : s16;
    }
}
