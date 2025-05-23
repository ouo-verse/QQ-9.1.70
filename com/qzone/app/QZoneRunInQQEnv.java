package com.qzone.app;

import android.content.Context;
import com.qzone.album.business.downloader.DownloadQueue;
import com.qzone.common.account.LoginData;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.IThreadPool;
import com.qzone.feed.business.service.QZoneFeedService;
import com.qzone.proxy.covercomponent.CoverComponentProxy;
import com.qzone.proxy.feedcomponent.manager.QZoneVideoLoader;
import com.qzone.publish.business.publishqueue.QZonePublishQueue;
import com.qzone.publish.outbox.Outbox;
import com.qzone.reborn.comment.utils.cachedata.QZoneCommentCacheDataHelper;
import com.qzone.reborn.runtime.QZoneRuntime;
import com.qzone.util.x;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.network.utils.thread.PriorityThreadPool;
import com.tencent.component.network.utils.thread.ThreadPool;
import com.tencent.image.JpegExifReader;
import com.tencent.mobileqq.activity.miniaio.MiniMsgIPCClient;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv;
import com.tencent.mobileqq.service.qzone.QZoneTitleTabManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.pubaccount.publish.PubAccountTaskQueue;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.QQCrashReportManager;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.upload.uinterface.UploadServiceBuilder;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneCrashHandler;
import cooperation.qzone.UploadEnv;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.cache.SDCardMountMonitorReceiver;
import cooperation.qzone.statistic.serverip.WebAppIpManager;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.PerfTracer;
import cooperation.qzone.util.QZLog;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneRunInQQEnv {
    private static final String TAG = "QZoneRunInQQEnv";
    private static boolean sInit = false;
    private static boolean sIsLogin = false;
    private static long sUin;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements IThreadPool {

        /* compiled from: P */
        /* renamed from: com.qzone.app.QZoneRunInQQEnv$a$a, reason: collision with other inner class name */
        /* loaded from: classes39.dex */
        class C0355a implements ThreadPool.Job<Object> {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Runnable f44444d;

            C0355a(Runnable runnable) {
                this.f44444d = runnable;
            }

            @Override // com.tencent.component.network.utils.thread.ThreadPool.Job
            public Object run(ThreadPool.JobContext jobContext) {
                this.f44444d.run();
                return null;
            }
        }

        a() {
        }

        @Override // com.qzone.common.event.IThreadPool
        public void submit(Runnable runnable) {
            PriorityThreadPool.getDefault().submit(new C0355a(runnable));
        }
    }

    public static synchronized boolean init(AppRuntime appRuntime) {
        synchronized (QZoneRunInQQEnv.class) {
            QLog.d(TAG, 1, "start init, sInit: " + sInit);
            if (sInit) {
                return true;
            }
            try {
                jo.h hVar = jo.h.f410717a;
                hVar.h("qzone_init").t("START_INIT");
                QZoneRuntime.j().l();
                LoginData.getInstance().setMainApp(appRuntime);
                final MobileQQ application = appRuntime.getApplication();
                ImageManagerEnv.init(application, new ImageEnvImpl(), new ImageLogger());
                EventCenter.setThreadPool(new a());
                EventCenter.getInstance();
                hVar.h("qzone_init").x("FEED_VIDEO_INIT");
                QZoneVideoLoader.r();
                hVar.h("qzone_init").m("FEED_VIDEO_INIT");
                com.qzone.proxy.feedcomponent.e.c(BaseApplication.getContext(), application);
                QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.app.QZoneRunInQQEnv.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            FeedVideoEnv.preloadResource(FeedVideoEnv.feedResources, FeedVideoEnv.externalFunc);
                            QZoneRunInQQEnv.initAppInterface(application);
                            ResourcePreloader.b().g();
                        } catch (Throwable th5) {
                            QZLog.w(th5);
                        }
                    }
                });
                QZoneCommBroadReceiver.b().e(BaseApplication.getContext());
                if (QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_MINI_AIO, true)) {
                    MiniMsgIPCClient.register();
                }
                j.d();
                sInit = true;
                hVar.h("qzone_init").t("FINISH_INIT");
            } catch (Throwable th5) {
                QZLog.w(TAG, "init: failed ", th5);
            }
            return sInit;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void initAppInterface(Context context) {
        JpegExifReader.initJpegExifReader(new b());
        QzoneConfig.getInstance().loadAllConfigs();
        UploadEnv uploadEnv = new UploadEnv();
        UploadServiceBuilder.init(BaseApplication.getContext(), new r7.b(), new r7.d(), new r7.e(), uploadEnv, uploadEnv, null);
        SDCardMountMonitorReceiver.getInstance().registerReceiver();
        so.c.a().b();
        QZoneFeedAlertService.getInstance().registerVipInfoBocastReveiver();
        String lastCrashInf = QZoneCrashHandler.getLastCrashInf();
        if (lastCrashInf != null) {
            QZLog.e("crash", "[lastCrashInfo]" + lastCrashInf);
        }
        CacheManager.initiate(LoginData.getInstance().getUin());
        e8.f.a().b().init();
        x.d();
        QQHeadChangeReceiver.a().b();
        ThreadManagerV2.post(new Runnable() { // from class: com.qzone.app.QZoneRunInQQEnv.4
            @Override // java.lang.Runnable
            public void run() {
                MyAppApi.b0();
            }
        }, 5, null, false);
        PerfTracer.traceEnd(PerfTracer.RUNTIME_FIRST_INIT);
        PerfTracer.traceStart(PerfTracer.RUNTIME_BUSINESS_ONLOGIN);
        onLogin();
        QZoneVideoLoader.t();
        QZonePublishQueue.w().W();
        PubAccountTaskQueue.t().P();
        DownloadQueue.j().D();
        WebAppIpManager.getInstance().report();
        QZoneTitleTabManager.d(LoginData.getInstance().getUinString());
        QZoneCommentCacheDataHelper.c().getCacheDataDelegate().b();
        oo.b.c();
        PerfTracer.traceEnd(PerfTracer.RUNTIME_BUSINESS_ONLOGIN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onLogout$0() {
        com.qzone.component.cache.database.c.g().b();
        e8.f.a().b().clear();
    }

    public static synchronized void onAccountChange(QQAppInterface qQAppInterface) {
        synchronized (QZoneRunInQQEnv.class) {
            if (!sInit) {
                init(qQAppInterface);
                return;
            }
            LoginData.getInstance().setUin(qQAppInterface.getLongAccountUin());
            setNickName(qQAppInterface);
            LoginData.getInstance().setMainApp(qQAppInterface);
            onLogin();
        }
    }

    public static synchronized void onLogin() {
        synchronized (QZoneRunInQQEnv.class) {
            long uin = LoginData.getInstance().getUin();
            long j3 = sUin;
            if (j3 == uin) {
                if (!sIsLogin) {
                    sIsLogin = true;
                }
                return;
            }
            if (j3 != 0) {
                QZLog.i(QZLog.TO_DEVICE_TAG, 1, "QBSvc.onLogin curUin:" + com.qzone.util.b.a(sUin) + " newUin:" + com.qzone.util.b.a(uin));
                onLogout();
                QZoneFeedService.U().o(uin, uin);
                try {
                    StatisticCollector.getInstance(BaseApplication.getContext()).setContact(String.valueOf(uin));
                    QQCrashReportManager.d(String.valueOf(uin));
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
            sUin = uin;
            sIsLogin = true;
        }
    }

    public static synchronized void onLogout() {
        synchronized (QZoneRunInQQEnv.class) {
            if (sUin == 0) {
                return;
            }
            if (LoginData.getInstance().getUin() == sUin) {
                QZLog.i(QZLog.TO_DEVICE_TAG, 1, "QBSvc.onLogout cancel");
                return;
            }
            QZLog.i(QZLog.TO_DEVICE_TAG, 1, "QBSvc.onLogout curUin:" + com.qzone.util.b.a(sUin));
            sUin = 0L;
            CoverComponentProxy.f50099g.getServiceInterface().setLoginUserCoverUrl(null);
            Outbox.C().A();
            QZonePublishQueue.w().V();
            if (com.qzone.reborn.configx.g.f53821a.b().j()) {
                RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.qzone.app.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        QZoneRunInQQEnv.lambda$onLogout$0();
                    }
                });
            } else {
                com.qzone.component.cache.database.c.g().b();
                e8.f.a().b().clear();
            }
            EventCenter.getInstance().post("Runtime", 2);
            sIsLogin = false;
        }
    }

    private static void setNickName(final QQAppInterface qQAppInterface) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.qzone.app.QZoneRunInQQEnv.5
            @Override // java.lang.Runnable
            public void run() {
                final String currentNickname = QQAppInterface.this.getCurrentNickname();
                QZLog.i(QZLog.TO_DEVICE_TAG, 4, "QBSvc.setNickName:" + com.tencent.util.k.d(currentNickname));
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.qzone.app.QZoneRunInQQEnv.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LoginData.getInstance().setNickName(currentNickname);
                    }
                });
            }
        }, 32, null, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b implements JpegExifReader.JpegExifReaderInterface {
        b() {
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
