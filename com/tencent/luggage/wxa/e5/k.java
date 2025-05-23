package com.tencent.luggage.wxa.e5;

import com.tencent.luggage.wxa.tn.f0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class k implements d {

    /* renamed from: a, reason: collision with root package name */
    public final String f124554a;

    public k(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.f124554a = name;
    }

    @Override // com.tencent.luggage.wxa.e5.d
    public f0 a() {
        f0 c16 = f0.c(this.f124554a, 2);
        Intrinsics.checkNotNullExpressionValue(c16, "getMMKV(name, MultiProcessMMKV.MULTI_PROCESS_MODE)");
        return c16;
    }
}
