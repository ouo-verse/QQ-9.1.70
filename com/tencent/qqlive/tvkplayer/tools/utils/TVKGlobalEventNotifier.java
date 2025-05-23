package com.tencent.qqlive.tvkplayer.tools.utils;

import android.os.Handler;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKGlobalEventNotifier {
    public static final int EVENT_ID_APP_ENTER_BACKGROUND = 100001;
    public static final int EVENT_ID_APP_ENTER_FOREGROUND = 100002;
    public static final int EVENT_ID_ON_NETWORK_CHANGE = 100003;
    private static final String TAG = "TVKGlobalEventNotifier";
    private static final CopyOnWriteArrayList<OnGlobalEventChangeListener> mListeners = new CopyOnWriteArrayList<>();
    private static final TVKGlobalEventNotifier sInstance = new TVKGlobalEventNotifier();
    private final Handler mHandler = new Handler(TVKThreadPool.getInstance().obtainSharedHandlerThread().getLooper());

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes23.dex */
    public @interface EventId {
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface OnGlobalEventChangeListener {
        void onEvent(int i3, int i16, int i17, Object obj);
    }

    TVKGlobalEventNotifier() {
    }

    public static TVKGlobalEventNotifier getInstance() {
        return sInstance;
    }

    public synchronized void addEventListener(OnGlobalEventChangeListener onGlobalEventChangeListener) {
        CopyOnWriteArrayList<OnGlobalEventChangeListener> copyOnWriteArrayList = mListeners;
        if (!copyOnWriteArrayList.contains(onGlobalEventChangeListener)) {
            copyOnWriteArrayList.add(onGlobalEventChangeListener);
            TVKLogUtil.i(TAG, "add global event listener: " + onGlobalEventChangeListener + ", mListeners: " + copyOnWriteArrayList.size());
        }
    }

    public void postGlobalEvent(final int i3, final int i16, final int i17, final Object obj) {
        this.mHandler.post(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.tools.utils.TVKGlobalEventNotifier.1
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = TVKGlobalEventNotifier.mListeners.iterator();
                while (it.hasNext()) {
                    ((OnGlobalEventChangeListener) it.next()).onEvent(i3, i16, i17, obj);
                }
            }
        });
    }

    public synchronized void removeEventListener(OnGlobalEventChangeListener onGlobalEventChangeListener) {
        CopyOnWriteArrayList<OnGlobalEventChangeListener> copyOnWriteArrayList = mListeners;
        copyOnWriteArrayList.remove(onGlobalEventChangeListener);
        TVKLogUtil.i(TAG, "remove global event listener: " + onGlobalEventChangeListener + ", mListeners: " + copyOnWriteArrayList.size());
    }
}
