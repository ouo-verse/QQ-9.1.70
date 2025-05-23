package com.tencent.luggage.wxa.tc;

import com.tencent.luggage.wxa.fd.o0;
import com.tencent.luggage.wxa.tn.w0;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e extends com.tencent.luggage.wxa.xn.c implements j {

    /* renamed from: g, reason: collision with root package name */
    public static final String[] f141221g = {com.tencent.luggage.wxa.xn.c.a(d.J, "AppBrandBackgroundFetchData")};

    public e(com.tencent.luggage.wxa.xn.b bVar) {
        super(bVar, d.J, "AppBrandBackgroundFetchData", null);
    }

    @Override // com.tencent.luggage.wxa.tc.j
    public boolean a(String str, int i3, String str2, String str3, String str4, int i16, long j3) {
        if (w0.c(str)) {
            return true;
        }
        d dVar = new d();
        dVar.f138256b = str;
        dVar.f138258d = i3;
        dVar.f138268n = str2;
        dVar.f138262h = str3;
        dVar.f138264j = str4;
        dVar.f138266l = i16;
        dVar.f138260f = j3;
        if (f(str, i3) == null) {
            return super.a(dVar);
        }
        return super.c(dVar, "username", "fetchType");
    }

    @Override // com.tencent.luggage.wxa.tc.j
    public c c(String str, int i3) {
        if (w0.c(str)) {
            return null;
        }
        return e(o0.a().b(str), i3);
    }

    public c e(String str, int i3) {
        if (w0.c(str)) {
            return null;
        }
        d dVar = new d();
        dVar.f138256b = str;
        dVar.f138258d = i3;
        if (!super.b(dVar, "username", "fetchType")) {
            return null;
        }
        c cVar = new c();
        a(dVar, cVar);
        return cVar;
    }

    public final d f(String str, int i3) {
        if (w0.c(str)) {
            return null;
        }
        d dVar = new d();
        dVar.f138256b = str;
        dVar.f138258d = i3;
        if (!super.b(dVar, "username", "fetchType")) {
            return null;
        }
        return dVar;
    }

    public static void a(d dVar, c cVar) {
        cVar.f141214a = dVar.f138256b;
        cVar.f141215b = dVar.f138258d;
        cVar.f141216c = dVar.f138262h;
        cVar.f141217d = dVar.f138264j;
        cVar.f141218e = dVar.f138268n;
        cVar.f141219f = dVar.f138266l;
        cVar.f141220g = dVar.f138260f;
    }
}
