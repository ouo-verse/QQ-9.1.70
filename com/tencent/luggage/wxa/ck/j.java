package com.tencent.luggage.wxa.ck;

import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;
import java.net.URLEncoder;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f123649a = new ConcurrentHashMap();

    public static void a(String str, String str2, String str3, String str4, long j3, long j16, int i3, int i16, int i17, String str5, String str6) {
        if (w0.c(str)) {
            w.b("MicroMsg.AppBrand.Report.kv_14510", "kv_14510 report fail, appId is null, functionName:%s method:%s url:%s", str2, str3, str4);
            return;
        }
        com.tencent.luggage.wxa.c5.e eVar = (com.tencent.luggage.wxa.c5.e) f123649a.get(str);
        if (eVar == null || eVar.S() == null || eVar.j0() == null) {
            return;
        }
        com.tencent.luggage.wxa.j4.d S = eVar.S();
        com.tencent.luggage.wxa.j4.g j06 = eVar.j0();
        if (j06 != null) {
            String encode = URLEncoder.encode(str4);
            int i18 = j06.f125966l.pkgVersion;
            int a16 = j06.a() + 1;
            String a17 = com.tencent.luggage.wxa.bk.k.a(z.c());
            int i19 = S.I + 1000;
            com.tencent.luggage.wxa.zj.d dVar = (com.tencent.luggage.wxa.zj.d) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.d.class);
            if (dVar == null) {
                return;
            }
            dVar.a(14510, str, Integer.valueOf(i18), Integer.valueOf(a16), a17, str2, encode, str3, Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), str5, str6, Integer.valueOf(i19));
            a(str, i18, a16, i19, a17, str2, encode, str3, j3, j16, i3, i16, i17, str5, str6);
            return;
        }
        w.h("MicroMsg.AppBrand.Report.kv_14510", "kv_14510 report config is null. %s", str);
    }

    public static void a(String str, int i3, int i16, int i17, String str2, String str3, String str4, String str5, long j3, long j16, int i18, int i19, int i26, String str6, String str7) {
        if (w.d() > 1) {
            return;
        }
        w.a("MicroMsg.AppBrand.Report.kv_14510", "report kv_14510{appId='" + str + "', appVersion=" + i3 + ", appState=" + i16 + ", appType=" + i17 + ", networkType='" + str2 + "', functionName='" + str3 + "', url='" + str4 + "', method='" + str5 + "', sentsize=" + j3 + ", receivedsize=" + j16 + ", statusCode=" + i18 + ", result=" + i19 + ", costtime=" + i26 + ", dstPath=" + str6 + ", contentType=" + str7 + '}');
    }
}
