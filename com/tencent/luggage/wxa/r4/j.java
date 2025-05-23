package com.tencent.luggage.wxa.r4;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class j implements i {

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.ei.t f139213a;

    /* renamed from: b, reason: collision with root package name */
    public final com.tencent.luggage.wxa.ei.h f139214b;

    public j(com.tencent.luggage.wxa.ei.t contextManager) {
        Intrinsics.checkNotNullParameter(contextManager, "contextManager");
        this.f139213a = contextManager;
        this.f139214b = contextManager.o();
    }

    @Override // com.tencent.luggage.wxa.r4.i
    public void a() {
        this.f139213a.s().a(this.f139214b, "WeixinJSContext");
    }

    @Override // com.tencent.luggage.wxa.r4.i
    public void a(com.tencent.luggage.wxa.ei.h context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f139214b.a(context, "WeixinJSContext");
    }
}
