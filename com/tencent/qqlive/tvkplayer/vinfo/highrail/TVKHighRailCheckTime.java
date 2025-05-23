package com.tencent.qqlive.tvkplayer.vinfo.highrail;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.tools.config.TVKUrlConfig;
import com.tencent.qqlive.tvkplayer.tools.http.TVKHttpProcessorFactory;
import com.tencent.qqlive.tvkplayer.tools.http.api.ITVKHttpProcessor;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import com.tencent.qqlive.tvkplayer.vinfo.apiinner.ITVKCheckTimeListener;
import com.tencent.qqlive.tvkplayer.vinfo.common.TVKCGIErrorCodeUtils;
import java.io.IOException;
import java.nio.charset.Charset;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKHighRailCheckTime {
    private static final String HTTP_REQUEST_TAG = "TVKHighRailCheckTime";
    private static final int MAX_RETRY_COUNT = 3;
    private static final int REQUEST_SERVER_TIME_OUT_MS = 15000;
    private static final String TAG = "TVKPlayer[TVKHighRailCheckTime]";
    private ITVKCheckTimeListener mListener;
    private static final TVKHighRailCheckTime INSTANCE = new TVKHighRailCheckTime();
    public static long mServerTimeSec = 0;
    public static long mElapsedRealTimeMs = 0;
    private int mCurrentRetryCount = 0;
    private boolean mIsRunning = false;
    private ITVKHttpProcessor.ITVKHttpCallback mCheckTimeCb = new ITVKHttpProcessor.ITVKHttpCallback() { // from class: com.tencent.qqlive.tvkplayer.vinfo.highrail.TVKHighRailCheckTime.1
        @Override // com.tencent.qqlive.tvkplayer.tools.http.api.ITVKHttpProcessor.ITVKHttpCallback
        public void onFailure(@NonNull IOException iOException) {
            int errCodeByThrowable = TVKCGIErrorCodeUtils.getErrCodeByThrowable(iOException);
            if (!TVKHighRailCheckTime.this.isNeedRetry()) {
                TVKHighRailCheckTime.this.dealOnFail(errCodeByThrowable);
            } else {
                TVKHighRailCheckTime.access$108(TVKHighRailCheckTime.this);
                TVKHighRailCheckTime.this.executeRequest();
            }
        }

        @Override // com.tencent.qqlive.tvkplayer.tools.http.api.ITVKHttpProcessor.ITVKHttpCallback
        public void onSuccess(ITVKHttpProcessor.TVKHttpResponse tVKHttpResponse) {
            String str = new String(tVKHttpResponse.getData(), Charset.forName("UTF-8"));
            if (!TextUtils.isEmpty(str) && TVKUtils.optLong(str, 0L) > 0) {
                synchronized (TVKHighRailCheckTime.class) {
                    TVKHighRailCheckTime.mServerTimeSec = TVKUtils.optLong(str, 0L);
                    TVKHighRailCheckTime.mElapsedRealTimeMs = SystemClock.elapsedRealtime();
                }
                if (TVKHighRailCheckTime.this.mListener != null) {
                    TVKHighRailCheckTime.this.mListener.onSuccess();
                }
                TVKHighRailCheckTime.this.reset();
                return;
            }
            if (!TVKHighRailCheckTime.this.isNeedRetry()) {
                TVKHighRailCheckTime.this.dealOnFail(23);
            } else {
                TVKHighRailCheckTime.access$108(TVKHighRailCheckTime.this);
                TVKHighRailCheckTime.this.executeRequest();
            }
        }
    };

    TVKHighRailCheckTime() {
    }

    static /* synthetic */ int access$108(TVKHighRailCheckTime tVKHighRailCheckTime) {
        int i3 = tVKHighRailCheckTime.mCurrentRetryCount;
        tVKHighRailCheckTime.mCurrentRetryCount = i3 + 1;
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dealOnFail(int i3) {
        ITVKCheckTimeListener iTVKCheckTimeListener = this.mListener;
        if (iTVKCheckTimeListener != null) {
            iTVKCheckTimeListener.onFailure(i3);
        }
        reset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeRequest() {
        TVKHttpProcessorFactory.getHttpRequester().executeAsync(new ITVKHttpProcessor.TVKHttpRequest.Builder(ITVKHttpProcessor.TVKHttpRequest.HttpMethod.GET, TVKUrlConfig.getServiceUrl(TVKUrlConfig.SERVICE_NAME_TIME_CGI_HIGH_RAIL_HOST)).reqTag(HTTP_REQUEST_TAG).callTimeoutMs(15000L).build(), this.mCheckTimeCb);
    }

    public static TVKHighRailCheckTime getInstance() {
        return INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isNeedRetry() {
        if (this.mCurrentRetryCount < 3) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.mCurrentRetryCount = 0;
        synchronized (TVKHighRailCheckTime.class) {
            this.mIsRunning = false;
        }
    }

    public void execute() {
        synchronized (TVKHighRailCheckTime.class) {
            if (this.mIsRunning) {
                TVKLogUtil.e(TAG, "now is running and return");
            } else {
                this.mIsRunning = true;
                executeRequest();
            }
        }
    }

    public void setListener(ITVKCheckTimeListener iTVKCheckTimeListener) {
        this.mListener = iTVKCheckTimeListener;
    }
}
