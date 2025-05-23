package com.tencent.aelight.camera.ae.flashshow;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageView;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.aelight.camera.ae.camera.core.AEFilterManagerHolder;
import com.tencent.aelight.camera.ae.camera.filter.a;
import com.tencent.aelight.camera.ae.camera.testpkg.c;
import com.tencent.aelight.camera.ae.camera.ui.AECaptureController;
import com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListScrollView;
import com.tencent.aelight.camera.ae.camera.ui.dashboard.AEDashboardUtil;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakeMaterialManager;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel;
import com.tencent.aelight.camera.ae.camera.ui.watermark.b;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView;
import com.tencent.aelight.camera.ae.flashshow.LSCameraManager;
import com.tencent.aelight.camera.ae.flashshow.dashboard.LSDashboardUtil;
import com.tencent.aelight.camera.ae.flashshow.filter.LSFilterProcessBase;
import com.tencent.aelight.camera.ae.flashshow.filter.LSFilterProcessTex;
import com.tencent.aelight.camera.ae.flashshow.filter.LSOperationUpdater;
import com.tencent.aelight.camera.ae.flashshow.switchHelper.SwitchHelper;
import com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowMaterialManager;
import com.tencent.aelight.camera.ae.flashshow.ui.LSCaptureController;
import com.tencent.aelight.camera.ae.flashshow.ui.LSDashboardPart;
import com.tencent.aelight.camera.ae.flashshow.ui.ay;
import com.tencent.aelight.camera.ae.flashshow.util.AEMaterialUtilKt;
import com.tencent.aelight.camera.ae.flashshow.util.m;
import com.tencent.aelight.camera.ae.gif.a;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.ae.util.Operator;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.pref.api.IPrefRecorder;
import com.tencent.aelight.camera.struct.camera.AEPhotoCaptureResult;
import com.tencent.aelight.camera.struct.camera.AEVideoCaptureResult;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.ark.EGLContextHolder;
import com.tencent.filter.GLSLRender;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.videocodec.audio.AudioCapture;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.ttpic.openapi.config.BeautyRealConfig;
import com.tencent.ttpic.openapi.filter.LightNode;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.VideoSDKMaterialParser;
import common.config.service.QzoneConfig;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.opengles.GL10;
import org.libpag.VideoDecoder;
import org.light.CameraConfig;
import org.light.DeviceCameraConfig;
import org.light.LightAsset;
import org.light.LightConstants;
import org.light.WatermarkConfig;
import org.light.bean.ExposureInfo;
import org.light.device.LightDeviceUtils;
import org.light.device.OfflineConfig;
import org.light.listener.OnLoadAssetListener;
import org.light.utils.MustRunOnGLThread;

/* compiled from: P */
/* loaded from: classes32.dex */
public class LSCameraGLSurfaceView extends GLSurfaceView implements GLSurfaceView.Renderer, AudioCapture.b, com.tencent.mobileqq.videocodec.mediacodec.recorder.c, LSFilterProcessTex.d, SurfaceTexture.OnFrameAvailableListener, SensorEventListener {

    /* renamed from: p1, reason: collision with root package name */
    private static final int f63744p1;

    /* renamed from: q1, reason: collision with root package name */
    private static final int f63745q1;

    /* renamed from: r1, reason: collision with root package name */
    public static volatile boolean f63746r1;
    private AEVideoStoryTopBarViewModel.Ratio A0;
    private ImageView B0;
    private int C;
    private Bitmap C0;
    protected int D;
    private final tq.c D0;
    protected int E;
    protected iq.a E0;
    protected int F;
    private AEVideoCaptureResult F0;
    protected int G;
    private volatile boolean G0;
    protected int H;
    private volatile boolean H0;
    protected int I;
    private com.tencent.mobileqq.videocodec.mediacodec.recorder.e I0;
    private int J;
    private com.tencent.mobileqq.videocodec.mediacodec.encoder.c J0;
    protected boolean K;
    private volatile boolean K0;
    private int L;
    private com.tencent.mobileqq.videocodec.mediacodec.recorder.e L0;
    protected boolean M;
    private com.tencent.mobileqq.videocodec.mediacodec.encoder.c M0;
    private com.tencent.aelight.camera.ae.camera.util.a N;
    private volatile boolean N0;
    private int O0;
    private x P;
    private boolean P0;
    private u Q;
    private int Q0;
    protected y R;
    private int R0;
    protected t S;
    private int S0;
    protected AEFilterManager.MaterialInnerEffectListener T;
    private int T0;
    protected v U;
    private int U0;
    protected a.b V;
    private VideoMaterial V0;
    public LSDashboardPart.s W;
    private String W0;
    private boolean X0;
    private boolean Y0;
    private int Z0;

    /* renamed from: a0, reason: collision with root package name */
    private AEBottomListScrollView.a f63747a0;

    /* renamed from: a1, reason: collision with root package name */
    private final int f63748a1;

    /* renamed from: b0, reason: collision with root package name */
    SensorManager f63749b0;

    /* renamed from: b1, reason: collision with root package name */
    private boolean f63750b1;

    /* renamed from: c0, reason: collision with root package name */
    private Sensor f63751c0;

    /* renamed from: c1, reason: collision with root package name */
    private boolean f63752c1;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.aelight.camera.ae.camera.ui.c f63753d;

    /* renamed from: d0, reason: collision with root package name */
    private xp.a f63754d0;

    /* renamed from: d1, reason: collision with root package name */
    private String f63755d1;

    /* renamed from: e, reason: collision with root package name */
    private LSFilterProcessBase f63756e;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f63757e0;

    /* renamed from: e1, reason: collision with root package name */
    private boolean f63758e1;

    /* renamed from: f, reason: collision with root package name */
    private LSOperationUpdater f63759f;

    /* renamed from: f0, reason: collision with root package name */
    private volatile boolean f63760f0;

    /* renamed from: f1, reason: collision with root package name */
    private int f63761f1;

    /* renamed from: g0, reason: collision with root package name */
    private float f63762g0;

    /* renamed from: g1, reason: collision with root package name */
    private int f63763g1;

    /* renamed from: h, reason: collision with root package name */
    private SurfaceTexture f63764h;

    /* renamed from: h0, reason: collision with root package name */
    CameraConfig.DeviceCameraOrientation f63765h0;

    /* renamed from: h1, reason: collision with root package name */
    private long f63766h1;

    /* renamed from: i, reason: collision with root package name */
    private int f63767i;

    /* renamed from: i0, reason: collision with root package name */
    private float f63768i0;

    /* renamed from: i1, reason: collision with root package name */
    private final com.tencent.aelight.camera.ae.util.l f63769i1;

    /* renamed from: j0, reason: collision with root package name */
    private boolean f63770j0;

    /* renamed from: j1, reason: collision with root package name */
    private LSFilterProcessTex.e f63771j1;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f63772k0;

    /* renamed from: k1, reason: collision with root package name */
    private Activity f63773k1;

    /* renamed from: l0, reason: collision with root package name */
    private boolean f63774l0;

    /* renamed from: l1, reason: collision with root package name */
    private AEMaterialMetaData f63775l1;

    /* renamed from: m, reason: collision with root package name */
    private boolean f63776m;

    /* renamed from: m0, reason: collision with root package name */
    private boolean f63777m0;

    /* renamed from: m1, reason: collision with root package name */
    protected int f63778m1;

    /* renamed from: n0, reason: collision with root package name */
    private boolean f63779n0;

    /* renamed from: n1, reason: collision with root package name */
    private final PointF f63780n1;

    /* renamed from: o0, reason: collision with root package name */
    private int f63781o0;

    /* renamed from: o1, reason: collision with root package name */
    private int f63782o1;

    /* renamed from: p0, reason: collision with root package name */
    protected boolean f63783p0;

    /* renamed from: q0, reason: collision with root package name */
    private volatile boolean f63784q0;

    /* renamed from: r0, reason: collision with root package name */
    private boolean f63785r0;

    /* renamed from: s0, reason: collision with root package name */
    private int f63786s0;

    /* renamed from: t0, reason: collision with root package name */
    private boolean f63787t0;

    /* renamed from: u0, reason: collision with root package name */
    private boolean f63788u0;

    /* renamed from: v0, reason: collision with root package name */
    private boolean f63789v0;

    /* renamed from: w0, reason: collision with root package name */
    private int f63790w0;

    /* renamed from: x0, reason: collision with root package name */
    private boolean f63791x0;

    /* renamed from: y0, reason: collision with root package name */
    private long f63792y0;

    /* renamed from: z0, reason: collision with root package name */
    private com.tencent.aelight.camera.ae.gif.a f63793z0;

    /* compiled from: P */
    /* renamed from: com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView$27, reason: invalid class name */
    /* loaded from: classes32.dex */
    class AnonymousClass27 implements Runnable {
        final /* synthetic */ LSCameraGLSurfaceView this$0;

