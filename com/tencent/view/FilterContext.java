package com.tencent.view;

import com.tencent.ark.EGLContextHolder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qfsmonet.gles.MonetEGL14Define$EGLQueryAttribute;
import com.tencent.ttpic.baseutils.log.LogUtils;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* compiled from: P */
/* loaded from: classes27.dex */
public class FilterContext {
    static IPatchRedirector $redirector_ = null;
    private static final boolean LIST_CONFIGS = false;
    private static final String TAG = "PixelBuffer";
    private EGL10 mEGL;
    private EGLConfig mEGLConfig;
    private EGLConfig[] mEGLConfigs;
    private EGLContext mEGLContext;
    private EGLDisplay mEGLDisplay;
    private EGLSurface mEGLSurface;

    public FilterContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        int[] iArr = {MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_WIDTH, 100, MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_HEIGHT, 100, 12344};
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        this.mEGL = egl10;
        EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.mEGLDisplay = eglGetDisplay;
        this.mEGL.eglInitialize(eglGetDisplay, new int[2]);
        EGLConfig chooseConfig = chooseConfig();
        this.mEGLConfig = chooseConfig;
        if (chooseConfig != null) {
            this.mEGLContext = this.mEGL.eglCreateContext(this.mEGLDisplay, chooseConfig, EGL10.EGL_NO_CONTEXT, new int[]{EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION, 2, 12344});
            this.mEGLSurface = this.mEGL.eglCreatePbufferSurface(this.mEGLDisplay, this.mEGLConfig, iArr);
        }
    }

    private EGLConfig chooseConfig() {
        int[] iArr = {12325, 0, 12326, 0, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344};
        int[] iArr2 = new int[1];
        this.mEGL.eglChooseConfig(this.mEGLDisplay, iArr, null, 0, iArr2);
        int i3 = iArr2[0];
        if (i3 > 0) {
            EGLConfig[] eGLConfigArr = new EGLConfig[i3];
            this.mEGLConfigs = eGLConfigArr;
            this.mEGL.eglChooseConfig(this.mEGLDisplay, iArr, eGLConfigArr, i3, iArr2);
            return this.mEGLConfigs[0];
        }
        return null;
    }

    private int getConfigAttrib(EGLConfig eGLConfig, int i3) {
        int[] iArr = new int[1];
        if (!this.mEGL.eglGetConfigAttrib(this.mEGLDisplay, eGLConfig, i3, iArr)) {
            return 0;
        }
        return iArr[0];
    }

    private void listConfig() {
        LogUtils.i(TAG, "Config List {");
        for (EGLConfig eGLConfig : this.mEGLConfigs) {
            LogUtils.i(TAG, "    <d,s,r,g,b,a> = <" + getConfigAttrib(eGLConfig, 12325) + "," + getConfigAttrib(eGLConfig, 12326) + "," + getConfigAttrib(eGLConfig, 12324) + "," + getConfigAttrib(eGLConfig, 12323) + "," + getConfigAttrib(eGLConfig, 12322) + "," + getConfigAttrib(eGLConfig, 12321) + ">");
        }
        LogUtils.i(TAG, "}");
    }

    public void destroyEgl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        EGL10 egl10 = this.mEGL;
        EGLDisplay eGLDisplay = this.mEGLDisplay;
        EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
        egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
        if (this.mEGLConfig != null) {
            this.mEGL.eglDestroySurface(this.mEGLDisplay, this.mEGLSurface);
            this.mEGL.eglDestroyContext(this.mEGLDisplay, this.mEGLContext);
        }
        this.mEGL.eglTerminate(this.mEGLDisplay);
    }

    public boolean usecurruntContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (this.mEGLConfig == null) {
            return false;
        }
        EGL10 egl10 = this.mEGL;
        EGLDisplay eGLDisplay = this.mEGLDisplay;
        EGLSurface eGLSurface = this.mEGLSurface;
        return egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.mEGLContext);
    }
}
