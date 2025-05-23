package com.tencent.rfw.barrage.data;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;
import tz3.e;
import tz3.i;
import tz3.k;
import vz3.f;
import vz3.h;
import wz3.g;

/* compiled from: P */
/* loaded from: classes25.dex */
public abstract class a<DATA, CONFIG extends e> {
    private static final AtomicInteger F = new AtomicInteger();
    private DATA C;
    protected CONFIG D;
    private HashMap<String, Object> E;

    /* renamed from: a, reason: collision with root package name */
    protected i f365060a;

    /* renamed from: c, reason: collision with root package name */
    protected long f365062c;

    /* renamed from: d, reason: collision with root package name */
    protected f f365063d;

    /* renamed from: e, reason: collision with root package name */
    protected long f365064e;

    /* renamed from: g, reason: collision with root package name */
    protected int f365066g;

    /* renamed from: h, reason: collision with root package name */
    protected int f365067h;

    /* renamed from: k, reason: collision with root package name */
    protected float f365070k;

    /* renamed from: l, reason: collision with root package name */
    protected int f365071l;

    /* renamed from: m, reason: collision with root package name */
    protected boolean f365072m;

    /* renamed from: n, reason: collision with root package name */
    protected boolean f365073n;

    /* renamed from: o, reason: collision with root package name */
    protected Bitmap f365074o;

    /* renamed from: p, reason: collision with root package name */
    protected Canvas f365075p;

    /* renamed from: q, reason: collision with root package name */
    protected int f365076q;

    /* renamed from: s, reason: collision with root package name */
    protected int f365078s;

    /* renamed from: t, reason: collision with root package name */
    protected boolean f365079t;

    /* renamed from: u, reason: collision with root package name */
    protected boolean f365080u;

    /* renamed from: v, reason: collision with root package name */
    protected boolean f365081v;

    /* renamed from: x, reason: collision with root package name */
    protected b f365083x;

    /* renamed from: b, reason: collision with root package name */
    protected final int f365061b = F.incrementAndGet();

    /* renamed from: i, reason: collision with root package name */
    protected float f365068i = -1.0f;

    /* renamed from: j, reason: collision with root package name */
    protected float f365069j = -1.0f;

    /* renamed from: r, reason: collision with root package name */
    protected int f365077r = -1;

    /* renamed from: w, reason: collision with root package name */
    protected boolean f365082w = false;

    /* renamed from: y, reason: collision with root package name */
    private float f365084y = -1.0f;

    /* renamed from: z, reason: collision with root package name */
    private float f365085z = -1.0f;
    private volatile boolean A = true;
    private volatile boolean B = true;

    /* renamed from: f, reason: collision with root package name */
    protected final PriorityQueue<c> f365065f = new PriorityQueue<>();

    /* compiled from: P */
    /* renamed from: com.tencent.rfw.barrage.data.a$a, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public interface InterfaceC9740a {
        void recycle();
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface b {
        void a(a aVar);

        void b(a aVar);

        void c(a aVar);
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static final class c implements Comparable<c> {

        /* renamed from: d, reason: collision with root package name */
        public long f365086d;

        @Override // java.lang.Comparable
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int compareTo(c cVar) {
            if (cVar == null) {
                return 1;
            }
            long j3 = this.f365086d;
            long j16 = cVar.f365086d;
            if (j3 > j16) {
                return -1;
            }
            if (j3 < j16) {
                return 1;
            }
            return 0;
        }

