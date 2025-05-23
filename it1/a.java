package it1;

import android.util.Size;
import android.view.Surface;
import com.tencent.ark.EGLContextHolder;
import com.tencent.qfsmonet.gles.MonetEGL14Define$EGLQueryAttribute;
import com.tencent.qphone.base.util.QLog;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import org.tencwebrtc.EglBase;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a implements c<EGLContext> {

    /* renamed from: h, reason: collision with root package name */
    private static final int[] f408682h = {12339, 1, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12352, 4, 12344};

    /* renamed from: i, reason: collision with root package name */
    private static final int[] f408683i = {12339, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12352, 4, EglBase.EGL_RECORDABLE_ANDROID, 1, 12344};

    /* renamed from: a, reason: collision with root package name */
    private final int f408684a;

    /* renamed from: b, reason: collision with root package name */
    private final int f408685b;

    /* renamed from: c, reason: collision with root package name */
    private EGLDisplay f408686c = EGL10.EGL_NO_DISPLAY;

    /* renamed from: d, reason: collision with root package name */
    private EGLContext f408687d = EGL10.EGL_NO_CONTEXT;

    /* renamed from: e, reason: collision with root package name */
    private EGLSurface f408688e = EGL10.EGL_NO_SURFACE;

    /* renamed from: f, reason: collision with root package name */
    private EGL10 f408689f;

    /* renamed from: g, reason: collision with root package name */
    private EGLConfig f408690g;

    a(int i3, int i16) {
        this.f408684a = i3;
        this.f408685b = i16;
    }

    public static a d(EGLConfig eGLConfig, EGLContext eGLContext, Surface surface, int i3, int i16) {
        a aVar = new a(i3, i16);
        if (aVar.e(eGLConfig, eGLContext, surface)) {
            return aVar;
        }
        return null;
    }

    private boolean e(EGLConfig eGLConfig, EGLContext eGLContext, Surface surface) {
        int[] iArr;
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        this.f408689f = egl10;
        EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.f408686c = eglGetDisplay;
        this.f408689f.eglInitialize(eglGetDisplay, new int[2]);
        if (eGLConfig == null) {
            int[] iArr2 = new int[1];
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            if (surface == null) {
                iArr = f408682h;
            } else {
                iArr = f408683i;
            }
            this.f408689f.eglChooseConfig(this.f408686c, iArr, eGLConfigArr, 1, iArr2);
            this.f408690g = eGLConfigArr[0];
        } else {
            this.f408690g = eGLConfig;
        }
        int[] iArr3 = {EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION, 2, 12344};
        if (eGLContext == null) {
            eGLContext = EGL10.EGL_NO_CONTEXT;
        }
        EGLContext eglCreateContext = this.f408689f.eglCreateContext(this.f408686c, this.f408690g, eGLContext, iArr3);
        this.f408687d = eglCreateContext;
        if (eglCreateContext == EGL10.EGL_NO_CONTEXT) {
            QLog.e("QGMC.EGL10Helper", 1, "mEGLContext == EGL10.EGL_NO_CONTEXT");
            c();
            return false;
        }
        int[] iArr4 = {MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_WIDTH, this.f408684a, MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_HEIGHT, this.f408685b, 12344};
        if (surface == null) {
            this.f408688e = this.f408689f.eglCreatePbufferSurface(this.f408686c, this.f408690g, iArr4);
        } else {
            this.f408688e = this.f408689f.eglCreateWindowSurface(this.f408686c, this.f408690g, surface, null);
        }
        EGLSurface eGLSurface = this.f408688e;
        if (eGLSurface == EGL10.EGL_NO_SURFACE) {
            QLog.e("QGMC.EGL10Helper", 1, "mEGLSurface == EGL10.EGL_NO_SURFACE");
            c();
            return false;
        }
        if (this.f408689f.eglMakeCurrent(this.f408686c, eGLSurface, eGLSurface, this.f408687d)) {
            return true;
        }
        c();
        return false;
    }

    @Override // it1.c
    public void a() {
        EGLDisplay eGLDisplay = this.f408686c;
        if (eGLDisplay != EGL10.EGL_NO_DISPLAY) {
            EGL10 egl10 = this.f408689f;
            EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
            egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
        }
    }

    @Override // it1.c
    public Size b() {
        int[] iArr = new int[1];
        int[] iArr2 = new int[1];
        boolean eglQuerySurface = this.f408689f.eglQuerySurface(this.f408686c, this.f408688e, MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_WIDTH, iArr);
        boolean eglQuerySurface2 = this.f408689f.eglQuerySurface(this.f408686c, this.f408688e, MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_HEIGHT, iArr2);
        if (eglQuerySurface && eglQuerySurface2) {
            return new Size(iArr[0], iArr2[0]);
        }
        return new Size(0, 0);
    }

    public void c() {
        int eglGetError = this.f408689f.eglGetError();
        if (eglGetError != 12288) {
            QLog.e("QGMC.EGL10Helper", 1, "EGL error: 0x" + Integer.toHexString(eglGetError));
        }
    }

    @Override // it1.c
    public void destroy() {
        EGLDisplay eGLDisplay = this.f408686c;
        if (eGLDisplay != EGL10.EGL_NO_DISPLAY) {
            EGL10 egl10 = this.f408689f;
            EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
            egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            EGLSurface eGLSurface2 = this.f408688e;
            if (eGLSurface2 != EGL10.EGL_NO_SURFACE) {
                this.f408689f.eglDestroySurface(this.f408686c, eGLSurface2);
                this.f408688e = EGL10.EGL_NO_SURFACE;
            }
            EGLContext eGLContext = this.f408687d;
            if (eGLContext != EGL10.EGL_NO_CONTEXT) {
                this.f408689f.eglDestroyContext(this.f408686c, eGLContext);
                this.f408687d = EGL10.EGL_NO_CONTEXT;
            }
            this.f408689f.eglTerminate(this.f408686c);
            c();
        }
        this.f408686c = EGL10.EGL_NO_DISPLAY;
    }

    @Override // it1.c
    public void makeCurrent() {
        EGL10 egl10 = this.f408689f;
        EGLDisplay eGLDisplay = this.f408686c;
        EGLSurface eGLSurface = this.f408688e;
        egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.f408687d);
        c();
    }

    @Override // it1.c
    public boolean swapBuffers() {
        boolean eglSwapBuffers = this.f408689f.eglSwapBuffers(this.f408686c, this.f408688e);
        c();
        return eglSwapBuffers;
    }
}
