package com.tencent.aio.dispatcher;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes3.dex */
public class HandlerPoster extends Handler implements com.tencent.mvi.api.runtime.a, Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final c f69237d;

    /* renamed from: e, reason: collision with root package name */
    private final int f69238e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f69239f;

    /* renamed from: h, reason: collision with root package name */
    private a f69240h;

    public HandlerPoster(Looper looper, int i3) {
        super(looper);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) looper, i3);
        } else {
            this.f69238e = i3;
            this.f69237d = new c();
        }
    }

    @Override // com.tencent.mvi.api.runtime.a
    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.f69237d.b();
    }

    @Override // com.tencent.mvi.api.runtime.a
    public void f(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) runnable);
            return;
        }
        b b16 = b.b(runnable);
        synchronized (this) {
            this.f69237d.a(b16);
            if (!this.f69239f) {
                this.f69239f = true;
                postAtFrontOfQueue(this);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            do {
                b c16 = this.f69237d.c();
                if (c16 == null) {
                    synchronized (this) {
                        c16 = this.f69237d.c();
                        if (c16 == null) {
                            this.f69239f = false;
                            a aVar = this.f69240h;
                            if (aVar != null) {
                                aVar.complete();
                            }
                            return;
                        }
                    }
                }
                c16.a();
            } while (SystemClock.uptimeMillis() - uptimeMillis < this.f69238e);
            postAtFrontOfQueue(this);
            this.f69239f = true;
        } finally {
            this.f69239f = false;
        }
    }

    public HandlerPoster(Looper looper, int i3, a aVar) {
        super(looper);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, looper, Integer.valueOf(i3), aVar);
            return;
        }
        this.f69238e = i3;
        this.f69237d = new c();
        this.f69240h = aVar;
    }
}
