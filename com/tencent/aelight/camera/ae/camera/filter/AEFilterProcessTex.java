package com.tencent.aelight.camera.ae.camera.filter;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.hardware.SensorEvent;
import android.opengl.GLES20;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.FrameBufferCache;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.aelight.camera.ae.camera.autotest.AEFilterManagerParamsListener;
import com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView;
import com.tencent.aelight.camera.ae.camera.ui.dashboard.AEDashboardUtil;
import com.tencent.aelight.camera.ae.camera.util.AIOOperationUpdater;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.ae.util.j;
import com.tencent.aelight.camera.api.IAELaunchRecorder;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.SurfaceTextureFilter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.facedetect.FaceStatus;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.config.BeautyRealConfig;
import com.tencent.ttpic.openapi.filter.CropFilter;
import com.tencent.ttpic.openapi.filter.LightNode;
import com.tencent.ttpic.openapi.filter.SpaceFilter;
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
import org.light.DeviceCameraConfig;
import org.light.LightConstants;
import org.light.bean.WMElement;
import org.light.listener.OnLoadAssetListener;
import org.light.utils.LightLogUtil;
import org.light.utils.TouchEventUtils;

/* loaded from: classes32.dex */
public class AEFilterProcessTex extends FilterProcessBase {

    /* renamed from: n0, reason: collision with root package name */
    private static int f62224n0;

    /* renamed from: o0, reason: collision with root package name */
    private static SparseArray<VideoMaterial> f62225o0 = new SparseArray<>();

    /* renamed from: p0, reason: collision with root package name */
    private static int f62226p0 = 0;

    /* renamed from: q0, reason: collision with root package name */
    private static int f62227q0 = 0;

    /* renamed from: r0, reason: collision with root package name */
    private static String f62228r0 = null;

    /* renamed from: s0, reason: collision with root package name */
    private static boolean f62229s0 = false;

    /* renamed from: t0, reason: collision with root package name */
    private static String f62230t0 = null;

    /* renamed from: u0, reason: collision with root package name */
    private static String f62231u0 = null;

    /* renamed from: v0, reason: collision with root package name */
    private static boolean f62232v0 = false;
    private AEFilterManager D;
    private Frame E;
    private Frame F;
    private BaseFilter G;
    private BaseFilter H;
    private com.tencent.aelight.camera.ae.camera.filter.c I;
    private SpaceFilter J;
    private CropFilter K;
    private com.tencent.aelight.camera.ae.gif.b L;
    private com.tencent.aelight.camera.ae.camera.filter.a N;
    private d P;
    private final int R;
    private String S;
    private e X;
    private LightNode.ILightNodeTipsListener Y;
    private OnLoadAssetListener Z;

    /* renamed from: a0, reason: collision with root package name */
    private AECameraGLSurfaceView.AEGenderTypeListener f62233a0;

    /* renamed from: b0, reason: collision with root package name */
    private String f62234b0;

    /* renamed from: k0, reason: collision with root package name */
    private AIOOperationUpdater f62243k0;

    /* renamed from: l0, reason: collision with root package name */
    private AIOOperationUpdater f62244l0;

    /* renamed from: m0, reason: collision with root package name */
    private AEFilterManager.MaterialInnerEffectListener f62245m0;
    private Queue<Runnable> M = new ArrayDeque();
    private boolean O = false;
    private eq.a Q = new eq.a();
    private boolean T = false;
    public volatile boolean U = true;
    private Set<String> V = new HashSet();
    private boolean W = true;

    /* renamed from: c0, reason: collision with root package name */
    private com.tencent.aelight.camera.ae.camera.autotest.a f62235c0 = null;

    /* renamed from: d0, reason: collision with root package name */
    private final ArrayList<PointF> f62236d0 = new ArrayList<>();

    /* renamed from: e0, reason: collision with root package name */
    private String f62237e0 = "";

    /* renamed from: f0, reason: collision with root package name */
    private boolean f62238f0 = false;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f62239g0 = false;

    /* renamed from: h0, reason: collision with root package name */
    private boolean f62240h0 = false;

    /* renamed from: i0, reason: collision with root package name */
    private boolean f62241i0 = false;

    /* renamed from: j0, reason: collision with root package name */
    private Bitmap f62242j0 = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a implements LightNode.ILightNodeTipsListener {
        a() {
        }

        @Override // com.tencent.ttpic.openapi.filter.LightNode.ILightNodeTipsListener
        public void onHideNormalTip() {
            if (AEFilterProcessTex.this.Y != null) {
                AEFilterProcessTex.this.Y.onHideNormalTip();
            }
        }

        @Override // com.tencent.ttpic.openapi.filter.LightNode.ILightNodeTipsListener
        public void onHidePagTip() {
            if (AEFilterProcessTex.this.Y != null) {
                AEFilterProcessTex.this.Y.onHidePagTip();
            }
        }

        @Override // com.tencent.ttpic.openapi.filter.LightNode.ILightNodeTipsListener
        public void onShowNormalTip(String str, String str2, int i3) {
            if (AEFilterProcessTex.this.Y != null) {
                AEFilterProcessTex.this.Y.onShowNormalTip(str, str2, i3);
            }
        }

        @Override // com.tencent.ttpic.openapi.filter.LightNode.ILightNodeTipsListener
        public void onShowPagTip(String str, int i3) {
            if (AEFilterProcessTex.this.Y != null) {
                AEFilterProcessTex.this.Y.onShowPagTip(str, i3);
            }
        }
    }

    /* loaded from: classes32.dex */
    public interface c {
        void onCaptureError(int i3);

        void onPhotoCaptured(Bitmap bitmap);
    }

    /* loaded from: classes32.dex */
    public interface d {
        void a(List<Integer> list, List<Integer> list2);
    }

