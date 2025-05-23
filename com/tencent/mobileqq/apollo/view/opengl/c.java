package com.tencent.mobileqq.apollo.view.opengl;

import com.tencent.ark.EGLContextHolder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

/* compiled from: P */
/* loaded from: classes11.dex */
public class c implements f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private int f194433a;

    /* renamed from: b, reason: collision with root package name */
    private int f194434b;

    public c(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
        } else {
            this.f194433a = EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION;
            this.f194434b = i3;
        }
    }

    @Override // com.tencent.mobileqq.apollo.view.opengl.f
    public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EGLContext) iPatchRedirector.redirect((short) 2, this, egl10, eGLDisplay, eGLConfig);
        }
        int i3 = this.f194434b;
        int[] iArr = {this.f194433a, i3, 12344};
        EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
        if (i3 == 0) {
            iArr = null;
        }
        return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
    }

    @Override // com.tencent.mobileqq.apollo.view.opengl.f
    public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, egl10, eGLDisplay, eGLContext);
            return;
        }
        if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
            QLog.e("[ApolloGL][DefaultContextFactory]", 1, "display:" + eGLDisplay + " context: " + eGLContext);
            EglHelper.m("eglDestroyContex", egl10.eglGetError());
        }
    }
}
