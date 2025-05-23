package com.tencent.luggage.wxa.uk;

import android.app.Activity;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a0 implements r {

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.xd.d f142650a;

    public a0(com.tencent.luggage.wxa.xd.d component) {
        Intrinsics.checkNotNullParameter(component, "component");
        this.f142650a = component;
    }

    @Override // com.tencent.luggage.wxa.uk.r
    public Activity a() {
        return com.tencent.luggage.wxa.bo.a.a(this.f142650a.getContext());
    }
}
