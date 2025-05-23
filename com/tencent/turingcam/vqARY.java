package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.turingcam.OTVRM;

/* compiled from: P */
/* loaded from: classes27.dex */
public class vqARY implements OTVRM.B9LVG {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TuringCallback f382409a;

    public vqARY(TuringCallback turingCallback) {
        this.f382409a = turingCallback;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) turingCallback);
        }
    }
}
