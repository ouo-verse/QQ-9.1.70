package com.tencent.qqlive.common.ratelimit;

import android.os.SystemClock;

/* compiled from: P */
/* loaded from: classes22.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public String f345200a;

    /* renamed from: b, reason: collision with root package name */
    public b<Long> f345201b;

    /* renamed from: c, reason: collision with root package name */
    public long f345202c;

    public d(String str, int i3) {
        this.f345200a = str;
        this.f345201b = new b<>(i3);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.f345202c = elapsedRealtime;
        this.f345201b.c(Long.valueOf(elapsedRealtime));
    }

    public void a() {
        this.f345201b.a();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.f345202c = elapsedRealtime;
        this.f345201b.c(Long.valueOf(elapsedRealtime));
    }

    public String toString() {
        return "ReqRateBean{cmdKey='" + this.f345200a + "', reqTimestamps=" + this.f345201b + ", lastReqTimestamp=" + this.f345202c + '}';
    }
}
