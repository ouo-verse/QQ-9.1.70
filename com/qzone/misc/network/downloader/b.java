package com.qzone.misc.network.downloader;

import android.text.TextUtils;
import com.qzone.common.config.service.QZoneConfigService;
import com.qzone.preview.service.PictureManager;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.downloader.DownloadReport;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.component.network.downloader.common.Utils;
import com.tencent.component.network.downloader.handler.ReportHandler;
import com.tencent.component.network.downloader.strategy.StrategyProvider;
import com.tencent.component.network.module.report.BusinessReport;
import com.tencent.component.network.module.report.ImageDownloadReporter;
import com.tencent.component.network.utils.thread.PriorityThreadFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.reborn.QZoneDownloadSharedPreferencesProvider;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.lp.LpReportInfo_DC01796;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes39.dex */
public class b {

    /* renamed from: e, reason: collision with root package name */
    private static b f48394e = null;

    /* renamed from: g, reason: collision with root package name */
    public static boolean f48396g = true;

    /* renamed from: a, reason: collision with root package name */
    Downloader f48398a;

    /* renamed from: b, reason: collision with root package name */
    private List<ReportHandler.DownloadReportObject> f48399b = Collections.synchronizedList(new ArrayList());

    /* renamed from: c, reason: collision with root package name */
    private Map<String, Pattern> f48400c = null;

    /* renamed from: d, reason: collision with root package name */
    private int f48401d = 0;

    /* renamed from: f, reason: collision with root package name */
    private static Object f48395f = new Object();

    /* renamed from: h, reason: collision with root package name */
    private static Random f48397h = new Random();

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a extends ImageDownloadReporter {
        a() {
        }

        @Override // com.tencent.component.network.module.report.ImageDownloadReporter, com.tencent.component.network.downloader.handler.ReportHandler
        public ReportHandler.DownloadReportObject obtainReportObj(DownloadResult downloadResult, DownloadReport downloadReport) {
            ReportHandler.DownloadReportObject obtainReportObj = super.obtainReportObj(downloadResult, downloadReport);
            b.this.h(obtainReportObj);
            b.this.i(downloadResult, downloadReport, obtainReportObj);
            return obtainReportObj;
        }
    }

