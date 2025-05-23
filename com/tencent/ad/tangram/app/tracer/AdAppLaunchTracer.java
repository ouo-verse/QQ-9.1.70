package com.tencent.ad.tangram.app.tracer;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.log.AdLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class AdAppLaunchTracer {
    private static final String TAG = "AdAppLaunchTracer";
    private static volatile AdAppLaunchTracer sInstance;
    private AdAppLaunchTracerActivityLifecycleCallbacks mActivityLifecycleCallbacks;
    private Application mApplication;
    private AdAppLaunchTracerParams mParams;
    private final Runnable mTraceOnTimeoutRunnable = new Runnable() { // from class: com.tencent.ad.tangram.app.tracer.AdAppLaunchTracer.1
        @Override // java.lang.Runnable
        public void run() {
            if (AdAppLaunchTracer.this.mParams != null && AdAppLaunchTracer.this.mParams.isValid()) {
                AdAppLaunchTracer.this.traceOnTimeout();
            } else {
                AdLog.i(AdAppLaunchTracer.TAG, "[mTraceOnTimeoutRunnable] do nothing, params is not valid");
            }
        }
    };
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final AdAppLaunchTracerActivityLifecycleData mData = new AdAppLaunchTracerActivityLifecycleData();

    AdAppLaunchTracer() {
    }

    public static AdAppLaunchTracer getInstance() {
        if (sInstance == null) {
            synchronized (AdAppLaunchTracer.class) {
                if (sInstance == null) {
                    sInstance = new AdAppLaunchTracer();
                }
            }
        }
        return sInstance;
    }

    private void notifyResult(AdAppLaunchTracerResult adAppLaunchTracerResult) {
        IAdAppLaunchTracerListener iAdAppLaunchTracerListener;
        AdAppLaunchTracerParams adAppLaunchTracerParams = this.mParams;
        if (adAppLaunchTracerParams != null && adAppLaunchTracerParams.isValid()) {
            CopyOnWriteArrayList<WeakReference<IAdAppLaunchTracerListener>> copyOnWriteArrayList = this.mParams.weakListeners;
            if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                AdLog.i(TAG, "[notifyResult] " + adAppLaunchTracerResult);
                Iterator<WeakReference<IAdAppLaunchTracerListener>> it = this.mParams.weakListeners.iterator();
                while (it.hasNext()) {
                    WeakReference<IAdAppLaunchTracerListener> next = it.next();
                    if (next != null) {
                        iAdAppLaunchTracerListener = next.get();
                    } else {
                        iAdAppLaunchTracerListener = null;
                    }
                    if (iAdAppLaunchTracerListener == null) {
                        AdLog.e(TAG, "[notifyResult] error, listener is null");
                    } else {
                        iAdAppLaunchTracerListener.onResult(this.mParams, adAppLaunchTracerResult);
                    }
                }
                return;
            }
            AdLog.i(TAG, "[notifyResult] do nothing, mParams.weakListeners is empty");
            return;
        }
        AdLog.i(TAG, "[notifyResult] do nothing, params is not valid");
    }

    private void traceOnActivityResult() {
        AdAppLaunchTracerParams adAppLaunchTracerParams = this.mParams;
        if (adAppLaunchTracerParams != null && adAppLaunchTracerParams.isValid()) {
            if (this.mData.matchExactly(new int[]{5})) {
                AdAppLaunchTracerResult adAppLaunchTracerResult = new AdAppLaunchTracerResult(0, 2);
                AdLog.i(TAG, "[traceOnActivityResult] result:" + adAppLaunchTracerResult + " mData:" + this.mData);
                notifyResult(adAppLaunchTracerResult);
                reset();
                return;
            }
            if (this.mData.matchExactly(new int[]{7, 3, 5})) {
                AdAppLaunchTracerResult adAppLaunchTracerResult2 = new AdAppLaunchTracerResult(0, 4);
                AdLog.i(TAG, "[traceOnActivityResult] result:" + adAppLaunchTracerResult2 + " mData:" + this.mData);
                notifyResult(adAppLaunchTracerResult2);
                reset();
                return;
            }
            AdLog.i(TAG, "[traceOnActivityResult] do nothing, mData:" + this.mData);
            return;
        }
        AdLog.i(TAG, "[traceOnActivityResult] do nothing, params is not valid");
    }

    private void traceOnStop() {
        AdAppLaunchTracerParams adAppLaunchTracerParams = this.mParams;
        if (adAppLaunchTracerParams != null && adAppLaunchTracerParams.isValid()) {
            if (this.mData.matchExactly(new int[]{7, 3, 4})) {
                AdAppLaunchTracerResult adAppLaunchTracerResult = new AdAppLaunchTracerResult(0, 3);
                AdLog.i(TAG, "[traceOnStop] result:" + adAppLaunchTracerResult + " mData:" + this.mData);
                notifyResult(adAppLaunchTracerResult);
                reset();
                return;
            }
            if (this.mData.matchExactly(new int[]{3, 5, 2, 7, 3, 4})) {
                AdAppLaunchTracerResult adAppLaunchTracerResult2 = new AdAppLaunchTracerResult(0, 1);
                AdLog.i(TAG, "[traceOnStop] result:" + adAppLaunchTracerResult2 + " mData:" + this.mData);
                notifyResult(adAppLaunchTracerResult2);
                reset();
                return;
            }
            AdLog.i(TAG, "[traceOnStop] do nothing, mData:" + this.mData);
            return;
        }
        AdLog.i(TAG, "[traceOnStop] do nothing, params is not valid");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void traceOnTimeout() {
        AdAppLaunchTracerParams adAppLaunchTracerParams = this.mParams;
        if (adAppLaunchTracerParams != null && adAppLaunchTracerParams.isValid()) {
            AdAppLaunchTracerResult adAppLaunchTracerResult = new AdAppLaunchTracerResult(13, 0);
            AdLog.i(TAG, "[traceOnTimeout] result:" + adAppLaunchTracerResult + " mData:" + this.mData);
            notifyResult(adAppLaunchTracerResult);
            reset();
            return;
        }
        AdLog.i(TAG, "[traceOnTimeout] do nothing, params is not valid");
    }

    public boolean isValid() {
        if (Build.VERSION.SDK_INT >= 29) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onActivityPaused() {
        AdAppLaunchTracerParams adAppLaunchTracerParams = this.mParams;
        if (adAppLaunchTracerParams != null && adAppLaunchTracerParams.isValid()) {
            AdLog.i(TAG, "[onActivityPaused]");
            this.mData.addStatus(3);
        } else {
            AdLog.i(TAG, "[onActivityPaused] do nothing, params is not valid");
        }
    }

    public boolean onActivityResult(int i3, int i16, Intent intent) {
        AdAppLaunchTracerParams adAppLaunchTracerParams = this.mParams;
        if (adAppLaunchTracerParams != null && adAppLaunchTracerParams.isValid()) {
            if (i3 != this.mParams.requestCode) {
                AdLog.i(TAG, "[onActivityResult] do nothing, not the specific request code");
                return false;
            }
            AdLog.i(TAG, "[onActivityResult] resultCode:" + i16);
            if (this.mData.addStatus(5)) {
                traceOnActivityResult();
                return true;
            }
            return true;
        }
        AdLog.i(TAG, "[onActivityResult] do nothing, params is not valid");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onActivityResumed() {
        AdAppLaunchTracerParams adAppLaunchTracerParams = this.mParams;
        if (adAppLaunchTracerParams != null && adAppLaunchTracerParams.isValid()) {
            AdLog.i(TAG, "[onActivityResumed]");
            this.mData.addStatus(2);
        } else {
            AdLog.i(TAG, "[onActivityResumed] do nothing, params is not valid");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onActivityStarted() {
        AdAppLaunchTracerParams adAppLaunchTracerParams = this.mParams;
        if (adAppLaunchTracerParams != null && adAppLaunchTracerParams.isValid()) {
            AdLog.i(TAG, "[onActivityStarted]");
            this.mData.addStatus(1);
        } else {
            AdLog.i(TAG, "[onActivityStarted] do nothing, params is not valid");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onActivityStopped() {
        AdAppLaunchTracerParams adAppLaunchTracerParams = this.mParams;
        if (adAppLaunchTracerParams != null && adAppLaunchTracerParams.isValid()) {
            AdLog.i(TAG, "[onActivityStopped]");
            if (this.mData.addStatus(4)) {
                traceOnStop();
                return;
            }
            return;
        }
        AdLog.i(TAG, "[onActivityStopped] do nothing, params is not valid");
    }

    public AdError onPreLaunch(AdAppLaunchTracerParams adAppLaunchTracerParams) {
        Application application;
        reset();
        if (adAppLaunchTracerParams != null && adAppLaunchTracerParams.isValid()) {
            Activity activity = adAppLaunchTracerParams.weakActivity.get();
            if (activity != null) {
                application = activity.getApplication();
            } else {
                application = null;
            }
            if (application == null) {
                AdLog.e(TAG, "[onPreLaunch] error, application is null");
                return new AdError(1);
            }
            AdLog.i(TAG, "[onPreLaunch] activity:" + activity);
            this.mParams = adAppLaunchTracerParams;
            this.mApplication = application;
            AdAppLaunchTracerActivityLifecycleCallbacks adAppLaunchTracerActivityLifecycleCallbacks = new AdAppLaunchTracerActivityLifecycleCallbacks(adAppLaunchTracerParams.weakActivity);
            this.mActivityLifecycleCallbacks = adAppLaunchTracerActivityLifecycleCallbacks;
            this.mApplication.registerActivityLifecycleCallbacks(adAppLaunchTracerActivityLifecycleCallbacks);
            this.mHandler.postDelayed(this.mTraceOnTimeoutRunnable, this.mParams.timeoutMillis);
            return new AdError(0);
        }
        AdLog.e(TAG, "[onPreLaunch] error, params is not valid");
        return new AdError(4);
    }

    public boolean onTopResumedActivityChanged(boolean z16) {
        int i3;
        AdAppLaunchTracerParams adAppLaunchTracerParams = this.mParams;
        if (adAppLaunchTracerParams != null && adAppLaunchTracerParams.isValid()) {
            AdLog.i(TAG, "[onTopResumedActivityChanged] onTop:" + z16);
            if (z16) {
                i3 = 6;
            } else {
                i3 = 7;
            }
            this.mData.addStatus(i3);
            return true;
        }
        AdLog.i(TAG, "[onActivityResult] do nothing, params is not valid");
        return false;
    }

    public void reset() {
        AdAppLaunchTracerActivityLifecycleCallbacks adAppLaunchTracerActivityLifecycleCallbacks;
        AdLog.i(TAG, "[reset]");
        this.mHandler.removeCallbacks(this.mTraceOnTimeoutRunnable);
        this.mData.reset();
        this.mParams = null;
        Application application = this.mApplication;
        if (application != null && (adAppLaunchTracerActivityLifecycleCallbacks = this.mActivityLifecycleCallbacks) != null) {
            application.unregisterActivityLifecycleCallbacks(adAppLaunchTracerActivityLifecycleCallbacks);
            this.mApplication = null;
            this.mActivityLifecycleCallbacks = null;
        }
    }
}
