package com.qq.e.comm.plugin.j;

import com.tencent.ams.fusion.service.a.a;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public class d implements com.tencent.ams.fusion.service.a.a {

    /* renamed from: a, reason: collision with root package name */
    private Map<String, String> f39589a = new HashMap<String, String>() { // from class: com.qq.e.comm.plugin.j.d.1
        {
            put("splashRealTimeSelectContinue", "tg_splash_rl_select_continue");
            put("shouldDownloadVideoSrcInRealtime", "shouldDownloadVideoSrcInRealtime");
            put("splashLocalSelect", "tangram_splash_local_select");
            put("splashSpaSelect", "tangram_splash_spa_select");
            put("maxParallelSourceDownload", "maxParallelSourceDownload");
            put("splashPreloadRetryTimes", "splash_preload_retry");
            put("splashDirExpiredDays", "adnetDirExpiredDays");
            put("splashDirCleanupThreshold", "adnetDirMaxSize");
            put("openSplashPreload", "openSplashPreload");
            put("openSplashSerializeDataTask", "openSplashSerializeDataTask");
            put("openFusionResDownloadAndClean", "openFusionResDownloadAndClean");
            put("splashLocalSelectAfterRealTimeTimeout", "tg_splash_rl_us_local_order");
            put("splashPreloadMaterialDownloadRetryTimes", "splash_preload_material_download_retry");
            put("splashRealTimeSelectCheckSrc", "splashRealTimeSelectCheckSrc");
            put("singleTaskTimeout", "singleTaskTimeout");
            put("realTimeSelectFirstResult", "realTimeSelectFirstResult");
            put("openSplashDynamic", "openSplashDynamic");
            put("openSplashRealTimeSelectOrderTask", "openSplashRealTimeSelectOrderTask");
            put("ignoreSplashEffectTimes", "ignoreSplashEffectTimes");
            put("ignoreSplashResource", "ignoreSplashResource");
            put("isUseNewImgVideoDownloadLogic", "isUseNewImgVideoDownloadLogic");
        }
    };

    @Override // com.tencent.ams.fusion.service.a.a
    public int a(a.C0673a c0673a) {
        if (c0673a != null) {
            return e.a().a(c0673a.d(), this.f39589a.get(c0673a.c()), c0673a.f());
        }
        return 0;
    }

    @Override // com.tencent.ams.fusion.service.a.a
    public String b(a.C0673a c0673a) {
        if (c0673a != null) {
            return e.a().a(c0673a.d(), this.f39589a.get(c0673a.c()), c0673a.e());
        }
        return null;
    }
}
