package com.tencent.mobileqq.ar;

import android.annotation.TargetApi;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLUtils;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import com.tencent.ark.EGLContextHolder;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.opengles.GL;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@TargetApi(14)
/* loaded from: classes11.dex */
public class ARGLSurfaceView extends GLSurfaceView {

    /* renamed from: d, reason: collision with root package name */
    private boolean f196788d;

    /* renamed from: e, reason: collision with root package name */
    private d f196789e;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements GLSurfaceView.EGLContextFactory {

        /* renamed from: a, reason: collision with root package name */
        private int f196790a = EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.ar.ARGLSurfaceView$a$a, reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        class C7394a extends EGLContext {
            C7394a() {
            }

            @Override // javax.microedition.khronos.egl.EGLContext
            public GL getGL() {
                return null;
            }
        }

        a() {
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            QLog.i("AREngine_ARGLSurfaceView", 1, "createContext. display = " + eGLDisplay + " config=" + eGLConfig);
            if (eGLConfig != null && eGLDisplay != null) {
                return egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{this.f196790a, 2, 12344});
            }
            return new C7394a();
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (ARGLSurfaceView.this.f196789e != null) {
                ARGLSurfaceView.this.f196789e.Qe();
            }
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                QLog.e("AREngine_ARGLSurfaceView", 1, "destroyContext. display = " + eGLDisplay + " context = " + eGLContext + " tid = " + Thread.currentThread().getId());
            }
            QLog.i("AREngine_ARGLSurfaceView", 1, "destroyContext. display = " + eGLDisplay + " context = " + eGLContext + " tid = " + Thread.currentThread().getId());
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    private static class b implements GLSurfaceView.EGLConfigChooser {

        /* renamed from: b, reason: collision with root package name */
        private int[] f196794b = new int[1];

        /* renamed from: c, reason: collision with root package name */
        protected int f196795c = 8;

        /* renamed from: d, reason: collision with root package name */
        protected int f196796d = 8;

        /* renamed from: e, reason: collision with root package name */
        protected int f196797e = 8;

        /* renamed from: f, reason: collision with root package name */
        protected int f196798f = 8;

        /* renamed from: g, reason: collision with root package name */
        protected int f196799g = 16;

        /* renamed from: h, reason: collision with root package name */
        protected int f196800h = 0;

        /* renamed from: a, reason: collision with root package name */
        protected int[] f196793a = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 16, 12326, 0, 12352, 4, 12344};

