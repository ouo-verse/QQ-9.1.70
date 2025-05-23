package com.tencent.component.network.downloader.strategy;

import android.text.TextUtils;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.Global;
import com.tencent.component.network.NetworkManager;
import com.tencent.component.network.downloader.DownloadReport;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.common.IPInfo;
import com.tencent.component.network.downloader.common.Utils;
import com.tencent.component.network.downloader.strategy.DownloadGlobalStrategy;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.module.common.DnsService;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.component.network.utils.http.HttpUtil;
import com.tencent.component.network.utils.http.base.QZoneHttpClient;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.protocol.HttpContext;

/* loaded from: classes5.dex */
public class StrategyProvider {
    private static final String TAG = "StrategyProvider";
    public static IPConfigStrategy backupIPConfigStrategy;
    public static IPConfigStrategy directIPConfigStrategy;
    public static PortConfigStrategy portConfigStrategy;
    private static HttpUtil.ClientOptions soptions = new HttpUtil.ClientOptions(true);
    private static HttpClient sHttpClient = null;
    private static final ThreadLocal<HttpUtil.RequestOptions> sRequestOptions = new ThreadLocal<HttpUtil.RequestOptions>() { // from class: com.tencent.component.network.downloader.strategy.StrategyProvider.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public HttpUtil.RequestOptions initialValue() {
            return new HttpUtil.RequestOptions();
        }
    };

    /* loaded from: classes5.dex */
    public static class ExecuteResult {
        public HttpContext context;
        public Throwable exception;
        public HttpGet request;
        public HttpResponse response;
        public DownloadGlobalStrategy.StrategyInfo strategyInfo;
    }

    /* loaded from: classes5.dex */
    public interface RequestProcessor {
        void prepareRequest(String str, HttpRequest httpRequest);
    }

    public static ExecuteResult exeHttpRequest(String str, DownloadGlobalStrategy.StrategyLib strategyLib, int i3, RequestProcessor requestProcessor, HttpRequest httpRequest, DownloadResult downloadResult, DownloadReport downloadReport, Proxy proxy, HttpUtil.ClientOptions clientOptions) {
        DownloadGlobalStrategy.StrategyInfo strategyInfo;
        HttpGet httpGet;
        String str2;
        ExecuteResult executeResult = new ExecuteResult();
        try {
            strategyInfo = generateStrategyInfo(str, strategyLib, i3);
        } catch (Throwable th5) {
            th = th5;
            strategyInfo = null;
            httpGet = null;
        }
        if (strategyInfo == null) {
            executeResult.request = null;
            executeResult.response = null;
            executeResult.strategyInfo = strategyInfo;
            return null;
        }
        try {
            HttpUtil.RequestOptions requestOptions = sRequestOptions.get();
            requestOptions.allowProxy = strategyInfo.allowProxy;
            requestOptions.apnProxy = strategyInfo.useConfigApn;
            requestOptions.mobileProxy = proxy;
            if (strategyInfo.getIPInfo() != null && !TextUtils.isEmpty(strategyInfo.getIPInfo().f99897ip)) {
                String str3 = strategyInfo.getIPInfo().f99897ip;
                if (Utils.count(str3, ':') < 2) {
                    int port = Utils.getPort(str);
                    if (port > 0) {
                        strategyInfo.getIPInfo().port = port;
                    } else {
                        port = strategyInfo.getIPInfo().port;
                    }
                    if (!Utils.isPortValid(port)) {
                        port = 80;
                    }
                    String str4 = str3 + ":" + port;
                    str2 = str.replaceFirst(Utils.getDominWithPort(str), str4);
                    if (QDLog.isInfoEnable()) {
                        QDLog.i(TAG, "downloader strategy run: " + strategyInfo.toString() + " domain:" + str4 + " url:" + str + " threadId:" + Thread.currentThread().getId());
                    }
                } else {
                    str2 = str;
                }
                if (downloadReport != null) {
                    downloadReport.strategyInfo = strategyInfo.toString();
                }
            } else {
                str2 = str;
            }
            httpGet = HttpUtil.createHttpGet(Global.getContext(), str, Utils.getDomin(str), str2, requestOptions);
            if (requestProcessor != null) {
                try {
                    requestProcessor.prepareRequest(str, httpGet);
                } catch (Throwable th6) {
                    th = th6;
                    if (downloadResult != null) {
                        try {
                            downloadResult.getStatus().setFailed(th);
                        } catch (Throwable th7) {
                            executeResult.request = httpGet;
                            executeResult.response = null;
                            executeResult.strategyInfo = strategyInfo;
                            throw th7;
                        }
                    }
                    executeResult.exception = th;
                    executeResult.request = httpGet;
                    executeResult.response = null;
                    executeResult.strategyInfo = strategyInfo;
                    return executeResult;
                }
            }
            HttpContext createHttpContext = HttpUtil.createHttpContext();
            executeResult.context = createHttpContext;
            HttpResponse execute = obtainHttpClient(clientOptions).execute(httpGet, createHttpContext);
            executeResult.request = httpGet;
            executeResult.response = execute;
        } catch (Throwable th8) {
            th = th8;
            httpGet = null;
        }
        executeResult.strategyInfo = strategyInfo;
        return executeResult;
    }

    public static DownloadGlobalStrategy.StrategyInfo generateStrategyInfo(String str, DownloadGlobalStrategy.StrategyLib strategyLib, int i3) {
        if (TextUtils.isEmpty(str) || strategyLib == null || i3 < 0) {
            return null;
        }
        DownloadGlobalStrategy.StrategyInfo oldStrategyInfo = strategyLib.getOldStrategyInfo();
        DownloadGlobalStrategy.StrategyInfo strategyInfo = strategyLib.getStrategyInfo(i3);
        strategyLib.setOldStrategyInfo(strategyInfo);
        if (QDLog.isInfoEnable()) {
            QDLog.i(TAG, "downloader strategy: " + strategyInfo.toString() + " currAttempCount:" + i3 + " best:" + strategyLib.getBestId() + " url:" + str + " Apn:" + NetworkManager.getApnValue() + " ISP:" + NetworkManager.getIspType() + " threadid:" + Thread.currentThread().getId());
        }
        String domin = Utils.getDomin(str);
        int port = strategyLib.getPort();
        if (!Utils.isPortValid(port)) {
            port = 80;
            strategyLib.setPort(80);
        }
        int i16 = DownloadGlobalStrategy.Strategy_BACKUPIP.f99899id;
        int i17 = strategyInfo.f99899id;
        if (i16 == i17) {
            if (oldStrategyInfo != null && i16 == oldStrategyInfo.f99899id) {
                PortConfigStrategy portConfigStrategy2 = portConfigStrategy;
                if (portConfigStrategy2 != null && portConfigStrategy2.supportExtraPort(domin)) {
                    int changePort = portConfigStrategy.changePort(domin, port);
                    if (changePort == port || !Utils.isPortValid(changePort)) {
                        if (QDLog.isInfoEnable()) {
                            QDLog.i(TAG, "downloader strategy: Pass! port:" + port + " newport:" + changePort + " threadId:" + Thread.currentThread().getId());
                        }
                        return null;
                    }
                    port = changePort;
                } else {
                    if (QDLog.isInfoEnable()) {
                        QDLog.i(TAG, "downloader strategy: Pass! Not support !80. threadId:" + Thread.currentThread().getId());
                    }
                    return null;
                }
            }
            String backupIP = strategyLib.getBackupIP();
            IPConfigStrategy iPConfigStrategy = backupIPConfigStrategy;
            if (iPConfigStrategy != null && !iPConfigStrategy.isIPValid(backupIP, domin)) {
                strategyLib.setBackupIP(null);
                backupIP = backupIPConfigStrategy.resolveIP(domin);
                if (!TextUtils.isEmpty(backupIP)) {
                    strategyLib.setBackupIP(backupIP);
                } else {
                    if (QDLog.isInfoEnable()) {
                        QDLog.i(TAG, "downloader strategy: backup ip is null. Pass! threadId:" + Thread.currentThread().getId());
                    }
                    return null;
                }
            }
            if (backupIP != null && !backupIP.equals(strategyLib.getDirectIP()) && !backupIP.equals(strategyLib.getDnsIP())) {
                DownloadGlobalStrategy.StrategyInfo m107clone = strategyInfo.m107clone();
                m107clone.setIPInfo(new IPInfo(backupIP, port));
                return m107clone;
            }
            if (QDLog.isInfoEnable()) {
                QDLog.i(TAG, "downloader strategy: Pass! Domain IP \u91cd\u590d. threadId:" + Thread.currentThread().getId());
            }
            return null;
        }
        int i18 = DownloadGlobalStrategy.Strategy_DOMAIN_FORCE.f99899id;
        if (i18 == i17) {
            if (oldStrategyInfo != null && i18 == oldStrategyInfo.f99899id) {
                PortConfigStrategy portConfigStrategy3 = portConfigStrategy;
                if (portConfigStrategy3 != null && portConfigStrategy3.supportExtraPort(domin)) {
                    int changePort2 = portConfigStrategy.changePort(domin, port);
                    if (changePort2 == port || !Utils.isPortValid(changePort2)) {
                        if (QDLog.isInfoEnable()) {
                            QDLog.i(TAG, "downloader strategy: Pass! port:" + port + " newport:" + changePort2 + " threadId:" + Thread.currentThread().getId());
                        }
                        return null;
                    }
                    port = changePort2;
                } else {
                    if (QDLog.isInfoEnable()) {
                        QDLog.i(TAG, "downloader strategy: Pass! Not support !80. threadId:" + Thread.currentThread().getId());
                    }
                    return null;
                }
            }
            String domainIP = DnsService.getInstance().getDomainIP(domin);
            if (domainIP != null && !domainIP.equals(strategyLib.getBackupIP()) && !domainIP.equals(strategyLib.getDirectIP())) {
                strategyLib.setDnsIP(domainIP);
                DownloadGlobalStrategy.StrategyInfo m107clone2 = strategyInfo.m107clone();
                m107clone2.setIPInfo(new IPInfo(domainIP, port));
                return m107clone2;
            }
            if (QDLog.isInfoEnable()) {
                QDLog.i(TAG, "downloader strategy: Pass! Domain IP \u91cd\u590d. threadId:" + Thread.currentThread().getId());
            }
            return null;
        }
        int i19 = DownloadGlobalStrategy.Strategy_DomainDirect.f99899id;
        if (i19 == i17) {
            if (oldStrategyInfo != null && i19 == oldStrategyInfo.f99899id) {
                PortConfigStrategy portConfigStrategy4 = portConfigStrategy;
                if (portConfigStrategy4 != null && portConfigStrategy4.supportExtraPort(domin)) {
                    int changePort3 = portConfigStrategy.changePort(domin, port);
                    if (changePort3 == port || !Utils.isPortValid(changePort3)) {
                        if (QDLog.isInfoEnable()) {
                            QDLog.i(TAG, "downloader strategy: Pass! port:" + port + " newport:" + changePort3 + " threadId:" + Thread.currentThread().getId());
                        }
                        return null;
                    }
                    port = changePort3;
                } else {
                    if (QDLog.isInfoEnable()) {
                        QDLog.i(TAG, "downloader strategy: Pass! Not support !80. threadId:" + Thread.currentThread().getId());
                    }
                    return null;
                }
            }
        } else if (DownloadGlobalStrategy.Strategy_DomainProxy_SYS.f99899id == i17 || DownloadGlobalStrategy.Strategy_DomainProxy_CON.f99899id == i17) {
            if (NetworkUtils.getProxy(Global.getContext(), DownloadGlobalStrategy.Strategy_DomainProxy_CON.f99899id == strategyInfo.f99899id) != null) {
                return strategyInfo;
            }
            if (QDLog.isInfoEnable()) {
                QDLog.i(TAG, "downloader strategy: proxy is null. Pass! threadId:" + Thread.currentThread().getId());
            }
            return null;
        }
        String directIP = strategyLib.getDirectIP();
        IPConfigStrategy iPConfigStrategy2 = directIPConfigStrategy;
        if (iPConfigStrategy2 != null && !iPConfigStrategy2.isIPValid(directIP, domin)) {
            directIP = directIPConfigStrategy.resolveIP(domin);
            if (!TextUtils.isEmpty(directIP)) {
                strategyLib.setDirectIP(directIP);
            } else {
                if (QDLog.isInfoEnable()) {
                    QDLog.i(TAG, "downloader strategy: resolve ip failed! threadId:" + Thread.currentThread().getId());
                }
                int i26 = DownloadGlobalStrategy.Strategy_DomainProxy_SYS.f99899id;
                int i27 = strategyInfo.f99899id;
                if (i26 != i27 && DownloadGlobalStrategy.Strategy_DomainProxy_CON.f99899id != i27) {
                    return null;
                }
            }
        }
        if (directIP != null && !directIP.equals(strategyLib.getBackupIP()) && !directIP.equals(strategyLib.getDnsIP())) {
            DownloadGlobalStrategy.StrategyInfo m107clone3 = strategyInfo.m107clone();
            m107clone3.setIPInfo(new IPInfo(directIP, port));
            return m107clone3;
        }
        if (QDLog.isInfoEnable()) {
            QDLog.i(TAG, "downloader strategy: Pass! Domain IP \u91cd\u590d. threadId:" + Thread.currentThread().getId());
        }
        return null;
    }

    private static HttpClient obtainHttpClient(HttpUtil.ClientOptions clientOptions) {
        QZoneHttpClient createHttpClient;
        HttpClient httpClient = sHttpClient;
        if (httpClient != null) {
            return httpClient;
        }
        synchronized (StrategyProvider.class) {
            if (clientOptions == null) {
                clientOptions = soptions;
            }
            createHttpClient = HttpUtil.createHttpClient(clientOptions);
            sHttpClient = createHttpClient;
        }
        return createHttpClient;
    }

    public static void onIPDownloadResult(String str, IPInfo iPInfo, boolean z16) {
        String domin = Utils.getDomin(str);
        if (!TextUtils.isEmpty(domin) && iPInfo != null) {
            if (DownloaderFactory.getInstance(Global.getContext()).getDirectIpStrategy() != null) {
                DownloaderFactory.getInstance(Global.getContext()).getDirectIpStrategy().onIPAccessResult(domin, iPInfo.f99897ip, z16);
            }
            if (DownloaderFactory.getInstance(Global.getContext()).getBackupIpStrategy() != null) {
                DownloaderFactory.getInstance(Global.getContext()).getBackupIpStrategy().onIPAccessResult(domin, iPInfo.f99897ip, z16);
            }
            DownloadGlobalStrategy.StrategyInfo strategyInfo = new DownloadGlobalStrategy.StrategyInfo(false, false, false);
            strategyInfo.f99899id = 0;
            strategyInfo.setIPInfo(iPInfo);
            DownloadGlobalStrategy.getInstance(Global.getContext()).report(Global.getContext(), str, domin, strategyInfo, z16);
        }
    }

    public static List<IPInfo> provideIPList(String str) {
        int i3;
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String domin = Utils.getDomin(str);
        if (TextUtils.isEmpty(domin)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList<String> arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        DownloadGlobalStrategy.StrategyInfo bestStrategyInfo = DownloadGlobalStrategy.getInstance(Global.getContext()).getBestStrategyInfo(str, domin);
        if (bestStrategyInfo != null && bestStrategyInfo.getIPInfo() != null && bestStrategyInfo.isIPValid()) {
            str2 = bestStrategyInfo.getIPInfo().f99897ip;
            arrayList2.add(str2);
            if (bestStrategyInfo.getIPInfo().port != 0) {
                i3 = bestStrategyInfo.getIPInfo().port;
            } else {
                i3 = 80;
            }
            arrayList3.add(Integer.valueOf(i3));
        }
        if (DownloaderFactory.getInstance(Global.getContext()).getPortStrategy() != null) {
            if (arrayList3.size() > 0) {
                int changePort = DownloaderFactory.getInstance(Global.getContext()).getPortStrategy().changePort(domin, ((Integer) arrayList3.get(0)).intValue());
                if (changePort != ((Integer) arrayList3.get(0)).intValue()) {
                    arrayList3.add(Integer.valueOf(changePort));
                }
            } else {
                arrayList3.add(80);
            }
        }
        if (DownloaderFactory.getInstance(Global.getContext()).getDirectIpStrategy() != null) {
            String resolveIP = DownloaderFactory.getInstance(Global.getContext()).getDirectIpStrategy().resolveIP(domin);
            if (!TextUtils.isEmpty(resolveIP) && !resolveIP.equalsIgnoreCase(str2)) {
                arrayList2.add(resolveIP);
            }
        }
        if (DownloaderFactory.getInstance(Global.getContext()).getBackupIpStrategy() != null) {
            String resolveIP2 = DownloaderFactory.getInstance(Global.getContext()).getBackupIpStrategy().resolveIP(domin);
            if (!TextUtils.isEmpty(resolveIP2) && !resolveIP2.equalsIgnoreCase(str2)) {
                arrayList2.add(resolveIP2);
            }
        }
        for (String str3 : arrayList2) {
            Iterator it = arrayList3.iterator();
            while (it.hasNext()) {
                arrayList.add(new IPInfo(str3, ((Integer) it.next()).intValue()));
            }
        }
        return arrayList;
    }

    public static DownloadGlobalStrategy.StrategyLib provideStrategyLib(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return DownloadGlobalStrategy.getInstance(Global.getContext()).getStrategyLib(str, Utils.getDomin(str), false);
    }

    public static List<IPInfo> provideVideoIPList(String str) {
        List<IPInfo> resolveVideoIP;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String domin = Utils.getDomin(str);
        if (TextUtils.isEmpty(domin)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            if (DownloaderFactory.getInstance(Global.getContext()).getDirectIpStrategy() != null && (resolveVideoIP = DownloaderFactory.getInstance(Global.getContext()).getDirectIpStrategy().resolveVideoIP(domin)) != null) {
                if (resolveVideoIP.size() > 0) {
                    return resolveVideoIP;
                }
                return arrayList;
            }
            return arrayList;
        } catch (Exception e16) {
            if (QDLog.isInfoEnable()) {
                QDLog.i(TAG, "provide video ip list error = " + e16.toString());
                return arrayList;
            }
            return arrayList;
        }
    }

    private static void initHttpClient(QZoneHttpClient qZoneHttpClient) {
    }
}
