package com.tencent.opentelemetry.sdk.metrics.internal.view;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.sdk.metrics.InstrumentSelector;
import com.tencent.opentelemetry.sdk.metrics.View;
import com.tencent.opentelemetry.sdk.metrics.internal.debug.SourceInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes22.dex */
public final class AutoValue_RegisteredView extends RegisteredView {
    static IPatchRedirector $redirector_;
    private final InstrumentSelector instrumentSelector;
    private final View view;
    private final AttributesProcessor viewAttributesProcessor;
    private final SourceInfo viewSourceInfo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_RegisteredView(InstrumentSelector instrumentSelector, View view, AttributesProcessor attributesProcessor, SourceInfo sourceInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, instrumentSelector, view, attributesProcessor, sourceInfo);
            return;
        }
        if (instrumentSelector != null) {
            this.instrumentSelector = instrumentSelector;
            if (view != null) {
                this.view = view;
                if (attributesProcessor != null) {
                    this.viewAttributesProcessor = attributesProcessor;
                    if (sourceInfo != null) {
                        this.viewSourceInfo = sourceInfo;
                        return;
                    }
                    throw new NullPointerException("Null viewSourceInfo");
                }
                throw new NullPointerException("Null viewAttributesProcessor");
            }
            throw new NullPointerException("Null view");
        }
        throw new NullPointerException("Null instrumentSelector");
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, obj)).booleanValue();
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RegisteredView)) {
            return false;
        }
        RegisteredView registeredView = (RegisteredView) obj;
        if (this.instrumentSelector.equals(registeredView.getInstrumentSelector()) && this.view.equals(registeredView.getView()) && this.viewAttributesProcessor.equals(registeredView.getViewAttributesProcessor()) && this.viewSourceInfo.equals(registeredView.getViewSourceInfo())) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.view.RegisteredView
    public InstrumentSelector getInstrumentSelector() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (InstrumentSelector) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.instrumentSelector;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.view.RegisteredView
    public View getView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.view;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.view.RegisteredView
    public AttributesProcessor getViewAttributesProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (AttributesProcessor) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.viewAttributesProcessor;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.view.RegisteredView
    public SourceInfo getViewSourceInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (SourceInfo) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.viewSourceInfo;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return ((((((this.instrumentSelector.hashCode() ^ 1000003) * 1000003) ^ this.view.hashCode()) * 1000003) ^ this.viewAttributesProcessor.hashCode()) * 1000003) ^ this.viewSourceInfo.hashCode();
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "RegisteredView{instrumentSelector=" + this.instrumentSelector + ", view=" + this.view + ", viewAttributesProcessor=" + this.viewAttributesProcessor + ", viewSourceInfo=" + this.viewSourceInfo + "}";
    }
}
