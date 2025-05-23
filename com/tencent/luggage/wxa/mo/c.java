package com.tencent.luggage.wxa.mo;

import android.content.Context;
import android.view.LayoutInflater;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c implements d {

    /* renamed from: a, reason: collision with root package name */
    public static final c f134787a = new c();

    @Override // com.tencent.luggage.wxa.mo.d
    public LayoutInflater h(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater cloneInContext = LayoutInflater.from(com.tencent.luggage.wxa.tn.z.c()).cloneInContext(context);
        Intrinsics.checkNotNullExpressionValue(cloneInContext, "from(MMApplicationContex\u2026).cloneInContext(context)");
        return cloneInContext;
    }
}
