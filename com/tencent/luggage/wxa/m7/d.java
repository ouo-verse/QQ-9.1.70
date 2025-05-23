package com.tencent.luggage.wxa.m7;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class d implements com.tencent.luggage.wxa.vi.b {
    @Override // com.tencent.luggage.wxa.vi.b
    public String a(Context context, com.tencent.luggage.wxa.m4.b pageView, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pageView, "pageView");
        return "Test Java Crash";
    }

    @Override // com.tencent.luggage.wxa.vi.b
    public boolean c(Context context, com.tencent.luggage.wxa.m4.b pageView, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pageView, "pageView");
        return true;
    }

    @Override // com.tencent.luggage.wxa.vi.b
    public void b(Context context, com.tencent.luggage.wxa.m4.b pageView, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pageView, "pageView");
        throw new IllegalAccessException("Test Java Crash");
    }
}
