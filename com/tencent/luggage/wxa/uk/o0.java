package com.tencent.luggage.wxa.uk;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class o0 implements LifecycleOwner, com.tencent.luggage.wxa.vo.a {

    /* renamed from: a, reason: collision with root package name */
    public final String f142771a;

    /* renamed from: b, reason: collision with root package name */
    public final LifecycleRegistry f142772b;

    public o0(int i3, com.tencent.luggage.wxa.vo.c lifecycleKeeper) {
        Intrinsics.checkNotNullParameter(lifecycleKeeper, "lifecycleKeeper");
        this.f142771a = "MicroMsg.VendingLifecycleAdapter#" + i3;
        LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);
        this.f142772b = lifecycleRegistry;
        lifecycleKeeper.b(this);
        lifecycleRegistry.setCurrentState(Lifecycle.State.CREATED);
    }

    @Override // androidx.lifecycle.LifecycleOwner
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public LifecycleRegistry getLifecycle() {
        return this.f142772b;
    }

    @Override // com.tencent.luggage.wxa.vo.a
    public void g() {
        com.tencent.luggage.wxa.tn.w.d(this.f142771a, "dead");
        this.f142772b.setCurrentState(Lifecycle.State.DESTROYED);
    }
}
