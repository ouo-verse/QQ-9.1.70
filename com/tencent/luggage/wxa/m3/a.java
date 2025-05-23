package com.tencent.luggage.wxa.m3;

import com.tencent.luggage.wxa.bk.e;
import com.tencent.luggage.wxa.d6.b;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f134071a = new a();

    public static final com.tencent.luggage.wxa.ki.a a(b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        return a(bVar, null, 1, null);
    }

    public static /* synthetic */ com.tencent.luggage.wxa.ki.a a(b bVar, e eVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            eVar = null;
        }
        return a(bVar, eVar);
    }

    public static final com.tencent.luggage.wxa.ki.a a(b bVar, e eVar) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        com.tencent.luggage.wxa.ki.a aVar = new com.tencent.luggage.wxa.ki.a();
        aVar.f132018b = bVar.f124086d;
        aVar.f132026f = bVar.f124089g;
        long j3 = bVar.f124095m;
        if (j3 <= 0) {
            aVar.f132038l = System.currentTimeMillis();
            aVar.f132040m = f134071a.a();
        } else {
            aVar.f132038l = TimeUnit.NANOSECONDS.toMillis(j3);
            aVar.f132040m = bVar.f124095m;
        }
        aVar.f132022d = bVar.f124090h;
        aVar.F = bVar.f124100r;
        if (eVar != null) {
            aVar.f132032i = eVar;
        }
        aVar.S = bVar.f124104v;
        return aVar;
    }

    public final long a() {
        return TimeUnit.MILLISECONDS.toNanos(System.currentTimeMillis()) + (System.nanoTime() % 1000000);
    }
}
