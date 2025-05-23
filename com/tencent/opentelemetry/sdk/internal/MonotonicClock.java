package com.tencent.opentelemetry.sdk.internal;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.sdk.common.Clock;
import javax.annotation.concurrent.Immutable;

/* compiled from: P */
@Immutable
/* loaded from: classes22.dex */
public final class MonotonicClock implements Clock {
    static IPatchRedirector $redirector_;
    private final Clock clock;
    private final long epochNanos;
    private final long nanoTime;

    MonotonicClock(Clock clock, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, clock, Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        this.clock = clock;
        this.epochNanos = j3;
        this.nanoTime = j16;
    }

    public static MonotonicClock create(Clock clock) {
        return new MonotonicClock(clock, clock.now(), clock.nanoTime());
    }

    @Override // com.tencent.opentelemetry.sdk.common.Clock
    public long nanoTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return this.clock.nanoTime();
    }

    @Override // com.tencent.opentelemetry.sdk.common.Clock
    public long now() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
        }
        return this.epochNanos + (this.clock.nanoTime() - this.nanoTime);
    }
}
