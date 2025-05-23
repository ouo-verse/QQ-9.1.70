package com.tencent.wcdb.database;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Closeable;

/* compiled from: P */
/* loaded from: classes27.dex */
public abstract class a implements Closeable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private int f384391d;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f384391d = 1;
        }
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        synchronized (this) {
            int i3 = this.f384391d;
            if (i3 > 0) {
                this.f384391d = i3 + 1;
            } else {
                throw new IllegalStateException("attempt to re-open an already-closed object: " + this);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            g();
        }
    }

    protected abstract void e();

    public void g() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        synchronized (this) {
            z16 = true;
            int i3 = this.f384391d - 1;
            this.f384391d = i3;
            if (i3 != 0) {
                z16 = false;
            }
        }
        if (z16) {
            e();
        }
    }
}
