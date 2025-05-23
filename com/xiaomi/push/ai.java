package com.xiaomi.push;

import com.tencent.mobileqq.perf.block.LockMethodProxy;
import java.util.concurrent.Callable;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ai<T> {

    /* renamed from: a, reason: collision with root package name */
    private final long f388169a;

    /* renamed from: b, reason: collision with root package name */
    private long f388170b;

    /* renamed from: c, reason: collision with root package name */
    private long f388171c;

    /* renamed from: d, reason: collision with root package name */
    private long f388172d;

    /* renamed from: e, reason: collision with root package name */
    private long f388173e;

    /* renamed from: f, reason: collision with root package name */
    private long f388174f;

    /* renamed from: g, reason: collision with root package name */
    private long f388175g;

    /* renamed from: h, reason: collision with root package name */
    private long f388176h;

    /* renamed from: i, reason: collision with root package name */
    private final long f388177i;

    public ai(long j3, long j16) {
        this.f388177i = j3 * 1000000;
        this.f388169a = j16;
    }

    public long a() {
        return this.f388171c;
    }

    public T b(Callable<T> callable) {
        T t16;
        long j3 = this.f388170b;
        long j16 = this.f388177i;
        if (j3 > j16) {
            long j17 = (j3 / j16) * this.f388169a;
            this.f388170b = 0L;
            if (j17 > 0) {
                try {
                    LockMethodProxy.sleep(j17);
                } catch (Exception unused) {
                }
            }
        }
        long nanoTime = System.nanoTime();
        if (this.f388175g <= 0) {
            this.f388175g = nanoTime;
        }
        try {
            t16 = callable.call();
        } catch (Exception e16) {
            e16.printStackTrace();
            t16 = null;
        }
        long nanoTime2 = System.nanoTime() - nanoTime;
        this.f388176h = System.nanoTime();
        this.f388173e++;
        if (this.f388171c < nanoTime2) {
            this.f388171c = nanoTime2;
        }
        if (nanoTime2 > 0) {
            this.f388174f += nanoTime2;
            long j18 = this.f388172d;
            if (j18 == 0 || j18 > nanoTime2) {
                this.f388172d = nanoTime2;
            }
        }
        this.f388170b += Math.max(nanoTime2, 0L);
        return t16;
    }

    public long c() {
        return this.f388172d;
    }

    public long d() {
        long j3 = this.f388174f;
        if (j3 > 0) {
            long j16 = this.f388173e;
            if (j16 > 0) {
                return j3 / j16;
            }
        }
        return 0L;
    }

    public long e() {
        long j3 = this.f388176h;
        long j16 = this.f388175g;
        if (j3 > j16) {
            return j3 - j16;
        }
        return 0L;
    }
}
