package com.tencent.mobileqq.apollo.view.opengl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* compiled from: P */
/* loaded from: classes11.dex */
public class d implements g {
    static IPatchRedirector $redirector_;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.apollo.view.opengl.g
    public EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EGLSurface) iPatchRedirector.redirect((short) 2, this, egl10, eGLDisplay, eGLConfig, obj);
        }
        if (obj == null) {
            return null;
        }
        try {
            return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
        } catch (Throwable th5) {
            QLog.e("[ApolloGL][DefWindowSurfaceFactory]", 1, "eglCreateWindowSurface exception", th5);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.apollo.view.opengl.g
    public void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, egl10, eGLDisplay, eGLSurface);
        } else {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }
    }
}
