package com.tencent.opentelemetry.sdk.metrics.internal.view;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.sdk.metrics.InstrumentSelector;
import com.tencent.opentelemetry.sdk.metrics.View;
import com.tencent.opentelemetry.sdk.metrics.internal.debug.SourceInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ViewRegistryBuilder {
    static IPatchRedirector $redirector_;
    private final List<RegisteredView> orderedViews;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewRegistryBuilder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.orderedViews = new ArrayList();
        }
    }

    public ViewRegistryBuilder addView(InstrumentSelector instrumentSelector, View view, AttributesProcessor attributesProcessor, SourceInfo sourceInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ViewRegistryBuilder) iPatchRedirector.redirect((short) 3, this, instrumentSelector, view, attributesProcessor, sourceInfo);
        }
        this.orderedViews.add(RegisteredView.create(instrumentSelector, view, attributesProcessor, sourceInfo));
        return this;
    }

    public ViewRegistry build() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ViewRegistry) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new ViewRegistry(Collections.unmodifiableList(this.orderedViews));
    }
}
