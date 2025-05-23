package com.tencent.av.opengl.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.animation.Animation;
import com.tencent.av.ui.l;
import com.tencent.av.utils.ax;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b {
    protected float A;
    protected float B;
    protected float C;
    protected float D;

    /* renamed from: b, reason: collision with root package name */
    protected RenderBuffer f74119b;

    /* renamed from: g, reason: collision with root package name */
    protected GLRootView f74124g;

    /* renamed from: h, reason: collision with root package name */
    protected b f74125h;

    /* renamed from: p, reason: collision with root package name */
    protected com.tencent.av.opengl.texture.a f74133p;

    /* renamed from: t, reason: collision with root package name */
    private SparseArray<Object> f74137t;

    /* renamed from: v, reason: collision with root package name */
    protected Animation f74139v;

    /* renamed from: w, reason: collision with root package name */
    protected com.tencent.av.opengl.texture.a f74140w;

    /* renamed from: x, reason: collision with root package name */
    protected WeakReference<Context> f74141x;

    /* renamed from: y, reason: collision with root package name */
    protected a f74142y;

    /* renamed from: z, reason: collision with root package name */
    protected InterfaceC0740b f74143z;

    /* renamed from: a, reason: collision with root package name */
    protected boolean f74118a = false;

    /* renamed from: c, reason: collision with root package name */
    protected l f74120c = new l();

    /* renamed from: d, reason: collision with root package name */
    protected final Rect f74121d = new Rect(0, 0, 0, 0);

    /* renamed from: e, reason: collision with root package name */
    protected final Rect f74122e = new Rect(0, 0, 0, 0);

    /* renamed from: f, reason: collision with root package name */
    protected final Rect f74123f = new Rect(0, 0, 0, 0);

    /* renamed from: i, reason: collision with root package name */
    protected int f74126i = 0;

    /* renamed from: j, reason: collision with root package name */
    protected int f74127j = 0;

    /* renamed from: k, reason: collision with root package name */
    protected int f74128k = 0;

    /* renamed from: l, reason: collision with root package name */
    protected int f74129l = -1;

    /* renamed from: m, reason: collision with root package name */
    protected int f74130m = -1;

    /* renamed from: n, reason: collision with root package name */
    protected int f74131n = 0;

    /* renamed from: o, reason: collision with root package name */
    protected int f74132o = 0;

    /* renamed from: q, reason: collision with root package name */
    protected int f74134q = 0;

    /* renamed from: r, reason: collision with root package name */
    protected int f74135r = -16777216;

    /* renamed from: s, reason: collision with root package name */
    protected boolean f74136s = true;

    /* renamed from: u, reason: collision with root package name */
    protected int f74138u = 0;
    protected float E = 1.0f;
    protected float F = 1.0f;
    protected float G = 1.0f;
    protected List<sv.a> H = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface a {
        boolean a(b bVar, MotionEvent motionEvent);
    }

    /* compiled from: P */
    /* renamed from: com.tencent.av.opengl.ui.b$b, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0740b {
        void a(b bVar, int i3, int i16);
    }

    public b(Context context) {
        this.f74141x = new WeakReference<>(context);
    }

    public void A(Runnable runnable) {
        GLRootView g16 = g();
        if (g16 != null) {
            g16.post(runnable);
        }
    }

    public void B(Runnable runnable, long j3) {
        GLRootView g16 = g();
        if (g16 != null) {
            g16.postDelayed(runnable, j3);
        }
    }

    public void C(ov.a aVar) {
        sv.a aVar2;
        G(System.currentTimeMillis());
        Rect rect = this.f74121d;
        int i3 = rect.left;
        int i16 = rect.top;
        aVar.save();
        if (this.H.size() > 0) {
            aVar2 = this.H.get(0);
        } else {
            aVar2 = null;
        }
        if (aVar2 != null && aVar2.l()) {
            aVar.e(aVar2.g(), aVar2.h(), aVar2.i());
        } else {
            aVar.e(i3, i16, this.A);
        }
        if (aVar2 != null && aVar2.k()) {
            K(i3, i16, (int) (i3 + aVar2.e()), (int) (i16 + aVar2.f()));
        }
        aVar.e(n() / 2, h() / 2, 0.0f);
        if (aVar2 != null && aVar2.j()) {
            aVar.p(aVar2.b(), 1.0f, 0.0f, 0.0f);
            aVar.p(aVar2.c(), 0.0f, 1.0f, 0.0f);
            aVar.p(aVar2.d(), 0.0f, 0.0f, 1.0f);
        } else {
            float f16 = this.B;
            if (f16 != 0.0f) {
                aVar.p(f16, 1.0f, 0.0f, 0.0f);
            }
            float f17 = this.C;
            if (f17 != 0.0f) {
                aVar.p(f17, 0.0f, 1.0f, 0.0f);
            }
            float f18 = this.D;
            if (f18 != 0.0f) {
                aVar.p(f18, 0.0f, 0.0f, 1.0f);
            }
        }
        D(aVar);
        E(aVar);
        aVar.restore();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void D(ov.a aVar) {
        if (!this.f74136s) {
            return;
        }
        if (this.f74133p != null) {
            this.f74133p.a(aVar, 0, 0, n(), h());
        } else {
            aVar.l(0.0f, 0.0f, n(), h(), this.f74135r);
        }
    }

    protected void E(ov.a aVar) {
        if (this.f74140w == null) {
            return;
        }
        int n3 = n();
        int h16 = h();
        Rect k3 = k();
        int i3 = k3.left;
        int i16 = (n3 - i3) - k3.right;
        int i17 = k3.top;
        int i18 = (h16 - i17) - k3.bottom;
        aVar.f(2);
        this.f74140w.a(aVar, i3, i17, i16, i18);
        aVar.restore();
    }

    public void F() {
        this.f74126i |= 4;
        this.f74130m = -1;
        this.f74129l = -1;
        b bVar = this.f74125h;
        if (bVar != null) {
            bVar.F();
            return;
        }
        GLRootView g16 = g();
        if (g16 != null) {
            g16.d();
        }
    }

    public void G(long j3) {
        synchronized (this.H) {
            if (this.H.size() > 0) {
                p();
                int i3 = 0;
                while (i3 < this.H.size()) {
                    try {
                        if (this.H.get(i3).m(j3)) {
                            i3--;
                        }
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                    i3++;
                }
            }
        }
    }

    public void H(Bitmap bitmap) {
        com.tencent.av.opengl.texture.a aVar = this.f74133p;
        if (aVar != null) {
            aVar.t();
            this.f74133p = null;
        }
        if (bitmap != null) {
            this.f74133p = new com.tencent.av.opengl.texture.b(bitmap);
            this.f74134q = 0;
        }
    }

    public void I(int i3) {
        this.f74135r = i3;
    }

    public void J(com.tencent.av.opengl.texture.b bVar) {
        com.tencent.av.opengl.texture.a aVar = this.f74133p;
        if (aVar != null) {
            aVar.t();
            this.f74133p = null;
        }
        if (bVar != null) {
            this.f74133p = bVar;
            this.f74134q = 0;
        }
    }

    public boolean K(int i3, int i16, int i17, int i18) {
        boolean z16;
        int i19 = i17 - i3;
        Rect rect = this.f74121d;
        if (i19 == rect.right - rect.left && i18 - i16 == rect.bottom - rect.top) {
            z16 = false;
        } else {
            z16 = true;
        }
        rect.set(i3, i16, i17, i18);
        return z16;
    }

    public void L(boolean z16) {
        this.f74118a = z16;
    }

    public void M(a aVar) {
        this.f74142y = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void N(InterfaceC0740b interfaceC0740b) {
        this.f74143z = interfaceC0740b;
    }

    public void O(int i3, int i16, int i17, int i18) {
        this.f74123f.set(i3, i16, i17, i18);
    }

    public void Q(int i3, Object obj) {
        if (this.f74137t == null) {
            this.f74137t = new SparseArray<>();
        }
        this.f74137t.put(i3, obj);
    }

    public void R(int i3) {
        if (i3 == m()) {
            return;
        }
        if (i3 == 0) {
            this.f74126i &= -2;
        } else {
            this.f74126i |= 1;
        }
        z(i3);
        p();
    }

    public void S(int i3) {
        int i16 = this.f74138u;
        if (i16 != i3) {
            this.f74138u = i3;
            InterfaceC0740b interfaceC0740b = this.f74143z;
            if (interfaceC0740b != null) {
                interfaceC0740b.a(this, i3, i16);
            }
        }
    }

    public void T(sv.a aVar) {
        synchronized (this.H) {
            if (aVar != null) {
                aVar.t(this);
                aVar.u();
                this.H.add(aVar);
                p();
            }
        }
    }

    public void a(GLRootView gLRootView) {
        r(gLRootView);
    }

    public boolean b() {
        if (m() != 0 && this.f74139v == null) {
            return false;
        }
        return true;
    }

    public void c() {
        s();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean d(MotionEvent motionEvent) {
        a aVar;
        if (m() == 0 && (aVar = this.f74142y) != null && aVar.a(this, motionEvent)) {
            return true;
        }
        return y(motionEvent);
    }

    public void e(boolean z16) {
        if (!ax.c()) {
            return;
        }
        this.f74136s = z16;
    }

    public Rect f() {
        return this.f74121d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            com.tencent.av.opengl.texture.a aVar = this.f74140w;
            if (aVar != null) {
                aVar.t();
                this.f74140w = null;
            }
            com.tencent.av.opengl.texture.a aVar2 = this.f74133p;
            if (aVar2 != null) {
                aVar2.t();
                this.f74133p = null;
                this.f74134q = 0;
            }
            RenderBuffer renderBuffer = this.f74119b;
            if (renderBuffer != null) {
                renderBuffer.destroy();
                this.f74119b = null;
            }
            s();
            SparseArray<Object> sparseArray = this.f74137t;
            if (sparseArray != null) {
                sparseArray.clear();
            }
            this.f74139v = null;
            this.f74142y = null;
            this.f74143z = null;
        } finally {
            super.finalize();
        }
    }

    public GLRootView g() {
        return this.f74124g;
    }

    public int h() {
        Rect rect = this.f74121d;
        return rect.bottom - rect.top;
    }

    public boolean i() {
        return this.f74118a;
    }

    public List<sv.a> j() {
        return this.H;
    }

    public Rect k() {
        return this.f74123f;
    }

    public Object l(int i3) {
        SparseArray<Object> sparseArray = this.f74137t;
        if (sparseArray != null) {
            return sparseArray.get(i3);
        }
        return null;
    }

    public int m() {
        if ((this.f74126i & 1) != 0) {
            return 1;
        }
        return 0;
    }

    public int n() {
        Rect rect = this.f74121d;
        return rect.right - rect.left;
    }

    public int o() {
        return this.f74138u;
    }

    public void p() {
        GLRootView g16 = g();
        if (g16 != null) {
            g16.requestRender();
        }
    }

    @SuppressLint({"WrongCall"})
    public void q(int i3, int i16, int i17, int i18) {
        boolean K = K(i3, i16, i17, i18);
        this.f74126i &= -5;
        u(K, i3, i16, i17, i18);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void r(GLRootView gLRootView) {
        this.f74124g = gLRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s() {
        this.f74124g = null;
    }

    protected boolean y(MotionEvent motionEvent) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void t() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void w() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void x() {
    }

    public void P(int i3) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void z(int i3) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v(int i3, int i16) {
    }

    protected void u(boolean z16, int i3, int i16, int i17, int i18) {
    }
}
