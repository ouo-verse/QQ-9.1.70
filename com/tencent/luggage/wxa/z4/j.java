package com.tencent.luggage.wxa.z4;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.fd.i f146321a;

    /* renamed from: b, reason: collision with root package name */
    public final String f146322b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f146323c;

    /* renamed from: d, reason: collision with root package name */
    public final int f146324d;

    public j(com.tencent.luggage.wxa.fd.i cfg, String appId, boolean z16, int i3) {
        Intrinsics.checkNotNullParameter(cfg, "cfg");
        Intrinsics.checkNotNullParameter(appId, "appId");
        this.f146321a = cfg;
        this.f146322b = appId;
        this.f146323c = z16;
        this.f146324d = i3;
    }

    public abstract String a();

    public abstract com.tencent.luggage.wxa.fd.i b();

    public abstract String c();

    public abstract int d();

    public abstract boolean e();
}
