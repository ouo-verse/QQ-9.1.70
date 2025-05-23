package com.tencent.opentelemetry.sdk.logs;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.sdk.common.Clock;
import com.tencent.opentelemetry.sdk.common.CompletableResultCode;
import com.tencent.opentelemetry.sdk.common.InstrumentationScopeInfo;
import com.tencent.opentelemetry.sdk.internal.ComponentRegistry;
import com.tencent.opentelemetry.sdk.resources.Resource;
import java.io.Closeable;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Supplier;

/* loaded from: classes22.dex */
public final class SdkLogEmitterProvider implements Closeable {
    static IPatchRedirector $redirector_ = null;
    static final String DEFAULT_EMITTER_NAME = "unknown";
    private final ComponentRegistry<SdkLogEmitter> logEmitterComponentRegistry;
    private final LogEmitterSharedState sharedState;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SdkLogEmitterProvider(Resource resource, Supplier<LogLimits> supplier, List<LogProcessor> list, Clock clock) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, resource, supplier, list, clock);
        } else {
            this.sharedState = new LogEmitterSharedState(resource, supplier, list, clock);
            this.logEmitterComponentRegistry = new ComponentRegistry<>(new Function() { // from class: com.tencent.opentelemetry.sdk.logs.c
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    SdkLogEmitter lambda$new$0;
                    lambda$new$0 = SdkLogEmitterProvider.this.lambda$new$0((InstrumentationScopeInfo) obj);
                    return lambda$new$0;
                }
            });
        }
    }

    public static SdkLogEmitterProviderBuilder builder() {
        return new SdkLogEmitterProviderBuilder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ SdkLogEmitter lambda$new$0(InstrumentationScopeInfo instrumentationScopeInfo) {
        return new SdkLogEmitter(this.sharedState, instrumentationScopeInfo);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            shutdown().join(10L, TimeUnit.SECONDS);
        }
    }

    public CompletableResultCode forceFlush() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (CompletableResultCode) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.sharedState.getLogProcessor().forceFlush();
    }

    public LogEmitter get(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LogEmitter) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        return logEmitterBuilder(str).build();
    }

    public LogEmitterBuilder logEmitterBuilder(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (LogEmitterBuilder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        if (str == null || str.isEmpty()) {
            str = "unknown";
        }
        return new SdkLogEmitterBuilder(this.logEmitterComponentRegistry, str);
    }

    public CompletableResultCode shutdown() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (CompletableResultCode) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        if (this.sharedState.hasBeenShutdown()) {
            return CompletableResultCode.ofSuccess();
        }
        return this.sharedState.shutdown();
    }
}
