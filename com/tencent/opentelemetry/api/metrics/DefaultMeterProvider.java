package com.tencent.opentelemetry.api.metrics;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* loaded from: classes22.dex */
public class DefaultMeterProvider implements MeterProvider {
    static IPatchRedirector $redirector_;
    private static final MeterBuilder BUILDER_INSTANCE;
    private static final DefaultMeterProvider INSTANCE;

    /* loaded from: classes22.dex */
    private static class NoopMeterBuilder implements MeterBuilder {
        static IPatchRedirector $redirector_;

        NoopMeterBuilder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        @Override // com.tencent.opentelemetry.api.metrics.MeterBuilder
        public Meter build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Meter) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return DefaultMeter.getInstance();
        }

        @Override // com.tencent.opentelemetry.api.metrics.MeterBuilder
        public MeterBuilder setInstrumentationVersion(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (MeterBuilder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            }
            return this;
        }

        @Override // com.tencent.opentelemetry.api.metrics.MeterBuilder
        public MeterBuilder setSchemaUrl(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (MeterBuilder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
            return this;
        }

        /* synthetic */ NoopMeterBuilder(AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) anonymousClass1);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15607);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new DefaultMeterProvider();
            BUILDER_INSTANCE = new NoopMeterBuilder(null);
        }
    }

    DefaultMeterProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    public static MeterProvider getInstance() {
        return INSTANCE;
    }

    @Override // com.tencent.opentelemetry.api.metrics.MeterProvider
    public /* synthetic */ Meter get(String str) {
        return a.a(this, str);
    }

    @Override // com.tencent.opentelemetry.api.metrics.MeterProvider
    public MeterBuilder meterBuilder(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (MeterBuilder) iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        }
        return BUILDER_INSTANCE;
    }

    @Override // com.tencent.opentelemetry.api.metrics.MeterProvider
    public /* synthetic */ Meter get(String str, String str2, String str3) {
        return a.b(this, str, str2, str3);
    }
}
