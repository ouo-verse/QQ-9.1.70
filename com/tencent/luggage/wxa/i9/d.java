package com.tencent.luggage.wxa.i9;

import android.os.Process;
import android.text.TextUtils;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public i f129620a;

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.luggage.wxa.j9.d f129621b;

    /* renamed from: h, reason: collision with root package name */
    public Thread f129627h;

    /* renamed from: c, reason: collision with root package name */
    public AtomicBoolean f129622c = new AtomicBoolean(false);

    /* renamed from: d, reason: collision with root package name */
    public AtomicBoolean f129623d = new AtomicBoolean(false);

    /* renamed from: e, reason: collision with root package name */
    public AtomicBoolean f129624e = new AtomicBoolean(false);

    /* renamed from: f, reason: collision with root package name */
    public volatile HashMap f129625f = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    public Object f129626g = new Object();

    /* renamed from: i, reason: collision with root package name */
    public volatile LinkedList f129628i = new LinkedList();

    /* renamed from: j, reason: collision with root package name */
    public volatile HashMap f129629j = new HashMap();

    /* renamed from: k, reason: collision with root package name */
    public volatile HashMap f129630k = new HashMap();

    /* renamed from: l, reason: collision with root package name */
    public volatile HashMap f129631l = new HashMap();

    /* renamed from: m, reason: collision with root package name */
    public volatile HashMap f129632m = new HashMap();

    /* renamed from: n, reason: collision with root package name */
    public Object f129633n = new Object();

    /* renamed from: o, reason: collision with root package name */
    public List f129634o = new ArrayList();

    /* renamed from: p, reason: collision with root package name */
    public volatile HashMap f129635p = new HashMap();

    /* renamed from: q, reason: collision with root package name */
    public volatile HashMap f129636q = new HashMap();

    /* renamed from: r, reason: collision with root package name */
    public volatile HashMap f129637r = new HashMap();

    /* renamed from: s, reason: collision with root package name */
    public volatile HashMap f129638s = new HashMap();

    /* renamed from: t, reason: collision with root package name */
    public volatile LinkedList f129639t = new LinkedList();

    /* renamed from: u, reason: collision with root package name */
    public long f129640u = 0;

    /* renamed from: v, reason: collision with root package name */
    public boolean f129641v = false;

    /* renamed from: w, reason: collision with root package name */
    public int f129642w = 0;

    /* renamed from: x, reason: collision with root package name */
    public long f129643x = 0;

    /* renamed from: y, reason: collision with root package name */
    public long f129644y = 0;

    /* renamed from: z, reason: collision with root package name */
    public long f129645z = 0;
    public Runnable A = new a();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(-19);
            if (d.this.g()) {
                com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioMixController", "stop and exit");
                return;
            }
            while (!d.this.g()) {
                d.this.q();
                if (d.this.g()) {
                    return;
                }
                System.nanoTime();
                List n3 = d.this.n();
                if (n3.size() > 0) {
                    long nanoTime = System.nanoTime();
                    com.tencent.luggage.wxa.c9.b a16 = d.this.f129620a.a(n3);
                    long nanoTime2 = System.nanoTime();
                    d.b(d.this);
                    d.a(d.this, nanoTime2 - nanoTime);
                    if (a16 != null) {
                        d.this.a(a16);
                    }
                    d.this.a(n3);
                    n3.clear();
                }
            }
            com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioMixController", "mix thread stop and exit");
        }
    }

    public d(com.tencent.luggage.wxa.j9.d dVar) {
        this.f129621b = dVar;
    }

    public static /* synthetic */ int b(d dVar) {
        int i3 = dVar.f129642w;
        dVar.f129642w = i3 + 1;
        return i3;
    }

    public long c(String str) {
        synchronized (this.f129633n) {
            if (!this.f129638s.containsKey(str)) {
                return -1L;
            }
            Long l3 = (Long) this.f129638s.get(str);
            if (l3 == null) {
                return -1L;
            }
            return l3.longValue();
        }
    }

    public boolean d(String str) {
        if (!this.f129628i.contains(str)) {
            return true;
        }
        List list = (List) this.f129630k.get(str);
        if (list != null && list.size() != 0) {
            return false;
        }
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioMixController", "queue size is 0");
        return true;
    }

    public boolean e() {
        return this.f129624e.get();
    }

    public boolean f(String str) {
        synchronized (this.f129633n) {
            if (!this.f129631l.containsKey(str)) {
                return false;
            }
            return ((Boolean) this.f129631l.get(str)).booleanValue();
        }
    }

    public void g(String str) {
        if (this.f129640u > 0) {
            this.f129640u = 0L;
        }
        synchronized (this.f129633n) {
            this.f129624e.set(false);
            HashMap hashMap = this.f129625f;
            Boolean bool = Boolean.FALSE;
            hashMap.put(str, bool);
            if (!this.f129628i.contains(str)) {
                this.f129628i.add(str);
                this.f129630k.put(str, new ArrayList());
                this.f129629j.put(str, new Object());
                this.f129635p.put(str, bool);
            } else {
                com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioMixController", "The audio of the Id is mixing");
            }
            this.f129631l.put(str, bool);
            this.f129636q.put(str, bool);
            if (this.f129623d.get()) {
                this.f129623d.set(false);
            } else {
                this.f129634o.size();
            }
            h();
            i();
        }
    }

    public void h() {
        synchronized (this.f129626g) {
            try {
                this.f129626g.notify();
            } catch (Exception e16) {
                com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioMixController", e16, "notifyMix", new Object[0]);
            }
        }
    }

    public void i() {
        try {
            this.f129633n.notifyAll();
        } catch (Exception e16) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioMixController", e16, "notifySyncPcmData", new Object[0]);
        }
    }

    public void j() {
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioMixController", "onInit");
        o();
        this.f129630k.clear();
        e eVar = new e();
        this.f129620a = eVar;
        eVar.init();
    }

    public void k() {
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioMixController", "onRelease");
        c();
        a();
        this.f129620a.release();
    }

    public void l() {
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioMixController", "pauseMix");
        this.f129623d.set(true);
        int i3 = this.f129642w;
        if (i3 > 0) {
            long j3 = this.f129643x / i3;
            this.f129640u = j3;
            com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioMixController", "mixAverageTime:%d", Long.valueOf(j3));
        }
        this.f129644y = 0L;
        this.f129642w = 0;
        this.f129643x = 0L;
        this.f129645z = 0L;
    }

    public void m() {
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioMixController", "prepareMix");
        this.f129622c.set(false);
        this.f129623d.set(false);
        o();
        h();
    }

    public void n(String str) {
        this.f129625f.put(str, Boolean.TRUE);
        k(str);
        if (this.f129628i.isEmpty()) {
            com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioMixController", "stopMix isMute");
            this.f129624e.set(true);
            this.f129621b.a(0.0f, 0.0f);
            return;
        }
        this.f129624e.set(false);
    }

    public final void o() {
        if (this.f129627h == null) {
            BaseThread baseThread = new BaseThread(this.A, "audio_mix_controller");
            this.f129627h = baseThread;
            baseThread.start();
        }
    }

    public void p() {
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioMixController", "stopMix");
        this.f129622c.set(true);
        this.f129623d.set(false);
        h();
        synchronized (this.f129633n) {
            i();
        }
        b();
        c();
    }

    public void q() {
        synchronized (this.f129626g) {
            while (!g() && f()) {
                try {
                    com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioMixController", "waitMix");
                    LockMethodProxy.wait(this.f129626g);
                } catch (Exception e16) {
                    com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioMixController", e16, "waitMix", new Object[0]);
                }
            }
        }
    }

    public static /* synthetic */ long a(d dVar, long j3) {
        long j16 = dVar.f129643x + j3;
        dVar.f129643x = j16;
        return j16;
    }

    public void b(String str, boolean z16) {
        synchronized (this.f129633n) {
            this.f129635p.put(str, Boolean.valueOf(z16));
        }
    }

    public final boolean e(String str) {
        synchronized (this.f129633n) {
            return this.f129635p.containsKey(str) && ((Boolean) this.f129635p.get(str)).booleanValue();
        }
    }

    public void i(String str) {
        synchronized (this.f129633n) {
            if (this.f129631l.containsKey(str)) {
                this.f129631l.put(str, Boolean.TRUE);
            } else {
                com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioMixController", "The audio of the id is remove");
            }
        }
    }

    public final void a(String str, boolean z16) {
        synchronized (this.f129633n) {
            if (this.f129631l.containsKey(str)) {
                this.f129631l.put(str, Boolean.valueOf(z16));
            } else {
                com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioMixController", "The audio of the id is remove");
            }
        }
    }

    public final void b() {
        for (int i3 = 0; i3 < this.f129628i.size(); i3++) {
            ((List) this.f129630k.get(this.f129628i.get(i3))).clear();
        }
    }

    public long d() {
        return this.f129640u;
    }

    public final void h(String str) {
        this.f129621b.a(5, str);
        com.tencent.luggage.wxa.qb.b a16 = this.f129621b.a(str);
        if (a16 != null) {
            a16.f138569f = (int) c(str);
        }
        k(str);
    }

    public void k(String str) {
        synchronized (this.f129633n) {
            if (this.f129628i.contains(str)) {
                this.f129628i.remove(str);
                Object obj = this.f129629j.get(str);
                List list = (List) this.f129630k.remove(str);
                if (obj != null) {
                    synchronized (obj) {
                        a(list);
                        list.clear();
                    }
                } else {
                    a(list);
                    list.clear();
                }
                this.f129629j.remove(str);
                this.f129631l.remove(str);
                this.f129635p.remove(str);
                this.f129636q.remove(str);
                if (f()) {
                    i();
                }
                this.f129637r.remove(str);
                this.f129638s.remove(str);
            } else {
                com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioMixController", "The audio of the id is remove");
            }
        }
    }

    public boolean f() {
        return this.f129623d.get();
    }

    public void j(String str) {
        i(str);
    }

    public void m(String str) {
        g(str);
    }

    public String b(String str) {
        com.tencent.luggage.wxa.g9.c cVar;
        WeakReference weakReference = (WeakReference) this.f129632m.get(str);
        return (weakReference == null || weakReference.get() == null || (cVar = (com.tencent.luggage.wxa.g9.c) weakReference.get()) == null) ? "" : cVar.m();
    }

    public final void c() {
        if (this.f129627h != null) {
            this.f129627h = null;
        }
    }

    public List n() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.f129633n) {
            arrayList.addAll(this.f129628i);
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            String str = (String) arrayList.get(i3);
            if (!f(str)) {
                List list = (List) this.f129630k.get(str);
                if (list != null && list.size() != 0) {
                    com.tencent.luggage.wxa.g9.c a16 = a(str);
                    if (a16 != null) {
                        a16.e(list.size());
                    }
                    Object obj = this.f129629j.get(str);
                    if (obj == null) {
                        continue;
                    } else {
                        synchronized (obj) {
                            int size = list.size();
                            if (size > 0) {
                                com.tencent.luggage.wxa.c9.e eVar = null;
                                while (size > 0) {
                                    eVar = (com.tencent.luggage.wxa.c9.e) list.remove(size - 1);
                                    size--;
                                    if (!this.f129637r.containsKey(str) || ((Integer) this.f129637r.get(str)).intValue() <= eVar.f123438e) {
                                        break;
                                    }
                                    if (eVar.a()) {
                                        com.tencent.luggage.wxa.d9.d.a().a(eVar);
                                    }
                                }
                                if (eVar != null) {
                                    this.f129638s.put(str, Long.valueOf(eVar.f123438e));
                                    com.tencent.luggage.wxa.qb.b a17 = this.f129621b.a(str);
                                    if (a17 != null && a17.f138575l == 0.0d && !eVar.a()) {
                                        com.tencent.luggage.wxa.c9.e b16 = com.tencent.luggage.wxa.d9.d.a().b();
                                        if (b16 != null) {
                                            if (b16.f123439f == null) {
                                                b16.f123439f = new byte[3536];
                                            }
                                            b16.b();
                                            this.f129634o.add(b16);
                                        } else {
                                            this.f129634o.add(eVar);
                                        }
                                    } else if (a17 != null && a17.f138575l == 0.0d && eVar.a()) {
                                        eVar.b();
                                        this.f129634o.add(eVar);
                                    } else {
                                        this.f129634o.add(eVar);
                                    }
                                    this.f129639t.add(str);
                                } else if (a16 != null) {
                                    a16.e(list.size());
                                }
                            }
                        }
                    }
                } else if (e(str)) {
                    b(str, false);
                    h(str);
                }
            }
        }
        synchronized (this.f129633n) {
            if (this.f129634o.size() == 0 && !g()) {
                try {
                    com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioMixController", "wait read data");
                    LockMethodProxy.wait(this.f129633n);
                } catch (Exception e16) {
                    com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioMixController", e16, "readMixDataFromPcmTrack", new Object[0]);
                }
            }
        }
        return this.f129634o;
    }

    public boolean a(String str, int i3, boolean z16) {
        com.tencent.luggage.wxa.c9.e eVar;
        if (!this.f129628i.contains(str)) {
            return false;
        }
        if (i3 < 0) {
            this.f129637r.remove(str);
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (i3 == 0) {
            this.f129637r.remove(str);
        } else {
            this.f129637r.put(str, Integer.valueOf(i3));
        }
        List list = (List) this.f129630k.get(str);
        if (list != null && list.size() != 0) {
            com.tencent.luggage.wxa.qb.b a16 = this.f129621b.a(str);
            if (a16 == null) {
                this.f129637r.remove(str);
                return false;
            }
            com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioMixController", "seekTo begin");
            boolean f16 = f(str);
            if (!f16) {
                j(str);
            }
            int size = list.size();
            com.tencent.luggage.wxa.c9.d b16 = com.tencent.luggage.wxa.d9.f.c().b(a16.f138566c);
            int m3 = b16.m();
            int i16 = i3 / 20;
            int c16 = (int) (c(str) / 20);
            Object obj = this.f129629j.get(str);
            if (obj == null) {
                this.f129637r.remove(str);
                return false;
            }
            com.tencent.luggage.wxa.g9.c a17 = a(str);
            if (i16 > c16 && i16 <= m3) {
                com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioMixController", "seekTo seekToPos > currentPos");
                int i17 = i16 - c16;
                synchronized (obj) {
                    for (int i18 = 0; i18 < i17 && i18 < size; i18++) {
                        int size2 = list.size() - 1;
                        if (size2 >= 0 && (eVar = (com.tencent.luggage.wxa.c9.e) list.remove(size2)) != null && eVar.a()) {
                            com.tencent.luggage.wxa.d9.d.a().a(eVar);
                        }
                    }
                }
                if (a17 != null) {
                    a17.e(list.size());
                }
            } else if (i16 < c16 && c16 <= m3 && !z16) {
                com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioMixController", "seekTo seekToPos < currentPos, can't write queue");
                synchronized (obj) {
                    a(list);
                    list.clear();
                }
                if (a17 != null) {
                    a17.e(list.size());
                }
            } else if (i16 < c16 && c16 <= m3) {
                com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioMixController", "seekTo seekToPos < currentPos, can write queue");
                synchronized (obj) {
                    while (c16 > i16) {
                        com.tencent.luggage.wxa.c9.e a18 = b16.a(c16);
                        if (a18 != null) {
                            list.add(list.size(), a18);
                        }
                        c16--;
                    }
                }
            }
            if (!f16) {
                com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioMixController", "is not Pause");
                a(str, false);
                synchronized (this.f129633n) {
                    i();
                }
            }
            com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioMixController", "seekTo end, time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            return true;
        }
        this.f129637r.remove(str);
        return false;
    }

    public void l(String str) {
        WeakReference weakReference;
        if (!this.f129632m.containsKey(str) || (weakReference = (WeakReference) this.f129632m.remove(str)) == null || weakReference.get() == null) {
            return;
        }
        weakReference.clear();
    }

    public boolean g() {
        return this.f129622c.get();
    }

    public final com.tencent.luggage.wxa.g9.c a(String str) {
        WeakReference weakReference;
        if (!this.f129632m.containsKey(str) || (weakReference = (WeakReference) this.f129632m.get(str)) == null || weakReference.get() == null) {
            return null;
        }
        return (com.tencent.luggage.wxa.g9.c) weakReference.get();
    }

    public final void a(com.tencent.luggage.wxa.c9.b bVar) {
        bVar.f123418e.addAll(this.f129639t);
        this.f129639t.clear();
        this.f129621b.a(bVar);
    }

    public int a(String str, com.tencent.luggage.wxa.c9.e eVar, com.tencent.luggage.wxa.g9.c cVar) {
        if (eVar != null && !TextUtils.isEmpty(str) && eVar.f123439f != null) {
            Object obj = null;
            if (!this.f129630k.containsKey(str)) {
                com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioMixController", "queue not exist for audioId:%s", str);
                synchronized (this.f129633n) {
                    this.f129630k.put(str, new ArrayList());
                    if (!this.f129628i.contains(str)) {
                        this.f129628i.add(str);
                    }
                    if (!this.f129629j.containsKey(str)) {
                        obj = new Object();
                        this.f129629j.put(str, obj);
                    }
                }
            }
            if (obj == null) {
                if (!this.f129629j.containsKey(str)) {
                    synchronized (this.f129633n) {
                        if (!this.f129629j.containsKey(str)) {
                            obj = new Object();
                            this.f129629j.put(str, obj);
                        } else {
                            obj = this.f129629j.get(str);
                        }
                    }
                } else {
                    obj = this.f129629j.get(str);
                }
            }
            if (obj == null) {
                obj = new Object();
            }
            if (!this.f129632m.containsKey(str)) {
                this.f129632m.put(str, new WeakReference(cVar));
            }
            List list = (List) this.f129630k.get(str);
            synchronized (obj) {
                if (list == null) {
                    if (eVar.a()) {
                        com.tencent.luggage.wxa.d9.d.a().a(eVar);
                    }
                    return 0;
                }
                list.add(0, eVar);
                synchronized (this.f129633n) {
                    try {
                        this.f129633n.notifyAll();
                    } catch (Exception e16) {
                        com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioMixController", e16, "writePcmDataTrack", new Object[0]);
                    }
                }
                return list.size();
            }
        }
        com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioMixController", "track is invalid");
        return 0;
    }

    public void a() {
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioMixController", HippyReporter.RemoveEngineReason.CLEAR_CACHE);
        synchronized (this.f129633n) {
            b();
            this.f129629j.clear();
        }
    }

    public final void a(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            com.tencent.luggage.wxa.c9.e eVar = (com.tencent.luggage.wxa.c9.e) it.next();
            if (eVar != null && eVar.a()) {
                com.tencent.luggage.wxa.d9.d.a().a(eVar);
            }
        }
    }
}
