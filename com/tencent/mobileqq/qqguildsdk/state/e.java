package com.tencent.mobileqq.qqguildsdk.state;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes17.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private final f f268478a;

    /* renamed from: b, reason: collision with root package name */
    private long f268479b = 60000;

    /* renamed from: c, reason: collision with root package name */
    private long f268480c = SystemClock.elapsedRealtime();

    /* renamed from: d, reason: collision with root package name */
    private final Application.ActivityLifecycleCallbacks f268481d;

    public e(f fVar) {
        this.f268478a = fVar;
        a aVar = new a();
        this.f268481d = aVar;
        BaseApplication.getContext().registerActivityLifecycleCallbacks(aVar);
    }

    public void a() {
        BaseApplication.getContext().unregisterActivityLifecycleCallbacks(this.f268481d);
    }

    public void b() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime < this.f268480c + this.f268479b) {
            return;
        }
        this.f268480c = elapsedRealtime;
        this.f268478a.k();
    }

    public void c(long j3) {
        this.f268479b = Math.max(60000L, j3);
        this.f268480c = SystemClock.elapsedRealtime();
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a implements Application.ActivityLifecycleCallbacks {
        a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            e.this.b();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }
    }
}