    /* loaded from: classes32.dex */
    public interface e {
        void recover(VideoMaterial videoMaterial);
    }

    public AEFilterProcessTex(int i3, com.tencent.aelight.camera.ae.camera.filter.a aVar) {
        this.R = i3;
        this.N = aVar;
        M();
        if (com.tencent.aelight.camera.ae.d.t()) {
            LightLogUtil.init(new rs.a());
            LightLogUtil.setMinPriority(6);
        }
    }

    @MustRunOnGLThread
    private void D() {
        BaseFilter baseFilter = this.G;
        if (baseFilter != null) {
            baseFilter.applyFilterChain(true, this.f62253e, this.f62254f);
        }
        SpaceFilter spaceFilter = this.J;
        if (spaceFilter != null) {
            spaceFilter.applyFilterChain(true, this.f62253e, this.f62254f);
        }
        BaseFilter baseFilter2 = this.H;
        if (baseFilter2 != null) {
            baseFilter2.applyFilterChain(true, this.f62253e, this.f62254f);
        }
        com.tencent.aelight.camera.ae.camera.filter.c cVar = this.I;
        if (cVar != null) {
            cVar.apply();
        }
        CropFilter cropFilter = this.K;
        if (cropFilter != null) {
            cropFilter.apply();
        }
        if (this.D != null) {
            V();
            Q0();
        }
        com.tencent.aelight.camera.ae.gif.b bVar = this.L;
        if (bVar != null) {
            bVar.b();
        }
        this.Q.f();
    }

    private int[] E(double d16) {
        if (Math.abs(d16 - this.f62259k) <= 0.01d) {
            return new int[]{this.f62255g, this.f62256h};
        }
        int i3 = this.f62256h;
        int i16 = this.f62255g;
        if (d16 < this.f62259k) {
            i16 = (int) (i3 * d16);
        } else {
            i3 = (int) (i16 / d16);
        }
        return new int[]{i16, i3};
    }

