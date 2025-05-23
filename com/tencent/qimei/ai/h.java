package com.tencent.qimei.ai;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qimei.am.d;
import com.tencent.qimei.as.a;
import com.tencent.qimei.sdk.IAsyncQimeiListener;
import com.tencent.qimei.sdk.Qimei;
import com.tencent.qimei.uin.U;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class h implements IAsyncQimeiListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f343037a;

    public h(e eVar) {
        this.f343037a = eVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) eVar);
        }
    }

    @Override // com.tencent.qimei.sdk.IAsyncQimeiListener
    public void onQimeiDispatch(Qimei qimei) {
        com.tencent.qimei.am.d dVar;
        int i3;
        String str;
        String str2;
        String f16;
        String i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qimei);
            return;
        }
        com.tencent.qimei.af.a a16 = com.tencent.qimei.af.a.a();
        String str3 = this.f343037a.f343025d;
        synchronized (a16) {
        }
        com.tencent.qimei.ak.a a17 = com.tencent.qimei.ak.a.a(this.f343037a.f343025d);
        if (a17.a()) {
            if (a17.f343051c) {
                i3 = 2;
            } else if (a17.f343050b) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            StringBuilder sb5 = new StringBuilder();
            if (a17.f343051c) {
                str = "1";
            } else {
                str = "0";
            }
            sb5.append(str);
            if (a17.f343050b) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            sb5.append(str2);
            sb5.append(a17.f343052d);
            String sb6 = sb5.toString();
            if (a17.f343053e == null) {
                a17.f343053e = new Qimei(a17.f343049a);
            }
            String str4 = a17.f343049a;
            com.tencent.qimei.ap.a aVar = new com.tencent.qimei.ap.a(str4);
            String qimei16 = a17.f343053e.getQimei16();
            String qimei36 = a17.f343053e.getQimei36();
            if (aVar.c() == null) {
                f16 = "";
            } else {
                f16 = aVar.c().f();
            }
            if (aVar.c() == null) {
                i16 = "";
            } else {
                i16 = aVar.c().i();
            }
            com.tencent.qimei.ag.h a18 = com.tencent.qimei.ag.h.a();
            a18.getClass();
            com.tencent.qimei.ag.e eVar = new com.tencent.qimei.ag.e();
            eVar.f342975a.put("6", qimei16);
            eVar.f342975a.put("7", qimei36);
            eVar.f342975a.put("9", f16);
            eVar.f342975a.put("10", i16);
            eVar.f342975a.put("8", String.valueOf(i3));
            eVar.f342975a.put("11", sb6);
            a18.a(eVar, "v7", str4);
            com.tencent.qimei.ad.c.b("CloneDetect", "%s, %s is clone\uff0ctype\uff1a%d", str4, com.tencent.qimei.u.a.d(), Integer.valueOf(i3));
        }
        String str5 = this.f343037a.f343025d;
        synchronized (com.tencent.qimei.am.d.class) {
            Map<String, com.tencent.qimei.am.d> map = com.tencent.qimei.am.d.f343066e;
            dVar = map.get(str5);
            if (dVar == null) {
                dVar = new com.tencent.qimei.am.d(str5);
                map.put(str5, dVar);
            }
        }
        com.tencent.qimei.at.a aVar2 = com.tencent.qimei.ar.a.a(dVar.f343067a).f343094b;
        aVar2.getClass();
        if (com.tencent.qimei.as.a.a(a.InterfaceC9310a.f343126x, aVar2.f343146r).booleanValue() && com.tencent.qimei.u.a.f()) {
            com.tencent.qimei.t.a.a().a(new com.tencent.qimei.am.c(dVar));
            com.tencent.qimei.t.a.a().a(a.b.F.a(com.tencent.qimei.ar.d.a(com.tencent.qimei.ar.a.a(dVar.f343067a).f343094b.f343146r)).intValue() * 1000, new d.a());
        }
        String str6 = this.f343037a.f343025d;
        com.tencent.qimei.at.a aVar3 = com.tencent.qimei.ar.a.a(str6).f343094b;
        aVar3.getClass();
        if (com.tencent.qimei.as.a.a(a.InterfaceC9310a.f343128z, aVar3.f343146r).booleanValue()) {
            U.f(str6);
        }
    }
}
