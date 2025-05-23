package com.tencent.halley.downloader.task.d;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.halley.common.a.c;
import com.tencent.halley.common.utils.d;
import com.tencent.halley.common.utils.e;
import com.tencent.halley.common.utils.j;
import com.tencent.halley.downloader.task.d.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final List<com.tencent.halley.downloader.task.d.a> f113910a;

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.halley.downloader.task.d.a f113911b;

    /* renamed from: c, reason: collision with root package name */
    public com.tencent.halley.downloader.task.d.a f113912c;

    /* renamed from: d, reason: collision with root package name */
    public com.tencent.halley.downloader.task.d.a f113913d;

    /* renamed from: e, reason: collision with root package name */
    public Map<String, a> f113914e;

    /* renamed from: f, reason: collision with root package name */
    public volatile boolean f113915f;

    /* renamed from: g, reason: collision with root package name */
    public int f113916g;

    /* renamed from: h, reason: collision with root package name */
    public AtomicInteger f113917h;

    /* renamed from: i, reason: collision with root package name */
    public volatile long f113918i;

    /* renamed from: j, reason: collision with root package name */
    public long f113919j;

    /* renamed from: k, reason: collision with root package name */
    public long f113920k;

    /* renamed from: l, reason: collision with root package name */
    public String f113921l;

    /* renamed from: m, reason: collision with root package name */
    public String f113922m;

    /* renamed from: n, reason: collision with root package name */
    public String f113923n;

    /* renamed from: o, reason: collision with root package name */
    List<com.tencent.halley.downloader.e.a> f113924o;

    /* renamed from: p, reason: collision with root package name */
    public Map<Integer, Map<String, String>> f113925p;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        List<com.tencent.halley.downloader.task.d.a> f113926a;

        /* renamed from: b, reason: collision with root package name */
        List<com.tencent.halley.downloader.task.d.a> f113927b;

        /* renamed from: c, reason: collision with root package name */
        public com.tencent.halley.downloader.task.d.a f113928c;

        /* renamed from: d, reason: collision with root package name */
        public com.tencent.halley.downloader.task.d.a f113929d;

        /* renamed from: f, reason: collision with root package name */
        private String f113931f;

        /* renamed from: g, reason: collision with root package name */
        private List<com.tencent.halley.downloader.task.d.a> f113932g;

        /* renamed from: h, reason: collision with root package name */
        private List<com.tencent.halley.downloader.task.d.a> f113933h;

        /* renamed from: i, reason: collision with root package name */
        private List<com.tencent.halley.downloader.task.d.a> f113934i;

        /* renamed from: j, reason: collision with root package name */
        private List<com.tencent.halley.downloader.task.d.a> f113935j;

        /* renamed from: k, reason: collision with root package name */
        private List<com.tencent.halley.downloader.task.d.a> f113936k;

        /* renamed from: l, reason: collision with root package name */
        private boolean f113937l;

        /* renamed from: m, reason: collision with root package name */
        private boolean f113938m;

        /* renamed from: n, reason: collision with root package name */
        private int f113939n;

        public a(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this, (Object) str);
                return;
            }
            this.f113937l = false;
            this.f113938m = false;
            this.f113939n = 0;
            this.f113931f = str;
        }

        private List<com.tencent.halley.downloader.task.d.a> b(a.EnumC1249a enumC1249a) {
            List<com.tencent.halley.downloader.task.d.a> list = enumC1249a == a.EnumC1249a.f113898c ? this.f113932g : null;
            if (enumC1249a == a.EnumC1249a.f113900e) {
                list = this.f113933h;
            }
            if (enumC1249a == a.EnumC1249a.f113901f) {
                list = this.f113926a;
            }
            if (enumC1249a == a.EnumC1249a.f113905j) {
                list = this.f113927b;
            }
            if (enumC1249a == a.EnumC1249a.f113903h) {
                list = this.f113934i;
            }
            if (enumC1249a == a.EnumC1249a.f113907l) {
                list = this.f113935j;
            }
            return enumC1249a == a.EnumC1249a.f113908m ? this.f113936k : list;
        }

        public final synchronized com.tencent.halley.downloader.task.d.a a(a.EnumC1249a enumC1249a) {
            List<com.tencent.halley.downloader.task.d.a> b16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (com.tencent.halley.downloader.task.d.a) iPatchRedirector.redirect((short) 8, (Object) this, (Object) enumC1249a);
            }
            if (enumC1249a == a.EnumC1249a.f113899d) {
                return this.f113928c;
            }
            if (enumC1249a == a.EnumC1249a.f113904i) {
                return this.f113929d;
            }
            if (!com.tencent.halley.downloader.task.d.a.b(enumC1249a) || (b16 = b(enumC1249a)) == null) {
                return null;
            }
            if (this.f113939n > b16.size() - 1) {
                this.f113939n = 0;
            }
            int i3 = this.f113939n;
            this.f113939n = i3 + 1;
            return b16.get(i3);
        }

        public final String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (String) iPatchRedirector.redirect((short) 10, (Object) this);
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(j.b(this.f113931f));
            sb5.append(",");
            a(sb5, this.f113932g);
            a(sb5, this.f113933h);
            a(sb5, this.f113926a);
            a(sb5, this.f113927b);
            com.tencent.halley.downloader.task.d.a aVar = this.f113928c;
            if (aVar != null) {
                sb5.append(aVar);
                sb5.append(",");
            }
            a(sb5, this.f113934i);
            com.tencent.halley.downloader.task.d.a aVar2 = this.f113929d;
            if (aVar2 != null) {
                sb5.append(aVar2);
            }
            sb5.deleteCharAt(sb5.length() - 1);
            return sb5.toString();
        }

        public final synchronized com.tencent.halley.downloader.task.d.a a(com.tencent.halley.downloader.task.d.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (com.tencent.halley.downloader.task.d.a) iPatchRedirector.redirect((short) 7, (Object) this, (Object) aVar);
            }
            if (aVar == null) {
                return null;
            }
            List<com.tencent.halley.downloader.task.d.a> b16 = b(aVar.f113891d);
            if (b16 == null) {
                return null;
            }
            for (int i3 = 0; i3 < b16.size(); i3++) {
                if (aVar == b16.get(i3)) {
                    if (i3 == b16.size() - 1) {
                        return null;
                    }
                    return b16.get(i3 + 1);
                }
            }
            return null;
        }

        public final synchronized void b(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            } else {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (this.f113929d == null) {
                    com.tencent.halley.downloader.task.d.a aVar = new com.tencent.halley.downloader.task.d.a(str, a.EnumC1249a.f113904i);
                    this.f113929d = aVar;
                    aVar.f113892e = b.this.f113917h.getAndIncrement();
                }
            }
        }

        public final synchronized List<com.tencent.halley.downloader.task.d.a> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (List) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(b.this.f113911b);
            a(arrayList, this.f113932g);
            a(arrayList, this.f113933h);
            a(arrayList, this.f113926a);
            a(arrayList, this.f113927b);
            com.tencent.halley.downloader.task.d.a aVar = this.f113928c;
            if (aVar != null) {
                arrayList.add(aVar);
            }
            a(arrayList, this.f113934i);
            com.tencent.halley.downloader.task.d.a aVar2 = this.f113929d;
            if (aVar2 != null) {
                arrayList.add(aVar2);
            }
            com.tencent.halley.downloader.task.d.a aVar3 = b.this.f113912c;
            if (aVar3 != null) {
                arrayList.add(aVar3);
            }
            return arrayList;
        }

        public final boolean b(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) ? z16 ? !this.f113937l : !this.f113938m : ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, z16)).booleanValue();
        }

        public final synchronized void a(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            } else {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (this.f113928c == null) {
                    com.tencent.halley.downloader.task.d.a aVar = new com.tencent.halley.downloader.task.d.a(str, a.EnumC1249a.f113899d);
                    this.f113928c = aVar;
                    aVar.f113892e = b.this.f113917h.getAndIncrement();
                }
            }
        }

        public final synchronized void a(String str, a.EnumC1249a enumC1249a) {
            List<com.tencent.halley.downloader.task.d.a> list;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) enumC1249a);
                return;
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (enumC1249a == a.EnumC1249a.f113898c) {
                if (this.f113932g == null) {
                    this.f113932g = new ArrayList();
                }
                list = this.f113932g;
            } else if (enumC1249a == a.EnumC1249a.f113900e) {
                if (this.f113933h == null) {
                    this.f113933h = new ArrayList();
                }
                list = this.f113933h;
            } else if (enumC1249a == a.EnumC1249a.f113901f) {
                if (this.f113926a == null) {
                    this.f113926a = new ArrayList();
                }
                list = this.f113926a;
            } else if (enumC1249a == a.EnumC1249a.f113905j) {
                if (this.f113927b == null) {
                    this.f113927b = new ArrayList();
                }
                list = this.f113927b;
            } else if (enumC1249a == a.EnumC1249a.f113903h) {
                if (this.f113934i == null) {
                    this.f113934i = new ArrayList();
                }
                list = this.f113934i;
            } else if (enumC1249a == a.EnumC1249a.f113907l) {
                if (this.f113935j == null) {
                    this.f113935j = new ArrayList();
                }
                list = this.f113935j;
            } else {
                if (enumC1249a != a.EnumC1249a.f113908m) {
                    return;
                }
                if (this.f113936k == null) {
                    this.f113936k = new ArrayList();
                }
                list = this.f113936k;
            }
            Iterator<com.tencent.halley.downloader.task.d.a> it = list.iterator();
            while (it.hasNext()) {
                if (str.equalsIgnoreCase(it.next().f113890c)) {
                    return;
                }
            }
            com.tencent.halley.downloader.task.d.a aVar = new com.tencent.halley.downloader.task.d.a(str, enumC1249a);
            aVar.f113892e = b.this.f113917h.getAndIncrement();
            list.add(aVar);
        }

        private static void a(StringBuilder sb5, List<com.tencent.halley.downloader.task.d.a> list) {
            if (list == null) {
                return;
            }
            synchronized (list) {
                if (list.size() > 0) {
                    for (com.tencent.halley.downloader.task.d.a aVar : list) {
                        if (aVar != null) {
                            sb5.append(aVar);
                            sb5.append(",");
                        }
                    }
                }
            }
        }

        private static void a(List<com.tencent.halley.downloader.task.d.a> list, List<com.tencent.halley.downloader.task.d.a> list2) {
            if (list2 == null || list2.size() <= 0) {
                return;
            }
            list.addAll(list2);
        }

        public final void a(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, z16);
            } else if (z16) {
                this.f113937l = true;
            } else {
                this.f113938m = true;
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.halley.downloader.task.d.b$b, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1250b implements com.tencent.halley.downloader.e.b {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        private CountDownLatch f113941b;

        public C1250b(CountDownLatch countDownLatch) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this, (Object) countDownLatch);
            } else {
                this.f113941b = countDownLatch;
            }
        }

        @Override // com.tencent.halley.downloader.e.b
        public final void a(String str, int i3, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), str2);
                return;
            }
            try {
                d.a("halley-downloader-DownloadUrlMgr", "onResScheduleFail for url:" + str + "," + i3 + ", info:" + str2);
            } catch (Throwable th5) {
                try {
                    th5.printStackTrace();
                } finally {
                    this.f113941b.countDown();
                }
            }
        }

        @Override // com.tencent.halley.downloader.e.b
        public final void a(String str, com.tencent.halley.downloader.e.a.b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) bVar);
                return;
            }
            try {
                d.a("halley-downloader-DownloadUrlMgr", "onResScheduleSucc for url:" + str + "," + bVar.f113735k);
                List<String> list = bVar.f113735k;
                if (list != null && list.size() > 0) {
                    c.e();
                    String b16 = c.b();
                    if (!TextUtils.isEmpty(b16)) {
                        b.this.b(true);
                        for (String str2 : bVar.f113735k) {
                            if (!TextUtils.isEmpty(str2)) {
                                a.EnumC1249a enumC1249a = a.EnumC1249a.f113901f;
                                if (str2.toLowerCase().startsWith("https://")) {
                                    enumC1249a = a.EnumC1249a.f113905j;
                                }
                                b.this.a(b16, str2, enumC1249a);
                            }
                        }
                        if (!b.this.f113915f) {
                            b bVar2 = b.this;
                            long elapsedRealtime = SystemClock.elapsedRealtime();
                            b bVar3 = b.this;
                            bVar2.f113916g = (int) (elapsedRealtime - bVar3.f113920k);
                            long j3 = -1;
                            if (bVar3.f113918i == -1) {
                                long j16 = bVar.f113729e;
                                if (j16 > 0) {
                                    j3 = j16;
                                }
                            }
                            bVar3.f113918i = j3;
                            b bVar4 = b.this;
                            bVar4.f113921l = (!TextUtils.isEmpty(bVar4.f113921l) || TextUtils.isEmpty(bVar.f113730f)) ? "" : bVar.f113730f;
                            b bVar5 = b.this;
                            bVar5.f113924o = bVar.f113734j;
                            bVar5.f113922m = bVar.f113732h;
                            bVar5.f113925p = bVar.f113736l;
                            bVar5.f113915f = true;
                        }
                    }
                }
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    public b(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Long.valueOf(j3));
            return;
        }
        this.f113910a = new ArrayList();
        this.f113913d = null;
        this.f113914e = new ConcurrentHashMap();
        this.f113915f = false;
        this.f113916g = 0;
        this.f113917h = new AtomicInteger(0);
        this.f113918i = -1L;
        this.f113919j = -1L;
        this.f113920k = -1L;
        this.f113921l = "";
        this.f113922m = "";
        com.tencent.halley.downloader.task.d.a aVar = new com.tencent.halley.downloader.task.d.a(str, a.EnumC1249a.f113897b);
        this.f113911b = aVar;
        aVar.f113892e = this.f113917h.getAndIncrement();
        this.f113919j = j3;
        try {
            this.f113923n = new URL(str).getHost();
        } catch (MalformedURLException e16) {
            e16.printStackTrace();
        }
    }

    private com.tencent.halley.downloader.task.d.a a(com.tencent.halley.downloader.task.d.a aVar) {
        synchronized (this.f113910a) {
            if (this.f113910a.size() <= 0) {
                return null;
            }
            int indexOf = this.f113910a.indexOf(aVar);
            if (indexOf == -1) {
                return this.f113910a.get(0);
            }
            if (indexOf == this.f113910a.size() - 1) {
                return null;
            }
            return this.f113910a.get(indexOf + 1);
        }
    }

    public final int b() {
        int size;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        synchronized (this.f113910a) {
            size = this.f113910a.size();
        }
        return size;
    }

    public final boolean c() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        a aVar = this.f113914e.get(c.b());
        boolean z17 = false;
        if (aVar == null) {
            return false;
        }
        List<com.tencent.halley.downloader.task.d.a> list = aVar.f113926a;
        if (list != null && list.size() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            List<com.tencent.halley.downloader.task.d.a> list2 = aVar.f113927b;
            if (list2 != null && list2.size() > 0) {
                z17 = true;
            }
            return z17;
        }
        return z16;
    }

    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        if (this.f113911b != null) {
            sb5.append("0,");
            sb5.append(this.f113911b);
            sb5.append(";");
        }
        if (this.f113912c != null) {
            sb5.append("1,");
            sb5.append(this.f113912c);
            sb5.append(";");
        }
        Iterator<String> it = this.f113914e.keySet().iterator();
        while (it.hasNext()) {
            a aVar = this.f113914e.get(it.next());
            if (aVar != null) {
                sb5.append(aVar);
                sb5.append(";");
            }
        }
        return sb5.toString();
    }

    private com.tencent.halley.downloader.task.d.a a(String str, com.tencent.halley.downloader.task.d.a aVar) {
        com.tencent.halley.downloader.task.d.a aVar2;
        com.tencent.halley.downloader.task.d.a aVar3;
        a aVar4 = this.f113914e.get(str);
        com.tencent.halley.downloader.task.d.a aVar5 = null;
        if (aVar4 != null) {
            synchronized (aVar4) {
                List<com.tencent.halley.downloader.task.d.a> list = aVar4.f113927b;
                if (list != null && list.size() > 0) {
                    int indexOf = list.indexOf(aVar);
                    if (indexOf == -1) {
                        aVar3 = list.get(0);
                    } else if (indexOf < list.size() - 1) {
                        aVar3 = list.get(indexOf + 1);
                    }
                    aVar5 = aVar3;
                }
            }
        }
        return (aVar5 != null || (aVar2 = this.f113913d) == null) ? aVar5 : aVar2;
    }

    public final void b(boolean z16) {
        a a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
            return;
        }
        c.e();
        String b16 = c.b();
        if (TextUtils.isEmpty(b16) || (a16 = a(b16)) == null) {
            return;
        }
        a16.a(z16);
    }

    public final com.tencent.halley.downloader.task.d.a a(String str, com.tencent.halley.downloader.task.d.a aVar, boolean z16, boolean z17, boolean z18, boolean z19, boolean z26) {
        com.tencent.halley.downloader.task.d.a aVar2;
        a aVar3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.halley.downloader.task.d.a) iPatchRedirector.redirect((short) 3, this, str, aVar, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), Boolean.valueOf(z19), Boolean.valueOf(z26));
        }
        if (z19) {
            aVar2 = a(str, aVar);
            if (aVar2 != null) {
                return aVar2;
            }
        } else {
            aVar2 = null;
        }
        if (z18 && (aVar2 = a(aVar)) != null) {
            return aVar2;
        }
        a.EnumC1249a enumC1249a = aVar != null ? aVar.f113891d : null;
        if (((aVar == null || z17 || !com.tencent.halley.downloader.task.d.a.b(aVar.f113891d)) ? false : true) && (aVar3 = this.f113914e.get(str)) != null && (aVar2 = aVar3.a(aVar)) != null) {
            return aVar2;
        }
        if (z26 && this.f113915f) {
            enumC1249a = a.EnumC1249a.f113897b;
        }
        for (int length = a.EnumC1249a.values().length; aVar2 == null && length > 0; length--) {
            enumC1249a = com.tencent.halley.downloader.task.d.a.a(enumC1249a, z16);
            if (com.tencent.halley.downloader.task.d.a.a(enumC1249a)) {
                a aVar4 = this.f113914e.get(str);
                if (aVar4 != null) {
                    aVar2 = aVar4.a(enumC1249a);
                }
            } else {
                aVar2 = enumC1249a == a.EnumC1249a.f113902g ? this.f113912c : this.f113911b;
            }
        }
        return aVar2 == null ? this.f113911b : aVar2;
    }

    public final a a(String str) {
        a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (a) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.f113914e) {
            aVar = this.f113914e.get(str);
            if (aVar == null) {
                aVar = new a(str);
                this.f113914e.put(str, aVar);
            }
        }
        return aVar;
    }

    public final List<com.tencent.halley.downloader.e.a> a() {
        ArrayList arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        List<com.tencent.halley.downloader.e.a> list = this.f113924o;
        if (list == null) {
            return null;
        }
        synchronized (list) {
            arrayList = new ArrayList();
            for (com.tencent.halley.downloader.e.a aVar : this.f113924o) {
                arrayList.add(new com.tencent.halley.downloader.e.a(aVar.f113723a, aVar.f113724b));
            }
        }
        return arrayList;
    }

    public final void a(String str, String str2, a.EnumC1249a enumC1249a) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, str2, enumC1249a);
            return;
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            String host = new URL(str2).getHost();
            if (host.charAt(0) == '[' && host.charAt(host.length() - 1) == ']') {
                if (c.i() == 1) {
                    d.b("halley-downloader-DownloadUrlMgr", "ignore ipv6 addr when in ipv4 only network");
                    return;
                }
            } else if (e.b(host) && c.i() == 3) {
                d.b("halley-downloader-DownloadUrlMgr", "ignore ipv4 addr when in ipv6 only network");
                return;
            }
            a a16 = a(str);
            if (a16 != null) {
                a16.a(str2, enumC1249a);
                d.b("halley-downloader-DownloadUrlMgr", "addUrlByApn...apn:" + str + ",type:" + enumC1249a + ",url:" + str2);
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public final boolean a(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, z16)).booleanValue();
        }
        c.e();
        String b16 = c.b();
        if (TextUtils.isEmpty(b16)) {
            return false;
        }
        a aVar = this.f113914e.get(b16);
        return aVar == null || aVar.b(z16);
    }
}
