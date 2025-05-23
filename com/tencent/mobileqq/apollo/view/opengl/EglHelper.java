package com.tencent.mobileqq.apollo.view.opengl;

import android.opengl.GLDebugHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.relation.common.nt.api.impl.RelationNTPushServiceImpl;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;

/* compiled from: P */
/* loaded from: classes11.dex */
public class EglHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<h> f194398a;

    /* renamed from: b, reason: collision with root package name */
    EGL10 f194399b;

    /* renamed from: c, reason: collision with root package name */
    EGLDisplay f194400c;

    /* renamed from: d, reason: collision with root package name */
    EGLSurface f194401d;

    /* renamed from: e, reason: collision with root package name */
    EGLConfig f194402e;

    /* renamed from: f, reason: collision with root package name */
    EGLContext f194403f;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class EGLException extends RuntimeException {
        static IPatchRedirector $redirector_;

        public EGLException(String str) {
            super(str);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            }
        }
    }

    public EglHelper(WeakReference<h> weakReference) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) weakReference);
        } else {
            this.f194398a = weakReference;
        }
    }

    private void d() {
        EGLSurface eGLSurface;
        EGLSurface eGLSurface2 = this.f194401d;
        if (eGLSurface2 != null && eGLSurface2 != (eGLSurface = EGL10.EGL_NO_SURFACE)) {
            this.f194399b.eglMakeCurrent(this.f194400c, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            h hVar = this.f194398a.get();
            if (hVar != null) {
                hVar.getEGLWindowSurfaceFactory().destroySurface(this.f194399b, this.f194400c, this.f194401d);
            }
            this.f194401d = null;
        }
    }

    public static String f(String str, int i3) {
        return str + " failed: " + g(i3);
    }

    public static String g(int i3) {
        switch (i3) {
            case 12288:
                return "EGL_SUCCESS";
            case 12289:
                return "EGL_NOT_INITIALIZED";
            case 12290:
                return "EGL_BAD_ACCESS";
            case 12291:
                return "EGL_BAD_ALLOC";
            case 12292:
                return "EGL_BAD_ATTRIBUTE";
            case 12293:
                return "EGL_BAD_CONFIG";
            case 12294:
                return "EGL_BAD_CONTEXT";
            case 12295:
                return "EGL_BAD_CURRENT_SURFACE";
            case 12296:
                return "EGL_BAD_DISPLAY";
            case 12297:
                return "EGL_BAD_MATCH";
            case 12298:
                return "EGL_BAD_NATIVE_PIXMAP";
            case 12299:
                return "EGL_BAD_NATIVE_WINDOW";
            case 12300:
                return "EGL_BAD_PARAMETER";
            case 12301:
                return "EGL_BAD_SURFACE";
            case 12302:
                return "EGL_CONTEXT_LOST";
            default:
                return h(i3);
        }
    }

    private static String h(int i3) {
        return RelationNTPushServiceImpl.PRE_HEX_STRING + Integer.toHexString(i3);
    }

    public static void i(String str, String str2, int i3) {
        QLog.w(str, 1, f(str2, i3));
    }

    private void l(String str) {
        m(str, this.f194399b.eglGetError());
    }

    public static void m(String str, int i3) {
        throw new EGLException(f(str, i3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GL a() {
        j jVar;
        GL gl5 = this.f194403f.getGL();
        h hVar = this.f194398a.get();
        if (hVar != null) {
            if (hVar.getGLWrapper() != null) {
                gl5 = hVar.getGLWrapper().wrap(gl5);
            }
            if ((hVar.getDebugFlags() & 3) != 0) {
                int i3 = 1;
                if ((hVar.getDebugFlags() & 1) == 0) {
                    i3 = 0;
                }
                if ((hVar.getDebugFlags() & 2) != 0) {
                    jVar = new j();
                } else {
                    jVar = null;
                }
                return GLDebugHelper.wrap(gl5, i3, jVar);
            }
            return gl5;
        }
        return gl5;
    }

    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        QLog.w("[ApolloGL][EglHelper]", 1, "createSurface()  tid=" + Thread.currentThread().getId());
        if (this.f194399b != null) {
            if (this.f194400c != null) {
                if (this.f194402e != null) {
                    d();
                    h hVar = this.f194398a.get();
                    if (hVar != null) {
                        this.f194401d = hVar.getEGLWindowSurfaceFactory().createWindowSurface(this.f194399b, this.f194400c, this.f194402e, hVar.getNativeWindow());
                    } else {
                        this.f194401d = null;
                    }
                    EGLSurface eGLSurface = this.f194401d;
                    if (eGLSurface != null && eGLSurface != EGL10.EGL_NO_SURFACE) {
                        if (this.f194399b.eglMakeCurrent(this.f194400c, eGLSurface, eGLSurface, this.f194403f)) {
                            return true;
                        }
                        i("[ApolloGL][EglHelper]", "eglMakeCurrent", this.f194399b.eglGetError());
                        return false;
                    }
                    QLog.e("[ApolloGL][EglHelper]", 1, "createWindowSurface returned error:" + g(this.f194399b.eglGetError()));
                    return false;
                }
                throw new RuntimeException("mEglConfig not initialized");
            }
            throw new RuntimeException("eglDisplay not initialized");
        }
        throw new RuntimeException("egl not initialized");
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        QLog.w("[ApolloGL][EglHelper]", 1, "destroySurface()  tid=" + Thread.currentThread().getId());
        d();
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        QLog.w("[ApolloGL][EglHelper]", 1, "finish() tid=" + Thread.currentThread().getId());
        if (this.f194403f != null) {
            h hVar = this.f194398a.get();
            if (hVar != null) {
                hVar.getEGLContextFactory().destroyContext(this.f194399b, this.f194400c, this.f194403f);
            }
            this.f194403f = null;
        }
        EGLDisplay eGLDisplay = this.f194400c;
        if (eGLDisplay != null) {
            this.f194399b.eglTerminate(eGLDisplay);
            this.f194400c = null;
        }
    }

    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        QLog.w("[ApolloGL][EglHelper]", 1, "start() tid=" + Thread.currentThread().getId());
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        this.f194399b = egl10;
        EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.f194400c = eglGetDisplay;
        if (eglGetDisplay != EGL10.EGL_NO_DISPLAY) {
            if (this.f194399b.eglInitialize(eglGetDisplay, new int[2])) {
                h hVar = this.f194398a.get();
                if (hVar == null) {
                    this.f194402e = null;
                    this.f194403f = null;
                } else {
                    this.f194402e = hVar.getEGLConfigChooser().chooseConfig(this.f194399b, this.f194400c);
                    this.f194403f = hVar.getEGLContextFactory().createContext(this.f194399b, this.f194400c, this.f194402e);
                }
                EGLContext eGLContext = this.f194403f;
                if (eGLContext == null || eGLContext == EGL10.EGL_NO_CONTEXT) {
                    this.f194403f = null;
                    l("createContext");
                }
                QLog.w("[ApolloGL][EglHelper]", 1, "createContext " + this.f194403f + " tid=" + Thread.currentThread().getId());
                this.f194401d = null;
                return;
            }
            throw new RuntimeException("eglInitialize failed");
        }
        throw new RuntimeException("eglGetDisplay failed");
    }

    public int k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        if (!this.f194399b.eglSwapBuffers(this.f194400c, this.f194401d)) {
            return this.f194399b.eglGetError();
        }
        return 12288;
    }
}
