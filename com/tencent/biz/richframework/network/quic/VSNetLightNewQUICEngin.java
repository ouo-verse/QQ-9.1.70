package com.tencent.biz.richframework.network.quic;

import android.text.TextUtils;
import com.tencent.biz.richframework.network.quic.manager.VSNetLightQUICIPStrategyManager;
import com.tencent.biz.richframework.network.quic.strategy.VSNetWorkStrategy;
import com.tencent.biz.richframework.network.request.VSNetQUICEvent;
import com.tencent.libra.download.LibraDns;
import com.tencent.lightquic.api.CongestionType;
import com.tencent.lightquic.api.LightQUICEngine;
import com.tencent.lightquic.api.LightQUICEngineConfig;
import com.tencent.lightquic.api.LightQUICRequest;
import com.tencent.lightquic.api.LightQUICRequestConfig;
import com.tencent.lightquic.api.LightQUICSDKMgr;
import com.tencent.lightquic.api.LightQUICSceneId;
import com.tencent.lightquic.api.QUICVersion;
import com.tencent.qphone.base.util.QLog;
import java.net.InetAddress;
import java.util.List;
import org.java_websocket.WebSocketImpl;
import uq3.o;

/* compiled from: P */
/* loaded from: classes5.dex */
public class VSNetLightNewQUICEngin {
    private static final int DEF_CONGESTION_CONTROL_TYPE = 2;
    private static final int DEF_CONGESTION_INITIAL_WINDOW = 128;
    private static final int DEF_PING_KEEP_ALIVE_SEC = 20;
    private static final float DEF_QUIC_CONNECT_TIME_OUT_SEC = 10.0f;
    private static final float DEF_QUIC_IDLE_TIME_OUT = 300.0f;
    private static final float DEF_QUIC_RECV_TIMEOUT_SEC = 15.0f;
    private static final float DEF_QUIC_REQUEST_TIMEOUT = 15.0f;
    private static final String TAG = "QUIC-VSNetLightNewQUICEngin";
    private static volatile VSNetLightNewQUICEngin sInstance;
    private int mQuicCongestionControlType;
    private int mQuicCongestionInitialWindow;
    private float mQuicEngineConnectTimeout;
    private float mQuicEngineIdleTimeout;
    private float mQuicEngineRecvTimeout;
    private boolean mQuicIsEnabledPingKeepAlive;
    private int mQuicPingKeepAliveSec;
    private LightQUICEngine mLightQUicEngin = generateQUICEngineAndUpdateConfig();
    private LibraDns mDNS = new LibraDns(new VSNetWorkStrategy());

    VSNetLightNewQUICEngin() {
    }

    private CongestionType converCongestionType(int i3) {
        if (i3 == 2) {
            return CongestionType.BBR;
        }
        return CongestionType.CUBIC_BYTES;
    }

    public static VSNetLightNewQUICEngin g() {
        if (sInstance == null) {
            synchronized (VSNetLightNewQUICEngin.class) {
                if (sInstance == null) {
                    sInstance = new VSNetLightNewQUICEngin();
                }
            }
        }
        return sInstance;
    }

    private LightQUICEngine generateQUICEngineAndUpdateConfig() {
        String str;
        float quicEngineConnectTimeout;
        float quicEngineRecvTimeout;
        float quicEngineIdleTimeout;
        int congestionControlType;
        int quicCongestionInitialWindow;
        boolean isEnabledPingKeepAlive;
        int quicPingKeepAliveSec;
        LightQUICEngine lightQUICEngine;
        try {
            quicEngineConnectTimeout = getQuicEngineConnectTimeout();
            quicEngineRecvTimeout = getQuicEngineRecvTimeout();
            quicEngineIdleTimeout = getQuicEngineIdleTimeout();
            congestionControlType = getCongestionControlType();
            quicCongestionInitialWindow = getQuicCongestionInitialWindow();
            isEnabledPingKeepAlive = isEnabledPingKeepAlive();
            quicPingKeepAliveSec = getQuicPingKeepAliveSec();
        } catch (Throwable th5) {
            th = th5;
            str = TAG;
        }
        if (this.mQuicEngineConnectTimeout == quicEngineConnectTimeout && this.mQuicEngineRecvTimeout == quicEngineRecvTimeout && this.mQuicEngineIdleTimeout == quicEngineIdleTimeout && this.mQuicCongestionControlType == congestionControlType && this.mQuicCongestionInitialWindow == quicCongestionInitialWindow && this.mQuicIsEnabledPingKeepAlive == isEnabledPingKeepAlive && this.mQuicPingKeepAliveSec == quicPingKeepAliveSec && (lightQUICEngine = this.mLightQUicEngin) != null) {
            return lightQUICEngine;
        }
        QLog.d(TAG, 1, "[generateQUICEngineAndUpdateConfig] quicEngineConnectTimeout: " + quicEngineConnectTimeout + " | quicEngineRecvTimeout: " + quicEngineRecvTimeout + " | quicEngineIdleTimeout: " + quicEngineIdleTimeout);
        QUICVersion qUICVersion = QUICVersion.GQUIC_43;
        CongestionType converCongestionType = converCongestionType(congestionControlType);
        str = TAG;
        try {
            LightQUICEngineConfig lightQUICEngineConfig = new LightQUICEngineConfig(quicEngineConnectTimeout, quicEngineRecvTimeout, quicEngineIdleTimeout, false, true, qUICVersion, true, converCongestionType, quicCongestionInitialWindow, isEnabledPingKeepAlive, quicPingKeepAliveSec);
            LightQUICSDKMgr lightQUICSDKMgr = LightQUICSDKMgr.INSTANCE;
            LightQUICSceneId lightQUICSceneId = LightQUICSceneId.SCENE_ID_QCIRCLE_SHORT_VIDEO;
            lightQUICSDKMgr.configEngine(lightQUICSceneId, lightQUICEngineConfig);
            this.mQuicEngineConnectTimeout = quicEngineConnectTimeout;
            this.mQuicEngineRecvTimeout = quicEngineRecvTimeout;
            this.mQuicEngineIdleTimeout = quicEngineIdleTimeout;
            this.mQuicCongestionControlType = congestionControlType;
            this.mQuicCongestionInitialWindow = quicCongestionInitialWindow;
            this.mQuicIsEnabledPingKeepAlive = isEnabledPingKeepAlive;
            this.mQuicPingKeepAliveSec = quicPingKeepAliveSec;
            this.mLightQUicEngin = LightQUICEngine.INSTANCE.getInstance(lightQUICSceneId);
        } catch (Throwable th6) {
            th = th6;
            QLog.d(str, 1, "[generateQUICEngineAndUpdateConfig] ex: ", th);
            return this.mLightQUicEngin;
        }
        return this.mLightQUicEngin;
    }

