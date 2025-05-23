package com.tencent.qqlive.tvkplayer.security;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKVideoInfoFromType;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKVodVideoInfo;
import com.tencent.qqlive.tvkplayer.context.TVKContext;
import com.tencent.qqlive.tvkplayer.event.ITVKEventObserver;
import com.tencent.qqlive.tvkplayer.event.TVKEventId;
import com.tencent.qqlive.tvkplayer.event.TVKEventParams;
import com.tencent.qqlive.tvkplayer.plugin.ITVKPlugin;
import com.tencent.qqlive.tvkplayer.security.TVKPlaybackAliveKeeper;
import com.tencent.qqlive.tvkplayer.tools.baseinfo.TVKCommParams;
import com.tencent.qqlive.tvkplayer.tools.baseinfo.TVKVersion;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.http.TVKHttpProcessorFactory;
import com.tencent.qqlive.tvkplayer.tools.http.api.ITVKHttpProcessor;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKThreadPool;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUrlBuilder;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKVcSystemInfo;
import com.tencent.qqlive.tvkplayer.vinfo.checktime.TVKServerTimeGetter;
import com.tencent.qqlive.tvkplayer.vinfo.common.TVKCKeyDecryptedResult;
import com.tencent.qqlive.tvkplayer.vinfo.common.TVKCKeyEncryptedResult;
import com.tencent.qqlive.tvkplayer.vinfo.common.TVKCKeyGenerator;
import com.tencent.qqlive.tvkplayer.vinfo.common.TVKCkeyParam;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes23.dex */
public class TVKPlaybackAliveKeeper implements ITVKEventObserver, ITVKPlugin {
    private static final String HTTP_REQUEST_TAG = "PollingService";
    private static final int MAX_POLLING_INTERVAL_SEC = 86400;
    private static final int MIN_POLLING_INTERVAL_SEC = 10;
    private static final int POLLING_REPORT_SCRIPT_TYPE_RANDOM = 1;
    private static final int POLLING_REQUEST_CMD_END = 3;
    private static final int POLLING_REQUEST_CMD_PERIOD = 2;
    private static final int POLLING_REQUEST_CMD_PULL_SCRIPT = 1;
    private static final String POLLING_REQUEST_QUERY_KEY_CKEY = "ce";
    private static final String POLLING_REQUEST_QUERY_KEY_CKEY_ENCRYPT_VER = "ev";
    private static final int POLLING_REQUEST_TIMEOUT_MS = 5000;
    private static final String POLLING_RESPONSE_KEY_ENCRYPTED_ANC = "anc";
    private static final String TAG = "TVKPlaybackAliveKeeper";
    private final Context mCtx;
    private final TVKContext mTVKContext;
    private String mPollingReportUrl = "";
    private String mVid = "";
    private TVKVideoInfoFromType mVinfoFromType = TVKVideoInfoFromType.FROM_TYPE_SERVER;
    private long mCurrentPositionSec = 0;
    private int mPollingId = 0;
    private String mRespScript = "";
    private String mRespTopicId = "";
    private long mPollingIntervalSec = TVKMediaPlayerConfig.PlayerConfig.default_polling_report_interval_sec;
    private PollingReportState mPollingReportState = PollingReportState.POLLING_REPORT_STATE_IDLE;
    private long mRequestTimestampSince1970Ms = 0;
    private ScheduledFuture<?> mTimerTask = null;
    private final ITVKHttpProcessor.ITVKHttpCallback mHttpCallback = new ITVKHttpProcessor.ITVKHttpCallback() { // from class: com.tencent.qqlive.tvkplayer.security.TVKPlaybackAliveKeeper.1
        @Override // com.tencent.qqlive.tvkplayer.tools.http.api.ITVKHttpProcessor.ITVKHttpCallback
        public void onFailure(IOException iOException) {
            TVKPlaybackAliveKeeper.this.handleFailure(iOException);
        }

        @Override // com.tencent.qqlive.tvkplayer.tools.http.api.ITVKHttpProcessor.ITVKHttpCallback
        public void onSuccess(ITVKHttpProcessor.TVKHttpResponse tVKHttpResponse) {
            TVKPlaybackAliveKeeper.this.handleSuccess(tVKHttpResponse);
        }
    };
    private final Map<Integer, MessageExecutor> mMessageHandler = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes23.dex */
    public interface MessageExecutor {
        void execute(ReportMessage reportMessage);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes23.dex */
    public enum PollingReportState {
        POLLING_REPORT_STATE_IDLE,
        POLLING_REPORT_STATE_STARTED,
        POLLING_REPORT_STATE_PAUSED,
        POLLING_REPORT_STATE_COMPLETED
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public static class ReportMessage {
        long currentTimeMs;
        int eventArg1;
        int eventArg2;
        String eventArg3;
        Object eventObject;

        ReportMessage() {
        }
    }

