package com.tencent.aelight.camera.ae;

import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.api.standard.AEModuleConfig;
import com.tencent.aekit.openrender.AEOpenRenderConfig;
import com.tencent.aelight.camera.ae.data.AEMaterialConfigParser;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.sveffects.SdkContext;
import com.tencent.ttpic.openapi.filter.LightNode;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.video.AECoderFactory;
import com.tencent.ttpic.video.AEDecoder;
import com.tencent.ttpic.video.AEEncoder;
import java.util.concurrent.Callable;
import mqq.app.AppRuntime;
import org.light.Config;
import org.light.DeviceSupportUtil;
import org.light.LightEngine;
import org.light.RendererConfig;
import org.light.device.OfflineConfig;
import org.light.utils.LightLogUtil;

/* compiled from: P */
/* loaded from: classes32.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f63494a = false;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f63495b = false;

    /* renamed from: c, reason: collision with root package name */
    private static volatile boolean f63496c = false;

    /* renamed from: d, reason: collision with root package name */
    private static Integer f63497d;

    /* renamed from: e, reason: collision with root package name */
    private static final LightEngine.SDKServiceCallback f63498e = new a();

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements LightEngine.SDKServiceCallback {
        a() {
        }

        @Override // org.light.LightEngine.SDKServiceCallback
        public void onServiceStarted(int i3) {
            ms.a.c("AEKitForQQ", "[onServiceStarted]: pid = " + i3);
            LightLogUtil.init(new rs.a());
            LightLogUtil.setMinPriority(6);
        }

        @Override // org.light.LightEngine.SDKServiceCallback
        public void onServiceCreateError(String str, boolean z16) {
            d.f63496c = false;
            ms.a.c("AEKitForQQ", "[onServiceCreateError]:" + str);
        }

        @Override // org.light.LightEngine.SDKServiceRuntimeErrorCallback
        public void onServiceRuntimeError(String str) {
            d.f63496c = false;
            ms.a.c("AEKitForQQ", "[onServiceRuntimeError]:" + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b implements AECoderFactory.AEDecoderFactory {
        b() {
        }

        @Override // com.tencent.ttpic.video.AECoderFactory.AEDecoderFactory
        public AEDecoder createDecoder(String str) {
            return new aq.a(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class c implements AECoderFactory.AEEncoderFactory {
        c() {
        }

        @Override // com.tencent.ttpic.video.AECoderFactory.AEEncoderFactory
        public AEEncoder createEncoder(String str, int i3, int i16) {
            return new aq.b(str, i3, i16);
        }
    }

    private static void d() {
        com.tencent.mobileqq.wink.editor.util.n.a(LightEngine.version(), new Callable() { // from class: com.tencent.aelight.camera.ae.b
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Boolean r16;
                r16 = d.r();
                return r16;
            }
        });
    }

    private static void e() {
        if (AEModule.getContext() == null) {
            ms.a.c("AEKitForQQ", "AEModule is not initialized, you are supposed to call AEKitForQQ.init first!");
            AEModule.setContext(BaseApplication.context);
        }
    }

    public static boolean f(VideoMaterial videoMaterial) {
        return FeatureManager.ensureMaterialSoLoaded(videoMaterial);
    }

    public static LightEngine.SDKServiceCallback g() {
        return f63498e;
    }

    public static boolean i(boolean z16, boolean z17) {
        ms.a.a("AEKitForQQ", "[init]");
        w(z17, "[init] peakLoadStatus = " + FeatureManager.Features.LIGHT_SDK.isFunctionReady());
        if (z16 && f63494a) {
            x(z17, " isInited = true");
            return true;
        }
        if (!z16 && f63495b) {
            x(z17, " isOnlySDKInited = true");
            return true;
        }
        if (!AEResUtil.U(AEResInfo.LIGHT_RES_FILAMENT)) {
            w(z17, "LIGHT_RES_FILAMENT not exit ");
            return false;
        }
        if (!AEResUtil.U(AEResInfo.LIGHT_RES_PAG)) {
            w(z17, "LIGHT_RES_PAG not exit ");
            return false;
        }
        if (!AEResUtil.U(AEResInfo.LIGHT_RES_BASE_PACKAGE)) {
            w(z17, "LIGHT_RES_BASE_PACKAGE not exit ");
            return false;
        }
        if (z16 && !AEResUtil.U(AEResInfo.AE_RES_BASE_PACKAGE)) {
            w(z17, "AE_RES_BASE_PACKAGE not exit ");
            return false;
        }
        LightNode.initResourcePath(AEResUtil.s(), AEResUtil.w());
        try {
            DeviceSupportUtil.init(AEResUtil.s());
        } catch (Throwable th5) {
            w(z17, "DeviceSupportUtil.init exception:" + th5.getMessage());
        }
        OfflineConfig.setAssetsPath(AEResUtil.s());
        if (!p()) {
            w(z17, "[init]sdk version Limited!");
            return false;
        }
        com.tencent.sveffects.a.b();
        String soPathDir = SdkContext.getInstance().getResources().getPtuFilterResource().getSoPathDir();
        ms.a.a("AEKitForQQ", "initAEKit modelPath = " + soPathDir);
        BaseApplication context = BaseApplication.getContext();
        AEOpenRenderConfig.setEnableStrictMode(false);
        FeatureManager.Features.LIGHT_SDK.setSoDirOverrideFeatureManager(AEResUtil.z());
        FeatureManager.Features.PAG.setSoDirOverrideFeatureManager(AEResUtil.z());
        ms.a.a("AEKitForQQ", "initAEKit SDK modelPath = " + AEResUtil.z());
        ms.a.f("AEKitForQQ", "AEModule initialize : " + AEModule.initialize(context, AEModuleConfig.newBuilder().setFilamentDir(AEResUtil.J(AEResInfo.LIGHT_RES_FILAMENT.agentType)).setPagDir(AEResUtil.J(AEResInfo.LIGHT_RES_PAG.agentType)).setLoadSo(false).setLutDir(soPathDir).setModelDir(soPathDir).setSoDir(soPathDir).setAuthMode(1).setEnableDebug(false).setFramebufferFetchEnable(false).setEnableResourceCheck(false).setEnableProfiler(false).setEnableDefaultBasic3(false).setEnableDataReport(o() ^ true).build()));
        AECoderFactory.setAEDecoder(new b());
        AECoderFactory.setAEEncoder(new c());
        AEMaterialConfigParser.f63515b = OfflineConfig.getPhonePerfLevel(context);
        ms.a.a("AEKitForQQ", "[init][material_downgrade] phoneLevel = " + AEMaterialConfigParser.f63515b);
        if (z16) {
            f63494a = true;
        } else {
            f63495b = true;
        }
        return true;
    }

    public static boolean n() {
        return FeatureManager.Features.LIGHT_SDK.isFunctionReady();
    }

    private static boolean o() {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        return runtime != null && (runtime instanceof QQAppInterface);
    }

    public static boolean p() {
        return AEModule.isAeKitSupportVersion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void q() {
        Config.cleanFileCacheFromRoot(RendererConfig.getDefaultFileCacheRootPath());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean r() throws Exception {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.c
            @Override // java.lang.Runnable
            public final void run() {
                d.q();
            }
        }, 64, null, true);
        return Boolean.TRUE;
    }

    public static boolean s() {
        e();
        boolean init = FeatureManager.Features.LIGHT_SDK.init();
        if (init) {
            d();
        }
        return init;
    }

    public static boolean t() {
        return FeatureManager.Features.LIGHT_SDK.isFunctionReady();
    }

    public static boolean u() {
        e();
        boolean loadBasicFeatures = FeatureManager.loadBasicFeatures();
        if (loadBasicFeatures) {
            d();
        }
        return loadBasicFeatures;
    }

    public static boolean v() {
        e();
        boolean z16 = FeatureManager.Features.LIGHT_SDK.init() && FeatureManager.Features.PAG.init();
        if (z16) {
            d();
        }
        return z16;
    }

    public static void y() {
        Integer num;
        if (!f63496c || (num = f63497d) == null) {
            return;
        }
        SystemMethodProxy.killProcess(num.intValue());
    }

    public static boolean h() {
        return i(true, true);
    }

    public static boolean j() {
        return k(true);
    }

    public static boolean k(boolean z16) {
        return i(true, z16);
    }

    public static boolean m(boolean z16) {
        return i(false, z16);
    }

    public static boolean l() {
        return i(false, true);
    }

    public static void w(boolean z16, String str) {
        if (z16) {
            ms.a.c("AEKitForQQ", str);
        }
    }

    public static void x(boolean z16, String str) {
        if (z16) {
            ms.a.f("AEKitForQQ", str);
        }
    }
}
