package com.tencent.msdk.dns.core.n.c;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.msdk.dns.core.rest.share.c;
import com.tencent.msdk.dns.core.rest.share.g;
import com.tencent.msdk.dns.core.rest.share.h;
import java.net.SocketAddress;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class a extends com.tencent.msdk.dns.core.rest.share.b {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private c f336285d;

    public a(int i3) {
        super(i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
        } else {
            this.f336285d = null;
            this.f336285d = new b();
        }
    }

    @Override // com.tencent.msdk.dns.core.rest.share.b
    public String e(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) str2);
        }
        return str;
    }

    @Override // com.tencent.msdk.dns.core.rest.share.b
    public String f(String str, String str2, g gVar) {
        String b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, this, str, str2, gVar);
        }
        if (1 == this.f336336b) {
            b16 = h.f(str2, gVar.f336366b, gVar.f336368d);
        } else {
            b16 = h.b(str2, gVar.f336366b, gVar.f336368d);
        }
        return this.f336285d.b(str, b16);
    }

    @Override // com.tencent.msdk.dns.core.rest.share.b
    public SocketAddress g(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (SocketAddress) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, i3);
        }
        return this.f336285d.c(str, i3);
    }

    @Override // com.tencent.msdk.dns.core.rest.share.b
    public String h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "Https";
    }

    @Override // com.tencent.msdk.dns.core.rest.share.b
    public String i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "HttpsDns(" + this.f336336b + ")";
    }
}
