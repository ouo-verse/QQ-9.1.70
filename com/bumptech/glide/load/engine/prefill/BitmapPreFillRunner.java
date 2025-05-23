package com.bumptech.glide.load.engine.prefill;

import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.VisibleForTesting;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
final class BitmapPreFillRunner implements Runnable {

    /* renamed from: h, reason: collision with root package name */
    private static final a f31749h = new a();

    /* renamed from: i, reason: collision with root package name */
    static final long f31750i = TimeUnit.SECONDS.toMillis(1);

    /* renamed from: d, reason: collision with root package name */
    private final a f31751d;

    /* renamed from: e, reason: collision with root package name */
    private final Handler f31752e;

    /* renamed from: f, reason: collision with root package name */
    private long f31753f;

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: classes.dex */
    public static class a {
        a() {
        }

        long a() {
            return SystemClock.currentThreadTimeMillis();
        }
    }

    private long f() {
        long j3 = this.f31753f;
        this.f31753f = Math.min(4 * j3, f31750i);
        return j3;
    }

    @VisibleForTesting
    boolean e() {
        this.f31751d.a();
        throw null;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (e()) {
            this.f31752e.postDelayed(this, f());
        }
    }
}
