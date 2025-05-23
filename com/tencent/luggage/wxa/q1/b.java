package com.tencent.luggage.wxa.q1;

import android.content.Context;
import com.tencent.luggage.wxa.ei.j;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b extends d {

    /* renamed from: f, reason: collision with root package name */
    public final boolean f137777f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context, j jsRuntime, boolean z16) {
        super(context, jsRuntime);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(jsRuntime, "jsRuntime");
        this.f137777f = z16;
    }

    @Override // com.tencent.luggage.wxa.q1.d
    public void a(com.tencent.magicbrush.c builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        super.a(builder);
        builder.c(false);
        builder.a(this.f137777f);
    }
}
