package com.tencent.luggage.wxa.n0;

import com.tencent.mobileqq.perf.block.LockMethodProxy;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public long f135100a;

    /* renamed from: b, reason: collision with root package name */
    public long f135101b;

    /* renamed from: c, reason: collision with root package name */
    public volatile long f135102c = -9223372036854775807L;

    public s(long j3) {
        d(j3);
    }

    public long a() {
        return this.f135100a;
    }

    public long b() {
        if (this.f135102c != -9223372036854775807L) {
            return this.f135102c;
        }
        long j3 = this.f135100a;
        if (j3 != Long.MAX_VALUE) {
            return j3;
        }
        return -9223372036854775807L;
    }

    public long c() {
        if (this.f135100a == Long.MAX_VALUE) {
            return 0L;
        }
        if (this.f135102c == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return this.f135101b;
    }

    public synchronized void d(long j3) {
        a.b(this.f135102c == -9223372036854775807L);
        this.f135100a = j3;
    }

    public synchronized void e() {
        while (this.f135102c == -9223372036854775807L) {
            LockMethodProxy.wait(this);
        }
    }

    public static long c(long j3) {
        return (j3 * 1000000) / 90000;
    }

    public long a(long j3) {
        if (j3 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.f135102c != -9223372036854775807L) {
            this.f135102c = j3;
        } else {
            long j16 = this.f135100a;
            if (j16 != Long.MAX_VALUE) {
                this.f135101b = j16 - j3;
            }
            synchronized (this) {
                this.f135102c = j3;
                notifyAll();
            }
        }
        return j3 + this.f135101b;
    }

    public long b(long j3) {
        if (j3 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.f135102c != -9223372036854775807L) {
            long e16 = e(this.f135102c);
            long j16 = (4294967296L + e16) / 8589934592L;
            long j17 = ((j16 - 1) * 8589934592L) + j3;
            j3 += j16 * 8589934592L;
            if (Math.abs(j17 - e16) < Math.abs(j3 - e16)) {
                j3 = j17;
            }
        }
        return a(c(j3));
    }

    public static long e(long j3) {
        return (j3 * 90000) / 1000000;
    }

    public void d() {
        this.f135102c = -9223372036854775807L;
    }
}
