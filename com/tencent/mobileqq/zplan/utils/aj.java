package com.tencent.mobileqq.zplan.utils;

import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.downloader.DownloadReport;
import com.tencent.component.network.downloader.DownloadRequest;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.component.network.module.base.Config;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.module.base.inter.Log;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QUA;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import nx4.a;

/* compiled from: P */
/* loaded from: classes34.dex */
public class aj {

    /* renamed from: d, reason: collision with root package name */
    private static volatile aj f335767d = null;

    /* renamed from: e, reason: collision with root package name */
    public static float f335768e = 0.2f;

    /* renamed from: a, reason: collision with root package name */
    private Downloader f335769a;

    /* renamed from: b, reason: collision with root package name */
    private Downloader.DownloadListener f335770b;

    /* renamed from: c, reason: collision with root package name */
    private ConcurrentHashMap<String, HashSet<Downloader.DownloadListener>> f335771c;

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class a implements Log {
        a() {
        }

        @Override // com.tencent.component.network.module.base.inter.Log
        public void d(String str, String str2) {
            QLog.d(str, 1, str2);
        }

        @Override // com.tencent.component.network.module.base.inter.Log
        public void e(String str, String str2) {
            QLog.e(str, 1, str2);
        }

        @Override // com.tencent.component.network.module.base.inter.Log
        public int getLogLevel() {
            if (QLog.isDevelopLevel()) {
                return 2;
            }
            return QLog.isColorLevel() ? 3 : 4;
        }

        @Override // com.tencent.component.network.module.base.inter.Log
        public void i(String str, String str2) {
            QLog.i(str, 1, str2);
        }

        @Override // com.tencent.component.network.module.base.inter.Log
        public void w(String str, String str2) {
            QLog.w(str, 1, str2);
        }

        @Override // com.tencent.component.network.module.base.inter.Log
        public void d(String str, String str2, Throwable th5) {
            QLog.d(str, 1, str2, th5);
        }

        @Override // com.tencent.component.network.module.base.inter.Log
        public void e(String str, String str2, Throwable th5) {
            QLog.e(str, 1, str2, th5);
        }

        @Override // com.tencent.component.network.module.base.inter.Log
        public void i(String str, String str2, Throwable th5) {
            QLog.i(str, 1, str2, th5);
        }

        @Override // com.tencent.component.network.module.base.inter.Log
        public void w(String str, String str2, Throwable th5) {
            QLog.w(str, 1, str2, th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class b implements Downloader.DownloadListener {
        b() {
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadCanceled(String str) {
            aj.this.m(str);
            aj.this.q(str);
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadFailed(String str, DownloadResult downloadResult) {
            aj.this.n(str, downloadResult);
            aj.this.q(str);
            aj.this.r(downloadResult);
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadProgress(String str, long j3, float f16) {
            aj.this.o(str, j3, f16);
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadSucceed(String str, DownloadResult downloadResult) {
            QLog.i("ZplanDownloadUtil", 1, "ZPlanDownloadUtil success, url=" + str);
            aj.this.p(str, downloadResult);
            aj.this.q(str);
            aj.this.r(downloadResult);
        }
    }

    aj() {
        if (this.f335769a == null) {
            if (QDLog.getLog() == null) {
                QDLog.setLog(new a());
            }
            BaseApplication context = BaseApplication.getContext();
            if (ZPlanFeatureSwitch.f369852a.n0()) {
                Config.setConfig(new ai());
                DownloaderFactory.getInstance(context);
                this.f335769a = DownloaderFactory.createDownloader("zplan_downloader");
            } else {
                this.f335769a = DownloaderFactory.getInstance(context).getCommonDownloader();
            }
            this.f335769a.enableResumeTransfer(true);
            this.f335769a.setHttpsIpDirectEnable(true);
        }
        k();
    }

    private void g(String str, Downloader.DownloadListener downloadListener) {
        if (TextUtils.isEmpty(str)) {
            QLog.w("ZplanDownloadUtil", 1, "addMapListener error, url or listener is null");
            return;
        }
        HashSet<Downloader.DownloadListener> hashSet = this.f335771c.get(str);
        if (hashSet == null) {
            hashSet = new HashSet<>();
            this.f335771c.put(str, hashSet);
        }
        if (downloadListener == null) {
            return;
        }
        hashSet.add(downloadListener);
        QLog.i("ZplanDownloadUtil", 1, "addMapListener url=" + str + ", size=" + hashSet.size());
    }

    public static a.b h(DownloadResult downloadResult) {
        DownloadReport report = downloadResult.getReport();
        return new a.b(downloadResult.getUrl(), Integer.valueOf(report.httpStatus), Boolean.valueOf(report.isSucceed), downloadResult.getDescInfo(), Boolean.FALSE, Long.valueOf(report.t_wait), Long.valueOf(report.t_prepare), Long.valueOf(report.t_conn), Long.valueOf(report.t_recvdata), Long.valueOf(report.totaltime), Long.valueOf(report.fileSize));
    }

    public static aj j() {
        if (f335767d == null) {
            synchronized (aj.class) {
                if (f335767d == null) {
                    f335767d = new aj();
                }
            }
        }
        return f335767d;
    }

    private void k() {
        this.f335770b = new b();
        this.f335771c = new ConcurrentHashMap<>();
    }

    private boolean l(String str) {
        return this.f335771c.containsKey(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(String str) {
        Iterator<Downloader.DownloadListener> it = this.f335771c.get(str).iterator();
        while (it.hasNext()) {
            Downloader.DownloadListener next = it.next();
            if (next != null) {
                next.onDownloadCanceled(str);
            } else {
                QLog.w("ZplanDownloadUtil", 1, "notifyDownloadCancel, listener is null");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str, DownloadResult downloadResult) {
        Iterator<Downloader.DownloadListener> it = this.f335771c.get(str).iterator();
        while (it.hasNext()) {
            Downloader.DownloadListener next = it.next();
            if (next != null) {
                next.onDownloadFailed(str, downloadResult);
            } else {
                QLog.w("ZplanDownloadUtil", 1, "notifyDownloadFaied, listener is null");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(String str, long j3, float f16) {
        Iterator<Downloader.DownloadListener> it = this.f335771c.get(str).iterator();
        while (it.hasNext()) {
            Downloader.DownloadListener next = it.next();
            if (next != null) {
                next.onDownloadProgress(str, j3, f16);
            } else {
                QLog.w("ZplanDownloadUtil", 1, "notifyDownloadProgress, listener is null");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(String str, DownloadResult downloadResult) {
        Iterator<Downloader.DownloadListener> it = this.f335771c.get(str).iterator();
        while (it.hasNext()) {
            Downloader.DownloadListener next = it.next();
            if (next != null) {
                next.onDownloadSucceed(str, downloadResult);
            } else {
                QLog.w("ZplanDownloadUtil", 1, "notifyDownloadSucceed, listener is null");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(String str) {
        this.f335771c.remove(str);
    }

    public boolean i(String str, String str2, Map<String, String> map, boolean z16, Downloader.DownloadMode downloadMode, Downloader.DownloadListener downloadListener) {
        if (!NetworkUtils.isNetworkUrl(str)) {
            return false;
        }
        if (l(str)) {
            g(str, downloadListener);
            QLog.i("ZplanDownloadUtil", 1, "has same url downloading, url=" + str);
            return true;
        }
        g(str, downloadListener);
        DownloadRequest downloadRequest = new DownloadRequest(str, new String[]{str2}, false, this.f335770b);
        downloadRequest.mode = downloadMode;
        downloadRequest.progressCallbackStep = f335768e;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                downloadRequest.addParam(entry.getKey(), entry.getValue());
            }
        }
        return this.f335769a.download(downloadRequest, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(DownloadResult downloadResult) {
        if (downloadResult == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("url", downloadResult.getUrl());
        hashMap.put("path", downloadResult.getPath());
        DownloadResult.Process process = downloadResult.getProcess();
        if (process != null) {
            hashMap.put("duration", process.duration + "");
            hashMap.put(PeakConstants.VIDEO_TOTAL_DURATION, process.totalDuration + "");
        }
        DownloadResult.Content content = downloadResult.getContent();
        if (content != null) {
            hashMap.put("file_size", content.length + "");
            hashMap.put("client_ip", content.clientip);
            hashMap.put("is_gzip", content.isGzip + "");
            hashMap.put("content_redirect_url", content.redirectUrl);
        }
        DownloadReport report = downloadResult.getReport();
        if (report != null) {
            hashMap.put("start_time_stamp", report.startTime + "");
            hashMap.put("end_time_stamp", report.endTime + "");
            hashMap.put("is_succeed", report.isSucceed + "");
            hashMap.put("download_mode", report.downloadMode + "");
            hashMap.put("is_http2", report.isHttp2 + "");
            hashMap.put("is_https", report.isHttps + "");
            hashMap.put("time_wait", report.t_wait + "");
            hashMap.put("time_cost_data", report.t_recvdata + "");
            hashMap.put("time_cost_header", report.t_recvrsp + "");
            hashMap.put("time_cost_range_receive", report.timeCostForRangeReceivePhase + "");
            hashMap.put("time_cost_range_merge", report.timeCostForRangeMergePhase + "");
            hashMap.put(AudienceReportConst.PROTOCOL, report.f99896protocol);
            hashMap.put("retry_count", report.currAttempCount + "");
            hashMap.put("range_number", report.rangeNumber + "");
            hashMap.put("refer", report.refer);
            hashMap.put("log_info", report.logInfo);
            if (report.okResponse != null) {
                hashMap.put("send_request_time_stamp", report.okResponse.sentRequestAtMillis() + "");
                hashMap.put("receive_response_time_stamp", report.okResponse.receivedResponseAtMillis() + "");
            }
        }
        DownloadResult.Status status = downloadResult.getStatus();
        if (status != null) {
            hashMap.put("http_status", status.httpStatus + "");
            hashMap.put("fail_message", status.getErrorMessage());
            hashMap.put("detail_info", status.detailDownloadInfo);
        }
        hashMap.put("network_type", HttpUtil.getNetWorkType() + "");
        hashMap.put("is_zplan_process", ZPlanFeatureSwitch.f369852a.Z2() + "");
        hashMap.put("is_public_version", "true");
        hashMap.put("qua", QUA.getQUA3());
        t74.r.d("0AND0YAG6R40RLM6", "zplan_resource_download", hashMap);
    }
}
