package com.tencent.qfsmonet.gles;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.ark.EGLContextHolder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
@TargetApi(17)
/* loaded from: classes22.dex */
public class d {
    static IPatchRedirector $redirector_;

    private static EGLContext a(EGLDisplay eGLDisplay, @NonNull EGLConfig eGLConfig, EGLContext eGLContext, int i3) {
        if (eGLDisplay == EGL14.EGL_NO_DISPLAY) {
            com.tencent.qfsmonet.utils.a.b("MonetEGL14Utils", "create createEglContext failed!");
            return null;
        }
        EGLContext eglCreateContext = EGL14.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, new int[]{EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION, i3, 12344}, 0);
        com.tencent.qfsmonet.utils.a.c("MonetEGL14Utils", "create createEglContext!");
        return eglCreateContext;
    }

    @Nullable
    private static EGLContext b(@NonNull EGLDisplay eGLDisplay, @NonNull EGLConfig eGLConfig, @Nullable EGLContext eGLContext) {
        if (eGLContext == null) {
            eGLContext = EGL14.EGL_NO_CONTEXT;
        }
        EGLContext a16 = a(eGLDisplay, eGLConfig, eGLContext, 3);
        if (a16 == EGL14.EGL_NO_CONTEXT) {
            com.tencent.qfsmonet.utils.a.h("MonetEGL14Utils", "eglCreateContext OpenGL ES 3.0 failed! try OpenGL ES 2.0");
            return a(eGLDisplay, eGLConfig, eGLContext, 2);
        }
        return a16;
    }

    @Nullable
    public static EGLSurface c(@NonNull EGLDisplay eGLDisplay, @NonNull EGLConfig eGLConfig) {
        if (eGLDisplay == EGL14.EGL_NO_DISPLAY) {
            com.tencent.qfsmonet.utils.a.b("MonetEGL14Utils", "create eglCreatePbufferSurface failed!");
            return null;
        }
        EGLSurface eglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eGLDisplay, eGLConfig, new int[]{MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_WIDTH, 128, MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_HEIGHT, 128, 12344}, 0);
        com.tencent.qfsmonet.utils.a.c("MonetEGL14Utils", "create createOffScreenEglSurface!");
        return eglCreatePbufferSurface;
    }

    @Nullable
    public static EGLSurface d(EGLDisplay eGLDisplay, @NonNull EGLConfig eGLConfig, @NonNull Surface surface) {
        if (eGLDisplay == EGL14.EGL_NO_DISPLAY) {
            com.tencent.qfsmonet.utils.a.b("MonetEGL14Utils", "create createWindowSurface failed!");
            return null;
        }
        EGLSurface eglCreateWindowSurface = EGL14.eglCreateWindowSurface(eGLDisplay, eGLConfig, surface, new int[]{12344}, 0);
        com.tencent.qfsmonet.utils.a.c("MonetEGL14Utils", "create createWindowSurface!");
        return eglCreateWindowSurface;
    }

    @Nullable
    private static EGLConfig e(@NonNull EGLDisplay eGLDisplay) {
        EGLConfig a16 = a.a(eGLDisplay, 3);
        if (a16 == null) {
            com.tencent.qfsmonet.utils.a.h("MonetEGL14Utils", "create openGL ES 3.0 failed, try 2.0");
            return a.a(eGLDisplay, 2);
        }
        return a16;
    }

    @Nullable
    public static b f(EGLContext eGLContext) {
        EGL14.eglBindAPI(12448);
        EGLDisplay g16 = g();
        if (g16 == null) {
            com.tencent.qfsmonet.utils.a.b("MonetEGL14Utils", "initEGLDisplay failed!");
            return null;
        }
        EGLConfig e16 = e(g16);
        if (e16 == null) {
            com.tencent.qfsmonet.utils.a.b("MonetEGL14Utils", "getEglConfig failed! err=" + EGL14.eglGetError());
            EGL14.eglTerminate(g16);
            return null;
        }
        EGLContext b16 = b(g16, e16, eGLContext);
        if (b16 == EGL14.EGL_NO_CONTEXT) {
            com.tencent.qfsmonet.utils.a.b("MonetEGL14Utils", "eglCreateContext create failed! err=" + EGL14.eglGetError());
            EGL14.eglTerminate(g16);
            return null;
        }
        EGLSurface c16 = c(g16, e16);
        if (c16 == EGL14.EGL_NO_SURFACE) {
            com.tencent.qfsmonet.utils.a.b("MonetEGL14Utils", "createOffScreenEglSurface failed! err=" + EGL14.eglGetError());
            EGL14.eglDestroyContext(g16, b16);
            EGL14.eglTerminate(g16);
            return null;
        }
        if (!EGL14.eglMakeCurrent(g16, c16, c16, b16)) {
            com.tencent.qfsmonet.utils.a.b("MonetEGL14Utils", "eglMadeCurrent failed!err=" + EGL14.eglGetError());
            EGL14.eglDestroySurface(g16, c16);
            EGL14.eglDestroyContext(g16, b16);
            EGL14.eglTerminate(g16);
            return null;
        }
        com.tencent.qfsmonet.utils.a.c("MonetEGL14Utils", "eglContext init success!");
        b bVar = new b(g16, b16, e16);
        bVar.e(c16);
        return bVar;
    }

    @Nullable
    private static EGLDisplay g() {
        EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
        if (eglGetDisplay == EGL14.EGL_NO_DISPLAY) {
            com.tencent.qfsmonet.utils.a.b("MonetEGL14Utils", "eglGetDisplay failed!");
            return null;
        }
        int[] iArr = new int[2];
        if (!EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
            com.tencent.qfsmonet.utils.a.b("MonetEGL14Utils", "eglInitialize failed!");
            EGL14.eglTerminate(eglGetDisplay);
            return null;
        }
        com.tencent.qfsmonet.utils.a.c("MonetEGL14Utils", "gl version major:" + iArr[0] + ":minor:" + iArr[1]);
        return eglGetDisplay;
    }

    public static int h(EGLDisplay eGLDisplay, @NonNull EGLSurface eGLSurface, int i3) {
        if (eGLDisplay == EGL14.EGL_NO_DISPLAY) {
            com.tencent.qfsmonet.utils.a.b("MonetEGL14Utils", "querySurface failed, no init!");
            return 0;
        }
        int[] iArr = new int[1];
        if (!EGL14.eglQuerySurface(eGLDisplay, eGLSurface, i3, iArr, 0)) {
            return 0;
        }
        return iArr[0];
    }

    public static void i(@NonNull b bVar) {
        com.tencent.qfsmonet.utils.a.c("MonetEGL14Utils", "releaseEglContext start!");
        EGLDisplay c16 = bVar.c();
        EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
        EGL14.eglMakeCurrent(c16, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
        EGL14.eglDestroySurface(bVar.c(), bVar.d());
        EGL14.eglDestroyContext(bVar.c(), bVar.b());
        EGL14.eglTerminate(bVar.c());
        EGL14.eglReleaseThread();
        com.tencent.qfsmonet.utils.a.c("MonetEGL14Utils", "releaseEglContext end");
    }

    public static void j(EGLDisplay eGLDisplay, @NonNull EGLSurface eGLSurface) {
        if (eGLDisplay == EGL14.EGL_NO_DISPLAY) {
            com.tencent.qfsmonet.utils.a.b("MonetEGL14Utils", "swapEglBuffer failed!");
        } else {
            EGL14.eglSwapBuffers(eGLDisplay, eGLSurface);
        }
    }

    public static boolean k(EGLDisplay eGLDisplay, EGLContext eGLContext, @NonNull EGLSurface eGLSurface, EGLSurface eGLSurface2) {
        if (eGLDisplay == EGL14.EGL_NO_DISPLAY) {
            com.tencent.qfsmonet.utils.a.b("MonetEGL14Utils", "switchElgContext failed, no init!");
            return false;
        }
        EGLSurface eGLSurface3 = EGL14.EGL_NO_SURFACE;
        if (eGLSurface2 == eGLSurface3) {
            com.tencent.qfsmonet.utils.a.b("MonetEGL14Utils", "switchElgContext failed, eglSurface invalid!");
            return false;
        }
        EGL14.eglMakeCurrent(eGLDisplay, eGLSurface3, eGLSurface3, eGLContext);
        EGL14.eglDestroySurface(eGLDisplay, eGLSurface);
        EGL14.eglMakeCurrent(eGLDisplay, eGLSurface2, eGLSurface2, eGLContext);
        return true;
    }
}
