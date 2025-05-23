package com.tencent.halley.downloader.c;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.halley.common.ParseDnsServerType;
import com.tencent.halley.common.e.a;
import com.tencent.halley.downloader.c.c;
import com.tencent.halley.downloader.c.f;
import com.tencent.halley.downloader.e.a.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a */
    public d f113662a;

    /* renamed from: b */
    public final CopyOnWriteArrayList<String> f113663b;

    /* renamed from: c */
    public Boolean f113664c;

    /* renamed from: d */
    public ParseDnsServerType f113665d;

    /* renamed from: e */
    private final com.tencent.halley.common.a.a.d f113666e;

    /* renamed from: f */
    private long f113667f;

    /* renamed from: g */
    private final Runnable f113668g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.halley.downloader.c.a$1 */
    /* loaded from: classes6.dex */
    public final class AnonymousClass1 implements Runnable {
        static IPatchRedirector $redirector_;

        AnonymousClass1() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                com.tencent.halley.common.utils.d.b("DnsPreParser", "\u8fbe\u5230\u5237\u65b0TTL\uff0c\u5f00\u59cb\u5237\u65b0");
                a.a(a.this, "1");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.halley.downloader.c.a$2 */
    /* loaded from: classes6.dex */
    public final class AnonymousClass2 implements com.tencent.halley.common.a.e {
        static IPatchRedirector $redirector_;

        AnonymousClass2() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // com.tencent.halley.common.a.e
        public final void a(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
            } else {
                a.a(a.this, "2");
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.halley.downloader.c.a$3 */
    /* loaded from: classes6.dex */
    public final class AnonymousClass3 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a */
        final /* synthetic */ String f113671a;

        AnonymousClass3(String str) {
            this.f113671a = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) str);
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            HashMap hashMap;
            c unused;
            f unused2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            try {
                a.this.f113662a = new d(com.tencent.halley.common.a.c.b());
                ParseDnsServerType parseDnsServerType = a.this.f113665d;
                if (parseDnsServerType == ParseDnsServerType.HTTP_DNS) {
                    com.tencent.halley.common.utils.d.c("DnsPreParser", "\u4f7f\u7528HttpDns\u9884\u89e3\u6790");
                    long currentTimeMillis = System.currentTimeMillis();
                    unused = c.a.f113689a;
                    CopyOnWriteArrayList<String> copyOnWriteArrayList = a.this.f113663b;
                    if (copyOnWriteArrayList == null) {
                        hashMap = null;
                    } else {
                        HashMap hashMap2 = new HashMap();
                        for (String str : copyOnWriteArrayList) {
                            hashMap2.put(str, c.a(str));
                        }
                        hashMap = hashMap2;
                    }
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    if (hashMap.isEmpty()) {
                        a.a(-2, "HttpDns\u89e3\u6790\u540e\u7684\u6570\u636e\u4e3a\u7a7a", this.f113671a);
                    } else {
                        a.a(a.this, currentTimeMillis2, "1", this.f113671a);
                    }
                    a.this.f113662a.a(hashMap);
                    a.a(a.this, hashMap);
                    return;
                }
                if (parseDnsServerType == ParseDnsServerType.LOCAL_DNS) {
                    com.tencent.halley.common.utils.d.c("DnsPreParser", "\u4f7f\u7528LocalDns\u9884\u89e3\u6790");
                    long currentTimeMillis3 = System.currentTimeMillis();
                    unused2 = f.a.f113695a;
                    Map<String, com.tencent.halley.downloader.d.a> a16 = f.a(a.this.f113663b);
                    long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis3;
                    a.this.f113662a.a(a16);
                    if (a16.isEmpty()) {
                        a.a(-1, "LocalDns\u89e3\u6790\u540e\u7684\u6570\u636e\u4e3a\u7a7a", this.f113671a);
                    } else {
                        a.a(a.this, currentTimeMillis4, "0", this.f113671a);
                    }
                    a.a(a.this, a16);
                    return;
                }
                com.tencent.halley.common.utils.d.c("DnsPreParser", "\u4f7f\u7528Halley\u670d\u52a1\u9884\u89e3\u6790");
                a.b(a.this, this.f113671a);
            } catch (Exception e16) {
                Log.e("DnsPreParser", "threadPoolExecutor.execute exception!", e16);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.halley.downloader.c.a$4 */
    /* loaded from: classes6.dex */
    public final class AnonymousClass4 implements com.tencent.halley.downloader.e.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a */
        final /* synthetic */ Map f113673a;

        /* renamed from: b */
        final /* synthetic */ String f113674b;

        /* renamed from: c */
        final /* synthetic */ AtomicInteger f113675c;

        /* renamed from: d */
        final /* synthetic */ long f113676d;

        /* renamed from: e */
        final /* synthetic */ String f113677e;

        AnonymousClass4(Map map, String str, AtomicInteger atomicInteger, long j3, String str2) {
            this.f113673a = map;
            this.f113674b = str;
            this.f113675c = atomicInteger;
            this.f113676d = j3;
            this.f113677e = str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, a.this, map, str, atomicInteger, Long.valueOf(j3), str2);
            }
        }

        @Override // com.tencent.halley.downloader.e.b
        public final void a(String str, int i3, String str2) {
            com.tencent.halley.common.e.a aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), str2);
                return;
            }
            com.tencent.halley.common.utils.d.c("DnsPreParser", "resSchedule onResScheduleFail url = " + str + " errorCode = " + i3 + " errorInfo = " + str2);
            if (this.f113675c.decrementAndGet() == 0) {
                String str3 = this.f113677e;
                HashMap hashMap = new HashMap();
                hashMap.put("qddDnsType", "1");
                hashMap.put("qddErrorCode", "-3");
                hashMap.put("qddErrorMsg", "Halley\u89e3\u6790\u5931\u8d25");
                hashMap.put("qddHalleyErrorCode", String.valueOf(i3));
                hashMap.put("qddHalleyErrorMsg", str2);
                hashMap.put("qddRefreshType", str3);
                aVar = a.C1242a.f113533a;
                aVar.a("B_DLSDK_DnsPod_Failed", false, hashMap);
                a.this.f113662a.a(this.f113673a);
                a.a(a.this, this.f113673a);
            }
        }

        @Override // com.tencent.halley.downloader.e.b
        public final void a(String str, com.tencent.halley.downloader.e.a.b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) bVar);
                return;
            }
            Iterator<b.a> it = bVar.f113733i.iterator();
            while (it.hasNext()) {
                this.f113673a.put(this.f113674b, new com.tencent.halley.downloader.d.a(it.next().f113739c, Collections.emptyList(), Collections.emptyList()));
            }
            if (this.f113675c.decrementAndGet() == 0) {
                a.a(a.this, System.currentTimeMillis() - this.f113676d, "1", this.f113677e);
                a.this.f113662a.a(this.f113673a);
                a.a(a.this, this.f113673a);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.halley.downloader.c.a$a */
    /* loaded from: classes6.dex */
    public static class C1243a {
        static IPatchRedirector $redirector_;

        /* renamed from: a */
        private static final a f113679a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17816);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
            } else {
                f113679a = new a((byte) 0);
            }
        }

        public static /* synthetic */ a a() {
            return f113679a;
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f113662a = null;
        this.f113663b = new CopyOnWriteArrayList<>();
        this.f113664c = Boolean.FALSE;
        this.f113665d = ParseDnsServerType.LOCAL_DNS;
        this.f113667f = 0L;
        this.f113668g = new Runnable() { // from class: com.tencent.halley.downloader.c.a.1
            static IPatchRedirector $redirector_;

            AnonymousClass1() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) a.this);
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    com.tencent.halley.common.utils.d.b("DnsPreParser", "\u8fbe\u5230\u5237\u65b0TTL\uff0c\u5f00\u59cb\u5237\u65b0");
                    a.a(a.this, "1");
                }
            }
        };
        com.tencent.halley.common.a.c.a("DnsPreParser", new com.tencent.halley.common.a.e() { // from class: com.tencent.halley.downloader.c.a.2
            static IPatchRedirector $redirector_;

            AnonymousClass2() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) a.this);
                }
            }

            @Override // com.tencent.halley.common.a.e
            public final void a(int i3, String str) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, i3, (Object) str);
                } else {
                    a.a(a.this, "2");
                }
            }
        });
        this.f113666e = new com.tencent.halley.common.a.a.d(1, 4, TimeUnit.SECONDS, new com.tencent.halley.common.a.a.b((byte) 0), new com.tencent.halley.common.a.a.a("HallyDownload-PreParseDnsPool"));
    }

    static /* synthetic */ void a(int i3, String str, String str2) {
        com.tencent.halley.common.e.a aVar;
        HashMap hashMap = new HashMap();
        hashMap.put("qddDnsType", "1");
        hashMap.put("qddErrorCode", String.valueOf(i3));
        hashMap.put("qddErrorMsg", str);
        hashMap.put("qddRefreshType", str2);
        aVar = a.C1242a.f113533a;
        aVar.a("B_DLSDK_DnsPod_Failed", false, hashMap);
    }

    static /* synthetic */ void b(a aVar, String str) {
        AtomicInteger atomicInteger = new AtomicInteger(aVar.f113663b.size());
        HashMap hashMap = new HashMap();
        long currentTimeMillis = System.currentTimeMillis();
        for (int i3 = 0; i3 < aVar.f113663b.size(); i3++) {
            String str2 = aVar.f113663b.get(i3);
            com.tencent.halley.downloader.e.c.a("http://".concat(String.valueOf(str2)), 0L, new com.tencent.halley.downloader.e.b(hashMap, str2, atomicInteger, currentTimeMillis, str) { // from class: com.tencent.halley.downloader.c.a.4
                static IPatchRedirector $redirector_;

                /* renamed from: a */
                final /* synthetic */ Map f113673a;

                /* renamed from: b */
                final /* synthetic */ String f113674b;

                /* renamed from: c */
                final /* synthetic */ AtomicInteger f113675c;

                /* renamed from: d */
                final /* synthetic */ long f113676d;

                /* renamed from: e */
                final /* synthetic */ String f113677e;

                AnonymousClass4(Map hashMap2, String str22, AtomicInteger atomicInteger2, long currentTimeMillis2, String str3) {
                    this.f113673a = hashMap2;
                    this.f113674b = str22;
                    this.f113675c = atomicInteger2;
                    this.f113676d = currentTimeMillis2;
                    this.f113677e = str3;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, a.this, hashMap2, str22, atomicInteger2, Long.valueOf(currentTimeMillis2), str3);
                    }
                }

                @Override // com.tencent.halley.downloader.e.b
                public final void a(String str3, int i36, String str22) {
                    com.tencent.halley.common.e.a aVar2;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, this, str3, Integer.valueOf(i36), str22);
                        return;
                    }
                    com.tencent.halley.common.utils.d.c("DnsPreParser", "resSchedule onResScheduleFail url = " + str3 + " errorCode = " + i36 + " errorInfo = " + str22);
                    if (this.f113675c.decrementAndGet() == 0) {
                        String str32 = this.f113677e;
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("qddDnsType", "1");
                        hashMap2.put("qddErrorCode", "-3");
                        hashMap2.put("qddErrorMsg", "Halley\u89e3\u6790\u5931\u8d25");
                        hashMap2.put("qddHalleyErrorCode", String.valueOf(i36));
                        hashMap2.put("qddHalleyErrorMsg", str22);
                        hashMap2.put("qddRefreshType", str32);
                        aVar2 = a.C1242a.f113533a;
                        aVar2.a("B_DLSDK_DnsPod_Failed", false, hashMap2);
                        a.this.f113662a.a(this.f113673a);
                        a.a(a.this, this.f113673a);
                    }
                }

                @Override // com.tencent.halley.downloader.e.b
                public final void a(String str3, com.tencent.halley.downloader.e.a.b bVar) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) str3, (Object) bVar);
                        return;
                    }
                    Iterator<b.a> it = bVar.f113733i.iterator();
                    while (it.hasNext()) {
                        this.f113673a.put(this.f113674b, new com.tencent.halley.downloader.d.a(it.next().f113739c, Collections.emptyList(), Collections.emptyList()));
                    }
                    if (this.f113675c.decrementAndGet() == 0) {
                        a.a(a.this, System.currentTimeMillis() - this.f113676d, "1", this.f113677e);
                        a.this.f113662a.a(this.f113673a);
                        a.a(a.this, this.f113673a);
                    }
                }
            }, 15000, true);
        }
    }

    /* synthetic */ a(byte b16) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, Byte.valueOf(b16));
    }

    static /* synthetic */ void a(a aVar, long j3, String str, String str2) {
        com.tencent.halley.common.e.a aVar2;
        HashMap hashMap = new HashMap();
        hashMap.put("qddDnsType", str);
        hashMap.put("qddDomainList", TextUtils.join(",", aVar.f113663b));
        hashMap.put("qddCostTime", String.valueOf(j3));
        hashMap.put("qddRefreshType", str2);
        aVar2 = a.C1242a.f113533a;
        aVar2.a("B_DLSDK_DnsPod_Success", true, hashMap);
    }

    static /* synthetic */ void a(a aVar, String str) {
        if (aVar.f113664c.booleanValue()) {
            aVar.a(str);
        } else {
            com.tencent.halley.common.utils.d.b("DnsPreParser", "\u672a\u5f00\u542fDNS\u9884\u89e3\u6790\u80fd\u529b");
        }
    }

    static /* synthetic */ void a(a aVar, Map map) {
        long j3 = 60;
        for (com.tencent.halley.downloader.d.a aVar2 : map.values()) {
            j3 = Math.max(60L, Math.min(aVar2.f113720c, aVar2.f113721d));
        }
        com.tencent.halley.common.a.j.a().a(aVar.f113668g, ((float) (j3 * 1000)) * 0.85f);
    }

    public final void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        if (!this.f113664c.booleanValue()) {
            com.tencent.halley.common.utils.d.b("DnsPreParser", "\u672a\u6253\u5f00DNS\u9884\u89e3\u6790\u529f\u80fd\uff0cstartPreParseByDomain\u65b9\u6cd5\u524d\u9700\u8981\u5148\u6309\u987a\u5e8f\u6267\u884csetPreParseDomains\u548copenDnsPreParse\u4e24\u4e2a\u63a5\u53e3");
            return;
        }
        if (this.f113663b.isEmpty()) {
            com.tencent.halley.common.utils.d.b("DnsPreParser", "\u57df\u540d\u5217\u8868\u4e3a\u7a7a\uff0cstartPreParseByDomain\u65b9\u6cd5\u524d\u9700\u8981\u5148\u6309\u987a\u5e8f\u6267\u884csetPreParseDomains\u548copenDnsPreParse\u4e24\u4e2a\u63a5\u53e3");
            return;
        }
        if (System.currentTimeMillis() - this.f113667f < 120) {
            com.tencent.halley.common.utils.d.b("DnsPreParser", "\u66f4\u65b0\u8fc7\u4e8e\u9891\u7e41\uff0c\u66f4\u65b0\u95f4\u9694\u81f3\u5c11\u5927\u4e8e\uff1a120ms");
            return;
        }
        this.f113667f = System.currentTimeMillis();
        com.tencent.halley.common.utils.d.a("DnsPreParser", " startPreParseByDomain", true);
        com.tencent.halley.common.a.j.a().a(this.f113668g);
        this.f113666e.execute(new Runnable(str) { // from class: com.tencent.halley.downloader.c.a.3
            static IPatchRedirector $redirector_;

            /* renamed from: a */
            final /* synthetic */ String f113671a;

            AnonymousClass3(String str2) {
                this.f113671a = str2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) a.this, (Object) str2);
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                HashMap hashMap;
                c unused;
                f unused2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    a.this.f113662a = new d(com.tencent.halley.common.a.c.b());
                    ParseDnsServerType parseDnsServerType = a.this.f113665d;
                    if (parseDnsServerType == ParseDnsServerType.HTTP_DNS) {
                        com.tencent.halley.common.utils.d.c("DnsPreParser", "\u4f7f\u7528HttpDns\u9884\u89e3\u6790");
                        long currentTimeMillis = System.currentTimeMillis();
                        unused = c.a.f113689a;
                        CopyOnWriteArrayList<String> copyOnWriteArrayList = a.this.f113663b;
                        if (copyOnWriteArrayList == null) {
                            hashMap = null;
                        } else {
                            HashMap hashMap2 = new HashMap();
                            for (String str2 : copyOnWriteArrayList) {
                                hashMap2.put(str2, c.a(str2));
                            }
                            hashMap = hashMap2;
                        }
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        if (hashMap.isEmpty()) {
                            a.a(-2, "HttpDns\u89e3\u6790\u540e\u7684\u6570\u636e\u4e3a\u7a7a", this.f113671a);
                        } else {
                            a.a(a.this, currentTimeMillis2, "1", this.f113671a);
                        }
                        a.this.f113662a.a(hashMap);
                        a.a(a.this, hashMap);
                        return;
                    }
                    if (parseDnsServerType == ParseDnsServerType.LOCAL_DNS) {
                        com.tencent.halley.common.utils.d.c("DnsPreParser", "\u4f7f\u7528LocalDns\u9884\u89e3\u6790");
                        long currentTimeMillis3 = System.currentTimeMillis();
                        unused2 = f.a.f113695a;
                        Map<String, com.tencent.halley.downloader.d.a> a16 = f.a(a.this.f113663b);
                        long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis3;
                        a.this.f113662a.a(a16);
                        if (a16.isEmpty()) {
                            a.a(-1, "LocalDns\u89e3\u6790\u540e\u7684\u6570\u636e\u4e3a\u7a7a", this.f113671a);
                        } else {
                            a.a(a.this, currentTimeMillis4, "0", this.f113671a);
                        }
                        a.a(a.this, a16);
                        return;
                    }
                    com.tencent.halley.common.utils.d.c("DnsPreParser", "\u4f7f\u7528Halley\u670d\u52a1\u9884\u89e3\u6790");
                    a.b(a.this, this.f113671a);
                } catch (Exception e16) {
                    Log.e("DnsPreParser", "threadPoolExecutor.execute exception!", e16);
                }
            }
        });
    }
}
