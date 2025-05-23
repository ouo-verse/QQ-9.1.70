package com.tencent.mapsdk.internal;

import android.annotation.TargetApi;
import android.opengl.GLUtils;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.mapsdk.internal.lb;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class tq extends BaseThread {

    /* renamed from: e, reason: collision with root package name */
    private static float f150997e = 60.0f;

    /* renamed from: n, reason: collision with root package name */
    private static final int f150998n = 12440;

    /* renamed from: o, reason: collision with root package name */
    private static final int f150999o = 4;

    /* renamed from: q, reason: collision with root package name */
    private static int f151000q = 2000;

    /* renamed from: t, reason: collision with root package name */
    private static long f151001t = 1500;

    /* renamed from: u, reason: collision with root package name */
    private static final String f151002u = "TextureGLRenderThread";

    /* renamed from: a, reason: collision with root package name */
    public boolean f151003a;

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<tr> f151004b;

    /* renamed from: f, reason: collision with root package name */
    private WeakReference<Object> f151007f;

    /* renamed from: i, reason: collision with root package name */
    private EGL10 f151010i;

    /* renamed from: m, reason: collision with root package name */
    private GL f151014m;

    /* renamed from: p, reason: collision with root package name */
    private long f151015p;

    /* renamed from: c, reason: collision with root package name */
    private AtomicBoolean f151005c = new AtomicBoolean(true);

    /* renamed from: d, reason: collision with root package name */
    private AtomicBoolean f151006d = new AtomicBoolean(false);

    /* renamed from: g, reason: collision with root package name */
    private volatile boolean f151008g = false;

    /* renamed from: h, reason: collision with root package name */
    private EGLConfig f151009h = null;

    /* renamed from: j, reason: collision with root package name */
    private EGLDisplay f151011j = EGL10.EGL_NO_DISPLAY;

    /* renamed from: k, reason: collision with root package name */
    private EGLContext f151012k = EGL10.EGL_NO_CONTEXT;

    /* renamed from: l, reason: collision with root package name */
    private EGLSurface f151013l = EGL10.EGL_NO_SURFACE;

    /* renamed from: r, reason: collision with root package name */
    private volatile long f151016r = 0;

    /* renamed from: s, reason: collision with root package name */
    private boolean f151017s = false;

    public tq(tr trVar) {
        this.f151004b = new WeakReference<>(trVar);
        setName(ua.a("TR"));
        LogUtil.a(e()).c(lb.a.f149160g, ua.a("TR") + " create");
    }

    private int e() {
        WeakReference<tr> weakReference = this.f151004b;
        if (weakReference != null && weakReference.get() != null) {
            return this.f151004b.get().f147934f;
        }
        return -1;
    }

    @TargetApi(14)
    private boolean f() {
        WeakReference<Object> weakReference;
        int[] iArr;
        try {
            weakReference = this.f151007f;
        } catch (Throwable th5) {
            LogUtil.d(f151002u, "initializeGLContext failed,errorDetail:" + Log.getStackTraceString(th5));
        }
        if (weakReference != null && weakReference.get() != null) {
            Object obj = this.f151007f.get();
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            this.f151010i = egl10;
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.f151011j = eglGetDisplay;
            if (eglGetDisplay == EGL10.EGL_NO_DISPLAY) {
                LogUtil.d(f151002u, "eglGetdisplay failed,mEglDisplay == EGL10.EGL_NO_DISPLAY,errorDetail:" + GLUtils.getEGLErrorString(this.f151010i.eglGetError()));
                return false;
            }
            if (!this.f151010i.eglInitialize(eglGetDisplay, new int[2])) {
                LogUtil.d(f151002u, "eglInitialize failed,errorDetail:" + GLUtils.getEGLErrorString(this.f151010i.eglGetError()));
                return false;
            }
            if (this.f151003a) {
                iArr = new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 16, 12326, 8, 12338, 1, 12337, 4, 12352, 4, 12344};
            } else {
                iArr = new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 16, 12326, 8, 12352, 4, 12344};
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            if (!this.f151010i.eglChooseConfig(this.f151011j, iArr, eGLConfigArr, 1, new int[1])) {
                LogUtil.d(f151002u, "eglChooseConfig failed,errorDetail:" + GLUtils.getEGLErrorString(this.f151010i.eglGetError()));
                return false;
            }
            EGLConfig eGLConfig = eGLConfigArr[0];
            this.f151009h = eGLConfig;
            EGLSurface eglCreateWindowSurface = this.f151010i.eglCreateWindowSurface(this.f151011j, eGLConfig, obj, null);
            this.f151013l = eglCreateWindowSurface;
            if (eglCreateWindowSurface == EGL10.EGL_NO_SURFACE) {
                LogUtil.d(f151002u, "eglCreateWindowSurface failed,mEglSurface == EGL10.EGL_NO_SURFACE,errorDetail:" + GLUtils.getEGLErrorString(this.f151010i.eglGetError()));
                return false;
            }
            EGLContext eglCreateContext = this.f151010i.eglCreateContext(this.f151011j, eGLConfigArr[0], EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
            this.f151012k = eglCreateContext;
            if (eglCreateContext == EGL10.EGL_NO_CONTEXT) {
                LogUtil.d(f151002u, "eglCreateContext failed,mEglContext == EGL10.EGL_NO_CONTEXT,errorDetail:" + GLUtils.getEGLErrorString(this.f151010i.eglGetError()));
                return false;
            }
            EGL10 egl102 = this.f151010i;
            EGLDisplay eGLDisplay = this.f151011j;
            EGLSurface eGLSurface = this.f151013l;
            if (!egl102.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, eglCreateContext)) {
                LogUtil.d(f151002u, "eglMakeCurrent failed,errorDetail:" + GLUtils.getEGLErrorString(this.f151010i.eglGetError()));
                return false;
            }
            this.f151014m = this.f151012k.getGL();
            return true;
        }
        return false;
    }

    @TargetApi(14)
    private void g() {
        WeakReference<Object> weakReference;
        LogUtil.a(e()).c(lb.a.f149160g, ua.a("TR") + " update surface begin");
        while (this.f151005c.get() && !this.f151006d.get() && SystemClock.elapsedRealtime() - this.f151015p <= f151000q) {
            h();
            try {
                weakReference = this.f151007f;
            } catch (Throwable th5) {
                LogUtil.d(f151002u, "updateSurface failed,errorDetail:" + Log.getStackTraceString(th5));
                LogUtil.a(e()).e(lb.a.f149160g, ua.a("TR") + " update surface failed", th5);
            }
            if (weakReference != null && weakReference.get() != null) {
                EGLSurface eglCreateWindowSurface = this.f151010i.eglCreateWindowSurface(this.f151011j, this.f151009h, this.f151007f.get(), null);
                this.f151013l = eglCreateWindowSurface;
                if (eglCreateWindowSurface == EGL10.EGL_NO_SURFACE) {
                    LogUtil.d(f151002u, "eglCreateWindowSurface failed,errorDetail:" + GLUtils.getEGLErrorString(this.f151010i.eglGetError()));
                } else {
                    if (this.f151010i.eglMakeCurrent(this.f151011j, eglCreateWindowSurface, eglCreateWindowSurface, this.f151012k)) {
                        break;
                    }
                    LogUtil.d(f151002u, "eglMakeCurrent failed,errorDetail:" + GLUtils.getEGLErrorString(this.f151010i.eglGetError()));
                }
            }
            return;
        }
        LogUtil.a(e()).c(lb.a.f149160g, ua.a("TR") + " update surface end");
    }

    private void h() {
        EGLSurface eGLSurface;
        EGLSurface eGLSurface2 = this.f151013l;
        if (eGLSurface2 != null && eGLSurface2 != (eGLSurface = EGL10.EGL_NO_SURFACE)) {
            this.f151010i.eglMakeCurrent(this.f151011j, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            this.f151010i.eglDestroySurface(this.f151011j, this.f151013l);
            this.f151013l = EGL10.EGL_NO_SURFACE;
            return;
        }
        LogUtil.d(ky.f149107m, "the EglSurface is null or status is EGL_NO_SURFACE");
    }

    private void i() {
        EGLContext eGLContext = this.f151012k;
        if (eGLContext != null && eGLContext != EGL10.EGL_NO_CONTEXT) {
            this.f151010i.eglDestroyContext(this.f151011j, eGLContext);
            this.f151012k = EGL10.EGL_NO_CONTEXT;
        } else {
            LogUtil.d(ky.f149107m, "the EglContext is null or status is EGL_NO_CONTEXT");
        }
    }

    private void j() {
        EGLDisplay eGLDisplay = this.f151011j;
        if (eGLDisplay != null && eGLDisplay != EGL10.EGL_NO_DISPLAY) {
            this.f151010i.eglTerminate(eGLDisplay);
            this.f151011j = EGL10.EGL_NO_DISPLAY;
        } else {
            LogUtil.d(ky.f149107m, "the EglDisplay is null or status is EGL_NO_DISPLAY");
        }
    }

    private void k() {
        h();
        EGLContext eGLContext = this.f151012k;
        if (eGLContext != null && eGLContext != EGL10.EGL_NO_CONTEXT) {
            this.f151010i.eglDestroyContext(this.f151011j, eGLContext);
            this.f151012k = EGL10.EGL_NO_CONTEXT;
        } else {
            LogUtil.d(ky.f149107m, "the EglContext is null or status is EGL_NO_CONTEXT");
        }
        EGLDisplay eGLDisplay = this.f151011j;
        if (eGLDisplay != null && eGLDisplay != EGL10.EGL_NO_DISPLAY) {
            this.f151010i.eglTerminate(eGLDisplay);
            this.f151011j = EGL10.EGL_NO_DISPLAY;
        } else {
            LogUtil.d(ky.f149107m, "the EglDisplay is null or status is EGL_NO_DISPLAY");
        }
    }

    public final void a() {
        LogUtil.a(e()).c(lb.a.f149160g, ua.a("TR") + " pause");
        this.f151006d.set(true);
        synchronized (this) {
            notifyAll();
        }
    }

    public final void b() {
        LogUtil.a(e()).c(lb.a.f149160g, ua.a("TR") + " resume");
        this.f151006d.set(false);
        synchronized (this) {
            notifyAll();
        }
    }

    public final void c() {
        LogUtil.a(e()).c(lb.a.f149160g, ua.a("TR") + " destroy");
        this.f151005c.set(false);
        this.f151006d.set(false);
        synchronized (this) {
            notifyAll();
        }
    }

    public final void d() {
        this.f151017s = true;
        this.f151016r = SystemClock.elapsedRealtime();
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
    public final void run() {
        WeakReference<Object> weakReference;
        super.run();
        LogUtil.a(e()).c(lb.a.f149160g, ua.a("TR") + " start");
        WeakReference<tr> weakReference2 = this.f151004b;
        if (weakReference2 != null && weakReference2.get() != null) {
            this.f151004b.get().E();
        }
        boolean z16 = false;
        while (this.f151005c.get()) {
            while (this.f151005c.get() && ((weakReference = this.f151007f) == null || weakReference.get() == null)) {
                synchronized (this) {
                    try {
                        LockMethodProxy.wait(this);
                    } catch (InterruptedException unused) {
                    }
                }
            }
            if (!z16) {
                z16 = f();
            }
            if (z16) {
                try {
                    synchronized (this) {
                        while (this.f151005c.get() && this.f151006d.get()) {
                            LockMethodProxy.wait(this);
                        }
                    }
                    if (this.f151008g) {
                        this.f151015p = SystemClock.elapsedRealtime();
                        g();
                        this.f151017s = true;
                        this.f151008g = false;
                        d();
                    }
                    WeakReference<tr> weakReference3 = this.f151004b;
                    if (weakReference3 != null && weakReference3.get() != null) {
                        tr trVar = this.f151004b.get();
                        if (this.f151017s && SystemClock.elapsedRealtime() - this.f151016r < f151001t) {
                            if (trVar != null) {
                                trVar.I();
                            }
                        } else {
                            this.f151017s = false;
                            this.f151016r = 0L;
                        }
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        if (trVar != null && trVar.a((GL10) this.f151014m)) {
                            this.f151010i.eglSwapBuffers(this.f151011j, this.f151013l);
                        }
                        int elapsedRealtime2 = (int) ((1000.0f / f150997e) - ((float) (SystemClock.elapsedRealtime() - elapsedRealtime)));
                        if (elapsedRealtime2 > 0) {
                            synchronized (this) {
                                try {
                                    wait(elapsedRealtime2);
                                } catch (InterruptedException unused2) {
                                }
                            }
                        }
                    }
                } catch (Throwable th5) {
                    if (this.f151005c.get() || !(th5 instanceof InterruptedException)) {
                        LogUtil.d(f151002u, "TextureGLRenderThread Render Exception:" + Log.getStackTraceString(th5));
                        LogUtil.a(e()).d(lb.a.f149160g, ua.a("TR") + " interrupted", th5);
                    }
                }
            }
        }
        LogUtil.a(e()).c(lb.a.f149160g, ua.a("TR") + " destroy GL");
        WeakReference<tr> weakReference4 = this.f151004b;
        if (weakReference4 != null && weakReference4.get() != null) {
            this.f151004b.get().F();
            this.f151004b = null;
        }
        h();
        EGLContext eGLContext = this.f151012k;
        if (eGLContext != null && eGLContext != EGL10.EGL_NO_CONTEXT) {
            this.f151010i.eglDestroyContext(this.f151011j, eGLContext);
            this.f151012k = EGL10.EGL_NO_CONTEXT;
        } else {
            LogUtil.d(ky.f149107m, "the EglContext is null or status is EGL_NO_CONTEXT");
        }
        EGLDisplay eGLDisplay = this.f151011j;
        if (eGLDisplay != null && eGLDisplay != EGL10.EGL_NO_DISPLAY) {
            this.f151010i.eglTerminate(eGLDisplay);
            this.f151011j = EGL10.EGL_NO_DISPLAY;
        } else {
            LogUtil.d(ky.f149107m, "the EglDisplay is null or status is EGL_NO_DISPLAY");
        }
    }

    public final void a(Object obj) {
        WeakReference<Object> weakReference = this.f151007f;
        if (weakReference != null && weakReference.get() != null) {
            this.f151008g = true;
        }
        this.f151007f = new WeakReference<>(obj);
        synchronized (this) {
            notifyAll();
        }
    }

    public static void a(float f16) {
        if (f16 <= 0.0f) {
            LogUtil.e(ky.f149107m, "\u5e27\u7387\u8bbe\u7f6e\u4e0d\u5728\u6709\u6548\u503c\u8303\u56f4\u5185");
        } else {
            f150997e = f16;
        }
    }

    private void a(boolean z16) {
        this.f151003a = z16;
    }
}
