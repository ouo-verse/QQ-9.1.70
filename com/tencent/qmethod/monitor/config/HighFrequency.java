package com.tencent.qmethod.monitor.config;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qmethod/monitor/config/HighFrequency;", "", "durationMillSecond", "", "count", "", "(Ljava/lang/String;IJI)V", "getCount", "()I", "getDurationMillSecond", "()J", "LOWER", "LOW", "MIDDLE", "HIGH", "HIGHER", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes22.dex */
public enum HighFrequency {
    LOWER(86400000, 2),
    LOW(600000, 20),
    MIDDLE(60000, 10),
    HIGH(10000, 10),
    HIGHER(10000, 60);

    private final int count;
    private final long durationMillSecond;

    HighFrequency(long j3, int i3) {
        this.durationMillSecond = j3;
        this.count = i3;
    }

    public final int getCount() {
        return this.count;
    }

    public final long getDurationMillSecond() {
        return this.durationMillSecond;
    }
}
