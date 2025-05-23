package com.tencent.thumbplayer.report.reportv1;

import com.tencent.thumbplayer.common.log.TPLogUtil;
import com.tencent.thumbplayer.report.ITPReportProperties;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes26.dex */
public class TPReportParams {
    public static final int BUFFERING_REASON_BITRATE_JITTER = 1400109;
    public static final int BUFFERING_REASON_CDN_TIMEOUT = 1400103;
    public static final int BUFFERING_REASON_CDN_TIMEOUT_BUT_CONNECTED = 1400104;
    public static final int BUFFERING_REASON_DOWNLOAD_SHORT_TIME = 1400111;
    public static final int BUFFERING_REASON_DOWNLOAD_TASK = 1400101;
    public static final int BUFFERING_REASON_NETWORK_DEVICE_EXCEPTION = 1400102;
    public static final int BUFFERING_REASON_NETWORK_UNSTABLE = 1400100;
    public static final int BUFFERING_REASON_P2P_FASTER_THAN_HTTP = 1400110;
    public static final int BUFFERING_REASON_P2P_UPLOAD = 1400112;
    public static final int BUFFERING_REASON_RECEIVE_TIMEOUT = 1400105;
    public static final int BUFFERING_REASON_RECEIVE_TIMEOUT_BUT_CONNECTED = 1400106;
    public static final int BUFFERING_REASON_SLOWLY_SPEED = 1400107;
    public static final int BUFFERING_REASON_SLOWLY_SPEED_BUT_CONNECTED = 1400108;
    public static final String ERROR_CODE_NO_ERROR = "0";
    public static final String JSON_KEY_VAL = "val";
    public static final int LIVE_STEP_FAILED = 150;
    public static final int LIVE_STEP_LOADING_SUCC = 205;
    public static final int LIVE_STEP_PLAY = 263;
    public static final int NETWORK_TYPE_2G = 2;
    public static final int NETWORK_TYPE_3G = 3;
    public static final int NETWORK_TYPE_4G = 4;
    public static final int NETWORK_TYPE_5G = 5;
    public static final int NETWORK_TYPE_ETHERNET = 10;
    public static final int NETWORK_TYPE_UNKNOWN = 0;
    public static final int NETWORK_TYPE_WIFI = 1;
    public static final int PLAYER_STEP_BUFFERING = 35;
    public static final int PLAYER_STEP_FIRST_LOAD = 30;
    public static final int PLAYER_STEP_FIRST_RENDERING = 32;
    public static final int PLAYER_STEP_GET_CDN_URL = 15;
    public static final int PLAYER_STEP_INIT_PLAYER = 5;
    public static final int PLAYER_STEP_LOAD_SUBTITLE = 33;
    public static final int PLAYER_STEP_PLAY_DONE = 50;
    public static final int PLAYER_STEP_REDIRECT = 34;
    public static final int PLAYER_STEP_USER_SEEK = 40;
    public static final int PLAYER_TYPE_SYSTEM_PLAYER = 0;
    public static final int PLAYER_TYPE_THUMB_PLAYER = 1;
    public static final int PLAY_END_REASON_APP_EXIT = 2;
    public static final int PLAY_END_REASON_EOS = 0;
    public static final int PLAY_END_REASON_PLAYER_ERROR = 3;
    public static final int PLAY_END_REASON_USER_STOP = 1;
    public static final int PLAY_EVENT_NONE = 0;
    public static final int PLAY_EVENT_PAUSE_BY_DEVICE = 2;
    public static final int PLAY_EVENT_SCREEN_SHOT = 3;
    public static final int PLAY_EVENT_SEEK = 1;
    public static final int PLAY_SCENE_NORMAL_PLAY = 1;
    public static final int PLAY_SCENE_TRICK_PLAY = 2;
    public static final int PLAY_TYPE_LIVE = 1;
    public static final int PLAY_TYPE_UNKNOWN = -1;
    public static final int PLAY_TYPE_VOD = 0;
    public static final String PROP_KEY_DATA = "data";
    private static final String TAG = "TPReportParams";
    public static final int VIDEO_DL_TYPE_HLS = 3;
    public static final int VIDEO_DL_TYPE_MP4 = 1;
    private CommonParams commonParams = new CommonParams();
    private PlayerInitParams initParams = new PlayerInitParams();
    private GetCdnUrlParams getCdnParams = new GetCdnUrlParams();
    private FirstLoadParams firstLoadParams = new FirstLoadParams();
    private FirstRenderParams firstRenderParams = new FirstRenderParams();
    private LoadSubtitleParams loadSubtitleParams = new LoadSubtitleParams();
    private RedirectParams redirectParams = new RedirectParams();
    private BufferingTotalParams bufferingTotalParams = new BufferingTotalParams();
    private UserSeekTotalParams userSeekTotalParams = new UserSeekTotalParams();
    private PlayDoneParams playDoneParams = new PlayDoneParams();
    private LiveExParam liveExParam = new LiveExParam();
    private VodExParam vodExParam = new VodExParam();

    /* loaded from: classes26.dex */
    public class BufferingOnceParams implements ITPReportParams {
        public long bufferingPresentTimeLong;
        public long endTimeUnix;
        public String errCodeString;
        public int formatInt;
        public int lastEventInt;
        public int reasonInt;
        public int sceneInt;
        public long starTimeUnix;
        public String urlString;

        public BufferingOnceParams() {
        }

