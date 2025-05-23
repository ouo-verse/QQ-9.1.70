package com.tencent.component.network.downloader.impl;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.component.network.NetworkManager;
import com.tencent.component.network.downloader.DownloadReport;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.component.network.downloader.common.IPInfo;
import com.tencent.component.network.downloader.common.Utils;
import com.tencent.component.network.downloader.impl.DownloadTask;
import com.tencent.component.network.downloader.strategy.DownloadGlobalStrategy;
import com.tencent.component.network.downloader.strategy.IPStrategy;
import com.tencent.component.network.downloader.strategy.PortConfigStrategy;
import com.tencent.component.network.downloader.strategy.ResumeTransfer;
import com.tencent.component.network.module.base.Config;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.module.common.DnsService;
import com.tencent.component.network.module.common.NetworkStatus;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.component.network.utils.http.HttpUtil;
import com.tencent.component.network.utils.http.base.QZoneHttpClient;
import com.tencent.component.network.utils.thread.ThreadPool;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import cooperation.qzone.util.WiFiDash;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Call;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.http.Header;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.protocol.HttpContext;
import org.java_websocket.WebSocketImpl;

/* compiled from: P */
/* loaded from: classes5.dex */
public class StrictDownloadTask extends DownloadTask {
    private static final Object Extra_Lock = new Object();
    private static final int TIMEOUT_NO_NETWORK = 150000;
    private static List<DownloadGlobalStrategy.StrategyInfo> extraStrategys;
    private int ISP_COUNT;
    int connect_retry;
    long connect_time;
    int exe_retry;
    long exe_time;
    private boolean mAPNProxy;
    private boolean mAllowProxy;
    private String mDomainWithPort;
    private int mOrigPort;
    private String mRealUrl;
    private final long mTimeStamp;
    Response okResponse;
    HttpResponse response;
    long send_req_time;
    private int[] triedIsp;

    public StrictDownloadTask(Context context, OkHttpClient okHttpClient, QZoneHttpClient qZoneHttpClient, String str, String str2, boolean z16, boolean z17) {
        super(context, okHttpClient, qZoneHttpClient, str, str2, z16, z17);
        this.mOrigPort = 0;
        this.mTimeStamp = SystemClock.uptimeMillis();
        this.ISP_COUNT = 4;
        this.triedIsp = new int[4];
        this.okResponse = null;
        this.response = null;
        this.connect_time = 0L;
        this.connect_retry = 0;
        this.exe_time = 0L;
        this.exe_retry = 0;
        this.send_req_time = 0L;
    }

    private void addTriedIsp(int i3) {
        if (i3 > 0 && i3 <= this.ISP_COUNT) {
            this.triedIsp[i3 - 1] = 1;
        }
    }

    private String generateDownloadDescInfo(int i3, int i16, int i17, String str, String str2, String str3, String str4) {
        return "{1.1," + i3 + "," + i16 + "," + i17 + "," + str + "," + str2 + "," + str3 + "," + str4 + "," + NetworkManager.getIspType() + "," + NetworkUtils.isNetworkAvailable(this.mContext) + "}";
    }

    private void initExtraStrategy() {
        if (extraStrategys == null) {
            synchronized (Extra_Lock) {
                if (extraStrategys == null) {
                    extraStrategys = new ArrayList();
                    DownloadGlobalStrategy.StrategyInfo strategyInfo = new DownloadGlobalStrategy.StrategyInfo(6, false, false, false, true);
                    strategyInfo.f99899id = 6;
                    DownloadGlobalStrategy.StrategyInfo strategyInfo2 = new DownloadGlobalStrategy.StrategyInfo(7, false, false, false, true);
                    strategyInfo2.f99899id = 7;
                    DownloadGlobalStrategy.StrategyInfo strategyInfo3 = new DownloadGlobalStrategy.StrategyInfo(8, false, false, false, true);
                    strategyInfo3.f99899id = 8;
                    DownloadGlobalStrategy.StrategyInfo strategyInfo4 = new DownloadGlobalStrategy.StrategyInfo(9, false, false, false, true);
                    strategyInfo4.f99899id = 9;
                    extraStrategys.add(strategyInfo);
                    extraStrategys.add(strategyInfo2);
                    extraStrategys.add(strategyInfo3);
                    extraStrategys.add(strategyInfo4);
                }
            }
        }
    }

    private int obtainUntriedIsp() {
        for (int i3 = 0; i3 < this.ISP_COUNT; i3++) {
            int[] iArr = this.triedIsp;
            if (iArr[i3] == 0) {
                iArr[i3] = 1;
                return i3 + 1;
            }
        }
        return 0;
    }

