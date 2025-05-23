package com.tencent.luggage.wxa.gb;

import android.opengl.GLSurfaceView;
import com.tencent.ark.EGLContextHolder;
import com.tencent.luggage.wxa.tn.f0;
import com.tencent.luggage.wxa.tn.w;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b implements GLSurfaceView.EGLContextFactory {

    /* renamed from: a, reason: collision with root package name */
    public final String f126676a = "MicroMsg.RenderContextFactory";

    /* renamed from: b, reason: collision with root package name */
    public final int f126677b = EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION;

    @Override // android.opengl.GLSurfaceView.EGLContextFactory
    public EGLContext createContext(EGL10 egl, EGLDisplay display, EGLConfig eglConfig) {
        Intrinsics.checkNotNullParameter(egl, "egl");
        Intrinsics.checkNotNullParameter(display, "display");
        Intrinsics.checkNotNullParameter(eglConfig, "eglConfig");
        w.f(this.f126676a, "creating OpenGL ES 2.0 context");
        EGLContext eglCreateContext = egl.eglCreateContext(display, eglConfig, EGL10.EGL_NO_CONTEXT, new int[]{this.f126677b, f0.e("mmkv_gl_key").a("support_egl_context_client_version", 3), 12344});
        Intrinsics.checkNotNullExpressionValue(eglCreateContext, "egl.eglCreateContext(dis\u2026_NO_CONTEXT, attrib_list)");
        return eglCreateContext;
    }

    @Override // android.opengl.GLSurfaceView.EGLContextFactory
    public void destroyContext(EGL10 egl, EGLDisplay display, EGLContext context) {
        Intrinsics.checkNotNullParameter(egl, "egl");
        Intrinsics.checkNotNullParameter(display, "display");
        Intrinsics.checkNotNullParameter(context, "context");
        w.f(this.f126676a, "destroyContext OpenGL ES 2.0 Context");
        egl.eglDestroyContext(display, context);
    }
}