        @Override // com.tencent.thumbplayer.report.reportv1.ITPReportParams
        public void paramsToJson(JSONObject jSONObject) {
            try {
                jSONObject.put("scene", this.sceneInt);
                jSONObject.put(TPReportKeys.PlayerStep.PLAYER_BUFFERING_LAST_EVENT, this.lastEventInt);
                jSONObject.put("reason", this.reasonInt);
                jSONObject.put("format", this.formatInt);
                jSONObject.put("ptime", this.bufferingPresentTimeLong);
                jSONObject.put(TPReportKeys.PlayerStep.PLAYER_START_TIME, this.starTimeUnix);
                jSONObject.put(TPReportKeys.PlayerStep.PLAYER_END_TIME, this.endTimeUnix);
                jSONObject.put("url", this.urlString);
                jSONObject.put("code", this.errCodeString);
            } catch (JSONException e16) {
                TPLogUtil.e(TPReportParams.TAG, e16);
            }
        }

        @Override // com.tencent.thumbplayer.report.reportv1.ITPReportParams
        public void paramsToProperties(ITPReportProperties iTPReportProperties) {
            iTPReportProperties.put("scene", this.sceneInt);
            iTPReportProperties.put(TPReportKeys.PlayerStep.PLAYER_BUFFERING_LAST_EVENT, this.lastEventInt);
            iTPReportProperties.put("reason", this.reasonInt);
            iTPReportProperties.put("format", this.formatInt);
            iTPReportProperties.put("ptime", this.bufferingPresentTimeLong);
            iTPReportProperties.put(TPReportKeys.PlayerStep.PLAYER_START_TIME, this.starTimeUnix);
            iTPReportProperties.put(TPReportKeys.PlayerStep.PLAYER_END_TIME, this.endTimeUnix);
            iTPReportProperties.put("url", this.urlString);
            iTPReportProperties.put("code", this.errCodeString);
        }

        @Override // com.tencent.thumbplayer.report.reportv1.ITPReportParams
        public void reset() {
            this.sceneInt = 1;
            this.lastEventInt = 0;
            this.reasonInt = TPReportParams.BUFFERING_REASON_NETWORK_UNSTABLE;
        }
    }

    /* loaded from: classes26.dex */
    public class BufferingTotalParams implements ITPReportParams {
        public int bufferingCountInt;
        public int bufferingDurationInt;
        public List<BufferingOnceParams> bufferingOnceParamsList = new LinkedList();

        public BufferingTotalParams() {
        }

        @Override // com.tencent.thumbplayer.report.reportv1.ITPReportParams
        public void paramsToJson(JSONObject jSONObject) {
            try {
                jSONObject.put(TPReportKeys.PlayerStep.PLAYER_BUFFERING_COUNT, this.bufferingCountInt);
                jSONObject.put(TPReportKeys.PlayerStep.PLAYER_BUFFERING_DURATION, this.bufferingDurationInt);
                JSONArray jSONArray = new JSONArray();
                for (BufferingOnceParams bufferingOnceParams : this.bufferingOnceParamsList) {
                    JSONObject jSONObject2 = new JSONObject();
                    bufferingOnceParams.paramsToJson(jSONObject2);
                    jSONArray.mo162put(jSONObject2);
                }
                jSONObject.put(TPReportParams.JSON_KEY_VAL, jSONArray);
            } catch (JSONException e16) {
                TPLogUtil.e(TPReportParams.TAG, e16);
            }
        }

        @Override // com.tencent.thumbplayer.report.reportv1.ITPReportParams
        public void paramsToProperties(ITPReportProperties iTPReportProperties) {
            iTPReportProperties.put(TPReportKeys.PlayerStep.PLAYER_BUFFERING_COUNT, this.bufferingCountInt);
            iTPReportProperties.put(TPReportKeys.PlayerStep.PLAYER_BUFFERING_DURATION, this.bufferingDurationInt);
        }

        @Override // com.tencent.thumbplayer.report.reportv1.ITPReportParams
        public void reset() {
            this.bufferingCountInt = 0;
            this.bufferingDurationInt = 0;
            this.bufferingOnceParamsList.clear();
        }
    }

    /* loaded from: classes26.dex */
    public class FirstLoadParams implements ITPReportParams {
        public String cdnUrlString;
        public int cgiUrlIndex;
        public long endTimeUnix;
        public String errCodeString;
        public long firstOpenTimeUnix;
        public long firstPacketReadTimeUnix;
        public long starTimeUnix;

        public FirstLoadParams() {
        }

        @Override // com.tencent.thumbplayer.report.reportv1.ITPReportParams
        public void paramsToJson(JSONObject jSONObject) {
            try {
                jSONObject.put(TPReportKeys.PlayerStep.PLAYER_START_TIME, this.starTimeUnix);
                jSONObject.put(TPReportKeys.PlayerStep.PLAYER_END_TIME, this.endTimeUnix);
                jSONObject.put(TPReportKeys.PlayerStep.PLAYER_FIRST_OPEN_TIME, this.firstOpenTimeUnix);
                jSONObject.put(TPReportKeys.PlayerStep.PLAYER_FIRST_PACKET_READ_TIME, this.firstPacketReadTimeUnix);
                jSONObject.put("url", this.cdnUrlString);
                jSONObject.put(TPReportKeys.PlayerStep.PLAYER_URL_INDEX, this.cgiUrlIndex);
                jSONObject.put("code", this.errCodeString);
            } catch (JSONException e16) {
                TPLogUtil.e(TPReportParams.TAG, e16);
            }
        }

