package com.tencent.luggage.wxa.j9;

import android.media.AudioTrack;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.luggage.wxa.g9.o;
import com.tencent.luggage.wxa.p9.c;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d {
    public com.tencent.luggage.wxa.g9.a C;
    public Handler G;

    /* renamed from: d, reason: collision with root package name */
    public AudioTrack f130896d;

    /* renamed from: k, reason: collision with root package name */
    public Thread f130903k;

    /* renamed from: l, reason: collision with root package name */
    public com.tencent.luggage.wxa.i9.d f130904l;

    /* renamed from: m, reason: collision with root package name */
    public com.tencent.luggage.wxa.j9.b f130905m;

    /* renamed from: n, reason: collision with root package name */
    public o f130906n;

    /* renamed from: o, reason: collision with root package name */
    public g f130907o;

    /* renamed from: a, reason: collision with root package name */
    public int f130893a = 2;

    /* renamed from: b, reason: collision with root package name */
    public int f130894b = 44100;

    /* renamed from: c, reason: collision with root package name */
    public int f130895c = 4;

    /* renamed from: e, reason: collision with root package name */
    public AtomicBoolean f130897e = new AtomicBoolean(false);

    /* renamed from: f, reason: collision with root package name */
    public AtomicBoolean f130898f = new AtomicBoolean(false);

    /* renamed from: g, reason: collision with root package name */
    public AtomicBoolean f130899g = new AtomicBoolean(true);

    /* renamed from: h, reason: collision with root package name */
    public Queue f130900h = new ArrayDeque();

    /* renamed from: i, reason: collision with root package name */
    public Object f130901i = new Object();

    /* renamed from: j, reason: collision with root package name */
    public Object f130902j = new Object();

    /* renamed from: p, reason: collision with root package name */
    public volatile HashMap f130908p = new HashMap();

    /* renamed from: q, reason: collision with root package name */
    public volatile HashMap f130909q = new HashMap();

    /* renamed from: r, reason: collision with root package name */
    public volatile HashMap f130910r = new HashMap();

    /* renamed from: s, reason: collision with root package name */
    public volatile HashMap f130911s = new HashMap();

    /* renamed from: t, reason: collision with root package name */
    public volatile HashMap f130912t = new HashMap();

    /* renamed from: u, reason: collision with root package name */
    public volatile HashMap f130913u = new HashMap();

    /* renamed from: v, reason: collision with root package name */
    public ArrayList f130914v = new ArrayList();

    /* renamed from: w, reason: collision with root package name */
    public volatile HashMap f130915w = new HashMap();

    /* renamed from: x, reason: collision with root package name */
    public volatile HashMap f130916x = new HashMap();

    /* renamed from: y, reason: collision with root package name */
    public volatile HashMap f130917y = new HashMap();

    /* renamed from: z, reason: collision with root package name */
    public volatile HashMap f130918z = new HashMap();
    public volatile HashMap A = new HashMap();
    public volatile HashMap B = new HashMap();
    public byte[] D = new byte[3536];
    public byte[] E = new byte[2];
    public short F = 0;
    public volatile boolean H = false;
    public int I = 0;
    public Runnable J = new a();
    public ArrayList K = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int i3;
            Process.setThreadPriority(-19);
            if (d.this.f130899g.get()) {
                com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioMixPlayerImpl", "stop and exit");
                return;
            }
            if (d.this.f130896d == null) {
                d.this.l();
            }
            com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioMixPlayerImpl", "playback start");
            while (true) {
                if (d.this.f130899g.get()) {
                    break;
                }
                d.this.w();
                if (d.this.f130899g.get()) {
                    com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioMixPlayerImpl", "playback break");
                    break;
                }
                com.tencent.luggage.wxa.c9.b d16 = d.this.d();
                if (d16 != null) {
                    byte[] bArr = d16.f123417d;
                    if (d.this.f130896d == null) {
                        d.this.l();
                    }
                    if (bArr != null && bArr.length > 0) {
                        if (d.this.f130896d != null && (d.this.f130896d.getPlayState() == 1 || d.this.f130896d.getPlayState() == 2)) {
                            d.this.f130896d.play();
                        }
                        d.this.c(d16);
                        d.j(d.this);
                        d.this.b(d16);
                        long currentTimeMillis = System.currentTimeMillis();
                        if (d.this.f130896d != null) {
                            if (d.this.f130904l.e()) {
                                com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioMixPlayerImpl", "isMute");
                                d.this.f130896d.setStereoVolume(0.0f, 0.0f);
                            } else {
                                d.this.f130896d.setStereoVolume(1.0f, 1.0f);
                            }
                            i3 = d.this.f130896d.write(bArr, 0, bArr.length);
                        } else {
                            i3 = 0;
                        }
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        if (currentTimeMillis2 > 100) {
                            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioMixPlayerImpl", "write audio track after writeSize:%d, time:%d, writeCount:%d", Integer.valueOf(i3), Long.valueOf(currentTimeMillis2), Integer.valueOf(d.this.I));
                        }
                        if (i3 < 0) {
                            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioMixPlayerImpl", "write audio track buffer failed, Size:%d", Integer.valueOf(i3));
                        }
                        if (d.this.f130900h.size() == 0) {
                            d.this.E[0] = bArr[bArr.length - 2];
                            d.this.E[1] = bArr[bArr.length - 1];
                        }
                    }
                    com.tencent.luggage.wxa.d9.b.a().a(d16);
                }
            }
            d.this.r();
            com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioMixPlayerImpl", "release AudioTrack and exit playback thread id:%d", Long.valueOf(Thread.currentThread().getId()));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f130920a;

        public b(String str) {
            this.f130920a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.a(11, this.f130920a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements o {
        public c() {
        }

        public final boolean a(int i3) {
            return i3 == 12 || i3 == 11 || i3 == 10 || i3 == 6;
        }

        @Override // com.tencent.luggage.wxa.g9.o
        public void a(com.tencent.luggage.wxa.p9.c cVar) {
            int i3 = cVar.f137441d.f137442a;
            if (!a(i3)) {
                if (d.this.f130911s.containsKey(cVar.f137441d.f137444c)) {
                    e eVar = (e) d.this.f130911s.get(cVar.f137441d.f137444c);
                    if (eVar != null && eVar.a((Object[]) new Integer[]{Integer.valueOf(i3)})) {
                        com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioMixPlayerImpl", "don't callback again");
                        return;
                    } else if (eVar != null) {
                        eVar.a(Integer.valueOf(i3));
                        d.this.f130911s.put(cVar.f137441d.f137444c, eVar);
                    }
                } else {
                    synchronized (d.this.f130902j) {
                        d.this.f130911s.put(cVar.f137441d.f137444c, new e(Integer.valueOf(i3)));
                    }
                }
            }
            if (d.this.f130905m == null) {
                return;
            }
            c.a aVar = cVar.f137441d;
            com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioMixPlayerImpl", "onEventChange audioId:%s, state:%s", aVar.f137444c, aVar.f137445d);
            if (i3 == 9) {
                d.this.f130905m.k(cVar);
                return;
            }
            if (i3 == 7) {
                d.this.f130905m.d(cVar);
                return;
            }
            if (i3 == 0) {
                d.this.f130905m.h(cVar);
                return;
            }
            if (i3 == 1) {
                d.this.f130905m.h(cVar);
                return;
            }
            if (i3 == 2) {
                d.this.f130905m.f(cVar);
                return;
            }
            if (i3 == 3) {
                d.this.f130910r.put(cVar.f137441d.f137444c, Boolean.FALSE);
                d.this.f130905m.i(cVar);
                return;
            }
            if (i3 == 5) {
                d.this.f130910r.put(cVar.f137441d.f137444c, Boolean.FALSE);
                d.this.f130905m.c(cVar);
                return;
            }
            if (i3 == 4) {
                d.this.f130910r.put(cVar.f137441d.f137444c, Boolean.FALSE);
                d.this.f130905m.j(cVar);
                return;
            }
            if (i3 == 10) {
                d.this.f130905m.g(cVar);
                return;
            }
            if (i3 == 6) {
                d.this.f130905m.b(cVar);
                return;
            }
            if (i3 == 11) {
                d.this.f130905m.e(cVar);
            } else if (i3 == 12) {
                d.this.f130905m.l(cVar);
            } else if (i3 == 13) {
                d.this.f130905m.a(cVar);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.j9.d$d, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC6332d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.c9.c f130923a;

        public RunnableC6332d(com.tencent.luggage.wxa.c9.c cVar) {
            this.f130923a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f130905m != null) {
                this.f130923a.f123415b = d.this.f130893a;
                this.f130923a.f123414a = d.this.f130894b;
                d.this.f130905m.a(this.f130923a);
            }
        }
    }

    public d(boolean z16) {
        a(z16);
    }

    public static /* synthetic */ int j(d dVar) {
        int i3 = dVar.I;
        dVar.I = i3 + 1;
        return i3;
    }

    public void p() {
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioMixPlayerImpl", "pauseAllOnBackground");
        this.f130904l.l();
        u();
    }

    public void q() {
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioMixPlayerImpl", "release");
        this.f130897e.set(false);
        b();
        u();
        this.f130904l.k();
        this.C = null;
        a();
    }

    public void r(String str) {
        this.f130908p.remove(str);
        this.f130909q.remove(str);
        this.f130910r.remove(str);
        synchronized (this.f130902j) {
            this.f130911s.remove(str);
            this.f130913u.remove(str);
        }
        this.f130912t.remove(str);
    }

    public void s(String str) {
        this.f130899g.set(false);
        this.f130898f.set(false);
        v();
        s();
        synchronized (this.f130902j) {
            this.f130913u.put(str, Boolean.FALSE);
        }
        this.f130904l.m(str);
        this.f130909q.remove(str);
        this.f130910r.put(str, Boolean.TRUE);
        if (this.C.d(str) && this.C.c(str)) {
            a(1, str);
        }
    }

    public void t() {
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioMixPlayerImpl", "stopAll");
        this.f130904l.p();
        b();
        u();
    }

    public void u() {
        this.f130897e.set(false);
        this.f130899g.set(true);
        this.f130898f.set(false);
        v();
        e();
    }

    public void v() {
        synchronized (this.f130901i) {
            com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioMixPlayerImpl", "sync notify");
            try {
                this.f130901i.notifyAll();
            } catch (Exception e16) {
                com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioMixPlayerImpl", e16, "syncNotify", new Object[0]);
            }
        }
    }

    public void w() {
        synchronized (this.f130901i) {
            while (this.f130898f.get() && !this.f130899g.get()) {
                com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioMixPlayerImpl", "waitPlay");
                try {
                    LockMethodProxy.wait(this.f130901i);
                } catch (Exception e16) {
                    com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioMixPlayerImpl", e16, "waitPlay", new Object[0]);
                }
            }
        }
    }

    public int b(String str) {
        com.tencent.luggage.wxa.c9.d b16;
        if (this.f130908p.containsKey(str)) {
            String str2 = ((com.tencent.luggage.wxa.qb.b) this.f130908p.get(str)).f138566c;
            if (!TextUtils.isEmpty(str2) && (b16 = com.tencent.luggage.wxa.d9.f.c().b(str2)) != null && b16.f() > 0) {
                return 100;
            }
        }
        return 0;
    }

    public void c(com.tencent.luggage.wxa.qb.b bVar) {
        this.f130908p.put(bVar.f138564a, bVar);
        if (j() == 1 && u(bVar.f138564a) && k(bVar.f138564a)) {
            float f16 = (float) bVar.f138575l;
            a(f16, f16);
            com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioMixPlayerImpl", "setPlayParam setVolume:%f", Double.valueOf(bVar.f138575l));
        }
    }

    public void d(com.tencent.luggage.wxa.qb.b bVar) {
        if (this.f130908p.containsKey(bVar.f138564a)) {
            this.f130908p.put(bVar.f138564a, bVar);
            if (j() == 1 && u(bVar.f138564a) && k(bVar.f138564a)) {
                float f16 = (float) bVar.f138575l;
                a(f16, f16);
                com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioMixPlayerImpl", "update setVolume:%f", Double.valueOf(bVar.f138575l));
            }
        }
    }

    public int e(String str) {
        com.tencent.luggage.wxa.qb.b bVar;
        long a16;
        if (!this.f130908p.containsKey(str) || (bVar = (com.tencent.luggage.wxa.qb.b) this.f130908p.get(str)) == null) {
            return 0;
        }
        if (bVar.f138589z) {
            a16 = this.f130904l.c(str);
        } else {
            a16 = this.C.a(str);
        }
        int i3 = (int) a16;
        if (i3 != -1) {
            bVar.f138569f = i3;
        } else {
            i3 = bVar.f138569f;
        }
        if (i3 == -1) {
            return 0;
        }
        int c16 = c(str);
        return (c16 <= 0 || i3 <= c16) ? i3 : c16;
    }

    public int f(String str) {
        e eVar;
        if (this.f130911s.containsKey(str) && (eVar = (e) this.f130911s.get(str)) != null) {
            return ((Integer) eVar.a()).intValue();
        }
        return -1;
    }

    public com.tencent.luggage.wxa.i9.d g() {
        return this.f130904l;
    }

    public boolean h(String str) {
        return this.f130909q.containsKey(str) && ((Boolean) this.f130909q.get(str)).booleanValue();
    }

    public boolean i(String str) {
        return this.f130899g.get();
    }

    public boolean j(String str) {
        e eVar;
        return this.f130911s.containsKey(str) && (eVar = (e) this.f130911s.get(str)) != null && eVar.a((Object[]) new Integer[]{2});
    }

    public boolean k(String str) {
        if (this.f130911s.containsKey(str)) {
            e eVar = (e) this.f130911s.get(str);
            if (eVar != null && eVar.a((Object[]) new Integer[]{0}) && !this.f130904l.f()) {
                return true;
            }
            if (!this.f130904l.f() && !this.f130904l.f(str) && this.C.c(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean l(String str) {
        e eVar;
        return this.f130911s.containsKey(str) && (eVar = (e) this.f130911s.get(str)) != null && eVar.a((Object[]) new Integer[]{7});
    }

    public void m() {
        com.tencent.luggage.wxa.i9.d dVar = new com.tencent.luggage.wxa.i9.d(this);
        this.f130904l = dVar;
        dVar.j();
    }

    public boolean n(String str) {
        if (this.f130910r.containsKey(str)) {
            return ((Boolean) this.f130910r.get(str)).booleanValue();
        }
        return false;
    }

    public void o() {
        if (this.f130897e.get()) {
            return;
        }
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioMixPlayerImpl", "initThread");
        this.f130897e.set(true);
        this.f130899g.set(false);
        this.f130898f.set(false);
        s();
    }

    public final void a(boolean z16) {
        m();
        n();
        if (z16) {
            o();
        }
        this.G = new Handler(Looper.myLooper());
    }

    public boolean g(String str) {
        return this.f130908p.containsKey(str);
    }

    public ArrayList h() {
        this.f130914v.clear();
        this.K.clear();
        synchronized (this.f130902j) {
            this.K.addAll(this.f130911s.keySet());
            Iterator it = this.K.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                e eVar = (e) this.f130911s.get(str);
                if (eVar != null && eVar.a((Object[]) new Integer[]{2})) {
                    this.f130914v.add(str);
                }
            }
        }
        return this.f130914v;
    }

    public int i() {
        int i3;
        synchronized (this.f130902j) {
            Set keySet = this.f130911s.keySet();
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(keySet);
            Iterator it = arrayList.iterator();
            i3 = 0;
            while (it.hasNext()) {
                e eVar = (e) this.f130911s.get((String) it.next());
                if (eVar != null && (eVar.a((Object[]) new Integer[]{0}) || eVar.a((Object[]) new Integer[]{1}) || eVar.a((Object[]) new Integer[]{2}))) {
                    i3++;
                }
            }
        }
        return i3;
    }

    public boolean m(String str) {
        e eVar;
        return this.f130911s.containsKey(str) && (eVar = (e) this.f130911s.get(str)) != null && eVar.a((Object[]) new Integer[]{9});
    }

    public final void n() {
        if (this.f130906n != null) {
            return;
        }
        this.f130906n = new c();
    }

    public void p(String str) {
        this.f130904l.j(str);
        if (this.C.d(str) && this.C.c(str)) {
            a(2, str);
        }
    }

    public long f() {
        return this.f130904l.d();
    }

    public int j() {
        int i3;
        synchronized (this.f130902j) {
            Set keySet = this.f130911s.keySet();
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(keySet);
            Iterator it = arrayList.iterator();
            i3 = 0;
            while (it.hasNext()) {
                e eVar = (e) this.f130911s.get((String) it.next());
                if (eVar != null && (eVar.a((Object[]) new Integer[]{0}) || eVar.a((Object[]) new Integer[]{1}))) {
                    i3++;
                }
            }
        }
        return i3;
    }

    public final void l() {
        if (!c()) {
            a(710);
        } else {
            com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioMixPlayerImpl", "create AudioTrack success");
            this.f130896d.play();
        }
    }

    public void t(String str) {
        this.f130904l.n(str);
        synchronized (this.f130902j) {
            this.f130913u.remove(str);
        }
        this.f130909q.remove(str);
        this.f130910r.put(str, Boolean.FALSE);
        if (this.C.d(str)) {
            a(3, str);
        }
    }

    public int c(String str) {
        com.tencent.luggage.wxa.qb.b bVar;
        com.tencent.luggage.wxa.c9.d b16;
        if (!this.f130908p.containsKey(str) || (bVar = (com.tencent.luggage.wxa.qb.b) this.f130908p.get(str)) == null) {
            return 0;
        }
        String str2 = bVar.f138566c;
        if (!TextUtils.isEmpty(str2) && (b16 = com.tencent.luggage.wxa.d9.f.c().b(str2)) != null) {
            return (int) b16.f();
        }
        return 0;
    }

    public g k() {
        return this.f130907o;
    }

    public boolean u(String str) {
        if (this.f130908p.containsKey(str)) {
            return ((com.tencent.luggage.wxa.qb.b) this.f130908p.get(str)).f138589z;
        }
        return false;
    }

    public void a(com.tencent.luggage.wxa.g9.a aVar) {
        this.C = aVar;
    }

    public void b(com.tencent.luggage.wxa.c9.b bVar) {
        boolean z16;
        Iterator it = bVar.f123418e.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            synchronized (this.f130902j) {
                if (!TextUtils.isEmpty(str) && (!this.f130913u.containsKey(str) || !((Boolean) this.f130913u.get(str)).booleanValue())) {
                    if (this.f130913u.containsKey(str)) {
                        this.f130913u.put(str, Boolean.TRUE);
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        this.G.post(new b(str));
                    }
                }
            }
        }
    }

    public com.tencent.luggage.wxa.c9.b d() {
        com.tencent.luggage.wxa.c9.b bVar;
        synchronized (this.f130901i) {
            while (true) {
                if ((this.f130900h.size() == 0 || this.f130898f.get()) && !this.f130899g.get()) {
                    try {
                        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioMixPlayerImpl", "wait play");
                        a(0.0f, 0.0f);
                        AudioTrack audioTrack = this.f130896d;
                        if (audioTrack != null && audioTrack.getPlayState() == 3) {
                            this.f130896d.stop();
                        }
                        LockMethodProxy.wait(this.f130901i);
                        this.I = 0;
                    } catch (InterruptedException e16) {
                        com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioMixPlayerImpl", e16, "waitPlay", new Object[0]);
                    }
                }
            }
            bVar = (com.tencent.luggage.wxa.c9.b) this.f130900h.poll();
            this.f130901i.notifyAll();
        }
        return bVar;
    }

    public void a() {
        this.f130904l.a();
        this.f130908p.clear();
        this.f130909q.clear();
        this.f130910r.clear();
        synchronized (this.f130902j) {
            this.f130911s.clear();
        }
        this.f130912t.clear();
        this.f130913u.clear();
    }

    public boolean o(String str) {
        e eVar;
        return this.f130911s.containsKey(str) && (eVar = (e) this.f130911s.get(str)) != null && (eVar.a((Object[]) new Integer[]{3}) || eVar.a((Object[]) new Integer[]{4}) || eVar.a((Object[]) new Integer[]{5}));
    }

    public void q(String str) {
        this.f130899g.set(false);
        this.f130898f.set(false);
        v();
        s();
        synchronized (this.f130902j) {
            this.f130913u.put(str, Boolean.FALSE);
        }
        this.f130904l.m(str);
        this.f130909q.remove(str);
        this.f130910r.put(str, Boolean.TRUE);
        if (this.C.d(str) && this.C.c(str)) {
            a(0, str);
        }
    }

    public final void e() {
        synchronized (this) {
            Thread thread = this.f130903k;
            if (thread != null) {
                com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioMixPlayerImpl", "stop playback thread id:%d", Long.valueOf(thread.getId()));
                this.f130903k = null;
            }
        }
    }

    public final synchronized void r() {
        try {
            AudioTrack audioTrack = this.f130896d;
            if (audioTrack != null) {
                audioTrack.flush();
                this.f130896d.stop();
                this.f130896d.release();
                this.f130896d = null;
            }
        } catch (Exception e16) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioMixPlayerImpl", e16, "releaseAudioTrack", new Object[0]);
        }
    }

    public final synchronized boolean c() {
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioMixPlayerImpl", "createAudioTrack");
        int i3 = this.f130893a == 1 ? 4 : 12;
        int minBufferSize = AudioTrack.getMinBufferSize(this.f130894b, i3, 2);
        this.f130895c = minBufferSize / 3536;
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioMixPlayerImpl", "miniBufferSize:%d, channels:%d, sampleRate:%d", Integer.valueOf(minBufferSize), Integer.valueOf(this.f130893a), Integer.valueOf(this.f130894b));
        if (this.f130896d == null) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioMixPlayerImpl", "audioTrack is null, new AudioTrack");
            try {
                this.f130896d = new AudioTrack(3, this.f130894b, i3, 2, minBufferSize, 1);
            } catch (IllegalArgumentException e16) {
                com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioMixPlayerImpl", e16, "AudioTrack create", new Object[0]);
            }
        }
        AudioTrack audioTrack = this.f130896d;
        if (audioTrack != null && audioTrack.getState() == 1) {
            return true;
        }
        com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioMixPlayerImpl", "audio track not initialized");
        AudioTrack audioTrack2 = this.f130896d;
        if (audioTrack2 != null) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioMixPlayerImpl", "AudioTrack getState", Integer.valueOf(audioTrack2.getState()));
            try {
                this.f130896d.release();
                this.f130896d = null;
            } catch (Exception e17) {
                com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioMixPlayerImpl", e17, "AudioTrack release", new Object[0]);
            }
        }
        return false;
    }

    public final void s() {
        synchronized (this) {
            if (this.f130903k == null) {
                BaseThread baseThread = new BaseThread(this.J, "audio_mix_player");
                this.f130903k = baseThread;
                baseThread.start();
                com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioMixPlayerImpl", "start playback thread id:%d", Long.valueOf(this.f130903k.getId()));
            }
        }
    }

    public void b() {
        this.f130900h.clear();
    }

    public void b(boolean z16) {
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioMixPlayerImpl", "setIsOutputMixBuffer:%b", Boolean.valueOf(z16));
        this.H = z16;
    }

    public void a(com.tencent.luggage.wxa.qb.b bVar) {
        e eVar;
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioMixPlayerImpl", "preparePlay");
        boolean z16 = bVar.B;
        if (z16 || !bVar.f138570g) {
            if (z16) {
                synchronized (this.f130902j) {
                    if (this.f130911s.containsKey(bVar.f138564a) && (eVar = (e) this.f130911s.get(bVar.f138564a)) != null && eVar.a((Object[]) new Integer[]{4})) {
                        this.f130911s.remove(bVar.f138564a);
                    }
                }
            }
        } else if (this.f130897e.get()) {
            s();
        } else {
            o();
        }
        this.f130908p.put(bVar.f138564a, bVar);
        synchronized (this.f130902j) {
            this.f130913u.put(bVar.f138564a, Boolean.FALSE);
        }
        this.f130904l.m(bVar.f138564a);
        this.f130904l.m();
    }

    public void b(com.tencent.luggage.wxa.qb.b bVar) {
        if (bVar == null) {
            return;
        }
        int c16 = c(bVar.f138564a);
        int i3 = i();
        if (c16 <= 2000) {
            bVar.f138589z = false;
        }
        if (c16 >= 5000) {
            bVar.f138589z = true;
        } else if (i3 <= 5) {
            bVar.f138589z = false;
        } else {
            bVar.f138589z = true;
        }
        if (bVar.f138566c.contains("scale_intro")) {
            bVar.f138589z = false;
        }
    }

    public com.tencent.luggage.wxa.qb.d d(String str) {
        com.tencent.luggage.wxa.qb.d dVar;
        if (this.f130912t.containsKey(str)) {
            dVar = (com.tencent.luggage.wxa.qb.d) this.f130912t.get(str);
        } else {
            dVar = new com.tencent.luggage.wxa.qb.d();
            this.f130912t.put(str, dVar);
        }
        int c16 = c(str);
        int e16 = e(str);
        boolean k3 = k(str);
        int b16 = b(str);
        if (b16 < 0) {
            b16 = 0;
        }
        dVar.f138591b = e16;
        dVar.f138590a = c16;
        dVar.f138592c = !k3;
        dVar.f138593d = h(str);
        dVar.f138594e = (b16 * c16) / 100;
        if (!this.f130908p.containsKey(str)) {
            return null;
        }
        com.tencent.luggage.wxa.qb.b bVar = (com.tencent.luggage.wxa.qb.b) this.f130908p.get(str);
        dVar.f138596g = bVar.f138568e;
        dVar.f138595f = bVar.f138565b;
        dVar.f138597h = bVar.f138585v;
        return dVar;
    }

    public final void c(com.tencent.luggage.wxa.c9.b bVar) {
        com.tencent.luggage.wxa.c9.c b16;
        if (this.f130905m == null || !this.H || (b16 = com.tencent.luggage.wxa.d9.c.a().b()) == null) {
            return;
        }
        byte[] bArr = b16.f123417d;
        if (bArr == null || bArr.length < bVar.f123417d.length) {
            b16.f123417d = new byte[bVar.f123417d.length];
        }
        byte[] bArr2 = bVar.f123417d;
        System.arraycopy(bArr2, 0, b16.f123417d, 0, bArr2.length);
        this.G.post(new RunnableC6332d(b16));
    }

    public com.tencent.luggage.wxa.qb.b a(String str) {
        if (this.f130908p.containsKey(str)) {
            return (com.tencent.luggage.wxa.qb.b) this.f130908p.get(str);
        }
        return null;
    }

    public boolean a(String str, int i3) {
        return this.f130904l.a(str, i3, true);
    }

    public boolean a(String str, int i3, boolean z16) {
        return this.f130904l.a(str, i3, z16);
    }

    public void a(com.tencent.luggage.wxa.j9.b bVar) {
        this.f130905m = bVar;
    }

    public final void a(int i3) {
        com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioMixPlayerImpl", "onError, errCode:%d", Integer.valueOf(i3));
    }

    public void a(float f16, float f17) {
        try {
            AudioTrack audioTrack = this.f130896d;
            if (audioTrack != null) {
                audioTrack.setStereoVolume(f16, f17);
            }
        } catch (Exception e16) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioMixPlayerImpl", e16, "setVolume", new Object[0]);
        }
    }

    public void a(com.tencent.luggage.wxa.c9.b bVar) {
        if (this.f130899g.get()) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioMixPlayerImpl", "exit, not to add MixBuff queue");
            return;
        }
        synchronized (this.f130901i) {
            while (this.f130900h.size() >= 2 && !this.f130899g.get()) {
                try {
                    LockMethodProxy.wait(this.f130901i);
                } catch (InterruptedException e16) {
                    com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioMixPlayerImpl", e16, "enqueueMixBuffer", new Object[0]);
                }
            }
            this.f130900h.add(bVar);
            this.f130901i.notifyAll();
        }
    }

    public void a(int i3, String str) {
        a(i3, str, this.f130904l.b(str));
    }

    public void a(int i3, String str, String str2) {
        com.tencent.luggage.wxa.qb.b bVar = (com.tencent.luggage.wxa.qb.b) this.f130908p.get(str);
        if (bVar == null) {
            return;
        }
        com.tencent.luggage.wxa.p9.c cVar = new com.tencent.luggage.wxa.p9.c();
        c.a aVar = cVar.f137441d;
        aVar.f137444c = str;
        aVar.f137442a = i3;
        aVar.f137446e = bVar.f138577n;
        if (TextUtils.isEmpty(str2)) {
            str2 = bVar.f138565b;
        }
        c.a aVar2 = cVar.f137441d;
        aVar2.f137449h = str2;
        aVar2.f137445d = com.tencent.luggage.wxa.p9.c.a(i3);
        o oVar = this.f130906n;
        if (oVar != null) {
            oVar.a(cVar);
        }
    }

    public void a(int i3, String str, int i16, String str2) {
        com.tencent.luggage.wxa.qb.b bVar = (com.tencent.luggage.wxa.qb.b) this.f130908p.get(str);
        if (bVar == null) {
            return;
        }
        com.tencent.luggage.wxa.p9.c cVar = new com.tencent.luggage.wxa.p9.c();
        c.a aVar = cVar.f137441d;
        aVar.f137444c = str;
        aVar.f137442a = i3;
        aVar.f137446e = bVar.f138577n;
        aVar.f137447f = i16;
        aVar.f137448g = str2;
        aVar.f137445d = com.tencent.luggage.wxa.p9.c.a(i3);
        o oVar = this.f130906n;
        if (oVar != null) {
            oVar.a(cVar);
        }
    }

    public void a(g gVar) {
        this.f130907o = gVar;
    }
}
