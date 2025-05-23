package com.tencent.mobileqq.msf.core.net.u.c;

import com.tencent.mobileqq.msf.core.x.q;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class f {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: c, reason: collision with root package name */
    private static final String f249455c = "UdpClient";

    /* renamed from: d, reason: collision with root package name */
    public static final String f249456d = "14.18.180.90";

    /* renamed from: e, reason: collision with root package name */
    private static volatile f f249457e;

    /* renamed from: a, reason: collision with root package name */
    public b f249458a;

    /* renamed from: b, reason: collision with root package name */
    private final com.tencent.mobileqq.msf.core.quicksend.b f249459b;

    f(com.tencent.mobileqq.msf.core.quicksend.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar);
        } else {
            this.f249458a = new b();
            this.f249459b = bVar;
        }
    }

    public static f a(com.tencent.mobileqq.msf.core.quicksend.b bVar) {
        if (f249457e == null) {
            synchronized (f.class) {
                if (f249457e == null) {
                    f249457e = new f(bVar);
                }
            }
        }
        return f249457e;
    }

    public d a(g gVar) {
        q s16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (d) iPatchRedirector.redirect((short) 2, (Object) this, (Object) gVar);
        }
        d dVar = new d(this, gVar);
        com.tencent.mobileqq.msf.core.quicksend.b bVar = this.f249459b;
        if (bVar != null && bVar.b() != null && (s16 = this.f249459b.b().s()) != null) {
            dVar.a(j.a().b(s16));
        }
        return dVar;
    }
}
