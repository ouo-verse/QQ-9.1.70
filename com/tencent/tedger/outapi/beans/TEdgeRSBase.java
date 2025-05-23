package com.tencent.tedger.outapi.beans;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tedger.outapi.jnishare.TEdgeRSSharedBase;

/* compiled from: P */
/* loaded from: classes26.dex */
public abstract class TEdgeRSBase extends TEdgeRSSharedBase {
    static IPatchRedirector $redirector_;

    public TEdgeRSBase() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public abstract byte[] readBussinessData();
}
