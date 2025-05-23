package com.tencent.mobileqq.vas.api.impl;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.IPAddressUtil;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.ServerAddr;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.transfile.dns.IpData;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.fb;
import com.tencent.mobileqq.vas.IConfigProxy;
import com.tencent.mobileqq.vas.ReportInfo;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.api.IVasDownloader;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.mobileqq.vas.toggle.UnitedProxy;
import com.tencent.mobileqq.vas.toggle.VasLongToggle;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vip.g;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqmini.minigame.plugins.RaffleJsPlugin;
import com.tencent.video.decode.AVDecodeError;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.functions.Function1;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.java_websocket.WebSocketImpl;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;
import v23.Node;

/* compiled from: P */
/* loaded from: classes20.dex */
public class VasDownloaderImpl implements IVasDownloader, INetInfoHandler {
    private static final int MAX_DOWNLOAD_TASK_NUM;
    public static final int MAX_WAIT_SECONDS;
    private static final boolean OPEN_LOG;
    public static final String TAG = "VasDownloaderImpl";
    public static volatile ConcurrentHashMap<String, Integer> TASK_FAILED_TIMES;
    private static final HashSet<String> sIpConnectWhiteSet;
    private static final UnitedProxy sVasDownloadToggle;
    private volatile boolean isInit;
    private volatile URL preRedirectionURL;
    private volatile long recordTime;
    private final LinkedList<com.tencent.mobileqq.vip.g> downloadQueue = new LinkedList<>();
    AtomicInteger downloadLimitCount = new AtomicInteger(1);
    private boolean isForceDns = false;
    private final Random random = new Random();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements HttpNetReq.ResponseURLCallback {
        a() {
        }

        @Override // com.tencent.mobileqq.transfile.HttpNetReq.ResponseURLCallback
        public void onResponseURL(@Nullable URL url) {
            if (VasLongToggle.VAS_DOWNLOAD_REDIRECTION_REUSE_CONFIG.isEnable(true) && url != null && !TextUtils.isEmpty(url.getHost()) && VasDownloaderImpl.this.preRedirectionURL == null && VasDownloaderImpl.this.isRedirectHost(url.getHost()) && SystemClock.uptimeMillis() - VasDownloaderImpl.this.recordTime > VasDownloaderImpl.this.getCacheRedirectReqTime()) {
                VasDownloaderImpl.this.preRedirectionURL = url;
                VasDownloaderImpl.this.recordTime = SystemClock.uptimeMillis();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class c implements HttpNetReq.DnsParseCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ x23.c f308497a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f308498b;

        c(x23.c cVar, boolean z16) {
            this.f308497a = cVar;
            this.f308498b = z16;
        }

        @Override // com.tencent.mobileqq.transfile.HttpNetReq.DnsParseCallback
        public void end() {
            Node node;
            long j3;
            x23.c cVar = this.f308497a;
            if (cVar != null) {
                if (cVar.d() == 1) {
                    node = new Node(2);
                    j3 = node.getStartTime() - this.f308497a.b(1);
                } else {
                    node = new Node(4);
                    j3 = 0;
                }
                this.f308497a.c(node);
                if (this.f308498b) {
                    this.f308497a.end();
                } else if (this.f308497a.d() == 4) {
                    this.f308497a.end();
                }
                IConfigProxy iConfigProxy = VasNormalToggle.VAS_FORCE_IP_CONNECT;
                if (iConfigProxy.isEnable(true) && j3 >= iConfigProxy.getJson().optLong("dns_time_out", 4000L)) {
                    VasDownloaderImpl.this.isForceDns = true;
                }
            }
        }

        @Override // com.tencent.mobileqq.transfile.HttpNetReq.DnsParseCallback
        public void start() {
            Node node;
            x23.c cVar = this.f308497a;
            if (cVar != null) {
                if (cVar.d() == -1) {
                    node = new Node(1);
                } else {
                    node = new Node(3);
                }
                this.f308497a.c(node);
            }
        }
    }

    static {
        HashSet<String> hashSet = new HashSet<>();
        sIpConnectWhiteSet = hashSet;
        UnitedProxy b16 = com.tencent.mobileqq.vas.ar.b("shouyouye", "2024-08-30", "vas_download_config");
        sVasDownloadToggle = b16;
        OPEN_LOG = b16.getJson().optBoolean("log", false);
        MAX_DOWNLOAD_TASK_NUM = b16.getJson().optInt("max_download_task", 3);
        MAX_WAIT_SECONDS = b16.getJson().optInt("max_wait_seconds", 600);
        TASK_FAILED_TIMES = new ConcurrentHashMap<>();
        hashSet.add("gxh.material.qq.com");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void colorLog(String str) {
        if (OPEN_LOG || QLog.isColorLevel()) {
            QLog.d(TAG, 1, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public NetResp directRequest(int i3, String str, File file, com.tencent.mobileqq.vip.g gVar) {
        NetResp netResp;
        try {
            netResp = requestDownload(gVar, i3, str, file, false);
        } catch (Exception e16) {
            gVar.f313006d = AVDecodeError.JNI_NOT_SUPPORT_PIXFMT_ERR;
            QLog.w(TAG, 1, "\u8bf7\u6c42\u53d1\u751f\u975e\u5b9a\u4e49\u5f02\u5e38,e:" + e16.getMessage());
            netResp = null;
        }
        if (netResp == null) {
            handleWhenDownloadFinished(TAG, gVar, -1);
            return null;
        }
        if (netResp.mResult != 0) {
            reportDirectDownload(str, netResp);
        }
        return netResp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getCacheRedirectReqTime() {
        IConfigProxy iConfigProxy = VasLongToggle.VAS_DOWNLOAD_REDIRECTION_REUSE_CONFIG;
        if (!iConfigProxy.isEnable(true)) {
            return 0L;
        }
        return iConfigProxy.getJson().optLong("replace_cache_time", MiniBoxNoticeInfo.MIN_5);
    }

    private HttpNetReq.ResponseURLCallback getCacheRedirectUrlCallback() {
        return new a();
    }

    private HttpNetReq.DnsParseCallback getDnsReportCallback(boolean z16, String str, String str2, HttpNetReq httpNetReq) {
        x23.c cVar;
        int i3;
        if (!z16) {
            cVar = com.tencent.mobileqq.vas.report.a.f310626a.a(new w23.c("vas_dns_report_parse", y23.a.INSTANCE.a(), 2, true, -1L));
        } else {
            x23.c a16 = com.tencent.mobileqq.vas.report.a.f310626a.a(new w23.c("vas_dns_report_replace_redirect_parse", y23.a.INSTANCE.a(), 1, true, -1L));
            a16.a("finalUrl", str2);
            cVar = a16;
        }
        cVar.a("url", str);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("");
        List<ServerAddr> list = httpNetReq.mServerList;
        if (list != null && list.size() > 0) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        sb5.append(i3);
        cVar.a("ip", sb5.toString());
        return new c(cVar, z16);
    }

    private String getHostIp(String str) {
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            String c16 = com.tencent.msdk.dns.c.h().c(str);
            if (!TextUtils.isEmpty(c16)) {
                String[] split = c16.split(";");
                ArrayList arrayList = new ArrayList();
                for (String str2 : split) {
                    if (!"0".equals(str2) && !TextUtils.isEmpty(str2)) {
                        arrayList.add(str2);
                    }
                }
                if (!arrayList.isEmpty()) {
                    return (String) arrayList.get(this.random.nextInt(arrayList.size()));
                }
            }
            long uptimeMillis2 = SystemClock.uptimeMillis();
            QLog.i(TAG, 1, "ip parse from MSDKDnsResolver cost:" + (uptimeMillis2 - uptimeMillis));
            hook(str);
            ArrayList<ServerAddr> reqSerAddrList = InnerDns.getInstance().reqSerAddrList(str, 1002);
            if (!reqSerAddrList.isEmpty()) {
                ServerAddr serverAddr = reqSerAddrList.get(this.random.nextInt(reqSerAddrList.size()));
                QLog.i(TAG, 1, "ip parse from InnerDns cost:" + (SystemClock.uptimeMillis() - uptimeMillis2));
                return serverAddr.mIp;
            }
            return "";
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.w(TAG, 2, e16.getMessage());
                return "";
            }
            return "";
        }
    }

    @NonNull
    private List<Integer> getHttpDnsConnectExcludeErrCode() {
        JSONArray optJSONArray;
        int length;
        ArrayList arrayList = new ArrayList();
        JSONObject jsonString = VasToggle.FEATURE_HTTPDNS.getJsonString();
        if (jsonString != null && (optJSONArray = jsonString.optJSONArray("exclude_err_code")) != null && (length = optJSONArray.length()) > 0) {
            for (int i3 = 0; i3 < length; i3++) {
                try {
                    arrayList.add(Integer.valueOf(optJSONArray.getInt(i3)));
                } catch (Exception e16) {
                    QLog.i(TAG, 1, "getHttpDnsConnectExcludeErrCode failed", e16);
                }
            }
        }
        return arrayList;
    }

    private List<String> getIpList(String str) {
        ArrayList<ServerAddr> reqSerAddrList;
        String c16 = com.tencent.msdk.dns.c.h().c(str);
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(c16)) {
            for (String str2 : c16.split(";")) {
                if (!"0".equals(str2) && !TextUtils.isEmpty(str2)) {
                    VasCommonReporter.getDownLoader().setValue1(str2).setValue2("httpdns_sdk_ip").report();
                    arrayList.add(str2);
                }
            }
        }
        if (arrayList.isEmpty() && (reqSerAddrList = InnerDns.getInstance().reqSerAddrList(str, 1002)) != null && !reqSerAddrList.isEmpty()) {
            Iterator<ServerAddr> it = reqSerAddrList.iterator();
            while (it.hasNext()) {
                ServerAddr next = it.next();
                arrayList.add(next.mIp);
                VasCommonReporter.getDownLoader().setValue1(next.mIp).setValue2("innerdns_sdk_ip").report();
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    /* renamed from: getIpServerList, reason: merged with bridge method [inline-methods] */
    public List<ServerAddr> lambda$requestDownload$0(String str) {
        List<String> ipList = getIpList(str);
        if (ipList.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : ipList) {
                ServerAddr serverAddr = new ServerAddr();
                serverAddr.mIp = str2;
                serverAddr.port = WebSocketImpl.DEFAULT_WSS_PORT;
                arrayList.add(serverAddr);
            }
            return arrayList;
        }
        return null;
    }

    private INetEngineListener getNetEngineListener(com.tencent.mobileqq.vip.g gVar, int i3) {
        return new b(gVar, i3);
    }

    private com.tencent.mobileqq.vip.g getNextTask() {
        synchronized (this.downloadQueue) {
            if (!this.downloadQueue.isEmpty()) {
                Iterator<com.tencent.mobileqq.vip.g> it = this.downloadQueue.iterator();
                while (it.hasNext()) {
                    com.tencent.mobileqq.vip.g next = it.next();
                    if (!next.k()) {
                        next.l();
                        return next;
                    }
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleIfTaskFailed(int i3, com.tencent.mobileqq.vip.g gVar, String str) {
        if (i3 != 0 && !gVar.j()) {
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (gVar.f313023u) {
                TASK_FAILED_TIMES.put(gVar.f313004c, Integer.valueOf(currentTimeMillis));
            }
            QLog.w(TAG, 2, "doTask | download fail | try over downloadUrl=" + str + ",change task.useIp=" + gVar.f313025w + " task.forceIp=" + gVar.f313024v);
            return;
        }
        TASK_FAILED_TIMES.remove(gVar.f313004c);
    }

    private void handleNetChanged(String str, Function1<com.tencent.mobileqq.vip.g, Object> function1) {
        if (this.downloadQueue.size() > 0) {
            colorLog(str);
            synchronized (this.downloadQueue) {
                Iterator<com.tencent.mobileqq.vip.g> it = this.downloadQueue.iterator();
                while (it.hasNext()) {
                    com.tencent.mobileqq.vip.g next = it.next();
                    if (next.i() == 2) {
                        function1.invoke(next);
                    }
                }
            }
        }
        TASK_FAILED_TIMES.clear();
    }

    public static void handleWhenDownloadFinished(String str, com.tencent.mobileqq.vip.g gVar, int i3) {
        int i16;
        if (gVar.j()) {
            colorLog("canceled");
            gVar.y(2);
            gVar.m();
        } else {
            if (i3 == 0) {
                i16 = 3;
            } else {
                i16 = -1;
            }
            gVar.y(i16);
        }
        colorLog("onDoned");
        gVar.n();
    }

    private void hook(String str) {
        int i3;
        try {
            ArrayList<ServerAddr> reqSerAddrList = InnerDns.getInstance().reqSerAddrList(str, 1002);
            if (reqSerAddrList == null || reqSerAddrList.size() == 0) {
                ArrayList arrayList = new ArrayList();
                InetAddress[] allByName = InetAddress.getAllByName(str);
                if (allByName != null && allByName.length > 0) {
                    for (InetAddress inetAddress : allByName) {
                        IpData ipData = new IpData();
                        String hostAddress = inetAddress.getHostAddress();
                        ipData.mIp = hostAddress;
                        ipData.mPort = WebSocketImpl.DEFAULT_WSS_PORT;
                        if (IPAddressUtil.isIPv4LiteralAddress(hostAddress)) {
                            i3 = 1;
                        } else {
                            i3 = 28;
                        }
                        ipData.mType = i3;
                        arrayList.add(ipData);
                    }
                    DomainData domainData = new DomainData(str, arrayList);
                    Field declaredField = InnerDns.getInstance().getClass().getDeclaredField("mNetMap");
                    declaredField.setAccessible(true);
                    HashMap hashMap = (HashMap) declaredField.get(InnerDns.getInstance());
                    String netTypeStr = getNetTypeStr();
                    if (hashMap != null) {
                        HashMap hashMap2 = (HashMap) hashMap.get(netTypeStr);
                        if (hashMap2 != null) {
                            hashMap2.put(str, domainData);
                        } else {
                            HashMap hashMap3 = new HashMap();
                            hashMap3.put(str, domainData);
                            hashMap.put(netTypeStr, hashMap3);
                        }
                    }
                    QLog.d(TAG, 1, "hook success: " + Arrays.toString(allByName));
                }
            }
        } catch (Exception e16) {
            QLog.d(TAG, 1, e16.getMessage());
        }
    }

    private void httpDnsInit() {
        IConfigProxy iConfigProxy = VasLongToggle.DOWNLOAD_IP_DNS_INIT;
        if (iConfigProxy.isEnable(false)) {
            JSONObject json = iConfigProxy.getJson();
            try {
                String optString = json.optString("appId");
                String optString2 = json.optString("dnsId");
                String optString3 = json.optString("dnsKey");
                String optString4 = json.optString("initService");
                com.tencent.msdk.dns.c h16 = com.tencent.msdk.dns.c.h();
                BaseApplication context = BaseApplication.getContext();
                if (TextUtils.isEmpty(optString)) {
                    optString = "0AND01ODDR4EBTOS";
                }
                String str = optString;
                if (TextUtils.isEmpty(optString2)) {
                    optString2 = "13762";
                }
                String str2 = optString2;
                if (TextUtils.isEmpty(optString3)) {
                    optString3 = "RgTIyHbn";
                }
                String str3 = optString3;
                if (TextUtils.isEmpty(optString4)) {
                    optString4 = "119.29.29.98";
                }
                h16.i(context, str, str2, str3, optString4, false, 1000);
            } catch (Exception e16) {
                QLog.w(TAG, 1, "init dns exception", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public NetResp ipConnectRequest(int i3, String str, File file, com.tencent.mobileqq.vip.g gVar) {
        NetResp netResp;
        try {
            if (VasToggle.BUG_IP_TO_CACHE.isEnable(false)) {
                fb.b(InnerDns.getHostFromUrl(str));
            }
            netResp = requestDownload(gVar, i3, str, file, true);
        } catch (Exception e16) {
            gVar.f313006d = AVDecodeError.JNI_NOT_SUPPORT_PIXFMT_ERR;
            QLog.w(TAG, 1, "\u8bf7\u6c42\u53d1\u751f\u975e\u5b9a\u4e49\u5f02\u5e38 2 ,e:" + e16.getMessage());
            netResp = null;
        }
        if (netResp == null) {
            handleWhenDownloadFinished(TAG, gVar, -1);
            return null;
        }
        reportDnsConnect(str, netResp);
        return netResp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isCanUseHttpDns(@Nullable NetResp netResp) {
        List<Integer> httpDnsConnectExcludeErrCode = getHttpDnsConnectExcludeErrCode();
        if (netResp != null && netResp.mResult != 0 && ((httpDnsConnectExcludeErrCode.isEmpty() || !httpDnsConnectExcludeErrCode.contains(Integer.valueOf(netResp.mErrCode))) && NetworkUtil.isNetworkAvailable() && VasToggle.FEATURE_HTTPDNS.isEnable(true))) {
            return true;
        }
        return false;
    }

    private URL isDownloadHostValidAndReturn() {
        if (SystemClock.uptimeMillis() - this.recordTime > getCacheRedirectReqTime()) {
            this.preRedirectionURL = null;
        }
        return this.preRedirectionURL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFailedTask(String str) {
        int i3;
        if (TASK_FAILED_TIMES.containsKey(str)) {
            i3 = TASK_FAILED_TIMES.get(str).intValue();
        } else {
            i3 = 0;
        }
        if (i3 <= 0) {
            return false;
        }
        if (((int) (System.currentTimeMillis() / 1000)) < i3 + MAX_WAIT_SECONDS) {
            return true;
        }
        TASK_FAILED_TIMES.remove(str);
        return false;
    }

    private boolean isNeedReplaceRedirectUrl(String str) {
        IConfigProxy iConfigProxy = VasLongToggle.VAS_DOWNLOAD_REDIRECTION_REUSE_CONFIG;
        if (!iConfigProxy.isEnable(true)) {
            return false;
        }
        for (String str2 : iConfigProxy.getJson().optString("replace_white_host", "gxh.material.qq.com").split(";")) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isRedirectHost(String str) {
        IConfigProxy iConfigProxy = VasLongToggle.VAS_DOWNLOAD_REDIRECTION_REUSE_CONFIG;
        if (!iConfigProxy.isEnable(true)) {
            return false;
        }
        for (String str2 : iConfigProxy.getJson().optString("replace_redirect_host", "dlied1.cdntips.net").split(";")) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$onNetMobile2None$3(com.tencent.mobileqq.vip.g gVar) {
        gVar.p();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$onNetWifi2Mobile$1(com.tencent.mobileqq.vip.g gVar) {
        gVar.q();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$onNetWifi2None$2(com.tencent.mobileqq.vip.g gVar) {
        gVar.r();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean needIpConnect(String str) {
        String hostFromUrl = InnerDns.getHostFromUrl(str);
        if (!sIpConnectWhiteSet.contains(hostFromUrl) || TextUtils.isEmpty(hostFromUrl)) {
            return false;
        }
        return !TextUtils.isEmpty(getHostIp(hostFromUrl));
    }

    private void registerConnectionChanged(AppRuntime appRuntime, IVasDownloader.DownloadConfig downloadConfig) {
        if (downloadConfig != null && downloadConfig.useNetChangeNotify) {
            AppNetConnInfo.registerConnectionChangeReceiver(appRuntime.getApplication(), this);
        } else {
            AppNetConnInfo.unregisterNetInfoHandler(this);
        }
    }

    private void reportDirectDownload(String str, NetResp netResp) {
        VasCommonReporter.getDownLoader().setValue1("direct_download").setValue2(str).setValue3(netResp.mErrDesc).setNum1(netResp.mResult).setNum2(netResp.mErrCode).setNum3(netResp.mHttpCode).report(false);
    }

    private void reportDnsConnect(String str, NetResp netResp) {
        VasCommonReporter.getDownLoader().setValue1("ip_connect_result").setValue2(str).setValue3(netResp.mErrDesc).setValue4("" + (NetworkUtil.isNetworkAvailable() ? 1 : 0)).setValue5("" + (this.isForceDns ? 1 : 0)).setNum1(netResp.mResult).setNum2(netResp.mErrCode).setNum3(netResp.mHttpCode).report(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportDownloadResult(String str, NetResp netResp, boolean z16, boolean z17) {
        String str2;
        long j3;
        long j16;
        ReportInfo value2 = VasCommonReporter.getDownLoader().setValue1("new_download").setValue2(str);
        if (netResp == null) {
            str2 = "";
        } else {
            str2 = netResp.mErrDesc;
        }
        ReportInfo value5 = value2.setValue3(str2).setValue4("" + z16).setValue5("" + z17);
        long j17 = -10000;
        if (netResp != null) {
            j3 = netResp.mResult;
        } else {
            j3 = -10000;
        }
        ReportInfo num1 = value5.setNum1(j3);
        if (netResp != null) {
            j16 = netResp.mErrCode;
        } else {
            j16 = -10000;
        }
        ReportInfo num2 = num1.setNum2(j16);
        if (netResp != null) {
            j17 = netResp.mHttpCode;
        }
        num2.setNum3(j17).report();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportNoNetwork(String str, com.tencent.mobileqq.vip.g gVar) {
        VasCommonReporter.getDownLoader().setValue1("new_download").setValue2(str).setValue3(RaffleJsPlugin.ERROR_REPORT_NO_NETWORK).setNum1(1L).setNum2(gVar.f313006d).report();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportNoUrl(String str, com.tencent.mobileqq.vip.g gVar) {
        VasCommonReporter.getDownLoader().setValue1("new_download").setValue2(str).setValue3("no url").setNum1(1L).setNum2(gVar.f313006d).report();
    }

    private NetResp requestDownload(com.tencent.mobileqq.vip.g gVar, int i3, String str, File file, boolean z16) {
        return requestDownload(gVar, i3, str, file, z16, true);
    }

    public static boolean taskStart(String str, com.tencent.mobileqq.vip.g gVar) {
        if (!gVar.t()) {
            gVar.f313006d = AVDecodeError.VIDEO_DECODE_A_ERR;
            gVar.n();
            colorLog("doTask |  download start return false stop task:" + gVar);
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.vas.api.IVasDownloader, com.tencent.mobileqq.vip.h
    public int cancelTask(boolean z16, String str) {
        colorLog("cancelTask stopAll=" + z16 + ",key=" + str);
        synchronized (this.downloadQueue) {
            if (!this.downloadQueue.isEmpty()) {
                if (z16) {
                    Iterator<com.tencent.mobileqq.vip.g> it = this.downloadQueue.iterator();
                    while (it.hasNext()) {
                        com.tencent.mobileqq.vip.g next = it.next();
                        next.c(true);
                        next.d();
                    }
                    this.downloadQueue.clear();
                } else if (str != null && !TextUtils.isEmpty(str)) {
                    Iterator<com.tencent.mobileqq.vip.g> it5 = this.downloadQueue.iterator();
                    ArrayList arrayList = new ArrayList();
                    while (it5.hasNext()) {
                        com.tencent.mobileqq.vip.g next2 = it5.next();
                        if (str.equals(next2.f313004c)) {
                            if (!next2.k()) {
                                it5.remove();
                                arrayList.add(next2);
                            } else {
                                next2.c(true);
                                next2.d();
                            }
                        } else if (next2.j() && !next2.k()) {
                            it5.remove();
                            arrayList.add(next2);
                        }
                    }
                    if (arrayList.size() > 0) {
                        this.downloadQueue.removeAll(arrayList);
                    }
                } else {
                    return -1;
                }
            }
            return 0;
        }
    }

    @Override // com.tencent.mobileqq.vas.api.IVasDownloader
    public void clearAddressCache() {
        if (!VasToggle.BUG_CLEAR_DNS_CACHE.isEnable(false)) {
            return;
        }
        try {
            InetAddress.class.getMethod("clearDnsCache", new Class[0]).invoke(InetAddress.class, new Object[0]);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e16) {
            QLog.i(TAG, 1, "reflect clearDnsCache exception", e16);
        }
    }

    synchronized void doTask() {
        synchronized (this.downloadQueue) {
            Iterator<com.tencent.mobileqq.vip.g> it = this.downloadQueue.iterator();
            while (true) {
                boolean z16 = true;
                boolean z17 = false;
                if (!it.hasNext()) {
                    break;
                }
                com.tencent.mobileqq.vip.g next = it.next();
                if (next.A > 0) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (next.k() || currentTimeMillis <= next.f313028z + next.A) {
                        z16 = false;
                    }
                    z17 = z16;
                }
                if (next.j() || z17) {
                    it.remove();
                    colorLog("remove task[" + next.f313004c + "], isCancal=" + next.j() + ", timeOut=" + z17);
                }
            }
        }
        colorLog("doTask | downloadLimitCount=" + this.downloadLimitCount.get() + ",maxDownloadCount=" + MAX_DOWNLOAD_TASK_NUM + ",downloadQueue size=" + this.downloadQueue.size());
        while (this.downloadLimitCount.get() <= MAX_DOWNLOAD_TASK_NUM) {
            final com.tencent.mobileqq.vip.g nextTask = getNextTask();
            if (nextTask == null) {
                colorLog("doTask | run() null");
                return;
            } else {
                ThreadManagerV2.postDownLoadTask(new Runnable() { // from class: com.tencent.mobileqq.vas.api.impl.VasDownloaderImpl.1
                    @Override // java.lang.Runnable
                    public void run() {
                        NetResp netResp;
                        boolean z18;
                        VasDownloaderImpl.colorLog("doTask | run() downloadLimitCount=" + VasDownloaderImpl.this.downloadLimitCount.get() + ",task=" + nextTask);
                        com.tencent.mobileqq.vip.g gVar = nextTask;
                        if (gVar.f313023u && VasDownloaderImpl.this.isFailedTask(gVar.f313004c)) {
                            com.tencent.mobileqq.vip.g gVar2 = nextTask;
                            gVar2.f313006d = -101;
                            gVar2.y(-1);
                            nextTask.n();
                            VasDownloaderImpl.this.removeTask(nextTask);
                            VasDownloaderImpl.this.downloadLimitCount.addAndGet(-1);
                            VasDownloaderImpl.this.doTask();
                            VasDownloaderImpl.colorLog("doTask | run() task is limit of failTime, task=" + nextTask);
                            return;
                        }
                        VasDownloaderImpl.taskStart(VasDownloaderImpl.TAG, nextTask);
                        int i3 = 0;
                        for (String str : nextTask.f313009g) {
                            File file = nextTask.f313010h.get(str);
                            if (file == null) {
                                nextTask.f313006d = -110;
                                QLog.w(VasDownloaderImpl.TAG, 2, "doTask | download task error task file param is null");
                                VasDownloaderImpl.handleWhenDownloadFinished(VasDownloaderImpl.TAG, nextTask, -1);
                            } else if (TextUtils.isEmpty(str)) {
                                nextTask.f313006d = -119;
                                QLog.w(VasDownloaderImpl.TAG, 2, "doTask | download task error task url param is null");
                                VasDownloaderImpl.this.reportNoUrl(str, nextTask);
                                VasDownloaderImpl.handleWhenDownloadFinished(VasDownloaderImpl.TAG, nextTask, -1);
                            } else if (!NetworkUtil.isNetworkAvailable()) {
                                nextTask.f313006d = -120;
                                QLog.w(VasDownloaderImpl.TAG, 2, "doTask | download task error task no network");
                                VasDownloaderImpl.this.reportNoNetwork(str, nextTask);
                                VasDownloaderImpl.handleWhenDownloadFinished(VasDownloaderImpl.TAG, nextTask, -1);
                            } else {
                                if (!VasDownloaderImpl.this.isForceDns) {
                                    netResp = VasDownloaderImpl.this.directRequest(i3, str, file, nextTask);
                                    if (netResp == null) {
                                        return;
                                    }
                                } else {
                                    netResp = null;
                                }
                                boolean z19 = true;
                                if (!VasDownloaderImpl.this.isForceDns && !VasDownloaderImpl.this.isCanUseHttpDns(netResp)) {
                                    z18 = false;
                                } else {
                                    z18 = true;
                                }
                                if (z18 && VasDownloaderImpl.this.needIpConnect(str)) {
                                    netResp = VasDownloaderImpl.this.ipConnectRequest(i3, str, file, nextTask);
                                    if (netResp == null) {
                                        return;
                                    }
                                } else {
                                    z19 = false;
                                }
                                if (VasDownloaderImpl.this.isForceDns && !z19) {
                                    netResp = VasDownloaderImpl.this.directRequest(i3, str, file, nextTask);
                                }
                                if (netResp != null) {
                                    VasDownloaderImpl.this.reportDownloadResult(str, netResp, z18, z19);
                                    if (netResp.mResult != 0 && netResp.mErrCode == 9055) {
                                        VasDownloaderImpl.this.clearAddressCache();
                                    }
                                    VasDownloaderImpl.this.handleIfTaskFailed(netResp.mResult, nextTask, str);
                                    VasDownloaderImpl.handleWhenDownloadFinished(VasDownloaderImpl.TAG, nextTask, netResp.mResult);
                                    VasDownloaderImpl.colorLog("doTask | run() download task result=" + netResp.mResult + ",task=" + nextTask);
                                } else {
                                    return;
                                }
                            }
                            i3++;
                        }
                        VasDownloaderImpl.this.removeTask(nextTask);
                        VasDownloaderImpl.this.downloadLimitCount.addAndGet(-1);
                        VasDownloaderImpl.this.doTask();
                    }

                    @NonNull
                    public String toString() {
                        String str;
                        try {
                            StringBuilder sb5 = new StringBuilder();
                            List<String> list = nextTask.f313009g;
                            if (list != null && list.size() != 0) {
                                str = nextTask.f313009g.get(0);
                                sb5.append(VasDownloaderImpl.TAG);
                                sb5.append(" current task:");
                                sb5.append(str);
                                sb5.append(",downloadQueue size:");
                                sb5.append(VasDownloaderImpl.this.downloadQueue.size());
                                return sb5.toString();
                            }
                            str = nextTask.f313004c;
                            sb5.append(VasDownloaderImpl.TAG);
                            sb5.append(" current task:");
                            sb5.append(str);
                            sb5.append(",downloadQueue size:");
                            sb5.append(VasDownloaderImpl.this.downloadQueue.size());
                            return sb5.toString();
                        } catch (Exception e16) {
                            QLog.e(VasDownloaderImpl.TAG, 1, e16, new Object[0]);
                            return super.toString();
                        }
                    }
                }, 2, null, false);
                this.downloadLimitCount.addAndGet(1);
            }
        }
    }

    @NotNull
    String getNetTypeStr() {
        return String.valueOf(NetworkUtil.getSystemNetwork(MobileQQ.sMobileQQ.getApplicationContext()));
    }

    @Override // com.tencent.mobileqq.vas.api.IVasDownloader, com.tencent.mobileqq.vip.h
    public com.tencent.mobileqq.vip.g getTask(String str) {
        synchronized (this.downloadQueue) {
            if (str != null) {
                if (!this.downloadQueue.isEmpty()) {
                    Iterator<com.tencent.mobileqq.vip.g> it = this.downloadQueue.iterator();
                    while (it.hasNext()) {
                        com.tencent.mobileqq.vip.g next = it.next();
                        if (str.equals(next.f313004c)) {
                            colorLog("getTask | " + str + " task find =" + next);
                            return next;
                        }
                    }
                }
            }
            colorLog("getTask | " + str + " task not find");
            return null;
        }
    }

    @Override // com.tencent.mobileqq.vas.api.IVasDownloader
    public void init(AppRuntime appRuntime, IVasDownloader.DownloadConfig downloadConfig) {
        this.isInit = true;
        httpDnsInit();
        registerConnectionChanged(appRuntime, downloadConfig);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasDownloader, com.tencent.mobileqq.vip.h
    public void onDestroy() {
        TASK_FAILED_TIMES.clear();
        cancelTask(true, null);
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetMobile2None() {
        handleNetChanged("queueDownload network-onNetMobile2None", new Function1() { // from class: com.tencent.mobileqq.vas.api.impl.ah
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object lambda$onNetMobile2None$3;
                lambda$onNetMobile2None$3 = VasDownloaderImpl.lambda$onNetMobile2None$3((com.tencent.mobileqq.vip.g) obj);
                return lambda$onNetMobile2None$3;
            }
        });
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetMobile2Wifi(String str) {
        colorLog("queueDownload network-onNetMobile2Wifi");
        TASK_FAILED_TIMES.clear();
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetNone2Mobile(String str) {
        colorLog("queueDownload network-onNetNone2Mobile");
        TASK_FAILED_TIMES.clear();
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetNone2Wifi(String str) {
        colorLog("queueDownload network-onNetNone2Wifi");
        TASK_FAILED_TIMES.clear();
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetWifi2Mobile(String str) {
        handleNetChanged("queueDownload network-onNetWifi2Mobile", new Function1() { // from class: com.tencent.mobileqq.vas.api.impl.ag
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object lambda$onNetWifi2Mobile$1;
                lambda$onNetWifi2Mobile$1 = VasDownloaderImpl.lambda$onNetWifi2Mobile$1((com.tencent.mobileqq.vip.g) obj);
                return lambda$onNetWifi2Mobile$1;
            }
        });
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetWifi2None() {
        handleNetChanged("queueDownload network-onNetWifi2None", new Function1() { // from class: com.tencent.mobileqq.vas.api.impl.ae
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object lambda$onNetWifi2None$2;
                lambda$onNetWifi2None$2 = VasDownloaderImpl.lambda$onNetWifi2None$2((com.tencent.mobileqq.vip.g) obj);
                return lambda$onNetWifi2None$2;
            }
        });
    }

    public void removeTask(com.tencent.mobileqq.vip.g gVar) {
        synchronized (this.downloadQueue) {
            if (gVar != null) {
                if (!this.downloadQueue.isEmpty() && this.downloadQueue.contains(gVar)) {
                    colorLog("removeTask | task=" + gVar);
                    gVar.d();
                    this.downloadQueue.remove(gVar);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.vas.api.IVasDownloader, com.tencent.mobileqq.vip.h
    public void startDownload(com.tencent.mobileqq.vip.g gVar, com.tencent.mobileqq.vip.f fVar, Bundle bundle) {
        String str;
        if (!this.isInit) {
            init(MobileQQ.sMobileQQ.peekAppRuntime(), new IVasDownloader.DownloadConfig(true));
        }
        com.tencent.mobileqq.vip.g task = getTask(gVar.f313004c);
        if (task != null) {
            if (task.f313001a0) {
                gVar.u(fVar);
                gVar.w(bundle);
                AppRuntime app = VasUtil.getApp();
                if (app != null) {
                    g.a aVar = gVar.Z;
                    if (aVar.f313030b < 0) {
                        aVar.f313030b = app.getLongAccountUin();
                    }
                }
                task.a(gVar);
                return;
            }
            return;
        }
        gVar.u(fVar);
        gVar.w(bundle);
        gVar.Y = 3;
        AppRuntime app2 = VasUtil.getApp();
        if (app2 != null) {
            g.a aVar2 = gVar.Z;
            if (aVar2.f313030b < 0) {
                aVar2.f313030b = app2.getLongAccountUin();
            }
        }
        synchronized (this.downloadQueue) {
            com.tencent.mobileqq.vip.g task2 = getTask(gVar.f313004c);
            if (task2 == null) {
                gVar.f313028z = (int) (System.currentTimeMillis() / 1000);
                if (gVar.f313019q) {
                    this.downloadQueue.addFirst(gVar);
                } else {
                    this.downloadQueue.addLast(gVar);
                }
            } else if (gVar.f313019q && !task2.k() && this.downloadQueue.remove(task2)) {
                this.downloadQueue.addFirst(task2);
            }
        }
        List<String> list = gVar.f313009g;
        if (list != null && list.size() != 0) {
            str = gVar.f313009g.get(0);
        } else {
            str = null;
        }
        colorLog("startDownload | task=" + gVar.f313004c + ", url:" + str);
        doTask();
    }

    @NonNull
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.downloadQueue.size() > 0) {
            synchronized (this.downloadQueue) {
                Iterator<com.tencent.mobileqq.vip.g> it = this.downloadQueue.iterator();
                while (it.hasNext()) {
                    com.tencent.mobileqq.vip.g next = it.next();
                    sb5.append("key=");
                    sb5.append(next.f313004c);
                    List<String> list = next.f313009g;
                    if (list != null && list.size() > 0) {
                        sb5.append(",size=");
                        sb5.append(next.f313009g.size());
                        sb5.append(JefsClass.INDEX_URL);
                        sb5.append(next.f313009g.get(0));
                    }
                    sb5.append(";");
                }
            }
        }
        return "QueueDownloader task url:" + ((Object) sb5);
    }

    private NetResp requestDownload(com.tencent.mobileqq.vip.g gVar, int i3, String str, File file, boolean z16, boolean z17) {
        boolean z18;
        String str2;
        HttpNetReq httpNetReq = new HttpNetReq();
        URL isDownloadHostValidAndReturn = isDownloadHostValidAndReturn();
        if (isDownloadHostValidAndReturn == null || !isNeedReplaceRedirectUrl(str)) {
            z18 = false;
            str2 = str;
        } else {
            str2 = "https://" + isDownloadHostValidAndReturn.getHost() + "/" + str.substring(8) + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + isDownloadHostValidAndReturn.getQuery();
            z18 = true;
            QLog.i(TAG, 1, "finalUrl:" + str2);
        }
        httpNetReq.mReqUrl = str2;
        httpNetReq.mOutPath = file.getAbsolutePath();
        httpNetReq.mNeedIpConnect = z16;
        httpNetReq.mIsHttps = str2.startsWith("https://");
        httpNetReq.mHostForHttpsVerify = InnerDns.getHostFromUrl(str2);
        if (z16) {
            httpNetReq.mServerList = lambda$requestDownload$0(InnerDns.getHostFromUrl(str2));
            httpNetReq.mHostParseToIp = new NetReq.HostParseToIp() { // from class: com.tencent.mobileqq.vas.api.impl.af
                @Override // com.tencent.mobileqq.transfile.NetReq.HostParseToIp
                public final List getIpByHost(String str3) {
                    List lambda$requestDownload$0;
                    lambda$requestDownload$0 = VasDownloaderImpl.this.lambda$requestDownload$0(str3);
                    return lambda$requestDownload$0;
                }
            };
        }
        httpNetReq.mCallback = getNetEngineListener(gVar, i3);
        httpNetReq.onResponseURL = getCacheRedirectUrlCallback();
        httpNetReq.mDnsParseCallback = getDnsReportCallback(z18, str, str2, httpNetReq);
        NetResp sendReqSync = ((IHttpEngineService) VasUtil.getApp().getRuntimeService(IHttpEngineService.class, "all")).sendReqSync(httpNetReq);
        if (!z17 || sendReqSync.mResult == 0 || !z18) {
            return sendReqSync;
        }
        this.preRedirectionURL = null;
        this.recordTime = 0L;
        return requestDownload(gVar, i3, str, file, z16, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b implements INetEngineListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.vip.g f308494d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f308495e;

        b(com.tencent.mobileqq.vip.g gVar, int i3) {
            this.f308494d = gVar;
            this.f308495e = i3;
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
            this.f308494d.x(j16, j3, this.f308495e);
            if (this.f308494d.g() != null) {
                this.f308494d.g().onProgress(this.f308494d);
            }
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onResp(NetResp netResp) {
        }
    }
}
