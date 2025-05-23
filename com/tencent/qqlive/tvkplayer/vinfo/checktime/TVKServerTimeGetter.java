package com.tencent.qqlive.tvkplayer.vinfo.checktime;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.ads.data.AdParam;
import com.tencent.ark.ark;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqlive.tvkplayer.tools.baseinfo.TVKCommParams;
import com.tencent.qqlive.tvkplayer.tools.config.TVKUrlConfig;
import com.tencent.qqlive.tvkplayer.tools.http.TVKHttpProcessorFactory;
import com.tencent.qqlive.tvkplayer.tools.http.api.ITVKHttpProcessor;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUrlBuilder;
import com.tencent.qqlive.tvkplayer.vinfo.api.ITVKServerTimeGetter;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveRequestBuilder;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKServerTimeGetter implements ITVKServerTimeGetter {
    private static final String HTTP_REQUEST_TAG = "TVKServerTimeGetter";
    private static final int REQUEST_SERVER_TIME_OUT_MS = 15000;
    private static final int RETRY_COUNT_NUM = 2;
    private static final String TAG = "[TVKPlayer]TVKServerTimeGetter";
    public static String sOutNetIp;
    public static String sRandKey;
    private ITVKServerTimeGetter.ITVKServerTimeCompleteListener mListener;
    private static final TVKServerTimeGetter INSTANCE = new TVKServerTimeGetter();
    public static long sServerTimeSec = 0;
    public static long sElapsedRealTimeMs = 0;
    private int mRetryCount = 1;
    private boolean mUseBkUrl = false;
    private boolean mIsRunning = false;
    private ITVKHttpProcessor.ITVKHttpCallback mHttpCallback = new ITVKHttpProcessor.ITVKHttpCallback() { // from class: com.tencent.qqlive.tvkplayer.vinfo.checktime.TVKServerTimeGetter.1
        @Override // com.tencent.qqlive.tvkplayer.tools.http.api.ITVKHttpProcessor.ITVKHttpCallback
        public void onFailure(IOException iOException) {
            TVKLogUtil.w(TVKServerTimeGetter.TAG, "[ServerTime] error" + iOException.toString());
            if (TVKServerTimeGetter.this.mRetryCount < 2) {
                TVKServerTimeGetter.this.mUseBkUrl = !r3.mUseBkUrl;
                TVKLogUtil.w(TVKServerTimeGetter.TAG, "[ServerTime] change host, retry");
                TVKServerTimeGetter.access$004(TVKServerTimeGetter.this);
                TVKServerTimeGetter.this.executeRequest();
                return;
            }
            TVKLogUtil.w(TVKServerTimeGetter.TAG, "[ServerTime] failure, pass wrong time to getvinfo");
            TVKServerTimeGetter.this.reset();
        }

        @Override // com.tencent.qqlive.tvkplayer.tools.http.api.ITVKHttpProcessor.ITVKHttpCallback
        public void onSuccess(ITVKHttpProcessor.TVKHttpResponse tVKHttpResponse) {
            String str = new String(tVKHttpResponse.getData(), StandardCharsets.UTF_8);
            TVKLogUtil.i(TVKServerTimeGetter.TAG, "[ServerTime]responseBody = " + str);
            if (!TextUtils.isEmpty(str)) {
                TVKServerTimeGetter.this.parseOutput(str);
            }
            TVKServerTimeGetter.this.reset();
        }
    };

    TVKServerTimeGetter() {
    }

    static /* synthetic */ int access$004(TVKServerTimeGetter tVKServerTimeGetter) {
        int i3 = tVKServerTimeGetter.mRetryCount + 1;
        tVKServerTimeGetter.mRetryCount = i3;
        return i3;
    }

    private static String escapeQZOutputJson(String str) {
        if (str != null && str.startsWith("QZOutputJson=")) {
            return str.substring(13);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeRequest() {
        String buildUrl = new TVKUrlBuilder().setUrl(getRequestUrl()).addParam(getRequestParams()).buildUrl();
        TVKLogUtil.i(TAG, "[ServerTime] request url=" + buildUrl);
        TVKHttpProcessorFactory.getHttpRequester().executeAsync(new ITVKHttpProcessor.TVKHttpRequest.Builder(ITVKHttpProcessor.TVKHttpRequest.HttpMethod.GET, buildUrl).reqTag(HTTP_REQUEST_TAG).callTimeoutMs(15000L).build(), this.mHttpCallback);
    }

    public static TVKServerTimeGetter getInstance() {
        return INSTANCE;
    }

    private Map<String, String> getRequestParams() {
        HashMap hashMap = new HashMap();
        hashMap.put(AdParam.OTYPE, ark.ARKMETADATA_JSON);
        hashMap.put("guid", TVKCommParams.getStaGuid());
        hashMap.put(TVKLiveRequestBuilder.RequestParamKey.RANDOM_NUMBER, String.valueOf(Math.random()));
        TVKLogUtil.i(TAG, "[ServerTime] request requestParams = " + hashMap.toString());
        return hashMap;
    }

    private String getRequestUrl() {
        String serviceUrl;
        if (!this.mUseBkUrl) {
            serviceUrl = TVKUrlConfig.getServiceUrl(TVKUrlConfig.SERVICE_NAME_TIME_CGI_HOST);
        } else {
            serviceUrl = TVKUrlConfig.getServiceUrl(TVKUrlConfig.SERVICE_NAME_TIME_CGI_HOST_BK);
        }
        TVKLogUtil.i(TAG, "[ServerTime] request url = " + serviceUrl);
        return serviceUrl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void parseOutput(String str) {
        TVKLogUtil.i(TAG, "[ServerTime] return httpText = " + str);
        try {
            JSONObject jSONObject = new JSONObject(escapeQZOutputJson(str));
            if ("o".equals(jSONObject.getString(ReportConstant.COSTREPORT_PREFIX))) {
                synchronized (TVKServerTimeGetter.class) {
                    if (jSONObject.has("t")) {
                        sServerTimeSec = jSONObject.optLong("t");
                        sElapsedRealTimeMs = SystemClock.elapsedRealtime();
                    }
                    if (jSONObject.has("rand")) {
                        sRandKey = jSONObject.optString("rand");
                    }
                    if (jSONObject.has("ip")) {
                        sOutNetIp = jSONObject.optString("ip");
                    }
                    ITVKServerTimeGetter.ITVKServerTimeCompleteListener iTVKServerTimeCompleteListener = this.mListener;
                    if (iTVKServerTimeCompleteListener != null) {
                        iTVKServerTimeCompleteListener.onComplete(sOutNetIp);
                    }
                }
                return;
            }
            TVKLogUtil.e(TAG, "[ServerTime] result can not get time");
        } catch (Throwable th5) {
            TVKLogUtil.e(TAG, "[ServerTime] parse has exception:" + th5.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void reset() {
        synchronized (TVKServerTimeGetter.class) {
            this.mIsRunning = false;
        }
        this.mRetryCount = 1;
        this.mUseBkUrl = false;
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.api.ITVKServerTimeGetter
    public long calculateCurrentServerTimeSec() {
        long j3 = sServerTimeSec;
        if (j3 == 0) {
            return System.currentTimeMillis() / 1000;
        }
        return j3 + ((SystemClock.elapsedRealtime() - sElapsedRealTimeMs) / 1000);
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.api.ITVKServerTimeGetter
    public void execute() {
        synchronized (TVKServerTimeGetter.class) {
            if (this.mIsRunning) {
                TVKLogUtil.i(TAG, "[ServerTime] now is running and return");
            } else {
                this.mIsRunning = true;
                executeRequest();
            }
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.api.ITVKServerTimeGetter
    public long getElapsedRealTimeMs() {
        long j3 = sElapsedRealTimeMs;
        if (j3 == 0) {
            return SystemClock.elapsedRealtime();
        }
        return j3;
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.api.ITVKServerTimeGetter
    public long getServerTimeSec() {
        return sServerTimeSec;
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.api.ITVKServerTimeGetter
    public void setServerTimeCompleteListener(ITVKServerTimeGetter.ITVKServerTimeCompleteListener iTVKServerTimeCompleteListener) {
        this.mListener = iTVKServerTimeCompleteListener;
    }
}
