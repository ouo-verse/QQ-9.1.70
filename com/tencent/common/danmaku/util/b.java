package com.tencent.common.danmaku.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.Thread;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b implements Thread.UncaughtExceptionHandler {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) thread, (Object) th5);
        } else {
            e.c("DanmakuManager", "danmaku crash thread:", thread.getName(), th5);
        }
    }
}
