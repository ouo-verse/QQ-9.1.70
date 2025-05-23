package com.tencent.maxvideo.common;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class CommonThread extends BaseHandlerThread {
    static IPatchRedirector $redirector_;
    private static String TAG;
    private static CommonThread instance;
    private static Handler mHandler;
    private static boolean mIsStart;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9613);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        TAG = "CommonThread";
        mIsStart = false;
        instance = new CommonThread("CommonThread");
    }

    public CommonThread(String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
    }

    public static synchronized int getCommonThreadId() {
        int threadId;
        synchronized (CommonThread.class) {
            threadId = instance.getThreadId();
        }
        return threadId;
    }

    public static synchronized Looper getCommonThreadLooper() {
        Looper looper;
        synchronized (CommonThread.class) {
            startThread();
            looper = instance.getLooper();
        }
        return looper;
    }

    private static void newHandler() {
        if (mHandler == null) {
            mHandler = new Handler(getCommonThreadLooper());
        }
    }

    public static synchronized boolean post(Runnable runnable) {
        boolean post;
        synchronized (CommonThread.class) {
            newHandler();
            post = mHandler.post(runnable);
        }
        return post;
    }

    public static synchronized boolean postDelayed(Runnable runnable, long j3) {
        boolean postDelayed;
        synchronized (CommonThread.class) {
            newHandler();
            postDelayed = mHandler.postDelayed(runnable, j3);
        }
        return postDelayed;
    }

    public static synchronized boolean quitCommonThread() {
        boolean quit;
        synchronized (CommonThread.class) {
            quit = instance.quit();
        }
        return quit;
    }

    public static synchronized void removeCallbacks(Runnable runnable) {
        synchronized (CommonThread.class) {
            newHandler();
            mHandler.removeCallbacks(runnable);
        }
    }

    private static void startThread() {
        if (!mIsStart) {
            mIsStart = true;
            instance.start();
        }
    }
}
