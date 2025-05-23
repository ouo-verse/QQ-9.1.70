package com.tencent.component.network.downloader.impl;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.component.network.NetworkManager;
import com.tencent.component.network.downloader.DownloadReport;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.component.network.downloader.RangeDownloadManager;
import com.tencent.component.network.downloader.impl.DownloadTask;
import com.tencent.component.network.downloader.strategy.DownloadGlobalStrategy;
import com.tencent.component.network.downloader.strategy.ResumeTransfer;
import com.tencent.component.network.module.base.Config;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.module.common.NetworkStatus;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.component.network.utils.SDCardUtil;
import com.tencent.component.network.utils.http.HttpUtil;
import com.tencent.component.network.utils.http.base.QZoneHttpClient;
import com.tencent.component.network.utils.thread.ThreadPool;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import java.net.Proxy;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RangeDownloadTask extends DownloadTask implements RangeDownloadManager.ProgressListener {
    int connect_retry;
    long connect_time;
    int exe_retry;
    long exe_time;
    private RangeDownloadManager mRangeDownloaderManager;
    private String mRealUrl;
    private String mRefer;
    private final long mTimeStamp;
    long send_req_time;

    public RangeDownloadTask(Context context, OkHttpClient okHttpClient, QZoneHttpClient qZoneHttpClient, String str, String str2, boolean z16, int i3, long j3) {
        super(context, okHttpClient, qZoneHttpClient, str, str2, z16, true);
        this.mTimeStamp = SystemClock.uptimeMillis();
        this.connect_time = 0L;
        this.connect_retry = 0;
        this.exe_time = 0L;
        this.exe_retry = 0;
        this.send_req_time = 0L;
        RangeDownloadManager rangeDownloadManager = new RangeDownloadManager(okHttpClient, i3);
        this.mRangeDownloaderManager = rangeDownloadManager;
        rangeDownloadManager.setContentLength(j3);
    }

    /* JADX WARN: Removed duplicated region for block: B:122:0x14c5  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x15ec  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x1617  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x1b83  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x0845 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0ee7  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0f61  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x1ba0 A[LOOP:0: B:2:0x0062->B:95:0x1ba0, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x1b9f A[SYNTHETIC] */
    @Override // com.tencent.component.network.downloader.impl.DownloadTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void execute(ThreadPool.JobContext jobContext, DownloadResult downloadResult) {
        ThreadPool.JobContext jobContext2;
        String str;
        String str2;
        String str3;
        DownloadReport downloadReport;
        long j3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        int i3;
        int i16;
        String str13;
        String str14;
        String str15;
        Throwable th5;
        Response response;
        int i17;
        Response response2;
        String str16;
        String str17;
        String str18;
        String str19;
        String str20;
        String str21;
        String str22;
        DownloadReport downloadReport2;
        String str23;
        String str24;
        Throwable th6;
        Throwable th7;
        Throwable th8;
        boolean z16;
        String str25;
        int i18;
        String str26;
        String str27;
        String str28;
        NetworkUtils.DNS dns;
        Response response3;
        String str29;
        String str30;
        DownloadReport downloadReport3;
        String str31;
        String str32;
        int i19;
        ThreadPool.JobContext jobContext3;
        String str33;
        String str34;
        String str35;
        String str36;
        String str37;
        String str38;
        String str39;
        DownloadResult downloadResult2;
        Response response4;
        NetworkUtils.DNS dns2;
        String str40;
        boolean z17;
        DownloadReport downloadReport4;
        String str41;
        String str42;
        String str43;
        String str44;
        Throwable th9;
        String str45;
        String str46;
        String str47;
        String str48;
        Proxy customProxy;
        String str49;
        String str50;
        String str51;
        long uptimeMillis;
        long j16;
        boolean z18;
        String str52;
        String str53;
        String str54;
        String str55;
        String str56;
        String str57;
        String str58;
        String str59;
        DownloadReport downloadReport5;
        String str60;
        Response response5;
        String str61;
        String str62;
        String str63;
        String str64;
        String str65;
        String str66;
        String str67;
        String str68;
        String str69;
        String str70;
        String str71;
        boolean z19;
        String str72;
        String str73;
        int i26;
        String str74;
        String str75;
        String str76;
        NetworkUtils.DNS dns3;
        Response response6;
        String str77;
        String str78;
        DownloadReport downloadReport6;
        String str79;
        String str80;
        DownloadReport downloadReport7;
        String str81;
        String str82;
        String str83;
        String str84;
        int i27;
        DownloadResult downloadResult3;
        String str85;
        String str86;
        String str87;
        String str88;
        String str89;
        String str90;
        ThreadPool.JobContext jobContext4;
        boolean z26;
        String str91;
        DownloadReport downloadReport8;
        String str92;
        Response response7;
        String str93;
        String str94;
        String str95;
        NetworkUtils.DNS dns4;
        String str96;
        String str97;
        String str98;
        ThreadPool.JobContext jobContext5 = jobContext;
        DownloadResult downloadResult4 = downloadResult;
        String str99 = ", IpStack=";
        String str100 = ", apn=";
        String str101 = ", thread=";
        String str102 = ", localAddress=";
        String str103 = ", remoteAddress=";
        String str104 = ", dns=";
        String str105 = "http1.1";
        String str106 = " , requestHttp2=";
        String str107 = ", redirectURI=";
        String str108 = ", contentType=";
        String str109 = ", protocol=";
        String str110 = ", ";
        String str111 = ", size=";
        String str112 = ", contentLength=";
        String str113 = ", totalDuration=";
        String str114 = ", duration=";
        String str115 = ",";
        int generateRandomId = DownloadTask.TaskHelper.generateRandomId(getUrl(), downloadResult4);
        boolean isSdCardHasEnoughCapability = SDCardUtil.isSdCardHasEnoughCapability();
        String str116 = ", realsize=";
        int i28 = 0;
        while (true) {
            String str117 = str99;
            if (jobContext.isCancelled()) {
                handleDownloadReportForTask(jobContext5, downloadResult4, null);
                return;
            }
            if (!NetworkUtils.isNetworkAvailable(this.mContext)) {
                if (i28 == this.mAttemptTotalCount - 1) {
                    downloadResult.getStatus().setFailed(6);
                    return;
                } else {
                    try {
                        LockMethodProxy.sleep(1000L);
                    } catch (Exception unused) {
                        QDLog.d(QDLog.TAG_DOWNLOAD, "no network sleep interruptted!");
                    }
                }
            }
            if (!isSdCardHasEnoughCapability) {
                downloadResult.getStatus().setFailed(2);
                return;
            }
            String str118 = str100;
            long uptimeMillis2 = SystemClock.uptimeMillis();
            DownloadReport downloadReport9 = new DownloadReport();
            downloadReport9.f99895id = generateRandomId;
            downloadReport9.url = getUrl();
            downloadReport9.domain = getDomain();
            String str119 = str108;
            downloadReport9.startTime = System.currentTimeMillis();
            this.okRequestBuilder = null;
            int i29 = generateRandomId;
            String str120 = str105;
            try {
                HttpUtil.RequestOptions requestOptions = DownloadTask.sRequestOptions.get();
                DownloadTask.DownloadTaskHandler downloadTaskHandler = this.mDownloadTaskHandler;
                if (downloadTaskHandler != null) {
                    try {
                        customProxy = downloadTaskHandler.getCustomProxy();
                    } catch (Throwable th10) {
                        th = th10;
                        jobContext2 = jobContext;
                        str = str107;
                        str2 = str106;
                        str3 = str104;
                        downloadReport = downloadReport9;
                        j3 = uptimeMillis2;
                        str4 = str109;
                        str5 = str110;
                        str6 = str111;
                        str7 = str112;
                        str8 = str113;
                        str9 = str114;
                        str10 = str115;
                        str11 = str119;
                        str12 = str120;
                        i3 = i29;
                        response = null;
                        i16 = i28;
                        str13 = str101;
                        str14 = str102;
                        str15 = str103;
                        i17 = 0;
                        th5 = th;
                        try {
                            QDLog.e(QDLog.TAG_DOWNLOAD_RANGE, "download " + getUrl() + " exception:", th5);
                            try {
                                downloadResult.getStatus().setFailed(th5);
                                int i36 = i16 + 1;
                                DownloadReport downloadReport10 = downloadReport;
                                downloadResult.getProcess().setDuration(j3, SystemClock.uptimeMillis());
                                downloadResult.getProcess().totalDuration = SystemClock.uptimeMillis() - this.mTimeStamp;
                                downloadResult.getProcess().startTimestamp = this.mTaskStartTimeStamp;
                                NetworkUtils.DNS dns5 = NetworkStatus.getInstance(this.mContext).getDNS();
                                String parserHttpHeaderInfo = parserHttpHeaderInfo(null, null, response);
                                if (response != null) {
                                }
                                downloadResult.getContent().redirectUrl = r3;
                                this.connect_time = 0L;
                                this.connect_retry = 0;
                                this.exe_time = 0L;
                                this.exe_retry = 0;
                                if (jobContext.isCancelled()) {
                                }
                                this.okRequestBuilder = null;
                                i28 = i19;
                                if (!canAttempt()) {
                                }
                            } catch (Throwable th11) {
                                response2 = response;
                                str16 = str8;
                                str18 = str13;
                                str19 = str;
                                str20 = str6;
                                str21 = str5;
                                str22 = str4;
                                Throwable th12 = th5;
                                str17 = str11;
                                downloadReport2 = downloadReport;
                                str23 = str9;
                                str24 = str15;
                                th6 = th11;
                                th7 = th12;
                                int i37 = i17;
                                DownloadReport downloadReport11 = downloadReport2;
                                downloadResult.getProcess().setDuration(j3, SystemClock.uptimeMillis());
                                downloadResult.getProcess().totalDuration = SystemClock.uptimeMillis() - this.mTimeStamp;
                                downloadResult.getProcess().startTimestamp = this.mTaskStartTimeStamp;
                                NetworkUtils.DNS dns6 = NetworkStatus.getInstance(this.mContext).getDNS();
                                String parserHttpHeaderInfo2 = parserHttpHeaderInfo(null, null, response2);
                                String header = (response2 == null || response2.priorResponse() == null) ? null : response2.priorResponse().header("Location");
                                downloadResult.getContent().redirectUrl = header;
                                this.connect_time = 0L;
                                String str121 = header;
                                this.connect_retry = 0;
                                this.exe_time = 0L;
                                this.exe_retry = 0;
                                if (!jobContext.isCancelled()) {
                                    boolean isNetworkAvailable = NetworkUtils.isNetworkAvailable(this.mContext);
                                    if (!downloadResult.getStatus().isSucceed()) {
                                        StringBuilder sb5 = new StringBuilder();
                                        sb5.append("Downloader, fail to download:");
                                        sb5.append(getUrl());
                                        sb5.append(str2);
                                        sb5.append(this.mIsHttp2);
                                        sb5.append(str22);
                                        sb5.append((!this.mIsHttp2 || response2 == null || response2.protocol() == null) ? str12 : response2.protocol().getProtocol());
                                        sb5.append(str3);
                                        sb5.append(dns6);
                                        sb5.append(str24);
                                        sb5.append((String) null);
                                        sb5.append(str14);
                                        sb5.append((String) null);
                                        sb5.append(str18);
                                        String str122 = str19;
                                        sb5.append(Thread.currentThread().getId());
                                        sb5.append(str118);
                                        sb5.append(NetworkManager.getApnValue());
                                        sb5.append(", netAvailable=");
                                        sb5.append(isNetworkAvailable);
                                        sb5.append(str117);
                                        sb5.append(Config.getNetworkStackType());
                                        sb5.append(str17);
                                        sb5.append(downloadResult.getContent().type);
                                        sb5.append(str23);
                                        sb5.append(downloadResult.getProcess().duration);
                                        sb5.append(str16);
                                        String str123 = str16;
                                        sb5.append(SystemClock.uptimeMillis() - this.mTimeStamp);
                                        sb5.append(str7);
                                        sb5.append(downloadResult.getContent().length);
                                        sb5.append(str20);
                                        sb5.append(downloadResult.getContent().size);
                                        sb5.append(str116);
                                        sb5.append(downloadResult.getContent().realsize);
                                        sb5.append(", retry=(");
                                        sb5.append(getCurrAttemptCount());
                                        String str124 = str10;
                                        sb5.append(str124);
                                        sb5.append(getTotalAttemptCount());
                                        sb5.append("), reason=");
                                        sb5.append(downloadResult.getStatus().getFailReason());
                                        sb5.append(", httpStatus=");
                                        sb5.append(i37);
                                        sb5.append(str21);
                                        sb5.append(parserHttpHeaderInfo2);
                                        sb5.append(str122);
                                        sb5.append(str121);
                                        sb5.append(", ipUrl:");
                                        String str125 = this.mRealUrl;
                                        if (str125 != null) {
                                            str32 = str122;
                                            str125 = str125.substring(0, 30);
                                        } else {
                                            str32 = str122;
                                        }
                                        sb5.append(str125);
                                        sb5.append(", clientip=");
                                        sb5.append(downloadResult.getContent().clientip);
                                        sb5.append(", getIP=");
                                        sb5.append(0L);
                                        sb5.append(", connect:(");
                                        sb5.append(this.connect_time);
                                        sb5.append(str124);
                                        sb5.append(this.connect_retry);
                                        sb5.append("), exeReqest:(");
                                        sb5.append(this.exe_time);
                                        sb5.append(str124);
                                        sb5.append(this.exe_retry);
                                        sb5.append("), sendReq=");
                                        sb5.append(this.send_req_time);
                                        sb5.append(", recvData=");
                                        sb5.append(this.t_recv_data);
                                        sb5.append(", Concurrent:(");
                                        sb5.append(getTaskConcurrentCount());
                                        sb5.append("), mobileProxy=");
                                        DownloadTask.DownloadTaskHandler downloadTaskHandler2 = this.mDownloadTaskHandler;
                                        sb5.append(downloadTaskHandler2 != null ? downloadTaskHandler2.getCustomProxy() : null);
                                        String sb6 = sb5.toString();
                                        downloadReport11.logInfo = sb6;
                                        Throwable th13 = th7;
                                        QDLog.e(QDLog.TAG_DOWNLOAD_RESULT, sb6, th13);
                                        str29 = str21;
                                        z16 = isNetworkAvailable;
                                        downloadReport3 = downloadReport11;
                                        th8 = th13;
                                        str26 = str17;
                                        i18 = i37;
                                        str28 = str121;
                                        str27 = str32;
                                        str25 = str123;
                                        dns = dns6;
                                        response3 = response2;
                                        str30 = parserHttpHeaderInfo2;
                                    } else {
                                        String str126 = str16;
                                        String str127 = str21;
                                        String str128 = str17;
                                        String str129 = str19;
                                        th8 = th7;
                                        String str130 = str18;
                                        String str131 = str117;
                                        String str132 = str118;
                                        String str133 = str3;
                                        z16 = isNetworkAvailable;
                                        String str134 = str14;
                                        StringBuilder sb7 = new StringBuilder();
                                        sb7.append("Downloader, succeed to download:");
                                        sb7.append(getUrl());
                                        sb7.append(str2);
                                        sb7.append(this.mIsHttp2);
                                        sb7.append(str22);
                                        sb7.append((!this.mIsHttp2 || response2 == null || response2.protocol() == null) ? str12 : response2.protocol().getProtocol());
                                        sb7.append(str133);
                                        sb7.append(dns6);
                                        sb7.append(str24);
                                        sb7.append((String) null);
                                        sb7.append(str134);
                                        sb7.append((String) null);
                                        sb7.append(str130);
                                        sb7.append(Thread.currentThread().getId());
                                        sb7.append(str132);
                                        sb7.append(NetworkManager.getApnValue());
                                        sb7.append(str131);
                                        sb7.append(Config.getNetworkStackType());
                                        sb7.append(str23);
                                        sb7.append(downloadResult.getProcess().duration);
                                        str25 = str126;
                                        sb7.append(str25);
                                        sb7.append(SystemClock.uptimeMillis() - this.mTimeStamp);
                                        sb7.append(str7);
                                        sb7.append(downloadResult.getContent().length);
                                        sb7.append(str20);
                                        sb7.append(downloadResult.getContent().size);
                                        sb7.append(str116);
                                        sb7.append(downloadResult.getContent().realsize);
                                        sb7.append(", retry=(");
                                        sb7.append(getCurrAttemptCount());
                                        String str135 = str10;
                                        sb7.append(str135);
                                        sb7.append(getTotalAttemptCount());
                                        sb7.append("), httpStatus=");
                                        i18 = i37;
                                        sb7.append(i18);
                                        sb7.append(str127);
                                        sb7.append(parserHttpHeaderInfo2);
                                        str26 = str128;
                                        sb7.append(str26);
                                        sb7.append(downloadResult.getContent().type);
                                        str27 = str129;
                                        sb7.append(str27);
                                        str28 = str121;
                                        sb7.append(str28);
                                        sb7.append(", ipUrl:");
                                        String str136 = this.mRealUrl;
                                        dns = dns6;
                                        if (str136 != null) {
                                            response3 = response2;
                                            str136 = str136.substring(0, 30);
                                        } else {
                                            response3 = response2;
                                        }
                                        sb7.append(str136);
                                        sb7.append(", clientip=");
                                        sb7.append(downloadResult.getContent().clientip);
                                        sb7.append(", getIP=");
                                        str29 = str127;
                                        str30 = parserHttpHeaderInfo2;
                                        sb7.append(0L);
                                        sb7.append(", connect:(");
                                        sb7.append(this.connect_time);
                                        sb7.append(str135);
                                        sb7.append(this.connect_retry);
                                        sb7.append("), exeReqest:(");
                                        sb7.append(this.exe_time);
                                        sb7.append(str135);
                                        sb7.append(this.exe_retry);
                                        sb7.append("), sendReq=");
                                        sb7.append(this.send_req_time);
                                        sb7.append(", recvData=");
                                        sb7.append(this.t_recv_data);
                                        sb7.append(", Concurrent:(");
                                        sb7.append(getTaskConcurrentCount());
                                        sb7.append("), mobileProxy=");
                                        DownloadTask.DownloadTaskHandler downloadTaskHandler3 = this.mDownloadTaskHandler;
                                        sb7.append(downloadTaskHandler3 != null ? downloadTaskHandler3.getCustomProxy() : null);
                                        String sb8 = sb7.toString();
                                        downloadReport3 = downloadReport11;
                                        downloadReport3.logInfo = sb8;
                                        QDLog.w(QDLog.TAG_DOWNLOAD_RESULT, sb8, null);
                                    }
                                    if (!z16) {
                                        this.mShouldReport = false;
                                    }
                                    DownloadResult.Status status = downloadResult.getStatus();
                                    StringBuilder sb9 = new StringBuilder();
                                    sb9.append(getUrl());
                                    sb9.append(" sip=");
                                    sb9.append((String) null);
                                    sb9.append(", client=");
                                    sb9.append(downloadResult.getContent().clientip);
                                    sb9.append(", ipType=");
                                    DownloadGlobalStrategy.StrategyInfo strategyInfo = this.pCurrStrategyInfo;
                                    sb9.append(strategyInfo != null ? strategyInfo.f99899id : 0);
                                    sb9.append(", httpStatus=");
                                    sb9.append(i18);
                                    sb9.append(str26);
                                    sb9.append(downloadResult.getContent().type);
                                    sb9.append(str7);
                                    sb9.append(downloadResult.getContent().length);
                                    sb9.append(str20);
                                    sb9.append(downloadResult.getContent().size);
                                    sb9.append(str23);
                                    sb9.append(downloadResult.getProcess().duration);
                                    sb9.append(str25);
                                    sb9.append(SystemClock.uptimeMillis() - this.mTimeStamp);
                                    if (TextUtils.isEmpty(str28)) {
                                        str31 = "";
                                    } else {
                                        str31 = str27 + str28;
                                    }
                                    sb9.append(str31);
                                    sb9.append(str29);
                                    sb9.append(str30);
                                    status.detailDownloadInfo = sb9.toString();
                                    if (z16) {
                                        DownloadGlobalStrategy downloadGlobalStrategy = DownloadGlobalStrategy.getInstance(this.mContext);
                                        String str137 = this.mRealUrl;
                                        downloadGlobalStrategy.reportHttps(str137, this.mIsHttp2 && str137 != null && str137.startsWith("https"), downloadResult.getStatus().isSucceed());
                                    }
                                    downloadReport3.endTime = System.currentTimeMillis();
                                    downloadReport3.fileSize = getContentLength();
                                    Response response8 = response3;
                                    downloadReport3.okResponse = response8;
                                    downloadReport3.httpStatus = i18;
                                    downloadReport3.exception = th8;
                                    downloadReport3.dns = dns == null ? null : dns.toString();
                                    downloadReport3.localAddress = null;
                                    downloadReport3.clientip = downloadResult.getContent().clientip;
                                    downloadReport3.totaltime = SystemClock.uptimeMillis() - this.mTimeStamp;
                                    downloadReport3.downloadTime = downloadResult.getProcess().duration;
                                    downloadReport3.t_wait = downloadReport3.totaltime - downloadResult.getProcess().duration;
                                    downloadReport3.t_prepare = 0L;
                                    downloadReport3.t_conn = this.connect_time;
                                    downloadReport3.t_recvrsp = this.send_req_time;
                                    downloadReport3.t_recvdata = this.t_recv_data;
                                    downloadReport3.t_process = 0L;
                                    downloadReport3.concurrent = getTaskConcurrentCount();
                                    downloadReport3.content_type = downloadResult.getContent().type;
                                    downloadReport3.isFromQzoneAlbum = Config.isFromQzoneAlbum(getDomain());
                                    downloadReport3.isHttp2 = this.mIsHttp2;
                                    String str138 = this.mRealUrl;
                                    downloadReport3.isHttps = str138 != null && str138.startsWith("https");
                                    downloadReport3.isSucceed = downloadResult.getStatus().isSucceed();
                                    downloadReport3.downloadMode = Downloader.DownloadMode.RangeMode.ordinal();
                                    downloadReport3.timeCostForRangeReceivePhase = this.mRangeDownloaderManager.getDurationMillisForRangeReceivePhase();
                                    if (response8 != null && response8.protocol() != null) {
                                        downloadReport3.f99896protocol = response8.protocol().getProtocol();
                                    }
                                    downloadReport3.rangeDownloadReports = this.mRangeDownloaderManager.getRangeDownloadReports();
                                    downloadReport3.rangeNumber = this.mRangeDownloaderManager.getNumberOfRangeTasks();
                                    downloadResult.setReport(downloadReport3);
                                    if (downloadResult.getStatus().isSucceed()) {
                                        handleDownloadReportForTask(jobContext, downloadResult, downloadReport3);
                                    }
                                }
                                this.okRequestBuilder = null;
                                throw th6;
                            }
                        } catch (Throwable th14) {
                            response2 = response;
                            str16 = str8;
                            str17 = str11;
                            str18 = str13;
                            str19 = str;
                            str20 = str6;
                            str21 = str5;
                            str22 = str4;
                            downloadReport2 = downloadReport;
                            str23 = str9;
                            str24 = str15;
                            th6 = th14;
                            th7 = null;
                        }
                    }
                } else {
                    customProxy = null;
                }
                requestOptions.mobileProxy = customProxy;
                downloadReport9.currAttempCount = i28;
                downloadReport9.refer = this.mRefer;
                this.mRealUrl = prepareUrl(getUrl());
                String str139 = str107;
                try {
                    str2 = str106;
                    try {
                        Request.Builder createOkHttpGet = HttpUtil.createOkHttpGet(this.mContext, getUrl(), getDomain(), this.mRealUrl, this.mRefer);
                        this.okRequestBuilder = createOkHttpGet;
                        ResumeTransfer resumeTransfer = this.pResumeTransfer;
                        if (resumeTransfer != null) {
                            try {
                                resumeTransfer.prepareRequest(null, createOkHttpGet, getUrl(), getDomain());
                            } catch (Throwable th15) {
                                th = th15;
                                jobContext2 = jobContext;
                                str3 = str104;
                                downloadReport = downloadReport9;
                                j3 = uptimeMillis2;
                                str4 = str109;
                                str5 = str110;
                                str6 = str111;
                                str7 = str112;
                                str8 = str113;
                                str9 = str114;
                                str10 = str115;
                                str11 = str119;
                                str12 = str120;
                                i3 = i29;
                                str = str139;
                                response = null;
                                i16 = i28;
                                str13 = str101;
                                str14 = str102;
                                str15 = str103;
                                i17 = 0;
                                th5 = th;
                                QDLog.e(QDLog.TAG_DOWNLOAD_RANGE, "download " + getUrl() + " exception:", th5);
                                downloadResult.getStatus().setFailed(th5);
                                int i362 = i16 + 1;
                                DownloadReport downloadReport102 = downloadReport;
                                downloadResult.getProcess().setDuration(j3, SystemClock.uptimeMillis());
                                downloadResult.getProcess().totalDuration = SystemClock.uptimeMillis() - this.mTimeStamp;
                                downloadResult.getProcess().startTimestamp = this.mTaskStartTimeStamp;
                                NetworkUtils.DNS dns52 = NetworkStatus.getInstance(this.mContext).getDNS();
                                String parserHttpHeaderInfo3 = parserHttpHeaderInfo(null, null, response);
                                if (response != null) {
                                }
                                downloadResult.getContent().redirectUrl = r3;
                                this.connect_time = 0L;
                                this.connect_retry = 0;
                                this.exe_time = 0L;
                                this.exe_retry = 0;
                                if (jobContext.isCancelled()) {
                                }
                                this.okRequestBuilder = null;
                                i28 = i19;
                                if (!canAttempt()) {
                                }
                            }
                        }
                        prepareRequest(getUrl(), getDomain(), null, this.okRequestBuilder);
                        str = str139;
                        i16 = i28;
                        str4 = str109;
                        str5 = str110;
                        str6 = str111;
                        str49 = str112;
                        str50 = str113;
                        str51 = str114;
                        str10 = str115;
                        i3 = i29;
                        str12 = str120;
                        str3 = str104;
                    } catch (Throwable th16) {
                        th = th16;
                        jobContext2 = jobContext;
                        str3 = str104;
                        downloadReport = downloadReport9;
                        j3 = uptimeMillis2;
                        str4 = str109;
                        str5 = str110;
                        str6 = str111;
                        str7 = str112;
                        str8 = str113;
                        str9 = str114;
                        str10 = str115;
                        str11 = str119;
                        str12 = str120;
                        i3 = i29;
                        str = str139;
                        i16 = i28;
                        str13 = str101;
                        str14 = str102;
                        str15 = str103;
                        th5 = th;
                        response = null;
                        i17 = 0;
                        QDLog.e(QDLog.TAG_DOWNLOAD_RANGE, "download " + getUrl() + " exception:", th5);
                        downloadResult.getStatus().setFailed(th5);
                        int i3622 = i16 + 1;
                        DownloadReport downloadReport1022 = downloadReport;
                        downloadResult.getProcess().setDuration(j3, SystemClock.uptimeMillis());
                        downloadResult.getProcess().totalDuration = SystemClock.uptimeMillis() - this.mTimeStamp;
                        downloadResult.getProcess().startTimestamp = this.mTaskStartTimeStamp;
                        NetworkUtils.DNS dns522 = NetworkStatus.getInstance(this.mContext).getDNS();
                        String parserHttpHeaderInfo32 = parserHttpHeaderInfo(null, null, response);
                        if (response != null) {
                        }
                        downloadResult.getContent().redirectUrl = r3;
                        this.connect_time = 0L;
                        this.connect_retry = 0;
                        this.exe_time = 0L;
                        this.exe_retry = 0;
                        if (jobContext.isCancelled()) {
                        }
                        this.okRequestBuilder = null;
                        i28 = i19;
                        if (!canAttempt()) {
                        }
                    }
                    try {
                        applyKeepAliveStrategy(getUrl(), getDomain(), null, this.okRequestBuilder, requestOptions);
                        this.send_req_time = 0L;
                        uptimeMillis = SystemClock.uptimeMillis();
                    } catch (Throwable th17) {
                        th = th17;
                        jobContext2 = jobContext;
                        str2 = str2;
                        j3 = uptimeMillis2;
                        str13 = str101;
                        str14 = str102;
                        str15 = str103;
                        downloadReport = downloadReport9;
                        str11 = str119;
                        str9 = str51;
                        str8 = str50;
                        str7 = str49;
                        th5 = th;
                        response = null;
                        i17 = 0;
                        QDLog.e(QDLog.TAG_DOWNLOAD_RANGE, "download " + getUrl() + " exception:", th5);
                        downloadResult.getStatus().setFailed(th5);
                        int i36222 = i16 + 1;
                        DownloadReport downloadReport10222 = downloadReport;
                        downloadResult.getProcess().setDuration(j3, SystemClock.uptimeMillis());
                        downloadResult.getProcess().totalDuration = SystemClock.uptimeMillis() - this.mTimeStamp;
                        downloadResult.getProcess().startTimestamp = this.mTaskStartTimeStamp;
                        NetworkUtils.DNS dns5222 = NetworkStatus.getInstance(this.mContext).getDNS();
                        String parserHttpHeaderInfo322 = parserHttpHeaderInfo(null, null, response);
                        if (response != null) {
                        }
                        downloadResult.getContent().redirectUrl = r3;
                        this.connect_time = 0L;
                        this.connect_retry = 0;
                        this.exe_time = 0L;
                        this.exe_retry = 0;
                        if (jobContext.isCancelled()) {
                        }
                        this.okRequestBuilder = null;
                        i28 = i19;
                        if (!canAttempt()) {
                        }
                    }
                } catch (Throwable th18) {
                    th = th18;
                    jobContext2 = jobContext;
                    str2 = str106;
                }
            } catch (Throwable th19) {
                th = th19;
                jobContext2 = jobContext;
                str = str107;
                str2 = str106;
                str3 = str104;
                downloadReport = downloadReport9;
                j3 = uptimeMillis2;
                str4 = str109;
                str5 = str110;
                str6 = str111;
                str7 = str112;
                str8 = str113;
                str9 = str114;
                str10 = str115;
                str11 = str119;
                str12 = str120;
                i3 = i29;
            }
            if (this.okRequestBuilder != null) {
                try {
                    String generateStorageName = generateStorageName();
                    String generateStoragePath = generateStoragePath(generateStorageName);
                    String generateStoragePath2 = generateStoragePath(generateStorageName, false);
                    if (ensureStorageSpace(generateStoragePath, this.mContentLength)) {
                        j16 = 0;
                        try {
                            downloadResult.setPath(generateStoragePath);
                        } catch (Throwable th20) {
                            th = th20;
                            jobContext2 = jobContext;
                            str2 = str2;
                            j3 = uptimeMillis2;
                            str13 = str101;
                            str14 = str102;
                            str15 = str103;
                            downloadReport = downloadReport9;
                            str11 = str119;
                            str9 = str51;
                            str8 = str50;
                            str7 = str49;
                            response = null;
                            i17 = 0;
                            th5 = th;
                            QDLog.e(QDLog.TAG_DOWNLOAD_RANGE, "download " + getUrl() + " exception:", th5);
                            downloadResult.getStatus().setFailed(th5);
                            int i362222 = i16 + 1;
                            DownloadReport downloadReport102222 = downloadReport;
                            downloadResult.getProcess().setDuration(j3, SystemClock.uptimeMillis());
                            downloadResult.getProcess().totalDuration = SystemClock.uptimeMillis() - this.mTimeStamp;
                            downloadResult.getProcess().startTimestamp = this.mTaskStartTimeStamp;
                            NetworkUtils.DNS dns52222 = NetworkStatus.getInstance(this.mContext).getDNS();
                            String parserHttpHeaderInfo3222 = parserHttpHeaderInfo(null, null, response);
                            if (response != null) {
                            }
                            downloadResult.getContent().redirectUrl = r3;
                            this.connect_time = 0L;
                            this.connect_retry = 0;
                            this.exe_time = 0L;
                            this.exe_retry = 0;
                            if (jobContext.isCancelled()) {
                            }
                            this.okRequestBuilder = null;
                            i28 = i19;
                            if (!canAttempt()) {
                            }
                        }
                    } else {
                        j16 = 0;
                        try {
                            if (!TextUtils.equals(generateStoragePath, generateStoragePath2) && ensureStorageSpace(generateStoragePath2, this.mContentLength)) {
                                downloadResult.setPath(generateStoragePath2);
                            } else {
                                downloadResult.getStatus().setFailed(2);
                                QDLog.e(QDLog.TAG_DOWNLOAD_RANGE, "download on rangeMode fail, " + getUrl() + ", realUrl:" + this.mRealUrl);
                                downloadResult.getProcess().setDuration(uptimeMillis2, SystemClock.uptimeMillis());
                                downloadResult.getProcess().totalDuration = SystemClock.uptimeMillis() - this.mTimeStamp;
                                downloadResult.getProcess().startTimestamp = this.mTaskStartTimeStamp;
                                NetworkUtils.DNS dns7 = NetworkStatus.getInstance(this.mContext).getDNS();
                                String parserHttpHeaderInfo4 = parserHttpHeaderInfo(null, null, null);
                                downloadResult.getContent().redirectUrl = null;
                                this.connect_time = 0L;
                                this.connect_retry = 0;
                                this.exe_time = 0L;
                                this.exe_retry = 0;
                                if (!jobContext.isCancelled()) {
                                    boolean isNetworkAvailable2 = NetworkUtils.isNetworkAvailable(this.mContext);
                                    if (!downloadResult.getStatus().isSucceed()) {
                                        StringBuilder sb10 = new StringBuilder();
                                        sb10.append("Downloader, fail to download:");
                                        sb10.append(getUrl());
                                        sb10.append(str2);
                                        sb10.append(this.mIsHttp2);
                                        sb10.append(str4);
                                        boolean z27 = this.mIsHttp2;
                                        sb10.append(str12);
                                        sb10.append(str3);
                                        sb10.append(dns7);
                                        sb10.append(str103);
                                        sb10.append((String) null);
                                        sb10.append(str102);
                                        sb10.append((String) null);
                                        sb10.append(str101);
                                        sb10.append(Thread.currentThread().getId());
                                        sb10.append(str118);
                                        sb10.append(NetworkManager.getApnValue());
                                        sb10.append(", netAvailable=");
                                        sb10.append(isNetworkAvailable2);
                                        sb10.append(str117);
                                        sb10.append(Config.getNetworkStackType());
                                        sb10.append(str119);
                                        sb10.append(downloadResult.getContent().type);
                                        sb10.append(str51);
                                        sb10.append(downloadResult.getProcess().duration);
                                        sb10.append(str50);
                                        sb10.append(SystemClock.uptimeMillis() - this.mTimeStamp);
                                        sb10.append(str49);
                                        sb10.append(downloadResult.getContent().length);
                                        sb10.append(str6);
                                        sb10.append(downloadResult.getContent().size);
                                        sb10.append(str116);
                                        sb10.append(downloadResult.getContent().realsize);
                                        sb10.append(", retry=(");
                                        sb10.append(getCurrAttemptCount());
                                        sb10.append(str10);
                                        sb10.append(getTotalAttemptCount());
                                        sb10.append("), reason=");
                                        sb10.append(downloadResult.getStatus().getFailReason());
                                        sb10.append(", httpStatus=");
                                        sb10.append(0);
                                        sb10.append(str5);
                                        sb10.append(parserHttpHeaderInfo4);
                                        sb10.append(str);
                                        sb10.append((String) null);
                                        sb10.append(", ipUrl:");
                                        String str140 = this.mRealUrl;
                                        if (str140 != null) {
                                            str140 = str140.substring(0, 30);
                                        }
                                        sb10.append(str140);
                                        sb10.append(", clientip=");
                                        sb10.append(downloadResult.getContent().clientip);
                                        sb10.append(", getIP=");
                                        sb10.append(0L);
                                        sb10.append(", connect:(");
                                        sb10.append(this.connect_time);
                                        sb10.append(str10);
                                        sb10.append(this.connect_retry);
                                        sb10.append("), exeReqest:(");
                                        sb10.append(this.exe_time);
                                        sb10.append(str10);
                                        sb10.append(this.exe_retry);
                                        sb10.append("), sendReq=");
                                        sb10.append(this.send_req_time);
                                        sb10.append(", recvData=");
                                        sb10.append(this.t_recv_data);
                                        sb10.append(", Concurrent:(");
                                        sb10.append(getTaskConcurrentCount());
                                        sb10.append("), mobileProxy=");
                                        DownloadTask.DownloadTaskHandler downloadTaskHandler4 = this.mDownloadTaskHandler;
                                        sb10.append(downloadTaskHandler4 != null ? downloadTaskHandler4.getCustomProxy() : null);
                                        String sb11 = sb10.toString();
                                        downloadReport9.logInfo = sb11;
                                        QDLog.e(QDLog.TAG_DOWNLOAD_RESULT, sb11, null);
                                        z18 = isNetworkAvailable2;
                                        str52 = str51;
                                        str53 = str50;
                                        str56 = str5;
                                        str57 = parserHttpHeaderInfo4;
                                        str55 = str6;
                                        str59 = str;
                                        str58 = str119;
                                        downloadReport5 = downloadReport9;
                                        str54 = str49;
                                    } else {
                                        z18 = isNetworkAvailable2;
                                        str52 = str51;
                                        str53 = str50;
                                        str54 = str49;
                                        StringBuilder sb12 = new StringBuilder();
                                        sb12.append("Downloader, succeed to download:");
                                        sb12.append(getUrl());
                                        sb12.append(str2);
                                        sb12.append(this.mIsHttp2);
                                        sb12.append(str4);
                                        boolean z28 = this.mIsHttp2;
                                        sb12.append(str12);
                                        sb12.append(str3);
                                        sb12.append(dns7);
                                        sb12.append(str103);
                                        sb12.append((String) null);
                                        sb12.append(str102);
                                        sb12.append((String) null);
                                        sb12.append(str101);
                                        sb12.append(Thread.currentThread().getId());
                                        sb12.append(str118);
                                        sb12.append(NetworkManager.getApnValue());
                                        sb12.append(str117);
                                        sb12.append(Config.getNetworkStackType());
                                        sb12.append(str52);
                                        sb12.append(downloadResult.getProcess().duration);
                                        sb12.append(str53);
                                        sb12.append(SystemClock.uptimeMillis() - this.mTimeStamp);
                                        sb12.append(str54);
                                        sb12.append(downloadResult.getContent().length);
                                        str55 = str6;
                                        sb12.append(str55);
                                        sb12.append(downloadResult.getContent().size);
                                        sb12.append(str116);
                                        sb12.append(downloadResult.getContent().realsize);
                                        sb12.append(", retry=(");
                                        sb12.append(getCurrAttemptCount());
                                        sb12.append(str10);
                                        sb12.append(getTotalAttemptCount());
                                        sb12.append("), httpStatus=");
                                        sb12.append(0);
                                        str56 = str5;
                                        sb12.append(str56);
                                        str57 = parserHttpHeaderInfo4;
                                        sb12.append(str57);
                                        str58 = str119;
                                        sb12.append(str58);
                                        sb12.append(downloadResult.getContent().type);
                                        str59 = str;
                                        sb12.append(str59);
                                        sb12.append((String) null);
                                        sb12.append(", ipUrl:");
                                        String str141 = this.mRealUrl;
                                        if (str141 != null) {
                                            str141 = str141.substring(0, 30);
                                        }
                                        sb12.append(str141);
                                        sb12.append(", clientip=");
                                        sb12.append(downloadResult.getContent().clientip);
                                        sb12.append(", getIP=");
                                        sb12.append(0L);
                                        sb12.append(", connect:(");
                                        sb12.append(this.connect_time);
                                        sb12.append(str10);
                                        sb12.append(this.connect_retry);
                                        sb12.append("), exeReqest:(");
                                        sb12.append(this.exe_time);
                                        sb12.append(str10);
                                        sb12.append(this.exe_retry);
                                        sb12.append("), sendReq=");
                                        sb12.append(this.send_req_time);
                                        sb12.append(", recvData=");
                                        sb12.append(this.t_recv_data);
                                        sb12.append(", Concurrent:(");
                                        sb12.append(getTaskConcurrentCount());
                                        sb12.append("), mobileProxy=");
                                        DownloadTask.DownloadTaskHandler downloadTaskHandler5 = this.mDownloadTaskHandler;
                                        sb12.append(downloadTaskHandler5 != null ? downloadTaskHandler5.getCustomProxy() : null);
                                        String sb13 = sb12.toString();
                                        downloadReport5 = downloadReport9;
                                        downloadReport5.logInfo = sb13;
                                        QDLog.w(QDLog.TAG_DOWNLOAD_RESULT, sb13, null);
                                    }
                                    if (!z18) {
                                        this.mShouldReport = false;
                                    }
                                    DownloadResult.Status status2 = downloadResult.getStatus();
                                    StringBuilder sb14 = new StringBuilder();
                                    sb14.append(getUrl());
                                    sb14.append(" sip=");
                                    sb14.append((String) null);
                                    sb14.append(", client=");
                                    sb14.append(downloadResult.getContent().clientip);
                                    sb14.append(", ipType=");
                                    DownloadGlobalStrategy.StrategyInfo strategyInfo2 = this.pCurrStrategyInfo;
                                    sb14.append(strategyInfo2 != null ? strategyInfo2.f99899id : 0);
                                    sb14.append(", httpStatus=");
                                    sb14.append(0);
                                    sb14.append(str58);
                                    sb14.append(downloadResult.getContent().type);
                                    sb14.append(str54);
                                    sb14.append(downloadResult.getContent().length);
                                    sb14.append(str55);
                                    sb14.append(downloadResult.getContent().size);
                                    sb14.append(str52);
                                    sb14.append(downloadResult.getProcess().duration);
                                    sb14.append(str53);
                                    sb14.append(SystemClock.uptimeMillis() - this.mTimeStamp);
                                    if (TextUtils.isEmpty(null)) {
                                        str60 = "";
                                    } else {
                                        str60 = str59 + ((String) null);
                                    }
                                    sb14.append(str60);
                                    sb14.append(str56);
                                    sb14.append(str57);
                                    status2.detailDownloadInfo = sb14.toString();
                                    if (z18) {
                                        DownloadGlobalStrategy downloadGlobalStrategy2 = DownloadGlobalStrategy.getInstance(this.mContext);
                                        String str142 = this.mRealUrl;
                                        downloadGlobalStrategy2.reportHttps(str142, this.mIsHttp2 && str142 != null && str142.startsWith("https"), downloadResult.getStatus().isSucceed());
                                    }
                                    downloadReport5.endTime = System.currentTimeMillis();
                                    downloadReport5.fileSize = getContentLength();
                                    downloadReport5.okResponse = null;
                                    downloadReport5.httpStatus = 0;
                                    downloadReport5.exception = null;
                                    downloadReport5.dns = dns7 == null ? null : dns7.toString();
                                    downloadReport5.localAddress = null;
                                    downloadReport5.clientip = downloadResult.getContent().clientip;
                                    downloadReport5.totaltime = SystemClock.uptimeMillis() - this.mTimeStamp;
                                    downloadReport5.downloadTime = downloadResult.getProcess().duration;
                                    downloadReport5.t_wait = downloadReport5.totaltime - downloadResult.getProcess().duration;
                                    downloadReport5.t_prepare = 0L;
                                    downloadReport5.t_conn = this.connect_time;
                                    downloadReport5.t_recvrsp = this.send_req_time;
                                    downloadReport5.t_recvdata = this.t_recv_data;
                                    downloadReport5.t_process = 0L;
                                    downloadReport5.concurrent = getTaskConcurrentCount();
                                    downloadReport5.content_type = downloadResult.getContent().type;
                                    downloadReport5.isFromQzoneAlbum = Config.isFromQzoneAlbum(getDomain());
                                    downloadReport5.isHttp2 = this.mIsHttp2;
                                    String str143 = this.mRealUrl;
                                    downloadReport5.isHttps = str143 != null && str143.startsWith("https");
                                    downloadReport5.isSucceed = downloadResult.getStatus().isSucceed();
                                    downloadReport5.downloadMode = Downloader.DownloadMode.RangeMode.ordinal();
                                    downloadReport5.timeCostForRangeReceivePhase = this.mRangeDownloaderManager.getDurationMillisForRangeReceivePhase();
                                    downloadReport5.rangeDownloadReports = this.mRangeDownloaderManager.getRangeDownloadReports();
                                    downloadReport5.rangeNumber = this.mRangeDownloaderManager.getNumberOfRangeTasks();
                                    downloadResult.setReport(downloadReport5);
                                    if (downloadResult.getStatus().isSucceed()) {
                                        handleDownloadReportForTask(jobContext, downloadResult, downloadReport5);
                                    }
                                }
                                this.okRequestBuilder = null;
                                return;
                            }
                        } catch (Throwable th21) {
                            th = th21;
                            jobContext2 = jobContext;
                            str2 = str2;
                            j3 = uptimeMillis2;
                            str13 = str101;
                            str14 = str102;
                            str15 = str103;
                            downloadReport = downloadReport9;
                            str11 = str119;
                            str9 = str51;
                            str8 = str50;
                            str7 = str49;
                            response = null;
                            i17 = 0;
                            th5 = th;
                            QDLog.e(QDLog.TAG_DOWNLOAD_RANGE, "download " + getUrl() + " exception:", th5);
                            downloadResult.getStatus().setFailed(th5);
                            int i3622222 = i16 + 1;
                            DownloadReport downloadReport1022222 = downloadReport;
                            downloadResult.getProcess().setDuration(j3, SystemClock.uptimeMillis());
                            downloadResult.getProcess().totalDuration = SystemClock.uptimeMillis() - this.mTimeStamp;
                            downloadResult.getProcess().startTimestamp = this.mTaskStartTimeStamp;
                            NetworkUtils.DNS dns522222 = NetworkStatus.getInstance(this.mContext).getDNS();
                            String parserHttpHeaderInfo32222 = parserHttpHeaderInfo(null, null, response);
                            if (response != null) {
                            }
                            downloadResult.getContent().redirectUrl = r3;
                            this.connect_time = 0L;
                            this.connect_retry = 0;
                            this.exe_time = 0L;
                            this.exe_retry = 0;
                            if (jobContext.isCancelled()) {
                            }
                            this.okRequestBuilder = null;
                            i28 = i19;
                            if (!canAttempt()) {
                            }
                        }
                    }
                } catch (Throwable th22) {
                    th = th22;
                }
                if (this.mRangeDownloaderManager.tryBuildAllRangeRequests(getUrl(), this.mRealUrl, this.okRequestBuilder, downloadResult.getPath(), this) && this.mRangeDownloaderManager.createEmptyFile(downloadResult.getPath())) {
                    this.send_req_time = SystemClock.uptimeMillis() - uptimeMillis;
                    QDLog.i(QDLog.TAG_DOWNLOAD_RANGE, "download on rangeMode, " + getUrl() + ", realUrl:" + this.mRealUrl);
                    downloadResult.getContent().length = this.mRangeDownloaderManager.getContentLength();
                    this.mContentLength = this.mRangeDownloaderManager.getContentLength();
                    response = this.mRangeDownloaderManager.execute();
                    try {
                        downloadResult.getContent().size = this.mRangeDownloaderManager.getTotalFileSize();
                        response5 = response;
                        str61 = str116;
                        str62 = str117;
                        str63 = str118;
                        str64 = str119;
                        str65 = str;
                        str66 = str50;
                        str67 = str4;
                        str68 = str3;
                    } catch (Throwable th23) {
                        th = th23;
                        jobContext2 = jobContext;
                        str2 = str2;
                        j3 = uptimeMillis2;
                        str13 = str101;
                        str14 = str102;
                        str15 = str103;
                        downloadReport = downloadReport9;
                        str11 = str119;
                        str9 = str51;
                        str8 = str50;
                        str7 = str49;
                        i17 = 0;
                        th5 = th;
                        QDLog.e(QDLog.TAG_DOWNLOAD_RANGE, "download " + getUrl() + " exception:", th5);
                        downloadResult.getStatus().setFailed(th5);
                        int i36222222 = i16 + 1;
                        DownloadReport downloadReport10222222 = downloadReport;
                        downloadResult.getProcess().setDuration(j3, SystemClock.uptimeMillis());
                        downloadResult.getProcess().totalDuration = SystemClock.uptimeMillis() - this.mTimeStamp;
                        downloadResult.getProcess().startTimestamp = this.mTaskStartTimeStamp;
                        NetworkUtils.DNS dns5222222 = NetworkStatus.getInstance(this.mContext).getDNS();
                        String parserHttpHeaderInfo322222 = parserHttpHeaderInfo(null, null, response);
                        if (response != null) {
                        }
                        downloadResult.getContent().redirectUrl = r3;
                        this.connect_time = 0L;
                        this.connect_retry = 0;
                        this.exe_time = 0L;
                        this.exe_retry = 0;
                        if (jobContext.isCancelled()) {
                        }
                        this.okRequestBuilder = null;
                        i28 = i19;
                        if (!canAttempt()) {
                        }
                    }
                    if (response5 == null) {
                        try {
                            int code = response5.code();
                            try {
                                downloadResult.getStatus().httpStatus = code;
                                if (200 == code) {
                                    try {
                                        downloadResult.getStatus().setSucceed();
                                        String str144 = str66;
                                        String str145 = str62;
                                        downloadResult.getProcess().setDuration(uptimeMillis2, SystemClock.uptimeMillis());
                                        downloadResult.getProcess().totalDuration = SystemClock.uptimeMillis() - this.mTimeStamp;
                                        downloadResult.getProcess().startTimestamp = this.mTaskStartTimeStamp;
                                        NetworkUtils.DNS dns8 = NetworkStatus.getInstance(this.mContext).getDNS();
                                        String parserHttpHeaderInfo5 = parserHttpHeaderInfo(null, null, response5);
                                        String header2 = response5.priorResponse() != null ? response5.priorResponse().header("Location") : null;
                                        downloadResult.getContent().redirectUrl = header2;
                                        this.connect_time = 0L;
                                        String str146 = header2;
                                        this.connect_retry = 0;
                                        this.exe_time = 0L;
                                        this.exe_retry = 0;
                                        if (!jobContext.isCancelled()) {
                                            boolean isNetworkAvailable3 = NetworkUtils.isNetworkAvailable(this.mContext);
                                            if (!downloadResult.getStatus().isSucceed()) {
                                                StringBuilder sb15 = new StringBuilder();
                                                sb15.append("Downloader, fail to download:");
                                                sb15.append(getUrl());
                                                sb15.append(str2);
                                                sb15.append(this.mIsHttp2);
                                                sb15.append(str67);
                                                sb15.append((!this.mIsHttp2 || response5.protocol() == null) ? str12 : response5.protocol().getProtocol());
                                                sb15.append(str68);
                                                sb15.append(dns8);
                                                sb15.append(str103);
                                                sb15.append((String) null);
                                                sb15.append(str102);
                                                sb15.append((String) null);
                                                sb15.append(str101);
                                                sb15.append(Thread.currentThread().getId());
                                                sb15.append(str63);
                                                sb15.append(NetworkManager.getApnValue());
                                                sb15.append(", netAvailable=");
                                                sb15.append(isNetworkAvailable3);
                                                sb15.append(str145);
                                                sb15.append(Config.getNetworkStackType());
                                                sb15.append(str64);
                                                sb15.append(downloadResult.getContent().type);
                                                sb15.append(str51);
                                                sb15.append(downloadResult.getProcess().duration);
                                                sb15.append(str144);
                                                sb15.append(SystemClock.uptimeMillis() - this.mTimeStamp);
                                                sb15.append(str49);
                                                sb15.append(downloadResult.getContent().length);
                                                sb15.append(str6);
                                                sb15.append(downloadResult.getContent().size);
                                                sb15.append(str61);
                                                sb15.append(downloadResult.getContent().realsize);
                                                sb15.append(", retry=(");
                                                sb15.append(getCurrAttemptCount());
                                                sb15.append(str10);
                                                sb15.append(getTotalAttemptCount());
                                                sb15.append("), reason=");
                                                sb15.append(downloadResult.getStatus().getFailReason());
                                                sb15.append(", httpStatus=");
                                                sb15.append(code);
                                                sb15.append(str5);
                                                sb15.append(parserHttpHeaderInfo5);
                                                String str147 = str65;
                                                sb15.append(str147);
                                                str78 = str146;
                                                sb15.append(str78);
                                                sb15.append(", ipUrl:");
                                                String str148 = this.mRealUrl;
                                                if (str148 != null) {
                                                    str80 = str49;
                                                    str148 = str148.substring(0, 30);
                                                } else {
                                                    str80 = str49;
                                                }
                                                sb15.append(str148);
                                                sb15.append(", clientip=");
                                                sb15.append(downloadResult.getContent().clientip);
                                                sb15.append(", getIP=");
                                                sb15.append(0L);
                                                sb15.append(", connect:(");
                                                sb15.append(this.connect_time);
                                                sb15.append(str10);
                                                sb15.append(this.connect_retry);
                                                sb15.append("), exeReqest:(");
                                                sb15.append(this.exe_time);
                                                sb15.append(str10);
                                                sb15.append(this.exe_retry);
                                                sb15.append("), sendReq=");
                                                sb15.append(this.send_req_time);
                                                sb15.append(", recvData=");
                                                sb15.append(this.t_recv_data);
                                                sb15.append(", Concurrent:(");
                                                sb15.append(getTaskConcurrentCount());
                                                sb15.append("), mobileProxy=");
                                                DownloadTask.DownloadTaskHandler downloadTaskHandler6 = this.mDownloadTaskHandler;
                                                sb15.append(downloadTaskHandler6 != null ? downloadTaskHandler6.getCustomProxy() : null);
                                                String sb16 = sb15.toString();
                                                downloadReport9.logInfo = sb16;
                                                QDLog.e(QDLog.TAG_DOWNLOAD_RESULT, sb16, null);
                                                dns3 = dns8;
                                                z19 = isNetworkAvailable3;
                                                str76 = str64;
                                                response6 = response5;
                                                i26 = code;
                                                str73 = str6;
                                                downloadReport6 = downloadReport9;
                                                str74 = str5;
                                                str77 = str147;
                                                str72 = str51;
                                                str70 = str144;
                                                str75 = parserHttpHeaderInfo5;
                                                str71 = str80;
                                            } else {
                                                String str149 = str64;
                                                str70 = str144;
                                                str71 = str49;
                                                String str150 = str65;
                                                String str151 = str61;
                                                z19 = isNetworkAvailable3;
                                                str72 = str51;
                                                StringBuilder sb17 = new StringBuilder();
                                                sb17.append("Downloader, succeed to download:");
                                                sb17.append(getUrl());
                                                sb17.append(str2);
                                                sb17.append(this.mIsHttp2);
                                                sb17.append(str67);
                                                sb17.append((!this.mIsHttp2 || response5.protocol() == null) ? str12 : response5.protocol().getProtocol());
                                                sb17.append(str68);
                                                sb17.append(dns8);
                                                sb17.append(str103);
                                                sb17.append((String) null);
                                                sb17.append(str102);
                                                sb17.append((String) null);
                                                sb17.append(str101);
                                                sb17.append(Thread.currentThread().getId());
                                                sb17.append(str63);
                                                sb17.append(NetworkManager.getApnValue());
                                                sb17.append(str145);
                                                sb17.append(Config.getNetworkStackType());
                                                sb17.append(str72);
                                                sb17.append(downloadResult.getProcess().duration);
                                                sb17.append(str70);
                                                sb17.append(SystemClock.uptimeMillis() - this.mTimeStamp);
                                                sb17.append(str71);
                                                sb17.append(downloadResult.getContent().length);
                                                str73 = str6;
                                                sb17.append(str73);
                                                sb17.append(downloadResult.getContent().size);
                                                sb17.append(str151);
                                                sb17.append(downloadResult.getContent().realsize);
                                                sb17.append(", retry=(");
                                                sb17.append(getCurrAttemptCount());
                                                sb17.append(str10);
                                                sb17.append(getTotalAttemptCount());
                                                sb17.append("), httpStatus=");
                                                i26 = code;
                                                sb17.append(i26);
                                                str74 = str5;
                                                sb17.append(str74);
                                                str75 = parserHttpHeaderInfo5;
                                                sb17.append(str75);
                                                str76 = str149;
                                                sb17.append(str76);
                                                sb17.append(downloadResult.getContent().type);
                                                sb17.append(str150);
                                                sb17.append(str146);
                                                sb17.append(", ipUrl:");
                                                String str152 = this.mRealUrl;
                                                dns3 = dns8;
                                                if (str152 != null) {
                                                    response6 = response5;
                                                    str152 = str152.substring(0, 30);
                                                } else {
                                                    response6 = response5;
                                                }
                                                sb17.append(str152);
                                                sb17.append(", clientip=");
                                                sb17.append(downloadResult.getContent().clientip);
                                                sb17.append(", getIP=");
                                                str77 = str150;
                                                str78 = str146;
                                                sb17.append(0L);
                                                sb17.append(", connect:(");
                                                sb17.append(this.connect_time);
                                                sb17.append(str10);
                                                sb17.append(this.connect_retry);
                                                sb17.append("), exeReqest:(");
                                                sb17.append(this.exe_time);
                                                sb17.append(str10);
                                                sb17.append(this.exe_retry);
                                                sb17.append("), sendReq=");
                                                sb17.append(this.send_req_time);
                                                sb17.append(", recvData=");
                                                sb17.append(this.t_recv_data);
                                                sb17.append(", Concurrent:(");
                                                sb17.append(getTaskConcurrentCount());
                                                sb17.append("), mobileProxy=");
                                                DownloadTask.DownloadTaskHandler downloadTaskHandler7 = this.mDownloadTaskHandler;
                                                sb17.append(downloadTaskHandler7 != null ? downloadTaskHandler7.getCustomProxy() : null);
                                                String sb18 = sb17.toString();
                                                downloadReport6 = downloadReport9;
                                                downloadReport6.logInfo = sb18;
                                                QDLog.w(QDLog.TAG_DOWNLOAD_RESULT, sb18, null);
                                            }
                                            if (!z19) {
                                                this.mShouldReport = false;
                                            }
                                            DownloadResult.Status status3 = downloadResult.getStatus();
                                            StringBuilder sb19 = new StringBuilder();
                                            sb19.append(getUrl());
                                            sb19.append(" sip=");
                                            sb19.append((String) null);
                                            sb19.append(", client=");
                                            sb19.append(downloadResult.getContent().clientip);
                                            sb19.append(", ipType=");
                                            DownloadGlobalStrategy.StrategyInfo strategyInfo3 = this.pCurrStrategyInfo;
                                            sb19.append(strategyInfo3 != null ? strategyInfo3.f99899id : 0);
                                            sb19.append(", httpStatus=");
                                            sb19.append(i26);
                                            sb19.append(str76);
                                            sb19.append(downloadResult.getContent().type);
                                            sb19.append(str71);
                                            sb19.append(downloadResult.getContent().length);
                                            sb19.append(str73);
                                            sb19.append(downloadResult.getContent().size);
                                            sb19.append(str72);
                                            sb19.append(downloadResult.getProcess().duration);
                                            sb19.append(str70);
                                            sb19.append(SystemClock.uptimeMillis() - this.mTimeStamp);
                                            if (TextUtils.isEmpty(str78)) {
                                                str79 = "";
                                            } else {
                                                str79 = str77 + str78;
                                            }
                                            sb19.append(str79);
                                            sb19.append(str74);
                                            sb19.append(str75);
                                            status3.detailDownloadInfo = sb19.toString();
                                            if (z19) {
                                                DownloadGlobalStrategy downloadGlobalStrategy3 = DownloadGlobalStrategy.getInstance(this.mContext);
                                                String str153 = this.mRealUrl;
                                                downloadGlobalStrategy3.reportHttps(str153, this.mIsHttp2 && str153 != null && str153.startsWith("https"), downloadResult.getStatus().isSucceed());
                                            }
                                            downloadReport6.endTime = System.currentTimeMillis();
                                            downloadReport6.fileSize = getContentLength();
                                            Response response9 = response6;
                                            downloadReport6.okResponse = response9;
                                            downloadReport6.httpStatus = i26;
                                            downloadReport6.exception = null;
                                            downloadReport6.dns = dns3 == null ? null : dns3.toString();
                                            downloadReport6.localAddress = null;
                                            downloadReport6.clientip = downloadResult.getContent().clientip;
                                            downloadReport6.totaltime = SystemClock.uptimeMillis() - this.mTimeStamp;
                                            downloadReport6.downloadTime = downloadResult.getProcess().duration;
                                            downloadReport6.t_wait = downloadReport6.totaltime - downloadResult.getProcess().duration;
                                            downloadReport6.t_prepare = 0L;
                                            downloadReport6.t_conn = this.connect_time;
                                            downloadReport6.t_recvrsp = this.send_req_time;
                                            downloadReport6.t_recvdata = this.t_recv_data;
                                            downloadReport6.t_process = 0L;
                                            downloadReport6.concurrent = getTaskConcurrentCount();
                                            downloadReport6.content_type = downloadResult.getContent().type;
                                            downloadReport6.isFromQzoneAlbum = Config.isFromQzoneAlbum(getDomain());
                                            downloadReport6.isHttp2 = this.mIsHttp2;
                                            String str154 = this.mRealUrl;
                                            downloadReport6.isHttps = str154 != null && str154.startsWith("https");
                                            downloadReport6.isSucceed = downloadResult.getStatus().isSucceed();
                                            downloadReport6.downloadMode = Downloader.DownloadMode.RangeMode.ordinal();
                                            downloadReport6.timeCostForRangeReceivePhase = this.mRangeDownloaderManager.getDurationMillisForRangeReceivePhase();
                                            if (response9.protocol() != null) {
                                                downloadReport6.f99896protocol = response9.protocol().getProtocol();
                                            }
                                            downloadReport6.rangeDownloadReports = this.mRangeDownloaderManager.getRangeDownloadReports();
                                            downloadReport6.rangeNumber = this.mRangeDownloaderManager.getNumberOfRangeTasks();
                                            downloadResult.setReport(downloadReport6);
                                            if (downloadResult.getStatus().isSucceed()) {
                                                handleDownloadReportForTask(jobContext, downloadResult, downloadReport6);
                                            }
                                        }
                                        this.okRequestBuilder = null;
                                        return;
                                    } catch (Throwable th24) {
                                        str69 = str64;
                                        String str155 = str66;
                                        str117 = str62;
                                        str118 = str63;
                                        str4 = str67;
                                        str3 = str68;
                                        response = response5;
                                        str2 = str2;
                                        str13 = str101;
                                        str14 = str102;
                                        str15 = str103;
                                        i17 = code;
                                        downloadReport = downloadReport9;
                                        str = str65;
                                        str116 = str61;
                                        jobContext2 = jobContext;
                                        th5 = th24;
                                        str8 = str155;
                                        str9 = str51;
                                    }
                                } else {
                                    downloadReport7 = downloadReport9;
                                    str81 = str10;
                                    str82 = str5;
                                    str83 = str65;
                                    str116 = str61;
                                    str69 = str64;
                                    String str156 = str66;
                                    try {
                                        ResumeTransfer resumeTransfer2 = this.pResumeTransfer;
                                        if (resumeTransfer2 != null) {
                                            str84 = str156;
                                            try {
                                                str51 = str51;
                                                try {
                                                    resumeTransfer2.onDownloadResult(getUrl(), true);
                                                } catch (Throwable th25) {
                                                    th = th25;
                                                    str117 = str62;
                                                    str118 = str63;
                                                    str4 = str67;
                                                    str3 = str68;
                                                    response = response5;
                                                    str2 = str2;
                                                    str13 = str101;
                                                    str14 = str102;
                                                    str15 = str103;
                                                    i17 = code;
                                                    str9 = str51;
                                                    str8 = str84;
                                                    downloadReport = downloadReport7;
                                                    str10 = str81;
                                                    str5 = str82;
                                                    str = str83;
                                                    jobContext2 = jobContext;
                                                    th5 = th;
                                                    str11 = str69;
                                                    j3 = uptimeMillis2;
                                                    str7 = str49;
                                                    QDLog.e(QDLog.TAG_DOWNLOAD_RANGE, "download " + getUrl() + " exception:", th5);
                                                    downloadResult.getStatus().setFailed(th5);
                                                    int i362222222 = i16 + 1;
                                                    DownloadReport downloadReport102222222 = downloadReport;
                                                    downloadResult.getProcess().setDuration(j3, SystemClock.uptimeMillis());
                                                    downloadResult.getProcess().totalDuration = SystemClock.uptimeMillis() - this.mTimeStamp;
                                                    downloadResult.getProcess().startTimestamp = this.mTaskStartTimeStamp;
                                                    NetworkUtils.DNS dns52222222 = NetworkStatus.getInstance(this.mContext).getDNS();
                                                    String parserHttpHeaderInfo3222222 = parserHttpHeaderInfo(null, null, response);
                                                    if (response != null) {
                                                    }
                                                    downloadResult.getContent().redirectUrl = r3;
                                                    this.connect_time = 0L;
                                                    this.connect_retry = 0;
                                                    this.exe_time = 0L;
                                                    this.exe_retry = 0;
                                                    if (jobContext.isCancelled()) {
                                                    }
                                                    this.okRequestBuilder = null;
                                                    i28 = i19;
                                                    if (!canAttempt()) {
                                                    }
                                                }
                                            } catch (Throwable th26) {
                                                th = th26;
                                                str9 = str51;
                                                str117 = str62;
                                                str118 = str63;
                                                str4 = str67;
                                                str3 = str68;
                                                response = response5;
                                                str2 = str2;
                                                str13 = str101;
                                                str14 = str102;
                                                str15 = str103;
                                                i17 = code;
                                            }
                                        } else {
                                            str51 = str51;
                                            str84 = str156;
                                        }
                                        i27 = code;
                                    } catch (Throwable th27) {
                                        str117 = str62;
                                        str118 = str63;
                                        str4 = str67;
                                        str3 = str68;
                                        str2 = str2;
                                        str13 = str101;
                                        str14 = str102;
                                        str15 = str103;
                                        i17 = code;
                                        downloadReport = downloadReport7;
                                        str10 = str81;
                                        str5 = str82;
                                        str = str83;
                                        jobContext2 = jobContext;
                                        th5 = th27;
                                        str8 = str156;
                                        str9 = str51;
                                        response = response5;
                                    }
                                }
                                str11 = str69;
                                j3 = uptimeMillis2;
                                str7 = str49;
                            } catch (Throwable th28) {
                                th = th28;
                                str117 = str62;
                                str118 = str63;
                                str4 = str67;
                                str3 = str68;
                                str2 = str2;
                                str13 = str101;
                                str14 = str102;
                                str15 = str103;
                                i17 = code;
                                downloadReport = downloadReport9;
                                str = str65;
                                str116 = str61;
                                jobContext2 = jobContext;
                                th5 = th;
                                str8 = str66;
                                response = response5;
                                j3 = uptimeMillis2;
                                str7 = str49;
                                str11 = str64;
                                str9 = str51;
                                QDLog.e(QDLog.TAG_DOWNLOAD_RANGE, "download " + getUrl() + " exception:", th5);
                                downloadResult.getStatus().setFailed(th5);
                                int i3622222222 = i16 + 1;
                                DownloadReport downloadReport1022222222 = downloadReport;
                                downloadResult.getProcess().setDuration(j3, SystemClock.uptimeMillis());
                                downloadResult.getProcess().totalDuration = SystemClock.uptimeMillis() - this.mTimeStamp;
                                downloadResult.getProcess().startTimestamp = this.mTaskStartTimeStamp;
                                NetworkUtils.DNS dns522222222 = NetworkStatus.getInstance(this.mContext).getDNS();
                                String parserHttpHeaderInfo32222222 = parserHttpHeaderInfo(null, null, response);
                                if (response != null) {
                                }
                                downloadResult.getContent().redirectUrl = r3;
                                this.connect_time = 0L;
                                this.connect_retry = 0;
                                this.exe_time = 0L;
                                this.exe_retry = 0;
                                if (jobContext.isCancelled()) {
                                }
                                this.okRequestBuilder = null;
                                i28 = i19;
                                if (!canAttempt()) {
                                }
                            }
                        } catch (Throwable th29) {
                            th = th29;
                            str117 = str62;
                            str118 = str63;
                            str4 = str67;
                            str3 = str68;
                            str2 = str2;
                            str13 = str101;
                            str14 = str102;
                            str15 = str103;
                            downloadReport = downloadReport9;
                            str = str65;
                            str116 = str61;
                            i17 = 0;
                        }
                        QDLog.e(QDLog.TAG_DOWNLOAD_RANGE, "download " + getUrl() + " exception:", th5);
                        downloadResult.getStatus().setFailed(th5);
                        int i36222222222 = i16 + 1;
                        DownloadReport downloadReport10222222222 = downloadReport;
                        downloadResult.getProcess().setDuration(j3, SystemClock.uptimeMillis());
                        downloadResult.getProcess().totalDuration = SystemClock.uptimeMillis() - this.mTimeStamp;
                        downloadResult.getProcess().startTimestamp = this.mTaskStartTimeStamp;
                        NetworkUtils.DNS dns5222222222 = NetworkStatus.getInstance(this.mContext).getDNS();
                        String parserHttpHeaderInfo322222222 = parserHttpHeaderInfo(null, null, response);
                        String header3 = (response != null || response.priorResponse() == null) ? null : response.priorResponse().header("Location");
                        downloadResult.getContent().redirectUrl = header3;
                        this.connect_time = 0L;
                        this.connect_retry = 0;
                        this.exe_time = 0L;
                        this.exe_retry = 0;
                        if (jobContext.isCancelled()) {
                            i19 = i36222222222;
                            jobContext3 = jobContext2;
                            str33 = str9;
                            str34 = str8;
                            str35 = str11;
                            str36 = str13;
                            str37 = str6;
                            str38 = str5;
                            str39 = str4;
                            downloadResult2 = downloadResult;
                        } else {
                            boolean isNetworkAvailable4 = NetworkUtils.isNetworkAvailable(this.mContext);
                            if (!downloadResult.getStatus().isSucceed()) {
                                StringBuilder sb20 = new StringBuilder();
                                sb20.append("Downloader, fail to download:");
                                sb20.append(getUrl());
                                String str157 = str2;
                                sb20.append(str157);
                                i19 = i36222222222;
                                sb20.append(this.mIsHttp2);
                                String str158 = str4;
                                sb20.append(str158);
                                sb20.append((!this.mIsHttp2 || response == null || response.protocol() == null) ? str12 : response.protocol().getProtocol());
                                response4 = response;
                                sb20.append(str3);
                                sb20.append(dns5222222222);
                                dns2 = dns5222222222;
                                sb20.append(str15);
                                sb20.append((String) null);
                                sb20.append(str14);
                                sb20.append((String) null);
                                sb20.append(str13);
                                sb20.append(Thread.currentThread().getId());
                                sb20.append(str118);
                                sb20.append(NetworkManager.getApnValue());
                                sb20.append(", netAvailable=");
                                sb20.append(isNetworkAvailable4);
                                sb20.append(str117);
                                z17 = isNetworkAvailable4;
                                sb20.append(Config.getNetworkStackType());
                                sb20.append(str11);
                                sb20.append(downloadResult.getContent().type);
                                sb20.append(str9);
                                sb20.append(downloadResult.getProcess().duration);
                                sb20.append(str8);
                                String str159 = str9;
                                str40 = str8;
                                sb20.append(SystemClock.uptimeMillis() - this.mTimeStamp);
                                sb20.append(str7);
                                sb20.append(downloadResult.getContent().length);
                                str37 = str6;
                                sb20.append(str37);
                                sb20.append(downloadResult.getContent().size);
                                String str160 = str116;
                                sb20.append(str160);
                                sb20.append(downloadResult.getContent().realsize);
                                sb20.append(", retry=(");
                                sb20.append(getCurrAttemptCount());
                                str41 = str10;
                                sb20.append(str41);
                                sb20.append(getTotalAttemptCount());
                                sb20.append("), reason=");
                                sb20.append(downloadResult.getStatus().getFailReason());
                                sb20.append(", httpStatus=");
                                sb20.append(i17);
                                str38 = str5;
                                sb20.append(str38);
                                sb20.append(parserHttpHeaderInfo322222222);
                                sb20.append(str);
                                sb20.append(header3);
                                String str161 = header3;
                                sb20.append(", ipUrl:");
                                String str162 = this.mRealUrl;
                                if (str162 != null) {
                                    str48 = str11;
                                    str162 = str162.substring(0, 30);
                                } else {
                                    str48 = str11;
                                }
                                sb20.append(str162);
                                sb20.append(", clientip=");
                                sb20.append(downloadResult.getContent().clientip);
                                sb20.append(", getIP=");
                                sb20.append(0L);
                                sb20.append(", connect:(");
                                sb20.append(this.connect_time);
                                sb20.append(str41);
                                sb20.append(this.connect_retry);
                                sb20.append("), exeReqest:(");
                                sb20.append(this.exe_time);
                                sb20.append(str41);
                                sb20.append(this.exe_retry);
                                sb20.append("), sendReq=");
                                sb20.append(this.send_req_time);
                                sb20.append(", recvData=");
                                sb20.append(this.t_recv_data);
                                sb20.append(", Concurrent:(");
                                sb20.append(getTaskConcurrentCount());
                                sb20.append("), mobileProxy=");
                                DownloadTask.DownloadTaskHandler downloadTaskHandler8 = this.mDownloadTaskHandler;
                                sb20.append(downloadTaskHandler8 != null ? downloadTaskHandler8.getCustomProxy() : null);
                                String sb21 = sb20.toString();
                                downloadReport4 = downloadReport10222222222;
                                downloadReport4.logInfo = sb21;
                                QDLog.e(QDLog.TAG_DOWNLOAD_RESULT, sb21, th5);
                                str116 = str160;
                                str46 = parserHttpHeaderInfo322222222;
                                str42 = str158;
                                str2 = str157;
                                str45 = str161;
                                str44 = str;
                                str43 = str159;
                                str36 = str13;
                                th9 = th5;
                                str35 = str48;
                            } else {
                                i19 = i36222222222;
                                response4 = response;
                                dns2 = dns5222222222;
                                String str163 = header3;
                                String str164 = str9;
                                str40 = str8;
                                z17 = isNetworkAvailable4;
                                String str165 = str11;
                                String str166 = str116;
                                downloadReport4 = downloadReport10222222222;
                                String str167 = str2;
                                str41 = str10;
                                str37 = str6;
                                str38 = str5;
                                String str168 = str4;
                                StringBuilder sb22 = new StringBuilder();
                                sb22.append("Downloader, succeed to download:");
                                sb22.append(getUrl());
                                sb22.append(str167);
                                sb22.append(this.mIsHttp2);
                                sb22.append(str168);
                                sb22.append((!this.mIsHttp2 || response4 == null || response4.protocol() == null) ? str12 : response4.protocol().getProtocol());
                                sb22.append(str3);
                                sb22.append(dns2);
                                String str169 = str15;
                                sb22.append(str169);
                                str42 = str168;
                                sb22.append((String) null);
                                sb22.append(str14);
                                sb22.append((String) null);
                                String str170 = str13;
                                sb22.append(str170);
                                str2 = str167;
                                sb22.append(Thread.currentThread().getId());
                                sb22.append(str118);
                                sb22.append(NetworkManager.getApnValue());
                                sb22.append(str117);
                                str15 = str169;
                                sb22.append(Config.getNetworkStackType());
                                str43 = str164;
                                sb22.append(str43);
                                sb22.append(downloadResult.getProcess().duration);
                                sb22.append(str40);
                                Throwable th30 = th5;
                                sb22.append(SystemClock.uptimeMillis() - this.mTimeStamp);
                                sb22.append(str7);
                                sb22.append(downloadResult.getContent().length);
                                sb22.append(str37);
                                sb22.append(downloadResult.getContent().size);
                                sb22.append(str166);
                                sb22.append(downloadResult.getContent().realsize);
                                sb22.append(", retry=(");
                                sb22.append(getCurrAttemptCount());
                                sb22.append(str41);
                                sb22.append(getTotalAttemptCount());
                                sb22.append("), httpStatus=");
                                sb22.append(i17);
                                sb22.append(str38);
                                sb22.append(parserHttpHeaderInfo322222222);
                                str35 = str165;
                                sb22.append(str35);
                                sb22.append(downloadResult.getContent().type);
                                str44 = str;
                                sb22.append(str44);
                                th9 = th30;
                                str45 = str163;
                                sb22.append(str45);
                                str116 = str166;
                                sb22.append(", ipUrl:");
                                String str171 = this.mRealUrl;
                                if (str171 != null) {
                                    str36 = str170;
                                    str46 = parserHttpHeaderInfo322222222;
                                    str171 = str171.substring(0, 30);
                                } else {
                                    str46 = parserHttpHeaderInfo322222222;
                                    str36 = str170;
                                }
                                sb22.append(str171);
                                sb22.append(", clientip=");
                                sb22.append(downloadResult.getContent().clientip);
                                sb22.append(", getIP=");
                                sb22.append(0L);
                                sb22.append(", connect:(");
                                sb22.append(this.connect_time);
                                sb22.append(str41);
                                sb22.append(this.connect_retry);
                                sb22.append("), exeReqest:(");
                                sb22.append(this.exe_time);
                                sb22.append(str41);
                                sb22.append(this.exe_retry);
                                sb22.append("), sendReq=");
                                sb22.append(this.send_req_time);
                                sb22.append(", recvData=");
                                sb22.append(this.t_recv_data);
                                sb22.append(", Concurrent:(");
                                sb22.append(getTaskConcurrentCount());
                                sb22.append("), mobileProxy=");
                                DownloadTask.DownloadTaskHandler downloadTaskHandler9 = this.mDownloadTaskHandler;
                                sb22.append(downloadTaskHandler9 != null ? downloadTaskHandler9.getCustomProxy() : null);
                                String sb23 = sb22.toString();
                                downloadReport4.logInfo = sb23;
                                QDLog.w(QDLog.TAG_DOWNLOAD_RESULT, sb23, null);
                            }
                            if (!z17) {
                                this.mShouldReport = false;
                            }
                            DownloadResult.Status status4 = downloadResult.getStatus();
                            StringBuilder sb24 = new StringBuilder();
                            sb24.append(getUrl());
                            sb24.append(" sip=");
                            sb24.append((String) null);
                            sb24.append(", client=");
                            sb24.append(downloadResult.getContent().clientip);
                            sb24.append(", ipType=");
                            DownloadGlobalStrategy.StrategyInfo strategyInfo4 = this.pCurrStrategyInfo;
                            sb24.append(strategyInfo4 != null ? strategyInfo4.f99899id : 0);
                            sb24.append(", httpStatus=");
                            sb24.append(i17);
                            sb24.append(str35);
                            sb24.append(downloadResult.getContent().type);
                            sb24.append(str7);
                            str10 = str41;
                            sb24.append(downloadResult.getContent().length);
                            sb24.append(str37);
                            sb24.append(downloadResult.getContent().size);
                            sb24.append(str43);
                            sb24.append(downloadResult.getProcess().duration);
                            str34 = str40;
                            sb24.append(str34);
                            str33 = str43;
                            sb24.append(SystemClock.uptimeMillis() - this.mTimeStamp);
                            if (TextUtils.isEmpty(str45)) {
                                str47 = "";
                            } else {
                                str47 = str44 + str45;
                            }
                            sb24.append(str47);
                            sb24.append(str38);
                            sb24.append(str46);
                            status4.detailDownloadInfo = sb24.toString();
                            if (z17) {
                                DownloadGlobalStrategy downloadGlobalStrategy4 = DownloadGlobalStrategy.getInstance(this.mContext);
                                String str172 = this.mRealUrl;
                                downloadGlobalStrategy4.reportHttps(str172, this.mIsHttp2 && str172 != null && str172.startsWith("https"), downloadResult.getStatus().isSucceed());
                            }
                            downloadReport4.endTime = System.currentTimeMillis();
                            downloadReport4.fileSize = getContentLength();
                            Response response10 = response4;
                            downloadReport4.okResponse = response10;
                            downloadReport4.httpStatus = i17;
                            downloadReport4.exception = th9;
                            downloadReport4.dns = dns2 == null ? null : dns2.toString();
                            downloadReport4.localAddress = null;
                            downloadReport4.clientip = downloadResult.getContent().clientip;
                            str = str44;
                            downloadReport4.totaltime = SystemClock.uptimeMillis() - this.mTimeStamp;
                            downloadReport4.downloadTime = downloadResult.getProcess().duration;
                            downloadReport4.t_wait = downloadReport4.totaltime - downloadResult.getProcess().duration;
                            downloadReport4.t_prepare = 0L;
                            downloadReport4.t_conn = this.connect_time;
                            downloadReport4.t_recvrsp = this.send_req_time;
                            downloadReport4.t_recvdata = this.t_recv_data;
                            downloadReport4.t_process = 0L;
                            downloadReport4.concurrent = getTaskConcurrentCount();
                            downloadReport4.content_type = downloadResult.getContent().type;
                            downloadReport4.isFromQzoneAlbum = Config.isFromQzoneAlbum(getDomain());
                            downloadReport4.isHttp2 = this.mIsHttp2;
                            String str173 = this.mRealUrl;
                            downloadReport4.isHttps = str173 != null && str173.startsWith("https");
                            downloadReport4.isSucceed = downloadResult.getStatus().isSucceed();
                            downloadReport4.downloadMode = Downloader.DownloadMode.RangeMode.ordinal();
                            downloadReport4.timeCostForRangeReceivePhase = this.mRangeDownloaderManager.getDurationMillisForRangeReceivePhase();
                            if (response10 != null && response10.protocol() != null) {
                                downloadReport4.f99896protocol = response10.protocol().getProtocol();
                            }
                            downloadReport4.rangeDownloadReports = this.mRangeDownloaderManager.getRangeDownloadReports();
                            downloadReport4.rangeNumber = this.mRangeDownloaderManager.getNumberOfRangeTasks();
                            downloadResult2 = downloadResult;
                            downloadResult2.setReport(downloadReport4);
                            jobContext3 = jobContext;
                            str39 = str42;
                            if (downloadResult.getStatus().isSucceed()) {
                                handleDownloadReportForTask(jobContext3, downloadResult2, downloadReport4);
                            }
                        }
                        this.okRequestBuilder = null;
                        i28 = i19;
                        if (!canAttempt()) {
                            return;
                        }
                        str111 = str37;
                        downloadResult4 = downloadResult2;
                        str110 = str38;
                        str112 = str7;
                        str108 = str35;
                        jobContext5 = jobContext3;
                        str102 = str14;
                        str101 = str36;
                        str99 = str117;
                        str100 = str118;
                        str106 = str2;
                        str107 = str;
                        str115 = str10;
                        str114 = str33;
                        str105 = str12;
                        str104 = str3;
                        String str174 = str15;
                        str113 = str34;
                        generateRandomId = i3;
                        str109 = str39;
                        str103 = str174;
                    } else {
                        str84 = str66;
                        str69 = str64;
                        downloadReport7 = downloadReport9;
                        str81 = str10;
                        str82 = str5;
                        str83 = str65;
                        str116 = str61;
                        try {
                            downloadResult.getStatus().setFailed(3);
                            i27 = 0;
                        } catch (Throwable th31) {
                            str117 = str62;
                            str118 = str63;
                            str4 = str67;
                            str3 = str68;
                            response = response5;
                            str2 = str2;
                            str13 = str101;
                            str14 = str102;
                            str15 = str103;
                            str9 = str51;
                            str8 = str84;
                            downloadReport = downloadReport7;
                            str10 = str81;
                            str5 = str82;
                            str = str83;
                            jobContext2 = jobContext;
                            str11 = str69;
                            j3 = uptimeMillis2;
                            str7 = str49;
                            th5 = th31;
                            i17 = 0;
                            QDLog.e(QDLog.TAG_DOWNLOAD_RANGE, "download " + getUrl() + " exception:", th5);
                            downloadResult.getStatus().setFailed(th5);
                            int i362222222222 = i16 + 1;
                            DownloadReport downloadReport102222222222 = downloadReport;
                            downloadResult.getProcess().setDuration(j3, SystemClock.uptimeMillis());
                            downloadResult.getProcess().totalDuration = SystemClock.uptimeMillis() - this.mTimeStamp;
                            downloadResult.getProcess().startTimestamp = this.mTaskStartTimeStamp;
                            NetworkUtils.DNS dns52222222222 = NetworkStatus.getInstance(this.mContext).getDNS();
                            String parserHttpHeaderInfo3222222222 = parserHttpHeaderInfo(null, null, response);
                            if (response != null) {
                            }
                            downloadResult.getContent().redirectUrl = header3;
                            this.connect_time = 0L;
                            this.connect_retry = 0;
                            this.exe_time = 0L;
                            this.exe_retry = 0;
                            if (jobContext.isCancelled()) {
                            }
                            this.okRequestBuilder = null;
                            i28 = i19;
                            if (!canAttempt()) {
                            }
                        }
                    }
                    int i38 = i16 + 1;
                    str117 = str62;
                    str118 = str63;
                    downloadResult.getProcess().setDuration(uptimeMillis2, SystemClock.uptimeMillis());
                    downloadResult.getProcess().totalDuration = SystemClock.uptimeMillis() - this.mTimeStamp;
                    downloadResult.getProcess().startTimestamp = this.mTaskStartTimeStamp;
                    NetworkUtils.DNS dns9 = NetworkStatus.getInstance(this.mContext).getDNS();
                    String parserHttpHeaderInfo6 = parserHttpHeaderInfo(null, null, response5);
                    String header4 = (response5 != null || response5.priorResponse() == null) ? null : response5.priorResponse().header("Location");
                    downloadResult.getContent().redirectUrl = header4;
                    this.connect_time = 0L;
                    this.connect_retry = 0;
                    this.exe_time = 0L;
                    this.exe_retry = 0;
                    if (jobContext.isCancelled()) {
                        boolean isNetworkAvailable5 = NetworkUtils.isNetworkAvailable(this.mContext);
                        if (!downloadResult.getStatus().isSucceed()) {
                            StringBuilder sb25 = new StringBuilder();
                            sb25.append("Downloader, fail to download:");
                            sb25.append(getUrl());
                            sb25.append(str2);
                            sb25.append(this.mIsHttp2);
                            sb25.append(str67);
                            sb25.append((!this.mIsHttp2 || response5 == null || response5.protocol() == null) ? str12 : response5.protocol().getProtocol());
                            sb25.append(str68);
                            sb25.append(dns9);
                            sb25.append(str103);
                            sb25.append((String) null);
                            sb25.append(str102);
                            sb25.append((String) null);
                            sb25.append(str101);
                            String str175 = str101;
                            sb25.append(Thread.currentThread().getId());
                            sb25.append(str118);
                            sb25.append(NetworkManager.getApnValue());
                            sb25.append(", netAvailable=");
                            sb25.append(isNetworkAvailable5);
                            sb25.append(str117);
                            z26 = isNetworkAvailable5;
                            sb25.append(Config.getNetworkStackType());
                            sb25.append(str69);
                            sb25.append(downloadResult.getContent().type);
                            str88 = str51;
                            sb25.append(str88);
                            String str176 = str69;
                            sb25.append(downloadResult.getProcess().duration);
                            String str177 = str84;
                            sb25.append(str177);
                            str14 = str102;
                            str15 = str103;
                            sb25.append(SystemClock.uptimeMillis() - this.mTimeStamp);
                            str7 = str49;
                            sb25.append(str7);
                            sb25.append(downloadResult.getContent().length);
                            str91 = str6;
                            sb25.append(str91);
                            sb25.append(downloadResult.getContent().size);
                            sb25.append(str116);
                            sb25.append(downloadResult.getContent().realsize);
                            sb25.append(", retry=(");
                            sb25.append(getCurrAttemptCount());
                            str92 = str81;
                            sb25.append(str92);
                            sb25.append(getTotalAttemptCount());
                            sb25.append("), reason=");
                            sb25.append(downloadResult.getStatus().getFailReason());
                            sb25.append(", httpStatus=");
                            sb25.append(i27);
                            String str178 = str82;
                            sb25.append(str178);
                            sb25.append(parserHttpHeaderInfo6);
                            String str179 = str83;
                            sb25.append(str179);
                            sb25.append(header4);
                            String str180 = header4;
                            sb25.append(", ipUrl:");
                            String str181 = this.mRealUrl;
                            if (str181 != null) {
                                str96 = str178;
                                str181 = str181.substring(0, 30);
                            } else {
                                str96 = str178;
                            }
                            sb25.append(str181);
                            sb25.append(", clientip=");
                            sb25.append(downloadResult.getContent().clientip);
                            sb25.append(", getIP=");
                            sb25.append(0L);
                            sb25.append(", connect:(");
                            sb25.append(this.connect_time);
                            sb25.append(str92);
                            sb25.append(this.connect_retry);
                            sb25.append("), exeReqest:(");
                            sb25.append(this.exe_time);
                            sb25.append(str92);
                            sb25.append(this.exe_retry);
                            sb25.append("), sendReq=");
                            sb25.append(this.send_req_time);
                            sb25.append(", recvData=");
                            sb25.append(this.t_recv_data);
                            sb25.append(", Concurrent:(");
                            sb25.append(getTaskConcurrentCount());
                            sb25.append("), mobileProxy=");
                            DownloadTask.DownloadTaskHandler downloadTaskHandler10 = this.mDownloadTaskHandler;
                            sb25.append(downloadTaskHandler10 != null ? downloadTaskHandler10.getCustomProxy() : null);
                            String sb26 = sb25.toString();
                            downloadReport8 = downloadReport7;
                            downloadReport8.logInfo = sb26;
                            QDLog.e(QDLog.TAG_DOWNLOAD_RESULT, sb26, null);
                            str85 = str67;
                            str3 = str68;
                            str93 = str177;
                            str2 = str2;
                            str95 = str180;
                            str86 = str176;
                            dns4 = dns9;
                            str97 = parserHttpHeaderInfo6;
                            str87 = str175;
                            response7 = response5;
                            str94 = str179;
                        } else {
                            String str182 = header4;
                            z26 = isNetworkAvailable5;
                            String str183 = str69;
                            String str184 = str101;
                            str14 = str102;
                            str15 = str103;
                            str88 = str51;
                            String str185 = str84;
                            str7 = str49;
                            str91 = str6;
                            downloadReport8 = downloadReport7;
                            str92 = str81;
                            String str186 = str82;
                            String str187 = str83;
                            StringBuilder sb27 = new StringBuilder();
                            sb27.append("Downloader, succeed to download:");
                            sb27.append(getUrl());
                            sb27.append(str2);
                            sb27.append(this.mIsHttp2);
                            sb27.append(str67);
                            sb27.append((!this.mIsHttp2 || response5 == null || response5.protocol() == null) ? str12 : response5.protocol().getProtocol());
                            sb27.append(str68);
                            sb27.append(dns9);
                            sb27.append(str15);
                            sb27.append((String) null);
                            sb27.append(str14);
                            sb27.append((String) null);
                            sb27.append(str184);
                            str2 = str2;
                            sb27.append(Thread.currentThread().getId());
                            sb27.append(str118);
                            sb27.append(NetworkManager.getApnValue());
                            sb27.append(str117);
                            sb27.append(Config.getNetworkStackType());
                            sb27.append(str88);
                            sb27.append(downloadResult.getProcess().duration);
                            sb27.append(str185);
                            response7 = response5;
                            str93 = str185;
                            sb27.append(SystemClock.uptimeMillis() - this.mTimeStamp);
                            sb27.append(str7);
                            sb27.append(downloadResult.getContent().length);
                            sb27.append(str91);
                            sb27.append(downloadResult.getContent().size);
                            sb27.append(str116);
                            sb27.append(downloadResult.getContent().realsize);
                            sb27.append(", retry=(");
                            sb27.append(getCurrAttemptCount());
                            sb27.append(str92);
                            sb27.append(getTotalAttemptCount());
                            sb27.append("), httpStatus=");
                            sb27.append(i27);
                            sb27.append(str186);
                            sb27.append(parserHttpHeaderInfo6);
                            str86 = str183;
                            sb27.append(str86);
                            sb27.append(downloadResult.getContent().type);
                            str94 = str187;
                            sb27.append(str94);
                            str87 = str184;
                            str95 = str182;
                            sb27.append(str95);
                            str3 = str68;
                            sb27.append(", ipUrl:");
                            String str188 = this.mRealUrl;
                            if (str188 != null) {
                                str85 = str67;
                                dns4 = dns9;
                                str188 = str188.substring(0, 30);
                            } else {
                                dns4 = dns9;
                                str85 = str67;
                            }
                            sb27.append(str188);
                            sb27.append(", clientip=");
                            sb27.append(downloadResult.getContent().clientip);
                            sb27.append(", getIP=");
                            str96 = str186;
                            str97 = parserHttpHeaderInfo6;
                            sb27.append(0L);
                            sb27.append(", connect:(");
                            sb27.append(this.connect_time);
                            sb27.append(str92);
                            sb27.append(this.connect_retry);
                            sb27.append("), exeReqest:(");
                            sb27.append(this.exe_time);
                            sb27.append(str92);
                            sb27.append(this.exe_retry);
                            sb27.append("), sendReq=");
                            sb27.append(this.send_req_time);
                            sb27.append(", recvData=");
                            sb27.append(this.t_recv_data);
                            sb27.append(", Concurrent:(");
                            sb27.append(getTaskConcurrentCount());
                            sb27.append("), mobileProxy=");
                            DownloadTask.DownloadTaskHandler downloadTaskHandler11 = this.mDownloadTaskHandler;
                            sb27.append(downloadTaskHandler11 != null ? downloadTaskHandler11.getCustomProxy() : null);
                            String sb28 = sb27.toString();
                            downloadReport8.logInfo = sb28;
                            QDLog.w(QDLog.TAG_DOWNLOAD_RESULT, sb28, null);
                        }
                        if (!z26) {
                            this.mShouldReport = false;
                        }
                        DownloadResult.Status status5 = downloadResult.getStatus();
                        StringBuilder sb29 = new StringBuilder();
                        sb29.append(getUrl());
                        sb29.append(" sip=");
                        sb29.append((String) null);
                        sb29.append(", client=");
                        sb29.append(downloadResult.getContent().clientip);
                        sb29.append(", ipType=");
                        DownloadGlobalStrategy.StrategyInfo strategyInfo5 = this.pCurrStrategyInfo;
                        sb29.append(strategyInfo5 != null ? strategyInfo5.f99899id : 0);
                        sb29.append(", httpStatus=");
                        sb29.append(i27);
                        sb29.append(str86);
                        sb29.append(downloadResult.getContent().type);
                        sb29.append(str7);
                        sb29.append(downloadResult.getContent().length);
                        sb29.append(str91);
                        sb29.append(downloadResult.getContent().size);
                        sb29.append(str88);
                        sb29.append(downloadResult.getProcess().duration);
                        str89 = str93;
                        sb29.append(str89);
                        str6 = str91;
                        str10 = str92;
                        sb29.append(SystemClock.uptimeMillis() - this.mTimeStamp);
                        if (TextUtils.isEmpty(str95)) {
                            str98 = "";
                        } else {
                            str98 = str94 + str95;
                        }
                        sb29.append(str98);
                        String str189 = str96;
                        sb29.append(str189);
                        sb29.append(str97);
                        status5.detailDownloadInfo = sb29.toString();
                        if (z26) {
                            DownloadGlobalStrategy downloadGlobalStrategy5 = DownloadGlobalStrategy.getInstance(this.mContext);
                            String str190 = this.mRealUrl;
                            downloadGlobalStrategy5.reportHttps(str190, this.mIsHttp2 && str190 != null && str190.startsWith("https"), downloadResult.getStatus().isSucceed());
                        }
                        downloadReport8.endTime = System.currentTimeMillis();
                        downloadReport8.fileSize = getContentLength();
                        Response response11 = response7;
                        downloadReport8.okResponse = response11;
                        downloadReport8.httpStatus = i27;
                        downloadReport8.exception = null;
                        downloadReport8.dns = dns4 == null ? null : dns4.toString();
                        downloadReport8.localAddress = null;
                        downloadReport8.clientip = downloadResult.getContent().clientip;
                        str = str94;
                        str90 = str189;
                        downloadReport8.totaltime = SystemClock.uptimeMillis() - this.mTimeStamp;
                        downloadReport8.downloadTime = downloadResult.getProcess().duration;
                        downloadReport8.t_wait = downloadReport8.totaltime - downloadResult.getProcess().duration;
                        downloadReport8.t_prepare = 0L;
                        downloadReport8.t_conn = this.connect_time;
                        downloadReport8.t_recvrsp = this.send_req_time;
                        downloadReport8.t_recvdata = this.t_recv_data;
                        downloadReport8.t_process = 0L;
                        downloadReport8.concurrent = getTaskConcurrentCount();
                        downloadReport8.content_type = downloadResult.getContent().type;
                        downloadReport8.isFromQzoneAlbum = Config.isFromQzoneAlbum(getDomain());
                        downloadReport8.isHttp2 = this.mIsHttp2;
                        String str191 = this.mRealUrl;
                        downloadReport8.isHttps = str191 != null && str191.startsWith("https");
                        downloadReport8.isSucceed = downloadResult.getStatus().isSucceed();
                        downloadReport8.downloadMode = Downloader.DownloadMode.RangeMode.ordinal();
                        downloadReport8.timeCostForRangeReceivePhase = this.mRangeDownloaderManager.getDurationMillisForRangeReceivePhase();
                        if (response11 != null && response11.protocol() != null) {
                            downloadReport8.f99896protocol = response11.protocol().getProtocol();
                        }
                        downloadReport8.rangeDownloadReports = this.mRangeDownloaderManager.getRangeDownloadReports();
                        downloadReport8.rangeNumber = this.mRangeDownloaderManager.getNumberOfRangeTasks();
                        downloadResult3 = downloadResult;
                        downloadResult3.setReport(downloadReport8);
                        jobContext4 = jobContext;
                        if (downloadResult.getStatus().isSucceed()) {
                            handleDownloadReportForTask(jobContext4, downloadResult3, downloadReport8);
                        }
                    } else {
                        downloadResult3 = downloadResult;
                        str85 = str67;
                        str3 = str68;
                        str86 = str69;
                        str2 = str2;
                        str87 = str101;
                        str14 = str102;
                        str15 = str103;
                        str88 = str51;
                        str89 = str84;
                        str7 = str49;
                        str10 = str81;
                        str90 = str82;
                        str = str83;
                        jobContext4 = jobContext;
                    }
                    this.okRequestBuilder = null;
                    jobContext3 = jobContext4;
                    str33 = str88;
                    str34 = str89;
                    str35 = str86;
                    i28 = i38;
                    str36 = str87;
                    str37 = str6;
                    str38 = str90;
                    str39 = str85;
                    downloadResult2 = downloadResult3;
                    if (!canAttempt()) {
                    }
                } else {
                    QDLog.e(QDLog.TAG_DOWNLOAD_RANGE, "download on rangeMode fail, " + getUrl() + ", realUrl:" + this.mRealUrl);
                }
            }
            str61 = str116;
            str62 = str117;
            str63 = str118;
            str64 = str119;
            str65 = str;
            str66 = str50;
            str67 = str4;
            str68 = str3;
            response5 = null;
            if (response5 == null) {
            }
            int i382 = i16 + 1;
            str117 = str62;
            str118 = str63;
            downloadResult.getProcess().setDuration(uptimeMillis2, SystemClock.uptimeMillis());
            downloadResult.getProcess().totalDuration = SystemClock.uptimeMillis() - this.mTimeStamp;
            downloadResult.getProcess().startTimestamp = this.mTaskStartTimeStamp;
            NetworkUtils.DNS dns92 = NetworkStatus.getInstance(this.mContext).getDNS();
            String parserHttpHeaderInfo62 = parserHttpHeaderInfo(null, null, response5);
            if (response5 != null) {
            }
            downloadResult.getContent().redirectUrl = header4;
            this.connect_time = 0L;
            this.connect_retry = 0;
            this.exe_time = 0L;
            this.exe_retry = 0;
            if (jobContext.isCancelled()) {
            }
            this.okRequestBuilder = null;
            jobContext3 = jobContext4;
            str33 = str88;
            str34 = str89;
            str35 = str86;
            i28 = i382;
            str36 = str87;
            str37 = str6;
            str38 = str90;
            str39 = str85;
            downloadResult2 = downloadResult3;
            if (!canAttempt()) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.component.network.downloader.impl.DownloadTask
    public void initTask() {
        super.initTask();
        this.mRefer = HttpUtil.prepareRefer(getUrl());
    }

    @Override // com.tencent.component.network.downloader.RangeDownloadManager.ProgressListener
    public void onReceive(float f16) {
        notifyDownloadProgress(getUrlKey(), this.mContentLength, f16);
    }
}
