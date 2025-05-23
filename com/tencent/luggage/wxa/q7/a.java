package com.tencent.luggage.wxa.q7;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f137866a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static boolean f137867b;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f137868c;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.q7.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6620a extends com.tencent.luggage.wxa.tk.a {
        @Override // com.tencent.luggage.wxa.tk.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            a.f137866a.a(true);
        }
    }

    public final boolean a() {
        return f137868c;
    }

    public final boolean b() {
        return f137867b;
    }

    public final void a(boolean z16) {
        f137868c = z16;
    }

    public final void a(Context context) {
        Application application;
        if (context instanceof Application) {
            application = (Application) context;
        } else {
            Context applicationContext = context != null ? context.getApplicationContext() : null;
            application = applicationContext instanceof Application ? (Application) applicationContext : null;
        }
        if (application == null) {
            Log.e("Luggage.ActivityGuard", "startMonitor try get application failed");
        } else {
            application.registerActivityLifecycleCallbacks(new C6620a());
            f137867b = true;
        }
    }
}
