package com.tencent.gamematrix.gmcg.webrtc;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.core.os.TraceCompat;
import androidx.core.view.MotionEventCompat;
import com.android.volley.VolleyError;
import com.android.volley.h;
import com.heytap.databaseengine.apiv3.data.Element;
import com.heytap.databaseengine.type.DeviceType;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.gamematrix.gmcg.base.delaycount.GmCgDelayCounter;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmcg.base.network.CGGsonBodyRequest;
import com.tencent.gamematrix.gmcg.base.network.CGHttpReqManager;
import com.tencent.gamematrix.gmcg.base.utils.CGDisplayUtil;
import com.tencent.gamematrix.gmcg.base.utils.CGSystemUtil;
import com.tencent.gamematrix.gmcg.webrtc.BatteryBroadcastReceiver;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCClient;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCEvents;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.GamepadEventManage;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.GamepadKeyEvent;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.GamepadMotionEvent;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.hidusb.IHIDSensorManager;
import com.tencent.gamematrix.gmcg.webrtc.monitor.CGTdmDataReport;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.medialab.video.decoder.VDecoder;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.qmethod.pandoraex.monitor.LocationMonitor;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import cooperation.qzone.remote.ServiceConst;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.coroutines.DebugKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.tencwebrtc.DefaultVideoDecoderFactory;
import org.tencwebrtc.EglBase;
import org.tencwebrtc.EglRenderer;
import org.tencwebrtc.Logging;
import org.tencwebrtc.RendererCommon;
import org.tencwebrtc.SurfaceViewRenderer;
import org.tencwebrtc.VideoDecoder;
import org.tencwebrtc.VideoSR;

/* compiled from: P */
/* loaded from: classes6.dex */
public class WebRTCSDK {
    private static final String CMD_INPUT_SET_CGINPUT = "set";
    private static final int DETECT_PERIOD_MS = 2000;
    private static final int DETECT_WINDOW_SIZE = 8;
    public static final String ENCODER_FRAMERATE = "fps";
    public static final String ENCODER_RESOLUTION = "resolution";
    public static final String ENCODER_SOFTWARE_ENCODE = "software_encode";
    public static final String ENCODER_USE_AUDIO = "use_audio";
    public static final String IP_TAG = "ip";
    private static final String KEY_ENCODER_PROPERTY = "property";
    private static final String KEY_RIGHTS_SUBSCRIBE = "SubscribeMutexRights";
    private static final String KEY_RIGHTS_UNSUBSCRIBE = "UnSubscribeMutexRights";
    private static final String KEY_RIGHTS_UPDATE = "rights";
    private static final int LATENCY_MAX_SECONDS = 460;
    private static final int LATENCY_THRESHOLD_120 = 120;
    private static final int LATENCY_THRESHOLD_150 = 150;
    public static final String PASS_WEBRTC_PERF_STATS = "pass_webrtc_perf_stats";
    private static final String PREFIX_CLIPBOARD = "cp:";
    private static final String PREFIX_INPUT_CMD = "cmd:";
    private static final String PREFIX_INPUT_HEIGHT = "height:";
    private static final String PREFIX_INPUT_KEY = "key:";
    private static final String PREFIX_INPUT_TEXT = "imme:";
    public static final String PRIVILEGE_AUDIO_INPUT = "audio_input";
    public static final String PRIVILEGE_CLOUD_PHOTO = "cloudphoto";
    public static final String PRIVILEGE_GPS = "gps";
    public static final String PRIVILEGE_INPUT_METHOD = "input_method";
    public static final String PRIVILEGE_PASSTHROUGH = "passthrough";
    public static final String PRIVILEGE_SENSOR = "sensor";
    public static final String PRIVILEGE_TOUCH = "touch";
    public static final String PRIVILEGE_VIRTUAL_PAD = "virtual_pad";
    public static final String PROVINCE_TAG = "province";
    public static final String QOS_STATE = "qosState";
    public static final String QOS_TAG = "qosTag";
    public static final String QOS_UUID = "qosUuid";
    private static final int SERVER_CONNECTION_WAIT_DELAY_TIME = 50;
    private static final int SERVER_CONNECTION_WAIT_TIMES = 100;
    private static final int STUTTER_CNT_LIMIT = 5;
    private static final int SUBSCRIBE_PRIVILEGE = 100;
    private static final String TAG = "WebRTCSDK";
    private static final int UNSUBSCRIBE_PRIVILEGE = 101;
    private static final int VG_REGISTRATION_NOTIFICATION = 106;
    private static final int WEBRTC_CONFIG = 90;
    private static boolean mAudioFec = true;
    public static int mContainerOrientation = 0;
    private static boolean mCustomizeDecoder = false;
    public static int mDegree = 0;
    private static boolean mEnableCmLog = false;
    private static boolean mEnableFrameFeedback = true;
    private static boolean mEnableKeepSession = false;
    private static boolean mEnableLm = false;
    private static boolean mEnablePerfReport = true;
    private static boolean mEnableQuic = false;
    private static boolean mEnableSeiPerfReport = true;
    private static boolean mFlexFec = true;
    private static boolean mForceFastRender = false;
    public static int mHeight = 0;
    private static boolean mHidSensor = false;
    static Location mInitLoc = null;
    private static boolean mRsFec = true;
    private static boolean mSkipRender = false;
    public static int mWidth;
    private BatteryBroadcastReceiver mBatteryBroadcastReceiver;
    private Context mCtx;
    private double mCurrAudioVolume;
    private DeviceConfig mDeviceConfig;
    private boolean mDisableMediaEncryption;
    private EglBase mEglBase;
    private boolean mEnableTrace;
    private Handler mHandler;
    private HandlerThread mHandlerThread;
    private IHIDSensorManager mHidSm;
    LocationListener mLocationListener;
    private LocationManager mLocationManager;
    private String mNetworkCarrier;
    private int mPacketsLost;
    private int mPacketsRecved;
    PerfMonitorConfig mPerfConfig;
    private ScheduledExecutorService mPeriodExecutorService;
    private int mRtt;
    private final SensorConfig mSensorCfg;
    private int mSensorNum;
    private final int[] mSensors;
    private final CGSessionCtx mSessionCtx;
    private SensorManager mSm;
    private float mSoftKeyBoardHeightRatio;
    private final int[] mStutter;
    private final long[] mStutterTime;
    private SurfaceViewRenderer mSurfaceView;
    private TextureViewRenderer mTextureView;
    private final WebRTCParameters mWebRTCParameters;
    private WebRTCEvents mWebrtcEventObserver;
    SensorEventListener sensorEvtListener;
    private ScheduledFuture<?> softInputScheduled;
    private WebRTCClient mWebRTCClient = null;
    private long mStartTimestampInMs = 0;
    private long mFirstFrameRenderDelay = 0;
    private boolean mFirstFrameRendered = false;
    private final AtomicBoolean mStarted = new AtomicBoolean(false);
    private final ExecutorService mRTCExecutor = ProxyExecutors.newSingleThreadExecutor();
    private final int mMaxSensors = 35;
    private boolean mStartSensor = false;
    private boolean mLmSwitchedOn = false;
    private boolean mEnableVoice = false;
    private boolean mEnablePinchFace = false;
    private boolean mEnableOpenSles = true;
    private boolean mEnableRecordFile = false;
    private boolean mEnablePassThrough = true;
    private boolean mEnableIme = false;
    private final ArrayList<String> mPerfArray = new ArrayList<>();
    private final ArrayList<String> mPerfArrayForStutterAnalysis = new ArrayList<>();
    private int mLastEncodeNum = 0;
    private long mLastEncodeTimestamp = 0;
    private int mLastDisplayNum = 0;
    private int mCurDisplayNum = 0;
    boolean mEnableStutterDetect = false;
    private int mPerfTimeInSec = 0;
    private int mIntervalInSec = 1;
    private int mStutterCnt = 0;
    private final int LATENCY_WINDOW_SIZE = 3;
    private long mLastShowTimeStamp = 0;
    private long mLastEncodeTs = 0;
    private int mQuicLoggingLevel = GmCgQuicLogSeverity.ERROR.getValue();
    private boolean mProprietary = false;
    private final int MSG_WHAT_TOUCH = 1;
    private final int MSG_WHAT_START_GPS = 2;
    private final int MSG_WHAT_STOP_GPS = 3;
    private final int MSG_WHAT_SENSOR_EVENT = 4;
    private final int MSG_WHAT_SWITCH_VOICE = 5;
    private final int MSG_WHAT_SWITCH_AUDIO = 6;
    private final int MSG_WHAT_SEND_INPUT = 7;
    private final int MSG_WHAT_SIGNAL_SERVER_CONNECTION = 8;
    private final int MSG_WHAT_APP_RESTART = 9;
    private boolean mKeepConnection = false;
    private boolean mEnableAudioDump = false;
    private int mSensorSign = 1;
    private boolean mSoftKeyBoardHeightInitialized = false;
    private AudioManager mAudioManager = null;
    private int mPerfInvokedCount = 0;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class PerfMonitorConfig {
        public PerfMonitorConfig() {
        }

        private long latencyAnalysis(ArrayList<String> arrayList) {
            long j3;
            try {
                int size = arrayList.size();
                long j16 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    ByteBuffer wrap = ByteBuffer.wrap(Base64.decode(arrayList.get(i3), 2));
                    wrap.order(ByteOrder.BIG_ENDIAN);
                    long j17 = wrap.getLong(8);
                    long j18 = wrap.getLong(32);
                    short s16 = wrap.getShort(40);
                    short s17 = wrap.getShort(42);
                    short s18 = wrap.getShort(44);
                    if (s18 > 0) {
                        WebRTCSDK.this.mWebRTCClient.getPerfValue().roundTripLatency = s18;
                    }
                    long j19 = j18 + s16 + s17;
                    j3 = 0;
                    if (WebRTCSDK.this.mLastShowTimeStamp != 0) {
                        try {
                            long j26 = j19 - WebRTCSDK.this.mLastShowTimeStamp;
                            long j27 = j17 - WebRTCSDK.this.mLastEncodeTs;
                            if (j26 >= 150 && j26 > j27 + 120) {
                                j16 += j26;
                            }
                        } catch (Exception e16) {
                            e = e16;
                            e.printStackTrace();
                            return j3;
                        }
                    }
                    WebRTCSDK.this.mLastShowTimeStamp = j19;
                    WebRTCSDK.this.mLastEncodeTs = j17;
                }
                j3 = 0;
                if (size < 1) {
                    j16 = 460;
                }
                int i16 = 0;
                for (int length = WebRTCSDK.this.mStutterTime.length - 1; length > 0; length--) {
                    WebRTCSDK.this.mStutterTime[length] = WebRTCSDK.this.mStutterTime[length - 1];
                    i16 = (int) (i16 + WebRTCSDK.this.mStutterTime[length]);
                }
                WebRTCSDK.this.mStutterTime[0] = j16;
                return ((int) (i16 + WebRTCSDK.this.mStutterTime[0])) / 3;
            } catch (Exception e17) {
                e = e17;
                j3 = 0;
            }
        }

        public long collectPerf(int i3) {
            try {
                WebRTCSDK.this.mPerfTimeInSec += i3;
                if (!WebRTCSDK.mEnablePerfReport) {
                    return 0L;
                }
                if (WebRTCSDK.this.mWebRTCClient != null) {
                    WebRTCSDK webRTCSDK = WebRTCSDK.this;
                    webRTCSDK.mRtt = (int) webRTCSDK.mWebRTCClient.getPerfValue().rtt;
                    WebRTCSDK webRTCSDK2 = WebRTCSDK.this;
                    webRTCSDK2.mPacketsLost = webRTCSDK2.mWebRTCClient.getPerfValue().packetsLost;
                    WebRTCSDK webRTCSDK3 = WebRTCSDK.this;
                    webRTCSDK3.mPacketsRecved = (int) webRTCSDK3.mWebRTCClient.getPerfValue().packetsReceived;
                }
                if (WebRTCSDK.this.mWebRTCClient != null && WebRTCSDK.this.mPerfArray != null) {
                    synchronized (WebRTCSDK.this.mPerfArray) {
                        WebRTCSDK.this.mPerfArrayForStutterAnalysis.addAll(WebRTCSDK.this.mPerfArray);
                        WebRTCSDK.this.mPerfArray.clear();
                    }
                }
                WebRTCSDK webRTCSDK4 = WebRTCSDK.this;
                if (webRTCSDK4.mEnableStutterDetect) {
                    webRTCSDK4.stutterDetect(webRTCSDK4.mPerfArrayForStutterAnalysis);
                    long latencyAnalysis = latencyAnalysis(WebRTCSDK.this.mPerfArrayForStutterAnalysis);
                    WebRTCSDK.this.mPerfArrayForStutterAnalysis.clear();
                    return latencyAnalysis;
                }
                return 0L;
            } catch (Exception e16) {
                e16.printStackTrace();
                return 0L;
            }
        }

