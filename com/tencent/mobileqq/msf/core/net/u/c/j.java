package com.tencent.mobileqq.msf.core.net.u.c;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.x.q;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes15.dex */
public class j {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: b, reason: collision with root package name */
    private static final String f249468b = "UdpSsoEndpointManager";

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentMap<String, Integer> f249469a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final j f249470a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26158);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f249470a = new j(null);
            }
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* synthetic */ j(a aVar) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
    }

    public void a(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return;
        }
        iPatchRedirector.redirect((short) 4, (Object) this, (Object) dVar);
    }

    public void b(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return;
        }
        iPatchRedirector.redirect((short) 5, (Object) this, (Object) dVar);
    }

    j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.f249469a = new ConcurrentHashMap();
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static j a() {
        return b.f249470a;
    }

    public com.tencent.mobileqq.msf.core.d b(q qVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.mobileqq.msf.core.d) iPatchRedirector.redirect((short) 3, (Object) this, (Object) qVar);
        }
        CopyOnWriteArrayList<com.tencent.mobileqq.msf.core.d> a16 = a(qVar);
        com.tencent.mobileqq.msf.core.d dVar = a16.get(com.tencent.mobileqq.msf.core.net.utils.e.a(0, a16.size()));
        com.tencent.mobileqq.msf.core.d dVar2 = new com.tencent.mobileqq.msf.core.d();
        dVar2.b(dVar.b());
        dVar2.a(21000);
        return dVar2;
    }

    private CopyOnWriteArrayList<com.tencent.mobileqq.msf.core.d> a(q qVar) {
        if (NetConnInfoCenter.isWifiConn()) {
            return qVar.a(q.c.a(q.f250388t, q.f250391w, q.f250393y), true);
        }
        return qVar.a(q.c.a(q.f250388t, q.f250392x, q.f250393y), true);
    }
}
