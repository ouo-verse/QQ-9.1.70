package com.tencent.bugly.traffic.custom;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.bugly.common.network.NetworkWatcher;
import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.rmonitor.base.config.ConfigProxy;
import com.tencent.rmonitor.common.lifecycle.LifecycleCallback;
import com.tencent.rmonitor.common.lifecycle.a;
import com.tencent.rmonitor.common.logger.Logger;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.net.ssl.SSLException;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.Headers;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes5.dex */
public class Okhttp3EventListener extends EventListener {
    private static final String TAG = "Okhttp3EventListener";
    private static String endFlag;
    private boolean canMonitor;
    private EventListener listener;
    private static final ConcurrentHashMap<String, String> dnsMap = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<Call, SocketInfo> calls = new ConcurrentHashMap<>();

    public Okhttp3EventListener(EventListener eventListener) {
        this.canMonitor = false;
        this.listener = eventListener;
    }

    private void addToReportQueue(Call call) {
        if (this.canMonitor) {
            SocketInfo socketInfo = getSocketInfo(call, false);
            if (socketInfo != null) {
                fillSocketInfo(socketInfo);
                CustomTrafficStatistic.getInstance().addHttpToQueue(socketInfo);
            }
            calls.remove(call);
        }
    }

    private void fillSocketInfo(SocketInfo socketInfo) {
        socketInfo.threadId = Thread.currentThread().getId();
        socketInfo.endTimeStamp = System.currentTimeMillis();
        if (TextUtils.isEmpty(socketInfo.host) && TextUtils.isEmpty(socketInfo.url)) {
            try {
                String host = new URL(socketInfo.url).getHost();
                socketInfo.host = host;
                socketInfo.f98595ip = dnsMap.get(host);
            } catch (Throwable th5) {
                Logger.f365497g.w(TAG, "fill socket has failed, ", th5.getMessage());
            }
        }
    }

    private SocketInfo getSocketInfo(Call call, boolean z16) {
        ConcurrentHashMap<Call, SocketInfo> concurrentHashMap = calls;
        SocketInfo socketInfo = concurrentHashMap.get(call);
        if (socketInfo == null && z16) {
            SocketInfo socketInfo2 = new SocketInfo();
            concurrentHashMap.put(call, socketInfo2);
            return socketInfo2;
        }
        return socketInfo;
    }

    private boolean isSocketECONNRESET(Exception exc) {
        if (exc == null) {
            return false;
        }
        try {
            if (!(exc instanceof SocketException)) {
                return false;
            }
            if (!exc.getMessage().contains("recvfrom failed: ECONNRESET (Connection reset by peer)")) {
                return false;
            }
            return true;
        } catch (Exception e16) {
            Logger.f365497g.b(TAG, "isSocketECONNRESET error", e16);
            return false;
        }
    }

    private static void parseHeader(Headers headers, Map<String, String> map, SocketInfo socketInfo) {
        if (socketInfo != null) {
            if (socketInfo.requestHeaders.containsKey(android.net.http.Headers.CONTENT_ENCODING) && "gzip".equalsIgnoreCase(socketInfo.requestHeaders.get(android.net.http.Headers.CONTENT_ENCODING))) {
                socketInfo.gzip = true;
            }
            if (socketInfo.requestHeaders.containsKey(android.net.http.Headers.TRANSFER_ENCODING) && "chunked".equalsIgnoreCase(socketInfo.requestHeaders.get(android.net.http.Headers.TRANSFER_ENCODING))) {
                socketInfo.chunked = true;
            }
        }
    }

    private void setErrorCodeFromException(Exception exc, SocketInfo socketInfo) {
        if (exc instanceof IOException) {
            if (isSocketECONNRESET(exc)) {
                socketInfo.errorCode = HttpErrorUtils.CONNECTION_RESET_EXCEPTION;
                socketInfo.statusCode = HttpErrorUtils.CONNECTION_RESET_EXCEPTION;
                return;
            }
            String message = exc.getMessage();
            if (message != null && message.contains("ftruncate failed: ENOENT (No such file or directory)")) {
                socketInfo.errorCode = HttpErrorUtils.NO_FILE_OR_DIRECTORY;
                socketInfo.statusCode = HttpErrorUtils.NO_FILE_OR_DIRECTORY;
                return;
            }
        }
        if (exc instanceof UnknownHostException) {
            socketInfo.errorCode = 901;
            socketInfo.statusCode = 901;
            return;
        }
        if (exc instanceof SocketTimeoutException) {
            socketInfo.errorCode = 903;
            socketInfo.statusCode = 903;
            return;
        }
        if (exc instanceof ConnectException) {
            socketInfo.errorCode = 902;
            socketInfo.statusCode = 902;
        } else if (exc instanceof MalformedURLException) {
            socketInfo.errorCode = 900;
            socketInfo.statusCode = 900;
        } else if (exc instanceof SSLException) {
            socketInfo.errorCode = 908;
            socketInfo.statusCode = 908;
        } else {
            socketInfo.errorCode = -1;
            socketInfo.statusCode = -1;
        }
    }

