package com.tencent.biz.richframework.network.request;

import android.os.SystemClock;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes5.dex */
public class VSRequestStrategyBean {
    private static final String KEY_CMD = "cmd";
    private static final String KEY_FORBIDDEN_CACHE = "forbidden_cache";
    private static final String KEY_FREQUENCY = "frequency";
    private static final String KEY_SAMPLE = "sample";
    private static final String KEY_STRATEGY_ERROR_CODE = "error_code";
    private static final String KEY_STRATEGY_ERROR_MSG = "error_msg";
    private static final String KEY_STRATEGY_TYPE = "strategy_type";
    public static final int STRATEGY_FREQUENCY = 2;
    public static final int STRATEGY_REJECT = 3;
    public static final int STRATEGY_SAMPLE = 1;
    private final String mCmd;
    private final int mErrorCode;
    private final String mErrorMsg;
    private final int mForbiddenCache;
    private final int mFrequency;
    private long mLastRequestTimeStamp = 0;
    private final double mSample;
    private final int mStrategyType;

    public VSRequestStrategyBean(JSONObject jSONObject) {
        this.mCmd = jSONObject.optString("cmd", "");
        this.mStrategyType = jSONObject.optInt(KEY_STRATEGY_TYPE, 0);
        this.mErrorCode = jSONObject.optInt("error_code", 0);
        this.mErrorMsg = jSONObject.optString("error_msg", "");
        this.mFrequency = jSONObject.optInt(KEY_FREQUENCY, 0);
        this.mSample = jSONObject.optDouble(KEY_SAMPLE, 0.0d);
        this.mForbiddenCache = jSONObject.optInt(KEY_FORBIDDEN_CACHE, 1);
    }

    private boolean isHitSample() {
        if (Math.random() < this.mSample) {
            RFWLog.w(VSRequestStrategy.TAG, RFWLog.USR, this.mCmd + "\uff1ahit sample strategy");
            return true;
        }
        return false;
    }

    private boolean isLimitFrequency() {
        if (SystemClock.elapsedRealtime() - this.mLastRequestTimeStamp < this.mFrequency) {
            RFWLog.w(VSRequestStrategy.TAG, RFWLog.USR, this.mCmd + "\uff1ahit frequency strategy");
            return true;
        }
        this.mLastRequestTimeStamp = SystemClock.elapsedRealtime();
        return false;
    }

    public boolean forbiddenCache() {
        if (this.mForbiddenCache == 1) {
            return true;
        }
        return false;
    }

    public String getCmd() {
        return this.mCmd;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public String getErrorMsg() {
        return this.mErrorMsg;
    }

    public boolean isForbiddenRequest() {
        int i3 = this.mStrategyType;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return false;
                }
                RFWLog.w(VSRequestStrategy.TAG, RFWLog.USR, this.mCmd + "\uff1ahit reject strategy");
                return true;
            }
            return isLimitFrequency();
        }
        return isHitSample();
    }
}
