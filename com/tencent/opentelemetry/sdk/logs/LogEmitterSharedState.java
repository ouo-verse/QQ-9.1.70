package com.tencent.opentelemetry.sdk.logs;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.sdk.common.Clock;
import com.tencent.opentelemetry.sdk.common.CompletableResultCode;
import com.tencent.opentelemetry.sdk.resources.Resource;
import java.util.List;
import java.util.function.Supplier;
import javax.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes22.dex */
final class LogEmitterSharedState {
    static IPatchRedirector $redirector_;
    private final Clock clock;
    private final Object lock;
    private final Supplier<LogLimits> logLimitsSupplier;
    private final LogProcessor logProcessor;
    private final Resource resource;

    @Nullable
    private volatile CompletableResultCode shutdownResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LogEmitterSharedState(Resource resource, Supplier<LogLimits> supplier, List<LogProcessor> list, Clock clock) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, resource, supplier, list, clock);
            return;
        }
        this.lock = new Object();
        this.shutdownResult = null;
        this.resource = resource;
        this.logLimitsSupplier = supplier;
        this.logProcessor = b.d(list);
        this.clock = clock;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Clock getClock() {
        return this.clock;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LogLimits getLogLimits() {
        Object obj;
        obj = this.logLimitsSupplier.get();
        return (LogLimits) obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LogProcessor getLogProcessor() {
        return this.logProcessor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Resource getResource() {
        return this.resource;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasBeenShutdown() {
        if (this.shutdownResult != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CompletableResultCode shutdown() {
        synchronized (this.lock) {
            if (this.shutdownResult != null) {
                return this.shutdownResult;
            }
            this.shutdownResult = this.logProcessor.shutdown();
            return this.shutdownResult;
        }
    }
}