    @Override // okhttp3.EventListener
    public void callEnd(@NotNull Call call) {
        SocketInfo socketInfo;
        super.callEnd(call);
        if (this.canMonitor && (socketInfo = getSocketInfo(call, false)) != null) {
            socketInfo.isEnd = true;
            socketInfo.hasSaved = true;
            addToReportQueue(call);
        }
        EventListener eventListener = this.listener;
        if (eventListener != null) {
            eventListener.callEnd(call);
        }
    }

    @Override // okhttp3.EventListener
    public void callFailed(@NotNull Call call, @NotNull IOException iOException) {
        SocketInfo socketInfo;
        super.callFailed(call, iOException);
        if (this.canMonitor && (socketInfo = getSocketInfo(call, false)) != null) {
            setErrorCodeFromException(iOException, socketInfo);
            addToReportQueue(call);
        }
        EventListener eventListener = this.listener;
        if (eventListener != null) {
            eventListener.callFailed(call, iOException);
        }
    }

    @Override // okhttp3.EventListener
    public void callStart(@NotNull Call call) {
        super.callStart(call);
        boolean z16 = ConfigProxy.INSTANCE.getConfig().i(BuglyMonitorName.TRAFFIC_DETAIL).com.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String.enabled;
        this.canMonitor = z16;
        if (z16) {
            try {
                SocketInfo socketInfo = getSocketInfo(call, true);
                NetworkWatcher networkWatcher = NetworkWatcher.INSTANCE;
                if (networkWatcher.isWifiAvailable()) {
                    socketInfo.networkType = 1;
                } else if (networkWatcher.isNetAvailable()) {
                    socketInfo.networkType = 2;
                } else {
                    socketInfo.networkType = 3;
                }
                if (LifecycleCallback.G.m()) {
                    socketInfo.frontState = 1;
                } else {
                    socketInfo.frontState = 2;
                }
                socketInfo.type = "custom";
                socketInfo.pageId = a.f();
                socketInfo.startTimeStamp = System.currentTimeMillis();
                socketInfo.method = call.request().method();
                socketInfo.url = call.request().url().getUrl();
                socketInfo.f98596protocol = call.request().url().url().getProtocol();
                socketInfo.ssl = call.request().isHttps();
            } catch (Throwable th5) {
                Logger.f365497g.w(TAG, "callStart failed, " + th5.getMessage());
            }
        }
        EventListener eventListener = this.listener;
        if (eventListener != null) {
            eventListener.callStart(call);
        }
    }

    @Override // okhttp3.EventListener
    public void connectEnd(@NotNull Call call, @NotNull InetSocketAddress inetSocketAddress, @NotNull Proxy proxy, @Nullable Protocol protocol2) {
        super.connectEnd(call, inetSocketAddress, proxy, protocol2);
        if (this.canMonitor) {
            boolean z16 = false;
            SocketInfo socketInfo = getSocketInfo(call, false);
            if (socketInfo != null) {
                socketInfo.connEnd = System.currentTimeMillis();
                if (proxy.address() != null) {
                    z16 = true;
                }
                socketInfo.isProxy = z16;
                try {
                    if (inetSocketAddress.getAddress() != null) {
                        socketInfo.port = inetSocketAddress.getPort();
                        socketInfo.f98595ip = inetSocketAddress.getAddress().getHostAddress();
                        String hostName = inetSocketAddress.getHostName();
                        socketInfo.host = hostName;
                        dnsMap.put(hostName, socketInfo.f98595ip);
                    }
                } catch (Throwable unused) {
                    Logger.f365497g.w(TAG, "get inetSocket info failed from connectEnd");
                }
            }
        }
        EventListener eventListener = this.listener;
        if (eventListener != null) {
            eventListener.connectEnd(call, inetSocketAddress, proxy, protocol2);
        }
    }

