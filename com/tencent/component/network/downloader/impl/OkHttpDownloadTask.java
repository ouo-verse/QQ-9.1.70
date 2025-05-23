package com.tencent.component.network.downloader.impl;

import android.content.Context;
import android.net.http.Headers;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.component.network.NetworkManager;
import com.tencent.component.network.downloader.DownloadReport;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.component.network.downloader.impl.DownloadTask;
import com.tencent.component.network.downloader.strategy.DownloadGlobalStrategy;
import com.tencent.component.network.downloader.strategy.ResumeTransfer;
import com.tencent.component.network.module.base.Config;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.module.common.DnsService;
import com.tencent.component.network.module.common.NetworkStatus;
import com.tencent.component.network.module.common.ProgressResponseBody;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.component.network.utils.SDCardUtil;
import com.tencent.component.network.utils.http.base.QZoneHttpClient;
import com.tencent.component.network.utils.http.pool.CustomDnsResolve;
import com.tencent.component.network.utils.thread.ThreadPool;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.List;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* compiled from: P */
/* loaded from: classes5.dex */
public class OkHttpDownloadTask extends DownloadTask {
    private static final String TAG = "OkHttpDownloadTask";
    private long mDnsEnd;
    private long mDnsStart;
    private float mLastCallbackProgress;
    private final float mProgressCallbackStep;
    private String mRemoteAddress;
    private final long mTimeStamp;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    private class ProgressInterceptor implements Interceptor {
        ProgressResponseBody.ProgressListener progressListener;

        ProgressInterceptor(ProgressResponseBody.ProgressListener progressListener) {
            this.progressListener = progressListener;
        }

        @Override // okhttp3.Interceptor
        public Response intercept(Interceptor.Chain chain) throws IOException {
            Connection connection = chain.connection();
            if (connection != null) {
                OkHttpDownloadTask.this.mRemoteAddress = connection.getRoute().socketAddress().toString();
            }
            Response proceed = chain.proceed(chain.request());
            return proceed.newBuilder().body(new ProgressResponseBody(proceed.body(), this.progressListener)).build();
        }
    }

    public OkHttpDownloadTask(Context context, OkHttpClient okHttpClient, QZoneHttpClient qZoneHttpClient, String str, String str2, boolean z16, boolean z17) {
        super(context, okHttpClient, qZoneHttpClient, str, str2, z16, true);
        this.mTimeStamp = SystemClock.uptimeMillis();
        this.mProgressCallbackStep = 0.1f;
        this.pokHttpClient = this.pokHttpClient.newBuilder().addNetworkInterceptor(new ProgressInterceptor(new ProgressResponseBody.ProgressListener() { // from class: com.tencent.component.network.downloader.impl.OkHttpDownloadTask.2
            @Override // com.tencent.component.network.module.common.ProgressResponseBody.ProgressListener
            public void update(long j3, long j16, boolean z18) {
                if (j16 > 0) {
                    float f16 = (((float) j3) * 1.0f) / ((float) j16);
                    if (f16 - OkHttpDownloadTask.this.mLastCallbackProgress >= 0.1f) {
                        OkHttpDownloadTask.this.mLastCallbackProgress = f16;
                        OkHttpDownloadTask okHttpDownloadTask = OkHttpDownloadTask.this;
                        String urlKey = okHttpDownloadTask.getUrlKey();
                        OkHttpDownloadTask okHttpDownloadTask2 = OkHttpDownloadTask.this;
                        okHttpDownloadTask.notifyDownloadProgress(urlKey, okHttpDownloadTask2.mContentLength, okHttpDownloadTask2.mLastCallbackProgress);
                    }
                }
            }
        })).eventListener(new EventListener() { // from class: com.tencent.component.network.downloader.impl.OkHttpDownloadTask.1
            @Override // okhttp3.EventListener
            public void dnsEnd(Call call, String str3, List<InetAddress> list) {
                super.dnsEnd(call, str3, list);
                OkHttpDownloadTask.this.mDnsEnd = SystemClock.uptimeMillis();
            }

            @Override // okhttp3.EventListener
            public void dnsStart(Call call, String str3) {
                super.dnsStart(call, str3);
                OkHttpDownloadTask.this.mDnsStart = SystemClock.uptimeMillis();
            }
        }).build();
    }

    private void handleErrorByCode(String str, DownloadResult.Status status) {
        if (Config.isUseSmartIpStackStrategy() && status != null && !status.isSucceed()) {
            int i3 = status.exception2Code;
            if (i3 != 7) {
                switch (i3) {
                    case 50004:
                    case 50005:
                        break;
                    default:
                        return;
                }
            }
            if (Config.isIpV6Stack()) {
                QDLog.e(TAG, "handleErrorByCode ipStack:" + Config.getNetworkStackType() + ",errcode:" + status.exception2Code);
                if (Config.getNetworkStackType() == 3) {
                    DnsService.getInstance().updatePreferV4(str);
                }
            }
        }
    }

    private long parseContentLength(Response response) {
        if (response != null && response.body() != null) {
            long contentLength = response.body().getContentLength();
            if (contentLength <= 0 && response.networkResponse() != null) {
                String header = response.networkResponse().header(Headers.CONTENT_LEN);
                if (!TextUtils.isEmpty(header)) {
                    try {
                        return Long.parseLong(header);
                    } catch (Throwable unused) {
                        return contentLength;
                    }
                }
                return contentLength;
            }
            return contentLength;
        }
        return -1L;
    }

    private void reset() {
        this.mLastCallbackProgress = 0.0f;
    }

    private long saveToFile(InputStream inputStream, String str) throws IOException {
        int i3;
        long j3 = 0;
        if (inputStream != null && !TextUtils.isEmpty(str)) {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(str));
            byte[] bArr = new byte[8192];
            loop0: while (true) {
                i3 = 0;
                do {
                    int read = inputStream.read(bArr, i3, 8192 - i3);
                    if (read == -1) {
                        break loop0;
                    }
                    i3 += read;
                } while (i3 < 8192);
                fileOutputStream.write(bArr, 0, i3);
                j3 += i3;
            }
            if (i3 > 0) {
                fileOutputStream.write(bArr, 0, i3);
                j3 += i3;
            }
            fileOutputStream.close();
        }
        return j3;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:18|(4:19|20|(4:540|541|(7:544|545|546|547|(2:551|552)|553|542)|559)|22)|(10:23|24|25|26|27|28|29|30|31|32)|(3:417|418|(4:422|423|424|(7:439|440|442|443|(1:445)(1:516)|446|(17:448|(7:450|(1:503)(1:454)|455|(1:457)(1:502)|458|(1:460)|461)(5:504|(1:514)(1:508)|509|(1:511)(1:513)|512)|(1:463)|464|(1:466)(1:501)|467|(1:469)(1:500)|470|(4:472|(1:498)(2:475|(2:477|478))|497|478)(1:499)|479|(1:481)(1:496)|482|(1:495)(1:486)|487|(1:489)|490|(2:492|493)(1:494))(1:515))(17:426|427|428|429|430|431|432|35|36|(14:306|307|308|309|(3:400|401|(1:403))|311|(4:316|(1:318)(1:321)|319|320)|322|323|325|326|(1:328)(1:399)|329|(17:331|(7:333|(1:386)(1:337)|338|(1:340)(1:385)|341|(1:343)|344)(5:387|(1:397)(1:391)|392|(1:394)(1:396)|395)|(1:346)|347|(1:349)(1:384)|350|(1:352)(1:383)|353|(4:355|(1:381)(2:358|(2:360|361))|380|361)(1:382)|362|(1:364)(1:379)|365|(1:378)(1:369)|370|(1:372)|373|(2:375|376)(1:377))(1:398))(7:38|39|40|41|42|43|44)|45|(1:128)(1:49)|50|(17:52|(7:54|(1:114)(1:59)|60|(1:62)(1:113)|63|(1:65)|66)(5:115|(1:126)(1:120)|121|(1:123)(1:125)|124)|(1:68)|69|(1:71)(1:112)|72|(1:74)(1:111)|75|(4:77|(1:109)(2:80|(2:82|83))|108|83)(1:110)|84|(1:86)(1:107)|87|(1:106)(1:91)|92|(1:96)|97|(1:99))(1:127)|100|101|(2:104|105)(1:103))))|34|35|36|(0)(0)|45|(1:47)|128|50|(0)(0)|100|101|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:415:0x164e, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:416:0x164f, code lost:
    
