package com.tencent.qimei.ae;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qimei.as.a;
import com.tencent.qimei.uin.U;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
@SuppressLint({"MissingPermission"})
/* loaded from: classes22.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static final Map<String, a> f342944d;

    /* renamed from: a, reason: collision with root package name */
    public final String f342945a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f342946b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f342947c;

    /* compiled from: P */
    /* renamed from: com.tencent.qimei.ae.a$a, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public class C9305a implements m {
        static IPatchRedirector $redirector_;

        public C9305a(a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            }
        }

        @Override // com.tencent.qimei.ae.m
        public String a() {
            com.tencent.qimei.u.c cVar;
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            synchronized (com.tencent.qimei.u.c.class) {
                cVar = com.tencent.qimei.u.c.f343390p;
            }
            synchronized (cVar) {
                str = cVar.f343400j;
                if (str == null) {
                    str = DeviceInfoMonitor.getModel();
                    cVar.f343400j = str;
                }
            }
            return str;
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class b implements m {
        static IPatchRedirector $redirector_;

        public b(a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            }
        }

        @Override // com.tencent.qimei.ae.m
        public String a() {
            com.tencent.qimei.u.c cVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            synchronized (com.tencent.qimei.u.c.class) {
                cVar = com.tencent.qimei.u.c.f343390p;
            }
            String str = cVar.f343398h;
            if (str == null) {
                return "";
            }
            return str;
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class c implements m {
        static IPatchRedirector $redirector_;

        public c(a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            }
        }

        @Override // com.tencent.qimei.ae.m
        public String a() {
            com.tencent.qimei.u.c cVar;
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            synchronized (com.tencent.qimei.u.c.class) {
                cVar = com.tencent.qimei.u.c.f343390p;
            }
            synchronized (cVar.f343402l) {
                if (TextUtils.isEmpty(cVar.f343401k)) {
                    cVar.f343401k = U.a(cVar.f343391a);
                }
                str = cVar.f343401k;
            }
            return str;
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class d implements m {
        static IPatchRedirector $redirector_;

        public d(a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            }
        }

        @Override // com.tencent.qimei.ae.m
        public String a() {
            com.tencent.qimei.u.c cVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            synchronized (com.tencent.qimei.u.c.class) {
                cVar = com.tencent.qimei.u.c.f343390p;
            }
            return cVar.b();
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class e implements m {
        static IPatchRedirector $redirector_;

        public e(a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            }
        }

        @Override // com.tencent.qimei.ae.m
        public String a() {
            com.tencent.qimei.u.c cVar;
            String str;
            Enumeration<InetAddress> inetAddresses;
            String hostAddress;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            synchronized (com.tencent.qimei.u.c.class) {
                cVar = com.tencent.qimei.u.c.f343390p;
            }
            synchronized (cVar) {
                if (cVar.f343399i == null) {
                    synchronized (cVar) {
                        if (cVar.f343405o == null) {
                            try {
                                cVar.f343405o = NetworkMonitor.getNetworkInterfaces();
                            } catch (SocketException e16) {
                                com.tencent.qimei.ad.c.a(e16);
                            }
                        }
                        Enumeration<NetworkInterface> enumeration = cVar.f343405o;
                        if (enumeration != null) {
                            loop0: while (enumeration.hasMoreElements()) {
                                NetworkInterface nextElement = enumeration.nextElement();
                                if (nextElement != null && (inetAddresses = NetworkMonitor.getInetAddresses(nextElement)) != null) {
                                    while (inetAddresses.hasMoreElements()) {
                                        InetAddress nextElement2 = inetAddresses.nextElement();
                                        if (!nextElement2.isLoopbackAddress() && (nextElement2 instanceof Inet4Address)) {
                                            hostAddress = nextElement2.getHostAddress();
                                            break loop0;
                                        }
                                    }
                                }
                            }
                        }
                        hostAddress = "0.0.0.0";
                        cVar.f343399i = hostAddress;
                    }
                }
                str = cVar.f343399i;
            }
            return str;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20037);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f342944d = new ConcurrentHashMap();
        }
    }

    public a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.f342946b = new Object();
        this.f342947c = false;
        this.f342945a = str;
    }

    public static synchronized a a(String str) {
        a aVar;
        synchronized (a.class) {
            Map<String, a> map = f342944d;
            aVar = map.get(str);
            if (aVar == null) {
                aVar = new a(str);
                map.put(str, aVar);
            }
        }
        return aVar;
    }

    public String b() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        String str = com.tencent.qimei.ar.a.a(this.f342945a).f343094b.f343145q;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        com.tencent.qimei.at.a aVar = com.tencent.qimei.ar.a.a(this.f342945a).f343094b;
        if (aVar.f343137i && aVar.f343138j) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return "";
        }
        return k.a().a(6, new C9305a(this));
    }

    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (!com.tencent.qimei.ar.a.a(this.f342945a).f343094b.f343138j) {
            return "";
        }
        return k.a().a(11, new e(this));
    }

    public String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        String str = com.tencent.qimei.ar.a.a(this.f342945a).f343094b.f343143o;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        if (!com.tencent.qimei.ar.a.a(this.f342945a).f343094b.a()) {
            return "";
        }
        return k.a().a(7, new b(this));
    }

    public String e() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        com.tencent.qimei.at.a aVar = com.tencent.qimei.ar.a.a(this.f342945a).f343094b;
        if (aVar.f343138j && com.tencent.qimei.as.a.a(a.InterfaceC9310a.f343122t, aVar.f343146r).booleanValue()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return "";
        }
        return k.a().a(8, new c(this));
    }

    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        String str = com.tencent.qimei.ar.a.a(this.f342945a).f343094b.f343144p;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        com.tencent.qimei.at.a aVar = com.tencent.qimei.ar.a.a(this.f342945a).f343094b;
        return !(aVar.f343132d && aVar.f343138j && com.tencent.qimei.as.a.a(a.InterfaceC9310a.f343111i, aVar.f343146r).booleanValue()) ? "" : k.a().a(3, new d(this));
    }
}
