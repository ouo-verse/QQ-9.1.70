package com.tencent.opentelemetry.sdk.internal;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.sdk.common.Clock;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ThrottlingLogger {
    static IPatchRedirector $redirector_ = null;
    private static final double RATE_LIMIT = 5.0d;
    private static final double THROTTLED_RATE_LIMIT = 1.0d;
    private static final TimeUnit rateTimeUnit;
    private final Logger delegate;
    private final RateLimiter fastRateLimiter;
    private final AtomicBoolean throttled;
    private final RateLimiter throttledRateLimiter;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9370);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            rateTimeUnit = TimeUnit.MINUTES;
        }
    }

    public ThrottlingLogger(Logger logger) {
        this(logger, SystemClock.getInstance());
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) logger);
    }

    private void doLog(Level level, String str, @Nullable Throwable th5) {
        if (th5 != null) {
            this.delegate.log(level, str, th5);
        } else {
            this.delegate.log(level, str);
        }
    }

    public boolean isLoggable(Level level) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) level)).booleanValue();
        }
        return this.delegate.isLoggable(level);
    }

    public void log(Level level, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            log(level, str, null);
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) level, (Object) str);
        }
    }

    ThrottlingLogger(Logger logger, Clock clock) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) logger, (Object) clock);
            return;
        }
        this.throttled = new AtomicBoolean(false);
        this.delegate = logger;
        TimeUnit timeUnit = rateTimeUnit;
        this.fastRateLimiter = new RateLimiter(RATE_LIMIT / timeUnit.toSeconds(1L), RATE_LIMIT, clock);
        this.throttledRateLimiter = new RateLimiter(RATE_LIMIT / timeUnit.toSeconds(1L), 1.0d, clock);
    }

    public void log(Level level, String str, @Nullable Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, level, str, th5);
            return;
        }
        if (isLoggable(level)) {
            if (this.throttled.get()) {
                if (this.throttledRateLimiter.trySpend(1.0d)) {
                    doLog(level, str, th5);
                }
            } else if (this.fastRateLimiter.trySpend(1.0d)) {
                doLog(level, str, th5);
            } else if (this.throttled.compareAndSet(false, true)) {
                this.throttledRateLimiter.trySpend(1.0d);
                this.delegate.log(level, "Too many log messages detected. Will only log once per minute from now on.");
                doLog(level, str, th5);
            }
        }
    }
}
