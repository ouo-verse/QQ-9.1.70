package com.tencent.opentelemetry.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.api.trace.Tracer;
import com.tencent.opentelemetry.api.trace.TracerBuilder;
import com.tencent.opentelemetry.api.trace.TracerProvider;
import com.tencent.opentelemetry.context.propagation.ContextPropagators;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

/* compiled from: P */
/* loaded from: classes22.dex */
public class GlobalOpenTelemetry {
    static IPatchRedirector $redirector_;
    private static final String TAG;

    @Nullable
    private static volatile ObfuscatedOpenTelemetry globalOpenTelemetry;
    private static final Object mutex;

    @Nullable
    private static Throwable setGlobalCaller;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @ThreadSafe
    /* loaded from: classes22.dex */
    public static class ObfuscatedOpenTelemetry implements OpenTelemetry {
        static IPatchRedirector $redirector_;
        private final OpenTelemetry delegate;

        ObfuscatedOpenTelemetry(OpenTelemetry openTelemetry) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) openTelemetry);
            } else {
                this.delegate = openTelemetry;
            }
        }

        @Override // com.tencent.opentelemetry.api.OpenTelemetry
        public ContextPropagators getPropagators() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (ContextPropagators) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.delegate.getPropagators();
        }

        @Override // com.tencent.opentelemetry.api.OpenTelemetry
        public /* synthetic */ Tracer getTracer(String str) {
            return a.a(this, str);
        }

        @Override // com.tencent.opentelemetry.api.OpenTelemetry
        public TracerProvider getTracerProvider() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (TracerProvider) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.delegate.getTracerProvider();
        }

        @Override // com.tencent.opentelemetry.api.OpenTelemetry
        public /* synthetic */ TracerBuilder tracerBuilder(String str) {
            return a.c(this, str);
        }

        @Override // com.tencent.opentelemetry.api.OpenTelemetry
        public /* synthetic */ Tracer getTracer(String str, String str2) {
            return a.b(this, str, str2);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16084);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            TAG = GlobalOpenTelemetry.class.getName();
            mutex = new Object();
        }
    }

    GlobalOpenTelemetry() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static OpenTelemetry get() {
        if (globalOpenTelemetry == null) {
            synchronized (mutex) {
                if (globalOpenTelemetry == null) {
                    set(a.d());
                    return a.d();
                }
            }
        }
        return globalOpenTelemetry;
    }

    public static ContextPropagators getPropagators() {
        return get().getPropagators();
    }

    public static Tracer getTracer(String str) {
        return get().getTracer(str);
    }

    public static TracerProvider getTracerProvider() {
        return get().getTracerProvider();
    }

    public static void resetForTest() {
        globalOpenTelemetry = null;
    }

    public static void set(OpenTelemetry openTelemetry) {
        synchronized (mutex) {
            if (globalOpenTelemetry == null) {
                globalOpenTelemetry = new ObfuscatedOpenTelemetry(openTelemetry);
                setGlobalCaller = new Throwable();
            } else {
                throw new IllegalStateException("GlobalOpenTelemetry.set has already been called. GlobalOpenTelemetry.set must be called only once before any calls to GlobalOpenTelemetry.get. If you are using the OpenTelemetrySdk, use OpenTelemetrySdkBuilder.buildAndRegisterGlobal instead. Previous invocation set to cause of this exception.", setGlobalCaller);
            }
        }
    }

    public static TracerBuilder tracerBuilder(String str) {
        return get().tracerBuilder(str);
    }

    public static Tracer getTracer(String str, String str2) {
        return get().getTracer(str, str2);
    }
}
