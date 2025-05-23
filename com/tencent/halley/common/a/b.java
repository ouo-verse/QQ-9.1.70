package com.tencent.halley.common.a;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static String f113212a;

    /* renamed from: b, reason: collision with root package name */
    private static String f113213b;

    /* renamed from: c, reason: collision with root package name */
    private static Map<Integer, a> f113214c;

    /* renamed from: d, reason: collision with root package name */
    private static Map<String, a> f113215d;

    /* renamed from: e, reason: collision with root package name */
    private static e f113216e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        String f113218a;

        /* renamed from: b, reason: collision with root package name */
        Integer f113219b;

        /* renamed from: c, reason: collision with root package name */
        String f113220c;

        /* renamed from: d, reason: collision with root package name */
        String f113221d;

        /* renamed from: e, reason: collision with root package name */
        List<com.tencent.halley.common.a.a> f113222e;

        /* renamed from: f, reason: collision with root package name */
        String f113223f;

        /* renamed from: g, reason: collision with root package name */
        int f113224g;

        public a(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            } else {
                this.f113222e = new ArrayList();
                this.f113218a = str;
            }
        }

        public final List<com.tencent.halley.common.a.a> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (List) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.f113222e);
            return arrayList;
        }

        public final synchronized void b(com.tencent.halley.common.a.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
                return;
            }
            if (aVar == null) {
                return;
            }
            byte b16 = aVar.f113198e;
            if (b16 == 1 || b16 == 2) {
                if (this.f113222e.contains(aVar)) {
                    this.f113222e.remove(aVar);
                    com.tencent.halley.common.utils.d.b(b.f113213b, "remove accessIp:".concat(String.valueOf(aVar)));
                    return;
                }
                com.tencent.halley.common.utils.d.b(b.f113213b, "not contain ready to remove accessIp:".concat(String.valueOf(aVar)));
            }
        }

        public final String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Appid\uff1a" + this.f113219b + " domain\uff1a" + this.f113220c + "\r\n");
            sb5.append("apn\uff1a" + this.f113218a + " ckIP\uff1a" + this.f113221d + "\r\n");
            Iterator<com.tencent.halley.common.a.a> it = a().iterator();
            while (it.hasNext()) {
                sb5.append("accessIP\uff1a" + it.next().toString() + "\r\n");
            }
            return sb5.toString();
        }

        public final void a(com.tencent.halley.common.a.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
                return;
            }
            if (aVar == null) {
                return;
            }
            byte b16 = aVar.f113198e;
            if (b16 > 0 && b16 <= 5) {
                this.f113222e.add(aVar);
                return;
            }
            com.tencent.halley.common.utils.d.e(b.f113213b, "Error when addAccessIPToList as iptype:" + ((int) aVar.f113198e));
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16483);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        f113213b = "halley-cloud-AccessIpMgr";
        f113214c = new ConcurrentHashMap();
        f113215d = new ConcurrentHashMap();
        f113216e = new e() { // from class: com.tencent.halley.common.a.b.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // com.tencent.halley.common.a.e
            public final void a(int i3, String str) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    com.tencent.halley.common.utils.d.d(b.f113213b, "onNetworkSwitch refresh ScheduleInfo:" + str + ",netType:" + i3);
                    if (i3 != 0) {
                        b.b();
                        b.c();
                        b.f113212a = str;
                        return;
                    }
                    return;
                }
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
            }
        };
    }

    public static com.tencent.halley.common.a.c.b a(String str) {
        a aVar = f113215d.get(str);
        if (aVar != null) {
            com.tencent.halley.common.a.c.b bVar = new com.tencent.halley.common.a.c.b(aVar.f113220c, aVar.f113223f);
            List<com.tencent.halley.common.a.a> a16 = aVar.a();
            bVar.f113261c = a16;
            if (!a16.isEmpty()) {
                return bVar;
            }
        }
        com.tencent.halley.common.a.a aVar2 = new com.tencent.halley.common.a.a(str);
        aVar2.f113198e = (byte) 3;
        com.tencent.halley.common.a.c.b bVar2 = new com.tencent.halley.common.a.c.b(str, "");
        ArrayList arrayList = new ArrayList();
        arrayList.add(aVar2);
        bVar2.f113261c = arrayList;
        return bVar2;
    }

    public static void b() {
        com.tencent.halley.common.d.h.d().f();
        com.tencent.halley.common.utils.d.d(f113213b, "appidSchContainers is null.");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void c() {
        String str;
        String valueOf;
        String str2;
        List<com.tencent.halley.common.a.c.b> a16 = com.tencent.halley.common.d.h.d().f().a();
        if (a16 != null) {
            boolean z16 = false;
            if (h.a("app_schdule_use_ipv6", 0, 1, 1) == 1) {
                z16 = true;
            }
            f113215d.clear();
            for (com.tencent.halley.common.a.c.b bVar : a16) {
                a aVar = new a(f113212a);
                aVar.f113220c = bVar.f113259a;
                String str3 = bVar.f113260b;
                aVar.f113223f = str3;
                aVar.f113224g = bVar.f113262d;
                boolean startsWith = str3.startsWith("bottom");
                for (com.tencent.halley.common.a.a aVar2 : bVar.f113261c) {
                    if (!z16 && aVar2.c()) {
                        com.tencent.halley.common.utils.d.b(f113213b, "ignore ipv6 accessIp due to cloud-settings");
                    } else if (c.i() == 1) {
                        if (aVar2.c()) {
                            str = f113213b;
                            valueOf = String.valueOf(aVar2);
                            str2 = "ignore ipv6 accessIp for ipv4 only, accessIp: ";
                            com.tencent.halley.common.utils.d.b(str, str2.concat(valueOf));
                        } else {
                            if (startsWith) {
                                aVar2.f113198e = (byte) 5;
                            }
                            com.tencent.halley.common.utils.d.b(f113213b, "directScheduleInfo " + aVar2 + " for domain:" + aVar.f113220c);
                            aVar.a(aVar2);
                        }
                    } else {
                        if (c.i() == 3 && !aVar2.c()) {
                            str = f113213b;
                            valueOf = String.valueOf(aVar2);
                            str2 = "ignore ipv4 accessIp for ipv6 only, accessIp: ";
                            com.tencent.halley.common.utils.d.b(str, str2.concat(valueOf));
                        }
                        if (startsWith) {
                        }
                        com.tencent.halley.common.utils.d.b(f113213b, "directScheduleInfo " + aVar2 + " for domain:" + aVar.f113220c);
                        aVar.a(aVar2);
                    }
                }
                com.tencent.halley.common.a.a aVar3 = new com.tencent.halley.common.a.a(bVar.f113259a);
                aVar3.f113198e = (byte) 3;
                aVar.a(aVar3);
                com.tencent.halley.common.utils.d.b(f113213b, "directScheduleInfo " + aVar3 + " for domain:" + aVar.f113220c);
                Collections.sort(aVar.f113222e, new Comparator<com.tencent.halley.common.a.a>() { // from class: com.tencent.halley.common.a.b.a.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
                        }
                    }

                    @Override // java.util.Comparator
                    public final /* bridge */ /* synthetic */ int compare(com.tencent.halley.common.a.a aVar4, com.tencent.halley.common.a.a aVar5) {
                        return aVar4.f113198e - aVar5.f113198e;
                    }
                });
                f113215d.put(bVar.f113259a, aVar);
            }
            return;
        }
        com.tencent.halley.common.utils.d.d(f113213b, "getDirectAccessInfo is null.");
    }

    static /* synthetic */ void e() {
        com.tencent.halley.common.utils.d.d(f113213b, "init Get Schedule Info start.");
        f113212a = c.b();
        b();
        c();
        com.tencent.halley.common.utils.d.d(f113213b, "init Get Schedule Info end.");
    }

    public static void a() {
        com.tencent.halley.common.a.h().post(new Runnable() { // from class: com.tencent.halley.common.a.b.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    b.e();
                    c.a(b.f113213b, b.f113216e);
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
        });
    }

    public static void a(String str, com.tencent.halley.common.a.a aVar, int i3, int i16) {
        a aVar2;
        if ((i3 != 0 || i16 >= 500) && (aVar2 = f113215d.get(str)) != null) {
            aVar2.b(aVar);
        }
    }
}
