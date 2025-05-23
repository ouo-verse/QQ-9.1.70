package com.tencent.mobileqq.richmedia.capture.view;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.os.SystemClock;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.OrientationEventListener;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.aekit.openrender.internal.FrameBufferCache;
import com.tencent.aelight.camera.api.IAELaunchRecorder;
import com.tencent.aelight.camera.api.ICameraCompatible;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.report.api.ICaptureReportUtil;
import com.tencent.aelight.camera.struct.camera.AEPhotoCaptureResult;
import com.tencent.aelight.camera.struct.camera.BaseVideoCaptureResult;
import com.tencent.aelight.camera.util.api.ICaptureUtil;
import com.tencent.ark.EGLContextHolder;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.richmedia.view.CameraCover;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraControl;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraExceptionHandler;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.videocodec.audio.AudioCapture;
import com.tencent.mobileqq.videocodec.mediacodec.encoder.EglHandlerThread;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;
import gm2.c;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: P */
@TargetApi(18)
/* loaded from: classes18.dex */
public class CameraCaptureView extends GLSurfaceView implements CameraCover.a, GLSurfaceView.Renderer, CameraProxy.e, AudioCapture.b, com.tencent.mobileqq.videocodec.mediacodec.recorder.c, SurfaceTexture.OnFrameAvailableListener, yq2.c, CameraExceptionHandler.a {

    /* renamed from: f1, reason: collision with root package name */
    public static final CameraProxy f281365f1 = new CameraProxy(null, null);
    private int A0;
    private boolean B0;
    protected int C;
    private gm2.c C0;
    protected int D;
    private boolean D0;
    protected int E;
    private int E0;
    protected int F;
    private int F0;
    protected int G;
    public h G0;
    protected int H;
    private boolean H0;
    protected int I;
    protected OrientationEventListener I0;
    protected int J;
    protected int J0;
    protected int K;
    protected int K0;
    protected int L;
    protected boolean L0;
    protected int M;
    private long M0;
    protected int N;
    protected boolean N0;
    protected boolean O0;
    protected int P;
    private boolean P0;
    protected int Q;
    public boolean Q0;
    protected int R;
    protected int R0;
    protected f S;
    protected boolean S0;
    private boolean T;
    private boolean T0;
    private volatile boolean U;
    private boolean U0;
    private boolean V;
    private volatile boolean V0;
    private int W;
    private volatile boolean W0;
    private boolean X0;
    private long Y0;
    public int Z0;

    /* renamed from: a0, reason: collision with root package name */
    private int f281366a0;

    /* renamed from: a1, reason: collision with root package name */
    public long f281367a1;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f281368b0;

    /* renamed from: b1, reason: collision with root package name */
    public int f281369b1;

    /* renamed from: c0, reason: collision with root package name */
    protected com.tencent.mobileqq.videocodec.mediacodec.recorder.e f281370c0;

    /* renamed from: c1, reason: collision with root package name */
    private boolean f281371c1;

    /* renamed from: d, reason: collision with root package name */
    private boolean f281372d;

    /* renamed from: d0, reason: collision with root package name */
    protected com.tencent.mobileqq.videocodec.mediacodec.encoder.c f281373d0;

    /* renamed from: d1, reason: collision with root package name */
    private boolean f281374d1;

    /* renamed from: e, reason: collision with root package name */
    private GLSurfaceView.EGLContextFactory f281375e;

    /* renamed from: e0, reason: collision with root package name */
    protected volatile boolean f281376e0;

    /* renamed from: e1, reason: collision with root package name */
    protected boolean f281377e1;

    /* renamed from: f, reason: collision with root package name */
    private CameraExceptionHandler f281378f;

    /* renamed from: f0, reason: collision with root package name */
    protected boolean f281379f0;

    /* renamed from: g0, reason: collision with root package name */
    protected volatile boolean f281380g0;

    /* renamed from: h, reason: collision with root package name */
    private Handler f281381h;

    /* renamed from: h0, reason: collision with root package name */
    protected AudioCapture f281382h0;

    /* renamed from: i, reason: collision with root package name */
    protected int f281383i;

    /* renamed from: i0, reason: collision with root package name */
    protected VideoCaptureResult f281384i0;

    /* renamed from: j0, reason: collision with root package name */
    protected int f281385j0;

    /* renamed from: k0, reason: collision with root package name */
    protected em2.a f281386k0;

    /* renamed from: l0, reason: collision with root package name */
    protected int f281387l0;

    /* renamed from: m, reason: collision with root package name */
    protected int f281388m;

    /* renamed from: m0, reason: collision with root package name */
    protected int f281389m0;

    /* renamed from: n0, reason: collision with root package name */
    protected SurfaceTexture f281390n0;

    /* renamed from: o0, reason: collision with root package name */
    protected final float[] f281391o0;

    /* renamed from: p0, reason: collision with root package name */
    protected Map<String, RenderBuffer> f281392p0;

    /* renamed from: q0, reason: collision with root package name */
    protected TextureRender f281393q0;

    /* renamed from: r0, reason: collision with root package name */
    protected EglHandlerThread f281394r0;

    /* renamed from: s0, reason: collision with root package name */
    private boolean f281395s0;

    /* renamed from: t0, reason: collision with root package name */
    public EGLConfig f281396t0;

    /* renamed from: u0, reason: collision with root package name */
    public EGLContext f281397u0;

    /* renamed from: v0, reason: collision with root package name */
    protected com.tencent.mobileqq.activity.richmedia.e f281398v0;

    /* renamed from: w0, reason: collision with root package name */
    private boolean f281399w0;

    /* renamed from: x0, reason: collision with root package name */
    private boolean f281400x0;

    /* renamed from: y0, reason: collision with root package name */
    private View f281401y0;

    /* renamed from: z0, reason: collision with root package name */
    private int f281402z0;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView$17, reason: invalid class name */
    /* loaded from: classes18.dex */
    class AnonymousClass17 implements Runnable {
        final /* synthetic */ CameraCaptureView this$0;