    public TVKPlaybackAliveKeeper(@NonNull TVKContext tVKContext) {
        this.mTVKContext = tVKContext;
        this.mCtx = tVKContext.getContext();
        initMsgFunction();
    }

    @NonNull
    private Map<String, String> buildPollRequestQueryParams(@NonNull String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(POLLING_REQUEST_QUERY_KEY_CKEY, str);
        hashMap.put(POLLING_REQUEST_QUERY_KEY_CKEY_ENCRYPT_VER, TVKCKeyGenerator.getEncryptVer());
        return hashMap;
    }

    private void endPreviousPollingIfNeeded() {
        if (!needCancelPrePolling()) {
            return;
        }
        stopPollingReport();
    }

    private void executeReportMsg(final int i3, int i16, int i17, String str, Object obj) {
        final ReportMessage reportMessage = new ReportMessage();
        reportMessage.currentTimeMs = System.currentTimeMillis();
        reportMessage.eventArg1 = i16;
        reportMessage.eventArg2 = i17;
        reportMessage.eventArg3 = str;
        reportMessage.eventObject = obj;
        TVKThreadPool.getInstance().obtainSingleThreadExecutor().execute(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.security.TVKPlaybackAliveKeeper.2
            @Override // java.lang.Runnable
            public void run() {
                MessageExecutor messageExecutor;
                if (TVKPlaybackAliveKeeper.this.mPollingReportState == PollingReportState.POLLING_REPORT_STATE_COMPLETED) {
                    return;
                }
                if ((i3 == 10201 || (!TextUtils.isEmpty(TVKPlaybackAliveKeeper.this.mPollingReportUrl) && TVKPlaybackAliveKeeper.this.mVinfoFromType != TVKVideoInfoFromType.FROM_TYPE_DL_PROXY)) && (messageExecutor = (MessageExecutor) TVKPlaybackAliveKeeper.this.mMessageHandler.get(Integer.valueOf(i3))) != null) {
                    messageExecutor.execute(reportMessage);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeReportRequestWithCmd(int i3) {
        if (TextUtils.isEmpty(this.mRespScript)) {
            i3 = 1;
        }
        this.mRequestTimestampSince1970Ms = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vid", this.mVid);
            jSONObject.put("ptime", this.mCurrentPositionSec);
            jSONObject.put("timestamp", this.mRequestTimestampSince1970Ms);
            jSONObject.put("guid", TVKCommParams.getStaGuid());
            JSONObject jSONObject2 = new JSONObject();
            int i16 = this.mPollingId + 1;
            this.mPollingId = i16;
            jSONObject2.put("pid", i16);
            jSONObject2.put("tid", this.mRespTopicId);
            jSONObject2.put("msg", this.mRespScript);
            jSONObject.put(TVKPlaybackAliveKeeperConstant.POLLING_REPORT_REQUEST_KEY_SESSION_INFO, jSONObject2);
            jSONObject.put("platform", TVKVersion.getPlatform());
            jSONObject.put("lang", 1);
            jSONObject.put("apv", TVKVcSystemInfo.getAppVersionName(this.mCtx));
            jSONObject.put(TVKPlaybackAliveKeeperConstant.POLLING_REPORT_REQUEST_KEY_QIMEI36, TVKCommParams.getQimei36());
            jSONObject.put("cmd", i3);
        } catch (JSONException unused) {
        }
        postPollingReportWithData(jSONObject.toString());
    }

    @NonNull
    private TVKCKeyEncryptedResult generateCkeyAndEncryptWithData(@NonNull String str) {
        return TVKCKeyGenerator.getCKeyWithData(new TVKCkeyParam.Builder(0, null).sdtfrom(TVKVersion.getSdtfrom()).platform(TVKVersion.getPlatform()).appVer(TVKVcSystemInfo.getAppVersionName(TVKCommParams.getApplicationContext())).build(), TVKServerTimeGetter.getInstance().calculateCurrentServerTimeSec(), str.getBytes(StandardCharsets.UTF_8));
    }

    @NonNull
    private String getHttpRequestTag() {
        return "PollingService_" + this.mPollingId;
    }

    private void handleGetvinfoResponseWithParam(Object obj) {
        TVKEventParams.GetVInfoResponseParam getVInfoResponseParam = (TVKEventParams.GetVInfoResponseParam) obj;
        if (getVInfoResponseParam == null) {
            return;
        }
        TVKNetVideoInfo tVKNetVideoInfo = getVInfoResponseParam.videoInfo;
        if (!(tVKNetVideoInfo instanceof TVKVodVideoInfo)) {
            return;
        }
        TVKVodVideoInfo tVKVodVideoInfo = (TVKVodVideoInfo) tVKNetVideoInfo;
        if (TextUtils.isEmpty(tVKVodVideoInfo.getPollingServiceUrl())) {
            return;
        }
        boolean isEmpty = TextUtils.isEmpty(this.mPollingReportUrl);
        endPreviousPollingIfNeeded();
        resetAllParams();
        this.mPollingReportUrl = tVKVodVideoInfo.getPollingServiceUrl();
        this.mVid = tVKVodVideoInfo.getVid();
        this.mVinfoFromType = tVKVodVideoInfo.getFromType();
        if (!isEmpty && !TextUtils.isEmpty(this.mPollingReportUrl)) {
            executeReportRequestWithCmd(2);
            this.mPollingReportState = PollingReportState.POLLING_REPORT_STATE_STARTED;
            reStartPollingReportTimerIfNeeded(this.mPollingIntervalSec);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public void handlePollingReportResponse(@NonNull byte[] bArr) {
        try {
            String optString = new JSONObject(new String(bArr, StandardCharsets.UTF_8)).optString(POLLING_RESPONSE_KEY_ENCRYPTED_ANC);
            if (optString.isEmpty()) {
                TVKLogUtil.e(TAG, "anc is null or empty.");
                return;
            }
            TVKCKeyDecryptedResult decryptCKeyServerResponse = TVKCKeyGenerator.decryptCKeyServerResponse(optString);
            if (decryptCKeyServerResponse != null && decryptCKeyServerResponse.getRetCode() == 0) {
                try {
                    JSONObject jSONObject = new JSONObject(new String(decryptCKeyServerResponse.getData(), StandardCharsets.UTF_8));
                    JSONObject optJSONObject = jSONObject.optJSONObject(TVKPlaybackAliveKeeperConstant.POLLING_REPORT_REQUEST_KEY_SESSION_INFO);
                    if (optJSONObject != null) {
                        int optInt = optJSONObject.optInt("pid");
                        if (isPollingReportTimeoutWithPollingReportId(optInt)) {
                            TVKLogUtil.w(TAG, "polling report timeout with pollId:" + optInt);
                            return;
                        }
                        this.mRespTopicId = optJSONObject.optString("tid");
                        this.mRespScript = optJSONObject.optString("msg");
                    }
                    long optLong = jSONObject.optLong("ptime");
                    if (optLong < 10 || optLong > 86400) {
                        optLong = this.mPollingIntervalSec;
                    }
                    reStartPollingReportTimerIfNeeded(optLong);
                    this.mPollingIntervalSec = optLong;
                    return;
                } catch (JSONException unused) {
                    TVKLogUtil.e(TAG, "fail to create TVKPollResponseInfo with ckey decrypted data");
                    return;
                }
            }
            TVKLogUtil.e(TAG, "fail to decryptCKeyServerResponse, return null.");
        } catch (JSONException e16) {
            TVKLogUtil.e(TAG, e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSuccess(final ITVKHttpProcessor.TVKHttpResponse tVKHttpResponse) {
        TVKThreadPool.getInstance().obtainSingleThreadExecutor().execute(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.security.TVKPlaybackAliveKeeper.9
            @Override // java.lang.Runnable
            public void run() {
                TVKPlaybackAliveKeeper.this.handlePollingReportResponse(tVKHttpResponse.getData());
            }
        });
    }

    private void initMsgFunction() {
        this.mMessageHandler.put(10201, new MessageExecutor() { // from class: com.tencent.qqlive.tvkplayer.security.a
            @Override // com.tencent.qqlive.tvkplayer.security.TVKPlaybackAliveKeeper.MessageExecutor
            public final void execute(TVKPlaybackAliveKeeper.ReportMessage reportMessage) {
                TVKPlaybackAliveKeeper.this.lambda$initMsgFunction$0(reportMessage);
            }
        });
        this.mMessageHandler.put(16000, new MessageExecutor() { // from class: com.tencent.qqlive.tvkplayer.security.TVKPlaybackAliveKeeper.3
            @Override // com.tencent.qqlive.tvkplayer.security.TVKPlaybackAliveKeeper.MessageExecutor
            public void execute(ReportMessage reportMessage) {
                Object obj = reportMessage.eventObject;
                if (obj != null) {
                    TVKPlaybackAliveKeeper.this.mCurrentPositionSec = ((Long) obj).longValue() / 1000;
                }
            }
        });
        this.mMessageHandler.put(Integer.valueOf(TVKEventId.PLAYER_STATE_START_PLAY), new MessageExecutor() { // from class: com.tencent.qqlive.tvkplayer.security.TVKPlaybackAliveKeeper.4
            @Override // com.tencent.qqlive.tvkplayer.security.TVKPlaybackAliveKeeper.MessageExecutor
            public void execute(ReportMessage reportMessage) {
                if (TVKPlaybackAliveKeeper.this.mPollingReportState == PollingReportState.POLLING_REPORT_STATE_IDLE) {
                    TVKPlaybackAliveKeeper.this.executeReportRequestWithCmd(2);
                }
                TVKPlaybackAliveKeeper tVKPlaybackAliveKeeper = TVKPlaybackAliveKeeper.this;
                tVKPlaybackAliveKeeper.startPollingReportTimer(tVKPlaybackAliveKeeper.mPollingIntervalSec);
                TVKPlaybackAliveKeeper.this.mPollingReportState = PollingReportState.POLLING_REPORT_STATE_STARTED;
            }
        });
        this.mMessageHandler.put(Integer.valueOf(TVKEventId.PLAYER_STATE_PAUSE), new MessageExecutor() { // from class: com.tencent.qqlive.tvkplayer.security.TVKPlaybackAliveKeeper.5
            @Override // com.tencent.qqlive.tvkplayer.security.TVKPlaybackAliveKeeper.MessageExecutor
            public void execute(ReportMessage reportMessage) {
                TVKPlaybackAliveKeeper.this.stopPollingReportTimer();
                TVKPlaybackAliveKeeper.this.mPollingReportState = PollingReportState.POLLING_REPORT_STATE_PAUSED;
            }
        });
        this.mMessageHandler.put(Integer.valueOf(TVKEventId.PLAYER_STATE_STOP), new MessageExecutor() { // from class: com.tencent.qqlive.tvkplayer.security.TVKPlaybackAliveKeeper.6
            @Override // com.tencent.qqlive.tvkplayer.security.TVKPlaybackAliveKeeper.MessageExecutor
            public void execute(ReportMessage reportMessage) {
                TVKPlaybackAliveKeeper.this.stopPollingReport();
                TVKPlaybackAliveKeeper.this.resetAllParams();
            }
        });
        this.mMessageHandler.put(Integer.valueOf(TVKEventId.PLAYER_STATE_PLAYER_ERROR), new MessageExecutor() { // from class: com.tencent.qqlive.tvkplayer.security.TVKPlaybackAliveKeeper.7
            @Override // com.tencent.qqlive.tvkplayer.security.TVKPlaybackAliveKeeper.MessageExecutor
            public void execute(ReportMessage reportMessage) {
                TVKPlaybackAliveKeeper.this.stopPollingReport();
                TVKPlaybackAliveKeeper.this.resetAllParams();
            }
        });
        this.mMessageHandler.put(Integer.valueOf(TVKEventId.PLAYER_STATE_PLAY_COMPLETE), new MessageExecutor() { // from class: com.tencent.qqlive.tvkplayer.security.TVKPlaybackAliveKeeper.8
            @Override // com.tencent.qqlive.tvkplayer.security.TVKPlaybackAliveKeeper.MessageExecutor
            public void execute(ReportMessage reportMessage) {
                TVKPlaybackAliveKeeper.this.stopPollingReportTimer();
            }
        });
    }

    private boolean isPollingReportTimeoutWithPollingReportId(int i3) {
        if (System.currentTimeMillis() - this.mRequestTimestampSince1970Ms <= 5000 && i3 == this.mPollingId) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initMsgFunction$0(ReportMessage reportMessage) {
        handleGetvinfoResponseWithParam(reportMessage.eventObject);
    }

    private boolean needCancelPrePolling() {
        PollingReportState pollingReportState = this.mPollingReportState;
        if (pollingReportState != PollingReportState.POLLING_REPORT_STATE_IDLE && pollingReportState != PollingReportState.POLLING_REPORT_STATE_COMPLETED && !TextUtils.isEmpty(this.mRespScript)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPollingReport() {
        TVKThreadPool.getInstance().obtainSingleThreadExecutor().execute(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.security.TVKPlaybackAliveKeeper.10
            @Override // java.lang.Runnable
            public void run() {
                TVKPlaybackAliveKeeper.this.executeReportRequestWithCmd(2);
            }
        });
    }

    private void postPollingReportWithData(@NonNull String str) {
        TVKCKeyEncryptedResult generateCkeyAndEncryptWithData = generateCkeyAndEncryptWithData(str);
        if (generateCkeyAndEncryptWithData.getCKey() != null && generateCkeyAndEncryptWithData.getCipher() != null) {
            if (TextUtils.isEmpty(this.mPollingReportUrl)) {
                TVKLogUtil.e(TAG, "postPollingReportWithData, mPollingReportUrl is empty.");
                return;
            }
            String buildUrl = new TVKUrlBuilder().setUrl(this.mPollingReportUrl).addParam(buildPollRequestQueryParams(new String(generateCkeyAndEncryptWithData.getCKey(), StandardCharsets.UTF_8))).buildUrl();
            TVKLogUtil.i(TAG, "poll request url:" + buildUrl);
            TVKLogUtil.i(TAG, "poll request body:" + new String(generateCkeyAndEncryptWithData.getCipher()));
            TVKHttpProcessorFactory.getHttpRequester().executeAsync(new ITVKHttpProcessor.TVKHttpRequest.Builder(ITVKHttpProcessor.TVKHttpRequest.HttpMethod.POST, buildUrl).reqTag(HTTP_REQUEST_TAG).body(generateCkeyAndEncryptWithData.getCipher()).callTimeoutMs(5000L).build(), this.mHttpCallback);
            return;
        }
        TVKLogUtil.e(TAG, "postPollingReportWithData, fail to generateSignature.");
    }

    private void reStartPollingReportTimerIfNeeded(long j3) {
        if (this.mPollingIntervalSec != j3 && this.mPollingReportState != PollingReportState.POLLING_REPORT_STATE_COMPLETED) {
            startPollingReportTimer(j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetAllParams() {
        this.mPollingIntervalSec = TVKMediaPlayerConfig.PlayerConfig.default_polling_report_interval_sec;
        stopPollingReportTimer();
        this.mPollingId = 0;
        this.mCurrentPositionSec = 0L;
        this.mRequestTimestampSince1970Ms = 0L;
        this.mVid = "";
        this.mRespTopicId = "";
        this.mRespScript = "";
        this.mPollingReportUrl = "";
        this.mPollingReportState = PollingReportState.POLLING_REPORT_STATE_IDLE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPollingReportTimer(long j3) {
        stopPollingReportTimer();
        TVKLogUtil.i(TAG, "startPollReportTimer, poll interval:" + j3);
        this.mTimerTask = TVKThreadPool.getInstance().obtainScheduledExecutorService().scheduleAtFixedRate(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.security.b
            @Override // java.lang.Runnable
            public final void run() {
                TVKPlaybackAliveKeeper.this.onPollingReport();
            }
        }, j3, j3, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPollingReport() {
        stopPollingReportTimer();
        executeReportRequestWithCmd(3);
        this.mPollingReportState = PollingReportState.POLLING_REPORT_STATE_COMPLETED;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPollingReportTimer() {
        if (this.mTimerTask != null) {
            TVKLogUtil.i(TAG, "stopPollReportTimer");
            this.mTimerTask.cancel(true);
            this.mTimerTask = null;
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.event.ITVKEventObserver
    public void onEvent(int i3, int i16, int i17, String str, Object obj) {
        if (i3 == 11000) {
            return;
        }
        executeReportMsg(i3, i16, i17, str, obj);
    }

    @Override // com.tencent.qqlive.tvkplayer.plugin.ITVKPlugin
    public void onLoad() {
        this.mTVKContext.getEventSender().registerObserver(this);
    }

    @Override // com.tencent.qqlive.tvkplayer.plugin.ITVKPlugin
    public void onUnload() {
        this.mTVKContext.getEventSender().unregisterObserver(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleFailure(IOException iOException) {
    }
}
