package com.tencent.luggage.wxa.lm;

import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.tencent.bugly.common.utils.DeviceInfoUtil;
import com.tencent.luggage.wxa.lm.a;
import com.tencent.luggage.wxa.p9.c;
import com.tencent.luggage.wxa.so.c;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.i0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes8.dex */
public class i implements l {
    private static final String W = "MicroMsg.Audio.AudioPlayerMgr";
    private static final int X = 3;
    private static final int Y = 2;
    private static final int Z = 1;

    /* renamed from: a0, reason: collision with root package name */
    private static final int f133625a0 = 10000;

    /* renamed from: b0, reason: collision with root package name */
    private static final int f133626b0 = 500;

    /* renamed from: c0, reason: collision with root package name */
    private static final int f133627c0 = 30;

    /* renamed from: d0, reason: collision with root package name */
    private static i f133628d0;
    private com.tencent.luggage.wxa.j9.c B;
    private com.tencent.luggage.wxa.h9.a I;
    private Handler J;
    private Looper K;

    /* renamed from: u, reason: collision with root package name */
    private com.tencent.luggage.wxa.mm.a f133649u;

    /* renamed from: a, reason: collision with root package name */
    private LinkedList<String> f133629a = new LinkedList<>();

    /* renamed from: b, reason: collision with root package name */
    private HashMap<String, m> f133630b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private LinkedList<String> f133631c = new LinkedList<>();

    /* renamed from: d, reason: collision with root package name */
    private HashMap<String, m> f133632d = new HashMap<>();

    /* renamed from: e, reason: collision with root package name */
    private LinkedList<String> f133633e = new LinkedList<>();

    /* renamed from: f, reason: collision with root package name */
    private LinkedList<String> f133634f = new LinkedList<>();

    /* renamed from: g, reason: collision with root package name */
    private HashMap<String, String> f133635g = new HashMap<>();

    /* renamed from: h, reason: collision with root package name */
    private HashMap<String, LinkedList<String>> f133636h = new HashMap<>();

    /* renamed from: i, reason: collision with root package name */
    private HashMap<String, com.tencent.luggage.wxa.qb.b> f133637i = new HashMap<>();

    /* renamed from: j, reason: collision with root package name */
    private HashMap<String, com.tencent.luggage.wxa.qb.d> f133638j = new HashMap<>();

    /* renamed from: k, reason: collision with root package name */
    private LinkedList<String> f133639k = new LinkedList<>();

    /* renamed from: l, reason: collision with root package name */
    private LinkedList<String> f133640l = new LinkedList<>();

    /* renamed from: m, reason: collision with root package name */
    private HashMap<String, Integer> f133641m = new HashMap<>();

    /* renamed from: n, reason: collision with root package name */
    private LinkedList<String> f133642n = new LinkedList<>();

    /* renamed from: o, reason: collision with root package name */
    private volatile Set<String> f133643o = new HashSet();

    /* renamed from: p, reason: collision with root package name */
    private Object f133644p = new Object();

    /* renamed from: q, reason: collision with root package name */
    private boolean f133645q = false;

    /* renamed from: r, reason: collision with root package name */
    private boolean f133646r = false;

    /* renamed from: s, reason: collision with root package name */
    private long f133647s = 0;

    /* renamed from: t, reason: collision with root package name */
    private long f133648t = 0;

    /* renamed from: v, reason: collision with root package name */
    private com.tencent.luggage.wxa.qb.a f133650v = new com.tencent.luggage.wxa.qb.a();

    /* renamed from: w, reason: collision with root package name */
    private com.tencent.luggage.wxa.nm.a f133651w = new com.tencent.luggage.wxa.nm.a();

    /* renamed from: x, reason: collision with root package name */
    private final i0.b[] f133652x = {null};

    /* renamed from: y, reason: collision with root package name */
    private final ArrayList<com.tencent.luggage.wxa.lm.k> f133653y = new ArrayList<>();

