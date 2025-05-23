package com.tencent.qqlive.tvkplayer.vinfo.live;

import android.net.ParseException;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.TVKError;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKLiveVideoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKVideoInfoFromType;
import com.tencent.qqlive.tvkplayer.context.TVKContext;
import com.tencent.qqlive.tvkplayer.event.TVKEventId;
import com.tencent.qqlive.tvkplayer.event.TVKEventParams;
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
import com.tencent.qqlive.tvkplayer.vinfo.apiinner.ITVKCGIRequestBase;
import com.tencent.qqlive.tvkplayer.vinfo.apiinner.ITVKLiveInfoListener;
import com.tencent.qqlive.tvkplayer.vinfo.checktime.TVKServerTimeGetter;
import com.tencent.qqlive.tvkplayer.vinfo.common.TVKCGIErrorCodeUtils;
import com.tencent.qqlive.tvkplayer.vinfo.common.TVKCGIExecutor;
import com.tencent.qqlive.tvkplayer.vinfo.common.TVKIllegalCGIResponseException;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveInfoRequest;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.json.JSONException;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKLiveInfoRequest implements ITVKCGIRequestBase {
    private static final String MODULE_NAME = "TVKLiveInfoRequest";
    private final TVKCGIExecutor mCGIExecutor;

    @NonNull
    private final ITVKLiveInfoListener mListener;

    @NonNull
    private final TVKLiveInfoParser mLiveInfoParser;

    @NonNull
    private final TVKLiveRequestBuilder mLiveRequestBuilder;
    private final ITVKLogger mLogger;
    private final int mRequestId;
    private final TVKContext mTVKContext;
    private int mRetryCount = 0;
    private String mCacheKey = "";
    private final ITVKHttpProcessor.ITVKHttpCallback mHttpCallback = new AnonymousClass1();
    private volatile ITVKCGIRequestBase.RequestState mRequestState = ITVKCGIRequestBase.RequestState.STATE_IDLE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveInfoRequest$1, reason: invalid class name */
    /* loaded from: classes23.dex */
    public class AnonymousClass1 implements ITVKHttpProcessor.ITVKHttpCallback {
        AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onFailure$0(IOException iOException) {
            TVKLiveInfoRequest.this.handleFailure(iOException);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onSuccess$1(ITVKHttpProcessor.TVKHttpResponse tVKHttpResponse) {
            TVKLiveInfoRequest.this.handleSuccess(tVKHttpResponse);
        }

        @Override // com.tencent.qqlive.tvkplayer.tools.http.api.ITVKHttpProcessor.ITVKHttpCallback
        public void onFailure(@NonNull final IOException iOException) {
            TVKLiveInfoRequest.this.mCGIExecutor.execute(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.vinfo.live.d
                @Override // java.lang.Runnable
                public final void run() {
                    TVKLiveInfoRequest.AnonymousClass1.this.lambda$onFailure$0(iOException);
                }
            });
        }

        @Override // com.tencent.qqlive.tvkplayer.tools.http.api.ITVKHttpProcessor.ITVKHttpCallback
        public void onSuccess(@NonNull final ITVKHttpProcessor.TVKHttpResponse tVKHttpResponse) {
            TVKLiveInfoRequest.this.mCGIExecutor.execute(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.vinfo.live.e
                @Override // java.lang.Runnable
                public final void run() {
                    TVKLiveInfoRequest.AnonymousClass1.this.lambda$onSuccess$1(tVKHttpResponse);
                }
            });
        }
    }

    public TVKLiveInfoRequest(int i3, @NonNull TVKContext tVKContext, @NonNull TVKLiveRequestBuilder tVKLiveRequestBuilder, @NonNull TVKLiveInfoParser tVKLiveInfoParser, @NonNull ITVKLiveInfoListener iTVKLiveInfoListener) {
        this.mRequestId = i3;
        this.mTVKContext = tVKContext;
        this.mLogger = new TVKLogger(tVKContext, MODULE_NAME);
        this.mLiveRequestBuilder = tVKLiveRequestBuilder;
        this.mListener = iTVKLiveInfoListener;
        this.mLiveInfoParser = tVKLiveInfoParser;
        this.mCGIExecutor = new TVKCGIExecutor(tVKLiveRequestBuilder.getRequestSource());
    }

    private boolean applyCachedLiveVideoInfo() {
        TVKLiveVideoInfo tVKLiveVideoInfo;
        sendEvent(TVKEventId.PLAYER_STATE_CGI_LOOK_UP_LOCAL_CACHE_START, 0, 0, "", null);
        this.mLogger.info("attempting to get CGI content with key: " + this.mCacheKey, new Object[0]);
        TVKLiveVideoInfo tVKLiveVideoInfo2 = TVKLiveInfoCache.getInstance().get(this.mCacheKey);
        if (tVKLiveVideoInfo2 != null) {
            this.mLogger.info("found cached live video info", new Object[0]);
            dumpLiveCgiResp(tVKLiveVideoInfo2.getXml());
            dealOnSuccess(tVKLiveVideoInfo2);
            return true;
        }
        if (this.mLiveRequestBuilder.isFirstBootFromOtherApp() && this.mRetryCount == 0 && TVKInProgressHTTPRequestRecorder.isHttpRequestInProgress(this.mCacheKey)) {
            this.mLogger.info("trying to wait for another request completion", new Object[0]);
            try {
                if (TVKInProgressHTTPRequestRecorder.waitOtherHttpRequestDone(this.mCacheKey, this.mLogger) && (tVKLiveVideoInfo = TVKLiveInfoCache.getInstance().get(this.mCacheKey)) != null) {
                    this.mLogger.info("found cached live video info", new Object[0]);
                    dumpLiveCgiResp(tVKLiveVideoInfo.getXml());
                    dealOnSuccess(tVKLiveVideoInfo);
                    return true;
                }
            } catch (InterruptedException e16) {
                this.mLogger.error("InterruptedException encountered: " + e16, new Object[0]);
                return false;
            }
        }
        this.mLogger.info("no cached live video info found. Online request required", new Object[0]);
        return false;
    }

    private void dealOnFail(int i3) {
        if (isCanceled()) {
            this.mLogger.warn("LIVE CGI: [dealOnFail] canceled and return", new Object[0]);
            return;
        }
        int i16 = i3 + TVKCommonErrorCodeUtil.CODE.LIVE.CGI_PROTOCOL_NETWORK_BASE_ERR;
        TVKLiveVideoInfo tVKLiveVideoInfo = new TVKLiveVideoInfo();
        tVKLiveVideoInfo.setRetCode(i16);
        TVKError tVKError = new TVKError(TVKCommonErrorCodeUtil.MODULE.CGI_GETPROGINFO_ERR, i16);
        tVKError.addExtraInfo(TVKError.ExtraInfoKey.NET_VIDEO_INFO, tVKLiveVideoInfo);
        TVKInProgressHTTPRequestRecorder.notifyAllHttpRequestDone(this.mCacheKey, false, this.mLogger);
        this.mListener.onFailure(this.mRequestId, tVKError);
    }

    private void dealOnFailWithInfo(TVKLiveVideoInfo tVKLiveVideoInfo) {
        if (!isCanceled()) {
            TVKError tVKError = new TVKError(TVKCommonErrorCodeUtil.MODULE.CGI_GETPROGINFO_ERR, tVKLiveVideoInfo.getRetCode() + 130000, tVKLiveVideoInfo.getIretDetailCode());
            tVKError.addExtraInfo(TVKError.ExtraInfoKey.ERROR_INSTRUCTION, tVKLiveVideoInfo.getErrInfo());
            tVKError.addExtraInfo(TVKError.ExtraInfoKey.NET_VIDEO_INFO, tVKLiveVideoInfo);
            TVKInProgressHTTPRequestRecorder.notifyAllHttpRequestDone(this.mCacheKey, false, this.mLogger);
            this.mListener.onFailure(this.mRequestId, tVKError);
        }
    }

    private void dealOnSuccess(final TVKLiveVideoInfo tVKLiveVideoInfo) {
        boolean z16 = false;
        if (isCanceled()) {
            this.mLogger.warn("LIVE CGI: [dealOnSuccess] canceled and return", new Object[0]);
            return;
        }
        if (TVKMediaPlayerConfig.PlayerConfig.enable_live_cgi_cache) {
            TVKThreadPool.getInstance().obtainNormalPriorityExecutor().execute(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.vinfo.live.a
                @Override // java.lang.Runnable
                public final void run() {
                    TVKLiveInfoRequest.this.lambda$dealOnSuccess$0(tVKLiveVideoInfo);
                }
            });
        } else {
            TVKInProgressHTTPRequestRecorder.notifyAllHttpRequestDone(this.mCacheKey, false, this.mLogger);
        }
        TVKEventParams.CgiHandleResponseSuccess cgiHandleResponseSuccess = new TVKEventParams.CgiHandleResponseSuccess();
        cgiHandleResponseSuccess.retryCount = this.mRetryCount;
        if (tVKLiveVideoInfo.getFromType() == TVKVideoInfoFromType.FROM_TYPE_CACHE) {
            z16 = true;
        }
        cgiHandleResponseSuccess.useLocalCache = z16;
        sendEvent(TVKEventId.PLAYER_STATE_CGI_HANDLE_RESPONSE_SUCCESS, 0, 0, "", cgiHandleResponseSuccess);
        this.mListener.onSuccess(this.mRequestId, tVKLiveVideoInfo);
    }

    private void dumpLiveCgiResp(String str) {
        this.mLogger.info("LIVE CGI: httpBodyText = ", new Object[0]);
        final ITVKLogger iTVKLogger = this.mLogger;
        Objects.requireNonNull(iTVKLogger);
        TVKLongTextPrinter.print(str, new TVKLongTextPrinter.Printer() { // from class: com.tencent.qqlive.tvkplayer.vinfo.live.c
            @Override // com.tencent.qqlive.tvkplayer.tools.utils.TVKLongTextPrinter.Printer
            public final void print(String str2) {
                TVKLiveInfoRequest.lambda$dumpLiveCgiResp$1(ITVKLogger.this, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeRequest() {
        if (isCanceled()) {
            this.mLogger.info("executeRequest, has been cancelled, return", new Object[0]);
            return;
        }
        sendEvent(TVKEventId.PLAYER_STATE_CGI_BUILD_REQUEST_PARAMS_START, 0, 0, "", null);
        Map<String, String> buildRequestParams = this.mLiveRequestBuilder.buildRequestParams();
        Map<String, String> buildRequestHeader = this.mLiveRequestBuilder.buildRequestHeader();
        String buildRequestHost = this.mLiveRequestBuilder.buildRequestHost();
        String buildUrl = new TVKUrlBuilder().setUrl(buildRequestHost).addParam(buildRequestParams).buildUrl();
        this.mLogger.info("LIVE CGI: request url = " + buildUrl, new Object[0]);
        this.mLogger.info("LIVE CGI: request headers = " + buildRequestHeader, new Object[0]);
        if (!this.mLiveRequestBuilder.isFirstBootFromOtherApp() && TVKNetworkUtils.isNetworkTypeMobile()) {
            this.mCacheKey = "";
        } else {
            this.mCacheKey = TVKLiveInfoCache.getInstance().generateCacheKey(buildRequestParams, buildRequestHeader);
        }
        this.mLogger.info("cache key for current request generated: " + this.mCacheKey, new Object[0]);
        if (applyCachedLiveVideoInfo()) {
            return;
        }
        TVKInProgressHTTPRequestRecorder.recordHTTPRequestInProgress(this.mCacheKey, this.mLogger);
        TVKHttpProcessorFactory.getHttpRequester().executeAsync(new ITVKHttpProcessor.TVKHttpRequest.Builder(ITVKHttpProcessor.TVKHttpRequest.HttpMethod.POST, buildRequestHost).reqTag(getHttpRequestTag()).body(TVKHttpUtils.encodeParamsToByteForUrlEncoding(buildRequestParams, "UTF-8")).addBackupHosts(this.mLiveRequestBuilder.buildRequestBakHosts()).headers(buildRequestHeader).httpDns(true).retryCellularOnWifiFailure(true).callTimeoutMs(TVKMediaPlayerConfig.PlayerConfig.cgi_request_timeout_ms).build(), this.mHttpCallback);
        sendEvent(TVKEventId.PLAYER_STATE_CGI_HTTP_REQUEST, 0, 0, "", null);
    }

    private String getHttpRequestTag() {
        return this.mLogger.getTag() + "_" + this.mRequestId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleFailure(IOException iOException) {
        if (isCanceled()) {
            this.mLogger.warn("LIVE CGI: [onFailure] canceled and return", new Object[0]);
            return;
        }
        int errCodeByThrowable = TVKCGIErrorCodeUtils.getErrCodeByThrowable(iOException);
        this.mLogger.error("LIVE CGI: [onFailure] exception: " + iOException + ", error code=" + errCodeByThrowable, new Object[0]);
        int i3 = this.mRetryCount;
        if (i3 < TVKMediaPlayerConfig.PlayerConfig.cgi_max_retry_times) {
            this.mRetryCount = i3 + 1;
            this.mLogger.warn("try again. Reason: IO exception, retry count=" + this.mRetryCount, new Object[0]);
            executeRequest();
            return;
        }
        dealOnFail(errCodeByThrowable);
    }

    private void handleResponse(Map<String, List<String>> map, String str) {
        try {
            TVKLiveVideoInfo parseLiveInfo = this.mLiveInfoParser.parseLiveInfo(str);
            setMultiNicFromTypeIfNeeded(map, parseLiveInfo);
            if (this.mRetryCount < TVKMediaPlayerConfig.PlayerConfig.cgi_max_retry_times && isCkeyVerifyErr(parseLiveInfo)) {
                this.mRetryCount++;
                this.mLogger.warn("try again. Reason: CKey verification error, retry count=" + this.mRetryCount, new Object[0]);
                executeRequest();
                return;
            }
            if (parseLiveInfo.getRetCode() == 0) {
                dealOnSuccess(parseLiveInfo);
            } else {
                dealOnFailWithInfo(parseLiveInfo);
            }
        } catch (ParseException e16) {
            e = e16;
            this.mLogger.printException(e);
            dealOnFail(15);
        } catch (TVKIllegalCGIResponseException e17) {
            this.mLogger.printException(e17);
            if (e17.getErrorType() != 5) {
                dealOnFail(6);
            } else {
                dealOnFail(28);
            }
        } catch (JSONException e18) {
            e = e18;
            this.mLogger.printException(e);
            dealOnFail(15);
        } catch (Exception e19) {
            this.mLogger.printException(e19);
            dealOnFail(6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSuccess(ITVKHttpProcessor.TVKHttpResponse tVKHttpResponse) {
        sendEvent(TVKEventId.PLAYER_STATE_CGI_RESPONSE_HEADERS, 0, 0, "", tVKHttpResponse.getHeaders());
        if (isCanceled()) {
            this.mLogger.warn("LIVE CGI: [onSuccess] canceled and return", new Object[0]);
            return;
        }
        sendEvent(TVKEventId.PLAYER_STATE_CGI_HTTP_RESPONSE, 0, 0, "", null);
        String str = new String(tVKHttpResponse.getData(), Charset.forName("UTF-8"));
        if (!TextUtils.isEmpty(str)) {
            dumpLiveCgiResp(str);
            handleResponse(tVKHttpResponse.getHeaders(), str);
            return;
        }
        int i3 = this.mRetryCount;
        if (i3 < TVKMediaPlayerConfig.PlayerConfig.cgi_max_retry_times) {
            this.mRetryCount = i3 + 1;
            this.mLogger.warn("try again. Reason: empty response, retry count=" + this.mRetryCount, new Object[0]);
            executeRequest();
            return;
        }
        dealOnFail(23);
    }

    private boolean isCanceled() {
        if (this.mRequestState == ITVKCGIRequestBase.RequestState.STATE_CANCELED) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$dealOnSuccess$0(TVKLiveVideoInfo tVKLiveVideoInfo) {
        boolean put = TVKLiveInfoCache.getInstance().put(this.mCacheKey, tVKLiveVideoInfo);
        this.mLogger.info("LIVE CGI: [dealOnSuccess] successfully cache CGI content with key " + this.mCacheKey + "? " + put, new Object[0]);
        TVKInProgressHTTPRequestRecorder.notifyAllHttpRequestDone(this.mCacheKey, put, this.mLogger);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$dumpLiveCgiResp$1(ITVKLogger iTVKLogger, String str) {
        iTVKLogger.info(str, new Object[0]);
    }

    private void sendEvent(int i3, int i16, int i17, String str, Object obj) {
        if (isCanceled()) {
            return;
        }
        this.mTVKContext.getEventSender().sendEvent(i3, i16, i17, str, obj);
    }

    private void setMultiNicFromTypeIfNeeded(Map<String, List<String>> map, TVKLiveVideoInfo tVKLiveVideoInfo) {
        List<String> list = map.get(ITVKHttpProcessor.HTTP_REQUEST_NETWORK_INTERFACE_SPECIFIER);
        if (list != null && list.contains("1")) {
            tVKLiveVideoInfo.setFromType(TVKVideoInfoFromType.FROM_TYPE_SERVER_BY_MULTI_NIC);
        }
    }

    private boolean shouldUseBakUrl() {
        if (this.mRetryCount >= TVKMediaPlayerConfig.PlayerConfig.cgi_max_retry_times / 2) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.apiinner.ITVKCGIRequestBase
    public void cancel() {
        this.mRequestState = ITVKCGIRequestBase.RequestState.STATE_CANCELED;
        TVKInProgressHTTPRequestRecorder.notifyAllHttpRequestDone(this.mCacheKey, false, this.mLogger);
        TVKHttpProcessorFactory.getHttpRequester().cancelRequest(getHttpRequestTag());
        this.mLogger.info("LIVE CGI: [cancel] canceled", new Object[0]);
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.apiinner.ITVKCGIRequestBase
    public void execute() {
        if (this.mRequestState != ITVKCGIRequestBase.RequestState.STATE_IDLE) {
            this.mLogger.error("request state is not idle and return", new Object[0]);
            return;
        }
        this.mRequestState = ITVKCGIRequestBase.RequestState.STATE_RUNNING;
        sendEvent(TVKEventId.PLAYER_STATE_CGI_START, 0, 0, "", null);
        this.mCGIExecutor.execute(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.vinfo.live.b
            @Override // java.lang.Runnable
            public final void run() {
                TVKLiveInfoRequest.this.executeRequest();
            }
        });
    }

    protected boolean isCkeyVerifyErr(TVKLiveVideoInfo tVKLiveVideoInfo) {
        boolean z16;
        boolean z17;
        boolean z18;
        if (tVKLiveVideoInfo != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && tVKLiveVideoInfo.getRetCode() == 32) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17 && tVKLiveVideoInfo.getSubErrType() == -3) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (!z18) {
            return false;
        }
        TVKServerTimeGetter.sServerTimeSec = tVKLiveVideoInfo.getServerTime();
        TVKServerTimeGetter.sRandKey = tVKLiveVideoInfo.getRand();
        TVKServerTimeGetter.sElapsedRealTimeMs = SystemClock.elapsedRealtime();
        return true;
    }
}
