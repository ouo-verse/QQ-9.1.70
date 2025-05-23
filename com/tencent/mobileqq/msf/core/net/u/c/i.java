package com.tencent.mobileqq.msf.core.net.u.c;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.net.DatagramSocket;
import java.net.SocketException;

/* compiled from: P */
/* loaded from: classes15.dex */
public class i extends DatagramSocket {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: b, reason: collision with root package name */
    private static final String f249466b = "MsfUdpSocket";

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.mobileqq.msf.core.d f249467a;

    public i(com.tencent.mobileqq.msf.core.d dVar) throws SocketException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.f249467a = dVar;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) dVar);
        }
    }

    public boolean a(i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) iVar)).booleanValue();
        }
        if (iVar != null && iVar.f249467a.equals(this.f249467a)) {
            return true;
        }
        return false;
    }

    public i(int i3) throws SocketException {
        super(i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, i3);
    }
}
