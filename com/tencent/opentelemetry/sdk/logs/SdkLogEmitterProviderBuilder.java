package com.tencent.opentelemetry.sdk.logs;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.sdk.common.Clock;
import com.tencent.opentelemetry.sdk.resources.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

/* loaded from: classes22.dex */
public class SdkLogEmitterProviderBuilder {
    static IPatchRedirector $redirector_;
    private Clock clock;
    private Supplier<LogLimits> logLimitsSupplier;
    private final List<LogProcessor> logProcessors;
    private Resource resource;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SdkLogEmitterProviderBuilder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.logProcessors = new ArrayList();
        this.resource = Resource.getDefault();
        this.logLimitsSupplier = new Supplier() { // from class: com.tencent.opentelemetry.sdk.logs.d
            @Override // java.util.function.Supplier
            public final Object get() {
                return LogLimits.getDefault();
            }
        };
        this.clock = com.tencent.opentelemetry.sdk.common.a.a();
    }

    public SdkLogEmitterProviderBuilder addLogProcessor(LogProcessor logProcessor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (SdkLogEmitterProviderBuilder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) logProcessor);
        }
        Objects.requireNonNull(logProcessor, "processor");
        this.logProcessors.add(logProcessor);
        return this;
    }

    public SdkLogEmitterProvider build() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (SdkLogEmitterProvider) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return new SdkLogEmitterProvider(this.resource, this.logLimitsSupplier, this.logProcessors, this.clock);
    }

    public SdkLogEmitterProviderBuilder setClock(Clock clock) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (SdkLogEmitterProviderBuilder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) clock);
        }
        Objects.requireNonNull(clock, "clock");
        this.clock = clock;
        return this;
    }

    public SdkLogEmitterProviderBuilder setLogLimits(Supplier<LogLimits> supplier) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (SdkLogEmitterProviderBuilder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) supplier);
        }
        Objects.requireNonNull(supplier, "logLimitsSupplier");
        this.logLimitsSupplier = supplier;
        return this;
    }

    public SdkLogEmitterProviderBuilder setResource(Resource resource) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SdkLogEmitterProviderBuilder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) resource);
        }
        Objects.requireNonNull(resource, "resource");
        this.resource = resource;
        return this;
    }
}
