package com.tencent.shadow.dynamic.host;

import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.shadow.core.common.Logger;
import com.tencent.shadow.core.common.LoggerFactory;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes25.dex */
public abstract class BasePluginProcessService extends Service {
    private static Object sSingleInstanceFlag;
    protected final Logger mLogger = LoggerFactory.getLogger(ShadowTag.class);

    @Override // android.app.Service
    public void onCreate() {
        if (sSingleInstanceFlag == null) {
            sSingleInstanceFlag = new Object();
            super.onCreate();
            if (this.mLogger.isInfoEnabled()) {
                this.mLogger.info("onCreate:" + this);
                return;
            }
            return;
        }
        throw new IllegalStateException("PPS\u51fa\u73b0\u591a\u5b9e\u4f8b");
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        if (this.mLogger.isInfoEnabled()) {
            this.mLogger.info("onDestroy:" + this);
        }
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        if (this.mLogger.isInfoEnabled()) {
            this.mLogger.info("onRebind:" + this);
        }
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
        if (this.mLogger.isInfoEnabled()) {
            this.mLogger.info("onTaskRemoved:" + this);
        }
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        if (this.mLogger.isInfoEnabled()) {
            this.mLogger.info("onUnbind:" + this);
        }
        return super.onUnbind(intent);
    }

    /* loaded from: classes25.dex */
    public static class ActivityHolder implements Application.ActivityLifecycleCallbacks {
        private List<Activity> mActivities = new LinkedList();

        /* JADX INFO: Access modifiers changed from: package-private */
        public void finishAll() {
            Iterator<Activity> it = this.mActivities.iterator();
            while (it.hasNext()) {
                it.next().finish();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            this.mActivities.add(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            this.mActivities.remove(activity);
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
