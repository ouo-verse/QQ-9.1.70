package com.tencent.opentelemetry.sdk.metrics;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.metrics.Meter;
import com.tencent.opentelemetry.api.metrics.MeterBuilder;
import com.tencent.opentelemetry.sdk.internal.ComponentRegistry;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes22.dex */
public class SdkMeterBuilder implements MeterBuilder {
    static IPatchRedirector $redirector_;
    private final String instrumentationScopeName;

    @Nullable
    private String instrumentationScopeVersion;
    private final ComponentRegistry<SdkMeter> registry;

    @Nullable
    private String schemaUrl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SdkMeterBuilder(ComponentRegistry<SdkMeter> componentRegistry, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) componentRegistry, (Object) str);
        } else {
            this.registry = componentRegistry;
            this.instrumentationScopeName = str;
        }
    }

    @Override // com.tencent.opentelemetry.api.metrics.MeterBuilder
    public Meter build() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Meter) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.registry.get(this.instrumentationScopeName, this.instrumentationScopeVersion, this.schemaUrl);
    }

    @Override // com.tencent.opentelemetry.api.metrics.MeterBuilder
    public MeterBuilder setInstrumentationVersion(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (MeterBuilder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        this.instrumentationScopeVersion = str;
        return this;
    }

    @Override // com.tencent.opentelemetry.api.metrics.MeterBuilder
    public MeterBuilder setSchemaUrl(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MeterBuilder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        this.schemaUrl = str;
        return this;
    }
}
