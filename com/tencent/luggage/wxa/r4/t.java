package com.tencent.luggage.wxa.r4;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public final String f139241a;

    /* renamed from: b, reason: collision with root package name */
    public final int f139242b;

    public t(String libName, int i3) {
        Intrinsics.checkNotNullParameter(libName, "libName");
        this.f139241a = libName;
        this.f139242b = i3;
    }

    public final String a() {
        return this.f139241a;
    }

    public final int b() {
        return this.f139242b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        if (Intrinsics.areEqual(this.f139241a, tVar.f139241a) && this.f139242b == tVar.f139242b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.f139241a.hashCode() * 31) + this.f139242b;
    }

    public String toString() {
        return "NativeLibMeta(libName=" + this.f139241a + ", minimumVersion=" + this.f139242b + ')';
    }
}
