package com.tencent.mobileqq.qqvideoplatform.api;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mmkv.MMKV;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqvideoplatform.imp.e;
import com.tencent.mobileqq.qqvideoplatform.imp.f;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.o;
import com.tencent.mobileqq.util.IFeatureServiceProxy;
import com.tencent.mobileqq.utils.t;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.mobileqq.videoplatform.VideoPlaySDKManager;
import com.tencent.mobileqq.videoplatform.api.LoadSoCallback;
import com.tencent.mobileqq.videoplatform.util.LoadSoUtil;
import com.tencent.mobileqq.videoplatform.util.LogUtil;
import com.tencent.mobileqq.videoplatform.util.RegisterTVideoUtil;
import com.tencent.mobileqq.videoplatform.util.ReportUtil;
import com.tencent.mobileqq.videoplatform.util.ThreadUtil;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.tools.config.TVKUrlConfig;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import com.tencent.superplayer.api.SuperPlayerSdkOption;
import com.tencent.thumbplayer.api.capability.TPHdrCapability;
import com.tencent.thumbplayer.api.exception.TPLoadLibraryException;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import mqq.app.MobileQQ;

/* loaded from: classes17.dex */
public class QQVideoPlaySDKManager {
    static IPatchRedirector $redirector_ = null;
    public static final int CONFIG_SUPERPLAYER_BACKGROUND_ALIVE_CONFIG = 580;
    private static final String DEFAULT_MAC_ADDRESS = "02:00:00:00:00:00";
    private static final String DEFAULT_NONE = "NONE";
    private static final int DELAY_TOOL_PROCESS_LISTEN_BACKGROUND_TIME = 2000;
    public static final String KEY_BOOL_USE_UNITED_CONFIG = "KEY_BOOL_USE_UNITED_CONFIG";
    private static final String KEY_ENV_SWITCH_SP = "envSwitch";
    private static final String KEY_SUPER_DEBUG_INFO = "super_debug_info";
    public static final boolean LOAD_SO_FROM_AAR = false;
    public static final String TAG = "[VideoPlatform]QQVideoPlaySDKManager";
    public static final String WATCH_TOGETHER_APP_KEY = "W9SzVA5ESaRZIor1eGpkBZLk5EV8TNC46ZbGi9w73v03wr5PuxVloB/BN0Xd+IIjxVrK5c36B32DE2WjQlOTxCUoVPp5ZE0JEre0b+pvYAOYJQbORDSN8ggDoafO50Zfv3gvJUJ397rV61aG84+2TZBOVpZTJFT/7smh99LID/eokTM2YIoEVYh+oCwuT5AJheIjpU+Gq6FN0OQqVNZD/Q+9FSzaps7qYOxzInAjIBbTv0EZhGGw0KMzCIHLykU9I0kXGWdmh+/BiIuQchXpo0mlapd4yZiHtSfT1zMuGV4+noKWS8EGDH0yAMbiCcUscWSAtv3Va3HdtGA8eyGWBw==|jFrabrZHbE2zachNGFte5Kw2T6dinegHuCleYhNAsS4rCrNSIIvvzInLkJLX1uHWp7uc7MgARp2aPYIrUohETdmCAkk/9dTObrCiQYc5/QVuT01mqJY66EWklcZ74E/16QX8ZwydpYAT1YBkwv8S0K5MOOaY15fvDDzEo+Ez7nNcqeEtA3Izz1S5VODeRsao51PAxoksq1oVU1myHxSjIYYIuMqcj0ejxuwZLsMNHRDaW7Y/n4Vmq4EreAfIUewD1ukmIV7iGzoubF4VzTAuR39/lFM9jsPiOX6kRIc0SwflNvm4+zpWpZORgOEdLwVJR+PrutZgMvUIak2dJZa6J1U4oYS8j2MBqXdJ0PJCOZQX0HxM/DioW+AmoW6NIc3L+nIRniN7d1JLBw22lHzz7H1gRe1RkE8C6ur/Akd8/EpvX45IquShRaAX7Qr/TLTpCLI5BrKzLrYX/1FPB2lvjQxiCG2t3sfG/n/k9/nUzf7KWjDR7eLjMMObzlYHbYip";
    private static volatile boolean hasInitQQImp;
    private static QQAppLifecycleCallback sAppLifecycleCallback;
    private static volatile IQQVideoSDKConfigMgr sConfigMgr;
    private static volatile boolean sMonetLoadSuccess;
    private static volatile Map<String, String> sSuperReportMap;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public class a implements SDKInitListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ SDKInitListener f276392d;

