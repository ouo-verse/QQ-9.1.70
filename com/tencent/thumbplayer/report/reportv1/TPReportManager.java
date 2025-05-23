package com.tencent.thumbplayer.report.reportv1;

import android.annotation.SuppressLint;
import android.app.UiModeManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.thumbplayer.api.manager.TPMgrConfig;
import com.tencent.thumbplayer.api.report.v1.ITPBusinessReportManager;
import com.tencent.thumbplayer.api.report.v1.TPDefaultReportInfo;
import com.tencent.thumbplayer.api.report.v1.TPLiveReportInfo;
import com.tencent.thumbplayer.api.report.v1.TPVodReportInfo;
import com.tencent.thumbplayer.common.TPHashMapBuilder;
import com.tencent.thumbplayer.common.TPVersion;
import com.tencent.thumbplayer.common.cache.TPLocalCacheReaderWriter;
import com.tencent.thumbplayer.common.config.TPConfig;
import com.tencent.thumbplayer.common.log.TPLogUtil;
import com.tencent.thumbplayer.common.thread.TPThreadPool;
import com.tencent.thumbplayer.core.utils.TPSystemInfo;
import com.tencent.thumbplayer.report.ITPReportProperties;
import com.tencent.thumbplayer.report.TPBeaconReportWrapper;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import com.tencent.thumbplayer.report.reportv1.TPReportParams;
import com.tencent.thumbplayer.tpplayer.plugin.ITPPluginBase;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;
import org.apache.httpcore.message.TokenParser;
import org.json.JSONObject;

/* loaded from: classes26.dex */
public class TPReportManager implements ITPPluginBase, ITPBusinessReportManager {
    private static final boolean APP_STATE_BACKGROUND = false;
    private static final boolean APP_STATE_FOREGROUND = true;
    private static final int BUFFERING_DURATION_THRESHOLD_MS = 1200;
    private static final int DEVICE_TYPE_AN_PAD = 5;
    private static final int DEVICE_TYPE_AN_PHONE = 2;
    private static final int DEVICE_TYPE_AN_TV = 9;
    private static final String EVENT_KEY_BUFFERING = "second_buffering";
    private static final String EVENT_KEY_FIRST_LOAD = "first_load";
    private static final String EVENT_KEY_FIRST_RENDERING = "first_rendering";
    private static final String EVENT_KEY_GET_CDN_URL = "get_cdn_url";
    private static final String EVENT_KEY_INIT_PLAYER = "init_player";
    private static final String EVENT_KEY_LIVE_FIRST_LOAD = "live_loading";
    private static final String EVENT_KEY_LIVE_PERIOD = "live_period";
    private static final String EVENT_KEY_LIVE_PLAY_ERROR = "live_error";
    private static final String EVENT_KEY_LOAD_SUBTITLE = "load_subtitle";
    private static final String EVENT_KEY_PLAY_DONE = "play_done";
    private static final String EVENT_KEY_REDIRECT = "302_redirect";
    private static final String EVENT_KEY_USER_SEEK = "user_seek";
    private static final String LIVE_HLS_M3U8_TAG_PREFIX = "#EXT-X-PROGRAM-DATE-TIME:";
    private static final int LIVE_REPORT_PERIOD = 60000;
    private static final int MAX_BUFFERING_REPORT_COUNT = 20;
    private static final int MAX_SEEK_REPORT_COUNT = 20;
    private static final String PROXY_HITDOWNLOADED_KEY = "hitDownloaded";
    private static final String REPORT_DATA_CACHE_NAME = "TPReportCache";
    private static final String TAG = "TPReportManager";
    private static final int VOD_HIT_DOWNLOADED_UNSET = -1;
    private Context mContext;
    private EventHandler mEventHandler;
    private HandlerThread mReportThread;
    private static final String OS_VERSION = String.format("Android %s", TPSystemInfo.getOsVersion());
    private static String sDisplayResolutionReportString = "";
    private static boolean hasReportLastEvent = false;
    private static TPLocalCacheReaderWriter mCache = null;
    private final Object mExitLock = new Object();
    private final ParamRecord mParamRecord = new ParamRecord();
    private boolean mIsExit = false;
    private TPDefaultReportInfo mReportInfoGetter = null;
    private TPReportParams mReportParams = null;
    private int mPlayScene = 1;
    private int mLastEvent = 0;
    private boolean mIsPlayDone = true;
    private boolean mAppState = true;
    private boolean mIsPrepare = false;
    private boolean mIsLoadingSubtitle = false;
    private long mPlayStartTimeMs = 0;
    private long mPlayDurationMs = 0;
    private int mSignalStrength = 81;
    private int mNetworkSpeed = 0;
    private int mSeekBufferingDuration = 0;
    private int mSeekBufferingCount = 0;
    private boolean mIsSeeking = false;
    private boolean mIsBuffering = false;
    private boolean mIsUseP2P = false;
    private String mErrorCode = "0";
    private String mProto = "";
    private String mProtoVer = "";
    private String mFlowId = "";
    private int mPlayerType = 0;
    private int mDownloadType = 0;
    private String mMediaResolution = "";
    private int mMediaRate = 0;
    private long mMediaDurationMs = 0;
    private int mPlayType = -1;
    private IReportHandler mReportHandler = new DefaultReportHandler();
    private double mSamplingRate = 1.0d;
    private boolean mNeedReportToBeacon = true;
    private TPReportParams.BufferingOnceParams mCurBufferingParams = null;
    private TPReportParams.UserSeekOnceParams mCurSeekParams = null;

    /* loaded from: classes26.dex */
    class DefaultReportHandler implements IReportHandler {
        DefaultReportHandler() {
        }