        private int b(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i3, int i16) {
            if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i3, this.f196794b)) {
                return this.f196794b[0];
            }
            return i16;
        }

        public EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            int i3 = 0;
            int i16 = 0;
            while (true) {
                if (i3 < eGLConfigArr.length) {
                    int b16 = b(egl10, eGLDisplay, eGLConfigArr[i3], 12325, 0);
                    int b17 = b(egl10, eGLDisplay, eGLConfigArr[i3], 12326, 0);
                    int b18 = b(egl10, eGLDisplay, eGLConfigArr[i3], 12324, 0);
                    int b19 = b(egl10, eGLDisplay, eGLConfigArr[i3], 12323, 0);
                    int b26 = b(egl10, eGLDisplay, eGLConfigArr[i3], 12322, 0);
                    int b27 = b(egl10, eGLDisplay, eGLConfigArr[i3], 12321, 0);
                    QLog.d("AREngine_ARGLSurfaceView", 1, "findConfigAttrib configs[" + i3 + "] EGL_DEPTH_SIZE=" + b16 + " EGL_STENCIL_SIZE=" + b17 + " EGL_RED_SIZE=" + b18 + " EGL_GREEN_SIZE=" + b19 + " EGL_BLUE_SIZE=" + b26 + " EGL_ALPHA_SIZE=" + b27);
                    if (b18 == this.f196795c && b19 == this.f196796d && b26 == this.f196797e && b27 == this.f196798f) {
                        if (b16 >= this.f196799g && b17 >= this.f196800h) {
                            break;
                        }
                        i16 = i3;
                    }
                    i3++;
                } else {
                    i3 = i16;
                    break;
                }
            }
            return eGLConfigArr[i3];
        }

        @Override // android.opengl.GLSurfaceView.EGLConfigChooser
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            while (true) {
                int[] iArr2 = this.f196793a;
                if (i3 >= iArr2.length - 2) {
                    break;
                }
                int i16 = i3 + 1;
                if (!egl10.eglChooseConfig(eGLDisplay, new int[]{iArr2[i3], iArr2[i16], 12344}, null, 0, iArr)) {
                    QLog.e("AREngine_ARGLSurfaceView", 1, "eglChooseConfig failed, i=" + i3 + " key=" + this.f196793a[i3] + " value=" + this.f196793a[i16] + " " + egl10.eglGetError() + " " + GLUtils.getEGLErrorString(egl10.eglGetError()));
                } else if (iArr[0] <= 0) {
                    QLog.e("AREngine_ARGLSurfaceView", 1, "eglChooseConfig#2 failed, i=" + i3 + " key=" + this.f196793a[i3] + " value=" + this.f196793a[i16]);
                } else {
                    arrayList.add(Integer.valueOf(this.f196793a[i3]));
                    arrayList.add(Integer.valueOf(this.f196793a[i16]));
                }
                i3 += 2;
            }
            arrayList.add(12344);
            int size = arrayList.size() / 2;
            iArr[0] = size;
            QLog.d("AREngine_ARGLSurfaceView", 1, "chooseConfig1 workConfigSpec size=" + size);
            if (size <= 0) {
                QLog.e("AREngine_ARGLSurfaceView", 1, "eglChooseConfig failed");
                return null;
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[size];
            int[] iArr3 = new int[arrayList.size()];
            for (int i17 = 0; i17 < arrayList.size(); i17++) {
                iArr3[i17] = ((Integer) arrayList.get(i17)).intValue();
            }
            if (!egl10.eglChooseConfig(eGLDisplay, iArr3, eGLConfigArr, size, iArr)) {
                QLog.e("AREngine_ARGLSurfaceView", 1, "eglChooseConfig#2 failed");
                return null;
            }
            EGLConfig a16 = a(egl10, eGLDisplay, eGLConfigArr);
            if (a16 == null) {
                QLog.e("AREngine_ARGLSurfaceView", 1, "No config chosen");
            }
            return a16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface c {
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface d {
        void Qe();
    }

    public ARGLSurfaceView(Context context, SurfaceHolder.Callback callback, c cVar) {
        super(context);
        QLog.i("AREngine_ARGLSurfaceView", 1, "create ARGLSurfaceView. context = " + context + ", holderCallback = " + callback + ", surfaceViewCallback = " + cVar);
        setEGLContextFactory(new a());
        setEGLContextClientVersion(2);
        if (f()) {
            setEGLConfigChooser(new b());
            QLog.d("AREngine_ARGLSurfaceView", 1, "use new chooser.");
        } else {
            setEGLConfigChooser(8, 8, 8, 8, 16, 0);
            QLog.d("AREngine_ARGLSurfaceView", 1, "use old chooser.");
        }
        getHolder().setFormat(1);
        if (callback != null) {
            getHolder().addCallback(callback);
        }
        this.f196788d = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("ar_surfaceview_resume_pause_sub_thread", false);
        QLog.i("AREngine_ARGLSurfaceView", 1, "superMethodPostSubThread=" + this.f196788d);
    }

    private boolean f() {
        try {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                return false;
            }
            return ((IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("ARGLSurfaceView_chooseConfig_new", false);
        } catch (Exception e16) {
            QLog.e("AREngine_ARGLSurfaceView", 1, "getIsFeatureSwitchEnable exception " + e16.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g() {
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h() {
        super.onResume();
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        if (this.f196788d) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.ar.c
                @Override // java.lang.Runnable
                public final void run() {
                    ARGLSurfaceView.this.g();
                }
            }, 16, null, false);
        } else {
            super.onPause();
        }
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        if (this.f196788d) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.ar.b
                @Override // java.lang.Runnable
                public final void run() {
                    ARGLSurfaceView.this.h();
                }
            }, 16, null, false);
        } else {
            super.onResume();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return false;
    }

    public void setOnEglContextDestoryListener(d dVar) {
        this.f196789e = dVar;
    }

    @Override // android.opengl.GLSurfaceView
    @Deprecated
    public void setRenderer(GLSurfaceView.Renderer renderer) {
        super.setRenderer(renderer);
    }
}
