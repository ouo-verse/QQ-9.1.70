package com.tencent.opentelemetry.sdk.metrics.internal.view;

import com.google.auto.value.AutoValue;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.sdk.metrics.InstrumentSelector;
import com.tencent.opentelemetry.sdk.metrics.View;
import com.tencent.opentelemetry.sdk.metrics.internal.debug.SourceInfo;
import javax.annotation.concurrent.Immutable;

/* compiled from: P */
@AutoValue
@Immutable
/* loaded from: classes22.dex */
public abstract class RegisteredView {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RegisteredView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static RegisteredView create(InstrumentSelector instrumentSelector, View view, AttributesProcessor attributesProcessor, SourceInfo sourceInfo) {
        return new AutoValue_RegisteredView(instrumentSelector, view, attributesProcessor, sourceInfo);
    }

    public abstract InstrumentSelector getInstrumentSelector();

    public abstract View getView();

    public abstract AttributesProcessor getViewAttributesProcessor();

    public abstract SourceInfo getViewSourceInfo();
}
