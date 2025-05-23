package com.tencent.opentelemetry.sdk.trace;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.sdk.common.Clock;
import javax.annotation.concurrent.Immutable;

/* compiled from: P */
@Immutable
/* loaded from: classes22.dex */
public class AnchoredClock {
    static IPatchRedirector $redirector_;
    private final Clock clock;
    private final long epochNanos;
    private final long nanoTime;

    AnchoredClock(Clock clock, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, clock, Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        this.clock = clock;
        this.epochNanos = j3;
        this.nanoTime = j16;
    }

    public static AnchoredClock create(Clock clock) {
        return new AnchoredClock(clock, clock.now(), clock.nanoTime());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long now() {
        return this.epochNanos + (this.clock.nanoTime() - this.nanoTime);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long startTime() {
        return this.epochNanos;
    }
}
