package com.tencent.opentelemetry.sdk.metrics;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.internal.Utils;
import java.util.Objects;
import javax.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class InstrumentSelectorBuilder {
    static IPatchRedirector $redirector_;

    @Nullable
    private String instrumentName;

    @Nullable
    private InstrumentType instrumentType;

    @Nullable
    private String meterName;

    @Nullable
    private String meterSchemaUrl;

    @Nullable
    private String meterVersion;

    /* JADX INFO: Access modifiers changed from: package-private */
    public InstrumentSelectorBuilder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public InstrumentSelector build() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (InstrumentSelector) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        if (this.instrumentType == null && this.instrumentName == null && this.meterName == null && this.meterVersion == null && this.meterSchemaUrl == null) {
            z16 = false;
        } else {
            z16 = true;
        }
        Utils.checkArgument(z16, "Instrument selector must contain selection criteria");
        return InstrumentSelector.create(this.instrumentType, this.instrumentName, this.meterName, this.meterVersion, this.meterSchemaUrl);
    }

    public InstrumentSelectorBuilder setMeterName(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (InstrumentSelectorBuilder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        Objects.requireNonNull(str, "meterName");
        this.meterName = str;
        return this;
    }

    public InstrumentSelectorBuilder setMeterSchemaUrl(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (InstrumentSelectorBuilder) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
        Objects.requireNonNull(str, "meterSchemaUrl");
        this.meterSchemaUrl = str;
        return this;
    }

    public InstrumentSelectorBuilder setMeterVersion(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (InstrumentSelectorBuilder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        Objects.requireNonNull(str, "meterVersion");
        this.meterVersion = str;
        return this;
    }

    public InstrumentSelectorBuilder setName(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (InstrumentSelectorBuilder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        Objects.requireNonNull(str, "name");
        this.instrumentName = str;
        return this;
    }

    public InstrumentSelectorBuilder setType(InstrumentType instrumentType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (InstrumentSelectorBuilder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) instrumentType);
        }
        Objects.requireNonNull(instrumentType, "instrumentType");
        this.instrumentType = instrumentType;
        return this;
    }
}
