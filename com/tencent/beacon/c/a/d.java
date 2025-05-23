package com.tencent.beacon.c.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.tencent.beacon.module.StatModule;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
@TargetApi(14)
/* loaded from: classes2.dex */
public class d implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a, reason: collision with root package name */
    private long f77804a = System.currentTimeMillis();

    /* renamed from: b, reason: collision with root package name */
    private Map<Activity, Long> f77805b = new HashMap(3);

    /* renamed from: c, reason: collision with root package name */
    private StatModule f77806c;

    public d(StatModule statModule) {
        this.f77806c = statModule;
    }

    private void a(Activity activity) {
        Long l3 = this.f77805b.get(activity);
        if (l3 == null) {
            l3 = Long.valueOf(this.f77804a);
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.f77806c.b(activity.getLocalClassName(), currentTimeMillis - l3.longValue(), currentTimeMillis);
        this.f77805b.remove(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        a(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        this.f77805b.put(activity, Long.valueOf(System.currentTimeMillis()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
