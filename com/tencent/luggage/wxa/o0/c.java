package com.tencent.luggage.wxa.o0;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Surface;
import com.tencent.ark.EGLContextHolder;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.luggage.wxa.n0.v;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.qfsmonet.gles.MonetEGL14Define$EGLQueryAttribute;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c extends Surface {

    /* renamed from: d, reason: collision with root package name */
    public static boolean f135969d;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f135970e;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f135971a;

    /* renamed from: b, reason: collision with root package name */
    public final b f135972b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f135973c;

    public static c a(Context context, boolean z16) {
        a();
        com.tencent.luggage.wxa.n0.a.b(!z16 || b(context));
        return new b().b(z16);
    }

    public static synchronized boolean b(Context context) {
        boolean z16;
        boolean z17;
        synchronized (c.class) {
            if (!f135970e) {
                if (v.f135103a >= 24 && a(context)) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                f135969d = z17;
                f135970e = true;
            }
            z16 = f135969d;
        }
        return z16;
    }

    @Override // android.view.Surface
    public void release() {
        super.release();
        synchronized (this.f135972b) {
            if (!this.f135973c) {
                this.f135972b.a();
                this.f135973c = true;
            }
        }
    }

    public c(b bVar, SurfaceTexture surfaceTexture, boolean z16) {
        super(surfaceTexture);
        this.f135972b = bVar;
        this.f135971a = z16;
    }

    public static void a() {
        if (v.f135103a < 17) {
            throw new UnsupportedOperationException("Unsupported prior to API level 17");
        }
    }

    public static boolean a(Context context) {
        String eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373);
        if (eglQueryString == null || !eglQueryString.contains("EGL_EXT_protected_content")) {
            return false;
        }
        int i3 = v.f135103a;
        if (i3 == 24 && CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING.equals(v.f135105c)) {
            return false;
        }
        return i3 >= 26 || context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance");
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class b extends BaseHandlerThread implements SurfaceTexture.OnFrameAvailableListener, Handler.Callback {

        /* renamed from: a, reason: collision with root package name */
        public final int[] f135974a;

        /* renamed from: b, reason: collision with root package name */
        public EGLDisplay f135975b;

        /* renamed from: c, reason: collision with root package name */
        public EGLContext f135976c;

        /* renamed from: d, reason: collision with root package name */
        public EGLSurface f135977d;

        /* renamed from: e, reason: collision with root package name */
        public Handler f135978e;

        /* renamed from: f, reason: collision with root package name */
        public SurfaceTexture f135979f;

        /* renamed from: g, reason: collision with root package name */
        public Error f135980g;

        /* renamed from: h, reason: collision with root package name */
        public RuntimeException f135981h;

        /* renamed from: i, reason: collision with root package name */
        public c f135982i;

        public b() {
            super("dummySurface");
            this.f135974a = new int[1];
        }

        public void a() {
            this.f135978e.sendEmptyMessage(3);
        }

        public c b(boolean z16) {
            boolean z17;
            start();
            this.f135978e = new Handler(getLooper(), this);
            synchronized (this) {
                z17 = false;
                this.f135978e.obtainMessage(1, z16 ? 1 : 0, 0).sendToTarget();
                while (this.f135982i == null && this.f135981h == null && this.f135980g == null) {
                    try {
                        LockMethodProxy.wait(this);
                    } catch (InterruptedException unused) {
                        z17 = true;
                    }
                }
            }
            if (z17) {
                Thread.currentThread().interrupt();
            }
            RuntimeException runtimeException = this.f135981h;
            if (runtimeException == null) {
                Error error = this.f135980g;
                if (error == null) {
                    return this.f135982i;
                }
                throw error;
            }
            throw runtimeException;
        }

        public final void c(boolean z16) {
            boolean z17;
            boolean z18;
            int[] iArr;
            boolean z19;
            int[] iArr2;
            boolean z26;
            EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
            this.f135975b = eglGetDisplay;
            if (eglGetDisplay != null) {
                z17 = true;
            } else {
                z17 = false;
            }
            com.tencent.luggage.wxa.n0.a.b(z17, "eglGetDisplay failed");
            int[] iArr3 = new int[2];
            com.tencent.luggage.wxa.n0.a.b(EGL14.eglInitialize(this.f135975b, iArr3, 0, iArr3, 1), "eglInitialize failed");
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            int[] iArr4 = new int[1];
            if (EGL14.eglChooseConfig(this.f135975b, new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344}, 0, eGLConfigArr, 0, 1, iArr4, 0) && iArr4[0] > 0 && eGLConfigArr[0] != null) {
                z18 = true;
            } else {
                z18 = false;
            }
            com.tencent.luggage.wxa.n0.a.b(z18, "eglChooseConfig failed");
            EGLConfig eGLConfig = eGLConfigArr[0];
            if (z16) {
                iArr = new int[]{EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION, 2, 12992, 1, 12344};
            } else {
                iArr = new int[]{EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION, 2, 12344};
            }
            EGLContext eglCreateContext = EGL14.eglCreateContext(this.f135975b, eGLConfig, EGL14.EGL_NO_CONTEXT, iArr, 0);
            this.f135976c = eglCreateContext;
            if (eglCreateContext != null) {
                z19 = true;
            } else {
                z19 = false;
            }
            com.tencent.luggage.wxa.n0.a.b(z19, "eglCreateContext failed");
            if (z16) {
                iArr2 = new int[]{MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_WIDTH, 1, MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_HEIGHT, 1, 12992, 1, 12344};
            } else {
                iArr2 = new int[]{MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_WIDTH, 1, MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_HEIGHT, 1, 12344};
            }
            EGLSurface eglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(this.f135975b, eGLConfig, iArr2, 0);
            this.f135977d = eglCreatePbufferSurface;
            if (eglCreatePbufferSurface != null) {
                z26 = true;
            } else {
                z26 = false;
            }
            com.tencent.luggage.wxa.n0.a.b(z26, "eglCreatePbufferSurface failed");
            EGLDisplay eGLDisplay = this.f135975b;
            EGLSurface eGLSurface = this.f135977d;
            com.tencent.luggage.wxa.n0.a.b(EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.f135976c), "eglMakeCurrent failed");
            GLES20.glGenTextures(1, this.f135974a, 0);
            SurfaceTexture surfaceTexture = new SurfaceTexture(this.f135974a[0]);
            this.f135979f = surfaceTexture;
            surfaceTexture.setOnFrameAvailableListener(this);
            this.f135982i = new c(this, this.f135979f, z16);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            boolean z16;
            int i3 = message.what;
            try {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            return true;
                        }
                        try {
                            b();
                        } finally {
                            try {
                                return true;
                            } finally {
                            }
                        }
                        return true;
                    }
                    this.f135979f.updateTexImage();
                    return true;
                }
                try {
                    if (message.arg1 != 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    c(z16);
                    synchronized (this) {
                        notify();
                    }
                } catch (Error e16) {
                    Log.e("DummySurface", "Failed to initialize dummy surface", e16);
                    this.f135980g = e16;
                    synchronized (this) {
                        notify();
                    }
                } catch (RuntimeException e17) {
                    Log.e("DummySurface", "Failed to initialize dummy surface", e17);
                    this.f135981h = e17;
                    synchronized (this) {
                        notify();
                    }
                }
                return true;
            } catch (Throwable th5) {
                synchronized (this) {
                    notify();
                    throw th5;
                }
            }
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            this.f135978e.sendEmptyMessage(2);
        }

        public final void b() {
            try {
                SurfaceTexture surfaceTexture = this.f135979f;
                if (surfaceTexture != null) {
                    surfaceTexture.release();
                    GLES20.glDeleteTextures(1, this.f135974a, 0);
                }
            } finally {
                EGLSurface eGLSurface = this.f135977d;
                if (eGLSurface != null) {
                    EGL14.eglDestroySurface(this.f135975b, eGLSurface);
                }
                EGLContext eGLContext = this.f135976c;
                if (eGLContext != null) {
                    EGL14.eglDestroyContext(this.f135975b, eGLContext);
                }
                this.f135977d = null;
                this.f135976c = null;
                this.f135975b = null;
                this.f135982i = null;
                this.f135979f = null;
            }
        }
    }
}
