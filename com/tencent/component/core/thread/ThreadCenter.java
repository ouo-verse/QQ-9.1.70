package com.tencent.component.core.thread;

import android.content.Context;
import com.tencent.component.core.thread.impl.ThreadImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ThreadCenter {
    public static HandlerKeyable sDefaultHandlerKey = new HandlerKeyable() { // from class: com.tencent.component.core.thread.ThreadCenter.1
    };
    private static ThreadImpl threadImpl = new ThreadImpl();

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface HandlerKeyable {
    }

    public static void clear(HandlerKeyable handlerKeyable) {
        threadImpl.clear(handlerKeyable);
    }

    public static void postDefaultUITask(Runnable runnable) {
        threadImpl.postMainTask(sDefaultHandlerKey, runnable, 0L, false);
    }

    public static void postDelayedUITask(HandlerKeyable handlerKeyable, Runnable runnable, long j3) {
        threadImpl.postMainTask(handlerKeyable, runnable, j3, false);
    }

    public static void postLogicTask(Runnable runnable) {
        postLogicTask(runnable, false);
    }

    public static void postUITask(HandlerKeyable handlerKeyable, Runnable runnable) {
        threadImpl.postMainTask(handlerKeyable, runnable, 0L, false);
    }

    public static void removeDefaultUITask(Runnable runnable) {
        threadImpl.removeUITask(sDefaultHandlerKey, runnable);
    }

    public static void removeUITask(HandlerKeyable handlerKeyable, Runnable runnable) {
        threadImpl.removeUITask(handlerKeyable, runnable);
    }

    public static void postDefaultUITask(Runnable runnable, boolean z16) {
        threadImpl.postMainTask(sDefaultHandlerKey, runnable, 0L, z16);
    }

    public static void postLogicTask(Runnable runnable, boolean z16) {
        ThreadManagerV2.excute(runnable, 16, null, true);
    }

    public static void postUITask(HandlerKeyable handlerKeyable, Runnable runnable, boolean z16) {
        threadImpl.postMainTask(handlerKeyable, runnable, 0L, z16);
    }

    public static void postDefaultUITask(Runnable runnable, long j3) {
        threadImpl.postMainTask(sDefaultHandlerKey, runnable, j3, false);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    private static class ErrorRunnable implements Runnable {
        ErrorRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public static void init(Context context) {
    }

    public static void removeLogicTask(ErrorRunnable errorRunnable) {
    }

    public static Runnable postDelayedLogicTask(ErrorRunnable errorRunnable, int i3) {
        return errorRunnable;
    }
}
