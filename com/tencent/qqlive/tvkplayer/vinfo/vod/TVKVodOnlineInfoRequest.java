package com.tencent.qqlive.tvkplayer.vinfo.vod;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.ITVKReportEventListener;
import com.tencent.qqlive.tvkplayer.api.TVKError;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKVideoInfoFromType;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKVodVideoInfo;
import com.tencent.qqlive.tvkplayer.context.TVKContext;
import com.tencent.qqlive.tvkplayer.context.TVKDebugTrackingEventReporter;
import com.tencent.qqlive.tvkplayer.context.TVKReportEventParamsInner;
import com.tencent.qqlive.tvkplayer.event.TVKEventId;
import com.tencent.qqlive.tvkplayer.event.TVKEventParams;
import com.tencent.qqlive.tvkplayer.tools.baseinfo.TVKVersion;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.http.TVKHttpProcessorFactory;
import com.tencent.qqlive.tvkplayer.tools.http.api.ITVKHttpProcessor;
import com.tencent.qqlive.tvkplayer.tools.http.api.TVKInProgressHTTPRequestRecorder;
import com.tencent.qqlive.tvkplayer.tools.log.ITVKLogger;
import com.tencent.qqlive.tvkplayer.tools.log.TVKLogger;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonErrorCodeUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKHttpUtils;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLongTextPrinter;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKNetworkUtils;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKThreadPool;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUrlBuilder;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import com.tencent.qqlive.tvkplayer.vinfo.apiinner.ITVKCGIRequestBase;
import com.tencent.qqlive.tvkplayer.vinfo.apiinner.ITVKVodInfoListener;
import com.tencent.qqlive.tvkplayer.vinfo.checktime.TVKServerTimeGetter;
import com.tencent.qqlive.tvkplayer.vinfo.common.TVKCGIErrorCodeUtils;
import com.tencent.qqlive.tvkplayer.vinfo.common.TVKCGIExecutor;
import com.tencent.qqlive.tvkplayer.vinfo.vod.TVKVodOnlineInfoRequest;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKVodOnlineInfoRequest implements ITVKCGIRequestBase {
    private static final String MODULE_NAME = "TVKVodOnlineInfoRequest";
    private final TVKCGIExecutor mCGIExecutor;

    @NonNull
    private final ITVKVodInfoListener mListener;
    private final ITVKLogger mLogger;
    private final TVKVodProxyCache mProxyCache;
    private final int mRequestId;
    private final TVKContext mTVKContext;

    @NonNull
    private final TVKVodInfoParser mVodInfoParser;

    @NonNull
    private final TVKVodRequestBuilder mVodRequestBuilder;
    private final TVKVodInfoRequestRetryer mRequestRetryer = new TVKVodInfoRequestRetryer();
    private final ITVKCGIRequestBase.TVKCGIElapsedTime mVinfoElapsedTime = new ITVKCGIRequestBase.TVKCGIElapsedTime();
    private boolean mIsFirstHttpResponseReceived = false;
    private String mCacheKey = "";
    private String mRequestHost = "";
    private final ITVKHttpProcessor.ITVKHttpCallback mHttpCallback = new AnonymousClass1();
    private volatile ITVKCGIRequestBase.RequestState mRequestState = ITVKCGIRequestBase.RequestState.STATE_IDLE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.qqlive.tvkplayer.vinfo.vod.TVKVodOnlineInfoRequest$1, reason: invalid class name */
    /* loaded from: classes23.dex */
    public class AnonymousClass1 implements ITVKHttpProcessor.ITVKHttpCallback {
        AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onFailure$0(IOException iOException) {
            TVKVodOnlineInfoRequest.this.handleFailure(iOException);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onSuccess$1(ITVKHttpProcessor.TVKHttpResponse tVKHttpResponse) {
            TVKVodOnlineInfoRequest.this.handleSuccess(tVKHttpResponse);
        }

        @Override // com.tencent.qqlive.tvkplayer.tools.http.api.ITVKHttpProcessor.ITVKHttpCallback
        public void onFailure(@NonNull final IOException iOException) {
            if (TVKVodOnlineInfoRequest.this.isCanceled()) {
                TVKVodOnlineInfoRequest.this.mLogger.warn("VOD CGI: [vinfo][onFailure] canceled and return", new Object[0]);
            } else {
                TVKVodOnlineInfoRequest.this.mCGIExecutor.execute(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.vinfo.vod.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        TVKVodOnlineInfoRequest.AnonymousClass1.this.lambda$onFailure$0(iOException);
                    }
                });
            }
        }

        @Override // com.tencent.qqlive.tvkplayer.tools.http.api.ITVKHttpProcessor.ITVKHttpCallback
        public void onSuccess(@NonNull final ITVKHttpProcessor.TVKHttpResponse tVKHttpResponse) {
            if (TVKVodOnlineInfoRequest.this.isCanceled()) {
                TVKVodOnlineInfoRequest.this.mLogger.warn("VOD CGI: [vinfo][onSuccess] canceled and return", new Object[0]);
            } else {
                TVKVodOnlineInfoRequest.this.mCGIExecutor.execute(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.vinfo.vod.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        TVKVodOnlineInfoRequest.AnonymousClass1.this.lambda$onSuccess$1(tVKHttpResponse);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class TVKVodInfoRequestRetryer {
        private static final int MAX_CGI_RETRY_DELAY_PERIOD_MS = 600;
        private final int[] mCGIRetryDelayPeriodMs;
        private final int mMaxRetryCount;
        private int mRetryCount;

        public TVKVodInfoRequestRetryer() {
            int i3 = TVKMediaPlayerConfig.PlayerConfig.cgi_max_retry_times;
            this.mMaxRetryCount = i3;
            this.mRetryCount = 0;
            this.mCGIRetryDelayPeriodMs = new int[i3];
            initCGIRetryDelayPeriodMs();
        }

        private int getCgiRetryDelayPeriodMs() {
            int[] iArr = this.mCGIRetryDelayPeriodMs;
            int i3 = iArr[this.mRetryCount % iArr.length];
            TVKVodOnlineInfoRequest.this.mLogger.info("VOD CGI: [vinfo][onFailure] retryCount: " + this.mRetryCount + " delay period(ms):" + i3, new Object[0]);
            return i3;
        }

        private void initCGIRetryDelayPeriodMs() {
            int length = this.mCGIRetryDelayPeriodMs.length;
            if (length < 1) {
                return;
            }
            int i3 = 600 / length;
            int i16 = 0;
            while (i16 < length) {
                int i17 = i16 + 1;
                this.mCGIRetryDelayPeriodMs[i16] = i17 * i3;
                i16 = i17;
            }
        }

        private boolean isCkeyVerificationError(@NonNull TVKVodRetryAndErrorInfo tVKVodRetryAndErrorInfo) {
            if (tVKVodRetryAndErrorInfo.getErrCode() == 85 && tVKVodRetryAndErrorInfo.getErrDetailCode() == -3) {
                return true;
            }
            return false;
        }

        public int getCurrentRetryCount() {
            return this.mRetryCount;
        }

        public boolean retryImmediately() {
            int i3 = this.mRetryCount;
            if (i3 >= this.mMaxRetryCount) {
                TVKVodOnlineInfoRequest.this.mLogger.info("VOD CGI: [retryOnNetworkException] Exceeded maximum retry attempts, no further retries will be performed", new Object[0]);
                return false;
            }
            this.mRetryCount = i3 + 1;
            TVKVodOnlineInfoRequest.this.mLogger.warn("VOD CGI: [retryImmediately], retry count=" + this.mRetryCount, new Object[0]);
            TVKVodOnlineInfoRequest.this.executeRequest();
            return true;
        }

        public boolean retryOnVinfoInvalid(TVKGetVinfoData tVKGetVinfoData) {
            if (this.mRetryCount >= this.mMaxRetryCount) {
                TVKVodOnlineInfoRequest.this.mLogger.info("VOD CGI: [retryOnVinfoInvalid] Exceeded maximum retry attempts, no further retries will be performed", new Object[0]);
                return false;
            }
            if (tVKGetVinfoData.getParseResult() != 0) {
                TVKVodOnlineInfoRequest.this.mLogger.info("VOD CGI: [retryOnVinfoInvalid] do not need to retry: parsing failed", new Object[0]);
                return false;
            }
            TVKVodRetryAndErrorInfo errorInfo = tVKGetVinfoData.getErrorInfo();
            if (errorInfo == null) {
                TVKVodOnlineInfoRequest.this.mLogger.info("VOD CGI: [retryOnVinfoInvalid] do not need to retry: no error", new Object[0]);
                return false;
            }
            if (errorInfo.getNeedRetry() != 1) {
                TVKVodOnlineInfoRequest.this.mLogger.info("VOD CGI: [retryOnVinfoInvalid] do not need to retry: server does not advise", new Object[0]);
                return false;
            }
            if (isCkeyVerificationError(errorInfo)) {
                TVKVodOnlineInfoRequest.this.mLogger.info("VOD CGI: [retryOnVinfoInvalid] ckey error, update clock", new Object[0]);
                TVKServerTimeGetter.sServerTimeSec = tVKGetVinfoData.getErrorInfo().getCurTime();
                TVKServerTimeGetter.sRandKey = tVKGetVinfoData.getErrorInfo().getRand();
                TVKServerTimeGetter.sElapsedRealTimeMs = SystemClock.elapsedRealtime();
            }
            this.mRetryCount++;
            TVKVodOnlineInfoRequest.this.mLogger.warn("VOD CGI: [retryOnVinfoInvalid] attempt to retry request, retry count=" + this.mRetryCount, new Object[0]);
            TVKVodOnlineInfoRequest.this.executeRequest();
            return true;
        }

        public boolean retryWithIncrementalDelay() {
            int i3 = this.mRetryCount;
            if (i3 >= this.mMaxRetryCount) {
                TVKVodOnlineInfoRequest.this.mLogger.info("VOD CGI: [retryOnNetworkException] Exceeded maximum retry attempts, no further retries will be performed", new Object[0]);
                return false;
            }
            this.mRetryCount = i3 + 1;
            TVKVodOnlineInfoRequest.this.mLogger.warn("VOD CGI: [retryWithIncrementalDelay], retry count=" + this.mRetryCount, new Object[0]);
            ScheduledExecutorService obtainScheduledExecutorService = TVKThreadPool.getInstance().obtainScheduledExecutorService();
            final TVKVodOnlineInfoRequest tVKVodOnlineInfoRequest = TVKVodOnlineInfoRequest.this;
            obtainScheduledExecutorService.schedule(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.vinfo.vod.j
                @Override // java.lang.Runnable
                public final void run() {
                    TVKVodOnlineInfoRequest.access$500(TVKVodOnlineInfoRequest.this);
                }
            }, (long) getCgiRetryDelayPeriodMs(), TimeUnit.MILLISECONDS);
            return true;
        }
    }

    public TVKVodOnlineInfoRequest(int i3, @NonNull TVKContext tVKContext, @NonNull TVKVodRequestBuilder tVKVodRequestBuilder, @NonNull TVKVodInfoParser tVKVodInfoParser, @NonNull TVKVodProxyCache tVKVodProxyCache, @NonNull ITVKVodInfoListener iTVKVodInfoListener) {
        this.mRequestId = i3;
        this.mTVKContext = tVKContext;
        this.mLogger = new TVKLogger(tVKContext, MODULE_NAME);
        this.mVodRequestBuilder = tVKVodRequestBuilder;
        this.mVodInfoParser = tVKVodInfoParser;
        this.mProxyCache = tVKVodProxyCache;
        this.mListener = iTVKVodInfoListener;
        this.mCGIExecutor = new TVKCGIExecutor(tVKVodRequestBuilder.getRequestSource());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void access$500(TVKVodOnlineInfoRequest tVKVodOnlineInfoRequest) {
        tVKVodOnlineInfoRequest.executeRequest();
    }

    private boolean applyCachedVodVideoInfo() {
        sendEvent(TVKEventId.PLAYER_STATE_CGI_LOOK_UP_LOCAL_CACHE_START, 0, 0, "", null);
        this.mLogger.info("attempting to get CGI content with key: " + this.mCacheKey, new Object[0]);
        TVKVodVideoInfo tVKVodVideoInfo = TVKVodInfoCache.getInstance().get(this.mCacheKey);
        if (tVKVodVideoInfo != null) {
            this.mLogger.info("found cached vod video info", new Object[0]);
            dumpGetVInfoResp(tVKVodVideoInfo.getXml());
            dealOnSuccess(tVKVodVideoInfo);
            return true;
        }
        if (this.mVodRequestBuilder.isFirstBootFromOtherApp() && this.mRequestRetryer.getCurrentRetryCount() == 0 && TVKInProgressHTTPRequestRecorder.isHttpRequestInProgress(this.mCacheKey)) {
            try {
                this.mLogger.info("VOD CGI: waiting for existing request response", new Object[0]);
                if (TVKInProgressHTTPRequestRecorder.waitOtherHttpRequestDone(this.mCacheKey, this.mLogger)) {
                    TVKVodVideoInfo tVKVodVideoInfo2 = TVKVodInfoCache.getInstance().get(this.mCacheKey);
                    this.mLogger.info("VOD CGI: existing request response received, video info=" + tVKVodVideoInfo2, new Object[0]);
                    if (tVKVodVideoInfo2 != null) {
                        dumpGetVInfoResp(tVKVodVideoInfo2.getXml());
                        dealOnSuccess(tVKVodVideoInfo2);
                        return true;
                    }
                }
            } catch (InterruptedException e16) {
                this.mLogger.error("VOD CGI: InterruptedException encountered: " + e16, new Object[0]);
                return false;
            }
        }
        this.mLogger.info("no cached vod video info found. Online request required", new Object[0]);
        return false;
    }

    private void dealOnFail(int i3) {
        if (isCanceled()) {
            this.mLogger.warn("VOD CGI: [vinfo][dealOnFail] canceled and return", new Object[0]);
            return;
        }
        TVKError tVKError = new TVKError(TVKCommonErrorCodeUtil.MODULE.CGI_GETVINFO_ERR, i3 + TVKCommonErrorCodeUtil.CODE.VOD.CGI_GETVINFO_NETWORK_BASE_ERR);
        TVKInProgressHTTPRequestRecorder.notifyAllHttpRequestDone(this.mCacheKey, false, this.mLogger);
        this.mListener.onFailure(this.mRequestId, tVKError);
    }

    private void dealOnSuccess(final TVKVodVideoInfo tVKVodVideoInfo) {
        boolean z16 = false;
        if (isCanceled()) {
            this.mLogger.warn("VOD CGI: [vinfo][dealOnSuccess] canceled and return", new Object[0]);
            return;
        }
        TVKThreadPool.getInstance().obtainNormalPriorityExecutor().execute(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.vinfo.vod.e
            @Override // java.lang.Runnable
            public final void run() {
                TVKVodOnlineInfoRequest.this.lambda$dealOnSuccess$1(tVKVodVideoInfo);
            }
        });
        TVKVodVideoInfo lookupOfflineVinfoForQuickPlay = lookupOfflineVinfoForQuickPlay(tVKVodVideoInfo);
        TVKVodInfoPlayUrlBuilder.buildCdnUrl(lookupOfflineVinfoForQuickPlay, TVKVersion.getSdtfrom());
        TVKEventParams.CgiHandleResponseSuccess cgiHandleResponseSuccess = new TVKEventParams.CgiHandleResponseSuccess();
        cgiHandleResponseSuccess.retryCount = this.mRequestRetryer.getCurrentRetryCount();
        if (lookupOfflineVinfoForQuickPlay.getFromType() == TVKVideoInfoFromType.FROM_TYPE_CACHE) {
            z16 = true;
        }
        cgiHandleResponseSuccess.useLocalCache = z16;
        cgiHandleResponseSuccess.requestHost = this.mRequestHost;
        sendEvent(TVKEventId.PLAYER_STATE_CGI_HANDLE_RESPONSE_SUCCESS, 0, 0, "", cgiHandleResponseSuccess);
        this.mListener.onSuccess(this.mRequestId, lookupOfflineVinfoForQuickPlay);
    }

    private void dumpGetVInfoResp(String str) {
        this.mVinfoElapsedTime.mTotalRequestCostTimeMs = SystemClock.elapsedRealtime() - this.mVinfoElapsedTime.mStartRequestMs;
        this.mLogger.info("VOD CGI: [vinfo][onSuccess] success time cost:" + this.mVinfoElapsedTime.mTotalRequestCostTimeMs + " xml:", new Object[0]);
        final ITVKLogger iTVKLogger = this.mLogger;
        Objects.requireNonNull(iTVKLogger);
        TVKLongTextPrinter.print(str, new TVKLongTextPrinter.Printer() { // from class: com.tencent.qqlive.tvkplayer.vinfo.vod.f
            @Override // com.tencent.qqlive.tvkplayer.tools.utils.TVKLongTextPrinter.Printer
            public final void print(String str2) {
                TVKVodOnlineInfoRequest.lambda$dumpGetVInfoResp$2(ITVKLogger.this, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeRequest() {
        boolean z16;
        String str;
        if (isCanceled()) {
            return;
        }
        sendEvent(TVKEventId.PLAYER_STATE_CGI_BUILD_REQUEST_PARAMS_START, 0, 0, "", null);
        this.mVinfoElapsedTime.mStartHttpRequestMs = SystemClock.elapsedRealtime();
        String buildVinfoRequestHost = this.mVodRequestBuilder.buildVinfoRequestHost();
        this.mRequestHost = TVKNetworkUtils.getHostnameFromUrl(buildVinfoRequestHost);
        TVKVodRequestBuilder tVKVodRequestBuilder = this.mVodRequestBuilder;
        if (this.mRequestRetryer.getCurrentRetryCount() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        Map<String, String> buildVinfoRequestParams = tVKVodRequestBuilder.buildVinfoRequestParams(z16);
        String buildUrl = new TVKUrlBuilder().setUrl(buildVinfoRequestHost).addParam(buildVinfoRequestParams).buildUrl();
        Map<String, String> buildVinfoRequestHeader = this.mVodRequestBuilder.buildVinfoRequestHeader();
        this.mLogger.info("VOD CGI: [vinfo] request url = " + buildUrl, new Object[0]);
        this.mLogger.info("VOD CGI: [vinfo] request headers = " + buildVinfoRequestHeader, new Object[0]);
        if (shouldEnableCache(buildVinfoRequestParams)) {
            str = TVKVodInfoCache.getInstance().generateCacheKey(buildVinfoRequestParams, buildVinfoRequestHeader);
        } else {
            str = "";
        }
        this.mCacheKey = str;
        this.mLogger.info("VOD CGI: cache key generated: " + this.mCacheKey, new Object[0]);
        if (applyCachedVodVideoInfo()) {
            return;
        }
        this.mLogger.info("VOD CGI: execute http request", new Object[0]);
        TVKInProgressHTTPRequestRecorder.recordHTTPRequestInProgress(this.mCacheKey, this.mLogger);
        TVKHttpProcessorFactory.getHttpRequester().executeAsync(new ITVKHttpProcessor.TVKHttpRequest.Builder(ITVKHttpProcessor.TVKHttpRequest.HttpMethod.POST, buildVinfoRequestHost).reqTag(getHttpRequestTag()).body(TVKHttpUtils.encodeParamsToByteForUrlEncoding(buildVinfoRequestParams, "UTF-8")).headers(buildVinfoRequestHeader).addBackupHosts(this.mVodRequestBuilder.buildVinfoRequestBakHosts()).callTimeoutMs(TVKMediaPlayerConfig.PlayerConfig.cgi_request_timeout_ms).httpDns(true).retryCellularOnWifiFailure(shouldRetryWithCellularNetwork()).build(), this.mHttpCallback);
        sendEvent(TVKEventId.PLAYER_STATE_CGI_HTTP_REQUEST, 0, 0, "", null);
    }

    private String getHttpRequestTag() {
        return this.mLogger.getTag() + "_" + this.mRequestId;
    }

    private String getResponseContent(ITVKHttpProcessor.TVKHttpResponse tVKHttpResponse) {
        String str;
        try {
            if (TVKNetworkUtils.isCompressedByGzip(tVKHttpResponse.getHeaders())) {
                byte[] gzipDeCompress = TVKUtils.gzipDeCompress(tVKHttpResponse.getData());
                if (gzipDeCompress == null) {
                    return "";
                }
                str = new String(gzipDeCompress, StandardCharsets.UTF_8);
            } else {
                str = new String(tVKHttpResponse.getData(), StandardCharsets.UTF_8);
            }
            return str;
        } catch (Exception e16) {
            this.mLogger.error("VOD CGI: [vinfo][onSuccess] getResponseContent has exception:" + e16, new Object[0]);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleFailure(IOException iOException) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.mVinfoElapsedTime.mStartHttpRequestMs;
        this.mLogger.error("VOD CGI: [vinfo][onFailure] cost time:" + elapsedRealtime + ", ioException = " + iOException + ", errorCode:" + TVKCGIErrorCodeUtils.getErrCodeByThrowable(iOException), new Object[0]);
        if (isCanceled()) {
            this.mLogger.warn("VOD CGI: [vinfo][onFailure] canceled and return", new Object[0]);
        } else {
            if (this.mRequestRetryer.retryWithIncrementalDelay()) {
                return;
            }
            dealOnFail(TVKCGIErrorCodeUtils.getErrCodeByThrowable(iOException));
        }
    }

    private void handleResponse(Map<String, List<String>> map, String str) {
        this.mVinfoElapsedTime.mStartParseTimeMs = SystemClock.elapsedRealtime();
        this.mLogger.info("VOD CGI: before parse xml", new Object[0]);
        TVKGetVinfoData parseVinfo = this.mVodInfoParser.parseVinfo(str);
        this.mVinfoElapsedTime.mParseCostTimeMs = SystemClock.elapsedRealtime() - this.mVinfoElapsedTime.mStartParseTimeMs;
        this.mLogger.info("VOD CGI: after parse xml, parse costMs:" + this.mVinfoElapsedTime.mParseCostTimeMs, new Object[0]);
        if (parseVinfo.getParseResult() != 0) {
            this.mLogger.error("VOD CGI: [vinfo][onSuccess] xml parse error!", new Object[0]);
            dealOnFail(parseVinfo.getParseResult());
            return;
        }
        reportEvent(ITVKReportEventListener.ReportEvent.TVK_REPORT_EVENT_CGI_PARSE_DATA_DONE, new TVKReportEventParamsInner.Builder().build());
        if (this.mRequestRetryer.retryOnVinfoInvalid(parseVinfo)) {
            return;
        }
        reportEvent(ITVKReportEventListener.ReportEvent.TVK_REPORT_EVENT_CGI_PARSE_DATA_RESPONSE, new TVKReportEventParamsInner.Builder().build());
        if (isVinfoSuccess(parseVinfo)) {
            parseVinfoHeaders(map, parseVinfo.getVodInfo());
            dealOnSuccess(parseVinfo.getVodInfo());
        } else {
            dealOnFail(parseVinfo.getErrorInfo());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSuccess(ITVKHttpProcessor.TVKHttpResponse tVKHttpResponse) {
        sendEvent(TVKEventId.PLAYER_STATE_CGI_RESPONSE_HEADERS, 0, 0, "", tVKHttpResponse.getHeaders());
        if (!this.mIsFirstHttpResponseReceived) {
            reportEvent(ITVKReportEventListener.ReportEvent.TVK_REPORT_EVENT_CGI_HTTP_RESPONSE_RECEIVED, new TVKReportEventParamsInner.Builder().build());
            this.mIsFirstHttpResponseReceived = true;
        }
        this.mVinfoElapsedTime.mHttpRequestCostTimeMs = SystemClock.elapsedRealtime() - this.mVinfoElapsedTime.mStartHttpRequestMs;
        this.mLogger.info("VOD CGI: [vinfo] [handleSuccess] http cost time:" + this.mVinfoElapsedTime.mHttpRequestCostTimeMs, new Object[0]);
        if (isCanceled()) {
            this.mLogger.warn("VOD CGI: [vinfo][handleSuccess] canceled and return", new Object[0]);
            return;
        }
        sendEvent(TVKEventId.PLAYER_STATE_CGI_HTTP_RESPONSE, 0, 0, "", null);
        String responseContent = getResponseContent(tVKHttpResponse);
        if (TextUtils.isEmpty(responseContent)) {
            this.mLogger.warn("VOD CGI: [vinfo][handleSuccess] vinfoContent is empty", new Object[0]);
            if (this.mRequestRetryer.retryImmediately()) {
                return;
            }
            dealOnFail(23);
            return;
        }
        dumpGetVInfoResp(responseContent);
        handleResponse(tVKHttpResponse.getHeaders(), responseContent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isCanceled() {
        if (this.mRequestState == ITVKCGIRequestBase.RequestState.STATE_CANCELED) {
            return true;
        }
        return false;
    }

    private boolean isVinfoSuccess(TVKGetVinfoData tVKGetVinfoData) {
        boolean z16;
        boolean z17;
        if (tVKGetVinfoData.getParseResult() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && tVKGetVinfoData.getErrorInfo() != null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17 && tVKGetVinfoData.getErrorInfo().getErrCode() == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$dealOnSuccess$1(TVKVodVideoInfo tVKVodVideoInfo) {
        boolean put = TVKVodInfoCache.getInstance().put(this.mCacheKey, tVKVodVideoInfo);
        this.mLogger.info("VOD CGI: [vinfo][dealOnSuccess] successfully cache CGI content with key " + this.mCacheKey + "? " + put, new Object[0]);
        TVKInProgressHTTPRequestRecorder.notifyAllHttpRequestDone(this.mCacheKey, put, this.mLogger);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$dumpGetVInfoResp$2(ITVKLogger iTVKLogger, String str) {
        iTVKLogger.info(str, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$lookupOfflineVinfoForQuickPlay$0(ITVKLogger iTVKLogger, String str) {
        iTVKLogger.info(str, new Object[0]);
    }

    private TVKVodVideoInfo lookupOfflineVinfoForQuickPlay(TVKVodVideoInfo tVKVodVideoInfo) {
        sendEvent(TVKEventId.PLAYER_STATE_CGI_LOOK_UP_OFFLINE_RESOURCE_FOR_QUICK_PLAY_START, 0, 0, "", null);
        String offlineVInfoForQuickPlay = this.mProxyCache.getOfflineVInfoForQuickPlay(tVKVodVideoInfo);
        if (!TextUtils.isEmpty(offlineVInfoForQuickPlay)) {
            this.mLogger.info("VOD CGI: got vinfo offline substitute: ", new Object[0]);
            final ITVKLogger iTVKLogger = this.mLogger;
            Objects.requireNonNull(iTVKLogger);
            TVKLongTextPrinter.print(offlineVInfoForQuickPlay, new TVKLongTextPrinter.Printer() { // from class: com.tencent.qqlive.tvkplayer.vinfo.vod.g
                @Override // com.tencent.qqlive.tvkplayer.tools.utils.TVKLongTextPrinter.Printer
                public final void print(String str) {
                    TVKVodOnlineInfoRequest.lambda$lookupOfflineVinfoForQuickPlay$0(ITVKLogger.this, str);
                }
            });
            TVKGetVinfoData parseVinfo = this.mVodInfoParser.parseVinfo(offlineVInfoForQuickPlay);
            if (parseVinfo.getErrorInfo().getErrCode() == 0) {
                this.mLogger.info("VOD CGI: offline play , use offline videoinfo", new Object[0]);
                TVKVodVideoInfo vodInfo = parseVinfo.getVodInfo();
                vodInfo.setFromType(TVKVideoInfoFromType.FROM_TYPE_DL_PROXY);
                return vodInfo;
            }
            return tVKVodVideoInfo;
        }
        return tVKVodVideoInfo;
    }

    private void parseVinfoHeaders(Map<String, List<String>> map, TVKVodVideoInfo tVKVodVideoInfo) {
        List<String> list = map.get(ITVKHttpProcessor.HTTP_REQUEST_NETWORK_INTERFACE_SPECIFIER);
        if (list != null && list.contains("1")) {
            tVKVodVideoInfo.setFromType(TVKVideoInfoFromType.FROM_TYPE_SERVER_BY_MULTI_NIC);
        }
        List<String> list2 = map.get("host");
        if (list2 != null) {
            this.mRequestHost = no0.a.a("", list2);
        }
    }

    private void reportEvent(ITVKReportEventListener.ReportEvent reportEvent, TVKReportEventParamsInner tVKReportEventParamsInner) {
        TVKDebugTrackingEventReporter debugTrackingEventReporter = this.mTVKContext.getDebugTrackingEventReporter();
        if (debugTrackingEventReporter == null) {
            this.mLogger.warn("onReportPushEvent, debugTrackingEventReporter == null", new Object[0]);
            return;
        }
        this.mLogger.info("event happens: " + reportEvent.name() + " in UTC timeMs=" + tVKReportEventParamsInner.getTimeSince1970Ms(), new Object[0]);
        debugTrackingEventReporter.sendEvent(reportEvent, tVKReportEventParamsInner);
    }

    private void sendEvent(int i3, int i16, int i17, String str, Object obj) {
        if (isCanceled()) {
            return;
        }
        this.mTVKContext.getEventSender().sendEvent(i3, i16, i17, str, obj);
    }

    private boolean shouldEnableCache(Map<String, String> map) {
        if (!TVKMediaPlayerConfig.PlayerConfig.enable_vod_cgi_cache) {
            this.mLogger.info("disabled by config, do not cache", new Object[0]);
            return false;
        }
        if (this.mVodRequestBuilder.getRequestType() != 0) {
            this.mLogger.info("request type=" + this.mVodRequestBuilder.getRequestType() + ", do not cache", new Object[0]);
            return false;
        }
        if (TextUtils.equals("auto", this.mVodRequestBuilder.getDefinition())) {
            this.mLogger.info("request definition is auto, do not cache", new Object[0]);
            return false;
        }
        if (this.mVodRequestBuilder.isFirstBootFromOtherApp()) {
            this.mLogger.info("it's an external boot up bro, cache it anyway", new Object[0]);
            return true;
        }
        if (map != null && !map.isEmpty()) {
            if (TextUtils.isEmpty(map.get("vid"))) {
                this.mLogger.warn("quick play\uff0cdo not cache", new Object[0]);
                return false;
            }
            if (!TextUtils.isEmpty(map.get("track"))) {
                this.mLogger.warn("multi audio track\uff0cdo not cache", new Object[0]);
                return false;
            }
            this.mLogger.info("we should cache the video info", new Object[0]);
            return true;
        }
        this.mLogger.warn("empty request map, do not cache", new Object[0]);
        return false;
    }

    private boolean shouldRetryWithCellularNetwork() {
        if (this.mVodRequestBuilder.getRequestSource() == 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.apiinner.ITVKCGIRequestBase
    public void cancel() {
        this.mRequestState = ITVKCGIRequestBase.RequestState.STATE_CANCELED;
        TVKInProgressHTTPRequestRecorder.notifyAllHttpRequestDone(this.mCacheKey, false, this.mLogger);
        TVKHttpProcessorFactory.getHttpRequester().cancelRequest(getHttpRequestTag());
        this.mLogger.info("VOD CGI: [vinfo] canceled", new Object[0]);
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.apiinner.ITVKCGIRequestBase
    public void execute() {
        if (this.mRequestState != ITVKCGIRequestBase.RequestState.STATE_IDLE) {
            this.mLogger.error("VOD CGI: [vinfo] request state is not idle and return", new Object[0]);
            return;
        }
        this.mLogger.info("VOD CGI: start execute request", new Object[0]);
        this.mRequestState = ITVKCGIRequestBase.RequestState.STATE_RUNNING;
        this.mVinfoElapsedTime.mStartRequestMs = SystemClock.elapsedRealtime();
        reportEvent(ITVKReportEventListener.ReportEvent.TVK_REPORT_EVENT_CGI_SEND_HTTP_REQUEST, new TVKReportEventParamsInner.Builder().build());
        sendEvent(TVKEventId.PLAYER_STATE_CGI_START, 0, 0, "", null);
        this.mCGIExecutor.execute(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.vinfo.vod.d
            @Override // java.lang.Runnable
            public final void run() {
                TVKVodOnlineInfoRequest.this.executeRequest();
            }
        });
    }

    private void dealOnFail(TVKVodRetryAndErrorInfo tVKVodRetryAndErrorInfo) {
        if (isCanceled()) {
            this.mLogger.warn("VOD CGI: [vinfo][dealOnFail] canceled and return", new Object[0]);
            return;
        }
        TVKError tVKError = new TVKError(TVKCommonErrorCodeUtil.MODULE.CGI_GETVINFO_ERR, tVKVodRetryAndErrorInfo.getErrCode() + 1300000, tVKVodRetryAndErrorInfo.getErrDetailCode());
        tVKError.addExtraInfo(TVKError.ExtraInfoKey.ERROR_INSTRUCTION, tVKVodRetryAndErrorInfo.getMessage());
        tVKError.addExtraInfo(TVKError.ExtraInfoKey.IP_LIMITATION_INFO, tVKVodRetryAndErrorInfo.getIpInfo());
        TVKInProgressHTTPRequestRecorder.notifyAllHttpRequestDone(this.mCacheKey, false, this.mLogger);
        this.mListener.onFailure(this.mRequestId, tVKError);
    }
}
