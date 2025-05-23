package com.tencent.msdk.dns.core;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.msdk.dns.core.i;
import com.tencent.msdk.dns.core.i.c;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class d<Statistics extends i.c> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final c f336251a;

    /* renamed from: b, reason: collision with root package name */
    public final Statistics f336252b;

    public d(String[] strArr, Statistics statistics) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) strArr, (Object) statistics);
        } else {
            if (strArr == null) {
                throw new IllegalArgumentException("ips".concat(" can not be null"));
            }
            if (statistics != null) {
                this.f336251a = new c(strArr);
                this.f336252b = statistics;
                return;
            }
            throw new IllegalArgumentException("stat".concat(" can not be null"));
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "LookupResult{ipSet=" + this.f336251a + ", stat=" + this.f336252b + '}';
    }

    public d(c cVar, Statistics statistics) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar, (Object) statistics);
        } else {
            if (cVar == null) {
                throw new IllegalArgumentException("ipSet".concat(" can not be null"));
            }
            if (statistics != null) {
                this.f336251a = cVar;
                this.f336252b = statistics;
                return;
            }
            throw new IllegalArgumentException("stat".concat(" can not be null"));
        }
    }
}
