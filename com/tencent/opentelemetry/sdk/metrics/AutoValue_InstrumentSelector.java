package com.tencent.opentelemetry.sdk.metrics;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import javax.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes22.dex */
final class AutoValue_InstrumentSelector extends InstrumentSelector {
    static IPatchRedirector $redirector_;
    private final String instrumentName;
    private final InstrumentType instrumentType;
    private final String meterName;
    private final String meterSchemaUrl;
    private final String meterVersion;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_InstrumentSelector(@Nullable InstrumentType instrumentType, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, instrumentType, str, str2, str3, str4);
            return;
        }
        this.instrumentType = instrumentType;
        this.instrumentName = str;
        this.meterName = str2;
        this.meterVersion = str3;
        this.meterSchemaUrl = str4;
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, obj)).booleanValue();
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InstrumentSelector)) {
            return false;
        }
        InstrumentSelector instrumentSelector = (InstrumentSelector) obj;
        InstrumentType instrumentType = this.instrumentType;
        if (instrumentType != null ? instrumentType.equals(instrumentSelector.getInstrumentType()) : instrumentSelector.getInstrumentType() == null) {
            String str = this.instrumentName;
            if (str != null ? str.equals(instrumentSelector.getInstrumentName()) : instrumentSelector.getInstrumentName() == null) {
                String str2 = this.meterName;
                if (str2 != null ? str2.equals(instrumentSelector.getMeterName()) : instrumentSelector.getMeterName() == null) {
                    String str3 = this.meterVersion;
                    if (str3 != null ? str3.equals(instrumentSelector.getMeterVersion()) : instrumentSelector.getMeterVersion() == null) {
                        String str4 = this.meterSchemaUrl;
                        if (str4 == null) {
                            if (instrumentSelector.getMeterSchemaUrl() == null) {
                                return true;
                            }
                        } else if (str4.equals(instrumentSelector.getMeterSchemaUrl())) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.InstrumentSelector
    @Nullable
    public String getInstrumentName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.instrumentName;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.InstrumentSelector
    @Nullable
    public InstrumentType getInstrumentType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (InstrumentType) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.instrumentType;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.InstrumentSelector
    @Nullable
    public String getMeterName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.meterName;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.InstrumentSelector
    @Nullable
    public String getMeterSchemaUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.meterSchemaUrl;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.InstrumentSelector
    @Nullable
    public String getMeterVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.meterVersion;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        InstrumentType instrumentType = this.instrumentType;
        int i3 = 0;
        if (instrumentType == null) {
            hashCode = 0;
        } else {
            hashCode = instrumentType.hashCode();
        }
        int i16 = (hashCode ^ 1000003) * 1000003;
        String str = this.instrumentName;
        if (str == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str.hashCode();
        }
        int i17 = (i16 ^ hashCode2) * 1000003;
        String str2 = this.meterName;
        if (str2 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str2.hashCode();
        }
        int i18 = (i17 ^ hashCode3) * 1000003;
        String str3 = this.meterVersion;
        if (str3 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = str3.hashCode();
        }
        int i19 = (i18 ^ hashCode4) * 1000003;
        String str4 = this.meterSchemaUrl;
        if (str4 != null) {
            i3 = str4.hashCode();
        }
        return i19 ^ i3;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return "InstrumentSelector{instrumentType=" + this.instrumentType + ", instrumentName=" + this.instrumentName + ", meterName=" + this.meterName + ", meterVersion=" + this.meterVersion + ", meterSchemaUrl=" + this.meterSchemaUrl + "}";
    }
}
