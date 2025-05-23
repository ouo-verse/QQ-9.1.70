package com.tencent.gamecenter.wadl.sdk.common.b;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes6.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    private static String f107002b = "AccessIpMgr";

    /* renamed from: c, reason: collision with root package name */
    public static String f107003c;

    /* renamed from: a, reason: collision with root package name */
    private static d f107001a = new a();

    /* renamed from: d, reason: collision with root package name */
    private static Map<Integer, c> f107004d = new ConcurrentHashMap();

    /* renamed from: e, reason: collision with root package name */
    private static Map<String, c> f107005e = new ConcurrentHashMap();

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a implements d {
        a() {
        }

        @Override // com.tencent.gamecenter.wadl.sdk.common.b.d
        public void onNetworkSwitch(int i3, String str) {
            com.tencent.gamecenter.wadl.sdk.common.e.b.e(b.f107002b, "onNetworkSwitch refresh ScheduleInfo:" + str + ",netType:" + i3);
            if (i3 != 0) {
                b.g();
                b.f();
                b.f107003c = str;
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.gamecenter.wadl.sdk.common.b.b$b, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    class RunnableC1122b implements Runnable {
        RunnableC1122b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                b.e();
                com.tencent.gamecenter.wadl.sdk.common.b.c.a(b.f107002b, b.f107001a);
            } catch (Throwable th5) {
                com.tencent.gamecenter.wadl.sdk.common.e.b.c(b.f107002b, "init failed.", th5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        String f107006a;

        /* renamed from: b, reason: collision with root package name */
        Integer f107007b;

        /* renamed from: c, reason: collision with root package name */
        String f107008c;

        /* renamed from: d, reason: collision with root package name */
        String f107009d;

        /* renamed from: e, reason: collision with root package name */
        List<com.tencent.gamecenter.wadl.sdk.common.b.a> f107010e = new ArrayList();

        /* renamed from: f, reason: collision with root package name */
        String f107011f;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes6.dex */
        public class a implements Comparator<com.tencent.gamecenter.wadl.sdk.common.b.a> {
            a(c cVar) {
            }

            @Override // java.util.Comparator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(com.tencent.gamecenter.wadl.sdk.common.b.a aVar, com.tencent.gamecenter.wadl.sdk.common.b.a aVar2) {
                return aVar.f106999c - aVar2.f106999c;
            }
        }

        public c(String str) {
            this.f107006a = str;
        }

        public List<com.tencent.gamecenter.wadl.sdk.common.b.a> a() {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.f107010e);
            return arrayList;
        }

        public void b(com.tencent.gamecenter.wadl.sdk.common.b.a aVar) {
            if (aVar == null) {
                return;
            }
            byte b16 = aVar.f106999c;
            if (b16 < 1 || b16 > 5) {
                com.tencent.gamecenter.wadl.sdk.common.e.b.b(b.f107002b, "Error when addAccessIPToList as iptype:" + ((int) aVar.f106999c));
                return;
            }
            this.f107010e.add(aVar);
        }

        public void c() {
            Collections.sort(this.f107010e, new a(this));
        }

        public synchronized void d(com.tencent.gamecenter.wadl.sdk.common.b.a aVar) {
            String str;
            String str2;
            if (aVar == null) {
                return;
            }
            byte b16 = aVar.f106999c;
            if (b16 == 1 || b16 == 2) {
                if (!this.f107010e.contains(aVar)) {
                    str = b.f107002b;
                    str2 = "not contain ready to remove accessIp:" + aVar;
                } else {
                    this.f107010e.remove(aVar);
                    str = b.f107002b;
                    str2 = "remove accessIp:" + aVar;
                }
                com.tencent.gamecenter.wadl.sdk.common.e.b.a(str, str2);
            }
        }

        public String toString() {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Appid\uff1a" + this.f107007b + " domain\uff1a" + this.f107008c + "\r\n");
            sb5.append("apn\uff1a" + this.f107006a + " ckIP\uff1a" + this.f107009d + "\r\n");
            Iterator<com.tencent.gamecenter.wadl.sdk.common.b.a> it = a().iterator();
            while (it.hasNext()) {
                sb5.append("accessIP\uff1a" + it.next().toString() + "\r\n");
            }
            return sb5.toString();
        }
    }

    public static com.tencent.gamecenter.wadl.sdk.common.b.k.c a(String str) {
        c cVar = f107005e.get(str);
        if (cVar != null) {
            com.tencent.gamecenter.wadl.sdk.common.b.k.c cVar2 = new com.tencent.gamecenter.wadl.sdk.common.b.k.c(cVar.f107008c, cVar.f107011f);
            List<com.tencent.gamecenter.wadl.sdk.common.b.a> a16 = cVar.a();
            cVar2.f107057c = a16;
            if (!a16.isEmpty()) {
                return cVar2;
            }
        }
        com.tencent.gamecenter.wadl.sdk.common.b.a aVar = new com.tencent.gamecenter.wadl.sdk.common.b.a(str, -1);
        aVar.a((byte) 3);
        com.tencent.gamecenter.wadl.sdk.common.b.k.c cVar3 = new com.tencent.gamecenter.wadl.sdk.common.b.k.c(str, "");
        ArrayList arrayList = new ArrayList();
        arrayList.add(aVar);
        cVar3.f107057c = arrayList;
        return cVar3;
    }

    public static void d() {
        com.tencent.gamecenter.wadl.sdk.common.a.g().post(new RunnableC1122b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e() {
        com.tencent.gamecenter.wadl.sdk.common.e.b.e(f107002b, "init Get Schedule Info start.");
        f107003c = com.tencent.gamecenter.wadl.sdk.common.b.c.b();
        g();
        f();
        com.tencent.gamecenter.wadl.sdk.common.e.b.e(f107002b, "init Get Schedule Info end.");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void f() {
        String str;
        StringBuilder sb5;
        String str2;
        List<com.tencent.gamecenter.wadl.sdk.common.b.k.c> a16 = com.tencent.gamecenter.wadl.sdk.common.d.h.e().f().a();
        if (a16 != null) {
            boolean z16 = false;
            if (g.a("app_schdule_use_ipv6", 0, 1, 1) == 1) {
                z16 = true;
            }
            f107005e.clear();
            for (com.tencent.gamecenter.wadl.sdk.common.b.k.c cVar : a16) {
                c cVar2 = new c(f107003c);
                cVar2.f107008c = cVar.f107055a;
                String str3 = cVar.f107056b;
                cVar2.f107011f = str3;
                boolean startsWith = str3.startsWith("bottom");
                for (com.tencent.gamecenter.wadl.sdk.common.b.a aVar : cVar.f107057c) {
                    if (!z16 && aVar.b()) {
                        com.tencent.gamecenter.wadl.sdk.common.e.b.a(f107002b, "ignore ipv6 accessIp due to cloud-settings");
                    } else if (com.tencent.gamecenter.wadl.sdk.common.b.c.c() == 1) {
                        if (aVar.b()) {
                            str = f107002b;
                            sb5 = new StringBuilder();
                            str2 = "ignore ipv6 accessIp for ipv4 only, accessIp: ";
                            sb5.append(str2);
                            sb5.append(aVar);
                            com.tencent.gamecenter.wadl.sdk.common.e.b.a(str, sb5.toString());
                        } else {
                            if (startsWith) {
                                aVar.a((byte) 5);
                            }
                            com.tencent.gamecenter.wadl.sdk.common.e.b.a(f107002b, "directScheduleInfo " + aVar + " for domain:" + cVar2.f107008c);
                            cVar2.b(aVar);
                        }
                    } else {
                        if (com.tencent.gamecenter.wadl.sdk.common.b.c.c() == 3 && !aVar.b()) {
                            str = f107002b;
                            sb5 = new StringBuilder();
                            str2 = "ignore ipv4 accessIp for ipv6 only, accessIp: ";
                            sb5.append(str2);
                            sb5.append(aVar);
                            com.tencent.gamecenter.wadl.sdk.common.e.b.a(str, sb5.toString());
                        }
                        if (startsWith) {
                        }
                        com.tencent.gamecenter.wadl.sdk.common.e.b.a(f107002b, "directScheduleInfo " + aVar + " for domain:" + cVar2.f107008c);
                        cVar2.b(aVar);
                    }
                }
                com.tencent.gamecenter.wadl.sdk.common.b.a aVar2 = new com.tencent.gamecenter.wadl.sdk.common.b.a(cVar.f107055a, -1);
                aVar2.a((byte) 3);
                cVar2.b(aVar2);
                com.tencent.gamecenter.wadl.sdk.common.e.b.a(f107002b, "directScheduleInfo " + aVar2 + " for domain:" + cVar2.f107008c);
                cVar2.c();
                f107005e.put(cVar.f107055a, cVar2);
            }
            return;
        }
        com.tencent.gamecenter.wadl.sdk.common.e.b.e(f107002b, "getDirectAccessInfo is null.");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00ed  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void g() {
        boolean z16;
        boolean z17;
        boolean z18;
        String str;
        StringBuilder sb5;
        String str2;
        List<com.tencent.gamecenter.wadl.sdk.common.b.k.a> b16 = com.tencent.gamecenter.wadl.sdk.common.d.h.e().f().b();
        if (b16 != null) {
            if (g.a("app_schdule_use_ipv6", 0, 1, 1) == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            f107004d.clear();
            com.tencent.gamecenter.wadl.sdk.common.e.b.e(f107002b, "GetAppidSchInfoList end, size:" + b16.size());
            for (com.tencent.gamecenter.wadl.sdk.common.b.k.a aVar : b16) {
                c cVar = new c(f107003c);
                cVar.f107007b = Integer.valueOf(aVar.a());
                cVar.f107009d = aVar.b();
                String e16 = aVar.e();
                cVar.f107011f = e16;
                if (e16.startsWith("bottom")) {
                    com.tencent.gamecenter.wadl.sdk.common.e.b.a(f107002b, "schedule rule is in bottom");
                    z17 = true;
                } else {
                    z17 = false;
                }
                for (com.tencent.gamecenter.wadl.sdk.common.b.a aVar2 : aVar.c()) {
                    if (!z16 && aVar2.b()) {
                        com.tencent.gamecenter.wadl.sdk.common.e.b.a(f107002b, "ignore ipv6 accessIp due to cloud-settings");
                    } else if (com.tencent.gamecenter.wadl.sdk.common.b.c.c() == 1) {
                        if (aVar2.b()) {
                            str = f107002b;
                            sb5 = new StringBuilder();
                            str2 = "ignore ipv6 accessIp for ipv4 only, accessIp: ";
                            sb5.append(str2);
                            sb5.append(aVar2);
                            sb5.append(" appId:");
                            sb5.append(aVar.a());
                            com.tencent.gamecenter.wadl.sdk.common.e.b.a(str, sb5.toString());
                        } else {
                            if (z17) {
                                aVar2.a((byte) 5);
                            }
                            com.tencent.gamecenter.wadl.sdk.common.e.b.a(f107002b, "appIdSchInfo " + aVar2 + " appId:" + aVar.a());
                            cVar.b(aVar2);
                        }
                    } else {
                        if (com.tencent.gamecenter.wadl.sdk.common.b.c.c() == 3 && !aVar2.b()) {
                            str = f107002b;
                            sb5 = new StringBuilder();
                            str2 = "ignore ipv4 accessIp for ipv6 only, accessIp: ";
                            sb5.append(str2);
                            sb5.append(aVar2);
                            sb5.append(" appId:");
                            sb5.append(aVar.a());
                            com.tencent.gamecenter.wadl.sdk.common.e.b.a(str, sb5.toString());
                        }
                        if (z17) {
                        }
                        com.tencent.gamecenter.wadl.sdk.common.e.b.a(f107002b, "appIdSchInfo " + aVar2 + " appId:" + aVar.a());
                        cVar.b(aVar2);
                    }
                }
                if (cVar.f107007b.intValue() != 0) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                com.tencent.gamecenter.wadl.sdk.common.b.a aVar3 = new com.tencent.gamecenter.wadl.sdk.common.b.a(com.tencent.gamecenter.wadl.sdk.common.d.i.a(z18), com.tencent.gamecenter.wadl.sdk.common.d.i.b(z18));
                aVar3.a((byte) 3);
                cVar.b(aVar3);
                com.tencent.gamecenter.wadl.sdk.common.e.b.a(f107002b, "appIdDomainAccessIp " + aVar3 + " appId:" + aVar.a());
                cVar.c();
                f107004d.put(Integer.valueOf(aVar.a()), cVar);
            }
            return;
        }
        com.tencent.gamecenter.wadl.sdk.common.e.b.e(f107002b, "appidSchContainers is null.");
    }

    public static void a(String str, com.tencent.gamecenter.wadl.sdk.common.b.a aVar, int i3, int i16) {
        c cVar;
        if ((i3 != 0 || i16 >= 500) && (cVar = f107005e.get(str)) != null) {
            cVar.d(aVar);
        }
    }
}
