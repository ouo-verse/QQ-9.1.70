package com.tencent.opentelemetry.sdk.metrics.internal.state;

import com.google.auto.value.AutoValue;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.sdk.common.Clock;
import com.tencent.opentelemetry.sdk.metrics.internal.exemplar.ExemplarFilter;
import com.tencent.opentelemetry.sdk.metrics.internal.view.ViewRegistry;
import com.tencent.opentelemetry.sdk.resources.Resource;
import javax.annotation.concurrent.Immutable;

@AutoValue
@Immutable
/* loaded from: classes22.dex */
public abstract class MeterProviderSharedState {
    static IPatchRedirector $redirector_;

    public MeterProviderSharedState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static MeterProviderSharedState create(Clock clock, Resource resource, ViewRegistry viewRegistry, ExemplarFilter exemplarFilter) {
        return new AutoValue_MeterProviderSharedState(clock, resource, viewRegistry, clock.now(), exemplarFilter);
    }

    public abstract Clock getClock();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract ExemplarFilter getExemplarFilter();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Resource getResource();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract long getStartEpochNanos();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract ViewRegistry getViewRegistry();
}
