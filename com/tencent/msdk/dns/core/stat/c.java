package com.tencent.msdk.dns.core.stat;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.msdk.dns.core.a;
import com.tencent.msdk.dns.core.i;
import com.tencent.msdk.dns.core.rest.share.g;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class c implements a.InterfaceC9211a {
    static IPatchRedirector $redirector_;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.msdk.dns.core.a.InterfaceC9211a
    public <LookupExtraImpl extends i.a> com.tencent.msdk.dns.core.a<LookupExtraImpl> a(Class<LookupExtraImpl> cls, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.msdk.dns.core.a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) cls, (Object) context);
        }
        if (cls != null) {
            if (context != null) {
                if (g.class.equals(cls)) {
                    return new b(context);
                }
                return a.InterfaceC9211a.f336239a.a(cls, context);
            }
            throw new IllegalArgumentException("context".concat(" can not be null"));
        }
        throw new IllegalArgumentException("klass".concat(" can not be null"));
    }
}
