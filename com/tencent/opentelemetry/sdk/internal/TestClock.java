package com.tencent.opentelemetry.sdk.internal;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.sdk.common.Clock;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.ThreadSafe;

/* compiled from: P */
@ThreadSafe
/* loaded from: classes22.dex */
public final class TestClock implements Clock {
    static IPatchRedirector $redirector_;
    private long currentEpochNanos;

    TestClock(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, j3);
        } else {
            this.currentEpochNanos = j3;
        }
    }

    public static TestClock create() {
        return create(TimeUnit.MILLISECONDS.toNanos(1557212400000L));
    }

    public synchronized void advanceMillis(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, j3);
        } else {
            this.currentEpochNanos += TimeUnit.MILLISECONDS.toNanos(j3);
        }
    }

    public synchronized void advanceNanos(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, j3);
        } else {
            this.currentEpochNanos += j3;
        }
    }

    @Override // com.tencent.opentelemetry.sdk.common.Clock
    public synchronized long nanoTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
        }
        return this.currentEpochNanos;
    }

    @Override // com.tencent.opentelemetry.sdk.common.Clock
    public synchronized long now() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
        }
        return this.currentEpochNanos;
    }

    public synchronized void setTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, j3);
        } else {
            this.currentEpochNanos = j3;
        }
    }

    public static TestClock create(long j3) {
        return new TestClock(j3);
    }
}
