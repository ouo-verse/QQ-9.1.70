package com.tencent.mobileqq.fe.utils;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    private static a f205844c;

    /* renamed from: a, reason: collision with root package name */
    private HandlerThread f205845a;

    /* renamed from: b, reason: collision with root package name */
    private Handler f205846b;

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else if (this.f205845a == null) {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("FEKit_1");
            this.f205845a = baseHandlerThread;
            baseHandlerThread.start();
            this.f205846b = new Handler(this.f205845a.getLooper());
        }
    }

    public static a a() {
        if (f205844c == null) {
            synchronized (a.class) {
                if (f205844c == null) {
                    f205844c = new a();
                }
            }
        }
        return f205844c;
    }

    public void b(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) runnable);
        } else {
            this.f205846b.post(runnable);
        }
    }

    public void c(Runnable runnable, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, runnable, Long.valueOf(j3));
        } else {
            this.f205846b.postDelayed(runnable, j3);
        }
    }
}
