package com.tencent.component.core.thread.impl;

import android.os.Handler;
import android.os.Looper;
import com.tencent.component.core.thread.ThreadCenter;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ThreadImpl {
    private ConcurrentHashMap<Integer, Handler> mHandlerMap = new ConcurrentHashMap<>();

    public void clear(ThreadCenter.HandlerKeyable handlerKeyable) {
        Handler handler = this.mHandlerMap.get(Integer.valueOf(handlerKeyable.hashCode()));
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.mHandlerMap.remove(Integer.valueOf(handlerKeyable.hashCode()));
        }
    }

    public void postMainTask(ThreadCenter.HandlerKeyable handlerKeyable, Runnable runnable, long j3, boolean z16) {
        if (runnable == null) {
            return;
        }
        if (handlerKeyable == null) {
            handlerKeyable = ThreadCenter.sDefaultHandlerKey;
        }
        Handler handler = this.mHandlerMap.get(Integer.valueOf(handlerKeyable.hashCode()));
        if (handler == null) {
            handler = new Handler(Looper.getMainLooper());
            this.mHandlerMap.put(Integer.valueOf(handlerKeyable.hashCode()), handler);
        }
        if (j3 > 0) {
            handler.postDelayed(runnable, j3);
        } else if (z16) {
            handler.postAtFrontOfQueue(runnable);
        } else {
            handler.post(runnable);
        }
    }

    public void removeUITask(ThreadCenter.HandlerKeyable handlerKeyable, Runnable runnable) {
        Handler handler;
        if (runnable != null && (handler = this.mHandlerMap.get(Integer.valueOf(handlerKeyable.hashCode()))) != null) {
            handler.removeCallbacks(runnable);
        }
    }
}
