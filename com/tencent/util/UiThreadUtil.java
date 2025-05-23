package com.tencent.util;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class UiThreadUtil {
    static IPatchRedirector $redirector_;
    private static Handler sMainHandler;

    public UiThreadUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean isOnUiThread() {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            return true;
        }
        return false;
    }

    public static void remove(Runnable runnable) {
        synchronized (UiThreadUtil.class) {
            Handler handler = sMainHandler;
            if (handler == null) {
                return;
            }
            handler.removeCallbacks(runnable);
        }
    }

    public static void runOnUiThread(Runnable runnable) {
        synchronized (UiThreadUtil.class) {
            if (sMainHandler == null) {
                sMainHandler = new Handler(Looper.getMainLooper());
            }
        }
        sMainHandler.post(runnable);
    }

    public static void runOnUiThreadWithCheck(Runnable runnable) {
        if (isOnUiThread()) {
            runnable.run();
        } else {
            runOnUiThread(runnable);
        }
    }

    public static void runOnUiThread(Runnable runnable, long j3) {
        synchronized (UiThreadUtil.class) {
            if (sMainHandler == null) {
                sMainHandler = new Handler(Looper.getMainLooper());
            }
        }
        sMainHandler.postDelayed(runnable, j3);
    }
}
