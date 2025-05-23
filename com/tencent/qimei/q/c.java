package com.tencent.qimei.q;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qimei.ag.e;
import com.tencent.qimei.ag.h;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c {
    static IPatchRedirector $redirector_;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @com.tencent.qimei.p.b
    public static int sendSample(int i3, int i16, int i17) {
        h a16 = h.a();
        a16.getClass();
        e eVar = new e();
        eVar.f342975a.put("6", String.valueOf(i3));
        eVar.f342975a.put("7", String.valueOf(i16));
        eVar.f342975a.put("8", String.valueOf(i17));
        a16.a(eVar, "x8", a.a().f343358a);
        return 0;
    }
}
