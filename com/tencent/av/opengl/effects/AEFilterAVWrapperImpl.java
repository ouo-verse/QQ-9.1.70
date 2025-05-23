package com.tencent.av.opengl.effects;

import android.text.TextUtils;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.aelight.camera.api.IAEMaterialManager;
import com.tencent.aelight.camera.api.IAEQQFilamentManager;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.av.opengl.effects.c;
import com.tencent.av.zplan.avatar.resmgr.AVAvatarResMgr;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.shortvideo.filter.QQPtColorFilter;
import com.tencent.mobileqq.shortvideo.filter.QQPtColorFilterInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sveffects.SdkContext;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.filter.LightNode;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.light.CameraConfig;
import org.light.DeviceCameraConfig;
import org.light.LightConstants;
import org.light.avatar.AvatarAIInfo;
import org.light.listener.OnLoadAssetListener;
import org.light.utils.LightLogUtil;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AEFilterAVWrapperImpl implements com.tencent.av.opengl.effects.a {

    /* renamed from: a, reason: collision with root package name */
    private volatile int f73874a;

    /* renamed from: b, reason: collision with root package name */
    private int f73875b = 0;

    /* renamed from: c, reason: collision with root package name */
    private int f73876c = 0;

    /* renamed from: d, reason: collision with root package name */
    private AEFilterManager f73877d = null;

    /* renamed from: e, reason: collision with root package name */
    private final c f73878e;

    /* renamed from: f, reason: collision with root package name */
    private final c f73879f;

    /* renamed from: g, reason: collision with root package name */
    private final List<c.a> f73880g;

    /* renamed from: h, reason: collision with root package name */
    private FilterDesc f73881h;

    /* renamed from: i, reason: collision with root package name */
    private PendantItem f73882i;

    /* renamed from: j, reason: collision with root package name */
    private VideoMaterial f73883j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f73884k;

    /* renamed from: l, reason: collision with root package name */
    private int f73885l;

    /* renamed from: m, reason: collision with root package name */
    private int f73886m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f73887n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f73888o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f73889p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f73890q;

    /* renamed from: r, reason: collision with root package name */
    private List<String> f73891r;

    /* renamed from: s, reason: collision with root package name */
    private o f73892s;

    /* renamed from: t, reason: collision with root package name */
    private b f73893t;

    /* renamed from: u, reason: collision with root package name */
    private MyLightAssetListener f73894u;

    /* renamed from: v, reason: collision with root package name */
    private a f73895v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f73896w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f73897x;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class b implements LightNode.ILightNodeTipsListener {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<AEFilterAVWrapperImpl> f73899a;

        b(AEFilterAVWrapperImpl aEFilterAVWrapperImpl) {
            this.f73899a = new WeakReference<>(aEFilterAVWrapperImpl);
        }

        private void a(String str) {
            if (this.f73899a.get() == null) {
                return;
            }
            ag.e().h();
            if (QLog.isColorLevel()) {
                QLog.i("AEFilterAVWrapperImpl", 2, "hideGestureTips, from[" + str + "]");
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0031  */
        /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void b(String str, String str2) {
            String str3;
            String str4;
            AEFilterAVWrapperImpl aEFilterAVWrapperImpl = this.f73899a.get();
            if (aEFilterAVWrapperImpl != null) {
                PendantItem pendantItem = aEFilterAVWrapperImpl.f73882i;
                if (pendantItem != null) {
                    str3 = pendantItem.getGestureType();
                    if (TextUtils.isEmpty(str2)) {
                        str4 = pendantItem.getGestureWording();
                        ag.e().o(str4, str3);
                        if (!QLog.isColorLevel()) {
                            QLog.i("AEFilterAVWrapperImpl", 2, "showGestureTips, wording[" + str2 + "], gestureType[" + str3 + "], gestureWording[" + str4 + "], from[" + str + "]");
                            return;
                        }
                        return;
                    }
                } else {
                    str3 = "";
                }
                str4 = str2;
                ag.e().o(str4, str3);
                if (!QLog.isColorLevel()) {
                }
            }
        }

        @Override // com.tencent.ttpic.openapi.filter.LightNode.ILightNodeTipsListener
        public void onHideNormalTip() {
            a("onHideNormalTip");
        }

        @Override // com.tencent.ttpic.openapi.filter.LightNode.ILightNodeTipsListener
        public void onHidePagTip() {
            a("onHidePagTip");
        }

        @Override // com.tencent.ttpic.openapi.filter.LightNode.ILightNodeTipsListener
        public void onShowNormalTip(String str, String str2, int i3) {
            b("onShowNormalTip", str);
        }

        @Override // com.tencent.ttpic.openapi.filter.LightNode.ILightNodeTipsListener
        public void onShowPagTip(String str, int i3) {
            b("onShowPagTip", str);
        }
    }

    public AEFilterAVWrapperImpl(int i3) {
        c cVar = new c();
        this.f73878e = cVar;
        c cVar2 = new c();
        this.f73879f = cVar2;
        this.f73880g = new ArrayList(11);
        this.f73881h = null;
        this.f73882i = null;
        this.f73883j = null;
        this.f73884k = false;
        this.f73885l = 0;
        this.f73887n = false;
        this.f73888o = false;
        this.f73889p = false;
        this.f73890q = false;
        this.f73891r = new ArrayList();
        this.f73892s = null;
        this.f73897x = false;
        if (QLog.isColorLevel()) {
            QLog.i("AEFilterAVWrapperImpl", 2, "AEFilterAVWrapperImpl, mode[" + i3 + "]");
        }
        this.f73874a = 0;
        this.f73886m = i3;
        if (i3 == 1) {
            this.f73889p = false;
            this.f73888o = false;
            this.f73887n = false;
        }
        if (i3 == 2) {
            this.f73897x = true;
        }
        this.f73893t = new b(this);
        this.f73894u = new MyLightAssetListener();
        this.f73895v = new a();
        cVar.a();
        cVar2.a();
        this.f73896w = com.tencent.av.ui.f.d();
        A(1);
        LogUtils.setEnable(true);
    }

    private void A(int i3) {
        if (this.f73874a >= 1) {
            return;
        }
        boolean f16 = AEFilterSupport.f(i3);
        if (f16 && this.f73874a < 1) {
            this.f73874a = 1;
            LightLogUtil.init(new com.tencent.av.utils.a());
            LightLogUtil.setMinPriority(6);
        }
        if (i3 != 0 && QLog.isColorLevel()) {
            QLog.i("AEFilterAVWrapperImpl", 2, "prepare ret[" + f16 + "], state[" + this.f73874a + "], flag[" + i3 + "]");
        }
    }

    private void B() {
        if (this.f73877d == null) {
            return;
        }
        for (Map.Entry<String, String> entry : ((IAEResUtil) QRoute.api(IAEResUtil.class)).getLightBundleMap().entrySet()) {
            String value = entry.getValue();
            String key = entry.getKey();
            QLog.d("AEFilterAVWrapperImpl", 2, "[prepareBundleToLight] agentType:" + key + " | dir:" + value);
            this.f73877d.setLightBundle(value, key);
        }
        if (this.f73897x) {
            String w3 = AVAvatarResMgr.v().w("LightFaceModelLowVersion");
            String s16 = AVAvatarResMgr.v().s("LightFaceModelLowVersion");
            this.f73877d.setLightBundle(w3, s16);
            QLog.d("AEFilterAVWrapperImpl", 1, "[prepareBundleToLight] agentType:" + s16 + " | dir:" + w3);
            String w16 = AVAvatarResMgr.v().w("AEKit3DMMLowVersion");
            String s17 = AVAvatarResMgr.v().s("AEKit3DMMLowVersion");
            this.f73877d.setLightBundle(w16, s17);
            QLog.d("AEFilterAVWrapperImpl", 1, "[prepareBundleToLight] agentType:" + s17 + " | dir:" + w16);
            String w17 = AVAvatarResMgr.v().w("LightResBody3DModel");
            String s18 = AVAvatarResMgr.v().s("LightResBody3DModel");
            this.f73877d.setLightBundle(w17, s18);
            QLog.d("AEFilterAVWrapperImpl", 1, "[prepareBundleToLight] agentType:" + s18 + " | dir:" + w17);
        }
    }

    private void C(boolean z16, boolean z17) {
        AEFilterManager aEFilterManager;
        boolean z18;
        if (this.f73886m == 1 || (aEFilterManager = this.f73877d) == null) {
            return;
        }
        if (this.f73887n != z16) {
            this.f73887n = z16;
            aEFilterManager.switchAbilityInLightNode("beauty.enable", z16);
            if (QLog.isDevelopLevel()) {
                QLog.i("AEFilterAVWrapperImpl", 4, "updateBeautyFilter, isBeautyActive[" + z16 + "]");
            }
        }
        if (this.f73888o != z17) {
            this.f73888o = z17;
            aEFilterManager.switchAbilityInLightNode("transform.enable", z17);
            if (QLog.isDevelopLevel()) {
                QLog.i("AEFilterAVWrapperImpl", 4, "updateBeautyFilter, isTransformActive[" + z17 + "]");
            }
        }
        if (!z16 && !z17 && this.f73882i == null && this.f73881h == null && this.f73883j == null && !this.f73884k) {
            z18 = false;
        } else {
            z18 = true;
        }
        if (this.f73889p != z18) {
            this.f73889p = z18;
            aEFilterManager.switchAbilityInLightNode("ai.face.enable", z18);
            aEFilterManager.setOverallSmooth(!this.f73889p);
            if (QLog.isDevelopLevel()) {
                QLog.i("AEFilterAVWrapperImpl", 4, "updateBeautyFilter, enableFaceDetect[" + z18 + "]");
            }
        }
    }

    private void D(AEFilterManager aEFilterManager) {
        this.f73880g.clear();
        this.f73878e.c(this.f73880g);
        if (this.f73896w) {
            H(aEFilterManager);
        } else {
            E(aEFilterManager);
        }
    }

    private void E(AEFilterManager aEFilterManager) {
        boolean z16 = false;
        boolean z17 = false;
        for (c.a aVar : this.f73880g) {
            if (aVar != null) {
                int i3 = aVar.f73965a;
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            String d16 = c.d(aVar.f73966b.value);
                            if (aVar.f73969e != this.f73879f.b(d16)) {
                                aEFilterManager.setBeautyOrTransformLevel(aVar.f73966b, aVar.f73969e);
                                this.f73879f.n(d16, aVar.f73969e);
                                if (QLog.isColorLevel()) {
                                    QLog.i("AEFilterAVWrapperImpl", 2, "setBeautyOrTransformLevelV5: type: + " + aVar.f73965a + " level: " + aVar.f73969e);
                                }
                            }
                            if (aVar.f73969e != aVar.f73968d) {
                                z17 = true;
                            }
                        }
                    } else {
                        String d17 = c.d(aVar.f73966b.value);
                        if (aVar.f73969e != this.f73879f.b(d17)) {
                            aEFilterManager.setBeautyOrTransformLevel(aVar.f73966b, aVar.f73969e);
                            this.f73879f.n(d17, aVar.f73969e);
                            if (QLog.isColorLevel()) {
                                QLog.i("AEFilterAVWrapperImpl", 2, "setBeautyOrTransformLevelV5: type: + " + aVar.f73965a + " level: " + aVar.f73969e);
                            }
                        }
                        if (aVar.f73969e != aVar.f73968d) {
                            z16 = true;
                        }
                    }
                } else if (aVar.f73969e != this.f73879f.b("BEAUTY_SKIN")) {
                    aEFilterManager.setSmoothSharpenStrength(0.0f);
                    aEFilterManager.setSmoothLevel(aVar.f73969e);
                    this.f73879f.n("BEAUTY_SKIN", aVar.f73969e);
                    if (QLog.isColorLevel()) {
                        QLog.i("AEFilterAVWrapperImpl", 2, "setSmoothLevelV5: " + aVar.f73969e);
                    }
                }
            }
        }
        C(z16, z17);
    }

    private void F(VideoMaterial videoMaterial) {
        QLog.d("AEFilterAVWrapperImpl", 2, "[updateMaterial]:" + videoMaterial.getDataPath());
        if (((IAEMaterialManager) QRoute.api(IAEMaterialManager.class)).isSpecialTemplate(videoMaterial)) {
            QLog.d("PreCheckAERes", 2, "[setMaterial] set special template");
            if (((IAEResUtil) QRoute.api(IAEResUtil.class)).checkAEResVersionOK(AEResInfo.LIGHT_RES_BASE_PACKAGE)) {
                QLog.d("PreCheckAERes", 2, "[setMaterial] version check success");
                if (FeatureManager.ensureMaterialSoLoaded(videoMaterial)) {
                    QLog.d("PreCheckAERes", 2, "[setMaterial] so load success\u3002");
                    this.f73891r.clear();
                    List<String> needDownloadList = ((IAEResUtil) QRoute.api(IAEResUtil.class)).getNeedDownloadList(videoMaterial, QQWinkConstants.ENTRY_QQ_VIDEO);
                    this.f73891r = needDownloadList;
                    if (!needDownloadList.isEmpty()) {
                        QLog.d("PreCheckAERes", 2, "[setMaterial] bundleStatus not ready, go fetch bundles ... " + this.f73891r.size());
                        ((IAEResUtil) QRoute.api(IAEResUtil.class)).fetchSpecificBundles(this.f73891r);
                        return;
                    }
                    QLog.d("PreCheckAERes", 2, "[setMaterial] bundleStatus ready, apply material...");
                    return;
                }
                QLog.e("PreCheckAERes", 2, "[setMaterial] so load failed");
                return;
            }
            QLog.e("PreCheckAERes", 2, "[setMaterial] version check failed");
        }
    }

    private void G() {
        AEFilterManager aEFilterManager = this.f73877d;
        if (aEFilterManager == null) {
            return;
        }
        D(aEFilterManager);
        PendantItem pendantItem = this.f73882i;
        if (pendantItem != null && PendantItem.isBeautyMakeup(pendantItem.getCategory())) {
            Object obj = this.f73882i.extraParam;
            if (obj instanceof Integer) {
                this.f73885l = ((Integer) obj).intValue();
            }
            aEFilterManager.setCosmeticsAlpha(this.f73885l);
        }
        t();
    }

    private void t() {
        AEFilterManager aEFilterManager = this.f73877d;
        if (this.f73890q && aEFilterManager != null) {
            uv.b f16 = uv.b.f();
            AEResInfo aEResInfo = AEResInfo.LIGHT_RES_BUNDLE_HAND;
            if (f16.k(aEResInfo.index)) {
                this.f73890q = false;
                try {
                    aEFilterManager.setLightBundle(((IAEResUtil) QRoute.api(IAEResUtil.class)).getLightBundleDir(aEResInfo), aEResInfo.agentType);
                } catch (Throwable th5) {
                    QLog.i("AEFilterAVWrapperImpl", 1, "updateParam", th5);
                }
                if (QLog.isColorLevel()) {
                    QLog.i("AEFilterAVWrapperImpl", 2, "updateParam, has load hand bundle.");
                }
            }
        }
        if (this.f73891r.isEmpty() && aEFilterManager != null) {
            z();
        }
    }

    private void u() {
        o oVar = this.f73892s;
        if (oVar != null) {
            oVar.a();
            this.f73892s = null;
        }
    }

    private int v(int i3, int i16, int i17) {
        t a16 = t.a(-1, i3);
        if (this.f73892s == null) {
            this.f73892s = new o();
        }
        this.f73892s.d(2);
        t c16 = this.f73892s.c(a16, i16, i17);
        if (c16 != null) {
            i3 = c16.f74046b;
        }
        if (c16 != a16 && c16 != null) {
            c16.b();
        }
        a16.b();
        return i3;
    }

    private PTFaceAttr w() {
        AEFilterManager aEFilterManager = this.f73877d;
        if (aEFilterManager != null) {
            return aEFilterManager.getFaceAttr();
        }
        return null;
    }

    private String x(FilterDesc filterDesc) {
        if (filterDesc == null) {
            return null;
        }
        String filterResPath = SdkContext.getInstance().getResources().getAvFilterResource().getFilterResPath();
        if (!TextUtils.isEmpty(filterDesc.resRootPath)) {
            filterResPath = filterDesc.resRootPath;
        }
        String resFold = filterDesc.getResFold(filterResPath);
        QQPtColorFilterInfo colorFilterInfo = QQPtColorFilter.getColorFilterInfo(resFold);
        if (colorFilterInfo != null) {
            resFold = resFold + colorFilterInfo.getColorPng();
        }
        if (QLog.isColorLevel()) {
            QLog.i("AEFilterAVWrapperImpl", 2, "getLutPath, name[" + filterDesc.name + "], out[" + resFold + "]");
        }
        return resFold;
    }

    private void y() {
        if (this.f73874a >= 2) {
            return;
        }
        if (this.f73874a < 3) {
            if (com.tencent.av.ui.f.d()) {
                this.f73877d = new AEFilterManager("defaultBeautyV7.json", true, true, null, com.tencent.av.ui.f.e());
            } else {
                this.f73877d = new AEFilterManager("defaultBeautyV5.json", true, null);
            }
            if (this.f73897x) {
                this.f73877d.setAvatarMode(true);
                QLog.i("AEFilterAVWrapperImpl", 2, "setAvatarMode");
            }
            this.f73877d.setLightAppEntry(QQWinkConstants.ENTRY_QQ_VIDEO);
            this.f73877d.setLightNodeTipsListener(this.f73893t);
            this.f73877d.setLightNodeLightAssetListener(this.f73894u);
            this.f73877d.setStickerInnerLutFilterListener(this.f73895v);
            this.f73877d.initInGL(this.f73875b, this.f73876c);
            this.f73877d.setOverallSmooth(!this.f73889p);
            this.f73877d.switchAbilityInLightNode("denoise.enable", false);
            this.f73877d.switchAbilityInLightNode("beauty.enable", this.f73887n);
            this.f73877d.switchAbilityInLightNode("transform.enable", this.f73888o);
            this.f73877d.switchAbilityInLightNode("ai.face.enable", this.f73889p);
            this.f73877d.switchAbilityInLightNode("beauty.faceFeature.enable", false);
            if (com.tencent.av.ui.f.d()) {
                HashMap hashMap = new HashMap();
                hashMap.put("smooth.curveAdjustAlpha", "0");
                this.f73877d.updateCameraConfigData(hashMap);
                this.f73877d.switchAbilityInLightNode(LightConstants.DetectSwitchKey.AI_FACE_STATIC_FEATURE_ENABLE, true);
                this.f73877d.switchAIBeauty(true);
                this.f73877d.setExposureValue(50);
                IAEResUtil iAEResUtil = (IAEResUtil) QRoute.api(IAEResUtil.class);
                AEResInfo aEResInfo = AEResInfo.LIGHT_RES_BUNDLE_FACE_STATIC_FEATURE;
                if (!iAEResUtil.isAEResExist(aEResInfo.agentType, QQWinkConstants.ENTRY_QQ_VIDEO)) {
                    QLog.i("AEFilterAVWrapperImpl", 2, "Gender res does not download success");
                    ((IAEResUtil) QRoute.api(IAEResUtil.class)).fetchSingleBundle(aEResInfo.agentType);
                }
            }
            IAEResUtil iAEResUtil2 = (IAEResUtil) QRoute.api(IAEResUtil.class);
            AEResInfo aEResInfo2 = AEResInfo.LIGHT_RES_BUNDLE_FACE;
            if (!iAEResUtil2.isAEResExist(aEResInfo2.agentType, QQWinkConstants.ENTRY_QQ_VIDEO)) {
                QLog.i("AEFilterAVWrapperImpl", 2, "face agent bundle does not download success");
                ((IAEResUtil) QRoute.api(IAEResUtil.class)).fetchSingleBundle(aEResInfo2.agentType);
            }
            String x16 = x(this.f73881h);
            if (!TextUtils.isEmpty(x16) && !FileUtils.fileExists(x16)) {
                QLog.i("AEFilterAVWrapperImpl", 1, "initAEFilterInGL, fail path[" + x16 + "]");
            } else {
                this.f73877d.updateLutGL(x16);
            }
            this.f73877d.updateMaterialGL(this.f73883j);
            B();
            this.f73877d.setForceFaceDetect(this.f73884k);
            boolean isInited = this.f73877d.isInited();
            if (isInited) {
                this.f73874a = 2;
                int i3 = this.f73886m;
                if (i3 != 0 && i3 == 1) {
                    this.f73877d.switchAbilityInLightNode("smooth.enable", true);
                    this.f73877d.switchAbilityInLightNode("denoise.enable", false);
                    this.f73877d.switchAbilityInLightNode("beauty.enable", false);
                    this.f73877d.switchAbilityInLightNode("transform.enable", false);
                    this.f73877d.switchAbilityInLightNode("ai.face.enable", false);
                    this.f73877d.switchAbilityInLightNode("sticker.enable", false);
                }
            } else {
                this.f73874a = 3;
            }
            this.f73877d.setZplanFilamentAbility(((IAEQQFilamentManager) QRoute.api(IAEQQFilamentManager.class)).getAEFilamentManager());
            ae.c(isInited);
        }
        if (QLog.isColorLevel()) {
            QLog.i("AEFilterAVWrapperImpl", 2, "initAEFilterInGL, state[" + this.f73874a + "]");
        }
    }

    private void z() {
        for (String str : this.f73891r) {
            if (!((IAEResUtil) QRoute.api(IAEResUtil.class)).isAEResExist(str, QQWinkConstants.ENTRY_QQ_VIDEO) && this.f73877d != null) {
                QLog.d("AEFilterAVWrapperImpl", 2, "[injectBundlePathsToLight] agentType:" + str + " | dir:" + ((IAEResUtil) QRoute.api(IAEResUtil.class)).getLightBundleDir(str));
                this.f73877d.setLightBundle(((IAEResUtil) QRoute.api(IAEResUtil.class)).getLightBundleDir(str), str);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[injectBundlePathsToLight] curResBundleStatus:");
                sb5.append(str);
                QLog.d("AEFilterAVWrapperImpl", 2, sb5.toString());
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:20:0x0061. Please report as an issue. */
    void H(AEFilterManager aEFilterManager) {
        if (!this.f73887n) {
            this.f73887n = true;
            this.f73877d.switchAbilityInLightNode("beauty.enable", true);
        }
        if (!this.f73888o) {
            this.f73888o = true;
            this.f73877d.switchAbilityInLightNode("transform.enable", true);
        }
        if (!this.f73889p) {
            this.f73889p = true;
            this.f73877d.switchAbilityInLightNode("ai.face.enable", true);
            this.f73877d.setOverallSmooth(false);
        }
        for (c.a aVar : this.f73880g) {
            if (aVar != null) {
                String d16 = c.d(aVar.f73966b.value);
                if (aVar.f73969e != this.f73879f.b(d16)) {
                    d16.hashCode();
                    char c16 = '\uffff';
                    switch (d16.hashCode()) {
                        case -1799361320:
                            if (d16.equals("MOUTH_LIPS")) {
                                c16 = 0;
                                break;
                            }
                            break;
                        case -374332525:
                            if (d16.equals("FACE_3D")) {
                                c16 = 1;
                                break;
                            }
                            break;
                        case 2149981:
                            if (d16.equals("FACE")) {
                                c16 = 2;
                                break;
                            }
                            break;
                        case 78166166:
                            if (d16.equals("ROUGE")) {
                                c16 = 3;
                                break;
                            }
                            break;
                    }
                    switch (c16) {
                        case 0:
                            this.f73877d.openAndUpdateBasicLips("images/beauty/lips_mitaose.png", aVar.f73969e, 2);
                            this.f73877d.openBeautyEnable(true);
                            this.f73879f.n(d16, aVar.f73969e);
                            if (QLog.isColorLevel()) {
                                QLog.i("AEFilterAVWrapperImpl", 2, "setBeautyLevelV7: beautyName: + " + d16 + " level: " + aVar.f73969e);
                                break;
                            } else {
                                break;
                            }
                        case 1:
                            this.f73877d.openAndUpdateBasicSoftLight("images/beauty/liti_guangmang.png", aVar.f73969e);
                            this.f73877d.openBeautyEnable(true);
                            this.f73879f.n(d16, aVar.f73969e);
                            if (QLog.isColorLevel()) {
                                QLog.i("AEFilterAVWrapperImpl", 2, "setBeautyLevelV7: beautyName: + " + d16 + " level: " + aVar.f73969e);
                                break;
                            } else {
                                break;
                            }
                        case 2:
                            this.f73877d.openFaceThinEnable("nature");
                            aEFilterManager.setBeautyOrTransformLevel(aVar.f73966b, aVar.f73969e);
                            this.f73879f.n(d16, aVar.f73969e);
                            if (QLog.isColorLevel()) {
                                QLog.i("AEFilterAVWrapperImpl", 2, "setBeautyLevelV7: beautyName: + " + d16 + " level: " + aVar.f73969e);
                                break;
                            } else {
                                break;
                            }
                        case 3:
                            this.f73877d.openAndUpdateBasicMultiply("images/beauty/saihong_jianyue.png", aVar.f73969e);
                            this.f73877d.openBeautyEnable(true);
                            this.f73879f.n(d16, aVar.f73969e);
                            if (QLog.isColorLevel()) {
                                QLog.i("AEFilterAVWrapperImpl", 2, "setBeautyLevelV7: beautyName: + " + d16 + " level: " + aVar.f73969e);
                                break;
                            } else {
                                break;
                            }
                        default:
                            aEFilterManager.setBeautyOrTransformLevel(aVar.f73966b, aVar.f73969e);
                            this.f73879f.n(d16, aVar.f73969e);
                            if (QLog.isColorLevel()) {
                                QLog.i("AEFilterAVWrapperImpl", 2, "setBeautyLevelV7: beautyName: + " + d16 + " level: " + aVar.f73969e);
                                break;
                            } else {
                                break;
                            }
                    }
                }
            }
        }
    }

    @Override // com.tencent.av.opengl.effects.a
    public void a(long j3) {
        QLog.w("AEFilterAVWrapperImpl", 1, "clearState, seq[" + j3 + "]");
        ag.e().d(j3);
    }

    @Override // com.tencent.av.opengl.effects.a
    public boolean b(c cVar) {
        if (cVar == null) {
            this.f73878e.a();
        } else {
            this.f73878e.o(cVar);
        }
        return this.f73878e.j();
    }

    @Override // com.tencent.av.opengl.effects.a
    public void c(String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.i("AEFilterAVWrapperImpl", 2, "notifyDownloadFinish: path = " + str + " agent = " + str2);
        }
        AEFilterManager aEFilterManager = this.f73877d;
        if (aEFilterManager != null) {
            aEFilterManager.setLightBundle(str, str2);
        }
    }

    @Override // com.tencent.av.opengl.effects.a
    public void d(p pVar) {
        boolean z16;
        if (l()) {
            return;
        }
        PendantItem pendantItem = this.f73882i;
        if (pendantItem != null) {
            z16 = pendantItem.hasFace();
        } else {
            z16 = false;
        }
        if (pVar != null && pVar.f74006c > 0) {
            ag.e().g();
        } else if (this.f73884k || z16) {
            ag.e().n();
        }
    }

    @Override // com.tencent.av.opengl.effects.a
    public void e(CameraConfig.DeviceCameraOrientation deviceCameraOrientation) {
        AEFilterManager aEFilterManager = this.f73877d;
        if (aEFilterManager != null) {
            aEFilterManager.setSensorOrientationToLight(deviceCameraOrientation);
        }
    }

    @Override // com.tencent.av.opengl.effects.a
    public boolean f() {
        return this.f73889p;
    }

    @Override // com.tencent.av.opengl.effects.a
    public void g(PendantItem pendantItem, VideoMaterial videoMaterial) {
        boolean z16;
        boolean z17;
        if (!ae.b(this.f73882i, pendantItem) || this.f73883j != videoMaterial) {
            if (pendantItem != null && pendantItem.hasGesture()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (QLog.isColorLevel()) {
                QLog.d("AEFilterAVWrapperImpl", 2, "setPendant, pendantItem[" + pendantItem + "], isPendantHasGesture[" + z16 + "]");
            }
            AEFilterManager aEFilterManager = this.f73877d;
            if (aEFilterManager != null && !aEFilterManager.isInited()) {
                QLog.i("AEFilterAVWrapperImpl", 1, "initAEDetector failed!");
            } else {
                this.f73882i = pendantItem;
                this.f73883j = videoMaterial;
                if (videoMaterial != null) {
                    F(videoMaterial);
                }
                AEFilterManager aEFilterManager2 = this.f73877d;
                if (aEFilterManager2 != null) {
                    aEFilterManager2.updateMaterialGL(this.f73883j);
                }
                if (z16) {
                    uv.b f16 = uv.b.f();
                    AEResInfo aEResInfo = AEResInfo.LIGHT_RES_BUNDLE_HAND;
                    if (!f16.k(aEResInfo.index)) {
                        z17 = uv.b.f().d(null, aEResInfo.index);
                    } else {
                        z17 = true;
                    }
                    this.f73890q = !z17;
                    ag.e().i(this.f73882i.getGestureType());
                    if (QLog.isColorLevel()) {
                        QLog.i("AEFilterAVWrapperImpl", 2, "setPendant, need gesture bundle. isNeedLoad[" + this.f73890q + "]");
                    }
                } else {
                    this.f73890q = false;
                    ag.e().p();
                }
            }
        }
        PendantItem pendantItem2 = this.f73882i;
        if (pendantItem2 != null && PendantItem.isBeautyMakeup(pendantItem2.getCategory())) {
            Object obj = this.f73882i.extraParam;
            if (obj instanceof Integer) {
                this.f73885l = ((Integer) obj).intValue();
            }
        }
    }

    @Override // com.tencent.av.opengl.effects.a
    public void h(int i3, int i16) {
        this.f73875b = i3;
        this.f73876c = i16;
        if (QLog.isColorLevel()) {
            QLog.i("AEFilterAVWrapperImpl", 2, "initInGL");
        }
    }

    @Override // com.tencent.av.opengl.effects.a
    public void i(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.i("AEFilterAVWrapperImpl", 2, "setFrontOrBackCamera: isFrontCamera = " + z16);
        }
        if (this.f73877d != null) {
            DeviceCameraConfig deviceCameraConfig = new DeviceCameraConfig();
            deviceCameraConfig.cameraIndex = !z16 ? 1 : 0;
            this.f73877d.updateDeviceCameraConfig(deviceCameraConfig);
        }
    }

    @Override // com.tencent.av.opengl.effects.a
    public void j(FilterDesc filterDesc) {
        String str;
        if (!ae.a(this.f73881h, filterDesc)) {
            this.f73881h = filterDesc;
            String x16 = x(filterDesc);
            if (this.f73877d != null && (TextUtils.isEmpty(x16) || FileUtils.fileExists(x16))) {
                this.f73877d.updateLutGL(x16);
            } else {
                QLog.i("AEFilterAVWrapperImpl", 1, "setFilterDesc, fail path[" + x16 + "]");
            }
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("setFilterDesc, name[");
                if (filterDesc == null) {
                    str = "null";
                } else {
                    str = filterDesc.name;
                }
                sb5.append(str);
                sb5.append("], path[");
                sb5.append(x16);
                sb5.append("]");
                QLog.i("AEFilterAVWrapperImpl", 2, sb5.toString());
            }
        }
    }

    @Override // com.tencent.av.opengl.effects.a
    public int k(int i3, boolean z16, p pVar, boolean z17) {
        if (this.f73874a < 1) {
            A(0);
            return i3;
        }
        if (this.f73874a < 2) {
            y();
        }
        if (this.f73874a >= 3) {
            return i3;
        }
        if (this.f73877d == null) {
            return i3;
        }
        int v3 = v(i3, this.f73875b, this.f73876c);
        G();
        int drawFrame = this.f73877d.drawFrame(v3, z16, System.currentTimeMillis() * 1000000);
        this.f73877d.notifyDetectFaceAttr();
        if (pVar != null) {
            pVar.d(w(), z17);
        }
        if (drawFrame == v3) {
            if (QLog.isDevelopLevel()) {
                QLog.i("AEFilterAVWrapperImpl", 4, "drawFrameInGL, AEFilterManager do nothing.");
                return i3;
            }
            return i3;
        }
        return drawFrame;
    }

    @Override // com.tencent.av.opengl.effects.a
    public boolean l() {
        PendantItem pendantItem = this.f73882i;
        if (pendantItem != null && pendantItem.hasGesture()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.av.opengl.effects.a
    public AvatarAIInfo m() {
        AEFilterManager aEFilterManager = this.f73877d;
        if (aEFilterManager != null) {
            return aEFilterManager.getLightAvatarAIInfo();
        }
        return null;
    }

    @Override // com.tencent.av.opengl.effects.a
    public void n() {
        AEFilterManager aEFilterManager = this.f73877d;
        if (aEFilterManager != null) {
            aEFilterManager.updateMaterialGL(null);
        }
        AEFilterManager aEFilterManager2 = this.f73877d;
        if (aEFilterManager2 != null) {
            aEFilterManager2.updateLutGL(null);
        }
        this.f73881h = null;
        this.f73882i = null;
        this.f73883j = null;
        if (QLog.isColorLevel()) {
            QLog.i("AEFilterAVWrapperImpl", 2, "uninitInGL");
        }
    }

    @Override // com.tencent.av.opengl.effects.a
    public void o() {
        u();
        AEFilterManager aEFilterManager = this.f73877d;
        if (aEFilterManager != null) {
            aEFilterManager.setLightNodeTipsListener(null);
            this.f73877d.setLightNodeLightAssetListener(null);
            this.f73877d.updateLutGL(null);
            this.f73877d.updateMaterialGL(null);
            this.f73877d.destroy();
            this.f73877d = null;
        }
        this.f73874a = -1;
        this.f73881h = null;
        this.f73883j = null;
        this.f73882i = null;
        this.f73879f.a();
        if (QLog.isColorLevel()) {
            QLog.i("AEFilterAVWrapperImpl", 2, "destroyInGL");
        }
    }

    @Override // com.tencent.av.opengl.effects.a
    public void p(boolean z16) {
        if (QLog.isDevelopLevel() && this.f73884k != z16) {
            QLog.i("AEFilterAVWrapperImpl", 4, "setNeedFaceData, needDetectFace[" + z16 + "]");
        }
        this.f73884k = z16;
        AEFilterManager aEFilterManager = this.f73877d;
        if (aEFilterManager != null) {
            aEFilterManager.setForceFaceDetect(z16);
        }
    }

    @Override // com.tencent.av.opengl.effects.a
    public void q(int i3, int i16) {
        if (i3 != 0 && i16 != 0) {
            if (this.f73875b != i3 || this.f73876c != i16) {
                if (QLog.isDevelopLevel()) {
                    QLog.i("AEFilterAVWrapperImpl", 2, "updateWidthHeight, width[" + i3 + "], height[" + i16 + "]");
                }
                this.f73875b = i3;
                this.f73876c = i16;
                AEFilterManager aEFilterManager = this.f73877d;
                if (aEFilterManager != null) {
                    aEFilterManager.updateWidthHeight(i3, i16);
                }
            }
        }
    }

    @Override // com.tencent.av.opengl.effects.a
    public boolean r() {
        return this.f73884k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class MyLightAssetListener implements OnLoadAssetListener {
        MyLightAssetListener() {
        }

        private boolean a(int i3) {
            if (i3 != 0) {
                return true;
            }
            return false;
        }

        private static String b(int i3) {
            int i16;
            if (i3 != -200) {
                if (i3 != -100) {
                    if (i3 != 0) {
                        i16 = R.string.f1779535c;
                    } else {
                        i16 = 0;
                    }
                } else {
                    i16 = R.string.f1779835f;
                }
            } else {
                i16 = R.string.f1779435b;
            }
            if (i16 != 0) {
                return HardCodeUtil.qqStr(i16);
            }
            return null;
        }

        @Override // org.light.listener.OnLoadAssetListener
        public void OnAssetProcessing(HashMap<String, String> hashMap) {
            QLog.i("AEFilterAVWrapperImpl", 2, "OnAssetProcessing");
            if (hashMap != null && hashMap.containsKey(LightConstants.ZPlanConfigKeys.ASSET_PROCESSING_ZPLAN_FILAMENT_FIRSTFRAME)) {
                QLog.i("AEFilterAVWrapperImpl", 1, "receive filament first frame: " + hashMap.get(LightConstants.ZPlanConfigKeys.ASSET_PROCESSING_ZPLAN_FILAMENT_FIRSTFRAME));
                final AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime instanceof VideoAppInterface) {
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.av.opengl.effects.AEFilterAVWrapperImpl.MyLightAssetListener.1
                        @Override // java.lang.Runnable
                        public void run() {
                            cw.e.d((VideoAppInterface) peekAppRuntime, 3022);
                            ag.e().j();
                        }
                    });
                }
            }
        }

        @Override // org.light.listener.OnLoadAssetListener
        public void OnLoadAssetError(int i3) {
            if (a(i3)) {
                String b16 = b(i3);
                QLog.i("AEFilterAVWrapperImpl", 1, "OnLoadAssetError: errorCode = " + i3 + " error tips is " + b16);
                ag e16 = ag.e();
                if (TextUtils.isEmpty(b16)) {
                    b16 = "";
                }
                e16.m(b16);
                ag.e().f(1500);
            }
        }

        @Override // org.light.listener.OnLoadAssetListener
        public void OnAssetDurationChange(long j3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class a implements AEFilterManager.MaterialInnerEffectListener {
        a() {
        }

        @Override // com.tencent.aekit.api.standard.filter.AEFilterManager.MaterialInnerEffectListener
        public void onDeviceNotSupportMaterial() {
            QLog.i("AEFilterAVWrapperImpl", 1, "onDeviceNotSupport called");
            String qqStr = HardCodeUtil.qqStr(R.string.f1779535c);
            ag e16 = ag.e();
            if (TextUtils.isEmpty(qqStr)) {
                qqStr = "";
            }
            e16.m(qqStr);
            ag.e().f(1500);
        }

        @Override // com.tencent.aekit.api.standard.filter.AEFilterManager.MaterialInnerEffectListener
        public void notifyEnableLutType(int i3) {
        }

        @Override // com.tencent.aekit.api.standard.filter.AEFilterManager.MaterialInnerEffectListener
        public void notifyEnableMeshType(int i3) {
        }
    }
}
