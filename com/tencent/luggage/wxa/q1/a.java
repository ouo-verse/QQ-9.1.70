package com.tencent.luggage.wxa.q1;

import com.tencent.luggage.wxa.ei.q;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a implements com.tencent.luggage.wxa.r8.a {

    /* renamed from: a, reason: collision with root package name */
    public final q f137776a;

    public a(q impl) {
        Intrinsics.checkNotNullParameter(impl, "impl");
        this.f137776a = impl;
    }

    @Override // com.tencent.luggage.wxa.r8.a
    public void a(Runnable r16, boolean z16) {
        Intrinsics.checkNotNullParameter(r16, "r");
        this.f137776a.a(r16, z16);
    }

    @Override // com.tencent.luggage.wxa.r8.a
    public void b() {
        this.f137776a.b();
    }

    @Override // com.tencent.luggage.wxa.r8.a
    public boolean c() {
        return this.f137776a.c();
    }

    @Override // com.tencent.luggage.wxa.r8.a
    public String d() {
        return this.f137776a.d();
    }

    @Override // com.tencent.luggage.wxa.r8.a
    public boolean g() {
        return this.f137776a.g();
    }
}
