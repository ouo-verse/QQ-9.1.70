package com.tencent.luggage.wxa.x2;

import com.tencent.luggage.wxa.fd.n0;
import com.tencent.luggage.wxa.fd.o0;
import com.tencent.luggage.wxa.ic.t0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f144546a = new c();

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a implements t0.a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f144547a = new a();

        @Override // com.tencent.luggage.wxa.ic.t0.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.tencent.luggage.wxa.j4.g newInstance() {
            return new com.tencent.luggage.wxa.j4.g();
        }
    }

    public final com.tencent.luggage.wxa.j4.g a(f rt5) {
        com.tencent.luggage.wxa.j4.g a16;
        Intrinsics.checkNotNullParameter(rt5, "rt");
        n0 a17 = o0.a().a(rt5.getAppId(), new String[0]);
        if (a17 == null) {
            a16 = new com.tencent.luggage.wxa.j4.g();
        } else {
            a16 = t0.a(a.f144547a, a17);
        }
        Intrinsics.checkNotNullExpressionValue(a16, "if (null == attrs) {\n   \u2026()}, attrs)\n            }");
        if (a16.f130831g0 == null) {
            a16.f130831g0 = com.tencent.luggage.wxa.fd.h.f125726o0;
        }
        a16.f125966l = new com.tencent.mm.plugin.appbrand.appcache.a();
        a16.f125966l.f151861a = rt5.l0();
        a16.f125966l.pkgVersion = rt5.C1();
        a16.f125966l.f151863c = true;
        return a16;
    }
}
