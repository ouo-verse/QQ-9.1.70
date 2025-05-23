package com.tencent.bugly.network;

import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.rmonitor.base.config.data.m;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class NetQualityPluginConfig extends m {
    public static final int DEFAULT_CACHE_SIZE = 5000;
    public static final long DEFAULT_CALL_END_DELAY = 600000;
    public static final long MAX_CALL_END_DELAY_IN_SEC = 14400;
    public static final int MAX_VALID_BATCH_COUNT = 1000;
    public static final int MIN_CACHE_SIZE = 500;
    public static final long MIN_CALL_END_DELAY_IN_SEC = 600;
    public static final long ONE_SEC_IN_MS = 1000;
    public int cacheSize;
    public long callEndDelayOther;
    public long callEndDelayWhenFail;
    public long callEndDelayWhenSuccess;
    public int maxBatchCount;
    public int minBatchCount;

    public NetQualityPluginConfig() {
        super(BuglyMonitorName.NET_QUALITY, false, 1000, 1.0f, 0.0f, 100);
        this.callEndDelayWhenSuccess = 600000L;
        this.callEndDelayWhenFail = 600000L;
        this.callEndDelayOther = 600000L;
        this.maxBatchCount = 100;
        this.minBatchCount = 50;
        this.cacheSize = 5000;
    }

    protected void parseConfigItemOfBatch(JSONObject jSONObject) {
        int optInt;
        int optInt2;
        if (jSONObject.has("max_batch_count") && (optInt2 = jSONObject.optInt("max_batch_count")) > 0 && optInt2 <= 1000) {
            this.maxBatchCount = optInt2;
        }
        if (jSONObject.has("min_batch_count") && (optInt = jSONObject.optInt("min_batch_count")) > 0 && optInt <= 1000) {
            this.minBatchCount = optInt;
        }
        int i3 = this.minBatchCount;
        int i16 = this.maxBatchCount;
        if (i3 > i16) {
            this.minBatchCount = i16;
        }
    }

    protected void parseConfigItemOfCallEnd(JSONObject jSONObject) {
        if (jSONObject.has("call_end_delay_when_success")) {
            long optLong = jSONObject.optLong("call_end_delay_when_success");
            if (optLong >= 600 && optLong <= MAX_CALL_END_DELAY_IN_SEC) {
                this.callEndDelayWhenSuccess = optLong * 1000;
            }
        }
        if (jSONObject.has("call_end_delay_when_fail")) {
            long optLong2 = jSONObject.optLong("call_end_delay_when_fail");
            if (optLong2 >= 600 && optLong2 <= MAX_CALL_END_DELAY_IN_SEC) {
                this.callEndDelayWhenFail = optLong2 * 1000;
            }
        }
        if (jSONObject.has("call_end_delay_other")) {
            long optLong3 = jSONObject.optLong("call_end_delay_other");
            if (optLong3 >= 600 && optLong3 <= MAX_CALL_END_DELAY_IN_SEC) {
                this.callEndDelayOther = optLong3 * 1000;
            }
        }
    }

    @Override // com.tencent.rmonitor.base.config.data.m, com.tencent.rmonitor.base.config.h
    public void parsePluginConfig(JSONObject jSONObject) {
        int optInt;
        super.parsePluginConfig(jSONObject);
        parseConfigItemOfCallEnd(jSONObject);
        parseConfigItemOfBatch(jSONObject);
        if (jSONObject.has("cache_size") && (optInt = jSONObject.optInt("cache_size")) >= 500) {
            this.cacheSize = optInt;
        }
    }

    public String toString() {
        return "{callEndDelayWhenSuccess: " + this.callEndDelayWhenSuccess + ", callEndDelayWhenFail: " + this.callEndDelayWhenFail + ", callEndDelayOther: " + this.callEndDelayOther + ", maxBatchCount: " + this.maxBatchCount + ", minBatchCount: " + this.minBatchCount + ", cacheSize: " + this.cacheSize + "}";
    }

    @Override // com.tencent.rmonitor.base.config.data.m
    public void update(m mVar) {
        super.update(mVar);
        if (mVar instanceof NetQualityPluginConfig) {
            NetQualityPluginConfig netQualityPluginConfig = (NetQualityPluginConfig) mVar;
            this.callEndDelayWhenSuccess = netQualityPluginConfig.callEndDelayWhenSuccess;
            this.callEndDelayWhenFail = netQualityPluginConfig.callEndDelayWhenFail;
            this.callEndDelayOther = netQualityPluginConfig.callEndDelayOther;
            this.maxBatchCount = netQualityPluginConfig.maxBatchCount;
            this.minBatchCount = netQualityPluginConfig.minBatchCount;
            this.cacheSize = netQualityPluginConfig.cacheSize;
        }
    }

    @Override // com.tencent.rmonitor.base.config.data.m
    /* renamed from: clone */
    public NetQualityPluginConfig mo105clone() {
        return new NetQualityPluginConfig(this);
    }

    public NetQualityPluginConfig(NetQualityPluginConfig netQualityPluginConfig) {
        super(netQualityPluginConfig);
        this.callEndDelayWhenSuccess = 600000L;
        this.callEndDelayWhenFail = 600000L;
        this.callEndDelayOther = 600000L;
        this.maxBatchCount = 100;
        this.minBatchCount = 50;
        this.cacheSize = 5000;
        update(netQualityPluginConfig);
    }
}