        public String toString() {
            return "mRemainTime:" + this.f365086d;
        }
    }

    public a(i iVar) {
        this.f365060a = iVar;
        L();
        g0();
    }

    private void L() {
        try {
            this.D = (CONFIG) this.f365060a.g(J());
        } catch (Exception e16) {
            if (!g.b()) {
            } else {
                throw new RuntimeException("IDanmakuUIConfig should been provided by IDanmakuUIConfigCreator in DanmakuContext", e16);
            }
        }
    }

    private void e() {
        this.f365065f.clear();
        this.f365066g = 0;
        this.f365067h = 0;
        this.f365068i = -1.0f;
        this.f365069j = -1.0f;
        this.f365071l = 0;
        this.f365074o = null;
        this.f365076q = 0;
        this.f365078s = 0;
        this.f365079t = false;
        this.f365082w = false;
        this.A = true;
        this.B = true;
        this.f365084y = -1.0f;
        this.f365085z = -1.0f;
        this.f365080u = false;
        HashMap<String, Object> hashMap = this.E;
        if (hashMap != null) {
            for (Object obj : hashMap.values()) {
                if (obj instanceof InterfaceC9740a) {
                    ((InterfaceC9740a) obj).recycle();
                }
            }
            this.E.clear();
            this.E = null;
        }
    }

    public abstract float[] A(long j3);

    public void A0(long j3) {
        this.f365064e = j3;
    }

    public abstract long B(float f16);

    public void B0(boolean z16) {
        if (z16) {
            this.f365071l = 1;
        } else {
            this.f365071l = 0;
        }
    }

    public int C() {
        return this.f365076q;
    }

    public abstract float D();

    public int E() {
        return i.l().j();
    }

    public int F() {
        return i.l().k();
    }

    public abstract float G();

    public long H() {
        return this.f365064e;
    }

    public abstract float I();

    public abstract int J();

    public boolean K(float f16, float f17, float f18, long j3) {
        float[] A = A(j3);
        if (A == null || A[0] > f16 || f16 > A[2] + f18 || A[1] > f17 || f17 > A[3]) {
            return false;
        }
        return true;
    }

    public boolean M() {
        return i.l().n();
    }

    public boolean N() {
        return this.f365072m;
    }

    public boolean O() {
        return this.f365081v;
    }

    public boolean P() {
        return this.B;
    }

    public boolean Q() {
        if (this.f365073n && k.p()) {
            return true;
        }
        return false;
    }

    public boolean R(long j3) {
        long j16 = this.f365062c;
        if (j16 > 0 && j3 - j16 < 0) {
            return true;
        }
        return false;
    }

    public boolean S(long j3) {
        long j16 = this.f365062c;
        if (j16 > 0 && j3 - j16 >= this.f365063d.d()) {
            return true;
        }
        return false;
    }

    public boolean T() {
        return this.A;
    }

    public boolean U() {
        if (this.f365068i >= 0.0f && this.f365069j >= 0.0f && !T()) {
            return true;
        }
        return false;
    }

    public boolean V() {
        return this.f365080u;
    }

    public boolean W() {
        return this.f365079t;
    }

    public boolean X() {
        if (this.f365071l == 1) {
            return true;
        }
        return false;
    }

    public boolean Y(long j3) {
        if (this.f365080u || j3 - this.f365064e < this.f365063d.d()) {
            return false;
        }
        return true;
    }

    public void Z() {
        b bVar = this.f365083x;
        if (bVar != null) {
            bVar.b(this);
        }
    }

    public void a() {
        float t16 = t();
        if (!this.f365082w && t16 < F()) {
            b0();
            b bVar = this.f365083x;
            if (bVar != null) {
                bVar.a(this);
            }
            this.f365082w = true;
        }
        if (this.f365083x != null && t16 <= 0 - F()) {
            this.f365083x.c(this);
            this.f365083x = null;
        }
    }

    public vz3.e a0(h hVar) {
        return new vz3.e(-1);
    }

    public void b() {
        w0(false);
    }

    protected void b0() {
        i iVar = this.f365060a;
        if (iVar != null) {
            iVar.p(this);
        }
    }

    public void c() {
        r0(new f(i.l().d()));
        d();
    }

    public abstract void c0(float f16, float f17, long j3, long j16);

    public abstract void d0(long j3);

    public final void e0(long j3, long j16) {
        if (this.f365079t || this.f365072m) {
            this.f365062c += j3;
        }
        if (this.f365072m) {
            return;
        }
        d0(j16);
        if (!this.f365065f.isEmpty()) {
            Iterator<c> it = this.f365065f.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next != null) {
                    long j17 = next.f365086d - j3;
                    next.f365086d = j17;
                    if (j17 <= 0) {
                        it.remove();
                        throw null;
                    }
                }
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DATA data = this.C;
        DATA data2 = ((a) obj).C;
        if (data != null) {
            return data.equals(data2);
        }
        if (data2 == null) {
            return true;
        }
        return false;
    }

    public void f() {
        this.f365075p.setBitmap(null);
    }

    public boolean f0(int i3) {
        if (!V() && this.f365076q - i3 < 0) {
            return false;
        }
        this.f365076q -= i3;
        this.f365062c += i3;
        return true;
    }

    public abstract float g();

    public void g0() {
        k l3 = i.l();
        i0(l3.c());
        q0(l3.o());
        e();
        c();
    }

    public abstract float[] h(long j3);

    public void h0(boolean z16) {
        this.f365072m = z16;
    }

    public int hashCode() {
        DATA data = this.C;
        if (data == null) {
            return 0;
        }
        return data.hashCode();
    }

    public float i() {
        return t() + i.l().e();
    }

    public void i0(float f16) {
        this.f365070k = f16;
    }

    public float j() {
        return I() + v();
    }

    public void j0(float f16) {
        this.f365085z = f16;
    }

    public float k() {
        return this.f365084y;
    }

    public void k0(float f16) {
        this.f365084y = f16;
    }

    public DATA l() {
        return this.C;
    }

    public void l0(DATA data) {
        if (g.b() && data == null) {
            throw new RuntimeException("Danmaku data should been null");
        }
        this.C = data;
        p0(true);
    }

    public Bitmap m() {
        return this.f365074o;
    }

    public void m0(boolean z16) {
        this.f365081v = z16;
    }

    public Canvas n() {
        return this.f365075p;
    }

    public void n0(Bitmap bitmap) {
        this.f365074o = bitmap;
    }

    public long o() {
        return this.f365063d.d();
    }

    public void o0(Canvas canvas) {
        this.f365075p = canvas;
        p0(true);
    }

    public long p() {
        return this.f365062c + o();
    }

    public void p0(boolean z16) {
        this.B = z16;
    }

    public long q() {
        return this.f365062c;
    }

    public void q0(boolean z16) {
        this.f365073n = z16;
    }

    public int r(int i3) {
        int i16 = this.f365077r;
        if (i16 >= i3) {
            return i3 - 1;
        }
        return i16;
    }

    public void r0(f fVar) {
        this.f365063d = fVar;
    }

    public long s() {
        return this.f365061b;
    }

    public void s0(float f16) {
        this.f365063d.c(f16);
    }

    public abstract float t();

    public void t0(String str, Object obj) {
        if (this.E == null) {
            this.E = new HashMap<>();
        }
        this.E.put(str, obj);
    }

    public String toString() {
        return "BaseDanmaku" + this.f365061b + "[left:" + t() + ",top:" + I() + ",right:" + D() + ",bottom:" + g() + ", time:" + this.f365064e + ", mData=" + String.valueOf(this.C) + ", mType=" + J() + ", playerTime=" + this.f365060a.j() + "]";
    }

    public int u() {
        return this.f365066g;
    }

    public void u0(long j3) {
        this.f365062c = j3;
    }

    public int v() {
        return i.l().f();
    }

    public void v0(b bVar) {
        this.f365083x = bVar;
    }

    public int w() {
        return this.f365067h;
    }

    public void w0(boolean z16) {
        this.A = z16;
    }

    public float x() {
        return this.f365069j;
    }

    public void x0(boolean z16) {
        this.f365080u = z16;
    }

    public float y() {
        return this.f365068i;
    }

    public void y0(float f16) {
        this.f365069j = f16;
    }

    public int z(int i3) {
        int i16 = this.f365078s;
        if (i16 > i3) {
            return i3 - 1;
        }
        return i16;
    }

    public void z0(float f16) {
        this.f365068i = f16;
    }

    protected void d() {
    }
}
