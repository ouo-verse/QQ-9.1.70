package com.tencent.luggage.wxa.mc;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class s0 {

    /* renamed from: a, reason: collision with root package name */
    public final String f134363a;

    public s0(String provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        this.f134363a = provider;
    }

    public boolean equals(Object obj) {
        s0 s0Var;
        String str = null;
        if (obj instanceof s0) {
            s0Var = (s0) obj;
        } else {
            s0Var = null;
        }
        if (s0Var != null) {
            str = s0Var.f134363a;
        }
        return Intrinsics.areEqual(str, this.f134363a);
    }

    public int hashCode() {
        return this.f134363a.hashCode();
    }

    public String toString() {
        return "PLUGIN(provider=" + this.f134363a + ')';
    }
}
