package com.tencent.mobileqq.uftransfer;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.uftransfer.depend.c;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    private static a f304857c;

    /* renamed from: a, reason: collision with root package name */
    private HandlerThread f304858a;

    /* renamed from: b, reason: collision with root package name */
    private Handler f304859b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19080);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f304857c = null;
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            e();
        }
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            a aVar2 = f304857c;
            if (aVar2 == null) {
                f304857c = new a();
            } else {
                aVar2.e();
            }
            aVar = f304857c;
        }
        return aVar;
    }

    private synchronized void e() {
        if (this.f304858a != null) {
            return;
        }
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("UFTTransferLogicThread");
        this.f304858a = baseHandlerThread;
        baseHandlerThread.start();
        this.f304859b = new Handler(this.f304858a.getLooper());
        c.c("[UFTTransfer] UFTLogicThread", 1, "transfer logicThread start...");
    }

    public void b(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) runnable);
        } else {
            if (runnable == null) {
                return;
            }
            this.f304859b.post(runnable);
        }
    }

    public void c(Runnable runnable, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, runnable, Long.valueOf(j3));
        } else {
            if (runnable == null) {
                return;
            }
            this.f304859b.postDelayed(runnable, j3);
        }
    }

    public void d(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) runnable);
        } else {
            if (runnable == null) {
                return;
            }
            if (Thread.currentThread() != this.f304859b.getLooper().getThread()) {
                this.f304859b.post(runnable);
            } else {
                runnable.run();
            }
        }
    }
}
