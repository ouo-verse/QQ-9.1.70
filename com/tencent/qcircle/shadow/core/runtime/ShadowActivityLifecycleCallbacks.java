package com.tencent.qcircle.shadow.core.runtime;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.tencent.qcircle.shadow.core.runtime.qcircle.container.PluginContainerActivity;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface ShadowActivityLifecycleCallbacks {

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class Wrapper implements Application.ActivityLifecycleCallbacks {
        final ShadowActivityLifecycleCallbacks shadowActivityLifecycleCallbacks;
        final ShadowApplication shadowApplication;

        public Wrapper(ShadowActivityLifecycleCallbacks shadowActivityLifecycleCallbacks, ShadowApplication shadowApplication) {
            this.shadowActivityLifecycleCallbacks = shadowActivityLifecycleCallbacks;
            this.shadowApplication = shadowApplication;
        }

        private boolean checkOwnerActivity(PluginActivity pluginActivity) {
            if (pluginActivity != null && pluginActivity.mPluginApplication == this.shadowApplication) {
                return true;
            }
            return false;
        }

        private ShadowActivity getPluginActivity(Activity activity) {
            if (activity instanceof PluginContainerActivity) {
                return (ShadowActivity) ((PluginContainerActivity) activity).getPluginActivity();
            }
            return null;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            ShadowActivity pluginActivity = getPluginActivity(activity);
            if (checkOwnerActivity(pluginActivity)) {
                this.shadowActivityLifecycleCallbacks.onActivityCreated(pluginActivity, bundle);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            ShadowActivity pluginActivity = getPluginActivity(activity);
            if (checkOwnerActivity(pluginActivity)) {
                this.shadowActivityLifecycleCallbacks.onActivityDestroyed(pluginActivity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            ShadowActivity pluginActivity = getPluginActivity(activity);
            if (checkOwnerActivity(pluginActivity)) {
                this.shadowActivityLifecycleCallbacks.onActivityPaused(pluginActivity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            ShadowActivity pluginActivity = getPluginActivity(activity);
            if (checkOwnerActivity(pluginActivity)) {
                this.shadowActivityLifecycleCallbacks.onActivityResumed(pluginActivity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            ShadowActivity pluginActivity = getPluginActivity(activity);
            if (checkOwnerActivity(pluginActivity)) {
                this.shadowActivityLifecycleCallbacks.onActivitySaveInstanceState(pluginActivity, bundle);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            ShadowActivity pluginActivity = getPluginActivity(activity);
            if (checkOwnerActivity(pluginActivity)) {
                this.shadowActivityLifecycleCallbacks.onActivityStarted(pluginActivity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            ShadowActivity pluginActivity = getPluginActivity(activity);
            if (checkOwnerActivity(pluginActivity)) {
                this.shadowActivityLifecycleCallbacks.onActivityStopped(pluginActivity);
            }
        }
    }

    void onActivityCreated(ShadowActivity shadowActivity, Bundle bundle);

    void onActivityDestroyed(ShadowActivity shadowActivity);

    void onActivityPaused(ShadowActivity shadowActivity);

    void onActivityResumed(ShadowActivity shadowActivity);

    void onActivitySaveInstanceState(ShadowActivity shadowActivity, Bundle bundle);

    void onActivityStarted(ShadowActivity shadowActivity);

    void onActivityStopped(ShadowActivity shadowActivity);
}
