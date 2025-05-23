package com.tencent.opentelemetry.sdk.trace;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.sdk.common.Clock;
import com.tencent.opentelemetry.sdk.common.CompletableResultCode;
import com.tencent.opentelemetry.sdk.resources.Resource;
import com.tencent.opentelemetry.sdk.trace.samplers.Sampler;
import java.util.List;
import java.util.function.Supplier;
import javax.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes22.dex */
public class TracerSharedState {
    static IPatchRedirector $redirector_;
    private final SpanProcessor activeSpanProcessor;
    private final Clock clock;
    private final IdGenerator idGenerator;
    private final boolean idGeneratorSafeToSkipIdValidation;
    private final Object lock;
    private Resource resource;
    private final Sampler sampler;

    @Nullable
    private volatile CompletableResultCode shutdownResult;
    private final Supplier<SpanLimits> spanLimitsSupplier;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TracerSharedState(Clock clock, IdGenerator idGenerator, Resource resource, Supplier<SpanLimits> supplier, Sampler sampler, List<SpanProcessor> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, clock, idGenerator, resource, supplier, sampler, list);
            return;
        }
        this.lock = new Object();
        this.shutdownResult = null;
        this.clock = clock;
        this.idGenerator = idGenerator;
        this.idGeneratorSafeToSkipIdValidation = idGenerator instanceof RandomIdGenerator;
        this.resource = resource;
        this.spanLimitsSupplier = supplier;
        this.sampler = sampler;
        this.activeSpanProcessor = i.e(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SpanProcessor getActiveSpanProcessor() {
        return this.activeSpanProcessor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Clock getClock() {
        return this.clock;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IdGenerator getIdGenerator() {
        return this.idGenerator;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Resource getResource() {
        return this.resource;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Sampler getSampler() {
        return this.sampler;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SpanLimits getSpanLimits() {
        Object obj;
        obj = this.spanLimitsSupplier.get();
        return (SpanLimits) obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasBeenShutdown() {
        if (this.shutdownResult != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isIdGeneratorSafeToSkipIdValidation() {
        return this.idGeneratorSafeToSkipIdValidation;
    }

    public void reopen() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.shutdownResult = null;
        }
    }

    public void setResource(Resource resource) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) resource);
        } else {
            this.resource = resource;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CompletableResultCode shutdown() {
        synchronized (this.lock) {
            if (this.shutdownResult != null) {
                return this.shutdownResult;
            }
            this.shutdownResult = this.activeSpanProcessor.shutdown();
            return this.shutdownResult;
        }
    }
}