        @Override // com.tencent.thumbplayer.report.reportv1.ITPReportParams
        public void paramsToProperties(ITPReportProperties iTPReportProperties) {
            iTPReportProperties.put(TPReportKeys.PlayerStep.PLAYER_START_TIME, this.starTimeUnix);
            iTPReportProperties.put(TPReportKeys.PlayerStep.PLAYER_END_TIME, this.endTimeUnix);
            iTPReportProperties.put(TPReportKeys.PlayerStep.PLAYER_FIRST_OPEN_TIME, this.firstOpenTimeUnix);
            iTPReportProperties.put(TPReportKeys.PlayerStep.PLAYER_FIRST_PACKET_READ_TIME, this.firstPacketReadTimeUnix);
            iTPReportProperties.put("url", this.cdnUrlString);
            iTPReportProperties.put(TPReportKeys.PlayerStep.PLAYER_URL_INDEX, this.cgiUrlIndex);
            iTPReportProperties.put("code", this.errCodeString);
        }

        @Override // com.tencent.thumbplayer.report.reportv1.ITPReportParams
        public void reset() {
            this.starTimeUnix = 0L;
            this.firstOpenTimeUnix = 0L;
            this.firstPacketReadTimeUnix = 0L;
            this.endTimeUnix = 0L;
            this.cdnUrlString = "";
            this.cgiUrlIndex = 0;
            this.errCodeString = "0";
        }
    }

    /* loaded from: classes26.dex */
    public class FirstRenderParams implements ITPReportParams {
        public long endTimeUnix;
        public String errCodeString;
        public long starTimeUnix;

        public FirstRenderParams() {
        }

        @Override // com.tencent.thumbplayer.report.reportv1.ITPReportParams
        public void paramsToJson(JSONObject jSONObject) {
            try {
                jSONObject.put(TPReportKeys.PlayerStep.PLAYER_START_TIME, this.starTimeUnix);
                jSONObject.put(TPReportKeys.PlayerStep.PLAYER_END_TIME, this.endTimeUnix);
                jSONObject.put("code", this.errCodeString);
            } catch (JSONException e16) {
                TPLogUtil.e(TPReportParams.TAG, e16);
            }
        }

        @Override // com.tencent.thumbplayer.report.reportv1.ITPReportParams
        public void paramsToProperties(ITPReportProperties iTPReportProperties) {
            iTPReportProperties.put(TPReportKeys.PlayerStep.PLAYER_START_TIME, this.starTimeUnix);
            iTPReportProperties.put(TPReportKeys.PlayerStep.PLAYER_END_TIME, this.endTimeUnix);
            iTPReportProperties.put("code", this.errCodeString);
        }

        @Override // com.tencent.thumbplayer.report.reportv1.ITPReportParams
        public void reset() {
            this.starTimeUnix = 0L;
            this.endTimeUnix = 0L;
            this.errCodeString = "0";
        }
    }

    /* loaded from: classes26.dex */
    public class GetCdnUrlParams implements ITPReportParams {
        public long endTimeUnix;
        public String errCodeString;
        public String proxyIpString;
        public long starTimeUnix;

        public GetCdnUrlParams() {
        }

        @Override // com.tencent.thumbplayer.report.reportv1.ITPReportParams
        public void paramsToJson(JSONObject jSONObject) {
            try {
                jSONObject.put(TPReportKeys.PlayerStep.PLAYER_START_TIME, this.starTimeUnix);
                jSONObject.put(TPReportKeys.PlayerStep.PLAYER_END_TIME, this.endTimeUnix);
                jSONObject.put("ip", this.proxyIpString);
                jSONObject.put("code", this.errCodeString);
            } catch (JSONException e16) {
                TPLogUtil.e(TPReportParams.TAG, e16);
            }
        }

        @Override // com.tencent.thumbplayer.report.reportv1.ITPReportParams
        public void paramsToProperties(ITPReportProperties iTPReportProperties) {
            iTPReportProperties.put(TPReportKeys.PlayerStep.PLAYER_START_TIME, this.starTimeUnix);
            iTPReportProperties.put(TPReportKeys.PlayerStep.PLAYER_END_TIME, this.endTimeUnix);
            iTPReportProperties.put("ip", this.proxyIpString);
            iTPReportProperties.put("code", this.errCodeString);
        }

        @Override // com.tencent.thumbplayer.report.reportv1.ITPReportParams
        public void reset() {
            this.starTimeUnix = 0L;
            this.endTimeUnix = 0L;
            this.proxyIpString = "";
            this.errCodeString = "0";
        }
    }

    /* loaded from: classes26.dex */
    public class LoadSubtitleParams implements ITPReportParams {
        public int bufferingDurationInt;
        public int cdnTypeInt;
        public int cgiUrlIndex;
        public long endTimeUnix;
        public String errCodeString;
        public long starTimeUnix;
        public String subtitleUrlString;

        public LoadSubtitleParams() {
        }

        @Override // com.tencent.thumbplayer.report.reportv1.ITPReportParams
        public void paramsToJson(JSONObject jSONObject) {
            try {
                jSONObject.put(TPReportKeys.PlayerStep.PLAYER_START_TIME, this.starTimeUnix);
                jSONObject.put(TPReportKeys.PlayerStep.PLAYER_END_TIME, this.endTimeUnix);
                jSONObject.put(TPReportKeys.PlayerStep.PLAYER_BUFFER_DURATION, this.bufferingDurationInt);
                jSONObject.put("url", this.subtitleUrlString);
                jSONObject.put(TPReportKeys.PlayerStep.PLAYER_CDN_TYPE, this.cdnTypeInt);
                jSONObject.put(TPReportKeys.PlayerStep.PLAYER_URL_INDEX, this.cgiUrlIndex);
                jSONObject.put("code", this.errCodeString);
            } catch (JSONException e16) {
                TPLogUtil.e(TPReportParams.TAG, e16);
            }
        }

