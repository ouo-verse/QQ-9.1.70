package com.tencent.qqlive.module.videoreport.utils;

import com.tencent.qqlive.module.videoreport.Log;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ListenerMgr<T> {
    private static boolean sIsDebug = false;
    private final ConcurrentLinkedQueue<WeakReference<T>> mListenerQueue = new ConcurrentLinkedQueue<>();

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface INotifyCallback<T> {
        void onNotify(T t16);
    }

    public static void setDebug(boolean z16) {
        sIsDebug = z16;
    }

    private void throwRuntimeExceptionInMain(final Throwable th5) {
        com.tencent.qqlive.module.videoreport.task.ThreadUtils.runOnUiThread(new Runnable() { // from class: com.tencent.qqlive.module.videoreport.utils.ListenerMgr.1
            @Override // java.lang.Runnable
            public void run() {
                throw new RuntimeException(th5);
            }
        });
    }

    public void clear() {
        synchronized (this.mListenerQueue) {
            this.mListenerQueue.clear();
        }
    }

    public void register(T t16) {
        if (t16 == null) {
            return;
        }
        synchronized (this.mListenerQueue) {
            Iterator<WeakReference<T>> it = this.mListenerQueue.iterator();
            boolean z16 = false;
            while (it.hasNext()) {
                T t17 = it.next().get();
                if (t17 == null) {
                    it.remove();
                } else if (t17 == t16) {
                    z16 = true;
                }
            }
            if (!z16) {
                this.mListenerQueue.add(new WeakReference<>(t16));
            }
        }
    }

    public int size() {
        int size;
        synchronized (this.mListenerQueue) {
            size = this.mListenerQueue.size();
        }
        return size;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void startNotify(INotifyCallback<T> iNotifyCallback) {
        ConcurrentLinkedQueue concurrentLinkedQueue;
        synchronized (this.mListenerQueue) {
            if (this.mListenerQueue.size() > 0) {
                concurrentLinkedQueue = new ConcurrentLinkedQueue(this.mListenerQueue);
            } else {
                concurrentLinkedQueue = null;
            }
        }
        if (concurrentLinkedQueue == null) {
            return;
        }
        try {
            Iterator it = concurrentLinkedQueue.iterator();
            while (it.hasNext()) {
                Object obj = ((WeakReference) it.next()).get();
                if (obj != null) {
                    try {
                        iNotifyCallback.onNotify(obj);
                    } catch (Throwable th5) {
                        Log.e("crash", th5.toString());
                        if (sIsDebug) {
                            throwRuntimeExceptionInMain(th5);
                        }
                    }
                }
            }
        } catch (Throwable th6) {
            Log.e("crash", th6.toString());
        }
    }

    public void unregister(T t16) {
        if (t16 == null) {
            return;
        }
        synchronized (this.mListenerQueue) {
            Iterator<WeakReference<T>> it = this.mListenerQueue.iterator();
            while (it.hasNext()) {
                if (it.next().get() == t16) {
                    it.remove();
                    return;
                }
            }
        }
    }
}
