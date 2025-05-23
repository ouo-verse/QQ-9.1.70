package com.tencent.qimei.ai;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qimei.report.beat.BeatType;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class f implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f343035a;

    public f(e eVar) {
        this.f343035a = eVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) eVar);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        com.tencent.qimei.ar.c cVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        com.tencent.qimei.ab.e.a().a(this.f343035a.f343025d);
        com.tencent.qimei.y.b a16 = com.tencent.qimei.y.b.a();
        Context context = this.f343035a.f343026e;
        synchronized (a16) {
            if (a16.f343430a.isEmpty()) {
                a16.f343433d = com.tencent.qimei.f.a.b();
                int i3 = Build.VERSION.SDK_INT;
                a16.f343431b = new com.tencent.qimei.y.a(a16);
                a16.f343434e = (ConnectivityManager) context.getSystemService("connectivity");
                NetworkRequest.Builder builder = new NetworkRequest.Builder();
                builder.addTransportType(0);
                builder.addTransportType(1);
                builder.addTransportType(3);
                builder.addTransportType(4);
                if (i3 >= 26) {
                    builder.addTransportType(5);
                }
                if (i3 >= 27) {
                    builder.addTransportType(6);
                }
                ConnectivityManager connectivityManager = a16.f343434e;
                if (connectivityManager != null) {
                    try {
                        connectivityManager.registerNetworkCallback(builder.build(), a16.f343431b);
                    } catch (SecurityException e16) {
                        com.tencent.qimei.ad.c.a(e16);
                    }
                }
            }
        }
        com.tencent.qimei.y.b a17 = com.tencent.qimei.y.b.a();
        e eVar = this.f343035a;
        String str = eVar.f343025d;
        synchronized (a17) {
            a17.f343430a.put(eVar, str);
        }
        com.tencent.qimei.av.f a18 = com.tencent.qimei.av.f.a(this.f343035a.f343025d);
        e eVar2 = this.f343035a;
        a18.f343163g = eVar2.f343026e;
        a18.f343164h = a18;
        com.tencent.qimei.ar.a a19 = com.tencent.qimei.ar.a.a(eVar2.f343025d);
        e eVar3 = this.f343035a;
        String str2 = a19.f343093a;
        synchronized (com.tencent.qimei.ar.c.class) {
            Map<String, com.tencent.qimei.ar.c> map = com.tencent.qimei.ar.c.f343096d;
            cVar = map.get(str2);
            if (cVar == null) {
                cVar = new com.tencent.qimei.ar.c(str2);
                map.put(str2, cVar);
            }
        }
        com.tencent.qimei.ar.e eVar4 = cVar.f343099b;
        eVar4.f343105d = eVar3;
        try {
            String d16 = com.tencent.qimei.aa.f.b(eVar4.f343102a).d("s_d");
            if (!d16.equals("")) {
                try {
                    d16 = com.tencent.qimei.f.a.a(d16, com.tencent.qimei.f.a.a("s_d"));
                } catch (Exception e17) {
                    e17.printStackTrace();
                }
            }
            if (d16 != null) {
                eVar4.a(d16, false);
            }
        } catch (Exception e18) {
            com.tencent.qimei.ad.c.a(e18);
        }
        com.tencent.qimei.ad.c.b("QM", "start Strategy request task(appKey: %s)", cVar.f343098a);
        if (com.tencent.qimei.f.a.b()) {
            cVar.a();
        } else {
            com.tencent.qimei.ad.c.b("QM", "no network,cancel strategy request(appKey: %s)", cVar.f343098a);
        }
        com.tencent.qimei.y.b a26 = com.tencent.qimei.y.b.a();
        String str3 = cVar.f343098a;
        com.tencent.qimei.ar.b bVar = new com.tencent.qimei.ar.b(cVar);
        synchronized (a26) {
            a26.f343430a.put(bVar, str3);
        }
        com.tencent.qimei.ad.c.b("SDK_INIT \uff5c STRATEGY", " initialization finished ", new Object[0]);
        b.a(this.f343035a.f343025d).a();
        com.tencent.qimei.ah.a.a(this.f343035a.f343025d, BeatType.INIT, "0");
        String str4 = this.f343035a.f343025d;
        if (TextUtils.isEmpty(com.tencent.qimei.aa.f.b(str4).d("is_first"))) {
            com.tencent.qimei.t.a.a().a(r1 * 1000, new com.tencent.qimei.ak.b(str4, com.tencent.qimei.an.b.f343085a.nextInt(3) + 1));
        }
        k b16 = k.b(this.f343035a.f343025d);
        if (b16.f343046e.equals("1")) {
            com.tencent.qimei.f.a.b(b16.f343042a, "1");
        }
        e eVar5 = this.f343035a;
        eVar5.getQimei(new h(eVar5));
    }
}