        @Override // com.tencent.thumbplayer.report.reportv1.TPReportManager.IReportHandler
        public void handleReportEvent(int i3, @NonNull ITPReportProperties iTPReportProperties) {
            boolean z16;
            if (i3 > 30) {
                z16 = false;
            } else {
                z16 = true;
            }
            TPReportManager.this.updateCommonParam(iTPReportProperties, i3, z16);
            TPReportManager.this.onReportEvent(iTPReportProperties);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public class EventHandler extends Handler {
        private static final int MSG_302_REDIRECT = 2001;
        private static final int MSG_APP_BACKGROUND = 2100;
        private static final int MSG_APP_FOREGROUND = 2101;
        private static final int MSG_BUFFERING_END = 1014;
        private static final int MSG_BUFFERING_START = 1013;
        private static final int MSG_CDN_UPDATE = 1018;
        private static final int MSG_CREATE_DONE = 1000;
        private static final int MSG_CREATE_START = 999;
        private static final int MSG_DOWNLOAD_UPDATE = 1017;
        private static final int MSG_EARLY_ERROR = 2003;
        private static final int MSG_EXIT_THREAD = 100;
        private static final int MSG_FIRSTCLIP_OPEN = 1022;
        private static final int MSG_FIRST_PACKET = 1019;
        private static final int MSG_GET_CDN = 2000;
        private static final int MSG_HLS_PRIVATE_TAG = 1016;
        private static final int MSG_LIVE_PERIOD_REPORT = 3000;
        private static final int MSG_LOAD_SUBTITLE = 2002;
        private static final int MSG_PLAYER_ERROR = 1006;
        private static final int MSG_PLAYER_PAUSE = 1004;
        private static final int MSG_PLAYER_RELEASE = 1010;
        private static final int MSG_PLAYER_RESET = 1011;
        private static final int MSG_PLAYER_STOP = 1005;
        private static final int MSG_PLAY_COMPLETE = 1009;
        private static final int MSG_PREPARE_DONE = 1002;
        private static final int MSG_PROTOCOL_UPDATE = 1023;
        private static final int MSG_RENDERING_START = 1012;
        private static final int MSG_REPORT_LAST_EVENT = 4000;
        private static final int MSG_SEEK_COMPLETE = 1008;
        private static final int MSG_SELECT_TRACK = 2004;
        private static final int MSG_SELECT_TRACK_DONE = 2005;
        private static final int MSG_SET_PLAY_SPEED = 1015;
        private static final int MSG_START_PLAY = 1003;
        private static final int MSG_START_PREPARE = 1001;
        private static final int MSG_START_SEEK = 1007;
        private static final int MSG_SWITCH_DEF = 1020;
        private static final int MSG_SWITCH_DEF_END = 1021;

        EventHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Map map;
            Object obj = message.obj;
            if (obj instanceof Map) {
                map = (Map) obj;
            } else {
                map = null;
            }
            int i3 = message.what;
            if (i3 == 100) {
                TPReportManager.this.handleReportThreadExit();
                return;
            }
            if (i3 == 3000) {
                TPReportManager.this.onLivePeriodReport();
                return;
            }
            if (i3 == 4000) {
                TPReportManager.this.onReportLastEvent();
                return;
            }
            if (i3 == 2100) {
                TPReportManager.this.onAppBackground();
                return;
            }
            if (i3 != 2101) {
                switch (i3) {
                    case 999:
                        TPReportManager.this.onPlayerCreateStart(map);
                        return;
                    case 1000:
                        TPReportManager.this.onPlayerCreateDone(map);
                        return;
                    case 1001:
                        TPReportManager.this.onStartPrepare(map);
                        return;
                    case 1002:
                        TPReportManager.this.onPrepareDone(map);
                        return;
                    case 1003:
                        TPReportManager.this.onStartPlayer(map);
                        return;
                    case 1004:
                        TPReportManager.this.onPlayerPause(map);
                        return;
                    case 1005:
                        TPReportManager.this.onPlayerStop(map);
                        return;
                    case 1006:
                        TPReportManager.this.onPlayerError(map);
                        return;
                    case 1007:
                        TPReportManager.this.onStartSeek(map);
                        return;
                    case 1008:
                        TPReportManager.this.onSeekComplete(map);
                        return;
                    case 1009:
                        TPReportManager.this.onPlayComplete(map);
                        return;
                    case 1010:
                        TPReportManager.this.onPlayerRelease(map);
                        return;
                    case 1011:
                        TPReportManager.this.onPlayerReset(map);
                        return;
                    case 1012:
                        TPReportManager.this.onRenderingStart(map);
                        return;
                    case 1013:
                        TPReportManager.this.onBufferingStart(map);
                        return;
                    case 1014:
                        TPReportManager.this.onBufferingEnd(map);
                        return;
                    case 1015:
                        TPReportManager.this.onSetPlaySpeed(map);
                        return;
                    case 1016:
                        if (obj instanceof String) {
                            TPReportManager.this.onHandleHlsTag((String) obj);
                            return;
                        }
                        return;
                    case 1017:
                        TPReportManager.this.onProxyInfoUpdate(map);
                        return;
                    case 1018:
                        TPReportManager.this.onCdnInfoUpdate(map);
                        return;
                    case 1019:
                        TPReportManager.this.onFirstPacketRead(map);
                        return;
                    case 1020:
                        TPReportManager.this.onSwitchDef(map);
                        return;
                    case 1021:
                        TPReportManager.this.onSwitchDefEnd(map);
                        return;
                    case 1022:
                        TPReportManager.this.onFirstClipOpen(map);
                        return;
                    case 1023:
                        TPReportManager.this.onReportProtocolUpdate(map);
                        return;
                    default:
                        switch (i3) {
                            case 2000:
                                TPReportManager.this.onGetCdn(map);
                                return;
                            case 2001:
                                TPReportManager.this.on302Redirect(map);
                                return;
                            case 2002:
                                TPReportManager.this.onLoadSubtitle(map);
                                return;
                            case 2003:
                                TPReportManager.this.onPlayerEarlyError(map);
                                return;
                            case 2004:
                                TPReportManager.this.onSelectTrack(map);
                                return;
                            case 2005:
                                TPReportManager.this.onSelectTrackDone(map);
                                return;
                            default:
                                return;
                        }
                }
            }
            TPReportManager.this.onAppForeground();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes26.dex */
    public interface IReportHandler {
        void handleReportEvent(int i3, @NonNull ITPReportProperties iTPReportProperties);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes26.dex */
    public class LiveReportHandler implements IReportHandler {
        LiveReportHandler() {
        }

        @Override // com.tencent.thumbplayer.report.reportv1.TPReportManager.IReportHandler
        public void handleReportEvent(int i3, @NonNull ITPReportProperties iTPReportProperties) {
            boolean z16;
            TPProperties tPProperties = new TPProperties();
            if (i3 > 30 && i3 != 263) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (i3 != 30) {
                if (i3 != 50) {
                    if (i3 != 150) {
                        if (i3 != 263) {
                            return;
                        }
                        TPReportManager.this.mEventHandler.removeMessages(3000);
                        TPReportManager.this.mEventHandler.sendEmptyMessageDelayed(3000, 60000L);
                    } else {
                        TPReportManager.this.mEventHandler.removeMessages(3000);
                    }
                } else {
                    TPReportManager.this.mEventHandler.removeMessages(3000);
                    i3 = 263;
                }
            } else {
                i3 = 205;
            }
            TPReportManager.this.updateCommonParam(tPProperties, i3, z16);
            TPReportManager.this.updateLiveExParam(tPProperties, z16);
            if (i3 != 205) {
                tPProperties.put(TPReportKeys.LiveExKeys.LIVE_EX_LOADING_TIME, 0);
            }
            TPLogUtil.i(TPReportManager.TAG, "liveExParam.prePlayLengthInt: " + TPReportManager.this.mReportParams.getLiveExParam().prePlayLengthInt);
            TPReportManager.this.onReportEvent(tPProperties);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public class ParamRecord {
        int bufferingCount;
        int bufferingDurationMs;
        String cdnIp;
        String cdnUip;
        String cdnUrl;
        String defId;
        long endBufferingTimeMs;
        long endPrepareTimeMs;
        int getSpeedCnt;
        int hitDownloaded;
        boolean isMultiTrack;
        boolean isSelectedSubtitle;
        boolean isSwitchingDef;
        int liveDelayMs;
        int maxSpeed;
        int playDurationMs;
        String spanId;
        long startBufferingTimeMs;
        long startPlayTimeMs;
        long startPrepareTimeMs;
        ArrayList<SubtitleInfo> subtitleInfos;
        int totalSpeed;
        String tuid;

        ParamRecord() {
            this.startPlayTimeMs = 0L;
            this.playDurationMs = 0;
            this.startPrepareTimeMs = 0L;
            this.endPrepareTimeMs = 0L;
            this.bufferingCount = 0;
            this.bufferingDurationMs = 0;
            this.startBufferingTimeMs = 0L;
            this.endBufferingTimeMs = 0L;
            this.liveDelayMs = 0;
            this.maxSpeed = 0;
            this.totalSpeed = 0;
            this.getSpeedCnt = 0;
            this.isSelectedSubtitle = false;
            this.isMultiTrack = false;
            this.isSwitchingDef = false;
            this.hitDownloaded = -1;
            this.defId = "";
            this.cdnUrl = "";
            this.cdnIp = "";
            this.cdnUip = "";
            this.spanId = "";
            this.tuid = "";
            this.subtitleInfos = new ArrayList<>();
        }

        void reset() {
            this.startPlayTimeMs = 0L;
            this.playDurationMs = 0;
            this.startPrepareTimeMs = 0L;
            this.endPrepareTimeMs = 0L;
            this.bufferingCount = 0;
            this.bufferingDurationMs = 0;
            this.startBufferingTimeMs = 0L;
            this.endBufferingTimeMs = 0L;
            this.liveDelayMs = 0;
            this.maxSpeed = 0;
            this.totalSpeed = 0;
            this.getSpeedCnt = 0;
            this.isSelectedSubtitle = false;
            this.isMultiTrack = false;
            this.isSwitchingDef = false;
            this.hitDownloaded = -1;
            this.defId = "";
            this.cdnUrl = "";
            this.cdnIp = "";
            this.cdnUip = "";
            this.spanId = "";
            this.tuid = "";
            this.subtitleInfos.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public class SubtitleInfo {
        String name;
        long opaque = -1;
        String url;

        SubtitleInfo(String str, String str2) {
            this.name = str;
            this.url = str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes26.dex */
    public class VodReportHandler implements IReportHandler {
        VodReportHandler() {
        }

        @Override // com.tencent.thumbplayer.report.reportv1.TPReportManager.IReportHandler
        public void handleReportEvent(int i3, @NonNull ITPReportProperties iTPReportProperties) {
            boolean z16;
            if (i3 > 30) {
                z16 = false;
            } else {
                z16 = true;
            }
            TPReportManager.this.updateCommonParam(iTPReportProperties, i3, z16);
            TPReportManager.this.updateVodExParam(iTPReportProperties, z16);
            TPReportManager.this.onReportEvent(iTPReportProperties);
        }
    }

    public TPReportManager(Context context) {
        this.mContext = context.getApplicationContext();
    }

    private String getDeviceResolution() {
        if (this.mContext == null) {
            return "0";
        }
        if (!TextUtils.isEmpty(sDisplayResolutionReportString)) {
            return sDisplayResolutionReportString;
        }
        int i3 = this.mContext.getResources().getDisplayMetrics().widthPixels;
        String str = this.mContext.getResources().getDisplayMetrics().heightPixels + "*" + i3;
        sDisplayResolutionReportString = str;
        return str;
    }

    private int getDeviceType() {
        UiModeManager uiModeManager = (UiModeManager) this.mContext.getSystemService("uimode");
        if (uiModeManager == null) {
            return 2;
        }
        if (uiModeManager.getCurrentModeType() == 4) {
            return 9;
        }
        if ((this.mContext.getResources().getConfiguration().screenLayout & 15) < 3) {
            return 2;
        }
        return 5;
    }

    private static String getEventId(int i3) {
        if (i3 != 5) {
            if (i3 != 15) {
                if (i3 != 30) {
                    if (i3 != 40) {
                        if (i3 != 50) {
                            if (i3 != 150) {
                                if (i3 != 205) {
                                    if (i3 != 263) {
                                        switch (i3) {
                                            case 32:
                                                return EVENT_KEY_FIRST_RENDERING;
                                            case 33:
                                                return EVENT_KEY_LOAD_SUBTITLE;
                                            case 34:
                                                return EVENT_KEY_REDIRECT;
                                            case 35:
                                                return EVENT_KEY_BUFFERING;
                                            default:
                                                return "";
                                        }
                                    }
                                    return EVENT_KEY_LIVE_PERIOD;
                                }
                                return EVENT_KEY_LIVE_FIRST_LOAD;
                            }
                            return EVENT_KEY_LIVE_PLAY_ERROR;
                        }
                        return EVENT_KEY_PLAY_DONE;
                    }
                    return EVENT_KEY_USER_SEEK;
                }
                return EVENT_KEY_FIRST_LOAD;
            }
            return EVENT_KEY_GET_CDN_URL;
        }
        return EVENT_KEY_INIT_PLAYER;
    }

    private void getHitDownloadedInfo(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(PROXY_HITDOWNLOADED_KEY)) {
                ParamRecord paramRecord = this.mParamRecord;
                if (paramRecord.hitDownloaded == -1) {
                    paramRecord.hitDownloaded = jSONObject.getInt(PROXY_HITDOWNLOADED_KEY);
                }
            }
        } catch (Exception e16) {
            TPLogUtil.e(TAG, e16);
        }
    }

    private boolean getMapValueBool(Map<String, Object> map, String str, boolean z16) {
        if (map == null) {
            return z16;
        }
        Object obj = map.get(str);
        if (obj != null) {
            return ((Boolean) obj).booleanValue();
        }
        return z16;
    }

    private float getMapValueFloat(Map<String, Object> map, String str, float f16) {
        if (map == null) {
            return f16;
        }
        Object obj = map.get(str);
        if (obj != null) {
            return ((Float) obj).floatValue();
        }
        return f16;
    }

    private int getMapValueInteger(Map<String, Object> map, String str, int i3) {
        if (map == null) {
            return i3;
        }
        Object obj = map.get(str);
        if (obj != null) {
            return ((Integer) obj).intValue();
        }
        return i3;
    }

    private long getMapValueLong(Map<String, Object> map, String str, long j3) {
        if (map == null) {
            return j3;
        }
        Object obj = map.get(str);
        if (obj != null) {
            return ((Long) obj).longValue();
        }
        return j3;
    }

    private String getMapValueString(Map<String, Object> map, String str, String str2) {
        if (map == null) {
            return str2;
        }
        Object obj = map.get(str);
        if (obj != null) {
            return (String) obj;
        }
        return str2;
    }

    private int getMobileSubType(int i3) {
        switch (i3) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return 2;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return 3;
            case 13:
                return 4;
            default:
                return 0;
        }
    }

    @SuppressLint({"MissingPermission"})
    private int getNetWorkType() {
        NetworkInfo activeNetworkInfo;
        int mobileSubType;
        Context context = this.mContext;
        if (context == null) {
            return 0;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) {
                return 0;
            }
            int type = NetworkMonitor.getType(activeNetworkInfo);
            if (type != 0) {
                mobileSubType = 1;
                if (type != 1) {
                    if (type != 9) {
                        return 0;
                    }
                    mobileSubType = 10;
                }
            } else {
                mobileSubType = getMobileSubType(NetworkMonitor.getSubtype(activeNetworkInfo));
            }
            return mobileSubType;
        } catch (Exception e16) {
            TPLogUtil.e(TAG, e16);
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleReportThreadExit() {
        TPLogUtil.d(TAG, "handleReportThreadExit");
        synchronized (this.mExitLock) {
            this.mIsExit = true;
            this.mExitLock.notify();
        }
    }

    private void init() {
        this.mReportThread = TPThreadPool.getInstance().obtainHandleThread("TPReportThread");
        this.mEventHandler = new EventHandler(this.mReportThread.getLooper());
        this.mReportParams = new TPReportParams();
        synchronized (TPReportManager.class) {
            if (mCache == null) {
                mCache = new TPLocalCacheReaderWriter(this.mContext, REPORT_DATA_CACHE_NAME);
            }
            if (!hasReportLastEvent) {
                this.mEventHandler.obtainMessage(4000).sendToTarget();
            }
            hasReportLastEvent = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void on302Redirect(Map<String, Object> map) {
        if (map == null) {
            TPLogUtil.w(TAG, "on302Redirect with null info");
            return;
        }
        TPReportParams.RedirectParams redirectParams = this.mReportParams.getRedirectParams();
        redirectParams.cdnTypeInt = getMapValueInteger(map, TPReportKeys.PlayerStep.PLAYER_CDN_TYPE, 0);
        redirectParams.redirectCountInt = getMapValueInteger(map, TPReportKeys.PlayerStep.PLAYER_T302, 0);
        redirectParams.redirectedUrlString = getMapValueString(map, "url", "");
        redirectParams.starTimeUnix = getMapValueLong(map, TPReportKeys.PlayerStep.PLAYER_START_TIME, 0L);
        redirectParams.endTimeUnix = getMapValueLong(map, TPReportKeys.PlayerStep.PLAYER_END_TIME, 0L);
        redirectParams.errCodeString = getMapValueString(map, "code", "0");
        TPProperties tPProperties = new TPProperties();
        redirectParams.paramsToProperties(tPProperties);
        this.mReportHandler.handleReportEvent(34, tPProperties);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAppBackground() {
        TPLogUtil.i(TAG, "onAppBackground");
        if (!this.mIsPlayDone && this.mPlayType != 1 && this.mAppState) {
            this.mAppState = false;
            TPProperties tPProperties = new TPProperties();
            this.mReportParams.getBufferingTotalParams().paramsToProperties(tPProperties);
            this.mReportParams.getUserSeekTotalParams().paramsToProperties(tPProperties);
            TPReportParams.PlayDoneParams playDoneParams = this.mReportParams.getPlayDoneParams();
            playDoneParams.endTimeUnix = System.currentTimeMillis();
            playDoneParams.reasonInt = 2;
            playDoneParams.errCodeString = this.mErrorCode;
            ParamRecord paramRecord = this.mParamRecord;
            if (paramRecord.startPlayTimeMs > 0) {
                int i3 = paramRecord.playDurationMs;
                long currentTimeMillis = System.currentTimeMillis();
                ParamRecord paramRecord2 = this.mParamRecord;
                paramRecord.playDurationMs = i3 + ((int) (currentTimeMillis - paramRecord2.startPlayTimeMs));
                paramRecord2.startPlayTimeMs = 0L;
            }
            long j3 = this.mPlayStartTimeMs;
            if (j3 > 0) {
                this.mPlayDurationMs += playDoneParams.endTimeUnix - j3;
                this.mPlayStartTimeMs = 0L;
            }
            playDoneParams.playDurationFloat = ((float) this.mPlayDurationMs) / 1000.0f;
            playDoneParams.paramsToProperties(tPProperties);
            TPReportParams.CommonParams commonParams = this.mReportParams.getCommonParams();
            commonParams.stepInt = 50;
            commonParams.paramsToProperties(tPProperties);
            int i16 = this.mPlayType;
            if (i16 == 0) {
                updateVodExParam(tPProperties, false);
            } else if (i16 == 1) {
                updateLiveExParam(tPProperties, false);
            }
            if (mCache != null && !TextUtils.isEmpty(this.mFlowId) && this.mNeedReportToBeacon) {
                TPLogUtil.i(TAG, "Cache report event. mFlowId: " + this.mFlowId);
                mCache.write(this.mFlowId, tPProperties.getProperties());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAppForeground() {
        TPLogUtil.i(TAG, "onAppForeground");
        if (this.mAppState) {
            return;
        }
        this.mAppState = true;
        removeCacheEvent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onBufferingEnd(Map<String, Object> map) {
        this.mIsBuffering = false;
        ParamRecord paramRecord = this.mParamRecord;
        if (!paramRecord.isSwitchingDef) {
            paramRecord.startPlayTimeMs = System.currentTimeMillis();
        }
        if (map == null) {
            TPLogUtil.w(TAG, "onBufferingEnd with null info");
            return;
        }
        long mapValueLong = getMapValueLong(map, TPReportKeys.PlayerStep.PLAYER_END_TIME, System.currentTimeMillis());
        ParamRecord paramRecord2 = this.mParamRecord;
        long j3 = paramRecord2.startBufferingTimeMs;
        int i3 = (int) (mapValueLong - j3);
        if (i3 <= 1200 || this.mIsSeeking) {
            return;
        }
        paramRecord2.bufferingCount++;
        paramRecord2.endBufferingTimeMs = mapValueLong;
        paramRecord2.bufferingDurationMs += (int) (mapValueLong - j3);
        TPReportParams.BufferingOnceParams bufferingOnceParams = this.mCurBufferingParams;
        if (bufferingOnceParams == null) {
            return;
        }
        bufferingOnceParams.endTimeUnix = getMapValueLong(map, TPReportKeys.PlayerStep.PLAYER_END_TIME, 0L);
        this.mCurBufferingParams.errCodeString = this.mErrorCode;
        TPReportParams.BufferingTotalParams bufferingTotalParams = this.mReportParams.getBufferingTotalParams();
        bufferingTotalParams.bufferingCountInt++;
        bufferingTotalParams.bufferingDurationInt += i3;
        if (bufferingTotalParams.bufferingOnceParamsList.size() < 20) {
            bufferingTotalParams.bufferingOnceParamsList.add(this.mCurBufferingParams);
            TPProperties tPProperties = new TPProperties();
            this.mCurBufferingParams.paramsToProperties(tPProperties);
            this.mReportHandler.handleReportEvent(35, tPProperties);
        }
        this.mCurBufferingParams = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onBufferingStart(Map<String, Object> map) {
        if (map == null) {
            TPLogUtil.w(TAG, "onBufferingStart with null info");
            return;
        }
        this.mIsBuffering = true;
        if (this.mIsSeeking) {
            return;
        }
        ParamRecord paramRecord = this.mParamRecord;
        if (paramRecord.startPlayTimeMs > 0) {
            int i3 = paramRecord.playDurationMs;
            long currentTimeMillis = System.currentTimeMillis();
            ParamRecord paramRecord2 = this.mParamRecord;
            paramRecord.playDurationMs = i3 + ((int) (currentTimeMillis - paramRecord2.startPlayTimeMs));
            paramRecord2.startPlayTimeMs = 0L;
        }
        this.mParamRecord.startBufferingTimeMs = getMapValueLong(map, TPReportKeys.PlayerStep.PLAYER_START_TIME, System.currentTimeMillis());
        TPReportParams.BufferingOnceParams createBufferingOnceParams = this.mReportParams.createBufferingOnceParams();
        this.mCurBufferingParams = createBufferingOnceParams;
        createBufferingOnceParams.starTimeUnix = this.mParamRecord.startBufferingTimeMs;
        createBufferingOnceParams.formatInt = getMapValueInteger(map, "format", 0);
        TPReportParams.CommonParams commonParams = this.mReportParams.getCommonParams();
        TPReportParams.BufferingOnceParams bufferingOnceParams = this.mCurBufferingParams;
        bufferingOnceParams.formatInt = commonParams.mediaFormatInt;
        bufferingOnceParams.reasonInt = getMapValueInteger(map, "reason", 0);
        TPReportParams.BufferingOnceParams bufferingOnceParams2 = this.mCurBufferingParams;
        bufferingOnceParams2.lastEventInt = this.mLastEvent;
        bufferingOnceParams2.sceneInt = this.mPlayScene;
        bufferingOnceParams2.bufferingPresentTimeLong = getMapValueLong(map, "ptime", 0L) / 1000;
        this.mCurBufferingParams.urlString = getMapValueString(map, "url", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCdnInfoUpdate(Map<String, Object> map) {
        String substring;
        if (map == null) {
            return;
        }
        this.mParamRecord.cdnUrl = getMapValueString(map, "url", "");
        this.mParamRecord.cdnIp = getMapValueString(map, TPReportKeys.Common.COMMON_CDN_IP, "");
        this.mParamRecord.cdnUip = getMapValueString(map, TPReportKeys.Common.COMMON_CDN_UIP, "");
        if (!TextUtils.isEmpty(this.mParamRecord.cdnUrl) && this.mParamRecord.cdnUrl.contains("sid=")) {
            int indexOf = this.mParamRecord.cdnUrl.indexOf("sid=");
            int indexOf2 = this.mParamRecord.cdnUrl.indexOf(ContainerUtils.FIELD_DELIMITER, indexOf);
            ParamRecord paramRecord = this.mParamRecord;
            if (indexOf2 > -1) {
                substring = paramRecord.cdnUrl.substring(indexOf + 4, indexOf2);
            } else {
                substring = paramRecord.cdnUrl.substring(indexOf + 4);
            }
            paramRecord.tuid = substring;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFirstClipOpen(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        this.mReportParams.getFirstLoadParams().firstOpenTimeUnix = getMapValueLong(map, TPReportKeys.PlayerStep.PLAYER_START_TIME, System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFirstPacketRead(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        TPReportParams.LiveExParam liveExParam = this.mReportParams.getLiveExParam();
        long mapValueLong = getMapValueLong(map, TPReportKeys.PlayerStep.PLAYER_START_TIME, System.currentTimeMillis());
        liveExParam.getSyncFrameDurationInt = (int) (mapValueLong - this.mParamRecord.startPrepareTimeMs);
        this.mReportParams.getFirstLoadParams().firstPacketReadTimeUnix = mapValueLong;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onGetCdn(Map<String, Object> map) {
        if (map == null) {
            TPLogUtil.w(TAG, "onGetCdn with null info");
            return;
        }
        TPReportParams.GetCdnUrlParams getCdnParams = this.mReportParams.getGetCdnParams();
        getCdnParams.proxyIpString = getMapValueString(map, "ip", "");
        getCdnParams.starTimeUnix = getMapValueLong(map, TPReportKeys.PlayerStep.PLAYER_START_TIME, 0L);
        getCdnParams.endTimeUnix = getMapValueLong(map, TPReportKeys.PlayerStep.PLAYER_END_TIME, 0L);
        getCdnParams.errCodeString = getMapValueString(map, "code", "0");
        TPProperties tPProperties = new TPProperties();
        getCdnParams.paramsToProperties(tPProperties);
        this.mReportHandler.handleReportEvent(15, tPProperties);
        if (!TextUtils.isEmpty(getCdnParams.errCodeString) && !getCdnParams.errCodeString.equals("0") && !getCdnParams.errCodeString.equals("0.0")) {
            this.mErrorCode = getCdnParams.errCodeString;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onHandleHlsTag(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            TPLogUtil.i(TAG, "onHandleHlsTag, tag is null");
            return;
        }
        if (!str.startsWith(LIVE_HLS_M3U8_TAG_PREFIX)) {
            TPLogUtil.i(TAG, "onHandleHlsTag, tag is not start with #EXT-X-PROGRAM-DATE-TIME:");
            return;
        }
        try {
            String substring = str.substring(25);
            int indexOf = substring.indexOf(43);
            if (indexOf != -1) {
                str2 = substring.substring(0, indexOf).replace('T', TokenParser.SP);
            } else {
                TPLogUtil.i(TAG, "handleOnPlayerPrivaterHlsM3u8Tag , player_m3u8_tag , tag do not contains time zone");
                str2 = substring.replace('T', TokenParser.SP);
            }
        } catch (Exception e16) {
            TPLogUtil.e(TAG, e16);
            str2 = "";
        }
        if (TextUtils.isEmpty(str2)) {
            TPLogUtil.i(TAG, "onHandleHlsTag , player_m3u8_tag , dataTime is null ");
            return;
        }
        long j3 = 0;
        try {
            Date parse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str2);
            if (parse != null) {
                j3 = parse.getTime();
            }
        } catch (Exception e17) {
            TPLogUtil.e(TAG, e17);
        }
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onHandleHlsTag , player_m3u8_tag , sysCurTime: ");
        sb5.append(currentTimeMillis);
        sb5.append(", time:");
        sb5.append(j3);
        sb5.append(", delay:");
        long j16 = currentTimeMillis - j3;
        sb5.append(j16);
        TPLogUtil.i(TAG, sb5.toString());
        this.mParamRecord.liveDelayMs = (int) j16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLivePeriodReport() {
        TPLogUtil.i(TAG, "onLivePeriodReport");
        this.mReportHandler.handleReportEvent(263, new TPProperties());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLoadSubtitle(Map<String, Object> map) {
        if (map == null) {
            TPLogUtil.w(TAG, "onLoadSubtitle with null info");
            return;
        }
        this.mParamRecord.subtitleInfos.add(new SubtitleInfo(getMapValueString(map, "name", ""), getMapValueString(map, "url", "")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPlayComplete(Map<String, Object> map) {
        if (map == null) {
            TPLogUtil.w(TAG, "onPlayComplete with null info");
        } else {
            map.put("reason", 0);
            onPlayEnd(map);
        }
    }

    private void onPlayEnd(Map<String, Object> map) {
        if (map != null && !this.mIsPlayDone) {
            this.mIsPlayDone = true;
            if (this.mPlayType != 1 && this.mIsPrepare) {
                onPrepareDone(new TPHashMapBuilder().put(TPReportKeys.PlayerStep.PLAYER_END_TIME, Long.valueOf(System.currentTimeMillis())).build());
            }
            if (this.mIsBuffering) {
                onBufferingEnd(new TPHashMapBuilder().put(TPReportKeys.PlayerStep.PLAYER_END_TIME, Long.valueOf(System.currentTimeMillis())).build());
            }
            if (this.mIsSeeking) {
                onSeekComplete(new TPHashMapBuilder().put(TPReportKeys.PlayerStep.PLAYER_END_TIME, Long.valueOf(System.currentTimeMillis())).build());
            }
            ParamRecord paramRecord = this.mParamRecord;
            if (paramRecord.startPlayTimeMs > 0) {
                int i3 = paramRecord.playDurationMs;
                long currentTimeMillis = System.currentTimeMillis();
                ParamRecord paramRecord2 = this.mParamRecord;
                paramRecord.playDurationMs = i3 + ((int) (currentTimeMillis - paramRecord2.startPlayTimeMs));
                paramRecord2.startPlayTimeMs = 0L;
            }
            this.mIsSeeking = false;
            TPProperties tPProperties = new TPProperties();
            this.mReportParams.getBufferingTotalParams().paramsToProperties(tPProperties);
            this.mReportParams.getBufferingTotalParams().reset();
            this.mReportParams.getUserSeekTotalParams().paramsToProperties(tPProperties);
            this.mReportParams.getUserSeekTotalParams().reset();
            TPReportParams.PlayDoneParams playDoneParams = this.mReportParams.getPlayDoneParams();
            playDoneParams.endTimeUnix = getMapValueLong(map, TPReportKeys.PlayerStep.PLAYER_END_TIME, System.currentTimeMillis());
            playDoneParams.reasonInt = getMapValueInteger(map, "reason", 0);
            playDoneParams.errCodeString = this.mErrorCode;
            long j3 = this.mPlayStartTimeMs;
            if (j3 > 0) {
                this.mPlayDurationMs += playDoneParams.endTimeUnix - j3;
                this.mPlayStartTimeMs = 0L;
            }
            playDoneParams.playDurationFloat = ((float) this.mPlayDurationMs) / 1000.0f;
            playDoneParams.paramsToProperties(tPProperties);
            this.mReportHandler.handleReportEvent(50, tPProperties);
            this.mErrorCode = "0";
            this.mReportParams.resetAllParam();
            removeCacheEvent();
            resetLocalParam();
            return;
        }
        TPLogUtil.w(TAG, "onPlayEnd with null info");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPlayerCreateDone(Map<String, Object> map) {
        if (map == null) {
            TPLogUtil.w(TAG, "onPlayerCreateDone with null info");
            return;
        }
        TPProperties tPProperties = new TPProperties();
        TPReportParams.PlayerInitParams initParams = this.mReportParams.getInitParams();
        initParams.playEndTimeUnix = getMapValueLong(map, TPReportKeys.PlayerStep.PLAYER_END_TIME, System.currentTimeMillis());
        initParams.errCodeString = this.mErrorCode;
        initParams.paramsToProperties(tPProperties);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPlayerCreateStart(Map<String, Object> map) {
        if (map == null) {
            TPLogUtil.w(TAG, "onPlayerCreateStart with null info");
        } else {
            this.mReportParams.getInitParams().playStarTimeUnix = getMapValueLong(map, TPReportKeys.PlayerStep.PLAYER_START_TIME, System.currentTimeMillis());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPlayerEarlyError(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        this.mFlowId = UUID.randomUUID().toString() + System.nanoTime() + "_" + ((Integer) TPConfig.getConfigValue(TPMgrConfig.TP_MGR_CONFIG_KEY_BEFORE_INT_PLATFORM, 0)).intValue();
        this.mErrorCode = getMapValueString(map, "code", "0");
        TPDefaultReportInfo tPDefaultReportInfo = this.mReportInfoGetter;
        if (tPDefaultReportInfo != null) {
            this.mPlayType = tPDefaultReportInfo.getPlayType();
        }
        if (this.mPlayType == 1) {
            this.mReportHandler.handleReportEvent(150, new TPProperties());
        } else {
            map.put("reason", 3);
            this.mIsPlayDone = false;
            onPlayEnd(map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPlayerError(Map<String, Object> map) {
        if (map == null) {
            TPLogUtil.w(TAG, "onPlayerError with null info");
            return;
        }
        ParamRecord paramRecord = this.mParamRecord;
        if (paramRecord.startPlayTimeMs > 0) {
            int i3 = paramRecord.playDurationMs;
            long currentTimeMillis = System.currentTimeMillis();
            ParamRecord paramRecord2 = this.mParamRecord;
            paramRecord.playDurationMs = i3 + ((int) (currentTimeMillis - paramRecord2.startPlayTimeMs));
            paramRecord2.startPlayTimeMs = 0L;
        }
        this.mErrorCode = getMapValueString(map, "code", "0");
        if (this.mPlayType == 1) {
            this.mReportHandler.handleReportEvent(150, new TPProperties());
        } else {
            map.put("reason", 3);
            onPlayEnd(map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPlayerPause(Map<String, Object> map) {
        if (map == null) {
            TPLogUtil.w(TAG, "onPlayerPause with null info");
            return;
        }
        if (this.mPlayStartTimeMs > 0) {
            this.mPlayDurationMs += getMapValueLong(map, TPReportKeys.PlayerStep.PLAYER_START_TIME, System.currentTimeMillis()) - this.mPlayStartTimeMs;
            this.mPlayStartTimeMs = 0L;
        }
        ParamRecord paramRecord = this.mParamRecord;
        if (paramRecord.startPlayTimeMs > 0) {
            int i3 = paramRecord.playDurationMs;
            long currentTimeMillis = System.currentTimeMillis();
            ParamRecord paramRecord2 = this.mParamRecord;
            paramRecord.playDurationMs = i3 + ((int) (currentTimeMillis - paramRecord2.startPlayTimeMs));
            paramRecord2.startPlayTimeMs = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPlayerRelease(Map<String, Object> map) {
        if (map == null) {
            TPLogUtil.w(TAG, "onPlayerRelease with null info");
        } else {
            map.put("reason", 1);
            onPlayEnd(map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPlayerReset(Map<String, Object> map) {
        if (map == null) {
            TPLogUtil.w(TAG, "onPlayerReset with null info");
        } else {
            map.put("reason", 1);
            onPlayEnd(map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPlayerStop(Map<String, Object> map) {
        if (map == null) {
            TPLogUtil.w(TAG, "onPlayerStop with null info");
            return;
        }
        if (this.mPlayStartTimeMs > 0) {
            this.mPlayDurationMs += getMapValueLong(map, TPReportKeys.PlayerStep.PLAYER_END_TIME, System.currentTimeMillis()) - this.mPlayStartTimeMs;
            this.mPlayStartTimeMs = 0L;
        }
        ParamRecord paramRecord = this.mParamRecord;
        if (paramRecord.startPlayTimeMs > 0) {
            int i3 = paramRecord.playDurationMs;
            long currentTimeMillis = System.currentTimeMillis();
            ParamRecord paramRecord2 = this.mParamRecord;
            paramRecord.playDurationMs = i3 + ((int) (currentTimeMillis - paramRecord2.startPlayTimeMs));
            paramRecord2.startPlayTimeMs = 0L;
        }
        map.put("reason", 1);
        onPlayEnd(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPrepareDone(Map<String, Object> map) {
        if (!this.mIsPrepare) {
            TPLogUtil.w(TAG, "onPrepareDone with invalid state");
            return;
        }
        this.mIsPrepare = false;
        if (map == null) {
            TPLogUtil.w(TAG, "onPrepareDone with null info");
            return;
        }
        this.mParamRecord.endPrepareTimeMs = System.currentTimeMillis();
        this.mParamRecord.isMultiTrack = getMapValueBool(map, TPReportKeys.VodExKeys.VOD_EX_MULTI_TRACK, false);
        if (getMapValueInteger(map, TPReportKeys.Common.COMMON_PLAYER_TYPE, 0) == 1) {
            this.mPlayerType = 0;
        } else {
            this.mPlayerType = 1;
        }
        this.mMediaResolution = getMapValueString(map, "definition", "");
        this.mMediaDurationMs = getMapValueLong(map, "duration", 0L);
        this.mMediaRate = (int) getMapValueLong(map, "rate", 0L);
        String mapValueString = getMapValueString(map, TPReportKeys.Common.COMMON_MEDIA_FORMAT, "");
        if (mapValueString != null && mapValueString.contains(TVKMediaPlayerConfig.PlayerConfig.FORMAT_ID_HLS)) {
            this.mDownloadType = 3;
        } else {
            this.mDownloadType = 1;
        }
        TPReportParams.FirstLoadParams firstLoadParams = this.mReportParams.getFirstLoadParams();
        firstLoadParams.endTimeUnix = getMapValueLong(map, TPReportKeys.PlayerStep.PLAYER_END_TIME, 0L);
        firstLoadParams.errCodeString = this.mErrorCode;
        TPProperties tPProperties = new TPProperties();
        firstLoadParams.paramsToProperties(tPProperties);
        this.mReportHandler.handleReportEvent(30, tPProperties);
        this.mReportParams.getFirstLoadParams().reset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onProxyInfoUpdate(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        int mapValueInteger = getMapValueInteger(map, "speed", 0);
        this.mNetworkSpeed = mapValueInteger;
        ParamRecord paramRecord = this.mParamRecord;
        paramRecord.totalSpeed += mapValueInteger;
        paramRecord.getSpeedCnt++;
        if (mapValueInteger > paramRecord.maxSpeed) {
            paramRecord.maxSpeed = mapValueInteger;
        }
        String mapValueString = getMapValueString(map, TPReportKeys.LiveExKeys.LIVE_FX_SPANID, "");
        if (!TextUtils.isEmpty(mapValueString)) {
            try {
                JSONObject jSONObject = new JSONObject(mapValueString);
                if (jSONObject.has(TPReportKeys.LiveExKeys.LIVE_FX_SPANID)) {
                    this.mParamRecord.spanId = jSONObject.getString(TPReportKeys.LiveExKeys.LIVE_FX_SPANID);
                }
            } catch (Exception e16) {
                TPLogUtil.e(TAG, e16);
            }
            getHitDownloadedInfo(mapValueString);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRenderingStart(Map<String, Object> map) {
        if (map == null) {
            TPLogUtil.w(TAG, "onRenderingStart with null info");
            return;
        }
        TPProperties tPProperties = new TPProperties();
        TPReportParams.FirstRenderParams firstRenderParams = this.mReportParams.getFirstRenderParams();
        firstRenderParams.endTimeUnix = getMapValueLong(map, TPReportKeys.PlayerStep.PLAYER_END_TIME, 0L);
        firstRenderParams.errCodeString = this.mErrorCode;
        firstRenderParams.paramsToProperties(tPProperties);
        this.mReportHandler.handleReportEvent(32, tPProperties);
        this.mReportParams.getFirstRenderParams().reset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onReportEvent(ITPReportProperties iTPReportProperties) {
        String str;
        TPLogUtil.d(TAG, "onReportEvent, needReportToBeacon:" + this.mNeedReportToBeacon + ", params:" + iTPReportProperties.toString());
        if (!this.mNeedReportToBeacon) {
            return;
        }
        HashMap hashMap = new HashMap();
        iTPReportProperties.propertiesToMap(hashMap);
        if (!hashMap.containsKey("step") || (str = hashMap.get("step")) == null) {
            return;
        }
        String eventId = getEventId(Integer.parseInt(str));
        if (TextUtils.isEmpty(eventId)) {
            return;
        }
        TPBeaconReportWrapper.trackCustomKVEvent(eventId, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onReportLastEvent() {
        TPLogUtil.i(TAG, "onReportLastEvent");
        TPLocalCacheReaderWriter tPLocalCacheReaderWriter = mCache;
        if (tPLocalCacheReaderWriter == null) {
            return;
        }
        try {
            ArrayList arrayList = (ArrayList) tPLocalCacheReaderWriter.readAll();
            mCache.clearAll();
            if (arrayList == null) {
                return;
            }
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                try {
                    Properties properties = (Properties) arrayList.get(i3);
                    if (properties != null) {
                        onReportEvent(new TPProperties(properties));
                    }
                } catch (Exception e16) {
                    TPLogUtil.e(TAG, e16);
                }
            }
        } catch (Exception e17) {
            TPLogUtil.e(TAG, e17);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onReportProtocolUpdate(Map<String, Object> map) {
        this.mProto = getMapValueString(map, "proto", "");
        this.mProtoVer = getMapValueString(map, TPReportKeys.Common.COMMON_PROTOVER, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSeekComplete(Map<String, Object> map) {
        this.mIsSeeking = false;
        if (map == null) {
            TPLogUtil.w(TAG, "onSeekComplete with null info");
            return;
        }
        TPReportParams.UserSeekOnceParams userSeekOnceParams = this.mCurSeekParams;
        if (userSeekOnceParams == null) {
            TPLogUtil.w(TAG, "onSeekComplete with null seek param");
            return;
        }
        userSeekOnceParams.seekEndTimeUnix = getMapValueLong(map, TPReportKeys.PlayerStep.PLAYER_END_TIME, System.currentTimeMillis());
        this.mCurSeekParams.endPresentTimeLong = getMapValueLong(map, TPReportKeys.PlayerStep.PLAYER_SEEK_PRESENT_END_TIME, 0L) / 1000;
        TPReportParams.UserSeekOnceParams userSeekOnceParams2 = this.mCurSeekParams;
        userSeekOnceParams2.errCodeString = this.mErrorCode;
        long j3 = userSeekOnceParams2.seekEndTimeUnix - userSeekOnceParams2.seekStartTimeUnix;
        if (j3 > 1200) {
            this.mSeekBufferingCount++;
            this.mSeekBufferingDuration = (int) (this.mSeekBufferingDuration + j3);
        }
        TPReportParams.UserSeekTotalParams userSeekTotalParams = this.mReportParams.getUserSeekTotalParams();
        userSeekTotalParams.seekTotalCountInt++;
        userSeekTotalParams.seekBufferingDurationInt = this.mSeekBufferingDuration;
        userSeekTotalParams.seekBufferingCountInt = this.mSeekBufferingCount;
        if (userSeekTotalParams.seekOnceParamsList.size() < 20) {
            userSeekTotalParams.seekOnceParamsList.add(this.mCurSeekParams);
            TPProperties tPProperties = new TPProperties();
            this.mCurSeekParams.paramsToProperties(tPProperties);
            this.mReportHandler.handleReportEvent(40, tPProperties);
        }
        this.mCurSeekParams = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSelectTrack(Map<String, Object> map) {
        if (map == null) {
            TPLogUtil.w(TAG, "onSelectTrack with null info");
            return;
        }
        if (this.mParamRecord.subtitleInfos.size() == 0 || getMapValueInteger(map, TPReportKeys.PlayerStep.PLAYER_SELECT_TRACK_TYPE, 0) != 3) {
            return;
        }
        this.mIsLoadingSubtitle = true;
        this.mParamRecord.isSelectedSubtitle = true;
        TPReportParams.LoadSubtitleParams loadSubtitleParams = this.mReportParams.getLoadSubtitleParams();
        loadSubtitleParams.starTimeUnix = getMapValueLong(map, TPReportKeys.PlayerStep.PLAYER_START_TIME, 0L);
        TPDefaultReportInfo tPDefaultReportInfo = this.mReportInfoGetter;
        if (tPDefaultReportInfo != null) {
            loadSubtitleParams.cdnTypeInt = tPDefaultReportInfo.subtitleCdnType;
            loadSubtitleParams.cgiUrlIndex = tPDefaultReportInfo.subtitleUrlIndex;
        }
        long mapValueLong = getMapValueLong(map, TPReportKeys.PlayerStep.PLAYER_CALLBACK_OPAQUE, -1L);
        String mapValueString = getMapValueString(map, "name", "");
        Iterator<SubtitleInfo> it = this.mParamRecord.subtitleInfos.iterator();
        while (it.hasNext()) {
            SubtitleInfo next = it.next();
            if (!TextUtils.isEmpty(mapValueString) && next.name.equals(mapValueString)) {
                loadSubtitleParams.subtitleUrlString = next.url;
                next.opaque = mapValueLong;
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSelectTrackDone(Map<String, Object> map) {
        if (!this.mIsLoadingSubtitle) {
            TPLogUtil.w(TAG, "onSelectTrackDone while is loading subtile");
            return;
        }
        if (map == null) {
            TPLogUtil.w(TAG, "onSelectTrackDone with null info");
            return;
        }
        if (this.mParamRecord.subtitleInfos.size() == 0) {
            return;
        }
        long mapValueLong = getMapValueLong(map, TPReportKeys.PlayerStep.PLAYER_CALLBACK_OPAQUE, -1L);
        if (mapValueLong == -1) {
            return;
        }
        Iterator<SubtitleInfo> it = this.mParamRecord.subtitleInfos.iterator();
        while (it.hasNext()) {
            if (it.next().opaque == mapValueLong) {
                TPReportParams.LoadSubtitleParams loadSubtitleParams = this.mReportParams.getLoadSubtitleParams();
                loadSubtitleParams.endTimeUnix = getMapValueLong(map, TPReportKeys.PlayerStep.PLAYER_END_TIME, 0L);
                loadSubtitleParams.errCodeString = getMapValueString(map, "code", "0");
                loadSubtitleParams.bufferingDurationInt = (int) (loadSubtitleParams.endTimeUnix - loadSubtitleParams.starTimeUnix);
                TPProperties tPProperties = new TPProperties();
                loadSubtitleParams.paramsToProperties(tPProperties);
                this.mReportHandler.handleReportEvent(33, tPProperties);
                this.mIsLoadingSubtitle = false;
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSetPlaySpeed(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        if (getMapValueFloat(map, "scene", 1.0f) != 1.0f) {
            this.mPlayScene = 2;
        } else {
            this.mPlayScene = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStartPlayer(Map<String, Object> map) {
        this.mIsPlayDone = false;
        if (map == null) {
            TPLogUtil.w(TAG, "onStartPlayer with null info");
            return;
        }
        this.mParamRecord.startPlayTimeMs = System.currentTimeMillis();
        long mapValueLong = getMapValueLong(map, TPReportKeys.PlayerStep.PLAYER_START_TIME, 0L);
        if (this.mPlayStartTimeMs > 0) {
            this.mPlayDurationMs += System.currentTimeMillis() - mapValueLong;
        }
        this.mPlayStartTimeMs = mapValueLong;
        if (this.mPlayType == 1) {
            this.mEventHandler.removeMessages(3000);
            this.mEventHandler.sendEmptyMessageDelayed(3000, 60000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStartPrepare(Map<String, Object> map) {
        if (this.mIsPrepare) {
            TPLogUtil.w(TAG, "onStartPrepare with null info");
            return;
        }
        this.mIsPlayDone = false;
        this.mFlowId = getMapValueString(map, "flowid", "");
        this.mIsUseP2P = getMapValueBool(map, TPReportKeys.Common.COMMON_P2P, false);
        TPDefaultReportInfo tPDefaultReportInfo = this.mReportInfoGetter;
        if (tPDefaultReportInfo != null) {
            this.mPlayType = tPDefaultReportInfo.getPlayType();
        }
        int i3 = this.mPlayType;
        if (i3 == 1) {
            this.mReportHandler = new LiveReportHandler();
        } else if (i3 == 0) {
            this.mReportHandler = new VodReportHandler();
        }
        TPProperties tPProperties = new TPProperties();
        this.mReportParams.getInitParams().paramsToProperties(tPProperties);
        this.mReportHandler.handleReportEvent(5, tPProperties);
        this.mParamRecord.startPrepareTimeMs = System.currentTimeMillis();
        TPReportParams.FirstLoadParams firstLoadParams = this.mReportParams.getFirstLoadParams();
        String str = this.mParamRecord.cdnUrl;
        firstLoadParams.cdnUrlString = str;
        if (TextUtils.isEmpty(str)) {
            firstLoadParams.cdnUrlString = getMapValueString(map, "url", "");
        }
        TPDefaultReportInfo tPDefaultReportInfo2 = this.mReportInfoGetter;
        if (tPDefaultReportInfo2 != null) {
            firstLoadParams.cgiUrlIndex = tPDefaultReportInfo2.cdnUrlIndex;
        }
        firstLoadParams.cgiUrlIndex = getMapValueInteger(map, TPReportKeys.PlayerStep.PLAYER_URL_INDEX, 0);
        firstLoadParams.starTimeUnix = getMapValueLong(map, TPReportKeys.PlayerStep.PLAYER_START_TIME, 0L);
        this.mReportParams.getFirstRenderParams().starTimeUnix = getMapValueLong(map, TPReportKeys.PlayerStep.PLAYER_START_TIME, 0L);
        this.mIsPrepare = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStartSeek(Map<String, Object> map) {
        if (map == null) {
            TPLogUtil.w(TAG, "onStartSeek with null info");
            return;
        }
        if (this.mIsBuffering) {
            onBufferingEnd(new TPHashMapBuilder().put(TPReportKeys.PlayerStep.PLAYER_END_TIME, Long.valueOf(System.currentTimeMillis())).build());
        }
        if (this.mIsSeeking) {
            onSeekComplete(new TPHashMapBuilder().put(TPReportKeys.PlayerStep.PLAYER_END_TIME, Long.valueOf(System.currentTimeMillis())).put(TPReportKeys.PlayerStep.PLAYER_SEEK_PRESENT_END_TIME, Long.valueOf(getMapValueLong(map, TPReportKeys.PlayerStep.PLAYER_SEEK_PRESENT_START_TIME, 0L) / 1000)).build());
        }
        this.mIsSeeking = true;
        this.mLastEvent = 1;
        TPReportParams.UserSeekOnceParams createUserSeekOnceParams = this.mReportParams.createUserSeekOnceParams();
        this.mCurSeekParams = createUserSeekOnceParams;
        createUserSeekOnceParams.seekStartTimeUnix = getMapValueLong(map, TPReportKeys.PlayerStep.PLAYER_START_TIME, System.currentTimeMillis());
        TPReportParams.CommonParams commonParams = this.mReportParams.getCommonParams();
        TPReportParams.UserSeekOnceParams userSeekOnceParams = this.mCurSeekParams;
        userSeekOnceParams.formatInt = commonParams.mediaFormatInt;
        userSeekOnceParams.startPresentTimeLong = getMapValueLong(map, TPReportKeys.PlayerStep.PLAYER_SEEK_PRESENT_START_TIME, 0L) / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSwitchDef(Map<String, Object> map) {
        if (map == null) {
            TPLogUtil.w(TAG, "onSwitchDef with null info");
            return;
        }
        this.mParamRecord.defId = getMapValueString(map, TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, "");
        this.mParamRecord.isSwitchingDef = true;
        if (this.mPlayType == 1) {
            this.mEventHandler.removeMessages(3000);
            onLivePeriodReport();
            ParamRecord paramRecord = this.mParamRecord;
            paramRecord.startPrepareTimeMs = 0L;
            paramRecord.endPrepareTimeMs = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSwitchDefEnd(Map<String, Object> map) {
        if (map == null) {
            TPLogUtil.w(TAG, "onSwitchDefEnd with null info");
            return;
        }
        this.mParamRecord.defId = getMapValueString(map, TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, "");
        this.mParamRecord.isSwitchingDef = false;
        if (this.mPlayType == 1) {
            this.mReportHandler.handleReportEvent(30, new TPProperties());
            this.mEventHandler.removeMessages(3000);
            this.mEventHandler.sendEmptyMessageDelayed(3000, 60000L);
            this.mParamRecord.startPlayTimeMs = System.currentTimeMillis();
        }
    }

    private void release() {
        HandlerThread handlerThread = this.mReportThread;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            this.mReportThread = null;
        }
    }

    private void removeCacheEvent() {
        TPLogUtil.i(TAG, "removeCacheEvent: mFlowId: " + this.mFlowId);
        if (mCache != null && !TextUtils.isEmpty(this.mFlowId)) {
            mCache.remove(this.mFlowId);
        }
    }

    private void resetLocalParam() {
        this.mPlayStartTimeMs = 0L;
        this.mPlayDurationMs = 0L;
        this.mSeekBufferingCount = 0;
        this.mSeekBufferingDuration = 0;
        this.mIsSeeking = false;
        this.mIsBuffering = false;
        this.mIsPrepare = false;
        this.mIsLoadingSubtitle = false;
        this.mFlowId = "";
        this.mPlayerType = 0;
        this.mDownloadType = 0;
        this.mMediaRate = 0;
        this.mMediaDurationMs = 0L;
        this.mNetworkSpeed = 0;
        this.mIsUseP2P = false;
        this.mProto = "";
        this.mProtoVer = "";
        this.mMediaResolution = "";
        this.mPlayType = -1;
        this.mErrorCode = "0";
        this.mParamRecord.reset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCommonParam(ITPReportProperties iTPReportProperties, int i3, boolean z16) {
        TPReportParams.CommonParams commonParams = this.mReportParams.getCommonParams();
        commonParams.stepInt = i3;
        commonParams.seqInt++;
        String str = this.mFlowId;
        commonParams.flowIdString = str;
        commonParams.playNoString = str;
        commonParams.signalStrengthInt = this.mSignalStrength;
        commonParams.networkSpeedInt = this.mNetworkSpeed;
        commonParams.networkTypeInt = getNetWorkType();
        commonParams.deviceNameString = TPSystemInfo.getDeviceName();
        commonParams.deviceResolutionString = getDeviceResolution();
        commonParams.osVersionString = OS_VERSION;
        commonParams.p2pVersionString = TPVersion.getDataTransportVersion();
        commonParams.playerVersionString = TPVersion.getVersion();
        commonParams.playerTypeInt = this.mPlayerType;
        commonParams.p2pInt = this.mIsUseP2P ? 1 : 0;
        commonParams.proto = this.mProto;
        commonParams.protover = this.mProtoVer;
        commonParams.playTypeInt = this.mPlayType;
        TPDefaultReportInfo tPDefaultReportInfo = this.mReportInfoGetter;
        if (tPDefaultReportInfo != null && z16) {
            commonParams.testIdInt = tPDefaultReportInfo.testId;
            commonParams.cdnIdInt = tPDefaultReportInfo.cdnId;
            commonParams.downloadTypeInt = tPDefaultReportInfo.dlType;
            commonParams.loginTypeInt = tPDefaultReportInfo.loginType;
            commonParams.mediaFormatInt = tPDefaultReportInfo.mediaFormat;
            commonParams.mediaRateInt = tPDefaultReportInfo.mediaRate;
            commonParams.platformLong = tPDefaultReportInfo.platform;
            commonParams.onlineInt = tPDefaultReportInfo.isOnline ? 1 : 0;
            commonParams.mediaDurationFloat = tPDefaultReportInfo.mediaDuration;
            commonParams.uinString = tPDefaultReportInfo.uin;
            commonParams.qqOpenIdString = tPDefaultReportInfo.qqOpenId;
            commonParams.wxOpenIdString = tPDefaultReportInfo.wxOpenId;
            commonParams.guidString = tPDefaultReportInfo.guid;
            commonParams.uipString = tPDefaultReportInfo.uip;
            commonParams.cdnUipString = tPDefaultReportInfo.cdnUip;
            commonParams.cdnIpString = tPDefaultReportInfo.cdnIp;
            commonParams.appVersionString = tPDefaultReportInfo.appVersion;
            commonParams.vidString = tPDefaultReportInfo.vid;
            commonParams.mediaResolutionString = tPDefaultReportInfo.mediaResolution;
            commonParams.scenesId = tPDefaultReportInfo.scenesId;
            Properties properties = tPDefaultReportInfo.extraReportInfo;
            if (properties != null) {
                for (Map.Entry entry : properties.entrySet()) {
                    Object key = entry.getKey();
                    Object value = entry.getValue();
                    if (value == null) {
                        iTPReportProperties.put(key.toString(), "");
                    } else {
                        iTPReportProperties.put(key.toString(), value.toString());
                    }
                }
            }
            this.mPlayType = this.mReportInfoGetter.getPlayType();
        }
        if (commonParams.platformLong <= 0) {
            commonParams.platformLong = ((Integer) TPConfig.getConfigValue(TPMgrConfig.TP_MGR_CONFIG_KEY_BEFORE_INT_PLATFORM, 0)).intValue();
        }
        if (TextUtils.isEmpty(commonParams.uinString)) {
            commonParams.uinString = "";
        }
        if (TextUtils.isEmpty(commonParams.guidString)) {
            commonParams.guidString = (String) TPConfig.getConfigValue(TPMgrConfig.TP_MGR_CONFIG_KEY_BEFORE_STRING_GUID, "");
        }
        if (TextUtils.isEmpty(commonParams.appVersionString)) {
            commonParams.appVersionString = TPSystemInfo.getAppVersionName(this.mContext);
        }
        if (TextUtils.isEmpty(commonParams.uipString)) {
            commonParams.uipString = this.mParamRecord.cdnUip;
        }
        if (TextUtils.isEmpty(commonParams.cdnUipString)) {
            commonParams.cdnUipString = this.mParamRecord.cdnUip;
        }
        if (TextUtils.isEmpty(commonParams.cdnIpString)) {
            commonParams.cdnIpString = this.mParamRecord.cdnIp;
        }
        if (commonParams.downloadTypeInt <= 0) {
            commonParams.downloadTypeInt = this.mDownloadType;
        }
        if (TextUtils.isEmpty(commonParams.mediaResolutionString)) {
            commonParams.mediaResolutionString = this.mMediaResolution;
        }
        if (commonParams.mediaDurationFloat <= 0.0f) {
            commonParams.mediaDurationFloat = ((float) this.mMediaDurationMs) / 1000.0f;
        }
        if (commonParams.mediaRateInt <= 0) {
            commonParams.mediaRateInt = this.mMediaRate;
        }
        commonParams.paramsToProperties(iTPReportProperties);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLiveExParam(ITPReportProperties iTPReportProperties, boolean z16) {
        TPReportParams.LiveExParam liveExParam = this.mReportParams.getLiveExParam();
        if (liveExParam == null) {
            return;
        }
        TPDefaultReportInfo tPDefaultReportInfo = this.mReportInfoGetter;
        if (tPDefaultReportInfo != null && (tPDefaultReportInfo instanceof TPLiveReportInfo) && z16) {
            liveExParam.adPlayLengthInt = ((TPLiveReportInfo) tPDefaultReportInfo).adPlayLength;
            liveExParam.liveProgramIdInt = ((TPLiveReportInfo) tPDefaultReportInfo).programId;
            liveExParam.streamIdInt = ((TPLiveReportInfo) tPDefaultReportInfo).streamId;
            liveExParam.contentIdInt = ((TPLiveReportInfo) tPDefaultReportInfo).contentId;
            liveExParam.playTimeInt = ((TPLiveReportInfo) tPDefaultReportInfo).playTime;
            liveExParam.liveTypeInt = ((TPLiveReportInfo) tPDefaultReportInfo).liveType;
            liveExParam.isUserPayInt = ((TPLiveReportInfo) tPDefaultReportInfo).isUserPay ? 1 : 0;
            liveExParam.isLookBackInt = ((TPLiveReportInfo) tPDefaultReportInfo).isLookBack ? 1 : 0;
            liveExParam.cdnServerString = ((TPLiveReportInfo) tPDefaultReportInfo).cdnServer;
            liveExParam.freeTypeInt = tPDefaultReportInfo.freeType;
            liveExParam.userQQString = tPDefaultReportInfo.uin;
            liveExParam.userIpString = tPDefaultReportInfo.uip;
            liveExParam.isStreamP2PInt = tPDefaultReportInfo.enableP2p ? 1 : 0;
        }
        if (tPDefaultReportInfo != null && (tPDefaultReportInfo instanceof TPLiveReportInfo)) {
            liveExParam.liveDelayInt = ((TPLiveReportInfo) tPDefaultReportInfo).liveDelay;
        }
        liveExParam.isUseP2PInt = this.mIsUseP2P ? 1 : 0;
        String str = this.mParamRecord.cdnUrl;
        liveExParam.downloadUrl = str;
        if (TextUtils.isEmpty(str)) {
            liveExParam.downloadUrl = this.mReportParams.getFirstLoadParams().cdnUrlString;
        }
        liveExParam.downloadServerIpString = this.mParamRecord.cdnIp;
        liveExParam.reportTimeLong = System.currentTimeMillis();
        ParamRecord paramRecord = this.mParamRecord;
        if (paramRecord.startPlayTimeMs > 0) {
            long j3 = paramRecord.playDurationMs;
            long currentTimeMillis = System.currentTimeMillis();
            ParamRecord paramRecord2 = this.mParamRecord;
            paramRecord.playDurationMs = (int) (j3 + (currentTimeMillis - paramRecord2.startPlayTimeMs));
            if (!this.mIsPlayDone && !this.mIsBuffering && !paramRecord2.isSwitchingDef) {
                paramRecord2.startPlayTimeMs = System.currentTimeMillis();
            } else {
                paramRecord2.startPlayTimeMs = 0L;
            }
        }
        ParamRecord paramRecord3 = this.mParamRecord;
        liveExParam.prePlayLengthInt = paramRecord3.playDurationMs;
        paramRecord3.playDurationMs = 0;
        liveExParam.playerVersionString = TPVersion.getVersion();
        liveExParam.deviceTypeInt = getDeviceType();
        liveExParam.networkTypeInt = getNetWorkType();
        ParamRecord paramRecord4 = this.mParamRecord;
        liveExParam.maxSpeedInt = paramRecord4.maxSpeed;
        paramRecord4.maxSpeed = 0;
        liveExParam.testSpeedInt = this.mNetworkSpeed;
        int i3 = paramRecord4.getSpeedCnt;
        if (i3 > 0) {
            liveExParam.downSpeedInt = paramRecord4.totalSpeed / i3;
            paramRecord4.totalSpeed = 0;
            paramRecord4.getSpeedCnt = 0;
        }
        liveExParam.liveTagInt = 0;
        liveExParam.extraInfoString = "";
        liveExParam.reconnectCntInt = 0;
        liveExParam.connectTimeInt = 0;
        liveExParam.getUrlTimeInt = 0;
        liveExParam.defSwitchString = paramRecord4.defId;
        liveExParam.loadingTimeLong = paramRecord4.endPrepareTimeMs - paramRecord4.startPrepareTimeMs;
        liveExParam.blockTimeInt = paramRecord4.bufferingDurationMs;
        liveExParam.blockCountInt = paramRecord4.bufferingCount;
        paramRecord4.bufferingCount = 0;
        paramRecord4.bufferingDurationMs = 0;
        liveExParam.errCodeInt = 0;
        liveExParam.fullErrCodeString = this.mErrorCode;
        liveExParam.spanId = paramRecord4.spanId;
        liveExParam.tuid = paramRecord4.tuid;
        liveExParam.paramsToProperties(iTPReportProperties);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateVodExParam(ITPReportProperties iTPReportProperties, boolean z16) {
        TPReportParams.VodExParam vodExParam = this.mReportParams.getVodExParam();
        if (vodExParam == null) {
            return;
        }
        TPDefaultReportInfo tPDefaultReportInfo = this.mReportInfoGetter;
        if (tPDefaultReportInfo != null && (tPDefaultReportInfo instanceof TPVodReportInfo) && z16) {
            vodExParam.currentPlayInt = ((TPVodReportInfo) tPDefaultReportInfo).currentPlayState;
            vodExParam.optimizedPlayInt = ((TPVodReportInfo) tPDefaultReportInfo).optimizedPlay;
            vodExParam.hasSubtitleInt = ((TPVodReportInfo) tPDefaultReportInfo).hasSubtitles ? 1 : 0;
            vodExParam.bizIdInt = ((TPVodReportInfo) tPDefaultReportInfo).bizId;
            vodExParam.clipInt = ((TPVodReportInfo) tPDefaultReportInfo).clipCount;
            vodExParam.statusInt = ((TPVodReportInfo) tPDefaultReportInfo).videoStatus;
            vodExParam.freeTypeInt = tPDefaultReportInfo.freeType;
        }
        ParamRecord paramRecord = this.mParamRecord;
        vodExParam.multiTrackInt = paramRecord.isMultiTrack ? 1 : 0;
        vodExParam.isSelectedSubtitleInt = paramRecord.isSelectedSubtitle ? 1 : 0;
        vodExParam.hevcLcInt = 0;
        vodExParam.hitDownloaded = paramRecord.hitDownloaded;
        vodExParam.paramsToProperties(iTPReportProperties);
    }

    public boolean doReportSampling() {
        if (Math.random() < this.mSamplingRate) {
            TPLogUtil.d(TAG, "reports are sampled");
            this.mNeedReportToBeacon = true;
        } else {
            TPLogUtil.d(TAG, "reports are not sampled");
            this.mNeedReportToBeacon = false;
        }
        return this.mNeedReportToBeacon;
    }

    @Override // com.tencent.thumbplayer.tpplayer.plugin.ITPPluginBase
    public void onAttach() {
        init();
    }

    @Override // com.tencent.thumbplayer.tpplayer.plugin.ITPPluginBase
    public void onDetach() {
        release();
    }

    @Override // com.tencent.thumbplayer.tpplayer.plugin.ITPPluginBase
    public void onEvent(int i3, int i16, int i17, String str, Object obj) {
        int i18;
        switch (i3) {
            case 100:
                i18 = 999;
                break;
            case 101:
                i18 = 1000;
                break;
            case 102:
                i18 = 1001;
                break;
            case 103:
                i18 = 1002;
                break;
            case 104:
                i18 = 1003;
                break;
            case 105:
                i18 = 1012;
                break;
            case 106:
                i18 = 1004;
                break;
            case 107:
                i18 = 1005;
                break;
            case 108:
                i18 = 1006;
                break;
            case 109:
                i18 = 1007;
                break;
            case 110:
                i18 = 1008;
                break;
            case 111:
                i18 = 1009;
                break;
            case 112:
                i18 = 1010;
                break;
            case 113:
                i18 = 1011;
                break;
            case 114:
                i18 = 1013;
                break;
            case 115:
                i18 = 1014;
                break;
            case 116:
                i18 = 1015;
                break;
            case 117:
                i18 = 1016;
                break;
            case 118:
                i18 = 2002;
                break;
            case 119:
                i18 = 1019;
                break;
            case 120:
                i18 = 1020;
                break;
            case 121:
                i18 = 1021;
                break;
            case 122:
                i18 = 2004;
                break;
            case 123:
                i18 = 2005;
                break;
            case 124:
                i18 = 1022;
                break;
            default:
                switch (i3) {
                    case 200:
                        i18 = 1017;
                        break;
                    case 201:
                        i18 = 1018;
                        break;
                    case 202:
                        i18 = 1023;
                        break;
                    default:
                        return;
                }
        }
        this.mEventHandler.obtainMessage(i18, obj).sendToTarget();
    }

    @Override // com.tencent.thumbplayer.api.report.v1.ITPBusinessReportManager
    public void setReportInfoGetter(TPDefaultReportInfo tPDefaultReportInfo) {
        this.mReportInfoGetter = tPDefaultReportInfo;
    }

    @Override // com.tencent.thumbplayer.api.report.v1.ITPBusinessReportManager
    public void setReportSamplingRate(double d16) {
        if (d16 < 0.0d) {
            d16 = 0.0d;
        }
        if (d16 > 1.0d) {
            d16 = 1.0d;
        }
        this.mSamplingRate = d16;
    }
}
