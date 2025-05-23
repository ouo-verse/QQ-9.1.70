package com.tencent.mobileqq.armap;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.opengl.GLSurfaceView;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.WindowManager;
import com.tencent.ark.EGLContextHolder;
import com.tencent.mobileqq.armap.ARMapTracer;
import com.tencent.mobileqq.armap.sensor.a;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ARGLSurfaceView extends GLSurfaceView implements GLSurfaceView.Renderer, a.InterfaceC7424a {
    static IPatchRedirector $redirector_ = null;
    public static final int ACCELER_TYPE = 1;
    public static long FPS_LIMIT = 0;
    public static boolean FPS_LIMIT_SWITCH = false;
    public static final int GYROSCOPE_TYPE = 2;
    public static final long MAX_FPS_LIMIT = 33;
    private static final String TAG = "ARGLSurfaceView";
    private TraceCallback mCallback;
    private Activity mCurActivity;
    protected long mEngineHandler;
    private long mFrameCount;
    private long mFrameLastFPS;
    public long mFrameRate;
    private volatile boolean mIsContextDestroyed;
    volatile boolean mIsDestroyed;
    private boolean mIsSupportPreserveEGLContextOnPause;
    private a.InterfaceC7424a mSensorListener;
    public com.tencent.mobileqq.armap.sensor.a mSensorManager;
    private SurfaceStateListener mSurfaceStateListener;
    private OrientationEventListener orientationListener;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface SurfaceStateListener {
        void onDestroy();

        void onEGLConfigCreated(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, EGLContext eGLContext, long j3);

        void onEGLContextDestroyed(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);

        void onInit(long j3);

        void onPause();

        void onResume();

        void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig);
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface TraceCallback {
        void endTrace();

        void startTrace();

        void trace(long j3);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(70846);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 55)) {
            redirector.redirect((short) 55);
        } else {
            FPS_LIMIT = 33L;
            FPS_LIMIT_SWITCH = false;
        }
    }

    public ARGLSurfaceView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mIsSupportPreserveEGLContextOnPause = true;
        this.mIsDestroyed = false;
        this.mIsContextDestroyed = false;
        this.mFrameCount = 0L;
        this.mFrameLastFPS = 0L;
        this.mFrameRate = 0L;
    }

    public static native void nataiveSetCameraTexture(long j3, int i3);

    public static native void nativeSetLogLevel(int i3);

    /* JADX INFO: Access modifiers changed from: private */
    public native void native_destroy(long j3);

    /* JADX INFO: Access modifiers changed from: private */
    public native long native_init(Activity activity, AssetManager assetManager, String str, int i3);

    /* JADX INFO: Access modifiers changed from: private */
    public native void native_onContextDestroy(long j3);

    /* JADX INFO: Access modifiers changed from: private */
    public native long native_onOrientationChanged(int i3);

    /* JADX INFO: Access modifiers changed from: private */
    public native void native_onTouchBegin(int i3, float f16, float f17, int i16, long j3, long j16);

    /* JADX INFO: Access modifiers changed from: private */
    public native void native_onTouchCancel(int[] iArr, float[] fArr, float[] fArr2, long j3, long j16);

    /* JADX INFO: Access modifiers changed from: private */
    public native void native_onTouchEnd(int i3, float f16, float f17, int i16, long j3, long j16);

    /* JADX INFO: Access modifiers changed from: private */
    public native void native_onTouchMove(int[] iArr, float[] fArr, float[] fArr2, long j3, long j16);

    /* JADX INFO: Access modifiers changed from: private */
    public native void native_pause(long j3);

    /* JADX INFO: Access modifiers changed from: private */
    public native void native_resume(long j3);

    public static native void setDrawTexture(long j3, int i3);

    public static native void setVideoSize(long j3, int i3, int i16);

    public long getEngineHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Long) iPatchRedirector.redirect((short) 33, (Object) this)).longValue();
        }
        return this.mEngineHandler;
    }

    @TargetApi(11)
    public void init(Activity activity, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, activity, str, Integer.valueOf(i3));
            return;
        }
        this.mCurActivity = activity;
        setEGLContextClientVersion(2);
        setPreserveEGLContextOnPause(this.mIsSupportPreserveEGLContextOnPause);
        setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        setEGLContextFactory(new GLSurfaceView.EGLContextFactory() { // from class: com.tencent.mobileqq.armap.ARGLSurfaceView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ARGLSurfaceView.this);
                }
            }

            @Override // android.opengl.GLSurfaceView.EGLContextFactory
            public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (EGLContext) iPatchRedirector2.redirect((short) 2, this, egl10, eGLDisplay, eGLConfig);
                }
                QLog.d(ARGLSurfaceView.TAG, 2, "createContext start");
                if (egl10.eglGetError() == 12288) {
                    ARGLSurfaceView.this.mIsContextDestroyed = false;
                    EGLContext eglCreateContext = egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION, 2, 12344});
                    if (egl10.eglGetError() == 12288) {
                        if (ARGLSurfaceView.this.mSurfaceStateListener != null) {
                            ARGLSurfaceView.this.mSurfaceStateListener.onEGLConfigCreated(egl10, eGLDisplay, eGLConfig, eglCreateContext, ARGLSurfaceView.this.mEngineHandler);
                        }
                        return eglCreateContext;
                    }
                    throw new RuntimeException("createContext error:" + egl10.eglGetError());
                }
                throw new RuntimeException("createContext error:" + egl10.eglGetError());
            }

            @Override // android.opengl.GLSurfaceView.EGLContextFactory
            public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, this, egl10, eGLDisplay, eGLContext);
                    return;
                }
                QLog.d(ARGLSurfaceView.TAG, 2, "destroyContext");
                ARGLSurfaceView.this.mIsContextDestroyed = true;
                if (ARGLSurfaceView.this.mSurfaceStateListener != null) {
                    ARGLSurfaceView.this.mSurfaceStateListener.onEGLContextDestroyed(egl10, eGLDisplay, eGLContext);
                }
                if (ARGLSurfaceView.this.mIsDestroyed) {
                    ARGLSurfaceView aRGLSurfaceView = ARGLSurfaceView.this;
                    long j3 = aRGLSurfaceView.mEngineHandler;
                    if (j3 != 0) {
                        aRGLSurfaceView.native_destroy(j3);
                        ARGLSurfaceView.this.mEngineHandler = 0L;
                    }
                }
                ARGLSurfaceView aRGLSurfaceView2 = ARGLSurfaceView.this;
                long j16 = aRGLSurfaceView2.mEngineHandler;
                if (j16 != 0) {
                    aRGLSurfaceView2.native_onContextDestroy(j16);
                }
                egl10.eglDestroyContext(eGLDisplay, eGLContext);
            }
        });
        setRenderer(this);
        setRenderMode(1);
        queueEvent(new Runnable(activity, str, i3) { // from class: com.tencent.mobileqq.armap.ARGLSurfaceView.2
            static IPatchRedirector $redirector_;
            final /* synthetic */ Activity val$activity;
            final /* synthetic */ int val$code;
            final /* synthetic */ String val$resPath;

            {
                this.val$activity = activity;
                this.val$resPath = str;
                this.val$code = i3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, ARGLSurfaceView.this, activity, str, Integer.valueOf(i3));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (QLog.isDevelopLevel()) {
                    ARGLSurfaceView.nativeSetLogLevel(4);
                } else if (QLog.isColorLevel()) {
                    ARGLSurfaceView.nativeSetLogLevel(2);
                } else {
                    ARGLSurfaceView.nativeSetLogLevel(1);
                }
                ARGLSurfaceView aRGLSurfaceView = ARGLSurfaceView.this;
                Activity activity2 = this.val$activity;
                aRGLSurfaceView.mEngineHandler = aRGLSurfaceView.native_init(activity2, activity2.getAssets(), this.val$resPath, this.val$code);
                if (ARGLSurfaceView.this.mSurfaceStateListener != null) {
                    ARGLSurfaceView.this.mSurfaceStateListener.onInit(ARGLSurfaceView.this.mEngineHandler);
                }
            }
        });
        this.orientationListener = new OrientationEventListener(activity, activity) { // from class: com.tencent.mobileqq.armap.ARGLSurfaceView.3
            static IPatchRedirector $redirector_;
            final /* synthetic */ Activity val$activity;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(activity);
                this.val$activity = activity;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, ARGLSurfaceView.this, activity, activity);
                }
            }

            @Override // android.view.OrientationEventListener
            public void onOrientationChanged(int i16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, i16);
                } else if (i16 != -1) {
                    ARGLSurfaceView.this.queueEvent(new Runnable(((WindowManager) this.val$activity.getSystemService("window")).getDefaultDisplay().getRotation()) { // from class: com.tencent.mobileqq.armap.ARGLSurfaceView.3.1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ int val$rotation;

                        {
                            this.val$rotation = r5;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass3.this, r5);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                                ARGLSurfaceView.this.native_onOrientationChanged(this.val$rotation);
                            } else {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            }
                        }
                    });
                }
            }
        };
    }

    public void initSensor(a.InterfaceC7424a interfaceC7424a, int i3) {
        Activity activity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) interfaceC7424a, i3);
        } else if (this.mSensorManager == null && (activity = this.mCurActivity) != null) {
            this.mSensorManager = new com.tencent.mobileqq.armap.sensor.a(activity, i3);
            this.mSensorListener = interfaceC7424a;
        }
    }

    public native void nativeCameraTextureM(long j3, float[] fArr);

    public native void nativeSetCameraBgTexture(long j3, int i3);

    public native void nativeSetCameraYUVTexture(long j3, int i3, int i16, int i17);

    public native void nativeTextureM(long j3, float[] fArr);

    public native void nativeUpdatePerfLevel(int i3);

    public native void nativeUpdateRotation(long j3, float f16, float f17, float f18);

    public native void nativeUpdateRotationM(long j3, float[] fArr);

    public native void native_onDrawFrame(long j3);

    public native void native_onSensorChanged(float f16, float f17, float f18, long j3, int i3);

    public native void native_onSurfaceChanged(long j3, int i3, int i16);

    public native void native_onSurfaceCreated(long j3, int i3, int i16);

    public native void native_setSensorSupport(int i3, boolean z16);

    public native void native_updateAccel(float f16, float f17, float f18);

    public native void native_updateAzimuth(long j3, float f16);

    public native void native_updateHongbaoNumber(long j3, int i3, int i16, int[] iArr);

    public native void native_updatePitch(long j3, float f16);

    public native void native_updateQuaternion(float f16, float f17, float f18, float f19);

    public native void native_updateRoll(long j3, float f16);

    public native void native_updateSensor(long j3, float f16, float f17, float f18);

    public native void nativestopRenderScene(long j3);

    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        SurfaceStateListener surfaceStateListener = this.mSurfaceStateListener;
        if (surfaceStateListener != null) {
            surfaceStateListener.onDestroy();
        }
        this.mIsDestroyed = true;
        super.queueEvent(new Runnable() { // from class: com.tencent.mobileqq.armap.ARGLSurfaceView.6
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ARGLSurfaceView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                ARGLSurfaceView aRGLSurfaceView = ARGLSurfaceView.this;
                long j3 = aRGLSurfaceView.mEngineHandler;
                if (j3 != 0) {
                    aRGLSurfaceView.native_destroy(j3);
                    ARGLSurfaceView.this.mEngineHandler = 0L;
                }
            }
        });
        TraceCallback traceCallback = this.mCallback;
        if (traceCallback != null) {
            traceCallback.endTrace();
        }
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
        } else {
            this.mIsDestroyed = true;
            super.onDetachedFromWindow();
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) gl10);
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j3 = this.mEngineHandler;
        if (j3 != 0) {
            native_onDrawFrame(j3);
        }
        updateFPSRate(elapsedRealtime);
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        super.onPause();
        this.orientationListener.disable();
        queueEvent(new Runnable() { // from class: com.tencent.mobileqq.armap.ARGLSurfaceView.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ARGLSurfaceView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    ARGLSurfaceView aRGLSurfaceView = ARGLSurfaceView.this;
                    aRGLSurfaceView.native_pause(aRGLSurfaceView.mEngineHandler);
                }
            }
        });
        SurfaceStateListener surfaceStateListener = this.mSurfaceStateListener;
        if (surfaceStateListener != null) {
            surfaceStateListener.onPause();
        }
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        super.onResume();
        this.orientationListener.enable();
        queueEvent(new Runnable() { // from class: com.tencent.mobileqq.armap.ARGLSurfaceView.5
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ARGLSurfaceView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    ARGLSurfaceView aRGLSurfaceView = ARGLSurfaceView.this;
                    aRGLSurfaceView.native_resume(aRGLSurfaceView.mEngineHandler);
                }
            }
        });
        SurfaceStateListener surfaceStateListener = this.mSurfaceStateListener;
        if (surfaceStateListener != null) {
            surfaceStateListener.onResume();
        }
    }

    @Override // com.tencent.mobileqq.armap.sensor.a.InterfaceC7424a
    public void onRotationUpdateOriginal(float[] fArr) {
        a.InterfaceC7424a interfaceC7424a;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) fArr);
        } else if (this.mEngineHandler != 0 && (interfaceC7424a = this.mSensorListener) != null) {
            interfaceC7424a.onRotationUpdateOriginal(fArr);
        }
    }

    @Override // com.tencent.mobileqq.armap.sensor.a.InterfaceC7424a
    public void onRotationUpdateQuaternion(float[] fArr) {
        a.InterfaceC7424a interfaceC7424a;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) fArr);
        } else if (this.mEngineHandler != 0 && (interfaceC7424a = this.mSensorListener) != null) {
            interfaceC7424a.onRotationUpdateQuaternion(fArr);
        }
    }

    @Override // com.tencent.mobileqq.armap.sensor.a.InterfaceC7424a
    public void onSensorSupport(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        queueEvent(new Runnable(i3, z16) { // from class: com.tencent.mobileqq.armap.ARGLSurfaceView.19
            static IPatchRedirector $redirector_;
            final /* synthetic */ boolean val$isSupport;
            final /* synthetic */ int val$type;

            {
                this.val$type = i3;
                this.val$isSupport = z16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, ARGLSurfaceView.this, Integer.valueOf(i3), Boolean.valueOf(z16));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    ARGLSurfaceView.this.native_setSensorSupport(this.val$type, this.val$isSupport);
                }
            }
        });
        a.InterfaceC7424a interfaceC7424a = this.mSensorListener;
        if (interfaceC7424a != null) {
            interfaceC7424a.onSensorSupport(i3, z16);
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, gl10, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        long j3 = this.mEngineHandler;
        if (j3 != 0) {
            native_onSurfaceChanged(j3, i3, i16);
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) gl10, (Object) eGLConfig);
            return;
        }
        long j3 = this.mEngineHandler;
        if (j3 != 0) {
            native_onSurfaceCreated(j3, getMeasuredWidth(), getMeasuredHeight());
            SurfaceStateListener surfaceStateListener = this.mSurfaceStateListener;
            if (surfaceStateListener != null) {
                surfaceStateListener.onSurfaceCreated(gl10, eGLConfig);
            }
        }
        if (QLog.isDevelopLevel()) {
            nativeSetLogLevel(4);
        } else if (QLog.isColorLevel()) {
            nativeSetLogLevel(2);
        } else {
            nativeSetLogLevel(1);
        }
        TraceCallback traceCallback = this.mCallback;
        if (traceCallback != null) {
            traceCallback.startTrace();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) motionEvent)).booleanValue();
        }
        int pointerCount = motionEvent.getPointerCount();
        int[] iArr = new int[pointerCount];
        float[] fArr = new float[pointerCount];
        float[] fArr2 = new float[pointerCount];
        for (int i3 = 0; i3 < pointerCount; i3++) {
            iArr[i3] = motionEvent.getPointerId(i3);
            fArr[i3] = motionEvent.getX(i3);
            fArr2[i3] = motionEvent.getY(i3);
        }
        long currentTimeMillis = System.currentTimeMillis();
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        if (action != 5) {
                            if (action == 6) {
                                int action2 = motionEvent.getAction() >> 8;
                                queueEvent(new Runnable(motionEvent.getPointerId(action2), motionEvent.getX(action2), motionEvent.getY(action2), currentTimeMillis) { // from class: com.tencent.mobileqq.armap.ARGLSurfaceView.10
                                    static IPatchRedirector $redirector_;
                                    final /* synthetic */ int val$idPointerUp;
                                    final /* synthetic */ long val$timestamp;
                                    final /* synthetic */ float val$xPointerUp;
                                    final /* synthetic */ float val$yPointerUp;

                                    {
                                        this.val$idPointerUp = r6;
                                        this.val$xPointerUp = r7;
                                        this.val$yPointerUp = r8;
                                        this.val$timestamp = currentTimeMillis;
                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                            iPatchRedirector2.redirect((short) 1, this, ARGLSurfaceView.this, Integer.valueOf(r6), Float.valueOf(r7), Float.valueOf(r8), Long.valueOf(currentTimeMillis));
                                        }
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                            iPatchRedirector2.redirect((short) 2, (Object) this);
                                        } else {
                                            ARGLSurfaceView aRGLSurfaceView = ARGLSurfaceView.this;
                                            aRGLSurfaceView.native_onTouchEnd(this.val$idPointerUp, this.val$xPointerUp, this.val$yPointerUp, 6, this.val$timestamp, aRGLSurfaceView.mEngineHandler);
                                        }
                                    }
                                });
                            }
                        } else {
                            int action3 = motionEvent.getAction() >> 8;
                            queueEvent(new Runnable(motionEvent.getPointerId(action3), motionEvent.getX(action3), motionEvent.getY(action3), currentTimeMillis) { // from class: com.tencent.mobileqq.armap.ARGLSurfaceView.7
                                static IPatchRedirector $redirector_;
                                final /* synthetic */ int val$idPointerDown;
                                final /* synthetic */ long val$timestamp;
                                final /* synthetic */ float val$xPointerDown;
                                final /* synthetic */ float val$yPointerDown;

                                {
                                    this.val$idPointerDown = r6;
                                    this.val$xPointerDown = r7;
                                    this.val$yPointerDown = r8;
                                    this.val$timestamp = currentTimeMillis;
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                        iPatchRedirector2.redirect((short) 1, this, ARGLSurfaceView.this, Integer.valueOf(r6), Float.valueOf(r7), Float.valueOf(r8), Long.valueOf(currentTimeMillis));
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                        iPatchRedirector2.redirect((short) 2, (Object) this);
                                    } else {
                                        ARGLSurfaceView aRGLSurfaceView = ARGLSurfaceView.this;
                                        aRGLSurfaceView.native_onTouchBegin(this.val$idPointerDown, this.val$xPointerDown, this.val$yPointerDown, 5, this.val$timestamp, aRGLSurfaceView.mEngineHandler);
                                    }
                                }
                            });
                        }
                    } else {
                        queueEvent(new Runnable(iArr, fArr, fArr2, currentTimeMillis) { // from class: com.tencent.mobileqq.armap.ARGLSurfaceView.12
                            static IPatchRedirector $redirector_;
                            final /* synthetic */ int[] val$ids;
                            final /* synthetic */ long val$timestamp;
                            final /* synthetic */ float[] val$xs;
                            final /* synthetic */ float[] val$ys;

                            {
                                this.val$ids = iArr;
                                this.val$xs = fArr;
                                this.val$ys = fArr2;
                                this.val$timestamp = currentTimeMillis;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, this, ARGLSurfaceView.this, iArr, fArr, fArr2, Long.valueOf(currentTimeMillis));
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                } else {
                                    ARGLSurfaceView aRGLSurfaceView = ARGLSurfaceView.this;
                                    aRGLSurfaceView.native_onTouchCancel(this.val$ids, this.val$xs, this.val$ys, this.val$timestamp, aRGLSurfaceView.mEngineHandler);
                                }
                            }
                        });
                    }
                } else {
                    queueEvent(new Runnable(iArr, fArr, fArr2, currentTimeMillis) { // from class: com.tencent.mobileqq.armap.ARGLSurfaceView.9
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ int[] val$ids;
                        final /* synthetic */ long val$timestamp;
                        final /* synthetic */ float[] val$xs;
                        final /* synthetic */ float[] val$ys;

                        {
                            this.val$ids = iArr;
                            this.val$xs = fArr;
                            this.val$ys = fArr2;
                            this.val$timestamp = currentTimeMillis;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, ARGLSurfaceView.this, iArr, fArr, fArr2, Long.valueOf(currentTimeMillis));
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            } else {
                                ARGLSurfaceView aRGLSurfaceView = ARGLSurfaceView.this;
                                aRGLSurfaceView.native_onTouchMove(this.val$ids, this.val$xs, this.val$ys, this.val$timestamp, aRGLSurfaceView.mEngineHandler);
                            }
                        }
                    });
                }
            } else {
                queueEvent(new Runnable(motionEvent.getPointerId(0), fArr[0], fArr2[0], currentTimeMillis) { // from class: com.tencent.mobileqq.armap.ARGLSurfaceView.11
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ int val$idUp;
                    final /* synthetic */ long val$timestamp;
                    final /* synthetic */ float val$xUp;
                    final /* synthetic */ float val$yUp;

                    {
                        this.val$idUp = r6;
                        this.val$xUp = r7;
                        this.val$yUp = r8;
                        this.val$timestamp = currentTimeMillis;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, ARGLSurfaceView.this, Integer.valueOf(r6), Float.valueOf(r7), Float.valueOf(r8), Long.valueOf(currentTimeMillis));
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            ARGLSurfaceView aRGLSurfaceView = ARGLSurfaceView.this;
                            aRGLSurfaceView.native_onTouchEnd(this.val$idUp, this.val$xUp, this.val$yUp, 1, this.val$timestamp, aRGLSurfaceView.mEngineHandler);
                        }
                    }
                });
            }
        } else {
            queueEvent(new Runnable(motionEvent.getPointerId(0), fArr[0], fArr2[0], currentTimeMillis) { // from class: com.tencent.mobileqq.armap.ARGLSurfaceView.8
                static IPatchRedirector $redirector_;
                final /* synthetic */ int val$idDown;
                final /* synthetic */ long val$timestamp;
                final /* synthetic */ float val$xDown;
                final /* synthetic */ float val$yDown;

                {
                    this.val$idDown = r6;
                    this.val$xDown = r7;
                    this.val$yDown = r8;
                    this.val$timestamp = currentTimeMillis;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, ARGLSurfaceView.this, Integer.valueOf(r6), Float.valueOf(r7), Float.valueOf(r8), Long.valueOf(currentTimeMillis));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        ARGLSurfaceView aRGLSurfaceView = ARGLSurfaceView.this;
                        aRGLSurfaceView.native_onTouchBegin(this.val$idDown, this.val$xDown, this.val$yDown, 0, this.val$timestamp, aRGLSurfaceView.mEngineHandler);
                    }
                }
            });
        }
        super.onTouchEvent(motionEvent);
        return true;
    }

    @Override // android.opengl.GLSurfaceView
    public void queueEvent(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) runnable);
        } else if (!this.mIsContextDestroyed) {
            super.queueEvent(ARMapTracer.GLHackTask.a(runnable, this));
        }
    }

    public void resumeSensor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        com.tencent.mobileqq.armap.sensor.a aVar = this.mSensorManager;
        if (aVar != null) {
            aVar.e(this);
        }
    }

    public void runOnGlThread(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) runnable);
        } else {
            queueEvent(runnable);
        }
    }

    public boolean sensorAvailable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Boolean) iPatchRedirector.redirect((short) 32, (Object) this)).booleanValue();
        }
        com.tencent.mobileqq.armap.sensor.a aVar = this.mSensorManager;
        if (aVar != null) {
            return aVar.a();
        }
        return false;
    }

    public void setLowFPSRate(boolean z16, long j3, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), Long.valueOf(j3), Boolean.valueOf(z17));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format(Locale.getDefault(), "setLowFPSRate fromDPC=%s enable=%s fpsLimit=%d", Boolean.valueOf(z17), Boolean.valueOf(z16), Long.valueOf(j3)));
        }
        FPS_LIMIT_SWITCH = z16;
        if (z17 && (j3 < 0 || j3 > 33)) {
            j3 = 33;
        }
        FPS_LIMIT = j3;
    }

    public native void setShouldShowGameTipsNative(boolean z16);

    public void setSurfaceStateListener(SurfaceStateListener surfaceStateListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) surfaceStateListener);
        } else {
            this.mSurfaceStateListener = surfaceStateListener;
        }
    }

    public void setTraceCallback(TraceCallback traceCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) traceCallback);
        } else {
            this.mCallback = traceCallback;
        }
    }

    public void stopSensor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        com.tencent.mobileqq.armap.sensor.a aVar = this.mSensorManager;
        if (aVar != null) {
            aVar.g();
        }
    }

    @Override // com.tencent.mobileqq.armap.sensor.a.InterfaceC7424a
    public void updateAccelerometer(float f16, float f17, float f18, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Long.valueOf(j3));
            return;
        }
        queueEvent(new Runnable(f16, f17, f18, j3) { // from class: com.tencent.mobileqq.armap.ARGLSurfaceView.13
            static IPatchRedirector $redirector_;
            final /* synthetic */ long val$timestamp;
            final /* synthetic */ float val$x;
            final /* synthetic */ float val$y;
            final /* synthetic */ float val$z;

            {
                this.val$x = f16;
                this.val$y = f17;
                this.val$z = f18;
                this.val$timestamp = j3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, ARGLSurfaceView.this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Long.valueOf(j3));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    ARGLSurfaceView.this.native_onSensorChanged(this.val$x, this.val$y, this.val$z, this.val$timestamp, 1);
                }
            }
        });
        a.InterfaceC7424a interfaceC7424a = this.mSensorListener;
        if (interfaceC7424a != null) {
            interfaceC7424a.updateAccelerometer(f16, f17, f18, j3);
        }
    }

    @Override // com.tencent.mobileqq.armap.sensor.a.InterfaceC7424a
    public void updateAzimuth(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, Float.valueOf(f16));
            return;
        }
        if (this.mEngineHandler != 0) {
            queueEvent(new Runnable(f16) { // from class: com.tencent.mobileqq.armap.ARGLSurfaceView.16
                static IPatchRedirector $redirector_;
                final /* synthetic */ float val$azimuth;

                {
                    this.val$azimuth = f16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, ARGLSurfaceView.this, Float.valueOf(f16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        ARGLSurfaceView aRGLSurfaceView = ARGLSurfaceView.this;
                        aRGLSurfaceView.native_updateAzimuth(aRGLSurfaceView.mEngineHandler, this.val$azimuth);
                    }
                }
            });
            a.InterfaceC7424a interfaceC7424a = this.mSensorListener;
            if (interfaceC7424a != null) {
                interfaceC7424a.updateAzimuth(f16);
            }
        }
    }

    public void updateFPSRate(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, j3);
            return;
        }
        this.mFrameCount++;
        if (this.mFrameLastFPS == 0) {
            this.mFrameLastFPS = SystemClock.elapsedRealtime();
        }
        if (SystemClock.elapsedRealtime() - this.mFrameLastFPS >= 1000) {
            this.mFrameRate = this.mFrameCount;
            this.mFrameCount = 0L;
            this.mFrameLastFPS = SystemClock.elapsedRealtime();
            TraceCallback traceCallback = this.mCallback;
            if (traceCallback != null) {
                traceCallback.trace(this.mFrameRate);
            }
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - j3;
        if (FPS_LIMIT_SWITCH) {
            long j16 = FPS_LIMIT;
            if (elapsedRealtime < j16) {
                try {
                    LockMethodProxy.sleep(j16 - elapsedRealtime);
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.armap.sensor.a.InterfaceC7424a
    public void updateGyroscope(float f16, float f17, float f18, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Long.valueOf(j3));
            return;
        }
        queueEvent(new Runnable(f16, f17, f18, j3) { // from class: com.tencent.mobileqq.armap.ARGLSurfaceView.14
            static IPatchRedirector $redirector_;
            final /* synthetic */ long val$timestamp;
            final /* synthetic */ float val$x;
            final /* synthetic */ float val$y;
            final /* synthetic */ float val$z;

            {
                this.val$x = f16;
                this.val$y = f17;
                this.val$z = f18;
                this.val$timestamp = j3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, ARGLSurfaceView.this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Long.valueOf(j3));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    ARGLSurfaceView.this.native_onSensorChanged(this.val$x, this.val$y, this.val$z, this.val$timestamp, 2);
                }
            }
        });
        a.InterfaceC7424a interfaceC7424a = this.mSensorListener;
        if (interfaceC7424a != null) {
            interfaceC7424a.updateGyroscope(f16, f17, f18, j3);
        }
    }

    @Override // com.tencent.mobileqq.armap.sensor.a.InterfaceC7424a
    public void updatePitch(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, Float.valueOf(f16));
            return;
        }
        if (this.mEngineHandler != 0) {
            queueEvent(new Runnable(f16) { // from class: com.tencent.mobileqq.armap.ARGLSurfaceView.17
                static IPatchRedirector $redirector_;
                final /* synthetic */ float val$pitch;

                {
                    this.val$pitch = f16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, ARGLSurfaceView.this, Float.valueOf(f16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        ARGLSurfaceView aRGLSurfaceView = ARGLSurfaceView.this;
                        aRGLSurfaceView.native_updatePitch(aRGLSurfaceView.mEngineHandler, this.val$pitch);
                    }
                }
            });
            a.InterfaceC7424a interfaceC7424a = this.mSensorListener;
            if (interfaceC7424a != null) {
                interfaceC7424a.updatePitch(f16);
            }
        }
    }

    @Override // com.tencent.mobileqq.armap.sensor.a.InterfaceC7424a
    public void updateRoll(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, Float.valueOf(f16));
            return;
        }
        if (this.mEngineHandler != 0) {
            queueEvent(new Runnable(f16) { // from class: com.tencent.mobileqq.armap.ARGLSurfaceView.18
                static IPatchRedirector $redirector_;
                final /* synthetic */ float val$roll;

                {
                    this.val$roll = f16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, ARGLSurfaceView.this, Float.valueOf(f16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        ARGLSurfaceView aRGLSurfaceView = ARGLSurfaceView.this;
                        aRGLSurfaceView.native_updateRoll(aRGLSurfaceView.mEngineHandler, this.val$roll);
                    }
                }
            });
            a.InterfaceC7424a interfaceC7424a = this.mSensorListener;
            if (interfaceC7424a != null) {
                interfaceC7424a.updateRoll(f16);
            }
        }
    }

    @Override // com.tencent.mobileqq.armap.sensor.a.InterfaceC7424a
    public void updateRotation(float f16, float f17, float f18) {
        a.InterfaceC7424a interfaceC7424a;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18));
        } else if (this.mEngineHandler != 0 && (interfaceC7424a = this.mSensorListener) != null) {
            interfaceC7424a.updateRotation(f16, f17, f18);
        }
    }

    @Override // com.tencent.mobileqq.armap.sensor.a.InterfaceC7424a
    public void updateSensor(float f16, float f17, float f18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18));
            return;
        }
        if (this.mEngineHandler != 0) {
            queueEvent(new Runnable(f16, f17, f18) { // from class: com.tencent.mobileqq.armap.ARGLSurfaceView.15
                static IPatchRedirector $redirector_;
                final /* synthetic */ float val$azimuth;
                final /* synthetic */ float val$pitch;
                final /* synthetic */ float val$roll;

                {
                    this.val$azimuth = f16;
                    this.val$pitch = f17;
                    this.val$roll = f18;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, ARGLSurfaceView.this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        ARGLSurfaceView aRGLSurfaceView = ARGLSurfaceView.this;
                        aRGLSurfaceView.native_updateSensor(aRGLSurfaceView.mEngineHandler, this.val$azimuth, this.val$pitch, this.val$roll);
                    }
                }
            });
            a.InterfaceC7424a interfaceC7424a = this.mSensorListener;
            if (interfaceC7424a != null) {
                interfaceC7424a.updateSensor(f16, f17, f18);
            }
        }
    }

    public void resumeSensor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, i3);
            return;
        }
        com.tencent.mobileqq.armap.sensor.a aVar = this.mSensorManager;
        if (aVar != null) {
            aVar.f(this, i3);
        }
    }

    public ARGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.mIsSupportPreserveEGLContextOnPause = true;
        this.mIsDestroyed = false;
        this.mIsContextDestroyed = false;
        this.mFrameCount = 0L;
        this.mFrameLastFPS = 0L;
        this.mFrameRate = 0L;
    }
}
