package com.tencent.luggage.wxa.p004if;

import android.content.Context;
import com.tencent.luggage.wxa.h1.e;
import com.tencent.luggage.wxa.ic.g;
import com.tencent.luggage.wxa.xd.m;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e0 implements q {

    /* renamed from: a, reason: collision with root package name */
    public static final e0 f130199a = new e0();

    @Override // com.tencent.luggage.wxa.p004if.q
    public p a(g runtime) {
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        p pVar = (p) runtime.c(p.class);
        if (pVar == null) {
            Context F = runtime.F();
            Intrinsics.checkNotNullExpressionValue(F, "runtime.appContext");
            c0 c0Var = new c0(F);
            runtime.a((m) c0Var);
            return c0Var;
        }
        return pVar;
    }

    public void b() {
        e.a(q.class, this);
    }
}
