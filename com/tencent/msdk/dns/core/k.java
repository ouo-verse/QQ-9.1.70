package com.tencent.msdk.dns.core;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.msdk.dns.core.i;
import com.tencent.upload.network.session.cache.SessionDbHelper;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class k {

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class a implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ n f336269d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ i f336270e;

        a(n nVar, i iVar) {
            this.f336269d = nVar;
            this.f336270e = iVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) nVar, (Object) iVar);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            Set<i> r16 = this.f336269d.r();
            if (!r16.contains(this.f336270e)) {
                return;
            }
            d b16 = this.f336270e.b(this.f336269d.l());
            if (b16.f336252b.a() || b16.f336252b.e()) {
                r16.remove(this.f336270e);
                if (b16.f336252b.a()) {
                    this.f336269d.A().a(this.f336270e, b16.f336251a.f336250c);
                }
                this.f336269d.B().c(this.f336270e, b16.f336252b);
            }
        }
    }

    public static <LookupExtra extends i.a> void a(i.b bVar, n<LookupExtra> nVar) {
        b(bVar, nVar, false);
    }

    public static <LookupExtra extends i.a> void b(i.b bVar, n<LookupExtra> nVar, boolean z16) {
        if (bVar != null) {
            if (nVar != null) {
                com.tencent.msdk.dns.base.log.c.c("prepareNonBlockLookupTask call, forRetry:%b", Boolean.valueOf(z16));
                if (bVar.a().c()) {
                    com.tencent.msdk.dns.base.log.c.c("prepareNonBlockLookupTask start receive", new Object[0]);
                    String[] b16 = bVar.b();
                    if (bVar.f().a() || bVar.f().e()) {
                        i g16 = bVar.g();
                        if (!z16) {
                            nVar.z().remove(bVar);
                        }
                        nVar.r().remove(g16);
                        if (bVar.f().a()) {
                            nVar.A().a(g16, b16);
                        }
                        nVar.B().c(g16, bVar.f());
                        return;
                    }
                    return;
                }
                if (!z16) {
                    nVar.z().add(bVar);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("lookupContext".concat(" can not be null"));
        }
        throw new IllegalArgumentException(SessionDbHelper.SESSION_ID.concat(" can not be null"));
    }

    public static <LookupExtra extends i.a> void c(i<LookupExtra> iVar, n<LookupExtra> nVar) {
        if (iVar != null) {
            if (nVar != null) {
                nVar.C().a(new a(nVar, iVar));
                return;
            }
            throw new IllegalArgumentException("lookupContext".concat(" can not be null"));
        }
        throw new IllegalArgumentException("dns".concat(" can not be null"));
    }
}
