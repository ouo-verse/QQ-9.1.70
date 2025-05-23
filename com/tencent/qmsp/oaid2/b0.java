package com.tencent.qmsp.oaid2;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b0 implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public y f344182a;

    /* renamed from: b, reason: collision with root package name */
    public a0 f344183b;

    public b0(y yVar, a0 a0Var) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) yVar, (Object) a0Var);
        } else {
            this.f344182a = yVar;
            this.f344183b = a0Var;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        a0 a0Var;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (this.f344182a == null) {
            return;
        }
        int i3 = 0;
        boolean z16 = false;
        do {
            try {
                TimeUnit.MICROSECONDS.sleep(10L);
                z16 = this.f344182a.c();
                i3++;
                if (z16) {
                    break;
                }
            } catch (Exception unused) {
            }
        } while (i3 < 30);
        if (z16 && (a0Var = this.f344183b) != null) {
            a0Var.a(true);
        }
    }
}
