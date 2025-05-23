package it1;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.util.Log;
import android.util.Size;
import android.view.Surface;
import com.tencent.ark.EGLContextHolder;
import com.tencent.qfsmonet.gles.MonetEGL14Define$EGLQueryAttribute;
import com.tencent.qphone.base.util.QLog;
import org.tencwebrtc.EglBase;

/* compiled from: P */
@TargetApi(17)
/* loaded from: classes14.dex */
public class b implements c<EGLContext> {

    /* renamed from: g, reason: collision with root package name */
    private static final int[] f408691g = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12352, 4, EglBase.EGL_RECORDABLE_ANDROID, 1, 12344};

    /* renamed from: h, reason: collision with root package name */
    private static final int[] f408692h = {12339, 1, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12352, 4, EglBase.EGL_RECORDABLE_ANDROID, 1, 12344};

    /* renamed from: a, reason: collision with root package name */
    private final int f408693a;

    /* renamed from: b, reason: collision with root package name */
    private final int f408694b;

    /* renamed from: c, reason: collision with root package name */
    private EGLConfig f408695c = null;

    /* renamed from: d, reason: collision with root package name */
    private EGLDisplay f408696d = EGL14.EGL_NO_DISPLAY;

    /* renamed from: e, reason: collision with root package name */
    private EGLContext f408697e = EGL14.EGL_NO_CONTEXT;

    /* renamed from: f, reason: collision with root package name */
    private EGLSurface f408698f;

    b(int i3, int i16) {
        this.f408693a = i3;
        this.f408694b = i16;
    }

    private void c() {
        int eglGetError = EGL14.eglGetError();
        if (eglGetError == 12288) {
            return;
        }
        Log.e("QGMC.EGL14Helper", "EGL error:" + eglGetError);
        throw new RuntimeException(": EGL error: 0x" + Integer.toHexString(eglGetError));
    }

    public static b d(EGLConfig eGLConfig, EGLContext eGLContext, Surface surface, int i3, int i16) {
        b bVar = new b(i3, i16);
        if (bVar.f(eGLConfig, eGLContext, surface)) {
            return bVar;
        }
        return null;
    }

    private EGLContext e(EGLDisplay eGLDisplay, EGLConfig eGLConfig, EGLContext eGLContext, int i3) {
        return EGL14.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, new int[]{EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION, i3, 12344}, 0);
    }

    private boolean f(EGLConfig eGLConfig, EGLContext eGLContext, Surface surface) {
        int[] iArr;
        EGLContext eGLContext2;
        EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
        this.f408696d = eglGetDisplay;
        if (eglGetDisplay != EGL14.EGL_NO_DISPLAY) {
            int[] iArr2 = new int[2];
            if (EGL14.eglInitialize(eglGetDisplay, iArr2, 0, iArr2, 1)) {
                if (eGLConfig != null) {
                    this.f408695c = eGLConfig;
                } else {
                    EGLConfig[] eGLConfigArr = new EGLConfig[1];
                    int[] iArr3 = new int[1];
                    if (surface == null) {
                        iArr = f408692h;
                    } else {
                        iArr = f408691g;
                    }
                    if (!EGL14.eglChooseConfig(this.f408696d, iArr, 0, eGLConfigArr, 0, 1, iArr3, 0)) {
                        return false;
                    }
                    this.f408695c = eGLConfigArr[0];
                }
                if (eGLContext == null) {
                    eGLContext2 = EGL14.EGL_NO_CONTEXT;
                } else {
                    eGLContext2 = eGLContext;
                }
                QLog.i("QGMC.EGL14Helper", 1, "try to create EGLContext of OpenGL ES 2.0");
                EGLContext e16 = e(this.f408696d, this.f408695c, eGLContext2, 2);
                this.f408697e = e16;
                if (e16 == EGL14.EGL_NO_CONTEXT) {
                    QLog.e("QGMC.EGL14Helper", 1, "failed to create EGLContext of OpenGL ES 2.0, try 3.0");
                    EGLContext e17 = e(this.f408696d, this.f408695c, eGLContext2, 3);
                    this.f408697e = e17;
                    if (e17 == EGL14.EGL_NO_CONTEXT) {
                        QLog.e("QGMC.EGL14Helper", 1, "try 3.0 failed, mEGLContext == EGL14.EGL_NO_CONTEXT");
                        c();
                        return false;
                    }
                }
                if (surface == null) {
                    this.f408698f = EGL14.eglCreatePbufferSurface(this.f408696d, this.f408695c, new int[]{MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_WIDTH, this.f408693a, MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_HEIGHT, this.f408694b, 12344}, 0);
                } else {
                    this.f408698f = EGL14.eglCreateWindowSurface(this.f408696d, this.f408695c, surface, new int[]{12344}, 0);
                }
                c();
                EGLDisplay eGLDisplay = this.f408696d;
                EGLSurface eGLSurface = this.f408698f;
                if (EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.f408697e)) {
                    return true;
                }
                QLog.e("QGMC.EGL14Helper", 1, "EGL14.eglMakeCurrent return false!!!");
                c();
                return false;
            }
            this.f408696d = null;
            throw new RuntimeException("unable to initialize EGL14");
        }
        throw new RuntimeException("unable to get EGL14 display");
    }

    @Override // it1.c
    public void a() {
        EGLDisplay eGLDisplay = this.f408696d;
        if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
        }
    }

    @Override // it1.c
    public Size b() {
        int[] iArr = new int[2];
        boolean eglQuerySurface = EGL14.eglQuerySurface(this.f408696d, this.f408698f, MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_WIDTH, iArr, 0);
        boolean eglQuerySurface2 = EGL14.eglQuerySurface(this.f408696d, this.f408698f, MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_HEIGHT, iArr, 1);
        if (eglQuerySurface && eglQuerySurface2) {
            return new Size(iArr[0], iArr[1]);
        }
        return new Size(0, 0);
    }

    @Override // it1.c
    public void destroy() {
        EGLDisplay eGLDisplay = this.f408696d;
        if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            EGLSurface eGLSurface2 = this.f408698f;
            if (eGLSurface2 != EGL14.EGL_NO_SURFACE) {
                EGL14.eglDestroySurface(this.f408696d, eGLSurface2);
                this.f408698f = EGL14.EGL_NO_SURFACE;
            }
            EGLContext eGLContext = this.f408697e;
            if (eGLContext != EGL14.EGL_NO_CONTEXT) {
                EGL14.eglDestroyContext(this.f408696d, eGLContext);
                this.f408697e = EGL14.EGL_NO_CONTEXT;
            }
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.f408696d);
        }
        this.f408696d = EGL14.EGL_NO_DISPLAY;
    }

    @Override // it1.c
    public void makeCurrent() {
        if (this.f408696d == EGL14.EGL_NO_DISPLAY) {
            QLog.d("QGMC.EGL14Helper", 4, "NOTE: makeCurrent w/o display");
        }
        EGLDisplay eGLDisplay = this.f408696d;
        EGLSurface eGLSurface = this.f408698f;
        if (EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.f408697e)) {
        } else {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    @Override // it1.c
    public boolean swapBuffers() {
        return EGL14.eglSwapBuffers(this.f408696d, this.f408698f);
    }
}
