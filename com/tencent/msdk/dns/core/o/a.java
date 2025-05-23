package com.tencent.msdk.dns.core.o;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.msdk.dns.base.log.c;
import com.tencent.msdk.dns.core.i;
import com.tencent.msdk.dns.core.k;
import com.tencent.msdk.dns.core.l;
import com.tencent.msdk.dns.core.n;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class a implements l {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.msdk.dns.core.l
    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return 1;
        }
        return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
    }

    @Override // com.tencent.msdk.dns.core.l
    public <LookupExtra extends i.a> void b(n<LookupExtra> nVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) nVar);
            return;
        }
        if (nVar != null) {
            c.c("Retry lookup for %s(%d) block", nVar.u(), Integer.valueOf(nVar.t()));
            Set<i> r16 = nVar.r();
            synchronized (r16) {
                Iterator<i> it = r16.iterator();
                while (it.hasNext()) {
                    k.c(it.next(), nVar);
                }
            }
            nVar.C().c();
            return;
        }
        throw new IllegalArgumentException("lookupContext".concat(" can not be null"));
    }

    @Override // com.tencent.msdk.dns.core.l
    public void a(n nVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) nVar);
            return;
        }
        if (nVar != null) {
            List<i.b> z16 = nVar.z();
            c.c("Retry lookup for %s(%d) nonBlock session:%d  start", nVar.u(), Integer.valueOf(nVar.t()), Integer.valueOf(z16.size()));
            Iterator<i.b> it = z16.iterator();
            while (it.hasNext()) {
                k.b(it.next().i(), nVar, true);
            }
            c.c("Retry lookup for %s(%d) nonBlock session:%d finish.", nVar.u(), Integer.valueOf(nVar.t()), Integer.valueOf(z16.size()));
            return;
        }
        throw new IllegalArgumentException("lookupContext".concat(" can not be null"));
    }
}
