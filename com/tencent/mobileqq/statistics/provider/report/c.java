package com.tencent.mobileqq.statistics.provider.report;

import com.tencent.mobileqq.data.entitymanager.Provider;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import z91.d;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c implements Provider<d> {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements d {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.data.entitymanager.Provider
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public d get() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (d) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new a();
    }
}
