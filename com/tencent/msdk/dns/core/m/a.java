package com.tencent.msdk.dns.core.m;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.msdk.dns.base.log.c;
import com.tencent.msdk.dns.core.d;
import com.tencent.msdk.dns.core.h;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class a implements h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, d> f336273a;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f336273a = new ConcurrentHashMap();
        }
    }

    @Override // com.tencent.msdk.dns.core.h
    public void a(String str, d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) dVar);
        } else {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("hostname".concat(" can not be empty"));
            }
            if (dVar != null) {
                c.c("Cache %s for %s", dVar, str);
                this.f336273a.put(str, dVar);
                return;
            }
            throw new IllegalArgumentException("lookupResult".concat(" can not be null"));
        }
    }

    @Override // com.tencent.msdk.dns.core.h
    public d b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (d) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        if (!TextUtils.isEmpty(str)) {
            return this.f336273a.get(str);
        }
        throw new IllegalArgumentException("hostname".concat(" can not be empty"));
    }

    @Override // com.tencent.msdk.dns.core.h
    public void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            if (!TextUtils.isEmpty(str)) {
                this.f336273a.remove(str);
                return;
            }
            throw new IllegalArgumentException("hostname".concat(" can not be empty"));
        }
    }

    @Override // com.tencent.msdk.dns.core.h
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            this.f336273a.clear();
        } else {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }
}