    /* renamed from: z, reason: collision with root package name */
    private HashMap<String, String> f133654z = new HashMap<>();
    private HashMap<String, Integer> A = new HashMap<>();
    volatile boolean C = true;
    private volatile boolean D = true;
    private com.tencent.luggage.wxa.so.c E = com.tencent.luggage.wxa.so.c.a(new c.a() { // from class: com.tencent.luggage.wxa.lm.n
        @Override // com.tencent.luggage.wxa.so.c.a
        public final Object a() {
            AudioManager s16;
            s16 = i.s();
            return s16;
        }
    });
    private long F = 0;
    private LinkedList<String> G = new LinkedList<>();
    private LinkedList<String> H = new LinkedList<>();
    private com.tencent.luggage.wxa.lm.a L = null;
    private a.c M = null;
    private com.tencent.luggage.wxa.lm.f N = new c();
    private Runnable O = new d();
    private Runnable P = new e();
    private com.tencent.luggage.wxa.j9.b Q = new g();
    private com.tencent.luggage.wxa.j9.g R = new h();
    private com.tencent.luggage.wxa.h9.f S = new C6448i();
    volatile int T = 0;
    public Object U = new Object();
    private com.tencent.luggage.wxa.qb.e V = new a();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements com.tencent.luggage.wxa.qb.e {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.qb.e
        public void a(String str) {
            synchronized (i.this.U) {
                if (!i.this.f133643o.contains(str)) {
                    i.this.f133643o.add(str);
                }
            }
        }

        @Override // com.tencent.luggage.wxa.qb.e
        public void b(String str) {
            synchronized (i.this.U) {
                i.this.f133643o.remove(str);
            }
        }

        @Override // com.tencent.luggage.wxa.qb.e
        public boolean c(String str) {
            return i.this.f133643o.contains(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            i.this.c();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements com.tencent.luggage.wxa.lm.f {
        public c() {
        }

        @Override // com.tencent.luggage.wxa.lm.f
        public void a(String str) {
            m m3 = i.this.m(str);
            if (m3 != null) {
                i.this.b(str, m3);
                synchronized (i.this.f133644p) {
                    i.this.f133645q = false;
                }
                c0.b(i.this.P);
                com.tencent.luggage.wxa.p9.c cVar = new com.tencent.luggage.wxa.p9.c();
                c.a aVar = cVar.f137441d;
                aVar.f137442a = 11;
                aVar.f137445d = "real_play";
                aVar.f137444c = str;
                aVar.f137446e = i.this.k(str);
                cVar.a(Looper.getMainLooper());
                return;
            }
            w.b(i.W, "onStart player is null");
        }

        @Override // com.tencent.luggage.wxa.lm.f
        public void b(String str) {
            m m3 = i.this.m(str);
            if (m3 != null) {
                i.this.f(str, m3);
                i.this.c(str, m3);
                i.this.h();
                i.this.a(1800000);
                i.this.F(str);
                i.this.y(str);
                return;
            }
            w.b(i.W, "onStop player is null");
        }

        @Override // com.tencent.luggage.wxa.lm.f
        public void c(String str) {
            m m3 = i.this.m(str);
            if (m3 != null) {
                i.this.f(str, m3);
                i.this.c(str, m3);
                i.this.h();
                i.this.a(1800000);
                i.this.F(str);
                i.this.y(str);
                return;
            }
            w.b(i.W, "onComplete player is null");
        }

        @Override // com.tencent.luggage.wxa.lm.f
        public void d(String str) {
            m m3 = i.this.m(str);
            if (m3 != null) {
                i.this.f(str, m3);
                i.this.c(str, m3);
                i.this.h();
                i.this.a(1800000);
                return;
            }
            w.b(i.W, "onPause player is null");
        }

        @Override // com.tencent.luggage.wxa.lm.f
        public void e(String str) {
            m m3 = i.this.m(str);
            if (m3 != null) {
                i.this.f(str, m3);
                if (i.this.c(str, m3.E())) {
                    w.b(i.W, "try to stop same url players and play again");
                    i.this.w();
                    i.this.b(str, (com.tencent.luggage.wxa.qb.b) null);
                    return;
                } else {
                    w.b(i.W, "not try to play again");
                    i.this.c(str, m3);
                    i.this.h();
                    i.this.a(1800000);
                    return;
                }
            }
            w.b(i.W, "onError player is null");
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            w.d(i.W, "stopAudioDelayRunnable, run");
            Iterator it = i.this.f133634f.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (i.this.n(str) == 0) {
                    i.this.w(str);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            w.d(i.W, "releaseAudioDelayRunnable, run");
            Iterator it = i.this.f133634f.iterator();
            boolean z16 = false;
            while (it.hasNext()) {
                String str = (String) it.next();
                if (i.this.n(str) == 0) {
                    i.this.f(str);
                    z16 = true;
                }
            }
            if (!z16) {
                synchronized (i.this.f133644p) {
                    i.this.f133645q = true;
                }
                i.this.f133647s = System.currentTimeMillis();
                c0.a(i.this.P, 1800000L);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class f implements MessageQueue.IdleHandler {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f133660a;

        public f(String str) {
            this.f133660a = str;
        }

        /* JADX WARN: Removed duplicated region for block: B:33:0x01ef A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // android.os.MessageQueue.IdleHandler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean queueIdle() {
            int i3;
            com.tencent.luggage.wxa.qb.b bVar = (com.tencent.luggage.wxa.qb.b) i.this.f133637i.get(this.f133660a);
            boolean z16 = true;
            if (bVar == null) {
                w.d(i.W, "preloadMixCache param is null, audioId:%s", this.f133660a);
                synchronized (i.this.H) {
                    i.this.H.remove(this.f133660a);
                }
                i.this.d(this.f133660a);
                return false;
            }
            if (!TextUtils.isEmpty(bVar.f138566c) && !i.this.B.g(bVar.f138566c)) {
                long d16 = com.tencent.luggage.wxa.m9.a.d(bVar.f138566c);
                if (i.this.c(bVar)) {
                    d16 = bVar.C.limit();
                }
                w.d(i.W, "preloadMixCache preload filePath:%s, fileSize:%d, preloadMixCacheCount:%d", bVar.f138566c, Long.valueOf(d16), Long.valueOf(i.this.F));
                long f16 = i.this.B.f();
                boolean i16 = i.this.B.i();
                if (i.this.A.containsKey(bVar.f138566c)) {
                    i3 = ((Integer) i.this.A.get(bVar.f138566c)).intValue();
                } else {
                    i3 = 0;
                }
                if (i16) {
                    w.b(i.W, "loaded cache is exceed Max Memory 50M, don't load more audio into memory!");
                    if (i.this.f133649u != null) {
                        i.this.f133649u.e(713);
                    }
                    i.this.B.a("");
                } else if (f16 + d16 > 50000000) {
                    w.b(i.W, "loaded cache and loading fileSize is exceed Max Memory 50M, don't load more audio into memory!  loadCacheBufferSize:%d, fileSize:%d", Long.valueOf(f16), Long.valueOf(d16));
                    if (i.this.f133649u != null) {
                        i.this.f133649u.e(714);
                    }
                    i.this.B.a("");
                } else if (i3 < 30) {
                    com.tencent.luggage.wxa.j9.c unused = i.this.B;
                    if (!com.tencent.luggage.wxa.j9.c.q(bVar.f138566c) && !i.this.c(bVar)) {
                        w.b(i.W, "don't support load large file and invalid file");
                    } else if (i.this.c(bVar) && com.tencent.luggage.wxa.m9.a.a(bVar.C.limit())) {
                        w.b(i.W, "don't support load pByteBuff large file");
                    } else {
                        if (!i.this.B.h(bVar.f138566c)) {
                            bVar.B = true;
                            bVar.f138587x = d16;
                            i.this.B.b(bVar);
                            i.g(i.this);
                            synchronized (i.this.H) {
                                i.this.H.remove(this.f133660a);
                            }
                            if (!z16) {
                                i.this.d(this.f133660a);
                            }
                            return false;
                        }
                        w.d(i.W, "mix audio cache is loading");
                    }
                } else {
                    w.b(i.W, "load audio fail number exceed MAX_LOAD_FAIL_COUNT, don't load again!");
                }
            } else if (!TextUtils.isEmpty(bVar.f138566c)) {
                bVar.B = false;
                if (!i.this.B.i(this.f133660a)) {
                    i.this.B.c(bVar);
                }
                if (i.this.c(bVar)) {
                    bVar.f138587x = bVar.C.limit();
                } else {
                    bVar.f138587x = com.tencent.luggage.wxa.m9.a.d(bVar.f138566c);
                }
            } else {
                bVar.B = false;
            }
            z16 = false;
            synchronized (i.this.H) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class g implements com.tencent.luggage.wxa.j9.b {
        public g() {
        }

        @Override // com.tencent.luggage.wxa.j9.b
        public void a(com.tencent.luggage.wxa.p9.c cVar) {
            i.this.d(cVar.f137441d.f137444c);
        }

        @Override // com.tencent.luggage.wxa.j9.b
        public void b(com.tencent.luggage.wxa.p9.c cVar) {
            cVar.a(Looper.getMainLooper());
        }

        @Override // com.tencent.luggage.wxa.j9.b
        public void c(com.tencent.luggage.wxa.p9.c cVar) {
            cVar.a(Looper.getMainLooper());
        }

        @Override // com.tencent.luggage.wxa.j9.b
        public void d(com.tencent.luggage.wxa.p9.c cVar) {
            if (!i.this.f133639k.contains(cVar.f137441d.f137444c)) {
                cVar.a(Looper.getMainLooper());
            }
            i.this.f133639k.remove(cVar.f137441d.f137444c);
        }

        @Override // com.tencent.luggage.wxa.j9.b
        public void e(com.tencent.luggage.wxa.p9.c cVar) {
            if (i.this.f133649u != null) {
                com.tencent.luggage.wxa.qb.b bVar = (com.tencent.luggage.wxa.qb.b) i.this.f133637i.get(cVar.f137441d.f137444c);
                if (bVar == null) {
                    return;
                }
                long j3 = bVar.f138580q;
                if (j3 > 1000000) {
                    w.b(i.W, "onRealPlay: %s, invokeCallTime:%d", bVar.f138564a, Long.valueOf(j3));
                }
                String str = cVar.f137441d.f137449h;
                if (TextUtils.isEmpty(str)) {
                    str = bVar.f138565b;
                }
                i.this.f133649u.a(bVar.f138564a, str, System.currentTimeMillis() - bVar.f138578o, bVar.f138579p, bVar.f138580q, false, bVar.f138566c, i.this.B.d(bVar.f138564a), bVar.f138587x, i.this.B.c(bVar.f138566c));
                if (i.this.A.containsKey(bVar.f138566c)) {
                    i.this.A.remove(bVar.f138566c);
                }
            }
            cVar.a(Looper.getMainLooper());
        }

        @Override // com.tencent.luggage.wxa.j9.b
        public void f(com.tencent.luggage.wxa.p9.c cVar) {
            cVar.a(Looper.getMainLooper());
        }

        @Override // com.tencent.luggage.wxa.j9.b
        public void g(com.tencent.luggage.wxa.p9.c cVar) {
            cVar.a(Looper.getMainLooper());
        }

        @Override // com.tencent.luggage.wxa.j9.b
        public void h(com.tencent.luggage.wxa.p9.c cVar) {
            cVar.a(Looper.getMainLooper());
        }

        @Override // com.tencent.luggage.wxa.j9.b
        public void i(com.tencent.luggage.wxa.p9.c cVar) {
            cVar.a(Looper.getMainLooper());
            i.this.d(cVar.f137441d.f137444c);
        }

        @Override // com.tencent.luggage.wxa.j9.b
        public void j(com.tencent.luggage.wxa.p9.c cVar) {
            int i3 = cVar.f137441d.f137447f;
            w.d(i.W, "onError errCode:%d", Integer.valueOf(i3));
            if (i3 != 709 && i3 != 702 && i3 != 703 && i3 != 705 && i3 != 706) {
                cVar.a(Looper.getMainLooper());
            } else {
                w.b(i.W, "decode mix cache errors, don't callback to JS");
            }
            if (i.this.f133649u != null) {
                com.tencent.luggage.wxa.qb.b bVar = (com.tencent.luggage.wxa.qb.b) i.this.f133637i.get(cVar.f137441d.f137444c);
                if (bVar == null) {
                    return;
                }
                i.this.f133649u.a(bVar.f138572i, cVar.f137441d.f137447f);
                if (!i.this.B.g(bVar.f138566c)) {
                    if (i.this.A.containsKey(bVar.f138566c)) {
                        i.this.A.put(bVar.f138566c, Integer.valueOf(((Integer) i.this.A.get(bVar.f138566c)).intValue() + 1));
                    } else {
                        i.this.A.put(bVar.f138566c, 1);
                    }
                }
            }
            i.this.d(cVar.f137441d.f137444c);
        }

        @Override // com.tencent.luggage.wxa.j9.b
        public void k(com.tencent.luggage.wxa.p9.c cVar) {
            cVar.a(Looper.getMainLooper());
        }

        public void m(com.tencent.luggage.wxa.p9.c cVar) {
            cVar.a(Looper.getMainLooper());
        }

        @Override // com.tencent.luggage.wxa.j9.b
        public void a(com.tencent.luggage.wxa.c9.c cVar) {
            if (i.this.L != null) {
                i.this.L.a(i.this.M, 1, cVar.f123415b, cVar.f123414a, cVar.f123417d);
            }
            com.tencent.luggage.wxa.d9.c.a().a(cVar);
        }

        @Override // com.tencent.luggage.wxa.j9.b
        public void l(com.tencent.luggage.wxa.p9.c cVar) {
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.lm.i$i, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6448i implements com.tencent.luggage.wxa.h9.f {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.lm.i$i$a */
        /* loaded from: classes8.dex */
        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.tencent.luggage.wxa.qb.b f133665a;

            public a(com.tencent.luggage.wxa.qb.b bVar) {
                this.f133665a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                i.this.F(this.f133665a.f138564a);
                i.this.h(this.f133665a);
                i.this.y(this.f133665a.f138564a);
            }
        }

        public C6448i() {
        }

        @Override // com.tencent.luggage.wxa.h9.f
        public void a(com.tencent.luggage.wxa.qb.b bVar) {
            boolean z16;
            w.d(i.W, "loadCache audio:%s", bVar.f138564a);
            com.tencent.luggage.wxa.qb.b l3 = i.this.l(bVar.f138564a);
            if (l3 != null && !TextUtils.isEmpty(l3.f138566c) && i.this.B.g(l3.f138566c)) {
                z16 = true;
            } else {
                z16 = false;
            }
            w.d(i.W, "cached:%b", Boolean.valueOf(z16));
            if (!z16 && i.this.J != null) {
                i.this.J.post(new a(bVar));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class j implements i0.b {
        public j() {
        }

        @Override // com.tencent.luggage.wxa.tn.i0.b
        public void a(int i3) {
            w.d(i.W, "onPhoneCall state:%d", Integer.valueOf(i3));
            synchronized (i.this.f133653y) {
                Iterator it = i.this.f133653y.iterator();
                while (it.hasNext()) {
                    ((com.tencent.luggage.wxa.lm.k) it.next()).a(i3);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class k implements Comparator<com.tencent.luggage.wxa.qb.b> {
        public k() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(com.tencent.luggage.wxa.qb.b bVar, com.tencent.luggage.wxa.qb.b bVar2) {
            long j3 = bVar.f138573j;
            long j16 = bVar2.f138573j;
            if (j3 > j16) {
                return 1;
            }
            if (j3 < j16) {
                return -1;
            }
            return 0;
        }
    }

    i() {
        d();
        com.tencent.luggage.wxa.j9.c cVar = new com.tencent.luggage.wxa.j9.c(false);
        this.B = cVar;
        cVar.a(this.Q);
        this.B.a(this.R);
        com.tencent.luggage.wxa.lm.c cVar2 = new com.tencent.luggage.wxa.lm.c();
        this.I = cVar2;
        cVar2.a(this.S);
    }

    private void A(String str) {
        w.d(W, "recycleStoppedPlayerByAppId");
        h(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(String str) {
        com.tencent.luggage.wxa.qb.b bVar = this.f133637i.get(str);
        if (bVar != null && !TextUtils.isEmpty(bVar.f138565b)) {
            if ((!bVar.f138565b.startsWith("http://") && !bVar.f138565b.startsWith("https://")) || !com.tencent.luggage.wxa.om.i.a(bVar.f138565b)) {
                return;
            }
            bVar.f138566c = com.tencent.luggage.wxa.wm.b.c(bVar.f138565b);
            if (!this.f133654z.containsKey(bVar.f138565b)) {
                this.f133654z.put(bVar.f138565b, bVar.f138566c);
            }
        }
    }

    public static /* synthetic */ long g(i iVar) {
        long j3 = iVar.F;
        iVar.F = 1 + j3;
        return j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ AudioManager s() {
        return (AudioManager) z.c().getSystemService("audio");
    }

    private void t() {
        w.d(W, "recycleStopPlayer");
        synchronized (this.f133644p) {
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(this.f133633e);
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                m remove = this.f133632d.remove(str);
                this.f133633e.remove(str);
                if (remove != null) {
                    if (remove.p()) {
                        f(str, remove);
                        e(str, remove);
                    } else if (!remove.O()) {
                        f(str, remove);
                        a(str, remove);
                    }
                }
            }
        }
    }

    private void z(String str) {
        w.d(W, "recyclePlayer");
        int size = this.f133630b.size();
        int size2 = this.f133632d.size();
        int l3 = l();
        if (size > 0 || size2 > 0 || l3 > 0) {
            w.d(W, "start_player_count:%d, recycled_player_count:%d, paused_player_count:%d", Integer.valueOf(size), Integer.valueOf(size2), Integer.valueOf(l3));
        }
        if (size >= 10) {
            u();
        } else if (l3 >= 6) {
            u();
        } else if (size + l3 >= 8) {
            u();
        }
        String k3 = k(str);
        int size3 = this.f133630b.size();
        int size4 = this.f133632d.size();
        if (size3 > 0 || size4 > 0) {
            w.d(W, "start_player_count:%d, recycled_player_count:%d", Integer.valueOf(size3), Integer.valueOf(size4));
        }
        if (size4 >= 50) {
            Iterator<String> it = this.f133634f.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next != null && !next.equalsIgnoreCase(k3)) {
                    A(next);
                }
            }
        } else if (size4 + size3 >= 50) {
            Iterator<String> it5 = this.f133634f.iterator();
            while (it5.hasNext()) {
                String next2 = it5.next();
                if (next2 != null && !next2.equalsIgnoreCase(k3)) {
                    A(next2);
                }
            }
        } else {
            w.d(W, "condition is not satisfy to do recycleStopPlayerByAppId");
        }
        int size5 = this.f133632d.size();
        if (size3 > 0 || size5 > 0) {
            w.d(W, "start_player_count:%d, recycled_player_count:%d", Integer.valueOf(size3), Integer.valueOf(size5));
        }
        if (size5 >= 50) {
            t();
        } else if (size3 + size5 >= 50) {
            t();
        } else {
            w.d(W, "condition is not satisfy to do recycleAllStopPlayer");
        }
    }

    public boolean C(String str) {
        return b(str, (com.tencent.luggage.wxa.qb.b) null);
    }

    public boolean D(String str) {
        m m3 = m(str);
        if (m3 == null) {
            w.b(W, "stopAudio, player is null");
            if (!this.B.i(str)) {
                return false;
            }
            this.B.v(str);
            return true;
        }
        w.d(W, "stopAudio, audioId:%s", str);
        m3.f();
        com.tencent.luggage.wxa.qb.b bVar = this.f133637i.get(str);
        if (bVar != null) {
            bVar.f138567d = 0;
            bVar.f138570g = true;
        }
        f(str, m3);
        c(str, m3);
        return true;
    }

    public boolean E(String str) {
        if (this.B.i(str)) {
            this.B.v(str);
        }
        m m3 = m(str);
        if (m3 == null) {
            w.b(W, "stopPlayOnBackGround, player is null");
            return false;
        }
        w.d(W, "stopPlayOnBackGround, audioId:%s", str);
        m3.B();
        com.tencent.luggage.wxa.qb.b bVar = this.f133637i.get(str);
        if (bVar != null) {
            bVar.f138567d = 0;
            bVar.f138570g = true;
        }
        f(str, m3);
        c(str, m3);
        return true;
    }

    public boolean u(String str) {
        m m3 = m(str);
        if (m3 == null) {
            if (this.B.i(str)) {
                return this.B.o(str);
            }
            w.b(W, "isStartPlayAudio, player is null");
            return false;
        }
        return m3.c();
    }

    public void v() {
        w.d(W, "release, clear all cache");
        d();
        e();
        this.B.m();
        this.B.l();
        this.B.a();
        this.B.a((com.tencent.luggage.wxa.j9.b) null);
        this.B.a((com.tencent.luggage.wxa.j9.g) null);
        this.I.a((com.tencent.luggage.wxa.h9.f) null);
        this.I.c();
        this.I.b();
        c();
    }

    public void w(String str) {
        w.d(W, "pauseAllAudioPlayers, appId:%s", str);
        this.B.k();
        com.tencent.luggage.wxa.zp.h.f146825d.execute(new b());
        e();
        LinkedList<String> linkedList = this.f133636h.get(str);
        long g16 = this.B.g();
        long f16 = this.B.f();
        long h16 = this.B.h();
        long j3 = f16 + h16;
        w.d(W, "mixAverageTime:%d, loadedCacheBufferSize:%d, remainingBufferSize:%d", Long.valueOf(g16), Long.valueOf(f16), Long.valueOf(h16));
        this.f133649u = (com.tencent.luggage.wxa.mm.a) com.tencent.luggage.wxa.tm.b.a(com.tencent.luggage.wxa.mm.a.class);
        if (linkedList != null && linkedList.size() != 0) {
            if (this.f133630b.isEmpty() && this.f133632d.isEmpty()) {
                w.b(W, "there is no audioIds and players for this appId to pause");
                com.tencent.luggage.wxa.mm.a aVar = this.f133649u;
                if (aVar != null) {
                    aVar.a(str, g16, j3, f16);
                    return;
                }
                return;
            }
            LinkedList linkedList2 = new LinkedList();
            synchronized (this.f133644p) {
                linkedList2.addAll(linkedList);
            }
            Iterator it = linkedList2.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                m mVar = this.f133632d.get(str2);
                if (mVar != null) {
                    d(str2, mVar);
                }
            }
            w.d(W, "playing player count:%d", Integer.valueOf(this.f133630b.size()));
            Iterator it5 = linkedList2.iterator();
            while (it5.hasNext()) {
                String str3 = (String) it5.next();
                m mVar2 = this.f133630b.get(str3);
                if (mVar2 != null) {
                    d(str3, mVar2);
                    c(str3, mVar2);
                }
            }
            com.tencent.luggage.wxa.mm.a aVar2 = this.f133649u;
            if (aVar2 != null) {
                aVar2.a(str, g16, j3, f16);
                return;
            }
            return;
        }
        w.b(W, "there is no audioIds and players for this appId to pause");
    }

    public void x() {
        this.B.e();
        this.L = null;
        for (m mVar : this.f133630b.values()) {
            if (mVar != null) {
                mVar.a((com.tencent.luggage.wxa.lm.a) null);
            }
        }
    }

    public void y(String str) {
        if (q()) {
            com.tencent.luggage.wxa.qb.b bVar = this.f133637i.get(str);
            if (bVar != null && !TextUtils.isEmpty(bVar.f138566c) && this.B.g(bVar.f138566c)) {
                w.d(W, "preloadMixCache cache done!");
                return;
            }
            synchronized (this.H) {
                if (!this.H.contains(str)) {
                    this.H.add(str);
                }
            }
            if (this.K != null && Looper.myQueue() != null) {
                Looper.myQueue().addIdleHandler(new f(str));
            } else {
                w.d(W, "Looper.myQueue() is null!");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class h implements com.tencent.luggage.wxa.j9.g {
        public h() {
        }

        @Override // com.tencent.luggage.wxa.j9.g
        public void a(int i3) {
            if (i.this.f133649u != null) {
                i.this.f133649u.b(i3);
            }
        }

        public void a(int i3, int i16) {
            if (i.this.f133649u != null) {
                i.this.f133649u.a(i3, i16);
            }
        }
    }

    private void g(com.tencent.luggage.wxa.qb.b bVar) {
        if (this.B.i(bVar.f138564a)) {
            this.B.d(bVar);
        } else {
            this.B.c(bVar);
        }
        if (c(bVar) || !TextUtils.isEmpty(bVar.f138566c)) {
            y(bVar.f138564a);
        }
    }

    private m i() {
        w.d(W, "createOrReusePlayer");
        synchronized (this.f133644p) {
            if (this.f133632d.size() == 0) {
                return new m();
            }
            String str = "";
            long currentTimeMillis = System.currentTimeMillis();
            Iterator<String> it = this.f133633e.iterator();
            m mVar = null;
            long j3 = 0;
            while (it.hasNext()) {
                String next = it.next();
                m mVar2 = this.f133632d.get(next);
                if (mVar2 != null && (mVar2.p() || mVar2.L() || mVar2.R() || mVar2.M())) {
                    if (j3 == 0 || mVar2.F() < j3) {
                        j3 = mVar2.F();
                        str = next;
                        mVar = mVar2;
                    }
                }
            }
            if (mVar != null && currentTimeMillis - j3 > 500) {
                w.d(W, "player is be reuse to play again with other audio");
                g(str, mVar);
                return mVar;
            }
            return new m();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String k(String str) {
        Iterator<String> it = this.f133634f.iterator();
        while (it.hasNext()) {
            String next = it.next();
            LinkedList<String> linkedList = this.f133636h.get(next);
            if (linkedList != null && linkedList.contains(str)) {
                return next;
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public m m(String str) {
        if (this.f133630b.containsKey(str)) {
            return this.f133630b.get(str);
        }
        if (this.f133632d.containsKey(str)) {
            return this.f133632d.get(str);
        }
        return null;
    }

    public static synchronized void n() {
        synchronized (i.class) {
            if (f133628d0 != null) {
                return;
            }
            f133628d0 = new i();
        }
    }

    public static i o() {
        if (f133628d0 == null) {
            f133628d0 = new i();
        }
        return f133628d0;
    }

    public void B(String str) {
        this.f133639k.remove(str);
    }

    public boolean e(com.tencent.luggage.wxa.qb.b bVar) {
        if (bVar == null) {
            w.b(W, "setAudioParam param == null");
            return false;
        }
        com.tencent.luggage.wxa.qb.b bVar2 = this.f133637i.get(bVar.f138564a);
        if (bVar2 != null) {
            bVar2.b(bVar);
        } else {
            this.f133637i.put(bVar.f138564a, bVar);
            bVar2 = bVar;
        }
        m m3 = m(bVar.f138564a);
        if (m3 != null) {
            w.d(W, "setAudioParam player ok");
            m3.c(bVar2);
        } else {
            w.b(W, "setAudioParam player is null");
        }
        if (!q()) {
            return true;
        }
        if (this.B.i(bVar.f138564a)) {
            this.B.d(bVar);
            return true;
        }
        this.B.c(bVar);
        return true;
    }

    public boolean f(com.tencent.luggage.wxa.qb.b bVar) {
        if (bVar == null) {
            w.b(W, "startAudio, play param is null");
            a(605, "");
            return false;
        }
        if (TextUtils.isEmpty(bVar.f138564a)) {
            w.b(W, "startAudio fail, the audioId is empty!");
            a(604, bVar.f138564a);
            return false;
        }
        if (!this.f133629a.contains(bVar.f138564a)) {
            w.b(W, "startAudio fail, the audioId is not found!");
            a(601, bVar.f138564a);
            return false;
        }
        if (bVar.f138570g) {
            d(bVar);
        }
        w.d(W, "startAudio");
        f();
        String k3 = k(bVar.f138564a);
        com.tencent.luggage.wxa.qb.b l3 = l(bVar.f138564a);
        int n3 = n(k3);
        if (n3 >= 10) {
            w.b(W, "startAudio now created QQAudioPlayer count %d arrive MAX_PLAY_AUDIO_PLAYER_COUNT, but save param!", Integer.valueOf(n3));
            this.f133637i.put(bVar.f138564a, bVar);
            w.d(W, "autoPlay:%b", Boolean.valueOf(bVar.f138570g));
            a(bVar);
            if (bVar.f138570g && a(bVar.f138564a)) {
                w();
            } else {
                if (bVar.f138570g) {
                    a(600, bVar.f138564a);
                    z();
                    return false;
                }
                w.b(W, "save param, do nothing ");
                m m3 = m(bVar.f138564a);
                if (m3 != null) {
                    m3.c(bVar);
                    m3.t();
                    if (!this.f133639k.contains(bVar.f138564a)) {
                        this.f133639k.add(bVar.f138564a);
                    }
                }
                return true;
            }
        }
        z(bVar.f138564a);
        g();
        c(k3);
        a();
        this.f133635g.put(k3, bVar.f138574k);
        this.f133637i.put(bVar.f138564a, bVar);
        h(bVar);
        m m16 = m(bVar.f138564a);
        boolean q16 = q();
        if (q16) {
            boolean a16 = a(m16);
            boolean z16 = (!TextUtils.isEmpty(bVar.f138566c) && this.B.g(bVar.f138566c)) || (l3 != null && bVar.a(l3) && !TextUtils.isEmpty(l3.f138566c) && this.B.g(l3.f138566c));
            w.d(W, "canUseMixPlayer:%b, localCacheExit:%b, audioId:%s", Boolean.valueOf(a16), Boolean.valueOf(z16), bVar.f138564a);
            if (a16 && z16) {
                a(bVar, l3);
                return true;
            }
        } else {
            w.d(W, "not support mix audio");
        }
        b(bVar, l3);
        if (q16) {
            this.K = Looper.myLooper();
            g(bVar);
        }
        a(bVar);
        return true;
    }

    public void h(String str) {
        w.d(W, "destroyAllStoppedAudioPlayersAndSaveStateByAppId, appId:%s", str);
        c(str);
        c();
        synchronized (this.f133644p) {
            LinkedList<String> linkedList = this.f133636h.get(str);
            if (linkedList != null && linkedList.size() != 0) {
                Iterator<String> it = linkedList.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (this.B.i(next)) {
                        this.B.v(next);
                    }
                    m remove = this.f133632d.remove(next);
                    this.f133633e.remove(next);
                    if (remove != null) {
                        f(next, remove);
                        w.d(W, "destroy recycled player");
                        if (remove.p()) {
                            e(next, remove);
                        } else {
                            a(next, remove);
                        }
                    }
                }
                return;
            }
            w.b(W, "there is no audioIds and players for this appId to stop");
        }
    }

    public com.tencent.luggage.wxa.qb.a j() {
        return this.f133650v;
    }

    public com.tencent.luggage.wxa.qb.b l(String str) {
        if (this.f133637i.containsKey(str)) {
            return this.f133637i.get(str);
        }
        return null;
    }

    public boolean p(String str) {
        m m3 = m(str);
        if (m3 == null) {
            if (this.B.i(str)) {
                return this.B.j(str);
            }
            w.b(W, "isPauseOnBackground, player is null");
            com.tencent.luggage.wxa.qb.d o16 = o(str);
            if (o16 != null) {
                return o16.f138593d;
            }
            return false;
        }
        return m3.p();
    }

    public boolean q(String str) {
        m m3 = m(str);
        if (m3 == null) {
            w.b(W, "isPausedPlayer, player is null");
            com.tencent.luggage.wxa.qb.d o16 = o(str);
            if (o16 != null) {
                return o16.f138592c;
            }
            return false;
        }
        return m3.O();
    }

    public boolean r(String str) {
        return this.f133634f.contains(str);
    }

    public boolean s(String str) {
        m m3 = m(str);
        if (m3 == null) {
            if (this.B.i(str)) {
                return this.B.l(str);
            }
            w.b(W, "isPlayingAudio, player is null");
            return false;
        }
        return m3.i();
    }

    private boolean r() {
        com.tencent.luggage.wxa.qb.a aVar = this.f133650v;
        return aVar.f138562b || aVar.f138561a;
    }

    public void A() {
        if (p()) {
            return;
        }
        w.d(W, "requestFocus focus:%b", Boolean.valueOf(this.f133651w.d()));
    }

    public void d() {
        w.d(W, "_release");
        this.f133629a.clear();
        synchronized (this.f133644p) {
            Iterator<String> it = this.f133631c.iterator();
            while (it.hasNext()) {
                String next = it.next();
                a(next, this.f133630b.remove(next));
            }
            this.f133631c.clear();
            this.f133630b.clear();
            Iterator<String> it5 = this.f133633e.iterator();
            while (it5.hasNext()) {
                String next2 = it5.next();
                a(next2, this.f133632d.remove(next2));
            }
            this.f133633e.clear();
            this.f133632d.clear();
            Iterator<String> it6 = this.f133634f.iterator();
            while (it6.hasNext()) {
                LinkedList<String> remove = this.f133636h.remove(it6.next());
                if (remove != null) {
                    remove.clear();
                }
            }
        }
        this.f133634f.clear();
        this.f133635g.clear();
        this.f133636h.clear();
        this.f133637i.clear();
        this.f133638j.clear();
        this.f133641m.clear();
        this.f133642n.clear();
        this.f133639k.clear();
        c0.b(this.O);
        c0.b(this.P);
        this.f133645q = false;
        this.f133646r = false;
        y();
        this.L = null;
    }

    public boolean j(String str) {
        boolean contains;
        synchronized (this.H) {
            contains = this.H.contains(str);
        }
        if (!contains) {
            com.tencent.luggage.wxa.qb.b bVar = this.f133637i.get(str);
            contains = bVar != null && this.B.h(bVar.f138566c);
        }
        if (!contains) {
            if (this.B.i(str) && (this.B.k(str) || this.B.l(str) || this.B.m(str) || this.B.n(str) || this.B.o(str))) {
                this.B.v(str);
            }
            this.B.t(str);
        }
        w.d(W, "destroyAudio, audioId:%s", str);
        m m3 = m(str);
        if (m3 != null) {
            a(str, m3);
            synchronized (this.f133644p) {
                this.f133630b.remove(str);
                this.f133631c.remove(str);
                this.f133632d.remove(str);
                this.f133633e.remove(str);
            }
        } else {
            w.b(W, "destroyAudio, player is null");
        }
        this.f133629a.remove(str);
        synchronized (this.f133644p) {
            Iterator<String> it = this.f133634f.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                LinkedList<String> linkedList = this.f133636h.get(next);
                if (linkedList != null && linkedList.contains(str)) {
                    linkedList.remove(str);
                    if (linkedList.size() == 0) {
                        this.f133636h.remove(next);
                        this.f133634f.remove(next);
                        this.f133635g.remove(next);
                    }
                }
            }
        }
        this.f133638j.remove(str);
        if (!contains) {
            this.f133637i.remove(str);
        } else if (!this.G.contains(str)) {
            this.G.add(str);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, m mVar) {
        w.d(W, "markPlayerRecycled, mark player recycled by audioId:%s", str);
        synchronized (this.f133644p) {
            if (this.f133631c.contains(str)) {
                this.f133630b.remove(str);
                this.f133631c.remove(str);
            }
            if (!this.f133633e.contains(str)) {
                this.f133633e.add(str);
                this.f133632d.put(str, mVar);
            }
        }
    }

    private int l() {
        int i3;
        synchronized (this.f133644p) {
            Iterator<String> it = this.f133633e.iterator();
            i3 = 0;
            while (it.hasNext()) {
                if (q(it.next())) {
                    i3++;
                }
            }
        }
        return i3;
    }

    public int n(String str) {
        int size;
        int l3 = l();
        synchronized (this.f133644p) {
            int size2 = this.f133629a.size();
            size = this.f133630b.size();
            int size3 = this.f133632d.size();
            LinkedList<String> linkedList = this.f133636h.get(str);
            w.d(W, "getAudioPlayerCount, count:%d, player_count:%d, recycled_player_count:%d, audioIdsCount:%d, pause_count:%d", Integer.valueOf(size2), Integer.valueOf(size), Integer.valueOf(size3), Integer.valueOf(linkedList == null ? 0 : linkedList.size()), Integer.valueOf(l3));
        }
        return size;
    }

    private void b(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        w.d(W, "saveCreateId, appId:%s, audioId:%s", str, str2);
        if (!this.f133634f.contains(str)) {
            this.f133634f.add(str);
        }
        if (!this.f133629a.contains(str2)) {
            this.f133629a.add(str2);
        }
        synchronized (this.f133644p) {
            LinkedList<String> linkedList = this.f133636h.get(str);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
            }
            if (!linkedList.contains(str2)) {
                linkedList.add(str2);
            }
            this.f133636h.put(str, linkedList);
        }
    }

    public com.tencent.luggage.wxa.qb.e k() {
        return this.V;
    }

    public com.tencent.luggage.wxa.qb.d o(String str) {
        com.tencent.luggage.wxa.qb.d e16;
        m m3 = m(str);
        if (m3 != null) {
            return m3.o();
        }
        return (!this.B.i(str) || (e16 = this.B.e(str)) == null) ? this.f133638j.get(str) : e16;
    }

    public boolean x(String str) {
        m m3 = m(str);
        if (m3 == null) {
            w.b(W, "pauseAudio, player is null");
            if (!this.B.i(str)) {
                return false;
            }
            this.B.r(str);
            return true;
        }
        w.d(W, "pauseAudio, audioId:%s", str);
        m3.pause();
        f(str, m3);
        c(str, m3);
        return true;
    }

    private int m() {
        return com.tencent.luggage.wxa.om.g.a(3);
    }

    private void u() {
        w.d(W, "recyclePausedPlayer");
        synchronized (this.f133644p) {
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(this.f133633e);
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                m mVar = this.f133632d.get(str);
                if (mVar != null && mVar.O()) {
                    d(str, mVar);
                }
            }
        }
    }

    private void g(String str, m mVar) {
        w.d(W, "unmarkPlayer, unmark player by audioId:%s", str);
        synchronized (this.f133644p) {
            if (this.f133633e.contains(str)) {
                this.f133632d.remove(str);
                this.f133633e.remove(str);
            }
            if (this.f133631c.contains(str)) {
                this.f133631c.remove(str);
                this.f133630b.remove(str);
            }
        }
    }

    private boolean q() {
        return com.tencent.luggage.wxa.lm.e.a() && r();
    }

    public void a(@NonNull com.tencent.luggage.wxa.lm.a aVar) {
        this.L = aVar;
        a.c cVar = new a.c(1, "0");
        aVar.c(cVar);
        this.M = cVar;
        this.B.j();
        synchronized (this.f133644p) {
            for (m mVar : this.f133630b.values()) {
                if (mVar != null) {
                    mVar.a(aVar);
                }
            }
        }
    }

    private boolean p() {
        return this.f133651w.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(String str, int i3) {
        int intValue = this.f133641m.containsKey(str) ? this.f133641m.get(str).intValue() : 0;
        if (intValue >= 1) {
            w.b(W, "try it one time, don't try again");
            this.f133641m.remove(str);
            return false;
        }
        if (66 != i3) {
            this.f133641m.remove(str);
            return false;
        }
        if (!b(str)) {
            return false;
        }
        this.f133641m.put(str, Integer.valueOf(intValue + 1));
        return true;
    }

    public boolean v(String str) {
        m m3 = m(str);
        if (m3 == null) {
            if (this.B.i(str)) {
                return this.B.p(str);
            }
            w.b(W, "isStoppedAudio, player is null");
            return true;
        }
        return m3.R();
    }

    public void y() {
        synchronized (this.f133652x) {
            i0.b bVar = this.f133652x[0];
            if (bVar != null) {
                ((i0) com.tencent.luggage.wxa.eo.g.a(i0.class)).b(bVar);
                this.f133652x[0] = null;
            }
        }
        w.d(W, "removePhoneStatusWatcher");
    }

    public void e(String str) {
        w.d(W, "destroyAllAudioPlayers, appId:%s", str);
        e();
        c(str);
        c();
        synchronized (this.f133644p) {
            LinkedList<String> remove = this.f133636h.remove(str);
            if (remove != null && remove.size() != 0) {
                Iterator<String> it = remove.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    m remove2 = this.f133630b.remove(next);
                    this.f133631c.remove(next);
                    w.d(W, "destroy playing player");
                    a(next, remove2);
                    this.f133637i.remove(next);
                    this.f133638j.remove(next);
                    if (this.B.i(next)) {
                        this.B.v(next);
                        this.B.t(next);
                    }
                }
                Iterator<String> it5 = remove.iterator();
                while (it5.hasNext()) {
                    String next2 = it5.next();
                    m remove3 = this.f133632d.remove(next2);
                    this.f133633e.remove(next2);
                    w.d(W, "destroy recycled player");
                    a(next2, remove3);
                    this.f133637i.remove(next2);
                    this.f133638j.remove(next2);
                    if (this.B.i(next2)) {
                        this.B.v(next2);
                        this.B.t(next2);
                    }
                }
                this.f133629a.removeAll(remove);
                this.f133634f.remove(str);
                this.f133635g.remove(str);
                this.B.c();
                this.B.b();
                this.f133654z.clear();
                this.A.clear();
                return;
            }
            w.b(W, "there is no audioIds and players for this appId to stop");
        }
    }

    public boolean t(String str) {
        return this.f133639k.contains(str);
    }

    public void g(String str) {
        if (this.f133634f.size() == 0) {
            return;
        }
        w.d(W, "destroyAllAudioPlayersByProcessName with name :%s", str);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f133634f);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            String str3 = this.f133635g.get(str2);
            if (str != null && str.equalsIgnoreCase(str3)) {
                w.d(W, "The app brand process name is same as the process which is killed by system");
                e(str2);
            }
        }
    }

    private void a(String str, com.tencent.luggage.wxa.qb.b bVar) {
        if (bVar == null) {
            w.b(W, "restorePlayerParam param == null, audioId:%s", str);
            return;
        }
        w.d(W, "restorePlayerParam audioId:%s", str);
        this.f133635g.put(bVar.f138577n, bVar.f138574k);
        this.f133637i.put(bVar.f138564a, bVar);
        b(bVar.f138577n, str);
        this.f133641m.remove(str);
    }

    private void b(com.tencent.luggage.wxa.qb.b bVar, com.tencent.luggage.wxa.qb.b bVar2) {
        boolean contains;
        w.d(W, "startAudioByQQAudioPlayer");
        m m3 = m(bVar.f138564a);
        if (m3 == null) {
            w.b(W, "startAudio, player is null, create new QQAudioPlayer with audioId:%s", bVar.f138564a);
            m i3 = i();
            i3.a(this.N);
            i3.a(this.L);
            i3.a(bVar.f138564a);
            i3.c(bVar);
            if (bVar.f138570g) {
                a(bVar, true, true);
                b(bVar.f138564a, i3);
                bVar.f138573j = System.currentTimeMillis();
                i3.a(bVar);
                return;
            }
            c(bVar.f138564a, i3);
            i3.t();
            if (!this.f133639k.contains(bVar.f138564a)) {
                this.f133639k.add(bVar.f138564a);
            }
            w.b(W, "new player autoplay false, not to play ");
            return;
        }
        w.d(W, "startAudio, audioId:%s", bVar.f138564a);
        if (bVar.f138570g) {
            b(bVar.f138564a, m3);
            bVar.f138573j = System.currentTimeMillis();
            m3.c(bVar);
            if (bVar2 != null && !bVar2.a(bVar)) {
                w.d(W, "param src change, do stop now and play new");
                if (m3.i() || m3.c() || m3.Q() || m3.P() || m3.O()) {
                    m3.f();
                }
                a(bVar, true, true);
                m3.a(bVar);
                return;
            }
            if (m3.i()) {
                w.d(W, "is playing, do nothing");
                return;
            }
            if (m3.c() && m3.O()) {
                a(bVar, true, true);
                w.d(W, "is paused, do resume");
                m3.a();
                return;
            } else if (m3.P()) {
                a(bVar, true, true);
                w.d(W, "is isPrepared, do resume");
                m3.a();
                return;
            } else {
                if (m3.Q()) {
                    w.d(W, "is isPreparing, do nothing");
                    return;
                }
                a(bVar, true, true);
                w.d(W, "is end or stop, do startPlay");
                m3.a(bVar);
                return;
            }
        }
        synchronized (this.f133644p) {
            contains = this.f133631c.contains(bVar.f138564a);
        }
        if (!contains) {
            w.d(W, "mark player recycle");
            c(bVar.f138564a, m3);
        } else {
            w.d(W, "don't mark player, is playing");
        }
        m3.c(bVar);
        if (bVar2 != null && !bVar2.a(bVar)) {
            w.d(W, "param src change, do stop now");
            if (m3.i() || m3.c() || m3.Q() || m3.P() || m3.O()) {
                m3.f();
            }
        }
        m3.t();
        if (!this.f133639k.contains(bVar.f138564a)) {
            this.f133639k.add(bVar.f138564a);
        }
        w.b(W, "autoplay false, not to play ");
    }

    private boolean i(String str) {
        m m3 = m(str);
        if (m3 == null) {
            return false;
        }
        w.d(W, "destroyAndRemovePlayer, audioId:%s", str);
        a(str, m3);
        synchronized (this.f133644p) {
            this.f133630b.remove(str);
            this.f133631c.remove(str);
            this.f133632d.remove(str);
            this.f133633e.remove(str);
        }
        return true;
    }

    private void c(String str) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.f133650v.f138563c) && !str.equalsIgnoreCase(this.f133650v.f138563c)) {
            this.f133650v.a();
            w.d(W, "reset AudioContextParam, appId:%s", str);
        }
        com.tencent.luggage.wxa.qb.a aVar = this.f133650v;
        aVar.f138563c = str;
        this.C = aVar.f138562b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (l() > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!this.f133646r || currentTimeMillis - this.f133648t >= 10000) {
                synchronized (this.f133644p) {
                    this.f133646r = true;
                }
                this.f133648t = currentTimeMillis;
                b(600000);
                return;
            }
            return;
        }
        synchronized (this.f133644p) {
            this.f133646r = false;
        }
        c0.b(this.O);
    }

    public String a(String str, String str2) {
        boolean z16;
        w.d(W, "createAudioPlayer");
        LinkedList<String> linkedList = this.f133636h.get(str);
        synchronized (this.f133644p) {
            if (linkedList != null) {
                try {
                    if (linkedList.contains(str2) && (this.f133631c.contains(str2) || this.f133633e.contains(str2))) {
                        z16 = true;
                    }
                } catch (Throwable th5) {
                    throw th5;
                }
            }
            z16 = false;
        }
        int n3 = n(str);
        if (TextUtils.isEmpty(str2)) {
            w.b(W, "createAudioPlayer fail, the audioId is empty!");
            a(604, str2);
            return null;
        }
        if (n3 >= 10) {
            w.b(W, "now created QQAudioPlayer count %d arrive MAX_AUDIO_PLAYER_COUNT, save id and not send error event, not create player!", Integer.valueOf(n3));
            b(str, str2);
            return null;
        }
        if (z16) {
            w.b(W, "now created QQAudioPlayer fail, the audioId exist in mAudioIds");
            a(603, str2);
            return null;
        }
        b(str, str2);
        z(str2);
        w.d(W, "create player success, appId:%s, audioId:%s", str, str2);
        return str2;
    }

    private void z() {
        com.tencent.luggage.wxa.mm.a aVar = (com.tencent.luggage.wxa.mm.a) com.tencent.luggage.wxa.tm.b.a(com.tencent.luggage.wxa.mm.a.class);
        this.f133649u = aVar;
        if (aVar != null) {
            aVar.e();
        }
    }

    @Override // com.tencent.luggage.wxa.lm.l
    public void c() {
        w.d(W, "resetSpeaker");
        if (!this.D && ((AudioManager) this.E.b()).getMode() == 3) {
            w.d(W, "set speaker on and reset mode to MODE_NORMAL");
            ((AudioManager) this.E.b()).setSpeakerphoneOn(true);
            ((AudioManager) this.E.b()).setMode(0);
        } else if (!this.D) {
            w.d(W, "set speaker on");
            ((AudioManager) this.E.b()).setSpeakerphoneOn(true);
        }
        this.D = true;
    }

    public void g() {
        w.d(W, "mixWithOther:%b, focus:%b", Boolean.valueOf(this.f133650v.f138561a), Boolean.valueOf(p()));
        if (!this.f133650v.f138561a && !p()) {
            w.d(W, "requestFocus()");
            A();
        } else if (this.f133650v.f138561a && p()) {
            w.d(W, "abandonFocus()");
            e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        w.d(W, "removeAndStopPlayingAudioPlayer");
        Iterator<String> it = this.f133640l.iterator();
        while (it.hasNext()) {
            String next = it.next();
            w.d(W, "need remove and stop player audioId : %s", next);
            D(next);
            z();
        }
        Iterator<String> it5 = this.f133642n.iterator();
        while (it5.hasNext()) {
            String next2 = it5.next();
            w.d(W, "need remove and stop player for try audioId : %s", next2);
            D(next2);
            z();
        }
        this.f133640l.clear();
        this.f133642n.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(com.tencent.luggage.wxa.qb.b bVar) {
        return (bVar == null || !bVar.f138565b.startsWith("wxblob://") || bVar.C == null) ? false : true;
    }

    private void d(String str, m mVar) {
        w.d(W, "pausePlayerOnBackground, pause player on background by audioId:%s", str);
        com.tencent.luggage.wxa.qb.b bVar = this.f133637i.get(str);
        if (bVar != null && mVar.i() && mVar.c()) {
            bVar.f138570g = true;
            bVar.f138567d = mVar.g();
        } else if (bVar != null && mVar.c()) {
            bVar.f138570g = true;
            bVar.f138567d = mVar.g();
        } else if (bVar != null) {
            bVar.f138570g = true;
            bVar.f138567d = 0;
        }
        f(str, mVar);
        com.tencent.luggage.wxa.qb.d o16 = o(str);
        if (o16 != null && mVar.i()) {
            o16.f138592c = true;
        }
        if (!mVar.i() && !mVar.c() && !mVar.Q() && !mVar.P() && !mVar.O()) {
            mVar.U();
        } else {
            mVar.A();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(com.tencent.luggage.wxa.qb.b bVar) {
        if (TextUtils.isEmpty(bVar.f138566c) && this.f133654z.containsKey(bVar.f138565b)) {
            bVar.f138566c = this.f133654z.get(bVar.f138565b);
        }
    }

    public boolean a(com.tencent.luggage.wxa.qb.a aVar) {
        this.f133650v = aVar;
        this.C = aVar.f138562b;
        return true;
    }

    private void a(com.tencent.luggage.wxa.qb.b bVar, com.tencent.luggage.wxa.qb.b bVar2) {
        w.d(W, "startAudioByMixPlayer");
        i(bVar.f138564a);
        b(bVar);
        if (TextUtils.isEmpty(bVar.f138566c) && bVar2 != null && bVar2.a(bVar)) {
            bVar.f138566c = bVar2.f138566c;
        }
        if (bVar.f138570g) {
            if (bVar2 != null && !bVar2.a(bVar)) {
                a(bVar, true, false);
                w.d(W, "mixPlayer param src change, do stop now and play new");
                if (this.B.l(bVar.f138564a) || this.B.o(bVar.f138564a) || this.B.n(bVar.f138564a) || this.B.m(bVar.f138564a) || this.B.k(bVar.f138564a)) {
                    this.B.v(bVar.f138564a);
                }
                this.B.b(bVar);
                return;
            }
            if (this.B.l(bVar.f138564a)) {
                w.d(W, "mixPlayer is playing, do nothing");
                return;
            }
            if (this.B.o(bVar.f138564a) && this.B.k(bVar.f138564a)) {
                w.d(W, "mixPlayer is paused, do resume");
                a(bVar, true, false);
                this.B.u(bVar.f138564a);
                return;
            } else if (this.B.m(bVar.f138564a)) {
                w.d(W, "mixPlayer is isPrepared, do resume");
                a(bVar, true, false);
                this.B.u(bVar.f138564a);
                return;
            } else {
                if (this.B.n(bVar.f138564a)) {
                    w.d(W, "mixPlayer is isPreparing, do nothing");
                    return;
                }
                w.d(W, "mixPlayer is end or stop, do startPlay");
                a(bVar, true, false);
                this.B.b(bVar);
                return;
            }
        }
        if (this.B.i(bVar.f138564a)) {
            this.B.d(bVar);
        } else {
            this.B.c(bVar);
        }
        if (bVar2 != null && !bVar2.a(bVar)) {
            w.d(W, "mixPlayer param src change, do stop now");
            if (this.B.l(bVar.f138564a) || this.B.o(bVar.f138564a) || this.B.n(bVar.f138564a) || this.B.m(bVar.f138564a) || this.B.k(bVar.f138564a)) {
                this.B.v(bVar.f138564a);
            }
        }
        this.B.a(7, bVar.f138564a);
    }

    public void f(String str) {
        w.d(W, "destroyAllAudioPlayersAndSaveState, appId:%s", str);
        synchronized (this.f133644p) {
            LinkedList<String> linkedList = this.f133636h.get(str);
            if (linkedList != null && linkedList.size() != 0) {
                Iterator<String> it = linkedList.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (this.B.i(next)) {
                        this.B.v(next);
                    }
                    m remove = this.f133630b.remove(next);
                    this.f133631c.remove(next);
                    if (remove != null) {
                        f(next, remove);
                        w.d(W, "destroy player");
                        if (remove.p()) {
                            e(next, remove);
                        } else {
                            a(next, remove);
                        }
                    }
                }
                Iterator<String> it5 = linkedList.iterator();
                while (it5.hasNext()) {
                    String next2 = it5.next();
                    if (this.B.i(next2)) {
                        this.B.v(next2);
                    }
                    m remove2 = this.f133632d.remove(next2);
                    this.f133633e.remove(next2);
                    if (remove2 != null) {
                        f(next2, remove2);
                        w.d(W, "destroy recycled player");
                        if (remove2.p()) {
                            e(next2, remove2);
                        } else {
                            a(next2, remove2);
                        }
                    }
                }
                return;
            }
            w.b(W, "there is no audioIds and players for this appId to stop");
        }
    }

    private void d(com.tencent.luggage.wxa.qb.b bVar) {
        com.tencent.luggage.wxa.mm.a aVar = (com.tencent.luggage.wxa.mm.a) com.tencent.luggage.wxa.tm.b.a(com.tencent.luggage.wxa.mm.a.class);
        this.f133649u = aVar;
        if (aVar != null) {
            aVar.a(bVar.f138564a, bVar.f138565b);
        }
    }

    private void e(String str, m mVar) {
        w.a(W, "releasePlayer");
        a(str, mVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        if (this.G.remove(str)) {
            this.f133637i.remove(str);
        }
    }

    public void e() {
        if (p()) {
            this.f133651w.a();
        }
    }

    private boolean a(String str, int i3) {
        com.tencent.luggage.wxa.qb.b bVar = this.f133637i.get(str);
        if (bVar == null) {
            return false;
        }
        bVar.f138567d = i3;
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:79:0x0026, code lost:
    
        if (r0 == null) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean b(String str, com.tencent.luggage.wxa.qb.b bVar) {
        com.tencent.luggage.wxa.qb.b bVar2 = this.f133637i.get(str);
        if ((!this.f133629a.contains(str) || bVar2 == null) && bVar != null) {
            w.b(W, "resumeAudio, the audioId %s is not found or param is null, backupParam is exit", str);
            a(str, bVar);
        } else {
            if (!this.f133629a.contains(str)) {
                w.b(W, "resumeAudio fail, the audioId is not found!");
                a(601, str);
                return false;
            }
            if (bVar2 == null) {
                w.b(W, "resumeAudio fail, the param is not found!");
                a(602, str);
                return false;
            }
        }
        bVar = bVar2;
        d(bVar);
        w.d(W, "resumeAudio, audioId:%s", str);
        String k3 = k(str);
        int n3 = n(k3);
        if (n3 >= 10) {
            w.b(W, "now created QQAudioPlayer count %d arrive MAX_PLAY_AUDIO_PLAYER_COUNT", Integer.valueOf(n3));
            if (a(str)) {
                w();
            } else {
                z();
                a(600, str);
                return false;
            }
        }
        g();
        this.f133637i.put(str, bVar);
        c(k3);
        a();
        m m3 = m(str);
        if (q()) {
            boolean a16 = a(m3);
            boolean z16 = this.B.i(str) && this.B.f(str);
            w.d(W, "resume canUseMixPlayer:%b, localCacheExit:%b, audioId:%s", Boolean.valueOf(a16), Boolean.valueOf(z16), bVar.f138564a);
            if (a16 && z16) {
                w.d(W, "use AudioMixPlayer");
                i(bVar.f138564a);
                b(bVar);
                if (this.B.l(bVar.f138564a)) {
                    w.d(W, "mix player is playing, do nothing");
                } else if (this.B.n(bVar.f138564a)) {
                    w.d(W, "mix player is preparing, do nothing");
                    bVar.f138570g = true;
                    m3.c(bVar);
                } else {
                    a(bVar, false, false);
                    this.B.s(str);
                }
                return true;
            }
            if (this.B.i(str) && !z16) {
                w.d(W, "resume mixPlayer param src change, do stop now");
                if (this.B.l(bVar.f138564a) || this.B.o(bVar.f138564a) || this.B.n(bVar.f138564a) || this.B.m(bVar.f138564a) || this.B.k(bVar.f138564a)) {
                    this.B.v(bVar.f138564a);
                }
            }
        } else {
            w.d(W, "Not support mix audio");
        }
        if (m3 == null) {
            w.b(W, "resumeAudio, player is null");
            z(str);
            w.d(W, "create new QQAudioPlayer with audioId %s to play", str);
            m i3 = i();
            i3.a(this.N);
            i3.a(this.L);
            i3.a(str);
            b(str, i3);
            bVar.f138570g = true;
            bVar.f138567d = 0;
            bVar.f138573j = System.currentTimeMillis();
            a(bVar, false, true);
            i3.a(bVar);
            return true;
        }
        b(str, m3);
        if (m3.c() && !m3.i()) {
            a(bVar, false, true);
            w.d(W, "is pause, do resume");
            m3.a();
        } else if (m3.P()) {
            a(bVar, false, true);
            bVar.f138570g = true;
            bVar.f138573j = System.currentTimeMillis();
            w.d(W, "is prepared, do resume");
            m3.a();
            bVar.f138567d = 0;
            m3.c(bVar);
        } else if (m3.Q()) {
            w.d(W, "is preparing, do update param");
            bVar.f138570g = true;
            bVar.f138573j = System.currentTimeMillis();
            m3.c(bVar);
        } else if (m3.p()) {
            a(bVar, false, true);
            bVar.f138570g = true;
            bVar.f138573j = System.currentTimeMillis();
            w.d(W, "is paused on background, do resume");
            m3.a(bVar);
        } else if (!m3.c()) {
            a(bVar, false, true);
            bVar.f138570g = true;
            bVar.f138573j = System.currentTimeMillis();
            w.d(W, "is stop, do startPlay");
            m3.a(bVar);
            bVar.f138567d = 0;
        } else {
            w.b(W, "do nothing");
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, m mVar) {
        this.f133638j.put(str, mVar.o());
    }

    public void a(int i3, String str) {
        w.b(W, "onErrorEvent with errCode:%d, audioId:%s", Integer.valueOf(i3), str);
        if (TextUtils.isEmpty(str)) {
            w.b(W, "audioId is empty");
            str = com.tencent.luggage.wxa.lm.h.a();
        }
        com.tencent.luggage.wxa.p9.c cVar = new com.tencent.luggage.wxa.p9.c();
        c.a aVar = cVar.f137441d;
        aVar.f137442a = 4;
        aVar.f137445d = "error";
        aVar.f137447f = com.tencent.luggage.wxa.sm.e.b(i3);
        cVar.f137441d.f137448g = com.tencent.luggage.wxa.sm.e.a(i3);
        c.a aVar2 = cVar.f137441d;
        aVar2.f137444c = str;
        aVar2.f137446e = k(str);
        cVar.a(Looper.getMainLooper());
    }

    public void f() {
        if (ContextCompat.checkSelfPermission(z.c(), DeviceInfoUtil.PERMISSION_READ_PHONE) != 0) {
            w.b(W, "addPhoneStatusWatcher() not have read_phone_state perm");
            return;
        }
        i0.b[] bVarArr = this.f133652x;
        if (bVarArr[0] != null) {
            return;
        }
        synchronized (bVarArr) {
            i0.b[] bVarArr2 = this.f133652x;
            if (bVarArr2[0] != null) {
                return;
            }
            bVarArr2[0] = new j();
            ((i0) com.tencent.luggage.wxa.eo.g.a(i0.class)).a(this.f133652x[0]);
            w.d(W, "addPhoneStatusWatcher");
        }
    }

    private void a(String str, m mVar) {
        if (mVar == null) {
            w.b(W, "destroyPlayer player is null for audioId:%s", str);
            return;
        }
        if (mVar.i() || mVar.c() || mVar.Q() || mVar.P() || mVar.O()) {
            mVar.f();
        }
        mVar.T();
        w.d(W, "destroyPlayer stop and release player by audioId:%s", str);
    }

    private boolean a(m mVar) {
        if (mVar == null) {
            return true;
        }
        return !(mVar.i() || mVar.O() || mVar.Q() || mVar.P() || mVar.c());
    }

    public void a(int i3) {
        long currentTimeMillis = System.currentTimeMillis();
        if (!this.f133645q || currentTimeMillis - this.f133647s >= 10000) {
            this.f133647s = currentTimeMillis;
            synchronized (this.f133644p) {
                this.f133645q = true;
            }
            w.d(W, "releaseAudioDelayIfPaused, delay_ms:%d", Integer.valueOf(i3));
            c0.b(this.P);
            c0.a(this.P, i3);
        }
    }

    private boolean a(String str) {
        com.tencent.luggage.wxa.qb.b bVar;
        String str2;
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        synchronized (this.f133644p) {
            int size = this.f133630b.size();
            char c16 = 0;
            if (size < 10) {
                this.f133640l.clear();
                w.d(W, "playerCount:%d is not need to remove", Integer.valueOf(size));
                return false;
            }
            Iterator<String> it = this.f133631c.iterator();
            while (it.hasNext()) {
                com.tencent.luggage.wxa.qb.b bVar2 = this.f133637i.get(it.next());
                if (bVar2 != null && (str2 = bVar2.f138565b) != null) {
                    if (!hashMap.containsKey(str2)) {
                        hashMap.put(bVar2.f138565b, 1);
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(bVar2.f138564a);
                        hashMap2.put(bVar2.f138565b, arrayList2);
                    } else {
                        hashMap.put(bVar2.f138565b, Integer.valueOf(((Integer) hashMap.get(bVar2.f138565b)).intValue() + 1));
                        ArrayList arrayList3 = (ArrayList) hashMap2.get(bVar2.f138565b);
                        if (!arrayList3.contains(bVar2.f138564a)) {
                            arrayList3.add(bVar2.f138564a);
                        }
                        hashMap2.put(bVar2.f138565b, arrayList3);
                    }
                    if (!arrayList.contains(bVar2.f138565b)) {
                        arrayList.add(bVar2.f138565b);
                    }
                }
            }
            String str3 = "";
            int m3 = m();
            w.a(W, "removePlayerGroupMinCount:%d", Integer.valueOf(m3));
            Iterator it5 = arrayList.iterator();
            boolean z16 = false;
            int i3 = m3;
            while (it5.hasNext()) {
                String str4 = (String) it5.next();
                int intValue = ((Integer) hashMap.get(str4)).intValue();
                Object[] objArr = new Object[2];
                objArr[c16] = Integer.valueOf(intValue);
                objArr[1] = str4;
                w.a(W, "count:%d, url:%s", objArr);
                if (intValue >= m3) {
                    if (i3 < intValue) {
                        str3 = str4;
                        i3 = intValue;
                    }
                    z16 = true;
                    if (TextUtils.isEmpty(str3)) {
                        str3 = str4;
                    }
                }
                c16 = 0;
            }
            if (z16 && (bVar = this.f133637i.get(str)) != null && str3 != null && str3.equalsIgnoreCase(bVar.f138565b)) {
                w.d(W, "srcUrl is same, not remove and don't play again");
                z16 = false;
            }
            if (z16) {
                w.d(W, "need to remove player");
                ArrayList arrayList4 = (ArrayList) hashMap2.get(str3);
                if (arrayList4 != null && arrayList4.size() > 0) {
                    LinkedList linkedList = new LinkedList();
                    Iterator it6 = arrayList4.iterator();
                    while (it6.hasNext()) {
                        com.tencent.luggage.wxa.qb.b bVar3 = this.f133637i.get((String) it6.next());
                        if (bVar3 != null) {
                            linkedList.add(bVar3);
                        }
                    }
                    Collections.sort(linkedList, new k());
                    LinkedList linkedList2 = new LinkedList();
                    Iterator it7 = linkedList.iterator();
                    while (it7.hasNext()) {
                        linkedList2.add(((com.tencent.luggage.wxa.qb.b) it7.next()).f138564a);
                    }
                    int i16 = size - 10;
                    if (i16 > 0 && linkedList2.size() > i16) {
                        int i17 = i16 + 1;
                        w.d(W, "removeCount should be %d", Integer.valueOf(i17));
                        int size2 = linkedList2.size() - i17;
                        if (size2 < 0) {
                            size2 = 1;
                        }
                        this.f133640l.addAll(linkedList2.subList(size2, linkedList2.size()));
                    } else if (i16 > 0 && linkedList2.size() < i16) {
                        this.f133640l.addAll(linkedList2.subList(1, linkedList2.size()));
                    } else {
                        this.f133640l.add((String) linkedList2.get(linkedList2.size() - 1));
                    }
                    w.d(W, "need remove and stop player count : %d", Integer.valueOf(this.f133640l.size()));
                }
            } else {
                w.d(W, "not need to remove player");
                this.f133640l.clear();
            }
            return z16;
        }
    }

    private void a(com.tencent.luggage.wxa.qb.b bVar, boolean z16, boolean z17) {
        long j3;
        com.tencent.luggage.wxa.mm.a aVar = (com.tencent.luggage.wxa.mm.a) com.tencent.luggage.wxa.tm.b.a(com.tencent.luggage.wxa.mm.a.class);
        this.f133649u = aVar;
        if (aVar != null) {
            aVar.a(bVar.f138564a, bVar.f138565b, z17);
        }
        long currentTimeMillis = System.currentTimeMillis();
        bVar.f138578o = currentTimeMillis;
        if (z16) {
            j3 = bVar.f138582s;
            bVar.f138579p = bVar.f138581r;
        } else {
            j3 = bVar.f138584u;
            bVar.f138579p = bVar.f138583t;
        }
        if (j3 > 0 && currentTimeMillis > j3) {
            bVar.f138580q = currentTimeMillis - j3;
        } else {
            bVar.f138580q = 0L;
        }
    }

    public boolean b(String str, int i3) {
        m m3 = m(str);
        if (m3 == null) {
            w.b(W, "seekToAudio, player is null");
            if (this.B.i(str)) {
                this.B.a(str, i3);
            }
            return a(str, i3);
        }
        if (i3 < 0) {
            w.b(W, "seekToAudio, time pos is invalid time:%d, duration:%d", Integer.valueOf(i3), Integer.valueOf(m3.getDuration()));
            return false;
        }
        if (m3.getDuration() <= 0) {
            w.b(W, "seekToAudio, duration is invalid, time:%d, duration:%d", Integer.valueOf(i3), Integer.valueOf(m3.getDuration()));
            m3.w();
            boolean a16 = a(str, i3);
            if (a16) {
                m3.c(this.f133637i.get(str));
            }
            return a16;
        }
        if (i3 > 0 && i3 > m3.getDuration()) {
            w.b(W, "seekToAudio, time pos is invalid, exceed duration time:%d, duration:%d", Integer.valueOf(i3), Integer.valueOf(m3.getDuration()));
            return false;
        }
        w.d(W, "seekToAudio, audioId:%s, time:%s", str, Integer.valueOf(i3));
        if (!m3.i() && !m3.c() && !m3.O()) {
            m3.w();
            return a(str, i3);
        }
        return m3.b(i3);
    }

    @Override // com.tencent.luggage.wxa.lm.l
    public void a() {
        if (this.f133650v.f138561a && !this.D) {
            w.d(W, "mixWithOther is true, useSpeakerOn is false, return");
            c();
            return;
        }
        if (this.f133650v.f138561a) {
            w.d(W, "mixWithOther is true, return");
            return;
        }
        if (this.C && ((AudioManager) this.E.b()).getMode() != 0) {
            w.d(W, "speaker is on and reset speaker");
            c();
            return;
        }
        if (this.C) {
            w.d(W, "speaker is on, do nothing");
            return;
        }
        if (i0.b0()) {
            w.d(W, "shiftSpeaker return when phone calling");
            return;
        }
        if (((AudioManager) this.E.b()).isBluetoothScoOn() || ((AudioManager) this.E.b()).isBluetoothA2dpOn()) {
            w.d(W, "shiftSpeaker return when isBluetoothScoOn:%b , isBluetoothA2dpOn:%b", Boolean.valueOf(((AudioManager) this.E.b()).isBluetoothScoOn()), Boolean.valueOf(((AudioManager) this.E.b()).isBluetoothA2dpOn()));
            return;
        }
        if (((AudioManager) this.E.b()).isWiredHeadsetOn()) {
            w.d(W, "shiftSpeaker return when wired headset on");
            return;
        }
        if (!this.D && ((AudioManager) this.E.b()).getMode() == 3 && !((AudioManager) this.E.b()).isSpeakerphoneOn()) {
            w.d(W, "shiftSpeaker return when wired headset on");
            return;
        }
        this.D = false;
        ((AudioManager) this.E.b()).setSpeakerphoneOn(false);
        ((AudioManager) this.E.b()).setMode(3);
        w.d(W, "set speaker off and change mode to MODE_IN_COMMUNICATION");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, m mVar) {
        w.d(W, "markPlayer, mark player by audioId:%s", str);
        synchronized (this.f133644p) {
            if (this.f133633e.contains(str)) {
                this.f133632d.remove(str);
                this.f133633e.remove(str);
            }
            if (!this.f133631c.contains(str)) {
                this.f133631c.add(str);
                this.f133630b.put(str, mVar);
            }
        }
    }

    public void b(int i3) {
        w.d(W, "stopAudioDelayIfPaused, delay_ms:%d", Integer.valueOf(i3));
        c0.b(this.O);
        c0.a(this.O, i3);
    }

    private void a(com.tencent.luggage.wxa.qb.b bVar) {
        if (bVar == null || TextUtils.isEmpty(bVar.f138565b) || !bVar.f138565b.startsWith("http")) {
            return;
        }
        if (!TextUtils.isEmpty(bVar.f138566c) && this.B.g(bVar.f138566c)) {
            return;
        }
        if (this.J == null) {
            this.J = new Handler(Looper.myLooper());
        }
        com.tencent.luggage.wxa.om.g.i(bVar.f138565b);
        boolean a16 = com.tencent.luggage.wxa.om.i.a(bVar.f138565b);
        w.d(W, "checkNeedDownloadSrc audioId:%s, cacheValid:%b, checkCount:%d", bVar.f138564a, Boolean.valueOf(a16), Integer.valueOf(this.T));
        this.T++;
        if (!a16) {
            this.I.b(bVar);
            return;
        }
        F(bVar.f138564a);
        h(bVar);
        y(bVar.f138564a);
    }

    private boolean b(String str) {
        String str2;
        w.d(W, "canRemoveAudioPlayerInPlayingListForTry");
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        synchronized (this.f133644p) {
            int size = this.f133630b.size();
            if (size <= 5) {
                w.d(W, "playerCount:%d is not need to remove for try", Integer.valueOf(size));
                return false;
            }
            Iterator<String> it = this.f133631c.iterator();
            while (it.hasNext()) {
                com.tencent.luggage.wxa.qb.b bVar = this.f133637i.get(it.next());
                if (bVar != null && (str2 = bVar.f138565b) != null) {
                    if (!hashMap.containsKey(str2)) {
                        hashMap.put(bVar.f138565b, 1);
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(bVar.f138564a);
                        hashMap2.put(bVar.f138565b, arrayList2);
                    } else {
                        hashMap.put(bVar.f138565b, Integer.valueOf(((Integer) hashMap.get(bVar.f138565b)).intValue() + 1));
                        ArrayList arrayList3 = (ArrayList) hashMap2.get(bVar.f138565b);
                        if (!arrayList3.contains(bVar.f138564a)) {
                            arrayList3.add(bVar.f138564a);
                        }
                        hashMap2.put(bVar.f138565b, arrayList3);
                    }
                    if (!arrayList.contains(bVar.f138565b)) {
                        arrayList.add(bVar.f138565b);
                    }
                }
            }
            com.tencent.luggage.wxa.qb.b bVar2 = this.f133637i.get(str);
            Iterator it5 = arrayList.iterator();
            while (it5.hasNext()) {
                String str3 = (String) it5.next();
                if (bVar2 != null && str3 != null && str3.equalsIgnoreCase(bVar2.f138565b)) {
                    w.d(W, "srcUrl is same, not remove and don't play again for try");
                    return false;
                }
            }
            String str4 = "";
            w.a(W, "removePlayerGroupMinCountForTry:%d", 2);
            Iterator it6 = arrayList.iterator();
            int i3 = 2;
            boolean z16 = false;
            while (it6.hasNext()) {
                String str5 = (String) it6.next();
                int intValue = ((Integer) hashMap.get(str5)).intValue();
                w.a(W, "count:%d, url:%s", Integer.valueOf(intValue), str5);
                if (intValue >= 2) {
                    if (i3 < intValue) {
                        str4 = str5;
                        i3 = intValue;
                    }
                    if (TextUtils.isEmpty(str4)) {
                        z16 = true;
                        str4 = str5;
                    } else {
                        z16 = true;
                    }
                }
            }
            if (z16) {
                w.d(W, "need to remove player");
                ArrayList arrayList4 = (ArrayList) hashMap2.get(str4);
                if (arrayList4 != null && arrayList4.size() > 0) {
                    LinkedList linkedList = new LinkedList();
                    Iterator it7 = arrayList4.iterator();
                    while (it7.hasNext()) {
                        com.tencent.luggage.wxa.qb.b bVar3 = this.f133637i.get((String) it7.next());
                        if (bVar3 != null) {
                            linkedList.add(bVar3);
                        }
                    }
                    Collections.sort(linkedList, new k());
                    LinkedList linkedList2 = new LinkedList();
                    Iterator it8 = linkedList.iterator();
                    while (it8.hasNext()) {
                        linkedList2.add(((com.tencent.luggage.wxa.qb.b) it8.next()).f138564a);
                    }
                    this.f133642n.add((String) linkedList2.getLast());
                    w.d(W, "need remove and stop player count for try: %d", Integer.valueOf(this.f133642n.size()));
                }
            } else {
                w.d(W, "not need to remove player for try");
            }
            return z16;
        }
    }

    public void a(com.tencent.luggage.wxa.lm.k kVar) {
        synchronized (this.f133653y) {
            if (!this.f133653y.contains(kVar)) {
                this.f133653y.add(kVar);
            }
        }
    }

    private void b(com.tencent.luggage.wxa.qb.b bVar) {
        com.tencent.luggage.wxa.qb.f fVar = bVar.f138588y;
        if (fVar != null) {
            try {
                fVar.close();
                bVar.f138588y = null;
            } catch (Exception e16) {
                w.a(W, e16, "closeAudioDataSource", new Object[0]);
            }
        }
    }

    @Override // com.tencent.luggage.wxa.lm.l
    public int b() {
        return (this.C || this.f133650v.f138561a || this.D) ? 3 : 0;
    }

    public void b(com.tencent.luggage.wxa.lm.k kVar) {
        synchronized (this.f133653y) {
            if (this.f133653y.contains(kVar)) {
                this.f133653y.remove(kVar);
            }
        }
    }
}