        r37 = r2;
        r29 = r8;
        r38 = r9;
        r36 = r10;
        r39 = r12;
        r17 = r13;
        r30 = r19;
        r53 = r32;
        r8 = r14;
        r15 = r49;
        r43 = r50;
        r44 = r51;
        r12 = r4;
        r13 = r6;
        r7 = r11;
        r33 = r20;
        r32 = r22;
        r5 = r47;
        r4 = r3;
        r2 = r45;
     */
    /* JADX WARN: Removed duplicated region for block: B:103:0x1d8d A[LOOP:0: B:2:0x0061->B:103:0x1d8d, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x1d8c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x15bc  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x17a1  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x17c5  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x1d73  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x089b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0f85  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x1008  */
    @Override // com.tencent.component.network.downloader.impl.DownloadTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void execute(ThreadPool.JobContext jobContext, DownloadResult downloadResult) {
        int i3;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        DownloadReport downloadReport;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        long j3;
        long j16;
        int i16;
        long j17;
        long j18;
        Response response;
        String str16;
        String str17;
        String str18;
        String str19;
        String str20;
        int i17;
        String str21;
        DownloadReport downloadReport2;
        long j19;
        long j26;
        String str22;
        boolean z16;
        String str23;
        String str24;
        String str25;
        String str26;
        int i18;
        String str27;
        String str28;
        String str29;
        NetworkUtils.DNS dns;
        long j27;
        DownloadReport downloadReport3;
        String str30;
        boolean z17;
        DownloadReport downloadReport4;
        String str31;
        long j28;
        String str32;
        String str33;
        String str34;
        String str35;
        String str36;
        String str37;
        String str38;
        long j29;
        String str39;
        String str40;
        String str41;
        boolean z18;
        String str42;
        Throwable th5;
        NetworkUtils.DNS dns2;
        String str43;
        String str44;
        DownloadReport downloadReport5;
        String str45;
        boolean z19;
        Request.Builder url;
        String str46;
        long j36;
        Response execute;
        Response response2;
        long j37;
        long j38;
        String str47;
        long j39;
        long j46;
        Response response3;
        String savePath;
        String str48;
        String str49;
        boolean z26;
        String str50;
        String str51;
        String str52;
        String str53;
        String str54;
        String str55;
        Response response4;
        long j47;
        DownloadReport downloadReport6;
        String str56;
        boolean z27;
        String str57;
        String str58;
        String str59;
        long j48;
        long j49;
        String str60;
        String str61;
        InputStream byteStream;
        long uptimeMillis;
        long saveToFile;
        String str62;
        String str63;
        long j56;
        int code;
        String str64;
        String str65;
        boolean z28;
        String str66;
        String str67;
        int i19;
        String str68;
        String str69;
        String str70;
        NetworkUtils.DNS dns3;
        long j57;
        Response response5;
        String str71;
        DownloadReport downloadReport7;
        String str72;
        boolean z29;
        int i26;
        long j58;
        String str73;
        String str74;
        String str75;
        String str76;
        long j59;
        long j65;
        String str77;
        String str78;
        String str79;
        String str80;
        String str81;
        String str82;
        String str83;
        String str84;
        String str85;
        String str86;
        long j66;
        String str87;
        ThreadPool.JobContext jobContext2;
        DownloadResult downloadResult2;
        String str88;
        boolean z36;
        String str89;
        String str90;
        String str91;
        NetworkUtils.DNS dns4;
        String str92;
        Response response6;
        String str93;
        String str94;
        long j67;
        String str95;
        DownloadReport downloadReport8;
        String str96;
        boolean z37;
        String str97 = ", IpStack=";
        String str98 = ", apn=";
        String str99 = ", thread=";
        String str100 = ", localAddress=";
        String str101 = ", remoteAddress=";
        String str102 = ", dns=";
        String str103 = ", protocol=";
        String str104 = " , requestHttp2=";
        String str105 = ", contentType=";
        String str106 = ", redirectURI=";
        String str107 = ", contentLength=";
        String str108 = ", ";
        String str109 = ", totalDuration=";
        String str110 = ", realsize=";
        String str111 = ", size=";
        String str112 = ",";
        int generateRandomId = DownloadTask.TaskHelper.generateRandomId(getUrl(), downloadResult);
        boolean isSdCardHasEnoughCapability = SDCardUtil.isSdCardHasEnoughCapability();
        String str113 = ", duration=";
        long j68 = 0;
        while (!jobContext.isCancelled()) {
            if (!NetworkUtils.isNetworkAvailable(this.mContext)) {
                if (getCurrAttemptCount() == getTotalAttemptCount() - 1) {
                    downloadResult.getStatus().setFailed(6);
                    return;
                } else {
                    try {
                        LockMethodProxy.sleep(1000L);
                    } catch (Exception unused) {
                        QDLog.d(QDLog.TAG_DOWNLOAD_OKHTTP, "no network sleep interruptted!");
                    }
                }
            }
            if (!isSdCardHasEnoughCapability) {
                downloadResult.getStatus().setFailed(2);
                return;
            }
            reset();
            downloadResult.reset();
            long uptimeMillis2 = SystemClock.uptimeMillis();
            String str114 = str107;
            DownloadReport downloadReport9 = new DownloadReport();
            downloadReport9.f99895id = generateRandomId;
            downloadReport9.url = getUrl();
            downloadReport9.domain = getDomain();
            String str115 = str97;
            String str116 = str98;
            downloadReport9.startTime = System.currentTimeMillis();
            downloadReport9.currAttempCount = getCurrAttemptCount();
            try {
                url = new Request.Builder().url(getUrl());
                if (getHttpParams() != null) {
                    try {
                        for (Map.Entry<String, String> entry : getHttpParams().entrySet()) {
                            String key = entry.getKey();
                            i3 = generateRandomId;
                            try {
                                String value = entry.getValue();
                                if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                                    url.header(key, value);
                                }
                                generateRandomId = i3;
                            } catch (Throwable th6) {
                                th = th6;
                                str = str99;
                                str2 = str100;
                                str3 = str101;
                                str4 = str102;
                                str5 = str109;
                                str6 = str103;
                                downloadReport = downloadReport9;
                                str7 = str105;
                                str8 = str106;
                                str9 = str108;
                                str10 = str110;
                                str11 = str111;
                                str12 = str113;
                                j16 = j68;
                                str13 = str116;
                                i16 = 0;
                                j18 = 0;
                                response = null;
                                str14 = str104;
                                str15 = str112;
                                j3 = uptimeMillis2;
                                j17 = 0;
                                try {
                                    StringBuilder sb5 = new StringBuilder();
                                    downloadReport4 = downloadReport;
                                    try {
                                        sb5.append("download ");
                                        sb5.append(getUrl());
                                        sb5.append(" exception:");
                                        QDLog.e(QDLog.TAG_DOWNLOAD_OKHTTP, sb5.toString(), th);
                                        downloadResult.getStatus().setFailed(th);
                                        downloadResult.getProcess().setDuration(j3, SystemClock.uptimeMillis());
                                        downloadResult.getProcess().totalDuration = SystemClock.uptimeMillis() - this.mTimeStamp;
                                        downloadResult.getProcess().startTimestamp = this.mTaskStartTimeStamp;
                                        NetworkUtils.DNS dns5 = NetworkStatus.getInstance(this.mContext).getDNS();
                                        String str117 = this.mRemoteAddress;
                                        String parserHttpHeaderInfo = parserHttpHeaderInfo(null, null, response);
                                        long j69 = j18;
                                        long j75 = j17;
                                        long j76 = this.mDnsEnd - this.mDnsStart;
                                        if (response != null) {
                                        }
                                        downloadResult.getContent().redirectUrl = r3;
                                        String url2 = getUrl();
                                        if (jobContext.isCancelled()) {
                                        }
                                        if (canAttempt()) {
                                        }
                                    } catch (Throwable th7) {
                                        th = th7;
                                        j19 = j3;
                                        str16 = str;
                                        str17 = str15;
                                        str18 = str4;
                                        str19 = str13;
                                        str20 = str8;
                                        j26 = j17;
                                        downloadReport2 = downloadReport4;
                                        i17 = i16;
                                        str21 = str5;
                                        long j77 = j18;
                                        String str118 = str7;
                                        Throwable th8 = th;
                                        downloadResult.getProcess().setDuration(j19, SystemClock.uptimeMillis());
                                        downloadResult.getProcess().totalDuration = SystemClock.uptimeMillis() - this.mTimeStamp;
                                        downloadResult.getProcess().startTimestamp = this.mTaskStartTimeStamp;
                                        NetworkUtils.DNS dns6 = NetworkStatus.getInstance(this.mContext).getDNS();
                                        String str119 = this.mRemoteAddress;
                                        String parserHttpHeaderInfo2 = parserHttpHeaderInfo(null, null, response);
                                        long j78 = j26;
                                        String str120 = str20;
                                        long j79 = this.mDnsEnd - this.mDnsStart;
                                        String header = (response == null || response.priorResponse() == null) ? null : response.priorResponse().header("Location");
                                        downloadResult.getContent().redirectUrl = header;
                                        String url3 = getUrl();
                                        if (!jobContext.isCancelled()) {
                                            boolean isNetworkAvailable = NetworkUtils.isNetworkAvailable(this.mContext);
                                            if (!downloadResult.getStatus().isSucceed()) {
                                                str22 = url3;
                                                StringBuilder sb6 = new StringBuilder();
                                                DownloadReport downloadReport10 = downloadReport2;
                                                sb6.append("Downloader, fail to download:");
                                                sb6.append(getUrl());
                                                sb6.append(str14);
                                                sb6.append(this.mIsHttp2);
                                                sb6.append(str6);
                                                sb6.append((!this.mIsHttp2 || response == null || response.protocol() == null) ? "http1.1" : response.protocol().getProtocol());
                                                sb6.append(str18);
                                                sb6.append(dns6);
                                                sb6.append(str3);
                                                sb6.append(str119);
                                                sb6.append(str2);
                                                sb6.append((String) null);
                                                sb6.append(str16);
                                                sb6.append(Thread.currentThread().getId());
                                                sb6.append(str19);
                                                sb6.append(NetworkManager.getApnValue());
                                                sb6.append(", netAvailable=");
                                                sb6.append(isNetworkAvailable);
                                                sb6.append(str115);
                                                sb6.append(Config.getNetworkStackType());
                                                sb6.append(str118);
                                                sb6.append(downloadResult.getContent().type);
                                                sb6.append(str12);
                                                sb6.append(downloadResult.getProcess().duration);
                                                sb6.append(str21);
                                                sb6.append(SystemClock.uptimeMillis() - this.mTimeStamp);
                                                sb6.append(str114);
                                                sb6.append(downloadResult.getContent().length);
                                                String str121 = str11;
                                                sb6.append(str121);
                                                sb6.append(downloadResult.getContent().size);
                                                sb6.append(str10);
                                                sb6.append(downloadResult.getContent().realsize);
                                                sb6.append(", retry=(");
                                                sb6.append(getCurrAttemptCount());
                                                String str122 = str17;
                                                sb6.append(str122);
                                                sb6.append(getTotalAttemptCount());
                                                sb6.append("), errorCode=");
                                                sb6.append(downloadResult.getStatus().exception2Code);
                                                sb6.append(", reason=");
                                                sb6.append(downloadResult.getStatus().getFailReason());
                                                sb6.append(", httpStatus=");
                                                sb6.append(i17);
                                                sb6.append(str9);
                                                sb6.append(parserHttpHeaderInfo2);
                                                str28 = str120;
                                                sb6.append(str28);
                                                sb6.append(header);
                                                sb6.append(", ipUrl:");
                                                sb6.append(getUrl());
                                                sb6.append(", clientip=");
                                                sb6.append(downloadResult.getContent().clientip);
                                                sb6.append(", getIP=");
                                                String str123 = header;
                                                str24 = parserHttpHeaderInfo2;
                                                sb6.append(j79);
                                                sb6.append(", connect:(");
                                                sb6.append(j78);
                                                sb6.append(str122);
                                                sb6.append(0);
                                                sb6.append("), exeReqest:(");
                                                sb6.append(0L);
                                                sb6.append(str122);
                                                sb6.append(0);
                                                sb6.append("), sendReq=");
                                                sb6.append(j77);
                                                sb6.append(", recvData=");
                                                sb6.append(this.t_recv_data);
                                                sb6.append(", Concurrent:(");
                                                sb6.append(getTaskConcurrentCount());
                                                sb6.append("), mobileProxy=");
                                                DownloadTask.DownloadTaskHandler downloadTaskHandler = this.mDownloadTaskHandler;
                                                sb6.append(downloadTaskHandler != null ? downloadTaskHandler.getCustomProxy() : null);
                                                sb6.append(", isGzip=");
                                                sb6.append(downloadResult.getContent().isGzip);
                                                String sb7 = sb6.toString();
                                                downloadReport10.logInfo = sb7;
                                                QDLog.e(QDLog.TAG_DOWNLOAD_RESULT, sb7, null);
                                                if (str22 != null) {
                                                    QDLog.d(TAG, "OK force dns first is " + Config.isForceDNSFirst());
                                                    CustomDnsResolve.setIPDirectEnable(getDomain(), Config.isForceDNSFirst());
                                                    handleErrorByCode(getDomain(), downloadResult.getStatus());
                                                }
                                                dns = dns6;
                                                i18 = i17;
                                                str25 = str114;
                                                downloadReport3 = downloadReport10;
                                                z16 = isNetworkAvailable;
                                                str23 = str9;
                                                str26 = str121;
                                                str29 = str123;
                                                str27 = str118;
                                                j27 = j77;
                                            } else {
                                                int i27 = i17;
                                                str22 = url3;
                                                z16 = isNetworkAvailable;
                                                str23 = str9;
                                                String str124 = str2;
                                                String str125 = str3;
                                                String str126 = str16;
                                                String str127 = str10;
                                                String str128 = str115;
                                                String str129 = str19;
                                                String str130 = str11;
                                                DownloadReport downloadReport11 = downloadReport2;
                                                String str131 = str14;
                                                str24 = parserHttpHeaderInfo2;
                                                String str132 = str17;
                                                String str133 = header;
                                                String str134 = str18;
                                                StringBuilder sb8 = new StringBuilder();
                                                sb8.append("Downloader, succeed to download:");
                                                sb8.append(getUrl());
                                                sb8.append(str131);
                                                sb8.append(this.mIsHttp2);
                                                sb8.append(str6);
                                                sb8.append((!this.mIsHttp2 || response == null || response.protocol() == null) ? "http1.1" : response.protocol().getProtocol());
                                                sb8.append(str134);
                                                sb8.append(dns6);
                                                sb8.append(str125);
                                                sb8.append(str119);
                                                sb8.append(str124);
                                                sb8.append((String) null);
                                                sb8.append(str126);
                                                sb8.append(Thread.currentThread().getId());
                                                sb8.append(str129);
                                                sb8.append(NetworkManager.getApnValue());
                                                sb8.append(str128);
                                                sb8.append(Config.getNetworkStackType());
                                                sb8.append(str12);
                                                sb8.append(downloadResult.getProcess().duration);
                                                sb8.append(str21);
                                                sb8.append(SystemClock.uptimeMillis() - this.mTimeStamp);
                                                str25 = str114;
                                                sb8.append(str25);
                                                sb8.append(downloadResult.getContent().length);
                                                str26 = str130;
                                                sb8.append(str26);
                                                sb8.append(downloadResult.getContent().size);
                                                sb8.append(str127);
                                                sb8.append(downloadResult.getContent().realsize);
                                                sb8.append(", retry=(");
                                                sb8.append(getCurrAttemptCount());
                                                sb8.append(str132);
                                                sb8.append(getTotalAttemptCount());
                                                sb8.append("), httpStatus=");
                                                i18 = i27;
                                                sb8.append(i18);
                                                sb8.append(str23);
                                                sb8.append(str24);
                                                str27 = str118;
                                                sb8.append(str27);
                                                sb8.append(downloadResult.getContent().type);
                                                str28 = str120;
                                                sb8.append(str28);
                                                str29 = str133;
                                                sb8.append(str29);
                                                dns = dns6;
                                                sb8.append(", ipUrl:");
                                                sb8.append(getUrl());
                                                sb8.append(", clientip=");
                                                sb8.append(downloadResult.getContent().clientip);
                                                sb8.append(", getIP=");
                                                sb8.append(j79);
                                                sb8.append(", connect:(");
                                                sb8.append(j78);
                                                sb8.append(str132);
                                                sb8.append(0);
                                                sb8.append("), exeReqest:(");
                                                sb8.append(0L);
                                                sb8.append(str132);
                                                sb8.append(0);
                                                sb8.append("), sendReq=");
                                                sb8.append(j77);
                                                sb8.append(", recvData=");
                                                j27 = j77;
                                                sb8.append(this.t_recv_data);
                                                sb8.append(", Concurrent:(");
                                                sb8.append(getTaskConcurrentCount());
                                                sb8.append("), mobileProxy=");
                                                DownloadTask.DownloadTaskHandler downloadTaskHandler2 = this.mDownloadTaskHandler;
                                                sb8.append(downloadTaskHandler2 != null ? downloadTaskHandler2.getCustomProxy() : null);
                                                sb8.append(", isGzip=");
                                                sb8.append(downloadResult.getContent().isGzip);
                                                String sb9 = sb8.toString();
                                                downloadReport3 = downloadReport11;
                                                downloadReport3.logInfo = sb9;
                                                QDLog.w(QDLog.TAG_DOWNLOAD_RESULT, sb9, null);
                                            }
                                            if (!z16) {
                                                this.mShouldReport = false;
                                            }
                                            DownloadResult.Status status = downloadResult.getStatus();
                                            StringBuilder sb10 = new StringBuilder();
                                            sb10.append(getUrl());
                                            sb10.append(" sip=");
                                            sb10.append(str119);
                                            sb10.append(", client=");
                                            sb10.append(downloadResult.getContent().clientip);
                                            sb10.append(", ipType=");
                                            DownloadGlobalStrategy.StrategyInfo strategyInfo = this.pCurrStrategyInfo;
                                            sb10.append(strategyInfo != null ? strategyInfo.f99899id : 0);
                                            sb10.append(", httpStatus=");
                                            sb10.append(i18);
                                            sb10.append(str27);
                                            sb10.append(downloadResult.getContent().type);
                                            sb10.append(str25);
                                            int i28 = i18;
                                            sb10.append(downloadResult.getContent().length);
                                            sb10.append(str26);
                                            sb10.append(downloadResult.getContent().size);
                                            sb10.append(str12);
                                            sb10.append(downloadResult.getProcess().duration);
                                            sb10.append(str21);
                                            sb10.append(SystemClock.uptimeMillis() - this.mTimeStamp);
                                            sb10.append(TextUtils.isEmpty(str29) ? "" : str28 + str29);
                                            sb10.append(str23);
                                            sb10.append(str24);
                                            status.detailDownloadInfo = sb10.toString();
                                            if (z16) {
                                                DownloadGlobalStrategy downloadGlobalStrategy = DownloadGlobalStrategy.getInstance(this.mContext);
                                                String url4 = getUrl();
                                                if (!this.mIsHttp2 || str22 == null) {
                                                    str30 = str22;
                                                } else {
                                                    str30 = str22;
                                                    if (str30.startsWith("https")) {
                                                        z17 = true;
                                                        downloadGlobalStrategy.reportHttps(url4, z17, downloadResult.getStatus().isSucceed());
                                                    }
                                                }
                                                z17 = false;
                                                downloadGlobalStrategy.reportHttps(url4, z17, downloadResult.getStatus().isSucceed());
                                            } else {
                                                str30 = str22;
                                            }
                                            downloadReport3.endTime = System.currentTimeMillis();
                                            downloadReport3.fileSize = getContentLength();
                                            downloadReport3.okResponse = response;
                                            downloadReport3.httpStatus = i28;
                                            downloadReport3.exception = null;
                                            downloadReport3.dns = dns == null ? null : dns.toString();
                                            downloadReport3.localAddress = null;
                                            downloadReport3.clientip = downloadResult.getContent().clientip;
                                            downloadReport3.totaltime = SystemClock.uptimeMillis() - this.mTimeStamp;
                                            downloadReport3.downloadTime = downloadResult.getProcess().duration;
                                            downloadReport3.t_wait = downloadReport3.totaltime - downloadResult.getProcess().duration;
                                            downloadReport3.t_prepare = j16;
                                            downloadReport3.t_conn = j78;
                                            downloadReport3.t_recvrsp = j27;
                                            downloadReport3.t_recvdata = this.t_recv_data;
                                            downloadReport3.t_process = 0L;
                                            downloadReport3.concurrent = getTaskConcurrentCount();
                                            downloadReport3.content_type = downloadResult.getContent().type;
                                            downloadReport3.isFromQzoneAlbum = Config.isFromQzoneAlbum(getDomain());
                                            downloadReport3.isHttp2 = this.mIsHttp2;
                                            downloadReport3.isHttps = str30 != null && str30.startsWith("https");
                                            downloadReport3.isSucceed = downloadResult.getStatus().isSucceed();
                                            downloadReport3.downloadMode = Downloader.DownloadMode.OkHttpMode.ordinal();
                                            if (response != null && response.protocol() != null) {
                                                downloadReport3.f99896protocol = response.protocol().getProtocol();
                                            }
                                            DownloadReport downloadReport12 = downloadReport3;
                                            downloadResult.setReport(downloadReport12);
                                            if (downloadResult.getStatus().isSucceed()) {
                                                handleDownloadReportForTask(jobContext, downloadResult, downloadReport12);
                                                throw th8;
                                            }
                                            throw th8;
                                        }
                                        throw th8;
                                    }
                                } catch (Throwable th9) {
                                    th = th9;
                                    str16 = str;
                                    str17 = str15;
                                    str18 = str4;
                                    str19 = str13;
                                    str20 = str8;
                                    long j85 = j17;
                                    i17 = i16;
                                    str21 = str5;
                                    downloadReport2 = downloadReport;
                                    j19 = j3;
                                    j26 = j85;
                                }
                            }
                        }
                    } catch (Throwable th10) {
                        th = th10;
                        i3 = generateRandomId;
                    }
                }
                i3 = generateRandomId;
            } catch (Throwable th11) {
                th = th11;
                i3 = generateRandomId;
            }
            try {
                url.removeHeader("Accept-Encoding");
                long uptimeMillis3 = SystemClock.uptimeMillis();
                str46 = str105;
                j36 = uptimeMillis3 - uptimeMillis2;
                try {
                    execute = this.pokHttpClient.newCall(url.build()).execute();
                    try {
                        j18 = SystemClock.uptimeMillis() - uptimeMillis3;
                        try {
                            headerCallback(execute);
                        } catch (Throwable th12) {
                            th = th12;
                            str7 = str46;
                            str = str99;
                            str2 = str100;
                            str3 = str101;
                            str4 = str102;
                            str5 = str109;
                            str6 = str103;
                            str8 = str106;
                            str9 = str108;
                            str10 = str110;
                            str12 = str113;
                            str13 = str116;
                            downloadReport = downloadReport9;
                            str14 = str104;
                            str11 = str111;
                            str15 = str112;
                            response2 = execute;
                            j3 = uptimeMillis2;
                            j37 = j36;
                        }
                    } catch (Throwable th13) {
                        th = th13;
                        str7 = str46;
                        str = str99;
                        str2 = str100;
                        str3 = str101;
                        str4 = str102;
                        str5 = str109;
                        str6 = str103;
                        str8 = str106;
                        str9 = str108;
                        str10 = str110;
                        str12 = str113;
                        str13 = str116;
                        downloadReport = downloadReport9;
                        str14 = str104;
                        str11 = str111;
                        str15 = str112;
                        j3 = uptimeMillis2;
                        j16 = j36;
                        response = execute;
                        i16 = 0;
                        j17 = 0;
                        j18 = 0;
                    }
                } catch (Throwable th14) {
                    th = th14;
                    str7 = str46;
                    str = str99;
                    str2 = str100;
                    str3 = str101;
                    str4 = str102;
                    str5 = str109;
                    str6 = str103;
                    str8 = str106;
                    str9 = str108;
                    str10 = str110;
                    str12 = str113;
                    str13 = str116;
                    downloadReport = downloadReport9;
                    str14 = str104;
                    str11 = str111;
                    str15 = str112;
                    j3 = uptimeMillis2;
                    j16 = j36;
                    i16 = 0;
                    j17 = 0;
                    j18 = 0;
                    response = null;
                    StringBuilder sb52 = new StringBuilder();
                    downloadReport4 = downloadReport;
                    sb52.append("download ");
                    sb52.append(getUrl());
                    sb52.append(" exception:");
                    QDLog.e(QDLog.TAG_DOWNLOAD_OKHTTP, sb52.toString(), th);
                    downloadResult.getStatus().setFailed(th);
                    downloadResult.getProcess().setDuration(j3, SystemClock.uptimeMillis());
                    downloadResult.getProcess().totalDuration = SystemClock.uptimeMillis() - this.mTimeStamp;
                    downloadResult.getProcess().startTimestamp = this.mTaskStartTimeStamp;
                    NetworkUtils.DNS dns52 = NetworkStatus.getInstance(this.mContext).getDNS();
                    String str1172 = this.mRemoteAddress;
                    String parserHttpHeaderInfo3 = parserHttpHeaderInfo(null, null, response);
                    long j692 = j18;
                    long j752 = j17;
                    long j762 = this.mDnsEnd - this.mDnsStart;
                    if (response != null) {
                    }
                    downloadResult.getContent().redirectUrl = r3;
                    String url22 = getUrl();
                    if (jobContext.isCancelled()) {
                    }
                    if (canAttempt()) {
                    }
                }
            } catch (Throwable th15) {
                th = th15;
                str = str99;
                str2 = str100;
                str3 = str101;
                str4 = str102;
                str5 = str109;
                str6 = str103;
                downloadReport = downloadReport9;
                str7 = str105;
                str8 = str106;
                str9 = str108;
                str10 = str110;
                str11 = str111;
                str12 = str113;
                str13 = str116;
                str14 = str104;
                str15 = str112;
                j3 = uptimeMillis2;
                j16 = j68;
                i16 = 0;
                j17 = 0;
                j18 = 0;
                response = null;
                StringBuilder sb522 = new StringBuilder();
                downloadReport4 = downloadReport;
                sb522.append("download ");
                sb522.append(getUrl());
                sb522.append(" exception:");
                QDLog.e(QDLog.TAG_DOWNLOAD_OKHTTP, sb522.toString(), th);
                downloadResult.getStatus().setFailed(th);
                downloadResult.getProcess().setDuration(j3, SystemClock.uptimeMillis());
                downloadResult.getProcess().totalDuration = SystemClock.uptimeMillis() - this.mTimeStamp;
                downloadResult.getProcess().startTimestamp = this.mTaskStartTimeStamp;
                NetworkUtils.DNS dns522 = NetworkStatus.getInstance(this.mContext).getDNS();
                String str11722 = this.mRemoteAddress;
                String parserHttpHeaderInfo32 = parserHttpHeaderInfo(null, null, response);
                long j6922 = j18;
                long j7522 = j17;
                long j7622 = this.mDnsEnd - this.mDnsStart;
                if (response != null) {
                }
                downloadResult.getContent().redirectUrl = r3;
                String url222 = getUrl();
                if (jobContext.isCancelled()) {
                }
                if (canAttempt()) {
                }
            }
            if (execute != null) {
                try {
                } catch (Throwable th16) {
                    th = th16;
                    j38 = j18;
                    str47 = str110;
                    j39 = j36;
                }
                if (execute.isSuccessful() && execute.body() != null) {
                    try {
                        this.mContentLength = parseContentLength(execute);
                        DownloadResult.Content content = downloadResult.getContent();
                        long j86 = this.mContentLength;
                        content.length = j86;
                        savePath = getSavePath(j86);
                    } catch (Throwable th17) {
                        th = th17;
                        str47 = str110;
                        j39 = j36;
                        j38 = j18;
                        j46 = uptimeMillis2;
                        response3 = execute;
                        str13 = str116;
                        str2 = str100;
                        str3 = str101;
                        str4 = str102;
                        str6 = str103;
                        str8 = str106;
                        str9 = str108;
                        str = str99;
                        str12 = str113;
                        str7 = str46;
                        downloadReport = downloadReport9;
                        j16 = j39;
                        str10 = str47;
                        i16 = 0;
                        str14 = str104;
                        str11 = str111;
                        str15 = str112;
                        j3 = j46;
                        str5 = str109;
                        j18 = j38;
                        response = response3;
                        j17 = j18;
                        StringBuilder sb5222 = new StringBuilder();
                        downloadReport4 = downloadReport;
                        sb5222.append("download ");
                        sb5222.append(getUrl());
                        sb5222.append(" exception:");
                        QDLog.e(QDLog.TAG_DOWNLOAD_OKHTTP, sb5222.toString(), th);
                        downloadResult.getStatus().setFailed(th);
                        downloadResult.getProcess().setDuration(j3, SystemClock.uptimeMillis());
                        downloadResult.getProcess().totalDuration = SystemClock.uptimeMillis() - this.mTimeStamp;
                        downloadResult.getProcess().startTimestamp = this.mTaskStartTimeStamp;
                        NetworkUtils.DNS dns5222 = NetworkStatus.getInstance(this.mContext).getDNS();
                        String str117222 = this.mRemoteAddress;
                        String parserHttpHeaderInfo322 = parserHttpHeaderInfo(null, null, response);
                        long j69222 = j18;
                        long j75222 = j17;
                        long j76222 = this.mDnsEnd - this.mDnsStart;
                        if (response != null) {
                        }
                        downloadResult.getContent().redirectUrl = r3;
                        String url2222 = getUrl();
                        if (jobContext.isCancelled()) {
                        }
                        if (canAttempt()) {
                        }
                    }
                    if (TextUtils.isEmpty(savePath)) {
                        try {
                            downloadResult.getStatus().setFailed(2);
                            QDLog.e(QDLog.TAG_DOWNLOAD_OKHTTP, "download fail, storage not enough. " + getUrl());
                            downloadResult.getProcess().setDuration(uptimeMillis2, SystemClock.uptimeMillis());
                            downloadResult.getProcess().totalDuration = SystemClock.uptimeMillis() - this.mTimeStamp;
                            downloadResult.getProcess().startTimestamp = this.mTaskStartTimeStamp;
                            NetworkUtils.DNS dns7 = NetworkStatus.getInstance(this.mContext).getDNS();
                            String str135 = this.mRemoteAddress;
                            String parserHttpHeaderInfo4 = parserHttpHeaderInfo(null, null, execute);
                            String str136 = str99;
                            long j87 = this.mDnsEnd - this.mDnsStart;
                            String header2 = execute.priorResponse() != null ? execute.priorResponse().header("Location") : null;
                            downloadResult.getContent().redirectUrl = header2;
                            String url5 = getUrl();
                            if (jobContext.isCancelled()) {
                                return;
                            }
                            boolean isNetworkAvailable2 = NetworkUtils.isNetworkAvailable(this.mContext);
                            if (!downloadResult.getStatus().isSucceed()) {
                                str48 = url5;
                                StringBuilder sb11 = new StringBuilder();
                                sb11.append("Downloader, fail to download:");
                                sb11.append(getUrl());
                                sb11.append(str104);
                                sb11.append(this.mIsHttp2);
                                sb11.append(str103);
                                sb11.append((!this.mIsHttp2 || execute.protocol() == null) ? "http1.1" : execute.protocol().getProtocol());
                                sb11.append(str102);
                                sb11.append(dns7);
                                sb11.append(str101);
                                sb11.append(str135);
                                sb11.append(str100);
                                sb11.append((String) null);
                                sb11.append(str136);
                                sb11.append(Thread.currentThread().getId());
                                sb11.append(str116);
                                sb11.append(NetworkManager.getApnValue());
                                sb11.append(", netAvailable=");
                                sb11.append(isNetworkAvailable2);
                                sb11.append(str115);
                                sb11.append(Config.getNetworkStackType());
                                sb11.append(str46);
                                sb11.append(downloadResult.getContent().type);
                                sb11.append(str113);
                                sb11.append(downloadResult.getProcess().duration);
                                sb11.append(str109);
                                sb11.append(SystemClock.uptimeMillis() - this.mTimeStamp);
                                sb11.append(str114);
                                sb11.append(downloadResult.getContent().length);
                                sb11.append(str111);
                                sb11.append(downloadResult.getContent().size);
                                sb11.append(str110);
                                sb11.append(downloadResult.getContent().realsize);
                                sb11.append(", retry=(");
                                sb11.append(getCurrAttemptCount());
                                String str137 = str112;
                                sb11.append(str137);
                                sb11.append(getTotalAttemptCount());
                                sb11.append("), errorCode=");
                                sb11.append(downloadResult.getStatus().exception2Code);
                                sb11.append(", reason=");
                                sb11.append(downloadResult.getStatus().getFailReason());
                                sb11.append(", httpStatus=");
                                sb11.append(0);
                                String str138 = str108;
                                sb11.append(str138);
                                sb11.append(parserHttpHeaderInfo4);
                                sb11.append(str106);
                                sb11.append(header2);
                                sb11.append(", ipUrl:");
                                sb11.append(getUrl());
                                sb11.append(", clientip=");
                                sb11.append(downloadResult.getContent().clientip);
                                sb11.append(", getIP=");
                                sb11.append(j87);
                                sb11.append(", connect:(");
                                sb11.append(j18);
                                sb11.append(str137);
                                sb11.append(0);
                                sb11.append("), exeReqest:(");
                                sb11.append(0L);
                                sb11.append(str137);
                                sb11.append(0);
                                sb11.append("), sendReq=");
                                sb11.append(j18);
                                sb11.append(", recvData=");
                                sb11.append(this.t_recv_data);
                                sb11.append(", Concurrent:(");
                                sb11.append(getTaskConcurrentCount());
                                sb11.append("), mobileProxy=");
                                DownloadTask.DownloadTaskHandler downloadTaskHandler3 = this.mDownloadTaskHandler;
                                sb11.append(downloadTaskHandler3 != null ? downloadTaskHandler3.getCustomProxy() : null);
                                sb11.append(", isGzip=");
                                sb11.append(downloadResult.getContent().isGzip);
                                String sb12 = sb11.toString();
                                downloadReport9.logInfo = sb12;
                                QDLog.e(QDLog.TAG_DOWNLOAD_RESULT, sb12, null);
                                if (str48 != null) {
                                    QDLog.d(TAG, "OK force dns first is " + Config.isForceDNSFirst());
                                    CustomDnsResolve.setIPDirectEnable(getDomain(), Config.isForceDNSFirst());
                                    handleErrorByCode(getDomain(), downloadResult.getStatus());
                                }
                                str55 = header2;
                                downloadReport6 = downloadReport9;
                                response4 = execute;
                                str54 = str106;
                                z26 = isNetworkAvailable2;
                                j47 = j18;
                                str52 = str111;
                                str49 = str113;
                                str50 = str138;
                                str53 = str46;
                                str51 = str114;
                            } else {
                                str48 = url5;
                                String str139 = str106;
                                String str140 = str110;
                                str49 = str113;
                                z26 = isNetworkAvailable2;
                                String str141 = str111;
                                str50 = str108;
                                String str142 = header2;
                                StringBuilder sb13 = new StringBuilder();
                                sb13.append("Downloader, succeed to download:");
                                sb13.append(getUrl());
                                sb13.append(str104);
                                sb13.append(this.mIsHttp2);
                                sb13.append(str103);
                                sb13.append((!this.mIsHttp2 || execute.protocol() == null) ? "http1.1" : execute.protocol().getProtocol());
                                sb13.append(str102);
                                sb13.append(dns7);
                                sb13.append(str101);
                                sb13.append(str135);
                                sb13.append(str100);
                                sb13.append((String) null);
                                sb13.append(str136);
                                sb13.append(Thread.currentThread().getId());
                                sb13.append(str116);
                                sb13.append(NetworkManager.getApnValue());
                                sb13.append(str115);
                                sb13.append(Config.getNetworkStackType());
                                sb13.append(str49);
                                sb13.append(downloadResult.getProcess().duration);
                                sb13.append(str109);
                                sb13.append(SystemClock.uptimeMillis() - this.mTimeStamp);
                                str51 = str114;
                                sb13.append(str51);
                                sb13.append(downloadResult.getContent().length);
                                str52 = str141;
                                sb13.append(str52);
                                sb13.append(downloadResult.getContent().size);
                                sb13.append(str140);
                                sb13.append(downloadResult.getContent().realsize);
                                sb13.append(", retry=(");
                                sb13.append(getCurrAttemptCount());
                                String str143 = str112;
                                sb13.append(str143);
                                sb13.append(getTotalAttemptCount());
                                sb13.append("), httpStatus=");
                                sb13.append(0);
                                sb13.append(str50);
                                sb13.append(parserHttpHeaderInfo4);
                                str53 = str46;
                                sb13.append(str53);
                                sb13.append(downloadResult.getContent().type);
                                str54 = str139;
                                sb13.append(str54);
                                str55 = str142;
                                sb13.append(str55);
                                sb13.append(", ipUrl:");
                                sb13.append(getUrl());
                                sb13.append(", clientip=");
                                sb13.append(downloadResult.getContent().clientip);
                                sb13.append(", getIP=");
                                response4 = execute;
                                sb13.append(j87);
                                sb13.append(", connect:(");
                                j47 = j18;
                                sb13.append(j47);
                                sb13.append(str143);
                                sb13.append(0);
                                sb13.append("), exeReqest:(");
                                sb13.append(0L);
                                sb13.append(str143);
                                sb13.append(0);
                                sb13.append("), sendReq=");
                                sb13.append(j47);
                                sb13.append(", recvData=");
                                sb13.append(this.t_recv_data);
                                sb13.append(", Concurrent:(");
                                sb13.append(getTaskConcurrentCount());
                                sb13.append("), mobileProxy=");
                                DownloadTask.DownloadTaskHandler downloadTaskHandler4 = this.mDownloadTaskHandler;
                                sb13.append(downloadTaskHandler4 != null ? downloadTaskHandler4.getCustomProxy() : null);
                                sb13.append(", isGzip=");
                                sb13.append(downloadResult.getContent().isGzip);
                                String sb14 = sb13.toString();
                                downloadReport6 = downloadReport9;
                                downloadReport6.logInfo = sb14;
                                QDLog.w(QDLog.TAG_DOWNLOAD_RESULT, sb14, null);
                            }
                            if (!z26) {
                                this.mShouldReport = false;
                            }
                            DownloadResult.Status status2 = downloadResult.getStatus();
                            StringBuilder sb15 = new StringBuilder();
                            sb15.append(getUrl());
                            sb15.append(" sip=");
                            sb15.append(str135);
                            sb15.append(", client=");
                            sb15.append(downloadResult.getContent().clientip);
                            sb15.append(", ipType=");
                            DownloadGlobalStrategy.StrategyInfo strategyInfo2 = this.pCurrStrategyInfo;
                            sb15.append(strategyInfo2 != null ? strategyInfo2.f99899id : 0);
                            sb15.append(", httpStatus=");
                            sb15.append(0);
                            sb15.append(str53);
                            sb15.append(downloadResult.getContent().type);
                            sb15.append(str51);
                            sb15.append(downloadResult.getContent().length);
                            sb15.append(str52);
                            sb15.append(downloadResult.getContent().size);
                            sb15.append(str49);
                            sb15.append(downloadResult.getProcess().duration);
                            sb15.append(str109);
                            sb15.append(SystemClock.uptimeMillis() - this.mTimeStamp);
                            sb15.append(TextUtils.isEmpty(str55) ? "" : str54 + str55);
                            sb15.append(str50);
                            sb15.append(parserHttpHeaderInfo4);
                            status2.detailDownloadInfo = sb15.toString();
                            if (z26) {
                                DownloadGlobalStrategy downloadGlobalStrategy2 = DownloadGlobalStrategy.getInstance(this.mContext);
                                String url6 = getUrl();
                                if (!this.mIsHttp2 || str48 == null) {
                                    str56 = str48;
                                } else {
                                    str56 = str48;
                                    if (str56.startsWith("https")) {
                                        z27 = true;
                                        downloadGlobalStrategy2.reportHttps(url6, z27, downloadResult.getStatus().isSucceed());
                                    }
                                }
                                z27 = false;
                                downloadGlobalStrategy2.reportHttps(url6, z27, downloadResult.getStatus().isSucceed());
                            } else {
                                str56 = str48;
                            }
                            downloadReport6.endTime = System.currentTimeMillis();
                            downloadReport6.fileSize = getContentLength();
                            Response response7 = response4;
                            downloadReport6.okResponse = response7;
                            downloadReport6.httpStatus = 0;
                            downloadReport6.exception = null;
                            downloadReport6.dns = dns7 == null ? null : dns7.toString();
                            downloadReport6.localAddress = null;
                            downloadReport6.clientip = downloadResult.getContent().clientip;
                            downloadReport6.totaltime = SystemClock.uptimeMillis() - this.mTimeStamp;
                            downloadReport6.downloadTime = downloadResult.getProcess().duration;
                            downloadReport6.t_wait = downloadReport6.totaltime - downloadResult.getProcess().duration;
                            downloadReport6.t_prepare = j36;
                            downloadReport6.t_conn = j47;
                            downloadReport6.t_recvrsp = j47;
                            downloadReport6.t_recvdata = this.t_recv_data;
                            downloadReport6.t_process = 0L;
                            downloadReport6.concurrent = getTaskConcurrentCount();
                            downloadReport6.content_type = downloadResult.getContent().type;
                            downloadReport6.isFromQzoneAlbum = Config.isFromQzoneAlbum(getDomain());
                            downloadReport6.isHttp2 = this.mIsHttp2;
                            downloadReport6.isHttps = str56 != null && str56.startsWith("https");
                            downloadReport6.isSucceed = downloadResult.getStatus().isSucceed();
                            downloadReport6.downloadMode = Downloader.DownloadMode.OkHttpMode.ordinal();
                            if (response7.protocol() != null) {
                                downloadReport6.f99896protocol = response7.protocol().getProtocol();
                            }
                            downloadResult.setReport(downloadReport6);
                            if (downloadResult.getStatus().isSucceed()) {
                                handleDownloadReportForTask(jobContext, downloadResult, downloadReport6);
                                return;
                            }
                            return;
                        } catch (Throwable th18) {
                            th = th18;
                            j38 = j18;
                            j46 = uptimeMillis2;
                            response3 = execute;
                            str2 = str100;
                            str3 = str101;
                            str4 = str102;
                            str6 = str103;
                            str7 = str46;
                            str = str99;
                            str8 = str106;
                            str9 = str108;
                            str10 = str110;
                            str12 = str113;
                            str13 = str116;
                            downloadReport = downloadReport9;
                            j16 = j36;
                            i16 = 0;
                            str14 = str104;
                            str11 = str111;
                            str15 = str112;
                            j3 = j46;
                            str5 = str109;
                            j18 = j38;
                            response = response3;
                            j17 = j18;
                            StringBuilder sb52222 = new StringBuilder();
                            downloadReport4 = downloadReport;
                            sb52222.append("download ");
                            sb52222.append(getUrl());
                            sb52222.append(" exception:");
                            QDLog.e(QDLog.TAG_DOWNLOAD_OKHTTP, sb52222.toString(), th);
                            downloadResult.getStatus().setFailed(th);
                            downloadResult.getProcess().setDuration(j3, SystemClock.uptimeMillis());
                            downloadResult.getProcess().totalDuration = SystemClock.uptimeMillis() - this.mTimeStamp;
                            downloadResult.getProcess().startTimestamp = this.mTaskStartTimeStamp;
                            NetworkUtils.DNS dns52222 = NetworkStatus.getInstance(this.mContext).getDNS();
                            String str1172222 = this.mRemoteAddress;
                            String parserHttpHeaderInfo3222 = parserHttpHeaderInfo(null, null, response);
                            long j692222 = j18;
                            long j752222 = j17;
                            long j762222 = this.mDnsEnd - this.mDnsStart;
                            if (response != null) {
                            }
                            downloadResult.getContent().redirectUrl = r3;
                            String url22222 = getUrl();
                            if (jobContext.isCancelled()) {
                            }
                            if (canAttempt()) {
                            }
                        }
                    } else {
                        String str144 = str99;
                        str57 = str106;
                        str58 = str108;
                        str59 = str110;
                        j48 = j36;
                        j38 = j18;
                        j49 = uptimeMillis2;
                        response3 = execute;
                        str60 = str113;
                        str61 = str116;
                        try {
                            downloadResult.setPath(savePath);
                            byteStream = response3.body().byteStream();
                            uptimeMillis = SystemClock.uptimeMillis();
                            saveToFile = saveToFile(byteStream, savePath);
                            str62 = str46;
                            str63 = str144;
                        } catch (Throwable th19) {
                            th = th19;
                            str13 = str61;
                            str2 = str100;
                            str3 = str101;
                            str4 = str102;
                            str6 = str103;
                            str14 = str104;
                            str7 = str46;
                            str = str144;
                            str15 = str112;
                            downloadReport = downloadReport9;
                            j16 = j48;
                            str9 = str58;
                            str8 = str57;
                            str10 = str59;
                            i16 = 0;
                            str12 = str60;
                            j3 = j49;
                            str5 = str109;
                            str11 = str111;
                            j18 = j38;
                            response = response3;
                            j17 = j18;
                            StringBuilder sb522222 = new StringBuilder();
                            downloadReport4 = downloadReport;
                            sb522222.append("download ");
                            sb522222.append(getUrl());
                            sb522222.append(" exception:");
                            QDLog.e(QDLog.TAG_DOWNLOAD_OKHTTP, sb522222.toString(), th);
                            downloadResult.getStatus().setFailed(th);
                            downloadResult.getProcess().setDuration(j3, SystemClock.uptimeMillis());
                            downloadResult.getProcess().totalDuration = SystemClock.uptimeMillis() - this.mTimeStamp;
                            downloadResult.getProcess().startTimestamp = this.mTaskStartTimeStamp;
                            NetworkUtils.DNS dns522222 = NetworkStatus.getInstance(this.mContext).getDNS();
                            String str11722222 = this.mRemoteAddress;
                            String parserHttpHeaderInfo32222 = parserHttpHeaderInfo(null, null, response);
                            long j6922222 = j18;
                            long j7522222 = j17;
                            long j7622222 = this.mDnsEnd - this.mDnsStart;
                            if (response != null) {
                            }
                            downloadResult.getContent().redirectUrl = r3;
                            String url222222 = getUrl();
                            if (jobContext.isCancelled()) {
                            }
                            if (canAttempt()) {
                            }
                        }
                        try {
                            this.t_recv_data = SystemClock.uptimeMillis() - uptimeMillis;
                            byteStream.close();
                            j56 = saveToFile;
                            downloadResult.getContent().size = j56;
                            downloadResult.getContent().realsize = j56;
                            if (response3 == null) {
                                try {
                                    code = response3.code();
                                } catch (Throwable th20) {
                                    th = th20;
                                    str13 = str61;
                                    str3 = str101;
                                    str4 = str102;
                                    str5 = str109;
                                    str6 = str103;
                                    str14 = str104;
                                    str2 = str100;
                                    str = str63;
                                    str7 = str62;
                                    str9 = str58;
                                    str8 = str57;
                                    str10 = str59;
                                    j16 = j48;
                                    i16 = 0;
                                    response = response3;
                                    j3 = j49;
                                    str12 = str60;
                                    str15 = str112;
                                    downloadReport = downloadReport9;
                                    j17 = j38;
                                    j18 = j17;
                                    str11 = str111;
                                }
                                try {
                                    downloadResult.getContent().type = response3.header("content-type");
                                    downloadResult.getContent().encoding = response3.header(Headers.CONTENT_ENCODING);
                                    downloadResult.getContent().retCode = code;
                                    downloadResult.getStatus().httpStatus = code;
                                    if (response3.networkResponse() != null) {
                                        try {
                                            String header3 = response3.networkResponse().header(Headers.CONTENT_ENCODING);
                                            if ("gzip".equals(header3)) {
                                                downloadResult.getContent().encoding = header3;
                                                downloadResult.getContent().isGzip = true;
                                            }
                                        } catch (Throwable th21) {
                                            th = th21;
                                            str13 = str61;
                                            i16 = code;
                                            str2 = str100;
                                            str3 = str101;
                                            str4 = str102;
                                            str6 = str103;
                                            str14 = str104;
                                            str = str63;
                                            str7 = str62;
                                            downloadReport = downloadReport9;
                                            j16 = j48;
                                            str9 = str58;
                                            str8 = str57;
                                            str10 = str59;
                                            str12 = str60;
                                            j3 = j49;
                                            str5 = str109;
                                            str11 = str111;
                                            str15 = str112;
                                            j18 = j38;
                                            response = response3;
                                            j17 = j18;
                                            StringBuilder sb5222222 = new StringBuilder();
                                            downloadReport4 = downloadReport;
                                            sb5222222.append("download ");
                                            sb5222222.append(getUrl());
                                            sb5222222.append(" exception:");
                                            QDLog.e(QDLog.TAG_DOWNLOAD_OKHTTP, sb5222222.toString(), th);
                                            downloadResult.getStatus().setFailed(th);
                                            downloadResult.getProcess().setDuration(j3, SystemClock.uptimeMillis());
                                            downloadResult.getProcess().totalDuration = SystemClock.uptimeMillis() - this.mTimeStamp;
                                            downloadResult.getProcess().startTimestamp = this.mTaskStartTimeStamp;
                                            NetworkUtils.DNS dns5222222 = NetworkStatus.getInstance(this.mContext).getDNS();
                                            String str117222222 = this.mRemoteAddress;
                                            String parserHttpHeaderInfo322222 = parserHttpHeaderInfo(null, null, response);
                                            long j69222222 = j18;
                                            long j75222222 = j17;
                                            long j76222222 = this.mDnsEnd - this.mDnsStart;
                                            if (response != null) {
                                            }
                                            downloadResult.getContent().redirectUrl = r3;
                                            String url2222222 = getUrl();
                                            if (jobContext.isCancelled()) {
                                            }
                                            if (canAttempt()) {
                                            }
                                        }
                                    }
                                    if (200 != code && 206 != code) {
                                        ResumeTransfer resumeTransfer = this.pResumeTransfer;
                                        if (resumeTransfer != null) {
                                            resumeTransfer.onDownloadResult(getUrl(), true);
                                        }
                                        downloadResult.getStatus().setFailed(code);
                                        i26 = code;
                                        j58 = j49;
                                        str73 = str100;
                                        str74 = str109;
                                        str75 = str63;
                                        str76 = str115;
                                        j59 = j48;
                                        j65 = j38;
                                        str77 = str58;
                                        str78 = str57;
                                        str79 = str59;
                                        str80 = str60;
                                        response2 = response3;
                                        str81 = str62;
                                    }
                                    downloadResult.getStatus().setSucceed();
                                    downloadResult.getProcess().setDuration(j49, SystemClock.uptimeMillis());
                                    downloadResult.getProcess().totalDuration = SystemClock.uptimeMillis() - this.mTimeStamp;
                                    downloadResult.getProcess().startTimestamp = this.mTaskStartTimeStamp;
                                    NetworkUtils.DNS dns8 = NetworkStatus.getInstance(this.mContext).getDNS();
                                    String str145 = this.mRemoteAddress;
                                    String parserHttpHeaderInfo5 = parserHttpHeaderInfo(null, null, response3);
                                    String str146 = str60;
                                    long j88 = this.mDnsEnd - this.mDnsStart;
                                    String header4 = response3.priorResponse() != null ? response3.priorResponse().header("Location") : null;
                                    downloadResult.getContent().redirectUrl = header4;
                                    String url7 = getUrl();
                                    if (jobContext.isCancelled()) {
                                        return;
                                    }
                                    boolean isNetworkAvailable3 = NetworkUtils.isNetworkAvailable(this.mContext);
                                    if (!downloadResult.getStatus().isSucceed()) {
                                        StringBuilder sb16 = new StringBuilder();
                                        sb16.append("Downloader, fail to download:");
                                        sb16.append(getUrl());
                                        sb16.append(str104);
                                        sb16.append(this.mIsHttp2);
                                        sb16.append(str103);
                                        sb16.append((!this.mIsHttp2 || response3.protocol() == null) ? "http1.1" : response3.protocol().getProtocol());
                                        sb16.append(str102);
                                        sb16.append(dns8);
                                        sb16.append(str101);
                                        sb16.append(str145);
                                        sb16.append(str100);
                                        sb16.append((String) null);
                                        sb16.append(str63);
                                        sb16.append(Thread.currentThread().getId());
                                        sb16.append(str61);
                                        sb16.append(NetworkManager.getApnValue());
                                        sb16.append(", netAvailable=");
                                        sb16.append(isNetworkAvailable3);
                                        sb16.append(str115);
                                        sb16.append(Config.getNetworkStackType());
                                        String str147 = str62;
                                        sb16.append(str147);
                                        sb16.append(downloadResult.getContent().type);
                                        sb16.append(str146);
                                        sb16.append(downloadResult.getProcess().duration);
                                        sb16.append(str109);
                                        sb16.append(SystemClock.uptimeMillis() - this.mTimeStamp);
                                        sb16.append(str114);
                                        sb16.append(downloadResult.getContent().length);
                                        String str148 = str111;
                                        sb16.append(str148);
                                        sb16.append(downloadResult.getContent().size);
                                        sb16.append(str59);
                                        sb16.append(downloadResult.getContent().realsize);
                                        sb16.append(", retry=(");
                                        sb16.append(getCurrAttemptCount());
                                        String str149 = str112;
                                        sb16.append(str149);
                                        sb16.append(getTotalAttemptCount());
                                        sb16.append("), errorCode=");
                                        sb16.append(downloadResult.getStatus().exception2Code);
                                        sb16.append(", reason=");
                                        sb16.append(downloadResult.getStatus().getFailReason());
                                        sb16.append(", httpStatus=");
                                        sb16.append(code);
                                        String str150 = str58;
                                        sb16.append(str150);
                                        sb16.append(parserHttpHeaderInfo5);
                                        z28 = isNetworkAvailable3;
                                        String str151 = str57;
                                        sb16.append(str151);
                                        sb16.append(header4);
                                        sb16.append(", ipUrl:");
                                        sb16.append(getUrl());
                                        sb16.append(", clientip=");
                                        sb16.append(downloadResult.getContent().clientip);
                                        sb16.append(", getIP=");
                                        str66 = header4;
                                        str64 = str151;
                                        sb16.append(j88);
                                        sb16.append(", connect:(");
                                        long j89 = j38;
                                        sb16.append(j89);
                                        sb16.append(str149);
                                        sb16.append(0);
                                        sb16.append("), exeReqest:(");
                                        sb16.append(0L);
                                        sb16.append(str149);
                                        sb16.append(0);
                                        sb16.append("), sendReq=");
                                        sb16.append(j89);
                                        sb16.append(", recvData=");
                                        sb16.append(this.t_recv_data);
                                        sb16.append(", Concurrent:(");
                                        sb16.append(getTaskConcurrentCount());
                                        sb16.append("), mobileProxy=");
                                        DownloadTask.DownloadTaskHandler downloadTaskHandler5 = this.mDownloadTaskHandler;
                                        sb16.append(downloadTaskHandler5 != null ? downloadTaskHandler5.getCustomProxy() : null);
                                        sb16.append(", isGzip=");
                                        sb16.append(downloadResult.getContent().isGzip);
                                        String sb17 = sb16.toString();
                                        downloadReport9.logInfo = sb17;
                                        QDLog.e(QDLog.TAG_DOWNLOAD_RESULT, sb17, null);
                                        if (url7 != null) {
                                            QDLog.d(TAG, "OK force dns first is " + Config.isForceDNSFirst());
                                            CustomDnsResolve.setIPDirectEnable(getDomain(), Config.isForceDNSFirst());
                                            handleErrorByCode(getDomain(), downloadResult.getStatus());
                                        }
                                        str71 = str114;
                                        str67 = str148;
                                        i19 = code;
                                        str68 = str150;
                                        str70 = str147;
                                        str69 = parserHttpHeaderInfo5;
                                        str65 = str146;
                                        dns3 = dns8;
                                        response5 = response3;
                                        j57 = j89;
                                        downloadReport7 = downloadReport9;
                                    } else {
                                        String str152 = str63;
                                        String str153 = str62;
                                        long j95 = j38;
                                        String str154 = str58;
                                        str64 = str57;
                                        String str155 = str59;
                                        String str156 = str100;
                                        str65 = str146;
                                        z28 = isNetworkAvailable3;
                                        String str157 = str112;
                                        String str158 = str111;
                                        str66 = header4;
                                        StringBuilder sb18 = new StringBuilder();
                                        sb18.append("Downloader, succeed to download:");
                                        sb18.append(getUrl());
                                        sb18.append(str104);
                                        sb18.append(this.mIsHttp2);
                                        sb18.append(str103);
                                        sb18.append((!this.mIsHttp2 || response3.protocol() == null) ? "http1.1" : response3.protocol().getProtocol());
                                        sb18.append(str102);
                                        sb18.append(dns8);
                                        sb18.append(str101);
                                        sb18.append(str145);
                                        sb18.append(str156);
                                        sb18.append((String) null);
                                        sb18.append(str152);
                                        sb18.append(Thread.currentThread().getId());
                                        sb18.append(str61);
                                        sb18.append(NetworkManager.getApnValue());
                                        sb18.append(str115);
                                        sb18.append(Config.getNetworkStackType());
                                        sb18.append(str65);
                                        sb18.append(downloadResult.getProcess().duration);
                                        sb18.append(str109);
                                        sb18.append(SystemClock.uptimeMillis() - this.mTimeStamp);
                                        sb18.append(str114);
                                        sb18.append(downloadResult.getContent().length);
                                        str67 = str158;
                                        sb18.append(str67);
                                        sb18.append(downloadResult.getContent().size);
                                        sb18.append(str155);
                                        sb18.append(downloadResult.getContent().realsize);
                                        sb18.append(", retry=(");
                                        sb18.append(getCurrAttemptCount());
                                        sb18.append(str157);
                                        sb18.append(getTotalAttemptCount());
                                        sb18.append("), httpStatus=");
                                        i19 = code;
                                        sb18.append(i19);
                                        str68 = str154;
                                        sb18.append(str68);
                                        str69 = parserHttpHeaderInfo5;
                                        sb18.append(str69);
                                        str70 = str153;
                                        sb18.append(str70);
                                        sb18.append(downloadResult.getContent().type);
                                        sb18.append(str64);
                                        sb18.append(str66);
                                        dns3 = dns8;
                                        sb18.append(", ipUrl:");
                                        sb18.append(getUrl());
                                        sb18.append(", clientip=");
                                        sb18.append(downloadResult.getContent().clientip);
                                        sb18.append(", getIP=");
                                        sb18.append(j88);
                                        sb18.append(", connect:(");
                                        j57 = j95;
                                        sb18.append(j57);
                                        sb18.append(str157);
                                        response5 = response3;
                                        sb18.append(0);
                                        sb18.append("), exeReqest:(");
                                        str71 = str114;
                                        sb18.append(0L);
                                        sb18.append(str157);
                                        sb18.append(0);
                                        sb18.append("), sendReq=");
                                        sb18.append(j57);
                                        sb18.append(", recvData=");
                                        sb18.append(this.t_recv_data);
                                        sb18.append(", Concurrent:(");
                                        sb18.append(getTaskConcurrentCount());
                                        sb18.append("), mobileProxy=");
                                        DownloadTask.DownloadTaskHandler downloadTaskHandler6 = this.mDownloadTaskHandler;
                                        sb18.append(downloadTaskHandler6 != null ? downloadTaskHandler6.getCustomProxy() : null);
                                        sb18.append(", isGzip=");
                                        sb18.append(downloadResult.getContent().isGzip);
                                        String sb19 = sb18.toString();
                                        downloadReport7 = downloadReport9;
                                        downloadReport7.logInfo = sb19;
                                        QDLog.w(QDLog.TAG_DOWNLOAD_RESULT, sb19, null);
                                    }
                                    if (!z28) {
                                        this.mShouldReport = false;
                                    }
                                    DownloadResult.Status status3 = downloadResult.getStatus();
                                    StringBuilder sb20 = new StringBuilder();
                                    sb20.append(getUrl());
                                    sb20.append(" sip=");
                                    sb20.append(str145);
                                    sb20.append(", client=");
                                    sb20.append(downloadResult.getContent().clientip);
                                    sb20.append(", ipType=");
                                    DownloadGlobalStrategy.StrategyInfo strategyInfo3 = this.pCurrStrategyInfo;
                                    sb20.append(strategyInfo3 != null ? strategyInfo3.f99899id : 0);
                                    sb20.append(", httpStatus=");
                                    sb20.append(i19);
                                    sb20.append(str70);
                                    sb20.append(downloadResult.getContent().type);
                                    sb20.append(str71);
                                    sb20.append(downloadResult.getContent().length);
                                    sb20.append(str67);
                                    sb20.append(downloadResult.getContent().size);
                                    sb20.append(str65);
                                    sb20.append(downloadResult.getProcess().duration);
                                    sb20.append(str109);
                                    sb20.append(SystemClock.uptimeMillis() - this.mTimeStamp);
                                    sb20.append(TextUtils.isEmpty(str66) ? "" : str64 + str66);
                                    sb20.append(str68);
                                    sb20.append(str69);
                                    status3.detailDownloadInfo = sb20.toString();
                                    if (z28) {
                                        DownloadGlobalStrategy downloadGlobalStrategy3 = DownloadGlobalStrategy.getInstance(this.mContext);
                                        String url8 = getUrl();
                                        if (!this.mIsHttp2 || url7 == null) {
                                            str72 = url7;
                                        } else {
                                            str72 = url7;
                                            if (str72.startsWith("https")) {
                                                z29 = true;
                                                downloadGlobalStrategy3.reportHttps(url8, z29, downloadResult.getStatus().isSucceed());
                                            }
                                        }
                                        z29 = false;
                                        downloadGlobalStrategy3.reportHttps(url8, z29, downloadResult.getStatus().isSucceed());
                                    } else {
                                        str72 = url7;
                                    }
                                    downloadReport7.endTime = System.currentTimeMillis();
                                    downloadReport7.fileSize = getContentLength();
                                    Response response8 = response5;
                                    downloadReport7.okResponse = response8;
                                    downloadReport7.httpStatus = i19;
                                    downloadReport7.exception = null;
                                    downloadReport7.dns = dns3 == null ? null : dns3.toString();
                                    downloadReport7.localAddress = null;
                                    downloadReport7.clientip = downloadResult.getContent().clientip;
                                    downloadReport7.totaltime = SystemClock.uptimeMillis() - this.mTimeStamp;
                                    downloadReport7.downloadTime = downloadResult.getProcess().duration;
                                    downloadReport7.t_wait = downloadReport7.totaltime - downloadResult.getProcess().duration;
                                    downloadReport7.t_prepare = j48;
                                    downloadReport7.t_conn = j57;
                                    downloadReport7.t_recvrsp = j57;
                                    downloadReport7.t_recvdata = this.t_recv_data;
                                    downloadReport7.t_process = 0L;
                                    downloadReport7.concurrent = getTaskConcurrentCount();
                                    downloadReport7.content_type = downloadResult.getContent().type;
                                    downloadReport7.isFromQzoneAlbum = Config.isFromQzoneAlbum(getDomain());
                                    downloadReport7.isHttp2 = this.mIsHttp2;
                                    downloadReport7.isHttps = str72 != null && str72.startsWith("https");
                                    downloadReport7.isSucceed = downloadResult.getStatus().isSucceed();
                                    downloadReport7.downloadMode = Downloader.DownloadMode.OkHttpMode.ordinal();
                                    if (response8.protocol() != null) {
                                        downloadReport7.f99896protocol = response8.protocol().getProtocol();
                                    }
                                    downloadResult.setReport(downloadReport7);
                                    if (downloadResult.getStatus().isSucceed()) {
                                        handleDownloadReportForTask(jobContext, downloadResult, downloadReport7);
                                        return;
                                    }
                                    return;
                                } catch (Throwable th22) {
                                    th = th22;
                                    str13 = str61;
                                    str3 = str101;
                                    str4 = str102;
                                    str5 = str109;
                                    str6 = str103;
                                    str2 = str100;
                                    i16 = code;
                                    str = str63;
                                    str7 = str62;
                                    str9 = str58;
                                    str8 = str57;
                                    str10 = str59;
                                    j16 = j48;
                                    response = response3;
                                    str12 = str60;
                                    str14 = str104;
                                    str15 = str112;
                                    downloadReport = downloadReport9;
                                    j17 = j38;
                                    j3 = j49;
                                    str11 = str111;
                                    j18 = j17;
                                    StringBuilder sb52222222 = new StringBuilder();
                                    downloadReport4 = downloadReport;
                                    sb52222222.append("download ");
                                    sb52222222.append(getUrl());
                                    sb52222222.append(" exception:");
                                    QDLog.e(QDLog.TAG_DOWNLOAD_OKHTTP, sb52222222.toString(), th);
                                    downloadResult.getStatus().setFailed(th);
                                    downloadResult.getProcess().setDuration(j3, SystemClock.uptimeMillis());
                                    downloadResult.getProcess().totalDuration = SystemClock.uptimeMillis() - this.mTimeStamp;
                                    downloadResult.getProcess().startTimestamp = this.mTaskStartTimeStamp;
                                    NetworkUtils.DNS dns52222222 = NetworkStatus.getInstance(this.mContext).getDNS();
                                    String str1172222222 = this.mRemoteAddress;
                                    String parserHttpHeaderInfo3222222 = parserHttpHeaderInfo(null, null, response);
                                    long j692222222 = j18;
                                    long j752222222 = j17;
                                    long j762222222 = this.mDnsEnd - this.mDnsStart;
                                    String header5 = (response != null || response.priorResponse() == null) ? null : response.priorResponse().header("Location");
                                    downloadResult.getContent().redirectUrl = header5;
                                    String url22222222 = getUrl();
                                    if (jobContext.isCancelled()) {
                                        boolean isNetworkAvailable4 = NetworkUtils.isNetworkAvailable(this.mContext);
                                        if (!downloadResult.getStatus().isSucceed()) {
                                            StringBuilder sb21 = new StringBuilder();
                                            str38 = url22222222;
                                            sb21.append("Downloader, fail to download:");
                                            sb21.append(getUrl());
                                            sb21.append(str14);
                                            sb21.append(this.mIsHttp2);
                                            sb21.append(str6);
                                            sb21.append((!this.mIsHttp2 || response == null || response.protocol() == null) ? "http1.1" : response.protocol().getProtocol());
                                            String str159 = str4;
                                            sb21.append(str159);
                                            sb21.append(dns52222222);
                                            sb21.append(str3);
                                            sb21.append(str1172222222);
                                            str41 = str1172222222;
                                            sb21.append(str2);
                                            sb21.append((String) null);
                                            String str160 = str;
                                            sb21.append(str160);
                                            str32 = str160;
                                            sb21.append(Thread.currentThread().getId());
                                            String str161 = str13;
                                            sb21.append(str161);
                                            sb21.append(NetworkManager.getApnValue());
                                            sb21.append(", netAvailable=");
                                            sb21.append(isNetworkAvailable4);
                                            sb21.append(str115);
                                            z18 = isNetworkAvailable4;
                                            sb21.append(Config.getNetworkStackType());
                                            sb21.append(str7);
                                            sb21.append(downloadResult.getContent().type);
                                            sb21.append(str12);
                                            sb21.append(downloadResult.getProcess().duration);
                                            sb21.append(str5);
                                            str40 = str5;
                                            sb21.append(SystemClock.uptimeMillis() - this.mTimeStamp);
                                            str42 = str114;
                                            sb21.append(str42);
                                            sb21.append(downloadResult.getContent().length);
                                            str39 = str11;
                                            sb21.append(str39);
                                            sb21.append(downloadResult.getContent().size);
                                            sb21.append(str10);
                                            sb21.append(downloadResult.getContent().realsize);
                                            sb21.append(", retry=(");
                                            sb21.append(getCurrAttemptCount());
                                            String str162 = str15;
                                            sb21.append(str162);
                                            sb21.append(getTotalAttemptCount());
                                            sb21.append("), errorCode=");
                                            sb21.append(downloadResult.getStatus().exception2Code);
                                            sb21.append(", reason=");
                                            sb21.append(downloadResult.getStatus().getFailReason());
                                            sb21.append(", httpStatus=");
                                            sb21.append(i16);
                                            sb21.append(str9);
                                            sb21.append(parserHttpHeaderInfo3222222);
                                            str36 = str8;
                                            sb21.append(str36);
                                            sb21.append(header5);
                                            String str163 = header5;
                                            sb21.append(", ipUrl:");
                                            sb21.append(getUrl());
                                            sb21.append(", clientip=");
                                            sb21.append(downloadResult.getContent().clientip);
                                            sb21.append(", getIP=");
                                            sb21.append(j762222222);
                                            sb21.append(", connect:(");
                                            sb21.append(j752222222);
                                            sb21.append(str162);
                                            sb21.append(0);
                                            sb21.append("), exeReqest:(");
                                            sb21.append(0L);
                                            sb21.append(str162);
                                            sb21.append(0);
                                            sb21.append("), sendReq=");
                                            sb21.append(j692222222);
                                            sb21.append(", recvData=");
                                            sb21.append(this.t_recv_data);
                                            sb21.append(", Concurrent:(");
                                            sb21.append(getTaskConcurrentCount());
                                            sb21.append("), mobileProxy=");
                                            DownloadTask.DownloadTaskHandler downloadTaskHandler7 = this.mDownloadTaskHandler;
                                            sb21.append(downloadTaskHandler7 != null ? downloadTaskHandler7.getCustomProxy() : null);
                                            sb21.append(", isGzip=");
                                            sb21.append(downloadResult.getContent().isGzip);
                                            String sb22 = sb21.toString();
                                            downloadReport4.logInfo = sb22;
                                            QDLog.e(QDLog.TAG_DOWNLOAD_RESULT, sb22, th);
                                            if (str38 != null) {
                                                QDLog.d(TAG, "OK force dns first is " + Config.isForceDNSFirst());
                                                CustomDnsResolve.setIPDirectEnable(getDomain(), Config.isForceDNSFirst());
                                                handleErrorByCode(getDomain(), downloadResult.getStatus());
                                            }
                                            th5 = th;
                                            j29 = j692222222;
                                            dns2 = dns52222222;
                                            str43 = str163;
                                            str35 = str161;
                                            str37 = str7;
                                            str34 = str159;
                                            str33 = str162;
                                            str44 = parserHttpHeaderInfo3222222;
                                            downloadReport5 = downloadReport4;
                                        } else {
                                            str38 = url22222222;
                                            j29 = j692222222;
                                            str32 = str;
                                            str39 = str11;
                                            String str164 = str4;
                                            String str165 = str13;
                                            str40 = str5;
                                            str41 = str1172222222;
                                            z18 = isNetworkAvailable4;
                                            str42 = str114;
                                            String str166 = str15;
                                            str36 = str8;
                                            String str167 = header5;
                                            StringBuilder sb23 = new StringBuilder();
                                            th5 = th;
                                            sb23.append("Downloader, succeed to download:");
                                            sb23.append(getUrl());
                                            sb23.append(str14);
                                            sb23.append(this.mIsHttp2);
                                            String str168 = str6;
                                            sb23.append(str168);
                                            sb23.append((!this.mIsHttp2 || response == null || response.protocol() == null) ? "http1.1" : response.protocol().getProtocol());
                                            sb23.append(str164);
                                            dns2 = dns52222222;
                                            sb23.append(dns2);
                                            str34 = str164;
                                            sb23.append(str3);
                                            sb23.append(str41);
                                            str6 = str168;
                                            sb23.append(str2);
                                            sb23.append((String) null);
                                            sb23.append(str32);
                                            sb23.append(Thread.currentThread().getId());
                                            sb23.append(str165);
                                            sb23.append(NetworkManager.getApnValue());
                                            sb23.append(str115);
                                            sb23.append(Config.getNetworkStackType());
                                            sb23.append(str12);
                                            sb23.append(downloadResult.getProcess().duration);
                                            sb23.append(str40);
                                            str35 = str165;
                                            sb23.append(SystemClock.uptimeMillis() - this.mTimeStamp);
                                            sb23.append(str42);
                                            sb23.append(downloadResult.getContent().length);
                                            sb23.append(str39);
                                            sb23.append(downloadResult.getContent().size);
                                            sb23.append(str10);
                                            sb23.append(downloadResult.getContent().realsize);
                                            sb23.append(", retry=(");
                                            sb23.append(getCurrAttemptCount());
                                            sb23.append(str166);
                                            sb23.append(getTotalAttemptCount());
                                            sb23.append("), httpStatus=");
                                            sb23.append(i16);
                                            sb23.append(str9);
                                            sb23.append(parserHttpHeaderInfo3222222);
                                            str37 = str7;
                                            sb23.append(str37);
                                            sb23.append(downloadResult.getContent().type);
                                            sb23.append(str36);
                                            str43 = str167;
                                            sb23.append(str43);
                                            sb23.append(", ipUrl:");
                                            sb23.append(getUrl());
                                            sb23.append(", clientip=");
                                            sb23.append(downloadResult.getContent().clientip);
                                            sb23.append(", getIP=");
                                            str44 = parserHttpHeaderInfo3222222;
                                            sb23.append(j762222222);
                                            sb23.append(", connect:(");
                                            sb23.append(j752222222);
                                            sb23.append(str166);
                                            j752222222 = j752222222;
                                            sb23.append(0);
                                            sb23.append("), exeReqest:(");
                                            sb23.append(0L);
                                            sb23.append(str166);
                                            sb23.append(0);
                                            sb23.append("), sendReq=");
                                            sb23.append(j29);
                                            str33 = str166;
                                            sb23.append(", recvData=");
                                            sb23.append(this.t_recv_data);
                                            sb23.append(", Concurrent:(");
                                            sb23.append(getTaskConcurrentCount());
                                            sb23.append("), mobileProxy=");
                                            DownloadTask.DownloadTaskHandler downloadTaskHandler8 = this.mDownloadTaskHandler;
                                            sb23.append(downloadTaskHandler8 != null ? downloadTaskHandler8.getCustomProxy() : null);
                                            sb23.append(", isGzip=");
                                            sb23.append(downloadResult.getContent().isGzip);
                                            String sb24 = sb23.toString();
                                            downloadReport5 = downloadReport4;
                                            downloadReport5.logInfo = sb24;
                                            QDLog.w(QDLog.TAG_DOWNLOAD_RESULT, sb24, null);
                                        }
                                        if (!z18) {
                                            this.mShouldReport = false;
                                        }
                                        DownloadResult.Status status4 = downloadResult.getStatus();
                                        StringBuilder sb25 = new StringBuilder();
                                        sb25.append(getUrl());
                                        sb25.append(" sip=");
                                        sb25.append(str41);
                                        sb25.append(", client=");
                                        sb25.append(downloadResult.getContent().clientip);
                                        sb25.append(", ipType=");
                                        DownloadGlobalStrategy.StrategyInfo strategyInfo4 = this.pCurrStrategyInfo;
                                        sb25.append(strategyInfo4 != null ? strategyInfo4.f99899id : 0);
                                        sb25.append(", httpStatus=");
                                        sb25.append(i16);
                                        sb25.append(str37);
                                        sb25.append(downloadResult.getContent().type);
                                        sb25.append(str42);
                                        int i29 = i16;
                                        sb25.append(downloadResult.getContent().length);
                                        sb25.append(str39);
                                        sb25.append(downloadResult.getContent().size);
                                        sb25.append(str12);
                                        sb25.append(downloadResult.getProcess().duration);
                                        str31 = str40;
                                        sb25.append(str31);
                                        String str169 = str42;
                                        str11 = str39;
                                        sb25.append(SystemClock.uptimeMillis() - this.mTimeStamp);
                                        sb25.append(TextUtils.isEmpty(str43) ? "" : str36 + str43);
                                        sb25.append(str9);
                                        sb25.append(str44);
                                        status4.detailDownloadInfo = sb25.toString();
                                        if (z18) {
                                            DownloadGlobalStrategy downloadGlobalStrategy4 = DownloadGlobalStrategy.getInstance(this.mContext);
                                            String url9 = getUrl();
                                            if (!this.mIsHttp2 || str38 == null) {
                                                str45 = str38;
                                            } else {
                                                str45 = str38;
                                                if (str45.startsWith("https")) {
                                                    z19 = true;
                                                    downloadGlobalStrategy4.reportHttps(url9, z19, downloadResult.getStatus().isSucceed());
                                                }
                                            }
                                            z19 = false;
                                            downloadGlobalStrategy4.reportHttps(url9, z19, downloadResult.getStatus().isSucceed());
                                        } else {
                                            str45 = str38;
                                        }
                                        downloadReport5.endTime = System.currentTimeMillis();
                                        downloadReport5.fileSize = getContentLength();
                                        downloadReport5.okResponse = response;
                                        downloadReport5.httpStatus = i29;
                                        downloadReport5.exception = th5;
                                        downloadReport5.dns = dns2 == null ? null : dns2.toString();
                                        downloadReport5.localAddress = null;
                                        downloadReport5.clientip = downloadResult.getContent().clientip;
                                        str114 = str169;
                                        downloadReport5.totaltime = SystemClock.uptimeMillis() - this.mTimeStamp;
                                        downloadReport5.downloadTime = downloadResult.getProcess().duration;
                                        downloadReport5.t_wait = downloadReport5.totaltime - downloadResult.getProcess().duration;
                                        long j96 = j16;
                                        downloadReport5.t_prepare = j96;
                                        downloadReport5.t_conn = j752222222;
                                        downloadReport5.t_recvrsp = j29;
                                        downloadReport5.t_recvdata = this.t_recv_data;
                                        downloadReport5.t_process = 0L;
                                        downloadReport5.concurrent = getTaskConcurrentCount();
                                        downloadReport5.content_type = downloadResult.getContent().type;
                                        downloadReport5.isFromQzoneAlbum = Config.isFromQzoneAlbum(getDomain());
                                        downloadReport5.isHttp2 = this.mIsHttp2;
                                        downloadReport5.isHttps = str45 != null && str45.startsWith("https");
                                        downloadReport5.isSucceed = downloadResult.getStatus().isSucceed();
                                        downloadReport5.downloadMode = Downloader.DownloadMode.OkHttpMode.ordinal();
                                        if (response != null && response.protocol() != null) {
                                            downloadReport5.f99896protocol = response.protocol().getProtocol();
                                        }
                                        j28 = j96;
                                        downloadResult.setReport(downloadReport5);
                                        if (downloadResult.getStatus().isSucceed()) {
                                            handleDownloadReportForTask(jobContext, downloadResult, downloadReport5);
                                        }
                                    } else {
                                        str31 = str5;
                                        j28 = j16;
                                        str32 = str;
                                        str33 = str15;
                                        str34 = str4;
                                        str35 = str13;
                                        str36 = str8;
                                        str37 = str7;
                                    }
                                    if (canAttempt()) {
                                    }
                                }
                            } else {
                                j58 = j49;
                                str73 = str100;
                                str75 = str63;
                                str76 = str115;
                                j59 = j48;
                                j65 = j38;
                                str77 = str58;
                                str78 = str57;
                                str79 = str59;
                                str80 = str60;
                                response2 = response3;
                                str81 = str62;
                                try {
                                    str74 = str109;
                                    try {
                                        downloadResult.getStatus().setFailed(3);
                                        i26 = 0;
                                    } catch (Throwable th23) {
                                        th = th23;
                                        str13 = str61;
                                        str7 = str81;
                                        str115 = str76;
                                        str3 = str101;
                                        str4 = str102;
                                        str6 = str103;
                                        str2 = str73;
                                        str = str75;
                                        str5 = str74;
                                        str15 = str112;
                                        j37 = j59;
                                        str9 = str77;
                                        str8 = str78;
                                        str10 = str79;
                                        str12 = str80;
                                        str14 = str104;
                                        downloadReport = downloadReport9;
                                        j3 = j58;
                                        str11 = str111;
                                        j18 = j65;
                                        j16 = j37;
                                        response = response2;
                                        j17 = j18;
                                        i16 = 0;
                                        StringBuilder sb522222222 = new StringBuilder();
                                        downloadReport4 = downloadReport;
                                        sb522222222.append("download ");
                                        sb522222222.append(getUrl());
                                        sb522222222.append(" exception:");
                                        QDLog.e(QDLog.TAG_DOWNLOAD_OKHTTP, sb522222222.toString(), th);
                                        downloadResult.getStatus().setFailed(th);
                                        downloadResult.getProcess().setDuration(j3, SystemClock.uptimeMillis());
                                        downloadResult.getProcess().totalDuration = SystemClock.uptimeMillis() - this.mTimeStamp;
                                        downloadResult.getProcess().startTimestamp = this.mTaskStartTimeStamp;
                                        NetworkUtils.DNS dns522222222 = NetworkStatus.getInstance(this.mContext).getDNS();
                                        String str11722222222 = this.mRemoteAddress;
                                        String parserHttpHeaderInfo32222222 = parserHttpHeaderInfo(null, null, response);
                                        long j6922222222 = j18;
                                        long j7522222222 = j17;
                                        long j7622222222 = this.mDnsEnd - this.mDnsStart;
                                        if (response != null) {
                                        }
                                        downloadResult.getContent().redirectUrl = header5;
                                        String url222222222 = getUrl();
                                        if (jobContext.isCancelled()) {
                                        }
                                        if (canAttempt()) {
                                        }
                                    }
                                } catch (Throwable th24) {
                                    th = th24;
                                    str13 = str61;
                                    str7 = str81;
                                    str115 = str76;
                                    str3 = str101;
                                    str4 = str102;
                                    str5 = str109;
                                    str6 = str103;
                                    str14 = str104;
                                    str2 = str73;
                                    str = str75;
                                    str15 = str112;
                                    j37 = j59;
                                    str9 = str77;
                                    str8 = str78;
                                    str10 = str79;
                                    j3 = j58;
                                    str12 = str80;
                                    downloadReport = downloadReport9;
                                    j18 = j65;
                                    str11 = str111;
                                }
                            }
                            str115 = str76;
                            String str170 = str80;
                            downloadResult.getProcess().setDuration(j58, SystemClock.uptimeMillis());
                            String str171 = str61;
                            String str172 = str81;
                            downloadResult.getProcess().totalDuration = SystemClock.uptimeMillis() - this.mTimeStamp;
                            downloadResult.getProcess().startTimestamp = this.mTaskStartTimeStamp;
                            NetworkUtils.DNS dns9 = NetworkStatus.getInstance(this.mContext).getDNS();
                            String str173 = this.mRemoteAddress;
                            String parserHttpHeaderInfo6 = parserHttpHeaderInfo(null, null, response2);
                            long j97 = this.mDnsEnd - this.mDnsStart;
                            String header6 = (response2 != null || response2.priorResponse() == null) ? null : response2.priorResponse().header("Location");
                            downloadResult.getContent().redirectUrl = header6;
                            String url10 = getUrl();
                            if (jobContext.isCancelled()) {
                                boolean isNetworkAvailable5 = NetworkUtils.isNetworkAvailable(this.mContext);
                                if (!downloadResult.getStatus().isSucceed()) {
                                    StringBuilder sb26 = new StringBuilder();
                                    sb26.append("Downloader, fail to download:");
                                    sb26.append(getUrl());
                                    sb26.append(str104);
                                    sb26.append(this.mIsHttp2);
                                    sb26.append(str103);
                                    sb26.append((!this.mIsHttp2 || response2 == null || response2.protocol() == null) ? "http1.1" : response2.protocol().getProtocol());
                                    sb26.append(str102);
                                    sb26.append(dns9);
                                    sb26.append(str101);
                                    sb26.append(str173);
                                    sb26.append(str73);
                                    sb26.append((String) null);
                                    sb26.append(str75);
                                    str2 = str73;
                                    str83 = str75;
                                    sb26.append(Thread.currentThread().getId());
                                    sb26.append(str171);
                                    sb26.append(NetworkManager.getApnValue());
                                    sb26.append(", netAvailable=");
                                    sb26.append(isNetworkAvailable5);
                                    sb26.append(str115);
                                    sb26.append(Config.getNetworkStackType());
                                    sb26.append(str172);
                                    z36 = isNetworkAvailable5;
                                    sb26.append(downloadResult.getContent().type);
                                    sb26.append(str170);
                                    sb26.append(downloadResult.getProcess().duration);
                                    sb26.append(str74);
                                    sb26.append(SystemClock.uptimeMillis() - this.mTimeStamp);
                                    sb26.append(str114);
                                    sb26.append(downloadResult.getContent().length);
                                    sb26.append(str111);
                                    sb26.append(downloadResult.getContent().size);
                                    String str174 = str79;
                                    sb26.append(str174);
                                    str10 = str174;
                                    sb26.append(downloadResult.getContent().realsize);
                                    sb26.append(", retry=(");
                                    sb26.append(getCurrAttemptCount());
                                    String str175 = str112;
                                    sb26.append(str175);
                                    sb26.append(getTotalAttemptCount());
                                    sb26.append("), errorCode=");
                                    sb26.append(downloadResult.getStatus().exception2Code);
                                    sb26.append(", reason=");
                                    sb26.append(downloadResult.getStatus().getFailReason());
                                    sb26.append(", httpStatus=");
                                    sb26.append(i26);
                                    str9 = str77;
                                    sb26.append(str9);
                                    sb26.append(parserHttpHeaderInfo6);
                                    String str176 = str78;
                                    sb26.append(str176);
                                    sb26.append(header6);
                                    String str177 = header6;
                                    sb26.append(", ipUrl:");
                                    sb26.append(getUrl());
                                    sb26.append(", clientip=");
                                    sb26.append(downloadResult.getContent().clientip);
                                    sb26.append(", getIP=");
                                    sb26.append(j97);
                                    sb26.append(", connect:(");
                                    long j98 = j65;
                                    sb26.append(j98);
                                    sb26.append(str175);
                                    sb26.append(0);
                                    sb26.append("), exeReqest:(");
                                    str86 = str171;
                                    String str178 = str101;
                                    sb26.append(0L);
                                    sb26.append(str175);
                                    sb26.append(0);
                                    sb26.append("), sendReq=");
                                    sb26.append(j98);
                                    sb26.append(", recvData=");
                                    sb26.append(this.t_recv_data);
                                    sb26.append(", Concurrent:(");
                                    sb26.append(getTaskConcurrentCount());
                                    sb26.append("), mobileProxy=");
                                    DownloadTask.DownloadTaskHandler downloadTaskHandler9 = this.mDownloadTaskHandler;
                                    sb26.append(downloadTaskHandler9 != null ? downloadTaskHandler9.getCustomProxy() : null);
                                    sb26.append(", isGzip=");
                                    sb26.append(downloadResult.getContent().isGzip);
                                    String sb27 = sb26.toString();
                                    downloadReport8 = downloadReport9;
                                    downloadReport8.logInfo = sb27;
                                    QDLog.e(QDLog.TAG_DOWNLOAD_RESULT, sb27, null);
                                    if (url10 != null) {
                                        QDLog.d(TAG, "OK force dns first is " + Config.isForceDNSFirst());
                                        CustomDnsResolve.setIPDirectEnable(getDomain(), Config.isForceDNSFirst());
                                        handleErrorByCode(getDomain(), downloadResult.getStatus());
                                    }
                                    str3 = str178;
                                    str6 = str103;
                                    str90 = str111;
                                    str12 = str170;
                                    j67 = j98;
                                    dns4 = dns9;
                                    str82 = str102;
                                    str89 = str114;
                                    str92 = str176;
                                    str95 = str74;
                                    str14 = str104;
                                    str91 = str172;
                                    str88 = str175;
                                    response6 = response2;
                                    str93 = str177;
                                    str94 = parserHttpHeaderInfo6;
                                } else {
                                    str2 = str73;
                                    str83 = str75;
                                    String str179 = str112;
                                    str86 = str171;
                                    str9 = str77;
                                    String str180 = str78;
                                    str10 = str79;
                                    String str181 = header6;
                                    z36 = isNetworkAvailable5;
                                    String str182 = str101;
                                    long j99 = j65;
                                    StringBuilder sb28 = new StringBuilder();
                                    sb28.append("Downloader, succeed to download:");
                                    sb28.append(getUrl());
                                    sb28.append(str104);
                                    sb28.append(this.mIsHttp2);
                                    sb28.append(str103);
                                    sb28.append((!this.mIsHttp2 || response2 == null || response2.protocol() == null) ? "http1.1" : response2.protocol().getProtocol());
                                    sb28.append(str102);
                                    sb28.append(dns9);
                                    sb28.append(str182);
                                    sb28.append(str173);
                                    sb28.append(str2);
                                    sb28.append((String) null);
                                    sb28.append(str83);
                                    sb28.append(Thread.currentThread().getId());
                                    sb28.append(str86);
                                    sb28.append(NetworkManager.getApnValue());
                                    sb28.append(str115);
                                    sb28.append(Config.getNetworkStackType());
                                    sb28.append(str170);
                                    str82 = str102;
                                    str3 = str182;
                                    sb28.append(downloadResult.getProcess().duration);
                                    String str183 = str74;
                                    sb28.append(str183);
                                    str6 = str103;
                                    str14 = str104;
                                    sb28.append(SystemClock.uptimeMillis() - this.mTimeStamp);
                                    str89 = str114;
                                    sb28.append(str89);
                                    sb28.append(downloadResult.getContent().length);
                                    str90 = str111;
                                    sb28.append(str90);
                                    sb28.append(downloadResult.getContent().size);
                                    sb28.append(str10);
                                    sb28.append(downloadResult.getContent().realsize);
                                    sb28.append(", retry=(");
                                    sb28.append(getCurrAttemptCount());
                                    sb28.append(str179);
                                    sb28.append(getTotalAttemptCount());
                                    sb28.append("), httpStatus=");
                                    sb28.append(i26);
                                    sb28.append(str9);
                                    sb28.append(parserHttpHeaderInfo6);
                                    str91 = str172;
                                    sb28.append(str91);
                                    dns4 = dns9;
                                    sb28.append(downloadResult.getContent().type);
                                    str92 = str180;
                                    sb28.append(str92);
                                    response6 = response2;
                                    str93 = str181;
                                    sb28.append(str93);
                                    str94 = parserHttpHeaderInfo6;
                                    sb28.append(", ipUrl:");
                                    sb28.append(getUrl());
                                    sb28.append(", clientip=");
                                    sb28.append(downloadResult.getContent().clientip);
                                    sb28.append(", getIP=");
                                    sb28.append(j97);
                                    sb28.append(", connect:(");
                                    j67 = j99;
                                    sb28.append(j67);
                                    sb28.append(str179);
                                    sb28.append(0);
                                    sb28.append("), exeReqest:(");
                                    str95 = str183;
                                    str12 = str170;
                                    sb28.append(0L);
                                    sb28.append(str179);
                                    sb28.append(0);
                                    sb28.append("), sendReq=");
                                    sb28.append(j67);
                                    sb28.append(", recvData=");
                                    sb28.append(this.t_recv_data);
                                    sb28.append(", Concurrent:(");
                                    sb28.append(getTaskConcurrentCount());
                                    sb28.append("), mobileProxy=");
                                    DownloadTask.DownloadTaskHandler downloadTaskHandler10 = this.mDownloadTaskHandler;
                                    sb28.append(downloadTaskHandler10 != null ? downloadTaskHandler10.getCustomProxy() : null);
                                    sb28.append(", isGzip=");
                                    sb28.append(downloadResult.getContent().isGzip);
                                    String sb29 = sb28.toString();
                                    downloadReport8 = downloadReport9;
                                    downloadReport8.logInfo = sb29;
                                    str88 = str179;
                                    QDLog.w(QDLog.TAG_DOWNLOAD_RESULT, sb29, null);
                                }
                                if (!z36) {
                                    this.mShouldReport = false;
                                }
                                DownloadResult.Status status5 = downloadResult.getStatus();
                                StringBuilder sb30 = new StringBuilder();
                                sb30.append(getUrl());
                                sb30.append(" sip=");
                                sb30.append(str173);
                                sb30.append(", client=");
                                sb30.append(downloadResult.getContent().clientip);
                                sb30.append(", ipType=");
                                DownloadGlobalStrategy.StrategyInfo strategyInfo5 = this.pCurrStrategyInfo;
                                sb30.append(strategyInfo5 != null ? strategyInfo5.f99899id : 0);
                                sb30.append(", httpStatus=");
                                sb30.append(i26);
                                sb30.append(str91);
                                sb30.append(downloadResult.getContent().type);
                                sb30.append(str89);
                                str85 = str91;
                                sb30.append(downloadResult.getContent().length);
                                sb30.append(str90);
                                sb30.append(downloadResult.getContent().size);
                                sb30.append(str12);
                                sb30.append(downloadResult.getProcess().duration);
                                String str184 = str95;
                                sb30.append(str184);
                                str114 = str89;
                                str11 = str90;
                                sb30.append(SystemClock.uptimeMillis() - this.mTimeStamp);
                                sb30.append(TextUtils.isEmpty(str93) ? "" : str92 + str93);
                                sb30.append(str9);
                                sb30.append(str94);
                                status5.detailDownloadInfo = sb30.toString();
                                if (z36) {
                                    DownloadGlobalStrategy downloadGlobalStrategy5 = DownloadGlobalStrategy.getInstance(this.mContext);
                                    String url11 = getUrl();
                                    if (!this.mIsHttp2 || url10 == null) {
                                        str96 = url10;
                                    } else {
                                        str96 = url10;
                                        if (str96.startsWith("https")) {
                                            z37 = true;
                                            downloadGlobalStrategy5.reportHttps(url11, z37, downloadResult.getStatus().isSucceed());
                                        }
                                    }
                                    z37 = false;
                                    downloadGlobalStrategy5.reportHttps(url11, z37, downloadResult.getStatus().isSucceed());
                                } else {
                                    str96 = url10;
                                }
                                downloadReport8.endTime = System.currentTimeMillis();
                                downloadReport8.fileSize = getContentLength();
                                Response response9 = response6;
                                downloadReport8.okResponse = response9;
                                downloadReport8.httpStatus = i26;
                                downloadReport8.exception = null;
                                downloadReport8.dns = dns4 == null ? null : dns4.toString();
                                downloadReport8.localAddress = null;
                                downloadReport8.clientip = downloadResult.getContent().clientip;
                                str87 = str92;
                                str84 = str184;
                                downloadReport8.totaltime = SystemClock.uptimeMillis() - this.mTimeStamp;
                                downloadReport8.downloadTime = downloadResult.getProcess().duration;
                                downloadReport8.t_wait = downloadReport8.totaltime - downloadResult.getProcess().duration;
                                j66 = j59;
                                downloadReport8.t_prepare = j66;
                                downloadReport8.t_conn = j67;
                                downloadReport8.t_recvrsp = j67;
                                downloadReport8.t_recvdata = this.t_recv_data;
                                downloadReport8.t_process = 0L;
                                downloadReport8.concurrent = getTaskConcurrentCount();
                                downloadReport8.content_type = downloadResult.getContent().type;
                                downloadReport8.isFromQzoneAlbum = Config.isFromQzoneAlbum(getDomain());
                                downloadReport8.isHttp2 = this.mIsHttp2;
                                downloadReport8.isHttps = str96 != null && str96.startsWith("https");
                                downloadReport8.isSucceed = downloadResult.getStatus().isSucceed();
                                downloadReport8.downloadMode = Downloader.DownloadMode.OkHttpMode.ordinal();
                                if (response9 != null && response9.protocol() != null) {
                                    downloadReport8.f99896protocol = response9.protocol().getProtocol();
                                }
                                downloadResult2 = downloadResult;
                                downloadResult2.setReport(downloadReport8);
                                jobContext2 = jobContext;
                                if (downloadResult.getStatus().isSucceed()) {
                                    handleDownloadReportForTask(jobContext2, downloadResult2, downloadReport8);
                                }
                            } else {
                                str3 = str101;
                                str82 = str102;
                                str6 = str103;
                                str2 = str73;
                                str83 = str75;
                                str84 = str74;
                                str85 = str172;
                                str11 = str111;
                                str12 = str170;
                                str86 = str171;
                                j66 = j59;
                                str9 = str77;
                                str87 = str78;
                                str10 = str79;
                                jobContext2 = jobContext;
                                downloadResult2 = downloadResult;
                                str14 = str104;
                                str88 = str112;
                            }
                            str32 = str83;
                            str33 = str88;
                            str34 = str82;
                            str35 = str86;
                            str36 = str87;
                            str37 = str85;
                            long j100 = j66;
                            str31 = str84;
                            j28 = j100;
                        } catch (Throwable th25) {
                            th = th25;
                            str13 = str61;
                            str2 = str100;
                            str3 = str101;
                            str4 = str102;
                            str6 = str103;
                            str14 = str104;
                            str = str63;
                            str7 = str62;
                            downloadReport = downloadReport9;
                            j16 = j48;
                            str9 = str58;
                            str8 = str57;
                            str10 = str59;
                            i16 = 0;
                            str12 = str60;
                            j3 = j49;
                            str5 = str109;
                            str11 = str111;
                            str15 = str112;
                            j18 = j38;
                            response = response3;
                            j17 = j18;
                            StringBuilder sb5222222222 = new StringBuilder();
                            downloadReport4 = downloadReport;
                            sb5222222222.append("download ");
                            sb5222222222.append(getUrl());
                            sb5222222222.append(" exception:");
                            QDLog.e(QDLog.TAG_DOWNLOAD_OKHTTP, sb5222222222.toString(), th);
                            downloadResult.getStatus().setFailed(th);
                            downloadResult.getProcess().setDuration(j3, SystemClock.uptimeMillis());
                            downloadResult.getProcess().totalDuration = SystemClock.uptimeMillis() - this.mTimeStamp;
                            downloadResult.getProcess().startTimestamp = this.mTaskStartTimeStamp;
                            NetworkUtils.DNS dns5222222222 = NetworkStatus.getInstance(this.mContext).getDNS();
                            String str117222222222 = this.mRemoteAddress;
                            String parserHttpHeaderInfo322222222 = parserHttpHeaderInfo(null, null, response);
                            long j69222222222 = j18;
                            long j75222222222 = j17;
                            long j76222222222 = this.mDnsEnd - this.mDnsStart;
                            if (response != null) {
                            }
                            downloadResult.getContent().redirectUrl = header5;
                            String url2222222222 = getUrl();
                            if (jobContext.isCancelled()) {
                            }
                            if (canAttempt()) {
                            }
                        }
                        if (canAttempt()) {
                            return;
                        }
                        str109 = str31;
                        str108 = str9;
                        str104 = str14;
                        str112 = str33;
                        str107 = str114;
                        str100 = str2;
                        str111 = str11;
                        generateRandomId = i3;
                        str101 = str3;
                        str110 = str10;
                        str105 = str37;
                        j68 = j28;
                        str106 = str36;
                        str102 = str34;
                        str97 = str115;
                        str98 = str35;
                        str99 = str32;
                        str113 = str12;
                        str103 = str6;
                    }
                }
            }
            j38 = j18;
            str57 = str106;
            str58 = str108;
            str59 = str110;
            j48 = j36;
            str63 = str99;
            j49 = uptimeMillis2;
            response3 = execute;
            str60 = str113;
            str62 = str46;
            str61 = str116;
            j56 = 0;
            downloadResult.getContent().size = j56;
            downloadResult.getContent().realsize = j56;
            if (response3 == null) {
            }
            str115 = str76;
            String str1702 = str80;
            downloadResult.getProcess().setDuration(j58, SystemClock.uptimeMillis());
            String str1712 = str61;
            String str1722 = str81;
            downloadResult.getProcess().totalDuration = SystemClock.uptimeMillis() - this.mTimeStamp;
            downloadResult.getProcess().startTimestamp = this.mTaskStartTimeStamp;
            NetworkUtils.DNS dns92 = NetworkStatus.getInstance(this.mContext).getDNS();
            String str1732 = this.mRemoteAddress;
            String parserHttpHeaderInfo62 = parserHttpHeaderInfo(null, null, response2);
            long j972 = this.mDnsEnd - this.mDnsStart;
            if (response2 != null) {
            }
            downloadResult.getContent().redirectUrl = header6;
            String url102 = getUrl();
            if (jobContext.isCancelled()) {
            }
            str32 = str83;
            str33 = str88;
            str34 = str82;
            str35 = str86;
            str36 = str87;
            str37 = str85;
            long j1002 = j66;
            str31 = str84;
            j28 = j1002;
            if (canAttempt()) {
            }
        }
    }
}