        @Override // java.lang.Runnable
        public void run() {
            CameraCaptureView cameraCaptureView = this.this$0;
            cameraCaptureView.I(cameraCaptureView.O0);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView$6, reason: invalid class name */
    /* loaded from: classes18.dex */
    class AnonymousClass6 implements Runnable {
        final /* synthetic */ CameraCaptureView this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.f281380g0 = true;
            this.this$0.requestRender();
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class PhotoCaptureResult extends AEPhotoCaptureResult {
        public PhotoCaptureResult(int i3, int i16, String str, Bitmap bitmap, int i17) {
            super(i3, i16, str, bitmap, 0L, i17);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class VideoCaptureResult extends BaseVideoCaptureResult {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a extends OrientationEventListener {
        a(Context context) {
            super(context);
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i3) {
            CameraCaptureView.this.K0 = i3;
            if (i3 == -1) {
                if (QLog.isColorLevel()) {
                    QLog.d("CameraCaptureView", 2, "OrientationEventListener unknown");
                }
                CameraCaptureView.this.R0 = 90;
            }
            if (i3 <= 315 && i3 >= 45) {
                if (i3 > 45 && i3 < 135) {
                    CameraCaptureView.this.R0 = 180;
                } else if (i3 > 135 && i3 < 225) {
                    CameraCaptureView.this.R0 = 270;
                } else if (i3 > 225 && i3 < 315) {
                    CameraCaptureView.this.R0 = 0;
                }
            } else {
                CameraCaptureView.this.R0 = 90;
            }
            CameraCaptureView cameraCaptureView = CameraCaptureView.this;
            if (cameraCaptureView.Q0) {
                cameraCaptureView.J0 = cameraCaptureView.R0;
            }
            gm2.d.f402415c = cameraCaptureView.J0;
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class b implements GLSurfaceView.EGLContextFactory {

        /* renamed from: a, reason: collision with root package name */
        private int f281411a = EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION;

        b() {
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {this.f281411a, 2, 12344};
            if (QLog.isColorLevel()) {
                QLog.d("CameraCaptureView", 1, "createContext. display = " + eGLDisplay + " tid = " + Thread.currentThread().getId());
            }
            CameraCaptureView cameraCaptureView = CameraCaptureView.this;
            cameraCaptureView.f281396t0 = eGLConfig;
            cameraCaptureView.f281397u0 = egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, iArr);
            return CameraCaptureView.this.f281397u0;
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            CameraCaptureView.this.R();
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                QLog.e("CameraCaptureView", 1, "destroyContext. display = " + eGLDisplay + " context = " + eGLContext + " tid = " + Thread.currentThread().getId());
            }
            if (QLog.isColorLevel()) {
                QLog.d("CameraCaptureView", 1, "destroyContext. display = " + eGLDisplay + " context = " + eGLContext + " tid = " + Thread.currentThread().getId());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class c implements CameraProxy.d {
        c() {
        }

        @Override // com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy.d
        public void a(boolean z16, boolean z17) {
            if (QLog.isColorLevel()) {
                QLog.d("CameraCaptureView", 2, "onAutoFocusCallback single tap focus " + z16 + ", camera2:" + z17);
            }
            if (z16) {
                CameraCaptureView.this.f281399w0 = true;
            } else {
                CameraCaptureView.f281365f1.D();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface d {
        void b(ps.c cVar);

        void e(String str);
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface e {
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface f {
        void H2();
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface g {
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class h {

        /* renamed from: t, reason: collision with root package name */
        public static final String f281414t = BaseApplication.getContext().getFilesDir().getPath() + "/Android/data/com.tencent.mobileqq/qq/video/LightVideo/";

        /* renamed from: u, reason: collision with root package name */
        public static String f281415u = "key_aio_fbo";

        /* renamed from: v, reason: collision with root package name */
        public static String f281416v = "key_riji_h_compress_fbo";

        /* renamed from: w, reason: collision with root package name */
        public static String f281417w = "key_riji_h_clip_fbo";

        /* renamed from: x, reason: collision with root package name */
        public static String f281418x = "key_riji_l_compress_fbo";

        /* renamed from: y, reason: collision with root package name */
        public static String f281419y = "key_riji_l_clip_fbo";

        /* renamed from: z, reason: collision with root package name */
        public static String f281420z = "key_ae_gif_fbo";

        /* renamed from: e, reason: collision with root package name */
        private int f281425e;

        /* renamed from: f, reason: collision with root package name */
        private int f281426f;

        /* renamed from: g, reason: collision with root package name */
        public int f281427g;

        /* renamed from: h, reason: collision with root package name */
        public int f281428h;

        /* renamed from: a, reason: collision with root package name */
        private int f281421a = 960;

        /* renamed from: b, reason: collision with root package name */
        private int f281422b = 720;

        /* renamed from: c, reason: collision with root package name */
        private int f281423c = 960;

        /* renamed from: d, reason: collision with root package name */
        private int f281424d = 720;

        /* renamed from: i, reason: collision with root package name */
        private int f281429i = 1;

        /* renamed from: j, reason: collision with root package name */
        protected float f281430j = 1.0f;

        /* renamed from: k, reason: collision with root package name */
        private int f281431k = AECameraConstants.TRIBE_MAX_RATE;

        /* renamed from: l, reason: collision with root package name */
        private int f281432l = 1;

        /* renamed from: m, reason: collision with root package name */
        protected int f281433m = -1;

        /* renamed from: n, reason: collision with root package name */
        protected int f281434n = -1;

        /* renamed from: o, reason: collision with root package name */
        public long f281435o = System.currentTimeMillis();

        /* renamed from: p, reason: collision with root package name */
        public String f281436p = BaseApplication.getContext().getFilesDir().getPath() + "/Android/data/com.tencent.mobileqq/qq/video/Source/" + this.f281435o;

        /* renamed from: q, reason: collision with root package name */
        protected boolean f281437q = true;

        /* renamed from: r, reason: collision with root package name */
        private int f281438r = 1;

        /* renamed from: s, reason: collision with root package name */
        protected boolean f281439s = true;

        public void f(boolean z16) {
            this.f281437q = z16;
        }

        public void g(int i3) {
            this.f281433m = i3;
        }

        public void h(int i3) {
            this.f281429i = i3;
        }

        public void i(int i3) {
            this.f281426f = i3;
        }

        public void j(int i3) {
            this.f281425e = i3;
        }

        public void k(int i3) {
            this.f281431k = i3;
        }

        public void l(int i3) {
            this.f281432l = i3;
        }

        public void m(float f16) {
            this.f281430j = f16;
        }

        public void n(int i3) {
            this.f281424d = i3;
        }

        public void o(int i3) {
            this.f281423c = i3;
        }

        public void p(int i3) {
            this.f281422b = i3;
        }

        public void q(int i3) {
            this.f281421a = i3;
        }

        public String toString() {
            return "CaptureParam{wantedPreviewWidth=" + this.f281421a + ", wantedPreviewHeight=" + this.f281422b + ", defaultCamera=" + this.f281429i + ", videoSizeRate=" + this.f281430j + ", videoBitRate=" + this.f281431k + ", videoIFrameInterval=" + this.f281432l + ", captureDir='" + this.f281436p + "', audioCaptureEnable=" + this.f281437q + ", functionFlag=" + this.f281438r + '}';
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface i {
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface j {
    }

    public CameraCaptureView(@NonNull Context context) {
        super(context);
        this.f281375e = new b();
        this.f281383i = 2;
        this.T = false;
        this.U = false;
        this.V = false;
        this.f281368b0 = false;
        this.f281379f0 = false;
        this.f281380g0 = false;
        this.f281391o0 = new float[16];
        this.f281392p0 = new HashMap();
        this.f281395s0 = false;
        this.f281396t0 = null;
        this.f281397u0 = null;
        this.f281399w0 = false;
        this.f281400x0 = false;
        this.B0 = false;
        this.D0 = true;
        this.H0 = false;
        this.J0 = 90;
        this.K0 = 0;
        this.L0 = true;
        this.N0 = false;
        this.O0 = false;
        this.P0 = false;
        this.Q0 = true;
        this.R0 = 90;
        this.S0 = false;
        this.V0 = false;
        this.W0 = false;
        this.X0 = false;
        this.Y0 = 0L;
        this.Z0 = 0;
        this.f281367a1 = 0L;
        this.f281369b1 = 0;
        this.f281371c1 = true;
        this.f281377e1 = true;
        this.M0 = System.currentTimeMillis();
        setEGLContextFactory(this.f281375e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(boolean z16) {
        if (this.f281383i == 1) {
            a0(z16);
        } else {
            f281365f1.R(z16);
        }
    }

    private void a0(boolean z16) {
        boolean z17;
        if (!(getContext() instanceof Activity)) {
            ms.a.c("CameraCaptureView", "turnFrontFlash|getContext is not Activity type.");
            return;
        }
        Activity activity = (Activity) getContext();
        if (!Settings.System.canWrite(activity)) {
            if (activity.checkSelfPermission("android.permission.SYSTEM_ALERT_WINDOW") == 0) {
                DialogUtil.showWriteSetting(activity, null, null);
            }
            z17 = false;
        } else {
            z17 = true;
        }
        if (!z17) {
            ms.a.c("CameraCaptureView", "can not grant permission");
            return;
        }
        if (z16) {
            if (this.f281401y0 == null) {
                this.f281401y0 = new View(activity);
            }
            this.f281401y0.setBackgroundColor(-1);
            this.f281401y0.setAlpha(0.7f);
            if (this.f281401y0.getParent() != null) {
                ((ViewGroup) this.f281401y0.getParent()).removeView(this.f281401y0);
            }
            activity.addContentView(this.f281401y0, new ViewGroup.LayoutParams(-1, -1));
            try {
                this.f281402z0 = Settings.System.getInt(activity.getContentResolver(), "screen_brightness_mode");
                Settings.System.putInt(activity.getContentResolver(), "screen_brightness_mode", 0);
                this.A0 = Settings.System.getInt(activity.getContentResolver(), "screen_brightness");
                Settings.System.putInt(activity.getContentResolver(), "screen_brightness", 255);
                this.B0 = true;
                return;
            } catch (Exception e16) {
                this.f281402z0 = 1;
                this.A0 = 100;
                if (QLog.isColorLevel()) {
                    QLog.e("CameraCaptureView", 2, "turn FrontFlash Error ", e16);
                    e16.printStackTrace();
                    return;
                }
                return;
            }
        }
        if (this.B0) {
            Settings.System.putInt(activity.getContentResolver(), "screen_brightness", this.A0);
            Settings.System.putInt(activity.getContentResolver(), "screen_brightness_mode", this.f281402z0);
            this.B0 = false;
        }
        View view = this.f281401y0;
        if (view != null && view.getParent() != null) {
            ((ViewGroup) this.f281401y0.getParent()).removeView(this.f281401y0);
        }
    }

    private void i() {
        if (this.T) {
        } else {
            throw new RuntimeException("Not inited. Must be called after setCaptureParam");
        }
    }

    public int F() {
        return this.f281383i;
    }

    protected void G() {
        int i3 = this.G0.f281429i;
        this.f281383i = i3;
        if (i3 == 1 && !com.tencent.mobileqq.camera.utils.a.i()) {
            this.f281383i = 2;
        }
        if (this.f281377e1) {
            setEGLContextClientVersion(2);
        }
        Handler handler = new Handler();
        this.f281381h = handler;
        CameraExceptionHandler cameraExceptionHandler = new CameraExceptionHandler(handler, this);
        this.f281378f = cameraExceptionHandler;
        CameraProxy cameraProxy = f281365f1;
        cameraProxy.B(cameraExceptionHandler);
        setRenderer(this);
        setRenderMode(0);
        this.f281370c0 = new com.tencent.mobileqq.videocodec.mediacodec.recorder.e();
        if (this.G0.f281437q) {
            this.f281382h0 = new AudioCapture(this.G0.f281436p, 1, CodecParam.mAudioSampleRate, CodecParam.mAudioChannel, CodecParam.mAudioFormat, this, cameraProxy.q());
            this.f281386k0 = new em2.a(this.G0.f281436p, CodecParam.mAudioSampleRate, this);
        }
        this.f281398v0 = new com.tencent.mobileqq.activity.richmedia.e();
        this.C0 = new gm2.c();
        QmcfManager.getInstance().setCameraMode(this.f281383i);
        this.T = true;
    }

    protected void H(CameraControl.b bVar) {
        this.E = bVar.f288111a;
        this.D = bVar.f288112b;
        if (!this.O0) {
            ICaptureUtil iCaptureUtil = (ICaptureUtil) QRoute.api(ICaptureUtil.class);
            int i3 = this.D;
            int i16 = this.E;
            h hVar = this.G0;
            int[] clipVideoSize = iCaptureUtil.clipVideoSize(i3, i16, hVar.f281427g, hVar.f281428h, 1.0f);
            this.N = clipVideoSize[0];
            this.P = clipVideoSize[1];
            int[] clipVideoSize2 = ((ICaptureUtil) QRoute.api(ICaptureUtil.class)).clipVideoSize(this.D, this.E, this.f281388m, this.C, this.G0.f281430j);
            this.Q = clipVideoSize2[0];
            this.R = clipVideoSize2[1];
            int[] scaleVideoSize = ((ICaptureUtil) QRoute.api(ICaptureUtil.class)).scaleVideoSize(this.G0.f281421a, this.Q, this.R);
            this.Q = scaleVideoSize[0];
            this.R = scaleVideoSize[1];
            h.f281415u = "key_aio_fbo" + this.N + this.P;
            queueEvent(new Runnable() { // from class: com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.7
                @Override // java.lang.Runnable
                public void run() {
                    if (!CameraCaptureView.this.f281392p0.containsKey(h.f281415u)) {
                        CameraCaptureView cameraCaptureView = CameraCaptureView.this;
                        cameraCaptureView.f281392p0.put(h.f281415u, new RenderBuffer(cameraCaptureView.N, cameraCaptureView.P, 33984));
                    }
                    CameraCaptureView.this.I(false);
                }
            });
            if (QLog.isColorLevel()) {
                QLog.i("CameraCaptureView", 2, "onCameraSizeSelected(): cameraPreviewWidth=" + this.D + ",cameraPreviewHeight=" + this.E);
                return;
            }
            return;
        }
        int[] scaleVideoSize2 = ((ICaptureUtil) QRoute.api(ICaptureUtil.class)).scaleVideoSize(this.G0.f281421a, this.D, this.E);
        final int i17 = scaleVideoSize2[0];
        final int i18 = scaleVideoSize2[1];
        h.f281416v = "key_riji_h_compress_fbo" + i17 + i18;
        ICaptureUtil iCaptureUtil2 = (ICaptureUtil) QRoute.api(ICaptureUtil.class);
        h hVar2 = this.G0;
        int[] clipVideoSize3 = iCaptureUtil2.clipVideoSize(i17, i18, hVar2.f281427g, hVar2.f281428h, 1.0f);
        this.F = clipVideoSize3[0];
        this.G = clipVideoSize3[1];
        h.f281417w = "key_riji_h_clip_fbo" + this.F + this.G;
        this.J = this.F;
        this.K = this.G;
        int unused = this.G0.f281424d;
        int[] scaleVideoSize3 = ((ICaptureUtil) QRoute.api(ICaptureUtil.class)).scaleVideoSize(this.G0.f281423c, this.D, this.E);
        final int i19 = scaleVideoSize3[0];
        final int i26 = scaleVideoSize3[1];
        h.f281418x = "key_riji_l_compress_fbo" + i19 + i26;
        ICaptureUtil iCaptureUtil3 = (ICaptureUtil) QRoute.api(ICaptureUtil.class);
        h hVar3 = this.G0;
        int[] clipVideoSize4 = iCaptureUtil3.clipVideoSize(i19, i26, hVar3.f281427g, hVar3.f281428h, 1.0f);
        this.H = clipVideoSize4[0];
        this.I = clipVideoSize4[1];
        h.f281419y = "key_riji_l_clip_fbo" + this.H + this.I;
        this.L = this.H;
        this.M = this.I;
        queueEvent(new Runnable() { // from class: com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.8
            @Override // java.lang.Runnable
            public void run() {
                if (!CameraCaptureView.this.f281392p0.containsKey(h.f281416v)) {
                    CameraCaptureView.this.f281392p0.put(h.f281416v, new RenderBuffer(i17, i18, 33984));
                }
                if (!CameraCaptureView.this.f281392p0.containsKey(h.f281417w)) {
                    CameraCaptureView cameraCaptureView = CameraCaptureView.this;
                    cameraCaptureView.f281392p0.put(h.f281417w, new RenderBuffer(cameraCaptureView.F, cameraCaptureView.G, 33984));
                }
                if (!CameraCaptureView.this.f281392p0.containsKey(h.f281418x)) {
                    CameraCaptureView.this.f281392p0.put(h.f281418x, new RenderBuffer(i19, i26, 33984));
                }
                if (!CameraCaptureView.this.f281392p0.containsKey(h.f281419y)) {
                    CameraCaptureView cameraCaptureView2 = CameraCaptureView.this;
                    cameraCaptureView2.f281392p0.put(h.f281419y, new RenderBuffer(cameraCaptureView2.H, cameraCaptureView2.I, 33984));
                }
                CameraCaptureView.this.I(false);
            }
        });
        if (QLog.isColorLevel()) {
            QLog.i("CameraCaptureView", 2, "onCameraSizeSelected(): cameraPreviewWidth=" + this.D + ",cameraPreviewHeight=" + this.E + "\uff0c highCompressCameraPreviewWidth=" + i17 + ",highCompressCamerareviewHeight=" + i18 + "\uff0c highCameraClipWidth=" + this.F + ",highCameraClipHeight=" + this.G + ", highVideoWidth=" + this.J + ",highVideoHeight=" + this.K + " ,lowCompressCameraPreviewWidth=" + i19 + ",lowCompressCamerareviewHeight=" + i26 + " ,lowCameraClipWidth=" + this.H + " ,lowCameraClipHeight=" + this.I + ",lowVideoWidth=" + this.L + " ,lowVideoHeight=" + this.M);
        }
    }

    protected void I(boolean z16) {
        if (this.O0) {
            if (z16) {
                this.P = this.I;
                this.N = this.H;
                if (this.N0) {
                    int[] clipVideoSize = ((ICaptureUtil) QRoute.api(ICaptureUtil.class)).clipVideoSize(this.J, this.K, this.f281388m, this.C, this.G0.f281430j);
                    this.Q = clipVideoSize[0];
                    this.R = clipVideoSize[1];
                } else {
                    int[] clipVideoSize2 = ((ICaptureUtil) QRoute.api(ICaptureUtil.class)).clipVideoSize(this.L, this.M, this.f281388m, this.C, this.G0.f281430j);
                    this.Q = clipVideoSize2[0];
                    this.R = clipVideoSize2[1];
                }
            } else {
                this.P = this.G;
                this.N = this.F;
                int[] clipVideoSize3 = ((ICaptureUtil) QRoute.api(ICaptureUtil.class)).clipVideoSize(this.J, this.K, this.f281388m, this.C, this.G0.f281430j);
                this.Q = clipVideoSize3[0];
                this.R = clipVideoSize3[1];
            }
        }
        com.tencent.mobileqq.activity.richmedia.e eVar = this.f281398v0;
        if (eVar != null) {
            eVar.d(this.P, this.N, p(), o());
        }
        if (QLog.isColorLevel()) {
            QLog.d("CameraCaptureView", 2, "compress=" + z16 + " onCameraSizeUpdate cameraClipHeight = " + this.P + " cameraClipWidth=" + this.N + " videoWidth=" + this.Q + " videoHeight=" + this.R);
        }
    }

    protected boolean K() {
        return false;
    }

    protected boolean L() {
        return false;
    }

    protected int M(boolean z16) {
        boolean z17;
        int i3 = this.f281387l0;
        if (z16) {
            z17 = K();
        } else if (this.O0) {
            z17 = L();
        } else {
            z17 = false;
        }
        if (this.O0) {
            if (z17) {
                RenderBuffer renderBuffer = this.f281392p0.get(h.f281418x);
                if (renderBuffer != null) {
                    renderBuffer.bind();
                    synchronized (this.f281390n0) {
                        this.f281390n0.getTransformMatrix(this.f281391o0);
                        this.f281393q0.drawTexture(36197, this.f281387l0, this.f281391o0, null);
                        QmcfManager.getInstance().setSTMatrix(this.f281391o0);
                        QmcfManager.getInstance().setIsQQRun(false);
                    }
                    j();
                    i3 = renderBuffer.getTexId();
                    renderBuffer.unbind();
                }
                RenderBuffer renderBuffer2 = this.f281392p0.get(h.f281419y);
                if (renderBuffer2 != null && renderBuffer != null) {
                    if (renderBuffer.getWidth() != renderBuffer2.getWidth() || renderBuffer.getHeight() != renderBuffer2.getHeight()) {
                        renderBuffer2.bind();
                        this.f281393q0.drawTexture(GLSLRender.GL_TEXTURE_2D, i3, null, GPUBaseFilter.caculateCenterCropMvpMatrix(renderBuffer.getWidth(), renderBuffer.getHeight(), renderBuffer2.getWidth(), renderBuffer2.getHeight()));
                        i3 = renderBuffer2.getTexId();
                        renderBuffer2.unbind();
                    }
                    if (this.N != renderBuffer2.getWidth() || this.P != renderBuffer2.getHeight()) {
                        I(true);
                        return i3;
                    }
                    return i3;
                }
                return i3;
            }
            RenderBuffer renderBuffer3 = this.f281392p0.get(h.f281416v);
            if (renderBuffer3 != null) {
                renderBuffer3.bind();
                synchronized (this.f281390n0) {
                    this.f281390n0.getTransformMatrix(this.f281391o0);
                    this.f281393q0.drawTexture(36197, this.f281387l0, this.f281391o0, null);
                    QmcfManager.getInstance().setSTMatrix(this.f281391o0);
                    QmcfManager.getInstance().setIsQQRun(false);
                }
                j();
                i3 = renderBuffer3.getTexId();
                renderBuffer3.unbind();
            }
            RenderBuffer renderBuffer4 = this.f281392p0.get(h.f281417w);
            if (renderBuffer4 != null && renderBuffer3 != null) {
                if (renderBuffer3.getWidth() != renderBuffer4.getWidth() || renderBuffer3.getHeight() != renderBuffer4.getHeight()) {
                    renderBuffer4.bind();
                    this.f281393q0.drawTexture(GLSLRender.GL_TEXTURE_2D, i3, null, GPUBaseFilter.caculateCenterCropMvpMatrix(renderBuffer3.getWidth(), renderBuffer3.getHeight(), renderBuffer4.getWidth(), renderBuffer4.getHeight()));
                    i3 = renderBuffer4.getTexId();
                    renderBuffer4.unbind();
                }
                if (this.N != renderBuffer4.getWidth() || this.P != renderBuffer4.getHeight()) {
                    I(false);
                    return i3;
                }
                return i3;
            }
            return i3;
        }
        RenderBuffer renderBuffer5 = this.f281392p0.get(h.f281415u);
        if (renderBuffer5 != null) {
            renderBuffer5.bind();
            synchronized (this.f281390n0) {
                this.f281390n0.getTransformMatrix(this.f281391o0);
                this.f281393q0.drawTexture(36197, this.f281387l0, this.f281391o0, GPUBaseFilter.caculateCenterCropMvpMatrix(this.D, this.E, renderBuffer5.getWidth(), renderBuffer5.getHeight()));
                QmcfManager.getInstance().setSTMatrix(this.f281391o0);
            }
            j();
            renderBuffer5.unbind();
            return renderBuffer5.getTexId();
        }
        return i3;
    }

    protected void P() {
        a aVar = new a(getContext());
        this.I0 = aVar;
        if (aVar.canDetectOrientation()) {
            this.I0.enable();
        }
        if (QLog.isColorLevel()) {
            QLog.d("CameraCaptureView", 2, "Create to FirstFrameShown cost : " + (System.currentTimeMillis() - this.M0) + "ms");
        }
    }

    public void R() {
        if (QLog.isColorLevel()) {
            QLog.d("CameraCaptureView", 2, "onSurfaceDestroy");
        }
        this.f281395s0 = false;
        if (!com.tencent.mobileqq.shortvideo.util.c.b()) {
            Iterator<RenderBuffer> it = this.f281392p0.values().iterator();
            while (it.hasNext()) {
                it.next().destroy();
            }
            this.f281392p0.clear();
            GlUtil.deleteTexture(this.f281387l0);
            SurfaceTexture surfaceTexture = this.f281390n0;
            if (surfaceTexture != null) {
                surfaceTexture.release();
            }
            TextureRender textureRender = this.f281393q0;
            if (textureRender != null) {
                textureRender.release();
            }
        }
        SurfaceTexture surfaceTexture2 = this.f281390n0;
        if (surfaceTexture2 != null) {
            surfaceTexture2.setOnFrameAvailableListener(null);
        }
        Y();
    }

    protected void S(int i3) {
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glViewport(0, 0, this.f281388m, this.C);
        this.f281393q0.drawTexture(GLSLRender.GL_TEXTURE_2D, i3, null, null);
    }

    protected void T() {
        VideoCaptureResult videoCaptureResult = this.f281384i0;
        gm2.d.g(videoCaptureResult.videoFrameCount, videoCaptureResult.videoMp4FilePath);
    }

    public void U(float f16, float f17) {
        if (this.f281398v0 == null) {
            return;
        }
        i();
        if (QLog.isColorLevel()) {
            QLog.i("CameraCaptureView", 2, "requestCameraFocus x:" + f16 + "y: " + f17 + ", Orientation:" + ((Activity) getContext()).getWindowManager().getDefaultDisplay().getRotation());
        }
        com.tencent.mobileqq.shortvideo.camera2.e eVar = new com.tencent.mobileqq.shortvideo.camera2.e();
        eVar.f287837a = f16;
        eVar.f287838b = f17;
        eVar.f287839c = p();
        eVar.f287840d = o();
        eVar.f287842f = this.f281398v0;
        eVar.f287841e = ((ICaptureUtil) QRoute.api(ICaptureUtil.class)).getPhotoOrientationDegree(this.K0);
        f281365f1.y(eVar, new c());
    }

    protected void V() {
        if (!this.T || this.U) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("CameraCaptureView", 2, "openCamera");
        }
        boolean z16 = false;
        this.V = false;
        this.W = 0;
        this.f281366a0 = 0;
        CameraProxy cameraProxy = f281365f1;
        cameraProxy.x(this);
        cameraProxy.j(this.f281383i);
        this.U = true;
        if (this.G0.f281437q && this.f281382h0 != null && (getContext() instanceof Activity)) {
            this.f281382h0.B((Activity) getContext());
        }
        com.tencent.mobileqq.activity.richmedia.e eVar = this.f281398v0;
        if (eVar != null) {
            if (this.f281383i == 1) {
                z16 = true;
            }
            eVar.e(z16);
        }
        com.tencent.mobileqq.activity.richmedia.c.f185845b = this.f281383i;
    }

    public void W() {
        if (this.T && this.f281395s0 && this.U) {
            if (!this.V || this.W != this.f281388m || this.f281366a0 != this.C) {
                h hVar = this.G0;
                if (hVar.f281427g == 0 || hVar.f281428h == 0 || this.f281371c1) {
                    hVar.f281427g = this.f281388m;
                    hVar.f281428h = this.C;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("CameraCaptureView", 2, "startCameraPreview, clipWidth:" + this.G0.f281427g + ", clipHeight:" + this.G0.f281428h + ", surfaceWidth:" + this.f281388m + ", surfaceHeight:" + this.C);
                }
                if (this.O0) {
                    CameraProxy cameraProxy = f281365f1;
                    CameraControl.b bVar = new CameraControl.b(this.C, this.f281388m);
                    h hVar2 = this.G0;
                    cameraProxy.H(bVar, new CameraControl.b(hVar2.f281427g, hVar2.f281428h), 0, 30, this.O0);
                } else {
                    CameraProxy cameraProxy2 = f281365f1;
                    CameraControl.b bVar2 = new CameraControl.b(this.G0.f281421a, this.G0.f281422b);
                    h hVar3 = this.G0;
                    cameraProxy2.H(bVar2, new CameraControl.b(hVar3.f281427g, hVar3.f281428h), 0, 30, this.O0);
                }
                f281365f1.m(this.f281390n0, null, this, true);
                J();
                this.V = true;
                this.W = this.f281388m;
                this.f281366a0 = this.C;
            }
        }
    }

    public void X() {
        boolean z16 = true;
        if (this.S != null) {
            Activity activity = (Activity) getContext();
            int checkSelfPermission = activity.checkSelfPermission(QQPermissionConstants.Permission.CAMERA);
            int checkSelfPermission2 = activity.checkSelfPermission(QQPermissionConstants.Permission.RECORD_AUDIO);
            if (QLog.isColorLevel()) {
                QLog.d("CameraCaptureView", 2, "startCameraWithPermission, camera: ", Integer.valueOf(checkSelfPermission), " audio: ", Integer.valueOf(checkSelfPermission2));
            }
            if (checkSelfPermission != 0 || checkSelfPermission2 != 0) {
                if (!this.V0) {
                    this.V0 = true;
                    this.S.H2();
                    return;
                }
                z16 = false;
            }
        }
        if (z16 || this.W0) {
            V();
            W();
        }
    }

    public void Y() {
        AudioCapture audioCapture;
        if (!this.T || !this.U) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("CameraCaptureView", 2, "stopCamera");
        }
        CameraProxy cameraProxy = f281365f1;
        cameraProxy.o(false);
        this.V = false;
        cameraProxy.l(this.H0);
        this.U = false;
        if (this.G0.f281437q && (audioCapture = this.f281382h0) != null) {
            audioCapture.y();
        }
        cameraProxy.S(this);
        gm2.a.d(this.f281383i);
        if (this.X0 && this.Y0 > 0) {
            this.f281367a1 = System.currentTimeMillis() - this.Y0;
            this.f281369b1 = this.Z0 - 15;
            this.Y0 = 0L;
        }
    }

    @Override // com.tencent.mobileqq.activity.richmedia.view.CameraCover.a
    public void a(String str) {
        l(new PhotoCaptureResult(1, 0, str, null, this.J0));
    }

    public void g(boolean z16) {
        f281365f1.A(z16);
    }

    protected void h(int i3, int i16, int i17) {
        int i18 = ((this.J0 + 360) - 90) % 360;
        if (QLog.isColorLevel()) {
            QLog.d("CameraCaptureView", 2, "captureFrame : width = " + i16 + " ; height = " + i17 + " ; orientation = " + i18);
        }
        try {
            RenderBuffer renderBuffer = new RenderBuffer(i16, i17, 33984);
            renderBuffer.bind();
            this.f281393q0.drawTexture(GLSLRender.GL_TEXTURE_2D, i3, null, null);
            renderBuffer.unbind();
            final Bitmap captureFrame = GlUtil.captureFrame(renderBuffer.getTexId(), i16, i17, -i18);
            renderBuffer.destroy();
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.16
                @Override // java.lang.Runnable
                public void run() {
                    String str = CameraCaptureView.this.G0.f281436p + "/" + System.currentTimeMillis() + ".jpg";
                    FileUtils.createFileIfNotExits(str);
                    File file = new File(str);
                    try {
                        BaseImageUtil.saveBitmapFileAsJPEG(captureFrame, file);
                        BaseImageUtil.savePhotoToSysAlbum(BaseApplication.getContext(), file.getAbsolutePath());
                        CameraCaptureView cameraCaptureView = CameraCaptureView.this;
                        cameraCaptureView.l(new PhotoCaptureResult(0, 0, str, null, cameraCaptureView.J0));
                    } catch (IOException e16) {
                        e16.printStackTrace();
                        CameraCaptureView cameraCaptureView2 = CameraCaptureView.this;
                        cameraCaptureView2.l(new PhotoCaptureResult(0, -1, str, null, cameraCaptureView2.J0));
                    }
                    captureFrame.recycle();
                }
            }, 64, null, false);
        } catch (OutOfMemoryError unused) {
        }
    }

    protected void k(int i3, float[] fArr, float[] fArr2) {
        n(GLSLRender.GL_TEXTURE_2D, i3, fArr, fArr2, SystemClock.elapsedRealtimeNanos());
    }

    protected void l(PhotoCaptureResult photoCaptureResult) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.10
            @Override // java.lang.Runnable
            public void run() {
                if (CameraCaptureView.this.f281400x0) {
                    CameraCaptureView.this.Z(false);
                }
            }
        });
        gm2.d.d();
        ICaptureReportUtil iCaptureReportUtil = (ICaptureReportUtil) QRoute.api(ICaptureReportUtil.class);
        int i3 = 1;
        if (CameraControl.u().f288084e != 1) {
            i3 = 2;
        }
        iCaptureReportUtil.reportPhotoTaken(i3);
    }

    protected void m(VideoCaptureResult videoCaptureResult) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.11
            @Override // java.lang.Runnable
            public void run() {
                if (CameraCaptureView.this.f281400x0) {
                    CameraCaptureView.this.Z(false);
                }
            }
        });
        gm2.d.e();
        ICaptureReportUtil iCaptureReportUtil = (ICaptureReportUtil) QRoute.api(ICaptureReportUtil.class);
        int i3 = 1;
        if (CameraControl.u().f288084e != 1) {
            i3 = 2;
        }
        iCaptureReportUtil.reportVideoCapture(i3);
    }

    protected void n(int i3, int i16, float[] fArr, float[] fArr2, long j3) {
        com.tencent.mobileqq.videocodec.mediacodec.encoder.c cVar;
        if (this.f281376e0 && (cVar = this.f281373d0) != null) {
            int i17 = this.f281385j0;
            if (i17 != 0) {
                if (i17 != 1) {
                    throw new RuntimeException("unknown status " + this.f281385j0);
                }
            } else {
                cVar.d(EGL14.eglGetCurrentContext());
                this.f281370c0.o();
                this.f281370c0.q(this.f281373d0, this);
                this.f281385j0 = 1;
            }
            this.f281370c0.h(i3, i16, fArr, fArr2, j3);
            return;
        }
        int i18 = this.f281385j0;
        if (i18 != 0) {
            if (i18 == 1) {
                this.f281370c0.s();
                Q();
                this.f281385j0 = 0;
            } else {
                throw new RuntimeException("unknown status " + this.f281385j0);
            }
        }
    }

    @Override // yq2.c
    public void notify(Object obj, int i3, Object... objArr) {
        if (QLog.isColorLevel()) {
            QLog.d("CameraCaptureView", 2, " notify : eventId = " + i3 + " ; sender = " + obj + " ; args = " + Arrays.toString(objArr));
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 13) {
                    if (i3 == 14) {
                        Object obj2 = objArr[0];
                        if (obj2 instanceof CameraControl.b) {
                            H((CameraControl.b) obj2);
                            if (objArr.length >= 2) {
                                Object obj3 = objArr[1];
                                if (obj3 instanceof CameraControl.b) {
                                    CameraControl.b bVar = (CameraControl.b) obj3;
                                    this.E0 = bVar.f288111a;
                                    this.F0 = bVar.f288112b;
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        boolean z16 = obj2 instanceof String;
                        return;
                    }
                    return;
                }
                boolean z17 = objArr[0] instanceof Integer;
                return;
            }
            Object obj4 = objArr[0];
            if (obj4 instanceof CameraControl.b) {
                H((CameraControl.b) obj4);
                return;
            } else {
                boolean z18 = obj4 instanceof String;
                return;
            }
        }
        boolean z19 = objArr[0] instanceof String;
    }

    protected int o() {
        return this.C;
    }

    @Override // com.tencent.mobileqq.videocodec.audio.AudioCapture.b
    public void onAudioCaptured(String str) {
        if (!this.f281386k0.d()) {
            if (QLog.isColorLevel()) {
                QLog.d("CameraCaptureView", 2, "onAudioCaptured filePath = " + str);
            }
            VideoCaptureResult videoCaptureResult = this.f281384i0;
            videoCaptureResult.audioDataFilePath = str;
            if (videoCaptureResult.videoMp4FilePath != null) {
                m(videoCaptureResult);
            }
        }
    }

    @Override // com.tencent.mobileqq.videocodec.audio.AudioCapture.b
    public void onAudioChangeCaptured(String str) {
        if (this.f281386k0.d()) {
            if (QLog.isColorLevel()) {
                QLog.d("CameraCaptureView", 2, "onAudioCaptured filePath = " + str);
            }
            VideoCaptureResult videoCaptureResult = this.f281384i0;
            videoCaptureResult.audioDataFilePath = str;
            if (videoCaptureResult.videoMp4FilePath != null) {
                m(videoCaptureResult);
            }
        }
    }

    @Override // com.tencent.mobileqq.videocodec.audio.AudioCapture.b
    public void onAudioError(int i3) {
        QLog.e("CameraCaptureView", 2, "onAudioError. errorCode = " + i3);
        if (i3 == -4 || i3 == -3 || i3 == -2 || i3 == -1) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.12
                @Override // java.lang.Runnable
                public void run() {
                    QQToast.makeText(BaseApplication.getContext(), HardCodeUtil.qqStr(R.string.k69), 1).show();
                }
            });
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        if (this.D != 0 && this.E != 0 && this.f281392p0.size() != 0) {
            if (!this.U) {
                if (QLog.isColorLevel()) {
                    QLog.d("CameraCaptureView", 2, "onDrawFrame ignore");
                    return;
                }
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (!this.X0 && this.Z0 > 15) {
                this.X0 = true;
                this.Y0 = currentTimeMillis;
            }
            boolean z16 = this.f281380g0;
            int M = M(z16);
            this.f281389m0 = M;
            int N = N(M);
            S(O(N));
            k(N, null, null);
            if (!this.f281379f0) {
                this.f281379f0 = true;
                P();
            }
            if (z16) {
                h(N, this.N, this.P);
                this.f281380g0 = false;
            }
            this.Z0++;
            FrameBufferCache.getInstance().forceRecycle();
            if (!this.f281372d) {
                ((IAELaunchRecorder) QRoute.api(IAELaunchRecorder.class)).oldAioDrawFirstFrameDone();
                this.f281372d = true;
                return;
            }
            return;
        }
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        if (QLog.isColorLevel()) {
            QLog.d("CameraCaptureView", 2, "onDrawFrame clean");
        }
    }

    @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.c
    public void onEncodeError(int i3, Throwable th5) {
        this.f281384i0.errorCode = i3;
    }

    @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.c
    public void onEncodeFinish(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("CameraCaptureView", 2, "onEncodeFinish filePath = " + str);
        }
        VideoCaptureResult videoCaptureResult = this.f281384i0;
        videoCaptureResult.videoMp4FilePath = str;
        if (this.G0.f281437q && this.f281382h0 != null) {
            if (videoCaptureResult.audioDataFilePath != null) {
                m(videoCaptureResult);
            } else if (this.f281386k0.d()) {
                this.f281386k0.g();
                this.f281382h0.O();
            } else {
                this.f281382h0.O();
            }
        } else {
            String str2 = this.G0.f281436p + "/noaudio";
            FileUtils.createFileIfNotExits(str2);
            VideoCaptureResult videoCaptureResult2 = this.f281384i0;
            videoCaptureResult2.audioDataFilePath = str2;
            m(videoCaptureResult2);
        }
        ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.9
            @Override // java.lang.Runnable
            public void run() {
                CameraCaptureView.this.T();
            }
        }, null, false);
    }

    @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.c
    public void onEncodeFrame() {
        this.f281384i0.videoFrameCount++;
    }

    @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.c
    public void onEncodeStart() {
        this.f281384i0.videoFrameCount = 0;
        if (this.G0.f281437q && this.f281382h0 != null) {
            if (this.f281386k0.d()) {
                this.f281386k0.c();
                this.f281382h0.N();
            } else {
                this.f281382h0.N();
            }
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(final SurfaceTexture surfaceTexture) {
        if (this.f281394r0.isInitSuccess() && !this.S0) {
            this.f281394r0.getHandler().post(new Runnable() { // from class: com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.14
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        synchronized (CameraCaptureView.this.f281390n0) {
                            surfaceTexture.updateTexImage();
                        }
                        CameraCaptureView.this.requestRender();
                    } catch (Exception e16) {
                        QLog.e("CameraCaptureView", 2, e16, new Object[0]);
                    }
                }
            });
        } else {
            queueEvent(new Runnable() { // from class: com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.15
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        surfaceTexture.updateTexImage();
                        CameraCaptureView.this.requestRender();
                    } catch (Exception e16) {
                        QLog.e("CameraCaptureView", 2, e16, new Object[0]);
                    }
                }
            });
        }
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        if (QLog.isColorLevel()) {
            QLog.d("CameraCaptureView", 2, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        }
        this.T0 = false;
        this.U0 = true;
        Y();
        this.f281381h.removeCallbacksAndMessages(null);
        if (this.f281400x0) {
            Z(false);
        }
        f281365f1.B(null);
        OrientationEventListener orientationEventListener = this.I0;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.3
            @Override // java.lang.Runnable
            public void run() {
                yq2.a.f();
            }
        }, 16, null, false);
    }

    @Override // com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy.e
    public void onPreviewFrame(byte[] bArr, Camera camera2) {
        int i3;
        if (this.D0) {
            int i16 = this.D;
            int i17 = this.E;
            int i18 = this.E0;
            if (i18 > 0 && (i3 = this.F0) > 0) {
                i17 = i18;
                i16 = i3;
            }
            this.C0.a(bArr, i16, i17, null);
        }
        CameraControl.u().g(true, bArr);
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        if (QLog.isColorLevel()) {
            QLog.d("CameraCaptureView", 2, "onResume");
        }
        this.U0 = false;
        if (this.T0) {
            QLog.d("CameraCaptureView", 1, "onResume, blockCameraFlag return");
            return;
        }
        X();
        gm2.c cVar = this.C0;
        if (cVar != null) {
            cVar.b();
        }
        OrientationEventListener orientationEventListener = this.I0;
        if (orientationEventListener != null && orientationEventListener.canDetectOrientation()) {
            this.I0.enable();
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.2
            @Override // java.lang.Runnable
            public void run() {
                yq2.a.a();
            }
        }, 16, null, false);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i3, int i16) {
        if (QLog.isColorLevel()) {
            QLog.d("CameraCaptureView", 2, "onSurfaceChanged(): width " + i3 + ";height" + i16);
        }
        this.f281388m = i3;
        this.C = i16;
        this.f281395s0 = true;
        boolean z16 = this.T0;
        if (!z16 && !this.U0) {
            if (!this.f281374d1) {
                X();
                this.f281374d1 = true;
                return;
            }
            return;
        }
        QLog.d("CameraCaptureView", 1, "onSurfaceChanged, blockCameraFlag return, ", Boolean.valueOf(z16), " ", Boolean.valueOf(this.U0));
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        if (QLog.isColorLevel()) {
            QLog.d("CameraCaptureView", 2, "onSurfaceCreated");
        }
        this.f281395s0 = false;
        EglHandlerThread eglHandlerThread = this.f281394r0;
        EglHandlerThread eglHandlerThread2 = new EglHandlerThread("update_texture", EGL14.eglGetCurrentContext());
        this.f281394r0 = eglHandlerThread2;
        eglHandlerThread2.start();
        if (eglHandlerThread != null) {
            eglHandlerThread.quitSafely();
        }
        this.f281387l0 = GlUtil.createTexture(36197);
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f281387l0);
        this.f281390n0 = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this);
        this.f281393q0 = new TextureRender();
        this.f281385j0 = 0;
        this.S0 = ((ICameraCompatible) QRoute.api(ICameraCompatible.class)).isNeedDrawOnOpenGLSingleThread();
        cr2.a.o(gl10.glGetString(7937));
    }

    protected int p() {
        return this.f281388m;
    }

    public void setBlockCameraFlag(boolean z16) {
        this.T0 = z16;
    }

    public void setCameraPermissionFinish(boolean z16) {
        this.W0 = z16;
    }

    public void setCameraPermissionListener(f fVar) {
        this.S = fVar;
    }

    public void setCameraPermissionResult(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("CameraCaptureView", 2, "setCameraPermissionResult, ", Boolean.valueOf(z16));
        }
        this.W0 = true;
        V();
        W();
    }

