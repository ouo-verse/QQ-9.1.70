package com.tencent.tdf.utils;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* loaded from: classes26.dex */
public class PlatformThread {
    static IPatchRedirector $redirector_;
    private static final Handler HANDLER;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15547);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            HANDLER = new Handler(Looper.getMainLooper());
        }
    }

    public PlatformThread() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void post(Runnable runnable) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
        } else {
            HANDLER.post(runnable);
        }
    }
}
