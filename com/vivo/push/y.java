package com.vivo.push;

import android.os.SystemClock;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    private volatile long f387943a = -1;

    public final synchronized boolean a() {
        boolean z16;
        long j3 = this.f387943a;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (j3 != -1 && elapsedRealtime > j3 && elapsedRealtime < j3 + 2000) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f387943a = SystemClock.elapsedRealtime();
        return z16;
    }
}
