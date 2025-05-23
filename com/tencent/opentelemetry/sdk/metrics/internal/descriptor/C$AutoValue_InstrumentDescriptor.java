package com.tencent.opentelemetry.sdk.metrics.internal.descriptor;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.sdk.metrics.InstrumentType;
import com.tencent.opentelemetry.sdk.metrics.InstrumentValueType;
import com.tencent.opentelemetry.sdk.metrics.internal.debug.SourceInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* renamed from: com.tencent.opentelemetry.sdk.metrics.internal.descriptor.$AutoValue_InstrumentDescriptor, reason: invalid class name */
/* loaded from: classes22.dex */
public abstract class C$AutoValue_InstrumentDescriptor extends InstrumentDescriptor {
    static IPatchRedirector $redirector_;
    private final String description;
    private final String name;
    private final SourceInfo sourceInfo;
    private final InstrumentType type;
    private final String unit;
    private final InstrumentValueType valueType;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C$AutoValue_InstrumentDescriptor(String str, String str2, String str3, InstrumentType instrumentType, InstrumentValueType instrumentValueType, SourceInfo sourceInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, str3, instrumentType, instrumentValueType, sourceInfo);
            return;
        }
        if (str != null) {
            this.name = str;
            if (str2 != null) {
                this.description = str2;
                if (str3 != null) {
                    this.unit = str3;
                    if (instrumentType != null) {
                        this.type = instrumentType;
                        if (instrumentValueType != null) {
                            this.valueType = instrumentValueType;
                            if (sourceInfo != null) {
                                this.sourceInfo = sourceInfo;
                                return;
                            }
                            throw new NullPointerException("Null sourceInfo");
                        }
                        throw new NullPointerException("Null valueType");
                    }
                    throw new NullPointerException("Null type");
                }
                throw new NullPointerException("Null unit");
            }
            throw new NullPointerException("Null description");
        }
        throw new NullPointerException("Null name");
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, obj)).booleanValue();
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InstrumentDescriptor)) {
            return false;
        }
        InstrumentDescriptor instrumentDescriptor = (InstrumentDescriptor) obj;
        if (this.name.equals(instrumentDescriptor.getName()) && this.description.equals(instrumentDescriptor.getDescription()) && this.unit.equals(instrumentDescriptor.getUnit()) && this.type.equals(instrumentDescriptor.getType()) && this.valueType.equals(instrumentDescriptor.getValueType()) && this.sourceInfo.equals(instrumentDescriptor.getSourceInfo())) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor
    public String getDescription() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.description;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor
    public String getName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.name;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor
    public SourceInfo getSourceInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (SourceInfo) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.sourceInfo;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor
    public InstrumentType getType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (InstrumentType) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.type;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor
    public String getUnit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.unit;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor
    public InstrumentValueType getValueType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (InstrumentValueType) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.valueType;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor
    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return ((((((((((this.name.hashCode() ^ 1000003) * 1000003) ^ this.description.hashCode()) * 1000003) ^ this.unit.hashCode()) * 1000003) ^ this.type.hashCode()) * 1000003) ^ this.valueType.hashCode()) * 1000003) ^ this.sourceInfo.hashCode();
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return "InstrumentDescriptor{name=" + this.name + ", description=" + this.description + ", unit=" + this.unit + ", type=" + this.type + ", valueType=" + this.valueType + ", sourceInfo=" + this.sourceInfo + "}";
    }
}
