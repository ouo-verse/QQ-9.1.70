package com.tencent.opentelemetry.context;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes22.dex */
class ContextScheduledExecutorService extends ContextExecutorService implements ScheduledExecutorService {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ContextScheduledExecutorService(Context context, ScheduledExecutorService scheduledExecutorService) {
        super(context, scheduledExecutorService);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) scheduledExecutorService);
        }
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> schedule(Runnable runnable, long j3, TimeUnit timeUnit) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? delegate().schedule(context().wrap(runnable), j3, timeUnit) : (ScheduledFuture) iPatchRedirector.redirect((short) 2, this, runnable, Long.valueOf(j3), timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j3, long j16, TimeUnit timeUnit) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ScheduledFuture) iPatchRedirector.redirect((short) 4, this, runnable, Long.valueOf(j3), Long.valueOf(j16), timeUnit);
        }
        return delegate().scheduleAtFixedRate(context().wrap(runnable), j3, j16, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j3, long j16, TimeUnit timeUnit) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ScheduledFuture) iPatchRedirector.redirect((short) 5, this, runnable, Long.valueOf(j3), Long.valueOf(j16), timeUnit);
        }
        return delegate().scheduleWithFixedDelay(context().wrap(runnable), j3, j16, timeUnit);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.opentelemetry.context.ForwardingExecutorService
    public ScheduledExecutorService delegate() {
        return (ScheduledExecutorService) super.delegate();
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public <V> ScheduledFuture<V> schedule(Callable<V> callable, long j3, TimeUnit timeUnit) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? delegate().schedule(context().wrap(callable), j3, timeUnit) : (ScheduledFuture) iPatchRedirector.redirect((short) 3, this, callable, Long.valueOf(j3), timeUnit);
    }
}
