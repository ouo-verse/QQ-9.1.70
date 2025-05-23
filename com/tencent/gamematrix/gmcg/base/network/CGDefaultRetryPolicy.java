package com.tencent.gamematrix.gmcg.base.network;

import com.android.volley.NoConnectionError;
import com.android.volley.VolleyError;
import com.android.volley.j;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmcg.base.utils.CGAppUtil;
import com.tencent.mobileqq.perf.block.LockMethodProxy;

/* loaded from: classes6.dex */
public class CGDefaultRetryPolicy implements j {
    public static final float DEFAULT_BACKOFF_MULT = 1.0f;
    public static final int DEFAULT_MAX_RETRIES = 3;
    public static final int DEFAULT_NO_NETWORK_TIMEOUT_MS = 500;
    public static final int DEFAULT_TIMEOUT_MS = 20000;
    private final float mBackoffMultiplier;
    private int mCurrentRetryCount;
    private int mCurrentTimeoutMs;
    private final int mMaxNumRetries;
    private final float mNoNetWorkBackoffMultiplier;
    private int mNoNetworkBackOffTimeoutMs;

    public CGDefaultRetryPolicy() {
        this(20000, 3, 1.0f);
    }

    public float getBackoffMultiplier() {
        return this.mBackoffMultiplier;
    }

    @Override // com.android.volley.j
    public int getCurrentRetryCount() {
        return this.mCurrentRetryCount;
    }

    @Override // com.android.volley.j
    public int getCurrentTimeout() {
        return this.mCurrentTimeoutMs;
    }

    protected boolean hasAttemptRemaining() {
        if (this.mCurrentRetryCount <= this.mMaxNumRetries) {
            return true;
        }
        return false;
    }

    @Override // com.android.volley.j
    public void retry(VolleyError volleyError) throws VolleyError {
        this.mCurrentRetryCount++;
        int i3 = this.mCurrentTimeoutMs;
        this.mCurrentTimeoutMs = i3 + ((int) (i3 * this.mBackoffMultiplier));
        if (hasAttemptRemaining()) {
            if ((volleyError instanceof NoConnectionError) && !CGAppUtil.isOnMainThread()) {
                int i16 = this.mNoNetworkBackOffTimeoutMs;
                this.mNoNetworkBackOffTimeoutMs = i16 + ((int) (i16 * 2.0f));
                CGLog.i("retry NoConnectionError: " + volleyError.getMessage() + ", mNoNetworkBackOffTimeoutMs: " + this.mNoNetworkBackOffTimeoutMs);
                try {
                    LockMethodProxy.sleep(this.mNoNetworkBackOffTimeoutMs);
                    return;
                } catch (InterruptedException e16) {
                    e16.printStackTrace();
                    return;
                }
            }
            return;
        }
        throw volleyError;
    }

    public CGDefaultRetryPolicy(int i3, int i16, float f16) {
        this.mNoNetworkBackOffTimeoutMs = 500;
        this.mNoNetWorkBackoffMultiplier = 2.0f;
        this.mCurrentTimeoutMs = i3;
        this.mMaxNumRetries = i16;
        this.mBackoffMultiplier = f16;
    }
}
