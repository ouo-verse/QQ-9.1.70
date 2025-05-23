package com.tencent.aelight.camera.ae.flashshow.filter;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.opengl.GLES20;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.aekit.openrender.CropFilter;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.FrameBufferCache;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView;
import com.tencent.aelight.camera.ae.flashshow.autotest.LSFilterManagerParamsListener;
import com.tencent.aelight.camera.ae.flashshow.autotest.i;
import com.tencent.aelight.camera.ae.flashshow.dashboard.LSDashboardUtil;
import com.tencent.aelight.camera.ae.flashshow.filter.LSOperationUpdater;
import com.tencent.aelight.camera.ae.flashshow.ui.ay;
import com.tencent.aelight.camera.api.IAELaunchRecorder;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.util.api.IMediaCodecDPC;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.facedetect.FaceStatus;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.config.BeautyRealConfig;
import com.tencent.ttpic.openapi.filter.LightNode;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.offlineset.AEOfflineConfig;
import com.tencent.ttpic.openapi.tips.AETipsManager;
import com.tencent.ttpic.openapi.util.AEStaticDetector;
import com.tencent.ttpic.util.FrameUtil;
import com.tencent.ttpic.util.MustRunOnGLThread;
import com.tencent.view.RendererUtils;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import org.light.CameraConfig;
import org.light.DeviceCameraConfig;
import org.light.LightConstants;
import org.light.bean.ExposureInfo;
import org.light.bean.WMElement;
import org.light.listener.OnLoadAssetListener;
import org.light.utils.LightLogUtil;
import org.light.utils.TouchEventUtils;

/* loaded from: classes32.dex */
public class LSFilterProcessTex extends LSFilterProcessBase {

    /* renamed from: s0, reason: collision with root package name */
    private static int f64281s0;
    private AEFilterManager D;
    private Frame E;
    private Frame F;
    private Frame G;
    public Frame H;
    private VideoFilterBase I;
    private com.tencent.aelight.camera.ae.flashshow.filter.d J;
    private VideoFilterBase K;
    private CropFilter L;
    private com.tencent.aelight.camera.ae.flashshow.filter.a M;
    private com.tencent.aelight.camera.ae.flashshow.filter.e N;
    private com.tencent.aelight.camera.ae.camera.filter.a P;
    private e R;
    private final int T;
    private String U;
    private f Z;

    /* renamed from: a0, reason: collision with root package name */
    private LightNode.ILightNodeTipsListener f64289a0;

    /* renamed from: b0, reason: collision with root package name */
    private OnLoadAssetListener f64290b0;

    /* renamed from: c0, reason: collision with root package name */
    private LightNode.ILightNodeCameraExposureListener f64291c0;

    /* renamed from: d0, reason: collision with root package name */
    private LSCameraGLSurfaceView.v f64292d0;

    /* renamed from: e0, reason: collision with root package name */
    private String f64293e0;

    /* renamed from: o0, reason: collision with root package name */
    private LSOperationUpdater f64303o0;

    /* renamed from: p0, reason: collision with root package name */
    private LSOperationUpdater f64304p0;

    /* renamed from: r0, reason: collision with root package name */
    private AEFilterManager.MaterialInnerEffectListener f64306r0;

    /* renamed from: t0, reason: collision with root package name */
    private static SparseArray<VideoMaterial> f64282t0 = new SparseArray<>();

    /* renamed from: u0, reason: collision with root package name */
    private static int f64283u0 = 0;

    /* renamed from: v0, reason: collision with root package name */
    private static int f64284v0 = 0;

    /* renamed from: w0, reason: collision with root package name */
    private static String f64285w0 = null;

    /* renamed from: x0, reason: collision with root package name */
    private static boolean f64286x0 = false;

    /* renamed from: y0, reason: collision with root package name */
    private static String f64287y0 = null;

    /* renamed from: z0, reason: collision with root package name */
    private static String f64288z0 = null;
    private static boolean A0 = false;
    public static int B0 = 0;
    public static int C0 = 0;
    public static int D0 = 0;
    public static int E0 = 0;
    public static int F0 = 0;
    public static int G0 = 0;
    public static boolean H0 = false;
    private Queue<Runnable> O = new ArrayDeque();
    private boolean Q = false;
    private com.tencent.aelight.camera.ae.flashshow.autotest.b S = new com.tencent.aelight.camera.ae.flashshow.autotest.b();
    private boolean V = false;
    public volatile boolean W = true;
    private Set<String> X = new HashSet();
    private boolean Y = true;

    /* renamed from: f0, reason: collision with root package name */
    private com.tencent.aelight.camera.ae.flashshow.autotest.a f64294f0 = null;

    /* renamed from: g0, reason: collision with root package name */
    private com.tencent.aelight.camera.ae.flashshow.autotest.f f64295g0 = null;

    /* renamed from: h0, reason: collision with root package name */
    private final ArrayList<PointF> f64296h0 = new ArrayList<>();

    /* renamed from: i0, reason: collision with root package name */
    private String f64297i0 = "";

    /* renamed from: j0, reason: collision with root package name */
    private boolean f64298j0 = false;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f64299k0 = false;

    /* renamed from: l0, reason: collision with root package name */
    private boolean f64300l0 = false;

    /* renamed from: m0, reason: collision with root package name */
    private boolean f64301m0 = false;

    /* renamed from: n0, reason: collision with root package name */
    private Bitmap f64302n0 = null;