        @Override // com.tencent.thumbplayer.report.reportv1.ITPReportParams
        public void paramsToProperties(ITPReportProperties iTPReportProperties) {
            iTPReportProperties.put(TPReportKeys.PlayerStep.PLAYER_START_TIME, this.starTimeUnix);
            iTPReportProperties.put(TPReportKeys.PlayerStep.PLAYER_END_TIME, this.endTimeUnix);
            iTPReportProperties.put(TPReportKeys.PlayerStep.PLAYER_BUFFER_DURATION, this.bufferingDurationInt);
            iTPReportProperties.put("url", this.subtitleUrlString);
            iTPReportProperties.put(TPReportKeys.PlayerStep.PLAYER_CDN_TYPE, this.cdnTypeInt);
            iTPReportProperties.put(TPReportKeys.PlayerStep.PLAYER_URL_INDEX, this.cgiUrlIndex);
            iTPReportProperties.put("code", this.errCodeString);
        }

        @Override // com.tencent.thumbplayer.report.reportv1.ITPReportParams
        public void reset() {
            this.starTimeUnix = 0L;
            this.endTimeUnix = 0L;
            this.bufferingDurationInt = 0;
            this.subtitleUrlString = "";
            this.cdnTypeInt = 0;
            this.cgiUrlIndex = 0;
            this.errCodeString = "0";
        }
    }

    /* loaded from: classes26.dex */
    public class PlayDoneParams implements ITPReportParams {
        public long endTimeUnix;
        public String errCodeString;
        public float playDurationFloat;
        public int reasonInt;

        public PlayDoneParams() {
        }

        @Override // com.tencent.thumbplayer.report.reportv1.ITPReportParams
        public void paramsToJson(JSONObject jSONObject) {
            try {
                jSONObject.put("reason", this.reasonInt);
                jSONObject.put(TPReportKeys.PlayerStep.PLAYER_END_TIME, this.endTimeUnix);
                jSONObject.put(TPReportKeys.PlayerStep.PLAYER_PLAY_DURATION, this.playDurationFloat);
                jSONObject.put("code", this.errCodeString);
            } catch (JSONException e16) {
                TPLogUtil.e(TPReportParams.TAG, e16);
            }
        }

        @Override // com.tencent.thumbplayer.report.reportv1.ITPReportParams
        public void paramsToProperties(ITPReportProperties iTPReportProperties) {
            iTPReportProperties.put("reason", this.reasonInt);
            iTPReportProperties.put(TPReportKeys.PlayerStep.PLAYER_END_TIME, this.endTimeUnix);
            iTPReportProperties.put(TPReportKeys.PlayerStep.PLAYER_PLAY_DURATION, this.playDurationFloat);
            iTPReportProperties.put("code", this.errCodeString);
        }

        @Override // com.tencent.thumbplayer.report.reportv1.ITPReportParams
        public void reset() {
            this.reasonInt = 0;
            this.endTimeUnix = 0L;
            this.playDurationFloat = 0.0f;
            this.errCodeString = "0";
        }
    }

    /* loaded from: classes26.dex */
    public class PlayerInitParams implements ITPReportParams {
        public String errCodeString;
        public long playEndTimeUnix;
        public long playStarTimeUnix;

        public PlayerInitParams() {
        }

        @Override // com.tencent.thumbplayer.report.reportv1.ITPReportParams
        public void paramsToJson(JSONObject jSONObject) {
            try {
                jSONObject.put(TPReportKeys.PlayerStep.PLAYER_START_TIME, this.playStarTimeUnix);
                jSONObject.put(TPReportKeys.PlayerStep.PLAYER_END_TIME, this.playEndTimeUnix);
                jSONObject.put("code", this.errCodeString);
            } catch (JSONException e16) {
                TPLogUtil.e(TPReportParams.TAG, e16);
            }
        }

        @Override // com.tencent.thumbplayer.report.reportv1.ITPReportParams
        public void paramsToProperties(ITPReportProperties iTPReportProperties) {
            iTPReportProperties.put(TPReportKeys.PlayerStep.PLAYER_START_TIME, this.playStarTimeUnix);
            iTPReportProperties.put(TPReportKeys.PlayerStep.PLAYER_END_TIME, this.playEndTimeUnix);
            iTPReportProperties.put("code", this.errCodeString);
        }

        @Override // com.tencent.thumbplayer.report.reportv1.ITPReportParams
        public void reset() {
            this.playStarTimeUnix = 0L;
            this.playEndTimeUnix = 0L;
            this.errCodeString = "0";
        }
    }

    /* loaded from: classes26.dex */
    public class RedirectParams implements ITPReportParams {
        public int cdnTypeInt;
        public long endTimeUnix;
        public String errCodeString;
        public int redirectCountInt;
        public String redirectedUrlString;
        public long starTimeUnix;

        public RedirectParams() {
        }

        @Override // com.tencent.thumbplayer.report.reportv1.ITPReportParams
        public void paramsToJson(JSONObject jSONObject) {
            try {
                jSONObject.put(TPReportKeys.PlayerStep.PLAYER_END_TIME, this.endTimeUnix);
                jSONObject.put("url", this.redirectedUrlString);
                jSONObject.put(TPReportKeys.PlayerStep.PLAYER_CDN_TYPE, this.cdnTypeInt);
                jSONObject.put(TPReportKeys.PlayerStep.PLAYER_T302, this.redirectCountInt);
                jSONObject.put("code", this.errCodeString);
            } catch (JSONException e16) {
                TPLogUtil.e(TPReportParams.TAG, e16);
            }
        }

        @Override // com.tencent.thumbplayer.report.reportv1.ITPReportParams
        public void paramsToProperties(ITPReportProperties iTPReportProperties) {
            iTPReportProperties.put(TPReportKeys.PlayerStep.PLAYER_END_TIME, this.endTimeUnix);
            iTPReportProperties.put("url", this.redirectedUrlString);
            iTPReportProperties.put(TPReportKeys.PlayerStep.PLAYER_CDN_TYPE, this.cdnTypeInt);
            iTPReportProperties.put(TPReportKeys.PlayerStep.PLAYER_T302, this.redirectCountInt);
            iTPReportProperties.put("code", this.errCodeString);
        }

