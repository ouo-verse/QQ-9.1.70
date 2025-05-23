package com.tencent.mobileqq.qqlive.anchor.beauty.processor;

import android.content.Context;
import android.net.TrafficStats;
import android.opengl.GLES20;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.aelight.camera.filament.api.IZplanFilamentProvider;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.anchor.beauty.f;
import com.tencent.mobileqq.qqlive.anchor.beauty.processor.TemplateRenderStrategy;
import com.tencent.mobileqq.qqlive.data.trtc.QQLiveVideoBaseFrame;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qcircle.weishi.module.publisher.entity.TemplateBean;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.xweb.pinus.ChildProcessServiceWrapper;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.light.AudioOutput;
import org.light.CameraConfig;
import org.light.CameraController;
import org.light.Config;
import org.light.LightAsset;
import org.light.LightConstants;
import org.light.LightEngine;
import org.light.LightSurface;
import org.light.RendererConfig;
import org.light.VideoOutput;
import org.light.listener.OnTipsStatusListener;
import org.light.utils.FileUtils;
import org.light.utils.LightLogUtil;

/* compiled from: P */
/* loaded from: classes17.dex */
public class b implements OnTipsStatusListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private int f270426a;

    /* renamed from: b, reason: collision with root package name */
    private int f270427b;

    /* renamed from: c, reason: collision with root package name */
    private int f270428c;

    /* renamed from: d, reason: collision with root package name */
    private int f270429d;

    /* renamed from: e, reason: collision with root package name */
    private int f270430e;

    /* renamed from: f, reason: collision with root package name */
    private LightSurface f270431f;

    /* renamed from: g, reason: collision with root package name */
    private LightEngine f270432g;

    /* renamed from: h, reason: collision with root package name */
    private CameraConfig f270433h;

    /* renamed from: i, reason: collision with root package name */
    private LightAsset f270434i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f270435j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f270436k;

    /* renamed from: l, reason: collision with root package name */
    private String f270437l;

    /* renamed from: m, reason: collision with root package name */
    private String f270438m;

    /* renamed from: n, reason: collision with root package name */
    private CameraController f270439n;

    /* renamed from: o, reason: collision with root package name */
    private VideoOutput f270440o;

    /* renamed from: p, reason: collision with root package name */
    private AudioOutput f270441p;

    /* renamed from: q, reason: collision with root package name */
    private int f270442q;

    /* renamed from: r, reason: collision with root package name */
    private a f270443r;

    /* renamed from: s, reason: collision with root package name */
    private long f270444s;

    /* renamed from: t, reason: collision with root package name */
    private volatile boolean f270445t;

    /* renamed from: u, reason: collision with root package name */
    private c f270446u;

    /* renamed from: v, reason: collision with root package name */
    private com.tencent.mobileqq.qqlive.anchor.beauty.utils.c f270447v;

    /* renamed from: w, reason: collision with root package name */
    private final e f270448w;

    /* renamed from: x, reason: collision with root package name */
    private TemplateRenderStrategy.TemplateType f270449x;

    public b(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f270426a = 0;
        this.f270427b = 0;
        this.f270428c = 0;
        this.f270429d = 0;
        this.f270430e = -1;
        this.f270442q = -1;
        this.f270445t = false;
        this.f270447v = new com.tencent.mobileqq.qqlive.anchor.beauty.utils.c();
        this.f270448w = new e();
        TrafficStats.setThreadStatsTag(-255);
        LightEngine.initAuth(context, null, "lightsdk_qq", "qq_live");
    }

    private void b() {
        AegisLogger.i("Open_Live|LightSdkProcessor", "initInternal", "initLightSDK start");
        e();
        d();
        c();
        l();
        h();
        g();
        j();
        this.f270445t = true;
        AegisLogger.i("Open_Live|LightSdkProcessor", "initInternal", "initLightSDK end");
    }

    private void c() {
        if (this.f270431f != null) {
            String lightSDKBaseResUnzipFinalPath = ((IAEResUtil) QRoute.api(IAEResUtil.class)).getLightSDKBaseResUnzipFinalPath();
            RendererConfig rendererConfig = new RendererConfig(lightSDKBaseResUnzipFinalPath + "assets/");
            rendererConfig.bundlePath = lightSDKBaseResUnzipFinalPath + "assets/";
            LightEngine make = LightEngine.make(null, null, rendererConfig);
            this.f270432g = make;
            make.setSurface(this.f270431f);
            CameraConfig make2 = CameraConfig.make();
            this.f270433h = make2;
            this.f270432g.setConfig(make2);
            this.f270433h.setDefaultBeautyVersion(LightConstants.DefaultBeautyVersion.DEFAULT_BEAUTY_VERSION_V8);
            this.f270440o = this.f270432g.videoOutput();
            this.f270441p = this.f270432g.audioOutput();
            AegisLogger.i("Open_Live|LightSdkProcessor", "initLightEngine", "initLightEngine end, renderConfig.bundlePath:" + rendererConfig.bundlePath);
            return;
        }
        throw new RuntimeException("initLightEngine fail, lightSurface is null!");
    }

    private void d() {
        if (this.f270428c > 0 && this.f270429d > 0) {
            if (this.f270430e == -1) {
                this.f270430e = d.c();
            }
            this.f270431f = LightSurface.makeFromTexture(this.f270430e, this.f270428c, this.f270429d);
            AegisLogger.i("Open_Live|LightSdkProcessor", "initLightRenderTexture", "initLightRenderTexture end, renderTexture:" + this.f270430e + "mOutputWidth:" + this.f270428c + "mOutputHeight:" + this.f270429d);
            return;
        }
        throw new RuntimeException("initLightRenderTexture fail, invalid outputWidth or outputHeight!");
    }

    private void e() {
        LightLogUtil.init(com.tencent.mobileqq.qqlive.anchor.beauty.utils.a.a());
        AegisLogger.i("Open_Live|LightSdkProcessor", "initLightSdkLogUtil", "initLightSdkLogUtil end");
    }

    private void g() {
        if (this.f270433h == null) {
            AegisLogger.e("Open_Live|LightSdkProcessor", "loadDefaultConfig", "initDefaultConfig fail, cameraConfig is null");
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(Config.ConfigKeys.ResourceDir.value(), ((IAEResUtil) QRoute.api(IAEResUtil.class)).getLightSDKBaseResUnzipFinalPath());
        hashMap.put(LightConstants.ReshapeConfigKey.RESHAPE_BASIC_FACE_SUB_TYPE_UNIFORM, "nature");
        hashMap.put("smooth.sharpen", String.valueOf(0.7f));
        hashMap.put("basicLUT.enable", String.valueOf(true));
        hashMap.put("materialLUT.enable", String.valueOf(true));
        this.f270433h.setConfigData(hashMap);
        this.f270433h.setDetectShorterEdgeLength(180, "");
        this.f270433h.setRenderSize(this.f270428c, this.f270429d);
        this.f270433h.setCameraTexture(this.f270442q, this.f270426a, this.f270427b, CameraConfig.DeviceCameraOrientation.ROTATION_0, CameraConfig.ImageOrigin.TopLeft);
        this.f270433h.setTipsStatusListener(this);
        AegisLogger.i("Open_Live|LightSdkProcessor", "loadDefaultConfig", "initDefaultConfig end");
    }

    private void h() {
        if (this.f270433h == null) {
            AegisLogger.e("Open_Live|LightSdkProcessor", "loadDefaultTemplate", "loadDefaultTemplate fail, cameraConfig is null");
            return;
        }
        String lightEmptyMaterialConfigPath = ((IAEResUtil) QRoute.api(IAEResUtil.class)).getLightEmptyMaterialConfigPath();
        this.f270438m = lightEmptyMaterialConfigPath;
        if (!TextUtils.equals(this.f270437l, lightEmptyMaterialConfigPath)) {
            AegisLogger.i("Open_Live|LightSdkProcessor", "loadDefaultTemplate", "loadDefaultTemplate path:" + this.f270438m);
            i(this.f270438m, TemplateRenderStrategy.TemplateType.BASE);
        }
        AegisLogger.i("Open_Live|LightSdkProcessor", "loadDefaultTemplate", "loadDefaultTemplate end");
    }

    private void i(String str, TemplateRenderStrategy.TemplateType templateType) {
        String str2;
        if (!str.contains(TemplateBean.TEMPLATE_JSON)) {
            str2 = str + File.separator + TemplateBean.TEMPLATE_JSON;
        } else {
            str2 = str;
        }
        if (!FileUtils.exists(str2)) {
            AegisLogger.e("Open_Live|LightSdkProcessor", "loadTemplate", "template does not exist fullTemplatePath = " + str2);
            return;
        }
        LightAsset Load = LightAsset.Load(str2, 0);
        if (Load == null) {
            AegisLogger.e("Open_Live|LightSdkProcessor", "loadTemplate", "newLightAsset is null");
            return;
        }
        if (Load.getErrorCode() != 0) {
            AegisLogger.e("Open_Live|LightSdkProcessor", "loadTemplate", "newLightAsset:" + Load + ", errorCode:" + Load.getErrorCode());
            Load.performFinalize();
            return;
        }
        LightAsset lightAsset = this.f270434i;
        if (lightAsset != null) {
            lightAsset.performFinalize();
        }
        this.f270434i = Load;
        this.f270436k = Load.hasLut();
        this.f270439n = this.f270432g.setAssetForCamera(this.f270434i);
        this.f270449x = templateType;
        this.f270447v.b();
        this.f270437l = str;
    }

    private void j() {
        boolean isFilamentReady = ((IZplanFilamentProvider) QRoute.api(IZplanFilamentProvider.class)).isFilamentReady();
        if (!isFilamentReady) {
            ((IZplanFilamentProvider) QRoute.api(IZplanFilamentProvider.class)).registerFilamentDownloader(null);
        }
        AegisLogger.i("Open_Live|LightSdkProcessor", "registerFilament", "isFilamentReady: " + isFilamentReady);
    }

    private void l() {
        AegisLogger.i("Open_Live|LightSdkProcessor", "setAiModelPath", "setAiModelPath  mLightAsset:" + this.f270434i);
        Map<AEResInfo, Boolean> a16 = f.a();
        for (AEResInfo aEResInfo : a16.keySet()) {
            if (a16.get(aEResInfo).booleanValue()) {
                this.f270433h.setLightAIModelPath(((IAEResUtil) QRoute.api(IAEResUtil.class)).getLightBundleDir(aEResInfo.agentType), aEResInfo.agentType);
                if ("k3D_MM_AGENT".equals(aEResInfo.agentType)) {
                    this.f270433h.setLightAIModelPath(((IAEResUtil) QRoute.api(IAEResUtil.class)).getLightBundleDir(aEResInfo.agentType), "kZPLAN_AGENT");
                    this.f270433h.setLightAIModelPath(((IAEResUtil) QRoute.api(IAEResUtil.class)).getLightBundleDir(aEResInfo.agentType), "k3D_MM_AGENT_V2");
                }
            }
        }
    }

    private void n(TemplateRenderStrategy.TemplateType templateType, TemplateRenderStrategy.TemplateType templateType2) {
        a aVar = this.f270443r;
        if (aVar != null && templateType == TemplateRenderStrategy.TemplateType.PROP && templateType2 == TemplateRenderStrategy.TemplateType.MAKEUP) {
            aVar.B("\u9700\u53d6\u6d88\u5f53\u524d\u9053\u5177\u6548\u679c");
        }
    }

    public void a(QQLiveVideoBaseFrame qQLiveVideoBaseFrame, QQLiveVideoBaseFrame qQLiveVideoBaseFrame2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) qQLiveVideoBaseFrame, (Object) qQLiveVideoBaseFrame2);
            return;
        }
        if (this.f270428c != qQLiveVideoBaseFrame2.getWidth() || this.f270429d != qQLiveVideoBaseFrame2.getHeight()) {
            this.f270428c = qQLiveVideoBaseFrame2.getWidth();
            this.f270429d = qQLiveVideoBaseFrame2.getHeight();
        }
        if (this.f270442q != qQLiveVideoBaseFrame.getTextureId() || this.f270426a != qQLiveVideoBaseFrame.getWidth() || this.f270427b != qQLiveVideoBaseFrame.getHeight()) {
            this.f270426a = qQLiveVideoBaseFrame.getWidth();
            this.f270427b = qQLiveVideoBaseFrame.getHeight();
            this.f270446u = d.d(qQLiveVideoBaseFrame.getTextureId(), this.f270426a, this.f270427b);
        }
        c cVar = this.f270446u;
        if (cVar != null) {
            this.f270442q = cVar.b();
        }
        b();
    }

    public boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.f270445t;
    }

    public void k(QQLiveVideoBaseFrame qQLiveVideoBaseFrame, QQLiveVideoBaseFrame qQLiveVideoBaseFrame2) {
        c cVar;
        CameraConfig cameraConfig;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) qQLiveVideoBaseFrame, (Object) qQLiveVideoBaseFrame2);
            return;
        }
        this.f270444s = SystemClock.elapsedRealtimeNanos() / 1000;
        if (this.f270428c != qQLiveVideoBaseFrame2.getWidth() || this.f270429d != qQLiveVideoBaseFrame2.getHeight()) {
            this.f270428c = qQLiveVideoBaseFrame2.getWidth();
            this.f270429d = qQLiveVideoBaseFrame2.getHeight();
        }
        if (this.f270442q != qQLiveVideoBaseFrame.getTextureId() || this.f270426a != qQLiveVideoBaseFrame.getWidth() || this.f270427b != qQLiveVideoBaseFrame.getHeight()) {
            this.f270426a = qQLiveVideoBaseFrame.getWidth();
            this.f270427b = qQLiveVideoBaseFrame.getHeight();
            this.f270446u = d.d(qQLiveVideoBaseFrame.getTextureId(), this.f270426a, this.f270427b);
        }
        int i3 = this.f270442q;
        if (i3 >= 0 && (cVar = this.f270446u) != null && ((i3 != cVar.b() || this.f270426a != this.f270446u.c() || this.f270427b != this.f270446u.a()) && (cameraConfig = this.f270433h) != null)) {
            cameraConfig.setCameraTexture(this.f270446u.b(), this.f270446u.c(), this.f270446u.a(), CameraConfig.DeviceCameraOrientation.ROTATION_0, CameraConfig.ImageOrigin.TopLeft);
        }
        c cVar2 = this.f270446u;
        if (cVar2 != null) {
            this.f270442q = cVar2.b();
        }
        if (!this.f270445t) {
            b();
        }
        VideoOutput videoOutput = this.f270440o;
        if (videoOutput != null) {
            videoOutput.readSample(this.f270447v.a(this.f270444s));
            qQLiveVideoBaseFrame2.setTextureId(this.f270430e);
        } else {
            AegisLogger.e("Open_Live|LightSdkProcessor", ChildProcessServiceWrapper.PROCESS_TYPE_RENDER, "no output for surface, lightSdkProcessor:" + this);
        }
    }

    public void m(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        } else {
            this.f270443r = aVar;
        }
    }

    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        AegisLogger.i("Open_Live|LightSdkProcessor", "unInit", "unInit start");
        int i3 = this.f270430e;
        if (i3 != -1) {
            GLES20.glDeleteTextures(1, new int[]{i3}, 0);
            this.f270430e = -1;
        }
        AudioOutput audioOutput = this.f270441p;
        if (audioOutput != null) {
            audioOutput.release();
            this.f270441p = null;
        }
        VideoOutput videoOutput = this.f270440o;
        if (videoOutput != null) {
            videoOutput.release();
            this.f270440o = null;
        }
        CameraController cameraController = this.f270439n;
        if (cameraController != null) {
            cameraController.release();
            this.f270439n = null;
        }
        LightEngine lightEngine = this.f270432g;
        if (lightEngine != null) {
            lightEngine.release();
            this.f270432g = null;
        }
        LightSurface lightSurface = this.f270431f;
        if (lightSurface != null) {
            lightSurface.release();
            this.f270431f = null;
        }
        LightAsset lightAsset = this.f270434i;
        if (lightAsset != null) {
            lightAsset.performFinalize();
            this.f270434i = null;
        }
        CameraConfig cameraConfig = this.f270433h;
        if (cameraConfig != null) {
            cameraConfig.performFinalize();
            this.f270433h = null;
        }
        if (this.f270446u != null) {
            this.f270446u = null;
        }
        com.tencent.mobileqq.qqlive.anchor.beauty.utils.c cVar = this.f270447v;
        if (cVar != null) {
            cVar.b();
        }
        this.f270437l = null;
        this.f270445t = false;
        this.f270443r = null;
        AegisLogger.i("Open_Live|LightSdkProcessor", "unInit", "unInit end");
    }

    public void p(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str, (Object) str2);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(str, str2);
        this.f270433h.setConfigData(hashMap);
    }

    public void q(String str, String str2, String str3, String str4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, str, str2, str3, str4);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(str, str2);
        hashMap.put(str3, str4);
        this.f270433h.setConfigData(hashMap);
    }

    public void r(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) str, (Object) str2);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(Config.ConfigKeys.ResourceDir.value(), ((IAEResUtil) QRoute.api(IAEResUtil.class)).getLightSDKBaseResUnzipFinalPath());
        hashMap.put("lut.src", str);
        hashMap.put("lut.intensity", str2);
        this.f270433h.setConfigData(hashMap);
        this.f270435j = !TextUtils.isEmpty(str);
    }

    public void s(String str, String str2, TemplateRenderStrategy.TemplateType templateType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, str, str2, templateType);
            return;
        }
        TemplateRenderStrategy.a aVar = new TemplateRenderStrategy.a();
        aVar.f270423b = templateType;
        TemplateRenderStrategy.Strategy a16 = TemplateRenderStrategy.a(this.f270449x, templateType);
        aVar.f270422a = a16;
        aVar.f270424c = str;
        aVar.f270425d = str2;
        if (a16 == TemplateRenderStrategy.Strategy.ACTION_DO_NOTHING) {
            AegisLogger.i("Open_Live|LightSdkProcessor", "updateMakeup", "updateMakeup Strategy ACTION_DO_NOTHING, filePath:" + aVar.f270424c);
            n(this.f270449x, templateType);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            if (!this.f270437l.contains(this.f270438m)) {
                i(this.f270438m, TemplateRenderStrategy.TemplateType.BASE);
                return;
            }
            return;
        }
        if (!str.contains(TemplateBean.TEMPLATE_JSON)) {
            String str3 = File.separator;
            if (str.endsWith(str3)) {
                str = str + TemplateBean.TEMPLATE_JSON;
            } else {
                str = str + str3 + TemplateBean.TEMPLATE_JSON;
            }
        }
        if (TextUtils.equals(str, this.f270437l)) {
            t(str2);
        } else {
            i(str, aVar.f270423b);
            t(str2);
        }
    }

    public void t(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("makeup.strength", str);
        this.f270439n.setAssetData(hashMap);
    }

    @Override // org.light.listener.OnTipsStatusListener
    public void tipsNeedHide(String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, str, str2, Integer.valueOf(i3));
            return;
        }
        a aVar = this.f270443r;
        if (aVar != null) {
            aVar.D(str, str2, i3);
        }
    }

    @Override // org.light.listener.OnTipsStatusListener
    public void tipsNeedShow(String str, String str2, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, str2, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        a aVar = this.f270443r;
        if (aVar != null) {
            aVar.N(str, str2, i3, i16);
        }
    }

    public void u(MotionEvent motionEvent, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, motionEvent, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.f270448w.b(this.f270439n, motionEvent, i3, i16);
        }
    }

    public void v(MotionEvent motionEvent, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, motionEvent, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.f270448w.c(this.f270439n, motionEvent, i3, i16);
        }
    }
}
