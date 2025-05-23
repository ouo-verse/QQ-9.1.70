package com.tencent.luggage.wxa.p7;

import com.tencent.luggage.wxa.hn.fa;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f137383a = new f();

    public final boolean a(d dVar) {
        if (dVar == null) {
            return false;
        }
        String a16 = dVar.a();
        int b16 = dVar.b();
        if (a16 == null || !((Boolean) k.f137393c.h().invoke(a16, Integer.valueOf(b16))).booleanValue()) {
            return false;
        }
        a aVar = a.f137370b;
        fa faVar = new fa();
        faVar.f127628d = a16;
        faVar.f127629e = b16;
        aVar.a(a.a(faVar));
        return true;
    }
}
