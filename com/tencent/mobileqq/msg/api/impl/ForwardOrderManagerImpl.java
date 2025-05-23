package com.tencent.mobileqq.msg.api.impl;

import com.tencent.mobileqq.activity.aio.forward.b;
import com.tencent.mobileqq.msg.api.IForwardOrderManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class ForwardOrderManagerImpl implements IForwardOrderManager {
    static IPatchRedirector $redirector_;

    public ForwardOrderManagerImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.msg.api.IForwardOrderManager
    public void mapUniSeqId(long j3, long j16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3));
        } else {
            b.d().e(j3, j16, i3);
        }
    }
}
