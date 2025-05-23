package com.tencent.qfsmonet.utils;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.concurrent.Semaphore;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MonetHandler extends Handler {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final Semaphore f342622a;

    public MonetHandler(Looper looper) {
        super(looper);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) looper);
            return;
        }
        this.f342622a = new Semaphore(0);
        a.c("MonetHandler", "MonetHandler, looper=" + looper);
    }

    public synchronized void b(@NonNull Runnable runnable) throws IllegalStateException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) runnable);
        } else if (post(new Runnable(runnable) { // from class: com.tencent.qfsmonet.utils.MonetHandler.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Runnable f342623d;

            {
                this.f342623d = runnable;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MonetHandler.this, (Object) runnable);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    this.f342623d.run();
                    MonetHandler.this.f342622a.release();
                }
            }
        })) {
            try {
                this.f342622a.acquire();
            } catch (Exception unused) {
                a.b("MonetHandler", "post runnable failed!");
            }
        } else {
            a.b("MonetHandler", "post runnable failed!");
            throw new IllegalStateException("postSync failed!");
        }
    }
}
