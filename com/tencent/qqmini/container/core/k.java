package com.tencent.qqmini.container.core;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes23.dex */
public class k {

    /* renamed from: c, reason: collision with root package name */
    public static k f346122c;

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<Activity> f346123a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f346124b = false;

    k() {
    }

    public static synchronized k d() {
        k kVar;
        synchronized (k.class) {
            if (f346122c == null) {
                f346122c = new k();
            }
            kVar = f346122c;
        }
        return kVar;
    }

    public void b(Context context) {
        if (this.f346124b) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        if (!(applicationContext instanceof Application)) {
            return;
        }
        this.f346124b = true;
        ((Application) applicationContext).registerActivityLifecycleCallbacks(new a());
    }

    public Activity c() {
        WeakReference<Activity> weakReference = this.f346123a;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public void e(Activity activity) {
        if (this.f346123a == null && activity != null) {
            this.f346123a = new WeakReference<>(activity);
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    class a implements Application.ActivityLifecycleCallbacks {
        a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(@NonNull Activity activity) {
            k.this.f346123a = new WeakReference(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(@NonNull Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(@NonNull Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(@NonNull Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@NonNull Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
        }
    }
}
