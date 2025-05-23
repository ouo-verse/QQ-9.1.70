package com.tencent.liteav.videobase.egl;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.view.Surface;
import com.tencent.ark.EGLContextHolder;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.qfsmonet.gles.MonetEGL14Define$EGLQueryAttribute;
import org.tencwebrtc.EglBase;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class b implements e<EGLContext> {

    /* renamed from: h, reason: collision with root package name */
    private static final int[] f119324h = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12352, 4, EglBase.EGL_RECORDABLE_ANDROID, 1, 12344};

    /* renamed from: i, reason: collision with root package name */
    private static final int[] f119325i = {12339, 1, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12352, 4, EglBase.EGL_RECORDABLE_ANDROID, 1, 12344};

    /* renamed from: d, reason: collision with root package name */
    private final int f119329d;

    /* renamed from: e, reason: collision with root package name */
    private final int f119330e;

    /* renamed from: f, reason: collision with root package name */
    private EGLConfig f119331f = null;

    /* renamed from: a, reason: collision with root package name */
    EGLDisplay f119326a = EGL14.EGL_NO_DISPLAY;

    /* renamed from: g, reason: collision with root package name */
    private EGLContext f119332g = EGL14.EGL_NO_CONTEXT;

    /* renamed from: b, reason: collision with root package name */
    EGLSurface f119327b = EGL14.EGL_NO_SURFACE;

    /* renamed from: c, reason: collision with root package name */
    private final String f119328c = "EGL14Helper@" + hashCode();

    b(int i3, int i16) {
        this.f119329d = i3;
        this.f119330e = i16;
    }

    public static b a(EGLContext eGLContext, Surface surface, int i3, int i16) throws d {
        int i17;
        b bVar = new b(i3, i16);
        try {
            EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
            bVar.f119326a = eglGetDisplay;
            if (eglGetDisplay != EGL14.EGL_NO_DISPLAY) {
                int[] iArr = new int[2];
                if (!EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
                    bVar.f119326a = null;
                    LiteavLog.e(bVar.f119328c, "unable to initialize EGL14");
                    throw new d(0);
                }
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                if (EGL14.eglChooseConfig(bVar.f119326a, surface == null ? f119325i : f119324h, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
                    bVar.f119331f = eGLConfigArr[0];
                    if (LiteavSystemInfo.getSystemOSVersionInt() >= 18) {
                        try {
                            bVar.f119332g = a(bVar.f119326a, bVar.f119331f, 2, eGLContext);
                        } catch (d unused) {
                            LiteavLog.i(bVar.f119328c, "failed to create EGLContext of OpenGL ES 2.0, try 3.0");
                            bVar.f119332g = a(bVar.f119326a, bVar.f119331f, 3, eGLContext);
                            i17 = 3;
                        }
                    } else {
                        bVar.f119332g = a(bVar.f119326a, bVar.f119331f, 2, eGLContext);
                    }
                    i17 = 2;
                    LiteavLog.i(bVar.f119328c, "create eglContext " + bVar.f119332g + " sharedContext: " + eGLContext + " version:" + i17);
                    if (surface == null) {
                        bVar.f119327b = EGL14.eglCreatePbufferSurface(bVar.f119326a, bVar.f119331f, new int[]{MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_WIDTH, bVar.f119329d, MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_HEIGHT, bVar.f119330e, 12344}, 0);
                    } else {
                        try {
                            bVar.f119327b = EGL14.eglCreateWindowSurface(bVar.f119326a, bVar.f119331f, surface, new int[]{12344}, 0);
                        } catch (Throwable th5) {
                            throw new d(EGL14.eglGetError(), "", th5);
                        }
                    }
                    g();
                    EGLDisplay eGLDisplay = bVar.f119326a;
                    EGLSurface eGLSurface = bVar.f119327b;
                    if (!EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, bVar.f119332g)) {
                        g();
                    }
                    return bVar;
                }
                throw new d(0);
            }
            LiteavLog.e(bVar.f119328c, "unable to get EGL14 display");
            throw new d(0);
        } catch (d e16) {
            bVar.c();
            throw e16;
        }
    }

    private static void g() throws d {
        int eglGetError = EGL14.eglGetError();
        if (eglGetError == 12288) {
        } else {
            throw new d(eglGetError);
        }
    }

    @Override // com.tencent.liteav.videobase.egl.e
    public final void b() throws d {
        EGLDisplay eGLDisplay = this.f119326a;
        EGLSurface eGLSurface = this.f119327b;
        if (!EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.f119332g)) {
            g();
        }
    }

    @Override // com.tencent.liteav.videobase.egl.e
    public final void c() {
        EGLDisplay eGLDisplay = this.f119326a;
        if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            EGLSurface eGLSurface2 = this.f119327b;
            if (eGLSurface2 != EGL14.EGL_NO_SURFACE) {
                EGL14.eglDestroySurface(this.f119326a, eGLSurface2);
                this.f119327b = EGL14.EGL_NO_SURFACE;
            }
            if (this.f119332g != EGL14.EGL_NO_CONTEXT) {
                LiteavLog.i(this.f119328c, "destroy eglContext " + this.f119332g);
                EGL14.eglDestroyContext(this.f119326a, this.f119332g);
                this.f119332g = EGL14.EGL_NO_CONTEXT;
            }
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.f119326a);
        }
        this.f119326a = EGL14.EGL_NO_DISPLAY;
    }

    @Override // com.tencent.liteav.videobase.egl.e
    public final void d() {
        EGLDisplay eGLDisplay = this.f119326a;
        if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
        }
    }

    @Override // com.tencent.liteav.videobase.egl.e
    public final Size e() {
        int[] iArr = new int[2];
        boolean eglQuerySurface = EGL14.eglQuerySurface(this.f119326a, this.f119327b, MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_WIDTH, iArr, 0);
        boolean eglQuerySurface2 = EGL14.eglQuerySurface(this.f119326a, this.f119327b, MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_HEIGHT, iArr, 1);
        if (eglQuerySurface && eglQuerySurface2) {
            return new Size(iArr[0], iArr[1]);
        }
        return new Size(0, 0);
    }

    @Override // com.tencent.liteav.videobase.egl.e
    public final /* bridge */ /* synthetic */ EGLContext f() {
        return this.f119332g;
    }

    @Override // com.tencent.liteav.videobase.egl.e
    public final void a() throws d {
        GLES20.glFinish();
        if (EGL14.eglSwapBuffers(this.f119326a, this.f119327b)) {
            return;
        }
        g();
    }

    private static EGLContext a(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i3, EGLContext eGLContext) throws d {
        int[] iArr = {EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION, i3, 12344};
        if (eGLContext == null) {
            eGLContext = EGL14.EGL_NO_CONTEXT;
        }
        EGLContext eglCreateContext = EGL14.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr, 0);
        g();
        return eglCreateContext;
    }
}