        @Override // com.tencent.thumbplayer.report.reportv1.ITPReportParams
        public void reset() {
            this.starTimeUnix = 0L;
            this.endTimeUnix = 0L;
            this.redirectedUrlString = "";
            this.cdnTypeInt = 0;
            this.redirectCountInt = 0;
            this.errCodeString = "0";
        }
    }

    /* loaded from: classes26.dex */
    public class UserSeekOnceParams implements ITPReportParams {
        public long endPresentTimeLong;
        public String errCodeString;
        public int formatInt;
        public long seekEndTimeUnix;
        public long seekStartTimeUnix;
        public long startPresentTimeLong;

        public UserSeekOnceParams() {
        }

        @Override // com.tencent.thumbplayer.report.reportv1.ITPReportParams
        public void paramsToJson(JSONObject jSONObject) {
            try {
                jSONObject.put("format", this.formatInt);
                jSONObject.put(TPReportKeys.PlayerStep.PLAYER_SEEK_PRESENT_START_TIME, this.startPresentTimeLong);
                jSONObject.put(TPReportKeys.PlayerStep.PLAYER_SEEK_PRESENT_END_TIME, this.endPresentTimeLong);
                jSONObject.put(TPReportKeys.PlayerStep.PLAYER_SEEK_BUFFERING_START_TIME, this.seekStartTimeUnix);
                jSONObject.put(TPReportKeys.PlayerStep.PLAYER_SEEK_BUFFERING_END_TIME, this.seekEndTimeUnix);
                jSONObject.put("code", this.errCodeString);
            } catch (JSONException e16) {
                TPLogUtil.e(TPReportParams.TAG, e16);
            }
        }

        @Override // com.tencent.thumbplayer.report.reportv1.ITPReportParams
        public void paramsToProperties(ITPReportProperties iTPReportProperties) {
            iTPReportProperties.put("format", this.formatInt);
            iTPReportProperties.put(TPReportKeys.PlayerStep.PLAYER_SEEK_PRESENT_START_TIME, this.startPresentTimeLong);
            iTPReportProperties.put(TPReportKeys.PlayerStep.PLAYER_SEEK_PRESENT_END_TIME, this.endPresentTimeLong);
            iTPReportProperties.put(TPReportKeys.PlayerStep.PLAYER_SEEK_BUFFERING_START_TIME, this.seekStartTimeUnix);
            iTPReportProperties.put(TPReportKeys.PlayerStep.PLAYER_SEEK_BUFFERING_END_TIME, this.seekEndTimeUnix);
            iTPReportProperties.put("code", this.errCodeString);
        }

        @Override // com.tencent.thumbplayer.report.reportv1.ITPReportParams
        public void reset() {
            this.startPresentTimeLong = 0L;
            this.endPresentTimeLong = 0L;
            this.seekStartTimeUnix = 0L;
            this.seekEndTimeUnix = 0L;
            this.errCodeString = "0";
        }
    }

    /* loaded from: classes26.dex */
    public class UserSeekTotalParams implements ITPReportParams {
        public int seekBufferingCountInt;
        public int seekBufferingDurationInt;
        public List<UserSeekOnceParams> seekOnceParamsList = new LinkedList();
        public int seekTotalCountInt;

        public UserSeekTotalParams() {
        }

        @Override // com.tencent.thumbplayer.report.reportv1.ITPReportParams
        public void paramsToJson(JSONObject jSONObject) {
            try {
                jSONObject.put(TPReportKeys.PlayerStep.PLAYER_SEEK_COUNT, this.seekTotalCountInt);
                jSONObject.put(TPReportKeys.PlayerStep.PLAYER_SEEK_BUFFERING_COUNT, this.seekBufferingCountInt);
                jSONObject.put(TPReportKeys.PlayerStep.PLAYER_SEEK_BUFFERING_DURATION, this.seekBufferingDurationInt);
                JSONArray jSONArray = new JSONArray();
                for (UserSeekOnceParams userSeekOnceParams : this.seekOnceParamsList) {
                    JSONObject jSONObject2 = new JSONObject();
                    userSeekOnceParams.paramsToJson(jSONObject2);
                    jSONArray.mo162put(jSONObject2);
                }
                jSONObject.put(TPReportParams.JSON_KEY_VAL, jSONArray);
            } catch (JSONException e16) {
                TPLogUtil.e(TPReportParams.TAG, e16);
            }
        }

        @Override // com.tencent.thumbplayer.report.reportv1.ITPReportParams
        public void paramsToProperties(ITPReportProperties iTPReportProperties) {
            iTPReportProperties.put(TPReportKeys.PlayerStep.PLAYER_SEEK_COUNT, this.seekTotalCountInt);
            iTPReportProperties.put(TPReportKeys.PlayerStep.PLAYER_SEEK_BUFFERING_COUNT, this.seekBufferingCountInt);
            iTPReportProperties.put(TPReportKeys.PlayerStep.PLAYER_SEEK_BUFFERING_DURATION, this.seekBufferingDurationInt);
        }

        @Override // com.tencent.thumbplayer.report.reportv1.ITPReportParams
        public void reset() {
            this.seekTotalCountInt = 0;
            this.seekBufferingCountInt = 0;
            this.seekBufferingDurationInt = 0;
            this.seekOnceParamsList.clear();
        }
    }

