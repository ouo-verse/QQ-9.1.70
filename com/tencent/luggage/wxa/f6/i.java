package com.tencent.luggage.wxa.f6;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.luggage.wxa.kj.i1;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class i extends i1.a {

    /* renamed from: a, reason: collision with root package name */
    public final Class[] f125397a = {com.tencent.luggage.wxa.lj.c.class, com.tencent.luggage.wxa.kl.d.class, com.tencent.luggage.wxa.ok.c.class};

    public final j a(Context context) {
        if (context instanceof j) {
            return (j) context;
        }
        Activity a16 = com.tencent.luggage.wxa.bo.a.a(context);
        if (a16 != null) {
            context = a16;
        }
        j a17 = j.a(context);
        Intrinsics.checkNotNullExpressionValue(a17, "{\n            WxaRuntime\u2026(this) ?: this)\n        }");
        return a17;
    }

    @Override // com.tencent.luggage.wxa.kj.i1.a, com.tencent.luggage.wxa.kj.i1
    public View b(Context context, Class clazz) {
        boolean contains;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        contains = ArraysKt___ArraysKt.contains(this.f125397a, clazz);
        if (contains) {
            return super.b(a(context), clazz);
        }
        return super.b(context, clazz);
    }
}
