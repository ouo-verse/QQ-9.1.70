package com.tencent.luggage.wxa.hg;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.r4.d f127137a;

    /* renamed from: b, reason: collision with root package name */
    public final JSONObject f127138b;

    public l(com.tencent.luggage.wxa.r4.d env, JSONObject paramsPack) {
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(paramsPack, "paramsPack");
        this.f127137a = env;
        this.f127138b = paramsPack;
    }

    public final com.tencent.luggage.wxa.r4.d a() {
        return this.f127137a;
    }

    public final JSONObject b() {
        return this.f127138b;
    }
}