    @Override // okhttp3.EventListener
    public void connectFailed(@NotNull Call call, @NotNull InetSocketAddress inetSocketAddress, @NotNull Proxy proxy, @Nullable Protocol protocol2, @NotNull IOException iOException) {
        SocketInfo socketInfo;
        super.connectFailed(call, inetSocketAddress, proxy, protocol2, iOException);
        if (this.canMonitor && (socketInfo = getSocketInfo(call, false)) != null) {
            if (socketInfo.sslConnStart != 0 && socketInfo.sslConnEnd == 0) {
                socketInfo.sslConnEnd = System.currentTimeMillis();
            }
            if (socketInfo.connStart != 0 && socketInfo.connEnd == 0) {
                socketInfo.connEnd = System.currentTimeMillis();
            }
            try {
                if (inetSocketAddress.getAddress() != null) {
                    socketInfo.port = inetSocketAddress.getPort();
                    socketInfo.f98595ip = inetSocketAddress.getAddress().getHostAddress();
                    String hostName = inetSocketAddress.getHostName();
                    socketInfo.host = hostName;
                    dnsMap.put(hostName, socketInfo.f98595ip);
                }
            } catch (Throwable unused) {
                Logger.f365497g.w(TAG, "get inetSocket info failed from connectFailed");
            }
            setErrorCodeFromException(iOException, socketInfo);
            addToReportQueue(call);
        }
        EventListener eventListener = this.listener;
        if (eventListener != null) {
            eventListener.connectFailed(call, inetSocketAddress, proxy, protocol2, iOException);
        }
    }

    @Override // okhttp3.EventListener
    public void connectStart(@NotNull Call call, @NotNull InetSocketAddress inetSocketAddress, @NotNull Proxy proxy) {
        SocketInfo socketInfo;
        super.connectStart(call, inetSocketAddress, proxy);
        if (this.canMonitor && (socketInfo = getSocketInfo(call, false)) != null) {
            socketInfo.connStart = System.currentTimeMillis();
        }
        EventListener eventListener = this.listener;
        if (eventListener != null) {
            eventListener.connectStart(call, inetSocketAddress, proxy);
        }
    }

    @Override // okhttp3.EventListener
    public void connectionAcquired(@NotNull Call call, @NotNull Connection connection) {
        SocketInfo socketInfo;
        super.connectionAcquired(call, connection);
        if (this.canMonitor && (socketInfo = getSocketInfo(call, false)) != null) {
            if (socketInfo.dnsStart == 0) {
                socketInfo.isDnsCache = true;
            } else {
                socketInfo.isDnsCache = false;
            }
        }
        EventListener eventListener = this.listener;
        if (eventListener != null) {
            eventListener.connectionAcquired(call, connection);
        }
    }

    @Override // okhttp3.EventListener
    public void connectionReleased(@NotNull Call call, @NotNull Connection connection) {
        super.connectionReleased(call, connection);
        EventListener eventListener = this.listener;
        if (eventListener != null) {
            eventListener.connectionReleased(call, connection);
        }
    }

    @Override // okhttp3.EventListener
    public void dnsEnd(@NotNull Call call, @NotNull String str, @NotNull List<InetAddress> list) {
        SocketInfo socketInfo;
        super.dnsEnd(call, str, list);
        if (this.canMonitor && (socketInfo = getSocketInfo(call, false)) != null) {
            socketInfo.dnsEnd = System.currentTimeMillis();
        }
        EventListener eventListener = this.listener;
        if (eventListener != null) {
            eventListener.dnsEnd(call, str, list);
        }
    }

    @Override // okhttp3.EventListener
    public void dnsStart(@NotNull Call call, @NotNull String str) {
        SocketInfo socketInfo;
        super.dnsStart(call, str);
        if (this.canMonitor && (socketInfo = getSocketInfo(call, false)) != null) {
            socketInfo.dnsStart = System.currentTimeMillis();
        }
        EventListener eventListener = this.listener;
        if (eventListener != null) {
            eventListener.dnsStart(call, str);
        }
    }

    @Override // okhttp3.EventListener
    public void requestBodyEnd(@NotNull Call call, long j3) {
        SocketInfo socketInfo;
        super.requestBodyEnd(call, j3);
        if (this.canMonitor && (socketInfo = getSocketInfo(call, false)) != null) {
            socketInfo.reqEnd = System.currentTimeMillis();
            socketInfo.sendBytes += j3;
        }
        EventListener eventListener = this.listener;
        if (eventListener != null) {
            eventListener.requestBodyEnd(call, j3);
        }
    }

    @Override // okhttp3.EventListener
    public void requestBodyStart(@NotNull Call call) {
        SocketInfo socketInfo;
        super.requestBodyStart(call);
        if (this.canMonitor && (socketInfo = getSocketInfo(call, false)) != null && socketInfo.reqStart == 0) {
            socketInfo.reqStart = System.currentTimeMillis();
        }
        EventListener eventListener = this.listener;
        if (eventListener != null) {
            eventListener.requestBodyStart(call);
        }
    }

