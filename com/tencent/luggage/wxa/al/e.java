package com.tencent.luggage.wxa.al;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e extends com.tencent.luggage.wxa.eh.c {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.tencent.luggage.wxa.eh.c
    public com.tencent.luggage.wxa.eh.d b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.G = 2;
        return new d(context);
    }
}
