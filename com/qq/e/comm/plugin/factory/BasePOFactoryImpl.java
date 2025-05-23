package com.qq.e.comm.plugin.factory;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.os.IBinder;
import android.view.ViewGroup;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.thread.GdtSDKThreadManager;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.pi.ADPLI;
import com.qq.e.comm.pi.IEGRVADI;
import com.qq.e.comm.pi.LOG;
import com.qq.e.comm.pi.NADI;
import com.qq.e.comm.pi.NEADI;
import com.qq.e.comm.pi.NEADVI;
import com.qq.e.comm.pi.NUADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.SOI;
import com.qq.e.comm.pi.SVSD;
import com.qq.e.comm.pi.TADLDI;
import com.qq.e.comm.pi.TGEPI;
import com.qq.e.comm.pi.TGRVOI;
import com.qq.e.comm.pi.TGSPPIV2;
import com.qq.e.comm.pi.TGSPVI;
import com.qq.e.comm.pi.TangramExposureCallback;
import com.qq.e.comm.pi.TangramWidget;
import com.qq.e.comm.pi.UBVI;
import com.qq.e.comm.pi.UIADI;
import com.qq.e.comm.pi.UTI;
import com.qq.e.comm.pi.WRI;
import com.qq.e.comm.plugin.base.ad.clickcomponent.e.d;
import com.qq.e.comm.plugin.e.c;
import com.qq.e.comm.plugin.ipc.server.IPCServer;
import com.qq.e.comm.plugin.j.a;
import com.qq.e.comm.plugin.k.au;
import com.qq.e.comm.plugin.k.bc;
import com.qq.e.comm.plugin.k.y;
import com.qq.e.comm.plugin.router.PublicApi;
import com.qq.e.comm.plugin.router.PublicApiHelper;
import com.qq.e.comm.plugin.stat.StatTracer;
import com.qq.e.comm.plugin.stat.f;
import com.qq.e.comm.plugin.stat.o;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.TimeRecorder;
import com.qq.e.tg.banner2.UnifiedBannerADListener;
import com.qq.e.tg.banner2.UnifiedBannerView;
import com.qq.e.tg.download.interfaces.ITGDC;
import com.qq.e.tg.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.tg.nativ.ADSize;
import com.qq.e.tg.splash.TGSplashMaterialUtil;
import com.tencent.ams.fusion.service.b;
import com.tencent.bugly.common.utils.DeviceInfoUtil;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class BasePOFactoryImpl implements POFactory {
    public static final String DOWNLOAD_MANAGE = "downloadManage";
    public static final String FULL_SCREEN_DETAIL = "fullScreenDetail";
    public static final String GDT_CANVAS = "gdtCanvas";
    public static final String HALF_SCREEN = "halfScreen";
    public static final String HIPPY_DSDK_JS_SERVER_TEST = "dkSdkCustomConfigJsonUrl";
    public static final String HIPPY_DSDK_TEMPLATE_SERVER_TEST = "dkSdkCustomTemplateUrl";
    public static final String HIPPY_ENABLE_IMAGE_LOADER_HANDLE_LOCAL_FILE = "enableHippyImageLoaderHandleLocalFile";
    public static final String INNER_BROWSER = "innerBrowser";
    public static final String INTERSTITIAL_FULL_SCREEN = "interstitialFullScreen";
    public static final String POPUP_APK_DETAIL = "popupAPKDetail";
    public static final String TANGRAMREWARD_VIDEO = "tangramrewardVideo";
    public static final String TANGRAM_REWARD_HIPPY = "tangramRewardHippy";
    public static final String TANGRAM_REWARD_PAGE_AD = "tangramRewardPageAd";
    public static final String TANGRAM_REWARD_PIC = "tangramRewardPic";
    public static final String TANGRAM_REWARD_VIDEO_CEILING = "tangramRewardVideoCeiling";
    public static final String VIDEO_CEILING = "videoCeiling";
    private static final POFactory instance = new BasePOFactoryImpl();

    BasePOFactoryImpl() {
        configFusionSDKDefaultValue();
        initStatEventSampleResult();
        a.a().b();
        GDTLogger.d("doInit BasePOFactoryImpl time 1: " + TimeRecorder.getInstance().costFromStart());
        initDeviceInfoModule();
        GDTLogger.d("doInit BasePOFactoryImpl time 3: " + TimeRecorder.getInstance().costFromStart());
        intSplashModule();
        b.b().c(GDTADManager.getInstance().getAppContext());
        GDTLogger.d("doInit BasePOFactoryImpl finish: " + TimeRecorder.getInstance().costFromStart());
        reportDeviceAbility();
    }

    private int checkPermissions(String str) {
        Context appContext = GDTADManager.getInstance().getAppContext();
        if (appContext != null) {
            try {
                if (appContext.checkCallingOrSelfPermission(str) == 0) {
                    return 1;
                }
                return 0;
            } catch (Throwable th5) {
                GDTLogger.e(th5.getMessage());
            }
        }
        return -1;
    }

    private void configFusionSDKDefaultValue() {
        com.tencent.ams.fusion.service.splash.a.b.b();
        com.tencent.ams.fusion.service.splash.a.b.a();
        com.tencent.ams.fusion.service.splash.a.b.d();
        com.tencent.ams.fusion.service.splash.a.b.c();
        com.tencent.ams.fusion.service.splash.a.b.e();
    }

    public static POFactory getInstance() {
        return instance;
    }

    private void initApkDownloaderModule() {
        try {
            ClassLoader pluginClassLoader = GDTADManager.getInstance().getPM().getPluginClassLoader();
            if (pluginClassLoader != null) {
                pluginClassLoader.loadClass("com.qq.e.comm.plugin.router.ApkDownloaderRouterHelper").newInstance();
            }
        } catch (Throwable th5) {
            GDTLogger.e("initApkDownloaderModule error :", th5);
        }
    }

    private void initDeviceInfoModule() {
        try {
            ClassLoader pluginClassLoader = GDTADManager.getInstance().getPM().getPluginClassLoader();
            if (pluginClassLoader != null) {
                pluginClassLoader.loadClass("com.qq.e.comm.plugin.router.DeviceInfoRouterHelper").newInstance();
            }
            th = null;
        } catch (Throwable th5) {
            th = th5;
            GDTLogger.e("initDeviceInfo error :", th);
        }
        if (th == null) {
            WeakReference weakReference = new WeakReference(GDTADManager.getInstance().getAppContext().getApplicationContext());
            if (weakReference.get() != null) {
                ((PublicApi.DeviceInfoApi) PublicApiHelper.getModuleApi(PublicApi.DeviceInfoApi.class)).init((Context) weakReference.get());
                GdtSDKThreadManager.getInstance().runOnThread(3, new Runnable() { // from class: com.qq.e.comm.plugin.factory.BasePOFactoryImpl.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            ((PublicApi.DeviceInfoApi) PublicApiHelper.getModuleApi(PublicApi.DeviceInfoApi.class)).get(com.qq.e.comm.plugin.base.ad.b.UNKNOWN.b(), new c());
                        } catch (Throwable th6) {
                            GDTLogger.e("DeviceInfoApi", th6);
                        }
                    }
                });
            }
        }
    }

    private void initRewardVideoModule() {
        try {
            ClassLoader pluginClassLoader = GDTADManager.getInstance().getPM().getPluginClassLoader();
            if (pluginClassLoader != null) {
                pluginClassLoader.loadClass("com.qq.e.comm.plugin.router.RewardVideoRouterHelper").newInstance();
            }
        } catch (Throwable th5) {
            GDTLogger.e("initRewardVideoModule error :", th5);
        }
    }

    private void initStatEventSampleResult() {
        f.a(false);
    }

    private void initWebViewModule() {
        try {
            ClassLoader pluginClassLoader = GDTADManager.getInstance().getPM().getPluginClassLoader();
            if (pluginClassLoader != null) {
                pluginClassLoader.loadClass("com.qq.e.comm.plugin.router.WebViewRouterHelper").newInstance();
            }
        } catch (Throwable th5) {
            GDTLogger.e("initWebViewModule error :", th5);
        }
    }

    private void intSplashModule() {
        try {
            ClassLoader pluginClassLoader = GDTADManager.getInstance().getPM().getPluginClassLoader();
            if (pluginClassLoader != null) {
                pluginClassLoader.loadClass("com.qq.e.comm.plugin.router.SplashRouterHelper").newInstance();
            }
        } catch (Throwable th5) {
            GDTLogger.e("initSplashModule error :", th5);
        }
    }

    private void reportCheckPermissions() {
        JSONObject a16 = y.a();
        y.a(a16, "READ_PHONE_STATE", checkPermissions(DeviceInfoUtil.PERMISSION_READ_PHONE));
        y.a(a16, "REQUEST_INSTALL_PACKAGES", checkPermissions("android.permission.REQUEST_INSTALL_PACKAGES"));
        y.a(a16, "QUERY_ALL_PACKAGES", checkPermissions("android.permission.QUERY_ALL_PACKAGES"));
        StatTracer.trackEvent(1330004, y.a(), a16);
    }

    private void reportDeviceAbility() {
        au.a();
        GdtSDKThreadManager.getInstance().runOnThread(3, new Runnable() { // from class: com.qq.e.comm.plugin.factory.BasePOFactoryImpl.2
            @Override // java.lang.Runnable
            public void run() {
                bc.a();
            }
        });
    }

    @Override // com.qq.e.comm.pi.POFactory
    public void checkPreloadSplashMaterial() {
        TGSplashMaterialUtil.checkPreloadSplashMaterial();
    }

    @Override // com.qq.e.comm.pi.POFactory
    public void checkUpdate() {
        a.a().c();
    }

    @Override // com.qq.e.comm.pi.POFactory
    public void config(int i3, String str, ADListener aDListener) {
        a.a().a(i3, str, aDListener);
    }

    @Override // com.qq.e.comm.pi.POFactory
    public SVSD getAPKDownloadServiceDelegate(Service service) {
        return null;
    }

    @Override // com.qq.e.comm.pi.POFactory
    public ACTD getActivityDelegate(String str, Activity activity) {
        if ("innerBrowser".equals(str)) {
            return new com.qq.e.comm.plugin.base.ad.b.b.c(activity);
        }
        if ("downloadManage".equals(str)) {
            return new com.qq.e.comm.plugin.base.ad.b.a.a(activity);
        }
        if ("videoCeiling".equals(str)) {
            return new d(activity);
        }
        if ("fullScreenDetail".equals(str)) {
            return new com.qq.e.comm.plugin.base.ad.clickcomponent.e.b(activity);
        }
        return null;
    }

    @Override // com.qq.e.comm.pi.POFactory
    public ADPLI getAdPreloader() {
        return com.qq.e.comm.plugin.base.ad.c.c.a();
    }

    @Override // com.qq.e.comm.pi.POFactory
    public LOG getLogger() {
        return null;
    }

    @Override // com.qq.e.comm.pi.POFactory
    public NADI getNativeADDelegate(Context context, String str, String str2, ADListener aDListener) {
        return null;
    }

    @Override // com.qq.e.comm.pi.POFactory
    public NUADI getNativeAdManagerDelegate(Context context, String str, String str2, ADListener aDListener) {
        return null;
    }

    @Override // com.qq.e.comm.pi.POFactory
    public NEADI getNativeExpressADDelegate(Context context, ADSize aDSize, String str, String str2, ADListener aDListener) {
        return null;
    }

    @Override // com.qq.e.comm.pi.POFactory
    public NEADVI getNativeExpressADView(NEADI neadi, Context context, ViewGroup viewGroup, ADSize aDSize, String str, String str2, JSONObject jSONObject, HashMap<String, JSONObject> hashMap) {
        return null;
    }

    @Override // com.qq.e.comm.pi.POFactory
    public IBinder getServerBinder() {
        return (IBinder) IPCServer.getServer().mBinderEntity;
    }

    @Override // com.qq.e.comm.pi.POFactory
    public SOI getSplashOrderDelegate() {
        return null;
    }

    @Override // com.qq.e.comm.pi.POFactory
    public TADLDI getTangramAdLoaderDelegate(Context context, String str) {
        return new com.qq.e.comm.plugin.base.ad.a.b(context, str);
    }

    @Override // com.qq.e.comm.pi.POFactory
    public UTI getTangramAdTriggerDelegate() {
        return new com.qq.e.comm.plugin.base.ad.a.a();
    }

    @Override // com.qq.e.comm.pi.POFactory
    public ITGDC getTangramDownloaderConfigure() {
        Object tangramDownloaderConfigure = ((PublicApi.DownloadManagerApi) PublicApiHelper.getModuleApi(PublicApi.DownloadManagerApi.class)).getTangramDownloaderConfigure();
        if (tangramDownloaderConfigure instanceof ITGDC) {
            return (ITGDC) tangramDownloaderConfigure;
        }
        return null;
    }

    @Override // com.qq.e.comm.pi.POFactory
    public TGEPI getTangramExposureChecker(JSONObject jSONObject, WeakReference<TangramExposureCallback> weakReference) {
        return new com.qq.e.comm.plugin.base.ad.e.f(jSONObject, weakReference);
    }

    @Override // com.qq.e.comm.pi.POFactory
    public TGRVOI getTangramRewardAdOrderImp(String str, String str2) {
        return null;
    }

    @Override // com.qq.e.comm.pi.POFactory
    public TGSPVI getTangramSplashAdView(Context context, String str, String str2) {
        return null;
    }

    @Override // com.qq.e.comm.pi.POFactory
    public TGSPPIV2 getTangramSplashPreloader() {
        return null;
    }

    @Override // com.qq.e.comm.pi.POFactory
    public TangramWidget getTangramWidget(Context context, String str) {
        return null;
    }

    @Override // com.qq.e.comm.pi.POFactory
    public UBVI getUnifiedBannerViewDelegate(UnifiedBannerView unifiedBannerView, Activity activity, String str, String str2, UnifiedBannerADListener unifiedBannerADListener) {
        return null;
    }

    @Override // com.qq.e.comm.pi.POFactory
    public UIADI getUnifiedInterstitialADDelegate(Activity activity, String str, String str2, UnifiedInterstitialADListener unifiedInterstitialADListener) {
        return null;
    }

    @Override // com.qq.e.comm.pi.POFactory
    public WRI getWebReporterDelegate(String str, long j3) {
        return new com.qq.e.comm.plugin.n.b(str, j3);
    }

    @Override // com.qq.e.comm.pi.POFactory
    public IEGRVADI gettangramrewardVideoADDelegate(Context context, String str, String str2, ADListener aDListener) {
        return null;
    }

    @Override // com.qq.e.comm.pi.POFactory
    public void onGdtConfigUpdateDone() {
        GDTLogger.i("onGdtConfigUpdateDone function call");
        ((PublicApi.DeviceInfoApi) PublicApiHelper.getModuleApi(PublicApi.DeviceInfoApi.class)).updateAppStatus(null);
        com.qq.e.comm.plugin.n.a.b.f39676a.a();
    }

    @Override // com.qq.e.comm.pi.POFactory
    public void onGdtConfigUpdateFailed() {
        GDTLogger.i("onGdtConfigUpdateFailed function call");
    }

    @Override // com.qq.e.comm.pi.POFactory
    public void proceedToDownloadAPKTask() {
        com.qq.e.comm.plugin.a.a.a().b();
    }

    @Override // com.qq.e.comm.pi.POFactory
    public void reportCost(int i3, int i16, Map map, Map map2) {
        com.qq.e.comm.plugin.stat.b bVar;
        com.qq.e.comm.plugin.stat.c cVar = null;
        if (map != null && !map.isEmpty()) {
            bVar = new com.qq.e.comm.plugin.stat.b(map);
        } else {
            bVar = null;
        }
        if (map2 != null && !map2.isEmpty()) {
            cVar = new com.qq.e.comm.plugin.stat.c(map2);
        }
        StatTracer.trackEvent(i3, i16, bVar, cVar);
    }

    @Override // com.qq.e.comm.pi.POFactory
    public void reportLog(String str) {
        o.a(str);
    }

    @Override // com.qq.e.comm.pi.POFactory
    public void config(int i3, String str) {
        a.a().a(i3, str, null);
    }

    private void initCanvasModule() {
    }

    private void initVelenModule() {
    }

    private void initVideoCacheModule() {
    }
}