    public TPReportParams() {
        this.commonParams.reset();
        this.initParams.reset();
        this.getCdnParams.reset();
        this.firstLoadParams.reset();
        this.firstRenderParams.reset();
        this.loadSubtitleParams.reset();
        this.redirectParams.reset();
        this.bufferingTotalParams.reset();
        this.userSeekTotalParams.reset();
        this.playDoneParams.reset();
    }

    public BufferingOnceParams createBufferingOnceParams() {
        return new BufferingOnceParams();
    }

    public UserSeekOnceParams createUserSeekOnceParams() {
        return new UserSeekOnceParams();
    }

    public BufferingTotalParams getBufferingTotalParams() {
        return this.bufferingTotalParams;
    }

    public CommonParams getCommonParams() {
        return this.commonParams;
    }

    public FirstLoadParams getFirstLoadParams() {
        return this.firstLoadParams;
    }

    public FirstRenderParams getFirstRenderParams() {
        return this.firstRenderParams;
    }

    public GetCdnUrlParams getGetCdnParams() {
        return this.getCdnParams;
    }

    public PlayerInitParams getInitParams() {
        return this.initParams;
    }

    public LiveExParam getLiveExParam() {
        return this.liveExParam;
    }

    public LoadSubtitleParams getLoadSubtitleParams() {
        return this.loadSubtitleParams;
    }

    public PlayDoneParams getPlayDoneParams() {
        return this.playDoneParams;
    }

    public RedirectParams getRedirectParams() {
        return this.redirectParams;
    }

    public UserSeekTotalParams getUserSeekTotalParams() {
        return this.userSeekTotalParams;
    }

    public VodExParam getVodExParam() {
        return this.vodExParam;
    }

    public void resetAllParam() {
        this.commonParams.reset();
        this.firstLoadParams.reset();
        this.firstRenderParams.reset();
        this.loadSubtitleParams.reset();
        this.getCdnParams.reset();
        this.redirectParams.reset();
        this.bufferingTotalParams.reset();
        this.userSeekTotalParams.reset();
        this.playDoneParams.reset();
        this.liveExParam.reset();
        this.vodExParam.reset();
    }

    /* loaded from: classes26.dex */
    public class LiveExParam implements ITPReportParams {
        int adPlayLengthInt;
        int blockCountInt;
        int blockTimeInt;
        String cdnServerString;
        int connectTimeInt;
        int contentIdInt;
        String defSwitchString;
        int deviceTypeInt;
        int downSpeedInt;
        String downloadServerIpString;
        String downloadUrl;
        int errCodeInt;
        String extraInfoString;
        int freeTypeInt;
        String fullErrCodeString;
        int getStreamDurationInt;
        int getSyncFrameDurationInt;
        int getUrlTimeInt;
        int isLookBackInt;
        int isStreamP2PInt;
        int isUseP2PInt;
        int isUserPayInt;
        int liveDelayInt;
        int liveProgramIdInt;
        int liveTagInt;
        int liveTypeInt;
        long loadingTimeLong;
        int maxSpeedInt;
        int networkTypeInt;
        int playTimeInt;
        String playerVersionString;
        int prePlayLengthInt;
        int reconnectCntInt;
        long reportTimeLong;
        String spanId;
        int streamIdInt;
        int testSpeedInt;
        String tuid;
        String userIpString;
        String userQQString;

        public LiveExParam() {
        }

