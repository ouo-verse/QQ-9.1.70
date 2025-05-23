package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.turingcam.HnGHR;
import java.util.concurrent.Callable;

/* compiled from: P */
/* loaded from: classes27.dex */
public class wheT7 implements Callable<HnGHR.spXPg> {
    static IPatchRedirector $redirector_;

    public wheT7() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, com.tencent.turingcam.HnGHR$spXPg] */
    @Override // java.util.concurrent.Callable
    public HnGHR.spXPg call() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return HnGHR.a();
    }
}
