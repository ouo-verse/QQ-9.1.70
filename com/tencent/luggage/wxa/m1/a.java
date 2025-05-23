package com.tencent.luggage.wxa.m1;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.os.HandlerThread;
import com.tencent.ark.EGLContextHolder;
import com.tencent.luggage.wxa.cq.d;
import com.tencent.luggage.wxa.l1.i;
import com.tencent.luggage.wxa.m1.c;
import com.tencent.luggage.wxa.tn.b0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.qfsmonet.gles.MonetEGL14Define$EGLQueryAttribute;
import org.tencwebrtc.EglBase;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a extends i {

    /* renamed from: l, reason: collision with root package name */
    public b0 f134026l;

    /* renamed from: m, reason: collision with root package name */
    public com.tencent.luggage.wxa.m1.c f134027m;

    /* renamed from: o, reason: collision with root package name */
    public int f134029o;

    /* renamed from: p, reason: collision with root package name */
    public int f134030p;

    /* renamed from: q, reason: collision with root package name */
    public int f134031q;

    /* renamed from: r, reason: collision with root package name */
    public int f134032r;

    /* renamed from: s, reason: collision with root package name */
    public int f134033s;

    /* renamed from: j, reason: collision with root package name */
    public final String f134024j = "MicroMsg.SameLayerYUVDateRenderToRBGBufferThread";

    /* renamed from: k, reason: collision with root package name */
    public HandlerThread f134025k = d.d("SameLayerYUVDateRenderToRBGBufferThread", 5);

    /* renamed from: n, reason: collision with root package name */
    public c.a f134028n = null;

    /* renamed from: t, reason: collision with root package name */
    public boolean f134034t = false;

    /* renamed from: u, reason: collision with root package name */
    public int[] f134035u = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, EglBase.EGL_RECORDABLE_ANDROID, 1, 12344};

    /* renamed from: v, reason: collision with root package name */
    public EGLDisplay f134036v = null;

    /* renamed from: w, reason: collision with root package name */
    public EGLSurface f134037w = null;

    /* renamed from: x, reason: collision with root package name */
    public EGLContext f134038x = null;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.m1.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC6455a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EGLContext f134039a;

        public RunnableC6455a(EGLContext eGLContext) {
            this.f134039a = eGLContext;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            aVar.a(this.f134039a, aVar.f134029o, a.this.f134030p);
            a aVar2 = a.this;
            aVar2.a(aVar2.f134029o, a.this.f134030p, a.this.f134032r, a.this.f134033s);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ byte[] f134041a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f134042b;

        public b(byte[] bArr, int i3) {
            this.f134041a = bArr;
            this.f134042b = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f134027m.a(this.f134041a, a.this.f134029o, a.this.f134030p, a.this.f134031q, this.f134042b);
            a.this.f134027m.onDrawFrame(null);
            a.this.f134028n.b();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f134027m.b();
            EGLDisplay eGLDisplay = a.this.f134036v;
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            if (a.this.f134037w != null && a.this.f134038x != null && a.this.f134036v != null) {
                EGL14.eglDestroySurface(a.this.f134036v, a.this.f134037w);
                EGL14.eglDestroyContext(a.this.f134036v, a.this.f134038x);
                EGL14.eglReleaseThread();
                EGL14.eglTerminate(a.this.f134036v);
                a.this.f134038x = null;
                a.this.f134036v = null;
                a.this.f134037w = null;
            }
            a.this.f134026l.a((Object) null);
            a.this.f134025k.quitSafely();
        }
    }

    public void a(EGLContext eGLContext) {
        w.a("MicroMsg.SameLayerYUVDateRenderToRBGBufferThread", "start context : " + eGLContext + "  hasStart : " + this.f134034t);
        if (this.f134034t || eGLContext == null) {
            return;
        }
        this.f134034t = true;
        this.f134025k.start();
        this.f134026l = new b0(this.f134025k.getLooper());
        a(new RunnableC6455a(eGLContext));
    }

    public final void a(int i3, int i16, int i17, int i18) {
        com.tencent.luggage.wxa.m1.c cVar = new com.tencent.luggage.wxa.m1.c(i3, i16, i17, i18);
        this.f134027m = cVar;
        cVar.onSurfaceCreated(null, null);
        this.f134027m.onSurfaceChanged(null, i17, i18);
        c.a aVar = this.f134028n;
        if (aVar != null) {
            this.f134027m.a(aVar.a());
        }
    }

    public void a(byte[] bArr, int i3) {
        if (this.f134034t || this.f134027m != null) {
            a(new b(bArr, i3));
        }
    }

    public void a(c.a aVar) {
        this.f134028n = aVar;
    }

    public void a(int i3, int i16, int i17, int i18, int i19) {
        w.d("MicroMsg.SameLayerYUVDateRenderToRBGBufferThread", "setFrameInfo, width: %s, height: %s, rotate: %s ,targetWidth:%d ,targetHeight:%d , this: %s ", Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), this);
        if (i3 != this.f134029o || i16 != this.f134030p || i17 != this.f134031q) {
            this.f134029o = i3;
            this.f134030p = i16;
            this.f134031q = i17;
        }
        this.f134032r = i18;
        this.f134033s = i19;
    }

    private void a(Runnable runnable) {
        if (this.f134025k.isAlive()) {
            this.f134026l.a(runnable);
        }
    }

    @Override // com.tencent.luggage.wxa.l1.i
    public void a() {
        a(new c());
    }

    public final void a(EGLContext eGLContext, int i3, int i16) {
        EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
        this.f134036v = eglGetDisplay;
        if (eglGetDisplay != EGL14.EGL_NO_DISPLAY) {
            int[] iArr = new int[2];
            if (EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                EGL14.eglChooseConfig(this.f134036v, this.f134035u, 0, eGLConfigArr, 0, 1, new int[1], 0);
                EGLConfig eGLConfig = eGLConfigArr[0];
                if (eGLConfig != null) {
                    EGLContext eglCreateContext = EGL14.eglCreateContext(this.f134036v, eGLConfig, eGLContext, new int[]{EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION, 2, 12344}, 0);
                    this.f134038x = eglCreateContext;
                    if (eglCreateContext != EGL14.EGL_NO_CONTEXT) {
                        a("eglCreateContext");
                        int[] iArr2 = {MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_WIDTH, i3, MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_HEIGHT, i16, 12344};
                        this.f134037w = null;
                        try {
                            this.f134037w = EGL14.eglCreatePbufferSurface(this.f134036v, eGLConfigArr[0], iArr2, 0);
                        } catch (IllegalArgumentException e16) {
                            w.b("MicroMsg.SameLayerYUVDateRenderToRBGBufferThread", "eglCreateWindowSurface", e16);
                        }
                        a("eglCreatePbufferSurface");
                        EGLSurface eGLSurface = this.f134037w;
                        if ((eGLSurface == null || eGLSurface == EGL14.EGL_NO_SURFACE) && EGL14.eglGetError() == 12299) {
                            w.b("MicroMsg.SameLayerYUVDateRenderToRBGBufferThread", "makeMyEGLCurrentSurface:returned EGL_BAD_NATIVE_WINDOW.");
                        }
                        EGLDisplay eGLDisplay = this.f134036v;
                        EGLSurface eGLSurface2 = this.f134037w;
                        if (EGL14.eglMakeCurrent(eGLDisplay, eGLSurface2, eGLSurface2, this.f134038x)) {
                            return;
                        }
                        w.f("MicroMsg.SameLayerYUVDateRenderToRBGBufferThread", "eglMakeCurrent:" + EGL14.eglGetError());
                        return;
                    }
                    throw new RuntimeException("EGL error " + EGL14.eglGetError());
                }
                throw new RuntimeException("chooseConfig failed");
            }
            this.f134036v = null;
            throw new RuntimeException("eglInitialize failed");
        }
        throw new RuntimeException("unable to get EGL14 display");
    }

    public final boolean a(String str) {
        int eglGetError = EGL14.eglGetError();
        if (eglGetError == 12288) {
            return false;
        }
        w.f("MicroMsg.SameLayerYUVDateRenderToRBGBufferThread", str + ": EGL error: 0x" + Integer.toHexString(eglGetError), new Object[0]);
        return true;
    }
}