        @Override // com.tencent.thumbplayer.report.reportv1.ITPReportParams
        public void paramsToProperties(ITPReportProperties iTPReportProperties) {
            iTPReportProperties.put(TPReportKeys.LiveExKeys.LIVE_EX_REPORT_TIME, this.reportTimeLong);
            iTPReportProperties.put(TPReportKeys.LiveExKeys.LIVE_EX_S_IP, this.userIpString);
            iTPReportProperties.put(TPReportKeys.LiveExKeys.LIVE_EX_I_QQ, this.userQQString);
            iTPReportProperties.put(TPReportKeys.LiveExKeys.LIVE_EX_PRE_DURATION, this.prePlayLengthInt);
            iTPReportProperties.put(TPReportKeys.LiveExKeys.LIVE_EX_AD_DURATION, this.adPlayLengthInt);
            iTPReportProperties.put(TPReportKeys.LiveExKeys.LIVE_EX_PLAYER_VER, this.playerVersionString);
            iTPReportProperties.put(TPReportKeys.LiveExKeys.LIVE_EX_DL_IP, this.downloadServerIpString);
            iTPReportProperties.put(TPReportKeys.LiveExKeys.LIVE_EX_DEV_TYPE, this.deviceTypeInt);
            iTPReportProperties.put(TPReportKeys.LiveExKeys.LIVE_EX_NET_TYPE, this.networkTypeInt);
            iTPReportProperties.put("freetype", this.freeTypeInt);
            iTPReportProperties.put(TPReportKeys.LiveExKeys.LIVE_EX_USE_P2P, this.isUseP2PInt);
            iTPReportProperties.put(TPReportKeys.LiveExKeys.LIVE_EX_P2P_PLAY, this.isStreamP2PInt);
            iTPReportProperties.put("livepid", this.liveProgramIdInt);
            iTPReportProperties.put("sid", this.streamIdInt);
            iTPReportProperties.put(TPReportKeys.LiveExKeys.LIVE_EX_CONTENT_ID, this.contentIdInt);
            iTPReportProperties.put(TPReportKeys.LiveExKeys.LIVE_EX_PLAY_TIME, this.playTimeInt);
            iTPReportProperties.put(TPReportKeys.LiveExKeys.LIVE_EX_IS_USER_PAY, this.isUserPayInt);
            iTPReportProperties.put(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, this.defSwitchString);
            iTPReportProperties.put("live_type", this.liveTypeInt);
            iTPReportProperties.put(TPReportKeys.LiveExKeys.LIVE_EX_CDN_SERVER, this.cdnServerString);
            iTPReportProperties.put(TPReportKeys.LiveExKeys.LIVE_EX_DOWNLOAD_URL, this.downloadUrl);
            iTPReportProperties.put(TPReportKeys.LiveExKeys.LIVE_EX_IS_LOOK_BACK, this.isLookBackInt);
            iTPReportProperties.put(TPReportKeys.LiveExKeys.LIVE_EX_LIVE_DELAY, this.liveDelayInt);
            iTPReportProperties.put(TPReportKeys.LiveExKeys.LIVE_EX_LIVE_TAG, this.liveTagInt);
            iTPReportProperties.put("extraInfo", this.extraInfoString);
            iTPReportProperties.put(TPReportKeys.LiveExKeys.LIVE_EX_CONN_TIME, this.connectTimeInt);
            iTPReportProperties.put(TPReportKeys.LiveExKeys.LIVE_EX_MAX_SPEED, this.maxSpeedInt);
            iTPReportProperties.put(TPReportKeys.LiveExKeys.LIVE_EX_TEST_SPEED, this.testSpeedInt);
            iTPReportProperties.put(TPReportKeys.LiveExKeys.LIVE_EX_DOWN_SPEED, this.downSpeedInt);
            iTPReportProperties.put(TPReportKeys.LiveExKeys.LIVE_EX_RECONNECT_TIME, this.reconnectCntInt);
            iTPReportProperties.put(TPReportKeys.LiveExKeys.LIVE_EX_LOADING_TIME, this.loadingTimeLong);
            iTPReportProperties.put(TPReportKeys.LiveExKeys.LIVE_EX_BLOCK_TIME, this.blockTimeInt);
            iTPReportProperties.put(TPReportKeys.LiveExKeys.LIVE_EX_BLOCK_COUNT, this.blockCountInt);
            iTPReportProperties.put("errorcode", this.errCodeInt);
            iTPReportProperties.put(TPReportKeys.LiveExKeys.LIVE_EX_GET_URL_TIME, this.getUrlTimeInt);
            iTPReportProperties.put(TPReportKeys.LiveExKeys.LIVE_EX_FULL_CODE, this.fullErrCodeString);
            iTPReportProperties.put(TPReportKeys.LiveExKeys.LIVE_EX_GET_DATA_DURATION, this.getStreamDurationInt);
            iTPReportProperties.put(TPReportKeys.LiveExKeys.LIVE_EX_GET_SYNC_FRAM, this.getSyncFrameDurationInt);
            iTPReportProperties.put(TPReportKeys.LiveExKeys.LIVE_FX_SPANID, this.spanId);
            iTPReportProperties.put(TPReportKeys.LiveExKeys.LICE_FX_TUID, this.tuid);
        }

        @Override // com.tencent.thumbplayer.report.reportv1.ITPReportParams
        public void reset() {
        }

        @Override // com.tencent.thumbplayer.report.reportv1.ITPReportParams
        public void paramsToJson(JSONObject jSONObject) {
        }
    }

    /* loaded from: classes26.dex */
    public class VodExParam implements ITPReportParams {
        int bizIdInt;
        int clipInt;
        int currentPlayInt;
        int freeTypeInt;
        int hasSubtitleInt;
        int hevcLcInt;
        int hitDownloaded;
        int isSelectedSubtitleInt;
        int multiTrackInt;
        int optimizedPlayInt;
        int statusInt;

        public VodExParam() {
        }

        @Override // com.tencent.thumbplayer.report.reportv1.ITPReportParams
        public void paramsToProperties(ITPReportProperties iTPReportProperties) {
            iTPReportProperties.put("freetype", this.freeTypeInt);
            iTPReportProperties.put(TPReportKeys.VodExKeys.VOD_EX_CURRENT_PLAY, this.currentPlayInt);
            iTPReportProperties.put(TPReportKeys.VodExKeys.VOD_EX_OPTIMIZED_PLAY, this.optimizedPlayInt);
            iTPReportProperties.put(TPReportKeys.VodExKeys.VOD_EX_HAS_SUBTITLE, this.hasSubtitleInt);
            iTPReportProperties.put(TPReportKeys.VodExKeys.VOD_EX_SELECTED_SUBTITLE, this.isSelectedSubtitleInt);
            iTPReportProperties.put(TPReportKeys.VodExKeys.VOD_EX_MULTI_TRACK, this.multiTrackInt);
            iTPReportProperties.put(TPReportKeys.VodExKeys.VOD_EX_BIZ_ID, this.bizIdInt);
            iTPReportProperties.put("hevclv", this.hevcLcInt);
            iTPReportProperties.put("clip", this.clipInt);
            iTPReportProperties.put("status", this.statusInt);
            iTPReportProperties.put(TPReportKeys.VodExKeys.VOD_EX_HIT_DOWNLOADED, this.hitDownloaded);
        }

        @Override // com.tencent.thumbplayer.report.reportv1.ITPReportParams
        public void reset() {
        }

        @Override // com.tencent.thumbplayer.report.reportv1.ITPReportParams
        public void paramsToJson(JSONObject jSONObject) {
        }
    }

