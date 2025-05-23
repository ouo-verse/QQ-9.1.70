package com.tencent.ad.tangram.app.tracer;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.tencent.ad.tangram.log.AdLog;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes3.dex */
public final class AdAppLaunchTracerActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
    private static final String TAG = "AdAppLaunchTracerActivityLifecycleCallbacks";
    private final WeakReference<Activity> mWeakActivity;

    public AdAppLaunchTracerActivityLifecycleCallbacks(WeakReference<Activity> weakReference) {
        this.mWeakActivity = weakReference;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Activity activity2;
        if (activity == null) {
            AdLog.e(TAG, "[onActivityCreated] error, activity is null");
            return;
        }
        WeakReference<Activity> weakReference = this.mWeakActivity;
        if (weakReference != null) {
            activity2 = weakReference.get();
        } else {
            activity2 = null;
        }
        if (activity2 == null) {
            AdLog.i(TAG, "[onActivityCreated] do nothing, thisActivity is null");
            return;
        }
        if (activity != activity2) {
            AdLog.i(TAG, "[onActivityCreated] do nothing, not the specific activity");
            return;
        }
        AdLog.i(TAG, "[onActivityCreated] activity:" + activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Activity activity2;
        if (activity == null) {
            AdLog.e(TAG, "[onActivityDestroyed] error, activity is null");
            return;
        }
        WeakReference<Activity> weakReference = this.mWeakActivity;
        if (weakReference != null) {
            activity2 = weakReference.get();
        } else {
            activity2 = null;
        }
        if (activity2 == null) {
            AdLog.i(TAG, "[onActivityDestroyed] do nothing, thisActivity is null");
            return;
        }
        if (activity != activity2) {
            AdLog.i(TAG, "[onActivityDestroyed] do nothing, not the specific activity");
            return;
        }
        AdLog.i(TAG, "[onActivityDestroyed] activity:" + activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Activity activity2;
        if (activity == null) {
            AdLog.e(TAG, "[onActivityPaused] error, activity is null");
            return;
        }
        WeakReference<Activity> weakReference = this.mWeakActivity;
        if (weakReference != null) {
            activity2 = weakReference.get();
        } else {
            activity2 = null;
        }
        if (activity2 == null) {
            AdLog.i(TAG, "[onActivityPaused] do nothing, thisActivity is null");
            return;
        }
        if (activity != activity2) {
            AdLog.i(TAG, "[onActivityPaused] do nothing, not the specific activity");
            return;
        }
        AdLog.i(TAG, "[onActivityPaused] activity:" + activity);
        AdAppLaunchTracer.getInstance().onActivityPaused();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Activity activity2;
        if (activity == null) {
            AdLog.e(TAG, "[onActivityResumed] error, activity is null");
            return;
        }
        WeakReference<Activity> weakReference = this.mWeakActivity;
        if (weakReference != null) {
            activity2 = weakReference.get();
        } else {
            activity2 = null;
        }
        if (activity2 == null) {
            AdLog.i(TAG, "[onActivityResumed] do nothing, thisActivity is null");
            return;
        }
        if (activity != activity2) {
            AdLog.i(TAG, "[onActivityResumed] do nothing, not the specific activity");
            return;
        }
        AdLog.i(TAG, "[onActivityResumed] activity:" + activity);
        AdAppLaunchTracer.getInstance().onActivityResumed();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Activity activity2;
        if (activity == null) {
            AdLog.e(TAG, "[onActivitySaveInstanceState] error, activity is null");
            return;
        }
        WeakReference<Activity> weakReference = this.mWeakActivity;
        if (weakReference != null) {
            activity2 = weakReference.get();
        } else {
            activity2 = null;
        }
        if (activity2 == null) {
            AdLog.i(TAG, "[onActivitySaveInstanceState] do nothing, thisActivity is null");
            return;
        }
        if (activity != activity2) {
            AdLog.i(TAG, "[onActivitySaveInstanceState] do nothing, not the specific activity");
            return;
        }
        try {
            AdLog.i(TAG, "[onActivitySaveInstanceState] activity:" + activity + " bundle:" + bundle);
        } catch (Throwable th5) {
            AdLog.e(TAG, "[onActivitySaveInstanceState] activity:" + activity, th5);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Activity activity2;
        if (activity == null) {
            AdLog.e(TAG, "[onActivityStarted] error, activity is null");
            return;
        }
        WeakReference<Activity> weakReference = this.mWeakActivity;
        if (weakReference != null) {
            activity2 = weakReference.get();
        } else {
            activity2 = null;
        }
        if (activity2 == null) {
            AdLog.i(TAG, "[onActivityStarted] do nothing, thisActivity is null");
            return;
        }
        if (activity != activity2) {
            AdLog.i(TAG, "[onActivityStarted] do nothing, not the specific activity");
            return;
        }
        AdLog.i(TAG, "[onActivityStarted] activity:" + activity);
        AdAppLaunchTracer.getInstance().onActivityStarted();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Activity activity2;
        if (activity == null) {
            AdLog.e(TAG, "[onActivityStopped] error, activity is null");
            return;
        }
        WeakReference<Activity> weakReference = this.mWeakActivity;
        if (weakReference != null) {
            activity2 = weakReference.get();
        } else {
            activity2 = null;
        }
        if (activity2 == null) {
            AdLog.i(TAG, "[onActivityStopped] do nothing, thisActivity is null");
            return;
        }
        if (activity != activity2) {
            AdLog.i(TAG, "[onActivityStopped] do nothing, not the specific activity");
            return;
        }
        AdLog.i(TAG, "[onActivityStopped] activity:" + activity);
        AdAppLaunchTracer.getInstance().onActivityStopped();
    }
}
