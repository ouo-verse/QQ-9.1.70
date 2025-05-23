package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.turingfd.sdk.xq.Cassiopeia;
import java.util.concurrent.Callable;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Teazle implements Callable<Cassiopeia.Cdo> {
    static IPatchRedirector $redirector_;

    public Teazle(Vermillion vermillion) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) vermillion);
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, com.tencent.turingfd.sdk.xq.Cassiopeia$do] */
    @Override // java.util.concurrent.Callable
    public Cassiopeia.Cdo call() throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return Cassiopeia.a();
    }
}
