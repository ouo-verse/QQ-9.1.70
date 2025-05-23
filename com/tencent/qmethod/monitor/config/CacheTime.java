package com.tencent.qmethod.monitor.config;

import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\t\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qmethod/monitor/config/CacheTime;", "", "cacheTime", "", "(Ljava/lang/String;IJ)V", "getCacheTime", "()J", "ONE_MINUTE", "FIVE_MINUTES", "QUARTER_HOUR", "ONE_HOUR", "ONE_DAY", "ALWAYS", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes22.dex */
public enum CacheTime {
    ONE_MINUTE(60000),
    FIVE_MINUTES(MiniBoxNoticeInfo.MIN_5),
    QUARTER_HOUR(900000),
    ONE_HOUR(3600000),
    ONE_DAY(86400000),
    ALWAYS(0);

    private final long cacheTime;

    CacheTime(long j3) {
        this.cacheTime = j3;
    }

    public final long getCacheTime() {
        return this.cacheTime;
    }
}
