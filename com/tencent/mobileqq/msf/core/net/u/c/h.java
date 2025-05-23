package com.tencent.mobileqq.msf.core.net.u.c;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.net.DatagramPacket;

/* compiled from: P */
/* loaded from: classes15.dex */
public class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final DatagramPacket f249465a;

    public h(DatagramPacket datagramPacket) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) datagramPacket);
        } else {
            this.f249465a = datagramPacket;
        }
    }

    public DatagramPacket a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (DatagramPacket) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f249465a;
    }
}
