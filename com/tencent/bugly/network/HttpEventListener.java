package com.tencent.bugly.network;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.bugly.common.thread.ThreadManager;
import com.tencent.rmonitor.common.logger.Logger;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes5.dex */
public class HttpEventListener extends EventListener {
    private static final long CHECK_INTERVAL = 30000;
    private static final String TAG = "RMonitor_net_quality";
    private final HttpReportMetaCollector metaCollector;
    private final ConcurrentHashMap<Call, HttpRequestQualityData> qualityDataHashMap = new ConcurrentHashMap<>();
    private final AtomicBoolean isStart = new AtomicBoolean(false);
    private final AsyncDelayCheckTask checkTask = new AsyncDelayCheckTask();

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class AsyncDelayCheckTask implements Runnable {
        private final AtomicBoolean isChecking = new AtomicBoolean(false);

        public AsyncDelayCheckTask() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                HttpEventListener.this.checkCallEnd();
            } catch (Throwable th5) {
                Logger.f365497g.c(HttpEventListener.TAG, th5);
            }
            this.isChecking.compareAndSet(true, false);
            if (!HttpEventListener.this.isMapEmpty()) {
                startDelayCheck();
            }
        }

        public void startDelayCheck() {
            long j3;
            if (this.isChecking.compareAndSet(false, true)) {
                NetQualityPluginConfig config = HttpEventListener.this.getConfig();
                if (config != null) {
                    j3 = config.callEndDelayOther;
                } else {
                    j3 = 30000;
                }
                if (Logger.verbos) {
                    Logger.f365497g.v(HttpEventListener.TAG, "startDelayCheck, delay: " + j3);
                }
                ThreadManager.runInMonitorThread(this, j3);
            }
        }
    }

    public HttpEventListener(HttpReportMetaCollector httpReportMetaCollector) {
        this.metaCollector = httpReportMetaCollector;
    }

    private String getHost(InetSocketAddress inetSocketAddress) {
        String str;
        if (inetSocketAddress == null) {
            return null;
        }
        try {
            InetAddress address = inetSocketAddress.getAddress();
            if (address != null) {
                str = address.getHostAddress();
            } else {
                str = null;
            }
            String hostString = inetSocketAddress.getHostString();
            if (TextUtils.equals(str, hostString)) {
                return null;
            }
            return hostString;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // okhttp3.EventListener
    public void callEnd(Call call) {
        HttpRequestQualityData removeHttpRequestQualityData = removeHttpRequestQualityData(call);
        if (removeHttpRequestQualityData == null) {
            return;
        }
        removeHttpRequestQualityData.isCanceled = call.getCanceled();
        removeHttpRequestQualityData.addEvent("callEnd");
        removeHttpRequestQualityData.onCallEnd("callEnd", null);
        onCallFinished(removeHttpRequestQualityData);
    }

    @Override // okhttp3.EventListener
    public void callFailed(Call call, IOException iOException) {
        HttpRequestQualityData removeHttpRequestQualityData = removeHttpRequestQualityData(call);
        if (removeHttpRequestQualityData == null) {
            return;
        }
        boolean z16 = true;
        if (Logger.verbos) {
            Logger.f365497g.v(TAG, "callFailed, isCanceled: " + call.getCanceled() + ", " + iOException);
        }
        if (!call.getCanceled() && !isCloseByUser(iOException, removeHttpRequestQualityData.responseCode)) {
            z16 = false;
        }
        removeHttpRequestQualityData.isCanceled = z16;
        if (z16) {
            removeHttpRequestQualityData.addEvent("callEnd");
            removeHttpRequestQualityData.onCallEnd("callEnd", iOException);
        } else {
            removeHttpRequestQualityData.addEvent("callFailed");
            removeHttpRequestQualityData.onCallEnd("callFailed", iOException);
        }
        onCallFinished(removeHttpRequestQualityData);
    }

    @Override // okhttp3.EventListener
    public void callStart(Call call) {
        HttpRequestQualityData obtainHttpRequestQualityData = obtainHttpRequestQualityData(call);
        if (obtainHttpRequestQualityData == null) {
            return;
        }
        obtainHttpRequestQualityData.addEvent("callStart");
        obtainHttpRequestQualityData.updateRequest("callStart", call.request());
        this.checkTask.startDelayCheck();
    }

    protected void checkCallEnd() {
        if (isMapEmpty()) {
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        HashSet hashSet = new HashSet();
        for (Map.Entry<Call, HttpRequestQualityData> entry : this.qualityDataHashMap.entrySet()) {
            HttpRequestQualityData value = entry.getValue();
            Call key = entry.getKey();
            if (value != null && value.isSuspicious(elapsedRealtime, getConfig())) {
                hashSet.add(key);
            }
        }
        if (Logger.verbos) {
            Logger.f365497g.v(TAG, "checkCallEnd, count: " + hashSet.size());
        }
        forceCallEnd(hashSet);
    }

    @Override // okhttp3.EventListener
    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, @Nullable Protocol protocol2) {
        HttpRequestQualityData findHttpRequestQualityData = findHttpRequestQualityData(call);
        if (findHttpRequestQualityData == null) {
            return;
        }
        findHttpRequestQualityData.addEvent("connectEnd");
        findHttpRequestQualityData.onConnectEnd(false, inetSocketAddress, protocol2, null);
        findHttpRequestQualityData.updateHost("connectEnd", getHost(inetSocketAddress));
    }

    @Override // okhttp3.EventListener
    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, @Nullable Protocol protocol2, IOException iOException) {
        HttpRequestQualityData findHttpRequestQualityData = findHttpRequestQualityData(call);
        if (findHttpRequestQualityData == null) {
            return;
        }
        findHttpRequestQualityData.addEvent("connectFailed");
        findHttpRequestQualityData.onConnectEnd(true, inetSocketAddress, protocol2, iOException);
        findHttpRequestQualityData.updateHost("connectFailed", getHost(inetSocketAddress));
    }

    @Override // okhttp3.EventListener
    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        HttpRequestQualityData findHttpRequestQualityData = findHttpRequestQualityData(call);
        if (findHttpRequestQualityData == null) {
            return;
        }
        findHttpRequestQualityData.addEvent("connectStart");
        findHttpRequestQualityData.updateHost("connectStart", getHost(inetSocketAddress));
    }

    @Override // okhttp3.EventListener
    public void connectionAcquired(Call call, Connection connection) {
        HttpRequestQualityData findHttpRequestQualityData = findHttpRequestQualityData(call);
        if (findHttpRequestQualityData == null) {
            return;
        }
        findHttpRequestQualityData.addEvent("connectionAcquired");
        findHttpRequestQualityData.onConnectionAcquired(connection);
    }

    @Override // okhttp3.EventListener
    public void connectionReleased(Call call, Connection connection) {
        HttpRequestQualityData findHttpRequestQualityData = findHttpRequestQualityData(call);
        if (findHttpRequestQualityData == null) {
            return;
        }
        findHttpRequestQualityData.addEvent("connectionReleased");
    }

    @Override // okhttp3.EventListener
    public void dnsEnd(Call call, String str, List<InetAddress> list) {
        HttpRequestQualityData findHttpRequestQualityData = findHttpRequestQualityData(call);
        if (findHttpRequestQualityData == null) {
            return;
        }
        findHttpRequestQualityData.addEvent("dnsEnd");
        findHttpRequestQualityData.onDNSEnd(str);
    }

    @Override // okhttp3.EventListener
    public void dnsStart(Call call, String str) {
        HttpRequestQualityData findHttpRequestQualityData = findHttpRequestQualityData(call);
        if (findHttpRequestQualityData == null) {
            return;
        }
        findHttpRequestQualityData.addEvent("dnsStart");
        findHttpRequestQualityData.updateHost("dnsStart", str);
    }

    protected HttpRequestQualityData findHttpRequestQualityData(Call call) {
        if (call == null) {
            return null;
        }
        return this.qualityDataHashMap.get(call);
    }

    protected void forceCallEnd(Set<Call> set) {
        if (set != null && !set.isEmpty()) {
            Iterator<Call> it = set.iterator();
            while (it.hasNext()) {
                HttpRequestQualityData removeHttpRequestQualityData = removeHttpRequestQualityData(it.next());
                if (removeHttpRequestQualityData != null) {
                    removeHttpRequestQualityData.onCallEnd("forceCallEnd", null);
                    onCallFinished(removeHttpRequestQualityData);
                }
            }
        }
    }

    protected NetQualityPluginConfig getConfig() {
        NetQualityPluginConfig netQualityPluginConfig;
        HttpReportMetaCollector httpReportMetaCollector = this.metaCollector;
        if (httpReportMetaCollector != null) {
            netQualityPluginConfig = httpReportMetaCollector.getConfig();
        } else {
            netQualityPluginConfig = null;
        }
        if (netQualityPluginConfig == null) {
            return new NetQualityPluginConfig();
        }
        return netQualityPluginConfig;
    }

    protected boolean isCloseByUser(IOException iOException, int i3) {
        String message;
        if (i3 < 200 || i3 >= 300) {
            return false;
        }
        if (iOException == null) {
            message = "";
        } else {
            message = iOException.getMessage();
        }
        if (!"timeout".equals(message) && !"deadline reached".equals(message) && !TextUtils.isEmpty(message)) {
            return false;
        }
        return true;
    }

    protected boolean isMapEmpty() {
        return this.qualityDataHashMap.isEmpty();
    }

    protected HttpRequestQualityData obtainHttpRequestQualityData(Call call) {
        int i3;
        HttpRequestQualityData httpRequestQualityData = null;
        if (call == null) {
            return null;
        }
        if (this.isStart.get()) {
            try {
                NetQualityPluginConfig config = getConfig();
                if (config != null) {
                    i3 = config.cacheSize;
                } else {
                    i3 = 5000;
                }
                if (this.qualityDataHashMap.size() > i3) {
                    return null;
                }
                httpRequestQualityData = HttpRequestQualityData.obtain();
                this.qualityDataHashMap.put(call, httpRequestQualityData);
            } catch (Throwable unused) {
                return httpRequestQualityData;
            }
        }
        return httpRequestQualityData;
    }

    protected void onCallFinished(@NonNull HttpRequestQualityData httpRequestQualityData) {
        HttpReportMetaCollector httpReportMetaCollector = this.metaCollector;
        if (httpReportMetaCollector != null) {
            httpReportMetaCollector.collectMeta(httpRequestQualityData.toMeta());
        }
        if (Logger.verbos) {
            Logger.f365497g.v(TAG, "onCallFinished, data: " + httpRequestQualityData);
        }
    }

    protected HttpRequestQualityData removeHttpRequestQualityData(Call call) {
        if (call == null) {
            return null;
        }
        return this.qualityDataHashMap.remove(call);
    }

    @Override // okhttp3.EventListener
    public void requestBodyEnd(Call call, long j3) {
        HttpRequestQualityData findHttpRequestQualityData = findHttpRequestQualityData(call);
        if (findHttpRequestQualityData == null) {
            return;
        }
        findHttpRequestQualityData.addEvent("requestBodyEnd");
        findHttpRequestQualityData.onRequestBodyEnd(j3);
    }

    @Override // okhttp3.EventListener
    public void requestBodyStart(Call call) {
        HttpRequestQualityData findHttpRequestQualityData = findHttpRequestQualityData(call);
        if (findHttpRequestQualityData == null) {
            return;
        }
        findHttpRequestQualityData.addEvent("requestBodyStart");
    }

    @Override // okhttp3.EventListener
    public void requestHeadersEnd(Call call, Request request) {
        HttpRequestQualityData findHttpRequestQualityData = findHttpRequestQualityData(call);
        if (findHttpRequestQualityData == null) {
            return;
        }
        findHttpRequestQualityData.addEvent("requestHeadersEnd");
        findHttpRequestQualityData.updateRequest("requestHeadersEnd", request);
    }

    @Override // okhttp3.EventListener
    public void requestHeadersStart(Call call) {
        HttpRequestQualityData findHttpRequestQualityData = findHttpRequestQualityData(call);
        if (findHttpRequestQualityData == null) {
            return;
        }
        findHttpRequestQualityData.addEvent("requestHeadersStart");
    }

    @Override // okhttp3.EventListener
    public void responseBodyEnd(Call call, long j3) {
        HttpRequestQualityData findHttpRequestQualityData = findHttpRequestQualityData(call);
        if (findHttpRequestQualityData == null) {
            return;
        }
        findHttpRequestQualityData.addEvent("responseBodyEnd");
        findHttpRequestQualityData.onResponseBodyEnd(j3);
    }

    @Override // okhttp3.EventListener
    public void responseBodyStart(Call call) {
        HttpRequestQualityData findHttpRequestQualityData = findHttpRequestQualityData(call);
        if (findHttpRequestQualityData == null) {
            return;
        }
        findHttpRequestQualityData.addEvent("responseBodyStart");
    }

    @Override // okhttp3.EventListener
    public void responseHeadersEnd(Call call, Response response) {
        HttpRequestQualityData findHttpRequestQualityData = findHttpRequestQualityData(call);
        if (findHttpRequestQualityData == null) {
            return;
        }
        findHttpRequestQualityData.addEvent("responseHeadersEnd");
        findHttpRequestQualityData.onResponseHeadersEnd(response);
    }

    @Override // okhttp3.EventListener
    public void responseHeadersStart(Call call) {
        HttpRequestQualityData findHttpRequestQualityData = findHttpRequestQualityData(call);
        if (findHttpRequestQualityData == null) {
            return;
        }
        findHttpRequestQualityData.addEvent("responseHeadersStart");
        findHttpRequestQualityData.onResponseHeadersStart();
    }

    @Override // okhttp3.EventListener
    public void secureConnectEnd(Call call, @Nullable Handshake handshake) {
        HttpRequestQualityData findHttpRequestQualityData = findHttpRequestQualityData(call);
        if (findHttpRequestQualityData == null) {
            return;
        }
        findHttpRequestQualityData.addEvent("secureConnectEnd");
        findHttpRequestQualityData.onSecureConnectEnd();
    }

    @Override // okhttp3.EventListener
    public void secureConnectStart(Call call) {
        HttpRequestQualityData findHttpRequestQualityData = findHttpRequestQualityData(call);
        if (findHttpRequestQualityData == null) {
            return;
        }
        findHttpRequestQualityData.addEvent("secureConnectStart");
    }

    public void start() {
        this.isStart.compareAndSet(false, true);
    }

    public void stop() {
        if (this.isStart.compareAndSet(true, false)) {
            forceCallEnd(this.qualityDataHashMap.keySet());
            this.qualityDataHashMap.clear();
        }
    }
}
