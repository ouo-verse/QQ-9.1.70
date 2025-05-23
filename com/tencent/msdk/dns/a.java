package com.tencent.msdk.dns;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.msdk.dns.base.executor.DnsExecutors;
import com.tencent.msdk.dns.core.rest.share.g;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final int f336171a;

    /* renamed from: b, reason: collision with root package name */
    public final String f336172b;

    /* renamed from: c, reason: collision with root package name */
    public String f336173c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f336174d;

    /* renamed from: e, reason: collision with root package name */
    public final String f336175e;

    /* renamed from: f, reason: collision with root package name */
    public final g f336176f;

    /* renamed from: g, reason: collision with root package name */
    public final int f336177g;

    /* renamed from: h, reason: collision with root package name */
    public final Set<c> f336178h;

    /* renamed from: i, reason: collision with root package name */
    public final Set<String> f336179i;

    /* renamed from: j, reason: collision with root package name */
    public final Set<String> f336180j;

    /* renamed from: k, reason: collision with root package name */
    public final String f336181k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f336182l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f336183m;

    /* renamed from: n, reason: collision with root package name */
    public final List<com.tencent.msdk.dns.base.log.a> f336184n;

    /* renamed from: o, reason: collision with root package name */
    public final List<com.tencent.msdk.dns.base.report.a> f336185o;

    /* compiled from: P */
    /* renamed from: com.tencent.msdk.dns.a$a, reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public static final class C9208a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private int f336186a;

        /* renamed from: b, reason: collision with root package name */
        private String f336187b;

        /* renamed from: c, reason: collision with root package name */
        private String f336188c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f336189d;

        /* renamed from: e, reason: collision with root package name */
        private String f336190e;

        /* renamed from: f, reason: collision with root package name */
        private String f336191f;

        /* renamed from: g, reason: collision with root package name */
        private String f336192g;

        /* renamed from: h, reason: collision with root package name */
        private String f336193h;

        /* renamed from: i, reason: collision with root package name */
        private int f336194i;

        /* renamed from: j, reason: collision with root package name */
        private int f336195j;

        /* renamed from: k, reason: collision with root package name */
        private Set<c> f336196k;

        /* renamed from: l, reason: collision with root package name */
        private Set<String> f336197l;

        /* renamed from: m, reason: collision with root package name */
        private Set<String> f336198m;

        /* renamed from: n, reason: collision with root package name */
        private String f336199n;

        /* renamed from: o, reason: collision with root package name */
        private boolean f336200o;

        /* renamed from: p, reason: collision with root package name */
        private boolean f336201p;

        /* renamed from: q, reason: collision with root package name */
        private List<com.tencent.msdk.dns.base.log.a> f336202q;

        /* renamed from: r, reason: collision with root package name */
        private List<com.tencent.msdk.dns.base.report.a> f336203r;

        public C9208a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f336186a = 5;
            this.f336187b = "";
            this.f336188c = "";
            this.f336189d = false;
            this.f336190e = "";
            this.f336191f = "";
            this.f336192g = "";
            this.f336193h = "";
            this.f336194i = 1000;
            this.f336195j = 10;
            this.f336196k = null;
            this.f336197l = null;
            this.f336198m = null;
            this.f336199n = "DesHttp";
            this.f336200o = false;
            this.f336201p = false;
            this.f336202q = null;
            this.f336203r = null;
        }

        public C9208a a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return (C9208a) iPatchRedirector.redirect((short) 16, (Object) this);
            }
            this.f336199n = "AesHttp";
            return this;
        }

        public C9208a b(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (C9208a) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            }
            if (!TextUtils.isEmpty(str)) {
                this.f336187b = str;
                return this;
            }
            throw new IllegalArgumentException("appId".concat(" can not be empty"));
        }

        public a c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
                return (a) iPatchRedirector.redirect((short) 26, (Object) this);
            }
            return new a(this.f336186a, this.f336187b, this.f336188c, this.f336189d, this.f336190e, this.f336191f, this.f336192g, this.f336193h, this.f336194i, this.f336196k, this.f336197l, this.f336198m, this.f336199n, this.f336200o, this.f336201p, null, null, this.f336202q, this.f336203r, null);
        }

        public C9208a d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return (C9208a) iPatchRedirector.redirect((short) 17, (Object) this);
            }
            this.f336199n = "DesHttp";
            return this;
        }

        public C9208a e(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (C9208a) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
            }
            if (!TextUtils.isEmpty(str)) {
                this.f336191f = str;
                return this;
            }
            throw new IllegalArgumentException("dnsId".concat(" can not be empty"));
        }

        public C9208a f(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (C9208a) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            }
            if (!TextUtils.isEmpty(str)) {
                this.f336190e = str;
                return this;
            }
            throw new IllegalArgumentException("dnsIp".concat(" can not be empty"));
        }

        public C9208a g(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (C9208a) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
            }
            if (!TextUtils.isEmpty(str)) {
                this.f336192g = str;
                return this;
            }
            throw new IllegalArgumentException("dnsKey".concat(" can not be empty"));
        }

        public C9208a h(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                return (C9208a) iPatchRedirector.redirect((short) 19, (Object) this, z16);
            }
            this.f336200o = z16;
            return this;
        }

        public C9208a i(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (C9208a) iPatchRedirector.redirect((short) 2, (Object) this, i3);
            }
            this.f336186a = i3;
            return this;
        }

        public C9208a j(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (C9208a) iPatchRedirector.redirect((short) 11, (Object) this, i3);
            }
            if (i3 > 0) {
                this.f336194i = i3;
                return this;
            }
            throw new IllegalArgumentException("timeoutMills".concat(" can not less than 0"));
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    static class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final boolean f336204a;

        /* renamed from: b, reason: collision with root package name */
        private final String f336205b;

        boolean a(String str) {
            if (this.f336204a) {
                return str.endsWith(this.f336205b);
            }
            return this.f336205b.equals(str);
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return "WildcardDomain{mIsWildcard=" + this.f336204a + ", mNakedDomain='" + this.f336205b + "'}";
        }
    }

    /* synthetic */ a(int i3, String str, String str2, boolean z16, String str3, String str4, String str5, String str6, int i16, Set set, Set set2, Set set3, String str7, boolean z17, boolean z18, DnsExecutors.b bVar, com.tencent.msdk.dns.b bVar2, List list, List list2, b bVar3) {
        this(i3, str, str2, z16, str3, str4, str5, str6, i16, set, set2, set3, str7, z17, z18, bVar, bVar2, list, list2);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, str2, Boolean.valueOf(z16), str3, str4, str5, str6, Integer.valueOf(i16), set, set2, set3, str7, Boolean.valueOf(z17), Boolean.valueOf(z18), bVar, bVar2, list, list2, bVar3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(String str) {
        if (!TextUtils.isEmpty(str)) {
            String trim = str.trim();
            if (!TextUtils.isEmpty(trim)) {
                Set<c> set = this.f336178h;
                if (set == null) {
                    return true;
                }
                Iterator<c> it = set.iterator();
                while (it.hasNext()) {
                    if (it.next().a(trim)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "DnsConfig{logLevel=" + this.f336171a + ", appId='" + this.f336172b + "', userId='" + this.f336173c + "', lookupExtra=" + this.f336176f + ", timeoutMills=" + this.f336177g + ", protectedDomains=" + com.tencent.msdk.dns.c.e.a.h(this.f336178h) + ", preLookupDomains=" + com.tencent.msdk.dns.c.e.a.h(this.f336179i) + ", asyncLookupDomains=" + com.tencent.msdk.dns.c.e.a.h(this.f336180j) + ", channel='" + this.f336181k + "', enableReport='" + this.f336182l + "', blockFirst=" + this.f336183m + ", executorSupplier=" + ((Object) null) + ", lookedUpListener=" + ((Object) null) + ", logNodes=" + com.tencent.msdk.dns.c.e.a.h(this.f336184n) + ", reporters=" + com.tencent.msdk.dns.c.e.a.h(this.f336185o) + '}';
    }

    a(int i3, String str, String str2, boolean z16, String str3, String str4, String str5, String str6, int i16, Set<c> set, Set<String> set2, Set<String> set3, String str7, boolean z17, boolean z18, DnsExecutors.b bVar, com.tencent.msdk.dns.b bVar2, List<com.tencent.msdk.dns.base.log.a> list, List<com.tencent.msdk.dns.base.report.a> list2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), str, str2, Boolean.valueOf(z16), str3, str4, str5, str6, Integer.valueOf(i16), set, set2, set3, str7, Boolean.valueOf(z17), Boolean.valueOf(z18), bVar, bVar2, list, list2);
            return;
        }
        this.f336171a = i3;
        this.f336172b = str;
        this.f336173c = str2;
        this.f336174d = z16;
        this.f336175e = str3;
        this.f336176f = new g(str4, str5, str6);
        this.f336177g = i16;
        this.f336178h = set;
        this.f336179i = set2;
        this.f336180j = set3;
        this.f336181k = str7;
        this.f336182l = z17;
        this.f336183m = z18;
        this.f336184n = list;
        this.f336185o = list2;
    }
}