    b() {
        String str;
        com.qzone.common.config.service.a e16 = QZoneConfigService.f().e();
        if (e16 != null && e16.getSource() != null) {
            str = e16.getSource();
        } else {
            str = "default";
        }
        DownloaderFactory.getInstance(BaseApplication.getContext());
        DownloaderFactory.init(new f(), new c(), QZoneDownloadSharedPreferencesProvider.INSTANCE);
        if (str != null && str.equalsIgnoreCase("MQQ")) {
            this.f48398a = DownloaderFactory.createDownloader(str, ThreadManagerV2.getNetExcutor(), c());
        } else {
            Downloader createImageDownloader = DownloaderFactory.createImageDownloader(str);
            this.f48398a = createImageDownloader;
            if (createImageDownloader == null) {
                return;
            }
            BusinessReport.init();
            this.f48398a.setExternalReportHandler(new a());
            if (QLog.isDevelopLevel()) {
                QLog.d("DownloaderManager", 4, "name=" + str + ",enable report");
            }
        }
        Downloader downloader = this.f48398a;
        if (downloader == null) {
            return;
        }
        if (f48396g) {
            downloader.setNetworkFlowStatistics(new g());
        }
        this.f48398a.enableResumeTransfer();
        QzoneDownloadPortConfig qzoneDownloadPortConfig = new QzoneDownloadPortConfig();
        this.f48398a.setPortConfigStrategy(qzoneDownloadPortConfig);
        h hVar = new h();
        this.f48398a.setDirectIPConfigStrategy(hVar);
        d dVar = new d();
        this.f48398a.setBackupIPConfigStrategy(dVar);
        this.f48398a.setKeepAliveStrategy(new e());
        this.f48398a.setHttpsIpDirectEnable(QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_QZONE_HTTPS_IP_DIRECT_ENABLE, 1) == 1);
        StrategyProvider.directIPConfigStrategy = hVar;
        StrategyProvider.backupIPConfigStrategy = dVar;
        StrategyProvider.portConfigStrategy = qzoneDownloadPortConfig;
    }

    private Executor c() {
        return new BaseThreadPoolExecutor(2, 3, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new PriorityThreadFactory("qchat_download_thread", 10));
    }

    private void d(ReportHandler.DownloadReportObject downloadReportObject) {
        ArrayList arrayList = new ArrayList();
        if (downloadReportObject != null) {
            arrayList.add(downloadReportObject);
        } else {
            arrayList.addAll(this.f48399b);
            this.f48399b.clear();
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            LpReportManager.getInstance().reportToDC01796(new LpReportInfo_DC01796((ReportHandler.DownloadReportObject) arrayList.get(i3)));
        }
    }

    public static b e() {
        if (f48394e == null) {
            synchronized (f48395f) {
                if (f48394e == null) {
                    f48394e = new b();
                }
            }
        }
        return f48394e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(DownloadResult downloadResult, DownloadReport downloadReport, ReportHandler.DownloadReportObject downloadReportObject) {
        if (downloadResult != null && g(downloadResult)) {
            try {
                this.f48399b.add(downloadReportObject);
                int config = QzoneConfig.getInstance().getConfig("PhotoSvrList", QzoneConfig.SECONDARY_DOWNLOAD_LINK_REPORT_CACHE_COUNT, 5);
                if (downloadReportObject != null && downloadReportObject.retCode == 0) {
                    ReportHandler.DownloadReportObject remove = this.f48399b.size() > config ? this.f48399b.remove(0) : null;
                    if (remove != null) {
                        int i3 = this.f48401d;
                        if (i3 > 0) {
                            this.f48401d = i3 - 1;
                            d(remove);
                            return;
                        } else {
                            if (f48397h.nextInt(Math.round(100 / QzoneConfig.getInstance().getConfig("PhotoSvrList", QzoneConfig.SECONDARY_DOWNLOAD_LINK_REPORT_SAMPLE, 2))) == 0) {
                                d(remove);
                                return;
                            }
                            return;
                        }
                    }
                    return;
                }
                this.f48401d = config;
                d(null);
            } catch (Exception unused) {
            }
        }
    }

    public Downloader f() {
        return this.f48398a;
    }

    private boolean g(DownloadResult downloadResult) {
        if (downloadResult != null && downloadResult.getUrl() != null) {
            try {
                if (QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_DOWNLOAD, QzoneConfig.SECONDARY_DOWNLOAD_LINK_REPORT_ENABLE, 1) != 1) {
                    return false;
                }
                if (QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_DOWNLOAD, QzoneConfig.SECONDARY_ENABLE_COLOR, -1) == 1) {
                    return true;
                }
                if (this.f48400c == null) {
                    synchronized (e()) {
                        this.f48400c = new HashMap();
                        String[] split = QzoneConfig.getInstance().getConfig("PhotoSvrList", QzoneConfig.SECONDARY_DOWNLOAD_LINK_REPORT_DOMAIN_LIST, "m.qpic.cn,a\\d+.photo.store.qq.com,b\\d+.photo.store.qq.com,d3g.qq.com").split(",");
                        if (split != null) {
                            for (String str : split) {
                                if (!TextUtils.isEmpty(str)) {
                                    this.f48400c.put(str, Pattern.compile(str, 2));
                                }
                            }
                        }
                    }
                }
                String domin = Utils.getDomin(downloadResult.getUrl());
                Iterator<Map.Entry<String, Pattern>> it = this.f48400c.entrySet().iterator();
                while (it.hasNext()) {
                    if (Utils.match(this.f48400c.get(it.next().getKey()), domin)) {
                        return true;
                    }
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(ReportHandler.DownloadReportObject downloadReportObject) {
        String sb5;
        if (downloadReportObject == null) {
            return;
        }
        try {
            if (MobileQQ.processName.endsWith("picture") && PictureManager.needDownloadReport && !TextUtils.isEmpty(PictureManager.downloadReportKey) && PictureManager.downloadReportKey.equals("freshnews.big_pic_download")) {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("retCode", String.valueOf(downloadReportObject.retCode));
                StringBuilder sb6 = downloadReportObject.errMsg;
                if (sb6 == null) {
                    sb5 = "";
                } else {
                    sb5 = sb6.toString();
                }
                hashMap.put("errMsg", sb5);
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, PictureManager.downloadReportKey, downloadReportObject.retCode == 0, 0L, 0L, hashMap, "", true);
            }
        } catch (Exception e16) {
            QZLog.w(e16);
        }
    }
}
