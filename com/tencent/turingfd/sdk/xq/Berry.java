package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Berry extends Draco {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReference<String> f382589a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f382590b;

    public Berry(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, z16);
        } else {
            this.f382589a = new AtomicReference<>(null);
            this.f382590b = z16;
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        synchronized (this.f382589a) {
            String str = this.f382589a.get();
            if (str != null) {
                return str;
            }
            try {
                this.f382589a.wait(2000L);
            } catch (InterruptedException unused) {
            }
            return this.f382589a.get();
        }
    }
}
