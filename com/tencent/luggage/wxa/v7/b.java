package com.tencent.luggage.wxa.v7;

import android.content.Context;
import android.util.Log;
import com.tencent.luggage.wxa.tn.w;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b implements e {

    /* renamed from: a, reason: collision with root package name */
    public static final b f143291a = new b();

    @Override // com.tencent.luggage.wxa.v7.e
    public void a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Log.w("DummyProcessStartup", "initialize: useless startup:" + Log.getStackTraceString(new Throwable()));
        w.f("DummyProcessStartup", "initialize: useless startup:" + Log.getStackTraceString(new Throwable()));
    }
}