    private void printfHttpDetail(HttpRequest httpRequest, Request.Builder builder, HttpResponse httpResponse, Response response) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\n/****************************************************/\n");
        stringBuffer.append("<---------Request Content--------->\n");
        int i3 = 0;
        if (httpRequest != null) {
            stringBuffer.append(httpRequest.getRequestLine());
            stringBuffer.append("\n");
            Header[] allHeaders = httpRequest.getAllHeaders();
            if (allHeaders != null) {
                for (int i16 = 0; i16 < allHeaders.length; i16++) {
                    stringBuffer.append(allHeaders[i16].getName());
                    stringBuffer.append(MsgSummary.STR_COLON);
                    stringBuffer.append(allHeaders[i16].getValue());
                    stringBuffer.append("\n");
                }
            }
        } else if (builder != null) {
            stringBuffer.append(builder.build().url());
            stringBuffer.append("\n");
            Headers headers = builder.build().headers();
            if (headers != null) {
                for (int i17 = 0; i17 < headers.size(); i17++) {
                    stringBuffer.append(headers.name(i17));
                    stringBuffer.append(MsgSummary.STR_COLON);
                    stringBuffer.append(headers.value(i17));
                    stringBuffer.append("\n");
                }
            }
        }
        stringBuffer.append("<---------Response Headers--------->\n");
        if (httpResponse != null) {
            stringBuffer.append(httpResponse.getStatusLine());
            stringBuffer.append("\n");
            Header[] allHeaders2 = httpResponse.getAllHeaders();
            if (allHeaders2 != null) {
                while (i3 < allHeaders2.length) {
                    stringBuffer.append(allHeaders2[i3].getName());
                    stringBuffer.append(MsgSummary.STR_COLON);
                    stringBuffer.append(allHeaders2[i3].getValue());
                    stringBuffer.append("\n");
                    i3++;
                }
            }
        } else if (response != null) {
            stringBuffer.append(response.code());
            stringBuffer.append("\n");
            Headers headers2 = response.headers();
            if (headers2 != null) {
                while (i3 < headers2.size()) {
                    stringBuffer.append(headers2.name(i3));
                    stringBuffer.append(MsgSummary.STR_COLON);
                    stringBuffer.append(headers2.value(i3));
                    stringBuffer.append("\n");
                    i3++;
                }
            }
        }
        stringBuffer.append("/****************************************************/");
        QDLog.w(QDLog.TAG_DOWNLOAD, "Http Details:" + stringBuffer.toString());
    }

    private boolean setStrategy(int i3) throws Exception {
        int i16;
        boolean z16;
        boolean z17;
        DownloadGlobalStrategy.StrategyInfo strategyInfo;
        DownloadGlobalStrategy.StrategyInfo strategyInfo2;
        if (this.pDownloadStrategyLib == null) {
            this.pDownloadStrategyLib = DownloadGlobalStrategy.getInstance(this.mContext).getStrategyLib(getUrl(), getDomain(), this.mIsHttp2);
            initExtraStrategy();
            this.pDownloadStrategyLib.copyStrageList();
            this.pDownloadStrategyLib.enableUpdate(false);
            this.pDownloadStrategyLib.addStrategy(extraStrategys);
        }
        this.pOldStrategyInfo = this.pCurrStrategyInfo;
        if (this.pDownloadStrategyLib.getStrategyList() != null) {
            i16 = this.pDownloadStrategyLib.getStrategyList().size();
        } else {
            i16 = 0;
        }
        if (i16 == 0) {
            return false;
        }
        this.pCurrStrategyInfo = this.pDownloadStrategyLib.getStrategyInfo(this.attemptStrategyCount % i16);
        while (true) {
            z16 = this.mIsHttp2;
            if (!z16 || (strategyInfo = this.pCurrStrategyInfo) == null || (strategyInfo2 = this.pOldStrategyInfo) == null || strategyInfo.f99899id != strategyInfo2.f99899id) {
                break;
            }
            int i17 = this.attemptStrategyCount + 1;
            this.attemptStrategyCount = i17;
            this.pCurrStrategyInfo = this.pDownloadStrategyLib.getStrategyInfo(i17 % i16);
        }
        int i18 = this.attemptStrategyCount + 1;
        this.attemptStrategyCount = i18;
        int i19 = 80;
        if (z16 && i18 > i16) {
            this.mIsHttp2 = false;
            this.pDownloadStrategyLib.setPort(80);
            this.mAttemptCurrCount = 0;
        }
        if (this.mIsHttp2) {
            i19 = WebSocketImpl.DEFAULT_WSS_PORT;
        }
        this.mStandardPort = i19;
        this.pDownloadStrategyLib.setPort(i19);
        if (QDLog.isInfoEnable()) {
            QDLog.i("downloader_strategy", "downloader strategy: " + this.pCurrStrategyInfo.toString() + " currAttempCount:" + i3 + " attemptStrategyCount:" + this.attemptStrategyCount + " best:" + this.pDownloadStrategyLib.getBestId() + " url:" + getUrl() + " Apn:" + NetworkManager.getApnValue() + " ISP:" + NetworkManager.getIspType() + " threadid:" + Thread.currentThread().getId());
        }
        DownloadGlobalStrategy.StrategyInfo strategyInfo3 = this.pCurrStrategyInfo;
        this.mAllowProxy = strategyInfo3.allowProxy;
        this.mAPNProxy = strategyInfo3.useConfigApn;
        String domain = getDomain();
        int port = this.pDownloadStrategyLib.getPort();
        if (!Utils.isPortValid(port)) {
            this.pDownloadStrategyLib.setPort(this.mStandardPort);
            port = this.mStandardPort;
        }
        int i26 = DownloadGlobalStrategy.Strategy_BACKUPIP.f99899id;
        int i27 = this.pCurrStrategyInfo.f99899id;
        String str = null;
        if (i26 == i27) {
            DownloadGlobalStrategy.StrategyInfo strategyInfo4 = this.pOldStrategyInfo;
            if (strategyInfo4 != null && i26 == strategyInfo4.f99899id && !this.mIsHttp2) {
                PortConfigStrategy portConfigStrategy = this.pPortConfigStrategy;
                if (portConfigStrategy != null && portConfigStrategy.supportExtraPort(domain)) {
                    int changePort = this.pPortConfigStrategy.changePort(domain, port);
                    if (changePort != port && Utils.isPortValid(changePort)) {
                        port = changePort;
                    } else {
                        if (QDLog.isInfoEnable()) {
                            QDLog.i(QDLog.TAG_DOWNLOAD, "downloader strategy: Pass! port:" + port + " newport:" + changePort + " threadId:" + Thread.currentThread().getId());
                        }
                        return false;
                    }
                } else {
                    if (QDLog.isInfoEnable()) {
                        QDLog.i(QDLog.TAG_DOWNLOAD, "downloader strategy: Pass! Not support !" + this.mStandardPort + ". threadId:" + Thread.currentThread().getId());
                    }
                    return false;
                }
            }
            String backupIP = this.pDownloadStrategyLib.getBackupIP();
            IPStrategy iPStrategy = this.pBackupIPConfigStrategy;
            if (iPStrategy != null && !iPStrategy.isIPValid(domain, backupIP)) {
                this.pDownloadStrategyLib.setBackupIP(null);
                backupIP = this.pBackupIPConfigStrategy.resolveIP(domain);
                if (!TextUtils.isEmpty(backupIP)) {
                    this.pDownloadStrategyLib.setBackupIP(backupIP);
                } else {
                    if (QDLog.isInfoEnable()) {
                        QDLog.i(QDLog.TAG_DOWNLOAD, "downloader strategy: backup ip is null. Pass! threadId:" + Thread.currentThread().getId());
                    }
                    return false;
                }
            }
            DownloadGlobalStrategy.StrategyInfo m107clone = this.pCurrStrategyInfo.m107clone();
            this.pCurrStrategyInfo = m107clone;
            m107clone.setIPInfo(new IPInfo(backupIP, port));
        } else {
            int i28 = DownloadGlobalStrategy.Strategy_DOMAIN_FORCE.f99899id;
            if (i28 == i27) {
                DownloadGlobalStrategy.StrategyInfo strategyInfo5 = this.pOldStrategyInfo;
                if (strategyInfo5 != null && i28 == strategyInfo5.f99899id && !this.mIsHttp2) {
                    PortConfigStrategy portConfigStrategy2 = this.pPortConfigStrategy;
                    if (portConfigStrategy2 != null && portConfigStrategy2.supportExtraPort(domain)) {
                        int changePort2 = this.pPortConfigStrategy.changePort(domain, port);
                        if (changePort2 != port && Utils.isPortValid(changePort2)) {
                            port = changePort2;
                        } else {
                            if (QDLog.isInfoEnable()) {
                                QDLog.i(QDLog.TAG_DOWNLOAD, "downloader strategy: Pass! port:" + port + " newport:" + changePort2 + " threadId:" + Thread.currentThread().getId());
                            }
                            return false;
                        }
                    } else {
                        if (QDLog.isInfoEnable()) {
                            QDLog.i(QDLog.TAG_DOWNLOAD, "downloader strategy: Pass! Not support !" + this.mStandardPort + ". threadId:" + Thread.currentThread().getId());
                        }
                        return false;
                    }
                }
                String domainIP = DnsService.getInstance().getDomainIP(domain);
                if (TextUtils.isEmpty(domainIP)) {
                    domainIP = DnsService.getInstance().getDomainIP(domain);
                }
                if (domainIP != null && !domainIP.equals(this.pDownloadStrategyLib.getBackupIP()) && !domainIP.equals(this.pDownloadStrategyLib.getDirectIP())) {
                    this.pDownloadStrategyLib.setDnsIP(domainIP);
                    DownloadGlobalStrategy.StrategyInfo m107clone2 = this.pCurrStrategyInfo.m107clone();
                    this.pCurrStrategyInfo = m107clone2;
                    m107clone2.setIPInfo(new IPInfo(domainIP, port));
                } else {
                    this.pDownloadStrategyLib.setDnsIP(null);
                    if (QDLog.isInfoEnable()) {
                        QDLog.i(QDLog.TAG_DOWNLOAD, "downloader strategy: Pass! Domain IP \u91cd\u590d. threadId:" + Thread.currentThread().getId());
                    }
                    return false;
                }
            } else if (6 == i27) {
                IPStrategy iPStrategy2 = this.pDirectIPConfigStrategy;
                if (iPStrategy2 != null) {
                    str = iPStrategy2.resolveIP(domain);
                    if (TextUtils.isEmpty(str)) {
                        str = DnsService.getInstance().getDomainIP(domain);
                    }
                }
                if (str == null) {
                    if (QDLog.isInfoEnable()) {
                        QDLog.i(QDLog.TAG_DOWNLOAD, "downloader strategy: direct ip is null. Pass! 6 threadId:" + Thread.currentThread().getId());
                    }
                    return false;
                }
                DownloadGlobalStrategy.StrategyInfo m107clone3 = this.pCurrStrategyInfo.m107clone();
                this.pCurrStrategyInfo = m107clone3;
                m107clone3.setIPInfo(new IPInfo(str, this.mStandardPort));
            } else if (7 == i27) {
                IPStrategy iPStrategy3 = this.pBackupIPConfigStrategy;
                if (iPStrategy3 != null) {
                    str = iPStrategy3.resolveIP(domain);
                    if (TextUtils.isEmpty(str)) {
                        str = DnsService.getInstance().getDomainIP(domain);
                    }
                }
                if (str == null) {
                    if (QDLog.isInfoEnable()) {
                        QDLog.i(QDLog.TAG_DOWNLOAD, "downloader strategy: backup ip is null. Pass! 7 threadId:" + Thread.currentThread().getId());
                    }
                    return false;
                }
                DownloadGlobalStrategy.StrategyInfo m107clone4 = this.pCurrStrategyInfo.m107clone();
                this.pCurrStrategyInfo = m107clone4;
                m107clone4.setIPInfo(new IPInfo(str, this.mStandardPort));
            } else {
                if (8 != i27) {
                    if (9 != i27) {
                        int i29 = DownloadGlobalStrategy.Strategy_DomainDirect.f99899id;
                        if (i29 == i27) {
                            DownloadGlobalStrategy.StrategyInfo strategyInfo6 = this.pOldStrategyInfo;
                            if (strategyInfo6 != null && i29 == strategyInfo6.f99899id && !this.mIsHttp2) {
                                PortConfigStrategy portConfigStrategy3 = this.pPortConfigStrategy;
                                if (portConfigStrategy3 != null && portConfigStrategy3.supportExtraPort(domain)) {
                                    int changePort3 = this.pPortConfigStrategy.changePort(domain, port);
                                    if (changePort3 != port && Utils.isPortValid(changePort3)) {
                                        port = changePort3;
                                    } else {
                                        if (QDLog.isInfoEnable()) {
                                            QDLog.i(QDLog.TAG_DOWNLOAD, "downloader strategy: Pass! port:" + port + " newport:" + changePort3 + " threadId:" + Thread.currentThread().getId());
                                        }
                                        return false;
                                    }
                                } else {
                                    if (QDLog.isInfoEnable()) {
                                        QDLog.i(QDLog.TAG_DOWNLOAD, "downloader strategy: Pass! Not support !" + this.mStandardPort + ". threadId:" + Thread.currentThread().getId());
                                    }
                                    return false;
                                }
                            }
                        } else if (DownloadGlobalStrategy.Strategy_DomainProxy_SYS.f99899id == i27 || DownloadGlobalStrategy.Strategy_DomainProxy_CON.f99899id == i27) {
                            Context context = this.mContext;
                            if (DownloadGlobalStrategy.Strategy_DomainProxy_CON.f99899id == i27) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            if (NetworkUtils.getProxy(context, z17) != null) {
                                return true;
                            }
                            if (QDLog.isInfoEnable()) {
                                QDLog.i(QDLog.TAG_DOWNLOAD, "downloader strategy: proxy is null. Pass! threadId:" + Thread.currentThread().getId());
                            }
                            return false;
                        }
                        String directIP = this.pDownloadStrategyLib.getDirectIP();
                        IPStrategy iPStrategy4 = this.pDirectIPConfigStrategy;
                        if (iPStrategy4 != null && !iPStrategy4.isIPValid(directIP, domain)) {
                            this.pDownloadStrategyLib.setDirectIP(null);
                            directIP = this.pDirectIPConfigStrategy.resolveIP(domain);
                            if (!TextUtils.isEmpty(directIP)) {
                                this.pDownloadStrategyLib.setDirectIP(directIP);
                            } else {
                                if (QDLog.isInfoEnable()) {
                                    QDLog.i(QDLog.TAG_DOWNLOAD, "downloader strategy: direct ip is null. Pass! threadId:" + Thread.currentThread().getId());
                                }
                                return false;
                            }
                        }
                        if (directIP != null && !directIP.equals(this.pDownloadStrategyLib.getBackupIP()) && !directIP.equals(this.pDownloadStrategyLib.getDnsIP())) {
                            DownloadGlobalStrategy.StrategyInfo m107clone5 = this.pCurrStrategyInfo.m107clone();
                            this.pCurrStrategyInfo = m107clone5;
                            m107clone5.setIPInfo(new IPInfo(directIP, port));
                        } else {
                            if (QDLog.isInfoEnable()) {
                                QDLog.i(QDLog.TAG_DOWNLOAD, "downloader strategy: Pass! Direct IP \u91cd\u590d. threadId:" + Thread.currentThread().getId());
                            }
                            return false;
                        }
                    }
                    do {
                        int obtainUntriedIsp = obtainUntriedIsp();
                        if (obtainUntriedIsp == 0) {
                            break;
                        }
                        IPStrategy iPStrategy5 = this.pDirectIPConfigStrategy;
                        if (iPStrategy5 != null) {
                            str = iPStrategy5.resolveIP(domain, obtainUntriedIsp);
                        }
                    } while (TextUtils.isEmpty(str));
                    if (str == null) {
                        str = DnsService.getInstance().getDomainIP(domain);
                    }
                    if (str == null) {
                        if (QDLog.isInfoEnable()) {
                            QDLog.i(QDLog.TAG_DOWNLOAD, "downloader strategy:  ip is null. Pass! 9 threadId:" + Thread.currentThread().getId());
                        }
                        return false;
                    }
                    DownloadGlobalStrategy.StrategyInfo m107clone6 = this.pCurrStrategyInfo.m107clone();
                    this.pCurrStrategyInfo = m107clone6;
                    m107clone6.setIPInfo(new IPInfo(str, this.mStandardPort));
                }
                do {
                    int obtainUntriedIsp2 = obtainUntriedIsp();
                    if (obtainUntriedIsp2 == 0) {
                        break;
                    }
                    IPStrategy iPStrategy6 = this.pDirectIPConfigStrategy;
                    if (iPStrategy6 != null) {
                        str = iPStrategy6.resolveIP(domain, obtainUntriedIsp2);
                    }
                } while (TextUtils.isEmpty(str));
                if (str == null) {
                    str = DnsService.getInstance().getDomainIP(domain);
                }
                if (str == null) {
                    if (QDLog.isInfoEnable()) {
                        QDLog.i(QDLog.TAG_DOWNLOAD, "downloader strategy:  ip is null. Pass! 8 threadId:" + Thread.currentThread().getId());
                    }
                    return false;
                }
                DownloadGlobalStrategy.StrategyInfo m107clone7 = this.pCurrStrategyInfo.m107clone();
                this.pCurrStrategyInfo = m107clone7;
                m107clone7.setIPInfo(new IPInfo(str, this.mStandardPort));
            }
        }
        addTriedIsp(NetworkManager.getIspType());
        return true;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(34:(9:354|355|356|357|358|(2:860|861)(1:360)|361|362|(2:363|364))|(6:789|790|791|792|793|(7:803|(34:805|(37:807|(1:809)(1:819)|810|(1:812)|813|(1:815)|816|(1:818)|387|(1:389)|390|(1:392)(1:785)|393|(4:395|396|397|398)(1:784)|400|401|402|403|404|405|406|407|(7:757|758|(1:760)|761|762|763|764)(3:409|(1:411)|412)|413|414|(3:744|745|(1:747)(17:748|443|(1:579)(1:447)|448|(1:450)(1:578)|(12:574|575|453|(4:455|(1:457)(1:572)|458|(1:460))(1:573)|461|(17:463|(11:465|(1:471)|472|(1:474)(1:547)|475|(1:477)|478|(1:480)(1:546)|481|(1:483)(1:545)|484)(11:548|(1:554)|555|(1:557)(1:570)|558|(1:560)|561|(1:563)(1:569)|564|(1:566)(1:568)|567)|485|(2:491|492)|544|496|(2:502|503)|507|(1:509)(1:543)|510|(1:542)(1:514)|515|(1:541)(1:519)|520|(1:524)|525|(1:540)(1:529))(1:571)|530|(3:532|(1:534)|535)(2:537|(1:539))|536|150|23|(0)(0))|452|453|(0)(0)|461|(0)(0)|530|(0)(0)|536|150|23|(0)(0)))|(1:417)(2:740|(1:742)(23:743|419|420|421|(5:586|587|588|589|(16:592|593|595|596|(1:729)(1:600)|601|(1:603)(1:728)|(9:724|725|606|(4:608|(1:610)|611|(1:613))|614|(18:616|(11:618|(1:624)|625|(1:627)(1:699)|628|(1:630)|631|(1:633)(1:698)|634|(1:636)(1:697)|637)(11:700|(1:706)|707|(1:709)(1:722)|710|(1:712)|713|(1:715)(1:721)|716|(1:718)(1:720)|719)|638|(2:644|645)|696|649|(2:655|656)|660|(1:662)(1:695)|663|(1:694)(1:667)|668|(1:693)(1:672)|673|(1:677)|678|(1:680)|692)(1:723)|682|(3:684|(1:686)|687)(2:689|(1:691))|688)|605|606|(0)|614|(0)(0)|682|(0)(0)|688)(1:591))(8:425|426|(1:428)|429|(1:437)|438|(1:440)|441)|442|443|(1:445)|579|448|(0)(0)|(0)|452|453|(0)(0)|461|(0)(0)|530|(0)(0)|536|150|23|(0)(0)))|418|419|420|421|(1:423)|586|587|588|589|(0)(0))|820|816|(0)|387|(0)|390|(0)(0)|393|(0)(0)|400|401|402|403|404|405|406|407|(0)(0)|413|414|(0)|(0)(0)|418|419|420|421|(0)|586|587|588|589|(0)(0))(35:821|(1:824)|825|(6:827|(1:829)(1:836)|830|(1:832)|833|(1:835))(3:837|(2:839|(6:841|(1:843)(1:850)|844|(1:846)|847|(1:849)))|820)|816|(0)|387|(0)|390|(0)(0)|393|(0)(0)|400|401|402|403|404|405|406|407|(0)(0)|413|414|(0)|(0)(0)|418|419|420|421|(0)|586|587|588|589|(0)(0))|29|30|(1:32)|33|35))(1:366)|367|368|(8:374|(1:376)(1:386)|377|(1:379)|380|(1:382)|383|(1:385))|387|(0)|390|(0)(0)|393|(0)(0)|400|401|402|403|404|405|406|407|(0)(0)|413|414|(0)|(0)(0)|418|419|420|421|(0)|586|587|588|589|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(43:354|355|356|357|358|(2:860|861)(1:360)|361|362|363|364|(6:789|790|791|792|793|(7:803|(34:805|(37:807|(1:809)(1:819)|810|(1:812)|813|(1:815)|816|(1:818)|387|(1:389)|390|(1:392)(1:785)|393|(4:395|396|397|398)(1:784)|400|401|402|403|404|405|406|407|(7:757|758|(1:760)|761|762|763|764)(3:409|(1:411)|412)|413|414|(3:744|745|(1:747)(17:748|443|(1:579)(1:447)|448|(1:450)(1:578)|(12:574|575|453|(4:455|(1:457)(1:572)|458|(1:460))(1:573)|461|(17:463|(11:465|(1:471)|472|(1:474)(1:547)|475|(1:477)|478|(1:480)(1:546)|481|(1:483)(1:545)|484)(11:548|(1:554)|555|(1:557)(1:570)|558|(1:560)|561|(1:563)(1:569)|564|(1:566)(1:568)|567)|485|(2:491|492)|544|496|(2:502|503)|507|(1:509)(1:543)|510|(1:542)(1:514)|515|(1:541)(1:519)|520|(1:524)|525|(1:540)(1:529))(1:571)|530|(3:532|(1:534)|535)(2:537|(1:539))|536|150|23|(0)(0))|452|453|(0)(0)|461|(0)(0)|530|(0)(0)|536|150|23|(0)(0)))|(1:417)(2:740|(1:742)(23:743|419|420|421|(5:586|587|588|589|(16:592|593|595|596|(1:729)(1:600)|601|(1:603)(1:728)|(9:724|725|606|(4:608|(1:610)|611|(1:613))|614|(18:616|(11:618|(1:624)|625|(1:627)(1:699)|628|(1:630)|631|(1:633)(1:698)|634|(1:636)(1:697)|637)(11:700|(1:706)|707|(1:709)(1:722)|710|(1:712)|713|(1:715)(1:721)|716|(1:718)(1:720)|719)|638|(2:644|645)|696|649|(2:655|656)|660|(1:662)(1:695)|663|(1:694)(1:667)|668|(1:693)(1:672)|673|(1:677)|678|(1:680)|692)(1:723)|682|(3:684|(1:686)|687)(2:689|(1:691))|688)|605|606|(0)|614|(0)(0)|682|(0)(0)|688)(1:591))(8:425|426|(1:428)|429|(1:437)|438|(1:440)|441)|442|443|(1:445)|579|448|(0)(0)|(0)|452|453|(0)(0)|461|(0)(0)|530|(0)(0)|536|150|23|(0)(0)))|418|419|420|421|(1:423)|586|587|588|589|(0)(0))|820|816|(0)|387|(0)|390|(0)(0)|393|(0)(0)|400|401|402|403|404|405|406|407|(0)(0)|413|414|(0)|(0)(0)|418|419|420|421|(0)|586|587|588|589|(0)(0))(35:821|(1:824)|825|(6:827|(1:829)(1:836)|830|(1:832)|833|(1:835))(3:837|(2:839|(6:841|(1:843)(1:850)|844|(1:846)|847|(1:849)))|820)|816|(0)|387|(0)|390|(0)(0)|393|(0)(0)|400|401|402|403|404|405|406|407|(0)(0)|413|414|(0)|(0)(0)|418|419|420|421|(0)|586|587|588|589|(0)(0))|29|30|(1:32)|33|35))(1:366)|367|368|(8:374|(1:376)(1:386)|377|(1:379)|380|(1:382)|383|(1:385))|387|(0)|390|(0)(0)|393|(0)(0)|400|401|402|403|404|405|406|407|(0)(0)|413|414|(0)|(0)(0)|418|419|420|421|(0)|586|587|588|589|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:292:0x2080, code lost:
    
        if (r85.getStatus().isSucceed() != false) goto L795;
     */
    /* JADX WARN: Code restructure failed: missing block: B:681:0x0b96, code lost:
    
        if (r85.getStatus().isSucceed() != false) goto L330;
     */
    /* JADX WARN: Code restructure failed: missing block: B:733:0x120f, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:734:0x1210, code lost:
    
        r1 = ", useProxy=";
        r6 = ", allowProxy=";
        r4 = ", apn=";
        r3 = ", thread=";
        r5 = "null:0";
        r2 = com.tencent.component.network.module.base.QDLog.TAG_DOWNLOAD_RESULT;
        r12 = ", localAddress=";
        r60 = ",";
        r59 = com.tencent.component.network.module.base.QDLog.TAG_DOWNLOAD;
        r27 = ", totalDuration=";
        r30 = ", IpStack=";
        r24 = r11;
        r11 = ", apnProxy=";
        r28 = ", duration=";
        r25 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:735:0x1252, code lost:
    
        r31 = r11;
        r61 = r16;
        r62 = r25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:736:0x1280, code lost:
    
        r11 = r0;
        r82 = r24;
        r24 = r1;
        r1 = r82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:738:0x122f, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:739:0x1230, code lost:
    
        r16 = r5;
        r1 = ", useProxy=";
        r4 = ", apn=";
        r3 = ", thread=";
        r5 = "null:0";
        r2 = com.tencent.component.network.module.base.QDLog.TAG_DOWNLOAD_RESULT;
        r60 = ",";
        r59 = com.tencent.component.network.module.base.QDLog.TAG_DOWNLOAD;
        r27 = ", totalDuration=";
        r24 = r6;
        r6 = ", allowProxy=";
        r30 = ", IpStack=";
        r28 = ", duration=";
        r25 = r11;
        r11 = ", apnProxy=";
        r12 = ", localAddress=";
     */
    /* JADX WARN: Code restructure failed: missing block: B:755:0x1259, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:756:0x125a, code lost:
    
        r1 = ", useProxy=";
        r4 = ", apn=";
        r3 = ", thread=";
        r5 = "null:0";
        r2 = com.tencent.component.network.module.base.QDLog.TAG_DOWNLOAD_RESULT;
        r60 = ",";
        r59 = com.tencent.component.network.module.base.QDLog.TAG_DOWNLOAD;
        r27 = ", totalDuration=";
        r24 = r6;
        r6 = ", allowProxy=";
        r30 = ", IpStack=";
        r28 = ", duration=";
        r12 = ", localAddress=";
        r31 = ", apnProxy=";
        r62 = r11;
        r61 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:772:0x1289, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:773:0x128a, code lost:
    
        r6 = ", allowProxy=";
        r4 = ", apn=";
        r3 = ", thread=";
        r5 = "null:0";
        r2 = com.tencent.component.network.module.base.QDLog.TAG_DOWNLOAD_RESULT;
        r60 = ",";
        r59 = com.tencent.component.network.module.base.QDLog.TAG_DOWNLOAD;
        r27 = ", totalDuration=";
        r30 = ", IpStack=";
        r28 = ", duration=";
        r12 = ", localAddress=";
        r24 = ", useProxy=";
        r31 = ", apnProxy=";
        r62 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:775:0x12b0, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:776:0x12b1, code lost:
    
        r1 = ", useProxy=";
        r11 = ", apnProxy=";
        r6 = ", allowProxy=";
        r4 = ", apn=";
        r3 = ", thread=";
        r5 = "null:0";
        r2 = com.tencent.component.network.module.base.QDLog.TAG_DOWNLOAD_RESULT;
        r12 = ", localAddress=";
        r60 = ",";
        r59 = com.tencent.component.network.module.base.QDLog.TAG_DOWNLOAD;
     */
    /* JADX WARN: Code restructure failed: missing block: B:777:0x133b, code lost:
    
        r27 = ", totalDuration=";
        r28 = ", duration=";
        r30 = ", IpStack=";
     */
    /* JADX WARN: Code restructure failed: missing block: B:779:0x12c7, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:780:0x12c8, code lost:
    
        r59 = com.tencent.component.network.module.base.QDLog.TAG_DOWNLOAD;
        r60 = ",";
        r12 = ", localAddress=";
        r1 = ", useProxy=";
        r11 = ", apnProxy=";
        r6 = ", allowProxy=";
        r4 = ", apn=";
        r3 = ", thread=";
        r5 = "null:0";
        r2 = com.tencent.component.network.module.base.QDLog.TAG_DOWNLOAD_RESULT;
        r14 = r2;
        r43 = ", contentLength=";
        r19 = r38;
        r40 = r39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:787:0x12e5, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:788:0x12e6, code lost:
    
        r40 = r1;
        r59 = com.tencent.component.network.module.base.QDLog.TAG_DOWNLOAD;
        r60 = ",";
        r12 = ", localAddress=";
        r1 = ", useProxy=";
        r11 = ", apnProxy=";
        r6 = ", allowProxy=";
        r4 = ", apn=";
        r3 = ", thread=";
        r5 = "null:0";
        r2 = com.tencent.component.network.module.base.QDLog.TAG_DOWNLOAD_RESULT;
        r14 = r2;
        r43 = ", contentLength=";
        r19 = r38;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:145:0x1a0d  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x1a18  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x19fe  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x14ab  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x1450 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x144b  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x139e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:219:0x1b05  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x1b4a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x1a6b A[LOOP:0: B:2:0x0026->B:25:0x1a6b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x1a2a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:273:0x1fbb  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x2078  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x208f  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x209a  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x1fbe  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x1a35 A[Catch: all -> 0x1a63, TryCatch #1 {all -> 0x1a63, blocks: (B:30:0x1a2d, B:32:0x1a35, B:33:0x1a3d), top: B:29:0x1a2d }] */
    /* JADX WARN: Removed duplicated region for block: B:337:0x208a  */
    /* JADX WARN: Removed duplicated region for block: B:339:0x1b3e  */
    /* JADX WARN: Removed duplicated region for block: B:340:0x1ae7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:389:0x03b9 A[Catch: all -> 0x02ce, TRY_ENTER, TRY_LEAVE, TryCatch #29 {all -> 0x02ce, blocks: (B:793:0x015e, B:795:0x0167, B:370:0x030e, B:374:0x031d, B:376:0x0332, B:377:0x0343, B:380:0x034b, B:382:0x036a, B:383:0x0372, B:385:0x0380, B:386:0x033b, B:389:0x03b9, B:392:0x03c9, B:395:0x03f2, B:797:0x016b, B:799:0x016f, B:801:0x0175, B:803:0x0183, B:807:0x019c, B:809:0x01a0, B:810:0x01b1, B:813:0x01b9, B:815:0x01d2, B:816:0x0280, B:818:0x028e, B:819:0x01a9, B:825:0x01e4, B:827:0x01ed, B:829:0x01f1, B:830:0x0202, B:833:0x020a, B:835:0x0229, B:836:0x01fa, B:837:0x0232, B:839:0x0239, B:841:0x0243, B:843:0x0247, B:844:0x0254, B:847:0x025c, B:849:0x0275, B:850:0x024e), top: B:792:0x015e }] */
    /* JADX WARN: Removed duplicated region for block: B:392:0x03c9 A[Catch: all -> 0x02ce, TRY_ENTER, TRY_LEAVE, TryCatch #29 {all -> 0x02ce, blocks: (B:793:0x015e, B:795:0x0167, B:370:0x030e, B:374:0x031d, B:376:0x0332, B:377:0x0343, B:380:0x034b, B:382:0x036a, B:383:0x0372, B:385:0x0380, B:386:0x033b, B:389:0x03b9, B:392:0x03c9, B:395:0x03f2, B:797:0x016b, B:799:0x016f, B:801:0x0175, B:803:0x0183, B:807:0x019c, B:809:0x01a0, B:810:0x01b1, B:813:0x01b9, B:815:0x01d2, B:816:0x0280, B:818:0x028e, B:819:0x01a9, B:825:0x01e4, B:827:0x01ed, B:829:0x01f1, B:830:0x0202, B:833:0x020a, B:835:0x0229, B:836:0x01fa, B:837:0x0232, B:839:0x0239, B:841:0x0243, B:843:0x0247, B:844:0x0254, B:847:0x025c, B:849:0x0275, B:850:0x024e), top: B:792:0x015e }] */
    /* JADX WARN: Removed duplicated region for block: B:395:0x03f2 A[Catch: all -> 0x02ce, TRY_ENTER, TRY_LEAVE, TryCatch #29 {all -> 0x02ce, blocks: (B:793:0x015e, B:795:0x0167, B:370:0x030e, B:374:0x031d, B:376:0x0332, B:377:0x0343, B:380:0x034b, B:382:0x036a, B:383:0x0372, B:385:0x0380, B:386:0x033b, B:389:0x03b9, B:392:0x03c9, B:395:0x03f2, B:797:0x016b, B:799:0x016f, B:801:0x0175, B:803:0x0183, B:807:0x019c, B:809:0x01a0, B:810:0x01b1, B:813:0x01b9, B:815:0x01d2, B:816:0x0280, B:818:0x028e, B:819:0x01a9, B:825:0x01e4, B:827:0x01ed, B:829:0x01f1, B:830:0x0202, B:833:0x020a, B:835:0x0229, B:836:0x01fa, B:837:0x0232, B:839:0x0239, B:841:0x0243, B:843:0x0247, B:844:0x0254, B:847:0x025c, B:849:0x0275, B:850:0x024e), top: B:792:0x015e }] */
    /* JADX WARN: Removed duplicated region for block: B:409:0x04ae A[Catch: all -> 0x1289, TRY_ENTER, TRY_LEAVE, TryCatch #28 {all -> 0x1289, blocks: (B:407:0x045c, B:409:0x04ae), top: B:406:0x045c }] */
    /* JADX WARN: Removed duplicated region for block: B:417:0x04fd A[Catch: all -> 0x04f8, TRY_LEAVE, TryCatch #16 {all -> 0x04f8, blocks: (B:745:0x04d0, B:748:0x04d5, B:417:0x04fd, B:742:0x050b), top: B:744:0x04d0 }] */
    /* JADX WARN: Removed duplicated region for block: B:423:0x051b  */
    /* JADX WARN: Removed duplicated region for block: B:450:0x0c4d  */
    /* JADX WARN: Removed duplicated region for block: B:455:0x0c71  */
    /* JADX WARN: Removed duplicated region for block: B:463:0x0cba  */
    /* JADX WARN: Removed duplicated region for block: B:532:0x11fb  */
    /* JADX WARN: Removed duplicated region for block: B:537:0x1205  */
    /* JADX WARN: Removed duplicated region for block: B:571:0x11ec  */
    /* JADX WARN: Removed duplicated region for block: B:573:0x0cac  */
    /* JADX WARN: Removed duplicated region for block: B:574:0x0c54 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:578:0x0c4f  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x1429  */
    /* JADX WARN: Removed duplicated region for block: B:591:0x0be1  */
    /* JADX WARN: Removed duplicated region for block: B:592:0x05b4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:608:0x062e  */
    /* JADX WARN: Removed duplicated region for block: B:616:0x065d  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x1448  */
    /* JADX WARN: Removed duplicated region for block: B:684:0x0ba9  */
    /* JADX WARN: Removed duplicated region for block: B:689:0x0bb3  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x146e  */
    /* JADX WARN: Removed duplicated region for block: B:723:0x0b9e  */
    /* JADX WARN: Removed duplicated region for block: B:740:0x0507 A[Catch: all -> 0x1259, TRY_ENTER, TRY_LEAVE, TryCatch #35 {all -> 0x1259, blocks: (B:414:0x04c5, B:740:0x0507), top: B:413:0x04c5 }] */
    /* JADX WARN: Removed duplicated region for block: B:744:0x04d0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:757:0x0466 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x14b9  */
    /* JADX WARN: Removed duplicated region for block: B:784:0x0421  */
    /* JADX WARN: Removed duplicated region for block: B:785:0x03dc A[Catch: all -> 0x12e5, TRY_ENTER, TryCatch #2 {all -> 0x12e5, blocks: (B:368:0x030a, B:387:0x03b5, B:390:0x03c5, B:393:0x03ee, B:785:0x03dc), top: B:367:0x030a }] */
    /* JADX WARN: Removed duplicated region for block: B:818:0x028e A[Catch: all -> 0x02ce, TRY_LEAVE, TryCatch #29 {all -> 0x02ce, blocks: (B:793:0x015e, B:795:0x0167, B:370:0x030e, B:374:0x031d, B:376:0x0332, B:377:0x0343, B:380:0x034b, B:382:0x036a, B:383:0x0372, B:385:0x0380, B:386:0x033b, B:389:0x03b9, B:392:0x03c9, B:395:0x03f2, B:797:0x016b, B:799:0x016f, B:801:0x0175, B:803:0x0183, B:807:0x019c, B:809:0x01a0, B:810:0x01b1, B:813:0x01b9, B:815:0x01d2, B:816:0x0280, B:818:0x028e, B:819:0x01a9, B:825:0x01e4, B:827:0x01ed, B:829:0x01f1, B:830:0x0202, B:833:0x020a, B:835:0x0229, B:836:0x01fa, B:837:0x0232, B:839:0x0239, B:841:0x0243, B:843:0x0247, B:844:0x0254, B:847:0x025c, B:849:0x0275, B:850:0x024e), top: B:792:0x015e }] */
    /* JADX WARN: Type inference failed for: r11v64 */
    /* JADX WARN: Type inference failed for: r11v65, types: [boolean] */
    /* JADX WARN: Type inference failed for: r11v66 */
    /* JADX WARN: Type inference failed for: r3v108 */
    /* JADX WARN: Type inference failed for: r3v114, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r3v115 */
    /* JADX WARN: Type inference failed for: r3v145 */
    /* JADX WARN: Type inference failed for: r3v146, types: [okhttp3.Request$Builder] */
    /* JADX WARN: Type inference failed for: r3v190 */
    /* JADX WARN: Type inference failed for: r3v191, types: [okhttp3.Request$Builder] */
    /* JADX WARN: Type inference failed for: r3v237 */
    /* JADX WARN: Type inference failed for: r3v238 */
    /* JADX WARN: Type inference failed for: r3v239 */
    /* JADX WARN: Type inference failed for: r3v240 */
    /* JADX WARN: Type inference failed for: r3v67 */
    /* JADX WARN: Type inference failed for: r3v69, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r3v80 */
    @Override // com.tencent.component.network.downloader.impl.DownloadTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void execute(ThreadPool.JobContext jobContext, DownloadResult downloadResult) {
        String str;
        DownloadResult downloadResult2;
        String str2;
        String str3;
        int i3;
        int i16;
        long j3;
        DownloadReport downloadReport;
        String str4;
        String str5;
        int i17;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        long j16;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        HttpUtil.RequestOptions requestOptions;
        Throwable th5;
        long j17;
        Proxy customProxy;
        HttpContext httpContext;
        int i18;
        String str18;
        String str19;
        boolean isIpV6Stack;
        boolean enableIpv6Debug;
        int i19;
        DownloadGlobalStrategy.StrategyInfo strategyInfo;
        String str20;
        DownloadGlobalStrategy.StrategyInfo strategyInfo2;
        ResumeTransfer resumeTransfer;
        DownloadReport downloadReport2;
        HttpContext createHttpContext;
        HttpContext httpContext2;
        HttpResponse httpResponse;
        long j18;
        String str21;
        String str22;
        String str23;
        String str24;
        String str25;
        String str26;
        DownloadReport downloadReport3;
        String str27;
        String str28;
        int i26;
        HttpContext httpContext3;
        String str29;
        String str30;
        String str31;
        String str32;
        String str33;
        String str34;
        ThreadPool.JobContext jobContext2;
        long j19;
        Request.Builder builder;
        ThreadPool.JobContext jobContext3;
        int i27;
        ?? r36;
        Response response;
        IPStrategy iPStrategy;
        IPStrategy iPStrategy2;
        Response response2;
        int i28;
        int code;
        int i29;
        String str35;
        String str36;
        String str37;
        Request.Builder builder2;
        String str38;
        int i36;
        long j26;
        ?? r37;
        Response response3;
        IPStrategy iPStrategy3;
        IPStrategy iPStrategy4;
        Response response4;
        int xErrorCode;
        String str39;
        Throwable th6;
        String str40;
        String str41;
        String str42;
        String str43;
        String str44;
        String str45;
        String str46;
        int i37;
        long j27;
        Throwable th7;
        String str47;
        String str48;
        String str49;
        String str50;
        ?? r38;
        int i38;
        int i39;
        long j28;
        String str51;
        Response response5;
        String str52;
        DownloadGlobalStrategy.StrategyInfo strategyInfo3;
        DownloadReport downloadReport4;
        Response response6;
        IPStrategy iPStrategy5;
        IPStrategy iPStrategy6;
        Response response7;
        String str53;
        int i46;
        String str54;
        String str55;
        String str56;
        String str57;
        int i47;
        int i48;
        ?? r39;
        int i49;
        String str58;
        Response response8;
        IPStrategy iPStrategy7;
        IPStrategy iPStrategy8;
        Response response9;
        ThreadPool.JobContext jobContext4 = jobContext;
        DownloadResult downloadResult3 = downloadResult;
        String str59 = "";
        int generateRandomId = DownloadTask.TaskHelper.generateRandomId(getUrl(), downloadResult3);
        long uptimeMillis = SystemClock.uptimeMillis();
        String str60 = "";
        long j29 = 0;
        int i56 = 0;
        while (!jobContext.isCancelled()) {
            while (!NetworkUtils.isNetworkAvailable(this.mContext) && SystemClock.uptimeMillis() - uptimeMillis <= 150000) {
                try {
                    LockMethodProxy.sleep(2000L);
                } catch (Exception unused) {
                }
            }
            try {
                if (SystemClock.uptimeMillis() - uptimeMillis > 150000) {
                    str = str59;
                    downloadResult2 = downloadResult3;
                    str2 = str60;
                    str3 = QDLog.TAG_DOWNLOAD;
                } else {
                    long uptimeMillis2 = SystemClock.uptimeMillis();
                    DownloadReport downloadReport5 = new DownloadReport();
                    downloadReport5.f99895id = generateRandomId;
                    downloadReport5.url = getUrl();
                    downloadReport5.domain = getDomain();
                    downloadReport5.startTime = System.currentTimeMillis();
                    this.request = null;
                    this.response = null;
                    this.okRequestBuilder = null;
                    this.okResponse = null;
                    long currentTimeMillis = System.currentTimeMillis();
                    try {
                    } catch (Throwable th8) {
                        th = th8;
                    }
                    if (setStrategy(this.mAttemptCurrCount)) {
                        th = null;
                        i16 = generateRandomId;
                        j3 = uptimeMillis;
                        str = str59;
                        String str61 = "http1.1";
                        try {
                            if (th == null) {
                                try {
                                    requestOptions = DownloadTask.sRequestOptions.get();
                                    try {
                                        requestOptions.allowProxy = this.mAllowProxy;
                                        requestOptions.apnProxy = this.mAPNProxy;
                                        DownloadTask.DownloadTaskHandler downloadTaskHandler = this.mDownloadTaskHandler;
                                        if (downloadTaskHandler != null) {
                                            try {
                                                customProxy = downloadTaskHandler.getCustomProxy();
                                            } catch (Throwable th9) {
                                                th5 = th9;
                                                downloadReport = downloadReport5;
                                                str4 = QDLog.TAG_DOWNLOAD;
                                                str5 = ", contentLength=";
                                                i17 = i56;
                                                str6 = ",";
                                                str7 = ", localAddress=";
                                                j17 = j29;
                                                str10 = ", allowProxy=";
                                                str11 = ", apn=";
                                                str16 = ", thread=";
                                                str12 = "null:0";
                                                str17 = QDLog.TAG_DOWNLOAD_RESULT;
                                                j16 = uptimeMillis2;
                                                httpContext = null;
                                                i18 = 0;
                                                str15 = ", IpStack=";
                                                str18 = ", apnProxy=";
                                                str14 = ", duration=";
                                                str13 = ", totalDuration=";
                                                str19 = ", useProxy=";
                                                downloadResult.getStatus().setFailed(th5);
                                                str53 = this.mRealUrl;
                                                th6 = th5;
                                                if (str53 != null) {
                                                }
                                                str54 = str17;
                                                int i57 = i17 + 1;
                                                String str62 = str16;
                                                downloadResult.getProcess().setDuration(j16, SystemClock.uptimeMillis());
                                                downloadResult.getProcess().totalDuration = SystemClock.uptimeMillis() - this.mTimeStamp;
                                                downloadResult.getProcess().startTimestamp = this.mTaskStartTimeStamp;
                                                NetworkUtils.DNS dns = NetworkStatus.getInstance(this.mContext).getDNS();
                                                DownloadGlobalStrategy.StrategyInfo strategyInfo4 = this.pCurrStrategyInfo;
                                                if (strategyInfo4 != null) {
                                                }
                                                String parserHttpHeaderInfo = parserHttpHeaderInfo(this.request, this.response, this.okResponse);
                                                if (r0 != null) {
                                                }
                                                if (httpContext != null) {
                                                }
                                                str55 = "";
                                                downloadResult.getContent().redirectUrl = str55;
                                                if (downloadResult.getStatus().isSucceed()) {
                                                }
                                                if (jobContext.isCancelled()) {
                                                }
                                                if (!this.mIsHttp2) {
                                                }
                                                i56 = i48;
                                                str60 = str34;
                                                j29 = j19;
                                                if (canAttempt()) {
                                                }
                                            }
                                        } else {
                                            customProxy = null;
                                        }
                                        requestOptions.mobileProxy = customProxy;
                                        downloadReport5.currAttempCount = i56;
                                        downloadResult.reset();
                                        this.mRealUrl = prepareUrl(getUrl());
                                        isIpV6Stack = Config.isIpV6Stack();
                                        enableIpv6Debug = enableIpv6Debug();
                                        try {
                                        } catch (Throwable th10) {
                                            th = th10;
                                            downloadReport = downloadReport5;
                                            str4 = QDLog.TAG_DOWNLOAD;
                                            i17 = i56;
                                            str6 = ",";
                                            str7 = ", localAddress=";
                                            str8 = ", useProxy=";
                                            str9 = ", apnProxy=";
                                            str10 = ", allowProxy=";
                                            str11 = ", apn=";
                                            str16 = ", thread=";
                                            str12 = "null:0";
                                            str17 = QDLog.TAG_DOWNLOAD_RESULT;
                                            j16 = uptimeMillis2;
                                            str5 = ", contentLength=";
                                        }
                                    } catch (Throwable th11) {
                                        th = th11;
                                        downloadReport = downloadReport5;
                                        str4 = QDLog.TAG_DOWNLOAD;
                                        str5 = ", contentLength=";
                                        i17 = i56;
                                        str6 = ",";
                                        str7 = ", localAddress=";
                                        str8 = ", useProxy=";
                                        str9 = ", apnProxy=";
                                        str10 = ", allowProxy=";
                                        str11 = ", apn=";
                                        str16 = ", thread=";
                                        str12 = "null:0";
                                        str17 = QDLog.TAG_DOWNLOAD_RESULT;
                                        j16 = uptimeMillis2;
                                    }
                                } catch (Throwable th12) {
                                    th = th12;
                                    downloadReport = downloadReport5;
                                    str4 = QDLog.TAG_DOWNLOAD;
                                    str5 = ", contentLength=";
                                    i17 = i56;
                                    str6 = ",";
                                    str7 = ", localAddress=";
                                    str8 = ", useProxy=";
                                    str9 = ", apnProxy=";
                                    str10 = ", allowProxy=";
                                    str11 = ", apn=";
                                    str12 = "null:0";
                                    j16 = uptimeMillis2;
                                    str13 = ", totalDuration=";
                                    str14 = ", duration=";
                                    str15 = ", IpStack=";
                                    str16 = ", thread=";
                                    str17 = QDLog.TAG_DOWNLOAD_RESULT;
                                }
                                if (requestOptions.mobileProxy == null) {
                                    try {
                                        i19 = i56;
                                        try {
                                        } catch (Throwable th13) {
                                            th5 = th13;
                                            downloadReport = downloadReport5;
                                            str4 = QDLog.TAG_DOWNLOAD;
                                            str6 = ",";
                                            str7 = ", localAddress=";
                                            j17 = j29;
                                            str10 = ", allowProxy=";
                                            str11 = ", apn=";
                                            str16 = ", thread=";
                                            str12 = "null:0";
                                            str17 = QDLog.TAG_DOWNLOAD_RESULT;
                                            j16 = uptimeMillis2;
                                            str5 = ", contentLength=";
                                            i17 = i19;
                                            httpContext = null;
                                            i18 = 0;
                                            str15 = ", IpStack=";
                                            str18 = ", apnProxy=";
                                            str14 = ", duration=";
                                            str13 = ", totalDuration=";
                                            str19 = ", useProxy=";
                                            downloadResult.getStatus().setFailed(th5);
                                            str53 = this.mRealUrl;
                                            th6 = th5;
                                            if (str53 != null) {
                                            }
                                            str54 = str17;
                                            int i572 = i17 + 1;
                                            String str622 = str16;
                                            downloadResult.getProcess().setDuration(j16, SystemClock.uptimeMillis());
                                            downloadResult.getProcess().totalDuration = SystemClock.uptimeMillis() - this.mTimeStamp;
                                            downloadResult.getProcess().startTimestamp = this.mTaskStartTimeStamp;
                                            NetworkUtils.DNS dns2 = NetworkStatus.getInstance(this.mContext).getDNS();
                                            DownloadGlobalStrategy.StrategyInfo strategyInfo42 = this.pCurrStrategyInfo;
                                            if (strategyInfo42 != null) {
                                            }
                                            String parserHttpHeaderInfo2 = parserHttpHeaderInfo(this.request, this.response, this.okResponse);
                                            if (r0 != null) {
                                            }
                                            if (httpContext != null) {
                                            }
                                            str55 = "";
                                            downloadResult.getContent().redirectUrl = str55;
                                            if (downloadResult.getStatus().isSucceed()) {
                                            }
                                            if (jobContext.isCancelled()) {
                                            }
                                            if (!this.mIsHttp2) {
                                            }
                                            i56 = i48;
                                            str60 = str34;
                                            j29 = j19;
                                            if (canAttempt()) {
                                            }
                                        }
                                    } catch (Throwable th14) {
                                        th5 = th14;
                                        downloadReport = downloadReport5;
                                        str4 = QDLog.TAG_DOWNLOAD;
                                        i17 = i56;
                                        str6 = ",";
                                        str7 = ", localAddress=";
                                        j17 = j29;
                                        str10 = ", allowProxy=";
                                        str11 = ", apn=";
                                        str16 = ", thread=";
                                        str12 = "null:0";
                                        str17 = QDLog.TAG_DOWNLOAD_RESULT;
                                        j16 = uptimeMillis2;
                                        str5 = ", contentLength=";
                                    }
                                    if ((!this.mRealUrl.startsWith("https") || this.mIsHttp2) && (strategyInfo = this.pCurrStrategyInfo) != null && strategyInfo.getIPInfo() != null && !TextUtils.isEmpty(this.pCurrStrategyInfo.getIPInfo().f99897ip)) {
                                        String str63 = this.pCurrStrategyInfo.getIPInfo().f99897ip;
                                        String domain = getDomain();
                                        int count = Utils.count(str63, ':');
                                        if (isIpV6Stack) {
                                            if (count < 2 && enableIpv6Debug) {
                                                str63 = "240e:ff:f040:28::23";
                                            }
                                            if (Utils.count(str63, ':') >= 2) {
                                                int i58 = this.mOrigPort;
                                                if (i58 > 0) {
                                                    this.pCurrStrategyInfo.getIPInfo().port = i58;
                                                } else {
                                                    i58 = this.pCurrStrategyInfo.getIPInfo().port;
                                                }
                                                if (!Utils.isPortValid(i58)) {
                                                    i58 = 80;
                                                }
                                                str20 = "[" + str63 + "]:" + i58;
                                                String str64 = this.mDomainWithPort;
                                                if (str64 != null) {
                                                    this.mRealUrl = this.mRealUrl.replaceFirst(str64, str20);
                                                }
                                            } else {
                                                if (Config.getNetworkStackType() == 3) {
                                                    DownloadGlobalStrategy.StrategyInfo strategyInfo5 = this.pCurrStrategyInfo;
                                                    if (strategyInfo5.f99899id != DownloadGlobalStrategy.Strategy_DOMAIN_FORCE.f99899id) {
                                                        int i59 = this.mOrigPort;
                                                        if (i59 > 0) {
                                                            strategyInfo5.getIPInfo().port = i59;
                                                        } else {
                                                            i59 = strategyInfo5.getIPInfo().port;
                                                        }
                                                        if (!Utils.isPortValid(i59)) {
                                                            i59 = 80;
                                                        }
                                                        str20 = str63 + ":" + i59;
                                                        String str65 = this.mDomainWithPort;
                                                        if (str65 != null) {
                                                            this.mRealUrl = this.mRealUrl.replaceFirst(str65, str20);
                                                        }
                                                    }
                                                }
                                                str20 = domain;
                                            }
                                            downloadReport5.strategyInfo = this.pCurrStrategyInfo.toString();
                                            if (QDLog.isDebugEnable()) {
                                            }
                                            strategyInfo2 = this.pCurrStrategyInfo;
                                            if (strategyInfo2 != null) {
                                            }
                                            if (!this.mIsHttp2) {
                                            }
                                            resumeTransfer = this.pResumeTransfer;
                                            if (resumeTransfer == null) {
                                            }
                                            prepareRequest(getUrl(), getDomain(), this.request, this.okRequestBuilder);
                                            downloadReport = downloadReport2;
                                            j16 = uptimeMillis2;
                                            str5 = ", contentLength=";
                                            i17 = i19;
                                            applyKeepAliveStrategy(getUrl(), getDomain(), this.request, this.okRequestBuilder, requestOptions);
                                            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                                            this.send_req_time = 0L;
                                            long uptimeMillis3 = SystemClock.uptimeMillis();
                                            if (this.request == null) {
                                            }
                                            this.send_req_time = SystemClock.uptimeMillis() - uptimeMillis3;
                                            httpResponse = this.response;
                                            if (httpResponse == null) {
                                            }
                                            if (httpResponse == null) {
                                            }
                                            i28 = code;
                                            downloadResult.getStatus().httpStatus = i28;
                                            if (200 == i28) {
                                            }
                                            i29 = i28;
                                            httpContext3 = httpContext2;
                                            if (handleResponse(this.response, this.okResponse, downloadResult, jobContext, i29)) {
                                            }
                                        } else {
                                            if (count < 2) {
                                                int i65 = this.mOrigPort;
                                                if (i65 > 0) {
                                                    this.pCurrStrategyInfo.getIPInfo().port = i65;
                                                } else {
                                                    i65 = this.pCurrStrategyInfo.getIPInfo().port;
                                                }
                                                if (!Utils.isPortValid(i65)) {
                                                    i65 = 80;
                                                }
                                                str20 = str63 + ":" + i65;
                                                String str66 = this.mDomainWithPort;
                                                if (str66 != null) {
                                                    this.mRealUrl = this.mRealUrl.replaceFirst(str66, str20);
                                                }
                                                downloadReport5.strategyInfo = this.pCurrStrategyInfo.toString();
                                                if (QDLog.isDebugEnable()) {
                                                    QDLog.d(QDLog.TAG_DOWNLOAD, "downloader strategy run: " + downloadReport5.strategyInfo + " domain:" + str20 + " url:" + getUrl() + " threadId:" + Thread.currentThread().getId());
                                                }
                                                strategyInfo2 = this.pCurrStrategyInfo;
                                                if (strategyInfo2 != null) {
                                                    downloadReport5.strategyInfo = strategyInfo2.toString();
                                                    downloadReport5.strategyId = this.pCurrStrategyInfo.f99899id;
                                                }
                                                if (!this.mIsHttp2) {
                                                    this.okRequestBuilder = HttpUtil.createOkHttpGet(this.mContext, getUrl(), getDomain(), this.mRealUrl);
                                                } else {
                                                    this.request = HttpUtil.createHttpGet(this.mContext, getUrl(), getDomain(), this.mRealUrl, requestOptions);
                                                }
                                                resumeTransfer = this.pResumeTransfer;
                                                if (resumeTransfer == null) {
                                                    downloadReport2 = downloadReport5;
                                                    try {
                                                        resumeTransfer.prepareRequest(this.request, this.okRequestBuilder, getUrl(), getDomain());
                                                    } catch (Throwable th15) {
                                                        th5 = th15;
                                                        str4 = QDLog.TAG_DOWNLOAD;
                                                        str6 = ",";
                                                        str7 = ", localAddress=";
                                                        j17 = j29;
                                                        str10 = ", allowProxy=";
                                                        str11 = ", apn=";
                                                        str16 = ", thread=";
                                                        str12 = "null:0";
                                                        str17 = QDLog.TAG_DOWNLOAD_RESULT;
                                                        j16 = uptimeMillis2;
                                                        str5 = ", contentLength=";
                                                        i17 = i19;
                                                        downloadReport = downloadReport2;
                                                        httpContext = null;
                                                        i18 = 0;
                                                        str15 = ", IpStack=";
                                                        str18 = ", apnProxy=";
                                                        str14 = ", duration=";
                                                        str13 = ", totalDuration=";
                                                        str19 = ", useProxy=";
                                                        downloadResult.getStatus().setFailed(th5);
                                                        str53 = this.mRealUrl;
                                                        th6 = th5;
                                                        if (str53 != null) {
                                                        }
                                                        str54 = str17;
                                                        int i5722 = i17 + 1;
                                                        String str6222 = str16;
                                                        downloadResult.getProcess().setDuration(j16, SystemClock.uptimeMillis());
                                                        downloadResult.getProcess().totalDuration = SystemClock.uptimeMillis() - this.mTimeStamp;
                                                        downloadResult.getProcess().startTimestamp = this.mTaskStartTimeStamp;
                                                        NetworkUtils.DNS dns22 = NetworkStatus.getInstance(this.mContext).getDNS();
                                                        DownloadGlobalStrategy.StrategyInfo strategyInfo422 = this.pCurrStrategyInfo;
                                                        if (strategyInfo422 != null) {
                                                        }
                                                        String parserHttpHeaderInfo22 = parserHttpHeaderInfo(this.request, this.response, this.okResponse);
                                                        if (r0 != null) {
                                                        }
                                                        if (httpContext != null) {
                                                        }
                                                        str55 = "";
                                                        downloadResult.getContent().redirectUrl = str55;
                                                        if (downloadResult.getStatus().isSucceed()) {
                                                        }
                                                        if (jobContext.isCancelled()) {
                                                        }
                                                        if (!this.mIsHttp2) {
                                                        }
                                                        i56 = i48;
                                                        str60 = str34;
                                                        j29 = j19;
                                                        if (canAttempt()) {
                                                        }
                                                    }
                                                } else {
                                                    downloadReport2 = downloadReport5;
                                                }
                                                prepareRequest(getUrl(), getDomain(), this.request, this.okRequestBuilder);
                                                downloadReport = downloadReport2;
                                                j16 = uptimeMillis2;
                                                str5 = ", contentLength=";
                                                i17 = i19;
                                                applyKeepAliveStrategy(getUrl(), getDomain(), this.request, this.okRequestBuilder, requestOptions);
                                                long currentTimeMillis22 = System.currentTimeMillis() - currentTimeMillis;
                                                this.send_req_time = 0L;
                                                long uptimeMillis32 = SystemClock.uptimeMillis();
                                                if (this.request == null) {
                                                    try {
                                                        if (this.pHttpClient == null) {
                                                            this.pHttpClient = HttpUtil.CreateDefaultHttpClient();
                                                        }
                                                        createHttpContext = HttpUtil.createHttpContext();
                                                    } catch (Throwable th16) {
                                                        th = th16;
                                                        j17 = currentTimeMillis22;
                                                        str10 = ", allowProxy=";
                                                        str11 = ", apn=";
                                                        str16 = ", thread=";
                                                        str12 = "null:0";
                                                        str17 = QDLog.TAG_DOWNLOAD_RESULT;
                                                        str7 = ", localAddress=";
                                                        str6 = ",";
                                                        str4 = QDLog.TAG_DOWNLOAD;
                                                        httpContext = null;
                                                        i18 = 0;
                                                        th5 = th;
                                                        str15 = ", IpStack=";
                                                        str18 = ", apnProxy=";
                                                        str14 = ", duration=";
                                                        str13 = ", totalDuration=";
                                                        str19 = ", useProxy=";
                                                        downloadResult.getStatus().setFailed(th5);
                                                        str53 = this.mRealUrl;
                                                        th6 = th5;
                                                        if (str53 != null) {
                                                        }
                                                        str54 = str17;
                                                        int i57222 = i17 + 1;
                                                        String str62222 = str16;
                                                        downloadResult.getProcess().setDuration(j16, SystemClock.uptimeMillis());
                                                        downloadResult.getProcess().totalDuration = SystemClock.uptimeMillis() - this.mTimeStamp;
                                                        downloadResult.getProcess().startTimestamp = this.mTaskStartTimeStamp;
                                                        NetworkUtils.DNS dns222 = NetworkStatus.getInstance(this.mContext).getDNS();
                                                        DownloadGlobalStrategy.StrategyInfo strategyInfo4222 = this.pCurrStrategyInfo;
                                                        if (strategyInfo4222 != null) {
                                                        }
                                                        String parserHttpHeaderInfo222 = parserHttpHeaderInfo(this.request, this.response, this.okResponse);
                                                        if (r0 != null) {
                                                        }
                                                        if (httpContext != null) {
                                                        }
                                                        str55 = "";
                                                        downloadResult.getContent().redirectUrl = str55;
                                                        if (downloadResult.getStatus().isSucceed()) {
                                                        }
                                                        if (jobContext.isCancelled()) {
                                                        }
                                                        if (!this.mIsHttp2) {
                                                        }
                                                        i56 = i48;
                                                        str60 = str34;
                                                        j29 = j19;
                                                        if (canAttempt()) {
                                                        }
                                                    }
                                                    try {
                                                        this.response = this.pHttpClient.execute(this.request, createHttpContext);
                                                        httpContext2 = createHttpContext;
                                                    } catch (Throwable th17) {
                                                        th = th17;
                                                        httpContext = createHttpContext;
                                                        j17 = currentTimeMillis22;
                                                        str10 = ", allowProxy=";
                                                        str11 = ", apn=";
                                                        str16 = ", thread=";
                                                        str12 = "null:0";
                                                        str17 = QDLog.TAG_DOWNLOAD_RESULT;
                                                        str7 = ", localAddress=";
                                                        str6 = ",";
                                                        str4 = QDLog.TAG_DOWNLOAD;
                                                        i18 = 0;
                                                        th5 = th;
                                                        str15 = ", IpStack=";
                                                        str18 = ", apnProxy=";
                                                        str14 = ", duration=";
                                                        str13 = ", totalDuration=";
                                                        str19 = ", useProxy=";
                                                        downloadResult.getStatus().setFailed(th5);
                                                        str53 = this.mRealUrl;
                                                        th6 = th5;
                                                        if (str53 != null) {
                                                        }
                                                        str54 = str17;
                                                        int i572222 = i17 + 1;
                                                        String str622222 = str16;
                                                        downloadResult.getProcess().setDuration(j16, SystemClock.uptimeMillis());
                                                        downloadResult.getProcess().totalDuration = SystemClock.uptimeMillis() - this.mTimeStamp;
                                                        downloadResult.getProcess().startTimestamp = this.mTaskStartTimeStamp;
                                                        NetworkUtils.DNS dns2222 = NetworkStatus.getInstance(this.mContext).getDNS();
                                                        DownloadGlobalStrategy.StrategyInfo strategyInfo42222 = this.pCurrStrategyInfo;
                                                        if (strategyInfo42222 != null) {
                                                        }
                                                        String parserHttpHeaderInfo2222 = parserHttpHeaderInfo(this.request, this.response, this.okResponse);
                                                        if (r0 != null) {
                                                        }
                                                        if (httpContext != null) {
                                                        }
                                                        str55 = "";
                                                        downloadResult.getContent().redirectUrl = str55;
                                                        if (downloadResult.getStatus().isSucceed()) {
                                                        }
                                                        if (jobContext.isCancelled()) {
                                                        }
                                                        if (!this.mIsHttp2) {
                                                        }
                                                        i56 = i48;
                                                        str60 = str34;
                                                        j29 = j19;
                                                        if (canAttempt()) {
                                                        }
                                                    }
                                                } else {
                                                    Request.Builder builder3 = this.okRequestBuilder;
                                                    if (builder3 != null) {
                                                        Call newCall = this.pokHttpClient.newCall(builder3.build());
                                                        this.okRequestCall = newCall;
                                                        this.okResponse = newCall.execute();
                                                    }
                                                    httpContext2 = null;
                                                }
                                                this.send_req_time = SystemClock.uptimeMillis() - uptimeMillis32;
                                                httpResponse = this.response;
                                                if (httpResponse == null) {
                                                    try {
                                                    } catch (Throwable th18) {
                                                        th = th18;
                                                        httpContext = httpContext2;
                                                        j17 = currentTimeMillis22;
                                                        str10 = ", allowProxy=";
                                                        str11 = ", apn=";
                                                        str16 = ", thread=";
                                                        str12 = "null:0";
                                                        str17 = QDLog.TAG_DOWNLOAD_RESULT;
                                                        str7 = ", localAddress=";
                                                        str6 = ",";
                                                        str4 = QDLog.TAG_DOWNLOAD;
                                                        i18 = 0;
                                                        th5 = th;
                                                        str15 = ", IpStack=";
                                                        str18 = ", apnProxy=";
                                                        str14 = ", duration=";
                                                        str13 = ", totalDuration=";
                                                        str19 = ", useProxy=";
                                                        downloadResult.getStatus().setFailed(th5);
                                                        str53 = this.mRealUrl;
                                                        th6 = th5;
                                                        if (str53 != null) {
                                                        }
                                                        str54 = str17;
                                                        int i5722222 = i17 + 1;
                                                        String str6222222 = str16;
                                                        downloadResult.getProcess().setDuration(j16, SystemClock.uptimeMillis());
                                                        downloadResult.getProcess().totalDuration = SystemClock.uptimeMillis() - this.mTimeStamp;
                                                        downloadResult.getProcess().startTimestamp = this.mTaskStartTimeStamp;
                                                        NetworkUtils.DNS dns22222 = NetworkStatus.getInstance(this.mContext).getDNS();
                                                        DownloadGlobalStrategy.StrategyInfo strategyInfo422222 = this.pCurrStrategyInfo;
                                                        if (strategyInfo422222 != null) {
                                                        }
                                                        String parserHttpHeaderInfo22222 = parserHttpHeaderInfo(this.request, this.response, this.okResponse);
                                                        if (r0 != null) {
                                                        }
                                                        if (httpContext != null) {
                                                        }
                                                        str55 = "";
                                                        downloadResult.getContent().redirectUrl = str55;
                                                        if (downloadResult.getStatus().isSucceed()) {
                                                        }
                                                        if (jobContext.isCancelled()) {
                                                        }
                                                        if (!this.mIsHttp2) {
                                                        }
                                                        i56 = i48;
                                                        str60 = str34;
                                                        j29 = j19;
                                                        if (canAttempt()) {
                                                        }
                                                    }
                                                    if (this.okResponse == null) {
                                                        downloadResult.getStatus().setFailed(3);
                                                        j18 = currentTimeMillis22;
                                                        str21 = ", apnProxy=";
                                                        str22 = ", allowProxy=";
                                                        str23 = ", apn=";
                                                        str24 = ", thread=";
                                                        str25 = "null:0";
                                                        str26 = ", localAddress=";
                                                        downloadReport3 = downloadReport;
                                                        str27 = ",";
                                                        str28 = QDLog.TAG_DOWNLOAD;
                                                        i26 = 0;
                                                        httpContext3 = httpContext2;
                                                        str29 = ", useProxy=";
                                                        String str67 = str29;
                                                        int i66 = i17 + 1;
                                                        String str68 = str22;
                                                        downloadResult.getProcess().setDuration(j16, SystemClock.uptimeMillis());
                                                        downloadResult.getProcess().totalDuration = SystemClock.uptimeMillis() - this.mTimeStamp;
                                                        downloadResult.getProcess().startTimestamp = this.mTaskStartTimeStamp;
                                                        NetworkUtils.DNS dns3 = NetworkStatus.getInstance(this.mContext).getDNS();
                                                        DownloadGlobalStrategy.StrategyInfo strategyInfo6 = this.pCurrStrategyInfo;
                                                        String iPInfo = (strategyInfo6 != null || strategyInfo6.getIPInfo() == null) ? str25 : this.pCurrStrategyInfo.getIPInfo().toString();
                                                        String parserHttpHeaderInfo3 = parserHttpHeaderInfo(this.request, this.response, this.okResponse);
                                                        String str69 = iPInfo == null ? iPInfo : WiFiDash.NOT_AVALIBLE;
                                                        if (httpContext3 != null) {
                                                            try {
                                                                str30 = (String) httpContext3.getAttribute("RedirectURI");
                                                            } catch (Exception unused2) {
                                                            }
                                                            downloadResult.getContent().redirectUrl = str30;
                                                            if (downloadResult.getStatus().isSucceed()) {
                                                                str31 = str21;
                                                                str32 = parserHttpHeaderInfo3;
                                                                str33 = str30;
                                                                str34 = str69;
                                                            } else {
                                                                ResumeTransfer resumeTransfer2 = this.pResumeTransfer;
                                                                if (resumeTransfer2 != null) {
                                                                    str34 = str69;
                                                                    str33 = str30;
                                                                    str32 = parserHttpHeaderInfo3;
                                                                    str31 = str21;
                                                                    resumeTransfer2.addCacheTmpFile(getUrl(), downloadResult.getPath(), this.response, this.okResponse);
                                                                } else {
                                                                    str31 = str21;
                                                                    str32 = parserHttpHeaderInfo3;
                                                                    str33 = str30;
                                                                    str34 = str69;
                                                                }
                                                                if (!NetworkUtils.isNetworkAvailable(this.mContext)) {
                                                                    this.mAttemptCurrCount--;
                                                                    downloadResult.getStatus().setFailed(6);
                                                                }
                                                            }
                                                            if (jobContext.isCancelled()) {
                                                                jobContext2 = jobContext;
                                                                downloadResult2 = downloadResult;
                                                                i56 = i66;
                                                                j19 = j18;
                                                                str3 = str28;
                                                                builder = null;
                                                            } else {
                                                                if (!downloadResult.getStatus().isSucceed()) {
                                                                    StringBuilder sb5 = new StringBuilder();
                                                                    sb5.append("Downloader, fail to download:");
                                                                    sb5.append(getUrl());
                                                                    sb5.append(" , requestHttp2=");
                                                                    sb5.append(this.mIsHttp2);
                                                                    sb5.append(",protocol=");
                                                                    if (this.mIsHttp2 && (response2 = this.okResponse) != null && response2.protocol() != null) {
                                                                        str61 = this.okResponse.protocol().getProtocol();
                                                                    }
                                                                    sb5.append(str61);
                                                                    sb5.append(", dns=");
                                                                    sb5.append(dns3);
                                                                    sb5.append(", remoteAddress=");
                                                                    sb5.append(iPInfo);
                                                                    sb5.append(str26);
                                                                    sb5.append(str25);
                                                                    sb5.append(str24);
                                                                    sb5.append(Thread.currentThread().getId());
                                                                    sb5.append(str23);
                                                                    sb5.append(NetworkManager.getApnValue());
                                                                    sb5.append(str68);
                                                                    sb5.append(this.mAllowProxy);
                                                                    sb5.append(str31);
                                                                    sb5.append(this.mAPNProxy);
                                                                    sb5.append(str67);
                                                                    sb5.append(this.mAllowProxy ? NetworkUtils.getProxy(this.mContext, this.mAPNProxy) : null);
                                                                    sb5.append(", netAvailable=");
                                                                    sb5.append(NetworkUtils.isNetworkAvailable(this.mContext));
                                                                    sb5.append(", IpStack=");
                                                                    sb5.append(Config.getNetworkStackType());
                                                                    sb5.append(", contentType=");
                                                                    sb5.append(downloadResult.getContent().type);
                                                                    sb5.append(", duration=");
                                                                    sb5.append(downloadResult.getProcess().duration);
                                                                    sb5.append(", totalDuration=");
                                                                    sb5.append(SystemClock.uptimeMillis() - this.mTimeStamp);
                                                                    sb5.append(str5);
                                                                    sb5.append(downloadResult.getContent().length);
                                                                    sb5.append(", size=");
                                                                    sb5.append(downloadResult.getContent().size);
                                                                    sb5.append(", realsize=");
                                                                    sb5.append(downloadResult.getContent().realsize);
                                                                    sb5.append(", retry=(");
                                                                    sb5.append(this.mAttemptCurrCount);
                                                                    String str70 = str27;
                                                                    sb5.append(str70);
                                                                    sb5.append(this.mAttemptTotalCount);
                                                                    sb5.append("), realretry=(");
                                                                    sb5.append(i66);
                                                                    sb5.append("), reason=");
                                                                    sb5.append(downloadResult.getStatus().getFailReason());
                                                                    sb5.append(", httpStatus=");
                                                                    int i67 = i26;
                                                                    sb5.append(i67);
                                                                    sb5.append(", ");
                                                                    sb5.append(str32);
                                                                    sb5.append(", redirectURI=");
                                                                    sb5.append(str33);
                                                                    sb5.append(", ipUrl:");
                                                                    String str71 = this.mRealUrl;
                                                                    if (str71 != null) {
                                                                        str71 = str71.substring(0, 30);
                                                                    }
                                                                    sb5.append(str71);
                                                                    sb5.append(", strategyId=");
                                                                    DownloadGlobalStrategy.StrategyInfo strategyInfo7 = this.pCurrStrategyInfo;
                                                                    sb5.append(strategyInfo7 != null ? strategyInfo7.f99899id : 0);
                                                                    sb5.append(", clientip=");
                                                                    sb5.append(downloadResult.getContent().clientip);
                                                                    sb5.append(", getIP=");
                                                                    j19 = j18;
                                                                    sb5.append(j19);
                                                                    sb5.append(", connect:(");
                                                                    sb5.append(this.connect_time);
                                                                    sb5.append(str70);
                                                                    sb5.append(this.connect_retry);
                                                                    sb5.append("), exeReqest:(");
                                                                    sb5.append(this.exe_time);
                                                                    sb5.append(str70);
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
                                                                    r36 = 0;
                                                                    QDLog.e(QDLog.TAG_DOWNLOAD_RESULT, sb5.toString(), null);
                                                                    i56 = i66;
                                                                    i27 = i67;
                                                                } else {
                                                                    String str72 = str33;
                                                                    String str73 = str32;
                                                                    String str74 = str31;
                                                                    long j36 = j18;
                                                                    String str75 = str27;
                                                                    int i68 = i26;
                                                                    StringBuilder sb6 = new StringBuilder();
                                                                    sb6.append("Downloader, succeed to download:");
                                                                    sb6.append(getUrl());
                                                                    sb6.append(" , requestHttp2=");
                                                                    sb6.append(this.mIsHttp2);
                                                                    sb6.append(",protocol=");
                                                                    if (this.mIsHttp2 && (response = this.okResponse) != null && response.protocol() != null) {
                                                                        str61 = this.okResponse.protocol().getProtocol();
                                                                    }
                                                                    sb6.append(str61);
                                                                    sb6.append(", dns=");
                                                                    sb6.append(dns3);
                                                                    sb6.append(", remoteAddress=");
                                                                    sb6.append(iPInfo);
                                                                    sb6.append(str26);
                                                                    sb6.append(str25);
                                                                    sb6.append(str24);
                                                                    sb6.append(Thread.currentThread().getId());
                                                                    sb6.append(str23);
                                                                    sb6.append(NetworkManager.getApnValue());
                                                                    sb6.append(str68);
                                                                    sb6.append(this.mAllowProxy);
                                                                    sb6.append(str74);
                                                                    sb6.append(this.mAPNProxy);
                                                                    sb6.append(str67);
                                                                    sb6.append(this.mAllowProxy ? NetworkUtils.getProxy(this.mContext, this.mAPNProxy) : null);
                                                                    sb6.append(", IpStack=");
                                                                    sb6.append(Config.getNetworkStackType());
                                                                    sb6.append(", duration=");
                                                                    sb6.append(downloadResult.getProcess().duration);
                                                                    sb6.append(", totalDuration=");
                                                                    sb6.append(SystemClock.uptimeMillis() - this.mTimeStamp);
                                                                    sb6.append(str5);
                                                                    sb6.append(downloadResult.getContent().length);
                                                                    sb6.append(", size=");
                                                                    sb6.append(downloadResult.getContent().size);
                                                                    sb6.append(", realsize=");
                                                                    sb6.append(downloadResult.getContent().realsize);
                                                                    sb6.append(", retry=(");
                                                                    sb6.append(this.mAttemptCurrCount);
                                                                    sb6.append(str75);
                                                                    sb6.append(this.mAttemptTotalCount);
                                                                    sb6.append("), realretry=(");
                                                                    i56 = i66;
                                                                    sb6.append(i56);
                                                                    sb6.append("), httpStatus=");
                                                                    i27 = i68;
                                                                    sb6.append(i27);
                                                                    sb6.append(", contentType=");
                                                                    sb6.append(downloadResult.getContent().type);
                                                                    sb6.append(", ");
                                                                    sb6.append(str73);
                                                                    sb6.append(", redirectURI=");
                                                                    sb6.append(str72);
                                                                    sb6.append(", ipUrl:");
                                                                    String str76 = this.mRealUrl;
                                                                    if (str76 != null) {
                                                                        str76 = str76.substring(0, 30);
                                                                    }
                                                                    sb6.append(str76);
                                                                    sb6.append(", strategyId=");
                                                                    DownloadGlobalStrategy.StrategyInfo strategyInfo8 = this.pCurrStrategyInfo;
                                                                    sb6.append(strategyInfo8 != null ? strategyInfo8.f99899id : 0);
                                                                    sb6.append(", clientip=");
                                                                    sb6.append(downloadResult.getContent().clientip);
                                                                    sb6.append(", getIP=");
                                                                    j19 = j36;
                                                                    sb6.append(j19);
                                                                    sb6.append(", connect:(");
                                                                    sb6.append(this.connect_time);
                                                                    sb6.append(str75);
                                                                    sb6.append(this.connect_retry);
                                                                    sb6.append("), exeReqest:(");
                                                                    sb6.append(this.exe_time);
                                                                    sb6.append(str75);
                                                                    sb6.append(this.exe_retry);
                                                                    sb6.append("), sendReq=");
                                                                    sb6.append(this.send_req_time);
                                                                    sb6.append(", recvData=");
                                                                    sb6.append(this.t_recv_data);
                                                                    sb6.append(", Concurrent:(");
                                                                    sb6.append(getTaskConcurrentCount());
                                                                    sb6.append("), mobileProxy=");
                                                                    DownloadTask.DownloadTaskHandler downloadTaskHandler3 = this.mDownloadTaskHandler;
                                                                    sb6.append(downloadTaskHandler3 != null ? downloadTaskHandler3.getCustomProxy() : null);
                                                                    r36 = 0;
                                                                    QDLog.w(QDLog.TAG_DOWNLOAD_RESULT, sb6.toString(), null);
                                                                }
                                                                DownloadGlobalStrategy.StrategyInfo strategyInfo9 = this.pCurrStrategyInfo;
                                                                if (strategyInfo9 != null && DownloadGlobalStrategy.Strategy_BACKUPIP.f99899id == strategyInfo9.f99899id && (iPStrategy2 = this.pBackupIPConfigStrategy) != null) {
                                                                    try {
                                                                        iPStrategy2.onIPAccessResult(getDomain(), Utils.getDomin(this.mRealUrl), downloadResult.getStatus().isSucceed());
                                                                    } catch (Exception e16) {
                                                                        str3 = str28;
                                                                        QDLog.w(str3, "Strategy_BACKUPIP", e16);
                                                                    }
                                                                }
                                                                str3 = str28;
                                                                DownloadGlobalStrategy.StrategyInfo strategyInfo10 = this.pCurrStrategyInfo;
                                                                if (strategyInfo10 != null && DownloadGlobalStrategy.Strategy_DomainDirect.f99899id == strategyInfo10.f99899id && (iPStrategy = this.pDirectIPConfigStrategy) != null) {
                                                                    try {
                                                                        iPStrategy.onIPAccessResult(getDomain(), Utils.getDomin(this.mRealUrl), downloadResult.getStatus().isSucceed());
                                                                    } catch (Exception e17) {
                                                                        QDLog.w(str3, "Strategy_DomainDirect", e17);
                                                                    }
                                                                }
                                                                DownloadReport downloadReport6 = downloadReport3;
                                                                downloadReport6.endTime = System.currentTimeMillis();
                                                                downloadReport6.fileSize = this.mContentLength;
                                                                downloadReport6.response = this.response;
                                                                downloadReport6.httpStatus = i27;
                                                                downloadReport6.exception = r36;
                                                                downloadReport6.dns = dns3 == null ? r36 : dns3.toString();
                                                                DownloadGlobalStrategy.StrategyInfo strategyInfo11 = this.pCurrStrategyInfo;
                                                                downloadReport6.remoteAddress = (strategyInfo11 == null || strategyInfo11.getIPInfo() == null) ? r36 : this.pCurrStrategyInfo.getIPInfo().f99897ip;
                                                                downloadReport6.localAddress = str25;
                                                                downloadReport6.clientip = downloadResult.getContent().clientip;
                                                                downloadReport6.totaltime = SystemClock.uptimeMillis() - this.mTimeStamp;
                                                                downloadReport6.downloadTime = downloadResult.getProcess().duration;
                                                                downloadReport6.t_wait = downloadReport6.totaltime - downloadResult.getProcess().duration;
                                                                downloadReport6.t_prepare = j19;
                                                                downloadReport6.t_conn = this.connect_time;
                                                                downloadReport6.t_recvrsp = this.send_req_time;
                                                                downloadReport6.t_recvdata = this.t_recv_data;
                                                                downloadReport6.t_process = 0L;
                                                                downloadReport6.concurrent = getTaskConcurrentCount();
                                                                downloadReport6.content_type = downloadResult.getContent().type;
                                                                downloadReport6.isFromQzoneAlbum = Config.isFromQzoneAlbum(getDomain());
                                                                downloadReport6.isHttp2 = this.mIsHttp2;
                                                                String str77 = this.mRealUrl;
                                                                downloadReport6.isHttps = str77 != null && str77.startsWith("https");
                                                                downloadReport6.isSucceed = downloadResult.getStatus().isSucceed();
                                                                downloadReport6.downloadMode = Downloader.DownloadMode.StrictMode.ordinal();
                                                                Response response10 = this.okResponse;
                                                                if (response10 != null && response10.protocol() != null) {
                                                                    downloadReport6.f99896protocol = this.okResponse.protocol().getProtocol();
                                                                }
                                                                downloadResult2 = downloadResult;
                                                                downloadResult2.setReport(downloadReport6);
                                                                if (this.mAttemptCurrCount == this.mAttemptTotalCount - 1 || downloadResult.getStatus().isSucceed()) {
                                                                    jobContext2 = jobContext;
                                                                    handleDownloadReportForTask(jobContext2, downloadResult2, downloadReport6);
                                                                    builder = r36;
                                                                } else {
                                                                    jobContext2 = jobContext;
                                                                    builder = r36;
                                                                }
                                                            }
                                                            if (this.mIsHttp2) {
                                                                Call call = this.okRequestCall;
                                                                if (call != null) {
                                                                    call.cancel();
                                                                }
                                                                this.okRequestBuilder = builder;
                                                            } else {
                                                                HttpGet httpGet = this.request;
                                                                if (httpGet != null) {
                                                                    httpGet.abort();
                                                                }
                                                            }
                                                            jobContext3 = jobContext2;
                                                            str60 = str34;
                                                            j29 = j19;
                                                            if (canAttempt()) {
                                                            }
                                                        }
                                                        str30 = "";
                                                        downloadResult.getContent().redirectUrl = str30;
                                                        if (downloadResult.getStatus().isSucceed()) {
                                                        }
                                                        if (jobContext.isCancelled()) {
                                                        }
                                                        if (this.mIsHttp2) {
                                                        }
                                                        jobContext3 = jobContext2;
                                                        str60 = str34;
                                                        j29 = j19;
                                                        if (canAttempt()) {
                                                        }
                                                    }
                                                }
                                                if (httpResponse == null) {
                                                    code = httpResponse.getStatusLine().getStatusCode();
                                                } else {
                                                    Response response11 = this.okResponse;
                                                    if (response11 != null) {
                                                        code = response11.code();
                                                    } else {
                                                        i28 = 0;
                                                        downloadResult.getStatus().httpStatus = i28;
                                                        if (200 == i28 && 206 != i28) {
                                                            try {
                                                                printfHttpDetail(this.request, this.okRequestBuilder, this.response, this.okResponse);
                                                                if (getRetryFlag(this.response, this.okResponse) == 0) {
                                                                    setAttemptCount(0);
                                                                }
                                                                if (404 == i28 && ((xErrorCode = getXErrorCode(this.response, this.okResponse)) == -6101 || xErrorCode == -5062 || xErrorCode == -5023)) {
                                                                    setAttemptCount(0);
                                                                }
                                                                downloadResult.getStatus().setFailed(3);
                                                                ResumeTransfer resumeTransfer3 = this.pResumeTransfer;
                                                                if (resumeTransfer3 != null) {
                                                                    resumeTransfer3.onDownloadResult(getUrl(), true);
                                                                }
                                                                i29 = i28;
                                                                j18 = currentTimeMillis22;
                                                                str21 = ", apnProxy=";
                                                                str22 = ", allowProxy=";
                                                                str23 = ", apn=";
                                                                str24 = ", thread=";
                                                                str25 = "null:0";
                                                                str26 = ", localAddress=";
                                                                downloadReport3 = downloadReport;
                                                                str27 = ",";
                                                                str28 = QDLog.TAG_DOWNLOAD;
                                                                httpContext3 = httpContext2;
                                                                str29 = ", useProxy=";
                                                            } catch (Throwable th19) {
                                                                th = th19;
                                                                i18 = i28;
                                                                httpContext = httpContext2;
                                                                j17 = currentTimeMillis22;
                                                                str10 = ", allowProxy=";
                                                                str11 = ", apn=";
                                                                str16 = ", thread=";
                                                                str12 = "null:0";
                                                                str17 = QDLog.TAG_DOWNLOAD_RESULT;
                                                                str7 = ", localAddress=";
                                                                str6 = ",";
                                                                str4 = QDLog.TAG_DOWNLOAD;
                                                                th5 = th;
                                                                str15 = ", IpStack=";
                                                                str18 = ", apnProxy=";
                                                                str14 = ", duration=";
                                                                str13 = ", totalDuration=";
                                                                str19 = ", useProxy=";
                                                                downloadResult.getStatus().setFailed(th5);
                                                                str53 = this.mRealUrl;
                                                                th6 = th5;
                                                                if (str53 != null) {
                                                                }
                                                                str54 = str17;
                                                                int i57222222 = i17 + 1;
                                                                String str62222222 = str16;
                                                                downloadResult.getProcess().setDuration(j16, SystemClock.uptimeMillis());
                                                                downloadResult.getProcess().totalDuration = SystemClock.uptimeMillis() - this.mTimeStamp;
                                                                downloadResult.getProcess().startTimestamp = this.mTaskStartTimeStamp;
                                                                NetworkUtils.DNS dns222222 = NetworkStatus.getInstance(this.mContext).getDNS();
                                                                DownloadGlobalStrategy.StrategyInfo strategyInfo4222222 = this.pCurrStrategyInfo;
                                                                if (strategyInfo4222222 != null) {
                                                                }
                                                                String parserHttpHeaderInfo222222 = parserHttpHeaderInfo(this.request, this.response, this.okResponse);
                                                                if (r0 != null) {
                                                                }
                                                                if (httpContext != null) {
                                                                }
                                                                str55 = "";
                                                                downloadResult.getContent().redirectUrl = str55;
                                                                if (downloadResult.getStatus().isSucceed()) {
                                                                }
                                                                if (jobContext.isCancelled()) {
                                                                }
                                                                if (!this.mIsHttp2) {
                                                                }
                                                                i56 = i48;
                                                                str60 = str34;
                                                                j29 = j19;
                                                                if (canAttempt()) {
                                                                }
                                                            }
                                                        } else {
                                                            i29 = i28;
                                                            httpContext3 = httpContext2;
                                                            if (handleResponse(this.response, this.okResponse, downloadResult, jobContext, i29)) {
                                                                try {
                                                                    downloadResult.getStatus().setSucceed();
                                                                    int i69 = i17 + 1;
                                                                    downloadResult.getProcess().setDuration(j16, SystemClock.uptimeMillis());
                                                                    downloadResult.getProcess().totalDuration = SystemClock.uptimeMillis() - this.mTimeStamp;
                                                                    downloadResult.getProcess().startTimestamp = this.mTaskStartTimeStamp;
                                                                    NetworkUtils.DNS dns4 = NetworkStatus.getInstance(this.mContext).getDNS();
                                                                    DownloadGlobalStrategy.StrategyInfo strategyInfo12 = this.pCurrStrategyInfo;
                                                                    String iPInfo2 = (strategyInfo12 == null || strategyInfo12.getIPInfo() == null) ? "null:0" : this.pCurrStrategyInfo.getIPInfo().toString();
                                                                    String parserHttpHeaderInfo4 = parserHttpHeaderInfo(this.request, this.response, this.okResponse);
                                                                    String str78 = iPInfo2 != null ? iPInfo2 : WiFiDash.NOT_AVALIBLE;
                                                                    if (httpContext3 != null) {
                                                                        try {
                                                                            str35 = (String) httpContext3.getAttribute("RedirectURI");
                                                                        } catch (Exception unused3) {
                                                                        }
                                                                        downloadResult.getContent().redirectUrl = str35;
                                                                        if (!downloadResult.getStatus().isSucceed()) {
                                                                            ResumeTransfer resumeTransfer4 = this.pResumeTransfer;
                                                                            if (resumeTransfer4 != null) {
                                                                                resumeTransfer4.addCacheTmpFile(getUrl(), downloadResult.getPath(), this.response, this.okResponse);
                                                                            }
                                                                            if (!NetworkUtils.isNetworkAvailable(this.mContext)) {
                                                                                this.mAttemptCurrCount--;
                                                                                downloadResult.getStatus().setFailed(6);
                                                                            }
                                                                        }
                                                                        if (jobContext.isCancelled()) {
                                                                            if (!downloadResult.getStatus().isSucceed()) {
                                                                                StringBuilder sb7 = new StringBuilder();
                                                                                sb7.append("Downloader, fail to download:");
                                                                                sb7.append(getUrl());
                                                                                sb7.append(" , requestHttp2=");
                                                                                sb7.append(this.mIsHttp2);
                                                                                sb7.append(",protocol=");
                                                                                if (this.mIsHttp2 && (response4 = this.okResponse) != null && response4.protocol() != null) {
                                                                                    str61 = this.okResponse.protocol().getProtocol();
                                                                                }
                                                                                sb7.append(str61);
                                                                                sb7.append(", dns=");
                                                                                sb7.append(dns4);
                                                                                sb7.append(", remoteAddress=");
                                                                                sb7.append(iPInfo2);
                                                                                sb7.append(", localAddress=");
                                                                                str38 = "null:0";
                                                                                sb7.append(str38);
                                                                                sb7.append(", thread=");
                                                                                sb7.append(Thread.currentThread().getId());
                                                                                sb7.append(", apn=");
                                                                                sb7.append(NetworkManager.getApnValue());
                                                                                sb7.append(", allowProxy=");
                                                                                sb7.append(this.mAllowProxy);
                                                                                sb7.append(", apnProxy=");
                                                                                sb7.append(this.mAPNProxy);
                                                                                sb7.append(", useProxy=");
                                                                                sb7.append(this.mAllowProxy ? NetworkUtils.getProxy(this.mContext, this.mAPNProxy) : null);
                                                                                sb7.append(", netAvailable=");
                                                                                sb7.append(NetworkUtils.isNetworkAvailable(this.mContext));
                                                                                sb7.append(", IpStack=");
                                                                                sb7.append(Config.getNetworkStackType());
                                                                                sb7.append(", contentType=");
                                                                                sb7.append(downloadResult.getContent().type);
                                                                                sb7.append(", duration=");
                                                                                sb7.append(downloadResult.getProcess().duration);
                                                                                sb7.append(", totalDuration=");
                                                                                sb7.append(SystemClock.uptimeMillis() - this.mTimeStamp);
                                                                                sb7.append(str5);
                                                                                sb7.append(downloadResult.getContent().length);
                                                                                sb7.append(", size=");
                                                                                sb7.append(downloadResult.getContent().size);
                                                                                sb7.append(", realsize=");
                                                                                sb7.append(downloadResult.getContent().realsize);
                                                                                sb7.append(", retry=(");
                                                                                sb7.append(this.mAttemptCurrCount);
                                                                                sb7.append(",");
                                                                                sb7.append(this.mAttemptTotalCount);
                                                                                sb7.append("), realretry=(");
                                                                                sb7.append(i69);
                                                                                sb7.append("), reason=");
                                                                                sb7.append(downloadResult.getStatus().getFailReason());
                                                                                sb7.append(", httpStatus=");
                                                                                sb7.append(i29);
                                                                                sb7.append(", ");
                                                                                sb7.append(parserHttpHeaderInfo4);
                                                                                sb7.append(", redirectURI=");
                                                                                sb7.append(str35);
                                                                                sb7.append(", ipUrl:");
                                                                                String str79 = this.mRealUrl;
                                                                                if (str79 != null) {
                                                                                    str79 = str79.substring(0, 30);
                                                                                }
                                                                                sb7.append(str79);
                                                                                sb7.append(", strategyId=");
                                                                                DownloadGlobalStrategy.StrategyInfo strategyInfo13 = this.pCurrStrategyInfo;
                                                                                sb7.append(strategyInfo13 != null ? strategyInfo13.f99899id : 0);
                                                                                sb7.append(", clientip=");
                                                                                sb7.append(downloadResult.getContent().clientip);
                                                                                sb7.append(", getIP=");
                                                                                sb7.append(currentTimeMillis22);
                                                                                sb7.append(", connect:(");
                                                                                sb7.append(this.connect_time);
                                                                                sb7.append(",");
                                                                                sb7.append(this.connect_retry);
                                                                                sb7.append("), exeReqest:(");
                                                                                sb7.append(this.exe_time);
                                                                                sb7.append(",");
                                                                                sb7.append(this.exe_retry);
                                                                                sb7.append("), sendReq=");
                                                                                sb7.append(this.send_req_time);
                                                                                sb7.append(", recvData=");
                                                                                sb7.append(this.t_recv_data);
                                                                                sb7.append(", Concurrent:(");
                                                                                sb7.append(getTaskConcurrentCount());
                                                                                sb7.append("), mobileProxy=");
                                                                                DownloadTask.DownloadTaskHandler downloadTaskHandler4 = this.mDownloadTaskHandler;
                                                                                sb7.append(downloadTaskHandler4 != null ? downloadTaskHandler4.getCustomProxy() : null);
                                                                                QDLog.e(QDLog.TAG_DOWNLOAD_RESULT, sb7.toString(), null);
                                                                                str36 = str78;
                                                                                i36 = i29;
                                                                                j26 = currentTimeMillis22;
                                                                                r37 = 0;
                                                                            } else {
                                                                                String str80 = str35;
                                                                                str38 = "null:0";
                                                                                str36 = str78;
                                                                                StringBuilder sb8 = new StringBuilder();
                                                                                sb8.append("Downloader, succeed to download:");
                                                                                sb8.append(getUrl());
                                                                                sb8.append(" , requestHttp2=");
                                                                                sb8.append(this.mIsHttp2);
                                                                                sb8.append(",protocol=");
                                                                                if (this.mIsHttp2 && (response3 = this.okResponse) != null && response3.protocol() != null) {
                                                                                    str61 = this.okResponse.protocol().getProtocol();
                                                                                }
                                                                                sb8.append(str61);
                                                                                sb8.append(", dns=");
                                                                                sb8.append(dns4);
                                                                                sb8.append(", remoteAddress=");
                                                                                sb8.append(iPInfo2);
                                                                                sb8.append(", localAddress=");
                                                                                sb8.append(str38);
                                                                                sb8.append(", thread=");
                                                                                sb8.append(Thread.currentThread().getId());
                                                                                sb8.append(", apn=");
                                                                                sb8.append(NetworkManager.getApnValue());
                                                                                sb8.append(", allowProxy=");
                                                                                sb8.append(this.mAllowProxy);
                                                                                sb8.append(", apnProxy=");
                                                                                sb8.append(this.mAPNProxy);
                                                                                sb8.append(", useProxy=");
                                                                                sb8.append(this.mAllowProxy ? NetworkUtils.getProxy(this.mContext, this.mAPNProxy) : null);
                                                                                sb8.append(", IpStack=");
                                                                                sb8.append(Config.getNetworkStackType());
                                                                                sb8.append(", duration=");
                                                                                sb8.append(downloadResult.getProcess().duration);
                                                                                sb8.append(", totalDuration=");
                                                                                sb8.append(SystemClock.uptimeMillis() - this.mTimeStamp);
                                                                                sb8.append(str5);
                                                                                sb8.append(downloadResult.getContent().length);
                                                                                sb8.append(", size=");
                                                                                sb8.append(downloadResult.getContent().size);
                                                                                sb8.append(", realsize=");
                                                                                sb8.append(downloadResult.getContent().realsize);
                                                                                sb8.append(", retry=(");
                                                                                sb8.append(this.mAttemptCurrCount);
                                                                                sb8.append(",");
                                                                                sb8.append(this.mAttemptTotalCount);
                                                                                sb8.append("), realretry=(");
                                                                                i69 = i69;
                                                                                sb8.append(i69);
                                                                                sb8.append("), httpStatus=");
                                                                                i36 = i29;
                                                                                sb8.append(i36);
                                                                                sb8.append(", contentType=");
                                                                                sb8.append(downloadResult.getContent().type);
                                                                                sb8.append(", ");
                                                                                sb8.append(parserHttpHeaderInfo4);
                                                                                sb8.append(", redirectURI=");
                                                                                sb8.append(str80);
                                                                                sb8.append(", ipUrl:");
                                                                                String str81 = this.mRealUrl;
                                                                                if (str81 != null) {
                                                                                    str81 = str81.substring(0, 30);
                                                                                }
                                                                                sb8.append(str81);
                                                                                sb8.append(", strategyId=");
                                                                                DownloadGlobalStrategy.StrategyInfo strategyInfo14 = this.pCurrStrategyInfo;
                                                                                sb8.append(strategyInfo14 != null ? strategyInfo14.f99899id : 0);
                                                                                sb8.append(", clientip=");
                                                                                sb8.append(downloadResult.getContent().clientip);
                                                                                sb8.append(", getIP=");
                                                                                j26 = currentTimeMillis22;
                                                                                sb8.append(j26);
                                                                                sb8.append(", connect:(");
                                                                                sb8.append(this.connect_time);
                                                                                sb8.append(",");
                                                                                sb8.append(this.connect_retry);
                                                                                sb8.append("), exeReqest:(");
                                                                                sb8.append(this.exe_time);
                                                                                sb8.append(",");
                                                                                sb8.append(this.exe_retry);
                                                                                sb8.append("), sendReq=");
                                                                                sb8.append(this.send_req_time);
                                                                                sb8.append(", recvData=");
                                                                                sb8.append(this.t_recv_data);
                                                                                sb8.append(", Concurrent:(");
                                                                                sb8.append(getTaskConcurrentCount());
                                                                                sb8.append("), mobileProxy=");
                                                                                DownloadTask.DownloadTaskHandler downloadTaskHandler5 = this.mDownloadTaskHandler;
                                                                                sb8.append(downloadTaskHandler5 != null ? downloadTaskHandler5.getCustomProxy() : null);
                                                                                r37 = 0;
                                                                                QDLog.w(QDLog.TAG_DOWNLOAD_RESULT, sb8.toString(), null);
                                                                            }
                                                                            DownloadGlobalStrategy.StrategyInfo strategyInfo15 = this.pCurrStrategyInfo;
                                                                            if (strategyInfo15 != null && DownloadGlobalStrategy.Strategy_BACKUPIP.f99899id == strategyInfo15.f99899id && (iPStrategy4 = this.pBackupIPConfigStrategy) != null) {
                                                                                try {
                                                                                    iPStrategy4.onIPAccessResult(getDomain(), Utils.getDomin(this.mRealUrl), downloadResult.getStatus().isSucceed());
                                                                                } catch (Exception e18) {
                                                                                    str37 = QDLog.TAG_DOWNLOAD;
                                                                                    QDLog.w(str37, "Strategy_BACKUPIP", e18);
                                                                                }
                                                                            }
                                                                            str37 = QDLog.TAG_DOWNLOAD;
                                                                            DownloadGlobalStrategy.StrategyInfo strategyInfo16 = this.pCurrStrategyInfo;
                                                                            if (strategyInfo16 != null && DownloadGlobalStrategy.Strategy_DomainDirect.f99899id == strategyInfo16.f99899id && (iPStrategy3 = this.pDirectIPConfigStrategy) != null) {
                                                                                try {
                                                                                    iPStrategy3.onIPAccessResult(getDomain(), Utils.getDomin(this.mRealUrl), downloadResult.getStatus().isSucceed());
                                                                                } catch (Exception e19) {
                                                                                    QDLog.w(str37, "Strategy_DomainDirect", e19);
                                                                                }
                                                                            }
                                                                            downloadReport.endTime = System.currentTimeMillis();
                                                                            downloadReport.fileSize = this.mContentLength;
                                                                            downloadReport.response = this.response;
                                                                            downloadReport.httpStatus = i36;
                                                                            downloadReport.exception = r37;
                                                                            downloadReport.dns = dns4 == null ? r37 : dns4.toString();
                                                                            DownloadGlobalStrategy.StrategyInfo strategyInfo17 = this.pCurrStrategyInfo;
                                                                            downloadReport.remoteAddress = (strategyInfo17 == null || strategyInfo17.getIPInfo() == null) ? r37 : this.pCurrStrategyInfo.getIPInfo().f99897ip;
                                                                            downloadReport.localAddress = str38;
                                                                            downloadReport.clientip = downloadResult.getContent().clientip;
                                                                            downloadReport.totaltime = SystemClock.uptimeMillis() - this.mTimeStamp;
                                                                            downloadReport.downloadTime = downloadResult.getProcess().duration;
                                                                            downloadReport.t_wait = downloadReport.totaltime - downloadResult.getProcess().duration;
                                                                            downloadReport.t_prepare = j26;
                                                                            downloadReport.t_conn = this.connect_time;
                                                                            downloadReport.t_recvrsp = this.send_req_time;
                                                                            downloadReport.t_recvdata = this.t_recv_data;
                                                                            downloadReport.t_process = 0L;
                                                                            downloadReport.concurrent = getTaskConcurrentCount();
                                                                            downloadReport.content_type = downloadResult.getContent().type;
                                                                            downloadReport.isFromQzoneAlbum = Config.isFromQzoneAlbum(getDomain());
                                                                            downloadReport.isHttp2 = this.mIsHttp2;
                                                                            String str82 = this.mRealUrl;
                                                                            downloadReport.isHttps = str82 != null && str82.startsWith("https");
                                                                            downloadReport.isSucceed = downloadResult.getStatus().isSucceed();
                                                                            downloadReport.downloadMode = Downloader.DownloadMode.StrictMode.ordinal();
                                                                            Response response12 = this.okResponse;
                                                                            if (response12 != null && response12.protocol() != null) {
                                                                                downloadReport.f99896protocol = this.okResponse.protocol().getProtocol();
                                                                            }
                                                                            downloadResult2 = downloadResult;
                                                                            downloadResult2.setReport(downloadReport);
                                                                            if (this.mAttemptCurrCount != this.mAttemptTotalCount - 1) {
                                                                                builder2 = r37;
                                                                            }
                                                                            handleDownloadReportForTask(jobContext, downloadResult2, downloadReport);
                                                                            builder2 = r37;
                                                                        } else {
                                                                            downloadResult2 = downloadResult;
                                                                            str36 = str78;
                                                                            str37 = QDLog.TAG_DOWNLOAD;
                                                                            builder2 = null;
                                                                        }
                                                                        if (!this.mIsHttp2) {
                                                                            Call call2 = this.okRequestCall;
                                                                            if (call2 != null) {
                                                                                call2.cancel();
                                                                            }
                                                                            this.okRequestBuilder = builder2;
                                                                        } else {
                                                                            HttpGet httpGet2 = this.request;
                                                                            if (httpGet2 != null) {
                                                                                httpGet2.abort();
                                                                            }
                                                                        }
                                                                        str3 = str37;
                                                                        i3 = i69;
                                                                        str2 = str36;
                                                                    }
                                                                    str35 = "";
                                                                    downloadResult.getContent().redirectUrl = str35;
                                                                    if (!downloadResult.getStatus().isSucceed()) {
                                                                    }
                                                                    if (jobContext.isCancelled()) {
                                                                    }
                                                                    if (!this.mIsHttp2) {
                                                                    }
                                                                    str3 = str37;
                                                                    i3 = i69;
                                                                    str2 = str36;
                                                                } catch (Throwable th20) {
                                                                    str11 = ", apn=";
                                                                    str16 = ", thread=";
                                                                    str7 = ", localAddress=";
                                                                    httpContext = httpContext3;
                                                                    i18 = i29;
                                                                    str18 = ", apnProxy=";
                                                                    str10 = ", allowProxy=";
                                                                    str12 = "null:0";
                                                                    str17 = QDLog.TAG_DOWNLOAD_RESULT;
                                                                    str6 = ",";
                                                                    str4 = QDLog.TAG_DOWNLOAD;
                                                                    j17 = currentTimeMillis22;
                                                                    th5 = th20;
                                                                    str14 = ", duration=";
                                                                    str15 = ", IpStack=";
                                                                    str13 = ", totalDuration=";
                                                                    str19 = ", useProxy=";
                                                                    downloadResult.getStatus().setFailed(th5);
                                                                    str53 = this.mRealUrl;
                                                                    th6 = th5;
                                                                    if (str53 != null) {
                                                                    }
                                                                    str54 = str17;
                                                                    int i572222222 = i17 + 1;
                                                                    String str622222222 = str16;
                                                                    downloadResult.getProcess().setDuration(j16, SystemClock.uptimeMillis());
                                                                    downloadResult.getProcess().totalDuration = SystemClock.uptimeMillis() - this.mTimeStamp;
                                                                    downloadResult.getProcess().startTimestamp = this.mTaskStartTimeStamp;
                                                                    NetworkUtils.DNS dns2222222 = NetworkStatus.getInstance(this.mContext).getDNS();
                                                                    DownloadGlobalStrategy.StrategyInfo strategyInfo42222222 = this.pCurrStrategyInfo;
                                                                    if (strategyInfo42222222 != null) {
                                                                    }
                                                                    String parserHttpHeaderInfo2222222 = parserHttpHeaderInfo(this.request, this.response, this.okResponse);
                                                                    if (r0 != null) {
                                                                    }
                                                                    if (httpContext != null) {
                                                                    }
                                                                    str55 = "";
                                                                    downloadResult.getContent().redirectUrl = str55;
                                                                    if (downloadResult.getStatus().isSucceed()) {
                                                                    }
                                                                    if (jobContext.isCancelled()) {
                                                                    }
                                                                    if (!this.mIsHttp2) {
                                                                    }
                                                                    i56 = i48;
                                                                    str60 = str34;
                                                                    j29 = j19;
                                                                    if (canAttempt()) {
                                                                    }
                                                                }
                                                            } else {
                                                                str29 = ", useProxy=";
                                                                str21 = ", apnProxy=";
                                                                str22 = ", allowProxy=";
                                                                str23 = ", apn=";
                                                                str24 = ", thread=";
                                                                str25 = "null:0";
                                                                j18 = currentTimeMillis22;
                                                                str26 = ", localAddress=";
                                                                downloadReport3 = downloadReport;
                                                                str27 = ",";
                                                                str28 = QDLog.TAG_DOWNLOAD;
                                                            }
                                                        }
                                                        i26 = i29;
                                                        String str672 = str29;
                                                        int i662 = i17 + 1;
                                                        String str682 = str22;
                                                        downloadResult.getProcess().setDuration(j16, SystemClock.uptimeMillis());
                                                        downloadResult.getProcess().totalDuration = SystemClock.uptimeMillis() - this.mTimeStamp;
                                                        downloadResult.getProcess().startTimestamp = this.mTaskStartTimeStamp;
                                                        NetworkUtils.DNS dns32 = NetworkStatus.getInstance(this.mContext).getDNS();
                                                        DownloadGlobalStrategy.StrategyInfo strategyInfo62 = this.pCurrStrategyInfo;
                                                        if (strategyInfo62 != null) {
                                                        }
                                                        String parserHttpHeaderInfo32 = parserHttpHeaderInfo(this.request, this.response, this.okResponse);
                                                        if (iPInfo == null) {
                                                        }
                                                        if (httpContext3 != null) {
                                                        }
                                                        str30 = "";
                                                        downloadResult.getContent().redirectUrl = str30;
                                                        if (downloadResult.getStatus().isSucceed()) {
                                                        }
                                                        if (jobContext.isCancelled()) {
                                                        }
                                                        if (this.mIsHttp2) {
                                                        }
                                                        jobContext3 = jobContext2;
                                                        str60 = str34;
                                                        j29 = j19;
                                                        if (canAttempt()) {
                                                        }
                                                    }
                                                }
                                                i28 = code;
                                                downloadResult.getStatus().httpStatus = i28;
                                                if (200 == i28) {
                                                }
                                                i29 = i28;
                                                httpContext3 = httpContext2;
                                                if (handleResponse(this.response, this.okResponse, downloadResult, jobContext, i29)) {
                                                }
                                            }
                                            str20 = domain;
                                            downloadReport5.strategyInfo = this.pCurrStrategyInfo.toString();
                                            if (QDLog.isDebugEnable()) {
                                            }
                                            strategyInfo2 = this.pCurrStrategyInfo;
                                            if (strategyInfo2 != null) {
                                            }
                                            if (!this.mIsHttp2) {
                                            }
                                            resumeTransfer = this.pResumeTransfer;
                                            if (resumeTransfer == null) {
                                            }
                                            prepareRequest(getUrl(), getDomain(), this.request, this.okRequestBuilder);
                                            downloadReport = downloadReport2;
                                            j16 = uptimeMillis2;
                                            str5 = ", contentLength=";
                                            i17 = i19;
                                            applyKeepAliveStrategy(getUrl(), getDomain(), this.request, this.okRequestBuilder, requestOptions);
                                            long currentTimeMillis222 = System.currentTimeMillis() - currentTimeMillis;
                                            this.send_req_time = 0L;
                                            long uptimeMillis322 = SystemClock.uptimeMillis();
                                            if (this.request == null) {
                                            }
                                            this.send_req_time = SystemClock.uptimeMillis() - uptimeMillis322;
                                            httpResponse = this.response;
                                            if (httpResponse == null) {
                                            }
                                            if (httpResponse == null) {
                                            }
                                            i28 = code;
                                            downloadResult.getStatus().httpStatus = i28;
                                            if (200 == i28) {
                                            }
                                            i29 = i28;
                                            httpContext3 = httpContext2;
                                            if (handleResponse(this.response, this.okResponse, downloadResult, jobContext, i29)) {
                                            }
                                        }
                                        if (!NetworkUtils.isNetworkAvailable(this.mContext)) {
                                            downloadResult.getStatus().setFailed(6);
                                        }
                                        downloadResult2.setDescInfo(generateDownloadDescInfo(downloadResult.getStatus().getFailReason(), downloadResult.getStatus().httpStatus, i3, NetworkManager.getApnValue(), str, downloadResult.getContent().type, str2));
                                        return;
                                    }
                                } else {
                                    i19 = i56;
                                }
                                if (this.pCurrStrategyInfo != null && this.mRealUrl.startsWith("https") && isIpV6Stack && enableIpv6Debug) {
                                    this.mRealUrl = this.mRealUrl.replaceFirst("https://", "http://");
                                    int i75 = this.mOrigPort;
                                    if (i75 > 0) {
                                        this.pCurrStrategyInfo.getIPInfo().port = i75;
                                    } else {
                                        i75 = this.pCurrStrategyInfo.getIPInfo().port;
                                    }
                                    if (!Utils.isPortValid(i75)) {
                                        i75 = 80;
                                    }
                                    String str83 = "[240e:ff:f040:28::23]:" + i75;
                                    String str84 = this.mDomainWithPort;
                                    if (str84 != null) {
                                        this.mRealUrl = this.mRealUrl.replaceFirst(str84, str83);
                                    }
                                    downloadReport5.strategyInfo = this.pCurrStrategyInfo.toString();
                                    if (QDLog.isDebugEnable()) {
                                        QDLog.d(QDLog.TAG_DOWNLOAD, "downloader strategy run: " + downloadReport5.strategyInfo + " domain: url:" + getUrl() + " threadId:" + Thread.currentThread().getId());
                                    }
                                }
                                strategyInfo2 = this.pCurrStrategyInfo;
                                if (strategyInfo2 != null) {
                                }
                                if (!this.mIsHttp2) {
                                }
                                resumeTransfer = this.pResumeTransfer;
                                if (resumeTransfer == null) {
                                }
                                prepareRequest(getUrl(), getDomain(), this.request, this.okRequestBuilder);
                                downloadReport = downloadReport2;
                                j16 = uptimeMillis2;
                                str5 = ", contentLength=";
                                i17 = i19;
                                applyKeepAliveStrategy(getUrl(), getDomain(), this.request, this.okRequestBuilder, requestOptions);
                                long currentTimeMillis2222 = System.currentTimeMillis() - currentTimeMillis;
                                this.send_req_time = 0L;
                                long uptimeMillis3222 = SystemClock.uptimeMillis();
                                if (this.request == null) {
                                }
                                this.send_req_time = SystemClock.uptimeMillis() - uptimeMillis3222;
                                httpResponse = this.response;
                                if (httpResponse == null) {
                                }
                                if (httpResponse == null) {
                                }
                                i28 = code;
                                downloadResult.getStatus().httpStatus = i28;
                                if (200 == i28) {
                                }
                                i29 = i28;
                                httpContext3 = httpContext2;
                                if (handleResponse(this.response, this.okResponse, downloadResult, jobContext, i29)) {
                                }
                            } else {
                                downloadReport = downloadReport5;
                                str4 = QDLog.TAG_DOWNLOAD;
                                str5 = ", contentLength=";
                                i17 = i56;
                                str6 = ",";
                                str7 = ", localAddress=";
                                str8 = ", useProxy=";
                                str9 = ", apnProxy=";
                                str10 = ", allowProxy=";
                                str11 = ", apn=";
                                str12 = "null:0";
                                j16 = uptimeMillis2;
                                str13 = ", totalDuration=";
                                str14 = ", duration=";
                                str15 = ", IpStack=";
                                str16 = ", thread=";
                                str17 = QDLog.TAG_DOWNLOAD_RESULT;
                                try {
                                    throw th;
                                    break;
                                } catch (Throwable th21) {
                                    th = th21;
                                }
                            }
                            downloadResult.getStatus().setFailed(th5);
                            str53 = this.mRealUrl;
                            th6 = th5;
                            if (str53 != null) {
                                try {
                                    if (str53.startsWith("https:")) {
                                        try {
                                            this.disableHttps = true;
                                            i46 = i17 - 1;
                                        } catch (Throwable th22) {
                                            th7 = th22;
                                            str39 = str17;
                                            str40 = str19;
                                            str41 = str13;
                                            str42 = str14;
                                            str43 = str15;
                                            str44 = str18;
                                            str45 = str4;
                                            str46 = str6;
                                            i37 = i18;
                                            j27 = j17;
                                            int i76 = i17 + 1;
                                            String str85 = str40;
                                            String str86 = str16;
                                            downloadResult.getProcess().setDuration(j16, SystemClock.uptimeMillis());
                                            downloadResult.getProcess().totalDuration = SystemClock.uptimeMillis() - this.mTimeStamp;
                                            downloadResult.getProcess().startTimestamp = this.mTaskStartTimeStamp;
                                            NetworkUtils.DNS dns5 = NetworkStatus.getInstance(this.mContext).getDNS();
                                            DownloadGlobalStrategy.StrategyInfo strategyInfo18 = this.pCurrStrategyInfo;
                                            if (strategyInfo18 != null) {
                                            }
                                            String parserHttpHeaderInfo5 = parserHttpHeaderInfo(this.request, this.response, this.okResponse);
                                            if (httpContext != null) {
                                            }
                                            str47 = "";
                                            downloadResult.getContent().redirectUrl = str47;
                                            if (downloadResult.getStatus().isSucceed()) {
                                            }
                                            if (jobContext.isCancelled()) {
                                            }
                                            if (this.mIsHttp2) {
                                            }
                                        }
                                        try {
                                            QDLog.e(str17, "https exception, disable it and retry! ");
                                            str54 = str17;
                                            i17 = i46;
                                            int i5722222222 = i17 + 1;
                                            String str6222222222 = str16;
                                            downloadResult.getProcess().setDuration(j16, SystemClock.uptimeMillis());
                                            downloadResult.getProcess().totalDuration = SystemClock.uptimeMillis() - this.mTimeStamp;
                                            downloadResult.getProcess().startTimestamp = this.mTaskStartTimeStamp;
                                            NetworkUtils.DNS dns22222222 = NetworkStatus.getInstance(this.mContext).getDNS();
                                            DownloadGlobalStrategy.StrategyInfo strategyInfo422222222 = this.pCurrStrategyInfo;
                                            String iPInfo3 = (strategyInfo422222222 != null || strategyInfo422222222.getIPInfo() == null) ? str12 : this.pCurrStrategyInfo.getIPInfo().toString();
                                            String parserHttpHeaderInfo22222222 = parserHttpHeaderInfo(this.request, this.response, this.okResponse);
                                            String str87 = iPInfo3 != null ? iPInfo3 : WiFiDash.NOT_AVALIBLE;
                                            if (httpContext != null) {
                                                try {
                                                    str55 = (String) httpContext.getAttribute("RedirectURI");
                                                } catch (Exception unused4) {
                                                }
                                                downloadResult.getContent().redirectUrl = str55;
                                                if (downloadResult.getStatus().isSucceed()) {
                                                    ResumeTransfer resumeTransfer5 = this.pResumeTransfer;
                                                    if (resumeTransfer5 != null) {
                                                        str34 = str87;
                                                        str56 = str55;
                                                        str57 = parserHttpHeaderInfo22222222;
                                                        i47 = i5722222222;
                                                        resumeTransfer5.addCacheTmpFile(getUrl(), downloadResult.getPath(), this.response, this.okResponse);
                                                    } else {
                                                        str56 = str55;
                                                        str57 = parserHttpHeaderInfo22222222;
                                                        i47 = i5722222222;
                                                        str34 = str87;
                                                    }
                                                    if (!NetworkUtils.isNetworkAvailable(this.mContext)) {
                                                        this.mAttemptCurrCount--;
                                                        downloadResult.getStatus().setFailed(6);
                                                    }
                                                } else {
                                                    str56 = str55;
                                                    str57 = parserHttpHeaderInfo22222222;
                                                    i47 = i5722222222;
                                                    str34 = str87;
                                                }
                                                if (jobContext.isCancelled()) {
                                                    if (!downloadResult.getStatus().isSucceed()) {
                                                        StringBuilder sb9 = new StringBuilder();
                                                        sb9.append("Downloader, fail to download:");
                                                        sb9.append(getUrl());
                                                        sb9.append(" , requestHttp2=");
                                                        sb9.append(this.mIsHttp2);
                                                        sb9.append(",protocol=");
                                                        if (this.mIsHttp2 && (response9 = this.okResponse) != null && response9.protocol() != null) {
                                                            str61 = this.okResponse.protocol().getProtocol();
                                                        }
                                                        sb9.append(str61);
                                                        sb9.append(", dns=");
                                                        sb9.append(dns22222222);
                                                        sb9.append(", remoteAddress=");
                                                        sb9.append(iPInfo3);
                                                        sb9.append(str7);
                                                        sb9.append(str12);
                                                        sb9.append(str6222222222);
                                                        sb9.append(Thread.currentThread().getId());
                                                        sb9.append(str11);
                                                        sb9.append(NetworkManager.getApnValue());
                                                        sb9.append(str10);
                                                        sb9.append(this.mAllowProxy);
                                                        sb9.append(str18);
                                                        sb9.append(this.mAPNProxy);
                                                        sb9.append(str19);
                                                        sb9.append(this.mAllowProxy ? NetworkUtils.getProxy(this.mContext, this.mAPNProxy) : null);
                                                        sb9.append(", netAvailable=");
                                                        sb9.append(NetworkUtils.isNetworkAvailable(this.mContext));
                                                        sb9.append(str15);
                                                        sb9.append(Config.getNetworkStackType());
                                                        sb9.append(", contentType=");
                                                        sb9.append(downloadResult.getContent().type);
                                                        sb9.append(str14);
                                                        sb9.append(downloadResult.getProcess().duration);
                                                        sb9.append(str13);
                                                        sb9.append(SystemClock.uptimeMillis() - this.mTimeStamp);
                                                        sb9.append(str5);
                                                        sb9.append(downloadResult.getContent().length);
                                                        sb9.append(", size=");
                                                        sb9.append(downloadResult.getContent().size);
                                                        sb9.append(", realsize=");
                                                        sb9.append(downloadResult.getContent().realsize);
                                                        sb9.append(", retry=(");
                                                        sb9.append(this.mAttemptCurrCount);
                                                        String str88 = str6;
                                                        sb9.append(str88);
                                                        sb9.append(this.mAttemptTotalCount);
                                                        sb9.append("), realretry=(");
                                                        i48 = i47;
                                                        sb9.append(i48);
                                                        sb9.append("), reason=");
                                                        sb9.append(downloadResult.getStatus().getFailReason());
                                                        sb9.append(", httpStatus=");
                                                        i49 = i18;
                                                        sb9.append(i49);
                                                        sb9.append(", ");
                                                        sb9.append(str57);
                                                        sb9.append(", redirectURI=");
                                                        sb9.append(str56);
                                                        sb9.append(", ipUrl:");
                                                        String str89 = this.mRealUrl;
                                                        if (str89 != null) {
                                                            str89 = str89.substring(0, 30);
                                                        }
                                                        sb9.append(str89);
                                                        sb9.append(", strategyId=");
                                                        DownloadGlobalStrategy.StrategyInfo strategyInfo19 = this.pCurrStrategyInfo;
                                                        sb9.append(strategyInfo19 != null ? strategyInfo19.f99899id : 0);
                                                        sb9.append(", clientip=");
                                                        sb9.append(downloadResult.getContent().clientip);
                                                        sb9.append(", getIP=");
                                                        j19 = j17;
                                                        sb9.append(j19);
                                                        sb9.append(", connect:(");
                                                        sb9.append(this.connect_time);
                                                        sb9.append(str88);
                                                        sb9.append(this.connect_retry);
                                                        sb9.append("), exeReqest:(");
                                                        sb9.append(this.exe_time);
                                                        sb9.append(str88);
                                                        sb9.append(this.exe_retry);
                                                        sb9.append("), sendReq=");
                                                        sb9.append(this.send_req_time);
                                                        sb9.append(", recvData=");
                                                        sb9.append(this.t_recv_data);
                                                        sb9.append(", Concurrent:(");
                                                        sb9.append(getTaskConcurrentCount());
                                                        sb9.append("), mobileProxy=");
                                                        DownloadTask.DownloadTaskHandler downloadTaskHandler6 = this.mDownloadTaskHandler;
                                                        sb9.append(downloadTaskHandler6 != null ? downloadTaskHandler6.getCustomProxy() : null);
                                                        QDLog.e(str54, sb9.toString(), th6);
                                                        str58 = null;
                                                    } else {
                                                        String str90 = str56;
                                                        String str91 = str19;
                                                        String str92 = str57;
                                                        String str93 = str13;
                                                        String str94 = str14;
                                                        String str95 = str15;
                                                        String str96 = str18;
                                                        String str97 = str54;
                                                        String str98 = str6;
                                                        int i77 = i18;
                                                        long j37 = j17;
                                                        StringBuilder sb10 = new StringBuilder();
                                                        sb10.append("Downloader, succeed to download:");
                                                        sb10.append(getUrl());
                                                        sb10.append(" , requestHttp2=");
                                                        sb10.append(this.mIsHttp2);
                                                        sb10.append(",protocol=");
                                                        if (this.mIsHttp2 && (response8 = this.okResponse) != null && response8.protocol() != null) {
                                                            str61 = this.okResponse.protocol().getProtocol();
                                                        }
                                                        sb10.append(str61);
                                                        sb10.append(", dns=");
                                                        sb10.append(dns22222222);
                                                        sb10.append(", remoteAddress=");
                                                        sb10.append(iPInfo3);
                                                        sb10.append(str7);
                                                        sb10.append(str12);
                                                        sb10.append(str6222222222);
                                                        sb10.append(Thread.currentThread().getId());
                                                        sb10.append(str11);
                                                        sb10.append(NetworkManager.getApnValue());
                                                        sb10.append(str10);
                                                        sb10.append(this.mAllowProxy);
                                                        sb10.append(str96);
                                                        sb10.append(this.mAPNProxy);
                                                        sb10.append(str91);
                                                        sb10.append(this.mAllowProxy ? NetworkUtils.getProxy(this.mContext, this.mAPNProxy) : null);
                                                        sb10.append(str95);
                                                        sb10.append(Config.getNetworkStackType());
                                                        sb10.append(str94);
                                                        sb10.append(downloadResult.getProcess().duration);
                                                        sb10.append(str93);
                                                        sb10.append(SystemClock.uptimeMillis() - this.mTimeStamp);
                                                        sb10.append(str5);
                                                        sb10.append(downloadResult.getContent().length);
                                                        sb10.append(", size=");
                                                        sb10.append(downloadResult.getContent().size);
                                                        sb10.append(", realsize=");
                                                        sb10.append(downloadResult.getContent().realsize);
                                                        sb10.append(", retry=(");
                                                        sb10.append(this.mAttemptCurrCount);
                                                        sb10.append(str98);
                                                        sb10.append(this.mAttemptTotalCount);
                                                        sb10.append("), realretry=(");
                                                        i48 = i47;
                                                        sb10.append(i48);
                                                        sb10.append("), httpStatus=");
                                                        i49 = i77;
                                                        sb10.append(i49);
                                                        sb10.append(", contentType=");
                                                        sb10.append(downloadResult.getContent().type);
                                                        sb10.append(", ");
                                                        sb10.append(str92);
                                                        sb10.append(", redirectURI=");
                                                        sb10.append(str90);
                                                        sb10.append(", ipUrl:");
                                                        String str99 = this.mRealUrl;
                                                        if (str99 != null) {
                                                            str99 = str99.substring(0, 30);
                                                        }
                                                        sb10.append(str99);
                                                        sb10.append(", strategyId=");
                                                        DownloadGlobalStrategy.StrategyInfo strategyInfo20 = this.pCurrStrategyInfo;
                                                        sb10.append(strategyInfo20 != null ? strategyInfo20.f99899id : 0);
                                                        sb10.append(", clientip=");
                                                        sb10.append(downloadResult.getContent().clientip);
                                                        sb10.append(", getIP=");
                                                        j19 = j37;
                                                        sb10.append(j19);
                                                        sb10.append(", connect:(");
                                                        sb10.append(this.connect_time);
                                                        sb10.append(str98);
                                                        sb10.append(this.connect_retry);
                                                        sb10.append("), exeReqest:(");
                                                        sb10.append(this.exe_time);
                                                        sb10.append(str98);
                                                        sb10.append(this.exe_retry);
                                                        sb10.append("), sendReq=");
                                                        sb10.append(this.send_req_time);
                                                        sb10.append(", recvData=");
                                                        sb10.append(this.t_recv_data);
                                                        sb10.append(", Concurrent:(");
                                                        sb10.append(getTaskConcurrentCount());
                                                        sb10.append("), mobileProxy=");
                                                        DownloadTask.DownloadTaskHandler downloadTaskHandler7 = this.mDownloadTaskHandler;
                                                        sb10.append(downloadTaskHandler7 != null ? downloadTaskHandler7.getCustomProxy() : null);
                                                        str58 = null;
                                                        QDLog.w(str97, sb10.toString(), null);
                                                    }
                                                    DownloadGlobalStrategy.StrategyInfo strategyInfo21 = this.pCurrStrategyInfo;
                                                    if (strategyInfo21 != null && DownloadGlobalStrategy.Strategy_BACKUPIP.f99899id == strategyInfo21.f99899id && (iPStrategy8 = this.pBackupIPConfigStrategy) != null) {
                                                        try {
                                                            iPStrategy8.onIPAccessResult(getDomain(), Utils.getDomin(this.mRealUrl), downloadResult.getStatus().isSucceed());
                                                        } catch (Exception e26) {
                                                            str3 = str4;
                                                            QDLog.w(str3, "Strategy_BACKUPIP", e26);
                                                        }
                                                    }
                                                    str3 = str4;
                                                    DownloadGlobalStrategy.StrategyInfo strategyInfo22 = this.pCurrStrategyInfo;
                                                    if (strategyInfo22 != null && DownloadGlobalStrategy.Strategy_DomainDirect.f99899id == strategyInfo22.f99899id && (iPStrategy7 = this.pDirectIPConfigStrategy) != null) {
                                                        try {
                                                            iPStrategy7.onIPAccessResult(getDomain(), Utils.getDomin(this.mRealUrl), downloadResult.getStatus().isSucceed());
                                                        } catch (Exception e27) {
                                                            QDLog.w(str3, "Strategy_DomainDirect", e27);
                                                        }
                                                    }
                                                    DownloadReport downloadReport7 = downloadReport;
                                                    downloadReport7.endTime = System.currentTimeMillis();
                                                    downloadReport7.fileSize = this.mContentLength;
                                                    downloadReport7.response = this.response;
                                                    downloadReport7.httpStatus = i49;
                                                    downloadReport7.exception = th6;
                                                    downloadReport7.dns = dns22222222 == null ? str58 : dns22222222.toString();
                                                    DownloadGlobalStrategy.StrategyInfo strategyInfo23 = this.pCurrStrategyInfo;
                                                    downloadReport7.remoteAddress = (strategyInfo23 == null || strategyInfo23.getIPInfo() == null) ? str58 : this.pCurrStrategyInfo.getIPInfo().f99897ip;
                                                    downloadReport7.localAddress = str12;
                                                    downloadReport7.clientip = downloadResult.getContent().clientip;
                                                    downloadReport7.totaltime = SystemClock.uptimeMillis() - this.mTimeStamp;
                                                    downloadReport7.downloadTime = downloadResult.getProcess().duration;
                                                    downloadReport7.t_wait = downloadReport7.totaltime - downloadResult.getProcess().duration;
                                                    downloadReport7.t_prepare = j19;
                                                    downloadReport7.t_conn = this.connect_time;
                                                    downloadReport7.t_recvrsp = this.send_req_time;
                                                    downloadReport7.t_recvdata = this.t_recv_data;
                                                    downloadReport7.t_process = 0L;
                                                    downloadReport7.concurrent = getTaskConcurrentCount();
                                                    downloadReport7.content_type = downloadResult.getContent().type;
                                                    downloadReport7.isFromQzoneAlbum = Config.isFromQzoneAlbum(getDomain());
                                                    downloadReport7.isHttp2 = this.mIsHttp2;
                                                    String str100 = this.mRealUrl;
                                                    downloadReport7.isHttps = str100 != null && str100.startsWith("https");
                                                    downloadReport7.isSucceed = downloadResult.getStatus().isSucceed();
                                                    downloadReport7.downloadMode = Downloader.DownloadMode.StrictMode.ordinal();
                                                    Response response13 = this.okResponse;
                                                    if (response13 != null && response13.protocol() != null) {
                                                        downloadReport7.f99896protocol = this.okResponse.protocol().getProtocol();
                                                    }
                                                    downloadResult2 = downloadResult;
                                                    downloadResult2.setReport(downloadReport7);
                                                    if (this.mAttemptCurrCount == this.mAttemptTotalCount - 1 || downloadResult.getStatus().isSucceed()) {
                                                        jobContext3 = jobContext;
                                                        handleDownloadReportForTask(jobContext3, downloadResult2, downloadReport7);
                                                        r39 = str58;
                                                    } else {
                                                        jobContext3 = jobContext;
                                                        r39 = str58;
                                                    }
                                                } else {
                                                    jobContext3 = jobContext;
                                                    downloadResult2 = downloadResult;
                                                    i48 = i47;
                                                    str3 = str4;
                                                    j19 = j17;
                                                    r39 = 0;
                                                }
                                                if (!this.mIsHttp2) {
                                                    Call call3 = this.okRequestCall;
                                                    if (call3 != null) {
                                                        call3.cancel();
                                                    }
                                                    this.okRequestBuilder = r39;
                                                } else {
                                                    HttpGet httpGet3 = this.request;
                                                    if (httpGet3 != null) {
                                                        httpGet3.abort();
                                                    }
                                                }
                                                i56 = i48;
                                                str60 = str34;
                                                j29 = j19;
                                                if (canAttempt()) {
                                                }
                                            }
                                            str55 = "";
                                            downloadResult.getContent().redirectUrl = str55;
                                            if (downloadResult.getStatus().isSucceed()) {
                                            }
                                            if (jobContext.isCancelled()) {
                                            }
                                            if (!this.mIsHttp2) {
                                            }
                                            i56 = i48;
                                            str60 = str34;
                                            j29 = j19;
                                            if (canAttempt()) {
                                            }
                                        } catch (Throwable th23) {
                                            th7 = th23;
                                            str39 = str17;
                                            i17 = i46;
                                            str40 = str19;
                                            str41 = str13;
                                            str42 = str14;
                                            str43 = str15;
                                            str44 = str18;
                                            str45 = str4;
                                            str46 = str6;
                                            i37 = i18;
                                            j27 = j17;
                                            int i762 = i17 + 1;
                                            String str852 = str40;
                                            String str862 = str16;
                                            downloadResult.getProcess().setDuration(j16, SystemClock.uptimeMillis());
                                            downloadResult.getProcess().totalDuration = SystemClock.uptimeMillis() - this.mTimeStamp;
                                            downloadResult.getProcess().startTimestamp = this.mTaskStartTimeStamp;
                                            NetworkUtils.DNS dns52 = NetworkStatus.getInstance(this.mContext).getDNS();
                                            DownloadGlobalStrategy.StrategyInfo strategyInfo182 = this.pCurrStrategyInfo;
                                            String iPInfo4 = (strategyInfo182 != null || strategyInfo182.getIPInfo() == null) ? str12 : this.pCurrStrategyInfo.getIPInfo().toString();
                                            String parserHttpHeaderInfo52 = parserHttpHeaderInfo(this.request, this.response, this.okResponse);
                                            if (httpContext != null) {
                                                try {
                                                    str47 = (String) httpContext.getAttribute("RedirectURI");
                                                } catch (Exception unused5) {
                                                    str47 = "";
                                                    downloadResult.getContent().redirectUrl = str47;
                                                    if (downloadResult.getStatus().isSucceed()) {
                                                        ResumeTransfer resumeTransfer6 = this.pResumeTransfer;
                                                        if (resumeTransfer6 != null) {
                                                            str48 = str47;
                                                            str49 = parserHttpHeaderInfo52;
                                                            str50 = str44;
                                                            resumeTransfer6.addCacheTmpFile(getUrl(), downloadResult.getPath(), this.response, this.okResponse);
                                                        } else {
                                                            str48 = str47;
                                                            str49 = parserHttpHeaderInfo52;
                                                            str50 = str44;
                                                        }
                                                        if (!NetworkUtils.isNetworkAvailable(this.mContext)) {
                                                            this.mAttemptCurrCount--;
                                                            downloadResult.getStatus().setFailed(6);
                                                        }
                                                    } else {
                                                        str48 = str47;
                                                        str49 = parserHttpHeaderInfo52;
                                                        str50 = str44;
                                                    }
                                                    if (jobContext.isCancelled()) {
                                                        if (!downloadResult.getStatus().isSucceed()) {
                                                            StringBuilder sb11 = new StringBuilder();
                                                            sb11.append("Downloader, fail to download:");
                                                            sb11.append(getUrl());
                                                            sb11.append(" , requestHttp2=");
                                                            sb11.append(this.mIsHttp2);
                                                            sb11.append(",protocol=");
                                                            if (this.mIsHttp2 && (response7 = this.okResponse) != null && response7.protocol() != null) {
                                                                str61 = this.okResponse.protocol().getProtocol();
                                                            }
                                                            sb11.append(str61);
                                                            sb11.append(", dns=");
                                                            sb11.append(dns52);
                                                            sb11.append(", remoteAddress=");
                                                            sb11.append(iPInfo4);
                                                            sb11.append(str7);
                                                            sb11.append(str12);
                                                            sb11.append(str862);
                                                            sb11.append(Thread.currentThread().getId());
                                                            sb11.append(str11);
                                                            sb11.append(NetworkManager.getApnValue());
                                                            sb11.append(str10);
                                                            sb11.append(this.mAllowProxy);
                                                            sb11.append(str50);
                                                            sb11.append(this.mAPNProxy);
                                                            sb11.append(str852);
                                                            sb11.append(this.mAllowProxy ? NetworkUtils.getProxy(this.mContext, this.mAPNProxy) : null);
                                                            sb11.append(", netAvailable=");
                                                            sb11.append(NetworkUtils.isNetworkAvailable(this.mContext));
                                                            sb11.append(str43);
                                                            sb11.append(Config.getNetworkStackType());
                                                            sb11.append(", contentType=");
                                                            sb11.append(downloadResult.getContent().type);
                                                            sb11.append(str42);
                                                            sb11.append(downloadResult.getProcess().duration);
                                                            sb11.append(str41);
                                                            sb11.append(SystemClock.uptimeMillis() - this.mTimeStamp);
                                                            sb11.append(str5);
                                                            sb11.append(downloadResult.getContent().length);
                                                            sb11.append(", size=");
                                                            sb11.append(downloadResult.getContent().size);
                                                            sb11.append(", realsize=");
                                                            sb11.append(downloadResult.getContent().realsize);
                                                            sb11.append(", retry=(");
                                                            sb11.append(this.mAttemptCurrCount);
                                                            String str101 = str46;
                                                            sb11.append(str101);
                                                            sb11.append(this.mAttemptTotalCount);
                                                            sb11.append("), realretry=(");
                                                            sb11.append(i762);
                                                            sb11.append("), reason=");
                                                            sb11.append(downloadResult.getStatus().getFailReason());
                                                            sb11.append(", httpStatus=");
                                                            i38 = i37;
                                                            sb11.append(i38);
                                                            sb11.append(", ");
                                                            sb11.append(str49);
                                                            sb11.append(", redirectURI=");
                                                            sb11.append(str48);
                                                            sb11.append(", ipUrl:");
                                                            String str102 = this.mRealUrl;
                                                            if (str102 != null) {
                                                                str102 = str102.substring(0, 30);
                                                            }
                                                            sb11.append(str102);
                                                            sb11.append(", strategyId=");
                                                            DownloadGlobalStrategy.StrategyInfo strategyInfo24 = this.pCurrStrategyInfo;
                                                            sb11.append(strategyInfo24 != null ? strategyInfo24.f99899id : 0);
                                                            sb11.append(", clientip=");
                                                            sb11.append(downloadResult.getContent().clientip);
                                                            sb11.append(", getIP=");
                                                            long j38 = j27;
                                                            sb11.append(j38);
                                                            sb11.append(", connect:(");
                                                            sb11.append(this.connect_time);
                                                            sb11.append(str101);
                                                            sb11.append(this.connect_retry);
                                                            sb11.append("), exeReqest:(");
                                                            sb11.append(this.exe_time);
                                                            sb11.append(str101);
                                                            sb11.append(this.exe_retry);
                                                            sb11.append("), sendReq=");
                                                            sb11.append(this.send_req_time);
                                                            sb11.append(", recvData=");
                                                            sb11.append(this.t_recv_data);
                                                            sb11.append(", Concurrent:(");
                                                            sb11.append(getTaskConcurrentCount());
                                                            sb11.append("), mobileProxy=");
                                                            DownloadTask.DownloadTaskHandler downloadTaskHandler8 = this.mDownloadTaskHandler;
                                                            sb11.append(downloadTaskHandler8 != null ? downloadTaskHandler8.getCustomProxy() : null);
                                                            QDLog.e(str39, sb11.toString(), th6);
                                                            j28 = j38;
                                                            str51 = null;
                                                            i39 = 0;
                                                        } else {
                                                            String str103 = str48;
                                                            String str104 = str49;
                                                            String str105 = str50;
                                                            String str106 = str39;
                                                            int i78 = i37;
                                                            long j39 = j27;
                                                            String str107 = str46;
                                                            StringBuilder sb12 = new StringBuilder();
                                                            sb12.append("Downloader, succeed to download:");
                                                            sb12.append(getUrl());
                                                            sb12.append(" , requestHttp2=");
                                                            sb12.append(this.mIsHttp2);
                                                            sb12.append(",protocol=");
                                                            if (this.mIsHttp2 && (response5 = this.okResponse) != null && response5.protocol() != null) {
                                                                str61 = this.okResponse.protocol().getProtocol();
                                                            }
                                                            sb12.append(str61);
                                                            sb12.append(", dns=");
                                                            sb12.append(dns52);
                                                            sb12.append(", remoteAddress=");
                                                            sb12.append(iPInfo4);
                                                            sb12.append(str7);
                                                            sb12.append(str12);
                                                            sb12.append(str862);
                                                            sb12.append(Thread.currentThread().getId());
                                                            sb12.append(str11);
                                                            sb12.append(NetworkManager.getApnValue());
                                                            sb12.append(str10);
                                                            sb12.append(this.mAllowProxy);
                                                            sb12.append(str105);
                                                            sb12.append(this.mAPNProxy);
                                                            sb12.append(str852);
                                                            sb12.append(this.mAllowProxy ? NetworkUtils.getProxy(this.mContext, this.mAPNProxy) : null);
                                                            sb12.append(str43);
                                                            sb12.append(Config.getNetworkStackType());
                                                            sb12.append(str42);
                                                            sb12.append(downloadResult.getProcess().duration);
                                                            sb12.append(str41);
                                                            sb12.append(SystemClock.uptimeMillis() - this.mTimeStamp);
                                                            sb12.append(str5);
                                                            sb12.append(downloadResult.getContent().length);
                                                            sb12.append(", size=");
                                                            sb12.append(downloadResult.getContent().size);
                                                            sb12.append(", realsize=");
                                                            sb12.append(downloadResult.getContent().realsize);
                                                            sb12.append(", retry=(");
                                                            sb12.append(this.mAttemptCurrCount);
                                                            sb12.append(str107);
                                                            sb12.append(this.mAttemptTotalCount);
                                                            sb12.append("), realretry=(");
                                                            sb12.append(i762);
                                                            sb12.append("), httpStatus=");
                                                            i38 = i78;
                                                            sb12.append(i38);
                                                            sb12.append(", contentType=");
                                                            sb12.append(downloadResult.getContent().type);
                                                            sb12.append(", ");
                                                            sb12.append(str104);
                                                            sb12.append(", redirectURI=");
                                                            sb12.append(str103);
                                                            sb12.append(", ipUrl:");
                                                            String str108 = this.mRealUrl;
                                                            if (str108 != null) {
                                                                i39 = 0;
                                                                str108 = str108.substring(0, 30);
                                                            } else {
                                                                i39 = 0;
                                                            }
                                                            sb12.append(str108);
                                                            sb12.append(", strategyId=");
                                                            DownloadGlobalStrategy.StrategyInfo strategyInfo25 = this.pCurrStrategyInfo;
                                                            sb12.append(strategyInfo25 != null ? strategyInfo25.f99899id : i39);
                                                            sb12.append(", clientip=");
                                                            sb12.append(downloadResult.getContent().clientip);
                                                            sb12.append(", getIP=");
                                                            j28 = j39;
                                                            sb12.append(j28);
                                                            sb12.append(", connect:(");
                                                            sb12.append(this.connect_time);
                                                            sb12.append(str107);
                                                            sb12.append(this.connect_retry);
                                                            sb12.append("), exeReqest:(");
                                                            sb12.append(this.exe_time);
                                                            sb12.append(str107);
                                                            sb12.append(this.exe_retry);
                                                            sb12.append("), sendReq=");
                                                            sb12.append(this.send_req_time);
                                                            sb12.append(", recvData=");
                                                            sb12.append(this.t_recv_data);
                                                            sb12.append(", Concurrent:(");
                                                            sb12.append(getTaskConcurrentCount());
                                                            sb12.append("), mobileProxy=");
                                                            DownloadTask.DownloadTaskHandler downloadTaskHandler9 = this.mDownloadTaskHandler;
                                                            sb12.append(downloadTaskHandler9 != null ? downloadTaskHandler9.getCustomProxy() : null);
                                                            str51 = null;
                                                            QDLog.w(str106, sb12.toString(), null);
                                                        }
                                                        DownloadGlobalStrategy.StrategyInfo strategyInfo26 = this.pCurrStrategyInfo;
                                                        if (strategyInfo26 != null && DownloadGlobalStrategy.Strategy_BACKUPIP.f99899id == strategyInfo26.f99899id && (iPStrategy6 = this.pBackupIPConfigStrategy) != null) {
                                                            try {
                                                                iPStrategy6.onIPAccessResult(getDomain(), Utils.getDomin(this.mRealUrl), downloadResult.getStatus().isSucceed());
                                                            } catch (Exception e28) {
                                                                str52 = str45;
                                                                QDLog.w(str52, "Strategy_BACKUPIP", e28);
                                                                strategyInfo3 = this.pCurrStrategyInfo;
                                                                if (strategyInfo3 != null) {
                                                                    try {
                                                                        iPStrategy5.onIPAccessResult(getDomain(), Utils.getDomin(this.mRealUrl), downloadResult.getStatus().isSucceed());
                                                                    } catch (Exception e29) {
                                                                        QDLog.w(str52, "Strategy_DomainDirect", e29);
                                                                    }
                                                                }
                                                                downloadReport4 = downloadReport;
                                                                downloadReport4.endTime = System.currentTimeMillis();
                                                                downloadReport4.fileSize = this.mContentLength;
                                                                downloadReport4.response = this.response;
                                                                downloadReport4.httpStatus = i38;
                                                                downloadReport4.exception = th6;
                                                                downloadReport4.dns = dns52 != null ? str51 : dns52.toString();
                                                                DownloadGlobalStrategy.StrategyInfo strategyInfo27 = this.pCurrStrategyInfo;
                                                                downloadReport4.remoteAddress = (strategyInfo27 != null || strategyInfo27.getIPInfo() == null) ? str51 : this.pCurrStrategyInfo.getIPInfo().f99897ip;
                                                                downloadReport4.localAddress = str12;
                                                                downloadReport4.clientip = downloadResult.getContent().clientip;
                                                                downloadReport4.totaltime = SystemClock.uptimeMillis() - this.mTimeStamp;
                                                                downloadReport4.downloadTime = downloadResult.getProcess().duration;
                                                                downloadReport4.t_wait = downloadReport4.totaltime - downloadResult.getProcess().duration;
                                                                downloadReport4.t_prepare = j28;
                                                                downloadReport4.t_conn = this.connect_time;
                                                                downloadReport4.t_recvrsp = this.send_req_time;
                                                                downloadReport4.t_recvdata = this.t_recv_data;
                                                                downloadReport4.t_process = 0L;
                                                                downloadReport4.concurrent = getTaskConcurrentCount();
                                                                downloadReport4.content_type = downloadResult.getContent().type;
                                                                downloadReport4.isFromQzoneAlbum = Config.isFromQzoneAlbum(getDomain());
                                                                downloadReport4.isHttp2 = this.mIsHttp2;
                                                                String str109 = this.mRealUrl;
                                                                downloadReport4.isHttps = (str109 == null && str109.startsWith("https")) ? 1 : i39;
                                                                downloadReport4.isSucceed = downloadResult.getStatus().isSucceed();
                                                                downloadReport4.downloadMode = Downloader.DownloadMode.StrictMode.ordinal();
                                                                response6 = this.okResponse;
                                                                if (response6 != null) {
                                                                    downloadReport4.f99896protocol = this.okResponse.protocol().getProtocol();
                                                                }
                                                                downloadResult.setReport(downloadReport4);
                                                                if (this.mAttemptCurrCount != this.mAttemptTotalCount - 1) {
                                                                }
                                                                handleDownloadReportForTask(jobContext, downloadResult, downloadReport4);
                                                                r38 = str51;
                                                                if (this.mIsHttp2) {
                                                                }
                                                            }
                                                        }
                                                        str52 = str45;
                                                        strategyInfo3 = this.pCurrStrategyInfo;
                                                        if (strategyInfo3 != null && DownloadGlobalStrategy.Strategy_DomainDirect.f99899id == strategyInfo3.f99899id && (iPStrategy5 = this.pDirectIPConfigStrategy) != null) {
                                                            iPStrategy5.onIPAccessResult(getDomain(), Utils.getDomin(this.mRealUrl), downloadResult.getStatus().isSucceed());
                                                        }
                                                        downloadReport4 = downloadReport;
                                                        downloadReport4.endTime = System.currentTimeMillis();
                                                        downloadReport4.fileSize = this.mContentLength;
                                                        downloadReport4.response = this.response;
                                                        downloadReport4.httpStatus = i38;
                                                        downloadReport4.exception = th6;
                                                        downloadReport4.dns = dns52 != null ? str51 : dns52.toString();
                                                        DownloadGlobalStrategy.StrategyInfo strategyInfo272 = this.pCurrStrategyInfo;
                                                        downloadReport4.remoteAddress = (strategyInfo272 != null || strategyInfo272.getIPInfo() == null) ? str51 : this.pCurrStrategyInfo.getIPInfo().f99897ip;
                                                        downloadReport4.localAddress = str12;
                                                        downloadReport4.clientip = downloadResult.getContent().clientip;
                                                        downloadReport4.totaltime = SystemClock.uptimeMillis() - this.mTimeStamp;
                                                        downloadReport4.downloadTime = downloadResult.getProcess().duration;
                                                        downloadReport4.t_wait = downloadReport4.totaltime - downloadResult.getProcess().duration;
                                                        downloadReport4.t_prepare = j28;
                                                        downloadReport4.t_conn = this.connect_time;
                                                        downloadReport4.t_recvrsp = this.send_req_time;
                                                        downloadReport4.t_recvdata = this.t_recv_data;
                                                        downloadReport4.t_process = 0L;
                                                        downloadReport4.concurrent = getTaskConcurrentCount();
                                                        downloadReport4.content_type = downloadResult.getContent().type;
                                                        downloadReport4.isFromQzoneAlbum = Config.isFromQzoneAlbum(getDomain());
                                                        downloadReport4.isHttp2 = this.mIsHttp2;
                                                        String str1092 = this.mRealUrl;
                                                        downloadReport4.isHttps = (str1092 == null && str1092.startsWith("https")) ? 1 : i39;
                                                        downloadReport4.isSucceed = downloadResult.getStatus().isSucceed();
                                                        downloadReport4.downloadMode = Downloader.DownloadMode.StrictMode.ordinal();
                                                        response6 = this.okResponse;
                                                        if (response6 != null && response6.protocol() != null) {
                                                            downloadReport4.f99896protocol = this.okResponse.protocol().getProtocol();
                                                        }
                                                        downloadResult.setReport(downloadReport4);
                                                        if (this.mAttemptCurrCount != this.mAttemptTotalCount - 1) {
                                                            r38 = str51;
                                                        }
                                                        handleDownloadReportForTask(jobContext, downloadResult, downloadReport4);
                                                        r38 = str51;
                                                    } else {
                                                        r38 = 0;
                                                    }
                                                    if (this.mIsHttp2) {
                                                        Call call4 = this.okRequestCall;
                                                        if (call4 != null) {
                                                            call4.cancel();
                                                        }
                                                        this.okRequestBuilder = r38;
                                                        throw th7;
                                                    }
                                                    HttpGet httpGet4 = this.request;
                                                    if (httpGet4 != null) {
                                                        httpGet4.abort();
                                                        throw th7;
                                                    }
                                                    throw th7;
                                                }
                                                downloadResult.getContent().redirectUrl = str47;
                                                if (downloadResult.getStatus().isSucceed()) {
                                                }
                                                if (jobContext.isCancelled()) {
                                                }
                                                if (this.mIsHttp2) {
                                                }
                                            }
                                            str47 = "";
                                            downloadResult.getContent().redirectUrl = str47;
                                            if (downloadResult.getStatus().isSucceed()) {
                                            }
                                            if (jobContext.isCancelled()) {
                                            }
                                            if (this.mIsHttp2) {
                                            }
                                        }
                                    }
                                } catch (Throwable th24) {
                                    th7 = th24;
                                    str39 = str17;
                                }
                            }
                            str54 = str17;
                            int i57222222222 = i17 + 1;
                            String str62222222222 = str16;
                            downloadResult.getProcess().setDuration(j16, SystemClock.uptimeMillis());
                            downloadResult.getProcess().totalDuration = SystemClock.uptimeMillis() - this.mTimeStamp;
                            downloadResult.getProcess().startTimestamp = this.mTaskStartTimeStamp;
                            NetworkUtils.DNS dns222222222 = NetworkStatus.getInstance(this.mContext).getDNS();
                            DownloadGlobalStrategy.StrategyInfo strategyInfo4222222222 = this.pCurrStrategyInfo;
                            if (strategyInfo4222222222 != null) {
                            }
                            String parserHttpHeaderInfo222222222 = parserHttpHeaderInfo(this.request, this.response, this.okResponse);
                            if (iPInfo3 != null) {
                            }
                            if (httpContext != null) {
                            }
                            str55 = "";
                            downloadResult.getContent().redirectUrl = str55;
                            if (downloadResult.getStatus().isSucceed()) {
                            }
                            if (jobContext.isCancelled()) {
                            }
                            if (!this.mIsHttp2) {
                            }
                            i56 = i48;
                            str60 = str34;
                            j29 = j19;
                            if (canAttempt()) {
                            }
                        } catch (Throwable th25) {
                            str39 = str17;
                            th6 = th5;
                            str40 = str19;
                            str41 = str13;
                            str42 = str14;
                            str43 = str15;
                            str44 = str18;
                            str45 = str4;
                            str46 = str6;
                            i37 = i18;
                            j27 = j17;
                            th7 = th25;
                        }
                        str19 = str8;
                        str18 = str9;
                        j17 = j29;
                        httpContext = null;
                        i18 = 0;
                        th5 = th;
                    } else {
                        jobContext3 = jobContext4;
                        str = str59;
                        downloadResult2 = downloadResult3;
                        i16 = generateRandomId;
                        j3 = uptimeMillis;
                        str3 = QDLog.TAG_DOWNLOAD;
                        if (canAttempt()) {
                            str2 = str60;
                        } else {
                            downloadResult3 = downloadResult2;
                            jobContext4 = jobContext3;
                            generateRandomId = i16;
                            uptimeMillis = j3;
                            str59 = str;
                        }
                    }
                }
                if (!NetworkUtils.isNetworkAvailable(this.mContext)) {
                }
                downloadResult2.setDescInfo(generateDownloadDescInfo(downloadResult.getStatus().getFailReason(), downloadResult.getStatus().httpStatus, i3, NetworkManager.getApnValue(), str, downloadResult.getContent().type, str2));
                return;
            } catch (Throwable th26) {
                QDLog.e(str3, "", th26);
                return;
            }
            i3 = i56;
        }
        handleDownloadReportForTask(jobContext4, downloadResult3, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.component.network.downloader.impl.DownloadTask
    public void initTask() {
        super.initTask();
        this.mDomainWithPort = Utils.getDominWithPort(getUrl());
        this.mOrigPort = Utils.getPort(getUrl());
    }
}
