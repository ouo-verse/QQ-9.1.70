package com.tencent.luggage.wxa.r6;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class g extends com.tencent.luggage.wxa.dk.b {
    public final c C;
    public int D;

    /* renamed from: j, reason: collision with root package name */
    public final h f139352j;

    /* renamed from: k, reason: collision with root package name */
    public long f139353k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f139354l;

    /* renamed from: m, reason: collision with root package name */
    public com.tencent.luggage.wxa.c5.e f139355m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(String instanceId, com.tencent.luggage.wxa.j4.d initConfigLU, com.tencent.luggage.wxa.bk.e statObj) {
        super(instanceId, initConfigLU, statObj, 0L);
        Intrinsics.checkNotNullParameter(instanceId, "instanceId");
        Intrinsics.checkNotNullParameter(initConfigLU, "initConfigLU");
        Intrinsics.checkNotNullParameter(statObj, "statObj");
        this.f139352j = new h();
        this.C = new c();
    }

    public final void a(long j3) {
        this.f139353k = j3;
    }

    public final com.tencent.luggage.wxa.c5.e b() {
        com.tencent.luggage.wxa.c5.e eVar = this.f139355m;
        if (eVar != null) {
            return eVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("runtime");
        return null;
    }

    public final int c() {
        return this.D;
    }

    public final long d() {
        return this.f139353k;
    }

    public final h e() {
        return this.f139352j;
    }

    public final boolean f() {
        return this.f139354l;
    }

    public final void a(boolean z16) {
        this.f139354l = z16;
    }

    public final void a(com.tencent.luggage.wxa.c5.e eVar) {
        Intrinsics.checkNotNullParameter(eVar, "<set-?>");
        this.f139355m = eVar;
    }

    public final c a() {
        return this.C;
    }

    public final void a(int i3) {
        this.D = i3;
    }
}
