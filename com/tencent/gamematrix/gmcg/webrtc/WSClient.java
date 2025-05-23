package com.tencent.gamematrix.gmcg.webrtc;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.gamematrix.gmcg.base.delaycount.GmCgDelayCounter;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmcg.webrtc.ConnectionClient;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.enums.ReadyState;
import org.java_websocket.exceptions.WebsocketNotConnectedException;
import org.java_websocket.handshake.ServerHandshake;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.tencwebrtc.VideoSR;

/* compiled from: P */
/* loaded from: classes6.dex */
public class WSClient implements ConnectionClient {
    public static final int CMD_CG_GAMEINFO = 110302;
    private static final int CMD_CG_PERFDATA = 100200;
    private static final int CMD_CG_SDKINFO = 100202;
    private static final int CMD_CG_SENSORINFO = 110303;
    private static final int CMD_CG_SUPERRESOLUTION = 171700;
    private static final int CMD_CLIENT_CONFIG = 100011;
    private static final int CMD_CLIENT_COUNT = 100012;
    private static final int CMD_CLIENT_KICK = 100014;
    private static final int CMD_ENABLE_SR_DOWNSCALE = 51020803;
    private static final int CMD_ERROR = 1;
    private static final int CMD_NETWORK_CARRIER = 100008;
    private static final int CMD_SERVER_CONFIG = 100032;
    private static final int CMD_SESSION_CLOSE = 100018;
    private static final int CMD_SESSION_ID = 150101;
    private static final int CMD_SESSION_INFO = 199901;
    private static final int CMD_USER_CONFIG = 100010;
    private static final int CMD_WEBRTC_ANSWER = 100001;
    private static final int CMD_WEBRTC_ICE = 100002;
    private static final int CMD_WEBRTC_OFFER = 100000;
    public static boolean HASCONNECTED = false;
    private static final int MAX_RECONNECT_GATE_TIMES = 5;
    private static final String TAG = "WSClient";
    private static String mGuid;
    private static String mServerConfigStr;
    private int mCurReconnectTimes;
    private String mDeviceId;
    private boolean mEnableKeepSession;
    private String mGameId;
    private Map<String, String> mHttpHeaders;
    private String mInstanceId;
    private ConnectionClient.SignalEvent mNotifier;
    private WebRTCSDK.PerfMonitorConfig mPerfConfig;
    private String mProxyIp;
    private int mProxyPort;
    private WebRTCSDK.SensorConfig mSensorConfig;
    TrustManager[] mTrustAllCerts;
    private String mUri;
    private String mUriKeepSession;
    private WebSocketClient mWebSocketClient;
    private WebRTCEvents mWebrtcEventObserver;
    private String sessionId;
    private URI wsUri;
    private volatile boolean mConnected = false;
    private boolean mStopped = false;
    private long appCpuTime = -1;
    SSLContext mSslContext = null;
    SSLSocketFactory mSocketFactory = null;
    private final String MSG_FIELD_CMD = "cmd";
    private final String MSG_FIELD_FROM = "from";
    private final String MSG_FIELD_TO = "to";
    private final String MSG_FIELD_ID = "id";
    private final String MSG_FIELD_TS = "ts";
    private final String MSG_FIELD_SESSIONID = "sessionId";
    private final String MSG_FIELD_RETRYCOUNT = "retryCount";
    private final String MSG_FIELD_BODY = "body";
    private final String mEncoderPropert = "property";
    private Handler mHandler = null;
    private ExecutorService mExecutorService = null;
    private Runnable mConnectRunnable = null;
    private HashMap<String, HashMap<Integer, String>> uuidMap = new HashMap<>();
    private HashMap<String, HashMap<Integer, Integer>> retryCountMap = new HashMap<>();

    public WSClient(ConnectionClient.SignalEvent signalEvent, WebRTCEvents webRTCEvents, WebRTCSDK.SensorConfig sensorConfig, WebRTCSDK.PerfMonitorConfig perfMonitorConfig, String str, boolean z16, Map<String, String> map) {
        this.mEnableKeepSession = false;
        this.mNotifier = signalEvent;
        this.mWebrtcEventObserver = webRTCEvents;
        this.mSensorConfig = sensorConfig;
        this.mPerfConfig = perfMonitorConfig;
        this.mDeviceId = str;
        String[] split = str.split("-");
        this.mInstanceId = split[1];
        this.mGameId = split[0];
        this.mEnableKeepSession = z16;
        new HashMap();
        this.mHttpHeaders = map;
    }

