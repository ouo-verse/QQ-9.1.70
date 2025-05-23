package com.tencent.luggage.wxa.uk;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f142716a = new h();

    public static final u a(com.tencent.luggage.wxa.xd.d component) {
        u uVar;
        Intrinsics.checkNotNullParameter(component, "component");
        synchronized (f142716a) {
            uVar = (u) component.c(u.class);
            if (uVar == null) {
                uVar = new k0();
                component.a(uVar);
            }
        }
        return uVar;
    }
}
