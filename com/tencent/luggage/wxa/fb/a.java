package com.tencent.luggage.wxa.fb;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import com.tencent.luggage.wxa.eb.d;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a implements GLSurfaceView.Renderer {

    /* renamed from: t, reason: collision with root package name */
    public static final C6204a f125592t = new C6204a(null);

    /* renamed from: a, reason: collision with root package name */
    public int f125593a;

    /* renamed from: b, reason: collision with root package name */
    public int f125594b;

    /* renamed from: c, reason: collision with root package name */
    public int f125595c;

    /* renamed from: d, reason: collision with root package name */
    public int f125596d;

    /* renamed from: e, reason: collision with root package name */
    public int f125597e;

    /* renamed from: f, reason: collision with root package name */
    public int f125598f;

    /* renamed from: g, reason: collision with root package name */
    public com.tencent.luggage.wxa.hb.a f125599g;

    /* renamed from: h, reason: collision with root package name */
    public byte[] f125600h;

    /* renamed from: i, reason: collision with root package name */
    public SurfaceTexture f125601i;

    /* renamed from: j, reason: collision with root package name */
    public d f125602j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f125603k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f125604l;

    /* renamed from: n, reason: collision with root package name */
    public int f125606n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f125607o;

    /* renamed from: q, reason: collision with root package name */
    public Function1 f125609q;

    /* renamed from: r, reason: collision with root package name */
    public Function0 f125610r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f125611s;

    /* renamed from: m, reason: collision with root package name */
    public int f125605m = -1;

    /* renamed from: p, reason: collision with root package name */
    public b f125608p = new b();

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.fb.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6204a {
        public C6204a() {
        }

        public /* synthetic */ C6204a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public long f125612a;

        /* renamed from: b, reason: collision with root package name */
        public int f125613b;

        /* renamed from: c, reason: collision with root package name */
        public long f125614c;

        /* renamed from: d, reason: collision with root package name */
        public long f125615d;

        /* renamed from: e, reason: collision with root package name */
        public long f125616e;

        public final void a() {
            this.f125613b++;
            this.f125612a += w0.e(this.f125614c);
            this.f125616e = w0.a();
        }

        public final void b() {
            long a16 = w0.a();
            this.f125614c = a16;
            if (this.f125615d == 0) {
                this.f125615d = a16;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements SurfaceTexture.OnFrameAvailableListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f125617a;

        public c(Function1 function1) {
            this.f125617a = function1;
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public final /* synthetic */ void onFrameAvailable(SurfaceTexture surfaceTexture) {
            this.f125617a.invoke(surfaceTexture);
        }
    }

    public a(int i3, int i16, int i17, int i18, int i19, int i26) {
        this.f125593a = i3;
        this.f125594b = i16;
        this.f125595c = i17;
        this.f125596d = i18;
        this.f125597e = i19;
        this.f125598f = i26;
    }

    public final void a(Function1 function1) {
        this.f125609q = function1;
    }

    public final void b() {
        this.f125602j = com.tencent.luggage.wxa.eb.c.a(false, 12L);
        GLES20.glFinish();
        d dVar = this.f125602j;
        if (dVar != null) {
            SurfaceTexture surfaceTexture = new SurfaceTexture(dVar.e());
            Function1 function1 = this.f125609q;
            surfaceTexture.setOnFrameAvailableListener(function1 != null ? new c(function1) : null);
            this.f125601i = surfaceTexture;
            d dVar2 = this.f125602j;
            if ((dVar2 != null ? dVar2.e() : -1) <= 0) {
                w.d("MicroMsg.Media.AbsSurfaceRenderer", "markCreateExternalTextureFailed");
                com.tencent.luggage.wxa.xm.b.INSTANCE.a(985L, 55L, 1L);
            }
            w.f("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " createSurfaceTexture:" + this.f125602j, new Object[0]);
        }
    }

    public abstract com.tencent.luggage.wxa.hb.a c();

    public final void c(int i3) {
        this.f125606n = i3;
    }

    public final boolean d() {
        return this.f125603k;
    }

    public final int e() {
        return this.f125596d;
    }

    public final int f() {
        return this.f125595c;
    }

    public d g() {
        return this.f125602j;
    }

    public final int h() {
        return this.f125597e;
    }

    public final int i() {
        return this.f125598f;
    }

    public final SurfaceTexture j() {
        return this.f125601i;
    }

    public d k() {
        return this.f125602j;
    }

    public SurfaceTexture l() {
        SurfaceTexture surfaceTexture;
        synchronized (this) {
            surfaceTexture = this.f125601i;
        }
        return surfaceTexture;
    }

    public final int m() {
        return this.f125594b;
    }

    public final int n() {
        return this.f125593a;
    }

    public final void o() {
        w.d("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " exec func initGLTextureRender  mirror : " + this.f125607o);
        a(this.f125595c, this.f125596d);
        b(this.f125593a, this.f125594b);
        b(this.f125606n);
        b(this.f125607o);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        if (this.f125603k) {
            w.d("MicroMsg.Media.AbsSurfaceRenderer", "do clear frame");
            this.f125603k = false;
            return;
        }
        if (this.f125600h == null && this.f125605m == -1) {
            w.b("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " there is no input ,do you dismiss setting input");
            return;
        }
        this.f125608p.b();
        p();
        this.f125608p.a();
        if (this.f125604l) {
            com.tencent.luggage.wxa.ib.a.f129678a.a(false);
        }
        Function0 function0 = this.f125610r;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i3, int i16) {
        w.d("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " onSurfaceChanged width:" + i3 + ", height:" + i16);
        a(i3, i16);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        w.d("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " onSurfaceCreated");
        com.tencent.luggage.wxa.jb.a.f130928a.a();
    }

    public void p() {
        com.tencent.luggage.wxa.hb.a aVar = this.f125599g;
        if (aVar != null) {
            aVar.r();
        }
    }

    public final void a(Function0 function0) {
        this.f125610r = function0;
    }

    public void c(boolean z16) {
        SurfaceTexture surfaceTexture;
        w.f("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " called release, shouldDestroySurfaceTexture: " + z16 + ", externalTextureObj:" + this.f125602j + ", surfaceTexture:" + this.f125601i, new Object[0]);
        com.tencent.luggage.wxa.hb.a aVar = this.f125599g;
        if (aVar != null) {
            aVar.q();
        }
        d dVar = this.f125602j;
        if (dVar != null) {
            dVar.close();
        }
        this.f125602j = null;
        GLES20.glFinish();
        if (z16 && (surfaceTexture = this.f125601i) != null) {
            surfaceTexture.release();
        }
        synchronized (this) {
            this.f125601i = null;
            Unit unit = Unit.INSTANCE;
        }
        this.f125611s = false;
    }

    public final void d(boolean z16) {
        this.f125603k = z16;
    }

    public void a(boolean z16) {
        if (this.f125611s) {
            w.f("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " initRenderProcInGlesThread, already init", new Object[0]);
            return;
        }
        this.f125604l = z16;
        this.f125599g = c();
        o();
        if (this.f125604l && (this.f125601i == null || this.f125605m <= 0)) {
            b();
            d dVar = this.f125602j;
            a(dVar != null ? dVar.e() : -1);
        }
        w.f("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " createSurfaceTexture:" + z16 + ", surfaceTexture:" + this.f125601i, new Object[0]);
        this.f125611s = true;
    }

    public void b(boolean z16) {
        w.d("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " set mirror: " + z16);
        this.f125607o = z16;
        com.tencent.luggage.wxa.hb.a aVar = this.f125599g;
        if (aVar != null) {
            aVar.a(z16);
        }
    }

    public final boolean a() {
        return this.f125611s;
    }

    public final void a(int i3) {
        this.f125605m = i3;
        com.tencent.luggage.wxa.hb.a aVar = this.f125599g;
        if (aVar != null) {
            aVar.a(i3);
        }
    }

    public void b(int i3, int i16) {
        w.f("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " updateTextureSize ,width : " + i3 + " , height : " + i16, new Object[0]);
        this.f125593a = i3;
        this.f125594b = i16;
        com.tencent.luggage.wxa.hb.a aVar = this.f125599g;
        if (aVar != null) {
            aVar.c(i3, i16);
        }
    }

    public static /* synthetic */ void a(a aVar, boolean z16, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: release");
        }
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        aVar.c(z16);
    }

    public void a(int i3, int i16) {
        w.f("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " updateDrawViewSize ,width : " + i3 + " , height : " + i16, new Object[0]);
        this.f125595c = i3;
        this.f125596d = i16;
        com.tencent.luggage.wxa.hb.a aVar = this.f125599g;
        if (aVar != null) {
            aVar.b(i3, i16);
        }
    }

    public void b(int i3) {
        w.f("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " change rotate ,old degree : " + this.f125606n + " , new degree : " + i3, new Object[0]);
        this.f125606n = i3;
        com.tencent.luggage.wxa.hb.a aVar = this.f125599g;
        if (aVar != null) {
            aVar.b(i3);
        }
    }
}