    public void setCaptureParam(h hVar) {
        if (this.G0 == null) {
            this.G0 = hVar;
            if (QLog.isColorLevel()) {
                QLog.d("CameraCaptureView", 2, "setCaptureParam : " + hVar);
            }
            G();
            return;
        }
        throw new RuntimeException("setCaptureParam is already called");
    }

    public void setDarkModeEnable(boolean z16) {
        this.D0 = z16;
    }

    public void setDynamicResolutionMode(boolean z16) {
        this.O0 = z16;
    }

    public void setSceneMode(String str) {
        i();
        f281365f1.K(str);
    }

    public void setSegmentMode(boolean z16) {
        this.N0 = z16;
    }

    public void setSyncStopCamera(boolean z16) {
        this.H0 = z16;
    }

    public void setUseVideoOrientation(boolean z16) {
        this.L0 = z16;
    }

    public void setZoom(int i3) {
        i();
        f281365f1.M(i3);
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (QLog.isColorLevel()) {
            QLog.d("CameraCaptureView", 2, "surfaceCreated");
        }
        super.surfaceCreated(surfaceHolder);
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        if (QLog.isColorLevel()) {
            QLog.d("CameraCaptureView", 2, "surfaceDestroyed");
        }
        super.surfaceDestroyed(surfaceHolder);
    }

