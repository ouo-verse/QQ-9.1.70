package com.tencent.luggage.wxa.u5;

import com.tencent.luggage.wxa.a6.c;
import com.tencent.luggage.wxa.p5.d;
import com.tencent.luggage.wxa.p5.f;
import com.tencent.luggage.wxa.p5.h;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b implements h {
    @Override // com.tencent.luggage.wxa.p5.h
    public void a(f rt5) {
        Intrinsics.checkNotNullParameter(rt5, "rt");
        com.tencent.luggage.wxa.c2.a.a(rt5.getAppId()).a(rt5.getAppId(), rt5.Q1());
    }

    @Override // com.tencent.luggage.wxa.p5.h
    public d b(f rt5) {
        Intrinsics.checkNotNullParameter(rt5, "rt");
        return new d(rt5.L(), rt5, new com.tencent.luggage.wxa.z1.f());
    }

    @Override // com.tencent.luggage.wxa.p5.h
    public com.tencent.luggage.wxa.a6.a c(f rt5) {
        Intrinsics.checkNotNullParameter(rt5, "rt");
        return new com.tencent.luggage.wxa.a6.a((Class<? extends com.tencent.luggage.wxa.r4.f>) c.class);
    }
}
