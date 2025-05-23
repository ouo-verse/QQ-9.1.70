package com.xiaomi.push;

import android.os.SystemClock;
import android.util.Pair;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.am;
import java.io.Reader;
import java.io.Writer;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class ep {

    /* renamed from: r, reason: collision with root package name */
    private static final AtomicInteger f388760r = new AtomicInteger(0);

    /* renamed from: s, reason: collision with root package name */
    public static boolean f388761s;

    /* renamed from: n, reason: collision with root package name */
    protected eq f388775n;

    /* renamed from: o, reason: collision with root package name */
    protected XMPushService f388776o;

    /* renamed from: a, reason: collision with root package name */
    protected int f388762a = 0;

    /* renamed from: b, reason: collision with root package name */
    protected long f388763b = -1;

    /* renamed from: c, reason: collision with root package name */
    protected volatile long f388764c = 0;

    /* renamed from: d, reason: collision with root package name */
    protected volatile long f388765d = 0;

    /* renamed from: e, reason: collision with root package name */
    private LinkedList<Pair<Integer, Long>> f388766e = new LinkedList<>();

    /* renamed from: f, reason: collision with root package name */
    private final Collection<es> f388767f = new CopyOnWriteArrayList();

    /* renamed from: g, reason: collision with root package name */
    protected final Map<eu, a> f388768g = new ConcurrentHashMap();

    /* renamed from: h, reason: collision with root package name */
    protected final Map<eu, a> f388769h = new ConcurrentHashMap();

    /* renamed from: i, reason: collision with root package name */
    protected ew f388770i = null;

    /* renamed from: j, reason: collision with root package name */
    protected String f388771j = "";

    /* renamed from: k, reason: collision with root package name */
    protected String f388772k = "";

    /* renamed from: l, reason: collision with root package name */
    private int f388773l = 2;

    /* renamed from: m, reason: collision with root package name */
    protected final int f388774m = f388760r.getAndIncrement();

    /* renamed from: p, reason: collision with root package name */
    private long f388777p = 0;

    /* renamed from: q, reason: collision with root package name */
    protected long f388778q = 0;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private eu f388779a;

        /* renamed from: b, reason: collision with root package name */
        private ex f388780b;

        public a(eu euVar, ex exVar) {
            this.f388779a = euVar;
            this.f388780b = exVar;
        }

        public void a(eb ebVar) {
            this.f388779a.b(ebVar);
        }

        public void b(fc fcVar) {
            ex exVar = this.f388780b;
            if (exVar == null || exVar.mo300a(fcVar)) {
                this.f388779a.a(fcVar);
            }
        }
    }

    static {
        f388761s = false;
        try {
            f388761s = Boolean.getBoolean("smack.debugEnabled");
        } catch (Exception unused) {
        }
        ev.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ep(XMPushService xMPushService, eq eqVar) {
        this.f388775n = eqVar;
        this.f388776o = xMPushService;
        u();
    }

    private String e(int i3) {
        if (i3 == 1) {
            return "connected";
        }
        if (i3 == 0) {
            return "connecting";
        }
        if (i3 == 2) {
            return "disconnected";
        }
        return "unknown";
    }

    private void g(int i3) {
        synchronized (this.f388766e) {
            if (i3 == 1) {
                this.f388766e.clear();
            } else {
                this.f388766e.add(new Pair<>(Integer.valueOf(i3), Long.valueOf(System.currentTimeMillis())));
                if (this.f388766e.size() > 6) {
                    this.f388766e.remove(0);
                }
            }
        }
    }

    public abstract void A(boolean z16);

    public boolean B() {
        if (this.f388773l == 0) {
            return true;
        }
        return false;
    }

    public synchronized void C() {
        this.f388777p = SystemClock.elapsedRealtime();
    }

    public boolean D() {
        if (this.f388773l == 1) {
            return true;
        }
        return false;
    }

    public void E() {
        synchronized (this.f388766e) {
            this.f388766e.clear();
        }
    }

    public int a() {
        return this.f388762a;
    }

    public long b() {
        return this.f388765d;
    }

    public eq c() {
        return this.f388775n;
    }

    public String d() {
        return this.f388775n.k();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Map<eu, a> f() {
        return this.f388768g;
    }

    public void h(int i3, int i16, Exception exc) {
        Exception exc2;
        int i17 = this.f388773l;
        if (i3 != i17) {
            jz4.c.m(String.format("update the connection status. %1$s -> %2$s : %3$s ", e(i17), e(i3), com.xiaomi.push.service.r.a(i16)));
        }
        if (au.t(this.f388776o)) {
            g(i3);
        }
        if (i3 == 1) {
            this.f388776o.a(10);
            if (this.f388773l != 0) {
                jz4.c.m("try set connected while not connecting.");
            }
            this.f388773l = i3;
            Iterator<es> it = this.f388767f.iterator();
            while (it.hasNext()) {
                it.next().b(this);
            }
            return;
        }
        if (i3 == 0) {
            if (this.f388773l != 2) {
                jz4.c.m("try set connecting while not disconnected.");
            }
            this.f388773l = i3;
            Iterator<es> it5 = this.f388767f.iterator();
            while (it5.hasNext()) {
                it5.next().a(this);
            }
            return;
        }
        if (i3 == 2) {
            this.f388776o.a(10);
            int i18 = this.f388773l;
            if (i18 == 0) {
                for (es esVar : this.f388767f) {
                    if (exc == null) {
                        exc2 = new CancellationException("disconnect while connecting");
                    } else {
                        exc2 = exc;
                    }
                    esVar.a(this, exc2);
                }
            } else if (i18 == 1) {
                Iterator<es> it6 = this.f388767f.iterator();
                while (it6.hasNext()) {
                    it6.next().a(this, i16, exc);
                }
            }
            this.f388773l = i3;
        }
    }

    public void i(es esVar) {
        if (esVar != null && !this.f388767f.contains(esVar)) {
            this.f388767f.add(esVar);
        }
    }

    public void j(eu euVar) {
        this.f388768g.remove(euVar);
    }

    public void k(eu euVar, ex exVar) {
        if (euVar != null) {
            this.f388768g.put(euVar, new a(euVar, exVar));
            return;
        }
        throw new NullPointerException("Packet listener is null.");
    }

    public abstract void l(fc fcVar);

    public abstract void m(am.b bVar);

    public synchronized void n(String str) {
        if (this.f388773l == 0) {
            jz4.c.m("setChallenge hash = " + ad.b(str).substring(0, 8));
            this.f388771j = str;
            h(1, 0, null);
        } else {
            jz4.c.m("ignore setChallenge because connection was disconnected");
        }
    }

    public abstract void o(String str, String str2);

    public abstract void p(eb[] ebVarArr);

    public boolean q() {
        return false;
    }

    public synchronized boolean r(long j3) {
        boolean z16;
        if (this.f388777p >= j3) {
            z16 = true;
        } else {
            z16 = false;
        }
        return z16;
    }

    public int s() {
        return this.f388773l;
    }

    public String t() {
        return this.f388775n.i();
    }

    protected void u() {
        String str;
        if (this.f388775n.f() && this.f388770i == null) {
            Class<?> cls = null;
            try {
                str = System.getProperty("smack.debuggerClass");
            } catch (Throwable unused) {
                str = null;
            }
            if (str != null) {
                try {
                    cls = Class.forName(str);
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
            if (cls == null) {
                this.f388770i = new en(this);
                return;
            }
            try {
                this.f388770i = (ew) cls.getConstructor(ep.class, Writer.class, Reader.class).newInstance(this);
            } catch (Exception e17) {
                throw new IllegalArgumentException("Can't initialize the configured debugger!", e17);
            }
        }
    }

    public abstract void v(int i3, Exception exc);

    public abstract void w(eb ebVar);

    public void x(es esVar) {
        this.f388767f.remove(esVar);
    }

    public void y(eu euVar) {
        this.f388769h.remove(euVar);
    }

    public void z(eu euVar, ex exVar) {
        if (euVar != null) {
            this.f388769h.put(euVar, new a(euVar, exVar));
            return;
        }
        throw new NullPointerException("Packet listener is null.");
    }
}
