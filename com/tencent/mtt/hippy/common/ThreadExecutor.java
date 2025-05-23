package com.tencent.mtt.hippy.common;

import java.lang.Thread;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ThreadExecutor implements Thread.UncaughtExceptionHandler {
    final HippyHandlerThread mDomThread;
    private final int mGroupId;
    final HippyHandlerThread mJsBridgeThread;
    final HippyHandlerThread mJsThread;
    WeakReference<UncaughtExceptionHandler> mRefUncaughtExceptionHandler;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface UncaughtExceptionHandler {
        void handleThreadUncaughtException(Thread thread, Throwable th5, Integer num);
    }

    public ThreadExecutor(int i3) {
        this.mGroupId = i3;
        HippyHandlerThread hippyHandlerThread = new HippyHandlerThread("hippy-js-Thread");
        this.mJsThread = hippyHandlerThread;
        hippyHandlerThread.setUncaughtExceptionHandler(this);
        HippyHandlerThread hippyHandlerThread2 = new HippyHandlerThread("hippy-jsBridge-Thread");
        this.mJsBridgeThread = hippyHandlerThread2;
        hippyHandlerThread2.setUncaughtExceptionHandler(this);
        HippyHandlerThread hippyHandlerThread3 = new HippyHandlerThread("hippy-DomThread");
        this.mDomThread = hippyHandlerThread3;
        hippyHandlerThread3.setUncaughtExceptionHandler(this);
    }

    public void assertOnDomThread() {
        if (Thread.currentThread().getId() == this.mDomThread.getId()) {
        } else {
            throw new RuntimeException("call is not on dom-thread");
        }
    }

    public void assertOnJsBridge() {
        if (Thread.currentThread().getId() == this.mJsBridgeThread.getId()) {
        } else {
            throw new RuntimeException("call is not on Js-bridge-thread");
        }
    }

    public void assertOnJsThread() {
        if (Thread.currentThread().getId() == this.mJsThread.getId()) {
        } else {
            throw new RuntimeException("call is not on Js-thread");
        }
    }

    public void destroy() {
        HippyHandlerThread hippyHandlerThread = this.mDomThread;
        if (hippyHandlerThread != null && hippyHandlerThread.isThreadAlive()) {
            this.mDomThread.quit();
            this.mDomThread.setUncaughtExceptionHandler(null);
        }
        HippyHandlerThread hippyHandlerThread2 = this.mJsBridgeThread;
        if (hippyHandlerThread2 != null && hippyHandlerThread2.isThreadAlive()) {
            this.mJsBridgeThread.quit();
            this.mJsBridgeThread.setUncaughtExceptionHandler(null);
        }
        HippyHandlerThread hippyHandlerThread3 = this.mJsThread;
        if (hippyHandlerThread3 != null && hippyHandlerThread3.isThreadAlive()) {
            this.mJsThread.quit();
            this.mJsThread.setUncaughtExceptionHandler(null);
        }
        WeakReference<UncaughtExceptionHandler> weakReference = this.mRefUncaughtExceptionHandler;
        if (weakReference != null) {
            weakReference.clear();
            this.mRefUncaughtExceptionHandler = null;
        }
    }

    public HippyHandlerThread getDomThread() {
        return this.mDomThread;
    }

    public HippyHandlerThread getJsBridgeThread() {
        return this.mJsBridgeThread;
    }

    public HippyHandlerThread getJsThread() {
        return this.mJsThread;
    }

    public void postDelayOnJsThread(int i3, Runnable runnable) {
        this.mJsThread.getHandler().postDelayed(runnable, i3);
    }

    public void postOnDomThread(Runnable runnable) {
        this.mDomThread.runOnQueue(runnable);
    }

    public void postOnJsBridgeThread(Runnable runnable) {
        this.mJsThread.runOnQueue(runnable);
    }

    public void postOnJsThread(Runnable runnable) {
        this.mJsBridgeThread.runOnQueue(runnable);
    }

    public void setUncaughtExceptionHandler(UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.mRefUncaughtExceptionHandler = new WeakReference<>(uncaughtExceptionHandler);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th5) {
        UncaughtExceptionHandler uncaughtExceptionHandler;
        WeakReference<UncaughtExceptionHandler> weakReference = this.mRefUncaughtExceptionHandler;
        if (weakReference != null) {
            uncaughtExceptionHandler = weakReference.get();
        } else {
            uncaughtExceptionHandler = null;
        }
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.handleThreadUncaughtException(thread, th5, Integer.valueOf(this.mGroupId));
        }
    }
}
