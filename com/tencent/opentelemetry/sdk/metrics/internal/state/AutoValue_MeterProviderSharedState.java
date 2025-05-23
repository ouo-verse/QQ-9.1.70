package com.tencent.opentelemetry.sdk.metrics.internal.state;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.sdk.common.Clock;
import com.tencent.opentelemetry.sdk.metrics.internal.exemplar.ExemplarFilter;
import com.tencent.opentelemetry.sdk.metrics.internal.view.ViewRegistry;
import com.tencent.opentelemetry.sdk.resources.Resource;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes22.dex */
public final class AutoValue_MeterProviderSharedState extends MeterProviderSharedState {
    static IPatchRedirector $redirector_;
    private final Clock clock;
    private final ExemplarFilter exemplarFilter;
    private final Resource resource;
    private final long startEpochNanos;
    private final ViewRegistry viewRegistry;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_MeterProviderSharedState(Clock clock, Resource resource, ViewRegistry viewRegistry, long j3, ExemplarFilter exemplarFilter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, clock, resource, viewRegistry, Long.valueOf(j3), exemplarFilter);
            return;
        }
        if (clock != null) {
            this.clock = clock;
            if (resource != null) {
                this.resource = resource;
                if (viewRegistry != null) {
                    this.viewRegistry = viewRegistry;
                    this.startEpochNanos = j3;
                    if (exemplarFilter != null) {
                        this.exemplarFilter = exemplarFilter;
                        return;
                    }
                    throw new NullPointerException("Null exemplarFilter");
                }
                throw new NullPointerException("Null viewRegistry");
            }
            throw new NullPointerException("Null resource");
        }
        throw new NullPointerException("Null clock");
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, obj)).booleanValue();
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MeterProviderSharedState)) {
            return false;
        }
        MeterProviderSharedState meterProviderSharedState = (MeterProviderSharedState) obj;
        if (this.clock.equals(meterProviderSharedState.getClock()) && this.resource.equals(meterProviderSharedState.getResource()) && this.viewRegistry.equals(meterProviderSharedState.getViewRegistry()) && this.startEpochNanos == meterProviderSharedState.getStartEpochNanos() && this.exemplarFilter.equals(meterProviderSharedState.getExemplarFilter())) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.state.MeterProviderSharedState
    public Clock getClock() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Clock) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.clock;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.opentelemetry.sdk.metrics.internal.state.MeterProviderSharedState
    public ExemplarFilter getExemplarFilter() {
        return this.exemplarFilter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.opentelemetry.sdk.metrics.internal.state.MeterProviderSharedState
    public Resource getResource() {
        return this.resource;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.opentelemetry.sdk.metrics.internal.state.MeterProviderSharedState
    public long getStartEpochNanos() {
        return this.startEpochNanos;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.opentelemetry.sdk.metrics.internal.state.MeterProviderSharedState
    public ViewRegistry getViewRegistry() {
        return this.viewRegistry;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        int hashCode = (((((this.clock.hashCode() ^ 1000003) * 1000003) ^ this.resource.hashCode()) * 1000003) ^ this.viewRegistry.hashCode()) * 1000003;
        long j3 = this.startEpochNanos;
        return ((hashCode ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003) ^ this.exemplarFilter.hashCode();
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "MeterProviderSharedState{clock=" + this.clock + ", resource=" + this.resource + ", viewRegistry=" + this.viewRegistry + ", startEpochNanos=" + this.startEpochNanos + ", exemplarFilter=" + this.exemplarFilter + "}";
    }
}
