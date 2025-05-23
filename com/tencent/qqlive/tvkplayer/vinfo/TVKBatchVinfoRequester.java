package com.tencent.qqlive.tvkplayer.vinfo;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.TVKError;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.TVKUserInfo;
import com.tencent.qqlive.tvkplayer.api.batchvinfo.ITVKBatchVinfoListener;
import com.tencent.qqlive.tvkplayer.api.batchvinfo.ITVKBatchVinfoRequester;
import com.tencent.qqlive.tvkplayer.api.batchvinfo.TVKBatchVinfoResponseInfo;
import com.tencent.qqlive.tvkplayer.context.TVKContext;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.TVKFeatureFactory;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.TVKPlayerFeatureGroup;
import com.tencent.qqlive.tvkplayer.qqliveasset.strategy.TVKFormatIDChooser;
import com.tencent.qqlive.tvkplayer.tools.http.TVKHttpProcessorFactory;
import com.tencent.qqlive.tvkplayer.tools.http.api.ITVKHttpProcessor;
import com.tencent.qqlive.tvkplayer.tools.log.ITVKLogger;
import com.tencent.qqlive.tvkplayer.tools.log.TVKLogger;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonErrorCodeUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonParamEnum;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLongTextPrinter;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKNetworkUtils;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKThreadPool;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import com.tencent.qqlive.tvkplayer.vinfo.TVKBatchVinfoRequester;
import com.tencent.qqlive.tvkplayer.vinfo.api.TVKCGIRequestParam;
import com.tencent.qqlive.tvkplayer.vinfo.common.TVKCGIErrorCodeUtils;
import com.tencent.qqlive.tvkplayer.vinfo.vod.TVKVodBatchVinfoRequestBuilder;
import com.tencent.qqlive.tvkplayer.vinfo.vod.TVKVodRequestBuilder;
import com.tencent.qqlive.tvkplayer.vinfo.vod.TVKVodVinfoDecryptor;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKBatchVinfoRequester implements ITVKBatchVinfoRequester {
    private static final int BATCH_VINFO_REQUEST_TIMEOUT_MS = 5000;
    private static final String HTTP_REQUEST_TAG = "TVKBatchVinfoRequester";
    private static final int MAX_RETRY_LIMIT = 4;
    private static final String TAG = "TVKBatchVinfoRequester";
    private static volatile TVKPlayerFeatureGroup sFeatureGroup;
    private static final AtomicInteger sTaskIdGenerator = new AtomicInteger(0);
    private final ITVKLogger mLogger;
    private final TVKContext mTVKContext;
    private final Map<Integer, BatchVinfoRequestInfo> mTaskIdToRequestInfo = new ConcurrentHashMap();
    private ITVKBatchVinfoListener mListener = new HookBatchVinfoListener(null);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class BatchVinfoRequestInfo {
        private final Map<String, TVKPlayerVideoInfo> mBatchVideoInfo;
        private int mRetryCount = 0;
        private final TVKUserInfo mUserInfo;

        public BatchVinfoRequestInfo(@NonNull Map<String, TVKPlayerVideoInfo> map, @NonNull TVKUserInfo tVKUserInfo) {
            this.mBatchVideoInfo = map;
            this.mUserInfo = tVKUserInfo;
        }

        @NonNull
        public Map<String, TVKPlayerVideoInfo> getBatchVideoInfo() {
            return this.mBatchVideoInfo;
        }

        public int getRetryCount() {
            return this.mRetryCount;
        }

        @NonNull
        public TVKUserInfo getUserInfo() {
            return this.mUserInfo;
        }

        public int increaseRetryCountAndGet() {
            int i3 = this.mRetryCount + 1;
            this.mRetryCount = i3;
            return i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class HookBatchVinfoListener implements ITVKBatchVinfoListener {
        private final Handler mCallbackHandler;
        private final ITVKBatchVinfoListener mOriginalListener;

        public HookBatchVinfoListener(ITVKBatchVinfoListener iTVKBatchVinfoListener) {
            this.mOriginalListener = iTVKBatchVinfoListener;
            Looper myLooper = Looper.myLooper();
            if (myLooper != null) {
                this.mCallbackHandler = new Handler(myLooper);
            } else {
                this.mCallbackHandler = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onFailure$1(int i3, TVKError tVKError) {
            this.mOriginalListener.onFailure(i3, tVKError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onSuccess$0(int i3, Map map) {
            this.mOriginalListener.onSuccess(i3, map);
        }

        @Override // com.tencent.qqlive.tvkplayer.api.batchvinfo.ITVKBatchVinfoListener
        public void onFailure(final int i3, final TVKError tVKError) {
            ITVKBatchVinfoListener iTVKBatchVinfoListener = this.mOriginalListener;
            if (iTVKBatchVinfoListener == null) {
                return;
            }
            Handler handler = this.mCallbackHandler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.vinfo.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        TVKBatchVinfoRequester.HookBatchVinfoListener.this.lambda$onFailure$1(i3, tVKError);
                    }
                });
            } else {
                iTVKBatchVinfoListener.onFailure(i3, tVKError);
            }
        }

        @Override // com.tencent.qqlive.tvkplayer.api.batchvinfo.ITVKBatchVinfoListener
        public void onSuccess(final int i3, final Map<String, TVKBatchVinfoResponseInfo> map) {
            ITVKBatchVinfoListener iTVKBatchVinfoListener = this.mOriginalListener;
            if (iTVKBatchVinfoListener == null) {
                return;
            }
            Handler handler = this.mCallbackHandler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.vinfo.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        TVKBatchVinfoRequester.HookBatchVinfoListener.this.lambda$onSuccess$0(i3, map);
                    }
                });
            } else {
                iTVKBatchVinfoListener.onSuccess(i3, map);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class HttpCallback implements ITVKHttpProcessor.ITVKHttpCallback {
        private final int mTaskId;

        public HttpCallback(int i3) {
            this.mTaskId = i3;
        }

        @Override // com.tencent.qqlive.tvkplayer.tools.http.api.ITVKHttpProcessor.ITVKHttpCallback
        public void onFailure(@NonNull IOException iOException) {
            TVKBatchVinfoRequester.this.mLogger.error("[onFailure] task id=" + this.mTaskId + ", batch vinfo request failed: " + iOException, new Object[0]);
            BatchVinfoRequestInfo batchVinfoRequestInfo = (BatchVinfoRequestInfo) TVKBatchVinfoRequester.this.mTaskIdToRequestInfo.get(Integer.valueOf(this.mTaskId));
            if (batchVinfoRequestInfo == null) {
                TVKBatchVinfoRequester.this.mLogger.error("[onFailure] cannot find request info with task id=" + this.mTaskId, new Object[0]);
                TVKBatchVinfoRequester.this.mListener.onFailure(this.mTaskId, new TVKError(TVKCommonErrorCodeUtil.MODULE.PLAY_QQLIVE_ASSET_ERR, TVKCommonErrorCodeUtil.CODE.LOGIC.UNKNOWN_ERR));
                return;
            }
            if (batchVinfoRequestInfo.increaseRetryCountAndGet() >= 4) {
                TVKBatchVinfoRequester.this.mLogger.error("[executeRequest] reach retry limit. Task id=" + this.mTaskId, new Object[0]);
                TVKBatchVinfoRequester.this.mTaskIdToRequestInfo.remove(Integer.valueOf(this.mTaskId));
                TVKBatchVinfoRequester.this.mListener.onFailure(this.mTaskId, new TVKError(TVKCommonErrorCodeUtil.MODULE.CGI_GETVINFO_ERR, TVKCGIErrorCodeUtils.getErrCodeByThrowable(iOException) + TVKCommonErrorCodeUtil.CODE.VOD.CGI_GETVINFO_NETWORK_BASE_ERR));
                return;
            }
            TVKBatchVinfoRequester.this.executeRequestAsync(this.mTaskId);
        }

        @Override // com.tencent.qqlive.tvkplayer.tools.http.api.ITVKHttpProcessor.ITVKHttpCallback
        public void onSuccess(ITVKHttpProcessor.TVKHttpResponse tVKHttpResponse) {
            String str;
            TVKBatchVinfoRequester.this.mLogger.info("[onSuccess] task id=" + this.mTaskId + ", batch vinfo request success", new Object[0]);
            if (TVKNetworkUtils.isCompressedByGzip(tVKHttpResponse.getHeaders())) {
                byte[] gzipDeCompress = TVKUtils.gzipDeCompress(tVKHttpResponse.getData());
                if (gzipDeCompress != null) {
                    str = new String(gzipDeCompress, StandardCharsets.UTF_8);
                } else {
                    str = "";
                }
            } else {
                str = new String(tVKHttpResponse.getData(), StandardCharsets.UTF_8);
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                TVKBatchVinfoRequester.this.mTaskIdToRequestInfo.remove(Integer.valueOf(this.mTaskId));
                Map<String, TVKBatchVinfoResponseInfo> generateBatchVinfoMap = TVKBatchVinfoRequester.this.generateBatchVinfoMap(jSONObject);
                TVKBatchVinfoRequester.this.mLogger.info("[onSuccess] batch vinfo map generated: ", new Object[0]);
                for (Map.Entry<String, TVKBatchVinfoResponseInfo> entry : generateBatchVinfoMap.entrySet()) {
                    TVKBatchVinfoRequester.this.mLogger.info(entry.getKey() + " => " + entry.getValue(), new Object[0]);
                }
                TVKBatchVinfoRequester.this.mListener.onSuccess(this.mTaskId, generateBatchVinfoMap);
            } catch (JSONException e16) {
                TVKBatchVinfoRequester.this.mLogger.error("[onSuccess] there is a exception: " + e16, new Object[0]);
                TVKBatchVinfoRequester.this.mTaskIdToRequestInfo.remove(Integer.valueOf(this.mTaskId));
                TVKBatchVinfoRequester.this.mListener.onFailure(this.mTaskId, new TVKError(TVKCommonErrorCodeUtil.MODULE.CGI_GETVINFO_ERR, TVKCGIErrorCodeUtils.getErrCodeByThrowable(e16) + TVKCommonErrorCodeUtil.CODE.VOD.CGI_GETVINFO_NETWORK_BASE_ERR));
            }
        }
    }

    public TVKBatchVinfoRequester(@NonNull TVKContext tVKContext) {
        this.mTVKContext = tVKContext;
        this.mLogger = new TVKLogger(tVKContext, "TVKBatchVinfoRequester");
        initFeatureGroup(tVKContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: executeRequest, reason: merged with bridge method [inline-methods] */
    public void lambda$executeRequestAsync$0(int i3) {
        boolean z16;
        Object asset;
        BatchVinfoRequestInfo batchVinfoRequestInfo = this.mTaskIdToRequestInfo.get(Integer.valueOf(i3));
        if (batchVinfoRequestInfo == null) {
            this.mLogger.error("[executeRequest] cannot find request info with task id=" + i3, new Object[0]);
            this.mListener.onFailure(i3, new TVKError(TVKCommonErrorCodeUtil.MODULE.PLAY_QQLIVE_ASSET_ERR, TVKCommonErrorCodeUtil.CODE.LOGIC.UNKNOWN_ERR));
            return;
        }
        Map<String, TVKPlayerVideoInfo> batchVideoInfo = batchVinfoRequestInfo.getBatchVideoInfo();
        TVKUserInfo userInfo = batchVinfoRequestInfo.getUserInfo();
        if (batchVinfoRequestInfo.getRetryCount() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        TVKVodBatchVinfoRequestBuilder tVKVodBatchVinfoRequestBuilder = new TVKVodBatchVinfoRequestBuilder();
        String generateFlowId = TVKUtils.generateFlowId();
        Map<String, String> map = null;
        String str = "";
        for (Map.Entry<String, TVKPlayerVideoInfo> entry : batchVideoInfo.entrySet()) {
            TVKPlayerVideoInfo value = entry.getValue();
            if (isVideoInfoInvalid(value)) {
                ITVKLogger iTVKLogger = this.mLogger;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[executeRequest] incorrect asset: ");
                if (value == null) {
                    asset = "null";
                } else {
                    asset = value.getAsset();
                }
                sb5.append(asset);
                iTVKLogger.error(sb5.toString(), new Object[0]);
            } else {
                TVKVodRequestBuilder tVKVodRequestBuilder = new TVKVodRequestBuilder(this.mTVKContext, new TVKCGIRequestParam.Builder(value, value.getAsset(), userInfo).definition(value.getDefinition()).streamFormatId(TVKFormatIDChooser.chooseFormatID(value)).requestSource(4).flowId(generateFlowId).build(), sFeatureGroup, TVKFeatureFactory.createFeatureParamGroupForBatchVinfo(value), 0);
                if (map == null) {
                    map = tVKVodRequestBuilder.buildBatchVinfoRequestHeaders();
                }
                if (TextUtils.isEmpty(str)) {
                    str = tVKVodRequestBuilder.buildBatchVinfoRequestHost();
                }
                tVKVodBatchVinfoRequestBuilder.addRequest(entry.getKey(), tVKVodRequestBuilder.buildVinfoRequestParams(z16));
            }
        }
        if (TextUtils.isEmpty(str)) {
            this.mLogger.error("[executeRequest] cannot generate request host url", new Object[0]);
            this.mTaskIdToRequestInfo.remove(Integer.valueOf(i3));
            this.mListener.onFailure(i3, new TVKError(TVKCommonErrorCodeUtil.MODULE.PLAY_QQLIVE_ASSET_ERR, TVKCommonErrorCodeUtil.CODE.LOGIC.PARAM_INVALID_ERR));
            return;
        }
        String build = tVKVodBatchVinfoRequestBuilder.build();
        this.mLogger.info("[executeRequest] task id=" + i3 + ", request body:", new Object[0]);
        final ITVKLogger iTVKLogger2 = this.mLogger;
        Objects.requireNonNull(iTVKLogger2);
        TVKLongTextPrinter.print(build, new TVKLongTextPrinter.Printer() { // from class: com.tencent.qqlive.tvkplayer.vinfo.b
            @Override // com.tencent.qqlive.tvkplayer.tools.utils.TVKLongTextPrinter.Printer
            public final void print(String str2) {
                TVKBatchVinfoRequester.lambda$executeRequest$1(ITVKLogger.this, str2);
            }
        });
        TVKHttpProcessorFactory.getHttpRequester().executeAsync(new ITVKHttpProcessor.TVKHttpRequest.Builder(ITVKHttpProcessor.TVKHttpRequest.HttpMethod.POST, str).reqTag("TVKBatchVinfoRequester").headers(map).body(build.getBytes(StandardCharsets.UTF_8)).callTimeoutMs(5000L).build(), new HttpCallback(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeRequestAsync(final int i3) {
        TVKThreadPool.getInstance().obtainNormalPriorityExecutor().execute(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.vinfo.a
            @Override // java.lang.Runnable
            public final void run() {
                TVKBatchVinfoRequester.this.lambda$executeRequestAsync$0(i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, TVKBatchVinfoResponseInfo> generateBatchVinfoMap(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        JSONObject optJSONObject = jSONObject.optJSONObject(TVKCommonParamEnum.BATCH_VINFO_RESPONSE_PARAM_RESPONSES);
        if (optJSONObject == null) {
            return hashMap;
        }
        Iterator keys = optJSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            JSONObject optJSONObject2 = optJSONObject.optJSONObject(str);
            if (optJSONObject2 != null) {
                try {
                    hashMap.put(str, new TVKBatchVinfoResponseInfo(optJSONObject2.optString("vid", ""), optJSONObject2.optString(TVKCommonParamEnum.BATCH_VINFO_RESPONSE_PARAM_DEFINITION, ""), optJSONObject2.optInt(TVKCommonParamEnum.BATCH_VINFO_RESPONSE_PARAM_EFFECTIVE_URL_DURATION_SEC, 0), TVKVodVinfoDecryptor.decryptVinfo(optJSONObject2.optString("video_info", ""))));
                } catch (TVKVodVinfoDecryptor.DecryptException e16) {
                    this.mLogger.error("[generateBatchVinfoMap] cannot decrypt vinfo", new Object[0]);
                    this.mLogger.printException(e16);
                }
            }
        }
        return hashMap;
    }

    private void initFeatureGroup(@NonNull TVKContext tVKContext) {
        if (sFeatureGroup == null) {
            synchronized (TVKBatchVinfoRequester.class) {
                if (sFeatureGroup == null) {
                    sFeatureGroup = new TVKPlayerFeatureGroup(TVKFeatureFactory.createVodFeatureList(tVKContext));
                }
            }
        }
    }

    private boolean isVideoInfoInvalid(TVKPlayerVideoInfo tVKPlayerVideoInfo) {
        if (tVKPlayerVideoInfo != null && tVKPlayerVideoInfo.isAssetValid() && (tVKPlayerVideoInfo.getAsset().getAssetType() == 131072 || tVKPlayerVideoInfo.getAsset().getAssetType() == 524288)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$executeRequest$1(ITVKLogger iTVKLogger, String str) {
        iTVKLogger.info(str, new Object[0]);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.batchvinfo.ITVKBatchVinfoRequester
    public int requestBatchVinfo(Map<String, TVKPlayerVideoInfo> map, TVKUserInfo tVKUserInfo) throws IllegalArgumentException {
        if (map != null && !map.isEmpty()) {
            if (tVKUserInfo == null) {
                tVKUserInfo = new TVKUserInfo();
            }
            this.mTVKContext.increaseSequence();
            int incrementAndGet = sTaskIdGenerator.incrementAndGet();
            this.mTaskIdToRequestInfo.put(Integer.valueOf(incrementAndGet), new BatchVinfoRequestInfo(map, tVKUserInfo));
            executeRequestAsync(incrementAndGet);
            return incrementAndGet;
        }
        this.mLogger.error("[requestBatchVinfo] batchVideoInfo is null or empty", new Object[0]);
        throw new IllegalArgumentException("Invalid input: batch video info is null or empty");
    }

    @Override // com.tencent.qqlive.tvkplayer.api.batchvinfo.ITVKBatchVinfoRequester
    public void setListener(ITVKBatchVinfoListener iTVKBatchVinfoListener) {
        this.mListener = new HookBatchVinfoListener(iTVKBatchVinfoListener);
    }
}
