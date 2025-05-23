package com.tencent.liteav.base.b;

import android.os.SystemClock;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private long f118886a = 0;

    /* renamed from: b, reason: collision with root package name */
    private final long f118887b;

    public a(long j3) {
        this.f118887b = j3;
    }

    public final boolean a() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j3 = this.f118886a;
        if (j3 != 0 && elapsedRealtime - j3 <= this.f118887b) {
            return false;
        }
        this.f118886a = SystemClock.elapsedRealtime();
        return true;
    }
}
