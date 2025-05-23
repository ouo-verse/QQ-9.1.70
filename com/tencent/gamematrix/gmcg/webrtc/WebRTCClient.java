package com.tencent.gamematrix.gmcg.webrtc;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.os.TraceCompat;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.gamematrix.CgConfig;
import com.tencent.gamematrix.CgQuicClient;
import com.tencent.gamematrix.gmcg.base.delaycount.GmCgDelayCounter;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmcg.webrtc.ConnectionClient;
import com.tencent.gamematrix.gmcg.webrtc.DeviceConfig;
import com.tencent.gamematrix.gmcg.webrtc.PeerConnectionClient;
import com.tencent.gamematrix.gmcg.webrtc.TouchEventSender;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCEvents;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCStatsCollector;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.Constants;
import com.tencent.gamematrix.gmcg.webrtc.monitor.CGTdmDataReport;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.qmethod.pandoraex.monitor.LocationMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qqnt.kernel.nativeinterface.WiFiPhotoErrorCode;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.apache.httpcore.HttpHeaders;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.tencwebrtc.EglBase;
import org.tencwebrtc.IceCandidate;
import org.tencwebrtc.Logging;
import org.tencwebrtc.PeerConnection;
import org.tencwebrtc.RTCStatsCollectorCallback;
import org.tencwebrtc.RTCStatsReport;
import org.tencwebrtc.Setting;
import org.tencwebrtc.SurfaceViewRenderer;

/* compiled from: P */
/* loaded from: classes6.dex */
public class WebRTCClient implements ConnectionClient.SignalEvent, PeerConnectionClient.PeerConnectionEvent {
    public static final String AUDIO_TRACK_ID = "TencAudioTrackTenc";
    private static final short BATTERY_EVENT = 2064;
    private static final String CHINA_TELECOM = "chinatelecom";
    private static final short CLOUD_GAME_WINDOW_SIZE = 2048;
    private static final byte CloudGameWindowEvent = 93;
    private static final int DATA_SEND_CHANNEL = 1;
    private static final short ENABLE_SEI_EXTENSION = 1792;
    private static final byte GameMsgGpsEvent = 99;
    private static final byte GameMsgSensorEvent = 92;
    private static final int MAX_PASS_THROUGH_LEN = 268435456;
    public static final String MEDIA_STREAM_ID = "TencStreamTenc";
    private static final String NETWORK_2G = "2g";
    private static final String NETWORK_3G = "3g";
    private static final String NETWORK_4G = "4g";
    private static final String NETWORK_5G = "5g";
    private static final String NETWORK_MOBILE = "MOBILE";
    private static final String NETWORK_UNKNOWN = "unknown";
    private static final String NETWORK_WIFI = "wifi";
    private static final String NETWORK_WIRE = "wire";
    private static final short PASS_THROUGH_DATA = 512;
    private static final String PREFIX_INPUT_KEY = "key:";
    private static final byte PassThroughEvent = 93;
    private static final int QUIC_SEND_CHANNEL = 2;
    private static final int REGISTRATION_CONNECTION = 102;
    private static final String RTCEVENTLOG_OUTPUT_DIR_NAME = "rtc_event_log";
    private static final int SEG_LEN = 61440;
    private static final short SEND_INPUT_TEXT = 1024;
    private static final short SEND_PHOTO_DATA = 768;
    private static final String SUFFIX_PROPRIETARY_MARK = "_special";
    private static final byte SendInputTextEvent = 93;
    private static final byte SendPhotoEvent = 93;
    private static final String TAG = "WebRTCClient";
    private static boolean mIsCandidateFound = false;
    private static String mProxyIp = null;
    private static int mProxyPort = 0;
    private static String mQuicServerIp = null;
    private static int mQuicServerPort = 0;
    public static String recvCandidate = "";
    public static SharedPreferences spWebRTCClient;
    private ScheduledFuture<?> getRtcStatusScheduledFuture;
    private ScheduledFuture<?> latencyScheduledFuture;
    private boolean mAdoptQuicChannel;
    private boolean mAnswerRecieved;
    private boolean mAudioFec;
    private ConnectionClient mConnClient;
    private final Context mCtx;
    private boolean mCustomizeDecoder;
    private volatile boolean mDataChannelConnected;
    private DeviceConfig mDeviceConfig;
    private boolean mDisableMediaEncryption;
    private EglBase mEglBase;
    private boolean mEnableAudioDump;
    private boolean mEnableCmLog;
    private boolean mEnableFrameFeedback;
    private final boolean mEnableIme;
    private boolean mEnableKeepSession;
    private final boolean mEnableLm;
    private boolean mEnablePassThrough;
    private boolean mEnablePinchFace;
    private boolean mEnableQuic;
    private boolean mEnableRecordFile;
    private boolean mEnableSeiPerfReport;
    private boolean mEnableTrace;
    private boolean mEnableVoice;
    private long mFirstFrameRenderDelay;
    private boolean mFlexFec;
    private boolean mForceFastRender;
    private boolean mHasQuicConnection;
    private final List<JSONObject> mIceCandidatesBeforeAnswer;
    private boolean mImageQualityPreferred;
    private boolean mInit;
    byte[] mInputMethodBuf;
    private int mInputMethodOffset;
    private boolean mKeepSession;
    String mLocalPath;
    private boolean mMatchedCarrierFound;
    private String mOptimalCarrier;
    private String mOptimalCarrierIp;
    private IceCandidate mOptimalIceCandidate;
    private PeerConnectionClient mPCClient;
    private boolean mPCConnected;
    byte[] mPassThroughBuf;
    private int mPassThroughOffset;
    WebRTCSDK.PerfMonitorConfig mPerfConfig;
    private ScheduledExecutorService mPeriodExecutorService;
    private String mPhoneCarrier;
    private String mPrevOptimalCarrierIp;
    private IceCandidate mPrevOptimalIceCandidate;
    private boolean mProprietary;
    private boolean mProprietaryFound;
    private boolean mQuicChannelConnected;
    private CgQuicClient mQuicClient;
    private int mQuicLoggingLevel;
    private final List<JSONObject> mRemoteIceCandidates;
    private boolean mRsFec;
    private final ExecutorService mRtcExecutor;
    WebRTCSDK.SensorConfig mSensorConfig;
    private final CGSessionCtx mSessionCtx;
    private boolean mSignalServerConnected;
    private String mSplicedSignalServer;
    private WebRTCStatsCollector mStatsCollector;
    private boolean mStatsReady;
    private volatile boolean mStopped;
    private SurfaceViewRenderer mSurfaceView;
    byte[] mTVScenesMonitorBuf;
    private int mTVScenesMonitorOffset;
    private boolean mTelecomCarrierFound;
    private int mTouchEventCount;
    private final TouchEventSender mTouchEventSender;
    private boolean mUseOpenSles;
    private UserConfig mUserConfig;
    private VideoCodecType mVideoCodecType;
    private WebRTCParameters mWebRTCParameters;
    private WebRTCEvents mWebrtcEventObserver;
    JSONArray mWebrtcproxyExternalIps;
    private ScheduledFuture<?> packetLossScheduledFuture;
    private int perfDataTag;
    public String tmpDeviceId;

