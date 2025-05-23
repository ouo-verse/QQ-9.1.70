package com.tencent.opentelemetry.sdk.metrics.internal.descriptor;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.sdk.metrics.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* renamed from: com.tencent.opentelemetry.sdk.metrics.internal.descriptor.$AutoValue_MetricDescriptor, reason: invalid class name */
/* loaded from: classes22.dex */
public abstract class C$AutoValue_MetricDescriptor extends MetricDescriptor {
    static IPatchRedirector $redirector_;
    private final String description;
    private final String name;
    private final InstrumentDescriptor sourceInstrument;
    private final View view;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C$AutoValue_MetricDescriptor(String str, String str2, View view, InstrumentDescriptor instrumentDescriptor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, view, instrumentDescriptor);
            return;
        }
        if (str != null) {
            this.name = str;
            if (str2 != null) {
                this.description = str2;
                if (view != null) {
                    this.view = view;
                    if (instrumentDescriptor != null) {
                        this.sourceInstrument = instrumentDescriptor;
                        return;
                    }
                    throw new NullPointerException("Null sourceInstrument");
                }
                throw new NullPointerException("Null view");
            }
            throw new NullPointerException("Null description");
        }
        throw new NullPointerException("Null name");
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, obj)).booleanValue();
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MetricDescriptor)) {
            return false;
        }
        MetricDescriptor metricDescriptor = (MetricDescriptor) obj;
        if (this.name.equals(metricDescriptor.getName()) && this.description.equals(metricDescriptor.getDescription()) && this.view.equals(metricDescriptor.getView()) && this.sourceInstrument.equals(metricDescriptor.getSourceInstrument())) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.descriptor.MetricDescriptor
    public String getDescription() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.description;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.descriptor.MetricDescriptor
    public String getName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.name;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.descriptor.MetricDescriptor
    public InstrumentDescriptor getSourceInstrument() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (InstrumentDescriptor) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.sourceInstrument;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.descriptor.MetricDescriptor
    public View getView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.view;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.descriptor.MetricDescriptor
    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return ((((((this.name.hashCode() ^ 1000003) * 1000003) ^ this.description.hashCode()) * 1000003) ^ this.view.hashCode()) * 1000003) ^ this.sourceInstrument.hashCode();
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "MetricDescriptor{name=" + this.name + ", description=" + this.description + ", view=" + this.view + ", sourceInstrument=" + this.sourceInstrument + "}";
    }
}
