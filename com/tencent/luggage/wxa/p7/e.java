package com.tencent.luggage.wxa.p7;

import com.tencent.luggage.wxa.fd.n0;
import com.tencent.luggage.wxa.fd.o0;
import com.tencent.luggage.wxa.hn.fa;
import com.tencent.luggage.wxa.mc.e;
import com.tencent.luggage.wxa.tn.w0;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f137382a = new e();

    public final int a(d dVar) {
        if (dVar == null) {
            return -1;
        }
        String a16 = dVar.a();
        int b16 = dVar.b();
        if (a16 == null || a16.length() == 0) {
            return -1;
        }
        if (e.a.b(b16) && a(a16)) {
            return -3;
        }
        k kVar = k.f137393c;
        int intValue = ((Number) kVar.j().invoke()).intValue();
        if (intValue == -1) {
            return -1;
        }
        if (intValue == 50) {
            return -2;
        }
        kVar.d().invoke(a16, Integer.valueOf(b16));
        a aVar = a.f137370b;
        fa faVar = new fa();
        faVar.f127628d = a16;
        faVar.f127629e = b16;
        aVar.a(a.a(faVar, null, null, 6, null));
        return 0;
    }

    public final boolean a(String str) {
        n0 b16 = o0.a().b(str, "appInfo");
        String str2 = b16 != null ? b16.f138487z : null;
        if (str2 == null || str2.length() == 0) {
            return false;
        }
        return w0.d() < b16.f().f125865c;
    }
}
