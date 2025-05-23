package com.tencent.av.opengl.texture;

import android.graphics.Rect;
import android.opengl.GLES20;
import com.tencent.av.opengl.program.TextureProgram;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.WeakHashMap;
import pv.f;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: o, reason: collision with root package name */
    private static WeakHashMap<a, Object> f74090o = new WeakHashMap<>();

    /* renamed from: p, reason: collision with root package name */
    private static ThreadLocal<Class<a>> f74091p = new ThreadLocal<>();

    /* renamed from: a, reason: collision with root package name */
    protected int[] f74092a;

    /* renamed from: b, reason: collision with root package name */
    protected int[] f74093b;

    /* renamed from: c, reason: collision with root package name */
    protected int f74094c;

    /* renamed from: d, reason: collision with root package name */
    protected int f74095d;

    /* renamed from: e, reason: collision with root package name */
    protected int f74096e;

    /* renamed from: f, reason: collision with root package name */
    protected int f74097f;

    /* renamed from: g, reason: collision with root package name */
    protected int f74098g;

    /* renamed from: h, reason: collision with root package name */
    protected int f74099h;

    /* renamed from: i, reason: collision with root package name */
    protected int f74100i;

    /* renamed from: j, reason: collision with root package name */
    protected int f74101j;

    /* renamed from: k, reason: collision with root package name */
    protected int f74102k;

    /* renamed from: l, reason: collision with root package name */
    protected int f74103l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f74104m;

    /* renamed from: n, reason: collision with root package name */
    protected ov.a f74105n;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(ov.a aVar, int i3) {
        this.f74096e = 0;
        this.f74097f = 0;
        this.f74098g = -1;
        this.f74099h = -1;
        this.f74104m = false;
        this.f74105n = null;
        u(aVar);
        this.f74095d = i3;
        this.f74094c = 0;
        synchronized (f74090o) {
            f74090o.put(this, null);
        }
    }

    public static void B() {
        synchronized (f74090o) {
            Iterator<a> it = f74090o.keySet().iterator();
            while (it.hasNext()) {
                it.next().A();
            }
        }
    }

    private void b() {
        ov.a aVar = this.f74105n;
        if (aVar != null && this.f74092a != null) {
            aVar.d(this);
            this.f74092a = null;
        }
        this.f74095d = 0;
        u(null);
    }

    public static boolean m() {
        if (f74091p.get() != null) {
            return true;
        }
        return false;
    }

    public static void n() {
        synchronized (f74090o) {
            for (a aVar : f74090o.keySet()) {
                aVar.f74095d = 0;
                aVar.u(null);
            }
        }
    }

    public void A() {
        b();
    }

    public void a(ov.a aVar, int i3, int i16, int i17, int i18) {
        aVar.g(this, i3, i16, i17, i18);
    }

    public int[] c() {
        if (this.f74104m) {
            if (this.f74093b == null) {
                this.f74093b = new int[1];
            }
            return this.f74093b;
        }
        return this.f74092a;
    }

    public Rect d() {
        int i3 = this.f74096e;
        int i16 = this.f74097f;
        return new Rect(i3, i16, this.f74098g + i3, this.f74099h + i16);
    }

    public int e() {
        return this.f74099h;
    }

    public int f() {
        return this.f74098g;
    }

    protected void finalize() throws Throwable {
        try {
            f74091p.set(a.class);
            t();
            f74091p.set(null);
        } finally {
            super.finalize();
        }
    }

    public abstract int g();

    public int h() {
        return this.f74101j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TextureProgram i() {
        return f.b(this.f74094c);
    }

    public int j() {
        return this.f74100i;
    }

    public int k() {
        return this.f74103l;
    }

    public int l() {
        return this.f74102k;
    }

    public boolean o() {
        return false;
    }

    public boolean p() {
        if (this.f74095d == 1) {
            return true;
        }
        return false;
    }

    public abstract boolean q();

    public abstract boolean r(ov.a aVar);

    public qv.b[] s(ov.a aVar) {
        boolean z16;
        TextureProgram i3 = i();
        GLES20.glUseProgram(i3.b());
        tv.c.a();
        if (q() && aVar.getAlpha() >= 0.95f) {
            z16 = false;
        } else {
            z16 = true;
        }
        ov.b.x(z16);
        if (r(aVar)) {
            int[] c16 = c();
            for (int i16 = 0; c16 != null && i16 < c16.length; i16++) {
                GLES20.glActiveTexture(33984 + i16);
                tv.c.a();
                GLES20.glBindTexture(g(), c16[i16]);
                tv.c.a();
                GLES20.glUniform1i(i3.c()[i16 + 4].f429680a, i16);
                tv.c.a();
            }
        }
        GLES20.glUniform1f(i3.c()[2].f429680a, aVar.getAlpha());
        tv.c.a();
        return i3.c();
    }

    public void t() {
        b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u(ov.a aVar) {
        this.f74105n = aVar;
    }

    public void v(int i3, int i16, int i17, int i18) {
        this.f74096e = i3;
        this.f74097f = i16;
        this.f74098g = i17;
        this.f74099h = i18;
    }

    public void w(int i3, int i16) {
        this.f74098g = i3;
        this.f74099h = i16;
    }

    public void x(int i3, int i16) {
        this.f74100i = i3;
        this.f74101j = i16;
        if ((i3 > 4096 || i16 > 4096) && QLog.isColorLevel()) {
            QLog.w("BasicTexture", 2, String.format("texture is too large: %d x %d", Integer.valueOf(this.f74100i), Integer.valueOf(this.f74101j)), new Exception());
        }
        if (this.f74098g == -1) {
            this.f74098g = i3;
            this.f74099h = i16;
        }
    }

    public void y(int i3) {
        this.f74103l = i3;
    }

    public void z(int i3) {
        this.f74102k = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a() {
        this(null, 0);
    }
}
