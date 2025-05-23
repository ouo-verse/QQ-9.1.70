package com.tencent.webbundle.sdk;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ThreadManager {
    static IPatchRedirector $redirector_;
    private static volatile Handler sUiHandler;

    public ThreadManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void checkMainThread(String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        throw new IllegalThreadStateException(str + " need to be invoke in main thread.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void executeOnUiThread(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            getUiHandler().postAtFrontOfQueue(runnable);
        }
    }

    public static Handler getUiHandler() {
        if (sUiHandler == null) {
            synchronized (Handler.class) {
                if (sUiHandler == null) {
                    sUiHandler = new Handler(Looper.getMainLooper());
                }
            }
        }
        return sUiHandler;
    }
}
