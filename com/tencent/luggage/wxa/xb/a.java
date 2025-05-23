package com.tencent.luggage.wxa.xb;

import com.tencent.luggage.wxa.ka.i;
import com.tencent.luggage.wxa.ka.o;
import com.tencent.luggage.wxa.tn.a1;
import com.tencent.luggage.wxa.va.e;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f144656a = new a();

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.xb.a$a, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class C6903a implements i {

        /* renamed from: a, reason: collision with root package name */
        public static final C6903a f144657a = new C6903a();

        @Override // com.tencent.luggage.wxa.ka.i
        public final void a(e eVar) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class b implements i {

        /* renamed from: a, reason: collision with root package name */
        public static final b f144658a = new b();

        @Override // com.tencent.luggage.wxa.ka.i
        public final void a(e eVar) {
        }
    }

    public final long a(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        long nanoTime = System.nanoTime();
        o.a(a1.f141525b, new com.tencent.luggage.wxa.xb.b(nanoTime, url, 0), c.class, C6903a.f144657a);
        return nanoTime;
    }

    public final void a(long j3) {
        o.a(a1.f141525b, new com.tencent.luggage.wxa.xb.b(j3, "", 1), c.class, b.f144658a);
    }
}
