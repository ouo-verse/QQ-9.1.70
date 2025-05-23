package com.tencent.qimei.ag;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qimei.as.a;
import com.tencent.qimei.sdk.IAsyncQimeiListener;
import com.tencent.qimei.sdk.Qimei;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class b implements IAsyncQimeiListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f342969a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f342970b;

    public b(String str, String str2) {
        this.f342969a = str;
        this.f342970b = str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) str2);
        }
    }

    @Override // com.tencent.qimei.sdk.IAsyncQimeiListener
    public void onQimeiDispatch(Qimei qimei) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qimei);
            return;
        }
        try {
            if (!com.tencent.qimei.u.a.f()) {
                return;
            }
            Integer a16 = a.b.I.a(this.f342970b);
            if (a16.intValue() <= 0) {
                com.tencent.qimei.ad.c.b("IsolateRequest", "disable get oid", new Object[0]);
            } else {
                com.tencent.qimei.t.a.a().a(new c(this.f342969a, a16.equals(c.f342971c)));
            }
        } catch (Exception unused) {
            com.tencent.qimei.ad.c.b("IsolateRequest", "get oid with exception", new Object[0]);
        }
    }
}
