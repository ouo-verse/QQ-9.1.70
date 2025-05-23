package com.tencent.gamecenter.wadl.sdk.downloader.task.k;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.sdk.common.b.c;
import com.tencent.gamecenter.wadl.sdk.common.e.g;
import com.tencent.gamecenter.wadl.sdk.downloader.manager.DNSPreParseManager;
import com.tencent.gamecenter.wadl.sdk.downloader.task.k.a;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public com.tencent.gamecenter.wadl.sdk.downloader.task.k.a f107627a;

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.gamecenter.wadl.sdk.downloader.task.k.a f107628b;

    /* renamed from: d, reason: collision with root package name */
    private long f107630d;

    /* renamed from: i, reason: collision with root package name */
    private List<com.tencent.gamecenter.wadl.sdk.downloader.d.a> f107635i;

    /* renamed from: l, reason: collision with root package name */
    public int f107638l;

    /* renamed from: n, reason: collision with root package name */
    private Map<Integer, Map<String, String>> f107640n;

    /* renamed from: o, reason: collision with root package name */
    private String f107641o;

    /* renamed from: c, reason: collision with root package name */
    public com.tencent.gamecenter.wadl.sdk.downloader.task.k.a f107629c = null;

    /* renamed from: e, reason: collision with root package name */
    public Map<String, C1137b> f107631e = new ConcurrentHashMap();

    /* renamed from: f, reason: collision with root package name */
    private AtomicInteger f107632f = new AtomicInteger(0);

    /* renamed from: g, reason: collision with root package name */
    private volatile long f107633g = -1;

    /* renamed from: h, reason: collision with root package name */
    private String f107634h = "";

    /* renamed from: j, reason: collision with root package name */
    private String f107636j = "";

    /* renamed from: k, reason: collision with root package name */
    public volatile boolean f107637k = false;

    /* renamed from: m, reason: collision with root package name */
    private long f107639m = -1;

    /* renamed from: p, reason: collision with root package name */
    private final List<com.tencent.gamecenter.wadl.sdk.downloader.task.k.a> f107642p = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a implements com.tencent.gamecenter.wadl.sdk.downloader.d.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f107643a;

        a(CountDownLatch countDownLatch) {
            this.f107643a = countDownLatch;
        }

        @Override // com.tencent.gamecenter.wadl.sdk.downloader.d.b
        public void a(String str, int i3, String str2) {
            try {
                com.tencent.gamecenter.wadl.sdk.common.e.b.d("Wadl-downloader-DownloadUrlMgr", "onResScheduleFail for url:" + str + "," + i3 + ", info:" + str2);
            } finally {
                try {
                } finally {
                }
            }
        }

        @Override // com.tencent.gamecenter.wadl.sdk.downloader.d.b
        public void a(String str, List<String> list, long j3, String str2, String str3, List<com.tencent.gamecenter.wadl.sdk.downloader.d.a> list2, String str4, Map<Integer, Map<String, String>> map) {
            try {
                com.tencent.gamecenter.wadl.sdk.common.e.b.d("Wadl-downloader-DownloadUrlMgr", "onResScheduleSucc for url:" + str + "," + list);
                if (list != null && list.size() > 0) {
                    c.m();
                    String b16 = c.b();
                    if (TextUtils.isEmpty(b16)) {
                        return;
                    }
                    b.this.b(true);
                    Iterator<String> it = list.iterator();
                    while (it.hasNext()) {
                        b.this.a(it.next(), b16);
                    }
                    if (!b.this.f107637k) {
                        b.this.f107638l = (int) (SystemClock.elapsedRealtime() - b.this.f107639m);
                        b bVar = b.this;
                        if (bVar.f107633g != -1 || j3 <= 0) {
                            j3 = -1;
                        }
                        bVar.f107633g = j3;
                        b bVar2 = b.this;
                        if (!TextUtils.isEmpty(bVar2.f107634h) || TextUtils.isEmpty(str2)) {
                            str2 = "";
                        }
                        bVar2.f107634h = str2;
                        b.this.f107635i = list2;
                        b.this.f107636j = str4;
                        b.this.f107640n = map;
                        b.this.f107637k = true;
                    }
                }
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: com.tencent.gamecenter.wadl.sdk.downloader.task.k.b$b, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1137b {

        /* renamed from: a, reason: collision with root package name */
        String f107645a;

        /* renamed from: b, reason: collision with root package name */
        List<com.tencent.gamecenter.wadl.sdk.downloader.task.k.a> f107646b;

        /* renamed from: c, reason: collision with root package name */
        List<com.tencent.gamecenter.wadl.sdk.downloader.task.k.a> f107647c;

        /* renamed from: d, reason: collision with root package name */
        List<com.tencent.gamecenter.wadl.sdk.downloader.task.k.a> f107648d;

        /* renamed from: e, reason: collision with root package name */
        List<com.tencent.gamecenter.wadl.sdk.downloader.task.k.a> f107649e;

        /* renamed from: f, reason: collision with root package name */
        com.tencent.gamecenter.wadl.sdk.downloader.task.k.a f107650f;

        /* renamed from: g, reason: collision with root package name */
        List<com.tencent.gamecenter.wadl.sdk.downloader.task.k.a> f107651g;

        /* renamed from: h, reason: collision with root package name */
        List<com.tencent.gamecenter.wadl.sdk.downloader.task.k.a> f107652h;

        /* renamed from: i, reason: collision with root package name */
        com.tencent.gamecenter.wadl.sdk.downloader.task.k.a f107653i;

        /* renamed from: j, reason: collision with root package name */
        boolean f107654j = false;

        /* renamed from: k, reason: collision with root package name */
        boolean f107655k = false;

        /* renamed from: l, reason: collision with root package name */
        private int f107656l = 0;

        public C1137b(String str) {
            this.f107645a = str;
        }

        private void f(StringBuilder sb5, List<com.tencent.gamecenter.wadl.sdk.downloader.task.k.a> list) {
            if (list != null) {
                synchronized (list) {
                    if (sb5 != null) {
                        if (list.size() > 0) {
                            for (com.tencent.gamecenter.wadl.sdk.downloader.task.k.a aVar : list) {
                                if (aVar != null) {
                                    sb5.append(aVar);
                                    sb5.append(",");
                                }
                            }
                        }
                    }
                }
            }
        }

        private void g(List<com.tencent.gamecenter.wadl.sdk.downloader.task.k.a> list, List<com.tencent.gamecenter.wadl.sdk.downloader.task.k.a> list2) {
            if (list2 != null && list2.size() > 0) {
                list.addAll(list2);
            }
        }

        private List<com.tencent.gamecenter.wadl.sdk.downloader.task.k.a> i(a.EnumC1136a enumC1136a) {
            if (enumC1136a == a.EnumC1136a.Type_CDN_Ip_App_Input) {
                return this.f107646b;
            }
            if (enumC1136a == a.EnumC1136a.Type_CDN_Ip_Http_Header) {
                return this.f107647c;
            }
            if (enumC1136a == a.EnumC1136a.Type_CDN_Ip_Socket_Schedule) {
                return this.f107648d;
            }
            if (enumC1136a == a.EnumC1136a.Type_CDN_Ip_Socket_Schedule_Https) {
                return this.f107649e;
            }
            if (enumC1136a == a.EnumC1136a.Type_Src_Ip_App_Input) {
                return this.f107651g;
            }
            if (enumC1136a == a.EnumC1136a.Type_CDN_Ip_Local_Dns) {
                return this.f107652h;
            }
            return null;
        }

        public synchronized com.tencent.gamecenter.wadl.sdk.downloader.task.k.a a(a.EnumC1136a enumC1136a) {
            List<com.tencent.gamecenter.wadl.sdk.downloader.task.k.a> i3;
            if (enumC1136a == a.EnumC1136a.Type_CDN_Ip_Jumped) {
                return this.f107650f;
            }
            if (enumC1136a == a.EnumC1136a.Type_Src_Ip_Jumped) {
                return this.f107653i;
            }
            if (com.tencent.gamecenter.wadl.sdk.downloader.task.k.a.b(enumC1136a) && (i3 = i(enumC1136a)) != null) {
                if (this.f107656l > i3.size() - 1) {
                    this.f107656l = 0;
                }
                int i16 = this.f107656l;
                this.f107656l = i16 + 1;
                return i3.get(i16);
            }
            return null;
        }

        public synchronized com.tencent.gamecenter.wadl.sdk.downloader.task.k.a b(com.tencent.gamecenter.wadl.sdk.downloader.task.k.a aVar) {
            if (aVar == null) {
                return null;
            }
            List<com.tencent.gamecenter.wadl.sdk.downloader.task.k.a> i3 = i(aVar.f107609b);
            if (i3 != null) {
                for (int i16 = 0; i16 < i3.size(); i16++) {
                    if (aVar == i3.get(i16)) {
                        if (i16 == i3.size() - 1) {
                            return null;
                        }
                        return i3.get(i16 + 1);
                    }
                }
            }
            return null;
        }

        public synchronized List<com.tencent.gamecenter.wadl.sdk.downloader.task.k.a> c() {
            ArrayList arrayList;
            arrayList = new ArrayList();
            arrayList.add(b.this.f107627a);
            g(arrayList, this.f107646b);
            g(arrayList, this.f107647c);
            g(arrayList, this.f107648d);
            g(arrayList, this.f107649e);
            com.tencent.gamecenter.wadl.sdk.downloader.task.k.a aVar = this.f107650f;
            if (aVar != null) {
                arrayList.add(aVar);
            }
            g(arrayList, this.f107651g);
            com.tencent.gamecenter.wadl.sdk.downloader.task.k.a aVar2 = this.f107653i;
            if (aVar2 != null) {
                arrayList.add(aVar2);
            }
            com.tencent.gamecenter.wadl.sdk.downloader.task.k.a aVar3 = b.this.f107628b;
            if (aVar3 != null) {
                arrayList.add(aVar3);
            }
            return arrayList;
        }

        public synchronized void d(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (this.f107650f == null) {
                com.tencent.gamecenter.wadl.sdk.downloader.task.k.a aVar = new com.tencent.gamecenter.wadl.sdk.downloader.task.k.a(str, a.EnumC1136a.Type_CDN_Ip_Jumped);
                this.f107650f = aVar;
                aVar.a(b.this.f107632f.getAndIncrement());
            }
        }

        public synchronized void e(String str, a.EnumC1136a enumC1136a) {
            List<com.tencent.gamecenter.wadl.sdk.downloader.task.k.a> list;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            com.tencent.gamecenter.wadl.sdk.common.e.b.a("Wadl-downloader-DownloadUrlMgr", "[addUrlToList] url=" + str + ", type=" + enumC1136a);
            if (enumC1136a == a.EnumC1136a.Type_CDN_Ip_App_Input) {
                if (this.f107646b == null) {
                    this.f107646b = new ArrayList();
                }
                list = this.f107646b;
            } else if (enumC1136a == a.EnumC1136a.Type_CDN_Ip_Http_Header) {
                if (this.f107647c == null) {
                    this.f107647c = new ArrayList();
                }
                list = this.f107647c;
            } else if (enumC1136a == a.EnumC1136a.Type_CDN_Ip_Socket_Schedule) {
                if (this.f107648d == null) {
                    this.f107648d = new ArrayList();
                }
                list = this.f107648d;
            } else if (enumC1136a == a.EnumC1136a.Type_CDN_Ip_Socket_Schedule_Https) {
                if (this.f107649e == null) {
                    this.f107649e = new ArrayList();
                }
                list = this.f107649e;
            } else if (enumC1136a == a.EnumC1136a.Type_Src_Ip_App_Input) {
                if (this.f107651g == null) {
                    this.f107651g = new ArrayList();
                }
                list = this.f107651g;
            } else if (enumC1136a == a.EnumC1136a.Type_CDN_Ip_Local_Dns) {
                if (this.f107652h == null) {
                    this.f107652h = new ArrayList();
                }
                list = this.f107652h;
            } else {
                return;
            }
            Iterator<com.tencent.gamecenter.wadl.sdk.downloader.task.k.a> it = list.iterator();
            while (it.hasNext()) {
                if (str.equalsIgnoreCase(it.next().f107608a)) {
                    return;
                }
            }
            com.tencent.gamecenter.wadl.sdk.downloader.task.k.a aVar = new com.tencent.gamecenter.wadl.sdk.downloader.task.k.a(str, enumC1136a);
            aVar.a(b.this.f107632f.getAndIncrement());
            list.add(aVar);
        }

        public boolean h(boolean z16) {
            boolean z17;
            if (z16) {
                z17 = this.f107654j;
            } else {
                z17 = this.f107655k;
            }
            return !z17;
        }

        public synchronized void j(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (this.f107653i == null) {
                com.tencent.gamecenter.wadl.sdk.downloader.task.k.a aVar = new com.tencent.gamecenter.wadl.sdk.downloader.task.k.a(str, a.EnumC1136a.Type_Src_Ip_Jumped);
                this.f107653i = aVar;
                aVar.a(b.this.f107632f.getAndIncrement());
            }
        }

        public void k(boolean z16) {
            if (z16) {
                this.f107654j = true;
            } else {
                this.f107655k = true;
            }
        }

        public String toString() {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(g.a(this.f107645a));
            sb5.append(",");
            f(sb5, this.f107646b);
            f(sb5, this.f107647c);
            f(sb5, this.f107648d);
            f(sb5, this.f107649e);
            com.tencent.gamecenter.wadl.sdk.downloader.task.k.a aVar = this.f107650f;
            if (aVar != null) {
                sb5.append(aVar);
                sb5.append(",");
            }
            f(sb5, this.f107651g);
            com.tencent.gamecenter.wadl.sdk.downloader.task.k.a aVar2 = this.f107653i;
            if (aVar2 != null) {
                sb5.append(aVar2);
            }
            sb5.deleteCharAt(sb5.length() - 1);
            return sb5.toString();
        }
    }

    public b(String str, long j3) {
        this.f107630d = -1L;
        com.tencent.gamecenter.wadl.sdk.downloader.task.k.a aVar = new com.tencent.gamecenter.wadl.sdk.downloader.task.k.a(str, a.EnumC1136a.Type_CDN_Domain);
        this.f107627a = aVar;
        aVar.a(this.f107632f.getAndIncrement());
        this.f107630d = j3;
        try {
            this.f107641o = new URL(str).getHost();
        } catch (MalformedURLException e16) {
            e16.printStackTrace();
        }
    }

    private void h() {
        if (this.f107639m == -1) {
            this.f107639m = SystemClock.elapsedRealtime();
        }
    }

    public int a() {
        List<com.tencent.gamecenter.wadl.sdk.downloader.task.k.a> c16;
        C1137b c1137b = this.f107631e.get(c.b());
        if (c1137b == null || (c16 = c1137b.c()) == null) {
            return 1;
        }
        return c16.size();
    }

    public int c() {
        int a16 = a();
        if (!TextUtils.isEmpty(this.f107627a.f107612e)) {
            a16--;
        }
        com.tencent.gamecenter.wadl.sdk.downloader.task.k.a aVar = this.f107628b;
        if (aVar != null && !TextUtils.isEmpty(aVar.f107612e)) {
            a16--;
        }
        if (a16 > 0) {
            return a16;
        }
        return 1;
    }

    public List<com.tencent.gamecenter.wadl.sdk.downloader.d.a> d() {
        ArrayList arrayList;
        List<com.tencent.gamecenter.wadl.sdk.downloader.d.a> list = this.f107635i;
        if (list == null) {
            return null;
        }
        synchronized (list) {
            arrayList = new ArrayList();
            Iterator<com.tencent.gamecenter.wadl.sdk.downloader.d.a> it = this.f107635i.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().a());
            }
        }
        return arrayList;
    }

    public String e() {
        return this.f107636j;
    }

    public long f() {
        return this.f107633g;
    }

    public int g() {
        int size;
        synchronized (this.f107642p) {
            size = this.f107642p.size();
        }
        return size;
    }

    private com.tencent.gamecenter.wadl.sdk.downloader.task.k.a b(com.tencent.gamecenter.wadl.sdk.downloader.task.k.a aVar) {
        synchronized (this.f107642p) {
            if (this.f107642p.size() <= 0) {
                return null;
            }
            int indexOf = this.f107642p.indexOf(aVar);
            if (indexOf == -1) {
                return this.f107642p.get(0);
            }
            if (indexOf == this.f107642p.size() - 1) {
                return null;
            }
            return this.f107642p.get(indexOf + 1);
        }
    }

    private C1137b b(String str) {
        C1137b c1137b;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.f107631e) {
            c1137b = this.f107631e.get(str);
            if (c1137b == null) {
                c1137b = new C1137b(str);
                this.f107631e.put(str, c1137b);
            }
        }
        return c1137b;
    }

    public void c(String str, String str2) {
        C1137b b16;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (b16 = b(str)) == null) {
            return;
        }
        b16.j(str2);
    }

    public void d(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.tencent.gamecenter.wadl.sdk.downloader.task.k.a aVar = new com.tencent.gamecenter.wadl.sdk.downloader.task.k.a(str, a.EnumC1136a.Type_Src_Domain);
        this.f107628b = aVar;
        aVar.a(this.f107632f.getAndIncrement());
    }

    public com.tencent.gamecenter.wadl.sdk.downloader.task.k.a a(a.EnumC1136a enumC1136a) {
        C1137b b16 = b(c.b());
        if (b16 != null) {
            return (enumC1136a == a.EnumC1136a.Type_CDN_Domain || enumC1136a == a.EnumC1136a.Type_Outer) ? b16.f107650f : b16.f107653i;
        }
        return null;
    }

    public String b() {
        return this.f107641o;
    }

    public boolean c(String str) {
        if (!str.toLowerCase().startsWith("https://")) {
            return false;
        }
        com.tencent.gamecenter.wadl.sdk.downloader.task.k.a aVar = new com.tencent.gamecenter.wadl.sdk.downloader.task.k.a(str, a.EnumC1136a.Type_CDN_Ip_User_Https);
        this.f107629c = aVar;
        aVar.a(this.f107632f.getAndIncrement());
        return true;
    }

    private com.tencent.gamecenter.wadl.sdk.downloader.task.k.a a(String str, com.tencent.gamecenter.wadl.sdk.downloader.task.k.a aVar) {
        com.tencent.gamecenter.wadl.sdk.downloader.task.k.a aVar2;
        com.tencent.gamecenter.wadl.sdk.downloader.task.k.a aVar3;
        C1137b c1137b = this.f107631e.get(str);
        com.tencent.gamecenter.wadl.sdk.downloader.task.k.a aVar4 = null;
        if (c1137b != null) {
            synchronized (c1137b) {
                List<com.tencent.gamecenter.wadl.sdk.downloader.task.k.a> list = c1137b.f107649e;
                if (list != null && list.size() > 0) {
                    int indexOf = list.indexOf(aVar);
                    if (indexOf == -1) {
                        aVar3 = list.get(0);
                    } else if (indexOf < list.size() - 1) {
                        aVar3 = list.get(indexOf + 1);
                    }
                    aVar4 = aVar3;
                }
            }
        }
        return (aVar4 != null || (aVar2 = this.f107629c) == null) ? aVar4 : aVar2;
    }

    private com.tencent.gamecenter.wadl.sdk.downloader.task.k.a a(String str, com.tencent.gamecenter.wadl.sdk.downloader.task.k.a aVar, boolean z16) {
        C1137b c1137b;
        if (z16 || !com.tencent.gamecenter.wadl.sdk.downloader.task.k.a.b(aVar.f107609b) || (c1137b = this.f107631e.get(str)) == null) {
            return null;
        }
        return c1137b.b(aVar);
    }

    public Map<String, String> b(a.EnumC1136a enumC1136a) {
        Map<Integer, Map<String, String>> map;
        int i3;
        Map<Integer, Map<String, String>> map2 = this.f107640n;
        if (map2 == null || map2.size() <= 0) {
            return null;
        }
        if (enumC1136a == a.EnumC1136a.Type_CDN_Ip_Socket_Schedule) {
            map = this.f107640n;
            i3 = 0;
        } else {
            if (enumC1136a != a.EnumC1136a.Type_CDN_Ip_Socket_Schedule_Https) {
                return null;
            }
            map = this.f107640n;
            i3 = 1;
        }
        return map.get(Integer.valueOf(i3));
    }

    public com.tencent.gamecenter.wadl.sdk.downloader.task.k.a a(String str, com.tencent.gamecenter.wadl.sdk.downloader.task.k.a aVar, boolean z16, boolean z17, boolean z18, boolean z19, boolean z26) {
        a.EnumC1136a enumC1136a;
        com.tencent.gamecenter.wadl.sdk.downloader.task.k.a a16 = a(z19, z18, str, aVar);
        if (a16 != null || aVar == null) {
            enumC1136a = null;
        } else {
            a.EnumC1136a enumC1136a2 = aVar.f107609b;
            a16 = a(str, aVar, z17);
            enumC1136a = enumC1136a2;
        }
        if (a16 != null) {
            return a16;
        }
        if (z26 && this.f107637k) {
            enumC1136a = a.EnumC1136a.Type_CDN_Domain;
        }
        for (int length = a.EnumC1136a.values().length; a16 == null && length > 0; length--) {
            enumC1136a = com.tencent.gamecenter.wadl.sdk.downloader.task.k.a.a(enumC1136a, z16);
            if (com.tencent.gamecenter.wadl.sdk.downloader.task.k.a.a(enumC1136a)) {
                C1137b c1137b = this.f107631e.get(str);
                if (c1137b != null) {
                    a16 = c1137b.a(enumC1136a);
                }
            } else {
                a16 = enumC1136a == a.EnumC1136a.Type_Src_Domain ? this.f107628b : this.f107627a;
            }
        }
        return a16 == null ? this.f107627a : a16;
    }

    public void b(String str, String str2) {
        C1137b b16;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (b16 = b(str)) == null) {
            return;
        }
        b16.d(str2);
    }

    private void b(URL url, List<String> list) {
        String b16 = c.b();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String b17 = com.tencent.gamecenter.wadl.sdk.common.e.c.b(url, it.next());
            if (!TextUtils.isEmpty(b17)) {
                a(b16, b17, a.EnumC1136a.Type_CDN_Ip_Local_Dns);
            }
        }
    }

    public synchronized com.tencent.gamecenter.wadl.sdk.downloader.task.k.a a(List<com.tencent.gamecenter.wadl.sdk.downloader.task.k.a> list, boolean z16) {
        List<com.tencent.gamecenter.wadl.sdk.downloader.task.k.a> c16;
        C1137b c1137b = this.f107631e.get(c.b());
        if (c1137b != null && (c16 = c1137b.c()) != null) {
            if (z16) {
                for (com.tencent.gamecenter.wadl.sdk.downloader.task.k.a aVar : c16) {
                    if (aVar.f107609b == a.EnumC1136a.Type_CDN_Ip_Socket_Schedule_Https && !list.contains(aVar)) {
                        return aVar;
                    }
                }
            }
            for (com.tencent.gamecenter.wadl.sdk.downloader.task.k.a aVar2 : c16) {
                if (!list.contains(aVar2) && !aVar2.f107613f) {
                    return aVar2;
                }
            }
        }
        return null;
    }

    private com.tencent.gamecenter.wadl.sdk.downloader.task.k.a a(boolean z16, boolean z17, String str, com.tencent.gamecenter.wadl.sdk.downloader.task.k.a aVar) {
        if (aVar != null) {
            return z17 ? b(aVar) : z16 ? a(str, aVar) : null;
        }
        return null;
    }

    public void b(boolean z16) {
        C1137b b16;
        c.m();
        String b17 = c.b();
        if (TextUtils.isEmpty(b17) || (b16 = b(b17)) == null) {
            return;
        }
        b16.k(z16);
    }

    public void a(int i3) {
        h();
        if (a(true)) {
            CountDownLatch countDownLatch = new CountDownLatch(1);
            a aVar = new a(countDownLatch);
            com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-downloader-DownloadUrlMgr", "start resSchedule url:" + this.f107627a.f107608a);
            com.tencent.gamecenter.wadl.sdk.downloader.d.c.a(this.f107627a.f107608a, this.f107630d, aVar, i3, this.f107637k ^ true);
            try {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                countDownLatch.await(20000L, TimeUnit.MILLISECONDS);
                com.tencent.gamecenter.wadl.sdk.common.e.b.a("Wadl-downloader-DownloadUrlMgr", "resSchedule time:" + (SystemClock.elapsedRealtime() - elapsedRealtime));
            } catch (InterruptedException e16) {
                com.tencent.gamecenter.wadl.sdk.common.e.b.b("Wadl-downloader-DownloadUrlMgr", "socketSchedule fail", e16);
            }
        }
    }

    public void a(com.tencent.gamecenter.wadl.sdk.downloader.task.k.a aVar) {
        synchronized (this.f107642p) {
            aVar.f107611d = true;
            this.f107642p.add(aVar);
        }
    }

    public void a(String str) {
        Object obj;
        if (!DNSPreParseManager.getInstance().isDnsPreParseSwitchOn()) {
            com.tencent.gamecenter.wadl.sdk.common.e.b.b("Wadl-downloader-DownloadUrlMgr", "[changeDownloadDomainToIp] dns pre parse swich is off!!!");
            return;
        }
        try {
            URL url = new URL(str);
            Pair<List<String>, List<String>> allIpsFromCache = DNSPreParseManager.getInstance().getAllIpsFromCache(c.b(), url.getHost());
            if (((List) allIpsFromCache.first).size() == 0 && ((List) allIpsFromCache.second).size() == 0) {
                com.tencent.gamecenter.wadl.sdk.common.e.b.b("Wadl-downloader-DownloadUrlMgr", "[changeDownloadDomainToIp] dns pre parse fail because ip pool is empty!!!");
                a(false, url.getHost(), (Pair<List<String>, List<String>>) null);
                return;
            }
            a(true, url.getHost(), allIpsFromCache);
            byte c16 = c.c();
            if (c16 == 1) {
                obj = allIpsFromCache.first;
            } else {
                if (c16 != 2) {
                    if (c16 != 3) {
                        return;
                    }
                    b(url, (List<String>) allIpsFromCache.second);
                    return;
                }
                b(url, (List<String>) allIpsFromCache.second);
                obj = allIpsFromCache.first;
            }
            a(url, (List<String>) obj);
        } catch (MalformedURLException e16) {
            a(false, "", (Pair<List<String>, List<String>>) null);
            com.tencent.gamecenter.wadl.sdk.common.e.b.b("Wadl-downloader-DownloadUrlMgr", "[changeDownloadDomainToIp] occur MalformedURLException: ", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a.EnumC1136a enumC1136a = a.EnumC1136a.Type_CDN_Ip_Socket_Schedule;
        if (str.toLowerCase().startsWith("https://")) {
            enumC1136a = a.EnumC1136a.Type_CDN_Ip_Socket_Schedule_Https;
        }
        a(str2, str, enumC1136a);
    }

    public void a(String str, String str2, a.EnumC1136a enumC1136a) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            String host = new URL(str2).getHost();
            if (host.charAt(0) == '[' && host.charAt(host.length() - 1) == ']') {
                if (c.c() == 1) {
                    com.tencent.gamecenter.wadl.sdk.common.e.b.a("Wadl-downloader-DownloadUrlMgr", "ignore ipv6 addr when in ipv4 only network");
                    return;
                }
            } else if (com.tencent.gamecenter.wadl.sdk.common.e.c.b(host) && c.c() == 3) {
                com.tencent.gamecenter.wadl.sdk.common.e.b.a("Wadl-downloader-DownloadUrlMgr", "ignore ipv4 addr when in ipv6 only network");
                return;
            }
            C1137b b16 = b(str);
            if (b16 != null) {
                b16.e(str2, enumC1136a);
                com.tencent.gamecenter.wadl.sdk.common.e.b.a("Wadl-downloader-DownloadUrlMgr", "addUrlByApn...apn:" + str + ",type:" + enumC1136a + ",url:" + str2);
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    private void a(URL url, List<String> list) {
        String b16 = c.b();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String a16 = com.tencent.gamecenter.wadl.sdk.common.e.c.a(url, it.next());
            if (!TextUtils.isEmpty(a16)) {
                a(b16, a16, a.EnumC1136a.Type_CDN_Ip_Local_Dns);
            }
        }
    }

    private void a(boolean z16, String str, Pair<List<String>, List<String>> pair) {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        if (pair != null) {
            arrayList.addAll((Collection) pair.first);
            arrayList.addAll((Collection) pair.second);
        }
        hashMap.put("change_to_ip_ips", TextUtils.join(",", arrayList));
        hashMap.put("change_to_ip_domain", str);
        hashMap.put("change_to_ip_apn", c.b());
        hashMap.put("dns_type", String.valueOf(DNSPreParseManager.getInstance().getDnsPreParseType()));
        hashMap.put("change_to_ip_result", (!z16 || arrayList.size() <= 0) ? "0" : "1");
        hashMap.put("change_to_ip_dnstype", String.valueOf(DNSPreParseManager.getInstance().getDnsPreParseType()));
        com.tencent.gamecenter.wadl.sdk.downloader.b.b dnsParserImplByType = DNSPreParseManager.getInstance().getDnsParserImplByType(DNSPreParseManager.getInstance().getDnsPreParseType());
        if (dnsParserImplByType != null) {
            if (z16) {
                dnsParserImplByType.b(WadlProxyConsts.OPER_ID_URL_CHANGE, "51", hashMap);
            } else {
                dnsParserImplByType.a(WadlProxyConsts.OPER_ID_URL_CHANGE, "51", hashMap);
            }
        }
    }

    public boolean a(boolean z16) {
        c.m();
        String b16 = c.b();
        if (TextUtils.isEmpty(b16)) {
            return false;
        }
        C1137b c1137b = this.f107631e.get(b16);
        return c1137b == null || c1137b.h(z16);
    }
}
