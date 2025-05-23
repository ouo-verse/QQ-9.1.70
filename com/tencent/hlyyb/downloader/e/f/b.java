package com.tencent.hlyyb.downloader.e.f;

import android.text.TextUtils;
import com.tencent.hlyyb.downloader.e.f.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public com.tencent.hlyyb.downloader.e.f.a f114548a;

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.hlyyb.downloader.e.f.a f114549b;

    /* renamed from: c, reason: collision with root package name */
    public Map<String, a> f114550c;

    /* renamed from: d, reason: collision with root package name */
    public AtomicInteger f114551d;

    /* renamed from: e, reason: collision with root package name */
    public volatile long f114552e;

    /* renamed from: f, reason: collision with root package name */
    public String f114553f;

    /* renamed from: g, reason: collision with root package name */
    public List<com.tencent.hlyyb.downloader.d.a> f114554g;

    /* renamed from: h, reason: collision with root package name */
    public String f114555h;

    /* renamed from: i, reason: collision with root package name */
    public int f114556i;

    /* renamed from: j, reason: collision with root package name */
    public final List<com.tencent.hlyyb.downloader.e.f.a> f114557j;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f114558a;

        /* renamed from: b, reason: collision with root package name */
        public List<com.tencent.hlyyb.downloader.e.f.a> f114559b;

        /* renamed from: c, reason: collision with root package name */
        public List<com.tencent.hlyyb.downloader.e.f.a> f114560c;

        /* renamed from: d, reason: collision with root package name */
        public List<com.tencent.hlyyb.downloader.e.f.a> f114561d;

        /* renamed from: e, reason: collision with root package name */
        public List<com.tencent.hlyyb.downloader.e.f.a> f114562e;

        /* renamed from: f, reason: collision with root package name */
        public com.tencent.hlyyb.downloader.e.f.a f114563f;

        /* renamed from: g, reason: collision with root package name */
        public List<com.tencent.hlyyb.downloader.e.f.a> f114564g;

        /* renamed from: h, reason: collision with root package name */
        public com.tencent.hlyyb.downloader.e.f.a f114565h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f114566i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f114567j;

        public a(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this, (Object) str);
                return;
            }
            this.f114566i = false;
            this.f114567j = false;
            this.f114558a = str;
        }

        public static void f(StringBuilder sb5, List<com.tencent.hlyyb.downloader.e.f.a> list) {
            if (list != null) {
                synchronized (list) {
                    if (list.size() > 0) {
                        for (com.tencent.hlyyb.downloader.e.f.a aVar : list) {
                            if (aVar != null) {
                                sb5.append(aVar);
                                sb5.append(",");
                            }
                        }
                    }
                }
            }
        }

        private List<com.tencent.hlyyb.downloader.e.f.a> g(int i3) {
            if (i3 == a.EnumC5821a.f114539c) {
                return this.f114559b;
            }
            if (i3 == a.EnumC5821a.f114541e) {
                return this.f114560c;
            }
            if (i3 == a.EnumC5821a.f114542f) {
                return this.f114561d;
            }
            if (i3 == a.EnumC5821a.f114546j) {
                return this.f114562e;
            }
            if (i3 == a.EnumC5821a.f114544h) {
                return this.f114564g;
            }
            return null;
        }

        public final synchronized com.tencent.hlyyb.downloader.e.f.a a(int i3) {
            List<com.tencent.hlyyb.downloader.e.f.a> g16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (com.tencent.hlyyb.downloader.e.f.a) iPatchRedirector.redirect((short) 7, (Object) this, i3);
            }
            if (i3 == a.EnumC5821a.f114540d) {
                return this.f114563f;
            }
            if (i3 == a.EnumC5821a.f114545i) {
                return this.f114565h;
            }
            if (com.tencent.hlyyb.downloader.e.f.a.c(i3) && (g16 = g(i3)) != null) {
                return g16.get(0);
            }
            return null;
        }

        public final synchronized com.tencent.hlyyb.downloader.e.f.a b(com.tencent.hlyyb.downloader.e.f.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (com.tencent.hlyyb.downloader.e.f.a) iPatchRedirector.redirect((short) 6, (Object) this, (Object) aVar);
            }
            if (aVar == null) {
                return null;
            }
            List<com.tencent.hlyyb.downloader.e.f.a> g16 = g(aVar.f114532b);
            if (g16 != null) {
                for (int i3 = 0; i3 < g16.size(); i3++) {
                    if (aVar == g16.get(i3)) {
                        if (i3 == g16.size() - 1) {
                            return null;
                        }
                        return g16.get(i3 + 1);
                    }
                }
            }
            return null;
        }

        public final synchronized List<com.tencent.hlyyb.downloader.e.f.a> c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (List) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(b.this.f114548a);
            List<com.tencent.hlyyb.downloader.e.f.a> list = this.f114559b;
            if (list != null && list.size() > 0) {
                arrayList.addAll(list);
            }
            List<com.tencent.hlyyb.downloader.e.f.a> list2 = this.f114560c;
            if (list2 != null && list2.size() > 0) {
                arrayList.addAll(list2);
            }
            List<com.tencent.hlyyb.downloader.e.f.a> list3 = this.f114561d;
            if (list3 != null && list3.size() > 0) {
                arrayList.addAll(list3);
            }
            List<com.tencent.hlyyb.downloader.e.f.a> list4 = this.f114562e;
            if (list4 != null && list4.size() > 0) {
                arrayList.addAll(list4);
            }
            com.tencent.hlyyb.downloader.e.f.a aVar = this.f114563f;
            if (aVar != null) {
                arrayList.add(aVar);
            }
            List<com.tencent.hlyyb.downloader.e.f.a> list5 = this.f114564g;
            if (list5 != null && list5.size() > 0) {
                arrayList.addAll(list5);
            }
            com.tencent.hlyyb.downloader.e.f.a aVar2 = this.f114565h;
            if (aVar2 != null) {
                arrayList.add(aVar2);
            }
            com.tencent.hlyyb.downloader.e.f.a aVar3 = b.this.f114549b;
            if (aVar3 != null) {
                arrayList.add(aVar3);
            }
            return arrayList;
        }

        public final synchronized void d(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            } else {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (this.f114563f == null) {
                    com.tencent.hlyyb.downloader.e.f.a aVar = new com.tencent.hlyyb.downloader.e.f.a(str, a.EnumC5821a.f114540d);
                    this.f114563f = aVar;
                    aVar.f114533c = b.this.f114551d.getAndIncrement();
                }
            }
        }

        public final synchronized void e(String str, int i3) {
            List<com.tencent.hlyyb.downloader.e.f.a> list;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, i3);
                return;
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (i3 == a.EnumC5821a.f114539c) {
                if (this.f114559b == null) {
                    this.f114559b = new ArrayList();
                }
                list = this.f114559b;
            } else if (i3 == a.EnumC5821a.f114541e) {
                if (this.f114560c == null) {
                    this.f114560c = new ArrayList();
                }
                list = this.f114560c;
            } else if (i3 == a.EnumC5821a.f114542f) {
                if (this.f114561d == null) {
                    this.f114561d = new ArrayList();
                }
                list = this.f114561d;
            } else if (i3 == a.EnumC5821a.f114546j) {
                if (this.f114562e == null) {
                    this.f114562e = new ArrayList();
                }
                list = this.f114562e;
            } else if (i3 == a.EnumC5821a.f114544h) {
                if (this.f114564g == null) {
                    this.f114564g = new ArrayList();
                }
                list = this.f114564g;
            } else {
                return;
            }
            Iterator<com.tencent.hlyyb.downloader.e.f.a> it = list.iterator();
            while (it.hasNext()) {
                if (str.equalsIgnoreCase(it.next().f114531a)) {
                    return;
                }
            }
            com.tencent.hlyyb.downloader.e.f.a aVar = new com.tencent.hlyyb.downloader.e.f.a(str, i3);
            aVar.f114533c = b.this.f114551d.getAndIncrement();
            list.add(aVar);
        }

        public final synchronized void h(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            } else {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (this.f114565h == null) {
                    com.tencent.hlyyb.downloader.e.f.a aVar = new com.tencent.hlyyb.downloader.e.f.a(str, a.EnumC5821a.f114545i);
                    this.f114565h = aVar;
                    aVar.f114533c = b.this.f114551d.getAndIncrement();
                }
            }
        }

        public final String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (String) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(com.tencent.hlyyb.common.b.b.b(this.f114558a));
            sb5.append(",");
            f(sb5, this.f114559b);
            f(sb5, this.f114560c);
            f(sb5, this.f114561d);
            f(sb5, this.f114562e);
            com.tencent.hlyyb.downloader.e.f.a aVar = this.f114563f;
            if (aVar != null) {
                sb5.append(aVar);
                sb5.append(",");
            }
            f(sb5, this.f114564g);
            com.tencent.hlyyb.downloader.e.f.a aVar2 = this.f114565h;
            if (aVar2 != null) {
                sb5.append(aVar2);
            }
            sb5.deleteCharAt(sb5.length() - 1);
            return sb5.toString();
        }
    }

    public b(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Long.valueOf(j3));
            return;
        }
        this.f114550c = new ConcurrentHashMap();
        this.f114551d = new AtomicInteger(0);
        this.f114552e = -1L;
        this.f114553f = "";
        this.f114555h = "";
        this.f114556i = 0;
        this.f114557j = new ArrayList();
        com.tencent.hlyyb.downloader.e.f.a aVar = new com.tencent.hlyyb.downloader.e.f.a(str, a.EnumC5821a.f114538b);
        this.f114548a = aVar;
        aVar.f114533c = this.f114551d.getAndIncrement();
    }

    private com.tencent.hlyyb.downloader.e.f.a c(String str, com.tencent.hlyyb.downloader.e.f.a aVar) {
        a aVar2 = this.f114550c.get(str);
        if (aVar2 == null) {
            return null;
        }
        synchronized (aVar2) {
            List<com.tencent.hlyyb.downloader.e.f.a> list = aVar2.f114562e;
            if (list == null || list.size() <= 0) {
                return null;
            }
            int indexOf = list.indexOf(aVar);
            if (indexOf == -1) {
                return list.get(0);
            }
            if (indexOf == list.size() - 1) {
                return null;
            }
            return list.get(indexOf + 1);
        }
    }

    private com.tencent.hlyyb.downloader.e.f.a l(com.tencent.hlyyb.downloader.e.f.a aVar) {
        synchronized (this.f114557j) {
            if (this.f114557j.size() <= 0) {
                return null;
            }
            int indexOf = this.f114557j.indexOf(aVar);
            if (indexOf == -1) {
                return this.f114557j.get(0);
            }
            if (indexOf == this.f114557j.size() - 1) {
                return null;
            }
            return this.f114557j.get(indexOf + 1);
        }
    }

    private a m(String str) {
        a aVar;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.f114550c) {
            aVar = this.f114550c.get(str);
            if (aVar == null) {
                aVar = new a(str);
                this.f114550c.put(str, aVar);
            }
        }
        return aVar;
    }

    public final long a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Long) iPatchRedirector.redirect((short) 12, (Object) this)).longValue();
        }
        return this.f114552e;
    }

    public final com.tencent.hlyyb.downloader.e.f.a b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.hlyyb.downloader.e.f.a) iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }
        a m3 = m(com.tencent.hlyyb.common.a.a.b());
        if (m3 != null) {
            if (i3 != a.EnumC5821a.f114538b && i3 != a.EnumC5821a.f114537a) {
                return m3.f114565h;
            }
            return m3.f114563f;
        }
        return null;
    }

    public final com.tencent.hlyyb.downloader.e.f.a d(String str, com.tencent.hlyyb.downloader.e.f.a aVar, boolean z16, boolean z17, boolean z18, boolean z19) {
        com.tencent.hlyyb.downloader.e.f.a aVar2;
        a aVar3;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.hlyyb.downloader.e.f.a) iPatchRedirector.redirect((short) 4, this, str, aVar, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), Boolean.valueOf(z19));
        }
        if (z19) {
            aVar2 = c(str, aVar);
            if (aVar2 != null) {
                return aVar2;
            }
        } else {
            aVar2 = null;
        }
        if (z18 && (aVar2 = l(aVar)) != null) {
            return aVar2;
        }
        if (aVar != null) {
            i3 = aVar.f114532b;
            if (com.tencent.hlyyb.downloader.e.f.a.c(i3) && (aVar3 = this.f114550c.get(str)) != null && (aVar2 = aVar3.b(aVar)) != null) {
                return aVar2;
            }
        }
        a.EnumC5821a.a();
        for (int i16 = 10; aVar2 == null && i16 > 0; i16--) {
            i3 = com.tencent.hlyyb.downloader.e.f.a.a(i3, z16);
            if (com.tencent.hlyyb.downloader.e.f.a.b(i3)) {
                a aVar4 = this.f114550c.get(str);
                if (aVar4 != null) {
                    aVar2 = aVar4.a(i3);
                }
            } else if (i3 == a.EnumC5821a.f114543g) {
                aVar2 = this.f114549b;
            } else {
                aVar2 = this.f114548a;
            }
        }
        if (aVar2 == null) {
            return this.f114548a;
        }
        return aVar2;
    }

    public final synchronized com.tencent.hlyyb.downloader.e.f.a e(List<com.tencent.hlyyb.downloader.e.f.a> list, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.hlyyb.downloader.e.f.a) iPatchRedirector.redirect((short) 3, this, list, Boolean.valueOf(z16));
        }
        a aVar = this.f114550c.get(com.tencent.hlyyb.common.a.a.b());
        if (aVar != null) {
            List<com.tencent.hlyyb.downloader.e.f.a> c16 = aVar.c();
            if (z16) {
                for (com.tencent.hlyyb.downloader.e.f.a aVar2 : c16) {
                    if (aVar2.f114532b == a.EnumC5821a.f114546j && !list.contains(aVar2)) {
                        return aVar2;
                    }
                }
            }
            for (com.tencent.hlyyb.downloader.e.f.a aVar3 : c16) {
                if (!list.contains(aVar3) && !aVar3.f114536f) {
                    return aVar3;
                }
            }
        }
        return null;
    }

    public final void g(com.tencent.hlyyb.downloader.e.f.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) aVar);
            return;
        }
        synchronized (this.f114557j) {
            aVar.f114534d = true;
            this.f114557j.add(aVar);
        }
    }

    public final void h(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            com.tencent.hlyyb.downloader.e.f.a aVar = new com.tencent.hlyyb.downloader.e.f.a(str, a.EnumC5821a.f114543g);
            this.f114549b = aVar;
            aVar.f114533c = this.f114551d.getAndIncrement();
        }
    }

    public final void i(String str, String str2) {
        a m3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) str2);
        } else if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (m3 = m(str)) != null) {
            m3.d(str2);
        }
    }

    public final void j(String str, String str2, int i3) {
        a m3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, str2, Integer.valueOf(i3));
        } else if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (m3 = m(str)) != null) {
            m3.e(str2, i3);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x003b, code lost:
    
        r4 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean k(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, z16)).booleanValue();
        }
        com.tencent.hlyyb.common.a.a.c();
        String b16 = com.tencent.hlyyb.common.a.a.b();
        if (TextUtils.isEmpty(b16)) {
            return false;
        }
        a aVar = this.f114550c.get(b16);
        if (aVar != null) {
            boolean z17 = z16 ? false : false;
            if (!z17) {
                return false;
            }
        }
        return true;
    }

    public final String n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.f114553f;
    }

    public final void o(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        }
    }

    public final void p(String str, String str2) {
        a m3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, (Object) str2);
        } else if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (m3 = m(str)) != null) {
            m3.h(str2);
        }
    }

    public final void q(boolean z16) {
        a m3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
            return;
        }
        com.tencent.hlyyb.common.a.a.c();
        String b16 = com.tencent.hlyyb.common.a.a.b();
        if (!TextUtils.isEmpty(b16) && (m3 = m(b16)) != null) {
            if (z16) {
                m3.f114566i = true;
            } else {
                m3.f114567j = true;
            }
        }
    }

    public final String r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.f114555h;
    }

    public final List<com.tencent.hlyyb.downloader.d.a> s() {
        ArrayList arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (List) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        List<com.tencent.hlyyb.downloader.d.a> list = this.f114554g;
        if (list == null) {
            return null;
        }
        synchronized (list) {
            arrayList = new ArrayList();
            for (com.tencent.hlyyb.downloader.d.a aVar : this.f114554g) {
                arrayList.add(new com.tencent.hlyyb.downloader.d.a(aVar.f114444a, aVar.f114445b));
            }
        }
        return arrayList;
    }

    public final int t() {
        int size;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        synchronized (this.f114557j) {
            size = this.f114557j.size();
        }
        return size;
    }

    public final boolean u() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        a aVar = this.f114550c.get(com.tencent.hlyyb.common.a.a.b());
        if (aVar == null) {
            return false;
        }
        List<com.tencent.hlyyb.downloader.e.f.a> list = aVar.f114561d;
        if (list != null && list.size() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            List<com.tencent.hlyyb.downloader.e.f.a> list2 = aVar.f114562e;
            if (list2 == null || list2.size() <= 0) {
                return false;
            }
            return true;
        }
        return z16;
    }

    public final String v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        if (this.f114548a != null) {
            sb5.append("0,");
            sb5.append(this.f114548a);
            sb5.append(";");
        }
        if (this.f114549b != null) {
            sb5.append("1,");
            sb5.append(this.f114549b);
            sb5.append(";");
        }
        Iterator<String> it = this.f114550c.keySet().iterator();
        while (it.hasNext()) {
            a aVar = this.f114550c.get(it.next());
            if (aVar != null) {
                sb5.append(aVar);
                sb5.append(";");
            }
        }
        return sb5.toString();
    }
}
