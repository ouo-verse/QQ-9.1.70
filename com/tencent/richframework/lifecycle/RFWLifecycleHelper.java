package com.tencent.richframework.lifecycle;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.richframework.thread.RFWThreadManager;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes25.dex */
public class RFWLifecycleHelper {
    private static volatile RFWLifecycleHelper sInstance;
    private Application mHostApplication;
    private Handler mScheduledHandler;
    private volatile boolean mIsRunningInCurrentApp = true;
    public final AtomicInteger mStartStateActivityCount = new AtomicInteger(0);
    private final Set<IProcessStateChangeCallback> mProcessStateChangeListeners = Collections.synchronizedSet(new HashSet());
    private final Set<Application.ActivityLifecycleCallbacks> mActivityLifecycleCallbacks = Collections.synchronizedSet(new HashSet());
    private final List<WeakReference<Activity>> mResumeActivities = Collections.synchronizedList(new LinkedList());
    private final AtomicBoolean mNotifyScheduled = new AtomicBoolean(false);
    private final Object mScheduledToken = new Object();
    private final Handler mUIHandler = new Handler(Looper.getMainLooper());

    /* compiled from: P */
    /* loaded from: classes25.dex */
    private class InnerLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
        InnerLifecycleCallbacks() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
            synchronized (RFWLifecycleHelper.this.mActivityLifecycleCallbacks) {
                Iterator it = RFWLifecycleHelper.this.mActivityLifecycleCallbacks.iterator();
                while (it.hasNext()) {
                    ((Application.ActivityLifecycleCallbacks) it.next()).onActivityCreated(activity, bundle);
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(@NonNull Activity activity) {
            RFWLog.i("RFWLifecycleHelper", RFWLog.USR, "onActivityDestroyed:" + activity);
            synchronized (RFWLifecycleHelper.this.mActivityLifecycleCallbacks) {
                Iterator it = RFWLifecycleHelper.this.mActivityLifecycleCallbacks.iterator();
                while (it.hasNext()) {
                    ((Application.ActivityLifecycleCallbacks) it.next()).onActivityDestroyed(activity);
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(@NonNull Activity activity) {
            RFWLog.i("RFWLifecycleHelper", RFWLog.USR, "onActivityPaused:" + activity);
            synchronized (RFWLifecycleHelper.this.mResumeActivities) {
                Iterator it = RFWLifecycleHelper.this.mResumeActivities.iterator();
                while (it.hasNext()) {
                    if (((WeakReference) it.next()).get() == activity) {
                        it.remove();
                    }
                }
            }
            synchronized (RFWLifecycleHelper.this.mActivityLifecycleCallbacks) {
                Iterator it5 = RFWLifecycleHelper.this.mActivityLifecycleCallbacks.iterator();
                while (it5.hasNext()) {
                    ((Application.ActivityLifecycleCallbacks) it5.next()).onActivityPaused(activity);
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(@NonNull Activity activity) {
            RFWLifecycleHelper.this.mResumeActivities.add(new WeakReference(activity));
            RFWLog.d("RFWLifecycleHelper", RFWLog.USR, "onActivityResumed:" + activity);
            synchronized (RFWLifecycleHelper.this.mActivityLifecycleCallbacks) {
                Iterator it = RFWLifecycleHelper.this.mActivityLifecycleCallbacks.iterator();
                while (it.hasNext()) {
                    ((Application.ActivityLifecycleCallbacks) it.next()).onActivityResumed(activity);
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
            synchronized (RFWLifecycleHelper.this.mActivityLifecycleCallbacks) {
                Iterator it = RFWLifecycleHelper.this.mActivityLifecycleCallbacks.iterator();
                while (it.hasNext()) {
                    ((Application.ActivityLifecycleCallbacks) it.next()).onActivitySaveInstanceState(activity, bundle);
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(@NonNull Activity activity) {
            RFWLifecycleHelper.this.mStartStateActivityCount.incrementAndGet();
            RFWLog.i("RFWLifecycleHelper", RFWLog.USR, "onActivityStarted:" + activity.getClass() + activity.hashCode() + " mStartStateActivityCount:" + RFWLifecycleHelper.this.mStartStateActivityCount.get());
            synchronized (RFWLifecycleHelper.this.mActivityLifecycleCallbacks) {
                Iterator it = RFWLifecycleHelper.this.mActivityLifecycleCallbacks.iterator();
                while (it.hasNext()) {
                    ((Application.ActivityLifecycleCallbacks) it.next()).onActivityStarted(activity);
                }
            }
            RFWLifecycleHelper.this.cancelIfScheduled();
            if (RFWLifecycleHelper.this.mStartStateActivityCount.get() == 1 && !RFWLifecycleHelper.this.mIsRunningInCurrentApp) {
                RFWLog.i("RFWLifecycleHelper", RFWLog.USR, "dispatchOnProcessForeground:" + activity);
                RFWLifecycleHelper.this.dispatchOnProcessForeground();
            }
            RFWLifecycleHelper.this.mIsRunningInCurrentApp = true;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@NonNull Activity activity) {
            RFWLifecycleHelper.this.mStartStateActivityCount.decrementAndGet();
            synchronized (RFWLifecycleHelper.this.mActivityLifecycleCallbacks) {
                Iterator it = RFWLifecycleHelper.this.mActivityLifecycleCallbacks.iterator();
                while (it.hasNext()) {
                    ((Application.ActivityLifecycleCallbacks) it.next()).onActivityStopped(activity);
                }
            }
            RFWLog.i("RFWLifecycleHelper", RFWLog.USR, "onActivityStopped:" + activity + " mStartStateActivityCount:" + RFWLifecycleHelper.this.mStartStateActivityCount.get());
            if (RFWLifecycleHelper.this.mStartStateActivityCount.get() == 0) {
                RFWLog.i("RFWLifecycleHelper", RFWLog.USR, "scheduledBackground: last activity:" + activity);
                RFWLifecycleHelper.this.scheduledBackground();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public class NotifyRunnable implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            boolean z16;
            if (!RFWLifecycleHelper.this.mNotifyScheduled.compareAndSet(true, false)) {
                RFWLog.e("RFWLifecycleHelper", RFWLog.USR, "mNotifyScheduled value error");
                return;
            }
            if (RFWLifecycleHelper.this.isInAppWithRunningTasks() && RFWLifecycleHelper.this.isInAppWithRunningAppProcesses()) {
                z16 = true;
            } else {
                z16 = false;
            }
            RFWLog.d("RFWLifecycleHelper", RFWLog.USR, "isRunningInCurrentApp:" + z16);
            if (!z16) {
                RFWLifecycleHelper.this.mIsRunningInCurrentApp = false;
                RFWLifecycleHelper.this.dispatchOnProcessBackground();
            } else {
                RFWLog.d("RFWLifecycleHelper", RFWLog.USR, "still in current app do nothing");
            }
        }

        NotifyRunnable() {
        }
    }

    RFWLifecycleHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelIfScheduled() {
        if (this.mNotifyScheduled.getAndSet(false)) {
            RFWLog.d("RFWLifecycleHelper", RFWLog.USR, "mNotifyScheduled is true, stop scheduled");
            Handler handler = getHandler(false);
            if (handler != null) {
                handler.removeCallbacksAndMessages(this.mScheduledToken);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchOnProcessBackground() {
        postInMain(new Runnable() { // from class: com.tencent.richframework.lifecycle.RFWLifecycleHelper.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (RFWLifecycleHelper.this.mProcessStateChangeListeners) {
                    Iterator it = RFWLifecycleHelper.this.mProcessStateChangeListeners.iterator();
                    while (it.hasNext()) {
                        ((IProcessStateChangeCallback) it.next()).onProcessBackground();
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchOnProcessForeground() {
        postInMain(new Runnable() { // from class: com.tencent.richframework.lifecycle.RFWLifecycleHelper.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (RFWLifecycleHelper.this.mProcessStateChangeListeners) {
                    Iterator it = RFWLifecycleHelper.this.mProcessStateChangeListeners.iterator();
                    while (it.hasNext()) {
                        ((IProcessStateChangeCallback) it.next()).onProcessForeground();
                    }
                }
            }
        });
    }

    @Nullable
    @MainThread
    private Handler getHandler(boolean z16) {
        if (this.mScheduledHandler == null && z16) {
            this.mScheduledHandler = RFWThreadManager.createNewThreadHandler(RFWThreadManager.TAG, 0);
        }
        return this.mScheduledHandler;
    }

    public static RFWLifecycleHelper getInstance() {
        if (sInstance == null) {
            synchronized (RFWLifecycleHelper.class) {
                if (sInstance == null) {
                    sInstance = new RFWLifecycleHelper();
                }
            }
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isInAppWithRunningAppProcesses() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) this.mHostApplication.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY));
        if (runningAppProcesses == null) {
            return false;
        }
        boolean z16 = false;
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            RFWLog.d("RFWLifecycleHelper", RFWLog.USR, "process:" + runningAppProcessInfo.processName + " importance:" + runningAppProcessInfo.importance + "importanceReasonCode" + runningAppProcessInfo.importanceReasonCode);
            if (runningAppProcessInfo.importance == 100 && runningAppProcessInfo.importanceReasonCode == 0) {
                z16 = true;
            }
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isInAppWithRunningTasks() {
        ComponentName componentName;
        try {
            List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) this.mHostApplication.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).getRunningTasks(1);
            if (runningTasks != null && runningTasks.size() > 0) {
                componentName = runningTasks.get(0).topActivity;
                RFWLog.e("RFWLifecycleHelper", RFWLog.USR, "topActivity:" + componentName);
                return this.mHostApplication.getPackageName().equals(componentName.getPackageName());
            }
        } catch (Throwable th5) {
            RFWLog.e("RFWLifecycleHelper", RFWLog.USR, "isRunningTaskInCurrentApp error", th5);
        }
        return false;
    }

    private void postInMain(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            this.mUIHandler.post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scheduledBackground() {
        Handler handler;
        if (!this.mNotifyScheduled.getAndSet(true) && (handler = getHandler(true)) != null) {
            handler.postAtTime(new NotifyRunnable(), this.mScheduledToken, SystemClock.uptimeMillis());
        }
    }

    public Activity getTopActivity() {
        synchronized (this.mResumeActivities) {
            Iterator<WeakReference<Activity>> it = this.mResumeActivities.iterator();
            while (it.hasNext()) {
                Activity activity = it.next().get();
                if (activity == null) {
                    it.remove();
                } else {
                    return activity;
                }
            }
            return null;
        }
    }

    public void init(Application application) {
        this.mHostApplication = application;
        application.registerActivityLifecycleCallbacks(new InnerLifecycleCallbacks());
    }

    public boolean isRunningInBackground() {
        return !this.mIsRunningInCurrentApp;
    }

    public void registerActivityLifecycleCallback(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.mActivityLifecycleCallbacks.add(activityLifecycleCallbacks);
    }

    public void registerProcessChangeListener(IProcessStateChangeCallback iProcessStateChangeCallback) {
        this.mProcessStateChangeListeners.add(iProcessStateChangeCallback);
    }

    public void unRegisterProcessChangeListener(IProcessStateChangeCallback iProcessStateChangeCallback) {
        this.mProcessStateChangeListeners.remove(iProcessStateChangeCallback);
    }
}
