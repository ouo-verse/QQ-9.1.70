package com.tencent.tmediacodec.util;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.util.concurrent.ExecutorService;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class ThreadManager {
    static IPatchRedirector $redirector_;
    private static final Handler mHandler;
    private static final HandlerThread mHandlerThread;
    private static final ExecutorService mThreadPool;
    private static Handler sSubHandler;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61744);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        mHandler = new Handler(Looper.getMainLooper());
        mThreadPool = ProxyExecutors.newCachedThreadPool();
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("tmediacodec-sub");
        mHandlerThread = baseHandlerThread;
        baseHandlerThread.start();
        sSubHandler = new Handler(baseHandlerThread.getLooper());
    }

    ThreadManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void execute(@NonNull Runnable runnable) {
        mThreadPool.execute(runnable);
    }

    public static void postOnSubThread(@NonNull Runnable runnable) {
        sSubHandler.post(runnable);
    }

    public static void runOnSubThread(@NonNull Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            mThreadPool.execute(runnable);
        } else {
            runnable.run();
        }
    }

    public static void runOnUiThread(@NonNull Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            mHandler.post(runnable);
        }
    }
}
