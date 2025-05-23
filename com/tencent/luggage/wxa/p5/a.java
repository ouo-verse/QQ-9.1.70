package com.tencent.luggage.wxa.p5;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a extends com.tencent.luggage.wxa.ic.f {

    /* renamed from: f, reason: collision with root package name */
    public final f f137260f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(f runtime, com.tencent.luggage.wxa.ok.c splash) {
        super(runtime, splash);
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        Intrinsics.checkNotNullParameter(splash, "splash");
        this.f137260f = runtime;
    }

    @Override // com.tencent.luggage.wxa.ic.f
    public boolean a() {
        return this.f137260f.d2();
    }
}
