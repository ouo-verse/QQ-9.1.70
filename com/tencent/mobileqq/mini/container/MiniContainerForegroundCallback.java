package com.tencent.mobileqq.mini.container;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.mini.api.IMiniContainer;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QActivityLifecycleCallbacks;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniContainerForegroundCallback implements QActivityLifecycleCallbacks {
    private static final String TAG = "MiniContainerForegroundCallback";

    @Override // mqq.app.QActivityLifecycleCallbacks
    public void onProcessForeground() {
        try {
            ((IMiniContainer) QRoute.api(IMiniContainer.class)).checkUpdate();
        } catch (OutOfMemoryError unused) {
            QLog.e(TAG, 1, "checkUpdate but OOM, abort");
        }
    }

    @Override // mqq.app.QActivityLifecycleCallbacks
    public void onProcessBackground() {
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
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