    @Override // okhttp3.EventListener
    public void requestHeadersEnd(@NotNull Call call, @NotNull Request request) {
        SocketInfo socketInfo;
        super.requestHeadersEnd(call, request);
        EventListener eventListener = this.listener;
        if (eventListener != null) {
            eventListener.requestHeadersEnd(call, request);
        }
        if (this.canMonitor && (socketInfo = getSocketInfo(call, false)) != null) {
            socketInfo.reqEnd = System.currentTimeMillis();
            String header = request.header("User-Agent");
            String str = endFlag;
            if (str == null || header == null || header.contains(str)) {
                try {
                    socketInfo.sendBytes += request.headers().byteCount();
                    socketInfo.url = request.url().getUrl();
                    parseHeader(request.headers(), socketInfo.requestHeaders, socketInfo);
                } catch (Exception e16) {
                    Logger.f365497g.w(TAG, "parse header failed, " + e16);
                }
            }
        }
    }

    @Override // okhttp3.EventListener
    public void requestHeadersStart(@NotNull Call call) {
        SocketInfo socketInfo;
        super.requestHeadersStart(call);
        if (this.canMonitor && (socketInfo = getSocketInfo(call, false)) != null) {
            socketInfo.reqStart = System.currentTimeMillis();
        }
        EventListener eventListener = this.listener;
        if (eventListener != null) {
            eventListener.requestHeadersStart(call);
        }
    }

    @Override // okhttp3.EventListener
    public void responseBodyEnd(@NotNull Call call, long j3) {
        SocketInfo socketInfo;
        super.responseBodyEnd(call, j3);
        if (this.canMonitor && (socketInfo = getSocketInfo(call, false)) != null) {
            socketInfo.receivedBytes += j3;
            socketInfo.respEnd = System.currentTimeMillis();
        }
        EventListener eventListener = this.listener;
        if (eventListener != null) {
            eventListener.responseBodyEnd(call, j3);
        }
    }

    @Override // okhttp3.EventListener
    public void responseBodyStart(@NotNull Call call) {
        super.responseBodyStart(call);
        EventListener eventListener = this.listener;
        if (eventListener != null) {
            eventListener.responseBodyStart(call);
        }
    }

    @Override // okhttp3.EventListener
    public void responseHeadersEnd(@NotNull Call call, @NotNull Response response) {
        super.responseHeadersEnd(call, response);
        if (this.canMonitor) {
            try {
                SocketInfo socketInfo = getSocketInfo(call, false);
                if (socketInfo != null) {
                    socketInfo.statusCode = response.code();
                    socketInfo.receivedBytes += response.headers().byteCount();
                    parseHeader(response.headers(), socketInfo.responseHeaders, null);
                }
            } catch (Exception e16) {
                Logger.f365497g.w(TAG, "responseHeadersEnd may be failed, " + e16);
            }
        }
        EventListener eventListener = this.listener;
        if (eventListener != null) {
            eventListener.responseHeadersEnd(call, response);
        }
    }

    @Override // okhttp3.EventListener
    public void responseHeadersStart(@NotNull Call call) {
        SocketInfo socketInfo;
        super.responseHeadersStart(call);
        if (this.canMonitor && (socketInfo = getSocketInfo(call, false)) != null) {
            long currentTimeMillis = System.currentTimeMillis();
            socketInfo.respStart = currentTimeMillis;
            socketInfo.firstPacketPeriod = currentTimeMillis - socketInfo.reqEnd;
        }
        EventListener eventListener = this.listener;
        if (eventListener != null) {
            eventListener.responseHeadersStart(call);
        }
    }

    @Override // okhttp3.EventListener
    public void secureConnectEnd(@NotNull Call call, @Nullable Handshake handshake) {
        SocketInfo socketInfo;
        super.secureConnectEnd(call, handshake);
        if (this.canMonitor && (socketInfo = getSocketInfo(call, false)) != null) {
            socketInfo.sslConnEnd = System.currentTimeMillis();
        }
        EventListener eventListener = this.listener;
        if (eventListener != null) {
            eventListener.secureConnectEnd(call, handshake);
        }
    }

    @Override // okhttp3.EventListener
    public void secureConnectStart(@NotNull Call call) {
        SocketInfo socketInfo;
        super.secureConnectStart(call);
        if (this.canMonitor && (socketInfo = getSocketInfo(call, false)) != null) {
            socketInfo.sslConnStart = System.currentTimeMillis();
        }
        EventListener eventListener = this.listener;
        if (eventListener != null) {
            eventListener.secureConnectStart(call);
        }
    }

    public Okhttp3EventListener() {
        this.listener = null;
        this.canMonitor = false;
    }
}
