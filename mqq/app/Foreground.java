package mqq.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.lifecycle.ForegroundActivityCallback;
import mqq.util.AIOLocalActivityUtils;
import mqq.util.QCircleActivityUtils;

/* compiled from: P */
/* loaded from: classes28.dex */
public class Foreground implements Handler.Callback {
    private static final int DELAY_BROADCAST = 100;
    public static final String EVENT_TIME = "event_time";
    public static final int FROM_OTHER = 0;
    public static final int FROM_PAUSE_BEFORE_CALL_SUPER = 4;
    public static final int FROM_RESUME_BEFORE_CALL_SUPER = 3;
    public static final int FROM_START_BEFORE_CALL_SUPER = 1;
    public static final int FROM_STOP_BEFORE_CALL_SUPER = 2;
    private static final int MSG_BACK = 0;
    private static final int MSG_FORE = 1;
    public static final String TAG = "ApplicationLife";
    private static ForegroundActivityCallback recordCallback;
    private static Context sContext;
    private static Handler sHandler;
    private static String sProcessName;
    private static WeakReference<Activity> sTopActivity;
    public static AtomicInteger sCountActivity = new AtomicInteger(0);
    public static AtomicInteger sCountResume = new AtomicInteger(0);
    private static final List<WeakReference<Activity>> sResumedActivities = new CopyOnWriteArrayList();
    private static final ForegroundActivityLifecycleCallbacks sCallbacks = new ForegroundActivityLifecycleCallbacks();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class ForegroundActivityLifecycleCallbacks implements QActivityLifecycleCallbacks {
        private final AtomicBoolean haveCallbackForeground;
        private final List<QActivityLifecycleCallbacks> mLifecycleCallbacks = new ArrayList();

        ForegroundActivityLifecycleCallbacks() {
            QLog.d("ForegroundCallback", 2, "cur proc: ", MobileQQ.processName);
            this.haveCallbackForeground = new AtomicBoolean(false);
        }

        private AppRuntime getRuntimeFromAct(Activity activity) {
            try {
            } catch (Throwable th5) {
                QLog.e("ForegroundCallback", 1, "getRuntimeFromAct with error: ", th5);
            }
            if (activity instanceof AppActivity) {
                return ((AppActivity) activity).getProRuntime();
            }
            QLog.d("ForegroundCallback", 1, "getRuntimeFromAct Activity is: ", activity.getClass().getName());
            return MobileQQ.sMobileQQ.peekAppRuntime();
        }

        private boolean isLifecycleBlackListActivity(Activity activity) {
            if (activity == null) {
                return true;
            }
            if (QCircleActivityUtils.isLifecycleBlackListActivity(activity)) {
                QLog.d("ForegroundCallback", 1, "activity is qcircle folder tab activity");
                return true;
            }
            if (AIOLocalActivityUtils.INSTANCE.isLifecycleBlackListActivity(activity)) {
                QLog.d("ForegroundCallback", 1, "activity is AIOLocalActivity");
                return true;
            }
            return false;
        }

        void addActivityLifecycleCallbacks(QActivityLifecycleCallbacks qActivityLifecycleCallbacks) {
            if (qActivityLifecycleCallbacks == null) {
                return;
            }
            synchronized (this.mLifecycleCallbacks) {
                if (!this.mLifecycleCallbacks.contains(qActivityLifecycleCallbacks)) {
                    this.mLifecycleCallbacks.add(qActivityLifecycleCallbacks);
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            QLog.d("ForegroundCallback", 2, "onActivityCreated cur activity: ", activity.getClass().getName());
            if (!isLifecycleBlackListActivity(activity)) {
                Foreground.onCreate(activity);
                synchronized (this.mLifecycleCallbacks) {
                    Iterator it = new ArrayList(this.mLifecycleCallbacks).iterator();
                    while (it.hasNext()) {
                        ((Application.ActivityLifecycleCallbacks) it.next()).onActivityCreated(activity, bundle);
                    }
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            QLog.d("ForegroundCallback", 2, "onActivityDestroyed cur activity: ", activity.getClass().getName());
            if (!isLifecycleBlackListActivity(activity)) {
                Foreground.onDestroy(activity);
                synchronized (this.mLifecycleCallbacks) {
                    Iterator it = new ArrayList(this.mLifecycleCallbacks).iterator();
                    while (it.hasNext()) {
                        ((Application.ActivityLifecycleCallbacks) it.next()).onActivityDestroyed(activity);
                    }
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            QLog.d("ForegroundCallback", 2, "onActivityPaused cur activity: ", activity.getClass().getName());
            if (!isLifecycleBlackListActivity(activity)) {
                Foreground.onPause(getRuntimeFromAct(activity), activity);
                synchronized (this.mLifecycleCallbacks) {
                    Iterator it = new ArrayList(this.mLifecycleCallbacks).iterator();
                    while (it.hasNext()) {
                        ((Application.ActivityLifecycleCallbacks) it.next()).onActivityPaused(activity);
                    }
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            QLog.d("ForegroundCallback", 2, "onActivityResumed cur activity: ", activity.getClass().getName());
            if (!isLifecycleBlackListActivity(activity)) {
                Foreground.onResume(getRuntimeFromAct(activity), activity);
                synchronized (this.mLifecycleCallbacks) {
                    Iterator it = new ArrayList(this.mLifecycleCallbacks).iterator();
                    while (it.hasNext()) {
                        ((Application.ActivityLifecycleCallbacks) it.next()).onActivityResumed(activity);
                    }
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            if (isLifecycleBlackListActivity(activity)) {
                return;
            }
            synchronized (this.mLifecycleCallbacks) {
                Iterator it = new ArrayList(this.mLifecycleCallbacks).iterator();
                while (it.hasNext()) {
                    ((Application.ActivityLifecycleCallbacks) it.next()).onActivitySaveInstanceState(activity, bundle);
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            QLog.d("ForegroundCallback", 2, "onActivityStarted cur activity: ", activity.getClass().getName());
            if (!isLifecycleBlackListActivity(activity)) {
                Foreground.onStart(getRuntimeFromAct(activity), activity);
                synchronized (this.mLifecycleCallbacks) {
                    Iterator it = new ArrayList(this.mLifecycleCallbacks).iterator();
                    while (it.hasNext()) {
                        ((Application.ActivityLifecycleCallbacks) it.next()).onActivityStarted(activity);
                    }
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            QLog.d("ForegroundCallback", 2, "onActivityStopped cur activity: ", activity.getClass().getName());
            if (!isLifecycleBlackListActivity(activity)) {
                Foreground.onStop(getRuntimeFromAct(activity));
                synchronized (this.mLifecycleCallbacks) {
                    Iterator it = new ArrayList(this.mLifecycleCallbacks).iterator();
                    while (it.hasNext()) {
                        ((Application.ActivityLifecycleCallbacks) it.next()).onActivityStopped(activity);
                    }
                }
            }
        }

        @Override // mqq.app.QActivityLifecycleCallbacks
        public void onProcessBackground() {
            synchronized (this.mLifecycleCallbacks) {
                if (QLog.isColorLevel()) {
                    QLog.d("ForegroundCallback", 2, "onProcessBackground");
                }
                Iterator it = new ArrayList(this.mLifecycleCallbacks).iterator();
                while (it.hasNext()) {
                    ((QActivityLifecycleCallbacks) it.next()).onProcessBackground();
                }
            }
            this.haveCallbackForeground.set(false);
        }

        @Override // mqq.app.QActivityLifecycleCallbacks
        public void onProcessForeground() {
            if (!this.haveCallbackForeground.get()) {
                if (QLog.isColorLevel()) {
                    QLog.d("ForegroundCallback", 2, "onProcessForeground");
                }
                synchronized (this.mLifecycleCallbacks) {
                    Iterator it = new ArrayList(this.mLifecycleCallbacks).iterator();
                    while (it.hasNext()) {
                        ((QActivityLifecycleCallbacks) it.next()).onProcessForeground();
                    }
                }
                this.haveCallbackForeground.set(true);
            }
        }

        synchronized void removeActivityLifecycleCallbacks(QActivityLifecycleCallbacks qActivityLifecycleCallbacks) {
            if (qActivityLifecycleCallbacks == null) {
                return;
            }
            synchronized (this.mLifecycleCallbacks) {
                this.mLifecycleCallbacks.remove(qActivityLifecycleCallbacks);
            }
        }
    }

    public static synchronized void addActivityLifeCallback(QActivityLifecycleCallbacks qActivityLifecycleCallbacks) {
        synchronized (Foreground.class) {
            ForegroundActivityLifecycleCallbacks foregroundActivityLifecycleCallbacks = sCallbacks;
            if (foregroundActivityLifecycleCallbacks != null) {
                foregroundActivityLifecycleCallbacks.addActivityLifecycleCallbacks(qActivityLifecycleCallbacks);
            } else {
                QLog.e("ForegroundCallback", 1, "sCallbacks is null, add failed.");
            }
        }
    }

    public static void finishAllActivityAtTask(int i3) {
        ForegroundActivityCallback foregroundActivityCallback = recordCallback;
        if (foregroundActivityCallback != null) {
            foregroundActivityCallback.finishAllActivityAtTask(i3);
        }
    }

    public static void finishProcessAllActivity() {
        ForegroundActivityCallback foregroundActivityCallback = recordCallback;
        if (foregroundActivityCallback != null) {
            foregroundActivityCallback.finishAllActivity();
        }
    }

    public static int getActivityCount() {
        return sCountActivity.get();
    }

    public static int getActivityCountFromLifecycle(int i3) {
        if (i3 == 2) {
            return sCountActivity.get() - 1;
        }
        if (i3 == 1) {
            return sCountActivity.get() + 1;
        }
        return sCountActivity.get();
    }

    public static int getProcessAllActivity() {
        ForegroundActivityCallback foregroundActivityCallback = recordCallback;
        if (foregroundActivityCallback != null) {
            return foregroundActivityCallback.getAvailableActCnt();
        }
        return 0;
    }

    public static int getResumeActivityCount() {
        return sCountResume.get();
    }

    public static int getResumeActivityCountFromLifecycle(int i3) {
        if (i3 == 4) {
            return sCountResume.get() - 1;
        }
        if (i3 == 3) {
            return sCountResume.get() + 1;
        }
        return sCountResume.get();
    }

    public static List<WeakReference<Activity>> getResumedActivity() {
        return new ArrayList(sResumedActivities);
    }

    public static Activity getTopActivity() {
        WeakReference<Activity> weakReference = sTopActivity;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public static void init(Context context, Looper looper, String str) {
        if (sHandler == null) {
            synchronized (TAG) {
                if (sHandler == null) {
                    sContext = context;
                    sProcessName = str;
                    sHandler = new Handler(looper, new Foreground());
                }
            }
        }
        if (recordCallback == null) {
            ForegroundActivityCallback foregroundActivityCallback = new ForegroundActivityCallback();
            recordCallback = foregroundActivityCallback;
            ForegroundActivityLifecycleCallbacks foregroundActivityLifecycleCallbacks = sCallbacks;
            foregroundActivityLifecycleCallbacks.addActivityLifecycleCallbacks(foregroundActivityCallback);
            ((Application) context).registerActivityLifecycleCallbacks(foregroundActivityLifecycleCallbacks);
        }
    }

    public static boolean isCurrentProcessForeground() {
        if (getActivityCount() > 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void onPause(AppRuntime appRuntime, Activity activity) {
        for (WeakReference<Activity> weakReference : sResumedActivities) {
            if (weakReference != null && activity == weakReference.get()) {
                sResumedActivities.remove(weakReference);
            }
        }
        if (sCountResume.decrementAndGet() <= 0 && appRuntime != null) {
            appRuntime.isBackgroundPause = true;
            Iterator<AppRuntime> it = appRuntime.subRuntimeMap.values().iterator();
            while (it.hasNext()) {
                it.next().isBackgroundPause = appRuntime.isBackgroundPause;
            }
            appRuntime.onProcPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void onResume(AppRuntime appRuntime, Activity activity) {
        if (activity != null) {
            sResumedActivities.add(new WeakReference<>(activity));
            if (!activity.equals(getTopActivity())) {
                sTopActivity = new WeakReference<>(activity);
            }
        }
        if (sCountResume.incrementAndGet() > 0 && appRuntime != null) {
            appRuntime.isBackgroundPause = false;
            Iterator<AppRuntime> it = appRuntime.subRuntimeMap.values().iterator();
            while (it.hasNext()) {
                it.next().isBackgroundPause = appRuntime.isBackgroundPause;
            }
            appRuntime.onProcResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void onStart(AppRuntime appRuntime, Activity activity) {
        sTopActivity = new WeakReference<>(activity);
        sCountActivity.incrementAndGet();
        if (getActivityCount() == 1 || getActivityCount() == 2) {
            long uptimeMillis = SystemClock.uptimeMillis();
            Message obtainMessage = sHandler.obtainMessage(1, (int) (uptimeMillis >>> 32), (int) (uptimeMillis & (-1)), appRuntime);
            sCallbacks.onProcessForeground();
            sHandler.sendMessageDelayed(obtainMessage, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void onStop(AppRuntime appRuntime) {
        QLog.d(TAG, 1, "[process] onStop: invoked. ", " sCountActivity: ", Integer.valueOf(getActivityCount()));
        if (sCountActivity.decrementAndGet() == 0) {
            long uptimeMillis = SystemClock.uptimeMillis();
            sHandler.sendMessageDelayed(sHandler.obtainMessage(0, (int) (uptimeMillis >>> 32), (int) (uptimeMillis & (-1)), appRuntime), 100L);
            sCallbacks.onProcessBackground();
            QLog.d(TAG, 1, "[process] onStop: invoked. send MSG_BACK", " sCountActivity: ", Integer.valueOf(getActivityCount()));
        }
    }

    public static synchronized void removeActivityLifeCallback(QActivityLifecycleCallbacks qActivityLifecycleCallbacks) {
        synchronized (Foreground.class) {
            ForegroundActivityLifecycleCallbacks foregroundActivityLifecycleCallbacks = sCallbacks;
            if (foregroundActivityLifecycleCallbacks != null) {
                foregroundActivityLifecycleCallbacks.removeActivityLifecycleCallbacks(qActivityLifecycleCallbacks);
            }
        }
    }

    public static void setReady() {
        if (getActivityCount() > 0) {
            long uptimeMillis = SystemClock.uptimeMillis();
            sHandler.sendMessageDelayed(sHandler.obtainMessage(1, (int) (uptimeMillis >>> 32), (int) ((-1) & uptimeMillis), null), 100L);
        } else {
            long uptimeMillis2 = SystemClock.uptimeMillis();
            sHandler.sendMessageDelayed(sHandler.obtainMessage(0, (int) (uptimeMillis2 >>> 32), (int) ((-1) & uptimeMillis2), null), 100L);
        }
    }

    public static void updateRuntimeState(AppRuntime appRuntime) {
        boolean z16;
        if (appRuntime != null) {
            boolean z17 = true;
            if (getResumeActivityCount() <= 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            appRuntime.isBackgroundPause = z16;
            if (getActivityCount() > 0) {
                z17 = false;
            }
            appRuntime.isBackgroundStop = z17;
            for (AppRuntime appRuntime2 : appRuntime.subRuntimeMap.values()) {
                appRuntime2.isBackgroundPause = appRuntime.isBackgroundPause;
                appRuntime2.isBackgroundStop = appRuntime.isBackgroundStop;
            }
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        AppRuntime appRuntime = (AppRuntime) message.obj;
        long j3 = (message.arg1 << 32) | (message.arg2 & (-1));
        if (QLog.isColorLevel()) {
            QLog.i("mqq", 2, message.what + ", " + sProcessName + ", " + j3 + ", " + getActivityCount() + ", rt = " + appRuntime);
        }
        int i3 = message.what;
        if (i3 != 0) {
            if (i3 == 1) {
                if (getActivityCount() > 0) {
                    if (appRuntime != null && appRuntime.isBackgroundStop) {
                        appRuntime.onRunningForeground();
                        Iterator<AppRuntime> it = appRuntime.subRuntimeMap.values().iterator();
                        while (it.hasNext()) {
                            it.next().onRunningForeground();
                        }
                    }
                    Intent intent = new Intent("com.tencent.process.starting");
                    intent.putExtra("runningProcessName", sProcessName);
                    intent.putExtra("runningtime", j3);
                    intent.putExtra("event_time", System.currentTimeMillis());
                    sContext.sendBroadcast(intent);
                    QLog.d(TAG, 1, "[process] handleMessage: invoked. send starting", " sProcessName: ", sProcessName);
                }
            }
            return true;
        }
        QLog.d(TAG, 1, "[process] handleMessage: invoked. ", " sCountActivity: ", Integer.valueOf(getActivityCount()));
        if (getActivityCount() == 0) {
            if (appRuntime != null) {
                appRuntime.onRunningBackground();
                Iterator<AppRuntime> it5 = appRuntime.subRuntimeMap.values().iterator();
                while (it5.hasNext()) {
                    it5.next().onRunningBackground();
                }
            }
            try {
                Intent intent2 = new Intent("com.tencent.process.stopping");
                intent2.putExtra("runningProcessName", sProcessName);
                intent2.putExtra("runningtime", j3);
                intent2.putExtra("event_time", System.currentTimeMillis());
                sContext.sendBroadcast(intent2);
                QLog.d(TAG, 1, "[process] handleMessage: invoked. send stopping", " sProcessName: ", sProcessName);
            } catch (Exception unused) {
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void onCreate(Activity activity) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void onDestroy(Activity activity) {
    }
}
