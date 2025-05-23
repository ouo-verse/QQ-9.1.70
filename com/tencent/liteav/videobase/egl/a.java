package com.tencent.liteav.videobase.egl;

import android.opengl.GLES20;
import android.view.Surface;
import com.tencent.ark.EGLContextHolder;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.qfsmonet.gles.MonetEGL14Define$EGLQueryAttribute;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import org.tencwebrtc.EglBase;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class a implements e<EGLContext> {

    /* renamed from: i, reason: collision with root package name */
    private static final int[] f119314i = {12339, 1, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12352, 4, 12344};

    /* renamed from: j, reason: collision with root package name */
    private static final int[] f119315j = {12339, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12352, 4, EglBase.EGL_RECORDABLE_ANDROID, 1, 12344};

    /* renamed from: b, reason: collision with root package name */
    private final int f119317b;

    /* renamed from: c, reason: collision with root package name */
    private final int f119318c;

    /* renamed from: g, reason: collision with root package name */
    private EGL10 f119322g;

    /* renamed from: h, reason: collision with root package name */
    private EGLConfig f119323h;

    /* renamed from: d, reason: collision with root package name */
    private EGLDisplay f119319d = EGL10.EGL_NO_DISPLAY;

    /* renamed from: e, reason: collision with root package name */
    private EGLContext f119320e = EGL10.EGL_NO_CONTEXT;

    /* renamed from: f, reason: collision with root package name */
    private EGLSurface f119321f = EGL10.EGL_NO_SURFACE;

    /* renamed from: a, reason: collision with root package name */
    private final String f119316a = "EGL10Helper@" + hashCode();

    a(int i3, int i16) {
        this.f119317b = i3;
        this.f119318c = i16;
    }

    public static a a(EGLContext eGLContext, Surface surface, int i3, int i16) throws d {
        int i17;
        a aVar = new a(i3, i16);
        try {
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            aVar.f119322g = egl10;
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            aVar.f119319d = eglGetDisplay;
            aVar.f119322g.eglInitialize(eglGetDisplay, new int[2]);
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            aVar.f119322g.eglChooseConfig(aVar.f119319d, surface == null ? f119314i : f119315j, eGLConfigArr, 1, new int[1]);
            aVar.f119323h = eGLConfigArr[0];
            if (LiteavSystemInfo.getSystemOSVersionInt() >= 18) {
                try {
                    aVar.f119320e = aVar.a(aVar.f119319d, aVar.f119323h, 2, eGLContext);
                } catch (d unused) {
                    LiteavLog.i(aVar.f119316a, "failed to create EGLContext of OpenGL ES 2.0, try 3.0");
                    aVar.f119320e = aVar.a(aVar.f119319d, aVar.f119323h, 3, eGLContext);
                    i17 = 3;
                }
            } else {
                aVar.f119320e = aVar.a(aVar.f119319d, aVar.f119323h, 2, eGLContext);
            }
            i17 = 2;
            LiteavLog.i(aVar.f119316a, "create eglContext " + aVar.f119320e + " sharedContext: " + eGLContext + " version:" + i17);
            if (surface == null) {
                aVar.f119321f = aVar.f119322g.eglCreatePbufferSurface(aVar.f119319d, aVar.f119323h, new int[]{MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_WIDTH, aVar.f119317b, MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_HEIGHT, aVar.f119318c, 12344});
            } else {
                try {
                    aVar.f119321f = aVar.f119322g.eglCreateWindowSurface(aVar.f119319d, aVar.f119323h, surface, null);
                } catch (Throwable th5) {
                    throw new d(aVar.f119322g.eglGetError(), "", th5);
                }
            }
            if (aVar.f119321f == EGL10.EGL_NO_SURFACE) {
                aVar.h();
            }
            EGL10 egl102 = aVar.f119322g;
            EGLDisplay eGLDisplay = aVar.f119319d;
            EGLSurface eGLSurface = aVar.f119321f;
            if (!egl102.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, aVar.f119320e)) {
                aVar.h();
            }
            return aVar;
        } catch (d e16) {
            aVar.c();
            throw e16;
        }
    }

    private void g() throws d {
        if (this.f119321f != EGL10.EGL_NO_SURFACE) {
            d();
            if (!this.f119322g.eglDestroySurface(this.f119319d, this.f119321f)) {
                h();
            }
            this.f119321f = EGL10.EGL_NO_SURFACE;
        }
    }

    private void h() throws d {
        int eglGetError = this.f119322g.eglGetError();
        if (eglGetError == 12288) {
        } else {
            throw new d(eglGetError);
        }
    }

    @Override // com.tencent.liteav.videobase.egl.e
    public final void b() throws d {
        EGL10 egl10 = this.f119322g;
        EGLDisplay eGLDisplay = this.f119319d;
        EGLSurface eGLSurface = this.f119321f;
        if (!egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.f119320e)) {
            h();
        }
    }

    @Override // com.tencent.liteav.videobase.egl.e
    public final void c() throws d {
        if (this.f119319d != EGL10.EGL_NO_DISPLAY) {
            d();
            g();
            if (this.f119320e != EGL10.EGL_NO_CONTEXT) {
                LiteavLog.i(this.f119316a, "destroy eglContext " + this.f119320e);
                this.f119322g.eglDestroyContext(this.f119319d, this.f119320e);
                this.f119320e = EGL10.EGL_NO_CONTEXT;
            }
            this.f119322g.eglTerminate(this.f119319d);
        }
        this.f119319d = EGL10.EGL_NO_DISPLAY;
    }

    @Override // com.tencent.liteav.videobase.egl.e
    public final void d() {
        EGLDisplay eGLDisplay = this.f119319d;
        if (eGLDisplay != EGL10.EGL_NO_DISPLAY) {
            EGL10 egl10 = this.f119322g;
            EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
            egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
        }
    }

    @Override // com.tencent.liteav.videobase.egl.e
    public final Size e() {
        int[] iArr = new int[1];
        int[] iArr2 = new int[1];
        boolean eglQuerySurface = this.f119322g.eglQuerySurface(this.f119319d, this.f119321f, MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_WIDTH, iArr);
        boolean eglQuerySurface2 = this.f119322g.eglQuerySurface(this.f119319d, this.f119321f, MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_HEIGHT, iArr2);
        if (eglQuerySurface && eglQuerySurface2) {
            return new Size(iArr[0], iArr2[0]);
        }
        return new Size(0, 0);
    }

    @Override // com.tencent.liteav.videobase.egl.e
    public final /* bridge */ /* synthetic */ EGLContext f() {
        return this.f119320e;
    }

    @Override // com.tencent.liteav.videobase.egl.e
    public final void a() throws d {
        GLES20.glFinish();
        if (this.f119322g.eglSwapBuffers(this.f119319d, this.f119321f)) {
            return;
        }
        h();
    }

    private EGLContext a(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i3, EGLContext eGLContext) throws d {
        int[] iArr = {EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION, i3, 12344};
        if (eGLContext == null) {
            eGLContext = EGL10.EGL_NO_CONTEXT;
        }
        EGLContext eglCreateContext = this.f119322g.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        h();
        return eglCreateContext;
    }
}
