package com.tencent.opentelemetry.sdk.internal;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.sdk.common.Clock;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.ThreadSafe;

/* compiled from: P */
@ThreadSafe
/* loaded from: classes22.dex */
public final class SystemClock implements Clock {
    static IPatchRedirector $redirector_;
    private static final SystemClock INSTANCE;
    public d3.b kronosClock;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9428);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new SystemClock();
        }
    }

    SystemClock() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static SystemClock getInstance() {
        return INSTANCE;
    }

    private Long getServerOffsetNanos() {
        return Long.valueOf(TimeUnit.MILLISECONDS.toNanos(Long.valueOf(this.kronosClock.a()).longValue() - Long.valueOf(System.currentTimeMillis()).longValue()));
    }

    @Override // com.tencent.opentelemetry.sdk.common.Clock
    public long nanoTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        if (this.kronosClock != null) {
            return System.nanoTime() + getServerOffsetNanos().longValue();
        }
        return System.nanoTime();
    }

    @Override // com.tencent.opentelemetry.sdk.common.Clock
    public long now() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
        }
        d3.b bVar = this.kronosClock;
        if (bVar != null) {
            return TimeUnit.MILLISECONDS.toNanos(bVar.a());
        }
        return JavaVersionSpecific.get().currentTimeNanos();
    }
}
