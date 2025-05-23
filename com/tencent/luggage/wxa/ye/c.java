package com.tencent.luggage.wxa.ye;

import android.app.Application;
import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f145567a = new c();

    public static final Context a(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        if (context instanceof Application) {
            return context;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            return applicationContext;
        }
        return context;
    }
}
