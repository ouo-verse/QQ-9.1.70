package com.tencent.luggage.wxa.n3;

import com.tencent.luggage.wxa.hn.s8;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a0 {
    public abstract int a();

    public final com.tencent.luggage.wxa.xo.d a(s8 request, Class respClazz) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(respClazz, "respClazz");
        return ((com.tencent.luggage.wxa.p3.d) com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.p3.d.class)).b(a(), b(), w.SHORT, request, respClazz);
    }

    public abstract String b();
}
