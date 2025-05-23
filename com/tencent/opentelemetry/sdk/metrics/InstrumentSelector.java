package com.tencent.opentelemetry.sdk.metrics;

import com.google.auto.value.AutoValue;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

/* compiled from: P */
@AutoValue
@Immutable
/* loaded from: classes22.dex */
public abstract class InstrumentSelector {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public InstrumentSelector() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static InstrumentSelectorBuilder builder() {
        return new InstrumentSelectorBuilder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static InstrumentSelector create(@Nullable InstrumentType instrumentType, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        return new AutoValue_InstrumentSelector(instrumentType, str, str2, str3, str4);
    }

    @Nullable
    public abstract String getInstrumentName();

    @Nullable
    public abstract InstrumentType getInstrumentType();

    @Nullable
    public abstract String getMeterName();

    @Nullable
    public abstract String getMeterSchemaUrl();

    @Nullable
    public abstract String getMeterVersion();
}