    /* renamed from: cs, reason: collision with root package name */
    public static WebRTCEvents.ConnectionState f108096cs = WebRTCEvents.ConnectionState.STATE_BEGIN;
    public static WebRTCEvents.ConnectStateDisplay csd = WebRTCEvents.ConnectStateDisplay.STATE_BEGIN;
    public static String sessionId = "";
    public static GmCgClientType mGmCgClientType = GmCgClientType.WEBRTC_SESSION_INVALID;
    private static boolean mEnableSeiExt = false;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class Builder {
        private String carrier;
        private final Context ctx;
        private boolean customizeDecoder;
        private boolean disableMediaEncryption;
        private EglBase eglBase;
        private boolean enableAudioDump;
        private boolean enableAudioFec;
        private boolean enableCmLog;
        private boolean enableFlexFec;
        private boolean enableFrameFeedback;
        private boolean enableIme;
        private boolean enableKeepSession;
        private boolean enableLm;
        private boolean enablePassThrough;
        private boolean enableQuic;
        private boolean enableRecordFile;
        private boolean enableRsFec;
        private boolean enableSeiPerfReport;
        private boolean enableVoice;
        private WebRTCEvents events;
        private boolean forceFastRender;
        private WebRTCSDK.PerfMonitorConfig perfConfig;
        private boolean pinchFace;
        private boolean proprietary;
        private int quicLoggingLevel;
        private ExecutorService rtcExecutor;
        private WebRTCSDK.SensorConfig sensorConfig;
        private final CGSessionCtx sessionCtx;
        private SurfaceViewRenderer surfaceView;
        private boolean useOpenSles;

        public Builder(@NonNull Context context, @NonNull CGSessionCtx cGSessionCtx) {
            this.sessionCtx = cGSessionCtx;
            this.ctx = context;
        }

        public WebRTCClient build() {
            return new WebRTCClient(this);
        }

        public Builder disableMediaEncryption(boolean z16) {
            this.disableMediaEncryption = z16;
            return this;
        }

        public Builder enableAudioDump(boolean z16) {
            this.enableAudioDump = z16;
            return this;
        }

        public Builder enableAudioFec(boolean z16) {
            this.enableAudioFec = z16;
            return this;
        }

        public Builder enableCmLog(boolean z16) {
            this.enableCmLog = z16;
            return this;
        }

        public Builder enableFlexFec(boolean z16) {
            this.enableFlexFec = z16;
            return this;
        }

        public Builder enableFrameFeedback(boolean z16) {
            this.enableFrameFeedback = z16;
            return this;
        }

        public Builder enableIme(boolean z16) {
            this.enableIme = z16;
            return this;
        }

        public Builder enableKeepSession(boolean z16) {
            this.enableKeepSession = z16;
            return this;
        }

        public Builder enableLm(boolean z16) {
            this.enableLm = z16;
            return this;
        }

        public Builder enablePassThrough(boolean z16) {
            this.enablePassThrough = z16;
            return this;
        }

        public Builder enablePinchFace(boolean z16) {
            this.pinchFace = z16;
            return this;
        }

        public Builder enableQuic(boolean z16) {
            this.enableQuic = z16;
            return this;
        }

        public Builder enableRecordFile(boolean z16) {
            this.enableRecordFile = z16;
            return this;
        }

        public Builder enableRsFec(boolean z16) {
            this.enableRsFec = z16;
            return this;
        }

        public Builder enableSeiPerfReport(boolean z16) {
            this.enableSeiPerfReport = z16;
            return this;
        }

        public Builder enableVoice(boolean z16) {
            this.enableVoice = z16;
            return this;
        }

        public Builder forceFastRender(boolean z16) {
            this.forceFastRender = z16;
            return this;
        }

        public Builder setCustomizeDecoder(boolean z16) {
            this.customizeDecoder = z16;
            return this;
        }

        public Builder setEglBase(EglBase eglBase) {
            this.eglBase = eglBase;
            return this;
        }

        public Builder setNetworkCarrier(String str) {
            this.carrier = str;
            return this;
        }

        public Builder setPerfConfig(WebRTCSDK.PerfMonitorConfig perfMonitorConfig) {
            this.perfConfig = perfMonitorConfig;
            return this;
        }

        public Builder setProprietary(boolean z16) {
            this.proprietary = z16;
            return this;
        }

        public Builder setQuicLoggingLevel(int i3) {
            this.quicLoggingLevel = i3;
            return this;
        }

        public Builder setSensorConfig(WebRTCSDK.SensorConfig sensorConfig) {
            this.sensorConfig = sensorConfig;
            return this;
        }

        public Builder setSurfaceView(SurfaceViewRenderer surfaceViewRenderer) {
            this.surfaceView = surfaceViewRenderer;
            return this;
        }

        public Builder setWebRtcEvents(WebRTCEvents webRTCEvents) {
            this.events = webRTCEvents;
            return this;
        }

        public Builder setWebRtcExecutor(ExecutorService executorService) {
            this.rtcExecutor = executorService;
            return this;
        }

        public Builder useOpenSles(boolean z16) {
            this.useOpenSles = z16;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addIceCandidate(JSONObject jSONObject) {
        logI("addIceCandidate: " + jSONObject);
        this.mRemoteIceCandidates.add(jSONObject);
        if (!this.mStopped) {
            checkAndAddOptimalCandidate(jSONObject);
        }
    }

    public static String byteToHex(byte[] bArr) {
        StringBuilder sb5 = new StringBuilder();
        for (byte b16 : bArr) {
            sb5.append(String.format("%02x", Byte.valueOf(b16)));
        }
        return sb5.toString();
    }

    private void checkAndAddOptimalCandidate(JSONObject jSONObject) {
        if (!this.mProprietaryFound && !this.mMatchedCarrierFound && !this.mTelecomCarrierFound) {
            CGLog.i("No available carrier found, do not filter ice candidate");
            try {
                IceCandidate iceCandidate = new IceCandidate(jSONObject.getString("sdpMid"), jSONObject.getInt("sdpMLineIndex"), jSONObject.getString("candidate"));
                WebRTCEvents webRTCEvents = this.mWebrtcEventObserver;
                if (webRTCEvents != null && !mIsCandidateFound) {
                    webRTCEvents.onWebrtcStartUpProcess(GmCgDelayCounter.CGDelayLifeCycle.CGWebrtcSubProcessLifeCycle.SUB_PROCESS_ICE, false);
                    this.mWebrtcEventObserver.onWebrtcStartUpProcess(GmCgDelayCounter.CGDelayLifeCycle.CGWebrtcSubProcessLifeCycle.SUB_PROCESS_LINK_WEBRTC, true);
                    mIsCandidateFound = true;
                }
                PeerConnectionClient peerConnectionClient = this.mPCClient;
                if (peerConnectionClient != null) {
                    peerConnectionClient.addRemoteIceCandidate(iceCandidate);
                } else {
                    logE("PCClient is null, can't addRemoteIceCandidate no optimal");
                }
                String string = jSONObject.getString("candidate");
                recvCandidate = string;
                this.mWebrtcEventObserver.onEventBeforeConnected(string, this.mOptimalCarrier, this.mProprietaryFound);
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        } else {
            try {
                String string2 = jSONObject.getString("candidate");
                if (string2.contains(this.mOptimalCarrierIp)) {
                    IceCandidate iceCandidate2 = new IceCandidate(jSONObject.getString("sdpMid"), jSONObject.getInt("sdpMLineIndex"), string2);
                    PeerConnectionClient peerConnectionClient2 = this.mPCClient;
                    if (peerConnectionClient2 != null) {
                        peerConnectionClient2.addRemoteIceCandidate(iceCandidate2);
                    } else {
                        logE("PCClient is null, can't addRemoteIceCandidate optimal");
                    }
                    recvCandidate = string2;
                    this.mWebrtcEventObserver.onEventBeforeConnected(string2, this.mOptimalCarrier, this.mProprietaryFound);
                    this.mOptimalIceCandidate = iceCandidate2;
                    CGLog.i("Add optimal remote candidate(" + this.mOptimalCarrierIp + "): " + string2);
                    WebRTCEvents webRTCEvents2 = this.mWebrtcEventObserver;
                    if (webRTCEvents2 != null && !mIsCandidateFound) {
                        webRTCEvents2.onWebrtcStartUpProcess(GmCgDelayCounter.CGDelayLifeCycle.CGWebrtcSubProcessLifeCycle.SUB_PROCESS_ICE, false);
                        this.mWebrtcEventObserver.onWebrtcStartUpProcess(GmCgDelayCounter.CGDelayLifeCycle.CGWebrtcSubProcessLifeCycle.SUB_PROCESS_LINK_WEBRTC, true);
                        mIsCandidateFound = true;
                    }
                } else {
                    CGLog.i("Not the optimal candidate, continue...");
                }
            } catch (JSONException e17) {
                CGLog.e("checkAndAddOptimalCandidate error: " + e17.getMessage());
            }
        }
        f108096cs = WebRTCEvents.ConnectionState.STATE_ICE_RECEIVED;
        csd = WebRTCEvents.ConnectStateDisplay.STATE_ICE_RECIEVED;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doSendTouchEvents(int i3, List<MobileButtonEvent> list) {
        int i16;
        this.mTouchEventCount++;
        ByteBuffer order = ByteBuffer.allocate((list.size() * 6) + 2).order(ByteOrder.LITTLE_ENDIAN);
        order.put(0, (byte) i3);
        order.put(1, (byte) list.size());
        int i17 = 2;
        for (MobileButtonEvent mobileButtonEvent : list) {
            order.putShort(i17, mobileButtonEvent.pX);
            int i18 = i17 + 2;
            order.putShort(i18, mobileButtonEvent.pY);
            int i19 = i18 + 2;
            order.put(i19, (byte) mobileButtonEvent.pId);
            int i26 = i19 + 1;
            if (mobileButtonEvent.pLast) {
                i16 = 255;
            } else {
                i16 = 0;
            }
            order.put(i26, (byte) i16);
            i17 = i26 + 1;
        }
        sendMessageViaDataChannel(order, false);
    }

    public static void enableSeiExtension(boolean z16) {
        mEnableSeiExt = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeGetStatsAtRtcExecutor(final int i3) {
        this.mRtcExecutor.execute(new Runnable() { // from class: com.tencent.gamematrix.gmcg.webrtc.j
            @Override // java.lang.Runnable
            public final void run() {
                WebRTCClient.this.lambda$executeGetStatsAtRtcExecutor$2(i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getGmCgNetworkType() {
        String networkState = getNetworkState();
        CGLog.i("network State: " + networkState);
        GmCgNetworkType gmCgNetworkType = GmCgNetworkType.NET_INVALID;
        int value = gmCgNetworkType.getValue();
        networkState.hashCode();
        char c16 = '\uffff';
        switch (networkState.hashCode()) {
            case -2015525726:
                if (networkState.equals(NETWORK_MOBILE)) {
                    c16 = 0;
                    break;
                }
                break;
            case -284840886:
                if (networkState.equals("unknown")) {
                    c16 = 1;
                    break;
                }
                break;
            case 1653:
                if (networkState.equals("2g")) {
                    c16 = 2;
                    break;
                }
                break;
            case 1684:
                if (networkState.equals("3g")) {
                    c16 = 3;
                    break;
                }
                break;
            case 1715:
                if (networkState.equals("4g")) {
                    c16 = 4;
                    break;
                }
                break;
            case 1746:
                if (networkState.equals("5g")) {
                    c16 = 5;
                    break;
                }
                break;
            case 3649301:
                if (networkState.equals("wifi")) {
                    c16 = 6;
                    break;
                }
                break;
            case 3649669:
                if (networkState.equals(NETWORK_WIRE)) {
                    c16 = 7;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                return GmCgNetworkType.NET_MOBILE.getValue();
            case 1:
                return gmCgNetworkType.getValue();
            case 2:
                return GmCgNetworkType.NET_2G.getValue();
            case 3:
                return GmCgNetworkType.NET_3G.getValue();
            case 4:
                return GmCgNetworkType.NET_4G.getValue();
            case 5:
                return GmCgNetworkType.NET_5G.getValue();
            case 6:
                return GmCgNetworkType.NET_WIFI.getValue();
            case 7:
                return GmCgNetworkType.NET_WIRED.getValue();
            default:
                return value;
        }
    }

    public static long getMicTime() {
        long currentTimeMillis = System.currentTimeMillis() * 1000;
        long nanoTime = System.nanoTime();
        return currentTimeMillis + ((nanoTime - ((nanoTime / 1000000) * 1000000)) / 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to find 'out' block for switch in B:40:0x0087. Please report as an issue. */
    public String getNetworkState() {
        Context applicationContext;
        NetworkInfo activeNetworkInfo;
        NetworkInfo.State state;
        NetworkInfo.State state2;
        try {
            applicationContext = this.mCtx.getApplicationContext();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (ContextCompat.checkSelfPermission(applicationContext, "android.permission.ACCESS_NETWORK_STATE") != 0 || applicationContext == null) {
            return null;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) applicationContext.getSystemService("connectivity");
        if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
            if (NetworkMonitor.getType(activeNetworkInfo) == 9) {
                return NETWORK_WIRE;
            }
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            if (networkInfo != null && (state2 = networkInfo.getState()) != null && (state2 == NetworkInfo.State.CONNECTED || state2 == NetworkInfo.State.CONNECTING)) {
                return "wifi";
            }
            NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
            if (networkInfo2 != null && (state = networkInfo2.getState()) != null && (state == NetworkInfo.State.CONNECTING || state == NetworkInfo.State.CONNECTED)) {
                int subtype = NetworkMonitor.getSubtype(activeNetworkInfo);
                CGLog.i("network type: " + subtype);
                switch (subtype) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                    case 16:
                        return "2g";
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                    case 18:
                        return "3g";
                    case 13:
                    case 19:
                        return "4g";
                    case 17:
                    default:
                        String subtypeName = networkInfo2.getSubtypeName();
                        if (!subtypeName.equalsIgnoreCase("TD-SCDMA") && !subtypeName.equalsIgnoreCase("WCDMA")) {
                            if (!subtypeName.equalsIgnoreCase("CDMA2000")) {
                                return "unknown";
                            }
                        }
                        return "3g";
                    case 20:
                        return "5g";
                }
            }
        }
        return "unknown";
    }

    private void identifyOptimalCandidate(String str) {
        int i3;
        try {
            CGLog.i("identifyOptimalCandidate form " + str);
            JSONArray jSONArray = this.mWebrtcproxyExternalIps;
            int i16 = 0;
            if (jSONArray != null) {
                i3 = jSONArray.length();
            } else {
                i3 = 0;
            }
            String[] strArr = new String[i3];
            while (true) {
                JSONArray jSONArray2 = this.mWebrtcproxyExternalIps;
                if (jSONArray2 == null || i16 >= jSONArray2.length()) {
                    break;
                }
                String string = ((JSONObject) this.mWebrtcproxyExternalIps.get(i16)).getString("ip");
                String string2 = ((JSONObject) this.mWebrtcproxyExternalIps.get(i16)).getString("isp");
                CGLog.i("webrtcproxy ip=" + string + " carrier=" + string2 + " phone carrier=" + this.mPhoneCarrier + " proprietary=" + this.mProprietary);
                strArr[i16] = string2;
                if (this.mProprietary) {
                    if (string2.matches(this.mPhoneCarrier + SUFFIX_PROPRIETARY_MARK)) {
                        CGLog.i(string2 + " \u5339\u914d\u5230 " + this.mPhoneCarrier + SUFFIX_PROPRIETARY_MARK);
                        this.mProprietaryFound = true;
                        this.mOptimalCarrierIp = string;
                        this.mOptimalCarrier = this.mPhoneCarrier;
                        break;
                    }
                }
                if (string2.matches(this.mPhoneCarrier)) {
                    if (!string2.matches(this.mPhoneCarrier + SUFFIX_PROPRIETARY_MARK)) {
                        CGLog.i(string2 + " \u5339\u914d\u5230 " + this.mPhoneCarrier);
                        this.mMatchedCarrierFound = true;
                        this.mOptimalCarrierIp = string;
                        this.mOptimalCarrier = this.mPhoneCarrier;
                    }
                }
                if (string2.matches(CHINA_TELECOM)) {
                    CGLog.i(string2 + " \u5339\u914d\u5230 " + CHINA_TELECOM);
                    this.mTelecomCarrierFound = true;
                    if (!this.mMatchedCarrierFound) {
                        CGLog.i("\u672a\u5339\u914d\u5230\u8fd0\u8425\u5546\uff0c\u9ed8\u8ba4\u4f7f\u7528chinatelecom");
                        this.mOptimalCarrierIp = string;
                        this.mOptimalCarrier = CHINA_TELECOM;
                    }
                }
                i16++;
            }
            WebRTCEvents webRTCEvents = this.mWebrtcEventObserver;
            if (webRTCEvents != null) {
                webRTCEvents.onEventNetworkCarrier(this.mOptimalCarrier, this.mPhoneCarrier);
                if (!this.mProprietaryFound && !this.mMatchedCarrierFound) {
                    this.mWebrtcEventObserver.onEventNetworkCarrierMismatch(strArr, this.mPhoneCarrier, this.mOptimalCarrier);
                }
            }
        } catch (Exception e16) {
            CGLog.w(e16.toString());
        }
        CGLog.i("optimal ip=" + this.mOptimalCarrierIp + " optimal carrier=" + this.mOptimalCarrier + " mProprietaryFound=" + this.mProprietaryFound + "mMatchedCarrierFound" + this.mMatchedCarrierFound + " mTelecomCarrierFound=" + this.mTelecomCarrierFound);
    }

    private void init() {
        String deviceId;
        if (this.mInit) {
            CGLog.i("WebRTCClient has init");
            return;
        }
        this.mInit = true;
        CGLog.i("init WebRTC");
        if (this.mEnableQuic) {
            initQuicClient();
        }
        HashMap hashMap = new HashMap();
        if (this.mDeviceConfig.isUseInstIp()) {
            this.mSplicedSignalServer = this.mDeviceConfig.getInstHost().trim();
        } else {
            this.mSplicedSignalServer = this.mDeviceConfig.getSignalServer().trim();
        }
        CGLog.i("mSplicedSignalServer = " + this.mDeviceConfig.getSignalServer().trim());
        String[] split = this.mSplicedSignalServer.split("&IP=", 4);
        hashMap.put("Connection", HttpHeaders.UPGRADE);
        hashMap.put(HttpHeaders.UPGRADE, "websocket");
        if (split.length >= 2) {
            this.mSplicedSignalServer = split[1];
            hashMap.put("Host", split[0]);
            String str = this.mSplicedSignalServer;
            if (!str.contains("http")) {
                str = "https://" + str;
            }
            hashMap.put("Origin", str);
            if (!this.mSplicedSignalServer.contains("ws")) {
                this.mSplicedSignalServer = "wss://" + this.mSplicedSignalServer;
            }
        } else {
            this.mSplicedSignalServer = split[0];
        }
        if (this.mDeviceConfig.getDeviceModel() == DeviceConfig.DeviceModel.DEVICE_ARM) {
            if (!this.mSplicedSignalServer.contains("ws")) {
                this.mSplicedSignalServer = "wss://" + this.mSplicedSignalServer;
            }
            if (!this.mSplicedSignalServer.contains("/p/conn?")) {
                this.mSplicedSignalServer += "/p/conn?";
            }
            if (!this.mSplicedSignalServer.contains("deviceId=")) {
                this.mSplicedSignalServer += "deviceId=" + this.mDeviceConfig.getDeviceId();
            }
            if (!this.mSplicedSignalServer.contains("identity=")) {
                this.mSplicedSignalServer += "&identity=" + this.mDeviceConfig.getIdentity();
            }
            if (!this.mSplicedSignalServer.contains("controlKey=")) {
                this.mSplicedSignalServer += "&controlKey=" + this.mDeviceConfig.getControlKey();
            }
            if (this.mDeviceConfig.isUseInstIp() && !this.mSplicedSignalServer.contains("instip=")) {
                this.mSplicedSignalServer += "&instip=" + this.mDeviceConfig.getInstAddress();
            }
            if (!this.mSplicedSignalServer.contains("token=")) {
                this.mSplicedSignalServer += "&token=" + this.mDeviceConfig.getToken();
            }
            if (this.mDeviceConfig.getDeviceId() == null) {
                deviceId = this.mSplicedSignalServer.split("deviceId=")[1].split(ContainerUtils.FIELD_DELIMITER)[0];
            } else {
                deviceId = this.mDeviceConfig.getDeviceId();
            }
            String str2 = deviceId;
            this.tmpDeviceId = str2;
            ConnectionClient connectionClient = this.mConnClient;
            if (connectionClient != null) {
                connectionClient.close();
            }
            WSClient wSClient = new WSClient(this, this.mWebrtcEventObserver, this.mSensorConfig, this.mPerfConfig, str2, this.mEnableKeepSession, hashMap);
            wSClient.setProxyIpPort(mProxyIp, mProxyPort);
            this.mConnClient = wSClient;
            this.mPCClient = new PeerConnectionClient(this.mCtx.getApplicationContext(), this.mEglBase, this, this.mWebRTCParameters, this.mEnableVoice, this.mUseOpenSles, this.mEnableRecordFile, this.mEnablePassThrough, this.mEnableAudioDump, this.mForceFastRender, this.mEnableKeepSession, this.mFlexFec, this.mAudioFec, this.mRsFec, this.mEnableFrameFeedback, this.mCustomizeDecoder, this.mEnableCmLog, this.mDisableMediaEncryption);
            this.mPeriodExecutorService = ProxyExecutors.newScheduledThreadPool(1);
            WebRTCStatsCollector webRTCStatsCollector = new WebRTCStatsCollector();
            this.mStatsCollector = webRTCStatsCollector;
            webRTCStatsCollector.setReportCallback(new WebRTCStatsCollector.ReportCallback() { // from class: com.tencent.gamematrix.gmcg.webrtc.h
                @Override // com.tencent.gamematrix.gmcg.webrtc.WebRTCStatsCollector.ReportCallback
                public final void onReport(ReportPerfValue reportPerfValue) {
                    WebRTCClient.this.lambda$init$0(reportPerfValue);
                }
            });
            this.mPCClient.setVideoRender(this.mSurfaceView);
            this.mPCClient.enablePinchFace(this.mEnablePinchFace);
            try {
                Setting setting = new Setting();
                setting.dump_received_bitstream = this.mWebRTCParameters.isDumpReceivedBitstream();
                setting.dump_size = this.mWebRTCParameters.getDumpSize();
                setting.dump_path = this.mWebRTCParameters.getDumpPath();
                setting.configure();
            } catch (Exception e16) {
                CGLog.e("Failed to setting.configure(); cause: " + e16);
            }
            this.mProprietaryFound = false;
            this.mMatchedCarrierFound = false;
            this.mTelecomCarrierFound = false;
            if (this.mWebRTCParameters.getLoggingSeverity() == Logging.Severity.LS_VERBOSE) {
                this.mEnableTrace = true;
                return;
            }
            return;
        }
        if (!this.mSplicedSignalServer.contains("http")) {
            this.mSplicedSignalServer = "https://" + this.mSplicedSignalServer;
        }
        if (!this.mSplicedSignalServer.contains("?device_id=")) {
            this.mSplicedSignalServer += "?device_id=" + this.mDeviceConfig.getDeviceId();
        }
        throw new IllegalArgumentException("\u4e0d\u652f\u6301\u975eARM\u8bbe\u5907");
    }

    @Deprecated
    private void initQuicClient() {
        this.mQuicClient = new CgQuicClient(new CgQuicClient.Callback() { // from class: com.tencent.gamematrix.gmcg.webrtc.WebRTCClient.11
            public void InternalOnData(byte[] bArr) {
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                wrap.order(byteOrder);
                wrap.mark();
                byte b16 = wrap.get();
                int i3 = 0;
                if (b16 == 2) {
                    int i16 = wrap.getInt() & 255;
                    if (i16 != 5) {
                        if (i16 != 6) {
                            if (i16 != 7) {
                                if (i16 != 8) {
                                    if (i16 != 96) {
                                        if (i16 != 98) {
                                            switch (i16) {
                                                case 10:
                                                    WebRTCClient.this.handleInputMethod(wrap);
                                                    return;
                                                case 11:
                                                    WebRTCClient.this.handlePriviledgeNotification(bArr);
                                                    return;
                                                case 12:
                                                    WebRTCClient.this.handleTVScenesMonitor(wrap);
                                                    return;
                                                default:
                                                    return;
                                            }
                                        }
                                        WebRTCClient.this.onVirtualGamepadParamsResp(bArr);
                                        return;
                                    }
                                    WebRTCClient.this.onVirtualGamepadSdkData(bArr);
                                    return;
                                }
                                if (WebRTCClient.this.mEnablePassThrough) {
                                    WebRTCClient.this.handlePassThrough(wrap);
                                    return;
                                }
                                return;
                            }
                            if (WebRTCClient.this.mEnablePinchFace) {
                                int i17 = wrap.getInt();
                                int i18 = wrap.getInt();
                                int i19 = wrap.getInt();
                                int i26 = wrap.getInt();
                                byte[] bArr2 = new byte[i17];
                                System.arraycopy(bArr, 21, bArr2, 0, i17);
                                String str = new String(bArr2);
                                CGLog.v("Received photo from game: " + str + ", nameLen=" + i17 + ", fileLen=" + i18 + ", segLen=" + i19 + ", isLast=" + i26 + ", channel capacity=" + wrap.capacity());
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append(WebRTCClient.this.mLocalPath);
                                sb5.append(str.substring(14));
                                File file = new File(sb5.toString());
                                try {
                                    if (!file.exists()) {
                                        if (!file.getParentFile().exists()) {
                                            file.getParentFile().mkdirs();
                                        }
                                        file.createNewFile();
                                    }
                                    FileOutputStream fileOutputStream = new FileOutputStream(file, true);
                                    int i27 = 21 + i17;
                                    if (wrap.capacity() < i27 + i19) {
                                        CGLog.e("channel capacity less than expected");
                                    }
                                    fileOutputStream.write(bArr, i27, i19);
                                    fileOutputStream.close();
                                } catch (IOException e16) {
                                    CGLog.e("Failed to write: " + e16);
                                }
                                if (i26 == 1) {
                                    Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                                    intent.setData(Uri.fromFile(file));
                                    WebRTCClient.this.mCtx.getApplicationContext().sendBroadcast(intent);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        if (wrap.getInt() == 0) {
                            WebRTCClient.this.onGpsSwitched(false);
                            CGLog.i("Received gps switching off message");
                            return;
                        } else {
                            WebRTCClient.this.onGpsSwitched(true);
                            CGLog.i("Received gps switching on message");
                            return;
                        }
                    }
                    if (WebRTCClient.this.mEnableVoice) {
                        if (wrap.getInt() == 0) {
                            WebRTCClient.this.onVoiceSwitched(false);
                            CGLog.i("Received voice switching off message");
                            return;
                        } else {
                            WebRTCClient.this.onVoiceSwitched(true);
                            CGLog.i("Received voice switching on message");
                            return;
                        }
                    }
                    return;
                }
                if (b16 == 3) {
                    if (wrap.get() == 107) {
                        try {
                            try {
                                int i28 = ((bArr[2] & 255) << 0) | ((bArr[3] & 255) << 8) | ((bArr[4] & 255) << 16) | ((bArr[5] & 255) << 24);
                                if (i28 > 256) {
                                    WebRTCClient.this.onConnectionNotification(2, null);
                                    return;
                                }
                                try {
                                    WebRTCClient.this.onConnectionNotification(1, new String(bArr, 6, i28));
                                } catch (Throwable th5) {
                                    th = th5;
                                    i3 = 1;
                                    WebRTCClient.this.onConnectionNotification(i3, null);
                                    throw th;
                                }
                            } catch (Exception unused) {
                                WebRTCClient.this.onConnectionNotification(3, null);
                            }
                        } catch (Throwable th6) {
                            th = th6;
                        }
                    }
                } else {
                    if (b16 == 108) {
                        try {
                            int i29 = ((bArr[1] & 255) << 0) | ((bArr[2] & 255) << 8) | ((bArr[3] & 255) << 16) | ((bArr[4] & 255) << 24);
                            if (i29 > 256) {
                                return;
                            }
                            WebRTCClient.this.switchSdkSendChannel(new String(bArr, 5, i29));
                            return;
                        } catch (Exception unused2) {
                            return;
                        } finally {
                            WebRTCClient.this.switchSdkSendChannel(null);
                        }
                    }
                    if (b16 == 4) {
                        long micTime = WebRTCClient.getMicTime();
                        wrap.reset();
                        wrap.get();
                        wrap.getInt();
                        long j3 = wrap.getLong();
                        long j16 = wrap.getLong();
                        ByteBuffer order = ByteBuffer.allocate(wrap.capacity() - 4).order(byteOrder);
                        order.mark();
                        order.put(0, (byte) -3);
                        order.putLong(1, j3);
                        order.putLong(9, j16);
                        order.putLong(17, micTime);
                        order.putLong(25, 0L);
                        if (WebRTCClient.this.mQuicClient != null && WebRTCClient.this.mQuicChannelConnected) {
                            WebRTCClient.this.mQuicClient.sendArray(order.array(), order.arrayOffset() + order.position(), order.remaining());
                            return;
                        }
                        return;
                    }
                    if (b16 == 109) {
                        try {
                            try {
                                int i36 = ((bArr[1] & 255) << 0) | ((bArr[2] & 255) << 8) | ((bArr[3] & 255) << 16) | ((bArr[4] & 255) << 24);
                                if (i36 > 256) {
                                    WebRTCClient.this.onSetWebrtcNetworkBandWidth(2, null);
                                    return;
                                }
                                try {
                                    WebRTCClient.this.onSetWebrtcNetworkBandWidth(1, new String(bArr, 5, i36));
                                } catch (Throwable th7) {
                                    th = th7;
                                    i3 = 1;
                                    WebRTCClient.this.onSetWebrtcNetworkBandWidth(i3, null);
                                    throw th;
                                }
                            } catch (Throwable th8) {
                                th = th8;
                            }
                        } catch (Exception unused3) {
                            WebRTCClient.this.onSetWebrtcNetworkBandWidth(3, null);
                        }
                    } else if (b16 == -126) {
                        WebRTCClient.this.handleCumulativeDelayedInformation(wrap, 1);
                    }
                }
            }

            public int byteArrayToInt(byte[] bArr, int i3) {
                return ((bArr[i3 + 3] & 255) << 24) | (bArr[i3] & 255) | ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3 + 2] & 255) << 16);
            }

            @Override // com.tencent.gamematrix.CgQuicClient.Callback
            public void onClose(int i3, String str) {
                WebRTCClient.this.mQuicChannelConnected = false;
                CGLog.i("Quic: onClose, error_code: " + i3 + " error_str: " + str);
            }

            @Override // com.tencent.gamematrix.CgQuicClient.Callback
            public void onConnect(final String str) {
                CGLog.i("Quic: onConnect id: " + str);
                new BaseThread() { // from class: com.tencent.gamematrix.gmcg.webrtc.WebRTCClient.11.1
                    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
                    public void run() {
                        CGLog.i("Quic: onConnect begin wait: " + WebRTCClient.this.mAdoptQuicChannel);
                        int i3 = 2000;
                        while (!WebRTCClient.this.mAdoptQuicChannel && !WebRTCClient.this.mStopped && i3 > 0) {
                            i3 -= 30;
                            try {
                                LockMethodProxy.sleep(30L);
                            } catch (Exception e16) {
                                CGLog.i("Quic: onConnect waiting " + e16.toString());
                            }
                        }
                        CGLog.i("Quic: onConnect end  wait: " + WebRTCClient.this.mAdoptQuicChannel);
                        WebRTCClient.this.mQuicChannelConnected = true;
                        WebRTCClient.this.getClientInfoAndRegisterConnection(2, WebRTCClient.mGmCgClientType.getValue(), WebRTCClient.sessionId, str, WebRTCClient.this.getGmCgNetworkType(), WebRTCClient.this.mOptimalCarrier != null ? WebRTCClient.this.mOptimalCarrier : WebRTCClient.this.mPhoneCarrier);
                    }
                }.start();
            }

            @Override // com.tencent.gamematrix.CgQuicClient.Callback
            public void onData(int i3, int i16, byte[] bArr) {
                int length = bArr.length;
                int i17 = 0;
                while (i17 < length) {
                    int byteArrayToInt = byteArrayToInt(bArr, i17);
                    byte[] bArr2 = new byte[byteArrayToInt];
                    System.arraycopy(bArr, i17 + 4, bArr2, 0, byteArrayToInt);
                    InternalOnData(bArr2);
                    i17 += byteArrayToInt + 4;
                }
            }
        }, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$executeGetStatsAtRtcExecutor$2(final int i3) {
        PeerConnectionClient peerConnectionClient;
        if (!this.mStopped && (peerConnectionClient = this.mPCClient) != null) {
            peerConnectionClient.getStats(new RTCStatsCollectorCallback() { // from class: com.tencent.gamematrix.gmcg.webrtc.g
                @Override // org.tencwebrtc.RTCStatsCollectorCallback
                public final void onStatsDelivered(RTCStatsReport rTCStatsReport) {
                    WebRTCClient.this.lambda$null$1(i3, rTCStatsReport);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$0(ReportPerfValue reportPerfValue) {
        WebRTCEvents webRTCEvents = this.mWebrtcEventObserver;
        if (webRTCEvents != null) {
            webRTCEvents.onEventReportPerfValueDelivered(reportPerfValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$null$1(int i3, RTCStatsReport rTCStatsReport) {
        WebRTCEvents webRTCEvents;
        if (!this.mStopped) {
            WebRTCStatsCollector webRTCStatsCollector = this.mStatsCollector;
            if (webRTCStatsCollector != null) {
                webRTCStatsCollector.onStatsDelivered(rTCStatsReport);
                GmCgPxlwManager.get().onPxlwFpsUpdated((int) this.mStatsCollector.perfValue.decodeRate);
                PerfValue perfValue = this.mStatsCollector.perfValue;
                perfValue.tag = this.perfDataTag;
                CGTdmDataReport.reportPerfData(this.mSessionCtx, perfValue, false);
            }
            long collectPerf = this.mPerfConfig.collectPerf(i3);
            WebRTCStatsCollector webRTCStatsCollector2 = this.mStatsCollector;
            if (webRTCStatsCollector2 != null) {
                PerfValue perfValue2 = webRTCStatsCollector2.perfValue;
                long j3 = perfValue2.rtt + collectPerf;
                perfValue2.stutterLatency = j3;
                if (j3 > 460) {
                    perfValue2.stutterLatency = 460L;
                    CGLog.i("totalStutterInSec=" + collectPerf + ", mStatsCollector.perfValue.rtt=" + this.mStatsCollector.perfValue.rtt);
                }
            }
            WebRTCStatsCollector webRTCStatsCollector3 = this.mStatsCollector;
            if (webRTCStatsCollector3 != null && (webRTCEvents = this.mWebrtcEventObserver) != null) {
                webRTCEvents.onEventSamplePerfValueDelivered(webRTCStatsCollector3.perfValue);
                VideoCodecType videoCodecType = this.mVideoCodecType;
                VideoCodecType videoCodecType2 = VideoCodecType.UNKNOWN;
                if (videoCodecType == videoCodecType2) {
                    VideoCodecType codecType = this.mStatsCollector.getCodecType();
                    this.mVideoCodecType = codecType;
                    if (codecType != videoCodecType2) {
                        this.mWebrtcEventObserver.onEventCodecTypeReported(codecType);
                        sendSDKInfo(new JSONObject());
                    }
                }
            }
        }
    }

    private void launchCheckPCConnectedTimerTask() {
        this.mPeriodExecutorService.schedule(new Runnable() { // from class: com.tencent.gamematrix.gmcg.webrtc.WebRTCClient.1
            @Override // java.lang.Runnable
            public void run() {
                if (!WebRTCClient.this.mPCConnected) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        int ordinal = WebRTCClient.csd.ordinal() + 41130;
                        WebRTCClient.this.genCurrentStatus(ordinal);
                        jSONObject.put("reserve4", "connectStatusCode:" + ordinal + ";");
                        WebRTCClient.this.sendSDKInfo(jSONObject);
                    } catch (JSONException e16) {
                        e16.printStackTrace();
                    }
                    WebRTCClient.this.mWebrtcEventObserver.onEventConnectStatus(WebRTCClient.csd);
                    WebRTCClient.f108096cs = WebRTCEvents.ConnectionState.STATE_WEBRTC_TIMEOUT;
                    CGLog.e(WebRTCClient.this.mWebRTCParameters.getConnectionTimeOut() + " seconds timeout, webrtc is not connected");
                    WebRTCClient.this.mWebrtcEventObserver.onEventConnectFailed(WebRTCClient.f108096cs, WebRTCClient.sessionId, WebRTCClient.recvCandidate);
                }
            }
        }, this.mWebRTCParameters.getConnectionTimeOut(), TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logE(String str) {
        CGLog.e("Thread[" + Thread.currentThread().getName() + "] " + this + MsgSummary.STR_COLON + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logI(String str) {
        CGLog.i("Thread[" + Thread.currentThread().getName() + "] WebRTCClient@" + hashCode() + MsgSummary.STR_COLON + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendChannelPing() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("cmd", "DataChannelPing");
            jSONObject.put("data", System.currentTimeMillis());
            byte[] bytes = jSONObject.toString().getBytes();
            ByteBuffer order = ByteBuffer.allocate(bytes.length + 5).order(ByteOrder.LITTLE_ENDIAN);
            order.put(Byte.MIN_VALUE);
            order.putInt(bytes.length);
            order.put(bytes);
            order.position(0);
            CGLog.d("sendChannelPing :" + jSONObject);
            sendMessageViaDataChannel(order, false);
        } catch (Exception e16) {
            CGLog.e("sendChannelPing failed: " + e16);
        }
    }

    private void sendClientInfoAndRegisterConnection(int i3, String str) {
        byte[] bytes = str.getBytes();
        int length = bytes.length + 5;
        ByteBuffer order = ByteBuffer.allocate(length).order(ByteOrder.LITTLE_ENDIAN);
        order.put((byte) 102);
        order.putInt(bytes.length);
        order.put(bytes);
        order.position(0);
        if (i3 == 1) {
            if (this.mPCClient != null && this.mDataChannelConnected) {
                this.mPCClient.sendMessageViaDataChannel(order);
                return;
            } else {
                CGLog.e("mPCClient = null, sendDataChannelClientInfoConnectionRegistration failed");
                return;
            }
        }
        if (i3 == 2) {
            if (this.mQuicClient != null && this.mQuicChannelConnected) {
                order.position(0);
                this.mQuicClient.sendArray(order.array(), order.arrayOffset() + order.position(), length);
                return;
            }
            CGLog.e("mQuicClient = null, sendQuicClientInfoConnectionRegistration failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendLocalLatency() {
        try {
            ByteBuffer order = ByteBuffer.allocate(10).order(ByteOrder.LITTLE_ENDIAN);
            order.put(0, Constants.SEND_CHANNEL_LATENCY);
            order.put(1, (byte) 8);
            long nanoTime = System.nanoTime() / 1000000;
            order.putLong(2, nanoTime);
            order.position(0);
            CGLog.i("local latency start ms=" + nanoTime);
            sendMessageViaDataChannel(order, false);
        } catch (Exception e16) {
            CGLog.e("sendLocalLatency failed: " + e16);
        }
    }

    public static void setClientType(GmCgClientType gmCgClientType) {
        mGmCgClientType = gmCgClientType;
    }

    public static void setProxyIpPort(String str, int i3) {
        mProxyIp = str;
        mProxyPort = i3;
    }

    public static void setQuicIPPort(String str, int i3) {
        mQuicServerIp = str;
        mQuicServerPort = i3;
    }

    private void startRtcGetStats(final int i3, int i16) {
        if (!this.mStopped && this.mPeriodExecutorService != null) {
            WebRTCStatsCollector.setFrequency(i3, i16);
            ScheduledFuture<?> scheduledFuture = this.getRtcStatusScheduledFuture;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
            TimeUnit timeUnit = TimeUnit.SECONDS;
            this.getRtcStatusScheduledFuture = this.mPeriodExecutorService.scheduleAtFixedRate(new Runnable() { // from class: com.tencent.gamematrix.gmcg.webrtc.WebRTCClient.4
                @Override // java.lang.Runnable
                public void run() {
                    if (!WebRTCClient.this.mStopped && WebRTCClient.this.mPCConnected && WebRTCClient.this.mStatsReady) {
                        WebRTCClient.this.executeGetStatsAtRtcExecutor(i3);
                    }
                }
            }, 1L, i3, timeUnit);
            ScheduledFuture<?> scheduledFuture2 = this.packetLossScheduledFuture;
            if (scheduledFuture2 != null) {
                scheduledFuture2.cancel(true);
            }
            this.packetLossScheduledFuture = this.mPeriodExecutorService.scheduleWithFixedDelay(new Runnable() { // from class: com.tencent.gamematrix.gmcg.webrtc.WebRTCClient.5
                @Override // java.lang.Runnable
                public void run() {
                    if (WebRTCClient.this.mStopped) {
                        CGLog.i("packetLossScheduledFuture still runs after SDK stopped");
                    }
                    if (!WebRTCClient.this.mStopped && WebRTCClient.this.mStatsCollector != null) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("accu_packets_lost", WebRTCClient.this.mStatsCollector.perfValue.accuPacketsLost);
                            jSONObject.put("accu_packets_recovery_by_fec", WebRTCClient.this.mStatsCollector.perfValue.packetsRecoveryByFec);
                            jSONObject.put("accu_packets_recovery_by_nack", WebRTCClient.this.mStatsCollector.perfValue.packetsRecoveryByNack);
                            byte[] bytes = jSONObject.toString().getBytes();
                            ByteBuffer order = ByteBuffer.allocate(bytes.length + 5).order(ByteOrder.LITTLE_ENDIAN);
                            order.put(Constants.PACKET_LOSS_EFFECT_STATIS);
                            order.putInt(bytes.length);
                            order.put(bytes);
                            order.position(0);
                            WebRTCClient.this.sendMessageViaDataChannel(order);
                        } catch (JSONException unused) {
                            CGLog.e("failed to send accu packets information");
                        }
                    }
                }
            }, 1L, 10L, timeUnit);
        }
        ScheduledExecutorService scheduledExecutorService = this.mPeriodExecutorService;
        if (scheduledExecutorService != null) {
            this.latencyScheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(new Runnable() { // from class: com.tencent.gamematrix.gmcg.webrtc.WebRTCClient.6
                @Override // java.lang.Runnable
                public void run() {
                    if (WebRTCClient.this.mStopped) {
                        CGLog.i("latencyScheduledFuture still runs after SDK stopped");
                    }
                    if (!WebRTCClient.this.mStopped) {
                        WebRTCClient.this.mRtcExecutor.execute(new Runnable() { // from class: com.tencent.gamematrix.gmcg.webrtc.WebRTCClient.6.1
                            @Override // java.lang.Runnable
                            public void run() {
                                WebRTCClient.this.sendLocalLatency();
                                WebRTCClient.this.sendChannelPing();
                            }
                        });
                    }
                }
            }, 1L, 2L, TimeUnit.SECONDS);
        }
    }

    private void stopGetStat() {
        this.mStatsReady = false;
        try {
            WebRTCStatsCollector webRTCStatsCollector = this.mStatsCollector;
            if (webRTCStatsCollector != null) {
                webRTCStatsCollector.onStatsStop();
            }
            StringBuilder sb5 = new StringBuilder("Cancel");
            ScheduledFuture<?> scheduledFuture = this.getRtcStatusScheduledFuture;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
                sb5.append(" getRtcStatusScheduledFuture");
            }
            ScheduledFuture<?> scheduledFuture2 = this.packetLossScheduledFuture;
            if (scheduledFuture2 != null) {
                scheduledFuture2.cancel(true);
                sb5.append(" packetLossScheduledFuture");
            }
            ScheduledFuture<?> scheduledFuture3 = this.latencyScheduledFuture;
            if (scheduledFuture3 != null) {
                scheduledFuture3.cancel(true);
                sb5.append(" latencyScheduledFuture");
            }
            CGLog.i(sb5.toString());
        } catch (Exception e16) {
            CGLog.i("Failed to stop getting statistics:" + e16);
        }
    }

    private void uninit() {
        if (!this.mInit) {
            return;
        }
        this.mInit = false;
        CGLog.i("uninit WebRTC");
        this.mPeriodExecutorService.shutdownNow();
        this.mTouchEventSender.stop();
        this.mPCClient.setVideoRender(null);
        this.mPeriodExecutorService = null;
        this.mStatsCollector = null;
        this.mPCClient = null;
        this.mConnClient = null;
        this.mQuicClient = null;
    }

    public int MethodCall(String str, List<String> list) {
        try {
            PeerConnectionClient peerConnectionClient = this.mPCClient;
            if (peerConnectionClient == null) {
                return -1;
            }
            return peerConnectionClient.MethodCall(str, list);
        } catch (Exception e16) {
            logE("Method Call: " + e16);
            return -1;
        }
    }

    public void clearTouchEventCount() {
        this.mTouchEventCount = 0;
    }

    public void enableRemoteMediaStream(boolean z16) {
        remoteMediaStreamTrackSetEnabled(z16);
    }

    public void genCurrentStatus(int i3) {
        String str;
        SharedPreferences.Editor edit = spWebRTCClient.edit();
        edit.putBoolean("timeout", true);
        edit.putInt("webrtccode", i3);
        edit.putString(com.tencent.bugly.common.constants.Constants.SP_DEVICE_ID, this.tmpDeviceId);
        edit.putString("sessionId", sessionId);
        edit.putString("identity", this.mDeviceConfig.getIdentity());
        edit.putString("sdkVersion", "3.0.0.241111110.3.9-SNAPSHOT");
        if (this.mWebRTCParameters.isHwDecode()) {
            str = "hw";
        } else {
            str = "sw";
        }
        edit.putString("decode", str);
        edit.commit();
    }

    public boolean getAudioStatus() {
        PeerConnectionClient peerConnectionClient;
        if (!this.mStopped && this.mPCConnected && (peerConnectionClient = this.mPCClient) != null) {
            return peerConnectionClient.getAudioStatus();
        }
        return false;
    }

    public void getClientInfoAndRegisterConnection(int i3, int i16, String str, String str2, int i17, String str3) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", i16);
            jSONObject.put("sessionID", str);
            jSONObject.put("id", str2);
            jSONObject.put("network_type", i17);
            jSONObject.put("network_operator", str3);
            CGLog.i("getClientInfoAndRegisterConnection: " + jSONObject.toString());
            sendClientInfoAndRegisterConnection(i3, jSONObject.toString());
        } catch (Exception e16) {
            CGLog.e("Failed to get client info and register connection, cause " + e16);
        }
    }

    public boolean getDataChannelConnectedState() {
        return this.mDataChannelConnected;
    }

    public PerfValue getPerfValue() {
        WebRTCStatsCollector webRTCStatsCollector = this.mStatsCollector;
        if (webRTCStatsCollector != null) {
            return webRTCStatsCollector.perfValue;
        }
        return null;
    }

    public boolean getSignalServerConnectedState() {
        return this.mSignalServerConnected;
    }

    public int getTouchEventCount() {
        return this.mTouchEventCount;
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.PeerConnectionClient.PeerConnectionEvent
    public void handleCumulativeDelayedInformation(ByteBuffer byteBuffer, int i3) {
        WebRTCEvents webRTCEvents = this.mWebrtcEventObserver;
        if (webRTCEvents != null) {
            webRTCEvents.onCumulativeDelayedInformationReport(byteBuffer, i3);
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0046. Please report as an issue. */
    @Override // com.tencent.gamematrix.gmcg.webrtc.PeerConnectionClient.PeerConnectionEvent
    public void handleInputMethod(ByteBuffer byteBuffer) {
        String str;
        int i3 = byteBuffer.getInt();
        if (i3 <= 268435456 && i3 > 0) {
            int i16 = byteBuffer.getInt();
            int i17 = byteBuffer.getInt();
            if (this.mInputMethodBuf == null) {
                this.mInputMethodBuf = new byte[i3];
                this.mInputMethodOffset = 0;
            }
            byte[] bArr = new byte[byteBuffer.capacity() - 17];
            byteBuffer.get(bArr);
            System.arraycopy(bArr, 0, this.mInputMethodBuf, this.mInputMethodOffset, i16);
            this.mInputMethodOffset += i16;
            if (i17 == 1) {
                String str2 = new String(this.mInputMethodBuf);
                onInputMethod(str2);
                switch (str2.hashCode()) {
                    case -2018531028:
                        str = "control:connected";
                        str2.equals(str);
                        break;
                    case -1231654983:
                        str = "imme:onCreate";
                        str2.equals(str);
                        break;
                    case -242992955:
                        str = "imme:onStartInput";
                        str2.equals(str);
                        break;
                    case 247635546:
                        str = "imme:onFinishInput";
                        str2.equals(str);
                        break;
                }
                this.mInputMethodBuf = null;
                this.mInputMethodOffset = 0;
                return;
            }
            return;
        }
        CGLog.i("handleInputMethod: Invalid dataLen: " + i3);
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.PeerConnectionClient.PeerConnectionEvent
    public void handlePassThrough(ByteBuffer byteBuffer) {
        int i3 = byteBuffer.getInt();
        if (i3 <= 268435456 && i3 > 0) {
            int i16 = byteBuffer.getInt();
            int i17 = byteBuffer.getInt();
            if (this.mPassThroughBuf == null) {
                this.mPassThroughBuf = new byte[i3];
                this.mPassThroughOffset = 0;
            }
            byte[] bArr = new byte[byteBuffer.capacity() - 17];
            byteBuffer.get(bArr);
            System.arraycopy(bArr, 0, this.mPassThroughBuf, this.mPassThroughOffset, i16);
            this.mPassThroughOffset += i16;
            if (i17 == 1) {
                byte[] bArr2 = this.mPassThroughBuf;
                if (bArr2[3] != 9 && bArr2[7] != 9) {
                    onPassThrough(new String(bArr2));
                } else {
                    CGLog.i("PassThrough: received photo open event");
                    onGalleryOpen();
                }
                this.mPassThroughBuf = null;
                this.mPassThroughOffset = 0;
                return;
            }
            return;
        }
        CGLog.i("handlePassThrough: Invalid dataLen: " + i3);
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.PeerConnectionClient.PeerConnectionEvent
    public void handlePriviledgeNotification(byte[] bArr) {
        int length = bArr.length - 5;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 5, bArr2, 0, length);
        onPriviledgeNotification(new String(bArr2));
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.PeerConnectionClient.PeerConnectionEvent
    public void handleTVScenesMonitor(ByteBuffer byteBuffer) {
        int i3 = byteBuffer.getInt();
        if (i3 <= 268435456 && i3 > 0) {
            int i16 = byteBuffer.getInt();
            int i17 = byteBuffer.getInt();
            if (this.mTVScenesMonitorBuf == null) {
                this.mTVScenesMonitorBuf = new byte[i3];
                this.mTVScenesMonitorOffset = 0;
            }
            byte[] bArr = new byte[byteBuffer.capacity() - 17];
            byteBuffer.get(bArr);
            System.arraycopy(bArr, 0, this.mTVScenesMonitorBuf, this.mTVScenesMonitorOffset, i16);
            this.mTVScenesMonitorOffset += i16;
            if (i17 == 1) {
                onTVScenesMonitor(new String(this.mTVScenesMonitorBuf));
                this.mTVScenesMonitorBuf = null;
                this.mTVScenesMonitorOffset = 0;
                return;
            }
            return;
        }
        CGLog.i("handleInputMethod: Invalid dataLen: " + i3);
    }

    public void kickOffline() {
        if (this.mSignalServerConnected && !this.mStopped) {
            this.mConnClient.sendKickMyself();
        }
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.ConnectionClient.SignalEvent
    public void onAnswerReceived(final JSONObject jSONObject) {
        logI("onAnswerReceived: " + jSONObject);
        if (this.mEnableTrace) {
            TraceCompat.beginSection("onAnswerReceived");
        }
        if (!this.mStopped) {
            this.mRtcExecutor.execute(new Runnable() { // from class: com.tencent.gamematrix.gmcg.webrtc.WebRTCClient.10
                @Override // java.lang.Runnable
                public void run() {
                    if (!WebRTCClient.this.mStopped && WebRTCClient.this.mPCClient != null) {
                        String optString = jSONObject.optString("sdp");
                        if (TextUtils.isEmpty(optString)) {
                            WebRTCClient.this.logE("onAnswerReceived sdp is empty");
                        } else {
                            CGLog.d("rtc answer:\n" + optString);
                            WebRTCClient.this.mPCClient.setRemoteSDP(optString);
                        }
                        WebRTCClient.f108096cs = WebRTCEvents.ConnectionState.STATE_OFFER_ANSWERED;
                        WebRTCClient.csd = WebRTCEvents.ConnectStateDisplay.STATE_ANSWER_RECIEVED;
                        WebRTCClient.this.mAnswerRecieved = true;
                        for (int i3 = 0; i3 < WebRTCClient.this.mIceCandidatesBeforeAnswer.size(); i3++) {
                            WebRTCClient webRTCClient = WebRTCClient.this;
                            webRTCClient.addIceCandidate((JSONObject) webRTCClient.mIceCandidatesBeforeAnswer.get(i3));
                        }
                    }
                }
            });
        }
        this.mAdoptQuicChannel = true;
        if (this.mEnableTrace) {
            TraceCompat.endSection();
        }
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.ConnectionClient.SignalEvent
    public void onChannelAck(String str) {
        try {
            WebRTCEvents webRTCEvents = this.mWebrtcEventObserver;
            if (webRTCEvents != null) {
                webRTCEvents.onEventChannelAck(str);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.ConnectionClient.SignalEvent
    public void onChannelData(String str) {
        try {
            WebRTCEvents webRTCEvents = this.mWebrtcEventObserver;
            if (webRTCEvents != null) {
                webRTCEvents.onEventChannelData(str);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.PeerConnectionClient.PeerConnectionEvent
    public void onChannelPong(String str) {
        WebRTCStatsCollector webRTCStatsCollector;
        try {
            long optLong = new JSONObject(str).optLong("data", 0L);
            if (optLong > 0 && (webRTCStatsCollector = this.mStatsCollector) != null) {
                webRTCStatsCollector.perfValue.dataChannelRtt = System.currentTimeMillis() - optLong;
            }
        } catch (Exception e16) {
            CGLog.w(e16.toString());
        }
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.ConnectionClient.SignalEvent
    public void onClientConfigReceived(final JSONObject jSONObject) {
        if (this.mEnableTrace) {
            TraceCompat.beginSection("onClientConfigReceived");
        }
        if (!this.mStopped && !this.mKeepSession) {
            this.mRtcExecutor.execute(new Runnable() { // from class: com.tencent.gamematrix.gmcg.webrtc.WebRTCClient.8
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (!WebRTCClient.this.mStopped && WebRTCClient.this.mPCClient != null) {
                            JSONObject jSONObject2 = new JSONObject();
                            if (jSONObject.has("peerConnectionOptions")) {
                                jSONObject2 = jSONObject.getJSONObject("peerConnectionOptions");
                            }
                            WebRTCClient.this.mPCClient.createPeerConnection(jSONObject2);
                            WebRTCClient.this.mPCClient.createDataChannel();
                            WebRTCClient.this.mPCClient.createOffer();
                        }
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                }
            });
            csd = WebRTCEvents.ConnectStateDisplay.STATE_CLIENTCONFIG_RECIEVED;
        }
        if (this.mEnableTrace) {
            TraceCompat.endSection();
        }
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.ConnectionClient.SignalEvent
    public void onConnected(boolean z16) {
        String str;
        String str2;
        String str3 = "true";
        if (this.mEnableTrace) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("GateConnected:");
            if (z16) {
                str2 = "true";
            } else {
                str2 = "false";
            }
            sb5.append(str2);
            TraceCompat.beginSection(sb5.toString());
        }
        StringBuilder sb6 = new StringBuilder();
        sb6.append("onConnected: !mStopped = ");
        if (!this.mStopped) {
            str = "true";
        } else {
            str = "false";
        }
        sb6.append(str);
        sb6.append(" connect = ");
        if (!z16) {
            str3 = "false";
        }
        sb6.append(str3);
        CGLog.i(sb6.toString());
        if (!this.mStopped) {
            if (z16) {
                this.mConnClient.sendUserConfig(this.mUserConfig);
                sendWebrtcConnectStatus();
            }
            this.mSignalServerConnected = z16;
            csd = WebRTCEvents.ConnectStateDisplay.STATE_SEND_USERCONFIG;
        }
        if (this.mEnableTrace) {
            TraceCompat.endSection();
        }
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.PeerConnectionClient.PeerConnectionEvent
    public void onConnectionChange(PeerConnection.PeerConnectionState peerConnectionState) {
        CGLog.i("onConnectionChange PeerConnectionState: " + peerConnectionState);
        if (peerConnectionState == PeerConnection.PeerConnectionState.CONNECTED) {
            if (this.mEnableTrace) {
                TraceCompat.beginSection("STATE_WEBRTC_CONNECTED");
            }
            this.mWebrtcEventObserver.onWebrtcStartUpProcess(GmCgDelayCounter.CGDelayLifeCycle.CGWebrtcSubProcessLifeCycle.SUB_PROCESS_LINK_WEBRTC, false);
            this.mWebrtcEventObserver.onWebrtcStartUpProcess(GmCgDelayCounter.CGDelayLifeCycle.CGWebrtcSubProcessLifeCycle.SUB_PROCESS_DECODE_RENDER, true);
            if (!this.mStopped) {
                this.mWebrtcEventObserver.onEventConnected(recvCandidate, this.mOptimalCarrier, this.mProprietaryFound);
                this.mPCConnected = true;
                this.mStatsReady = true;
                startRtcGetStats(WebRTCParameters.getSamplingStatsPeriod(), WebRTCParameters.getReportStatsPeriod());
                f108096cs = WebRTCEvents.ConnectionState.STATE_WEBRTC_CONNECTED;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("reserve2", "");
                } catch (JSONException e16) {
                    CGLog.e("Failed to put reserved2 into json, reason :" + e16);
                }
                sendSDKInfo(jSONObject);
            }
            if (this.mEnableTrace) {
                TraceCompat.endSection();
                return;
            }
            return;
        }
        if (peerConnectionState == PeerConnection.PeerConnectionState.DISCONNECTED) {
            this.mWebrtcEventObserver.onEventDisconnect();
            stopGetStat();
        } else if (peerConnectionState == PeerConnection.PeerConnectionState.FAILED) {
            CGLog.e("Webrtc connection failed");
            this.mWebrtcEventObserver.onEventConnectFailed(f108096cs, sessionId, recvCandidate);
            stopGetStat();
        } else if (peerConnectionState == PeerConnection.PeerConnectionState.CONNECTING) {
            this.mWebrtcEventObserver.onEventConnecting(recvCandidate, this.mOptimalCarrier, this.mProprietaryFound);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.PeerConnectionClient.PeerConnectionEvent
    public void onConnectionNotification(int i3, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i16 = jSONObject.getInt("event");
            int i17 = jSONObject.getInt(AudienceReportConst.CLIENT_TYPE);
            String string = jSONObject.getString("sessionID");
            String string2 = jSONObject.getString("id");
            CGLog.i("event = " + i16 + " clientType = " + i17 + " sessionId = " + string);
            try {
                WebRTCEvents webRTCEvents = this.mWebrtcEventObserver;
                if (webRTCEvents != null) {
                    webRTCEvents.onClientConnectionMsgData(i3, i17, string, string2, i16);
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        } catch (JSONException e17) {
            e17.printStackTrace();
        }
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.PeerConnectionClient.PeerConnectionEvent
    public void onCreateOfferSuccess(String str) {
        String str2;
        CGLog.d("rtc offer:\n" + str);
        if (this.mSignalServerConnected && !this.mStopped) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("type", mGmCgClientType.getValue());
                jSONObject.put("web_platform", "android");
                if (this.mImageQualityPreferred) {
                    jSONObject.put("image_quality_preferred", 1);
                } else {
                    jSONObject.put("image_quality_preferred", 0);
                }
                str2 = jSONObject.toString();
            } catch (Throwable th5) {
                CGLog.d("Generate connection description json failed: " + th5);
                str2 = "";
            }
            this.mConnClient.sendOffer(str, str2);
            csd = WebRTCEvents.ConnectStateDisplay.STATE_SEND_OFFER;
            WebRTCEvents webRTCEvents = this.mWebrtcEventObserver;
            if (webRTCEvents != null) {
                webRTCEvents.onEventOfferCreated(str);
            }
        }
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.PeerConnectionClient.PeerConnectionEvent
    public void onDataChannelConnected() {
        Location location;
        this.mDataChannelConnected = true;
        try {
            if (this.mEnableLm && (location = WebRTCSDK.mInitLoc) != null) {
                sendLocationEvent(location);
            }
            if (this.mWebrtcEventObserver != null) {
                String num = Integer.toString(new Random().nextInt(2147483646));
                int gmCgNetworkType = getGmCgNetworkType();
                String str = this.mOptimalCarrier;
                if (str == null) {
                    str = this.mPhoneCarrier;
                }
                getClientInfoAndRegisterConnection(1, mGmCgClientType.getValue(), sessionId, num, gmCgNetworkType, str);
                this.mWebrtcEventObserver.onEventDataChannelConnected();
                this.mWebrtcEventObserver.onEventDataChannelConnected(sessionId);
            }
            if (mEnableSeiExt) {
                sendEnableSeiExtension((short) 64);
            }
            if (VideoFilterController.get().isEnableCloudGameFullScreenVideo()) {
                CGLog.i("VideoFilter surfaceView_width=" + this.mSurfaceView.getWidth() + " surfaceView_height=" + this.mSurfaceView.getHeight());
                sendCloudGameWindowSize(VideoFilterController.get().getScreenDisplayWidth(), VideoFilterController.get().getScreenDisplayHeight());
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.PeerConnectionClient.PeerConnectionEvent
    public void onDataChannelDisconnected() {
        this.mDataChannelConnected = false;
        try {
            WebRTCEvents webRTCEvents = this.mWebrtcEventObserver;
            if (webRTCEvents != null) {
                webRTCEvents.onEventDataChannelDisconnected(sessionId);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.PeerConnectionClient.PeerConnectionEvent
    public void onDataChannelMessage(String str) {
        CGLog.i("OnDataChannelMessage: " + str);
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.PeerConnectionClient.PeerConnectionEvent
    public void onGalleryOpen() {
        try {
            WebRTCEvents webRTCEvents = this.mWebrtcEventObserver;
            if (webRTCEvents != null) {
                webRTCEvents.onEventGalleryOpen();
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.ConnectionClient.SignalEvent
    public void onGateReconnect() {
        CGLog.i("WebRTCClient onGateReconnect");
        try {
            WebRTCEvents webRTCEvents = this.mWebrtcEventObserver;
            if (webRTCEvents != null) {
                webRTCEvents.onGateReconnect();
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        this.mKeepSession = true;
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.PeerConnectionClient.PeerConnectionEvent
    public void onGpsSwitched(boolean z16) {
        WebRTCEvents webRTCEvents;
        try {
            if (this.mEnableLm && (webRTCEvents = this.mWebrtcEventObserver) != null) {
                webRTCEvents.onEventGpsSwitched(z16);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.PeerConnectionClient.PeerConnectionEvent
    public void onIceCandidate(String str, String str2, int i3) {
        if (this.mSignalServerConnected && !this.mStopped) {
            this.mConnClient.sendIceCandidate(str, str2, i3);
            csd = WebRTCEvents.ConnectStateDisplay.STATE_SEND_ICE;
        }
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.ConnectionClient.SignalEvent
    public void onIceCandidateReceived(final JSONObject jSONObject) {
        if (this.mEnableTrace) {
            TraceCompat.beginSection("onIceCandidateReceived");
        }
        logI("onIceCandidateReceived");
        if (!this.mStopped) {
            this.mRtcExecutor.execute(new Runnable() { // from class: com.tencent.gamematrix.gmcg.webrtc.WebRTCClient.9
                @Override // java.lang.Runnable
                public void run() {
                    if (!WebRTCClient.this.mStopped) {
                        if (WebRTCClient.this.mAnswerRecieved) {
                            WebRTCClient.this.logI("has received answer, add ice candidate");
                            WebRTCClient.this.addIceCandidate(jSONObject);
                        } else {
                            WebRTCClient.this.logI("not received answer, add to candidate list");
                            WebRTCClient.this.mIceCandidatesBeforeAnswer.add(jSONObject);
                        }
                    }
                }
            });
        }
        if (this.mEnableTrace) {
            TraceCompat.endSection();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008f A[Catch: Exception -> 0x0095, TRY_LEAVE, TryCatch #0 {Exception -> 0x0095, blocks: (B:8:0x002b, B:10:0x002f, B:21:0x006d, B:23:0x0076, B:26:0x0082, B:28:0x0089, B:30:0x008f, B:32:0x0045, B:35:0x0050, B:38:0x005b), top: B:7:0x002b }] */
    @Override // com.tencent.gamematrix.gmcg.webrtc.PeerConnectionClient.PeerConnectionEvent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onInputMethod(String str) {
        char c16;
        if (!this.mEnableIme) {
            CGLog.w("input method is closed!!!");
            return;
        }
        CGLog.i("onInputMethod: " + str + ", mEnableIme=" + this.mEnableIme);
        try {
            if (this.mWebrtcEventObserver != null) {
                int hashCode = str.hashCode();
                if (hashCode != -2018531028) {
                    if (hashCode != -242992955) {
                        if (hashCode == 247635546 && str.equals("imme:onFinishInput")) {
                            c16 = 1;
                            if (c16 == 0) {
                                if (c16 != 1) {
                                    if (c16 != 2) {
                                        if (str.startsWith("imme:cp:")) {
                                            this.mWebrtcEventObserver.onEventClipBoardDataRecved(str.substring(8));
                                            return;
                                        }
                                        return;
                                    }
                                    sendInputText("key:61");
                                    return;
                                }
                                this.mWebrtcEventObserver.onEventFinishInput();
                                return;
                            }
                            this.mWebrtcEventObserver.onEventStartInput();
                            return;
                        }
                        c16 = '\uffff';
                        if (c16 == 0) {
                        }
                    } else {
                        if (str.equals("imme:onStartInput")) {
                            c16 = 0;
                            if (c16 == 0) {
                            }
                        }
                        c16 = '\uffff';
                        if (c16 == 0) {
                        }
                    }
                } else {
                    if (str.equals("control:connected")) {
                        c16 = 2;
                        if (c16 == 0) {
                        }
                    }
                    c16 = '\uffff';
                    if (c16 == 0) {
                    }
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.ConnectionClient.SignalEvent
    public void onNetworkCarrier(Object... objArr) {
        if (this.mEnableTrace) {
            TraceCompat.beginSection("onNetworkCarrier");
        }
        if (!this.mStopped) {
            try {
                JSONObject jSONObject = new JSONObject(objArr[0].toString());
                this.mWebrtcproxyExternalIps = new JSONArray(jSONObject.getString("webrtcproxyExternalIps"));
                mQuicServerPort = jSONObject.getInt("webrtcQuicPort");
                identifyOptimalCandidate("onNetworkCarrier");
                String str = this.mOptimalCarrierIp;
                if (str != null) {
                    mQuicServerIp = str;
                } else {
                    mQuicServerIp = ((JSONObject) this.mWebrtcproxyExternalIps.get(0)).getString("ip");
                }
                CGLog.i("webrtcproxy portId = " + mQuicServerPort + " QuicServerIp  = " + mQuicServerIp);
                setQuicIPPort(mQuicServerIp, mQuicServerPort);
                if (this.mEnableQuic && this.mQuicClient != null && !this.mHasQuicConnection) {
                    this.mHasQuicConnection = true;
                    CgConfig cgConfig = new CgConfig();
                    cgConfig.mFecDataShards = (byte) 0;
                    cgConfig.mFecParityShards = (byte) 0;
                    cgConfig.mQuicVersion = 43;
                    cgConfig.mCongestionType = GmQuicCongestionType.QUICCUBICBYTES.getValue();
                    cgConfig.mConnectTimeoutMillis = 4000;
                    cgConfig.mIdleTimeoutMillis = 5000;
                    cgConfig.mPingIntervalMillis = 2000;
                    cgConfig.mLogLevel = this.mQuicLoggingLevel;
                    cgConfig.mFilePath = "";
                    CGLog.i("quicCfg.mLogLevel = " + cgConfig.mLogLevel);
                    this.mQuicClient.initialize(cgConfig);
                    this.mQuicClient.connect(mQuicServerIp, mQuicServerPort);
                }
            } catch (JSONException e16) {
                CGLog.w(e16.toString());
            } catch (Throwable th5) {
                CGLog.e(th5.toString());
            }
        }
        if (this.mEnableTrace) {
            TraceCompat.endSection();
        }
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.PeerConnectionClient.PeerConnectionEvent
    public void onPassThrough(String str) {
        try {
            JSONObject jSONObject = new JSONObject(new JSONObject(str).getString("body"));
            String string = jSONObject.getString("type");
            String string2 = jSONObject.getString("data");
            if (string.equals("channel-data")) {
                onChannelData(string2);
            } else if (string.equals("channel-ack")) {
                onChannelAck(string2);
            }
        } catch (Exception e16) {
            CGLog.w(e16.toString());
        }
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.PeerConnectionClient.PeerConnectionEvent
    public void onPriviledgeNotification(String str) {
        WebRTCEvents webRTCEvents = this.mWebrtcEventObserver;
        if (webRTCEvents != null) {
            webRTCEvents.onEventPriviledgeNotification(str);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.ConnectionClient.SignalEvent
    public void onSessionConnClose(int i3) {
        try {
            WebRTCEvents webRTCEvents = this.mWebrtcEventObserver;
            if (webRTCEvents != null) {
                webRTCEvents.onEventSessionConnClose(i3);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.ConnectionClient.SignalEvent
    public void onSessionError(int i3) {
        try {
            WebRTCEvents webRTCEvents = this.mWebrtcEventObserver;
            if (webRTCEvents != null) {
                webRTCEvents.onEventSessionError(i3);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.ConnectionClient.SignalEvent
    public void onSessionIdReceived(String str) {
        if (this.mEnableTrace) {
            TraceCompat.beginSection("onSessionIdReceived");
        }
        try {
            if (this.mSignalServerConnected && !this.mStopped) {
                this.mConnClient.sendStartBoard(str, String.valueOf(this.mDeviceConfig.getDeviceId()), this.mDeviceConfig.getControlKey(), this.mDeviceConfig.getIdentity());
                sessionId = str;
            }
            WebRTCEvents webRTCEvents = this.mWebrtcEventObserver;
            if (webRTCEvents != null) {
                webRTCEvents.onEventSessionIdReceived(str);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        csd = WebRTCEvents.ConnectStateDisplay.STATE_SESSIONID_RECIEVED;
        if (this.mEnableTrace) {
            TraceCompat.endSection();
        }
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.ConnectionClient.SignalEvent
    public void onSessionInfo(String str) {
        try {
            WebRTCEvents webRTCEvents = this.mWebrtcEventObserver;
            if (webRTCEvents != null) {
                webRTCEvents.onEventSessionInfo(str);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.PeerConnectionClient.PeerConnectionEvent
    public void onSetWebrtcNetworkBandWidth(int i3, String str) {
        double d16;
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i16 = jSONObject.getInt("bandwidth_bps");
            if (jSONObject.has("network_quality")) {
                d16 = jSONObject.getDouble("network_quality");
            } else {
                d16 = 5.0d;
            }
            WebRTCStatsCollector webRTCStatsCollector = this.mStatsCollector;
            if (webRTCStatsCollector != null) {
                PerfValue perfValue = webRTCStatsCollector.perfValue;
                perfValue.webrtcNetworkBandwidth = i16;
                perfValue.webrtcNetworkQuality = d16;
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    public void onTVScenesMonitor(String str) {
        try {
            WebRTCEvents webRTCEvents = this.mWebrtcEventObserver;
            if (webRTCEvents != null) {
                webRTCEvents.onEventChannelData(str);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.PeerConnectionClient.PeerConnectionEvent
    public void onVirtualGamepadEvent(int i3, int i16, String str) {
        try {
            WebRTCEvents webRTCEvents = this.mWebrtcEventObserver;
            if (webRTCEvents != null) {
                webRTCEvents.onVirtualGamepadMsgData(i3, i16, str);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.PeerConnectionClient.PeerConnectionEvent
    public void onVirtualGamepadParamsResp(byte[] bArr) {
        int i3 = 0;
        try {
            try {
                int i16 = ((bArr[5] & 255) << 24) | ((bArr[2] & 255) << 0) | ((bArr[3] & 255) << 8) | ((bArr[4] & 255) << 16);
                if (i16 > 256) {
                    onVirtualGamepadEvent(1, 2, null);
                    return;
                }
                try {
                    onVirtualGamepadEvent(1, 1, new String(bArr, 6, i16));
                } catch (Throwable th5) {
                    th = th5;
                    i3 = 1;
                    onVirtualGamepadEvent(1, i3, null);
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception unused) {
            onVirtualGamepadEvent(1, 3, null);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.PeerConnectionClient.PeerConnectionEvent
    public void onVirtualGamepadSdkData(byte[] bArr) {
        int i3;
        int i16;
        int i17;
        try {
            int i18 = ((bArr[2] & 255) << 0) | ((bArr[3] & 255) << 8) | ((bArr[4] & 255) << 16) | ((bArr[5] & 255) << 24);
            if (i18 >= 3 && i18 <= 256) {
                if (bArr[6] == 96) {
                    i3 = bArr[7] & 255;
                    try {
                        i16 = bArr[8] & 255;
                        if (i18 >= 4) {
                            try {
                                i17 = bArr[9] & 255;
                            } catch (Exception unused) {
                                onVirtualGamepadEvent(i3, 3, i16, 0);
                                return;
                            } catch (Throwable th5) {
                                th = th5;
                                onVirtualGamepadEvent(i3, 0, i16, 0);
                                throw th;
                            }
                        } else {
                            i17 = 0;
                        }
                    } catch (Exception unused2) {
                        i16 = 0;
                    } catch (Throwable th6) {
                        th = th6;
                        i16 = 0;
                    }
                } else {
                    i17 = 0;
                    i3 = 0;
                    i16 = 0;
                }
                onVirtualGamepadEvent(i3, 0, i16, i17);
                return;
            }
            onVirtualGamepadEvent(0, 2, 0, 0);
        } catch (Exception unused3) {
            i3 = 0;
            i16 = 0;
        } catch (Throwable th7) {
            th = th7;
            i3 = 0;
            i16 = 0;
        }
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.PeerConnectionClient.PeerConnectionEvent
    public void onVoiceSwitched(boolean z16) {
        try {
            WebRTCEvents webRTCEvents = this.mWebrtcEventObserver;
            if (webRTCEvents != null) {
                webRTCEvents.onEventVoiceSwitched(z16);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void passThroughData(String str) {
        byte[] bytes = str.getBytes();
        int length = bytes.length + 2;
        final ByteBuffer order = ByteBuffer.allocate(length + 5).order(ByteOrder.LITTLE_ENDIAN);
        order.put(0, (byte) 93);
        order.putInt(1, length);
        order.putShort(5, PASS_THROUGH_DATA);
        order.position(7);
        CGLog.i("data len=" + length + ", position=" + order.position() + ", byteBuffer.cap=" + order.capacity());
        order.put(bytes);
        order.position(0);
        ScheduledExecutorService scheduledExecutorService = this.mPeriodExecutorService;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.schedule(new Runnable() { // from class: com.tencent.gamematrix.gmcg.webrtc.WebRTCClient.3
                @Override // java.lang.Runnable
                public void run() {
                    WebRTCClient.this.sendMessageViaDataChannel(order);
                }
            }, 0L, TimeUnit.SECONDS);
        }
    }

    public void remoteMediaStreamTrackSetEnabled(boolean z16) {
        int i3;
        if (z16) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("cmd", i3);
            byte[] bytes = jSONObject.toString().getBytes();
            ByteBuffer order = ByteBuffer.allocate(bytes.length + 5).order(ByteOrder.LITTLE_ENDIAN);
            order.put(Constants.NOTIFICATION_BACKGROUND_PUSH_STREAM);
            order.putInt(bytes.length);
            order.put(bytes);
            order.position(0);
            sendMessageViaDataChannel(order);
        } catch (Exception unused) {
            CGLog.e("remoteMediaStreamTrackSetEnabled: " + z16);
        }
    }

    public void sendBatteryEvent(byte b16, byte b17, byte b18) {
        try {
            ByteBuffer order = ByteBuffer.allocate(10).order(ByteOrder.LITTLE_ENDIAN);
            order.put(0, (byte) 93);
            order.putInt(1, 5);
            order.putShort(5, BATTERY_EVENT);
            order.put(7, b16);
            order.put(8, b18);
            order.put(9, b17);
            order.position(10);
            CGLog.i("send battery event batteryLevel: " + ((int) b18));
            order.position(0);
            sendMessageViaDataChannel(order);
        } catch (Exception e16) {
            CGLog.e("send battery event " + e16);
        }
    }

    public void sendChannelAck(String str) {
        if (this.mEnablePassThrough) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("type", "channel-ack");
                jSONObject.put("data", str);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("body", jSONObject);
                ConnectionClient connectionClient = this.mConnClient;
                if (connectionClient instanceof WSClient) {
                    ((WSClient) connectionClient).generateMsgHeader(WSClient.CMD_CG_GAMEINFO, jSONObject2);
                }
                passThroughData(jSONObject2.toString());
                return;
            } catch (JSONException e16) {
                CGLog.e("sendChannelData error: " + e16);
                return;
            }
        }
        if (this.mSignalServerConnected && !this.mStopped) {
            this.mConnClient.sendChannelAck(str);
        }
    }

    public void sendChannelData(String str) {
        if (this.mEnablePassThrough) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("type", "channel-data");
                jSONObject.put("data", str);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("body", jSONObject);
                ConnectionClient connectionClient = this.mConnClient;
                if (connectionClient instanceof WSClient) {
                    ((WSClient) connectionClient).generateMsgHeader(WSClient.CMD_CG_GAMEINFO, jSONObject2);
                }
                passThroughData(jSONObject2.toString());
                return;
            } catch (JSONException e16) {
                CGLog.e("sendChannelData error: " + e16);
                return;
            }
        }
        if (this.mSignalServerConnected && !this.mStopped) {
            this.mConnClient.sendChannelData(str);
        }
    }

    public void sendCloudGameWindowSize(int i3, int i16) {
        try {
            ByteBuffer order = ByteBuffer.allocate(15).order(ByteOrder.LITTLE_ENDIAN);
            order.put(0, (byte) 93);
            order.putInt(1, 10);
            order.putShort(5, CLOUD_GAME_WINDOW_SIZE);
            order.putInt(7, i3);
            order.putInt(11, i16);
            order.position(15);
            CGLog.i("VideoFilter sendCloudGameWindowSize display_width=" + i3 + " display_height=" + i16);
            order.position(0);
            sendMessageViaDataChannel(order);
        } catch (Exception e16) {
            CGLog.e("VideoFilter sendCloudGameWindowSize: unsupported encoding " + e16);
        }
    }

    public void sendCommonTypeNotify(int i3, String str) {
        if (TextUtils.isEmpty(str)) {
            CGLog.w(TAG, "sendCommonTypeNotify data is empty!");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("cmd", i3);
            jSONObject.put("data", str);
            byte[] bytes = jSONObject.toString().getBytes();
            ByteBuffer order = ByteBuffer.allocate(bytes.length + 5).order(ByteOrder.LITTLE_ENDIAN);
            order.put(Byte.MAX_VALUE);
            order.putInt(bytes.length);
            order.put(bytes);
            order.position(0);
            sendMessageViaDataChannel(order);
        } catch (Exception unused) {
            CGLog.e("sendCommonTypeNotify data: " + str);
        }
    }

    public void sendEnableSeiExtension(short s16) {
        try {
            ByteBuffer order = ByteBuffer.allocate(9).order(ByteOrder.LITTLE_ENDIAN);
            order.put(0, (byte) 93);
            order.putInt(1, 4);
            order.putShort(5, ENABLE_SEI_EXTENSION);
            order.putShort(7, s16);
            order.position(9);
            CGLog.i("sendEnableSeiExtension ext bytes=" + ((int) s16));
            order.position(0);
            sendMessageViaDataChannel(order);
        } catch (Exception e16) {
            CGLog.e("sendInputText: unsupported encoding " + e16);
        }
    }

    public void sendInputText(String str) {
        try {
            byte[] bytes = str.getBytes("gbk");
            int length = bytes.length + 2;
            ByteBuffer order = ByteBuffer.allocate(length + 5).order(ByteOrder.LITTLE_ENDIAN);
            order.put(0, (byte) 93);
            order.putInt(1, length);
            order.putShort(5, SEND_INPUT_TEXT);
            order.position(7);
            CGLog.i("sendInputText: data len=" + length + ", position=" + order.position() + ", byteBuffer.cap=" + order.capacity());
            order.put(bytes);
            order.position(0);
            sendMessageViaDataChannel(order);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("sendInput:");
            sb5.append(str);
            CGLog.i(sb5.toString());
        } catch (UnsupportedEncodingException e16) {
            CGLog.e("sendInputText: unsupported encoding " + e16);
        }
    }

    public void sendLocationEvent(Location location) {
        ByteBuffer order = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        order.put(0, GameMsgGpsEvent);
        order.putInt(4, 0);
        order.putShort(8, (short) 0);
        double latitude = location.getLatitude();
        order.putDouble(16, latitude);
        double longitude = location.getLongitude();
        order.putDouble(24, longitude);
        double altitude = location.getAltitude();
        order.putDouble(32, altitude);
        float speed = location.getSpeed();
        order.putFloat(40, speed);
        float bearing = location.getBearing();
        order.putFloat(44, bearing);
        order.putFloat(48, LocationMonitor.getAccuracy(location));
        long time = location.getTime();
        order.putLong(56, time);
        CGLog.i("latitude:" + latitude + ", longitude:" + longitude + ", altitude:" + altitude + ", speed:" + speed + ", bearing:" + bearing + ", timestamp:" + time);
        sendMessageViaDataChannel(order);
    }

    public void sendMessageViaDataChannel(ByteBuffer byteBuffer) {
        sendMessageViaDataChannel(byteBuffer, true);
    }

    @Deprecated
    public void sendPerfData(ArrayList<String> arrayList, int i3, int i16, int i17) {
        int i18;
        if (this.mEnableSeiPerfReport && this.mSignalServerConnected && !this.mStopped) {
            WebRTCStatsCollector webRTCStatsCollector = this.mStatsCollector;
            if (webRTCStatsCollector != null) {
                i18 = (int) webRTCStatsCollector.perfValue.webrtcNetworkQuality;
            } else {
                i18 = 5;
            }
            this.mConnClient.sendPerfData(arrayList, i3, i16, i17, i18);
        }
    }

    public void sendPhoto(String str) {
        int read;
        int i3;
        File file = new File(str);
        byte[] bytes = file.getName().getBytes();
        byte[] bArr = new byte[61440];
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            long length = file.length();
            int i16 = 0;
            while (i16 < length && (read = fileInputStream.read(bArr)) != -1) {
                i16 += read;
                int length2 = bytes.length;
                if (i16 == length) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                int i17 = length2 + 14 + read;
                ByteBuffer order = ByteBuffer.allocate(i17 + 5).order(ByteOrder.LITTLE_ENDIAN);
                order.put(0, (byte) 93);
                order.putInt(1, i17);
                order.putShort(5, SEND_PHOTO_DATA);
                order.putInt(7, length2);
                order.putInt(11, read);
                order.putInt(15, i3);
                order.position(19);
                CGLog.i("data len=" + i17 + ", postion=" + order.position() + ", byteBuffer.cap=" + order.capacity());
                order.put(bytes);
                order.put(bArr, 0, read);
                order.position(0);
                sendMessageViaDataChannel(order);
            }
            fileInputStream.close();
        } catch (Exception e16) {
            CGLog.e("Failed to open: " + str + " " + e16);
        }
    }

    public void sendSDKInfo(final JSONObject jSONObject) {
        if (this.mPeriodExecutorService != null && this.mInit && !this.mStopped) {
            this.mPeriodExecutorService.execute(new Runnable() { // from class: com.tencent.gamematrix.gmcg.webrtc.WebRTCClient.7
                @Override // java.lang.Runnable
                public void run() {
                    String str;
                    String str2;
                    String str3;
                    String str4;
                    try {
                        jSONObject.put("identity", WebRTCClient.this.mDeviceConfig.getIdentity());
                        JSONObject jSONObject2 = jSONObject;
                        if (WebRTCClient.this.mWebRTCParameters.isHwDecode()) {
                            str = "hw";
                        } else {
                            str = "sw";
                        }
                        jSONObject2.put("decode", str);
                        jSONObject.put("sdkVersion", "3.0.0.241111110.3.9-SNAPSHOT");
                        JSONObject jSONObject3 = jSONObject;
                        if (WebRTCClient.this.mOptimalCarrierIp != null) {
                            str2 = WebRTCClient.this.mOptimalCarrierIp;
                        } else {
                            str2 = "";
                        }
                        jSONObject3.put("connectedWebrtcproxyIp", str2);
                        JSONObject jSONObject4 = jSONObject;
                        if (WebRTCClient.this.mOptimalCarrier != null) {
                            str3 = WebRTCClient.this.mOptimalCarrier;
                        } else {
                            str3 = "";
                        }
                        jSONObject4.put("connectedWebrtcproxyIpIsp", str3);
                        jSONObject.put("sdkIp", "");
                        jSONObject.put("sdkIpIsp", WebRTCClient.this.mPhoneCarrier);
                        jSONObject.put("videoStreamType", "");
                        jSONObject.put("reserve1", "android");
                        jSONObject.put("reserve3", WebRTCClient.this.getNetworkState());
                        if (!jSONObject.has("reserve4")) {
                            str4 = "";
                        } else {
                            str4 = (String) jSONObject.get("reserve4");
                        }
                        String str5 = ((((str4 + "gameid:" + WebRTCClient.this.mSessionCtx.pCgGameId + ";") + "bizno:" + WebRTCClient.this.mSessionCtx.pAppBizNo + ";") + "appchannel:" + WebRTCClient.this.mSessionCtx.pAppChannel + ";") + "clienttype:" + WebRTCClient.this.mSessionCtx.pGameClientType + ";") + "clientsource:" + WebRTCClient.this.mSessionCtx.pClientSource + ";";
                        if (WebRTCClient.this.mVideoCodecType != VideoCodecType.UNKNOWN) {
                            jSONObject.put("videoStreamType", "");
                            str5 = str5 + "codectype:" + WebRTCClient.this.mVideoCodecType.mimeType() + ";";
                            jSONObject.put("videoStreamType", WebRTCClient.this.mVideoCodecType.mimeType());
                        } else {
                            CGLog.i("codectype is UNKNOWN");
                        }
                        jSONObject.put("reserve4", str5);
                        jSONObject.put("reserve5", String.valueOf(WebRTCClient.this.mFirstFrameRenderDelay));
                        System.out.println(jSONObject.toString());
                        if (WebRTCClient.this.mConnClient != null) {
                            WebRTCClient.this.mConnClient.sendSdkInfo(jSONObject);
                        }
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                }
            });
        }
    }

    public void sendSeiData(byte[] bArr) {
        ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN);
        short s16 = order.getShort(44);
        if (s16 < 0) {
            return;
        }
        short s17 = order.getShort(16);
        byte b16 = order.get(19);
        int i3 = order.getInt(20);
        short s18 = order.getShort(28);
        short s19 = order.getShort(30);
        short s26 = order.getShort(40);
        short s27 = order.getShort(42);
        short s28 = order.getShort(50);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("encode_time", (int) s17);
            jSONObject.put("rgb_2_yuv", i3);
            jSONObject.put("recv_to_decode_latency", (int) s18);
            jSONObject.put("offset_to_render_start", (int) b16);
            jSONObject.put(ImageManagerEnv.MTA_VALUE_DECODE_TIME, (int) s19);
            jSONObject.put("decode_to_render_latency", (int) s26);
            jSONObject.put("render_time", (int) s27);
            jSONObject.put("recv_2_render", (int) s28);
            jSONObject.put("round_trip_latency", (int) s16);
            CGLog.i("Sei", jSONObject.toString());
            sendCommonTypeNotify(4, jSONObject.toString());
        } catch (JSONException e16) {
            CGLog.e("sendSeiData failed: " + e16);
        }
    }

    public void sendSensorEvent(CustomizedSensorEvent customizedSensorEvent) {
        int length = customizedSensorEvent.values.length;
        int i3 = 24;
        ByteBuffer order = ByteBuffer.allocate((length * 4) + 24).order(ByteOrder.LITTLE_ENDIAN);
        order.put(0, GameMsgSensorEvent);
        order.put(1, (byte) 0);
        order.put(2, (byte) 0);
        order.put(3, (byte) 0);
        order.putInt(4, customizedSensorEvent.sensor.getType());
        order.putInt(8, customizedSensorEvent.accuracy);
        order.putLong(12, customizedSensorEvent.timestamp);
        order.putInt(20, length);
        for (int i16 = 0; i16 < length; i16++) {
            order.putFloat(i3, customizedSensorEvent.values[i16]);
            i3 += 4;
        }
        sendMessageViaDataChannel(order, false);
    }

    public void sendTouchEvents(int i3, List<MobileButtonEvent> list) {
        this.mTouchEventSender.send(i3, list);
    }

    public void sendWebrtcConnectStatus() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        boolean z16 = spWebRTCClient.getBoolean("timeout", false);
        String identity = this.mDeviceConfig.getIdentity();
        String str6 = this.tmpDeviceId;
        String str7 = sessionId;
        if (this.mWebRTCParameters.isHwDecode()) {
            str = "hw";
        } else {
            str = "sw";
        }
        if (!z16) {
            str2 = "timeout";
            String str8 = str;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("identity", identity);
                str5 = str6;
                try {
                    jSONObject.put(com.tencent.bugly.common.constants.Constants.SP_DEVICE_ID, str5);
                    jSONObject.put("sessionId", str7);
                    jSONObject.put("webrtccode", 41130);
                    str4 = "3.0.0.241111110.3.9-SNAPSHOT";
                    try {
                        jSONObject.put("sdkVersion", str4);
                        str3 = str8;
                    } catch (JSONException e16) {
                        e = e16;
                        str3 = str8;
                    }
                    try {
                        jSONObject.put("decode", str3);
                        sendWebrtcConnectionStatus(jSONObject, str7);
                    } catch (JSONException e17) {
                        e = e17;
                        e.printStackTrace();
                        SharedPreferences.Editor edit = spWebRTCClient.edit();
                        edit.putBoolean(str2, false);
                        edit.putInt("webrtccode", 41130);
                        edit.putString(com.tencent.bugly.common.constants.Constants.SP_DEVICE_ID, str5);
                        edit.putString("sessionId", str7);
                        edit.putString("identity", identity);
                        edit.putString("sdkVersion", str4);
                        edit.putString("decode", str3);
                        edit.commit();
                    }
                } catch (JSONException e18) {
                    e = e18;
                    str3 = str8;
                    str4 = "3.0.0.241111110.3.9-SNAPSHOT";
                }
            } catch (JSONException e19) {
                e = e19;
                str3 = str8;
                str4 = "3.0.0.241111110.3.9-SNAPSHOT";
                str5 = str6;
            }
        } else {
            int i3 = spWebRTCClient.getInt("webrtccode", 41130);
            Object string = spWebRTCClient.getString("identity", null);
            str2 = "timeout";
            Object string2 = spWebRTCClient.getString(com.tencent.bugly.common.constants.Constants.SP_DEVICE_ID, null);
            String str9 = str;
            Object string3 = spWebRTCClient.getString("sessionId", null);
            Object string4 = spWebRTCClient.getString("sdkVersion", null);
            Object string5 = spWebRTCClient.getString("decode", null);
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("identity", string);
                jSONObject2.put(com.tencent.bugly.common.constants.Constants.SP_DEVICE_ID, string2);
                jSONObject2.put("sessionId", string3);
                jSONObject2.put("webrtccode", i3);
                jSONObject2.put("sdkVersion", string4);
                jSONObject2.put("decode", string5);
                sendWebrtcConnectionStatus(jSONObject2, str7);
            } catch (JSONException e26) {
                e26.printStackTrace();
            }
            str3 = str9;
            str4 = "3.0.0.241111110.3.9-SNAPSHOT";
            str5 = str6;
        }
        SharedPreferences.Editor edit2 = spWebRTCClient.edit();
        edit2.putBoolean(str2, false);
        edit2.putInt("webrtccode", 41130);
        edit2.putString(com.tencent.bugly.common.constants.Constants.SP_DEVICE_ID, str5);
        edit2.putString("sessionId", str7);
        edit2.putString("identity", identity);
        edit2.putString("sdkVersion", str4);
        edit2.putString("decode", str3);
        edit2.commit();
    }

    public void sendWebrtcConnectionStatus(JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("data", jSONObject.toString());
            jSONObject2.put("reportcmd", "webrtc_error_code");
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("cmd", WiFiPhotoErrorCode.ERR_FILEBRIDGE_NOT_FILE);
            jSONObject3.put("sessionId", str);
            jSONObject3.put("body", jSONObject2);
            ConnectionClient connectionClient = this.mConnClient;
            if (connectionClient != null) {
                connectionClient.sendSdkInfo(jSONObject3);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void setAudioVolume(double d16) {
        CGLog.i("Set audio volume" + d16);
        PeerConnectionClient peerConnectionClient = this.mPCClient;
        if (peerConnectionClient != null) {
            peerConnectionClient.setAudioVolume(d16);
        }
    }

    public void setFirstFrameRenderDelay(Long l3) {
        CGLog.i("setFirstFrameRenderDelay=" + l3);
        this.mFirstFrameRenderDelay = l3.longValue();
        f108096cs = WebRTCEvents.ConnectionState.STATE_FIRST_FRAME_RENDERED;
    }

    public void setImageQualityPreferred(boolean z16) {
        this.mImageQualityPreferred = z16;
        CGLog.i("setImageQualityPreferred : " + z16);
    }

    public void setNetworkCarrier(String str, boolean z16) {
        PeerConnectionClient peerConnectionClient;
        logI("setNetworkCarrier carrier: " + str + ", proprietary: " + z16);
        this.mProprietary = z16;
        this.mPhoneCarrier = str;
        identifyOptimalCandidate("setNetworkCarrier");
        String str2 = this.mOptimalCarrierIp;
        if (str2 != null && !this.mPrevOptimalCarrierIp.equals(str2)) {
            this.mPrevOptimalIceCandidate = this.mOptimalIceCandidate;
            this.mPrevOptimalCarrierIp = this.mOptimalCarrierIp;
            for (int i3 = 0; i3 < this.mRemoteIceCandidates.size(); i3++) {
                if (!this.mStopped) {
                    checkAndAddOptimalCandidate(this.mRemoteIceCandidates.get(i3));
                }
            }
            IceCandidate iceCandidate = this.mPrevOptimalIceCandidate;
            if (iceCandidate != this.mOptimalIceCandidate && iceCandidate != null && (peerConnectionClient = this.mPCClient) != null) {
                peerConnectionClient.removeRemoteIceCandidate(iceCandidate);
            }
        }
    }

    public void setPerfDataTag(int i3) {
        this.perfDataTag = i3;
    }

    public void setQuicLoggingLevel(int i3) {
        this.mQuicLoggingLevel = i3;
        CGLog.i(" WebRTCClient setQuicLoggingLevel level = " + this.mQuicLoggingLevel);
    }

    public void setVideoRender(SurfaceViewRenderer surfaceViewRenderer) {
        this.mSurfaceView = surfaceViewRenderer;
        PeerConnectionClient peerConnectionClient = this.mPCClient;
        if (peerConnectionClient != null) {
            peerConnectionClient.setVideoRender(surfaceViewRenderer);
        }
    }

    public void start() {
        logI("start WebRTCClient");
        this.mStopped = false;
        init();
        launchCheckPCConnectedTimerTask();
        if (this.mConnClient != null) {
            WebRTCEvents webRTCEvents = this.mWebrtcEventObserver;
            if (webRTCEvents != null) {
                webRTCEvents.onWebrtcStartUpProcess(GmCgDelayCounter.CGDelayLifeCycle.CGWebrtcSubProcessLifeCycle.SUB_PROCESS_GATE_LINK, true);
                mIsCandidateFound = false;
            }
            CGLog.i("mSplicedSignalServer: " + this.mSplicedSignalServer);
            this.mConnClient.connect(this.mSplicedSignalServer);
        }
    }

    public void stop() {
        CgQuicClient cgQuicClient;
        logI("stop WebRTCClient mStopped = " + this.mStopped);
        this.mStopped = true;
        this.mDataChannelConnected = false;
        this.mQuicChannelConnected = false;
        this.mHasQuicConnection = false;
        if (this.mEnableQuic && (cgQuicClient = this.mQuicClient) != null && cgQuicClient.getIsLoadLibrary()) {
            this.mQuicClient.close();
        }
        ConnectionClient connectionClient = this.mConnClient;
        if (connectionClient != null) {
            connectionClient.close();
        }
        if (this.mPCClient != null) {
            stopGetStat();
            this.mPCClient.close();
        }
        uninit();
        clearTouchEventCount();
    }

    public void switchOnAudio(boolean z16) {
        try {
            if (!this.mStopped && this.mPCConnected && this.mPCClient != null) {
                logI("switchOnAudio(" + z16 + ")");
                this.mPCClient.switchOnAudio(z16);
            } else {
                logI("mStopped=" + this.mStopped + " mPCConnected=" + this.mPCConnected + " mPCClient = " + this.mPCClient + " can't switchOnAudio(" + z16 + ")");
            }
        } catch (Exception e16) {
            CGLog.e("switchOnAudio(" + z16 + ") error: " + e16);
        }
    }

    public void switchOnVoice(boolean z16) {
        try {
            if (!this.mStopped && this.mPCConnected && this.mPCClient != null) {
                logI("switchOnVoice(" + z16 + ")");
                this.mPCClient.switchOnVoice(z16);
            } else {
                logI("mStopped=" + this.mStopped + " mPCConnected=" + this.mPCConnected + " mPCClient = " + this.mPCClient + " can't switchOnVoice(" + z16 + ")");
            }
        } catch (Exception e16) {
            CGLog.e("switchOnVoice(" + z16 + ") error: " + e16);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.PeerConnectionClient.PeerConnectionEvent
    public void switchSdkSendChannel(String str) {
        try {
            CGLog.i("switchSdkSendChannel = " + str);
            int i3 = new JSONObject(str).getInt("sdk_send_channel");
            if (i3 != 1) {
                if (i3 == 2) {
                    this.mEnableQuic = true;
                }
            } else {
                this.mEnableQuic = false;
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    public void switchToPreferredMode(int i3) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("cmd", i3);
            byte[] bytes = jSONObject.toString().getBytes();
            ByteBuffer order = ByteBuffer.allocate(bytes.length + 5).order(ByteOrder.LITTLE_ENDIAN);
            order.put(Constants.NOTIFICATION_BACKGROUND_PUSH_STREAM);
            order.putInt(bytes.length);
            order.put(bytes);
            order.position(0);
            sendMessageViaDataChannel(order);
        } catch (Exception unused) {
            CGLog.e("switch to preferred Mode: " + i3);
        }
    }

    WebRTCClient(Builder builder) {
        this.mSignalServerConnected = false;
        this.mEnableTrace = false;
        this.mPCConnected = false;
        this.mAnswerRecieved = false;
        this.mIceCandidatesBeforeAnswer = new ArrayList();
        this.mEnableKeepSession = false;
        this.mCustomizeDecoder = false;
        this.mEnableCmLog = false;
        this.perfDataTag = 0;
        this.mFirstFrameRenderDelay = -1L;
        this.mInit = false;
        this.mEnableVoice = false;
        this.mStatsReady = false;
        this.mUseOpenSles = true;
        this.mEnablePinchFace = false;
        this.mEnableRecordFile = false;
        this.mProprietaryFound = false;
        this.mMatchedCarrierFound = false;
        this.mTelecomCarrierFound = false;
        this.mOptimalIceCandidate = null;
        this.mPrevOptimalIceCandidate = null;
        this.mRemoteIceCandidates = new ArrayList();
        this.mProprietary = false;
        this.mEnablePassThrough = false;
        this.mEnableAudioDump = false;
        this.mTVScenesMonitorBuf = null;
        this.mTVScenesMonitorOffset = 0;
        this.mFlexFec = true;
        this.mAudioFec = true;
        this.mRsFec = true;
        this.mEnableFrameFeedback = true;
        this.mForceFastRender = true;
        this.mStopped = false;
        this.mKeepSession = false;
        this.mEnableSeiPerfReport = true;
        this.mVideoCodecType = VideoCodecType.UNKNOWN;
        this.mQuicChannelConnected = false;
        this.mAdoptQuicChannel = false;
        this.mHasQuicConnection = false;
        this.mLocalPath = "/sdcard/";
        this.mImageQualityPreferred = false;
        CGLog.i("build WebRTCClient");
        Context context = builder.ctx;
        this.mCtx = context;
        this.mSessionCtx = builder.sessionCtx;
        spWebRTCClient = context.getSharedPreferences("com.tencent.gamematrix.gmcg.webrtcdemo_preferences", 0);
        this.mSurfaceView = builder.surfaceView;
        this.mWebrtcEventObserver = builder.events;
        this.mDeviceConfig = builder.sessionCtx.pDeviceConfig;
        this.mEglBase = builder.eglBase;
        this.mWebRTCParameters = builder.sessionCtx.pWebRTCParameters;
        this.mSensorConfig = builder.sensorConfig;
        this.mPerfConfig = builder.perfConfig;
        this.mEnableVoice = builder.enableVoice;
        this.mUseOpenSles = builder.useOpenSles;
        this.mPhoneCarrier = builder.carrier;
        this.mPrevOptimalCarrierIp = "";
        this.mProprietary = builder.proprietary;
        this.mEnablePinchFace = builder.pinchFace;
        this.mEnableRecordFile = builder.enableRecordFile;
        this.mEnablePassThrough = builder.enablePassThrough;
        this.mEnableAudioDump = builder.enableAudioDump;
        this.mEnableLm = builder.enableLm;
        this.mEnableIme = builder.enableIme;
        this.mEnableQuic = builder.enableQuic;
        this.mQuicLoggingLevel = builder.quicLoggingLevel;
        this.mForceFastRender = builder.forceFastRender;
        this.mFlexFec = builder.enableFlexFec;
        this.mAudioFec = builder.enableAudioFec;
        this.mRsFec = builder.enableRsFec;
        this.mEnableFrameFeedback = builder.enableFrameFeedback;
        this.mEnableKeepSession = builder.enableKeepSession;
        this.mCustomizeDecoder = builder.customizeDecoder;
        this.mEnableCmLog = builder.enableCmLog;
        this.mDisableMediaEncryption = builder.disableMediaEncryption;
        this.mRtcExecutor = builder.rtcExecutor;
        this.mEnableSeiPerfReport = builder.enableSeiPerfReport;
        this.mDataChannelConnected = false;
        mIsCandidateFound = false;
        this.mTouchEventSender = new TouchEventSender(context, new TouchEventSender.Sender() { // from class: com.tencent.gamematrix.gmcg.webrtc.i
            @Override // com.tencent.gamematrix.gmcg.webrtc.TouchEventSender.Sender
            public final void send(int i3, List list) {
                WebRTCClient.this.doSendTouchEvents(i3, list);
            }
        });
        init();
    }

    public void sendMessageViaDataChannel(final ByteBuffer byteBuffer, boolean z16) {
        PeerConnectionClient peerConnectionClient;
        if (this.mEnableQuic && this.mQuicClient != null && this.mQuicChannelConnected) {
            this.mQuicClient.sendArray(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            return;
        }
        if (z16) {
            this.mRtcExecutor.execute(new Runnable() { // from class: com.tencent.gamematrix.gmcg.webrtc.WebRTCClient.2
                @Override // java.lang.Runnable
                public void run() {
                    if (WebRTCClient.this.mDataChannelConnected && WebRTCClient.this.mPCClient != null) {
                        WebRTCClient.this.mPCClient.sendMessageViaDataChannel(byteBuffer);
                    }
                }
            });
        } else {
            if (!this.mDataChannelConnected || (peerConnectionClient = this.mPCClient) == null) {
                return;
            }
            peerConnectionClient.sendMessageViaDataChannel(byteBuffer);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.PeerConnectionClient.PeerConnectionEvent
    public void onVirtualGamepadEvent(int i3, int i16, int i17, int i18) {
        try {
            WebRTCEvents webRTCEvents = this.mWebrtcEventObserver;
            if (webRTCEvents != null) {
                webRTCEvents.onVirtualGamepadMsgData(i3, i16, i17, i18);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.ConnectionClient.SignalEvent
    public void onClientCountReceived(int i3) {
    }
}