    private void j() {
    }

    protected void J() {
    }

    protected void Q() {
    }

    @Override // com.tencent.mobileqq.videocodec.audio.AudioCapture.b
    public void onAudioInit() {
    }

    @Override // com.tencent.mobileqq.videocodec.audio.AudioCapture.b
    public void onAudioUnInit() {
    }

    protected int N(int i3) {
        return i3;
    }

    protected int O(int i3) {
        return i3;
    }

    @Override // com.tencent.mobileqq.shortvideo.mediadevice.CameraExceptionHandler.a
    public void b(Exception exc) {
    }

    @Override // com.tencent.mobileqq.shortvideo.mediadevice.CameraExceptionHandler.a
    public void c(RuntimeException runtimeException) {
    }

    @Override // com.tencent.mobileqq.videocodec.audio.AudioCapture.b
    public void onEncodeAudioCaptured(String str) {
    }

    public void setCameraChangeListener(e eVar) {
    }

    public void setCaptureListener(g gVar) {
    }

    public void setDarkModeListener(c.a aVar) {
    }

    public void setOnSurfaceCreatedListener(i iVar) {
    }

    public void setPreviewCallback(j jVar) {
    }

    public CameraCaptureView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f281375e = new b();
        this.f281383i = 2;
        this.T = false;
        this.U = false;
        this.V = false;
        this.f281368b0 = false;
        this.f281379f0 = false;
        this.f281380g0 = false;
        this.f281391o0 = new float[16];
        this.f281392p0 = new HashMap();
        this.f281395s0 = false;
        this.f281396t0 = null;
        this.f281397u0 = null;
        this.f281399w0 = false;
        this.f281400x0 = false;
        this.B0 = false;
        this.D0 = true;
        this.H0 = false;
        this.J0 = 90;
        this.K0 = 0;
        this.L0 = true;
        this.N0 = false;
        this.O0 = false;
        this.P0 = false;
        this.Q0 = true;
        this.R0 = 90;
        this.S0 = false;
        this.V0 = false;
        this.W0 = false;
        this.X0 = false;
        this.Y0 = 0L;
        this.Z0 = 0;
        this.f281367a1 = 0L;
        this.f281369b1 = 0;
        this.f281371c1 = true;
        this.f281377e1 = true;
        this.M0 = System.currentTimeMillis();
        setEGLContextFactory(this.f281375e);
    }

    @Override // com.tencent.mobileqq.videocodec.audio.AudioCapture.b
    public void onAudioFrames(byte[] bArr, int i3, int i16) {
    }
}
