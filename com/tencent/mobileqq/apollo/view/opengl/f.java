package com.tencent.mobileqq.apollo.view.opengl;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

/* compiled from: P */
/* loaded from: classes11.dex */
public interface f {
    EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig);

    void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);
}
