package com.tencent.icgame.common.ratelimit;

import android.os.SystemClock;

/* compiled from: P */
/* loaded from: classes7.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public String f114854a;

    /* renamed from: b, reason: collision with root package name */
    public b<Long> f114855b;

    /* renamed from: c, reason: collision with root package name */
    public long f114856c;

    public e(String str, int i3) {
        this.f114854a = str;
        this.f114855b = new b<>(i3);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.f114856c = elapsedRealtime;
        this.f114855b.c(Long.valueOf(elapsedRealtime));
    }

    public void a() {
        this.f114855b.a();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.f114856c = elapsedRealtime;
        this.f114855b.c(Long.valueOf(elapsedRealtime));
    }

    public String toString() {
        return "ReqRateBean{cmdKey='" + this.f114854a + "', reqTimestamps=" + this.f114855b + ", lastReqTimestamp=" + this.f114856c + '}';
    }
}