    /* renamed from: q0, reason: collision with root package name */
    private int f64305q0 = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a implements LightNode.ILightNodeTipsListener {
        a() {
        }

        @Override // com.tencent.ttpic.openapi.filter.LightNode.ILightNodeTipsListener
        public void onHideNormalTip() {
            if (LSFilterProcessTex.this.f64289a0 != null) {
                LSFilterProcessTex.this.f64289a0.onHideNormalTip();
            }
        }

        @Override // com.tencent.ttpic.openapi.filter.LightNode.ILightNodeTipsListener
        public void onHidePagTip() {
            if (LSFilterProcessTex.this.f64289a0 != null) {
                LSFilterProcessTex.this.f64289a0.onHidePagTip();
            }
        }

        @Override // com.tencent.ttpic.openapi.filter.LightNode.ILightNodeTipsListener
        public void onShowNormalTip(String str, String str2, int i3) {
            if (LSFilterProcessTex.this.f64289a0 != null) {
                LSFilterProcessTex.this.f64289a0.onShowNormalTip(str, str2, i3);
            }
        }

        @Override // com.tencent.ttpic.openapi.filter.LightNode.ILightNodeTipsListener
        public void onShowPagTip(String str, int i3) {
            if (LSFilterProcessTex.this.f64289a0 != null) {
                LSFilterProcessTex.this.f64289a0.onShowPagTip(str, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class c implements LightNode.ILightNodeCameraExposureListener {
        c() {
        }

        @Override // com.tencent.ttpic.openapi.filter.LightNode.ILightNodeCameraExposureListener
        public void onChangeExposureInfo(ExposureInfo exposureInfo) {
            if (LSFilterProcessTex.this.f64291c0 != null) {
                LSFilterProcessTex.this.f64291c0.onChangeExposureInfo(exposureInfo);
            }
        }

        @Override // com.tencent.ttpic.openapi.filter.LightNode.ILightNodeCameraExposureListener
        public void onFetchExposureInfo(ExposureInfo exposureInfo) {
            if (LSFilterProcessTex.this.f64291c0 != null) {
                LSFilterProcessTex.this.f64291c0.onFetchExposureInfo(exposureInfo);
            }
        }
    }

    /* loaded from: classes32.dex */
    public interface d {
        void onCaptureError(int i3);

        void onPhotoCaptured(Bitmap bitmap);
    }

    /* loaded from: classes32.dex */
    public interface e {
        void a(List<Integer> list, List<Integer> list2);
    }

    /* loaded from: classes32.dex */
    public interface f {
        void recover(VideoMaterial videoMaterial);
    }

    public LSFilterProcessTex(int i3, com.tencent.aelight.camera.ae.camera.filter.a aVar) {
        this.T = i3;
        this.P = aVar;
        O();
        Y();
    }

    public static void B0(int i3, VideoMaterial videoMaterial) {
        f64282t0.put(i3, videoMaterial);
    }

    private void C0(VideoMaterial videoMaterial) {
        f64282t0.put(this.T, videoMaterial);
    }

    @MustRunOnGLThread
    private void E() {
        VideoFilterBase videoFilterBase = this.K;
        if (videoFilterBase != null) {
            videoFilterBase.apply();
        }
        VideoFilterBase videoFilterBase2 = this.I;
        if (videoFilterBase2 != null) {
            videoFilterBase2.apply();
        }
        com.tencent.aelight.camera.ae.flashshow.filter.e eVar = this.N;
        if (eVar != null) {
            eVar.ApplyGLSLFilter();
        }
        com.tencent.aelight.camera.ae.flashshow.filter.d dVar = this.J;
        if (dVar != null) {
            dVar.apply();
        }
        CropFilter cropFilter = this.L;
        if (cropFilter != null) {
            cropFilter.apply();
        }
        com.tencent.aelight.camera.ae.flashshow.filter.a aVar = this.M;
        if (aVar != null) {
            aVar.apply();
        }
        if (this.D != null) {
            X();
            U0();
        }
        this.S.f();
    }

    private boolean F() {
        return this.D != null && ((IMediaCodecDPC) QRoute.api(IMediaCodecDPC.class)).isInQijianPhone() && k() && this.D.canUseLargeImage();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x005b A[Catch: OutOfMemoryError -> 0x0066, TryCatch #0 {OutOfMemoryError -> 0x0066, blocks: (B:2:0x0000, B:8:0x0035, B:10:0x005b, B:11:0x005e, B:13:0x0062), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0062 A[Catch: OutOfMemoryError -> 0x0066, TRY_LEAVE, TryCatch #0 {OutOfMemoryError -> 0x0066, blocks: (B:2:0x0000, B:8:0x0035, B:10:0x005b, B:11:0x005e, B:13:0x0062), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void G(int i3, int i16, int i17) {
        int i18;
        int i19;
        d dVar;
        try {
            int i26 = -(((this.f64275u - 90) + 360) % 360);
            ms.a.a("LSFilterProcessTex", "[captureFrame]:rotation = " + i26);
            this.I.setRotationAndFlip(i26, false, false);
            int i27 = this.f64275u;
            if (i27 != 0 && i27 != 180) {
                i19 = i16;
                i18 = i17;
                this.I.RenderProcess(i3, i19, i18, -1, 0.0d, this.F);
                this.I.setRotationAndFlip(0, false, false);
                int textureId = this.F.getTextureId();
                Frame frame = this.F;
                Bitmap saveTexture2Bitmap = RendererUtils.saveTexture2Bitmap(textureId, GLSLRender.GL_TEXTURE_2D, frame.width, frame.height);
                dVar = this.f64276v;
                if (dVar != null) {
                    dVar.onPhotoCaptured(saveTexture2Bitmap);
                }
                if (this.Y) {
                    return;
                }
                j0();
                return;
            }
            i18 = i16;
            i19 = i17;
            this.I.RenderProcess(i3, i19, i18, -1, 0.0d, this.F);
            this.I.setRotationAndFlip(0, false, false);
            int textureId2 = this.F.getTextureId();
            Frame frame2 = this.F;
            Bitmap saveTexture2Bitmap2 = RendererUtils.saveTexture2Bitmap(textureId2, GLSLRender.GL_TEXTURE_2D, frame2.width, frame2.height);
            dVar = this.f64276v;
            if (dVar != null) {
            }
            if (this.Y) {
            }
        } catch (OutOfMemoryError unused) {
            d dVar2 = this.f64276v;
            if (dVar2 != null) {
                dVar2.onCaptureError(103);
            }
        }
    }

    private void H() {
        if (this.f64295g0 == null) {
            this.f64295g0 = i.d().c();
        }
    }

    private void I() {
        if (this.f64294f0 == null) {
            com.tencent.aelight.camera.ae.flashshow.autotest.a a16 = i.d().a();
            this.f64294f0 = a16;
            if (a16 != null) {
                a16.d(new LSFilterManagerParamsListener(this.D));
            }
        }
    }

    private void J() {
        LSOperationUpdater lSOperationUpdater = this.f64304p0;
        if (lSOperationUpdater == null) {
            return;
        }
        lSOperationUpdater.d(this);
        if (this.f64304p0.g()) {
            this.f64304p0 = null;
        }
    }

    private void J0(int i3) {
        AEFilterManager aEFilterManager = this.D;
        if (aEFilterManager != null) {
            aEFilterManager.setBeautyOrTransformLevel(BeautyRealConfig.TYPE.BASIC4, i3);
        }
    }

    private boolean L(LSOperationUpdater.OPERATION_ENUM operation_enum) {
        LSOperationUpdater lSOperationUpdater = this.f64304p0;
        return lSOperationUpdater == null || lSOperationUpdater.h(operation_enum);
    }

    private boolean M(LSOperationUpdater.OPERATION_ENUM operation_enum, String str, float f16, int i3) {
        if (L(operation_enum)) {
            return true;
        }
        this.f64304p0.l(operation_enum, new LSOperationUpdater.k(str, f16, i3));
        return false;
    }

    private boolean N(LSOperationUpdater.OPERATION_ENUM operation_enum, String str, int i3, int i16) {
        if (L(operation_enum)) {
            return true;
        }
        this.f64304p0.l(operation_enum, new LSOperationUpdater.k(str, i3, i16));
        return false;
    }

    private synchronized void O() {
        if (this.K == null) {
            this.K = new VideoFilterBase();
        }
        if (this.I == null) {
            this.I = new VideoFilterBase("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
        }
        if (this.N == null) {
            this.N = new com.tencent.aelight.camera.ae.flashshow.filter.e();
        }
        if (this.J == null) {
            this.J = new com.tencent.aelight.camera.ae.flashshow.filter.d("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
        }
        if (this.L == null) {
            this.L = new CropFilter();
        }
        if (this.M == null) {
            this.M = new com.tencent.aelight.camera.ae.flashshow.filter.a();
        }
        if (this.E == null) {
            this.E = new Frame();
        }
        if (this.F == null) {
            this.F = new Frame();
        }
        if (this.G == null) {
            this.G = new Frame();
        }
        if (this.H == null) {
            this.H = new Frame();
        }
        if (this.D == null) {
            AEFilterManager aEFilterManager = new AEFilterManager(this.P.k(), this.P.m(), true, null, AEOfflineConfig.getPhonePerfLevel() < 3);
            this.D = aEFilterManager;
            aEFilterManager.setZplanFilamentAbility(xq.c.f448345a);
            this.D.setLightAppEntry(nq.a.b().a());
            this.D.setWatermarkConfig(this.P.l());
        }
    }

    public static int S() {
        return f64281s0;
    }

    private VideoMaterial T() {
        return f64282t0.get(this.T);
    }

    private void U0() {
        LSOperationUpdater.OPERATION_ENUM operation_enum = LSOperationUpdater.OPERATION_ENUM.MATERIAL_OPERATION;
        if (L(operation_enum)) {
            n0(operation_enum);
            m0();
        }
    }

    private void V0() {
        int[] iArr = this.f64268n;
        int i3 = this.f64259e;
        iArr[0] = i3;
        int i16 = this.f64260f;
        iArr[1] = i16;
        if (i16 * 9 > i3 * 16) {
            iArr[1] = (i3 * 16) / 9;
        } else if (i16 * 9 < i3 * 16) {
            iArr[0] = (i16 * 9) / 16;
        }
    }

    private void X() {
        this.D.initInGL(this.f64259e, this.f64260f);
        this.D.setStickerInnerLutFilterListener(this.f64306r0);
        LogUtils.setEnable(false);
        for (Map.Entry<BeautyRealConfig.TYPE, Integer> entry : this.P.i().entrySet()) {
            this.D.setBeautyOrTransformLevel(entry.getKey(), entry.getValue().intValue());
        }
        HashMap hashMap = new HashMap();
        hashMap.put("smooth.curveAdjustAlpha", "0");
        this.D.updateCameraConfigData(hashMap);
        if (this.P.p()) {
            this.D.switchAbilityInLightNode(LightConstants.DetectSwitchKey.AI_FACE_STATIC_FEATURE_ENABLE, true);
            this.f64298j0 = true;
            this.f64299k0 = true;
            this.f64300l0 = true;
            this.f64301m0 = true;
        }
        this.D.setExposureValue(50);
        this.D.setLightNodeTipsListener(new a());
        this.D.setLightNodeLightAssetListener(new b());
        this.D.setCameraExposureListener(new c());
        Z();
        while (true) {
            Queue<Runnable> queue = this.O;
            if (queue == null || queue.isEmpty()) {
                return;
            }
            Runnable poll = this.O.poll();
            if (poll != null) {
                poll.run();
            }
        }
    }

    private static void Y() {
        if (A0) {
            return;
        }
        A0 = true;
        if (com.tencent.aelight.camera.ae.d.t()) {
            LightLogUtil.init(new rs.a());
            LightLogUtil.setMinPriority(6);
        }
    }

    private void Z() {
        Map<String, String> o16 = AEResUtil.o();
        if (o16 != null) {
            for (Map.Entry<String, String> entry : o16.entrySet()) {
                if (this.D != null) {
                    String value = entry.getValue();
                    String key = entry.getKey();
                    QLog.d("LSFilterProcessTex", 2, "[injectBundlePathsToLight] agentType:" + key + " | dir:" + value);
                    this.D.setLightBundle(value, key);
                }
            }
        }
    }

    private Frame a0() {
        AEFilterManager aEFilterManager;
        com.tencent.aelight.camera.ae.flashshow.autotest.f fVar = this.f64295g0;
        if (fVar == null) {
            return null;
        }
        this.S.l(fVar.getIsImageLoaded());
        this.f64295g0.p(true);
        if (com.tencent.aelight.camera.ae.flashshow.autotest.b.f64144j) {
            I();
            com.tencent.aelight.camera.ae.flashshow.autotest.a aVar = this.f64294f0;
            if (aVar == null) {
                return null;
            }
            com.tencent.aelight.camera.ae.flashshow.autotest.b.f64147m = aVar.c();
            if (this.f64294f0.a() == null) {
                return null;
            }
            com.tencent.aelight.camera.ae.flashshow.autotest.b.f64146l = this.f64294f0.a();
            com.tencent.aelight.camera.ae.flashshow.autotest.b.f64145k = this.f64294f0.b();
            this.S.l(!com.tencent.aelight.camera.ae.flashshow.autotest.b.f64147m);
        } else if (com.tencent.aelight.camera.ae.flashshow.autotest.b.f64150p) {
            if (this.f64295g0.h().isEmpty()) {
                return null;
            }
            com.tencent.aelight.camera.ae.flashshow.autotest.b.f64146l = this.f64295g0.h();
            com.tencent.aelight.camera.ae.flashshow.autotest.b.f64145k = true;
        }
        if (!this.S.i()) {
            this.S.k();
            this.f64261g = this.S.e();
            int b16 = this.S.b();
            this.f64262h = b16;
            int i3 = this.f64259e;
            int i16 = this.f64261g;
            if ((i3 != i16 || this.f64260f != b16) && (aEFilterManager = this.D) != null) {
                aEFilterManager.updateWidthHeight(i16, b16);
            }
            this.f64259e = this.f64261g;
            this.f64260f = this.f64262h;
        }
        this.I.setRotationAndFlip(0, false, true);
        return this.I.RenderProcess(this.S.c(), this.f64259e, this.f64260f);
    }

    private void a1(int i3, int i16, int i17, int i18, int i19, int i26) {
        ms.a.f("LSFilterProcessTex", "updateSizeDY previewWidth: " + i19 + " previewHeight: " + i26 + ",viewWidth:" + i3 + ",viewHeight:" + i16);
        this.f64266l = ((double) i3) / ((double) i16);
        if (i17 > 0 && i18 > 0) {
            this.f64261g = i17;
            this.f64262h = i18;
            this.f64265k = i17 / i18;
            ms.a.f("LSFilterProcessTex", "updateSizeDY cameraWidth: " + this.f64261g + " cameraHeight: " + this.f64262h);
        }
        ms.a.f("LSFilterProcessTex", "updateSizeDY mCameraAspectRatio: " + this.f64265k);
        this.f64257c = i19;
        this.f64258d = (int) (((double) i19) / this.f64266l);
        this.f64259e = i19;
        double d16 = this.f64265k;
        if (d16 > 1.0E-5d) {
            if (i19 > (((int) (i19 / d16)) * 9) / 16) {
                int i27 = (i19 * 16) / 9;
                if (i27 <= i18 || i18 <= 0) {
                    i18 = i27;
                }
                this.f64260f = i18;
                this.f64259e = (i18 * 9) / 16;
            } else {
                this.f64260f = (i19 * 16) / 9;
            }
        } else {
            this.f64260f = (i19 * 16) / 9;
        }
        ms.a.f("LSFilterProcessTex", "updateSizeDY this.previewWidth: " + this.f64259e + ",this.previewHeight:" + this.f64260f);
        this.f64255a = 1080;
        this.f64256b = (int) ((((double) 1080) / ((double) this.f64259e)) * ((double) this.f64260f));
        V0();
    }

    private void h0(LSOperationUpdater.OPERATION_ENUM operation_enum) {
        LSOperationUpdater lSOperationUpdater = this.f64303o0;
        if (lSOperationUpdater == null) {
            return;
        }
        lSOperationUpdater.i(operation_enum);
    }

    private void i0(String str, float f16) {
        LSOperationUpdater lSOperationUpdater = this.f64303o0;
        if (lSOperationUpdater == null) {
            return;
        }
        lSOperationUpdater.j(str, f16);
    }

    private void j0() {
        AEFilterManager aEFilterManager = this.D;
        if (aEFilterManager != null) {
            aEFilterManager.setStickerPause(true);
            this.D.onStickerStatusChange(true);
        }
    }

    private void n0(LSOperationUpdater.OPERATION_ENUM operation_enum) {
        LSOperationUpdater lSOperationUpdater = this.f64304p0;
        if (lSOperationUpdater == null) {
            return;
        }
        lSOperationUpdater.k(operation_enum);
    }

    private void p0(int i3, int i16, int i17, boolean z16) {
        if (this.f64269o && H0) {
            H0 = false;
            this.I.RenderProcess(i17, i3, i16, -1, 0.0d, this.H);
            E0 = this.H.getTextureId();
            G0 = i16;
            F0 = i3;
            return;
        }
        if (z16) {
            E0 = i17;
            G0 = i16;
            F0 = i3;
        }
    }

    public static void x0(int i3) {
        f64281s0 = i3;
    }

    public void A0(boolean z16) {
        AEFilterManager aEFilterManager = this.D;
        if (aEFilterManager != null) {
            aEFilterManager.setIsAfterUpdateMaterial(z16);
        }
    }

    public void C(Runnable runnable) {
        this.O.offer(runnable);
    }

    public void D(PointF pointF, int i3) {
        AEFilterManager aEFilterManager = this.D;
        if (aEFilterManager == null) {
            return;
        }
        aEFilterManager.addMaskTouchPoint(pointF, i3);
    }

    public void D0(OnLoadAssetListener onLoadAssetListener) {
        ms.a.a("LSFilterProcessTex", "setLightNodeLightAssetListener: " + onLoadAssetListener);
        this.f64290b0 = onLoadAssetListener;
    }

    public void E0(String str, String str2) {
        AEFilterManager aEFilterManager;
        if (TextUtils.isEmpty(str) || (aEFilterManager = this.D) == null) {
            return;
        }
        aEFilterManager.setLightNodePresetData(str, str2);
        ms.a.f("LSFilterProcessTex", str + ":" + str2);
    }

    public void F0(AEFilterManager.MaterialInnerEffectListener materialInnerEffectListener) {
        this.f64306r0 = materialInnerEffectListener;
    }

    public void G0(LSOperationUpdater lSOperationUpdater, LSOperationUpdater lSOperationUpdater2) {
        this.f64303o0 = lSOperationUpdater;
        this.f64304p0 = lSOperationUpdater2;
    }

    public void H0(CameraConfig.DeviceCameraOrientation deviceCameraOrientation) {
        AEFilterManager aEFilterManager = this.D;
        if (aEFilterManager != null) {
            aEFilterManager.setSensorOrientationToLight(deviceCameraOrientation);
        }
    }

    public void I0(int i3) {
        f64284v0 = i3;
        J0(i3);
    }

    public void K0(int i3) {
        f64283u0 = i3;
        this.D.setSmoothLevel(i3);
    }

    public void L0(LightNode.ILightNodeTipsListener iLightNodeTipsListener) {
        this.f64289a0 = iLightNodeTipsListener;
    }

    public void M0(Handler handler) {
        AETipsManager.getInstance().setUIHandler(handler, this.f64257c, this.f64258d, 0.16666666666666666d);
    }

    public void O0(VideoMaterial videoMaterial, boolean z16) {
        ms.a.c("LSFilterProcessTex", "[setVideoMaterial] force = " + z16);
        C0(videoMaterial);
        if (this.D != null) {
            if (videoMaterial != null && videoMaterial.getId() != null && (z16 || !videoMaterial.getId().equals(this.U))) {
                ms.a.c("LSFilterProcessTex", "[setVideoMaterial] material is new = " + videoMaterial.getId() + ", need updata");
                this.D.updateMaterialGL(videoMaterial);
                h0(LSOperationUpdater.OPERATION_ENUM.MATERIAL_OPERATION);
                this.U = videoMaterial.getId();
            } else if (videoMaterial != null && videoMaterial.getId() != null) {
                ms.a.c("LSFilterProcessTex", "[setVideoMaterial] material is same");
                if (!TextUtils.isEmpty(this.U) && this.X.contains(this.U)) {
                    ms.a.c("LSFilterProcessTex", "[setVideoMaterial] material is same, but need updata");
                    this.D.updateMaterialGL(videoMaterial);
                    h0(LSOperationUpdater.OPERATION_ENUM.MATERIAL_OPERATION);
                    this.U = videoMaterial.getId();
                }
            } else {
                ms.a.c("LSFilterProcessTex", "[setVideoMaterial] material is null, set emptyMap");
                this.D.updateMaterialGL(videoMaterial);
                h0(LSOperationUpdater.OPERATION_ENUM.MATERIAL_OPERATION);
                this.U = "none";
            }
            String str = f64287y0;
            if (str != null && str.equals(this.U)) {
                this.D.setCustomMaterial(f64288z0);
            }
        }
        int i3 = f64284v0;
        if (i3 > 0) {
            J0(i3);
        }
    }

    public void P0(String str) {
        this.f64293e0 = str;
    }

    public boolean Q() {
        AEFilterManager aEFilterManager = this.D;
        if (aEFilterManager == null) {
            return false;
        }
        return AEStaticDetector.hasFaceData(aEFilterManager.getFaceAttr());
    }

    public AEFilterManager R() {
        return this.D;
    }

    public void R0(boolean z16) {
        AEFilterManager aEFilterManager = this.D;
        if (aEFilterManager != null) {
            aEFilterManager.switchAIBeauty(z16);
        }
    }

    public void S0(final boolean z16) {
        f64286x0 = z16;
        Runnable runnable = new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.filter.LSFilterProcessTex.4
            @Override // java.lang.Runnable
            public void run() {
                if (LSFilterProcessTex.this.D != null) {
                    LSFilterProcessTex.this.D.switchAbilityInLightNode("ai.segmentation.bg.enable", z16);
                    if (LSFilterProcessTex.this.P.n()) {
                        if (z16) {
                            LSFilterProcessTex.this.D.setBeautyOrTransformLevel(BeautyRealConfig.TYPE.COLOR_TONE, 0);
                        } else {
                            LSFilterProcessTex.this.D.setBeautyOrTransformLevel(BeautyRealConfig.TYPE.COLOR_TONE, 50);
                        }
                    }
                }
            }
        };
        AEFilterManager aEFilterManager = this.D;
        if (aEFilterManager != null && aEFilterManager.isInited()) {
            runnable.run();
        } else {
            C(runnable);
        }
    }

    public void T0(boolean z16) {
        AEFilterManager aEFilterManager = this.D;
        if (aEFilterManager != null) {
            aEFilterManager.switchAbilityInLightNode("stroke.segmentFollowFace", z16);
        }
    }

    public List<AEResInfo> U() {
        com.tencent.aelight.camera.ae.camera.filter.a aVar = this.P;
        if (aVar != null) {
            return aVar.j();
        }
        return null;
    }

    public PTFaceAttr V() {
        AEFilterManager aEFilterManager = this.D;
        if (aEFilterManager == null) {
            return null;
        }
        return aEFilterManager.getFaceAttr();
    }

    public boolean W() {
        if (this.D == null) {
            return false;
        }
        return T() != null || f64283u0 > 0 || f64284v0 > 0 || f64285w0 != null;
    }

    public void W0(DeviceCameraConfig deviceCameraConfig) {
        AEFilterManager aEFilterManager = this.D;
        if (aEFilterManager != null) {
            aEFilterManager.updateDeviceCameraConfig(deviceCameraConfig);
        }
    }

    public void X0(int i3) {
        AEFilterManager aEFilterManager = this.D;
        if (aEFilterManager != null) {
            aEFilterManager.updateFenGeAlpha(i3);
        }
    }

    public void Y0(float f16) {
        LSOperationUpdater.OPERATION_ENUM operation_enum = LSOperationUpdater.OPERATION_ENUM.FILTER_LUT;
        if (M(operation_enum, f64285w0, f16, 0)) {
            AEFilterManager aEFilterManager = this.D;
            if (aEFilterManager != null) {
                aEFilterManager.updateLutAlpha(f16);
                i0(f64285w0, f16);
            }
            n0(operation_enum);
        }
    }

    public void Z0(String str) {
        f64285w0 = str;
        AEFilterManager aEFilterManager = this.D;
        if (aEFilterManager != null) {
            aEFilterManager.updateLutGL(str);
        }
        n0(LSOperationUpdater.OPERATION_ENUM.FILTER_LUT);
    }

    public boolean b0() {
        AEFilterManager aEFilterManager = this.D;
        if (aEFilterManager == null) {
            return false;
        }
        return aEFilterManager.needMaskRecordTouchPoint();
    }

    public void b1(MotionEvent motionEvent, int i3, int i16) {
        if (this.D != null) {
            int action = motionEvent.getAction() & 255;
            if (action == 0 || action == 1 || action == 2 || action == 5 || action == 6) {
                this.f64296h0.clear();
                int pointerCount = motionEvent.getPointerCount();
                for (int i17 = 0; i17 < pointerCount; i17++) {
                    this.f64296h0.add(new PointF(motionEvent.getX(i17), motionEvent.getY(i17)));
                }
                this.D.updateTouchEvent(TouchEventUtils.getEventAction(motionEvent), motionEvent.getDownTime(), motionEvent.getEventTime(), this.f64296h0, i3, i16);
            }
        }
    }

    public void c0(String str, int i3, int i16) {
        LSOperationUpdater.OPERATION_ENUM operation_enum = LSOperationUpdater.OPERATION_ENUM.LIPS_OPERATION;
        if (N(operation_enum, str, i3, i16)) {
            AEFilterManager aEFilterManager = this.D;
            if (aEFilterManager != null) {
                aEFilterManager.openAndUpdateBasicLips(str, i3, i16);
                h0(operation_enum);
            }
            n0(operation_enum);
        }
    }

    public void c1(float f16) {
        AEFilterManager aEFilterManager = this.D;
        if (aEFilterManager == null || !aEFilterManager.currentMaterialNeedVoiceDecibel()) {
            return;
        }
        this.D.updateVoiceDecibel(f16);
    }

    public void d0(String str, int i3) {
        LSOperationUpdater.OPERATION_ENUM operation_enum = LSOperationUpdater.OPERATION_ENUM.MULTIPLY_OPERATION;
        if (N(operation_enum, str, i3, 0)) {
            AEFilterManager aEFilterManager = this.D;
            if (aEFilterManager != null) {
                aEFilterManager.openAndUpdateBasicMultiply(str, i3);
                h0(operation_enum);
            }
            n0(operation_enum);
        }
    }

    public void e0(String str, int i3) {
        LSOperationUpdater.OPERATION_ENUM operation_enum = LSOperationUpdater.OPERATION_ENUM.SOFT_OPERATION;
        if (N(operation_enum, str, i3, 0)) {
            AEFilterManager aEFilterManager = this.D;
            if (aEFilterManager != null) {
                aEFilterManager.openAndUpdateBasicSoftLight(str, i3);
                h0(operation_enum);
            }
            n0(operation_enum);
        }
    }

    public void f0(boolean z16) {
        AEFilterManager aEFilterManager = this.D;
        if (aEFilterManager != null) {
            aEFilterManager.openBeautyEnable(z16);
        }
    }

    public void g0(String str) {
        AEFilterManager aEFilterManager = this.D;
        if (aEFilterManager != null) {
            aEFilterManager.openFaceThinEnable(str);
        }
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.filter.LSFilterProcessBase
    public void i() {
        E();
    }

    public synchronized void l0() {
        if (!TextUtils.isEmpty(this.U)) {
            this.X.add(this.U);
        }
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.filter.LSFilterProcessBase
    public void m() {
        if (this.D == null || T() == null || this.D.getVideoMaterial() == null || !this.D.getVideoMaterial().needResetWhenRecord()) {
            return;
        }
        this.D.stickerReset(true);
    }

    public void m0() {
        if (T() != null) {
            VideoMaterial loadLightAsset = VideoMaterial.loadLightAsset(T().getDataPath());
            if (com.tencent.aelight.camera.ae.d.f(loadLightAsset)) {
                ms.a.f("LSFilterProcessTex", "recoverLastEffect---id=" + loadLightAsset.getId());
                if (loadLightAsset.isWatermarkMaterial()) {
                    ms.a.f("LSFilterProcessTex", "recoverLastEffect---is an editable watermark material");
                    f fVar = this.Z;
                    if (fVar != null) {
                        fVar.recover(loadLightAsset);
                    }
                } else {
                    this.D.updateMaterialGL(loadLightAsset);
                    h0(LSOperationUpdater.OPERATION_ENUM.MATERIAL_OPERATION);
                    String id5 = loadLightAsset.getId();
                    this.U = id5;
                    String str = f64287y0;
                    if (str != null && str.equals(id5)) {
                        this.D.setCustomMaterial(f64288z0);
                    }
                }
            }
        } else {
            this.D.updateMaterialGL(null);
            h0(LSOperationUpdater.OPERATION_ENUM.MATERIAL_OPERATION);
        }
        Q0();
        if (f64286x0 && this.D.isInited()) {
            S0(f64286x0);
        }
        int i3 = f64283u0;
        if (i3 > 0) {
            this.D.setSmoothLevel(i3);
        }
        int i16 = f64284v0;
        if (i16 > 0) {
            J0(i16);
        }
    }

    public void q0(e eVar) {
        this.R = eVar;
    }

    public void r0() {
        AEFilterManager aEFilterManager = this.D;
        if (aEFilterManager != null) {
            aEFilterManager.setAudioPause();
        }
    }

    public void s0() {
        AEFilterManager aEFilterManager = this.D;
        if (aEFilterManager != null) {
            aEFilterManager.setAudioStart();
        }
    }

    public void t0(BeautyRealConfig.TYPE type, int i3) {
        AEFilterManager aEFilterManager = this.D;
        if (aEFilterManager != null) {
            aEFilterManager.setBeautyOrTransformLevel(type, i3);
        }
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.filter.LSFilterProcessBase
    public void u(float f16) {
        AEFilterManager aEFilterManager = this.D;
        if (aEFilterManager != null) {
            aEFilterManager.setPhoneRoll(f16);
        }
    }

    public void u0(LightNode.ILightNodeCameraExposureListener iLightNodeCameraExposureListener) {
        this.f64291c0 = iLightNodeCameraExposureListener;
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.filter.LSFilterProcessBase
    public void v(int i3, int i16, int i17, int i18, int i19, int i26) {
        if (j()) {
            a1(i3, i16, i17, i18, i19, i26);
        } else {
            super.v(i3, i16, i17, i18, i19, i26);
        }
        AEFilterManager aEFilterManager = this.D;
        if (aEFilterManager != null) {
            aEFilterManager.updateWidthHeight(this.f64259e, this.f64260f);
        }
    }

    public void v0(String str, String str2) {
        f64287y0 = str;
        f64288z0 = str2;
        AEFilterManager aEFilterManager = this.D;
        if (aEFilterManager != null) {
            aEFilterManager.setCustomMaterial(str2);
        }
    }

    public void w0(f fVar) {
        this.Z = fVar;
    }

    public void y0(int i3) {
        this.f64305q0 = i3;
    }

    public void z0(LSCameraGLSurfaceView.v vVar) {
        this.f64292d0 = vVar;
    }

    private void Q0() {
        ay ayVar = (ay) com.tencent.aelight.camera.ae.control.a.b(4);
        ay.SelectFilter d16 = ayVar.d();
        if (d16 == null || "".equals(d16.getId()) || com.tencent.aelight.camera.ae.flashshow.filter.b.a() == null) {
            return;
        }
        com.tencent.aelight.camera.ae.flashshow.filter.b.a().A0(false);
        com.tencent.aelight.camera.ae.flashshow.filter.b.a().Z0(d16.getLutPath());
        if (ayVar.c(d16.getId()) != null) {
            Y0(r0.getSeekBarValue());
        }
    }

    public void K() {
        F0(null);
        z0(null);
        q0(null);
        L0(null);
        u0(null);
        w0(null);
    }

    public void N0(VideoMaterial videoMaterial) {
        O0(videoMaterial, false);
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.filter.LSFilterProcessBase
    public void c() {
        this.f64291c0 = null;
        VideoFilterBase videoFilterBase = this.K;
        if (videoFilterBase != null) {
            videoFilterBase.clear();
            this.K = null;
        }
        VideoFilterBase videoFilterBase2 = this.I;
        if (videoFilterBase2 != null) {
            videoFilterBase2.clear();
            this.I = null;
        }
        com.tencent.aelight.camera.ae.flashshow.filter.e eVar = this.N;
        if (eVar != null) {
            eVar.clearGLSLSelf();
            this.N = null;
        }
        com.tencent.aelight.camera.ae.flashshow.filter.d dVar = this.J;
        if (dVar != null) {
            dVar.clearGLSLSelf();
        }
        CropFilter cropFilter = this.L;
        if (cropFilter != null) {
            cropFilter.clear();
            this.L = null;
        }
        com.tencent.aelight.camera.ae.flashshow.filter.a aVar = this.M;
        if (aVar != null) {
            aVar.clear();
            this.M = null;
        }
        Frame frame = this.E;
        if (frame != null) {
            frame.clear();
            this.E = null;
        }
        Frame frame2 = this.F;
        if (frame2 != null) {
            frame2.clear();
            this.F = null;
        }
        Frame frame3 = this.G;
        if (frame3 != null) {
            frame3.clear();
            this.G = null;
        }
        Frame frame4 = this.H;
        if (frame4 != null) {
            frame4.clear();
            this.H = null;
        }
        AEFilterManager aEFilterManager = this.D;
        if (aEFilterManager != null) {
            aEFilterManager.setStickerInnerLutFilterListener(null);
            this.D.destroy();
            this.D = null;
        }
        Bitmap bitmap = this.f64302n0;
        if (bitmap != null) {
            bitmap.recycle();
            this.f64302n0 = null;
        }
        this.f64290b0 = null;
        this.S.a();
        com.tencent.aelight.camera.ae.flashshow.autotest.f fVar = this.f64295g0;
        if (fVar != null) {
            fVar.k();
        }
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.filter.LSFilterProcessBase
    public void d(boolean z16) {
        f64283u0 = 0;
        f64284v0 = 0;
        f64286x0 = false;
        if (z16) {
            C0(null);
        }
    }

    private void k0(int i3) {
        this.I.setRotationAndFlip(0, false, true);
        if (j()) {
            int i16 = this.f64259e;
            int i17 = this.f64260f;
            int[] iArr = this.f64268n;
            int P = P(i3, i16, i17, iArr[0], iArr[1]);
            VideoFilterBase videoFilterBase = this.I;
            int[] iArr2 = this.f64268n;
            videoFilterBase.RenderProcess(P, iArr2[0], iArr2[1], -1, 0.0d, this.F);
        } else {
            this.I.RenderProcess(i3, this.f64259e, this.f64260f, -1, 0.0d, this.F);
        }
        this.I.setRotationAndFlip(0, false, false);
    }

    private int P(int i3, int i16, int i17, int i18, int i19) {
        if (i18 * i17 == i19 * i16) {
            return i3;
        }
        this.L.updateCorpRect(i18, i19, i16, i17);
        Frame RenderProcess = this.L.RenderProcess(i3, i16, i17, i18, i19);
        D0 = i19;
        C0 = i18;
        return RenderProcess.getTextureId();
    }

    /* JADX WARN: Code restructure failed: missing block: B:73:0x016f, code lost:
    
        if (r20.Q != false) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0171, code lost:
    
        r2 = r0.getGenderList();
        r0 = r0.getAgeList();
        ms.a.a("LSFilterProcessTex", "first get face data: genderList=" + r2 + "\nageList=" + r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0197, code lost:
    
        if (r2 == null) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0199, code lost:
    
        if (r0 == null) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01a3, code lost:
    
        if (r2.size() != r0.size()) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01a9, code lost:
    
        if (r2.size() <= 0) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01b5, code lost:
    
        if (r2.get(0).intValue() == 0) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01b7, code lost:
    
        r20.Q = true;
        r4 = r20.R;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01bb, code lost:
    
        if (r4 == null) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01bd, code lost:
    
        r4.a(r2, r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00dd A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00de A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.tencent.aelight.camera.ae.flashshow.filter.LSFilterProcessBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int[] s(int i3, int i16, boolean z16) {
        Frame frame;
        Frame RenderProcess;
        Frame frame2;
        com.tencent.aelight.camera.ae.flashshow.autotest.f fVar;
        String str;
        boolean z17;
        int i17;
        int i18;
        int i19;
        com.tencent.aelight.camera.ae.flashshow.autotest.a aVar;
        String str2;
        if (!k()) {
            int[] iArr = this.f64272r;
            iArr[0] = 0;
            iArr[1] = 0;
            return iArr;
        }
        J();
        boolean z18 = this.f64274t;
        boolean z19 = com.tencent.aelight.camera.ae.flashshow.autotest.b.f64141g || com.tencent.aelight.camera.ae.flashshow.autotest.b.f64150p;
        if (com.tencent.aelight.camera.ae.flashshow.autotest.b.f64151q) {
            H();
            if (this.f64295g0 == null) {
                return null;
            }
        }
        if (!z19 || (frame = a0()) == null) {
            frame = null;
        }
        if (!z19 && z18 && F()) {
            LSDashboardUtil.f64214d.f64248o = true;
            this.f64259e = this.f64255a;
            this.f64260f = this.f64256b;
        }
        if (this.f64293e0 != null) {
            List<WMElement> wmGetEditableWMElements = this.D.wmGetEditableWMElements();
            if (wmGetEditableWMElements != null && !wmGetEditableWMElements.isEmpty()) {
                Iterator<WMElement> it = wmGetEditableWMElements.iterator();
                while (it.hasNext()) {
                    it.next().setText(this.f64293e0);
                }
                ms.a.f("LSFilterProcessTex", "apply watermark text success: " + this.f64293e0);
                this.f64293e0 = null;
            } else {
                ms.a.c("LSFilterProcessTex", "try apply watermark text, but found no WMElements");
            }
        }
        if (!z19) {
            com.tencent.aelight.camera.ae.flashshow.filter.a aVar2 = this.M;
            int i26 = this.f64261g;
            int i27 = this.f64262h;
            aVar2.updateCorpRect(i26, i27, i26, i27);
            this.M.updateMatrix(this.f64273s);
            RenderProcess = this.M.RenderProcess(this.f64270p, this.f64259e, this.f64260f);
        } else {
            if (frame == null) {
                frame2 = null;
                if (frame2 != null) {
                    return null;
                }
                try {
                    PTFaceAttr notifyDetectFaceAttr = this.D.notifyDetectFaceAttr();
                    if (notifyDetectFaceAttr != null) {
                        List<Integer> genderList = notifyDetectFaceAttr.getGenderList();
                        if (genderList != null && genderList.size() > 0) {
                            Integer num = genderList.get(0);
                            if (this.f64292d0 != null && num.intValue() > 0) {
                                this.f64292d0.onGenderTypeListener(num.intValue());
                                if (!this.P.p()) {
                                    if (this.f64298j0) {
                                        LogUtils.i("LSFilterProcessTex", "genderType:" + num);
                                        this.D.switchAbilityInLightNode(LightConstants.DetectSwitchKey.AI_FACE_STATIC_FEATURE_ENABLE, false);
                                        this.f64298j0 = false;
                                    } else if (this.f64299k0) {
                                        LogUtils.i("LSFilterProcessTex", "set genderType: NONE...");
                                        this.D.switchAIAbility(LightConstants.DetectSwitchKey.AI_FACE_STATIC_FEATURE_ENABLE, "none");
                                        this.f64299k0 = false;
                                    }
                                }
                            }
                        }
                        List<FaceStatus> faceStatusList = notifyDetectFaceAttr.getFaceStatusList();
                        if (faceStatusList != null && !faceStatusList.isEmpty() && faceStatusList.size() <= 1) {
                            int i28 = notifyDetectFaceAttr.getFaceStatusList().get(0).gender;
                        }
                    }
                } catch (Throwable th5) {
                    QLog.d("LSFilterProcessTex", 1, "AEKit \u6e32\u67d3 start Throwable = " + th5.getMessage());
                }
                int textureId = frame2.getTextureId();
                if (this.D != null) {
                    if (!this.V) {
                        ((IAELaunchRecorder) QRoute.api(IAELaunchRecorder.class)).milestone(IAELaunchRecorder.MILESTONE_FILTER_MGR_DRAW_BEGIN);
                    }
                    HashMap hashMap = new HashMap();
                    if (z16) {
                        str2 = "1";
                    } else {
                        str2 = "0";
                    }
                    if (!str2.equals(this.f64297i0)) {
                        this.f64297i0 = str2;
                        hashMap.put("transparentMode", str2);
                    }
                    this.D.updateCameraConfigData(hashMap);
                    textureId = this.D.drawFrame(frame2.getTextureId(), z18, this.f64271q.getTimestamp(), this.f64261g, this.f64262h);
                    if (!this.V) {
                        ((IAELaunchRecorder) QRoute.api(IAELaunchRecorder.class)).milestone(IAELaunchRecorder.MILESTONE_FILTER_MGR_DRAW_END);
                        this.V = true;
                    }
                    frame2.unlock();
                }
                if (z19 && (aVar = this.f64294f0) != null) {
                    aVar.e(textureId, this.f64259e, this.f64260f);
                }
                if ((z19 || com.tencent.aelight.camera.ae.flashshow.autotest.b.f64152r) && (fVar = this.f64295g0) != null) {
                    fVar.r(textureId, this.f64259e, this.f64260f);
                }
                if (!j()) {
                    str = "LSFilterProcessTex";
                    z17 = z18;
                    i17 = textureId;
                } else {
                    int i29 = this.f64260f;
                    int i36 = i29 * i3;
                    int i37 = this.f64259e;
                    int i38 = i37 * i16;
                    if (i36 > i38) {
                        int i39 = i38 / i3;
                        i17 = P(textureId, i37, i29, i37, i39);
                        i18 = this.f64259e;
                        i19 = i39;
                        z17 = z18;
                        str = "LSFilterProcessTex";
                    } else {
                        z17 = z18;
                        if (i36 >= i38) {
                            str = "LSFilterProcessTex";
                            i17 = textureId;
                            i18 = 0;
                            i19 = 0;
                        } else {
                            int i46 = i36 / i16;
                            str = "LSFilterProcessTex";
                            i17 = P(textureId, i37, i29, i46, i29);
                            i19 = this.f64260f;
                            i18 = i46;
                        }
                    }
                    B0 = i17;
                    p0(i18, i19, i17, z17);
                }
                o0(i3, i16, i17, z16);
                if (z17) {
                    QLog.d(str, 1, "in capture frame.");
                    G(textureId, this.f64259e, this.f64260f);
                    this.f64274t = false;
                }
                FrameBufferCache.getInstance().forceRecycle();
                if (this.f64269o) {
                    k0(textureId);
                }
                int[] iArr2 = this.f64272r;
                iArr2[0] = textureId;
                iArr2[1] = this.F.getTextureId();
                tq.d.d();
                return this.f64272r;
            }
            CropFilter cropFilter = this.L;
            int i47 = this.f64261g;
            int i48 = this.f64262h;
            cropFilter.updateCorpRect(i47, i48, i47, i48);
            RenderProcess = this.L.RenderProcess(frame.getTextureId(), this.f64259e, this.f64260f);
        }
        frame2 = RenderProcess;
        if (frame2 != null) {
        }
    }

    private void o0(int i3, int i16, int i17, boolean z16) {
        int i18;
        if (z16) {
            GLES20.glClearColor(0.92f, 0.93f, 0.96f, 1.0f);
            GLES20.glClear(16384);
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(MiniReportManager.EventId.SDK_EMBEDDED_VIDEO, MiniReportManager.EventId.SDK_EMBEDDED_LIVE_PLAYER);
            FrameUtil.clearFrame(this.E, 0.0f, 0.0f, 0.0f, 0.0f, i3, i16);
            this.J.RenderProcess(i17, i3, i3, -1, 0.0d, this.E);
            i18 = this.E.getTextureId();
        } else {
            i18 = i17;
        }
        this.K.setRotationAndFlip(0, false, true);
        this.K.RenderProcess(i18, i3, i16, 0, 0.0d, this.E);
        if (z16) {
            GlUtil.setBlendModeSrcAlpha(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class b implements OnLoadAssetListener {
        b() {
        }

        @Override // org.light.listener.OnLoadAssetListener
        public void OnAssetProcessing(HashMap<String, String> hashMap) {
            Log.d("LSFilterProcessTex", "OnAssetProcessing: " + hashMap);
            if (LSFilterProcessTex.this.f64290b0 != null) {
                LSFilterProcessTex.this.f64290b0.OnAssetProcessing(hashMap);
            }
        }

        @Override // org.light.listener.OnLoadAssetListener
        public void OnLoadAssetError(int i3) {
            Log.d("LSFilterProcessTex", "OnLoadAssetError: " + i3);
            if (LSFilterProcessTex.this.f64290b0 != null) {
                LSFilterProcessTex.this.f64290b0.OnLoadAssetError(i3);
            }
        }

        @Override // org.light.listener.OnLoadAssetListener
        public void OnAssetDurationChange(long j3) {
        }
    }
}
