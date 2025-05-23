package com.tencent.opentelemetry.sdk.logs;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.sdk.internal.ComponentRegistry;
import javax.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes22.dex */
final class SdkLogEmitterBuilder implements LogEmitterBuilder {
    static IPatchRedirector $redirector_;

    @Nullable
    private String getInstrumentationVersion;
    private final String instrumentationName;
    private final ComponentRegistry<SdkLogEmitter> registry;

    @Nullable
    private String schemaUrl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SdkLogEmitterBuilder(ComponentRegistry<SdkLogEmitter> componentRegistry, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) componentRegistry, (Object) str);
        } else {
            this.registry = componentRegistry;
            this.instrumentationName = str;
        }
    }

    @Override // com.tencent.opentelemetry.sdk.logs.LogEmitterBuilder
    public SdkLogEmitter build() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? this.registry.get(this.instrumentationName, this.getInstrumentationVersion, this.schemaUrl) : (SdkLogEmitter) iPatchRedirector.redirect((short) 4, (Object) this);
    }

    @Override // com.tencent.opentelemetry.sdk.logs.LogEmitterBuilder
    public SdkLogEmitterBuilder setInstrumentationVersion(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (SdkLogEmitterBuilder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        this.getInstrumentationVersion = str;
        return this;
    }

    @Override // com.tencent.opentelemetry.sdk.logs.LogEmitterBuilder
    public SdkLogEmitterBuilder setSchemaUrl(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SdkLogEmitterBuilder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        this.schemaUrl = str;
        return this;
    }
}
