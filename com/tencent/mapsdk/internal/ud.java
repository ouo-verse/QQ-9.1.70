package com.tencent.mapsdk.internal;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.ark.EGLContextHolder;
import com.tencent.map.lib.models.AccessibleTouchItem;
import com.tencent.mapsdk.internal.ua;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class ud extends ua implements bw, on, oy, ua.m {

    /* renamed from: j, reason: collision with root package name */
    private final tr f151246j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f151247k;

    /* renamed from: l, reason: collision with root package name */
    private Object f151248l;

    /* renamed from: m, reason: collision with root package name */
    private bf f151249m;

    public ud(bf bfVar) {
        super(bfVar.getContext());
        this.f151249m = bfVar;
        this.f151248l = bfVar.j();
        this.f151172g = bfVar.p();
        tr trVar = (tr) bfVar.b();
        this.f151246j = trVar;
        this.f151173h = trVar.f147934f;
        setEGLContextClientVersion(2);
        setPreserveEGLContextOnPause(true);
        setEGLConfigChooser(new ua.b(8, 16, 8));
        setEGLContextFactory(new AnonymousClass1());
        if (this.f151248l != null) {
            setEGLWindowSurfaceFactory(new AnonymousClass2());
        }
        a(this, this.f151249m.n());
        setRenderMode(0);
        setPreserveEGLContextOnPause(true);
        this.f151247k = true;
        setContentDescription(AccessibleTouchItem.MAP_DEFAULT_CONTENT_DESCRIPTION);
    }

    private void h() {
        setEGLContextClientVersion(2);
        setPreserveEGLContextOnPause(true);
        setEGLConfigChooser(new ua.b(8, 16, 8));
        setEGLContextFactory(new AnonymousClass1());
        if (this.f151248l != null) {
            setEGLWindowSurfaceFactory(new AnonymousClass2());
        }
    }

    private static boolean k(ua uaVar) {
        uaVar.setPreserveEGLContextOnPause(true);
        return true;
    }

    @Override // com.tencent.mapsdk.internal.bw
    public final void a(Object obj, int i3, int i16) {
    }

    @Override // com.tencent.mapsdk.internal.ua.m
    public final void ad() {
        tr trVar = this.f151246j;
        if (trVar != null) {
            trVar.ad();
        }
    }

    @Override // com.tencent.mapsdk.internal.ua, com.tencent.mapsdk.internal.bw
    public final void c() {
        super.c();
    }

    @Override // com.tencent.mapsdk.internal.bw
    public final void d() {
        if (getVisibility() == 0) {
            this.f151174i.c();
        }
    }

    @Override // android.view.View
    protected final boolean dispatchHoverEvent(MotionEvent motionEvent) {
        tr trVar = this.f151246j;
        if (trVar != null && trVar.a(motionEvent)) {
            return true;
        }
        return super.dispatchHoverEvent(motionEvent);
    }

    @Override // com.tencent.mapsdk.internal.bw
    public final boolean e() {
        return false;
    }

    @Override // com.tencent.mapsdk.internal.on
    public final void f() {
        setEGLContextClientVersion(2);
        setPreserveEGLContextOnPause(true);
        setEGLConfigChooser(new ua.b(8, 16, 8));
        setEGLContextFactory(new AnonymousClass1());
        if (this.f151248l != null) {
            setEGLWindowSurfaceFactory(new AnonymousClass2());
        }
        a(this, this.f151249m.n());
        setRenderMode(0);
        setPreserveEGLContextOnPause(true);
        this.f151247k = true;
    }

    @Override // com.tencent.mapsdk.internal.oy
    public final int getEGLContextHash() {
        tr trVar = this.f151246j;
        if (trVar != null) {
            return trVar.getEGLContextHash();
        }
        return 0;
    }

    public final bb getVectorMapDelegate() {
        return this.f151246j;
    }

    @Override // android.view.View, com.tencent.mapsdk.internal.bw
    public final void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        tr trVar = this.f151246j;
        if (trVar != null) {
            trVar.e(i3, i16);
        }
    }

    @Override // android.view.View, com.tencent.mapsdk.internal.bw
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // com.tencent.mapsdk.internal.ua, com.tencent.mapsdk.internal.bw
    public final void b() {
        if (this.f151247k) {
            super.b();
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.ud$2, reason: invalid class name */
    /* loaded from: classes9.dex */
    final class AnonymousClass2 implements ua.g {
        AnonymousClass2() {
        }

        @Override // com.tencent.mapsdk.internal.ua.g
        public final EGLSurface a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            EGLSurface eGLSurface = null;
            try {
                eGLSurface = egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, ud.this.f151248l, null);
            } catch (IllegalArgumentException | OutOfMemoryError unused) {
            }
            if (ud.this.f151246j != null) {
                ud.this.f151246j.E();
            }
            return eGLSurface;
        }

        @Override // com.tencent.mapsdk.internal.ua.g
        public final void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            if (ud.this.f151246j != null) {
                ud.this.f151246j.F();
            }
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }
    }

    @Override // com.tencent.mapsdk.internal.ua.m
    public final void a(GL10 gl10, EGLConfig eGLConfig) {
        tr trVar = this.f151246j;
        if (trVar != null) {
            trVar.a(gl10, eGLConfig);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.ud$1, reason: invalid class name */
    /* loaded from: classes9.dex */
    final class AnonymousClass1 implements ua.f {
        AnonymousClass1() {
        }

        @Override // com.tencent.mapsdk.internal.ua.f
        public final void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (ud.this.f151246j != null) {
                ud.this.f151246j.F();
            }
            EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
            egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            egl10.eglDestroyContext(eGLDisplay, eGLContext);
        }

        @Override // com.tencent.mapsdk.internal.ua.f
        public final EGLContext a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            EGLContext eglCreateContext = egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION, 2, 12344});
            if (ud.this.f151246j != null) {
                ud.this.f151246j.E();
            }
            return eglCreateContext;
        }
    }

    @Override // com.tencent.mapsdk.internal.ua.m
    public final void a(GL10 gl10, int i3, int i16) {
        tr trVar = this.f151246j;
        if (trVar != null) {
            trVar.a(gl10, i3, i16);
        }
    }

    @Override // com.tencent.mapsdk.internal.ua, com.tencent.mapsdk.internal.bw
    public final void a() {
        if (this.f151247k) {
            super.a();
        }
    }

    @Override // com.tencent.mapsdk.internal.ua.m
    public final boolean a(GL10 gl10) {
        tr trVar = this.f151246j;
        if (trVar == null) {
            return false;
        }
        return trVar.a(gl10);
    }

    @Override // com.tencent.mapsdk.internal.bw
    public final View getView() {
        return this;
    }

    @Override // com.tencent.mapsdk.internal.bw
    public final void setMapOpaque(boolean z16) {
    }
}
