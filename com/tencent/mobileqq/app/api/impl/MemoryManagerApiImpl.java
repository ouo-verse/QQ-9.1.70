package com.tencent.mobileqq.app.api.impl;

import com.tencent.mobileqq.app.api.IMemoryManagerApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import sy3.b;

/* compiled from: P */
/* loaded from: classes11.dex */
public class MemoryManagerApiImpl implements IMemoryManagerApi {
    static IPatchRedirector $redirector_;

    public MemoryManagerApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.api.IMemoryManagerApi
    public long getAvailClassSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
        }
        return b.a();
    }
}
