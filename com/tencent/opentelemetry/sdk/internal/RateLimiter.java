package com.tencent.opentelemetry.sdk.internal;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.sdk.common.Clock;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: P */
/* loaded from: classes22.dex */
public class RateLimiter {
    static IPatchRedirector $redirector_;
    private final Clock clock;
    private final double creditsPerNanosecond;
    private final AtomicLong currentBalance;
    private final long maxBalance;

    public RateLimiter(double d16, double d17, Clock clock) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Double.valueOf(d16), Double.valueOf(d17), clock);
            return;
        }
        this.clock = clock;
        double d18 = d16 / 1.0E9d;
        this.creditsPerNanosecond = d18;
        long j3 = (long) (d17 / d18);
        this.maxBalance = j3;
        this.currentBalance = new AtomicLong(clock.nanoTime() - j3);
    }

    public boolean trySpend(double d16) {
        long j3;
        long nanoTime;
        long j16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, Double.valueOf(d16))).booleanValue();
        }
        long j17 = (long) (d16 / this.creditsPerNanosecond);
        do {
            j3 = this.currentBalance.get();
            nanoTime = this.clock.nanoTime();
            long j18 = nanoTime - j3;
            long j19 = this.maxBalance;
            if (j18 > j19) {
                j18 = j19;
            }
            j16 = j18 - j17;
            if (j16 < 0) {
                return false;
            }
        } while (!this.currentBalance.compareAndSet(j3, nanoTime - j16));
        return true;
    }
}