        a(SDKInitListener sDKInitListener) {
            this.f276392d = sDKInitListener;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) sDKInitListener);
            }
        }

        @Override // com.tencent.mobileqq.videoplatform.SDKInitListener
        public void onSDKInited(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
            } else {
                this.f276392d.onSDKInited(z16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public class b implements o.c {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.statistics.o.c
        public void a(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
            } else {
                SuperPlayerSDKMgr.setDeviceId(str);
            }
        }
    }

    /* loaded from: classes17.dex */
    class c implements LoadSoCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SDKInitListener f276393a;

        c(SDKInitListener sDKInitListener) {
            this.f276393a = sDKInitListener;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) sDKInitListener);
            }
        }

        @Override // com.tencent.mobileqq.videoplatform.api.LoadSoCallback
        public void onLoad(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                QQVideoPlaySDKManager.sMonetLoadSuccess = z16;
                SDKInitListener sDKInitListener = this.f276393a;
                if (sDKInitListener != null) {
                    sDKInitListener.onSDKInited(z16);
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
        }
    }

    /* loaded from: classes17.dex */
    class d implements SDKInitListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f276394d;

        d(int i3) {
            this.f276394d = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3);
            }
        }

        @Override // com.tencent.mobileqq.videoplatform.SDKInitListener
        public void onSDKInited(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
            } else {
                SuperPlayerSDKMgr.addVideoHwCodecBlackList(this.f276394d);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43042);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            sMonetLoadSuccess = false;
            initQQImp();
        }
    }

    public QQVideoPlaySDKManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void addSuperGlobalReportData(String str, String str2) {
        if (sSuperReportMap == null) {
            sSuperReportMap = getConfigMgr().getCommonReportMap();
        }
        sSuperReportMap.put(str, str2);
        SuperPlayerSDKMgr.setGlobalReportMap(sSuperReportMap);
    }

    public static void addVideoHwCodecBlackList(int i3) {
        if (isSDKReady()) {
            SuperPlayerSDKMgr.addVideoHwCodecBlackList(i3);
        } else {
            initSDKAsync(BaseApplication.context, new d(i3));
        }
    }

    public static void clearMemory(int i3) {
        SuperPlayerSDKMgr.clearMemoryCache(i3);
    }

    private static void commonSDKConfig(IQQVideoSDKConfigMgr iQQVideoSDKConfigMgr) {
        boolean z16;
        String str;
        if (MobileQQ.sProcessId == 1) {
            if (t.a() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                str = String.valueOf(true);
            } else {
                str = "";
            }
            SuperPlayerSDKMgr.setUpcInfo(str, 1);
        }
        if (sSuperReportMap == null) {
            sSuperReportMap = iQQVideoSDKConfigMgr.getCommonReportMap();
        }
        SuperPlayerSDKMgr.setGlobalReportMap(sSuperReportMap);
        Pair<Boolean, String> switchAndValue = ((IFeatureServiceProxy) QRoute.api(IFeatureServiceProxy.class)).getSwitchAndValue("hdr_white_list");
        if (switchAndValue != null && ((Boolean) switchAndValue.first).booleanValue()) {
            String model = DeviceInfoMonitor.getModel();
            if (isInHdrWhiteList(model, (String) switchAndValue.second)) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "innerInitSDK add hdr list:" + model);
                }
                try {
                    TPHdrCapability.addCustomizedHdrCapability(4, 1, 1);
                } catch (TPLoadLibraryException unused) {
                    QLog.d(TAG, 1, "TPLibrary is not load");
                }
            }
        }
    }

    private static SuperPlayerSdkOption generateSDKOption(IQQVideoSDKConfigMgr iQQVideoSDKConfigMgr) {
        SuperPlayerSdkOption option = SuperPlayerSdkOption.option();
        option.uid = getUin();
        option.deviceId = o.b();
        option.beaconQimei36 = o.c();
        option.deviceModel = DeviceInfoMonitor.getModel();
        if (TextUtils.isEmpty(option.deviceId)) {
            loadQimeiAsync();
        }
        try {
            iQQVideoSDKConfigMgr.initConfig(option);
            iQQVideoSDKConfigMgr.saveConfigToMMKV();
        } catch (Throwable th5) {
            if (LogUtil.isColorLevel()) {
                LogUtil.e(TAG, 2, "initSDKAsync", th5);
            }
        }
        return option;
    }

    private static synchronized IQQVideoSDKConfigMgr getConfigMgr() {
        synchronized (QQVideoPlaySDKManager.class) {
            if (sConfigMgr != null) {
                return sConfigMgr;
            }
            sConfigMgr = new e();
            return sConfigMgr;
        }
    }

    public static long getTPCoreVersionInt() {
        return SuperPlayerSDKMgr.getTPCoreVersionInt();
    }

    public static String getUin() {
        if (!MobileQQ.sMobileQQ.isRuntimeReady()) {
            return "";
        }
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (!(waitAppRuntime instanceof BaseQQAppInterface)) {
            return "";
        }
        return waitAppRuntime.getAccount();
    }

    public static void initDownloadSDKAsync(Context context, SDKInitListener sDKInitListener) {
        if (isDownloadSDKReady()) {
            sDKInitListener.onSDKInited(true);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "initDownloadSDKAsync: ");
        }
        if (getConfigMgr().enableInitDownloadOnly()) {
            ThreadManagerV2.excute(new Runnable(context, sDKInitListener) { // from class: com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Context f276390d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ SDKInitListener f276391e;

                {
                    this.f276390d = context;
                    this.f276391e = sDKInitListener;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) sDKInitListener);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        QQVideoPlaySDKManager.innerInitDownloadSDK(this.f276390d, this.f276391e);
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                }
            }, 64, null, true);
        } else {
            initSDKAsync(context, new a(sDKInitListener));
        }
    }

    public static void initMonetAsync(SDKInitListener sDKInitListener) {
        if (!sMonetLoadSuccess) {
            ((IVideoSoLoader) QRoute.api(IVideoSoLoader.class)).loadMonetSo(new c(sDKInitListener));
        }
    }

    public static synchronized void initQQImp() {
        synchronized (QQVideoPlaySDKManager.class) {
            if (!hasInitQQImp) {
                LogUtil.setLogImp(new com.tencent.mobileqq.qqvideoplatform.imp.b());
                ThreadUtil.setThreadImp(new f());
                LoadSoUtil.setLoadSoImp(new com.tencent.mobileqq.qqvideoplatform.imp.a(false));
                ReportUtil.setReportImp(new com.tencent.mobileqq.qqvideoplatform.imp.d());
                RegisterTVideoUtil.setRegisterTVideoImp(new com.tencent.mobileqq.qqvideoplatform.imp.c());
                sAppLifecycleCallback = new QQAppLifecycleCallback();
                hasInitQQImp = true;
            }
        }
    }

    public static void initSDKAsync(final Context context, final SDKInitListener sDKInitListener) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "initSDKAsync: ");
        }
        ThreadUtil.postOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.qqvideoplatform.api.a
            @Override // java.lang.Runnable
            public final void run() {
                QQVideoPlaySDKManager.innerInitSDK(context, sDKInitListener, false, true);
            }
        });
    }

    public static void initSDKWithoutWait(final Context context, final SDKInitListener sDKInitListener, final boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "initSDKWithoutWait: ");
        }
        if (getConfigMgr().enableInitSDKWithoutWait()) {
            ThreadUtil.postOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.qqvideoplatform.api.b
                @Override // java.lang.Runnable
                public final void run() {
                    QQVideoPlaySDKManager.innerInitSDK(context, sDKInitListener, true, z16);
                }
            });
        } else {
            initSDKAsync(context, sDKInitListener);
        }
    }

    private static void initTvkDebug() {
        boolean e16 = MMKV.u().e(KEY_SUPER_DEBUG_INFO, false);
        SuperPlayerSDKMgr.setShowPlayerDebugView(e16);
        if (e16) {
            TVKUrlConfig.setCurrentEnv(2);
        }
        LogUtil.d(TAG, 2, "innerInitSDK tvkDebugOpen : " + e16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void innerInitDownloadSDK(Context context, SDKInitListener sDKInitListener) {
        IQQVideoSDKConfigMgr configMgr = getConfigMgr();
        SuperPlayerSdkOption generateSDKOption = generateSDKOption(configMgr);
        commonSDKConfig(configMgr);
        VideoPlaySDKManager.getInstance().initDownloadSDKAsync(context.getApplicationContext(), generateSDKOption, sDKInitListener);
        listenAppLifecycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void innerInitSDK(Context context, SDKInitListener sDKInitListener, boolean z16, boolean z17) {
        IQQVideoSDKConfigMgr configMgr = getConfigMgr();
        SuperPlayerSdkOption generateSDKOption = generateSDKOption(configMgr);
        commonSDKConfig(configMgr);
        if (z16) {
            VideoPlaySDKManager.getInstance().initSDKAfterSystemPlayerAsync(context.getApplicationContext(), generateSDKOption, sDKInitListener, z17);
        } else {
            VideoPlaySDKManager.getInstance().initSDKAsync(context.getApplicationContext(), generateSDKOption, sDKInitListener);
        }
        SuperPlayerSDKMgr.initSDKForTVK(BaseApplication.getContext(), WATCH_TOGETHER_APP_KEY, getUin());
        listenAppLifecycle();
    }

    public static boolean isDownLoadSoExits() {
        return LoadSoUtil.isDownloadSoExist();
    }

    public static boolean isDownloadSDKReady() {
        return VideoPlaySDKManager.getInstance().isDownloadSDKReady();
    }

    private static boolean isInHdrWhiteList(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String trim = str2.trim();
            if (!trim.contains(",")) {
                return str.equals(trim);
            }
            for (String str3 : trim.split(",")) {
                if (str.equals(str3)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isMonetLoadSuccess() {
        return sMonetLoadSuccess;
    }

    public static boolean isSDKReady() {
        return VideoPlaySDKManager.getInstance().isSDKReady();
    }

    public static boolean isSoExits() {
        return LoadSoUtil.isAllSoExist();
    }

    public static boolean isSoLoadSucess() {
        return VideoPlaySDKManager.getInstance().isSoLoadSuc();
    }

    public static boolean isTpCoreSoExits() {
        return LoadSoUtil.isTpCoreSoExist();
    }

    private static void listenAppLifecycle() {
        boolean z16;
        try {
            z16 = getConfigMgr().getAliveEnable();
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "listenAppLifecycle: ", e16);
            }
            z16 = false;
        }
        if (z16) {
            return;
        }
        if (MobileQQ.sProcessId == 1) {
            Foreground.addActivityLifeCallback(sAppLifecycleCallback);
        } else {
            ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager.4
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        Foreground.addActivityLifeCallback(QQVideoPlaySDKManager.sAppLifecycleCallback);
                    }
                }
            }, 2000L);
        }
    }

    private static void loadQimeiAsync() {
        o.d(new b());
    }

    public static boolean needUseSystemPlayer() {
        if (isSDKReady()) {
            return !isSoLoadSucess();
        }
        return !isSoExits();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void onProcessBackground() {
        SuperPlayerSDKMgr.notifyAppBackground();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void onProcessForeground() {
        SuperPlayerSDKMgr.notifyAppForeground();
    }

    public static void predownloadSo() {
        LoadSoUtil.preloadSo();
    }
}
