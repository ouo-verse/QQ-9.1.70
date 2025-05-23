package com.tencent.mobileqq.app.automator;

import com.tencent.mobileqq.app.automator.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes11.dex */
public class ParallGroup<T extends b> extends StepGroup<T> implements c {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name */
    protected int f195312i;

    public ParallGroup() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public synchronized void a(AsyncStep asyncStep, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) asyncStep, i3);
            return;
        }
        int i16 = this.f195312i - 1;
        this.f195312i = i16;
        if (i16 == 0) {
            setResult(7);
            this.f195313d = null;
        }
        this.mAutomator.i2(this.f195313d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.automator.AsyncStep
    public int doStep() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        this.f195312i = this.f195316h.length;
        while (true) {
            AsyncStep g16 = g();
            if (g16 == null || this.mResult == 8) {
                break;
            }
            g16.mResultListener = this;
            this.mAutomator.a2(g16);
        }
        return 2;
    }
}
