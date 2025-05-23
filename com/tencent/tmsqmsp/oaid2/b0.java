package com.tencent.tmsqmsp.oaid2;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b0 implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public y f380772a;

    /* renamed from: b, reason: collision with root package name */
    public a0 f380773b;

    public b0(y yVar, a0 a0Var) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) yVar, (Object) a0Var);
        } else {
            this.f380772a = yVar;
            this.f380773b = a0Var;
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
        if (this.f380772a == null) {
            return;
        }
        int i3 = 0;
        boolean z16 = false;
        do {
            try {
                TimeUnit.MICROSECONDS.sleep(10L);
                z16 = this.f380772a.c();
                i3++;
                if (z16) {
                    break;
                }
            } catch (Exception unused) {
            }
        } while (i3 < 30);
        if (z16 && (a0Var = this.f380773b) != null) {
            a0Var.a(true);
        }
    }
}
