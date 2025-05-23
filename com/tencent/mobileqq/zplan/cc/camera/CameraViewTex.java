package com.tencent.mobileqq.zplan.cc.camera;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import com.epicgames.ue4.UE4;
import com.tencent.ark.EGLContextHolder;
import com.tencent.qphone.base.util.QLog;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

/* compiled from: P */
/* loaded from: classes35.dex */
public class CameraViewTex extends GLSurfaceView {

    /* renamed from: d, reason: collision with root package name */
    private boolean f332487d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class a implements GLSurfaceView.EGLContextFactory {
        a() {
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (CameraViewTex.this.f332487d) {
                eGLContext = CameraViewTex.this.e();
            }
            EGLContext d16 = CameraViewTex.this.d(egl10, eGLDisplay, eGLConfig, eGLContext, 3);
            return (d16 == null || d16 == EGL10.EGL_NO_CONTEXT) ? CameraViewTex.this.d(egl10, eGLDisplay, eGLConfig, eGLContext, 2) : d16;
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            egl10.eglDestroyContext(eGLDisplay, eGLContext);
        }
    }

    public CameraViewTex(Context context) {
        super(context);
        this.f332487d = false;
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EGLContext e() {
        try {
            return UE4.getCurrentContext();
        } catch (Exception e16) {
            QLog.e("ZPlanCamera", 1, e16, new Object[0]);
            return EGL10.EGL_NO_CONTEXT;
        }
    }

    private void f() {
        setEGLContextFactory(new a());
    }

    public void setNeedUEContext(boolean z16) {
        this.f332487d = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EGLContext d(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, EGLContext eGLContext, int i3) {
        try {
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, new int[]{EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION, i3, 12344});
        } catch (Exception unused) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("create egl context failed, eglVersion = ");
            sb5.append(i3);
            sb5.append(", has shared context = ");
            sb5.append(eGLContext != EGL10.EGL_NO_CONTEXT);
            QLog.i("ZPlanCamera", 1, sb5.toString());
            return EGL10.EGL_NO_CONTEXT;
        }
    }

    public CameraViewTex(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f332487d = false;
        f();
    }
}
