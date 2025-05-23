package com.tencent.qqlive.tvkplayer.tools.utils;

import android.os.Looper;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKApplicationLifecycleObserver implements LifecycleObserver {
    private static final String TAG = "TVKApplicationLifecycleObserver";

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private void onResume() {
        TVKGlobalEventNotifier.getInstance().postGlobalEvent(100002, 0, 0, null);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    private void onStop() {
        TVKGlobalEventNotifier.getInstance().postGlobalEvent(100001, 0, 0, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void registerObserver() {
        try {
            ProcessLifecycleOwner.get().getLifecycle().addObserver(new TVKApplicationLifecycleObserver());
        } catch (Exception e16) {
            TVKLogUtil.e(TAG, "ProcessLifecycleOwner addObserver exception:" + e16);
        }
    }

    public static void registerObserverOnUIThread() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            TVKThreadPool.getInstance().postRunnableOnMainThread(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.tools.utils.TVKApplicationLifecycleObserver.1
                @Override // java.lang.Runnable
                public void run() {
                    TVKApplicationLifecycleObserver.registerObserver();
                }
            });
        } else {
            registerObserver();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private void onCreate() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private void onDestroy() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private void onPause() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private void onStart() {
    }
}
