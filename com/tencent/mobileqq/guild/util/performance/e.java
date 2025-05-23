package com.tencent.mobileqq.guild.util.performance;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0005\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\b\u001a\u00020\u0007R\u0014\u0010\n\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\tR\u0016\u0010\f\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u000bR\u0016\u0010\r\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/util/performance/e;", "", "", "b", "d", "", "a", "", "c", "I", "sensorId", "J", "usedTime", "startTime", "<init>", "(I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int sensorId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long usedTime;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long startTime;

    public e(int i3) {
        this.sensorId = i3;
    }

    /* renamed from: a, reason: from getter */
    public final int getSensorId() {
        return this.sensorId;
    }

    public final void b() {
        this.startTime = System.currentTimeMillis();
    }

    public final long c() {
        long j3 = this.usedTime;
        long currentTimeMillis = System.currentTimeMillis();
        long j16 = this.startTime;
        if (j16 != 0) {
            j3 += currentTimeMillis - j16;
            this.startTime = currentTimeMillis;
        }
        this.usedTime = 0L;
        return j3;
    }

    public final void d() {
        this.usedTime += System.currentTimeMillis() - this.startTime;
        this.startTime = 0L;
    }
}
