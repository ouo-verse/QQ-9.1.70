package com.tencent.qmethod.monitor.config;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\t\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qmethod/monitor/config/Silence;", "", "silenceTime", "", "(Ljava/lang/String;IJ)V", "getSilenceTime", "()J", "FIVE_SECOND", "TEN_SECOND", "QUARTER_MINUTE", "HALF_MINUTE", "ONE_MINUTE", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes22.dex */
public enum Silence {
    FIVE_SECOND(5000),
    TEN_SECOND(10000),
    QUARTER_MINUTE(15000),
    HALF_MINUTE(30000),
    ONE_MINUTE(60000);

    private final long silenceTime;

    Silence(long j3) {
        this.silenceTime = j3;
    }

    public final long getSilenceTime() {
        return this.silenceTime;
    }
}
