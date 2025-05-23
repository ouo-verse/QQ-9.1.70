package com.tencent.mobileqq.vas.comm.api.impl;

import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.sdk.Agent;
import com.tencent.gamecenter.wadl.sdk.InitParam;
import com.tencent.gamecenter.wadl.sdk.downloader.Downloader;
import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTask;
import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTaskAttr;
import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTaskCategory;
import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTaskListener;
import com.tencent.gamecenter.wadl.util.k;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.vas.comm.api.IWadlSoDownloader;
import com.tencent.mobileqq.vip.g;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class WadlSoDownloaderImpl implements IWadlSoDownloader {
    private static final int MAX_RETRY_DOWNLOAD_CNT = 3;
    private static final int MAX_RETRY_DOWNLOAD_DELAY = 2000;
    private static final String REPORT_SCENE_DOWNLOAD_FLOW = "1000";
    private static final String SO_DOWNLOADER_SWITCH = "qqso_downloder_switch";
    private static final String TAG = "WadlSoDownloaderManager";
    private static final int WADL_DOWNLOADER_APPID = 11;
    private DownloaderTaskAttr downloaderTaskAttr;
    private Downloader mDownloader;
    private Runnable mRetryDownloadTask;
    private boolean mInitFlag = false;
    private final ConcurrentHashMap<String, AtomicInteger> downloadUrlRetryCntMap = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public g f308937a;

        /* renamed from: b, reason: collision with root package name */
        public long f308938b;

        b() {
        }
    }

    public WadlSoDownloaderImpl() {
        initDownloader();
    }

    private void clear(g gVar, DownloaderTask downloaderTask) {
        removeDownloadTask(downloaderTask.getUrl());
        if (!StringUtil.isEmpty(gVar.f313004c)) {
            this.downloadUrlRetryCntMap.remove(gVar.f313004c);
        }
        Runnable runnable = this.mRetryDownloadTask;
        if (runnable != null) {
            ThreadManagerV2.removeJob(runnable, 16);
            this.mRetryDownloadTask = null;
        }
    }

    private String getDownloadSaveDir(g gVar) {
        File parentFile;
        File file = gVar.f313010h.get(gVar.f313004c);
        if (file != null && (parentFile = file.getParentFile()) != null) {
            return parentFile.getAbsolutePath();
        }
        return "";
    }

    private String getDownloadSaveFileName(g gVar) {
        File file = gVar.f313010h.get(gVar.f313004c);
        if (file != null) {
            return file.getName();
        }
        return "";
    }

    private static WadlReportBuilder getReportBuilder() {
        WadlReportBuilder wadlReportBuilder = new WadlReportBuilder();
        wadlReportBuilder.setDcId(WadlProxyConsts.TAG_DC_00087).setOperModule("769").setOperId("208518").setModuleType("104705").setBussinessId("1").setPageId("160");
        return wadlReportBuilder;
    }

    private void initDownloader() {
        if (this.mInitFlag) {
            return;
        }
        this.mInitFlag = true;
        InitParam initParam = new InitParam(MobileQQ.sMobileQQ, 11);
        initParam.initDelegate(null, new com.tencent.mobileqq.vas.comm.api.impl.a(), new com.tencent.mobileqq.vas.comm.api.impl.b(), new k());
        Agent.init(initParam);
        Agent.enableLog(false);
        Downloader downloader = Agent.getDownloader(initParam);
        this.mDownloader = downloader;
        DownloaderTaskCategory downloaderTaskCategory = DownloaderTaskCategory.CATE_DEFAULT_EASE;
        downloader.setTaskNumForCategory(downloaderTaskCategory, 3);
        DownloaderTaskAttr downloaderTaskAttr = new DownloaderTaskAttr();
        this.downloaderTaskAttr = downloaderTaskAttr;
        downloaderTaskAttr.taskCategory = downloaderTaskCategory;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onTaskCompleted(b bVar, DownloaderTask downloaderTask, m03.a aVar) {
        g gVar = bVar.f308937a;
        if (gVar.g() != null) {
            gVar.f313006d = 0;
            gVar.f313015m = downloaderTask.getPercentage();
            gVar.f313013k = downloaderTask.getTotalLength();
            gVar.f313014l = downloaderTask.getReceivedLength();
            gVar.g().onDoneFile(gVar);
        }
        if (aVar != null) {
            aVar.onDownloadFinish(true);
        }
        clear(gVar, downloaderTask);
        reportFlow(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onTaskFail(final b bVar, DownloaderTask downloaderTask, final m03.a aVar) {
        g gVar = bVar.f308937a;
        AtomicInteger atomicInteger = this.downloadUrlRetryCntMap.get(gVar.f313004c);
        if (atomicInteger == null) {
            atomicInteger = new AtomicInteger(0);
            this.downloadUrlRetryCntMap.put(gVar.f313004c, atomicInteger);
        }
        int andIncrement = atomicInteger.getAndIncrement();
        QLog.e(TAG, 1, "onTaskFail currentRetry cnt: " + andIncrement);
        if (andIncrement < 3) {
            this.mRetryDownloadTask = ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.vas.comm.api.impl.WadlSoDownloaderImpl.1
                @Override // java.lang.Runnable
                public void run() {
                    WadlSoDownloaderImpl.this.startDownloadInner(bVar, aVar);
                }
            }, 192, null, true, 2000L);
            return;
        }
        if (gVar.g() != null) {
            gVar.f313006d = -1;
            gVar.g().onDoneFile(gVar);
        }
        if (aVar != null) {
            aVar.onDownloadFinish(false);
        }
        clear(gVar, downloaderTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onTaskPaused(g gVar, DownloaderTask downloaderTask) {
        if (gVar.g() != null) {
            gVar.f313006d = downloaderTask.getFailCode();
            gVar.f313015m = downloaderTask.getPercentage();
            gVar.g().onPause(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onTaskReceived(g gVar, DownloaderTask downloaderTask) {
        if (gVar.g() != null) {
            gVar.f313006d = downloaderTask.getFailCode();
            gVar.f313015m = downloaderTask.getPercentage();
            gVar.f313013k = downloaderTask.getTotalLength();
            gVar.f313014l = downloaderTask.getReceivedLength();
            gVar.g().onProgress(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onTaskStarted(b bVar, DownloaderTask downloaderTask) {
        g gVar = bVar.f308937a;
        if (gVar.g() != null) {
            gVar.f313006d = downloaderTask.getFailCode();
            gVar.f313015m = downloaderTask.getPercentage();
            bVar.f308938b = gVar.f313014l;
            gVar.g().onStart(gVar);
        }
    }

    private void removeDownloadTask(String str) {
        List<DownloaderTask> allTasks = this.mDownloader.getAllTasks();
        if (!TextUtils.isEmpty(str) && allTasks != null) {
            for (DownloaderTask downloaderTask : allTasks) {
                if (downloaderTask.getUrl().equals(str)) {
                    QLog.i(TAG, 2, "removeDownloadTask---delete unactive task, Id:" + downloaderTask.getId());
                    this.mDownloader.deleteTask(downloaderTask, false);
                    return;
                }
            }
        }
    }

    private void reportFlow(b bVar) {
        long j3 = bVar.f308937a.f313014l - bVar.f308938b;
        QLog.d(TAG, 1, "reportFlow flow=" + j3);
        if (j3 < 1) {
            return;
        }
        getReportBuilder().setExt(26, j3 + "").setExt(27, bVar.f308937a.f313004c).setExt(29, "1000").report();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int startDownloadInner(b bVar, m03.a aVar) {
        try {
            g gVar = bVar.f308937a;
            if (gVar == null) {
                QLog.e(TAG, 1, "download fail because soDownloadTask is null!");
                return -2;
            }
            if (gVar.j()) {
                QLog.e(TAG, 1, "download fail because soDownloadTask is canceled!");
                return 2;
            }
            String str = gVar.f313004c;
            String downloadSaveDir = getDownloadSaveDir(gVar);
            String downloadSaveFileName = getDownloadSaveFileName(gVar);
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "download originalUrl: " + str + ", saveDir: " + downloadSaveDir + ", filename: " + downloadSaveFileName);
            }
            if (!StringUtil.isEmpty(str) && !StringUtil.isEmpty(downloadSaveDir) && !StringUtil.isEmpty(downloadSaveFileName)) {
                DownloaderTask genDownloadTask = this.mDownloader.genDownloadTask(gVar.f313004c, downloadSaveDir, downloadSaveFileName, null, this.downloaderTaskAttr);
                genDownloadTask.addListener(new a(bVar, gVar, aVar));
                this.mDownloader.startDownload(genDownloadTask);
                return 0;
            }
            if (gVar.g() != null) {
                gVar.f313006d = -1;
                gVar.g().onDoneFile(gVar);
            }
            return -1;
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "startDownload: " + th5);
            return -1;
        }
    }

    @Override // com.tencent.mobileqq.vas.comm.api.IWadlSoDownloader
    public boolean isWadlDownloader() {
        try {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                QLog.e(TAG, 1, "AppRuntime is null");
                return false;
            }
            IFeatureRuntimeService iFeatureRuntimeService = (IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all");
            if (iFeatureRuntimeService == null) {
                QLog.e(TAG, 1, "IFeatureRuntimeService is null");
                return false;
            }
            boolean isFeatureSwitchEnable = iFeatureRuntimeService.isFeatureSwitchEnable(SO_DOWNLOADER_SWITCH, false);
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "wadl downloader isEnable: " + isFeatureSwitchEnable);
            }
            return isFeatureSwitchEnable;
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
            return false;
        }
    }

    @Override // com.tencent.mobileqq.vas.comm.api.IWadlSoDownloader
    public int startDownload(g gVar, m03.a aVar) {
        if (gVar == null) {
            QLog.e(TAG, 1, "download fail because soDownloadTask is null!");
            return -2;
        }
        if (gVar.j()) {
            QLog.e(TAG, 1, "download fail because soDownloadTask is canceled!");
            return 2;
        }
        if (!StringUtil.isEmpty(gVar.f313004c)) {
            this.downloadUrlRetryCntMap.remove(gVar.f313004c);
        }
        Runnable runnable = this.mRetryDownloadTask;
        if (runnable != null) {
            ThreadManagerV2.removeJob(runnable, 16);
            this.mRetryDownloadTask = null;
        }
        b bVar = new b();
        bVar.f308937a = gVar;
        bVar.f308938b = -1L;
        int startDownloadInner = startDownloadInner(bVar, aVar);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "downloadResult: " + startDownloadInner);
        }
        return startDownloadInner;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements DownloaderTaskListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f308933d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ g f308934e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ m03.a f308935f;

        a(b bVar, g gVar, m03.a aVar) {
            this.f308933d = bVar;
            this.f308934e = gVar;
            this.f308935f = aVar;
        }

        @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTaskListener
        public void onTaskCompletedSubloop(DownloaderTask downloaderTask) {
            downloaderTask.removeListener(this);
            WadlSoDownloaderImpl.this.onTaskCompleted(this.f308933d, downloaderTask, this.f308935f);
        }

        @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTaskListener
        public void onTaskFailedSubloop(DownloaderTask downloaderTask) {
            downloaderTask.removeListener(this);
            WadlSoDownloaderImpl.this.onTaskFail(this.f308933d, downloaderTask, this.f308935f);
        }

        @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTaskListener
        public void onTaskPausedSubloop(DownloaderTask downloaderTask) {
            downloaderTask.removeListener(this);
            WadlSoDownloaderImpl.this.onTaskPaused(this.f308934e, downloaderTask);
        }

        @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTaskListener
        public void onTaskReceivedSubloop(DownloaderTask downloaderTask) {
            WadlSoDownloaderImpl.this.onTaskReceived(this.f308934e, downloaderTask);
        }

        @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTaskListener
        public void onTaskStartedSubloop(DownloaderTask downloaderTask) {
            WadlSoDownloaderImpl.this.onTaskStarted(this.f308933d, downloaderTask);
        }

        @Override // com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTaskListener
        public void onTaskDetectedSubloop(DownloaderTask downloaderTask) {
        }
    }
}
