package com.tencent.mobileqq.msf.core.net.u.b;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes15.dex */
public class j implements d {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    private static final String f249419a = "UdpSwitchFilter";

    public j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.msf.core.net.u.b.d
    public ToServiceMsg a(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 2, (Object) this, (Object) toServiceMsg);
        }
        if (toServiceMsg == null) {
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f249419a, 2, "[filter] udp switch: ", Boolean.valueOf(com.tencent.mobileqq.msf.core.x.d.d1()), com.tencent.mobileqq.msf.core.z.a.b(toServiceMsg));
        }
        if (!com.tencent.mobileqq.msf.core.x.d.d1()) {
            return null;
        }
        return toServiceMsg;
    }
}
