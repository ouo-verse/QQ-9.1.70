package com.tencent.common.danmaku.data;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.support.annotation.CallSuper;
import com.tencent.common.danmaku.inject.h;
import com.tencent.common.danmaku.inject.m;
import com.tencent.common.danmaku.tool.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class a<DATA, CONFIG extends h> {
    static IPatchRedirector $redirector_;
    private static final AtomicInteger C;
    protected CONFIG A;
    private HashMap<String, Object> B;

    /* renamed from: a, reason: collision with root package name */
    protected com.tencent.common.danmaku.inject.b f99664a;

    /* renamed from: b, reason: collision with root package name */
    protected final int f99665b;

    /* renamed from: c, reason: collision with root package name */
    protected long f99666c;

    /* renamed from: d, reason: collision with root package name */
    protected e f99667d;

    /* renamed from: e, reason: collision with root package name */
    protected long f99668e;

    /* renamed from: f, reason: collision with root package name */
    protected final PriorityQueue<b> f99669f;

    /* renamed from: g, reason: collision with root package name */
    protected int f99670g;

    /* renamed from: h, reason: collision with root package name */
    protected int f99671h;

    /* renamed from: i, reason: collision with root package name */
    protected float f99672i;

    /* renamed from: j, reason: collision with root package name */
    protected float f99673j;

    /* renamed from: k, reason: collision with root package name */
    protected int f99674k;

    /* renamed from: l, reason: collision with root package name */
    protected boolean f99675l;

    /* renamed from: m, reason: collision with root package name */
    protected Bitmap f99676m;

    /* renamed from: n, reason: collision with root package name */
    protected Canvas f99677n;

    /* renamed from: o, reason: collision with root package name */
    protected int f99678o;

    /* renamed from: p, reason: collision with root package name */
    protected int f99679p;

    /* renamed from: q, reason: collision with root package name */
    protected int f99680q;

    /* renamed from: r, reason: collision with root package name */
    protected boolean f99681r;

    /* renamed from: s, reason: collision with root package name */
    protected boolean f99682s;

    /* renamed from: t, reason: collision with root package name */
    protected boolean f99683t;

    /* renamed from: u, reason: collision with root package name */
    private float f99684u;

    /* renamed from: v, reason: collision with root package name */
    private float f99685v;

    /* renamed from: w, reason: collision with root package name */
    private volatile boolean f99686w;

    /* renamed from: x, reason: collision with root package name */
    private volatile boolean f99687x;

    /* renamed from: y, reason: collision with root package name */
    private int f99688y;

    /* renamed from: z, reason: collision with root package name */
    private DATA f99689z;

    /* compiled from: P */
    /* renamed from: com.tencent.common.danmaku.data.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1014a {
        void recycle();
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class b implements Comparable<b> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public long f99690d;

        @Override // java.lang.Comparable
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar)).intValue();
            }
            if (bVar == null) {
                return 1;
            }
            long j3 = this.f99690d;
            long j16 = bVar.f99690d;
            if (j3 > j16) {
                return -1;
            }
            if (j3 < j16) {
                return 1;
            }
            return 0;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return "mRemainTime:" + this.f99690d;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8232);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 90)) {
            redirector.redirect((short) 90);
        } else {
            C = new AtomicInteger();
        }
    }

    public a(com.tencent.common.danmaku.inject.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar);
            return;
        }
        this.f99665b = C.incrementAndGet();
        this.f99672i = -1.0f;
        this.f99673j = -1.0f;
        this.f99678o = 1000;
        this.f99679p = -1;
        this.f99683t = false;
        this.f99684u = -1.0f;
        this.f99685v = -1.0f;
        this.f99686w = true;
        this.f99687x = true;
        this.f99688y = 1;
        this.f99664a = bVar;
        this.f99669f = new PriorityQueue<>();
        L();
        e0();
    }

    private void L() {
        try {
            this.A = (CONFIG) this.f99664a.i(J());
        } catch (Exception e16) {
            if (!com.tencent.common.danmaku.a.b().a().isDebug()) {
            } else {
                throw new RuntimeException("IDanmakuUIConfig should been provided by IDanmakuUIConfigCreator in DanmakuContext", e16);
            }
        }
    }

    private void e() {
        this.f99669f.clear();
        this.f99670g = 0;
        this.f99671h = 0;
        this.f99672i = -1.0f;
        this.f99673j = -1.0f;
        this.f99674k = 0;
        this.f99676m = null;
        this.f99678o = 1000;
        this.f99680q = 0;
        this.f99681r = false;
        this.f99683t = false;
        this.f99686w = true;
        this.f99687x = true;
        this.f99684u = -1.0f;
        this.f99685v = -1.0f;
        this.f99682s = false;
        HashMap<String, Object> hashMap = this.B;
        if (hashMap != null) {
            for (Object obj : hashMap.values()) {
                if (obj instanceof InterfaceC1014a) {
                    ((InterfaceC1014a) obj).recycle();
                }
            }
            this.B.clear();
            this.B = null;
        }
    }

    public int A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 88)) {
            return ((Integer) iPatchRedirector.redirect((short) 88, (Object) this)).intValue();
        }
        return this.f99688y;
    }

    public abstract float[] B(long j3);

    public int C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            return ((Integer) iPatchRedirector.redirect((short) 60, (Object) this)).intValue();
        }
        return this.f99678o;
    }

    public abstract float D();

    public int E() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
            return ((Integer) iPatchRedirector.redirect((short) 66, (Object) this)).intValue();
        }
        return com.tencent.common.danmaku.inject.b.p().j();
    }

    public int F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            return ((Integer) iPatchRedirector.redirect((short) 65, (Object) this)).intValue();
        }
        return com.tencent.common.danmaku.inject.b.p().k();
    }

    public abstract float G();

    public long H() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return ((Long) iPatchRedirector.redirect((short) 43, (Object) this)).longValue();
        }
        return this.f99668e;
    }

    public abstract float I();

    public abstract int J();

    public boolean K(float f16, float f17, float f18, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return ((Boolean) iPatchRedirector.redirect((short) 36, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Long.valueOf(j3))).booleanValue();
        }
        float[] B = B(j3);
        if (B == null) {
            return false;
        }
        if (B[0] <= f16 && f16 <= B[2] + f18 && B[1] <= f17 && f17 <= B[3]) {
            return true;
        }
        return false;
    }

    public boolean M() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            return ((Boolean) iPatchRedirector.redirect((short) 62, (Object) this)).booleanValue();
        }
        return com.tencent.common.danmaku.inject.b.p().n();
    }

    public boolean N() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 71)) {
            return ((Boolean) iPatchRedirector.redirect((short) 71, (Object) this)).booleanValue();
        }
        return this.f99687x;
    }

    public boolean O() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 67)) {
            return ((Boolean) iPatchRedirector.redirect((short) 67, (Object) this)).booleanValue();
        }
        if (this.f99675l && m.p()) {
            return true;
        }
        return false;
    }

    public boolean P(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this, j3)).booleanValue();
        }
        long j16 = this.f99666c;
        if (j16 > 0 && j3 - j16 < 0) {
            return true;
        }
        return false;
    }

    public boolean Q(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this, j3)).booleanValue();
        }
        long j16 = this.f99666c;
        if (j16 > 0 && j3 - j16 >= this.f99667d.c()) {
            return true;
        }
        return false;
    }

    public boolean R() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 73)) {
            return ((Boolean) iPatchRedirector.redirect((short) 73, (Object) this)).booleanValue();
        }
        return this.f99686w;
    }

    public boolean S() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        if (this.f99672i >= 0.0f && this.f99673j >= 0.0f && !R()) {
            return true;
        }
        return false;
    }

    public boolean T() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 83)) {
            return ((Boolean) iPatchRedirector.redirect((short) 83, (Object) this)).booleanValue();
        }
        return this.f99682s;
    }

    public boolean U() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return this.f99681r;
    }

    public boolean V() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this)).booleanValue();
        }
        if (this.f99674k == 1) {
            return true;
        }
        return false;
    }

    public boolean W(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this, j3)).booleanValue();
        }
        if (this.f99682s || j3 - this.f99668e < this.f99667d.c()) {
            return false;
        }
        return true;
    }

    public com.tencent.common.danmaku.tool.b X(com.tencent.common.danmaku.tool.h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 86)) {
            return (com.tencent.common.danmaku.tool.b) iPatchRedirector.redirect((short) 86, (Object) this, (Object) hVar);
        }
        return new com.tencent.common.danmaku.tool.b(-1);
    }

    protected void Y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 87)) {
            iPatchRedirector.redirect((short) 87, (Object) this);
            return;
        }
        com.tencent.common.danmaku.inject.b bVar = this.f99664a;
        if (bVar != null) {
            bVar.u(this);
        }
    }

    public abstract void Z(float f16, float f17, long j3, long j16);

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        float t16 = t();
        if (!this.f99683t && t16 < F()) {
            com.tencent.common.danmaku.util.e.e("BaseDanmaku", "onFirstExposure, danmaku = ", this);
            Y();
            this.f99683t = true;
        }
    }

    public abstract void a0(long j3);

    @CallSuper
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
        } else {
            q0(false);
        }
    }

    public void b0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            this.f99681r = true;
        }
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            n0(new e(com.tencent.common.danmaku.inject.b.p().d()));
            d();
        }
    }

    public final void c0(long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, this, Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        if (this.f99681r) {
            this.f99666c += j3;
        }
        a0(j16);
        if (!this.f99669f.isEmpty()) {
            Iterator<b> it = this.f99669f.iterator();
            while (it.hasNext()) {
                b next = it.next();
                long j17 = next.f99690d - j3;
                next.f99690d = j17;
                if (j17 <= 0) {
                    it.remove();
                    throw null;
                }
            }
        }
    }

    protected void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    public boolean d0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Boolean) iPatchRedirector.redirect((short) 37, (Object) this, i3)).booleanValue();
        }
        if (!T() && this.f99678o - i3 < 0) {
            return false;
        }
        this.f99678o -= i3;
        this.f99666c += i3;
        return true;
    }

    @CallSuper
    public void e0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        m0(com.tencent.common.danmaku.inject.b.p().o());
        e();
        c();
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Boolean) iPatchRedirector.redirect((short) 39, (Object) this, obj)).booleanValue();
        }
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DATA data = this.f99689z;
        DATA data2 = ((a) obj).f99689z;
        if (data != null) {
            return data.equals(data2);
        }
        if (data2 == null) {
            return true;
        }
        return false;
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 77)) {
            iPatchRedirector.redirect((short) 77, (Object) this);
        } else {
            this.f99677n.setBitmap(null);
        }
    }

    public void f0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            this.f99681r = false;
        }
    }

    public abstract float g();

    public void g0(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Float.valueOf(f16));
        } else {
            this.f99685v = f16;
        }
    }

    public abstract float h(long j3);

    public void h0(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Float.valueOf(f16));
        } else {
            this.f99684u = f16;
        }
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return ((Integer) iPatchRedirector.redirect((short) 38, (Object) this)).intValue();
        }
        DATA data = this.f99689z;
        if (data == null) {
            return 0;
        }
        return data.hashCode();
    }

    public abstract float i(long j3);

    public void i0(DATA data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) data);
        } else {
            if (com.tencent.common.danmaku.a.b().a().isDebug() && data == null) {
                throw new RuntimeException("Danmaku data should been null");
            }
            this.f99689z = data;
            l0(true);
        }
    }

    public float j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            return ((Float) iPatchRedirector.redirect((short) 63, (Object) this)).floatValue();
        }
        return t() + com.tencent.common.danmaku.inject.b.p().e();
    }

    public void j0(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 70)) {
            iPatchRedirector.redirect((short) 70, (Object) this, (Object) bitmap);
        } else {
            this.f99676m = bitmap;
        }
    }

    public float k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            return ((Float) iPatchRedirector.redirect((short) 64, (Object) this)).floatValue();
        }
        return I() + v();
    }

    public void k0(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 76)) {
            iPatchRedirector.redirect((short) 76, (Object) this, (Object) canvas);
        } else {
            this.f99677n = canvas;
            l0(true);
        }
    }

    public DATA l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (DATA) iPatchRedirector.redirect((short) 31, (Object) this);
        }
        return this.f99689z;
    }

    public void l0(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 72)) {
            iPatchRedirector.redirect((short) 72, (Object) this, z16);
        } else {
            this.f99687x = z16;
        }
    }

    public Bitmap m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 69)) {
            return (Bitmap) iPatchRedirector.redirect((short) 69, (Object) this);
        }
        return this.f99676m;
    }

    public void m0(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 68)) {
            iPatchRedirector.redirect((short) 68, (Object) this, z16);
        } else {
            this.f99675l = z16;
        }
    }

    public Canvas n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 75)) {
            return (Canvas) iPatchRedirector.redirect((short) 75, (Object) this);
        }
        return this.f99677n;
    }

    public void n0(e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this, (Object) eVar);
        } else {
            this.f99667d = eVar;
        }
    }

    public long o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Long) iPatchRedirector.redirect((short) 17, (Object) this)).longValue();
        }
        return this.f99667d.c();
    }

    public void o0(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Float.valueOf(f16));
        } else {
            this.f99667d.b(f16);
        }
    }

    public long p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Long) iPatchRedirector.redirect((short) 19, (Object) this)).longValue();
        }
        return this.f99666c + o();
    }

    public void p0(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 84)) {
            iPatchRedirector.redirect((short) 84, (Object) this, j3);
        } else {
            this.f99666c = j3;
        }
    }

    public long q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 85)) {
            return ((Long) iPatchRedirector.redirect((short) 85, (Object) this)).longValue();
        }
        return this.f99666c;
    }

    public void q0(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 74)) {
            iPatchRedirector.redirect((short) 74, (Object) this, z16);
        } else {
            this.f99686w = z16;
        }
    }

    public int r(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 79)) {
            return ((Integer) iPatchRedirector.redirect((short) 79, (Object) this, i3)).intValue();
        }
        int i16 = this.f99679p;
        if (i16 >= i3) {
            return i3 - 1;
        }
        return i16;
    }

    public void r0(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 82)) {
            iPatchRedirector.redirect((short) 82, (Object) this, z16);
        } else {
            this.f99682s = z16;
        }
    }

    public long s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return ((Long) iPatchRedirector.redirect((short) 41, (Object) this)).longValue();
        }
        return this.f99665b;
    }

    public void s0(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            iPatchRedirector.redirect((short) 55, this, Float.valueOf(f16));
        } else {
            this.f99673j = f16;
        }
    }

    public abstract float t();

    public void t0(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            iPatchRedirector.redirect((short) 53, this, Float.valueOf(f16));
        } else {
            this.f99672i = f16;
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return (String) iPatchRedirector.redirect((short) 40, (Object) this);
        }
        return "BaseDanmaku" + this.f99665b + "[left:" + t() + ",top:" + I() + ",right:" + D() + ",bottom:" + g() + ", time:" + this.f99668e + ", mData=" + this.f99689z + ", mType=" + J() + ", playerTime=" + this.f99664a.n() + "]";
    }

    public int u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            return ((Integer) iPatchRedirector.redirect((short) 48, (Object) this)).intValue();
        }
        return this.f99670g;
    }

    public void u0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            iPatchRedirector.redirect((short) 61, (Object) this, i3);
        } else {
            this.f99678o = i3;
        }
    }

    public int v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            return ((Integer) iPatchRedirector.redirect((short) 56, (Object) this)).intValue();
        }
        return com.tencent.common.danmaku.inject.b.p().f();
    }

    public void v0(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this, j3);
        } else {
            this.f99668e = j3;
        }
    }

    public int w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            return ((Integer) iPatchRedirector.redirect((short) 50, (Object) this)).intValue();
        }
        return this.f99671h;
    }

    public void w0(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, z16);
        } else if (z16) {
            this.f99674k = 1;
        } else {
            this.f99674k = 0;
        }
    }

    public float x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            return ((Float) iPatchRedirector.redirect((short) 54, (Object) this)).floatValue();
        }
        return this.f99673j;
    }

    public float y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            return ((Float) iPatchRedirector.redirect((short) 52, (Object) this)).floatValue();
        }
        return this.f99672i;
    }

    public int z(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 78)) {
            return ((Integer) iPatchRedirector.redirect((short) 78, (Object) this, i3)).intValue();
        }
        int i16 = this.f99680q;
        if (i16 > i3) {
            return i3 - 1;
        }
        return i16;
    }
}
