package com.qzone.app;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.telephony.PhoneStateListener;
import android.view.accessibility.AccessibilityManager;
import com.qzone.album.business.downloader.DownloadQueue;
import com.qzone.common.account.LoginData;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.IThreadPool;
import com.qzone.common.event.e;
import com.qzone.detail.business.service.QZoneDetailService;
import com.qzone.feed.business.service.QZoneFeedService;
import com.qzone.misc.network.report.QzoneFeedVisitorReportService;
import com.qzone.misc.network.uploader.report.BusinessReport;
import com.qzone.proxy.covercomponent.CoverComponentProxy;
import com.qzone.proxy.feedcomponent.manager.QZoneVideoLoader;
import com.qzone.publish.business.publishqueue.QZonePublishQueue;
import com.qzone.publish.business.publishqueue.QZoneReportTaskQueue;
import com.qzone.publish.outbox.Outbox;
import com.qzone.reborn.albumx.qzone.local.QZoneUploadRecommendDirector;
import com.qzone.util.SystemTools;
import com.qzone.util.q;
import com.qzone.util.x;
import com.qzone.widget.QZoneCustomToast;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.image.ArtDecoder;
import com.tencent.component.media.image.IDecoder;
import com.tencent.component.media.image.ImageManager;
import com.tencent.component.network.utils.thread.PriorityThreadPool;
import com.tencent.component.network.utils.thread.ThreadPool;
import com.tencent.image.JpegExifReader;
import com.tencent.mobileqq.activity.miniaio.MiniMsgIPCClient;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv;
import com.tencent.mobileqq.servlet.QZoneNotifyServlet;
import com.tencent.mobileqq.startup.step.DtSdkInitStep;
import com.tencent.mobileqq.startup.step.InitSkin;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.vas.adapter.ThemeFontAdapter;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.wink.api.IWinkMultiExportAPI;
import com.tencent.mobileqq.winkpublish.WinkPublishHelper2;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.pubaccount.publish.PubAccountTaskQueue;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.QQCrashReportManager;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.theme.SkinEngine;
import com.tencent.upload.uinterface.UploadServiceBuilder;
import common.config.service.QzoneConfig;
import cooperation.qzone.CrashGuard;
import cooperation.qzone.QUA;
import cooperation.qzone.QZoneCrashHandler;
import cooperation.qzone.QZoneVideoCommonUtils;
import cooperation.qzone.UploadEnv;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.cache.SDCardMountMonitorReceiver;
import cooperation.qzone.report.QzoneOnlineTimeCollectRptService;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.statistic.access.WnsCollector;
import cooperation.qzone.statistic.serverip.WebAppIpManager;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.PerfTracer;
import cooperation.qzone.util.QZLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.app.IToolProcEventListener;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneAppInterface extends AppRuntime implements IToolProcEventListener {
    private static final int DELAY_CLEAR_CACHE_ON_BACK = 8000;
    public static final String TAG = "QZoneAppInterface";
    private static MobileQQ appContext = null;
    public static boolean firstCreate = true;
    public static boolean keepAlive = false;
    public static boolean reactEnvAlive = false;
    private int activityNum;
    private PhoneStateListener mPhoneStateListener;
    private g memoryClearManger;
    private long uin;
    public static AtomicInteger activetyNum = new AtomicInteger(0);
    public static boolean canSetLayoutFactry = false;
    private static boolean mIsForeground = false;
    private static Boolean isCurrentVersionFirstLaunchActivity = null;
    private static Boolean isCurrentVersionFirstLaunch = null;
    private boolean isLoaded = false;
    private boolean isActivityCreated = false;
    protected CrashGuard.CrashListener crashHandle = new e();
    private Runnable mReportRunnable = new Runnable() { // from class: com.qzone.app.QZoneAppInterface.6
        @Override // java.lang.Runnable
        public void run() {
            QzoneFeedVisitorReportService.f().l();
            LpReportManager.getInstance().startReportImediately(2);
            if (QZLog.isColorLevel()) {
                QZLog.i("LocalDataReportManager", "smartReport begin");
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (QZLog.isColorLevel()) {
                QZLog.i("LocalDataReportManager", "smartReport end cost:" + (System.currentTimeMillis() - currentTimeMillis));
            }
            WnsCollector.Instance().flush();
            UploadServiceBuilder.getInstance().setBackgroundMode(true);
            q.d().i();
        }
    };
    private Runnable mCheckAccessibilityRunnable = new Runnable() { // from class: com.qzone.app.QZoneAppInterface.7
        @Override // java.lang.Runnable
        public void run() {
            QZoneAppInterface.this.checkAccessibility();
        }
    };
    private Runnable mClearCacheRunnable = new Runnable() { // from class: com.qzone.app.QZoneAppInterface.8
        @Override // java.lang.Runnable
        public void run() {
            ImageManager.getInstance().checkCleanImageLocalFile();
            CacheManager.checkAndCleanStorage();
            try {
                QZoneDetailService.U().O();
                i5.a.s().j();
                i5.b.e().d();
                t5.a.e().b();
            } catch (Exception e16) {
                e16.printStackTrace();
                QZLog.w(e16);
            }
        }
    };
    private Runnable mKillPictureProcessRunnable = new Runnable() { // from class: com.qzone.app.QZoneAppInterface.9
        @Override // java.lang.Runnable
        public void run() {
            SystemTools.d();
        }
    };
    Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = new Application.ActivityLifecycleCallbacks() { // from class: com.qzone.app.QZoneAppInterface.14
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            QZoneAppInterface.this.activityNum++;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            QZoneAppInterface qZoneAppInterface = QZoneAppInterface.this;
            qZoneAppInterface.activityNum--;
            if (QZoneAppInterface.this.activityNum <= 0) {
                QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).post(new Runnable() { // from class: com.qzone.app.QZoneAppInterface.14.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MiniMsgIPCClient.getInstance().clearBusiness(1);
                    }
                });
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }
    };
    private BroadcastReceiver mThemeChangeReceiver = new c();

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements IThreadPool {

        /* compiled from: P */
        /* renamed from: com.qzone.app.QZoneAppInterface$a$a, reason: collision with other inner class name */
        /* loaded from: classes39.dex */
        class C0354a implements ThreadPool.Job<Object> {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Runnable f44426d;

            C0354a(Runnable runnable) {
                this.f44426d = runnable;
            }

            @Override // com.tencent.component.network.utils.thread.ThreadPool.Job
            public Object run(ThreadPool.JobContext jobContext) {
                this.f44426d.run();
                return null;
            }
        }

        a() {
        }

        @Override // com.qzone.common.event.IThreadPool
        public void submit(Runnable runnable) {
            PriorityThreadPool.getDefault().submit(new C0354a(runnable));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b implements e.b {
        b() {
        }

        @Override // com.qzone.common.event.e.b
        public void onScreenOff() {
            if (QZLog.isColorLevel()) {
                QZLog.d("QzoneOnlineTimeCollectRptService", 2, "onScreenOff");
            }
            QzoneOnlineTimeCollectRptService.getInstance().closeTrace();
        }

        @Override // com.qzone.common.event.e.b
        public void onScreenOn() {
            if (QZLog.isColorLevel()) {
                QZLog.d("QzoneOnlineTimeCollectRptService", 2, "onScreenOn  isBackground_Stop:" + QZoneAppInterface.this.isBackgroundStop);
            }
            if (QZoneAppInterface.this.isBackgroundStop) {
                return;
            }
            QzoneOnlineTimeCollectRptService.getInstance().beginTrace(0);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class e implements CrashGuard.CrashListener {
        e() {
        }

        @Override // cooperation.qzone.CrashGuard.CrashListener
        public void onCrashHandle(Throwable th5) {
            WebAppIpManager.getInstance().persistence();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkAccessibility() {
        boolean z16;
        MobileQQ mobileQQ = appContext;
        if (mobileQQ != null) {
            try {
                AccessibilityManager accessibilityManager = (AccessibilityManager) mobileQQ.getSystemService("accessibility");
                List<AccessibilityServiceInfo> enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(-1);
                boolean z17 = true;
                if (enabledAccessibilityServiceList != null) {
                    Iterator<AccessibilityServiceInfo> it = enabledAccessibilityServiceList.iterator();
                    while (it.hasNext()) {
                        String id5 = it.next().getId();
                        if (id5 != null && (id5.contains("com.google") || id5.contains("com.bjbyhd.voiceback") || id5.contains("com.dianming.phoneapp") || id5.contains("com.archermind.android.marvin.voiceback") || id5.contains("com.nirenr.talkman") || id5.contains("net.tatans.soundback"))) {
                            z16 = true;
                            break;
                        }
                    }
                }
                z16 = false;
                if (QZLog.isColorLevel()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("accessibilityManager isEnabled ");
                    sb5.append(accessibilityManager.isEnabled() && z16);
                    QZLog.d(QZLog.TO_DEVICE_TAG, 1, sb5.toString());
                }
                if (!z16 || !accessibilityManager.isEnabled()) {
                    z17 = false;
                }
                u5.a.g(z17);
            } catch (Throwable th5) {
                u5.a.g(false);
                QZLog.e(QZLog.TO_DEVICE_TAG, "accessibilityManager isEnabled false", th5);
            }
        }
    }

    static void checkHuaweiNetworkState() {
        if (Build.MANUFACTURER.toLowerCase().equals(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HUAWEI)) {
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.app.QZoneAppInterface.11
                @Override // java.lang.Runnable
                public void run() {
                    if (AppNetConnInfo.isNetSupport()) {
                        return;
                    }
                    AppNetConnInfo.checkNetEvent();
                }
            });
        }
    }

    public static void initActivityStartParameters() {
        if (isCurrentVersionFirstLaunchActivity == null) {
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).post(new Runnable() { // from class: com.qzone.app.QZoneAppInterface.12
                @Override // java.lang.Runnable
                public void run() {
                    QZoneAppInterface.isCurrentVersionFirstLaunchActivity = Boolean.valueOf(!QUA.getQUA3().equals(u5.b.h0("isCurrentVersionFirstLaunchActivity", null)));
                    if (QZoneAppInterface.isCurrentVersionFirstLaunchActivity.booleanValue()) {
                        u5.b.v0("isCurrentVersionFirstLaunchActivity", QUA.getQUA3());
                        QZLog.i(QZoneAppInterface.TAG, 1, "\u5f53\u524d\u7248\u672c\u9996\u6b21\u542f\u52a8\u7a7a\u95f4\u9875\u9762 isCurrentVersionFirstLaunchActivity\uff1a", QZoneAppInterface.isCurrentVersionFirstLaunchActivity);
                    }
                }
            });
        } else {
            isCurrentVersionFirstLaunchActivity = Boolean.FALSE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initAppInterface() {
        if (firstCreate) {
            PerfTracer.traceStart(PerfTracer.RUNTIME_FIRST_INIT);
            JpegExifReader.initJpegExifReader(new d());
            QzoneConfig.getInstance().loadAllConfigs();
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(this.mCheckAccessibilityRunnable);
            CrashGuard.getInstance().onAppLaunch(LoginData.getInstance().getUin(), QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).getHandler(), this.crashHandle);
            UploadEnv uploadEnv = new UploadEnv();
            UploadServiceBuilder.init(BaseApplication.getContext(), new r7.b(), new r7.d(), new r7.e(), uploadEnv, uploadEnv, null);
            registerScreenStateReceiver();
            SDCardMountMonitorReceiver.getInstance().registerReceiver();
            so.c.a().b();
            QZoneFeedAlertService.getInstance().registerVipInfoBocastReveiver();
            String lastCrashInf = QZoneCrashHandler.getLastCrashInf();
            if (lastCrashInf != null) {
                QZLog.e("crash", "[lastCrashInfo]" + lastCrashInf);
            }
            try {
                ThemeFontAdapter.x(appContext);
                CacheManager.initiate(LoginData.getInstance().getUin());
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            e8.f.a().b().init();
            x.d();
            QQHeadChangeReceiver.a().b();
            QZLog.i(QZLog.TO_DEVICE_TAG, 1, "QzoneAppInterface  process=" + BaseApplicationImpl.getApplication().getQQProcessName());
            MyAppApi.m0();
            PerfTracer.traceEnd(PerfTracer.RUNTIME_FIRST_INIT);
        }
        PerfTracer.traceStart(PerfTracer.RUNTIME_BUSINESS_ONLOGIN);
        onLogin();
        QZoneVideoLoader.t();
        QZonePublishQueue.w().W();
        PubAccountTaskQueue.t().P();
        DownloadQueue.j().D();
        WebAppIpManager.getInstance().report();
        if (com.qzone.reborn.configx.g.f53821a.b().R1()) {
            QZoneVideoCommonUtils.getTrimSupport();
        }
        PerfTracer.traceEnd(PerfTracer.RUNTIME_BUSINESS_ONLOGIN);
        if (com.qzone.reborn.feedpro.utils.d.f54318a.b()) {
            QLog.d(TAG, 1, "init, qzone process, feedPro kmp");
            ((IQQKuiklyService) QRoute.api(IQQKuiklyService.class)).startKMPCore();
        }
    }

    private void initLocalRecommend() {
        if (com.qzone.reborn.albumx.qzone.local.g.f52662a.b()) {
            RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.qzone.app.e
                @Override // java.lang.Runnable
                public final void run() {
                    QZoneAppInterface.lambda$initLocalRecommend$0();
                }
            }, 3000L);
        } else {
            RFWLog.e("MediaRecommend_QZoneUploadRecommendDirector", RFWLog.USR, "initLocalRecommend but wns close");
        }
    }

    private void initStartupParameters() {
        if (isCurrentVersionFirstLaunch == null) {
            Boolean valueOf = Boolean.valueOf(!QUA.getQUA3().equals(u5.b.h0("isCurrentVersionFirstLaunch", null)));
            isCurrentVersionFirstLaunch = valueOf;
            if (valueOf.booleanValue()) {
                u5.b.v0("isCurrentVersionFirstLaunch", QUA.getQUA3());
            }
            QZLog.i(TAG, 1, "***********\u542f\u52a8\u7a7a\u95f4\u8fdb\u7a0b**********,\u5f53\u524d\u7248\u672c\u9996\u6b21\u542f\u52a8isCurrentVersionFirstLaunch\uff1a", isCurrentVersionFirstLaunch);
            return;
        }
        QZLog.e(TAG, 1, "wtf, initStartupParameters only be called once");
    }

    public static boolean isFirstEnterActivity() {
        Boolean bool = isCurrentVersionFirstLaunchActivity;
        if (bool == null) {
            QZLog.e(TAG, 1, "isCurrentVersionFirstLaunchActivity \u6ca1\u6709\u521d\u59cb\u5316\uff0c\u8fd4\u56defalse");
            return false;
        }
        return bool.booleanValue();
    }

    public static boolean isRunningForeground() {
        return mIsForeground;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$initLocalRecommend$0() {
        QZoneUploadRecommendDirector a16 = QZoneUploadRecommendDirector.INSTANCE.a();
        a16.B();
        RFWLog.d("MediaRecommend_QZoneUploadRecommendDirector", RFWLog.USR, "initLocalRecommend instance:" + a16);
    }

    private void registerScreenStateReceiver() {
        if (!com.qzone.common.event.e.b().d()) {
            com.qzone.common.event.e.b().c(appContext);
        }
        com.qzone.common.event.e.b().f(new b());
    }

    public void cancelKillPictureProcess() {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).removeTask(this.mKillPictureProcessRunnable);
    }

    public void destroy() {
        onLogout();
    }

    public void exitProcess() {
        QZoneFeedAlertService.getInstance().setPushCount(1, 0);
        QZLog.e(QZLog.TO_DEVICE_TAG, "exitProcess call,destroy()");
        destroy();
        try {
            e8.f.a().b().release();
        } catch (Throwable th5) {
            QZLog.e(TAG, "music exit error", th5);
        }
        try {
            MsfServiceSdk.get().unRegisterMsfService();
            MsfServiceSdk.get().unbindMsfService();
            QZoneCommBroadReceiver.b().a(appContext);
            SDCardMountMonitorReceiver.getInstance().unregisterReceiver();
            so.c.a().c();
            QZoneFeedAlertService.getInstance().unRegisterVipInfoBocastReveiver();
            QQHeadChangeReceiver.a().c();
            if (com.qzone.common.event.e.b().d()) {
                com.qzone.common.event.e.b().h();
            }
            ThemeFontAdapter.D(appContext);
        } catch (Exception e16) {
            QZLog.e(TAG, "exception:", e16);
        }
        SystemTools.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppRuntime
    public void exitToolProc() {
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_DELAY_QUIT_POC, 1) == 1) {
            onDestroy();
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).postDelayed(new Runnable() { // from class: com.qzone.app.QZoneAppInterface.13
                @Override // java.lang.Runnable
                public void run() {
                    km.a.f412646a.d();
                }
            }, 900L);
        } else {
            super.exitToolProc();
        }
    }

    @Override // mqq.app.AppRuntime
    public BaseApplication getApp() {
        return BaseApplication.getContext();
    }

    @Override // mqq.app.AppRuntime
    public String getCurrentAccountUin() {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime != null) {
            return runtime.getAccount();
        }
        return null;
    }

    @Override // mqq.app.AppRuntime
    public Manager getManager(int i3) {
        Manager manager = super.getManager(i3);
        if (manager != null) {
            return manager;
        }
        if (i3 == QQManagerFactory.DOWNLOADER_FACTORY) {
            manager = new DownloaderFactory(this);
        }
        if (manager != null) {
            addManager(i3, manager);
        }
        return manager;
    }

    @Override // mqq.app.AppRuntime
    public String getModuleId() {
        return "qzone_plugin.apk";
    }

    public boolean isLoaded() {
        return this.isLoaded;
    }

    public void onActivityCreate() {
        if (this.isActivityCreated) {
            return;
        }
        this.isActivityCreated = true;
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).postDelayed(new Runnable() { // from class: com.qzone.app.QZoneAppInterface.4
            @Override // java.lang.Runnable
            public void run() {
                QZoneUpdateService.b().d();
                BusinessReport.d();
                Outbox.C().D(QZoneAppInterface.this.uin);
                t5.a.e().j();
                QZoneVideoLoader.p();
            }
        }, 1000L);
    }

    @Override // mqq.app.IToolProcEventListener
    public void onBeforeExitProc() {
        exitProcess();
    }

    @Override // mqq.app.AppRuntime
    public void onCreate(Bundle bundle) {
        PerfTracer.traceStart(PerfTracer.RUNTIME_ONCREATE);
        PerfTracer.traceStart(PerfTracer.RUNTIME_SUPER_ONCREATE);
        super.onCreate(bundle);
        PerfTracer.traceEnd(PerfTracer.RUNTIME_SUPER_ONCREATE);
        firstCreate = appContext == null;
        QZLog.i(QZLog.TO_DEVICE_TAG, 1, "QZoneAppInterface onCreate isFirst:" + firstCreate + ",theadid=" + Thread.currentThread().getId());
        PerfTracer.traceStart(PerfTracer.RUNTIME_INIT_SKIN);
        if (!InitSkin.sInited) {
            InitSkin.startInitSkinEngine();
        } else {
            QZLog.i(QZLog.TO_DEVICE_TAG, 2, "skin engine has inited, just return");
        }
        PerfTracer.traceEnd(PerfTracer.RUNTIME_INIT_SKIN);
        initStartupParameters();
        appContext = getApplication();
        LoginData.getInstance().setApp(this);
        if (firstCreate) {
            ImageManagerEnv.init(appContext, new ImageEnvImpl(), new ImageLogger());
        }
        BaseApplicationImpl.getApplication().registerActivityLifecycleCallbacks(this.activityLifecycleCallbacks);
        EventCenter.setThreadPool(new a());
        EventCenter.getInstance();
        com.qzone.album.env.common.b.a();
        QZoneVideoLoader.r();
        PerfTracer.traceStart(PerfTracer.RUNTIME_FEED_ENV_INIT);
        com.qzone.proxy.feedcomponent.e.c(BaseApplication.getContext(), getApplication());
        PerfTracer.traceEnd(PerfTracer.RUNTIME_FEED_ENV_INIT);
        try {
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.app.QZoneAppInterface.2
                @Override // java.lang.Runnable
                public void run() {
                    if (!com.qzone.reborn.configx.g.f53821a.b().C1()) {
                        PerfTracer.traceStart(PerfTracer.RUNTIME_VIDEO_INIT);
                        FeedVideoEnv.preloadResource(FeedVideoEnv.feedResources, FeedVideoEnv.externalFunc);
                        PerfTracer.traceEnd(PerfTracer.RUNTIME_VIDEO_INIT);
                    }
                    QZoneAppInterface.this.initAppInterface();
                }
            });
        } catch (Throwable th5) {
            QZLog.w(th5);
        }
        QZoneCommBroadReceiver.b().e(BaseApplication.getContext());
        PerfTracer.traceEnd(PerfTracer.RUNTIME_ONCREATE);
        this.memoryClearManger = new g();
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_MINI_AIO, true)) {
            MiniMsgIPCClient.register();
        }
        BaseApplication.getContext().registerReceiver(this.mThemeChangeReceiver, new IntentFilter(SkinEngine.ACTION_THEME_INVALIDATE), "com.tencent.msg.permission.pushnotify", null);
        DtSdkInitStep.initDTSDK(0);
        j.d();
        initLocalRecommend();
        try {
            QQSysAndEmojiResMgr.getInstance().checkInitConfig();
        } catch (Throwable th6) {
            RFWLog.e(TAG, RFWLog.USR, th6);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppRuntime
    public void onDestroy() {
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_MINI_AIO, true)) {
            MiniMsgIPCClient.unregister();
        }
        WinkPublishHelper2.INSTANCE.unBindService();
        try {
            BaseApplicationImpl.getApplication().unregisterActivityLifecycleCallbacks(this.activityLifecycleCallbacks);
            BaseApplicationImpl.getApplication().unregisterReceiver(this.mThemeChangeReceiver);
        } catch (Throwable th5) {
            QZLog.e(TAG, "exception: ", th5);
        }
        super.onDestroy();
    }

    public void onLogin() {
        long uin = LoginData.getInstance().getUin();
        long j3 = this.uin;
        if (j3 == uin) {
            if (this.isLoaded) {
                return;
            }
            this.isLoaded = true;
            return;
        }
        if (j3 != 0) {
            QZLog.i(QZLog.TO_DEVICE_TAG, 1, "QBSvc.onLogin curUin:" + com.qzone.util.b.a(this.uin) + " newUin:" + com.qzone.util.b.a(uin));
            onLogout();
            QZoneFeedService.U().o(uin, uin);
            try {
                StatisticCollector.getInstance(BaseApplication.getContext()).setContact(String.valueOf(uin));
                QQCrashReportManager.d(String.valueOf(uin));
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        this.uin = uin;
        this.isLoaded = true;
    }

    public void onLogout() {
        if (this.uin == 0) {
            return;
        }
        if (LoginData.getInstance().getUin() == this.uin) {
            QZLog.i(QZLog.TO_DEVICE_TAG, 1, "QBSvc.onLogout cancel");
            return;
        }
        QZLog.i(QZLog.TO_DEVICE_TAG, 1, "QBSvc.onLogout curUin:" + com.qzone.util.b.a(this.uin));
        this.uin = 0L;
        CoverComponentProxy.f50099g.getServiceInterface().setLoginUserCoverUrl(null);
        Outbox.C().A();
        QZonePublishQueue.w().V();
        PubAccountTaskQueue.t().O();
        com.qzone.component.cache.database.c.g().b();
        e8.f.a().b().clear();
        EventCenter.getInstance().post("Runtime", 2);
        this.isLoaded = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppRuntime
    public void onRunningBackground() {
        super.onRunningBackground();
        QzoneOnlineTimeCollectRptService.getInstance().closeTrace();
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.ReportThread).post(this.mReportRunnable);
        if (SystemTools.b()) {
            QZLog.i(QZLog.TO_DEVICE_TAG, 1, "QzoneAppInterface onRunningBackground qzone extra process is forground");
            return;
        }
        QZLog.i(QZLog.TO_DEVICE_TAG, 1, "QzoneAppInterface onRunningBackground mIsForeground:" + mIsForeground);
        mIsForeground = false;
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).postDelayed(this.mKillPictureProcessRunnable, 8000L);
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).postDelayed(this.mClearCacheRunnable, 8000L);
        QZoneReportTaskQueue.h().o();
        IDecoder decoder = ImageManager.getInstance().getDecoder();
        if (decoder != null && (decoder instanceof ArtDecoder)) {
            ArtDecoder artDecoder = (ArtDecoder) decoder;
            QZLog.i(TAG, "hitCount:" + artDecoder.getHitCount() + ",miss:" + artDecoder.getMissCount() + ",expectSize:" + artDecoder.getTotalExpectSize() + ",realSize:" + artDecoder.getTotalRealSize());
        }
        QZoneCustomToast.a();
        QzonePreloadCustomResources.i(BaseApplication.getContext());
        try {
            QZoneVideoLoader.l().v(true);
        } catch (Exception e16) {
            QZLog.e(TAG, "", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppRuntime
    public void onRunningForeground() {
        super.onRunningForeground();
        QZLog.i(QZLog.TO_DEVICE_TAG, 1, "QzoneAppInterface onRunningForeground mIsForeground:" + mIsForeground);
        MyAppApi.b0();
        QzoneOnlineTimeCollectRptService.getInstance().beginTrace(0);
        if (mIsForeground) {
            return;
        }
        mIsForeground = true;
        checkHuaweiNetworkState();
        checkAccessibility();
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).removeTask(this.mReportRunnable);
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).removeTask(this.mKillPictureProcessRunnable);
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).removeTask(this.mClearCacheRunnable);
        Intent intent = new Intent("tencent.notify.foreground");
        intent.setPackage(BaseApplication.getContext().getPackageName());
        intent.putExtra("selfuin", LoginData.getInstance().getUinString());
        try {
            appContext.sendBroadcast(intent, "com.tencent.msg.permission.pushnotify");
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        QZoneReportTaskQueue.h().p();
        QZoneVideoLoader.l().v(false);
    }

    public void setLoaded(boolean z16) {
        this.isLoaded = z16;
    }

    @Override // mqq.app.IToolProcEventListener
    public boolean onReceiveAccountAction(String str, Intent intent) {
        QZLog.d(TAG, 1, "onReceiveAccountAction...");
        return false;
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class c extends BroadcastReceiver {
        c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getIntExtra("pid", Process.myPid()) == Process.myPid()) {
                com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface().onThemeColorChange();
                QZoneNotifyServlet.l();
            }
        }
    }

    @Override // mqq.app.IToolProcEventListener
    public boolean onReceiveLegalExitProcAction(Intent intent) {
        QZLog.d(TAG, 1, "onReceiveLegalExitProcAction... qzone:", Boolean.valueOf(QZonePublishQueue.w().F()), " pub:", Boolean.valueOf(PubAccountTaskQueue.t().y()), " keepAlive=", Boolean.valueOf(keepAlive), " hasWinkVideoTask=", Boolean.valueOf(((IWinkMultiExportAPI) QRoute.api(IWinkMultiExportAPI.class)).hasRunningTask()));
        if ((QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_EXIT_IF_FORGROUD, 1) != 1 || (!keepAlive && !mIsForeground && !QZonePublishQueue.w().F() && !PubAccountTaskQueue.t().y())) && !((IWinkMultiExportAPI) QRoute.api(IWinkMultiExportAPI.class)).hasRunningTask()) {
            return false;
        }
        QZLog.e(QZLog.TO_DEVICE_TAG, 1, "error kill qzone");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class d implements JpegExifReader.JpegExifReaderInterface {
        d() {
        }

        @Override // com.tencent.image.JpegExifReader.JpegExifReaderInterface
        public boolean readEnableFromDPC() {
            return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_USE_JPEG_EXIF_READER, 1) == 1;
        }

        @Override // com.tencent.image.JpegExifReader.JpegExifReaderInterface
        public void doReport(String str, String str2, boolean z16, long j3, long j16, HashMap<String, String> hashMap, String str3) {
        }
    }
}