    private int getCongestionControlType() {
        return o.R(2);
    }

    private int getQuicCongestionInitialWindow() {
        return o.t0(128);
    }

    private float getQuicEngineConnectTimeout() {
        return o.u0(10.0f);
    }

    private float getQuicEngineIdleTimeout() {
        return o.v0(300.0f);
    }

    private float getQuicEngineRecvTimeout() {
        return o.w0(15.0f);
    }

    private int getQuicPingKeepAliveSec() {
        return o.x0(20);
    }

    private float getQuicRequestTimeout() {
        return o.y0(15.0f);
    }

    private boolean isEnabledPingKeepAlive() {
        return o.y1();
    }

    public LightQUICRequestConfig createLightQUICRequestConfig() {
        return new LightQUICRequestConfig("", true, getQuicRequestTimeout(), WebSocketImpl.DEFAULT_WSS_PORT);
    }

    public LightQUICRequest startRequest(VSNetLightQUICBaseRequest vSNetLightQUICBaseRequest, byte[] bArr) {
        String hostAddress;
        String host = vSNetLightQUICBaseRequest.getHost();
        if (o.F1()) {
            VSNetLightQUICIPStrategyManager.instance().updateInetAddressList(host, false);
            hostAddress = VSNetLightQUICIPStrategyManager.instance().obtainRequestIp(host);
            QLog.d(TAG, 1, "[startRequest] hit ip strategy, resultIp: " + hostAddress);
        } else {
            List<InetAddress> lookup = this.mDNS.lookup(host);
            if (lookup.size() == 0) {
                vSNetLightQUICBaseRequest.onQUICEvent(new VSNetQUICEvent(VSNetQUICEvent.EVENT_ID_QUIC_DNS_ERROR));
                vSNetLightQUICBaseRequest.getCallBack().onRequestFinished(100002, "dns_empty");
                QLog.d(TAG, 1, "createRequest error not find dns:" + vSNetLightQUICBaseRequest.getTraceId());
                return null;
            }
            hostAddress = lookup.get(lookup.size() - 1).getHostAddress();
            QLog.d(TAG, 1, "[startRequest] hit normal dns, resultIp: " + hostAddress);
        }
        if (TextUtils.isEmpty(hostAddress)) {
            vSNetLightQUICBaseRequest.onQUICEvent(new VSNetQUICEvent(VSNetQUICEvent.EVENT_ID_QUIC_DNS_ERROR));
            vSNetLightQUICBaseRequest.getCallBack().onRequestFinished(100002, "dns_empty");
            QLog.d(TAG, 1, "createRequest error not find dns ip, traceid:" + vSNetLightQUICBaseRequest.getTraceId());
            return null;
        }
        vSNetLightQUICBaseRequest.onQUICEvent(new VSNetQUICEvent(VSNetQUICEvent.EVENT_ID_DNS_SUCCESS).setDNSIP(hostAddress));
        LightQUICRequestConfig createLightQUICRequestConfig = createLightQUICRequestConfig();
        generateQUICEngineAndUpdateConfig();
        LightQUICRequest createQUICRequest = this.mLightQUicEngin.createQUICRequest(vSNetLightQUICBaseRequest.getURL(), hostAddress, vSNetLightQUICBaseRequest.getHead(), vSNetLightQUICBaseRequest.getCallBack(), createLightQUICRequestConfig);
        createQUICRequest.startRequest(bArr);
        QLog.d(TAG, 1, "[startRequest] start light quic request: url:" + vSNetLightQUICBaseRequest.getURL() + " |ip:" + hostAddress + " |cdm:" + vSNetLightQUICBaseRequest.getCmdName() + " |service:" + vSNetLightQUICBaseRequest.getServiceName() + " |method:" + vSNetLightQUICBaseRequest.getMethodName() + " |recvTimeout:" + createLightQUICRequestConfig.getRecvTimeoutSec());
        return createQUICRequest;
    }
}