        @Override // java.lang.Runnable
        public void run() {
            if (this.this$0.f63756e != null) {
                this.this$0.f63756e.m();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    private class TapRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        int f63830d;

        /* renamed from: e, reason: collision with root package name */
        float f63831e;

        /* renamed from: f, reason: collision with root package name */
        float f63832f;

        public TapRunnable(int i3, float f16, float f17) {
            this.f63830d = i3;
            this.f63831e = f16;
            this.f63832f = f17;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (LSCameraGLSurfaceView.this.f63756e instanceof LSFilterProcessTex) {
                ((LSFilterProcessTex) LSCameraGLSurfaceView.this.f63756e).R().setTouchTriggerEvent(this.f63830d, this.f63831e, this.f63832f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b implements LightNode.ILightNodeCameraExposureListener {
        b() {
        }

        @Override // com.tencent.ttpic.openapi.filter.LightNode.ILightNodeCameraExposureListener
        public void onChangeExposureInfo(ExposureInfo exposureInfo) {
            t tVar = LSCameraGLSurfaceView.this.S;
            if (tVar != null) {
                tVar.k(exposureInfo);
            }
        }

        @Override // com.tencent.ttpic.openapi.filter.LightNode.ILightNodeCameraExposureListener
        public void onFetchExposureInfo(ExposureInfo exposureInfo) {
            t tVar = LSCameraGLSurfaceView.this.S;
            if (tVar != null) {
                tVar.l(exposureInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class c implements c.a {
        c() {
        }

        @Override // com.tencent.aelight.camera.ae.camera.testpkg.c.a
        public void endRecord() {
            LSCameraGLSurfaceView.this.Y1();
        }

        @Override // com.tencent.aelight.camera.ae.camera.testpkg.c.a
        public void startRecord() {
            LSCameraGLSurfaceView.this.V1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class d extends com.tencent.aelight.camera.ae.camera.util.a {
        d(Context context) {
            super(context);
        }

        @Override // com.tencent.aelight.camera.ae.camera.util.a
        public void onOrientationChanged(int i3) {
            int i16;
            if (LSCameraGLSurfaceView.this.Q != null) {
                LSCameraGLSurfaceView.this.Q.onOrientionChanged(i3);
            }
            int i17 = 0;
            if (i3 == -1) {
                if (ms.a.g()) {
                    ms.a.c("LSCameraGLSurfaceView", "OrientationEventListener unknown");
                }
                i16 = 90;
            } else {
                i16 = 0;
            }
            if (i3 > 315 || i3 < 45) {
                i17 = 90;
            } else if (i3 > 45 && i3 < 135) {
                i17 = 180;
            } else if (i3 > 135 && i3 < 225) {
                i17 = 270;
            } else if (i3 <= 225 || i3 >= 315) {
                i17 = i16;
            }
            if (LSCameraGLSurfaceView.this.f1()) {
                LSCameraGLSurfaceView.this.f63781o0 = 90;
            } else {
                LSCameraGLSurfaceView.this.f63781o0 = i17;
            }
        }

        @Override // com.tencent.aelight.camera.ae.camera.util.a
        public void onPoseChanged(float f16, float f17, float f18) {
            if (LSCameraGLSurfaceView.this.f63756e != null) {
                LSCameraGLSurfaceView.this.f63756e.u(f18);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class e implements LSCameraManager.b {
        e() {
        }

        @Override // com.tencent.aelight.camera.ae.flashshow.LSCameraManager.b
        public void onOpenResult(int i3, boolean z16) {
            LSCameraGLSurfaceView.this.J1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class f implements LSCameraManager.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ VideoMaterial f63838a;

        f(VideoMaterial videoMaterial) {
            this.f63838a = videoMaterial;
        }

        @Override // com.tencent.aelight.camera.ae.flashshow.LSCameraManager.b
        public void onOpenResult(int i3, boolean z16) {
            LSCameraGLSurfaceView.this.K1(this.f63838a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class g implements m.c {
        g() {
        }

        @Override // com.tencent.aelight.camera.ae.flashshow.util.m.c
        public void onGetLocation() {
            ms.a.f("LSCameraGLSurfaceView", "LocationPermissionHelper onGetLocation");
            LSCameraGLSurfaceView.this.Q1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class h implements com.tencent.mobileqq.videocodec.mediacodec.recorder.c {
        h() {
        }

        @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.c
        public void onEncodeError(int i3, Throwable th5) {
            QLog.e("LSCameraGLSurfaceView", 4, "Test Video  onEncodeError:" + i3 + "," + th5.getMessage());
        }

        @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.c
        public void onEncodeFinish(String str) {
            QLog.i("LSCameraGLSurfaceView", 4, "Test Video onEncodeFinish:" + str);
        }

        @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.c
        public void onEncodeStart() {
            QLog.i("LSCameraGLSurfaceView", 4, "Test Video onEncodeStart.");
        }

        @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.c
        public void onEncodeFrame() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class i implements w {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BeautyRealConfig.TYPE f63842a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f63843b;

        i(BeautyRealConfig.TYPE type, int i3) {
            this.f63842a = type;
            this.f63843b = i3;
        }

        @Override // com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView.w
        public void a(LSFilterProcessTex lSFilterProcessTex) {
            lSFilterProcessTex.t0(this.f63842a, this.f63843b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class j implements w {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f63845a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f63846b;

        j(String str, int i3) {
            this.f63845a = str;
            this.f63846b = i3;
        }

        @Override // com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView.w
        public void a(LSFilterProcessTex lSFilterProcessTex) {
            lSFilterProcessTex.d0(this.f63845a, this.f63846b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class k implements w {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f63848a;

        k(boolean z16) {
            this.f63848a = z16;
        }

        @Override // com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView.w
        public void a(LSFilterProcessTex lSFilterProcessTex) {
            lSFilterProcessTex.f0(this.f63848a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class l implements w {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f63850a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f63851b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f63852c;

        l(String str, int i3, int i16) {
            this.f63850a = str;
            this.f63851b = i3;
            this.f63852c = i16;
        }

        @Override // com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView.w
        public void a(LSFilterProcessTex lSFilterProcessTex) {
            lSFilterProcessTex.c0(this.f63850a, this.f63851b, this.f63852c);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class m implements w {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f63854a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f63855b;

        m(String str, int i3) {
            this.f63854a = str;
            this.f63855b = i3;
        }

        @Override // com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView.w
        public void a(LSFilterProcessTex lSFilterProcessTex) {
            lSFilterProcessTex.e0(this.f63854a, this.f63855b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class n implements w {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f63857a;

        n(String str) {
            this.f63857a = str;
        }

        @Override // com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView.w
        public void a(LSFilterProcessTex lSFilterProcessTex) {
            lSFilterProcessTex.g0(this.f63857a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class o implements w {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f63859a;

        o(float f16) {
            this.f63859a = f16;
        }

        @Override // com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView.w
        public void a(LSFilterProcessTex lSFilterProcessTex) {
            lSFilterProcessTex.Y0(this.f63859a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class p implements w {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f63861a;

        p(int i3) {
            this.f63861a = i3;
        }

        @Override // com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView.w
        public void a(LSFilterProcessTex lSFilterProcessTex) {
            lSFilterProcessTex.X0(this.f63861a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class q implements GLSurfaceView.EGLContextFactory {
        q() {
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            ms.a.c("LSCameraGLSurfaceView", "[EGLContext] destroyContext start");
            if (eGLDisplay == null) {
                ms.a.c("LSCameraGLSurfaceView", "EGLDisplay is null.");
            }
            egl10.eglDestroyContext(eGLDisplay, eGLContext);
            ms.a.c("LSCameraGLSurfaceView", "[EGLContext] destroyContext finish");
        }

        private EGLContext a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, EGLContext eGLContext, int i3) {
            int[] iArr = {EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION, i3, 12344};
            if (eGLContext == null) {
                eGLContext = EGL10.EGL_NO_CONTEXT;
            }
            try {
                return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
            } catch (Exception e16) {
                ms.a.d("LSCameraGLSurfaceView", "create egl context fail with eglVersion = " + i3 + " shareContext = " + eGLContext, e16);
                return EGL10.EGL_NO_CONTEXT;
            }
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            EGLContext a16 = a(egl10, eGLDisplay, eGLConfig, null, 3);
            if (a16 == null || a16 == EGL10.EGL_NO_CONTEXT) {
                a16 = a(egl10, eGLDisplay, eGLConfig, null, 2);
            }
            int[] iArr = new int[1];
            egl10.eglQueryContext(eGLDisplay, a16, EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION, iArr);
            if (QLog.isColorLevel()) {
                QLog.d("LSCameraGLSurfaceView", 2, "[EGLContext] createContext, client version " + iArr[0]);
            }
            LSCameraGLSurfaceView.this.f63761f1 = iArr[0];
            ms.a.c("LSCameraGLSurfaceView", "[EGLContext] createContext finish");
            return a16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class r implements LSFilterProcessTex.f {
        r() {
        }

        @Override // com.tencent.aelight.camera.ae.flashshow.filter.LSFilterProcessTex.f
        public void recover(VideoMaterial videoMaterial) {
            ms.a.f("LSCameraGLSurfaceView", "EditableWatermarkMaterialRecover recover---");
            LSCameraGLSurfaceView.this.V0 = null;
            LSCameraGLSurfaceView.this.setMaterial(videoMaterial.getDataPath());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class s implements LightNode.ILightNodeTipsListener {
        s() {
        }

        @Override // com.tencent.ttpic.openapi.filter.LightNode.ILightNodeTipsListener
        public void onHideNormalTip() {
            t tVar = LSCameraGLSurfaceView.this.S;
            if (tVar != null) {
                tVar.onHideNormalTip();
            }
        }

        @Override // com.tencent.ttpic.openapi.filter.LightNode.ILightNodeTipsListener
        public void onHidePagTip() {
            t tVar = LSCameraGLSurfaceView.this.S;
            if (tVar != null) {
                tVar.onHidePagTip();
            }
        }

        @Override // com.tencent.ttpic.openapi.filter.LightNode.ILightNodeTipsListener
        public void onShowNormalTip(String str, String str2, int i3) {
            t tVar = LSCameraGLSurfaceView.this.S;
            if (tVar != null) {
                tVar.onShowNormalTip(str, str2, i3);
            }
        }

        @Override // com.tencent.ttpic.openapi.filter.LightNode.ILightNodeTipsListener
        public void onShowPagTip(String str, int i3) {
            t tVar = LSCameraGLSurfaceView.this.S;
            if (tVar != null) {
                tVar.onShowPagTip(str, i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface t {
        void k(ExposureInfo exposureInfo);

        void l(ExposureInfo exposureInfo);

        void onAssetProcessingData(HashMap<String, String> hashMap);

        void onHideNormalTip();

        void onHidePagTip();

        void onSelectFaceEffect(VideoMaterial videoMaterial);

        void onShowNormalTip(String str, String str2, int i3);

        void onShowPagTip(String str, int i3);

        void r(int i3, boolean z16, LSCameraManager.b bVar);

        void s(LSFilterProcessTex lSFilterProcessTex);
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface u {
        void a();

        void onBasicBeautyDownload();

        void onDrawFrameWithEffect(int i3, AEFilterManager aEFilterManager);

        void onFirstFrameDone();

        void onOrientionChanged(int i3);

        void onPreviewSizeChanged(int i3, int i16, int i17, int i18);

        void onPreviewSurfaceTextureCreate(SurfaceTexture surfaceTexture);

        void onPreviewSurfaceTextureRelease();
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface v {
        void onGenderTypeListener(int i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface w {
        void a(LSFilterProcessTex lSFilterProcessTex);
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface x {
        void onAEKitInited();
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface y {
        void onCaptureError(int i3);

        void onPhotoCaptured(AEPhotoCaptureResult aEPhotoCaptureResult);

        void onVideoCaptureStart();

        void onVideoCaptured(AEVideoCaptureResult aEVideoCaptureResult);

        void reportFirstFrameShown();
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface z {
        void onExtract(Bitmap bitmap);
    }

    static {
        int phonePerfLevel = OfflineConfig.getPhonePerfLevel(BaseApplication.getContext());
        f63744p1 = phonePerfLevel;
        f63745q1 = phonePerfLevel < 4 ? phonePerfLevel < 2 ? PlayerResources.ViewId.CANVAS_VIDEO_TOTAL_TRAFFIC_TEXT : 720 : 1080;
        f63746r1 = false;
    }

    public LSCameraGLSurfaceView(Context context) {
        super(context);
        this.f63767i = 0;
        this.f63776m = false;
        this.C = 0;
        this.D = 320;
        this.E = 480;
        this.F = 0;
        this.G = 0;
        this.H = 0;
        this.I = 0;
        this.J = 0;
        this.K = true;
        this.L = 0;
        this.M = false;
        this.f63760f0 = false;
        this.f63768i0 = 3.0f;
        this.f63770j0 = false;
        this.f63772k0 = true;
        this.f63774l0 = true;
        this.f63777m0 = true;
        this.f63779n0 = true;
        this.f63781o0 = 90;
        this.f63783p0 = true;
        this.f63784q0 = false;
        this.f63785r0 = true;
        this.f63786s0 = 0;
        this.f63787t0 = false;
        this.f63788u0 = true;
        this.f63789v0 = false;
        this.f63790w0 = 0;
        this.f63791x0 = false;
        this.f63792y0 = 0L;
        this.C0 = null;
        this.D0 = new tq.a();
        this.G0 = false;
        this.H0 = false;
        this.P0 = true;
        this.V0 = null;
        this.W0 = null;
        this.X0 = false;
        this.Y0 = false;
        this.Z0 = -1;
        this.f63755d1 = null;
        this.f63763g1 = 0;
        this.f63766h1 = System.currentTimeMillis();
        this.f63769i1 = new com.tencent.aelight.camera.ae.util.t();
        this.f63778m1 = 2;
        this.f63780n1 = new PointF(0.0f, 0.0f);
        this.f63782o1 = 0;
        U0();
        this.f63748a1 = System.identityHashCode(this);
    }

    private void A0(int i3, float[] fArr, float[] fArr2) {
        if (f1()) {
            D0(GLSLRender.GL_TEXTURE_2D, i3, fArr, fArr2, SystemClock.elapsedRealtimeNanos());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0(AEPhotoCaptureResult aEPhotoCaptureResult) {
        y yVar = this.R;
        if (yVar != null) {
            yVar.onPhotoCaptured(aEPhotoCaptureResult);
        }
    }

    private Activity E0() {
        Activity activity = this.f63773k1;
        if (activity != null) {
            return activity;
        }
        if (getContext() instanceof Activity) {
            return (Activity) getContext();
        }
        return null;
    }

    private void F1() {
        ms.a.f("LSCameraGLSurfaceView", "preAction");
        if (f63746r1) {
            return;
        }
        X0();
    }

    private void G1() {
        u uVar;
        if (this.f63750b1 || !e1() || (uVar = this.Q) == null) {
            return;
        }
        uVar.onFirstFrameDone();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MustRunOnGLThread
    public void H1(Map<String, String> map) {
        AEFilterManager R;
        LSFilterProcessBase lSFilterProcessBase = this.f63756e;
        if ((lSFilterProcessBase instanceof LSFilterProcessTex) && (R = ((LSFilterProcessTex) lSFilterProcessBase).R()) != null) {
            ms.a.f("LSCameraGLSurfaceView", "prepareWMData: watermarkDict=" + map);
            R.wmAddInfoDict(map);
            String str = map.get("City");
            String str2 = map.get("Road");
            StringBuilder sb5 = new StringBuilder();
            if (str == null) {
                str = "";
            }
            sb5.append(str);
            if (str2 == null) {
                str2 = "";
            }
            sb5.append(str2);
            String sb6 = sb5.toString();
            ms.a.f("LSCameraGLSurfaceView", "[prepareWMData] location : " + sb6);
            if (!TextUtils.isEmpty(sb6)) {
                R.wmSetLocation(sb6);
            }
            String str3 = map.get("WeatherType");
            if (!TextUtils.isEmpty(str3)) {
                try {
                    R.wmSetWeatherCode(Integer.parseInt(str3));
                } catch (NumberFormatException e16) {
                    ms.a.e("LSCameraGLSurfaceView", e16);
                }
            }
            String str4 = map.get("Weather");
            if (str4 != null) {
                R.wmSetWeatherStr(str4);
            }
            String str5 = map.get("TempCurr");
            if (str5 != null) {
                R.wmSetTemperature(str5.replace(HardCodeUtil.qqStr(R.string.y9o), ""));
            }
        }
    }

    private String I0() {
        String str = this.W0;
        if (str == null || !str.contains("video_makeup_")) {
            return null;
        }
        return this.W0;
    }

    private void I1(final w wVar) {
        if (a1()) {
            LSFilterProcessBase lSFilterProcessBase = this.f63756e;
            if (lSFilterProcessBase instanceof LSFilterProcessTex) {
                final LSFilterProcessTex lSFilterProcessTex = (LSFilterProcessTex) lSFilterProcessBase;
                queueEvent(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ad
                    @Override // java.lang.Runnable
                    public final void run() {
                        LSCameraGLSurfaceView.w.this.a(lSFilterProcessTex);
                    }
                });
            }
        }
    }

    private int J0() {
        if (LSDashboardUtil.m()) {
            return f63745q1;
        }
        return 720;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J1() {
        queueEvent(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView.22
            @Override // java.lang.Runnable
            public void run() {
                if (LSCameraGLSurfaceView.this.f63756e == null || !(LSCameraGLSurfaceView.this.f63756e instanceof LSFilterProcessTex)) {
                    return;
                }
                ((LSFilterProcessTex) LSCameraGLSurfaceView.this.f63756e).N0(VideoMaterial.loadLightAsset(LightNode.getEmptyMaterialPath()));
            }
        });
    }

    private LSFilterProcessBase.VideoOutRatio L0() {
        ms.a.a("LSCameraGLSurfaceView", "getRatio" + this.A0);
        if (g1()) {
            return LSFilterProcessBase.VideoOutRatio.NONE;
        }
        return LSFilterProcessBase.VideoOutRatio.RATIO_9_16;
    }

    private void O1() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView.46
            @Override // java.lang.Runnable
            public void run() {
                long g16 = mq.a.d().g(IPrefRecorder.MILESTONE_CAMERA_TAB_SWITCH);
                HashMap<String, String> hashMap = new HashMap<>();
                if (g16 > 0) {
                    hashMap.put("triggerSource", IPrefRecorder.MILESTONE_CAMERA_TAB_SWITCH);
                    hashMap.put(QCircleWeakNetReporter.KEY_COST, String.valueOf(g16));
                    hashMap.put("FirstTapCameraTab", String.valueOf(tq.b.h().l()));
                    com.tencent.aelight.camera.ae.report.b.b().x(hashMap);
                    return;
                }
                long g17 = mq.a.d().g(IPrefRecorder.MILESTONE_CAMERA_RESUME_SWITCH);
                hashMap.put("triggerSource", "becomeActive");
                hashMap.put(QCircleWeakNetReporter.KEY_COST, String.valueOf(g17));
                com.tencent.aelight.camera.ae.report.b.b().x(hashMap);
            }
        }, 16, null, true);
    }

    private int[] P0() {
        LSFilterProcessBase lSFilterProcessBase;
        int[] f16;
        int i3;
        if (LSDashboardUtil.m() && (lSFilterProcessBase = this.f63756e) != null && (f16 = lSFilterProcessBase.f()) != null && f16.length >= 2 && (i3 = f16[0]) > 0 && f16[1] > 0) {
            return new int[]{com.tencent.aelight.camera.ae.flashshow.util.g.a(i3), com.tencent.aelight.camera.ae.flashshow.util.g.a(f16[1])};
        }
        return new int[]{this.Q0, this.R0};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P1() {
        ms.a.f("LSCameraGLSurfaceView", "reqLocationPermissionAndReqWMDict");
        new com.tencent.aelight.camera.ae.flashshow.util.m(E0(), new g()).c();
    }

    private boolean Q0() {
        return getContext().checkSelfPermission(QQPermissionConstants.Permission.CAMERA) == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q1() {
        com.tencent.aelight.camera.ae.camera.ui.watermark.b.f().k(new b.c() { // from class: com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView.26
            @Override // com.tencent.aelight.camera.ae.camera.ui.watermark.b.c
            public void onGetWatermarkDict(final Map<String, String> map) {
                LSCameraGLSurfaceView.this.queueEvent(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView.26.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LSCameraGLSurfaceView.this.H1(map);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R1() {
        t tVar = this.S;
        if (tVar != null) {
            tVar.r(this.f63778m1, false, new e());
        } else {
            J1();
        }
    }

    private void S1() {
        com.tencent.mobileqq.videocodec.mediacodec.encoder.c cVar = this.J0;
        if (cVar == null) {
            return;
        }
        if (this.M) {
            ms.a.a("LSCameraGLSurfaceView", "setEncodeConfigMuxer muxerWrapper = null");
            this.J0.f312575t = null;
        } else if (cVar.f312575t == null) {
            ms.a.a("LSCameraGLSurfaceView", "setEncodeConfigMuxer create MuxerWrapper");
            try {
                FileUtils.createFileIfNotExits(this.J0.f312558c);
                com.tencent.mobileqq.videocodec.mediacodec.encoder.c cVar2 = this.J0;
                cVar2.f312575t = new iq.e(cVar2.f312558c, this);
            } catch (IOException e16) {
                ms.a.a("LSCameraGLSurfaceView", "setEncodeConfigMuxer encounter error");
                e16.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T1(LSFilterProcessTex lSFilterProcessTex) {
        t tVar = this.S;
        if (tVar != null) {
            tVar.s(lSFilterProcessTex);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U1(final String str) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView.19
            @Override // java.lang.Runnable
            public void run() {
                QQToast.makeText(BaseApplication.getContext(), str, 0).show();
            }
        });
    }

    private void V0() {
        SurfaceTexture h16;
        LSFilterProcessBase lSFilterProcessBase = this.f63756e;
        if (lSFilterProcessBase == null || !(lSFilterProcessBase instanceof LSFilterProcessTex)) {
            ms.a.a("LSCameraGLSurfaceView", "initFilterProcess: mFilterProcess==null, createFilterProcess");
            LSFilterProcessBase v06 = v0();
            if (v06 == this.f63756e) {
                return;
            } else {
                this.f63756e = v06;
            }
        }
        tq.b.h().n("LSCameraGLSurfaceView", "initFilterProcess---begin");
        W0();
        LSFilterProcessBase lSFilterProcessBase2 = this.f63756e;
        if (lSFilterProcessBase2 instanceof LSFilterProcessTex) {
            com.tencent.aelight.camera.ae.flashshow.filter.b.b((LSFilterProcessTex) lSFilterProcessBase2);
            x xVar = this.P;
            if (xVar != null) {
                xVar.onAEKitInited();
            }
            ((LSFilterProcessTex) this.f63756e).F0(this.T);
            ((LSFilterProcessTex) this.f63756e).z0(this.U);
            ((LSFilterProcessTex) this.f63756e).q0(this.f63771j1);
            ((LSFilterProcessTex) this.f63756e).L0(new s());
            ((LSFilterProcessTex) this.f63756e).D0(new a());
            ((LSFilterProcessTex) this.f63756e).u0(new b());
            int i3 = this.F;
            if (i3 > 0) {
                this.f63756e.v(this.D, this.E, i3, this.G, this.H, this.I);
                this.f63756e.w(this.Q0, this.R0);
                ms.a.f("LSCameraGLSurfaceView", "onSurfaceChanged:" + this.D + "," + this.E + "," + this.F + "," + this.G + ",previewWidth:" + this.H + ",previewHeight:" + this.I);
            }
        }
        if (this.f63776m) {
            h16 = Y0();
            this.f63756e.q(this.f63767i, this.f63764h);
        } else {
            h16 = this.f63756e.h();
        }
        h16.setOnFrameAvailableListener(this);
        if (h16 instanceof com.tencent.aelight.camera.ae.camera.testpkg.c) {
            ((com.tencent.aelight.camera.ae.camera.testpkg.c) h16).d(new c());
        }
        r1(h16);
        tq.b.h().n("LSCameraGLSurfaceView", "initFilterProcess---end");
    }

    private void W0() {
        if (this.N == null) {
            this.N = new d(getContext().getApplicationContext());
        }
        if (this.N.canDetectOrientation()) {
            this.N.enable();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W1() {
        ms.a.f("LSCameraGLSurfaceView", "startCaptureVideo---recordingEnabled=" + this.K0);
        this.D0.f();
        String str = this.f63754d0.f448260n + File.separator + System.currentTimeMillis() + ".mp4";
        int f16 = (!this.P0 || this.f63791x0) ? 0 : com.tencent.aelight.camera.ae.flashshow.util.g.f(this.f63781o0);
        int[] P0 = P0();
        com.tencent.mobileqq.videocodec.mediacodec.encoder.c cVar = new com.tencent.mobileqq.videocodec.mediacodec.encoder.c(str, P0[0], P0[1], this.f63754d0.f(), this.f63754d0.g(), false, f16);
        this.J0 = cVar;
        cVar.f312572q = this.f63754d0.a();
        this.J0.f312573r = this.f63754d0.d();
        AEVideoCaptureResult aEVideoCaptureResult = new AEVideoCaptureResult();
        this.F0 = aEVideoCaptureResult;
        aEVideoCaptureResult.startTimeMs = System.currentTimeMillis();
        AEVideoCaptureResult aEVideoCaptureResult2 = this.F0;
        aEVideoCaptureResult2.orientation = this.f63781o0;
        aEVideoCaptureResult2.type = 0;
        this.K0 = true;
        LSFilterProcessBase lSFilterProcessBase = this.f63756e;
        if (lSFilterProcessBase != null) {
            lSFilterProcessBase.p(this.K0);
        }
        com.tencent.aelight.camera.ae.flashshow.util.g.i(false, false);
    }

    public static synchronized void X0() {
        synchronized (LSCameraGLSurfaceView.class) {
            ms.a.f("LSCameraGLSurfaceView", "[initSdk] + BEGIN, isSdkInited = " + f63746r1);
            long currentTimeMillis = System.currentTimeMillis();
            if (!f63746r1) {
                ms.a.f("LSCameraGLSurfaceView", "[initSdk] do init");
                f63746r1 = true;
                tq.b.h().o("glSurfaceViewStaticInit-begin");
                ms.a.f("LSCameraGLSurfaceView", "[initSdk] , AEKitForQQ.init result = " + com.tencent.aelight.camera.ae.d.m(false));
                tq.b.h().o("glSurfaceViewStaticInit-end");
            }
            ms.a.f("LSCameraGLSurfaceView", "[initSdk] + END, time cost = " + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    private SurfaceTexture Y0() {
        SurfaceTexture surfaceTexture = this.f63764h;
        if (surfaceTexture != null) {
            return surfaceTexture;
        }
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.f63767i = iArr[0];
        SurfaceTexture surfaceTexture2 = new SurfaceTexture(this.f63767i);
        this.f63764h = surfaceTexture2;
        return surfaceTexture2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y1() {
        ms.a.f("LSCameraGLSurfaceView", "stopCaptureVideo---recordingEnabled=" + this.K0 + ", recordingStatus=" + this.U0 + ", isPaused=" + this.f63788u0);
        if (this.N0) {
            this.N0 = false;
            if (this.O0 != 0 && this.f63788u0) {
                y0(0, null, null);
            }
        }
    }

    private void Z0(int i3, int i16) {
        int i17 = (int) (this.f63754d0.i() * ((this.E * 1.0f) / this.D));
        if (com.tencent.aelight.camera.ae.util.j.h().a()) {
            i17 = this.f63754d0.j();
        }
        if (this.f63757e0) {
            int[] h16 = com.tencent.aelight.camera.ae.flashshow.util.g.h(i17, i3, i16);
            int[] b16 = com.tencent.aelight.camera.ae.flashshow.util.g.b(h16[0], h16[1], this.f63754d0.c(), this.f63754d0.b(), 1.0f);
            this.Q0 = b16[0];
            this.R0 = b16[1];
            return;
        }
        int[] b17 = com.tencent.aelight.camera.ae.flashshow.util.g.b(i3, i16, this.D, this.E, this.f63754d0.h());
        int i18 = b17[0];
        this.Q0 = i18;
        int i19 = b17[1];
        this.R0 = i19;
        int[] h17 = com.tencent.aelight.camera.ae.flashshow.util.g.h(i17, i18, i19);
        this.Q0 = h17[0];
        this.R0 = h17[1];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a1() {
        LSFilterProcessBase lSFilterProcessBase;
        return AEResUtil.d0() && AEResUtil.U(AEResInfo.LIGHT_RES_BASE_PACKAGE) && (lSFilterProcessBase = this.f63756e) != null && (lSFilterProcessBase instanceof LSFilterProcessTex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d1() {
        if (getContext() instanceof Activity) {
            return gq.a.j(((Activity) getContext()).getIntent());
        }
        return false;
    }

    private boolean e1() {
        if (getContext() instanceof Activity) {
            return gq.a.r(((Activity) getContext()).getIntent());
        }
        return false;
    }

    private short[] e2(byte[] bArr) {
        int length = bArr.length >> 1;
        short[] sArr = new short[length];
        for (int i3 = 0; i3 < length; i3++) {
            int i16 = i3 * 2;
            sArr[i3] = (short) ((bArr[i16 + 1] << 8) | (bArr[i16] & 255));
        }
        return sArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f1() {
        return true;
    }

    private boolean g1() {
        if (getContext() instanceof Activity) {
            return gq.a.D(((Activity) getContext()).getIntent());
        }
        return false;
    }

    private boolean h1() {
        return this.f63778m1 == 1;
    }

    private void i2(String str, int i3) {
        setMaterial(str);
        this.Z0 = i3;
        ms.a.f("LSCameraGLSurfaceView", ":metaData path:" + str + ",alpha:" + i3);
    }

    private boolean j1() {
        return this.f63791x0 && this.K0 && this.J0 != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l1() {
        LSFilterProcessTex a16;
        ms.a.f("LSCameraGLSurfaceView", "acturl applyLastFilterAgain");
        com.tencent.aelight.camera.ae.flashshow.ui.ay ayVar = (com.tencent.aelight.camera.ae.flashshow.ui.ay) com.tencent.aelight.camera.ae.control.a.b(4);
        ay.SelectFilter d16 = ayVar.d();
        if (d16 == null || "".equals(d16.getId()) || (a16 = com.tencent.aelight.camera.ae.flashshow.filter.b.a()) == null) {
            return;
        }
        a16.A0(false);
        a16.Z0(d16.getLutPath());
        if (ayVar.c(d16.getId()) != null) {
            h2(r0.getSeekBarValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m1() {
        queueEvent(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ai
            @Override // java.lang.Runnable
            public final void run() {
                LSCameraGLSurfaceView.this.l1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o1() {
        g2(this.Z0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q0() {
        return getContext().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0 || getContext().checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q1(VideoMaterial videoMaterial) {
        return videoMaterial.getLightAsset() != null && videoMaterial.getLightAsset().needRenderAbility(LightConstants.AssetFeatureKey.WATERMARK_NEED_LOCATION);
    }

    private void r0() {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView.17
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (LSCameraGLSurfaceView.this.B0 != null) {
                        LSCameraGLSurfaceView.this.B0.setImageBitmap(null);
                        LSCameraGLSurfaceView.this.B0.setVisibility(8);
                    }
                    if (LSCameraGLSurfaceView.this.C0 != null) {
                        LSCameraGLSurfaceView.this.C0.recycle();
                        LSCameraGLSurfaceView.this.C0 = null;
                    }
                } catch (Exception unused) {
                    ms.a.c("LSCameraGLSurfaceView", "bitmap recycle error");
                }
            }
        });
    }

    private void r1(SurfaceTexture surfaceTexture) {
        u uVar = this.Q;
        if (uVar != null) {
            if (!this.f63776m || (this.f63756e instanceof com.tencent.aelight.camera.ae.flashshow.filter.c)) {
                uVar.onPreviewSurfaceTextureCreate(surfaceTexture);
            }
            if (this.f63776m && (this.f63756e instanceof LSFilterProcessTex)) {
                this.Q.onBasicBeautyDownload();
            }
        }
    }

    private void s0() {
        if (this.f63764h == null) {
            return;
        }
        GLES20.glDeleteTextures(1, new int[]{this.f63767i}, 0);
        this.f63764h.release();
        this.f63764h = null;
        this.f63776m = false;
    }

    private com.tencent.aelight.camera.ae.camera.filter.a u0() {
        com.tencent.aelight.camera.ae.camera.filter.a b16;
        if (AEDashboardUtil.p(E0())) {
            b16 = a.C0536a.b(LightConstants.DefaultBeautyVersion.DEFAULT_BEAUTY_VERSION_V7_1);
        } else {
            b16 = a.C0536a.b("defaultBeautyV7.json");
        }
        if (getContext() instanceof Activity) {
            b16.q((WatermarkConfig) ((Activity) getContext()).getIntent().getParcelableExtra(QQWinkConstants.WATERMARK_CONFIG));
        }
        return b16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private LSFilterProcessBase v0() {
        com.tencent.aelight.camera.ae.flashshow.filter.c cVar;
        ms.a.a("LSCameraGLSurfaceView", "[createFilterProcess]:");
        LSFilterProcessBase lSFilterProcessBase = this.f63756e;
        if (lSFilterProcessBase != null && ((lSFilterProcessBase instanceof LSFilterProcessTex) || this.f63760f0)) {
            ms.a.c("LSCameraGLSurfaceView", "[createFilterProcess]: return , mFilterProcess = " + this.f63756e + " hasRecorded = " + this.f63760f0);
            return this.f63756e;
        }
        int i3 = this.C + 1;
        this.C = i3;
        LSFilterProcessBase lSFilterProcessBase2 = this.f63756e;
        if (lSFilterProcessBase2 != null && i3 % 30 != 0) {
            return lSFilterProcessBase2;
        }
        ms.a.f("LSCameraGLSurfaceView", "createFilterProcess---BEGIN");
        boolean m3 = com.tencent.aelight.camera.ae.d.m(false);
        boolean v3 = com.tencent.aelight.camera.ae.d.v();
        LSFilterProcessBase lSFilterProcessBase3 = this.f63756e;
        if (lSFilterProcessBase3 != null) {
            if (m3 && v3) {
                lSFilterProcessBase3.b();
                this.f63760f0 = false;
            } else {
                ms.a.c("LSCameraGLSurfaceView", "[createFilterProcess]: return because aekitInited = false");
                return this.f63756e;
            }
        }
        if (m3 && v3) {
            LSFilterProcessTex lSFilterProcessTex = new LSFilterProcessTex(this.f63748a1, u0());
            lSFilterProcessTex.y0(this.f63782o1);
            lSFilterProcessTex.r(L0());
            if (LSDashboardUtil.m()) {
                LSOperationUpdater lSOperationUpdater = this.f63759f;
                LSOperationUpdater lSOperationUpdater2 = new LSOperationUpdater();
                this.f63759f = lSOperationUpdater2;
                lSFilterProcessTex.G0(lSOperationUpdater2, lSOperationUpdater);
            }
            lSFilterProcessTex.w0(new r());
            ms.a.f("LSCameraGLSurfaceView", "createFilterProcess---create LSFilterProcessTex");
            cVar = lSFilterProcessTex;
        } else {
            ms.a.a("LSCameraGLSurfaceView", "FeatureManager.loadBasicFeaturesInLight \u5931\u8d25\uff0c\u6784\u5efaNonAEFilterProcess");
            com.tencent.aelight.camera.ae.flashshow.filter.c cVar2 = new com.tencent.aelight.camera.ae.flashshow.filter.c();
            this.f63776m = true;
            ms.a.c("LSCameraGLSurfaceView", "createFilterProcess---create NonAEFilterProcess");
            U1(HardCodeUtil.qqStr(R.string.xzx));
            cVar = cVar2;
        }
        if (com.tencent.aelight.camera.ae.util.c.d()) {
            try {
                VideoDecoder.SetMaxHardwareDecoderCount(0);
            } catch (Throwable th5) {
                ms.a.c("LSCameraGLSurfaceView", "call SetMaxHardwareDecoderCount method error." + th5.getMessage());
            }
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0() {
        LSFilterProcessBase lSFilterProcessBase = this.f63756e;
        if (lSFilterProcessBase != null) {
            lSFilterProcessBase.b();
            this.f63756e.d(true);
            LSFilterProcessBase lSFilterProcessBase2 = this.f63756e;
            if (lSFilterProcessBase2 instanceof LSFilterProcessTex) {
                ((LSFilterProcessTex) lSFilterProcessBase2).K();
                com.tencent.aelight.camera.ae.flashshow.filter.b.b(null);
            }
            this.f63756e = null;
            this.f63760f0 = false;
            u uVar = this.Q;
            if (uVar != null) {
                uVar.onPreviewSurfaceTextureRelease();
            }
            s0();
        }
        AEFilterManagerHolder.setFilterProcess(null);
    }

    private void x0() {
        com.tencent.aelight.camera.ae.camera.util.a aVar = this.N;
        if (aVar != null) {
            aVar.disable();
        }
    }

    public void A1(String str, int i3, int i16) {
        if (b1()) {
            I1(new l(str, i3, i16));
        }
    }

    public void B1(String str, int i3) {
        if (b1()) {
            I1(new j(str, i3));
        }
    }

    protected void C0(final AEVideoCaptureResult aEVideoCaptureResult) {
        if (this.R != null) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView.13
                @Override // java.lang.Runnable
                public void run() {
                    LSCameraGLSurfaceView.this.R.onVideoCaptured(aEVideoCaptureResult);
                }
            });
        }
        com.tencent.aelight.camera.aioeditor.b.q(this.f63778m1 != 1 ? 2 : 1);
    }

    public void C1(String str, int i3) {
        if (b1()) {
            I1(new m(str, i3));
        }
    }

    public void D1(boolean z16) {
        if (b1()) {
            I1(new k(z16));
        }
    }

    public void E1(String str) {
        if (b1()) {
            I1(new n(str));
        }
    }

    public String F0() {
        xp.a aVar = this.f63754d0;
        if (aVar != null) {
            return aVar.f448260n;
        }
        return null;
    }

    public int H0() {
        return this.f63781o0;
    }

    public void K1(final VideoMaterial videoMaterial) {
        String str = this.f63755d1;
        final boolean z16 = str != null && str.equals(videoMaterial.getDataPath());
        this.f63755d1 = null;
        queueEvent(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView.24
            @Override // java.lang.Runnable
            public void run() {
                if (videoMaterial != null) {
                    ms.a.c("LSCameraGLSurfaceView", "[setVideoMaterial] update material: " + videoMaterial.getId());
                } else {
                    ms.a.c("LSCameraGLSurfaceView", "[setVideoMaterial] update material: ");
                }
                if (LSCameraGLSurfaceView.this.f63756e instanceof LSFilterProcessTex) {
                    ((LSFilterProcessTex) LSCameraGLSurfaceView.this.f63756e).O0(videoMaterial, z16);
                }
                VideoMaterial videoMaterial2 = videoMaterial;
                if (videoMaterial2 != null) {
                    com.tencent.aelight.camera.ae.util.m.f65786a.c(videoMaterial2.getId());
                }
                if (LSCameraGLSurfaceView.this.f63753d == null || !(LSCameraGLSurfaceView.this.f63753d instanceof LSCaptureController)) {
                    return;
                }
                ((LSCaptureController) LSCameraGLSurfaceView.this.f63753d).A();
            }
        });
        if (this.Z0 >= 0) {
            postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ae
                @Override // java.lang.Runnable
                public final void run() {
                    LSCameraGLSurfaceView.this.o1();
                }
            }, 100L);
        }
    }

    public int M0() {
        return this.L;
    }

    public void M1() {
        ms.a.f("LSCameraGLSurfaceView", "recoverScene");
        this.f63769i1.b();
    }

    public int N0() {
        return this.E;
    }

    public void N1() {
        if (TextUtils.isEmpty(this.W0)) {
            return;
        }
        setLastForceMaterialPath(this.W0);
        i2(this.W0, this.Z0);
    }

    public int O0() {
        return this.D;
    }

    public boolean R0() {
        LSFilterProcessBase lSFilterProcessBase = this.f63756e;
        return (lSFilterProcessBase instanceof LSFilterProcessTex) && ((LSFilterProcessTex) lSFilterProcessBase).R() != null && ((LSFilterProcessTex) this.f63756e).R().currentMaterialNeedTouchTriggerEvent();
    }

    public boolean S0() {
        return R0();
    }

    public void T0(xp.a aVar, iq.a aVar2, ac acVar) {
        if (this.f63754d0 != null) {
            throw new RuntimeException("init is already called");
        }
        if (aVar != null) {
            this.A0 = AEVideoStoryTopBarViewModel.Ratio.fromCode(acVar.r());
            ms.a.a("LSCameraGLSurfaceView", "adjustRatio :" + this.A0);
            this.f63754d0 = aVar;
            if (ms.a.g()) {
                ms.a.a("LSCameraGLSurfaceView", "setCaptureParam : " + aVar);
            }
            this.I0 = new com.tencent.mobileqq.videocodec.mediacodec.recorder.e();
            this.E0 = aVar2;
            SensorManager sensorManager = (SensorManager) getContext().getApplicationContext().getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
            this.f63749b0 = sensorManager;
            this.f63751c0 = SensorMonitor.getDefaultSensor(sensorManager, 1);
            this.D0.c();
            return;
        }
        throw new IllegalArgumentException("param captureParam is null");
    }

    public void V1() {
        ms.a.f("LSCameraGLSurfaceView", "startCaptureVideo---recordingEnabled=" + this.N0);
        int[] f16 = this.f63756e.f();
        com.tencent.mobileqq.videocodec.mediacodec.encoder.c cVar = new com.tencent.mobileqq.videocodec.mediacodec.encoder.c("/sdcard/testVideoFilter.mp4", f16[0], f16[1], this.f63754d0.f(), this.f63754d0.g(), false, 0);
        this.M0 = cVar;
        cVar.f312572q = this.f63754d0.a();
        this.M0.f312573r = this.f63754d0.d();
        this.N0 = true;
    }

    public void X1() {
        queueEvent(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView.29
            @Override // java.lang.Runnable
            public void run() {
                if (LSCameraGLSurfaceView.this.a1()) {
                    if (LSCameraGLSurfaceView.this.f63756e != null) {
                        LSCameraGLSurfaceView.this.f63756e.m();
                    }
                    LSCameraGLSurfaceView.this.W1();
                }
            }
        });
    }

    public void Z1() {
        ms.a.f("LSCameraGLSurfaceView", "stopCaptureVideo---recordingEnabled=" + this.K0 + ", recordingStatus=" + this.U0 + ", isPaused=" + this.f63788u0);
        if (this.K0) {
            this.K0 = false;
            this.f63760f0 = true;
            LSFilterProcessBase lSFilterProcessBase = this.f63756e;
            if (lSFilterProcessBase != null) {
                lSFilterProcessBase.p(this.K0);
            }
            if (this.U0 == 0) {
                y yVar = this.R;
                if (yVar != null) {
                    yVar.onCaptureError(102);
                    return;
                }
                return;
            }
            if (this.f63788u0) {
                A0(0, null, null);
            }
        }
    }

    public void a2() {
        queueEvent(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView.30
            @Override // java.lang.Runnable
            public void run() {
                LSCameraGLSurfaceView.this.Z1();
            }
        });
    }

    public boolean b1() {
        return this.f63772k0;
    }

    public void b2(boolean z16) {
        if (a1()) {
            ((LSFilterProcessTex) this.f63756e).R0(z16);
        }
    }

    public boolean c1() {
        return this.f63779n0;
    }

    public void c2(boolean z16) {
        if (a1()) {
            ((LSFilterProcessTex) this.f63756e).S0(z16);
        }
    }

    public void d2(boolean z16) {
        if (a1()) {
            ((LSFilterProcessTex) this.f63756e).T0(z16);
        }
    }

    public void f2(float f16, int i3) {
        if (this.f63756e instanceof LSFilterProcessTex) {
            final DeviceCameraConfig deviceCameraConfig = new DeviceCameraConfig();
            deviceCameraConfig.cameraHorizontalFov = f16;
            deviceCameraConfig.cameraIndex = i3;
            queueEvent(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView.3
                @Override // java.lang.Runnable
                public void run() {
                    if (LSCameraGLSurfaceView.this.f63756e == null || !(LSCameraGLSurfaceView.this.f63756e instanceof LSFilterProcessTex)) {
                        return;
                    }
                    ((LSFilterProcessTex) LSCameraGLSurfaceView.this.f63756e).W0(deviceCameraConfig);
                }
            });
        }
    }

    public void g2(int i3) {
        this.Z0 = i3;
        I1(new p(i3));
        AEMaterialMetaData aEMaterialMetaData = this.f63775l1;
        if (aEMaterialMetaData != null) {
            os.a.f423933a.f(aEMaterialMetaData.f69050id, this.Z0);
        }
    }

    public void h2(float f16) {
        I1(new o(f16));
    }

    public boolean i1() {
        return this.K0;
    }

    public void j2(MotionEvent motionEvent) {
        LSFilterProcessBase lSFilterProcessBase = this.f63756e;
        if (lSFilterProcessBase instanceof LSFilterProcessTex) {
            ((LSFilterProcessTex) lSFilterProcessBase).b1(motionEvent, getWidth(), getHeight());
        }
    }

    public boolean k1() {
        return this.f63774l0;
    }

    public void l0() {
        ms.a.f("LSCameraGLSurfaceView", "applyLastFilterAgain");
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ah
            @Override // java.lang.Runnable
            public final void run() {
                LSCameraGLSurfaceView.this.m1();
            }
        });
    }

    public boolean m0() {
        if (a1()) {
            return !((LSFilterProcessTex) this.f63756e).W();
        }
        return true;
    }

    public void n0() {
        LSFilterProcessBase lSFilterProcessBase = this.f63756e;
        if (lSFilterProcessBase != null) {
            lSFilterProcessBase.n(true, this.f63781o0, this);
        } else {
            this.R.onCaptureError(105);
            B0(null);
        }
        requestRender();
    }

    public void o0(int i3) {
        LSFilterProcessBase lSFilterProcessBase = this.f63756e;
        if (lSFilterProcessBase != null && (lSFilterProcessBase instanceof LSFilterProcessTex)) {
            ((LSFilterProcessTex) lSFilterProcessBase).R().setLightNodePresetData(AECameraConstants.KEY_CAMERA_CAPTURE_EVENT, LSMiddleCameraUnit.f63916q1);
        }
        if (i3 > 0) {
            ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView.28
                @Override // java.lang.Runnable
                public void run() {
                    LSCameraGLSurfaceView.this.n0();
                }
            }, i3);
        } else {
            n0();
        }
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        ms.a.f("LSCameraGLSurfaceView", "[onAttachedToWindow]" + this);
        super.onAttachedToWindow();
        ms.a.f("LSCameraGLSurfaceView", "[onAttachedToWindow] end");
    }

    @Override // com.tencent.mobileqq.videocodec.audio.AudioCapture.b
    public void onAudioCaptured(String str) {
        ms.a.c("LSCameraGLSurfaceView", "onAudioCaptured---filePath=" + str);
        AEVideoCaptureResult aEVideoCaptureResult = this.F0;
        aEVideoCaptureResult.audioDataFilePath = str;
        if (aEVideoCaptureResult.videoMp4FilePath != null) {
            C0(aEVideoCaptureResult);
        }
    }

    @Override // com.tencent.mobileqq.videocodec.audio.AudioCapture.b
    public void onAudioFrames(byte[] bArr, int i3, int i16) {
        double d16 = 0.0d;
        for (short s16 : e2(bArr)) {
            d16 += s16 * s16;
        }
        double log10 = Math.log10(d16 / r4.length) * 10.0d;
        LSFilterProcessBase lSFilterProcessBase = this.f63756e;
        if (lSFilterProcessBase instanceof LSFilterProcessTex) {
            ((LSFilterProcessTex) lSFilterProcessBase).c1((float) log10);
        }
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.filter.LSFilterProcessTex.d
    public void onCaptureError(int i3) {
        y yVar = this.R;
        if (yVar != null) {
            yVar.onCaptureError(i3);
        }
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        ms.a.c("LSCameraGLSurfaceView", "[onDetachedFromWindow]" + this);
        super.onDetachedFromWindow();
        ms.a.c("LSCameraGLSurfaceView", "[onDetachedFromWindow] end");
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        String str;
        int i3;
        String str2;
        if (this.f63788u0) {
            G1();
            return;
        }
        boolean z16 = this.f63784q0;
        if (!this.f63770j0) {
            this.f63770j0 = Q0();
        }
        if (this.f63770j0) {
            if (z16 && !this.f63752c1) {
                ms.a.a("LSCameraGLSurfaceView", "[onDrawFrame] onFirstFrameAfterStartPreviewDone");
                this.f63752c1 = true;
                u uVar = this.Q;
                if (uVar != null) {
                    uVar.a();
                }
            }
            if (z16 && !this.f63750b1) {
                this.f63750b1 = true;
                AEBaseReportParam.U().t0();
                com.tencent.aelight.camera.ae.report.b.b().g1();
                u uVar2 = this.Q;
                if (uVar2 != null) {
                    uVar2.onFirstFrameDone();
                }
            }
        } else {
            u uVar3 = this.Q;
            if (uVar3 != null) {
                uVar3.onFirstFrameDone();
            }
        }
        if (this.f63785r0) {
            this.f63786s0++;
            if (z16) {
                str2 = "onDrawFrameReal-begin";
            } else {
                str2 = "onDrawFrameFake-begin" + this.f63786s0;
            }
            tq.b.h().o(str2);
        }
        LSFilterProcessBase lSFilterProcessBase = this.f63756e;
        if (lSFilterProcessBase == null) {
            return;
        }
        if (!(lSFilterProcessBase instanceof LSFilterProcessTex) && !i1()) {
            ms.a.a("LSCameraGLSurfaceView", "[onDrawFrame] initFilterProcess");
            V0();
        }
        if (this.f63785r0) {
            tq.b.h().o("FilterProcessInitFilters-begin");
        }
        this.f63756e.g();
        if (this.f63785r0) {
            tq.b.h().o("FilterProcessInitFilters-end");
        }
        int[] s16 = this.f63756e.s(this.D, this.E, this.f63791x0);
        if (s16 == null) {
            return;
        }
        if (z16 && this.f63750b1) {
            long currentTimeMillis = System.currentTimeMillis();
            int i16 = this.f63763g1 + 1;
            this.f63763g1 = i16;
            long j3 = this.f63766h1;
            if (currentTimeMillis - j3 > 1000) {
                this.D0.e((i16 * 1.0f) / (((float) (currentTimeMillis - j3)) * 0.001f));
                this.f63766h1 = currentTimeMillis;
                this.f63763g1 = 0;
            }
        }
        if (a1()) {
            LSFilterProcessTex lSFilterProcessTex = (LSFilterProcessTex) this.f63756e;
            u uVar4 = this.Q;
            if (uVar4 != null) {
                uVar4.onDrawFrameWithEffect(this.f63778m1, lSFilterProcessTex.R());
            }
            L1(s16[1]);
        }
        if (this.f63758e1 && !this.f63791x0) {
            this.f63756e.a(s16[1]);
        }
        z0(s16[1], null, null);
        y0(s16[1], null, null);
        this.J++;
        if (this.f63784q0 && (i3 = this.J) >= 4) {
            if (i3 == 4) {
                mq.a.d().k(IPrefRecorder.MILESTONE_CAMERA_TAB_SWITCH);
                mq.a.d().k(IPrefRecorder.MILESTONE_CAMERA_RESUME_SWITCH);
                O1();
            }
            r0();
        }
        if (this.f63785r0) {
            if (z16) {
                str = "onDrawFrameReal-end";
            } else {
                str = "onDrawFrameFake-end" + this.f63786s0;
            }
            tq.b.h().o(str);
            if (z16) {
                this.f63785r0 = false;
                com.tencent.aelight.camera.ae.report.b.b().C1(tq.b.h().f(), tq.b.h().k(), tq.b.h().j(), "xsj", tq.b.h().m());
            }
        }
        if (z16 && this.f63783p0) {
            this.f63783p0 = false;
            y yVar = this.R;
            if (yVar != null) {
                yVar.reportFirstFrameShown();
            }
            this.D0.onFirstFrame();
            tq.b.h().b();
        }
    }

    @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.c
    public void onEncodeError(final int i3, Throwable th5) {
        ms.a.d("LSCameraGLSurfaceView", "encode error, code: " + i3, th5);
        this.F0.errorCode = i3;
        if (this.R != null) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView.16
                @Override // java.lang.Runnable
                public void run() {
                    if (i3 == 1) {
                        LSCameraGLSurfaceView.this.R.onCaptureError(102);
                    } else {
                        LSCameraGLSurfaceView.this.R.onCaptureError(104);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.c
    public void onEncodeFinish(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("LSCameraGLSurfaceView", 2, "onEncodeFinish filePath = " + str);
        }
        AEVideoCaptureResult aEVideoCaptureResult = this.F0;
        aEVideoCaptureResult.videoMp4FilePath = str;
        C0(aEVideoCaptureResult);
    }

    @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.c
    public void onEncodeFrame() {
        this.F0.videoFrameCount++;
    }

    @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.c
    public void onEncodeStart() {
        this.F0.videoFrameCount = 0;
        iq.a aVar = this.E0;
        if (aVar != null && !this.M) {
            com.tencent.mobileqq.videocodec.mediacodec.encoder.c cVar = this.J0;
            if (cVar != null) {
                aVar.W(cVar.f312575t);
            }
            this.E0.N();
        }
        if (this.R != null) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView.15
                @Override // java.lang.Runnable
                public void run() {
                    LSCameraGLSurfaceView.this.R.onVideoCaptureStart();
                }
            });
        }
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        ms.a.f("LSCameraGLSurfaceView", "[onPause] hashCode=" + this.f63748a1 + " ###" + System.currentTimeMillis());
        this.f63788u0 = true;
        if (QzoneConfig.isCameraPauseSwitch()) {
            ms.a.f("LSCameraGLSurfaceView", "[onPause] switch on ");
            super.onPause();
        }
        queueEvent(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView.6
            @Override // java.lang.Runnable
            public void run() {
                if (LSCameraGLSurfaceView.this.f63793z0 != null) {
                    LSCameraGLSurfaceView.this.f63793z0.c();
                    LSCameraGLSurfaceView.this.f63793z0 = null;
                }
                LSCameraGLSurfaceView.this.w0();
            }
        });
        this.f63749b0.unregisterListener(this);
        x0();
        if (!QzoneConfig.isCameraPauseSwitch()) {
            super.onPause();
        }
        ms.a.f("LSCameraGLSurfaceView", "[onPause] end" + System.currentTimeMillis());
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.filter.LSFilterProcessTex.d
    public void onPhotoCaptured(final Bitmap bitmap) {
        mq.a.d().j(IPrefRecorder.MILESTONE_CAMERA_SHOOT_JUMP_FLASH);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView.14
            @Override // java.lang.Runnable
            public void run() {
                String str = LSCameraGLSurfaceView.this.f63754d0.f448260n + "/" + System.currentTimeMillis() + ".jpg";
                FileUtils.createFileIfNotExits(str);
                File file = new File(str);
                try {
                    BaseImageUtil.saveBitmapFileAsJPEG(bitmap, file);
                    BaseImageUtil.savePhotoToSysAlbum(BaseApplication.getContext(), file.getAbsolutePath());
                    LSCameraGLSurfaceView lSCameraGLSurfaceView = LSCameraGLSurfaceView.this;
                    lSCameraGLSurfaceView.B0(new AEPhotoCaptureResult(0, 0, str, null, 0L, lSCameraGLSurfaceView.f63781o0));
                } catch (IOException e16) {
                    e16.printStackTrace();
                    LSCameraGLSurfaceView lSCameraGLSurfaceView2 = LSCameraGLSurfaceView.this;
                    lSCameraGLSurfaceView2.B0(new AEPhotoCaptureResult(0, -1, str, null, 0L, lSCameraGLSurfaceView2.f63781o0));
                }
                bitmap.recycle();
            }
        }, 64, null, false);
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        this.J = 0;
        this.f63788u0 = false;
        if (ms.a.h()) {
            ms.a.a("LSCameraGLSurfaceView", "### onResume, hashCode=" + this.f63748a1 + " ###");
        }
        this.K0 = false;
        LSFilterProcessBase lSFilterProcessBase = this.f63756e;
        if (lSFilterProcessBase != null) {
            lSFilterProcessBase.p(this.K0);
        }
        com.tencent.aelight.camera.ae.camera.util.a aVar = this.N;
        if (aVar != null && aVar.canDetectOrientation()) {
            this.N.enable();
        }
        if (this.H0) {
            this.H0 = false;
            this.G0 = true;
            P1();
        }
        SensorMonitor.registerListener(this.f63749b0, this, this.f63751c0, 3);
        SwitchHelper.e().h();
        ms.a.a("LSCameraGLSurfaceView", "codecSwitch " + SwitchHelper.f64369f);
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        CameraConfig.DeviceCameraOrientation deviceCameraOrientation = CameraConfig.DeviceCameraOrientation.ROTATION_0;
        if (sensorEvent.sensor == this.f63751c0) {
            float[] fArr = sensorEvent.values;
            int i3 = (int) fArr[0];
            int i16 = (int) fArr[1];
            if (Math.abs(i16) > Math.abs(i3)) {
                if (i16 <= 1 && i16 < -1) {
                    deviceCameraOrientation = CameraConfig.DeviceCameraOrientation.ROTATION_180;
                }
            } else if (i3 > 1) {
                deviceCameraOrientation = CameraConfig.DeviceCameraOrientation.ROTATION_90;
            } else if (i3 < -1) {
                deviceCameraOrientation = CameraConfig.DeviceCameraOrientation.ROTATION_270;
            }
            if (this.f63765h0 != deviceCameraOrientation) {
                float f16 = i3;
                if (Math.abs(f16 - this.f63762g0) > this.f63768i0 || Math.abs(i16 - this.f63762g0) > this.f63768i0) {
                    Log.d("LSCameraGLSurfaceView", "orientation is changed from" + this.f63765h0 + " to " + deviceCameraOrientation + ", and current XAxis:" + i3);
                    this.f63762g0 = f16;
                    this.f63765h0 = deviceCameraOrientation;
                    if (this.f63756e instanceof LSFilterProcessTex) {
                        queueEvent(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView.4
                            @Override // java.lang.Runnable
                            public void run() {
                                if (LSCameraGLSurfaceView.this.f63756e == null || !(LSCameraGLSurfaceView.this.f63756e instanceof LSFilterProcessTex)) {
                                    return;
                                }
                                ((LSFilterProcessTex) LSCameraGLSurfaceView.this.f63756e).H0(LSCameraGLSurfaceView.this.f63765h0);
                            }
                        });
                    }
                }
            }
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i3, int i16) {
        ms.a.f("LSCameraGLSurfaceView", "[onSurfaceChanged] + BEGIN, width = " + i3 + ", height = " + i16);
        tq.b.h().o("onSurfaceChanged-begin");
        this.D = i3;
        this.E = i16;
        if (this.f63756e != null) {
            int[] K0 = K0(i3, i16);
            this.f63756e.r(L0());
            this.f63756e.v(this.D, this.E, 0, 0, K0[0], K0[1]);
        }
        tq.b.h().o("onSurfaceChanged-end");
        ms.a.f("LSCameraGLSurfaceView", "[onSurfaceChanged] + END, width = " + i3 + ", height = " + i16);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        ms.a.f("LSCameraGLSurfaceView", "[onSurfaceCreated] + BEGIN");
        tq.b.h().o("onSurfaceCreated-begin");
        V0();
        tq.b.h().o("onSurfaceCreated-end");
        ms.a.f("LSCameraGLSurfaceView", "[onSurfaceCreated] + END");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003f, code lost:
    
        if (r1 == 2) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void p0(VideoMaterial videoMaterial) {
        LightAsset lightAsset = videoMaterial.getLightAsset();
        if (lightAsset != null && this.S != null && !this.X0) {
            int defaultCameraPosition = lightAsset.getDefaultCameraPosition();
            boolean needUseWideAngleLens = lightAsset.needUseWideAngleLens();
            ms.a.f("LSCameraGLSurfaceView", "checkChangeCameraAndApplyMaterial---cameraPosition=" + defaultCameraPosition + ",needWideAngleLens=" + needUseWideAngleLens);
            int i3 = this.f63778m1;
            int i16 = defaultCameraPosition != 1 ? 2 : 1;
            i3 = i16;
            this.S.r(i3, needUseWideAngleLens, new f(videoMaterial));
            return;
        }
        K1(videoMaterial);
    }

    public void s1(int i3, int i16) {
        int i17;
        int i18;
        ms.a.f("LSCameraGLSurfaceView", "onCameraPreviewSizeChanged---cameraWidth=" + i3 + ", cameraHeight=" + i16 + ", mSurfaceWidth=" + this.D + ", mSurfaceHeight=" + this.E);
        int i19 = this.D;
        int i26 = this.E;
        this.Q0 = i3;
        this.R0 = (int) (((double) i3) / (((double) i19) / ((double) i26)));
        if (this.f63791x0) {
            int[] b16 = com.tencent.aelight.camera.ae.flashshow.util.g.b(i3, i16, i19, i26, 1.0f);
            int[] h16 = com.tencent.aelight.camera.ae.flashshow.util.g.h(640, b16[0], b16[1]);
            i17 = h16[0];
            i18 = h16[1];
            this.S0 = i17;
            this.T0 = i18;
            this.Q0 = i17;
            this.R0 = i18;
        } else if (g1()) {
            i17 = this.D;
            i18 = this.E;
        } else {
            Z0(i3, i16);
            i17 = i3;
            i18 = i16;
        }
        if (this.f63756e != null) {
            int J0 = J0();
            if (i17 > J0) {
                i18 = (int) (((J0 * 1.0f) / i17) * i18);
                i17 = J0;
            }
            this.f63756e.v(this.D, this.E, i3, i16, i17, i18);
            this.G = i16;
            this.F = i3;
            this.I = i18;
            this.H = i17;
            ms.a.f("LSCameraGLSurfaceView", "onCameraPreviewSizeChanged:" + this.D + "," + this.E + "," + i3 + "," + i16 + ",previewWidth:" + i17 + ",previewHeight:" + i18);
            this.Q.onPreviewSizeChanged(i17, i18, this.D, this.E);
            this.f63756e.w(this.Q0, this.R0);
        }
        t0(i3, i16);
    }

    public void setAECaptureController(com.tencent.aelight.camera.ae.camera.ui.c cVar) {
        this.f63753d = cVar;
    }

    public void setAEKitInitListener(x xVar) {
        this.P = xVar;
    }

    public void setActivity(Activity activity) {
        this.f63773k1 = activity;
    }

    public void setAeEditMaterialSelectedListener(AEBottomListScrollView.a aVar) {
        this.f63747a0 = aVar;
    }

    public void setAeGLSurfaceListener(u uVar) {
        this.Q = uVar;
    }

    public void setAiBeautyFaceListener(LSFilterProcessTex.e eVar) {
        this.f63771j1 = eVar;
    }

    public void setAudioPause() {
        LSFilterProcessBase lSFilterProcessBase = this.f63756e;
        if (lSFilterProcessBase instanceof LSFilterProcessTex) {
            ((LSFilterProcessTex) lSFilterProcessBase).r0();
        }
    }

    public void setAudioStart() {
        LSFilterProcessBase lSFilterProcessBase = this.f63756e;
        if (lSFilterProcessBase instanceof LSFilterProcessTex) {
            ((LSFilterProcessTex) lSFilterProcessBase).s0();
        }
    }

    public void setBeautyEnable(boolean z16) {
        this.f63772k0 = z16;
    }

    public void setBeautyLevel(final int i3) {
        if (a1() && b1()) {
            this.L = i3;
            queueEvent(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView.32
                @Override // java.lang.Runnable
                public void run() {
                    LSFilterProcessTex lSFilterProcessTex;
                    if (LSCameraGLSurfaceView.this.f63756e == null || !(LSCameraGLSurfaceView.this.f63756e instanceof LSFilterProcessTex) || (lSFilterProcessTex = (LSFilterProcessTex) LSCameraGLSurfaceView.this.f63756e) == null) {
                        return;
                    }
                    lSFilterProcessTex.K0(i3);
                }
            });
            return;
        }
        ms.a.f("LSCameraGLSurfaceView", "[setBeautyLevel] level = " + i3 + ", isAEKitAvailable is false");
    }

    public void setBeautyOrTransformLevel(BeautyRealConfig.TYPE type, int i3) {
        if (b1()) {
            I1(new i(type, i3));
        }
    }

    public void setBundlePath(final String str, final String str2) {
        if (this.f63756e instanceof LSFilterProcessTex) {
            queueEvent(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView.2
                @Override // java.lang.Runnable
                public void run() {
                    AEFilterManager R;
                    if (LSCameraGLSurfaceView.this.f63756e == null || !(LSCameraGLSurfaceView.this.f63756e instanceof LSFilterProcessTex) || (R = ((LSFilterProcessTex) LSCameraGLSurfaceView.this.f63756e).R()) == null) {
                        return;
                    }
                    R.setLightBundle(str, str2);
                }
            });
        }
    }

    public void setCaptureListener(y yVar) {
        this.R = yVar;
    }

    public void setCaptureRequest(z zVar) {
        LSFilterProcessBase lSFilterProcessBase = this.f63756e;
        if (lSFilterProcessBase != null) {
            lSFilterProcessBase.o(zVar);
        }
    }

    public void setCurrentRatio(AEVideoStoryTopBarViewModel.Ratio ratio) {
        this.A0 = ratio;
    }

    public void setCustomMaterial(String str, String str2) {
        LSFilterProcessBase lSFilterProcessBase = this.f63756e;
        if (lSFilterProcessBase instanceof LSFilterProcessTex) {
            ((LSFilterProcessTex) lSFilterProcessBase).v0(str, str2);
        }
    }

    public void setDynamicResolutionMode(boolean z16) {
        this.f63757e0 = z16;
    }

    public void setFaceEffectEnable(boolean z16) {
        this.f63779n0 = z16;
    }

    public void setFaceEffectListener(t tVar) {
        this.S = tVar;
    }

    public void setFilterEnable(boolean z16) {
        this.f63777m0 = z16;
    }

    public void setFirstFrameView(ImageView imageView) {
        this.B0 = imageView;
    }

    public void setFrameBitMap(Bitmap bitmap) {
        this.C0 = bitmap;
    }

    public void setFrom(int i3) {
        this.f63782o1 = i3;
        LSFilterProcessBase lSFilterProcessBase = this.f63756e;
        if (lSFilterProcessBase instanceof LSFilterProcessTex) {
            ((LSFilterProcessTex) lSFilterProcessBase).y0(i3);
        }
    }

    public void setGenderTypeListener(v vVar) {
        this.U = vVar;
    }

    public void setIsGIFMode(boolean z16) {
        this.D0.b(z16);
        this.f63791x0 = z16;
    }

    public void setLastForceMaterialPath(String str) {
        this.f63755d1 = str;
    }

    public void setLightNodePresetData(final String str, final String str2) {
        queueEvent(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView.45
            @Override // java.lang.Runnable
            public void run() {
                if (LSCameraGLSurfaceView.this.f63756e instanceof LSFilterProcessTex) {
                    ((LSFilterProcessTex) LSCameraGLSurfaceView.this.f63756e).E0(str, str2);
                }
            }
        });
    }

    public void setMaterial(final String str) {
        ms.a.f("LSCameraGLSurfaceView", "[setMaterial] in set materialPath:" + str);
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView.20
            @Override // java.lang.Runnable
            public void run() {
                if (Looper.myLooper() == null) {
                    ms.a.c("LSCameraGLSurfaceView", "[setMaterial] Looper.myLooper() == null");
                    Looper.prepare();
                }
                ms.a.f("LSCameraGLSurfaceView", "[setMaterial] 2 in set materialPath:" + str);
                LSCameraGLSurfaceView lSCameraGLSurfaceView = LSCameraGLSurfaceView.this;
                boolean z16 = true;
                lSCameraGLSurfaceView.X0 = !TextUtils.isEmpty(lSCameraGLSurfaceView.W0) && !TextUtils.isEmpty(str) && LSCameraGLSurfaceView.this.W0.equals(str) && LSCameraGLSurfaceView.this.Y0;
                LSCameraGLSurfaceView.this.W0 = str;
                t tVar = LSCameraGLSurfaceView.this.S;
                if (tVar != null) {
                    tVar.onHidePagTip();
                    LSCameraGLSurfaceView.this.S.onHideNormalTip();
                }
                if (!LSCameraGLSurfaceView.this.i1() && LSCameraGLSurfaceView.this.a1()) {
                    String str2 = str;
                    final LSFilterProcessTex lSFilterProcessTex = (LSFilterProcessTex) LSCameraGLSurfaceView.this.f63756e;
                    if (TextUtils.isEmpty(str2)) {
                        if (lSFilterProcessTex != null && lSFilterProcessTex.U() != null) {
                            AEResUtil.g(AEResUtil.F(lSFilterProcessTex.U()), false);
                        }
                        LSCameraGLSurfaceView.this.D0.g(null);
                        if (lSFilterProcessTex != null) {
                            lSFilterProcessTex.W = true;
                        }
                        LSCameraGLSurfaceView.this.x1(null);
                        LSCameraGLSurfaceView.this.R1();
                        LSCameraGLSurfaceView.this.T1(lSFilterProcessTex);
                        LSCameraGLSurfaceView.this.V0 = null;
                        ms.a.c("LSCameraGLSurfaceView", "[setMaterial] materialPath:" + str2);
                        LSCameraGLSurfaceView.this.Y0 = false;
                        return;
                    }
                    if (!new File(str2).exists()) {
                        str2 = str2 + "Android";
                    }
                    if (!new File(str2).exists()) {
                        LSCameraGLSurfaceView.this.R1();
                        ms.a.c("LSCameraGLSurfaceView", "[setMaterial] materialPath not exist");
                        LSCameraGLSurfaceView.this.Y0 = false;
                        return;
                    }
                    final VideoMaterial loadLightAsset = VideoMaterial.loadLightAsset(str);
                    if (loadLightAsset == null) {
                        LSCameraGLSurfaceView.this.U1(HardCodeUtil.qqStr(R.string.f169890y53));
                        LSCameraGLSurfaceView.this.R1();
                        ms.a.c("LSCameraGLSurfaceView", "[setMaterial] videoMaterial null");
                        LSCameraGLSurfaceView.this.Y0 = false;
                        return;
                    }
                    ms.a.f("LSCameraGLSurfaceView", "lightSDK material," + loadLightAsset.getId() + "," + str);
                    LSCameraGLSurfaceView.this.D0.g(loadLightAsset);
                    if (AEMaterialManager.U(loadLightAsset)) {
                        ms.a.a("PreCheckAERes", "[setMaterial] set special template");
                        if (AEResUtil.U(AEResInfo.LIGHT_RES_BASE_PACKAGE)) {
                            ms.a.a("PreCheckAERes", "[setMaterial] version check success");
                            if (com.tencent.aelight.camera.ae.d.f(loadLightAsset)) {
                                ms.a.a("PreCheckAERes", "[setMaterial] so load success");
                                List<String> D = AEResUtil.D(loadLightAsset);
                                boolean z17 = (D == null || D.isEmpty()) ? false : true;
                                boolean z18 = z17 && !AEResUtil.G(D).isEmpty();
                                if (z17) {
                                    ms.a.f("LSCameraGLSurfaceView", "[setMaterial] need download extra bundles");
                                    boolean remove = D.remove(LightConstants.AgentType.QNN_HTP_BUNDLE);
                                    AEResUtil.g(D, true);
                                    if (remove && wq.a.e()) {
                                        AEResUtil.h(LightConstants.AgentType.QNN_HTP_BUNDLE);
                                    }
                                }
                                if (z18) {
                                    ms.a.f("LSCameraGLSurfaceView", "[setMaterial] need wait download");
                                    LSCameraGLSurfaceView.this.Y0 = false;
                                    return;
                                }
                            } else {
                                ms.a.c("PreCheckAERes", "[setMaterial] so load failed");
                            }
                        } else {
                            ms.a.c("PreCheckAERes", "[setMaterial] version check failed");
                        }
                    } else {
                        ms.a.f("LSCameraGLSurfaceView", "not special material.");
                    }
                    if (loadLightAsset.isWatermarkMaterial() && LSCameraGLSurfaceView.this.q1(loadLightAsset)) {
                        if (LSCameraGLSurfaceView.this.G0 || (LSCameraGLSurfaceView.this.f63773k1 == null && !(LSCameraGLSurfaceView.this.getContext() instanceof Activity))) {
                            if (LSCameraGLSurfaceView.this.q0()) {
                                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView.20.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        LSCameraGLSurfaceView.this.Q1();
                                    }
                                });
                            }
                        } else if (LSCameraGLSurfaceView.this.f63788u0) {
                            LSCameraGLSurfaceView.this.H0 = true;
                            ms.a.f("LSCameraGLSurfaceView", "updateWMProps requestLocationPermission true, but is paused, skip");
                        } else {
                            LSCameraGLSurfaceView.this.H0 = false;
                            LSCameraGLSurfaceView.this.G0 = true;
                            ms.a.f("LSCameraGLSurfaceView", "updateWMProps requestLocationPermission true");
                            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView.20.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    LSCameraGLSurfaceView.this.P1();
                                }
                            });
                        }
                    }
                    AEMaterialMetaData B = AEFlashShowMaterialManager.B();
                    if (B != null) {
                        final boolean isEditableWatermark = loadLightAsset.isEditableWatermark();
                        B.editablewatermark = isEditableWatermark;
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView.20.3
                            @Override // java.lang.Runnable
                            public void run() {
                                AEFlashShowMaterialManager aEFlashShowMaterialManager = (AEFlashShowMaterialManager) com.tencent.aelight.camera.ae.control.a.b(3);
                                if (isEditableWatermark) {
                                    aEFlashShowMaterialManager.Y(loadLightAsset);
                                } else {
                                    aEFlashShowMaterialManager.X(loadLightAsset);
                                }
                            }
                        });
                        ms.a.f("LSCameraGLSurfaceView", "editable id: " + B.f69050id + " enable: " + isEditableWatermark);
                    }
                    if (AEFlashShowMaterialManager.B() != null) {
                        AEMaterialMetaData B2 = AEFlashShowMaterialManager.B();
                        boolean isEditableWatermark2 = loadLightAsset.isEditableWatermark();
                        B2.editablewatermark = isEditableWatermark2;
                        if (LSCameraGLSurfaceView.this.f63747a0 != null) {
                            ms.a.f("LSCameraGLSurfaceView", "editable id: " + B2.f69050id + " enable: " + isEditableWatermark2);
                            LSCameraGLSurfaceView.this.f63747a0.f(isEditableWatermark2);
                        }
                    }
                    LSCameraGLSurfaceView.this.x1(loadLightAsset);
                    LSCameraGLSurfaceView.this.T1(lSFilterProcessTex);
                    if (loadLightAsset.isEditableWatermark()) {
                        if (LSCameraGLSurfaceView.this.V0 != null && LSCameraGLSurfaceView.this.V0.getId().equals(loadLightAsset.getId())) {
                            z16 = false;
                        }
                        ms.a.f("LSCameraGLSurfaceView", "[setMaterial] isWatermarkEditable case, applyMaterial=" + z16);
                    }
                    LSCameraGLSurfaceView.this.Y0 = z16;
                    LSCameraGLSurfaceView.this.V0 = loadLightAsset;
                    if (z16) {
                        LSCameraGLSurfaceView.this.p0(loadLightAsset);
                    }
                    if (LSCameraGLSurfaceView.this.d1()) {
                        LSCameraGLSurfaceView.this.queueEvent(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView.20.4
                            @Override // java.lang.Runnable
                            public void run() {
                                String l3 = AEARCakeMaterialManager.i().l();
                                lSFilterProcessTex.P0(l3);
                                ms.a.f("LSCameraGLSurfaceView", "apply ar cake watermark text: " + l3);
                            }
                        });
                        return;
                    }
                    return;
                }
                if ((!com.tencent.aelight.camera.ae.d.t() || !FeatureManager.Features.PAG.isFunctionReady()) && (!FeatureManager.Features.PAG.init() || !com.tencent.aelight.camera.ae.d.s())) {
                    z16 = false;
                }
                if (LSCameraGLSurfaceView.this.f63788u0 && z16 && !TextUtils.isEmpty(str)) {
                    LSFilterProcessTex.B0(LSCameraGLSurfaceView.this.f63748a1, VideoSDKMaterialParser.parseVideoMaterial(str, "params"));
                }
                ms.a.c("LSCameraGLSurfaceView", "[setMaterial]isRecording" + LSCameraGLSurfaceView.this.i1());
                ms.a.c("LSCameraGLSurfaceView", "[setMaterial]isAEKitAvailable" + LSCameraGLSurfaceView.this.a1());
                LSCameraGLSurfaceView.this.Y0 = false;
            }
        });
    }

    public void setMusic(boolean z16) {
        this.M = z16;
    }

    public void setPreExtractFrame(boolean z16) {
        this.f63758e1 = z16;
    }

    public void setRecommendTextCallback(a.b bVar) {
        this.V = bVar;
    }

    public void setSharpFaceEnable(boolean z16) {
        this.f63774l0 = z16;
    }

    public void setSharpFaceLevel(final int i3) {
        if (a1() && k1()) {
            queueEvent(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView.33
                @Override // java.lang.Runnable
                public void run() {
                    LSFilterProcessTex lSFilterProcessTex;
                    if (LSCameraGLSurfaceView.this.f63756e == null || !(LSCameraGLSurfaceView.this.f63756e instanceof LSFilterProcessTex) || (lSFilterProcessTex = (LSFilterProcessTex) LSCameraGLSurfaceView.this.f63756e) == null) {
                        return;
                    }
                    lSFilterProcessTex.I0(i3);
                }
            });
        }
    }

    public void setStickerInnerLutFilterListener(AEFilterManager.MaterialInnerEffectListener materialInnerEffectListener) {
        this.T = materialInnerEffectListener;
        LSFilterProcessBase lSFilterProcessBase = this.f63756e;
        if (lSFilterProcessBase == null || !(lSFilterProcessBase instanceof LSFilterProcessTex)) {
            return;
        }
        ((LSFilterProcessTex) lSFilterProcessBase).F0(materialInnerEffectListener);
    }

    public void setTapEvent(int i3, float f16, float f17) {
        queueEvent(new TapRunnable(i3, f16 / this.D, f17 / this.E));
    }

    public void setUseVideoOrientation(boolean z16) {
        this.P0 = z16;
    }

    public void t1() {
        this.D0.a();
        this.f63783p0 = true;
        this.f63752c1 = false;
        ms.a.a("LSCameraGLSurfaceView", "[onDrawFrame] onCameraPreviewStarted firstFrameStartPreviewActionDone = false");
    }

    public void u1(int i3) {
        this.f63778m1 = i3;
        LSFilterProcessBase lSFilterProcessBase = this.f63756e;
        if (lSFilterProcessBase != null) {
            lSFilterProcessBase.d(false);
        }
        this.D0.h(h1());
        VideoReport.setPageParams(getContext(), "ae_front_camera", Integer.valueOf(i3));
    }

    public void v1() {
        ms.a.c("LSCameraGLSurfaceView", "[onDestroy]");
        if (ms.a.h()) {
            ms.a.a("LSCameraGLSurfaceView", "### onDestroy, hashCode=" + this.f63748a1 + " ###");
        }
        x0();
        this.G0 = false;
        this.D0.d();
        this.E0.U();
        com.tencent.mobileqq.videocodec.mediacodec.recorder.e eVar = this.I0;
        if (eVar != null) {
            eVar.n();
        }
        com.tencent.mobileqq.videocodec.mediacodec.recorder.e eVar2 = this.L0;
        if (eVar2 != null) {
            eVar2.n();
        }
        this.f63769i1.a();
        queueEvent(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView.7
            @Override // java.lang.Runnable
            public void run() {
                if (LSCameraGLSurfaceView.this.f63793z0 != null) {
                    LSCameraGLSurfaceView.this.f63793z0.c();
                    LSCameraGLSurfaceView.this.f63793z0 = null;
                }
                LSCameraGLSurfaceView.this.w0();
            }
        });
        this.f63773k1 = null;
        this.T = null;
        ms.a.c("LSCameraGLSurfaceView", "[onDestroy] end");
    }

    protected void w1() {
        if (this.f63791x0) {
            this.f63792y0 = 0L;
            ms.a.a("LSCameraGLSurfaceView", "onMediaCodecStopRecord");
            if (this.f63793z0 != null) {
                ms.a.a("LSCameraGLSurfaceView", "onMediaCodecStopRecord and aeExpressionRecognizer != null, release it");
                this.f63793z0.i(this.V);
                this.f63793z0.g();
                this.f63793z0.h();
            }
        }
    }

    protected void x1(VideoMaterial videoMaterial) {
        t tVar;
        if (c1() && (tVar = this.S) != null) {
            tVar.onSelectFaceEffect(videoMaterial);
        }
    }

    public void y1() {
        ms.a.f("LSCameraGLSurfaceView", "onUserSelectFilter");
        this.f63769i1.c(new com.tencent.aelight.camera.ae.util.s(Operator.FILTER, new com.tencent.aelight.camera.ae.util.o() { // from class: com.tencent.aelight.camera.ae.flashshow.ag
            @Override // com.tencent.aelight.camera.ae.util.o
            public final void a() {
                LSCameraGLSurfaceView.this.l0();
            }
        }));
    }

    public void z1() {
        ms.a.f("LSCameraGLSurfaceView", "onUserSelectMaterial");
        this.f63769i1.c(new com.tencent.aelight.camera.ae.util.s(Operator.BEAUTY_MATERIAL, new com.tencent.aelight.camera.ae.util.o() { // from class: com.tencent.aelight.camera.ae.flashshow.af
            @Override // com.tencent.aelight.camera.ae.util.o
            public final void a() {
                LSCameraGLSurfaceView.this.N1();
            }
        }));
    }

    private int[] K0(int i3, int i16) {
        int[] iArr = {i3, i16};
        if (this.f63791x0) {
            int[] b16 = com.tencent.aelight.camera.ae.flashshow.util.g.b(i3, i16, this.D, this.E, 1.0f);
            return com.tencent.aelight.camera.ae.flashshow.util.g.h(640, b16[0], b16[1]);
        }
        int J0 = J0();
        if (i16 > J0) {
            i16 = (int) (((J0 * 1.0f) / i3) * i16);
            i3 = J0;
        }
        iArr[0] = i3;
        iArr[1] = i16;
        return iArr;
    }

    private void U0() {
        setEGLContextClientVersion(2);
        setEGLConfigChooser(8, 8, 8, 8, 0, 0);
        setEGLContextFactory(new q());
        setPreserveEGLContextOnPause(false);
        setRenderer(this);
        setRenderMode(0);
        F1();
    }

    void D0(int i3, int i16, float[] fArr, float[] fArr2, long j3) {
        if (this.K0 && this.J0 != null) {
            int i17 = this.U0;
            if (i17 == 0) {
                iq.a aVar = this.E0;
                if (aVar != null) {
                    aVar.B(E0());
                }
                this.J0.d(EGL14.eglGetCurrentContext());
                if (aq.d.f26717a.g()) {
                    ms.a.f("LSCameraGLSurfaceView", "useEGLContextVersion---Build.MODEL=" + DeviceInfoMonitor.getModel());
                    this.J0.c(this.f63761f1);
                }
                S1();
                this.I0.p(SwitchHelper.f64369f);
                this.I0.q(this.J0, this);
                this.U0 = 1;
            } else if (i17 != 1) {
                throw new RuntimeException("unknown status " + this.U0);
            }
            this.I0.h(i3, i16, fArr, fArr2, j3);
            return;
        }
        int i18 = this.U0;
        if (i18 != 0) {
            if (i18 == 1) {
                this.I0.s();
                if (!this.M) {
                    this.E0.O();
                }
                w1();
                this.U0 = 0;
                return;
            }
            throw new RuntimeException("unknown status " + this.U0);
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.f63784q0 = true;
        if (!this.f63787t0) {
            this.f63787t0 = true;
            tq.b.h().o("onFrameAvailable");
        }
        queueEvent(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView.1
            @Override // java.lang.Runnable
            public void run() {
                if (LSCameraGLSurfaceView.this.f63756e != null) {
                    LSCameraGLSurfaceView.this.f63756e.t();
                }
            }
        });
        requestRender();
    }

    private void L1(int i3) {
        if (i3 <= 0 || !j1() || this.f63792y0 <= 0) {
            return;
        }
        LSFilterProcessTex lSFilterProcessTex = (LSFilterProcessTex) this.f63756e;
        if (this.f63793z0 == null) {
            ms.a.a("LSCameraGLSurfaceView", "recording gif, aeExpressionRecognizer == null, create it");
            com.tencent.aelight.camera.ae.gif.a aVar = new com.tencent.aelight.camera.ae.gif.a();
            this.f63793z0 = aVar;
            aVar.f();
        }
        long elapsedRealtimeNanos = (SystemClock.elapsedRealtimeNanos() - this.f63792y0) / 1000000;
        int e16 = this.f63793z0.e();
        ms.a.a("LSCameraGLSurfaceView", "recording gif, aeExpressionRecognizer.getFrameCount() == " + e16);
        if (e16 >= 3 || ((float) elapsedRealtimeNanos) <= (e16 + 0.5f) * 1000.0f || !lSFilterProcessTex.Q()) {
            return;
        }
        this.f63793z0.b(i3, lSFilterProcessTex.V().getAllFacePoints().get(0), this.S0, this.T0);
    }

    public void setMaterialMetaData(AEMaterialMetaData aEMaterialMetaData, boolean z16) {
        int i3;
        if (aEMaterialMetaData != null && !aEMaterialMetaData.equals(AEMaterialMetaData.MATERIAL_NONE)) {
            if (z16) {
                ms.a.f("LSCameraGLSurfaceView", "force setMaterialMetaData: " + aEMaterialMetaData.f69050id);
                setLastForceMaterialPath(aEMaterialMetaData.getLocalPath());
            }
            this.f63775l1 = aEMaterialMetaData;
            String localPath = aEMaterialMetaData.getLocalPath();
            if (TextUtils.isEmpty(aEMaterialMetaData.f69050id)) {
                i3 = 100;
            } else if (aEMaterialMetaData.f69050id.startsWith("video_makeup_")) {
                i3 = os.a.f423933a.c(aEMaterialMetaData.f69050id, aEMaterialMetaData.cosmeticSlidingValue);
            } else {
                i3 = AEMaterialUtilKt.d(aEMaterialMetaData);
            }
            i2(localPath, i3);
            return;
        }
        setMaterial((aEMaterialMetaData == null || aEMaterialMetaData.isFromRecoveryMaterial) ? I0() : null);
        if (aEMaterialMetaData != null) {
            aEMaterialMetaData.isFromRecoveryMaterial = false;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        com.tencent.aelight.camera.ae.camera.ui.c cVar;
        boolean z16 = false;
        if (motionEvent == null) {
            return false;
        }
        if (a1() && (cVar = this.f63753d) != null) {
            if (cVar instanceof AECaptureController) {
                z16 = ((AECaptureController) cVar).k();
            } else if (cVar instanceof LSCaptureController) {
                z16 = ((LSCaptureController) cVar).k();
            }
            if (z16) {
                return super.onTouchEvent(motionEvent);
            }
            final LSFilterProcessTex lSFilterProcessTex = (LSFilterProcessTex) this.f63756e;
            if (lSFilterProcessTex.b0()) {
                final float x16 = motionEvent.getX();
                final float y16 = motionEvent.getY();
                final int screenWidth = LightDeviceUtils.getScreenWidth(AEModule.getContext());
                int action = motionEvent.getAction();
                if (action == 0) {
                    PointF pointF = this.f63780n1;
                    pointF.x = x16;
                    pointF.y = y16;
                    queueEvent(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView.42
                        @Override // java.lang.Runnable
                        public void run() {
                            LSFilterProcessTex lSFilterProcessTex2 = lSFilterProcessTex;
                            if (lSFilterProcessTex2 != null) {
                                lSFilterProcessTex2.D(new PointF(x16, y16), screenWidth);
                            }
                        }
                    });
                } else if (action == 1) {
                    queueEvent(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView.44
                        @Override // java.lang.Runnable
                        public void run() {
                            LSFilterProcessTex lSFilterProcessTex2 = lSFilterProcessTex;
                            if (lSFilterProcessTex2 != null) {
                                lSFilterProcessTex2.D(new PointF(x16, y16), screenWidth);
                            }
                        }
                    });
                } else if (action == 2) {
                    PointF pointF2 = this.f63780n1;
                    if (G0(pointF2.x, pointF2.y, x16, y16) > screenWidth * 0.05f) {
                        queueEvent(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView.43
                            @Override // java.lang.Runnable
                            public void run() {
                                LSFilterProcessTex lSFilterProcessTex2 = lSFilterProcessTex;
                                if (lSFilterProcessTex2 != null) {
                                    lSFilterProcessTex2.D(new PointF(x16, y16), screenWidth);
                                }
                            }
                        });
                    }
                }
                return true;
            }
            return super.onTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    private void y0(int i3, float[] fArr, float[] fArr2) {
        if (i3 <= 0) {
            return;
        }
        long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        if (this.N0 && this.M0 != null) {
            if (this.L0 == null) {
                this.L0 = new com.tencent.mobileqq.videocodec.mediacodec.recorder.e();
            }
            int i16 = this.O0;
            if (i16 == 0) {
                iq.a aVar = this.E0;
                if (aVar != null) {
                    aVar.B(E0());
                }
                this.M0.d(EGL14.eglGetCurrentContext());
                this.L0.o();
                this.L0.q(this.M0, new h());
                this.O0 = 1;
            } else if (i16 != 1) {
                throw new RuntimeException("unknown test status " + this.O0);
            }
            this.L0.h(GLSLRender.GL_TEXTURE_2D, i3, fArr, fArr2, elapsedRealtimeNanos);
            return;
        }
        int i17 = this.O0;
        if (i17 != 0) {
            if (i17 == 1) {
                this.L0.s();
                w1();
                this.O0 = 0;
            } else {
                throw new RuntimeException("unknown test . status " + this.O0);
            }
        }
    }

    private void z0(int i3, float[] fArr, float[] fArr2) {
        if (i3 <= 0) {
            return;
        }
        long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        if (a1() && j1()) {
            return;
        }
        D0(GLSLRender.GL_TEXTURE_2D, i3, fArr, fArr2, elapsedRealtimeNanos);
    }

    private float G0(float f16, float f17, float f18, float f19) {
        float f26 = f16 - f18;
        float f27 = f17 - f19;
        return (float) Math.sqrt((f26 * f26) + (f27 * f27));
    }

    public void setMaterialByPath(String str, String str2, boolean z16) {
        if (str == null || str2 == null) {
            return;
        }
        if (z16) {
            ms.a.f("LSCameraGLSurfaceView", "force setMaterialMetaData: " + str);
            setLastForceMaterialPath(str2);
        }
        i2(str2, 100);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements OnLoadAssetListener {
        a() {
        }

        @Override // org.light.listener.OnLoadAssetListener
        public void OnAssetProcessing(HashMap<String, String> hashMap) {
            Log.d("LSCameraGLSurfaceView", "OnAssetProcessing: " + hashMap);
            t tVar = LSCameraGLSurfaceView.this.S;
            if (tVar != null) {
                tVar.onAssetProcessingData(hashMap);
            }
        }

        @Override // org.light.listener.OnLoadAssetListener
        public void OnLoadAssetError(int i3) {
            ms.a.c("LSCameraGLSurfaceView", "OnLoadAssetError: " + i3);
            String p16 = LSCameraGLSurfaceView.p1(i3);
            if (p16 != null) {
                LSCameraGLSurfaceView.this.U1(p16);
            }
        }

        @Override // org.light.listener.OnLoadAssetListener
        public void OnAssetDurationChange(long j3) {
        }
    }

    @Override // com.tencent.mobileqq.videocodec.audio.AudioCapture.b
    public void onAudioChangeCaptured(String str) {
    }

    @Override // com.tencent.mobileqq.videocodec.audio.AudioCapture.b
    public void onAudioError(int i3) {
    }

    @Override // com.tencent.mobileqq.videocodec.audio.AudioCapture.b
    public void onEncodeAudioCaptured(String str) {
    }

    @Override // com.tencent.mobileqq.videocodec.audio.AudioCapture.b
    public void onAudioInit() {
    }

    @Override // com.tencent.mobileqq.videocodec.audio.AudioCapture.b
    public void onAudioUnInit() {
    }

    public LSCameraGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f63767i = 0;
        this.f63776m = false;
        this.C = 0;
        this.D = 320;
        this.E = 480;
        this.F = 0;
        this.G = 0;
        this.H = 0;
        this.I = 0;
        this.J = 0;
        this.K = true;
        this.L = 0;
        this.M = false;
        this.f63760f0 = false;
        this.f63768i0 = 3.0f;
        this.f63770j0 = false;
        this.f63772k0 = true;
        this.f63774l0 = true;
        this.f63777m0 = true;
        this.f63779n0 = true;
        this.f63781o0 = 90;
        this.f63783p0 = true;
        this.f63784q0 = false;
        this.f63785r0 = true;
        this.f63786s0 = 0;
        this.f63787t0 = false;
        this.f63788u0 = true;
        this.f63789v0 = false;
        this.f63790w0 = 0;
        this.f63791x0 = false;
        this.f63792y0 = 0L;
        this.C0 = null;
        this.D0 = new tq.a();
        this.G0 = false;
        this.H0 = false;
        this.P0 = true;
        this.V0 = null;
        this.W0 = null;
        this.X0 = false;
        this.Y0 = false;
        this.Z0 = -1;
        this.f63755d1 = null;
        this.f63763g1 = 0;
        this.f63766h1 = System.currentTimeMillis();
        this.f63769i1 = new com.tencent.aelight.camera.ae.util.t();
        this.f63778m1 = 2;
        this.f63780n1 = new PointF(0.0f, 0.0f);
        this.f63782o1 = 0;
        tq.b.h().o("glSurfaceViewConstruct-begin");
        U0();
        this.f63748a1 = System.identityHashCode(this);
        tq.b.h().o("glSurfaceViewConstruct-end");
    }

    private void t0(int i3, int i16) {
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String p1(int i3) {
        int i16 = i3 != -800 ? i3 != -700 ? i3 != -600 ? i3 != -500 ? i3 != -400 ? i3 != -300 ? i3 != -200 ? i3 != -100 ? i3 != 0 ? R.string.y6r : 0 : R.string.y6j : R.string.y6l : R.string.y6k : R.string.y6q : R.string.y6p : R.string.y6m : R.string.y6o : R.string.y6n;
        if (i16 != 0) {
            return HardCodeUtil.qqStr(i16);
        }
        return null;
    }
}
