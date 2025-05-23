package com.tencent.luggage.wxa.bi;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.md.c f122766a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f122767b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f122768c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f122769d;

    public e(com.tencent.luggage.wxa.md.c mrDevice) {
        Intrinsics.checkNotNullParameter(mrDevice, "mrDevice");
        this.f122766a = mrDevice;
    }

    public final com.tencent.luggage.wxa.md.c a() {
        return this.f122766a;
    }

    public final boolean b() {
        return this.f122768c;
    }

    public final void c(boolean z16) {
        this.f122767b = z16;
    }

    public final boolean d() {
        return this.f122767b;
    }

    public boolean equals(Object obj) {
        Class<?> cls;
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            cls = obj.getClass();
        } else {
            cls = null;
        }
        if (!Intrinsics.areEqual(e.class, cls)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.xwebplugin.video.cast.MRDeviceWithStatus");
        if (Intrinsics.areEqual(this.f122766a, ((e) obj).f122766a)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f122766a.hashCode();
    }

    public String toString() {
        return "MRDeviceWithStatus(mrDevice=" + this.f122766a + ", isSelected=" + this.f122767b + ", isConnectSuccess=" + this.f122768c + ", isConnecting=" + this.f122769d + ')';
    }

    public final void a(boolean z16) {
        this.f122768c = z16;
    }

    public final void b(boolean z16) {
        this.f122769d = z16;
    }

    public final boolean c() {
        return this.f122769d;
    }
}
