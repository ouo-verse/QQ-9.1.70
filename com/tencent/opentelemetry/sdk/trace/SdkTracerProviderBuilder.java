package com.tencent.opentelemetry.sdk.trace;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.sdk.common.Clock;
import com.tencent.opentelemetry.sdk.internal.SystemClock;
import com.tencent.opentelemetry.sdk.resources.Resource;
import com.tencent.opentelemetry.sdk.trace.samplers.Sampler;
import com.tencent.qqlive.module.videoreport.sample.interceptor.BaseSampleInterceptor;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

/* loaded from: classes22.dex */
public final class SdkTracerProviderBuilder {
    static IPatchRedirector $redirector_;
    private static final Sampler DEFAULT_SAMPLER;
    private Clock clock;
    private IdGenerator idsGenerator;
    private Resource resource;
    private Sampler sampler;
    private Supplier<SpanLimits> spanLimitsSupplier;
    private final List<SpanProcessor> spanProcessors;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11835);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            DEFAULT_SAMPLER = com.tencent.opentelemetry.sdk.trace.samplers.a.c(com.tencent.opentelemetry.sdk.trace.samplers.a.b());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SdkTracerProviderBuilder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        this.spanProcessors = new ArrayList();
        this.clock = SystemClock.getInstance();
        this.idsGenerator = c.a();
        this.resource = Resource.getDefault();
        this.spanLimitsSupplier = new Supplier() { // from class: com.tencent.opentelemetry.sdk.trace.g
            @Override // java.util.function.Supplier
            public final Object get() {
                return SpanLimits.getDefault();
            }
        };
        this.sampler = DEFAULT_SAMPLER;
    }

    public SdkTracerProviderBuilder addSpanProcessor(SpanProcessor spanProcessor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (SdkTracerProviderBuilder) iPatchRedirector.redirect((short) 7, (Object) this, (Object) spanProcessor);
        }
        this.spanProcessors.add(spanProcessor);
        return this;
    }

    public SdkTracerProvider build() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (SdkTracerProvider) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return new SdkTracerProvider(this.clock, this.idsGenerator, this.resource, this.spanLimitsSupplier, this.sampler, this.spanProcessors);
    }

    public SdkTracerProviderBuilder setClock(Clock clock) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (SdkTracerProviderBuilder) iPatchRedirector.redirect((short) 1, (Object) this, (Object) clock);
        }
        Objects.requireNonNull(clock, "clock");
        this.clock = clock;
        return this;
    }

    public SdkTracerProviderBuilder setIdGenerator(IdGenerator idGenerator) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SdkTracerProviderBuilder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) idGenerator);
        }
        Objects.requireNonNull(idGenerator, "idGenerator");
        this.idsGenerator = idGenerator;
        return this;
    }

    public SdkTracerProviderBuilder setResource(Resource resource) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (SdkTracerProviderBuilder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) resource);
        }
        Objects.requireNonNull(resource, "resource");
        this.resource = resource;
        return this;
    }

    public SdkTracerProviderBuilder setSampler(Sampler sampler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (SdkTracerProviderBuilder) iPatchRedirector.redirect((short) 6, (Object) this, (Object) sampler);
        }
        Objects.requireNonNull(sampler, BaseSampleInterceptor.SAMPLE_TAG);
        this.sampler = sampler;
        return this;
    }

    public SdkTracerProviderBuilder setSpanLimits(final SpanLimits spanLimits) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (SdkTracerProviderBuilder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) spanLimits);
        }
        Objects.requireNonNull(spanLimits, "spanLimits");
        this.spanLimitsSupplier = new Supplier() { // from class: com.tencent.opentelemetry.sdk.trace.h
            @Override // java.util.function.Supplier
            public final Object get() {
                SpanLimits lambda$setSpanLimits$0;
                lambda$setSpanLimits$0 = SdkTracerProviderBuilder.lambda$setSpanLimits$0(SpanLimits.this);
                return lambda$setSpanLimits$0;
            }
        };
        return this;
    }

    public SdkTracerProviderBuilder setSpanLimits(Supplier<SpanLimits> supplier) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (SdkTracerProviderBuilder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) supplier);
        }
        Objects.requireNonNull(supplier, "spanLimitsSupplier");
        this.spanLimitsSupplier = supplier;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ SpanLimits lambda$setSpanLimits$0(SpanLimits spanLimits) {
        return spanLimits;
    }
}
