package com.tencent.opentelemetry.sdk.metrics;

import com.google.auto.value.AutoValue;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.sdk.metrics.internal.debug.SourceInfo;
import com.tencent.opentelemetry.sdk.metrics.internal.view.AttributesProcessor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

/* compiled from: P */
@AutoValue
@Immutable
/* loaded from: classes22.dex */
public abstract class View {
    static IPatchRedirector $redirector_;

    public View() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static ViewBuilder builder() {
        return new ViewBuilder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static View create(String str, String str2, Aggregation aggregation, AttributesProcessor attributesProcessor) {
        return new AutoValue_View(str, str2, aggregation, attributesProcessor, com.tencent.opentelemetry.sdk.metrics.internal.debug.a.a());
    }

    public abstract Aggregation getAggregation();

    public abstract AttributesProcessor getAttributesProcessor();

    @Nullable
    public abstract String getDescription();

    @Nullable
    public abstract String getName();

    public abstract SourceInfo getSourceInfo();
}