    /* loaded from: classes26.dex */
    public class CommonParams implements ITPReportParams {
        public String appVersionString;
        public int cdnIdInt;
        public String cdnIpString;
        public String cdnUipString;
        public String deviceNameString;
        public String deviceResolutionString;
        public int downloadTypeInt;
        public String flowIdString;
        public String guidString;
        public int loginTypeInt;
        public float mediaDurationFloat;
        public int mediaFormatInt;
        public int mediaRateInt;
        public String mediaResolutionString;
        public int networkSpeedInt;
        public int networkTypeInt;
        public int onlineInt;
        public String osVersionString;
        public int p2pInt;
        public String p2pVersionString;
        public long platformLong;
        public String playNoString;
        public int playTypeInt;
        public int playerTypeInt;
        public String playerVersionString;
        public String proto;
        public String protover;
        public String qqOpenIdString;
        public int scenesId;
        public int seqInt = 0;
        public int signalStrengthInt;
        public int stepInt;
        public int testIdInt;
        public String uinString;
        public String uipString;
        public String vidString;
        public String wxOpenIdString;

        public CommonParams() {
        }

        @Override // com.tencent.thumbplayer.report.reportv1.ITPReportParams
        public void paramsToProperties(ITPReportProperties iTPReportProperties) {
            iTPReportProperties.put("step", this.stepInt);
            iTPReportProperties.put("seq", this.seqInt);
            iTPReportProperties.put("platform", this.platformLong);
            iTPReportProperties.put("flowid", this.flowIdString);
            iTPReportProperties.put(TPReportKeys.Common.COMMON_PLAY_NO, this.playNoString);
            iTPReportProperties.put("uin", this.uinString);
            iTPReportProperties.put(TPReportKeys.Common.COMMON_QQ_OPEN_ID, this.qqOpenIdString);
            iTPReportProperties.put(TPReportKeys.Common.COMMON_WX_OPEN_ID, this.wxOpenIdString);
            iTPReportProperties.put(TPReportKeys.Common.COMMON_LOGIN_TYPE, this.loginTypeInt);
            iTPReportProperties.put("guid", this.guidString);
            iTPReportProperties.put(TPReportKeys.Common.COMMON_UIP, this.uipString);
            iTPReportProperties.put(TPReportKeys.Common.COMMON_CDN_UIP, this.cdnUipString);
            iTPReportProperties.put(TPReportKeys.Common.COMMON_CDN_IP, this.cdnIpString);
            iTPReportProperties.put(TPReportKeys.Common.COMMON_ONLINE, this.onlineInt);
            iTPReportProperties.put(TPReportKeys.Common.COMMON_P2P, this.p2pInt);
            iTPReportProperties.put(TPReportKeys.Common.COMMON_SIG_STRENGTH, this.signalStrengthInt);
            iTPReportProperties.put("network", this.networkTypeInt);
            iTPReportProperties.put("speed", this.networkSpeedInt);
            iTPReportProperties.put("device", this.deviceNameString);
            iTPReportProperties.put("resolution", this.deviceResolutionString);
            iTPReportProperties.put("testid", this.testIdInt);
            iTPReportProperties.put(TPReportKeys.Common.COMMON_OS_VERSION, this.osVersionString);
            iTPReportProperties.put(TPReportKeys.Common.COMMON_P2P_VERSION, this.p2pVersionString);
            iTPReportProperties.put("appver", this.appVersionString);
            iTPReportProperties.put(TPReportKeys.Common.COMMON_PLAYER_VERSION, this.playerVersionString);
            iTPReportProperties.put(TPReportKeys.Common.COMMON_PLAYER_TYPE, this.playerTypeInt);
            iTPReportProperties.put(TPReportKeys.Common.COMMON_CDN_ID, this.cdnIdInt);
            iTPReportProperties.put(TPReportKeys.Common.COMMON_SCENES_ID, this.scenesId);
            iTPReportProperties.put(TPReportKeys.Common.COMMON_PLAY_TYPE, this.playTypeInt);
            iTPReportProperties.put(TPReportKeys.Common.COMMON_DL_TYPE, this.downloadTypeInt);
            iTPReportProperties.put("vid", this.vidString);
            iTPReportProperties.put("definition", this.mediaResolutionString);
            iTPReportProperties.put(TPReportKeys.Common.COMMON_MEDIA_FORMAT, this.mediaFormatInt);
            iTPReportProperties.put("rate", this.mediaRateInt);
            iTPReportProperties.put("duration", this.mediaDurationFloat);
            iTPReportProperties.put("proto", this.proto);
            iTPReportProperties.put(TPReportKeys.Common.COMMON_PROTOVER, this.protover);
        }

        @Override // com.tencent.thumbplayer.report.reportv1.ITPReportParams
        public void reset() {
            this.stepInt = 0;
            this.seqInt = 0;
            this.platformLong = 0L;
            this.flowIdString = "";
            this.playNoString = "";
            this.uinString = "";
            this.qqOpenIdString = "";
            this.wxOpenIdString = "";
            this.loginTypeInt = 0;
            this.guidString = "";
            this.uipString = "";
            this.cdnUipString = "";
            this.cdnIpString = "";
            this.onlineInt = 0;
            this.p2pInt = 0;
            this.signalStrengthInt = 0;
            this.networkTypeInt = 0;
            this.networkSpeedInt = 0;
            this.deviceNameString = "";
            this.deviceResolutionString = "";
            this.testIdInt = 0;
            this.osVersionString = "";
            this.p2pVersionString = "";
            this.appVersionString = "";
            this.playerVersionString = "";
            this.playerTypeInt = 0;
            this.cdnIdInt = 0;
            this.scenesId = 0;
            this.downloadTypeInt = 0;
            this.vidString = "";
            this.mediaResolutionString = "";
            this.mediaFormatInt = 0;
            this.mediaRateInt = 0;
            this.mediaDurationFloat = 0.0f;
            this.proto = "";
            this.protover = "";
        }

        @Override // com.tencent.thumbplayer.report.reportv1.ITPReportParams
        public void paramsToJson(JSONObject jSONObject) {
        }
    }
}
