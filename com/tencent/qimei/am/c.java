package com.tencent.qimei.am;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qimei.am.e;
import com.tencent.qimei.sdk.S.SpreadValue;
import com.tencent.qimei.uin.U;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f343065a;

    public c(d dVar) {
        this.f343065a = dVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) dVar);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        d dVar = this.f343065a;
        dVar.getClass();
        if (!U.e()) {
            com.tencent.qimei.ae.a a16 = com.tencent.qimei.ae.a.a(dVar.f343067a);
            str = a16.a();
            str2 = a16.d();
        } else {
            str = "";
            str2 = "";
        }
        HashMap<String, SpreadValue> hashMap = new HashMap<>();
        hashMap.put(dVar.f343069c, new SpreadValue().a(str).e(str2).b(dVar.f343067a).h(dVar.f343068b).f(com.tencent.qimei.an.a.a(dVar.f343067a).getQimei16()).g(com.tencent.qimei.an.a.a(dVar.f343067a).getQimei36()).a(System.currentTimeMillis()).c(dVar.f343067a).d(dVar.f343068b).b(System.currentTimeMillis()));
        String str3 = e.f343072f;
        e.a.f343078a.a(hashMap, dVar.f343067a, dVar.f343068b);
    }
}
