package com.tencent.luggage.wxa.mc;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class r0 {

    /* renamed from: a, reason: collision with root package name */
    public final String f134362a;

    public r0(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        String a16 = com.tencent.mm.plugin.appbrand.appcache.a.a(name);
        Intrinsics.checkNotNull(a16);
        this.f134362a = a16;
    }

    public final String a() {
        return this.f134362a;
    }

    public boolean equals(Object obj) {
        r0 r0Var;
        String str = null;
        if (obj instanceof r0) {
            r0Var = (r0) obj;
        } else {
            r0Var = null;
        }
        if (r0Var != null) {
            str = r0Var.f134362a;
        }
        return Intrinsics.areEqual(str, this.f134362a);
    }

    public int hashCode() {
        return this.f134362a.hashCode();
    }
}