        public void onPerfMonitorConfig(int i3) {
            CGLog.i("Perf interval in second: " + i3);
            if (i3 <= 0) {
                return;
            }
            if (i3 > 60) {
                WebRTCSDK.this.mIntervalInSec = 60;
            } else {
                WebRTCSDK.this.mIntervalInSec = i3;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class SensorConfig {
        public SensorConfig() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void onSensorConfig(JSONObject jSONObject) {
            int i3;
            int[] iArr = new int[3];
            int i16 = 0;
            try {
                if (jSONObject.getInt("accelerometer") == 1) {
                    try {
                        iArr[0] = 1;
                        i16 = 1;
                    } catch (JSONException unused) {
                        i16 = 1;
                        CGLog.e("Failed to extract sensor config " + jSONObject);
                        WebRTCSDK.this.registerSensors(i16, iArr);
                    }
                }
                if (jSONObject.getInt("gyroscope") == 1) {
                    i3 = i16 + 1;
                    try {
                        iArr[i16] = 4;
                        i16 = i3;
                    } catch (JSONException unused2) {
                        i16 = i3;
                        CGLog.e("Failed to extract sensor config " + jSONObject);
                        WebRTCSDK.this.registerSensors(i16, iArr);
                    }
                }
                if (jSONObject.getInt(LayoutAttrDefine.Gravity.Gravity) == 1) {
                    i3 = i16 + 1;
                    iArr[i16] = 9;
                    i16 = i3;
                }
            } catch (JSONException unused3) {
            }
            WebRTCSDK.this.registerSensors(i16, iArr);
        }
    }

    public WebRTCSDK(Context context, CGSessionCtx cGSessionCtx, SurfaceViewRenderer surfaceViewRenderer, WebRTCEvents webRTCEvents) {
        this.mEnableTrace = false;
        this.mCtx = context;
        this.mSessionCtx = cGSessionCtx;
        this.mSurfaceView = surfaceViewRenderer;
        if (surfaceViewRenderer != null) {
            this.mWebrtcEventObserver = webRTCEvents;
            WebRTCParameters webRTCParameters = cGSessionCtx.pWebRTCParameters;
            this.mWebRTCParameters = webRTCParameters;
            this.mDeviceConfig = cGSessionCtx.pDeviceConfig;
            this.mSensors = new int[35];
            this.mSensorCfg = new SensorConfig();
            this.mPerfConfig = new PerfMonitorConfig();
            this.mStutter = new int[8];
            this.mStutterTime = new long[3];
            FilterSurfaceViewRenderer.setVideoFilterParams(cGSessionCtx.pWebRTCParameters.isHwDecode(), cGSessionCtx.pWebRTCParameters.getVideofilterParams());
            if (cGSessionCtx.pWebRTCParameters.isEnableGetBatteryInfo()) {
                syncBatteryInfoToServer();
            }
            EglRenderer.enableLogToDebugOutput(WebRTCParameters.isEnableLogToDebugOutput());
            if (!webRTCParameters.isHwDecode()) {
                CGLog.i("Force mSkipRender to false for sw decode");
                mSkipRender = false;
            }
            this.mCurrAudioVolume = webRTCParameters.getCurrAudioVolume();
            if (webRTCParameters.getLoggingSeverity() == Logging.Severity.LS_VERBOSE) {
                this.mEnableTrace = true;
            }
            try {
                if (cGSessionCtx.pEnableTdmReport) {
                    CGTdmDataReport.init(context);
                }
            } catch (Throwable unused) {
                CGLog.e("failed to init CGTdmDataReport");
            }
            initVideoRenderView();
            initTouchHandlerThread();
            initCgInput(context);
            return;
        }
        throw new IllegalArgumentException("SurfaceViewRenderer must not be null!");
    }

    static /* synthetic */ int access$3908(WebRTCSDK webRTCSDK) {
        int i3 = webRTCSDK.mPerfInvokedCount;
        webRTCSDK.mPerfInvokedCount = i3 + 1;
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkFirstFrameRendered(final String str) {
        if (this.mPeriodExecutorService == null) {
            CGLog.w("mPeriodExecutorService is null, can't checkFirstFrameRendered");
            return;
        }
        CGLog.i("checkFirstFrameRendered " + str + " begin");
        try {
            this.mPeriodExecutorService.schedule(new Runnable() { // from class: com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK.5
                @Override // java.lang.Runnable
                public void run() {
                    CGLog.i("checkFirstFrameRendered " + str + " " + WebRTCClient.f108096cs + ", " + WebRTCSDK.this.mFirstFrameRendered + " end! ");
                    if ((WebRTCClient.f108096cs == WebRTCEvents.ConnectionState.STATE_WEBRTC_CONNECTED || WebRTCClient.f108096cs == WebRTCEvents.ConnectionState.STATE_ICE_COMPLETED) && !WebRTCSDK.this.mFirstFrameRendered) {
                        String onStreamingFail = SummaryLog.get().onStreamingFail(WebRTCSDK.this.mSessionCtx);
                        if (onStreamingFail != null) {
                            WebRTCSDK.this.sendChannelDataToRemoteClient(3, onStreamingFail);
                        }
                        CGLog.e((WebRTCSDK.this.mWebRTCParameters.getConnectionTimeOut() + 5) + " seconds timeout, mFirstFrameRendered is not set");
                        if (WebRTCSDK.this.mWebrtcEventObserver != null) {
                            WebRTCSDK.this.mWebrtcEventObserver.onEventConnectFailed(WebRTCClient.f108096cs, WebRTCClient.sessionId, WebRTCClient.recvCandidate);
                        }
                    }
                }
            }, this.mWebRTCParameters.getConnectionTimeOut() + 5, TimeUnit.SECONDS);
        } catch (Exception e16) {
            CGLog.e("checkFirstFrameRendered error: " + e16.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean consumeLocationEvent(Location location) {
        try {
            WebRTCClient webRTCClient = this.mWebRTCClient;
            if (webRTCClient != null) {
                webRTCClient.sendLocationEvent(location);
                return true;
            }
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean consumeSensorEvent(CustomizedSensorEvent customizedSensorEvent) {
        try {
            WebRTCClient webRTCClient = this.mWebRTCClient;
            if (webRTCClient != null) {
                webRTCClient.sendSensorEvent(customizedSensorEvent);
                return true;
            }
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x001f, code lost:
    
        if (r1 != 6) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006e A[Catch: Exception -> 0x007e, TryCatch #0 {Exception -> 0x007e, blocks: (B:3:0x0001, B:17:0x0068, B:19:0x006e, B:21:0x0072, B:44:0x0057, B:45:0x005f), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean consumeTouchEvent(MotionEvent motionEvent) {
        int actionMasked;
        int pointerCount;
        ArrayList arrayList;
        WebRTCClient webRTCClient;
        boolean z16;
        try {
            actionMasked = MotionEventCompat.getActionMasked(motionEvent);
            pointerCount = MotionEventCompat.getPointerCount(motionEvent);
            arrayList = new ArrayList();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                try {
                    if (actionMasked != 2) {
                        if (actionMasked != 3) {
                            if (actionMasked != 5) {
                            }
                        } else {
                            for (int i3 = 0; i3 < pointerCount; i3++) {
                                arrayList.add(processTouchEvent(motionEvent, 81, i3, true));
                                WebRTCClient webRTCClient2 = this.mWebRTCClient;
                                if (webRTCClient2 != null) {
                                    webRTCClient2.sendTouchEvents(((MobileButtonEvent) arrayList.get(0)).msgType, arrayList);
                                }
                                arrayList.clear();
                            }
                        }
                    } else {
                        for (int i16 = 0; i16 < pointerCount; i16++) {
                            if (i16 == pointerCount - 1) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            arrayList.add(processTouchEvent(motionEvent, 82, i16, z16));
                        }
                    }
                } catch (Exception unused) {
                }
                if (arrayList.size() > 0 && (webRTCClient = this.mWebRTCClient) != null) {
                    webRTCClient.sendTouchEvents(((MobileButtonEvent) arrayList.get(0)).msgType, arrayList);
                }
                return true;
            }
            arrayList.add(processTouchEvent(motionEvent, 81));
            if (arrayList.size() > 0) {
                webRTCClient.sendTouchEvents(((MobileButtonEvent) arrayList.get(0)).msgType, arrayList);
            }
            return true;
        }
        arrayList.add(processTouchEvent(motionEvent, 80));
        if (arrayList.size() > 0) {
        }
        return true;
    }

    public static void customizeDecoder(boolean z16) {
        mCustomizeDecoder = z16;
        CGLog.i("customizeDecoder: " + z16);
    }

    public static void enableAudioFec(boolean z16) {
        mAudioFec = z16;
    }

    public static void enableCmLog(boolean z16) {
        mEnableCmLog = z16;
    }

    public static void enableFlexFec(boolean z16) {
        mFlexFec = z16;
    }

    public static void enableFrameFeedback(boolean z16) {
        mEnableFrameFeedback = z16;
    }

    public static void enableHidSensor(boolean z16) {
        mHidSensor = z16;
    }

    public static void enableIPv6OnlyFix(boolean z16) {
        PeerConnectionClient.mEnableIpv6OnlyFix = z16;
        CGLog.i("enableIPv6OnlyFix: " + z16);
    }

    public static void enableKeepSession(boolean z16) {
        CGLog.i("enableKeepSession " + z16);
        mEnableKeepSession = z16;
    }

    public static void enableQuic(boolean z16) {
        CGLog.i("mEnableQuic " + z16);
        mEnableQuic = z16;
    }

    public static void enableRsFec(boolean z16) {
        mRsFec = z16;
    }

    public static void enableSeiExtension(boolean z16) {
        WebRTCClient.enableSeiExtension(z16);
        CGLog.i("enableSeiExtension");
    }

    public static void enableSeiPerfReport(boolean z16) {
        mEnableSeiPerfReport = z16;
        CGLog.i("Enable sei perf report: " + z16);
    }

    public static void enableTouchInterpolation(boolean z16) {
        TouchEventSender.isEnableTouchInterpolate = z16;
    }

    private String fillPrividge(JSONObject jSONObject) {
        String str;
        String str2 = "";
        try {
            if (!jSONObject.has(PRIVILEGE_CLOUD_PHOTO) || jSONObject.get(PRIVILEGE_CLOUD_PHOTO) != "1") {
                str = "";
            } else {
                str = "" + PRIVILEGE_CLOUD_PHOTO;
            }
            try {
                if (jSONObject.has(PRIVILEGE_INPUT_METHOD) && jSONObject.get(PRIVILEGE_INPUT_METHOD) == "1") {
                    if (!str.equals("")) {
                        str = str + ",";
                    }
                    str = str + PRIVILEGE_INPUT_METHOD;
                }
                if (jSONObject.has(PRIVILEGE_AUDIO_INPUT) && jSONObject.get(PRIVILEGE_AUDIO_INPUT) == "1") {
                    if (!str.equals("")) {
                        str = str + ",";
                    }
                    str = str + PRIVILEGE_AUDIO_INPUT;
                }
                if (jSONObject.has("gps") && jSONObject.get("gps") == "1") {
                    if (!str.equals("")) {
                        str = str + ",";
                    }
                    str = str + "gps";
                }
                if (jSONObject.has(PRIVILEGE_SENSOR) && jSONObject.get(PRIVILEGE_SENSOR) == "1") {
                    if (!str.equals("")) {
                        str = str + ",";
                    }
                    str = str + PRIVILEGE_SENSOR;
                }
                if (jSONObject.has(PRIVILEGE_VIRTUAL_PAD) && jSONObject.get(PRIVILEGE_VIRTUAL_PAD) == "1") {
                    if (!str.equals("")) {
                        str = str + ",";
                    }
                    str = str + PRIVILEGE_VIRTUAL_PAD;
                }
                if (jSONObject.has(PRIVILEGE_TOUCH) && jSONObject.get(PRIVILEGE_TOUCH) == "1") {
                    if (!str.equals("")) {
                        str = str + ",";
                    }
                    str = str + PRIVILEGE_TOUCH;
                }
                if (jSONObject.has(PRIVILEGE_PASSTHROUGH) && jSONObject.get(PRIVILEGE_PASSTHROUGH) == "1") {
                    if (!str.equals("")) {
                        str2 = str + ",";
                    } else {
                        str2 = str;
                    }
                    return str2 + PRIVILEGE_PASSTHROUGH;
                }
                return str;
            } catch (Exception e16) {
                e = e16;
                str2 = str;
                CGLog.e("Failed to fillPrividge, cause " + e);
                return str2;
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    private String fillPriviledgeKeyValue(JSONObject jSONObject) {
        String str;
        String str2 = "";
        try {
            if (!jSONObject.has(PRIVILEGE_CLOUD_PHOTO) || jSONObject.get(PRIVILEGE_CLOUD_PHOTO) == null) {
                str = "";
            } else {
                str = "" + PRIVILEGE_CLOUD_PHOTO + ContainerUtils.KEY_VALUE_DELIMITER + jSONObject.get(PRIVILEGE_CLOUD_PHOTO);
            }
            try {
                if (jSONObject.has(PRIVILEGE_INPUT_METHOD) && jSONObject.get(PRIVILEGE_INPUT_METHOD) != null) {
                    if (!str.equals("")) {
                        str = str + ":";
                    }
                    str = str + PRIVILEGE_INPUT_METHOD + ContainerUtils.KEY_VALUE_DELIMITER + jSONObject.get(PRIVILEGE_INPUT_METHOD);
                }
                if (jSONObject.has(PRIVILEGE_AUDIO_INPUT) && jSONObject.get(PRIVILEGE_AUDIO_INPUT) != null) {
                    if (!str.equals("")) {
                        str = str + ":";
                    }
                    str = str + PRIVILEGE_AUDIO_INPUT + ContainerUtils.KEY_VALUE_DELIMITER + jSONObject.get(PRIVILEGE_AUDIO_INPUT);
                }
                if (jSONObject.has("gps") && jSONObject.get("gps") != null) {
                    if (!str.equals("")) {
                        str = str + ":";
                    }
                    str = str + "gps" + ContainerUtils.KEY_VALUE_DELIMITER + jSONObject.get("gps");
                }
                if (jSONObject.has(PRIVILEGE_SENSOR) && jSONObject.get(PRIVILEGE_SENSOR) != null) {
                    if (!str.equals("")) {
                        str = str + ":";
                    }
                    str = str + PRIVILEGE_SENSOR + ContainerUtils.KEY_VALUE_DELIMITER + jSONObject.get(PRIVILEGE_SENSOR);
                }
                if (jSONObject.has(PRIVILEGE_VIRTUAL_PAD) && jSONObject.get(PRIVILEGE_VIRTUAL_PAD) != null) {
                    if (!str.equals("")) {
                        str = str + ":";
                    }
                    str = str + PRIVILEGE_VIRTUAL_PAD + ContainerUtils.KEY_VALUE_DELIMITER + jSONObject.get(PRIVILEGE_VIRTUAL_PAD);
                }
                if (jSONObject.has(PRIVILEGE_TOUCH) && jSONObject.get(PRIVILEGE_TOUCH) != null) {
                    if (!str.equals("")) {
                        str = str + ":";
                    }
                    str = str + PRIVILEGE_TOUCH + ContainerUtils.KEY_VALUE_DELIMITER + jSONObject.get(PRIVILEGE_TOUCH);
                }
                if (jSONObject.has(PRIVILEGE_PASSTHROUGH) && jSONObject.get(PRIVILEGE_PASSTHROUGH) != null) {
                    if (!str.equals("")) {
                        str2 = str + ":";
                    } else {
                        str2 = str;
                    }
                    return str2 + PRIVILEGE_PASSTHROUGH + ContainerUtils.KEY_VALUE_DELIMITER + jSONObject.get(PRIVILEGE_PASSTHROUGH);
                }
                return str;
            } catch (Exception e16) {
                e = e16;
                str2 = str;
                CGLog.e("Failed to fillPrividge, cause " + e);
                return str2;
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    public static void forceFastRender(boolean z16) {
        mForceFastRender = z16;
    }

    private Context getContext() {
        if (this.mCtx == null) {
            this.mCtx = this.mSurfaceView.getContext();
        }
        return this.mCtx;
    }

    private void initCgInput(Context context) {
        CGLog.i("initCgInput(" + context + ")");
        CgInputConnection.setCb(new InputMethodCb() { // from class: com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK.10
            @Override // com.tencent.gamematrix.gmcg.webrtc.InputMethodCb
            public void sendBackSpaceCb() {
                WebRTCSDK.this.sendBackSpace();
            }

            @Override // com.tencent.gamematrix.gmcg.webrtc.InputMethodCb
            public void sendCloseCb() {
                WebRTCSDK.this.sendClose();
            }

            @Override // com.tencent.gamematrix.gmcg.webrtc.InputMethodCb
            public void sendInputTextCb(String str) {
                WebRTCSDK.this.sendInputText(str);
            }
        });
        CgTextEditor.setCb(new InputMethodCb() { // from class: com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK.11
            @Override // com.tencent.gamematrix.gmcg.webrtc.InputMethodCb
            public void sendBackSpaceCb() {
                WebRTCSDK.this.sendBackSpace();
            }

            @Override // com.tencent.gamematrix.gmcg.webrtc.InputMethodCb
            public void sendCloseCb() {
                WebRTCSDK.this.sendClose();
            }

            @Override // com.tencent.gamematrix.gmcg.webrtc.InputMethodCb
            public void sendInputTextCb(String str) {
                WebRTCSDK.this.sendInputText(str);
            }
        });
        if (context.getResources().getConfiguration().orientation == 1) {
            this.mSoftKeyBoardHeightRatio = 0.2f;
        } else {
            this.mSoftKeyBoardHeightRatio = 0.7f;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initSensor() {
        boolean registerListener;
        try {
            if (this.mSensorNum != 0) {
                if (mHidSensor) {
                    IHIDSensorManager sensorManager = IHIDSensorManager.getSensorManager();
                    this.mHidSm = sensorManager;
                    if (sensorManager == null) {
                        CGLog.e("Failed to get HID SensorManager");
                    } else {
                        CGLog.i("Succeeded to get HID SensorManager");
                    }
                } else {
                    SensorManager sensorManager2 = (SensorManager) this.mCtx.getSystemService(PRIVILEGE_SENSOR);
                    this.mSm = sensorManager2;
                    if (sensorManager2 == null) {
                        CGLog.e("Failed to get SENSOR_SERVICE");
                    } else {
                        CGLog.i("Succeeded to get SENSOR_SERVICE");
                    }
                }
                this.sensorEvtListener = new SensorEventListener() { // from class: com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK.12
                    @Override // android.hardware.SensorEventListener
                    public void onSensorChanged(SensorEvent sensorEvent) {
                        if (WebRTCSDK.this.mStartSensor) {
                            int i3 = 0;
                            if (sensorEvent.sensor.getType() == 1) {
                                float[] fArr = sensorEvent.values;
                                float f16 = fArr[0];
                                float f17 = fArr[1];
                                float f18 = fArr[2];
                                if (Math.abs(f16) > Math.abs(f17) && Math.abs(f16) > Math.abs(f18)) {
                                    if (f16 > 0.0f) {
                                        WebRTCSDK.this.mSensorSign = 1;
                                    } else {
                                        WebRTCSDK.this.mSensorSign = -1;
                                    }
                                }
                            }
                            CustomizedSensorEvent customizedSensorEvent = new CustomizedSensorEvent(sensorEvent.values.length);
                            CustomizedSensor customizedSensor = new CustomizedSensor();
                            customizedSensorEvent.sensor = customizedSensor;
                            customizedSensor.setType(sensorEvent.sensor.getType());
                            customizedSensorEvent.accuracy = sensorEvent.accuracy;
                            customizedSensorEvent.timestamp = sensorEvent.timestamp;
                            while (true) {
                                float[] fArr2 = sensorEvent.values;
                                if (i3 >= fArr2.length) {
                                    break;
                                }
                                customizedSensorEvent.values[i3] = fArr2[i3] * WebRTCSDK.this.mSensorSign;
                                i3++;
                            }
                            if (WebRTCSDK.this.mStarted.get() && WebRTCSDK.this.mHandler != null) {
                                Message obtainMessage = WebRTCSDK.this.mHandler.obtainMessage();
                                obtainMessage.what = 4;
                                obtainMessage.obj = customizedSensorEvent;
                                WebRTCSDK.this.mHandler.sendMessage(obtainMessage);
                            }
                        }
                    }

                    @Override // android.hardware.SensorEventListener
                    public void onAccuracyChanged(Sensor sensor, int i3) {
                    }
                };
                CGLog.i("Succeeded to create SensorEventListener");
                for (int i3 = 0; i3 < this.mSensorNum; i3++) {
                    if (mHidSensor) {
                        IHIDSensorManager iHIDSensorManager = this.mHidSm;
                        registerListener = iHIDSensorManager.registerListener(this.sensorEvtListener, iHIDSensorManager.getDefaultSensor(this.mSensors[i3]), 1);
                    } else {
                        SensorManager sensorManager3 = this.mSm;
                        registerListener = SensorMonitor.registerListener(sensorManager3, this.sensorEvtListener, SensorMonitor.getDefaultSensor(sensorManager3, this.mSensors[i3]), 1);
                    }
                    if (registerListener) {
                        CGLog.i("Succeeded to register sensor type: " + this.mSensors[i3]);
                    } else {
                        CGLog.e("Failed to register sensor type: " + this.mSensors[i3]);
                    }
                }
                this.mStartSensor = true;
                return;
            }
            CGLog.d("WebRTCSDK mSensorNum= " + this.mSensorNum);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private void initTouchHandlerThread() {
        CGLog.i("initTouchHandlerThread");
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("touch-thread", -20);
        this.mHandlerThread = baseHandlerThread;
        baseHandlerThread.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper()) { // from class: com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK.7
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i3;
                switch (message.what) {
                    case 1:
                        WebRTCSDK.this.consumeTouchEvent((MotionEvent) message.obj);
                        return;
                    case 2:
                        WebRTCSDK.this.switchOnGps(true);
                        return;
                    case 3:
                        WebRTCSDK.this.switchOnGps(false);
                        return;
                    case 4:
                        WebRTCSDK.this.consumeSensorEvent((CustomizedSensorEvent) message.obj);
                        return;
                    case 5:
                        boolean booleanValue = ((Boolean) message.obj).booleanValue();
                        if (WebRTCSDK.this.mWebRTCClient != null) {
                            WebRTCSDK.this.mWebRTCClient.switchOnVoice(booleanValue);
                            return;
                        }
                        return;
                    case 6:
                        boolean booleanValue2 = ((Boolean) message.obj).booleanValue();
                        if (WebRTCSDK.this.mWebRTCClient != null) {
                            WebRTCSDK.this.mWebRTCClient.switchOnAudio(booleanValue2);
                            return;
                        }
                        return;
                    case 7:
                        String str = (String) message.obj;
                        try {
                            if (WebRTCSDK.this.mEnableIme && WebRTCSDK.this.mWebRTCClient != null) {
                                WebRTCSDK.this.mWebRTCClient.sendInputText(str);
                                return;
                            }
                            return;
                        } catch (Exception e16) {
                            e16.printStackTrace();
                            return;
                        }
                    case 8:
                        if (WSClient.HASCONNECTED && (i3 = message.arg1) < 100) {
                            if (i3 % 20 == 0) {
                                CGLog.i("start WebRTC until signal server is disconnected. HASCONNECTED = " + WSClient.HASCONNECTED + " and has waited " + (message.arg1 * message.arg2) + "ms");
                            }
                            Message obtain = Message.obtain();
                            obtain.what = 8;
                            obtain.arg1 = message.arg1 + 1;
                            obtain.arg2 = message.arg2;
                            sendMessageDelayed(obtain, message.arg2);
                            return;
                        }
                        if (WebRTCSDK.this.mWebRTCClient != null) {
                            WebRTCSDK.this.mWebRTCClient.start();
                        }
                        if (WebRTCSDK.this.mPeriodExecutorService != null) {
                            WebRTCSDK.this.checkFirstFrameRendered("HandlerThread.MSG_WHAT_SIGNAL_SERVER_CONNECTION");
                            WebRTCSDK.this.initSensor();
                            return;
                        }
                        return;
                    case 9:
                        Toast.makeText(WebRTCSDK.this.mCtx, "\u8bf7\u91cd\u542f\u5e94\u7528\u6216\u7535\u89c6", 1).show();
                        return;
                    default:
                        return;
                }
            }
        };
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void initVideoRenderView() {
        CGLog.i("initVideoRenderView skip renderer: " + mSkipRender);
        try {
            if (!mSkipRender) {
                EglBase eglBase = this.mEglBase;
                if (eglBase != null) {
                    eglBase.release();
                }
                this.mEglBase = org.tencwebrtc.g.a();
                EglRenderer.setPerfCb(new EglRenderer.PerfCallBack() { // from class: com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK.8
                    @Override // org.tencwebrtc.EglRenderer.PerfCallBack
                    public void onPerfCb(byte[] bArr, int i3) {
                        WebRTCSDK.mContainerOrientation = bArr[18] * 90;
                        WebRTCSDK.access$3908(WebRTCSDK.this);
                        if (WebRTCSDK.this.mPerfInvokedCount % 90 == 0) {
                            CGLog.v("Current orientation =" + WebRTCSDK.mContainerOrientation);
                        }
                        if (WebRTCSDK.mEnablePerfReport) {
                            if (WebRTCSDK.this.mWebRTCClient != null) {
                                WebRTCSDK.this.mWebRTCClient.sendSeiData(bArr);
                            }
                            String encodeToString = Base64.encodeToString(bArr, 2);
                            synchronized (WebRTCSDK.this.mPerfArray) {
                                WebRTCSDK.this.mPerfArray.add(encodeToString);
                            }
                        }
                    }
                });
                RendererCommon.RendererEvents rendererEvents = new RendererCommon.RendererEvents() { // from class: com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK.9
                    @Override // org.tencwebrtc.RendererCommon.RendererEvents
                    public void onFirstFrameRendered() {
                        if (WebRTCSDK.this.mWebrtcEventObserver != null) {
                            WebRTCSDK.this.mWebrtcEventObserver.onWebrtcStartUpProcess(GmCgDelayCounter.CGDelayLifeCycle.CGWebrtcSubProcessLifeCycle.SUB_PROCESS_DECODE_RENDER, false);
                        }
                        if (WebRTCSDK.this.mEnableTrace) {
                            TraceCompat.beginSection("onFirstFrameRendered");
                        }
                        WebRTCSDK.this.setFirstFrameRendered("SurfaceView onFirstFrameRendered", true);
                        WebRTCSDK.this.mFirstFrameRenderDelay = System.currentTimeMillis() - WebRTCSDK.this.mStartTimestampInMs;
                        if (WebRTCSDK.this.mWebRTCClient != null) {
                            WebRTCSDK.this.mWebRTCClient.getPerfValue().firstFrameRenderDelay = WebRTCSDK.this.mFirstFrameRenderDelay;
                            WebRTCSDK.this.mWebRTCClient.setFirstFrameRenderDelay(Long.valueOf(WebRTCSDK.this.mFirstFrameRenderDelay));
                        }
                        WebRTCSDK.this.onRTCFirstFrameRendered("onFirstFrameRendered");
                        WebRTCSDK.this.switchOnCgInput();
                        if (WebRTCSDK.this.mPeriodExecutorService != null) {
                            WebRTCSDK webRTCSDK = WebRTCSDK.this;
                            webRTCSDK.softInputScheduled = webRTCSDK.mPeriodExecutorService.schedule(new Runnable() { // from class: com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK.9.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    WebRTCSDK.this.switchOnSoftInput();
                                    if (!WebRTCSDK.this.mSoftKeyBoardHeightInitialized) {
                                        WebRTCSDK webRTCSDK2 = WebRTCSDK.this;
                                        webRTCSDK2.sendHeightRatio(webRTCSDK2.mSoftKeyBoardHeightRatio);
                                    }
                                }
                            }, 6000L, TimeUnit.MILLISECONDS);
                        }
                        if (WebRTCSDK.this.mEnableTrace) {
                            TraceCompat.endSection();
                        }
                    }

                    @Override // org.tencwebrtc.RendererCommon.RendererEvents
                    public void onFrameResolutionChanged(int i3, int i16, int i17) {
                        CGLog.i("onFrameResolutionChanged " + i3 + HippyTKDListViewAdapter.X + i16);
                        WebRTCSDK.mWidth = i3;
                        WebRTCSDK.mHeight = i16;
                    }
                };
                SurfaceViewRenderer surfaceViewRenderer = this.mSurfaceView;
                if (surfaceViewRenderer != null) {
                    surfaceViewRenderer.release();
                    this.mSurfaceView.init(this.mEglBase.getEglBaseContext(), rendererEvents);
                }
            }
            SurfaceViewRenderer surfaceViewRenderer2 = this.mSurfaceView;
            if (surfaceViewRenderer2 != null) {
                surfaceViewRenderer2.setScalingType(RendererCommon.ScalingType.SCALE_ASPECT_FIT);
                this.mSurfaceView.setEnableHardwareScaler(true);
                this.mSurfaceView.setZOrderMediaOverlay(true);
                this.mSurfaceView.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.gamematrix.gmcg.webrtc.t
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        boolean lambda$initVideoRenderView$3;
                        lambda$initVideoRenderView$3 = WebRTCSDK.this.lambda$initVideoRenderView$3(view, motionEvent);
                        return lambda$initVideoRenderView$3;
                    }
                });
                return;
            }
            TextureViewRenderer textureViewRenderer = this.mTextureView;
            if (textureViewRenderer != null) {
                textureViewRenderer.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.gamematrix.gmcg.webrtc.u
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        boolean lambda$initVideoRenderView$4;
                        lambda$initVideoRenderView$4 = WebRTCSDK.this.lambda$initVideoRenderView$4(view, motionEvent);
                        return lambda$initVideoRenderView$4;
                    }
                });
            }
        } catch (Exception e16) {
            CGLog.e("initVideoRenderView error: " + e16.getMessage());
        }
    }

    private void initWebRTC(DeviceConfig deviceConfig) {
        CGLog.i("initWebRTC, release mode");
        try {
            WebRTCEvents webRTCEvents = this.mWebrtcEventObserver;
            if (webRTCEvents != null) {
                webRTCEvents.onWebrtcStartUpProcess(GmCgDelayCounter.CGDelayLifeCycle.CGWebrtcSubProcessLifeCycle.SUB_PROCESS_GATE_PREPARE, true);
            }
            WebRTCClient build = new WebRTCClient.Builder(this.mCtx, this.mSessionCtx).setSurfaceView(this.mSurfaceView).setEglBase(this.mEglBase).setWebRtcEvents(this.mWebrtcEventObserver).setSensorConfig(this.mSensorCfg).setPerfConfig(this.mPerfConfig).enableVoice(this.mEnableVoice).useOpenSles(this.mEnableOpenSles).enablePinchFace(this.mEnablePinchFace).enableRecordFile(this.mEnableRecordFile).enablePassThrough(this.mEnablePassThrough).setNetworkCarrier(this.mNetworkCarrier).setProprietary(this.mProprietary).enableAudioDump(this.mEnableAudioDump).enableLm(mEnableLm).enableIme(this.mEnableIme).forceFastRender(mForceFastRender).enableKeepSession(mEnableKeepSession).enableQuic(mEnableQuic).setQuicLoggingLevel(this.mQuicLoggingLevel).enableFlexFec(mFlexFec).enableAudioFec(mAudioFec).enableRsFec(mRsFec).enableFrameFeedback(mEnableFrameFeedback).setCustomizeDecoder(mCustomizeDecoder).enableCmLog(mEnableCmLog).enableSeiPerfReport(mEnableSeiPerfReport).disableMediaEncryption(this.mDisableMediaEncryption).setWebRtcExecutor(this.mRTCExecutor).build();
            this.mWebRTCClient = build;
            WebRTCParameters webRTCParameters = this.mWebRTCParameters;
            if (webRTCParameters != null) {
                build.setImageQualityPreferred(webRTCParameters.getImgQualityPreferred());
            }
        } catch (Exception e16) {
            CGLog.e("initWebRTC error: " + e16);
        }
        WebRTCEvents webRTCEvents2 = this.mWebrtcEventObserver;
        if (webRTCEvents2 != null) {
            webRTCEvents2.onWebrtcStartUpProcess(GmCgDelayCounter.CGDelayLifeCycle.CGWebrtcSubProcessLifeCycle.SUB_PROCESS_GATE_PREPARE, false);
        }
    }

    public static boolean isEnableTouchInterpolation() {
        return TouchEventSender.isEnableTouchInterpolate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$initVideoRenderView$3(View view, MotionEvent motionEvent) {
        if (this.mStarted.get()) {
            if (motionEvent.getAction() == 1) {
                view.performClick();
            }
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            Handler handler = this.mHandler;
            if (handler != null) {
                Message obtainMessage = handler.obtainMessage();
                obtainMessage.what = 1;
                obtainMessage.obj = obtain;
                this.mHandler.sendMessage(obtainMessage);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$initVideoRenderView$4(View view, MotionEvent motionEvent) {
        if (this.mStarted.get()) {
            if (motionEvent.getAction() == 1) {
                view.performClick();
            }
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            Handler handler = this.mHandler;
            if (handler != null) {
                Message obtainMessage = handler.obtainMessage();
                obtainMessage.what = 1;
                obtainMessage.obj = obtain;
                this.mHandler.sendMessage(obtainMessage);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$sendAvgSrTime$6(SrReportResp srReportResp) {
        if (srReportResp.code == 0) {
            CGLog.i("VideoFilter sr_result success resp: msg=" + srReportResp.f108094msg + " tag=" + srReportResp.tag);
            return;
        }
        CGLog.e("VideoFilter sr_result resp: msg=" + srReportResp.f108094msg + " tag=" + srReportResp.tag);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setNetworkCarrier$5(String str, boolean z16) {
        logI("setNetworkCarrier carrier=" + str + ", proprietary=" + z16);
        this.mProprietary = z16;
        this.mNetworkCarrier = str;
        WebRTCClient webRTCClient = this.mWebRTCClient;
        if (webRTCClient != null) {
            webRTCClient.setNetworkCarrier(str, z16);
        } else {
            CGLog.w("WebRTCClient is null, can't setNetworkCarrier");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startPxlw$1() {
        GmCgPxlwManager.get().setSrSize(this.mSurfaceView.getWidth(), this.mSurfaceView.getHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startPxlw$2() {
        GmCgPxlwManager.get().setSrSize(this.mTextureView.getWidth(), this.mTextureView.getHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$stop$0() {
        logI("try to stop WebRTC, session=" + this.mSessionCtx.pLocalSessionNo);
        if (VideoFilterController.get().isOpenVideoSr() || VideoFilterController.get().isOpenFsr()) {
            sendAvgSrTime();
        }
        if (this.mEnableTrace) {
            TraceCompat.beginSection("stopWebRTC");
        }
        srServicePause();
        try {
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (this.mKeepConnection) {
            CGLog.i("stop WebRTC: keep connection. session=" + this.mSessionCtx.pLocalSessionNo);
            return;
        }
        if (this.mStarted.compareAndSet(true, false)) {
            if (mSkipRender) {
                setSurface(null);
            } else {
                unRegisterDecodeCallback(mCustomizeDecoder);
            }
            logI("stop WebRTC, session=" + this.mSessionCtx.pLocalSessionNo);
            sendHide();
            stopInner();
        }
        if (this.mEnableTrace) {
            TraceCompat.endSection();
        }
    }

    private void logI(String str) {
        CGLog.i("Thread[" + Thread.currentThread().getName() + "] WebRTCSDK@" + hashCode() + MsgSummary.STR_COLON + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRTCFirstFrameRendered(String str) {
        CGLog.i("onRTCFirstFrameRendered(" + str + ")");
        WebRTCEvents webRTCEvents = this.mWebrtcEventObserver;
        if (webRTCEvents != null) {
            webRTCEvents.onEventFirstFrameRendered();
        } else {
            CGLog.w("WebRTCSDK.mWebrtcEventObserver is null, can't call onEventFirstFrameRendered");
        }
        String onStreamingSuccess = SummaryLog.get().onStreamingSuccess(this.mSessionCtx);
        if (onStreamingSuccess != null) {
            CGLog.i("sendChannelDataToRemoteClient(3)");
            sendChannelDataToRemoteClient(3, onStreamingSuccess);
        }
    }

    private MobileButtonEvent processTouchEvent(MotionEvent motionEvent, int i3) {
        return processTouchEvent(motionEvent, i3, MotionEventCompat.getActionIndex(motionEvent), true);
    }

    private void registerGps() {
        try {
            if (!this.mLmSwitchedOn) {
                LocationManager locationManager = (LocationManager) this.mCtx.getSystemService("location");
                this.mLocationManager = locationManager;
                if (locationManager == null) {
                    CGLog.e("Failed to get LOCATION_SERVICE");
                    return;
                }
                CGLog.i("Succeeded to get LOCATION_SERVICE");
                this.mLocationListener = new LocationListener() { // from class: com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK.13
                    @Override // android.location.LocationListener
                    public void onLocationChanged(Location location) {
                        WebRTCSDK.this.consumeLocationEvent(location);
                        if (WebRTCSDK.mInitLoc == null) {
                            WebRTCSDK.mInitLoc = location;
                        }
                    }

                    @Override // android.location.LocationListener
                    public void onProviderDisabled(String str) {
                        CGLog.i("Provider: " + str + " disabled");
                    }

                    @Override // android.location.LocationListener
                    public void onProviderEnabled(String str) {
                        CGLog.i("Provider: " + str + " enabled");
                    }

                    @Override // android.location.LocationListener
                    public void onStatusChanged(String str, int i3, Bundle bundle) {
                        if (i3 == 0) {
                            CGLog.i(str + " is out of service");
                        }
                        if (i3 == 2) {
                            CGLog.i("Location provider: " + str + " is available");
                        }
                        if (i3 == 1) {
                            CGLog.i("Location provider: " + str + "is temporarily unavailable");
                        }
                    }
                };
                if (ContextCompat.checkSelfPermission(this.mCtx, "android.permission.ACCESS_FINE_LOCATION") != 0 && ContextCompat.checkSelfPermission(this.mCtx, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
                    return;
                }
                try {
                    LocationMonitor.requestLocationUpdates(this.mLocationManager, "gps", 2000L, 20.0f, this.mLocationListener);
                } catch (Exception e16) {
                    CGLog.e("Failed to requestLocationUpdates:" + e16);
                }
                this.mLmSwitchedOn = true;
                return;
            }
            CGLog.i("GPS already registered, will not register it again");
        } catch (Exception e17) {
            e17.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void restartInner() {
        logI("try to restart WebRTC, session=" + this.mSessionCtx.pLocalSessionNo);
        if (this.mEnableTrace) {
            TraceCompat.beginSection("restartWebRTC");
        }
        srServiceResume();
        try {
            if (this.mStarted.compareAndSet(true, false)) {
                CGLog.i("stop WebRTC, session=" + this.mSessionCtx.pLocalSessionNo);
                stopInner();
            }
            startInner();
        } catch (Exception e16) {
            CGLog.e("restartInner error: " + e16.getMessage());
        }
        if (this.mEnableTrace) {
            TraceCompat.endSection();
        }
    }

    private boolean sendButtonEvent(int i3, int i16) {
        int i17;
        if (i3 != 4) {
            i17 = -1;
        } else {
            i17 = 2;
        }
        if (i17 != -1) {
            try {
                if (this.mWebRTCClient != null) {
                    ByteBuffer order = ByteBuffer.allocate(2).order(ByteOrder.LITTLE_ENDIAN);
                    order.put(0, (byte) i16);
                    order.put(1, (byte) i17);
                    this.mWebRTCClient.sendMessageViaDataChannel(order);
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return true;
    }

    private void sendSubScribePriviledge(String str) {
        CGLog.i("sendSubScribePriviledge: " + str);
        byte[] bytes = str.getBytes();
        ByteBuffer order = ByteBuffer.allocate(bytes.length + 5).order(ByteOrder.LITTLE_ENDIAN);
        order.put((byte) 100);
        order.putInt(bytes.length);
        order.put(bytes);
        order.position(0);
        WebRTCClient webRTCClient = this.mWebRTCClient;
        if (webRTCClient != null) {
            webRTCClient.sendMessageViaDataChannel(order);
        } else {
            CGLog.e("mWebRTCClient = null, not sendMessageViaDataChannel");
        }
    }

    private void sendUnSubScribePriviledge(String str) {
        CGLog.i("sendUnSubScribePriviledge: " + str);
        byte[] bytes = str.getBytes();
        ByteBuffer order = ByteBuffer.allocate(bytes.length + 5).order(ByteOrder.LITTLE_ENDIAN);
        order.put((byte) 101);
        order.putInt(bytes.length);
        order.put(bytes);
        order.position(0);
        WebRTCClient webRTCClient = this.mWebRTCClient;
        if (webRTCClient != null) {
            webRTCClient.sendMessageViaDataChannel(order);
        } else {
            CGLog.e("mWebRTCClient = null, not sendMessageViaDataChannel");
        }
    }

    private void sendVirtualGamepadSubscribeNotification(String str) {
        byte[] bytes = str.getBytes();
        ByteBuffer order = ByteBuffer.allocate(bytes.length + 5).order(ByteOrder.LITTLE_ENDIAN);
        order.put((byte) 106);
        order.putInt(bytes.length);
        order.put(bytes);
        order.position(0);
        WebRTCClient webRTCClient = this.mWebRTCClient;
        if (webRTCClient != null) {
            webRTCClient.sendMessageViaDataChannel(order);
        } else {
            CGLog.e("mWebRTCClient = null, sendVirtualGamepadSubscribeNotification");
        }
    }

    private void sendWebRtcConfig(String str) {
        CGLog.i("sendWebRtcConfig: " + str);
        byte[] bytes = str.getBytes();
        ByteBuffer order = ByteBuffer.allocate(bytes.length + 5).order(ByteOrder.LITTLE_ENDIAN);
        order.put((byte) 90);
        order.putInt(bytes.length);
        order.put(bytes);
        order.position(0);
        WebRTCClient webRTCClient = this.mWebRTCClient;
        if (webRTCClient != null) {
            webRTCClient.sendMessageViaDataChannel(order);
        } else {
            CGLog.e("mWebRTCClient = null, not sendMessageViaDataChannel");
        }
    }

    public static void setClientType(GmCgClientType gmCgClientType) {
        boolean z16;
        WebRTCClient.setClientType(gmCgClientType);
        if (gmCgClientType.getValue() == GmCgClientType.WEBRTC_SESSION_TV.getValue()) {
            z16 = true;
        } else {
            z16 = false;
        }
        setDeviceType(z16);
        CGLog.i("setDeviceType: " + z16);
    }

    public static void setDecoderType(String str) {
        CustomizedVideoDecoderFactory.setDecodeType(str);
        CGLog.i("setDecoderType: " + str);
    }

    public static void setDegree(int i3) {
        try {
            mDegree = i3;
            EglRenderer.setDegree(i3);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public static void setDumpVideoStream(boolean z16) {
        CustomizedVideoDecoderFactory.setDumpVideoStreamEnabled(z16);
        CGLog.i("setDumpVideoStreamEnabled: " + z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFirstFrameRendered(String str, boolean z16) {
        logI("setFirstFrameRendered(" + str + ", " + z16 + ")");
        this.mFirstFrameRendered = z16;
    }

    public static void setLowLatency(boolean z16) {
        DefaultVideoDecoderFactory.setLowLatency(z16);
    }

    public static void setProxyIpPort(String str, int i3) {
        WebRTCClient.setProxyIpPort(str, i3);
    }

    public static void setQuicIPPort(String str, int i3) {
        WebRTCClient.setQuicIPPort(str, i3);
    }

    public static void setServerConfig(JSONObject jSONObject) {
        String str;
        try {
            if (!jSONObject.has(ENCODER_USE_AUDIO) || jSONObject.get(ENCODER_USE_AUDIO) == null) {
                str = "";
            } else {
                str = "" + ENCODER_USE_AUDIO + ContainerUtils.KEY_VALUE_DELIMITER + jSONObject.get(ENCODER_USE_AUDIO);
            }
            if (jSONObject.has(ENCODER_SOFTWARE_ENCODE) && jSONObject.get(ENCODER_SOFTWARE_ENCODE) != null) {
                if (!str.equals("")) {
                    str = str + ":";
                }
                str = str + ENCODER_SOFTWARE_ENCODE + ContainerUtils.KEY_VALUE_DELIMITER + jSONObject.get(ENCODER_SOFTWARE_ENCODE);
            }
            if (jSONObject.has(PASS_WEBRTC_PERF_STATS) && jSONObject.get(PASS_WEBRTC_PERF_STATS) != null) {
                if (!str.equals("")) {
                    str = str + ":";
                }
                str = str + PASS_WEBRTC_PERF_STATS + ContainerUtils.KEY_VALUE_DELIMITER + jSONObject.get(PASS_WEBRTC_PERF_STATS);
            }
            WSClient.setServerConfig(str);
        } catch (Exception e16) {
            CGLog.e("Failed to setServerConfig " + e16);
        }
    }

    public static void setSkipRender(boolean z16) {
        mSkipRender = z16;
    }

    public static void setTunnelPlaybackEnabled(boolean z16) {
        CustomizedVideoDecoderFactory.setTunneledPlaybackEnable(z16);
        CGLog.i("setTunneledPlaybackEnable: " + z16);
    }

    public static void setUserLocation(Location location) {
        CGLog.i("setUserLocation " + location);
        mInitLoc = location;
    }

    public static void setVDecoderFramerate(int i3) {
        CustomizedVideoDecoderFactory.setVDecoderFrameRate(i3);
        CGLog.i("setVDecoderFrameRate: " + i3);
    }

    public static void setVDecoderLogLevel(int i3) {
        CustomizedVideoDecoderFactory.setVDecoderLogLevel(i3);
        CGLog.i("setVDecoderLogLevel:  " + i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startInner() {
        logI("try to start WebRTC, session=" + this.mSessionCtx.pLocalSessionNo);
        if (this.mEnableTrace) {
            TraceCompat.beginSection("startWebRTC");
        }
        try {
            boolean z16 = true;
            if (this.mStarted.compareAndSet(false, true)) {
                WebRTCStatsCollector.setSkipRender(mSkipRender);
                WebRTCStatsCollector.customizeDecoder(mCustomizeDecoder);
                if (mCustomizeDecoder) {
                    CustomizedVideoDecoderFactory.setSkipRender(mSkipRender);
                } else {
                    DefaultVideoDecoderFactory.setSkipRender(mSkipRender);
                }
                Context context = this.mCtx;
                if (context != null) {
                    String deviceGuid = DeviceUtils.getDeviceGuid(context);
                    WSClient.setmGuid(deviceGuid);
                    CGLog.i("guid:" + deviceGuid);
                    AudioManager audioManager = (AudioManager) this.mCtx.getSystemService("audio");
                    this.mAudioManager = audioManager;
                    audioManager.setParameters("AudioQuickStart=enable");
                    CGLog.i("AudioQuickStart=enable");
                }
                this.mPeriodExecutorService = ProxyExecutors.newScheduledThreadPool(1);
                if (mSkipRender) {
                    SurfaceViewRenderer surfaceViewRenderer = this.mSurfaceView;
                    if (surfaceViewRenderer != null) {
                        setSurface(surfaceViewRenderer.getHolder().getSurface());
                    } else if (this.mTextureView.isAvailable()) {
                        setSurface(new Surface(this.mTextureView.getSurfaceTexture()));
                    } else {
                        new BaseThread() { // from class: com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK.4
                            @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
                            public void run() {
                                while (!WebRTCSDK.this.mTextureView.isAvailable()) {
                                    try {
                                        LockMethodProxy.sleep(20L);
                                    } catch (Exception e16) {
                                        CGLog.i("mTextureView isAvailable? " + e16.toString());
                                    }
                                }
                                WebRTCSDK.this.setSurface(new Surface(WebRTCSDK.this.mTextureView.getSurfaceTexture()));
                            }
                        }.start();
                    }
                } else {
                    registerDecodeCallback(mCustomizeDecoder);
                }
                CGLog.i("start WebRTC, session=" + this.mSessionCtx.pLocalSessionNo);
                this.mCurDisplayNum = 0;
                initWebRTC(this.mDeviceConfig);
                CGTdmDataReport.onResume();
                this.mStartTimestampInMs = System.currentTimeMillis();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("start WebRTC, WSClient HASCONNECTED = ");
                sb5.append(WSClient.HASCONNECTED);
                sb5.append(" mWebRTCClient != null:");
                if (this.mWebRTCClient == null) {
                    z16 = false;
                }
                sb5.append(z16);
                CGLog.i(sb5.toString());
                if (WSClient.HASCONNECTED) {
                    Handler handler = this.mHandler;
                    if (handler != null) {
                        Message obtainMessage = handler.obtainMessage();
                        obtainMessage.what = 8;
                        obtainMessage.arg1 = 0;
                        obtainMessage.arg2 = 50;
                        this.mHandler.sendMessage(obtainMessage);
                    }
                } else {
                    WebRTCClient webRTCClient = this.mWebRTCClient;
                    if (webRTCClient != null) {
                        webRTCClient.start();
                        WebRTCEvents webRTCEvents = this.mWebrtcEventObserver;
                        if (webRTCEvents != null) {
                            webRTCEvents.onEventStart();
                        }
                    }
                    if (this.mPeriodExecutorService != null) {
                        checkFirstFrameRendered("WebRTC.start()");
                        initSensor();
                    }
                }
            }
        } catch (Exception e16) {
            CGLog.e(TAG, "start error: " + e16.getMessage());
        }
        if (this.mEnableTrace) {
            TraceCompat.endSection();
        }
    }

    private void startPxlw() {
        CGLog.i(TAG, "startPxlw");
        SurfaceViewRenderer surfaceViewRenderer = this.mSurfaceView;
        Activity activity = null;
        if (surfaceViewRenderer != null) {
            Context context = surfaceViewRenderer.getContext();
            if (context instanceof Activity) {
                activity = (Activity) context;
            }
        } else {
            TextureViewRenderer textureViewRenderer = this.mTextureView;
            if (textureViewRenderer != null) {
                Context context2 = textureViewRenderer.getContext();
                if (context2 instanceof Activity) {
                    activity = (Activity) context2;
                }
            }
        }
        if (activity != null) {
            SurfaceViewRenderer surfaceViewRenderer2 = this.mSurfaceView;
            if (surfaceViewRenderer2 != null) {
                surfaceViewRenderer2.post(new Runnable() { // from class: com.tencent.gamematrix.gmcg.webrtc.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        WebRTCSDK.this.lambda$startPxlw$1();
                    }
                });
                return;
            }
            TextureViewRenderer textureViewRenderer2 = this.mTextureView;
            if (textureViewRenderer2 != null) {
                textureViewRenderer2.post(new Runnable() { // from class: com.tencent.gamematrix.gmcg.webrtc.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        WebRTCSDK.this.lambda$startPxlw$2();
                    }
                });
            } else {
                GmCgPxlwManager.get().setSrSize(CGDisplayUtil.getScreenWidth(this.mCtx), CGDisplayUtil.getScreenHeight(this.mCtx));
            }
        }
    }

    private void stopInner() {
        logI("stopInner");
        setFirstFrameRendered("stopInner", false);
        try {
            AudioManager audioManager = this.mAudioManager;
            if (audioManager != null) {
                audioManager.setParameters("AudioQuickStart=disable");
                CGLog.i("AudioQuickStart=disable");
                this.mAudioManager = null;
            }
            stopSensor();
            if (this.softInputScheduled != null) {
                stopSoftInput();
            }
            WebRTCClient webRTCClient = this.mWebRTCClient;
            if (webRTCClient != null) {
                CGTdmDataReport.reportPerfData(this.mSessionCtx, webRTCClient.getPerfValue(), true);
            }
            CGTdmDataReport.onStop();
            WebRTCClient webRTCClient2 = this.mWebRTCClient;
            if (webRTCClient2 != null) {
                webRTCClient2.stop();
                this.mWebRTCClient = null;
            }
            ScheduledExecutorService scheduledExecutorService = this.mPeriodExecutorService;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
                this.mPeriodExecutorService = null;
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private void stopSensor() {
        int i3 = 0;
        this.mStartSensor = false;
        try {
            if (this.mSensorNum != 0) {
                if (mHidSensor) {
                    if (this.mHidSm != null && this.sensorEvtListener != null) {
                        while (i3 < this.mSensorNum) {
                            IHIDSensorManager iHIDSensorManager = this.mHidSm;
                            iHIDSensorManager.unregisterListener(this.sensorEvtListener, iHIDSensorManager.getDefaultSensor(this.mSensors[i3]));
                            i3++;
                        }
                    }
                } else if (this.mSm != null && this.sensorEvtListener != null) {
                    while (i3 < this.mSensorNum) {
                        SensorManager sensorManager = this.mSm;
                        sensorManager.unregisterListener(this.sensorEvtListener, SensorMonitor.getDefaultSensor(sensorManager, this.mSensors[i3]));
                        i3++;
                    }
                }
                this.mSm = null;
                this.sensorEvtListener = null;
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private void stopSoftInput() {
        try {
            ScheduledFuture<?> scheduledFuture = this.softInputScheduled;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
                CGLog.i("Cancel softInputSchedulder");
            }
        } catch (Exception unused) {
            CGLog.i("Failed to stop soft input");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stutterDetect(ArrayList<String> arrayList) {
        int i3;
        int size = arrayList.size();
        int i16 = 0;
        while (true) {
            i3 = 7;
            if (i16 >= size) {
                break;
            }
            ByteBuffer wrap = ByteBuffer.wrap(Base64.decode(arrayList.get(i16), 2));
            wrap.order(ByteOrder.BIG_ENDIAN);
            int i17 = wrap.getInt(4);
            long j3 = wrap.getLong(8);
            if (this.mLastEncodeNum == 0) {
                this.mLastEncodeNum = i17;
                this.mLastEncodeTimestamp = j3;
                this.mLastDisplayNum = this.mCurDisplayNum;
            }
            int i18 = this.mCurDisplayNum + 1;
            this.mCurDisplayNum = i18;
            if (j3 - this.mLastEncodeTimestamp >= 2000) {
                this.mStutterCnt = 0;
                int i19 = i18 - this.mLastDisplayNum;
                int i26 = i17 - this.mLastEncodeNum;
                int i27 = i26 - i19;
                float f16 = (i27 * 1.0f) / i26;
                while (i3 > 0) {
                    int[] iArr = this.mStutter;
                    int i28 = iArr[i3 - 1];
                    iArr[i3] = i28;
                    this.mStutterCnt += i28;
                    i3--;
                }
                if (f16 >= 0.1f) {
                    this.mStutter[0] = 1;
                } else {
                    this.mStutter[0] = 0;
                }
                this.mStutterCnt += this.mStutter[0];
                CGLog.v("displayed=" + i19 + ", encoded=" + i26 + ", dropped=" + i27 + ", drop ratio=" + f16 + ", stutter count=" + this.mStutterCnt);
                this.mLastEncodeNum = i17;
                this.mLastEncodeTimestamp = j3;
                this.mLastDisplayNum = this.mCurDisplayNum;
            }
            i16++;
        }
        if (size < 1) {
            this.mStutterCnt = 0;
            while (i3 > 0) {
                int[] iArr2 = this.mStutter;
                int i29 = iArr2[i3 - 1];
                iArr2[i3] = i29;
                this.mStutterCnt += i29;
                i3--;
            }
            this.mStutter[0] = 2;
            this.mStutterCnt += 2;
        }
        if (this.mStutterCnt >= 5) {
            this.mRTCExecutor.execute(new Runnable() { // from class: com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (WebRTCSDK.this.mWebrtcEventObserver != null && WebRTCSDK.this.mStarted.get()) {
                            WebRTCSDK.this.mWebrtcEventObserver.onEventStutter(WebRTCEvents.ConnectionState.STATE_WEBRTC_STUTTER);
                        }
                    } catch (Exception e16) {
                        CGLog.e(WebRTCSDK.TAG, "onEventStutter error: " + e16.getMessage());
                    }
                }
            });
            for (int i36 = 0; i36 < 8; i36++) {
                this.mStutter[i36] = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void switchOnCgInput() {
        sendInput("cmd:set");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void switchOnSoftInput() {
        sendInput("key:61");
    }

    private void syncBatteryInfoToServer() {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        BatteryBroadcastReceiver batteryBroadcastReceiver = new BatteryBroadcastReceiver();
        this.mBatteryBroadcastReceiver = batteryBroadcastReceiver;
        if (this.mCtx != null) {
            batteryBroadcastReceiver.setOnBatteryListener(new BatteryBroadcastReceiver.OnBatteryListener() { // from class: com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK.6
                @Override // com.tencent.gamematrix.gmcg.webrtc.BatteryBroadcastReceiver.OnBatteryListener
                public void onBatteryChanged(float f16) {
                    CGLog.i("onBatteryChanged, battery percent:" + f16 + "%");
                    if (WebRTCSDK.this.mWebRTCClient != null) {
                        CGLog.i("onBatteryChanged, battery percent:" + f16 + "%");
                        WebRTCSDK.this.mWebRTCClient.sendBatteryEvent(WebRTCSDK.this.mBatteryBroadcastReceiver.mChargeType, WebRTCSDK.this.mBatteryBroadcastReceiver.mBatteryStatus, WebRTCSDK.this.mBatteryBroadcastReceiver.mBatteryLevel);
                    }
                }
            });
            this.mCtx.registerReceiver(this.mBatteryBroadcastReceiver, intentFilter);
        }
    }

    public int MethodCall(String str, List<String> list) {
        try {
            WebRTCClient webRTCClient = this.mWebRTCClient;
            if (webRTCClient == null) {
                return -1;
            }
            return webRTCClient.MethodCall(str, list);
        } catch (Exception e16) {
            e16.printStackTrace();
            return -1;
        }
    }

    public void ReportSDKInfo(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            String str = "";
            try {
                if (jSONObject.has("province") && jSONObject.get("province") != null) {
                    str = "province" + ContainerUtils.KEY_VALUE_DELIMITER + jSONObject.get("province") + ";";
                }
                if (jSONObject.has("ip") && jSONObject.get("ip") != null) {
                    str = str + "ip" + ContainerUtils.KEY_VALUE_DELIMITER + jSONObject.get("ip") + ";";
                }
                if (jSONObject.has(QOS_STATE) && jSONObject.get(QOS_STATE) != null) {
                    str = str + QOS_STATE + ContainerUtils.KEY_VALUE_DELIMITER + jSONObject.get(QOS_STATE) + ";";
                }
                if (jSONObject.has(QOS_TAG) && jSONObject.get(QOS_TAG) != null) {
                    str = str + QOS_TAG + ContainerUtils.KEY_VALUE_DELIMITER + jSONObject.get(QOS_TAG) + ";";
                }
                if (jSONObject.has(QOS_UUID) && jSONObject.get(QOS_UUID) != null) {
                    str = str + QOS_UUID + ContainerUtils.KEY_VALUE_DELIMITER + jSONObject.get(QOS_UUID) + ";";
                }
                jSONObject2.put("reserve2", str);
                str.replace(ContainerUtils.KEY_VALUE_DELIMITER, ":");
                jSONObject2.put("reserve4", str);
            } catch (JSONException e16) {
                CGLog.i("Failed to put max/min bitrate into json, reason :" + e16);
            }
            WebRTCClient webRTCClient = this.mWebRTCClient;
            if (webRTCClient != null) {
                webRTCClient.sendSDKInfo(jSONObject2);
            } else {
                CGLog.e("mWebRTCClient = null, not sendSDKInfo");
            }
        } catch (Exception e17) {
            e17.printStackTrace();
        }
    }

    public void clearTouchEventCount() {
        WebRTCClient webRTCClient = this.mWebRTCClient;
        if (webRTCClient != null) {
            webRTCClient.clearTouchEventCount();
        }
    }

    public void disableMediaEncryption(boolean z16) {
        this.mDisableMediaEncryption = z16;
    }

    public void enableAudioDump(boolean z16) {
        this.mEnableAudioDump = z16;
    }

    public void enableIme(boolean z16) {
        this.mEnableIme = z16;
        CGLog.i("enableIme: " + z16);
    }

    public void enableLm(boolean z16) {
        try {
            CGLog.i("enableLm " + z16);
            mEnableLm = z16;
            if (z16 && ContextCompat.checkSelfPermission(getContext(), "android.permission.ACCESS_FINE_LOCATION") != 0) {
                mEnableLm = false;
                CGLog.i("Force mEnableLm to false b/c of no permission");
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void enableOpenSles(boolean z16) {
        this.mEnableOpenSles = z16;
    }

    public void enablePassThrough(boolean z16) {
        this.mEnablePassThrough = z16;
    }

    public void enablePerfReport(boolean z16) {
        mEnablePerfReport = z16;
    }

    public void enablePinchFace(boolean z16) {
        this.mEnablePinchFace = z16;
    }

    public void enableRecordFile(boolean z16) {
        this.mEnableRecordFile = z16;
    }

    public void enableRemoteMediaStream(boolean z16) {
        if (z16) {
            initSensor();
        } else {
            stopSensor();
        }
        WebRTCClient webRTCClient = this.mWebRTCClient;
        if (webRTCClient != null) {
            webRTCClient.enableRemoteMediaStream(z16);
        }
    }

    public void enableStutterDetect(boolean z16) {
        this.mEnableStutterDetect = z16;
    }

    public void enableVoice(boolean z16) {
        CGLog.i("enableVoice " + z16);
        this.mEnableVoice = z16;
    }

    public String getAppBizNo() {
        CGSessionCtx cGSessionCtx = this.mSessionCtx;
        if (cGSessionCtx != null) {
            return cGSessionCtx.pAppBizNo;
        }
        return "";
    }

    public boolean getAudioStatus() {
        WebRTCClient webRTCClient = this.mWebRTCClient;
        if (webRTCClient != null) {
            return webRTCClient.getAudioStatus();
        }
        return false;
    }

    public boolean getDataChannelConnectedState() {
        WebRTCClient webRTCClient = this.mWebRTCClient;
        if (webRTCClient != null) {
            return webRTCClient.getDataChannelConnectedState();
        }
        return false;
    }

    public boolean getSignalServerConnectedState() {
        WebRTCClient webRTCClient = this.mWebRTCClient;
        if (webRTCClient != null) {
            return webRTCClient.getSignalServerConnectedState();
        }
        return false;
    }

    public int getTouchEventCount() {
        WebRTCClient webRTCClient = this.mWebRTCClient;
        if (webRTCClient != null) {
            return webRTCClient.getTouchEventCount();
        }
        return 0;
    }

    public void init(DeviceConfig deviceConfig) {
        CGLog.i("init SDK");
        this.mDeviceConfig = deviceConfig;
    }

    public void keepConnection(boolean z16) {
        this.mKeepConnection = z16;
    }

    public void kickOffline() {
        try {
            WebRTCClient webRTCClient = this.mWebRTCClient;
            if (webRTCClient != null) {
                webRTCClient.kickOffline();
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void onDestroy() {
        BatteryBroadcastReceiver batteryBroadcastReceiver;
        CGLog.i(MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        GmCgPxlwManager.get().unload();
        Context context = this.mCtx;
        if (context != null && (batteryBroadcastReceiver = this.mBatteryBroadcastReceiver) != null) {
            context.unregisterReceiver(batteryBroadcastReceiver);
            this.mBatteryBroadcastReceiver.setOnBatteryListener(null);
            this.mBatteryBroadcastReceiver = null;
        }
        try {
            srServiceRelease();
            videoFilterRelease();
            CGTdmDataReport.onDestroy();
            SurfaceViewRenderer surfaceViewRenderer = this.mSurfaceView;
            if (surfaceViewRenderer != null) {
                surfaceViewRenderer.setOnTouchListener(null);
                this.mSurfaceView.release();
                this.mSurfaceView = null;
            }
            TextureViewRenderer textureViewRenderer = this.mTextureView;
            if (textureViewRenderer != null) {
                textureViewRenderer.setOnTouchListener(null);
                this.mTextureView = null;
            }
            EglBase eglBase = this.mEglBase;
            if (eglBase != null) {
                eglBase.release();
                this.mEglBase = null;
            }
            HandlerThread handlerThread = this.mHandlerThread;
            if (handlerThread != null) {
                this.mHandler = null;
                handlerThread.quit();
                this.mHandlerThread = null;
            }
            this.mWebrtcEventObserver = null;
            this.mCtx = null;
            EglRenderer.setPerfCb(null);
            CgInputConnection.setCb(null);
            CgTextEditor.setCb(null);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        CGLog.i("onKeyDown keyCode=" + i3 + " event=" + keyEvent);
        return sendButtonEvent(i3, 83);
    }

    public boolean onKeyUp(int i3, KeyEvent keyEvent) {
        CGLog.i("onKeyUp keyCode=" + i3 + " event=" + keyEvent);
        return sendButtonEvent(i3, 84);
    }

    public void onStart() {
        CGLog.i("onStart");
        try {
            CGTdmDataReport.onStart();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void pause() {
        CGLog.i("WebRTCSDK pause");
        try {
            CGTdmDataReport.onPause();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void registerDecodeCallback(boolean z16) {
        VideoDecoder.DecodeCallback decodeCallback = new VideoDecoder.DecodeCallback() { // from class: com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK.1
            @Override // org.tencwebrtc.VideoDecoder.DecodeCallback
            public void onDecodeErrCodeReported(boolean z17, int i3, int i16, String str) {
                if (WebRTCSDK.this.mWebrtcEventObserver != null) {
                    WebRTCSDK.this.mWebrtcEventObserver.onDecodeErrCodeReport(z17, i3, i16, str);
                }
            }

            @Override // org.tencwebrtc.VideoDecoder.DecodeCallback
            public void onFirstFrameDecoded() {
                if (!WebRTCSDK.mSkipRender) {
                    WebRTCSDK.this.setFirstFrameRendered("Not Skip Render onFirstFrameDecoded", true);
                    return;
                }
                if (WebRTCSDK.this.mEnableTrace) {
                    TraceCompat.beginSection("onFirstFrameRendered");
                }
                WebRTCSDK.this.setFirstFrameRendered("Skip Render onFirstFrameDecoded ", true);
                WebRTCSDK.this.mFirstFrameRenderDelay = System.currentTimeMillis() - WebRTCSDK.this.mStartTimestampInMs;
                if (WebRTCSDK.this.mWebRTCClient != null) {
                    WebRTCSDK.this.mWebRTCClient.getPerfValue().firstFrameRenderDelay = WebRTCSDK.this.mFirstFrameRenderDelay;
                    WebRTCSDK.this.mWebRTCClient.setFirstFrameRenderDelay(Long.valueOf(WebRTCSDK.this.mFirstFrameRenderDelay));
                    CGLog.e("mWebRTCClient is not null firstFrameRenderDelay=" + WebRTCSDK.this.mWebRTCClient.getPerfValue().firstFrameRenderDelay);
                } else {
                    CGLog.e("mWebRTCClient is null when onFirstFrameDecoded");
                }
                if (WebRTCSDK.this.mWebrtcEventObserver != null) {
                    WebRTCSDK.this.mWebrtcEventObserver.onWebrtcStartUpProcess(GmCgDelayCounter.CGDelayLifeCycle.CGWebrtcSubProcessLifeCycle.SUB_PROCESS_DECODE_RENDER, false);
                    WebRTCSDK.this.onRTCFirstFrameRendered("onFirstFrameDecoded");
                }
                WebRTCSDK.this.switchOnCgInput();
                if (WebRTCSDK.this.mPeriodExecutorService != null) {
                    WebRTCSDK webRTCSDK = WebRTCSDK.this;
                    webRTCSDK.softInputScheduled = webRTCSDK.mPeriodExecutorService.schedule(new Runnable() { // from class: com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            WebRTCSDK.this.switchOnSoftInput();
                            WebRTCSDK webRTCSDK2 = WebRTCSDK.this;
                            webRTCSDK2.sendHeightRatio(webRTCSDK2.mSoftKeyBoardHeightRatio);
                        }
                    }, 6000L, TimeUnit.MILLISECONDS);
                }
                if (WebRTCSDK.this.mEnableTrace) {
                    TraceCompat.endSection();
                }
            }

            @Override // org.tencwebrtc.VideoDecoder.DecodeCallback
            public void onFrameResolutionChanged(int i3, int i16, int i17) {
                if (WebRTCSDK.mSkipRender) {
                    CGLog.e("onFrameResolutionChanged 111" + i3 + HippyTKDListViewAdapter.X + i16);
                    WebRTCSDK.mWidth = i3;
                    WebRTCSDK.mHeight = i16;
                    if (WebRTCSDK.this.mSurfaceView != null) {
                        WebRTCSDK.this.mSurfaceView.onFrameResolutionChanged(i3, i16, i17);
                    } else if (WebRTCSDK.this.mTextureView != null) {
                        WebRTCSDK.this.mTextureView.onFrameResolutionChanged(i3, i16, i17);
                    }
                }
            }

            @Override // org.tencwebrtc.VideoDecoder.DecodeCallback
            public void onOrientationChanged(int i3) {
                if (WebRTCSDK.mSkipRender) {
                    CGLog.i("onOrientationChanged " + i3);
                    WebRTCSDK.mContainerOrientation = i3 * 90;
                }
            }

            @Override // org.tencwebrtc.VideoDecoder.DecodeCallback
            public void onPerfCb(byte[] bArr, int i3) {
                if (WebRTCSDK.mSkipRender && WebRTCSDK.mEnablePerfReport) {
                    if (WebRTCSDK.this.mWebRTCClient != null) {
                        WebRTCSDK.this.mWebRTCClient.sendSeiData(bArr);
                    }
                    String encodeToString = Base64.encodeToString(bArr, 2);
                    synchronized (WebRTCSDK.this.mPerfArray) {
                        WebRTCSDK.this.mPerfArray.add(encodeToString);
                    }
                }
            }
        };
        if (z16) {
            CustomizedVideoDecoderFactory.setCallback(decodeCallback);
        } else {
            DefaultVideoDecoderFactory.setCallback(decodeCallback);
        }
    }

    public void registerSensors(int i3, int[] iArr) {
        if (i3 != 0) {
            for (int i16 = 0; i16 < i3; i16++) {
                this.mSensors[i16] = iArr[i16];
            }
            if (this.mSensorNum == 0) {
                this.mSensorNum = i3;
                return;
            }
            return;
        }
        CGLog.d("WebRTCSDK sensor num = " + i3);
    }

    public void restart() {
        this.mRTCExecutor.execute(new Runnable() { // from class: com.tencent.gamematrix.gmcg.webrtc.v
            @Override // java.lang.Runnable
            public final void run() {
                WebRTCSDK.this.restartInner();
            }
        });
    }

    public void resume() {
        CGLog.i("WebRTCSDK resume");
        try {
            CGTdmDataReport.onResume();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void sendAvgSrTime() {
        String str;
        WebRTCParameters webRTCParameters;
        String str2;
        String str3;
        String str4 = "SrReport@" + System.currentTimeMillis();
        CGSessionCtx cGSessionCtx = this.mSessionCtx;
        if (cGSessionCtx != null && (webRTCParameters = cGSessionCtx.pWebRTCParameters) != null) {
            VideoFilterParams videofilterParams = webRTCParameters.getVideofilterParams();
            if (videofilterParams == null) {
                CGLog.e("VideoFilter sendAvgSrTime failed! vfp is null obj.");
                return;
            }
            String str5 = videofilterParams.m_strSrResultHost;
            if (str5 != null && videofilterParams.m_strSrResultKey != null) {
                String str6 = "https://" + videofilterParams.m_strSrResultHost + "/api/edgegw/sr/report/sr-result";
                CGLog.v("VideoFilter sr result url: " + str6);
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("soc", videofilterParams.m_strBuildSoc);
                    jSONObject2.put("brand", videofilterParams.m_strBuildBrand);
                    jSONObject2.put("model", videofilterParams.m_strBuildModel);
                    jSONObject.put("sr_config_name", videofilterParams.m_strModelConfigName);
                    jSONObject.put("feature", jSONObject2);
                    if (VideoFilterController.get().isOpenFsr()) {
                        jSONObject.put("avg_sr_time", (int) VideoFilterController.get().getVideoFilterAvgTime());
                    } else if (VideoFilterController.get().isOpenVideoSr()) {
                        jSONObject.put("avg_sr_time", (int) VideoFilterController.get().getVideoSrAvgTime());
                    } else {
                        jSONObject.put("avg_sr_time", 9999);
                    }
                    jSONObject.put("sr_err_count", VideoFilterController.get().getSrErrCount());
                    jSONObject.put("device_id", videofilterParams.m_strDeviceId);
                    jSONObject.put(ServiceConst.PARA_SESSION_ID, videofilterParams.m_strSessionId);
                    jSONObject.put("sr_sdk_version", VideoFilterController.get().getSrServiceVersion());
                    jSONObject.put(AudienceReportConst.CLIENT_TYPE, DeviceType.DeviceCategory.MOBILE);
                    jSONObject.put("package_name", videofilterParams.m_strGameId);
                    jSONObject.put("version", "1.0.1");
                    jSONObject.put("video_filter_type", VideoFilterController.get().getVideoFilterType());
                    String jSONObject3 = jSONObject.toString();
                    Calendar.getInstance().setTimeZone(TimeZone.getTimeZone("GMT"));
                    String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
                    try {
                        str3 = CGSystemUtil.HMACSHA256(jSONObject3, valueOf, videofilterParams.m_strSrResultKey).toLowerCase();
                    } catch (Exception e16) {
                        e16.printStackTrace();
                        str3 = " ";
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("gmve_ts", valueOf);
                    hashMap.put("gmve_sign", str3);
                    CGLog.i("VideoFilter sendAvgSrTime  header=" + hashMap.toString() + "json: msg=" + jSONObject3 + " url=" + str6);
                    CGGsonBodyRequest cGGsonBodyRequest = new CGGsonBodyRequest(1, str6, SrReportResp.class, hashMap, null, jSONObject3, new h.b() { // from class: com.tencent.gamematrix.gmcg.webrtc.p
                        @Override // com.android.volley.h.b
                        public final void onResponse(Object obj) {
                            WebRTCSDK.lambda$sendAvgSrTime$6((SrReportResp) obj);
                        }
                    }, new h.a() { // from class: com.tencent.gamematrix.gmcg.webrtc.q
                        @Override // com.android.volley.h.a
                        public final void onErrorResponse(VolleyError volleyError) {
                            CGLog.e("VideoFilter sr_result error");
                        }
                    });
                    cGGsonBodyRequest.setTag(str4);
                    CGHttpReqManager.get().newReq(cGGsonBodyRequest);
                    return;
                } catch (JSONException e17) {
                    e17.printStackTrace();
                    return;
                } catch (Exception e18) {
                    e18.printStackTrace();
                    return;
                }
            }
            if (str5 == null) {
                str2 = "404";
            } else {
                str2 = "502";
            }
            CGLog.e("VideoFilter sendAvgSrTime failed! desc: " + str2);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("VideoFilter sendAvgSrTime failed! sessionctx is null obj. desc is ");
        if (this.mSessionCtx == null) {
            str = "0";
        } else {
            str = "1";
        }
        sb5.append(str);
        CGLog.e(sb5.toString());
    }

    public void sendBackSpace() {
        sendInput(PREFIX_INPUT_KEY + 67);
    }

    public void sendChannelAck(String str) {
        try {
            WebRTCClient webRTCClient = this.mWebRTCClient;
            if (webRTCClient != null) {
                webRTCClient.sendChannelAck(str);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void sendChannelData(String str) {
        try {
            WebRTCClient webRTCClient = this.mWebRTCClient;
            if (webRTCClient != null) {
                webRTCClient.sendChannelData(str);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void sendChannelDataToRemoteClient(int i3, String str) {
        try {
            WebRTCClient webRTCClient = this.mWebRTCClient;
            if (webRTCClient != null) {
                webRTCClient.sendCommonTypeNotify(i3, str);
            }
        } catch (Exception e16) {
            CGLog.e("sendChannelDataToRemoteClient failed: " + e16);
        }
    }

    public void sendClose() {
        sendInput(PREFIX_INPUT_KEY + 66);
    }

    public void sendCopiedText(String str) {
        sendInput(PREFIX_CLIPBOARD + str);
    }

    public boolean sendDeviceCreateEvent(int i3, int i16, int i17) {
        return sendDeviceCreateEvent(i3, i16, i17, false);
    }

    public boolean sendDeviceDetroyEvent(int i3, int i16, int i17) {
        return sendDeviceDetroyEvent(i3, i16, i17, false);
    }

    public boolean sendGamepadKeyEvent(int i3, int i16, int i17, int i18, int i19) {
        return sendGamepadKeyEvent(i3, i16, i17, i18, i19, false);
    }

    public boolean sendGamepadMotionEvent(MotionEvent motionEvent, int i3, int i16) {
        return sendGamepadMotionEvent(motionEvent, i3, i16, false);
    }

    public void sendGamepadTouchEvent(MotionEvent motionEvent) {
        if (this.mHandler != null) {
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            Message obtainMessage = this.mHandler.obtainMessage();
            obtainMessage.what = 1;
            obtainMessage.obj = obtain;
            this.mHandler.sendMessage(obtainMessage);
        }
    }

    public boolean sendGamepadTriggerEvent(int i3, int i16, float f16) {
        if (this.mWebRTCClient == null) {
            return false;
        }
        ByteBuffer order = ByteBuffer.allocate(17).order(ByteOrder.LITTLE_ENDIAN);
        order.put(0, (byte) 93);
        order.putInt(1, 12);
        order.putShort(5, (short) 257);
        order.putInt(7, i3);
        order.putShort(11, (short) i16);
        order.putFloat(13, f16);
        this.mWebRTCClient.sendMessageViaDataChannel(order);
        return true;
    }

    public void sendHeightRatio(float f16) {
        this.mSoftKeyBoardHeightInitialized = true;
        sendInput(PREFIX_INPUT_HEIGHT + f16);
    }

    public void sendHide() {
        sendInput(PREFIX_INPUT_KEY + 111);
    }

    public void sendInput(String str) {
        Handler handler;
        if (this.mStarted.get() && (handler = this.mHandler) != null) {
            Message obtainMessage = handler.obtainMessage();
            obtainMessage.what = 7;
            obtainMessage.obj = str;
            this.mHandler.sendMessage(obtainMessage);
        }
    }

    public void sendInputText(String str) {
        sendInput(PREFIX_INPUT_TEXT + str);
    }

    public void sendPerfData(ArrayList<String> arrayList, int i3, int i16, int i17) {
        try {
            WebRTCClient webRTCClient = this.mWebRTCClient;
            if (webRTCClient != null) {
                webRTCClient.sendPerfData(arrayList, i3, i16, i17);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void sendPhoto(String str) {
        try {
            WebRTCClient webRTCClient = this.mWebRTCClient;
            if (webRTCClient != null) {
                webRTCClient.sendPhoto(str);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public boolean sendVirtualGamepadEvent(int i3, int i16) {
        try {
            if (this.mWebRTCClient != null) {
                ByteBuffer order = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
                order.put(0, (byte) 95);
                order.put(1, (byte) 2);
                order.put(2, (byte) i3);
                order.put(3, (byte) i16);
                this.mWebRTCClient.sendMessageViaDataChannel(order);
                CGLog.i("send virtual gamepad event !!!!!" + i3);
                return true;
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return false;
    }

    public boolean sendVirtualGamepadRequest() {
        try {
            if (this.mWebRTCClient != null) {
                ByteBuffer order = ByteBuffer.allocate(7).order(ByteOrder.LITTLE_ENDIAN);
                order.put(0, (byte) 97);
                order.putInt(1, 2);
                order.putShort(5, (short) 257);
                this.mWebRTCClient.sendMessageViaDataChannel(order);
                CGLog.i("send virtual gamepad request !!!!!");
                return true;
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return false;
    }

    public void setAudioVolume(double d16) {
        double d17;
        CGLog.i("setAudioVolume volume=" + d16);
        try {
            this.mCurrAudioVolume = d16;
            if (this.mWebRTCClient != null) {
                int maxAudioVolume = this.mWebRTCParameters.getMaxAudioVolume();
                WebRTCClient webRTCClient = this.mWebRTCClient;
                if (maxAudioVolume != 0) {
                    d17 = (this.mCurrAudioVolume * 10.0d) / maxAudioVolume;
                } else {
                    d17 = 0.0d;
                }
                webRTCClient.setAudioVolume(d17);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void setEncodeProperty(JSONObject jSONObject) {
        String str;
        try {
            if (!jSONObject.has("fps") || jSONObject.get("fps") == null) {
                str = "";
            } else {
                str = "fps" + ContainerUtils.KEY_VALUE_DELIMITER + jSONObject.get("fps");
            }
            if (jSONObject.has("resolution") && jSONObject.get("resolution") != null) {
                if (!str.equals("")) {
                    str = str + ":";
                }
                str = str + "resolution" + ContainerUtils.KEY_VALUE_DELIMITER + jSONObject.get("resolution");
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(KEY_ENCODER_PROPERTY, str);
            sendWebRtcConfig(jSONObject2.toString());
        } catch (Exception e16) {
            CGLog.e("Failed to setEncodeProperty " + e16);
        }
    }

    public void setNetworkCarrier(final String str, final boolean z16) {
        this.mRTCExecutor.execute(new Runnable() { // from class: com.tencent.gamematrix.gmcg.webrtc.m
            @Override // java.lang.Runnable
            public final void run() {
                WebRTCSDK.this.lambda$setNetworkCarrier$5(str, z16);
            }
        });
    }

    public void setQuicLoggingLevel(int i3) {
        CGLog.i("WebRTCSDK setQuicLoggingLevel level = " + i3);
        this.mQuicLoggingLevel = i3;
        WebRTCClient webRTCClient = this.mWebRTCClient;
        if (webRTCClient != null) {
            webRTCClient.setQuicLoggingLevel(i3);
        }
    }

    public void setReportPerfDataTag(int i3) {
        try {
            WebRTCClient webRTCClient = this.mWebRTCClient;
            if (webRTCClient != null) {
                webRTCClient.setPerfDataTag(i3);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void setSurface(Surface surface) {
        try {
            if (mCustomizeDecoder) {
                CustomizedVideoDecoderFactory.setSurface(surface);
                if (surface == null) {
                    unRegisterDecodeCallback(true);
                    CustomizedVideoDecoderFactory.setVDecoderPerfCb(null);
                    CGLog.i("setSurface and setCallback to null");
                } else {
                    registerDecodeCallback(true);
                    CGLog.i("setSurface and callback, setVDecoderPerfCb");
                    CustomizedVideoDecoderFactory.setVDecoderPerfCb(new VDecoder.b() { // from class: com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK.2
                        public void OnDataReport(int i3, int i16, Map<String, String> map) {
                            if (WebRTCSDK.this.mWebrtcEventObserver != null) {
                                CGLog.i("CustomizedVideoDecoderFactory setVDecoderPerfCb");
                                WebRTCSDK.this.mWebrtcEventObserver.OnEventDataReport(i3, i16, map);
                            }
                        }

                        public void OnDecodeMessage(int i3, int i16, int i17, int i18) {
                            if (i3 == 24 || i3 == 25) {
                                Message obtainMessage = WebRTCSDK.this.mHandler.obtainMessage();
                                obtainMessage.what = 9;
                                WebRTCSDK.this.mHandler.sendMessage(obtainMessage);
                            }
                        }
                    });
                }
                CGLog.i("CustomizedVideoDecoderFactory.setSurface");
                return;
            }
            DefaultVideoDecoderFactory.setSurface(surface);
            if (surface == null) {
                unRegisterDecodeCallback(false);
                CGLog.i("DefaultVideoDecoderFactory setSurface and setCallback to null");
            } else {
                registerDecodeCallback(false);
            }
            CGLog.i("DefaultVideoDecoderFactory.setSurface");
        } catch (Exception e16) {
            CGLog.e("setSurface error: " + e16.getMessage());
        }
    }

    public void setSurfaceView(SurfaceViewRenderer surfaceViewRenderer) {
        if (this.mSurfaceView != null) {
            CGLog.i("release prev surface view " + this.mSurfaceView);
            this.mSurfaceView.release();
        }
        this.mSurfaceView = surfaceViewRenderer;
        CGLog.i("set new surface view: " + this.mSurfaceView);
        initVideoRenderView();
        if (mSkipRender) {
            setSurface(this.mSurfaceView.getHolder().getSurface());
        }
        WebRTCClient webRTCClient = this.mWebRTCClient;
        if (webRTCClient != null) {
            webRTCClient.setVideoRender(surfaceViewRenderer);
        }
    }

    public void setVideoBitrate(int i3, int i16) {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(Element.ELEMENT_NAME_MIN, i3);
                jSONObject2.put("max", i16);
                jSONObject.put("SetVideoBitrate", jSONObject2);
                jSONObject.put("type", WebRTCClient.mGmCgClientType.getValue());
                sendWebRtcConfig(jSONObject.toString());
                JSONObject jSONObject3 = new JSONObject();
                String str = "";
                if (i3 != 0) {
                    str = "minRate=" + Integer.toString(i3) + ";";
                }
                if (i16 != 0) {
                    str = str + "maxRate=" + Integer.toString(i16) + ";";
                }
                try {
                    jSONObject3.put("reserve2", str);
                    str.replace(ContainerUtils.KEY_VALUE_DELIMITER, ":");
                    jSONObject3.put("reserve4", str);
                } catch (JSONException e16) {
                    CGLog.e("Failed to put max/min bitrate into json, reason :" + e16);
                }
                WebRTCClient webRTCClient = this.mWebRTCClient;
                if (webRTCClient != null) {
                    webRTCClient.sendSDKInfo(jSONObject3);
                } else {
                    CGLog.e("mWebRTCClient = null, not sendSDKInfo");
                }
            } catch (JSONException e17) {
                throw new RuntimeException(e17);
            }
        } catch (Exception e18) {
            e18.printStackTrace();
        }
    }

    public boolean srServiceInited() {
        return VideoFilterController.get().isOpenVideoSr();
    }

    public void srServicePause() {
        VideoFilterController.get().srServicePause();
    }

    public void srServiceRelease() {
        VideoFilterController.get().setOpenVideoSr(false, null);
        FilterSurfaceViewRenderer.clearVideoFilterParams();
    }

    public void srServiceResume() {
        VideoFilterController.get().srServiceResume();
    }

    public String srServiceVersion() {
        return VideoFilterController.get().getSrServiceVersion();
    }

    public void start() {
        if (GmCgPxlwManager.get().isEnablePxlw()) {
            startPxlw();
        }
        this.mRTCExecutor.execute(new Runnable() { // from class: com.tencent.gamematrix.gmcg.webrtc.l
            @Override // java.lang.Runnable
            public final void run() {
                WebRTCSDK.this.startInner();
            }
        });
    }

    public void stop() {
        this.mRTCExecutor.execute(new Runnable() { // from class: com.tencent.gamematrix.gmcg.webrtc.s
            @Override // java.lang.Runnable
            public final void run() {
                WebRTCSDK.this.lambda$stop$0();
            }
        });
    }

    public void stopGps() {
        try {
            if (this.mLmSwitchedOn) {
                LocationManager locationManager = this.mLocationManager;
                if (locationManager != null) {
                    try {
                        LocationMonitor.removeUpdates(locationManager, this.mLocationListener);
                    } catch (Exception e16) {
                        CGLog.e("Failed to removeUpdates:" + e16);
                    }
                    this.mLocationListener = null;
                    this.mLocationManager = null;
                    CGLog.i("GPS stopped");
                } else {
                    CGLog.i("mLocationManager is null, no need to stop GPS");
                }
                this.mLmSwitchedOn = false;
                return;
            }
            CGLog.i("GPS not enabled, no need to stop GPS");
        } catch (Exception e17) {
            e17.printStackTrace();
        }
    }

    public void subscribePriviledge(JSONObject jSONObject) {
        String fillPrividge = fillPrividge(jSONObject);
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(KEY_RIGHTS_SUBSCRIBE, fillPrividge);
            sendSubScribePriviledge(jSONObject2.toString());
        } catch (Exception e16) {
            CGLog.e("Failed to subscribePriviledge, cause " + e16);
        }
    }

    public void switchOnAudio(boolean z16) {
        String str;
        Handler handler;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("Try to switch ");
        if (z16) {
            str = "on";
        } else {
            str = DebugKt.DEBUG_PROPERTY_VALUE_OFF;
        }
        sb5.append(str);
        sb5.append(" audio");
        CGLog.i(sb5.toString());
        if (this.mStarted.get() && (handler = this.mHandler) != null) {
            Message obtainMessage = handler.obtainMessage();
            obtainMessage.what = 6;
            obtainMessage.obj = Boolean.valueOf(z16);
            this.mHandler.sendMessage(obtainMessage);
        }
    }

    public void switchOnGps(boolean z16) {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("Try to switch ");
        if (z16) {
            str = "on";
        } else {
            str = DebugKt.DEBUG_PROPERTY_VALUE_OFF;
        }
        sb5.append(str);
        sb5.append(" GPS");
        CGLog.i(sb5.toString());
        try {
            if (mEnableLm) {
                if (z16) {
                    registerGps();
                } else {
                    stopGps();
                }
            } else {
                CGLog.i("GPS not enabled, will not switch on/off it");
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void switchOnVoice(boolean z16) {
        String str;
        Handler handler;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("Try to switch ");
        if (z16) {
            str = "on";
        } else {
            str = DebugKt.DEBUG_PROPERTY_VALUE_OFF;
        }
        sb5.append(str);
        sb5.append(" voice");
        CGLog.i(sb5.toString());
        if (this.mStarted.get() && (handler = this.mHandler) != null) {
            Message obtainMessage = handler.obtainMessage();
            obtainMessage.what = 5;
            obtainMessage.obj = Boolean.valueOf(z16);
            this.mHandler.sendMessage(obtainMessage);
        }
    }

    public void switchToPreferredMode(int i3) {
        WebRTCClient webRTCClient = this.mWebRTCClient;
        if (webRTCClient != null) {
            webRTCClient.switchToPreferredMode(i3);
        }
    }

    public void unRegisterDecodeCallback(boolean z16) {
        if (z16) {
            CustomizedVideoDecoderFactory.setCallback(null);
        } else {
            DefaultVideoDecoderFactory.setCallback(null);
        }
    }

    public void unSubscribePriviledge(JSONObject jSONObject) {
        String fillPrividge = fillPrividge(jSONObject);
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(KEY_RIGHTS_UNSUBSCRIBE, fillPrividge);
            sendUnSubScribePriviledge(jSONObject2.toString());
        } catch (Exception e16) {
            CGLog.e("Failed to unSubscribePriviledge, cause " + e16);
        }
    }

    public void updatePriviledges(JSONObject jSONObject) {
        String fillPriviledgeKeyValue = fillPriviledgeKeyValue(jSONObject);
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(KEY_RIGHTS_UPDATE, fillPriviledgeKeyValue);
            sendWebRtcConfig(jSONObject2.toString());
        } catch (Exception e16) {
            CGLog.e("Failed to updatePriviledges, cause " + e16);
        }
    }

    public void videoFilterRelease() {
        VideoFilterController.get().setOpenFsr(false, 0, null);
        FilterSurfaceViewRenderer.clearVideoFilterParams();
    }

    public void virtualGamepadSubscribeNotification(int i3, int[] iArr, int[] iArr2) {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            for (int i16 : iArr) {
                jSONArray.put(i16);
            }
            JSONArray jSONArray2 = new JSONArray();
            for (int i17 : iArr2) {
                jSONArray2.put(i17);
            }
            jSONObject.put("cmd", i3);
            jSONObject.put(AudienceReportConst.CLIENT_TYPE, jSONArray);
            jSONObject.put("event", jSONArray2);
            sendVirtualGamepadSubscribeNotification(jSONObject.toString());
            CGLog.i("virtualGamepadSubscribeNotification: " + jSONObject.toString());
        } catch (Exception e16) {
            CGLog.e("Failed to virtualGamepadSubscribeNotification, cause " + e16);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0044 A[Catch: Exception -> 0x018a, TryCatch #0 {Exception -> 0x018a, blocks: (B:3:0x0005, B:5:0x0013, B:8:0x001b, B:9:0x002e, B:11:0x0032, B:13:0x0036, B:17:0x0044, B:20:0x0062, B:21:0x0065, B:23:0x006c, B:26:0x0073, B:27:0x0076, B:29:0x007b, B:30:0x0080, B:32:0x008d, B:34:0x0091, B:38:0x009d, B:43:0x00bb, B:49:0x013a, B:52:0x00d2, B:53:0x00e1, B:55:0x00ea, B:56:0x00f7, B:57:0x0100, B:59:0x0104, B:61:0x0108, B:63:0x011a, B:64:0x0127, B:66:0x0132, B:68:0x004f, B:69:0x0028), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0062 A[Catch: Exception -> 0x018a, TryCatch #0 {Exception -> 0x018a, blocks: (B:3:0x0005, B:5:0x0013, B:8:0x001b, B:9:0x002e, B:11:0x0032, B:13:0x0036, B:17:0x0044, B:20:0x0062, B:21:0x0065, B:23:0x006c, B:26:0x0073, B:27:0x0076, B:29:0x007b, B:30:0x0080, B:32:0x008d, B:34:0x0091, B:38:0x009d, B:43:0x00bb, B:49:0x013a, B:52:0x00d2, B:53:0x00e1, B:55:0x00ea, B:56:0x00f7, B:57:0x0100, B:59:0x0104, B:61:0x0108, B:63:0x011a, B:64:0x0127, B:66:0x0132, B:68:0x004f, B:69:0x0028), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006c A[Catch: Exception -> 0x018a, TryCatch #0 {Exception -> 0x018a, blocks: (B:3:0x0005, B:5:0x0013, B:8:0x001b, B:9:0x002e, B:11:0x0032, B:13:0x0036, B:17:0x0044, B:20:0x0062, B:21:0x0065, B:23:0x006c, B:26:0x0073, B:27:0x0076, B:29:0x007b, B:30:0x0080, B:32:0x008d, B:34:0x0091, B:38:0x009d, B:43:0x00bb, B:49:0x013a, B:52:0x00d2, B:53:0x00e1, B:55:0x00ea, B:56:0x00f7, B:57:0x0100, B:59:0x0104, B:61:0x0108, B:63:0x011a, B:64:0x0127, B:66:0x0132, B:68:0x004f, B:69:0x0028), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0073 A[Catch: Exception -> 0x018a, TryCatch #0 {Exception -> 0x018a, blocks: (B:3:0x0005, B:5:0x0013, B:8:0x001b, B:9:0x002e, B:11:0x0032, B:13:0x0036, B:17:0x0044, B:20:0x0062, B:21:0x0065, B:23:0x006c, B:26:0x0073, B:27:0x0076, B:29:0x007b, B:30:0x0080, B:32:0x008d, B:34:0x0091, B:38:0x009d, B:43:0x00bb, B:49:0x013a, B:52:0x00d2, B:53:0x00e1, B:55:0x00ea, B:56:0x00f7, B:57:0x0100, B:59:0x0104, B:61:0x0108, B:63:0x011a, B:64:0x0127, B:66:0x0132, B:68:0x004f, B:69:0x0028), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007b A[Catch: Exception -> 0x018a, TryCatch #0 {Exception -> 0x018a, blocks: (B:3:0x0005, B:5:0x0013, B:8:0x001b, B:9:0x002e, B:11:0x0032, B:13:0x0036, B:17:0x0044, B:20:0x0062, B:21:0x0065, B:23:0x006c, B:26:0x0073, B:27:0x0076, B:29:0x007b, B:30:0x0080, B:32:0x008d, B:34:0x0091, B:38:0x009d, B:43:0x00bb, B:49:0x013a, B:52:0x00d2, B:53:0x00e1, B:55:0x00ea, B:56:0x00f7, B:57:0x0100, B:59:0x0104, B:61:0x0108, B:63:0x011a, B:64:0x0127, B:66:0x0132, B:68:0x004f, B:69:0x0028), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0100 A[Catch: Exception -> 0x018a, TryCatch #0 {Exception -> 0x018a, blocks: (B:3:0x0005, B:5:0x0013, B:8:0x001b, B:9:0x002e, B:11:0x0032, B:13:0x0036, B:17:0x0044, B:20:0x0062, B:21:0x0065, B:23:0x006c, B:26:0x0073, B:27:0x0076, B:29:0x007b, B:30:0x0080, B:32:0x008d, B:34:0x0091, B:38:0x009d, B:43:0x00bb, B:49:0x013a, B:52:0x00d2, B:53:0x00e1, B:55:0x00ea, B:56:0x00f7, B:57:0x0100, B:59:0x0104, B:61:0x0108, B:63:0x011a, B:64:0x0127, B:66:0x0132, B:68:0x004f, B:69:0x0028), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x004f A[Catch: Exception -> 0x018a, TryCatch #0 {Exception -> 0x018a, blocks: (B:3:0x0005, B:5:0x0013, B:8:0x001b, B:9:0x002e, B:11:0x0032, B:13:0x0036, B:17:0x0044, B:20:0x0062, B:21:0x0065, B:23:0x006c, B:26:0x0073, B:27:0x0076, B:29:0x007b, B:30:0x0080, B:32:0x008d, B:34:0x0091, B:38:0x009d, B:43:0x00bb, B:49:0x013a, B:52:0x00d2, B:53:0x00e1, B:55:0x00ea, B:56:0x00f7, B:57:0x0100, B:59:0x0104, B:61:0x0108, B:63:0x011a, B:64:0x0127, B:66:0x0132, B:68:0x004f, B:69:0x0028), top: B:2:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private MobileButtonEvent processTouchEvent(MotionEvent motionEvent, int i3, int i16, boolean z16) {
        float x16;
        float y16;
        SurfaceViewRenderer surfaceViewRenderer;
        int width;
        int height;
        float f16;
        float f17;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        int i28;
        int videoSrScale;
        MobileButtonEvent mobileButtonEvent = new MobileButtonEvent();
        try {
            x16 = MotionEventCompat.getX(motionEvent, i16);
            y16 = MotionEventCompat.getY(motionEvent, i16);
            mobileButtonEvent.msgType = i3;
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (i3 != 82 && MotionEventCompat.getActionMasked(motionEvent) != 3) {
            mobileButtonEvent.pId = motionEvent.getPointerId(motionEvent.getAction() >> 8);
            surfaceViewRenderer = this.mSurfaceView;
            if (surfaceViewRenderer != null && this.mTextureView == null) {
                mobileButtonEvent.pX = (short) 0;
                mobileButtonEvent.pY = (short) 0;
                CGLog.i("User touch received when SurfaceView and TextureView is null");
                return mobileButtonEvent;
            }
            if (surfaceViewRenderer == null) {
                width = surfaceViewRenderer.getWidth();
                height = this.mSurfaceView.getHeight();
            } else {
                width = this.mTextureView.getWidth();
                height = this.mTextureView.getHeight();
            }
            if (x16 < 0.0f) {
                mobileButtonEvent.msgType = 81;
                x16 = 0.0f;
            }
            f16 = width - 1;
            if (x16 > f16) {
                mobileButtonEvent.msgType = 81;
                x16 = f16;
            }
            if (y16 < 0.0f) {
                mobileButtonEvent.msgType = 81;
                y16 = 0.0f;
            }
            f17 = height;
            if (y16 > f17) {
                y16 = height - 1;
                mobileButtonEvent.msgType = 81;
            }
            mobileButtonEvent.pLast = z16;
            i17 = 1;
            if (VideoFilterController.get().isOpenVideoSr() && VideoSR.predictResCode_ == 0 && (videoSrScale = VideoFilterController.get().getVideoSrScale()) >= 1) {
                i17 = videoSrScale;
            }
            i18 = mHeight / i17;
            i19 = mWidth / i17;
            float f18 = (x16 * 1.0f) / width;
            float f19 = (1.0f * y16) / f17;
            i26 = mDegree;
            if (i26 != 90 && i26 != 270) {
                i28 = i18;
                i27 = i19;
                short s16 = (short) (i27 * f18);
                mobileButtonEvent.pX = s16;
                short s17 = (short) (i28 * f19);
                mobileButtonEvent.pY = s17;
                if (i26 == 90) {
                    if (i26 != 180) {
                        if (i26 == 270) {
                            if (i19 > i18) {
                                float f26 = i19;
                                mobileButtonEvent.pX = (short) (f26 - (f18 * f26));
                                float f27 = i18;
                                mobileButtonEvent.pY = (short) (f27 - (f19 * f27));
                            } else {
                                mobileButtonEvent.pY = (short) (i18 - s16);
                                mobileButtonEvent.pX = s17;
                            }
                        }
                    } else if (i19 > i18) {
                        mobileButtonEvent.pX = (short) (i19 * f18);
                        mobileButtonEvent.pY = (short) (i18 * f19);
                    } else {
                        mobileButtonEvent.pX = (short) (i19 - s16);
                        mobileButtonEvent.pY = (short) (i18 - s17);
                    }
                } else if (mSkipRender && mContainerOrientation == 270) {
                    float f28 = i19;
                    mobileButtonEvent.pX = (short) (f28 - (f18 * f28));
                    mobileButtonEvent.pY = (short) (i18 - (f28 * f19));
                } else if (i19 > i18) {
                    mobileButtonEvent.pX = (short) (i19 * f18);
                    mobileButtonEvent.pY = (short) (i18 * f19);
                } else {
                    short s18 = (short) (i19 - s17);
                    mobileButtonEvent.pX = s18;
                    mobileButtonEvent.pY = s16;
                    if (mContainerOrientation == 270) {
                        mobileButtonEvent.pX = (short) (i19 - s18);
                        mobileButtonEvent.pY = (short) (i18 - s16);
                    }
                }
                CGLog.v(" type=" + i3 + " x=" + x16 + " y=" + y16 + " w=" + width + " h=" + height + " pX=" + ((int) mobileButtonEvent.pX) + " pY=" + ((int) mobileButtonEvent.pY));
                return mobileButtonEvent;
            }
            i27 = i18;
            i28 = i19;
            short s162 = (short) (i27 * f18);
            mobileButtonEvent.pX = s162;
            short s172 = (short) (i28 * f19);
            mobileButtonEvent.pY = s172;
            if (i26 == 90) {
            }
            CGLog.v(" type=" + i3 + " x=" + x16 + " y=" + y16 + " w=" + width + " h=" + height + " pX=" + ((int) mobileButtonEvent.pX) + " pY=" + ((int) mobileButtonEvent.pY));
            return mobileButtonEvent;
        }
        mobileButtonEvent.pId = motionEvent.getPointerId(i16);
        surfaceViewRenderer = this.mSurfaceView;
        if (surfaceViewRenderer != null) {
        }
        if (surfaceViewRenderer == null) {
        }
        if (x16 < 0.0f) {
        }
        f16 = width - 1;
        if (x16 > f16) {
        }
        if (y16 < 0.0f) {
        }
        f17 = height;
        if (y16 > f17) {
        }
        mobileButtonEvent.pLast = z16;
        i17 = 1;
        if (VideoFilterController.get().isOpenVideoSr()) {
            i17 = videoSrScale;
        }
        i18 = mHeight / i17;
        i19 = mWidth / i17;
        float f182 = (x16 * 1.0f) / width;
        float f192 = (1.0f * y16) / f17;
        i26 = mDegree;
        if (i26 != 90) {
            i28 = i18;
            i27 = i19;
            short s1622 = (short) (i27 * f182);
            mobileButtonEvent.pX = s1622;
            short s1722 = (short) (i28 * f192);
            mobileButtonEvent.pY = s1722;
            if (i26 == 90) {
            }
            CGLog.v(" type=" + i3 + " x=" + x16 + " y=" + y16 + " w=" + width + " h=" + height + " pX=" + ((int) mobileButtonEvent.pX) + " pY=" + ((int) mobileButtonEvent.pY));
            return mobileButtonEvent;
        }
        i27 = i18;
        i28 = i19;
        short s16222 = (short) (i27 * f182);
        mobileButtonEvent.pX = s16222;
        short s17222 = (short) (i28 * f192);
        mobileButtonEvent.pY = s17222;
        if (i26 == 90) {
        }
        CGLog.v(" type=" + i3 + " x=" + x16 + " y=" + y16 + " w=" + width + " h=" + height + " pX=" + ((int) mobileButtonEvent.pX) + " pY=" + ((int) mobileButtonEvent.pY));
        return mobileButtonEvent;
    }

    public boolean sendDeviceCreateEvent(int i3, int i16, int i17, boolean z16) {
        try {
            if (this.mWebRTCClient == null) {
                return false;
            }
            int i18 = z16 ? 111 : 93;
            ByteBuffer order = ByteBuffer.allocate(15).order(ByteOrder.LITTLE_ENDIAN);
            order.put(0, (byte) i18);
            order.putInt(1, 10);
            order.putShort(5, (short) 257);
            order.putShort(7, (short) 1);
            order.putShort(9, (short) i3);
            order.putShort(11, (short) i16);
            order.putShort(13, (short) i17);
            this.mWebRTCClient.sendMessageViaDataChannel(order);
            CGLog.i("send device create event deviceType = " + i3 + " deviceId = " + i16 + " mapMode = " + i17);
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public boolean sendDeviceDetroyEvent(int i3, int i16, int i17, boolean z16) {
        try {
            if (this.mWebRTCClient == null) {
                return false;
            }
            int i18 = z16 ? 111 : 93;
            ByteBuffer order = ByteBuffer.allocate(15).order(ByteOrder.LITTLE_ENDIAN);
            order.put(0, (byte) i18);
            order.putInt(1, 10);
            order.putShort(5, (short) 257);
            order.putShort(7, (short) 2);
            order.putShort(9, (short) i3);
            order.putShort(11, (short) i16);
            order.putShort(13, (short) i17);
            this.mWebRTCClient.sendMessageViaDataChannel(order);
            CGLog.i("send device destroy event deviceType = " + i3 + " deviceId = " + i16 + " mapMode = " + i17);
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public boolean sendGamepadKeyEvent(int i3, int i16, int i17, int i18, int i19, boolean z16) {
        try {
            return sendGamepadKeyEvent(GamepadEventManage.getKeyEvent(i3, i16, i17, i18, i19), z16);
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public boolean sendGamepadMotionEvent(MotionEvent motionEvent, int i3, int i16, boolean z16) {
        try {
            GamepadMotionEvent motionEvent2 = GamepadEventManage.getMotionEvent(motionEvent, i3, i16);
            if (motionEvent2 == null) {
                return false;
            }
            r0 = motionEvent2.mDataLength != 0 ? sendGamepadMotionEvent(motionEvent2, z16) : false;
            return (motionEvent2.mUseDpadKeyEvent && motionEvent2.mHasKeyEvent) ? r0 | sendGamepadKeyEvent(motionEvent2.mKeyEvent, z16) : r0;
        } catch (Exception e16) {
            e16.printStackTrace();
            return r0;
        }
    }

    public boolean sendGamepadKeyEvent(GamepadKeyEvent gamepadKeyEvent) {
        return sendGamepadKeyEvent(gamepadKeyEvent, false);
    }

    public boolean sendGamepadKeyEvent(GamepadKeyEvent gamepadKeyEvent, boolean z16) {
        if (gamepadKeyEvent == null) {
            return false;
        }
        try {
            if (gamepadKeyEvent.mKeyCode == -1 || this.mWebRTCClient == null) {
                return false;
            }
            ByteBuffer order = ByteBuffer.allocate(21).order(ByteOrder.LITTLE_ENDIAN);
            if (z16) {
                order.put(0, PublicAccountH5AbilityPluginImpl.OPENIMG);
            } else {
                order.put(0, (byte) 93);
            }
            order.putInt(1, 16);
            order.putShort(5, (short) 257);
            order.putShort(7, (short) gamepadKeyEvent.mCmdType);
            order.putShort(9, (short) gamepadKeyEvent.mDeviceId);
            order.putInt(11, gamepadKeyEvent.mSource);
            order.putInt(15, gamepadKeyEvent.mKeyCode);
            order.putShort(19, (short) gamepadKeyEvent.mAction);
            this.mWebRTCClient.sendMessageViaDataChannel(order);
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public boolean sendGamepadMotionEvent(GamepadMotionEvent gamepadMotionEvent) {
        return sendGamepadMotionEvent(gamepadMotionEvent, false);
    }

    public boolean sendGamepadMotionEvent(GamepadMotionEvent gamepadMotionEvent, boolean z16) {
        if (gamepadMotionEvent == null) {
            return false;
        }
        try {
            if (this.mWebRTCClient == null) {
                return false;
            }
            int i3 = gamepadMotionEvent.mDataLength + 10;
            ByteBuffer order = ByteBuffer.allocate(i3 + 5).order(ByteOrder.LITTLE_ENDIAN);
            if (z16) {
                order.put(0, PublicAccountH5AbilityPluginImpl.OPENIMG);
            } else {
                order.put(0, (byte) 93);
            }
            order.putInt(1, i3);
            order.putShort(5, (short) 257);
            order.putShort(7, (short) gamepadMotionEvent.mCmdType);
            order.putShort(9, (short) gamepadMotionEvent.mDeviceId);
            order.putInt(11, gamepadMotionEvent.mSource);
            int i16 = 15;
            for (int i17 = 0; i17 < 8; i17++) {
                int i18 = gamepadMotionEvent.mAxisTypes[i17];
                if (i18 != -1) {
                    order.putShort(i16, (short) i18);
                    int i19 = i16 + 2;
                    order.putFloat(i19, gamepadMotionEvent.mAxisValues[i17]);
                    i16 = i19 + 4;
                }
            }
            this.mWebRTCClient.sendMessageViaDataChannel(order);
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public boolean sendVirtualGamepadEvent(int i3, String str) {
        try {
            if (this.mWebRTCClient != null && str != null) {
                byte[] bytes = str.getBytes("UTF8");
                int length = bytes.length + 1;
                ByteBuffer order = ByteBuffer.allocate(length + 2).order(ByteOrder.LITTLE_ENDIAN);
                order.put(0, (byte) 95);
                order.put(1, (byte) length);
                order.put(2, (byte) i3);
                int i16 = 3;
                for (byte b16 : bytes) {
                    order.put(i16, b16);
                    i16++;
                }
                this.mWebRTCClient.sendMessageViaDataChannel(order);
                CGLog.i("send virtual gamepad event !!!!!" + i3);
                return true;
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return false;
    }

    public static void setDeviceType(boolean z16) {
    }

    public WebRTCSDK(Context context, CGSessionCtx cGSessionCtx, TextureViewRenderer textureViewRenderer, WebRTCEvents webRTCEvents) {
        this.mEnableTrace = false;
        this.mCtx = context;
        this.mTextureView = textureViewRenderer;
        CGLog.i("WebRTCSDK use TextureView");
        this.mEglBase = org.tencwebrtc.g.a();
        this.mWebrtcEventObserver = webRTCEvents;
        this.mSessionCtx = cGSessionCtx;
        WebRTCParameters webRTCParameters = cGSessionCtx.pWebRTCParameters;
        this.mWebRTCParameters = webRTCParameters;
        EglRenderer.enableLogToDebugOutput(WebRTCParameters.isEnableLogToDebugOutput());
        if (!webRTCParameters.isHwDecode()) {
            mSkipRender = false;
            CGLog.i("Force mSkipRender to false for sw decode");
        }
        if (webRTCParameters.getLoggingSeverity() == Logging.Severity.LS_VERBOSE) {
            this.mEnableTrace = true;
        }
        try {
            if (cGSessionCtx.pEnableTdmReport) {
                CGTdmDataReport.init(context);
            }
        } catch (Throwable unused) {
            CGLog.e("failed to init CGTdmDataReport");
        }
        this.mDeviceConfig = cGSessionCtx.pDeviceConfig;
        initVideoRenderView();
        this.mSensors = new int[35];
        this.mSensorCfg = new SensorConfig();
        this.mPerfConfig = new PerfMonitorConfig();
        this.mStutter = new int[8];
        this.mStutterTime = new long[3];
        initTouchHandlerThread();
        initCgInput(context);
    }
}
