package com.tencent.luggage.wxa.n3;

import com.tencent.luggage.wxa.hn.s8;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public com.tencent.luggage.wxa.bj.c f135162a;

    public abstract String a();

    public final void a(com.tencent.luggage.wxa.bj.c cVar) {
        this.f135162a = cVar;
    }

    public com.tencent.luggage.wxa.xo.d a(String str, s8 request, Class clazz) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        com.tencent.luggage.wxa.bj.c cVar = this.f135162a;
        if (cVar == null) {
            cVar = (com.tencent.luggage.wxa.bj.c) com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.bj.c.class);
        }
        com.tencent.luggage.wxa.xo.d b16 = cVar.b(a(), str, request, clazz);
        Intrinsics.checkNotNullExpressionValue(b16, "dispatcher ?: Luggage.cu\u2026L, appId, request, clazz)");
        return b16;
    }

    public final Object a(String str, s8 s8Var, Class cls, Continuation continuation) {
        com.tencent.luggage.wxa.bj.c cVar = this.f135162a;
        if (cVar == null) {
            cVar = (com.tencent.luggage.wxa.bj.c) com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.bj.c.class);
        }
        com.tencent.luggage.wxa.bj.c cVar2 = cVar;
        Intrinsics.checkNotNullExpressionValue(cVar2, "dispatcher ?: Luggage.cu\u2026(ICgiService::class.java)");
        return com.tencent.luggage.wxa.bj.b.a(cVar2, a(), str, s8Var, cls, continuation);
    }
}