    private boolean F() {
        return this.D != null && j.h().l() && k() && this.D.canUseLargeImage();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004f A[Catch: OutOfMemoryError -> 0x005a, TryCatch #0 {OutOfMemoryError -> 0x005a, blocks: (B:2:0x0000, B:8:0x0035, B:10:0x004f, B:11:0x0052, B:13:0x0056), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0056 A[Catch: OutOfMemoryError -> 0x005a, TRY_LEAVE, TryCatch #0 {OutOfMemoryError -> 0x005a, blocks: (B:2:0x0000, B:8:0x0035, B:10:0x004f, B:11:0x0052, B:13:0x0056), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void G(int i3, int i16, int i17) {
        int i18;
        int i19;
        c cVar;
        try {
            int i26 = -(((this.f62269u - 90) + 360) % 360);
            ms.a.a("AEFilterProcessTex", "[captureFrame]:rotation = " + i26);
            this.H.setRotationAndFlip(i26, 0, 0);
            int i27 = this.f62269u;
            if (i27 != 0 && i27 != 180) {
                i19 = i16;
                i18 = i17;
                this.H.RenderProcess(i3, i19, i18, -1, 0.0d, this.F);
                this.H.setRotationAndFlip(0, 0, 0);
                Bitmap saveTexture = RendererUtils.saveTexture(this.F);
                cVar = this.f62270v;
                if (cVar != null) {
                    cVar.onPhotoCaptured(saveTexture);
                }
                if (this.W) {
                    return;
                }
                i0();
                return;
            }
            i18 = i16;
            i19 = i17;
            this.H.RenderProcess(i3, i19, i18, -1, 0.0d, this.F);
            this.H.setRotationAndFlip(0, 0, 0);
            Bitmap saveTexture2 = RendererUtils.saveTexture(this.F);
            cVar = this.f62270v;
            if (cVar != null) {
            }
            if (this.W) {
            }
        } catch (OutOfMemoryError unused) {
            c cVar2 = this.f62270v;
            if (cVar2 != null) {
                cVar2.onCaptureError(103);
            }
        }
    }

    private void G0(int i3) {
        AEFilterManager aEFilterManager = this.D;
        if (aEFilterManager != null) {
            aEFilterManager.setBeautyOrTransformLevel(BeautyRealConfig.TYPE.BASIC4, i3);
        }
    }

    private void H() {
        if (this.f62235c0 == null) {
            com.tencent.aelight.camera.ae.camera.autotest.a a16 = com.tencent.aelight.camera.ae.camera.autotest.c.c().a();
            this.f62235c0 = a16;
            if (a16 != null) {
                a16.f(new AEFilterManagerParamsListener(this.D));
            }
        }
    }

    private void I() {
        AIOOperationUpdater aIOOperationUpdater = this.f62244l0;
        if (aIOOperationUpdater == null) {
            return;
        }
        aIOOperationUpdater.d(this);
        if (this.f62244l0.g()) {
            this.f62244l0 = null;
        }
    }

    private boolean J(AIOOperationUpdater.OPERATION_ENUM operation_enum) {
        AIOOperationUpdater aIOOperationUpdater = this.f62244l0;
        return aIOOperationUpdater == null || aIOOperationUpdater.h(operation_enum);
    }

    private boolean K(AIOOperationUpdater.OPERATION_ENUM operation_enum, String str, float f16, int i3) {
        if (J(operation_enum)) {
            return true;
        }
        this.f62244l0.l(operation_enum, new AIOOperationUpdater.k(str, f16, i3));
        return false;
    }

    private boolean L(AIOOperationUpdater.OPERATION_ENUM operation_enum, String str, int i3, int i16) {
        if (J(operation_enum)) {
            return true;
        }
        this.f62244l0.l(operation_enum, new AIOOperationUpdater.k(str, i3, i16));
        return false;
    }

    private synchronized void M() {
        if (this.G == null) {
            this.G = new SurfaceTextureFilter();
        }
        if (this.J == null) {
            this.J = new SpaceFilter();
        }
        if (this.H == null) {
            this.H = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
        }
        if (this.I == null) {
            this.I = new com.tencent.aelight.camera.ae.camera.filter.c("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
        }
        if (this.K == null) {
            this.K = new CropFilter();
        }
        if (this.E == null) {
            this.E = new Frame();
        }
        if (this.F == null) {
            this.F = new Frame();
        }
        if (this.D == null) {
            AEFilterManager aEFilterManager = new AEFilterManager(this.N.k(), this.N.m(), true, null, AEOfflineConfig.getPhonePerfLevel() < 3);
            this.D = aEFilterManager;
            aEFilterManager.setZplanFilamentAbility(xq.c.f448345a);
            this.D.setLightAppEntry(rs.b.c().b());
        }
        if (this.L == null) {
            this.L = new com.tencent.aelight.camera.ae.gif.b();
        }
    }

    public static int Q() {
        return f62224n0;
    }

    private void Q0() {
        AIOOperationUpdater.OPERATION_ENUM operation_enum = AIOOperationUpdater.OPERATION_ENUM.MATERIAL_OPERATION;
        if (J(operation_enum)) {
            l0(operation_enum);
            k0();
        }
    }

    private VideoMaterial R() {
        return f62225o0.get(this.R);
    }

    private void R0() {
        int[] iArr = this.f62262n;
        int i3 = this.f62253e;
        iArr[0] = i3;
        int i16 = this.f62254f;
        iArr[1] = i16;
        if (i16 * 9 > i3 * 16) {
            iArr[1] = (i3 * 16) / 9;
        } else if (i16 * 9 < i3 * 16) {
            iArr[0] = (i16 * 9) / 16;
        }
    }

    private void V() {
        this.D.initInGL(this.f62253e, this.f62254f);
        this.D.setStickerInnerLutFilterListener(this.f62245m0);
        LogUtils.setEnable(false);
        for (Map.Entry<BeautyRealConfig.TYPE, Integer> entry : this.N.i().entrySet()) {
            this.D.setBeautyOrTransformLevel(entry.getKey(), entry.getValue().intValue());
        }
        HashMap hashMap = new HashMap();
        hashMap.put("smooth.curveAdjustAlpha", "0");
        this.D.updateCameraConfigData(hashMap);
        if (this.N.p()) {
            this.D.switchAbilityInLightNode(LightConstants.DetectSwitchKey.AI_FACE_STATIC_FEATURE_ENABLE, true);
            this.f62238f0 = true;
            this.f62239g0 = true;
            this.f62240h0 = true;
            this.f62241i0 = true;
        }
        this.D.setExposureValue(50);
        this.D.setLightNodeTipsListener(new a());
        this.D.setLightNodeLightAssetListener(new b());
        W();
        while (true) {
            Queue<Runnable> queue = this.M;
            if (queue == null || queue.isEmpty()) {
                return;
            }
            Runnable poll = this.M.poll();
            if (poll != null) {
                poll.run();
            }
        }
    }

    private void W() {
        Map<String, String> o16 = AEResUtil.o();
        if (o16 != null) {
            for (Map.Entry<String, String> entry : o16.entrySet()) {
                if (this.D != null) {
                    String value = entry.getValue();
                    String key = entry.getKey();
                    QLog.d("AEFilterProcessTex", 2, "[injectBundlePathsToLight] agentType:" + key + " | dir:" + value);
                    this.D.setLightBundle(value, key);
                }
            }
        }
    }

    private void W0(int i3, int i16, int i17, int i18, int i19, int i26) {
        ms.a.f("AEFilterProcessTex", "updateSizeDY previewWidth: " + i19 + " previewHeight: " + i26 + ",viewWidth:" + i3 + ",viewHeight:" + i16);
        this.f62260l = ((double) i3) / ((double) i16);
        if (i17 > 0 && i18 > 0) {
            this.f62255g = i17;
            this.f62256h = i18;
            this.f62259k = i17 / i18;
            ms.a.f("AEFilterProcessTex", "updateSizeDY cameraWidth: " + this.f62255g + " cameraHeight: " + this.f62256h);
        }
        ms.a.f("AEFilterProcessTex", "updateSizeDY mCameraAspectRatio: " + this.f62259k);
        this.f62251c = i19;
        this.f62252d = (int) (((double) i19) / this.f62260l);
        this.f62253e = i19;
        double d16 = this.f62259k;
        if (d16 > 1.0E-5d) {
            if (i19 > (((int) (i19 / d16)) * 9) / 16) {
                int i27 = (i19 * 16) / 9;
                if (i27 <= i18 || i18 <= 0) {
                    i18 = i27;
                }
                this.f62254f = i18;
                this.f62253e = (i18 * 9) / 16;
            } else {
                this.f62254f = (i19 * 16) / 9;
            }
        } else {
            this.f62254f = i26;
        }
        ms.a.f("AEFilterProcessTex", "updateSizeDY this.previewWidth: " + this.f62253e + ",this.previewHeight:" + this.f62254f);
        this.f62249a = 1080;
        this.f62250b = (int) ((((double) 1080) / ((double) this.f62253e)) * ((double) this.f62254f));
        R0();
    }

    private boolean X() {
        return com.tencent.aelight.camera.ae.d.t();
    }

    private Frame Z() {
        AEFilterManager aEFilterManager;
        if (eq.a.f396956i) {
            H();
            com.tencent.aelight.camera.ae.camera.autotest.a aVar = this.f62235c0;
            if (aVar == null) {
                return null;
            }
            eq.a.f396959l = aVar.c();
            if (this.f62235c0.a() == null) {
                return null;
            }
            eq.a.f396958k = this.f62235c0.a();
            eq.a.f396957j = this.f62235c0.b();
        }
        this.Q.k(!eq.a.f396959l);
        if (!this.Q.h()) {
            this.Q.j();
            this.f62255g = this.Q.e();
            int b16 = this.Q.b();
            this.f62256h = b16;
            int i3 = this.f62253e;
            int i16 = this.f62255g;
            if ((i3 != i16 || this.f62254f != b16) && (aEFilterManager = this.D) != null) {
                aEFilterManager.updateWidthHeight(i16, b16);
            }
            this.f62253e = this.f62255g;
            this.f62254f = this.f62256h;
        }
        this.H.setRotationAndFlip(0, 0, 1);
        return this.H.RenderProcess(this.Q.c(), this.f62253e, this.f62254f);
    }

    private void g0(AIOOperationUpdater.OPERATION_ENUM operation_enum) {
        AIOOperationUpdater aIOOperationUpdater = this.f62243k0;
        if (aIOOperationUpdater == null) {
            return;
        }
        aIOOperationUpdater.i(operation_enum);
    }

    private void h0(String str, float f16) {
        AIOOperationUpdater aIOOperationUpdater = this.f62243k0;
        if (aIOOperationUpdater == null) {
            return;
        }
        aIOOperationUpdater.j(str, f16);
    }

    private void i0() {
        AEFilterManager aEFilterManager = this.D;
        if (aEFilterManager != null) {
            aEFilterManager.setStickerPause(true);
            this.D.onStickerStatusChange(true);
        }
    }

    private void l0(AIOOperationUpdater.OPERATION_ENUM operation_enum) {
        AIOOperationUpdater aIOOperationUpdater = this.f62244l0;
        if (aIOOperationUpdater == null) {
            return;
        }
        aIOOperationUpdater.k(operation_enum);
    }

    public static void u0(int i3) {
        f62224n0 = i3;
    }

    public static void x0(int i3, VideoMaterial videoMaterial) {
        f62225o0.put(i3, videoMaterial);
    }

    private void y0(VideoMaterial videoMaterial) {
        f62225o0.put(this.R, videoMaterial);
    }

    public void A0(String str, String str2) {
        AEFilterManager aEFilterManager;
        if (TextUtils.isEmpty(str) || (aEFilterManager = this.D) == null) {
            return;
        }
        aEFilterManager.setLightNodePresetData(str, str2);
        ms.a.f("AEFilterProcessTex", str + ":" + str2);
    }

    public void B(Runnable runnable) {
        this.M.offer(runnable);
    }

    public void B0(AEFilterManager.MaterialInnerEffectListener materialInnerEffectListener) {
        this.f62245m0 = materialInnerEffectListener;
    }

    public void C(PointF pointF, int i3) {
        AEFilterManager aEFilterManager = this.D;
        if (aEFilterManager == null) {
            return;
        }
        aEFilterManager.addMaskTouchPoint(pointF, i3);
    }

    public void C0(AIOOperationUpdater aIOOperationUpdater, AIOOperationUpdater aIOOperationUpdater2) {
        this.f62243k0 = aIOOperationUpdater;
        this.f62244l0 = aIOOperationUpdater2;
    }

    public void D0(boolean z16) {
        this.W = z16;
    }

    public void E0(SensorEvent sensorEvent) {
        AEFilterManager aEFilterManager = this.D;
        if (aEFilterManager != null) {
            aEFilterManager.setSensorEventToLight(sensorEvent);
        }
    }

    public void F0(int i3) {
        f62227q0 = i3;
        G0(i3);
    }

    public void H0(int i3) {
        f62226p0 = i3;
        this.D.setSmoothLevel(i3);
    }

    public void I0(LightNode.ILightNodeTipsListener iLightNodeTipsListener) {
        this.Y = iLightNodeTipsListener;
    }

    public void J0(Handler handler) {
        AETipsManager.getInstance().setUIHandler(handler, this.f62251c, this.f62252d, 0.16666666666666666d);
    }

    public void L0(VideoMaterial videoMaterial, boolean z16) {
        y0(videoMaterial);
        if (this.D != null) {
            if (videoMaterial != null && videoMaterial.getId() != null && (z16 || !videoMaterial.getId().equals(this.S))) {
                this.D.updateMaterialGL(videoMaterial);
                g0(AIOOperationUpdater.OPERATION_ENUM.MATERIAL_OPERATION);
                this.S = videoMaterial.getId();
            } else if (videoMaterial != null && videoMaterial.getId() != null) {
                ms.a.c("AEFilterProcessTex", "[setVideoMaterial] material is same");
                if (!TextUtils.isEmpty(this.S) && this.V.contains(this.S)) {
                    this.D.updateMaterialGL(videoMaterial);
                    g0(AIOOperationUpdater.OPERATION_ENUM.MATERIAL_OPERATION);
                    this.S = videoMaterial.getId();
                }
            } else {
                this.D.updateMaterialGL(videoMaterial);
                g0(AIOOperationUpdater.OPERATION_ENUM.MATERIAL_OPERATION);
                this.S = "none";
            }
            String str = f62230t0;
            if (str != null && str.equals(this.S)) {
                this.D.setCustomMaterial(f62231u0);
            }
        }
        int i3 = f62227q0;
        if (i3 > 0) {
            G0(i3);
        }
    }

    public void M0(String str) {
        this.f62234b0 = str;
    }

    public void N0(boolean z16) {
        AEFilterManager aEFilterManager = this.D;
        if (aEFilterManager != null) {
            aEFilterManager.switchAIBeauty(z16);
        }
    }

    public boolean O() {
        AEFilterManager aEFilterManager = this.D;
        if (aEFilterManager == null) {
            return false;
        }
        return AEStaticDetector.hasFaceData(aEFilterManager.getFaceAttr());
    }

    public void O0(final boolean z16) {
        f62229s0 = z16;
        Runnable runnable = new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.filter.AEFilterProcessTex.3
            @Override // java.lang.Runnable
            public void run() {
                if (AEFilterProcessTex.this.D != null) {
                    AEFilterProcessTex.this.D.switchAbilityInLightNode("ai.segmentation.bg.enable", z16);
                    if (AEFilterProcessTex.this.N.n()) {
                        if (z16) {
                            AEFilterProcessTex.this.D.setBeautyOrTransformLevel(BeautyRealConfig.TYPE.COLOR_TONE, 0);
                        } else {
                            AEFilterProcessTex.this.D.setBeautyOrTransformLevel(BeautyRealConfig.TYPE.COLOR_TONE, 50);
                        }
                    }
                }
            }
        };
        AEFilterManager aEFilterManager = this.D;
        if (aEFilterManager != null && aEFilterManager.isInited()) {
            runnable.run();
        } else {
            B(runnable);
        }
    }

    public AEFilterManager P() {
        return this.D;
    }

    public void P0(boolean z16) {
        AEFilterManager aEFilterManager = this.D;
        if (aEFilterManager != null) {
            aEFilterManager.switchAbilityInLightNode("stroke.segmentFollowFace", z16);
        }
    }

    public List<AEResInfo> S() {
        com.tencent.aelight.camera.ae.camera.filter.a aVar = this.N;
        if (aVar != null) {
            return aVar.j();
        }
        return null;
    }

    public void S0(DeviceCameraConfig deviceCameraConfig) {
        AEFilterManager aEFilterManager = this.D;
        if (aEFilterManager != null) {
            aEFilterManager.updateDeviceCameraConfig(deviceCameraConfig);
        }
    }

    public PTFaceAttr T() {
        AEFilterManager aEFilterManager = this.D;
        if (aEFilterManager == null) {
            return null;
        }
        return aEFilterManager.getFaceAttr();
    }

    public void T0(int i3) {
        AEFilterManager aEFilterManager = this.D;
        if (aEFilterManager != null) {
            aEFilterManager.updateFenGeAlpha(i3);
        }
    }

    public boolean U() {
        AEFilterManager aEFilterManager = this.D;
        return aEFilterManager != null && aEFilterManager.hasEffect();
    }

    public void U0(float f16) {
        AIOOperationUpdater.OPERATION_ENUM operation_enum = AIOOperationUpdater.OPERATION_ENUM.FILTER_LUT;
        if (K(operation_enum, f62228r0, f16, 0)) {
            AEFilterManager aEFilterManager = this.D;
            if (aEFilterManager != null) {
                aEFilterManager.updateLutAlpha(f16);
                h0(f62228r0, f16);
            }
            l0(operation_enum);
        }
    }

    public void V0(String str) {
        f62228r0 = str;
        AEFilterManager aEFilterManager = this.D;
        if (aEFilterManager != null) {
            aEFilterManager.updateLutGL(str);
        }
        l0(AIOOperationUpdater.OPERATION_ENUM.FILTER_LUT);
    }

    public void X0(MotionEvent motionEvent, int i3, int i16) {
        if (this.D != null) {
            int action = motionEvent.getAction() & 255;
            if (action == 0 || action == 1 || action == 2 || action == 5 || action == 6) {
                this.f62236d0.clear();
                int pointerCount = motionEvent.getPointerCount();
                for (int i17 = 0; i17 < pointerCount; i17++) {
                    this.f62236d0.add(new PointF(motionEvent.getX(i17), motionEvent.getY(i17)));
                }
                this.D.updateTouchEvent(TouchEventUtils.getEventAction(motionEvent), motionEvent.getDownTime(), motionEvent.getEventTime(), this.f62236d0, i3, i16);
            }
        }
    }

    public boolean Y() {
        VideoMaterial R = R();
        if (R != null) {
            return !TextUtils.isEmpty(R.getDataPath()) && R.needFaceInfo();
        }
        ms.a.a("AEFilterProcessTex", "[isNeedFaceDetect]: false");
        return false;
    }

    public void Y0(float f16) {
        AEFilterManager aEFilterManager = this.D;
        if (aEFilterManager == null || !aEFilterManager.currentMaterialNeedVoiceDecibel()) {
            return;
        }
        this.D.updateVoiceDecibel(f16);
    }

    public boolean a0() {
        AEFilterManager aEFilterManager = this.D;
        if (aEFilterManager == null) {
            return false;
        }
        return aEFilterManager.needMaskRecordTouchPoint();
    }

    public void b0(String str, int i3, int i16) {
        AIOOperationUpdater.OPERATION_ENUM operation_enum = AIOOperationUpdater.OPERATION_ENUM.LIPS_OPERATION;
        if (L(operation_enum, str, i3, i16)) {
            AEFilterManager aEFilterManager = this.D;
            if (aEFilterManager != null) {
                aEFilterManager.openAndUpdateBasicLips(str, i3, i16);
                g0(operation_enum);
            }
            l0(operation_enum);
        }
    }

    @Override // com.tencent.aelight.camera.ae.camera.filter.FilterProcessBase
    public void c() {
        BaseFilter baseFilter = this.G;
        if (baseFilter != null) {
            baseFilter.clearGLSL();
            this.G = null;
        }
        SpaceFilter spaceFilter = this.J;
        if (spaceFilter != null) {
            spaceFilter.clearGLSL();
            this.J = null;
        }
        BaseFilter baseFilter2 = this.H;
        if (baseFilter2 != null) {
            baseFilter2.clearGLSL();
            this.H = null;
        }
        com.tencent.aelight.camera.ae.camera.filter.c cVar = this.I;
        if (cVar != null) {
            cVar.clearGLSLSelf();
        }
        CropFilter cropFilter = this.K;
        if (cropFilter != null) {
            cropFilter.clearGLSL();
            this.K = null;
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
        AEFilterManager aEFilterManager = this.D;
        if (aEFilterManager != null) {
            aEFilterManager.setStickerInnerLutFilterListener(null);
            this.D.destroy();
            this.D = null;
        }
        com.tencent.aelight.camera.ae.gif.b bVar = this.L;
        if (bVar != null) {
            bVar.a();
            this.L = null;
        }
        Bitmap bitmap = this.f62242j0;
        if (bitmap != null) {
            bitmap.recycle();
            this.f62242j0 = null;
        }
        this.Q.a();
        AEBaseReportParam.U().b();
        ms.a.f("AEFilterProcessTex", "clear over.");
    }

    public void c0(String str, int i3) {
        AIOOperationUpdater.OPERATION_ENUM operation_enum = AIOOperationUpdater.OPERATION_ENUM.MULTIPLY_OPERATION;
        if (L(operation_enum, str, i3, 0)) {
            AEFilterManager aEFilterManager = this.D;
            if (aEFilterManager != null) {
                aEFilterManager.openAndUpdateBasicMultiply(str, i3);
                g0(operation_enum);
            }
            l0(operation_enum);
        }
    }

    public void d0(String str, int i3) {
        AIOOperationUpdater.OPERATION_ENUM operation_enum = AIOOperationUpdater.OPERATION_ENUM.SOFT_OPERATION;
        if (L(operation_enum, str, i3, 0)) {
            AEFilterManager aEFilterManager = this.D;
            if (aEFilterManager != null) {
                aEFilterManager.openAndUpdateBasicSoftLight(str, i3);
                g0(operation_enum);
            }
            l0(operation_enum);
        }
    }

    public void e0(boolean z16) {
        AEFilterManager aEFilterManager = this.D;
        if (aEFilterManager != null) {
            aEFilterManager.openBeautyEnable(z16);
        }
    }

    public void f0(String str) {
        AEFilterManager aEFilterManager = this.D;
        if (aEFilterManager != null) {
            aEFilterManager.openFaceThinEnable(str);
        }
    }

    @Override // com.tencent.aelight.camera.ae.camera.filter.FilterProcessBase
    public void i() {
        D();
    }

    public synchronized void j0() {
        if (!TextUtils.isEmpty(this.S)) {
            this.V.add(this.S);
        }
    }

    @Override // com.tencent.aelight.camera.ae.camera.filter.FilterProcessBase
    public boolean k() {
        return super.k() && X();
    }

    public void k0() {
        if (R() != null) {
            VideoMaterial loadLightAsset = VideoMaterial.loadLightAsset(R().getDataPath());
            if (com.tencent.aelight.camera.ae.d.f(loadLightAsset)) {
                ms.a.f("AEFilterProcessTex", "recoverLastEffect---id=" + loadLightAsset.getId());
                if (loadLightAsset.isWatermarkMaterial()) {
                    ms.a.f("AEFilterProcessTex", "recoverLastEffect---is an editable watermark material");
                    e eVar = this.X;
                    if (eVar != null) {
                        eVar.recover(loadLightAsset);
                    }
                } else {
                    this.D.updateMaterialGL(loadLightAsset);
                    g0(AIOOperationUpdater.OPERATION_ENUM.MATERIAL_OPERATION);
                    String id5 = loadLightAsset.getId();
                    this.S = id5;
                    String str = f62230t0;
                    if (str != null && str.equals(id5)) {
                        this.D.setCustomMaterial(f62231u0);
                    }
                }
            }
        } else {
            this.D.updateMaterialGL(null);
            g0(AIOOperationUpdater.OPERATION_ENUM.MATERIAL_OPERATION);
        }
        if (f62229s0 && this.D.isInited()) {
            O0(f62229s0);
        }
        int i3 = f62226p0;
        if (i3 > 0) {
            this.D.setSmoothLevel(i3);
        }
        int i16 = f62227q0;
        if (i16 > 0) {
            G0(i16);
        }
    }

    @Override // com.tencent.aelight.camera.ae.camera.filter.FilterProcessBase
    public void m() {
        if (this.D == null || R() == null || this.D.getVideoMaterial() == null || !this.D.getVideoMaterial().needResetWhenRecord()) {
            return;
        }
        this.D.stickerReset(true);
    }

    public int m0(int i3) {
        return this.L.c(new Frame(-1, i3, this.f62257i, this.f62258j)).getTextureId();
    }

    public void o0(d dVar) {
        this.P = dVar;
    }

    public void p0() {
        AEFilterManager aEFilterManager = this.D;
        if (aEFilterManager != null) {
            aEFilterManager.setAudioPause();
        }
    }

    public void q0() {
        AEFilterManager aEFilterManager = this.D;
        if (aEFilterManager != null) {
            aEFilterManager.setAudioStart();
        }
    }

    public void r0(BeautyRealConfig.TYPE type, int i3) {
        AEFilterManager aEFilterManager = this.D;
        if (aEFilterManager != null) {
            aEFilterManager.setBeautyOrTransformLevel(type, i3);
        }
    }

    public void s0(String str, String str2) {
        f62230t0 = str;
        f62231u0 = str2;
        AEFilterManager aEFilterManager = this.D;
        if (aEFilterManager != null) {
            aEFilterManager.setCustomMaterial(str2);
        }
    }

    public void t0(e eVar) {
        this.X = eVar;
    }

    @Override // com.tencent.aelight.camera.ae.camera.filter.FilterProcessBase
    public void u(float f16) {
        AEFilterManager aEFilterManager = this.D;
        if (aEFilterManager != null) {
            aEFilterManager.setPhoneRoll(f16);
        }
    }

    @Override // com.tencent.aelight.camera.ae.camera.filter.FilterProcessBase
    public void v(int i3, int i16, int i17, int i18, int i19, int i26) {
        if (j()) {
            W0(i3, i16, i17, i18, i19, i26);
        } else {
            super.v(i3, i16, i17, i18, i19, i26);
        }
        AEFilterManager aEFilterManager = this.D;
        if (aEFilterManager != null) {
            aEFilterManager.updateWidthHeight(this.f62253e, this.f62254f);
        }
    }

    public void v0(AECameraGLSurfaceView.AEGenderTypeListener aEGenderTypeListener) {
        this.f62233a0 = aEGenderTypeListener;
    }

    public void w0(boolean z16) {
        AEFilterManager aEFilterManager = this.D;
        if (aEFilterManager != null) {
            aEFilterManager.setIsAfterUpdateMaterial(z16);
        }
    }

    public void z0(OnLoadAssetListener onLoadAssetListener) {
        ms.a.a("AEFilterProcessTex", "setLightNodeLightAssetListener: " + onLoadAssetListener);
        this.Z = onLoadAssetListener;
    }

    public void K0(VideoMaterial videoMaterial) {
        L0(videoMaterial, false);
    }

    @Override // com.tencent.aelight.camera.ae.camera.filter.FilterProcessBase
    public void d(boolean z16) {
        f62226p0 = 0;
        f62227q0 = 0;
        f62229s0 = false;
        if (z16) {
            y0(null);
        }
    }

    private int N(int i3, int i16, int i17, int i18, int i19) {
        if (i18 * i17 == i19 * i16) {
            return i3;
        }
        this.K.updateCorpRect(i18, i19, i16, i17);
        return this.K.RenderProcess(i3, i16, i17, i18, i19).getTextureId();
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0284  */
    @Override // com.tencent.aelight.camera.ae.camera.filter.FilterProcessBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int[] s(int i3, int i16, boolean z16) {
        int i17;
        int i18;
        int i19;
        com.tencent.aelight.camera.ae.camera.autotest.a aVar;
        String str;
        AEFilterManager aEFilterManager;
        Frame Z;
        if (!k()) {
            int[] iArr = this.f62266r;
            iArr[0] = 0;
            iArr[1] = 0;
            return iArr;
        }
        I();
        boolean z17 = this.f62268t;
        this.G.updateMatrix(this.f62267s);
        Frame RenderProcess = this.G.RenderProcess(this.f62264p, this.f62255g, this.f62256h);
        boolean z18 = eq.a.f396953f;
        if (z18 && (Z = Z()) != null) {
            RenderProcess = Z;
        }
        if (!z18 && z17 && F()) {
            AEDashboardUtil.f62611d.f62645o = true;
            this.f62253e = this.f62249a;
            this.f62254f = this.f62250b;
        }
        if (this.f62234b0 != null && (aEFilterManager = this.D) != null) {
            List<WMElement> wmGetEditableWMElements = aEFilterManager.wmGetEditableWMElements();
            if (wmGetEditableWMElements != null && !wmGetEditableWMElements.isEmpty()) {
                Iterator<WMElement> it = wmGetEditableWMElements.iterator();
                while (it.hasNext()) {
                    it.next().setText(this.f62234b0);
                }
                ms.a.f("AEFilterProcessTex", "apply watermark text success: " + this.f62234b0);
                this.f62234b0 = null;
            } else {
                ms.a.c("AEFilterProcessTex", "try apply watermark text, but found no WMElements");
            }
        }
        if (z18) {
            i18 = this.f62255g;
            i17 = this.f62256h;
        } else {
            int[] E = E(this.f62253e / this.f62254f);
            int i26 = E[0];
            i17 = E[1];
            i18 = i26;
        }
        this.K.updateCorpRect(i18, i17, this.f62255g, this.f62256h);
        Frame RenderProcess2 = this.K.RenderProcess(RenderProcess.getTextureId(), this.f62253e, this.f62254f);
        RenderProcess.unlock();
        if (X()) {
            try {
                PTFaceAttr notifyDetectFaceAttr = this.D.notifyDetectFaceAttr();
                int i27 = -1;
                if (notifyDetectFaceAttr != null) {
                    List<Integer> genderList = notifyDetectFaceAttr.getGenderList();
                    if (genderList != null && genderList.size() > 0) {
                        Integer num = genderList.get(0);
                        if (this.f62233a0 != null && num.intValue() > 0) {
                            this.f62233a0.onGenderTypeListener(num.intValue());
                            if (!this.N.p()) {
                                if (this.f62238f0) {
                                    LogUtils.i("AEFilterProcessTex", "genderType:" + num);
                                    this.D.switchAbilityInLightNode(LightConstants.DetectSwitchKey.AI_FACE_STATIC_FEATURE_ENABLE, false);
                                    this.f62238f0 = false;
                                } else if (this.f62239g0) {
                                    LogUtils.i("AEFilterProcessTex", "set genderType: NONE...");
                                    this.D.switchAIAbility(LightConstants.DetectSwitchKey.AI_FACE_STATIC_FEATURE_ENABLE, "none");
                                    this.f62239g0 = false;
                                }
                            }
                        }
                    }
                    List<FaceStatus> faceStatusList = notifyDetectFaceAttr.getFaceStatusList();
                    if (faceStatusList != null && !faceStatusList.isEmpty()) {
                        i27 = faceStatusList.size() > 1 ? 3 : notifyDetectFaceAttr.getFaceStatusList().get(0).gender;
                    }
                    AEBaseReportParam.U().k1(i27);
                } else {
                    AEBaseReportParam.U().k1(-1);
                }
                if (notifyDetectFaceAttr != null && !this.O) {
                    List<Integer> genderList2 = notifyDetectFaceAttr.getGenderList();
                    List<Integer> ageList = notifyDetectFaceAttr.getAgeList();
                    if (genderList2 != null && ageList != null && genderList2.size() == ageList.size() && genderList2.size() > 0 && genderList2.get(0).intValue() != 0) {
                        this.O = true;
                        d dVar = this.P;
                        if (dVar != null) {
                            dVar.a(genderList2, ageList);
                        }
                    }
                }
            } catch (Throwable th5) {
                QLog.d("AEFilterProcessTex", 1, "AEKit \u6e32\u67d3 start Throwable = " + th5.getMessage());
            }
        }
        int textureId = RenderProcess2.getTextureId();
        if (this.D != null) {
            if (!this.T) {
                tq.b.h().o(IAELaunchRecorder.MILESTONE_FILTER_MGR_DRAW_BEGIN);
            }
            HashMap hashMap = new HashMap();
            if (z16) {
                str = "1";
            } else {
                str = "0";
            }
            if (!str.equals(this.f62237e0)) {
                this.f62237e0 = str;
                hashMap.put("transparentMode", str);
            }
            this.D.updateCameraConfigData(hashMap);
            if (com.tencent.aelight.camera.ae.d.n()) {
                textureId = this.D.drawFrame(RenderProcess2.getTextureId(), z17, this.f62265q.getTimestamp());
            }
            if (!this.T) {
                tq.b.h().o(IAELaunchRecorder.MILESTONE_FILTER_MGR_DRAW_END);
                this.T = true;
            }
            RenderProcess2.unlock();
        }
        if (z18 && (aVar = this.f62235c0) != null) {
            aVar.g(textureId, this.f62253e, this.f62254f);
        }
        if (j()) {
            int i28 = this.f62254f;
            int i29 = i28 * i3;
            int i36 = this.f62253e;
            int i37 = i36 * i16;
            if (i29 > i37) {
                i19 = N(textureId, i36, i28, i36, i37 / i3);
            } else if (i29 < i37) {
                i19 = N(textureId, i36, i28, i29 / i16, i28);
            }
            n0(i3, i16, i19, z16);
            if (z17) {
                QLog.d("AEFilterProcessTex", 1, "in capture frame.");
                G(textureId, this.f62253e, this.f62254f);
                this.f62268t = false;
            }
            FrameBufferCache.getInstance().forceRecycle();
            if (this.f62263o) {
                this.H.setRotationAndFlip(0, 0, 1);
                if (j()) {
                    int i38 = this.f62253e;
                    int i39 = this.f62254f;
                    int[] iArr2 = this.f62262n;
                    int N = N(textureId, i38, i39, iArr2[0], iArr2[1]);
                    BaseFilter baseFilter = this.H;
                    int[] iArr3 = this.f62262n;
                    baseFilter.RenderProcess(N, iArr3[0], iArr3[1], -1, 0.0d, this.F);
                } else {
                    this.H.RenderProcess(textureId, this.f62253e, this.f62254f, -1, 0.0d, this.F);
                }
                this.H.setRotationAndFlip(0, 0, 0);
            }
            int[] iArr4 = this.f62266r;
            iArr4[0] = textureId;
            iArr4[1] = this.F.getTextureId();
            tq.d.d();
            return this.f62266r;
        }
        i19 = textureId;
        n0(i3, i16, i19, z16);
        if (z17) {
        }
        FrameBufferCache.getInstance().forceRecycle();
        if (this.f62263o) {
        }
        int[] iArr42 = this.f62266r;
        iArr42[0] = textureId;
        iArr42[1] = this.F.getTextureId();
        tq.d.d();
        return this.f62266r;
    }

    private void n0(int i3, int i16, int i17, boolean z16) {
        int i18;
        if (z16) {
            GLES20.glClearColor(0.92f, 0.93f, 0.96f, 1.0f);
            GLES20.glClear(16384);
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(MiniReportManager.EventId.SDK_EMBEDDED_VIDEO, MiniReportManager.EventId.SDK_EMBEDDED_LIVE_PLAYER);
            FrameUtil.clearFrame(this.E, 0.0f, 0.0f, 0.0f, 0.0f, i3, i16);
            this.I.RenderProcess(i17, i3, i3, -1, 0.0d, this.E);
            i18 = this.E.getTextureId();
        } else {
            i18 = i17;
        }
        this.J.setRotationAndFlip(0, 0, 1);
        this.J.RenderProcess(i18, i3, i16, 0, 0.0d, this.E);
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
            Log.d("AEFilterProcessTex", "OnAssetProcessing: " + hashMap);
            if (AEFilterProcessTex.this.Z != null) {
                AEFilterProcessTex.this.Z.OnAssetProcessing(hashMap);
            }
        }

        @Override // org.light.listener.OnLoadAssetListener
        public void OnLoadAssetError(int i3) {
            Log.d("AEFilterProcessTex", "OnLoadAssetError: " + i3);
            if (AEFilterProcessTex.this.Z != null) {
                AEFilterProcessTex.this.Z.OnLoadAssetError(i3);
            }
        }

        @Override // org.light.listener.OnLoadAssetListener
        public void OnAssetDurationChange(long j3) {
        }
    }
}
