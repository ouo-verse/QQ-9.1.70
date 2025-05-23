package com.tencent.msdk.dns.core.rest.share;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

/* compiled from: P */
/* loaded from: classes21.dex */
public abstract class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private SocketAddress f336346a;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f336346a = null;
        }
    }

    public abstract int a();

    public abstract String b(String str, String str2);

    public SocketAddress c(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SocketAddress) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, i3);
        }
        try {
            this.f336346a = new InetSocketAddress(InetAddress.getByName(str), a());
        } catch (Exception unused) {
        }
        return this.f336346a;
    }
}
