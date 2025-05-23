package com.tencent.luggage.wxa.ok;

import android.content.Context;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import com.tencent.luggage.wxa.f6.e;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class s implements com.tencent.luggage.wxa.mo.e {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements e.c {

        /* renamed from: a, reason: collision with root package name */
        public static final a f136641a = new a();

        @Override // com.tencent.luggage.wxa.f6.e.c
        public final DisplayMetrics a(DisplayMetrics originalMetrics, Configuration configuration) {
            Intrinsics.checkNotNullParameter(originalMetrics, "originalMetrics");
            Intrinsics.checkNotNullParameter(configuration, "<anonymous parameter 1>");
            return originalMetrics;
        }
    }

    @Override // com.tencent.luggage.wxa.mo.e
    public ContextThemeWrapper b(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        return new com.tencent.luggage.wxa.f6.e(ctx, a.f136641a);
    }
}
