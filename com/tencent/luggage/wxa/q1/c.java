package com.tencent.luggage.wxa.q1;

import android.content.Context;
import com.tencent.luggage.wxa.ei.j;
import com.tencent.luggage.wxa.ic.g;
import com.tencent.magicbrush.ui.a;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class c extends d {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context, j jsRuntime) {
        super(context, jsRuntime);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(jsRuntime, "jsRuntime");
    }

    @Override // com.tencent.luggage.wxa.q1.d
    public void a(com.tencent.magicbrush.c builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        super.a(builder);
        builder.c(true);
        builder.a(a.b.f147485b);
    }

    @Override // com.tencent.luggage.wxa.q1.d
    public void b(g runtime) {
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        com.tencent.luggage.wxa.s1.b.f139992e.a(d(), runtime, false);
    }
}