    private void connectIp() {
        if (this.mHandler == null) {
            this.mHandler = new Handler(Looper.getMainLooper());
        }
        if (this.mExecutorService == null) {
            this.mExecutorService = ProxyExecutors.newFixedThreadPool(1);
        }
        this.mExecutorService.execute(new Runnable() { // from class: com.tencent.gamematrix.gmcg.webrtc.f
            @Override // java.lang.Runnable
            public final void run() {
                WSClient.this.lambda$connectIp$1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: connectWebRtc, reason: merged with bridge method [inline-methods] */
    public void lambda$null$0() {
        WebSocketClient webSocketClient = this.mWebSocketClient;
        if (webSocketClient != null && !webSocketClient.isOpen()) {
            try {
                if (this.mWebSocketClient.getReadyState().equals(ReadyState.NOT_YET_CONNECTED)) {
                    this.mWebSocketClient.connect();
                } else if (this.mWebSocketClient.getReadyState().equals(ReadyState.CLOSING) || this.mWebSocketClient.getReadyState().equals(ReadyState.CLOSED)) {
                    this.mWebSocketClient.reconnect();
                }
            } catch (Exception unused) {
            }
        }
    }

    private int getRetryCount(int i3) {
        Integer num = new Integer(i3);
        if (this.retryCountMap.containsKey(this.sessionId)) {
            HashMap<Integer, Integer> hashMap = this.retryCountMap.get(this.sessionId);
            if (hashMap.containsKey(num)) {
                int intValue = hashMap.get(num).intValue();
                hashMap.put(num, Integer.valueOf(intValue + 1));
                this.retryCountMap.put(this.sessionId, hashMap);
                return intValue;
            }
            hashMap.put(num, 1);
            this.retryCountMap.put(this.sessionId, hashMap);
            return 0;
        }
        HashMap<Integer, Integer> hashMap2 = new HashMap<>();
        hashMap2.put(num, 1);
        this.retryCountMap.put(this.sessionId, hashMap2);
        return 0;
    }

    private String getUuid(String str, int i3) {
        Integer num = new Integer(i3);
        if (this.uuidMap.containsKey(str)) {
            HashMap<Integer, String> hashMap = this.uuidMap.get(str);
            if (hashMap.containsKey(num)) {
                return hashMap.get(num).toString();
            }
            String replaceAll = UUID.randomUUID().toString().replaceAll("-", "");
            hashMap.put(num, replaceAll);
            this.uuidMap.put(str, hashMap);
            return replaceAll;
        }
        HashMap<Integer, String> hashMap2 = new HashMap<>();
        String replaceAll2 = UUID.randomUUID().toString().replaceAll("-", "");
        hashMap2.put(num, replaceAll2);
        this.uuidMap.put(str, hashMap2);
        return replaceAll2;
    }

    private boolean isIpPorxyConnection(String str) {
        char charAt;
        if (TextUtils.isEmpty(this.mProxyIp) || this.mProxyPort <= 0 || TextUtils.isEmpty(str) || !str.startsWith("wss://") || str.length() <= 6 || (charAt = str.charAt(6)) < '0' || charAt > '9') {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$connectIp$1() {
        try {
            this.mWebSocketClient.setProxy(new Proxy(Proxy.Type.SOCKS, new InetSocketAddress(InetAddress.getByName("gmve-goc-cucc-tj.gamematrix.qq.com"), 1)));
        } catch (UnknownHostException e16) {
            e16.printStackTrace();
        }
        if (this.mConnectRunnable == null) {
            this.mConnectRunnable = new Runnable() { // from class: com.tencent.gamematrix.gmcg.webrtc.e
                @Override // java.lang.Runnable
                public final void run() {
                    WSClient.this.lambda$null$0();
                }
            };
        }
        this.mHandler.post(this.mConnectRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onChannelAck(String str) {
        ConnectionClient.SignalEvent signalEvent;
        CGLog.i("receive channel ack: " + str + " ,mStopped:" + this.mStopped);
        if (!this.mStopped && (signalEvent = this.mNotifier) != null) {
            signalEvent.onChannelAck(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onChannelData(String str) {
        ConnectionClient.SignalEvent signalEvent;
        CGLog.i("receive channel data: " + str + " ,mStopped:" + this.mStopped);
        if (!this.mStopped && (signalEvent = this.mNotifier) != null) {
            signalEvent.onChannelData(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClientConfig(Object... objArr) {
        CGLog.i("receive client config: " + objArr[0] + " ,mStopped:" + this.mStopped);
        if (!this.mStopped && this.mNotifier != null) {
            try {
                this.mNotifier.onClientConfigReceived(new JSONObject(objArr[0].toString()));
            } catch (JSONException e16) {
                CGLog.w(e16.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClientCount(Object... objArr) {
        CGLog.i("receive client count: " + objArr[0] + " ,mStopped:" + this.mStopped);
        if (!this.mStopped && this.mNotifier != null) {
            try {
                this.mNotifier.onClientCountReceived(new JSONObject(objArr[0].toString()).getInt("count"));
            } catch (JSONException e16) {
                CGLog.w(e16.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onConnect(Object... objArr) {
        ConnectionClient.SignalEvent signalEvent;
        CGLog.i("Signal server is connected ,mStopped:" + this.mStopped);
        this.mCurReconnectTimes = 0;
        CGLog.i("\u8fde\u63a5\u6210\u529f, mCurReconnectTimes = 0");
        if (!this.mStopped && (signalEvent = this.mNotifier) != null) {
            signalEvent.onConnected(true);
        }
        if (VideoSR.isInited()) {
            sendEnableSrCmd(true);
        } else {
            sendEnableSrCmd(false);
        }
        sendServerConfig();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDisconnect(Object... objArr) {
        ConnectionClient.SignalEvent signalEvent;
        CGLog.i("Signal server is disconnected ,mStopped:" + this.mStopped);
        if (!this.mStopped && (signalEvent = this.mNotifier) != null) {
            signalEvent.onConnected(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onNetworkCarrier(Object... objArr) {
        ConnectionClient.SignalEvent signalEvent;
        CGLog.i("receive webrtcproxy ip carrier " + objArr[0] + " ,mStopped:" + this.mStopped);
        if (!this.mStopped && (signalEvent = this.mNotifier) != null) {
            signalEvent.onNetworkCarrier(objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSensorConfig(Object... objArr) {
        CGLog.i("receive sensor config" + objArr[0]);
        try {
            JSONObject jSONObject = new JSONObject(objArr[0].toString());
            JSONObject jSONObject2 = new JSONObject(jSONObject.getString("sensors"));
            WebRTCSDK.SensorConfig sensorConfig = this.mSensorConfig;
            if (sensorConfig != null) {
                sensorConfig.onSensorConfig(jSONObject2);
            }
            int i3 = jSONObject.getInt("monitorInterval");
            WebRTCSDK.PerfMonitorConfig perfMonitorConfig = this.mPerfConfig;
            if (perfMonitorConfig != null) {
                perfMonitorConfig.onPerfMonitorConfig(i3);
            }
        } catch (JSONException e16) {
            CGLog.w(e16.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSessionConnClose(Object... objArr) {
        CGLog.i("receive sioconn close: " + objArr[0] + " ,mStopped:" + this.mStopped);
        if (!this.mStopped && this.mNotifier != null) {
            try {
                this.mNotifier.onSessionConnClose(new JSONObject(objArr[0].toString()).getInt("exitCode"));
            } catch (JSONException e16) {
                CGLog.w(e16.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSessionError(Object... objArr) {
        CGLog.i("receive session error: " + objArr[0] + " ,mStopped:" + this.mStopped);
        if (!this.mStopped && this.mNotifier != null) {
            try {
                this.mNotifier.onSessionConnClose(new JSONObject(objArr[0].toString()).getInt("code"));
            } catch (JSONException e16) {
                CGLog.w(e16.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSessionId(Object... objArr) {
        CGLog.i("receive session id: " + objArr[0] + " ,mStopped:" + this.mStopped);
        WebRTCEvents webRTCEvents = this.mWebrtcEventObserver;
        if (webRTCEvents != null) {
            webRTCEvents.onWebrtcStartUpProcess(GmCgDelayCounter.CGDelayLifeCycle.CGWebrtcSubProcessLifeCycle.SUB_PROCESS_GATE_LINK, false);
            this.mWebrtcEventObserver.onWebrtcStartUpProcess(GmCgDelayCounter.CGDelayLifeCycle.CGWebrtcSubProcessLifeCycle.SUB_PROCESS_ICE, true);
        }
        if (!this.mStopped && this.mNotifier != null) {
            try {
                String string = new JSONObject(objArr[0].toString()).getString("sessionId");
                this.sessionId = string;
                this.mNotifier.onSessionIdReceived(string);
            } catch (JSONException e16) {
                CGLog.w(e16.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onWebRTCAnswer(Object... objArr) {
        CGLog.i("receive webrtc answer: " + objArr[0] + " ,mStopped:" + this.mStopped);
        if (!this.mStopped && this.mNotifier != null) {
            try {
                this.mNotifier.onAnswerReceived(new JSONObject(objArr[0].toString()));
            } catch (JSONException e16) {
                CGLog.w(e16.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onWebRTCIceCandidate(Object... objArr) {
        CGLog.i("receive webrtc ice candidate: " + objArr[0] + " ,mStopped:" + this.mStopped);
        if (!this.mStopped && this.mNotifier != null) {
            try {
                this.mNotifier.onIceCandidateReceived(new JSONObject(objArr[0].toString()));
            } catch (JSONException e16) {
                CGLog.e("onWebRTCIceCandidate error: " + e16);
            }
        }
    }

    private void sendServerConfig() {
        if (this.mWebSocketClient != null && this.mConnected) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("property", mServerConfigStr);
                JSONObject jSONObject2 = new JSONObject();
                generateMsgHeader(CMD_SERVER_CONFIG, jSONObject2);
                jSONObject2.put("body", jSONObject);
                try {
                    this.mWebSocketClient.send(jSONObject2.toString());
                    CGLog.i("sendServerConfig " + jSONObject2.toString());
                } catch (WebsocketNotConnectedException e16) {
                    CGLog.e("sendServerConfig when signal server not connected " + e16);
                }
                return;
            } catch (Exception e17) {
                CGLog.e("sendServerConfig " + e17);
                return;
            }
        }
        CGLog.w("Signal server is NOT connected");
    }

    public static void setServerConfig(String str) {
        CGLog.i("setServerConfig " + str);
        mServerConfigStr = str;
    }

    public static void setmGuid(String str) {
        mGuid = str;
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.ConnectionClient
    public void close() {
        Handler handler;
        this.mStopped = true;
        WebSocketClient webSocketClient = this.mWebSocketClient;
        if (webSocketClient != null) {
            webSocketClient.close();
        }
        this.mConnected = false;
        HASCONNECTED = false;
        Runnable runnable = this.mConnectRunnable;
        if (runnable != null && (handler = this.mHandler) != null) {
            handler.removeCallbacks(runnable);
        }
        this.mHandler = null;
        this.mConnectRunnable = null;
        ExecutorService executorService = this.mExecutorService;
        if (executorService != null) {
            executorService.shutdown();
            this.mExecutorService = null;
        }
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.ConnectionClient
    public void connect(String str) {
        this.mStopped = false;
        long currentTimeMillis = System.currentTimeMillis();
        CGLog.i("curTime:" + currentTimeMillis);
        String str2 = str + "&timestamp=" + currentTimeMillis + "&guid=" + mGuid;
        CGLog.i("WSClient connect to " + str2);
        HASCONNECTED = true;
        try {
            this.wsUri = new URI(str2);
            if (this.mUri == null) {
                this.mUri = str2;
                this.mUriKeepSession = this.mUri + "&keepsession=true";
            }
        } catch (URISyntaxException e16) {
            e16.printStackTrace();
        }
        this.mWebSocketClient = new WebSocketClient(this.wsUri, this.mHttpHeaders) { // from class: com.tencent.gamematrix.gmcg.webrtc.WSClient.1
            @Override // org.java_websocket.client.WebSocketClient
            public void onClose(int i3, String str3, boolean z16) {
                String str4;
                CGLog.i("onClose, err code:" + i3 + ", err string:" + str3 + ", isRemote:" + z16 + ", mStopped:" + WSClient.this.mStopped + ", ws state: " + WebRTCClient.f108096cs);
                WSClient.this.mConnected = false;
                WSClient.HASCONNECTED = false;
                if (i3 == 1000) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("onClose, NORMAL,");
                    if (z16) {
                        str4 = "remote";
                    } else {
                        str4 = "local";
                    }
                    sb5.append(str4);
                    sb5.append(" closed the connection");
                    CGLog.i(sb5.toString());
                    if (z16 && WSClient.this.mWebrtcEventObserver != null && !WSClient.this.mStopped) {
                        WSClient.this.mWebrtcEventObserver.onEventSocketIoError("Remote closed the connection because of timeout");
                        return;
                    }
                    return;
                }
                if (WSClient.this.mEnableKeepSession) {
                    if (!WSClient.this.mStopped && WSClient.this.mCurReconnectTimes < 5) {
                        WSClient.this.mCurReconnectTimes++;
                        CGLog.i("\u8fde\u63a5\u65ad\u5f00, \u91cd\u8fde mCurReconnectTimes: " + WSClient.this.mCurReconnectTimes);
                        try {
                            final BaseTimer baseTimer = new BaseTimer();
                            baseTimer.schedule(new TimerTask() { // from class: com.tencent.gamematrix.gmcg.webrtc.WSClient.1.1
                                @Override // java.util.TimerTask, java.lang.Runnable
                                public void run() {
                                    WSClient.this.reconnectGate();
                                    baseTimer.cancel();
                                }
                            }, 1000L);
                        } catch (Throwable th5) {
                            CGLog.e("failed to reconnect gate" + th5.toString());
                        }
                    } else {
                        CGLog.i("\u5df2\u91cd\u8bd5\u6700\u5927\u6b21\u6570: 5, mCurReconnectTimes = 0");
                        WSClient.this.mWebrtcEventObserver.onEventSocketIoError("the maximum number of retries has been made and socket failed: 5");
                        WSClient.this.mCurReconnectTimes = 0;
                    }
                } else if (i3 == 1006 && WSClient.this.mWebrtcEventObserver != null && !WSClient.this.mStopped) {
                    WSClient.this.mWebrtcEventObserver.onEventSocketIoError(str3);
                }
                if (!WSClient.this.mStopped) {
                    WSClient.this.onDisconnect(new Object[0]);
                }
            }

            @Override // org.java_websocket.client.WebSocketClient
            public void onError(Exception exc) {
                CGLog.i("onError, " + exc);
            }

            @Override // org.java_websocket.client.WebSocketClient
            public void onMessage(String str3) {
                CGLog.i("onMessage: " + str3 + "mStopped:" + WSClient.this.mStopped);
                if (WSClient.this.mStopped) {
                    return;
                }
                for (String str4 : str3.split("\n")) {
                    try {
                        JSONObject jSONObject = new JSONObject(str4);
                        int i3 = jSONObject.getInt("cmd");
                        String string = jSONObject.getString("body");
                        switch (i3) {
                            case 1:
                                WSClient.this.onSessionError(string);
                                continue;
                            case 100001:
                                WSClient.this.onWebRTCAnswer(string);
                                continue;
                            case 100002:
                                WSClient.this.onWebRTCIceCandidate(string);
                                continue;
                            case 100008:
                                WSClient.this.onNetworkCarrier(string);
                                continue;
                            case 100011:
                                WSClient.this.onClientConfig(string);
                                continue;
                            case 100012:
                                WSClient.this.onClientCount(string);
                                continue;
                            case 100018:
                                WSClient.this.onSessionConnClose(string);
                                continue;
                            case WSClient.CMD_CG_GAMEINFO /* 110302 */:
                                try {
                                    JSONObject jSONObject2 = new JSONObject(string);
                                    String string2 = jSONObject2.getString("type");
                                    String string3 = jSONObject2.getString("data");
                                    if (string2.equals("channel-data")) {
                                        WSClient.this.onChannelData(string3);
                                        continue;
                                    } else if (string2.equals("channel-ack")) {
                                        WSClient.this.onChannelAck(string3);
                                        break;
                                    } else {
                                        break;
                                    }
                                } catch (JSONException e17) {
                                    CGLog.w(e17.toString());
                                    break;
                                }
                            case WSClient.CMD_CG_SENSORINFO /* 110303 */:
                                WSClient.this.onSensorConfig(string);
                                continue;
                            case WSClient.CMD_SESSION_ID /* 150101 */:
                                WSClient.this.onSessionId(string);
                                continue;
                            case WSClient.CMD_SESSION_INFO /* 199901 */:
                                WSClient.this.onSessionInfo(string);
                                continue;
                            default:
                                CGLog.e("Received an undefined command" + i3);
                                continue;
                        }
                    } catch (JSONException e18) {
                        CGLog.w(e18.toString());
                    }
                    CGLog.w(e18.toString());
                }
            }

            @Override // org.java_websocket.client.WebSocketClient
            public void onOpen(ServerHandshake serverHandshake) {
                WSClient.this.mConnected = true;
                CGLog.i("onOpen " + serverHandshake.getHttpStatusMessage());
                WSClient.this.onConnect(new Object[0]);
            }
        };
        this.mTrustAllCerts = new TrustManager[]{new X509TrustManager() { // from class: com.tencent.gamematrix.gmcg.webrtc.WSClient.2
            @Override // javax.net.ssl.X509TrustManager
            public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str3) throws CertificateException {
                CGLog.i("checkClientTrusted");
            }

            @Override // javax.net.ssl.X509TrustManager
            public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str3) throws CertificateException {
                CGLog.i("checkServerTrusted");
            }

            @Override // javax.net.ssl.X509TrustManager
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        }};
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            this.mSslContext = sSLContext;
            sSLContext.init(null, this.mTrustAllCerts, new SecureRandom());
            SSLSocketFactory socketFactory = this.mSslContext.getSocketFactory();
            this.mSocketFactory = socketFactory;
            this.mWebSocketClient.setSocketFactory(socketFactory);
            if (isIpPorxyConnection(str2)) {
                CGLog.i("Need to use Ip Connection");
                connectIp();
            } else {
                lambda$null$0();
            }
        } catch (KeyManagementException e17) {
            e17.printStackTrace();
        } catch (NoSuchAlgorithmException e18) {
            e18.printStackTrace();
        } catch (Throwable th5) {
            CGLog.i("webSocket connect failed: " + th5.toString());
        }
    }

    public void generateMsgHeader(int i3, JSONObject jSONObject) {
        try {
            jSONObject.put("cmd", i3);
            jSONObject.put("from", "sdk");
            jSONObject.put("to", "");
            jSONObject.put("id", UUID.randomUUID().toString().replaceAll("-", ""));
            jSONObject.put("ts", String.valueOf(System.nanoTime()));
            jSONObject.put("sessionId", this.sessionId);
            jSONObject.put("retryCount", getRetryCount(i3));
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    public void onSessionInfo(String str) {
        ConnectionClient.SignalEvent signalEvent;
        CGLog.i("receive onSessionInfo: " + str + " ,mStopped:" + this.mStopped);
        if (!this.mStopped && (signalEvent = this.mNotifier) != null) {
            signalEvent.onSessionInfo(str);
        }
    }

    public void reconnectGate() {
        ConnectionClient.SignalEvent signalEvent;
        CGLog.i("WSClient reconnect. ,mStopped:" + this.mStopped);
        if (!this.mStopped && (signalEvent = this.mNotifier) != null) {
            signalEvent.onGateReconnect();
            WebSocketClient webSocketClient = this.mWebSocketClient;
            if (webSocketClient != null) {
                webSocketClient.close();
            }
            connect(this.mUriKeepSession);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.ConnectionClient
    public void sendChannelAck(String str) {
        CGLog.i("Send channel ack" + str);
        if (this.mWebSocketClient != null && this.mConnected) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("type", "channel-ack");
                jSONObject.put("data", str);
                JSONObject jSONObject2 = new JSONObject();
                generateMsgHeader(CMD_CG_GAMEINFO, jSONObject2);
                jSONObject2.put("body", jSONObject);
                try {
                    this.mWebSocketClient.send(jSONObject2.toString());
                } catch (WebsocketNotConnectedException unused) {
                    CGLog.e("Signal server not connected");
                }
                CGLog.i("send channel ack: " + jSONObject.toString(2));
                return;
            } catch (JSONException e16) {
                e16.printStackTrace();
                return;
            }
        }
        CGLog.w("Signal server is NOT connected");
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.ConnectionClient
    public void sendChannelData(String str) {
        CGLog.i("Send channel data" + str);
        if (this.mWebSocketClient != null && this.mConnected) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("type", "channel-data");
                jSONObject.put("data", str);
                JSONObject jSONObject2 = new JSONObject();
                generateMsgHeader(CMD_CG_GAMEINFO, jSONObject2);
                jSONObject2.put("body", jSONObject);
                try {
                    this.mWebSocketClient.send(jSONObject2.toString());
                } catch (WebsocketNotConnectedException unused) {
                    CGLog.e("Signal server not connected");
                }
                CGLog.i("send channel data: " + jSONObject.toString());
                return;
            } catch (JSONException e16) {
                e16.printStackTrace();
                return;
            }
        }
        CGLog.w("Signal server is NOT connected");
    }

    public void sendEnableSrCmd(boolean z16) {
        if (this.mWebSocketClient != null && this.mConnected) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("enableSR", z16);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("cmd", CMD_CG_SUPERRESOLUTION);
                jSONObject2.put("data", jSONObject);
                JSONObject jSONObject3 = new JSONObject();
                generateMsgHeader(CMD_ENABLE_SR_DOWNSCALE, jSONObject3);
                jSONObject3.put("body", jSONObject2);
                CGLog.i("Send enable sr cmd: " + jSONObject3);
                try {
                    this.mWebSocketClient.send(jSONObject3.toString());
                } catch (WebsocketNotConnectedException unused) {
                    CGLog.e("Sending enable sr cmd when signal server not connected");
                }
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.ConnectionClient
    public void sendIceCandidate(String str, String str2, int i3) {
        if (this.mWebSocketClient != null && this.mConnected) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("candidate", str);
                jSONObject.put("sdpMid", str2);
                jSONObject.put("sdpMLineIndex", i3);
                JSONObject jSONObject2 = new JSONObject();
                generateMsgHeader(100002, jSONObject2);
                jSONObject2.put("body", jSONObject);
                try {
                    this.mWebSocketClient.send(jSONObject2.toString().replace("\\\\", ""));
                } catch (WebsocketNotConnectedException unused) {
                    CGLog.e("Signal server not connected");
                }
                CGLog.i("send ice candidate: " + jSONObject.toString(2));
                return;
            } catch (JSONException e16) {
                e16.printStackTrace();
                return;
            }
        }
        CGLog.w("Signal server is NOT connected");
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.ConnectionClient
    public void sendKickMyself() {
        if (this.mWebSocketClient != null && this.mConnected) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                generateMsgHeader(100014, jSONObject2);
                jSONObject2.put("body", jSONObject);
                try {
                    this.mWebSocketClient.send(jSONObject2.toString());
                } catch (WebsocketNotConnectedException unused) {
                    CGLog.e("Signal server not connected");
                }
                CGLog.i("Send kick myself");
                return;
            } catch (JSONException e16) {
                e16.printStackTrace();
                return;
            }
        }
        CGLog.w("Signal server is NOT connected");
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.ConnectionClient
    public void sendKickUser(String[] strArr) {
        if (this.mWebSocketClient != null && this.mConnected) {
            try {
                JSONArray jSONArray = new JSONArray();
                for (String str : strArr) {
                    jSONArray.mo162put(str);
                }
                JSONObject jSONObject = new JSONObject();
                generateMsgHeader(100014, jSONObject);
                jSONObject.put("body", jSONArray);
                try {
                    this.mWebSocketClient.send(jSONObject.toString().replace("\\\\", ""));
                } catch (WebsocketNotConnectedException unused) {
                    CGLog.e("Signal server not connected");
                }
                CGLog.i("send kick user: " + jSONArray.toString());
                return;
            } catch (JSONException e16) {
                e16.printStackTrace();
                return;
            }
        }
        CGLog.w("Signal server is NOT connected");
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.ConnectionClient
    public void sendOffer(String str, String str2) {
        if (this.mWebSocketClient != null && this.mConnected) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("type", "offer");
                jSONObject.put("sdp", str);
                jSONObject.put(PublicAccountMessageUtilImpl.META_NAME, str2);
                JSONObject jSONObject2 = new JSONObject();
                generateMsgHeader(100000, jSONObject2);
                jSONObject2.put("body", jSONObject);
                try {
                    this.mWebSocketClient.send(jSONObject2.toString().replace("\\\\", ""));
                } catch (WebsocketNotConnectedException unused) {
                    CGLog.e("Signal server not connected");
                }
                CGLog.i("send offer: " + jSONObject.toString(2));
                return;
            } catch (JSONException e16) {
                e16.printStackTrace();
                return;
            }
        }
        CGLog.w("Signal server is NOT connected");
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.ConnectionClient
    public void sendPerfData(ArrayList<String> arrayList, int i3, int i16, int i17, int i18) {
        if (this.mWebSocketClient != null && this.mConnected) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("identityId", "");
                jSONObject.put(VirtualAppProxy.KEY_GAME_ID, this.mGameId);
                jSONObject.put("instanceId", this.mInstanceId);
                jSONObject.put("sessionId", this.sessionId);
                jSONObject.put("sdkRtt", i3);
                jSONObject.put("sdkPktRecved", i16);
                jSONObject.put("sdkPktDropped", i17);
                jSONObject.put("sdkFramesData", new JSONArray((Collection) arrayList));
                jSONObject.put("networkQuality", i18);
                jSONObject.put("cpuUsage", 0);
                JSONObject jSONObject2 = new JSONObject();
                generateMsgHeader(100200, jSONObject2);
                jSONObject2.put("body", jSONObject);
                try {
                    this.mWebSocketClient.send(jSONObject2.toString());
                    return;
                } catch (WebsocketNotConnectedException unused) {
                    CGLog.e("Sending perf data when signal server not connected");
                    return;
                }
            } catch (JSONException e16) {
                e16.printStackTrace();
                return;
            }
        }
        CGLog.w("Signal server is NOT connected");
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.ConnectionClient
    public void sendSdkInfo(JSONObject jSONObject) {
        if (this.mWebSocketClient != null && this.mConnected) {
            if (jSONObject.has("cmd")) {
                CGLog.i("send  WebrtcConnectionStatus" + jSONObject);
                try {
                    this.mWebSocketClient.send(jSONObject.toString());
                    return;
                } catch (WebsocketNotConnectedException unused) {
                    CGLog.e("Sending perf data when signal server not connected");
                    return;
                }
            }
            try {
                jSONObject.put("sessionId", this.sessionId);
                jSONObject.put("instanceId", this.mInstanceId);
                jSONObject.put(VirtualAppProxy.KEY_GAME_ID, this.mGameId);
                jSONObject.put(Constants.SP_DEVICE_ID, this.mDeviceId);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("sdkInfo", jSONObject);
                JSONObject jSONObject3 = new JSONObject();
                generateMsgHeader(100202, jSONObject3);
                jSONObject3.put("body", jSONObject2);
                CGLog.i("Send SDK information" + jSONObject3);
                try {
                    this.mWebSocketClient.send(jSONObject3.toString());
                } catch (WebsocketNotConnectedException unused2) {
                    CGLog.e("Sending perf data when signal server not connected");
                }
                return;
            } catch (JSONException e16) {
                e16.printStackTrace();
                return;
            }
        }
        CGLog.w("Signal server is NOT connected");
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.ConnectionClient
    public void sendUserConfig(UserConfig userConfig) {
        if (this.mWebSocketClient != null && this.mConnected) {
            try {
                JSONObject jSONObject = new JSONObject();
                if (userConfig == null) {
                    jSONObject.put("emitData", "ArrayBuffer");
                } else {
                    jSONObject.put("cg_userid", userConfig.getCg_userid());
                    jSONObject.put("cg_usertoken", userConfig.getCg_usertoken());
                    jSONObject.put("cg_roomid", userConfig.getCg_roomid());
                    jSONObject.put("cg_gameid", userConfig.getCg_gameid());
                }
                JSONObject jSONObject2 = new JSONObject();
                generateMsgHeader(100010, jSONObject2);
                jSONObject2.put("body", jSONObject);
                try {
                    this.mWebSocketClient.send(jSONObject2.toString());
                } catch (WebsocketNotConnectedException unused) {
                    CGLog.e("Signal server not connected");
                }
                CGLog.i("send user config: " + jSONObject.toString(2));
                return;
            } catch (JSONException e16) {
                e16.printStackTrace();
                return;
            }
        }
        CGLog.w("Signal server is NOT connected");
    }

    public void setProxyIpPort(String str, int i3) {
        this.mProxyIp = str;
        this.mProxyPort = i3;
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.ConnectionClient
    public void sendStartBoard(String str, String str2, String str3, String str4) {
    }
}
