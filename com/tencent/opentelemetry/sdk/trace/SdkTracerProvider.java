package com.tencent.opentelemetry.sdk.trace;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.api.logging.DefaultPrintLogger;
import com.tencent.opentelemetry.api.trace.Tracer;
import com.tencent.opentelemetry.api.trace.TracerBuilder;
import com.tencent.opentelemetry.api.trace.TracerProvider;
import com.tencent.opentelemetry.sdk.common.Clock;
import com.tencent.opentelemetry.sdk.common.CompletableResultCode;
import com.tencent.opentelemetry.sdk.common.InstrumentationScopeInfo;
import com.tencent.opentelemetry.sdk.internal.ComponentRegistry;
import com.tencent.opentelemetry.sdk.resources.Resource;
import com.tencent.opentelemetry.sdk.trace.samplers.Sampler;
import java.io.Closeable;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Supplier;
import javax.annotation.Nullable;

/* loaded from: classes22.dex */
public final class SdkTracerProvider implements TracerProvider, Closeable {
    static IPatchRedirector $redirector_ = null;
    static final String DEFAULT_TRACER_NAME = "";
    private static final String TAG;
    private final TracerSharedState sharedState;
    private final ComponentRegistry<SdkTracer> tracerSdkComponentRegistry;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11841);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            TAG = SdkTracerProvider.class.getName();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SdkTracerProvider(Clock clock, IdGenerator idGenerator, Resource resource, Supplier<SpanLimits> supplier, Sampler sampler, List<SpanProcessor> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, clock, idGenerator, resource, supplier, sampler, list);
        } else {
            this.sharedState = new TracerSharedState(clock, idGenerator, resource, supplier, sampler, list);
            this.tracerSdkComponentRegistry = new ComponentRegistry<>(new Function() { // from class: com.tencent.opentelemetry.sdk.trace.f
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    SdkTracer lambda$new$0;
                    lambda$new$0 = SdkTracerProvider.this.lambda$new$0((InstrumentationScopeInfo) obj);
                    return lambda$new$0;
                }
            });
        }
    }

    public static SdkTracerProviderBuilder builder() {
        return new SdkTracerProviderBuilder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ SdkTracer lambda$new$0(InstrumentationScopeInfo instrumentationScopeInfo) {
        return new SdkTracer(this.sharedState, instrumentationScopeInfo);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            shutdown().join(10L, TimeUnit.SECONDS);
        }
    }

    public CompletableResultCode forceFlush() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (CompletableResultCode) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.sharedState.getActiveSpanProcessor().forceFlush();
    }

    @Override // com.tencent.opentelemetry.api.trace.TracerProvider
    public Tracer get(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? tracerBuilder(str).build() : (Tracer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
    }

    public Sampler getSampler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Sampler) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.sharedState.getSampler();
    }

    public SpanLimits getSpanLimits() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (SpanLimits) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.sharedState.getSpanLimits();
    }

    public void reopen() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            this.sharedState.reopen();
            this.sharedState.getActiveSpanProcessor().reopen();
        }
    }

    public void setResource(Resource resource) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) resource);
        } else {
            this.sharedState.setResource(resource);
        }
    }

    public CompletableResultCode shutdown() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (CompletableResultCode) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        if (this.sharedState.hasBeenShutdown()) {
            if (DefaultPrintLogger.isDebug()) {
                DefaultPrintLogger.w(TAG, "Calling shutdown() multiple times.");
            }
            return CompletableResultCode.ofSuccess();
        }
        return this.sharedState.shutdown();
    }

    @Override // com.tencent.opentelemetry.api.trace.TracerProvider
    public TracerBuilder tracerBuilder(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (TracerBuilder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        if (str == null || str.isEmpty()) {
            if (DefaultPrintLogger.isDebug()) {
                DefaultPrintLogger.d(TAG, "Tracer requested without instrumentation name.");
            }
            str = "";
        }
        return new SdkTracerBuilder(this.tracerSdkComponentRegistry, str);
    }

    @Override // com.tencent.opentelemetry.api.trace.TracerProvider
    public Tracer get(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? tracerBuilder(str).setInstrumentationVersion(str2).build() : (Tracer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
    }
}
