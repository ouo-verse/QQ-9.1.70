package com.tencent.opentelemetry.sdk.metrics;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.api.internal.Utils;
import com.tencent.opentelemetry.sdk.common.Clock;
import com.tencent.opentelemetry.sdk.metrics.export.MetricReader;
import com.tencent.opentelemetry.sdk.metrics.internal.exemplar.ExemplarFilter;
import com.tencent.opentelemetry.sdk.metrics.internal.view.ViewRegistry;
import com.tencent.opentelemetry.sdk.metrics.internal.view.ViewRegistryBuilder;
import com.tencent.opentelemetry.sdk.resources.Resource;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* loaded from: classes22.dex */
public class SdkMeterProviderBuilder {
    static IPatchRedirector $redirector_;
    private static final ExemplarFilter DEFAULT_EXEMPLAR_FILTER;
    private static final long DEFAULT_MIN_COLLECTION_INTERVAL_NANOS = 0;
    private Clock clock;
    private ExemplarFilter exemplarFilter;
    private final List<MetricReader> metricReaders;
    private long minimumCollectionIntervalNanos;
    private Resource resource;
    private final ViewRegistryBuilder viewRegistryBuilder;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11314);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            DEFAULT_EXEMPLAR_FILTER = com.tencent.opentelemetry.sdk.metrics.internal.exemplar.b.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SdkMeterProviderBuilder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.clock = com.tencent.opentelemetry.sdk.common.a.a();
        this.resource = Resource.getDefault();
        this.viewRegistryBuilder = ViewRegistry.builder();
        this.metricReaders = new ArrayList();
        this.exemplarFilter = DEFAULT_EXEMPLAR_FILTER;
        this.minimumCollectionIntervalNanos = 0L;
    }

    public SdkMeterProvider build() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (SdkMeterProvider) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return new SdkMeterProvider(this.metricReaders, this.clock, this.resource, this.viewRegistryBuilder.build(), this.exemplarFilter, this.minimumCollectionIntervalNanos);
    }

    public SdkMeterProviderBuilder registerMetricReader(MetricReader metricReader) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (SdkMeterProviderBuilder) iPatchRedirector.redirect((short) 6, (Object) this, (Object) metricReader);
        }
        this.metricReaders.add(metricReader);
        return this;
    }

    public SdkMeterProviderBuilder registerView(InstrumentSelector instrumentSelector, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (SdkMeterProviderBuilder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) instrumentSelector, (Object) view);
        }
        Objects.requireNonNull(instrumentSelector, "selector");
        Objects.requireNonNull(view, "view");
        this.viewRegistryBuilder.addView(instrumentSelector, view, view.getAttributesProcessor(), com.tencent.opentelemetry.sdk.metrics.internal.debug.a.a());
        return this;
    }

    public SdkMeterProviderBuilder setClock(Clock clock) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SdkMeterProviderBuilder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) clock);
        }
        Objects.requireNonNull(clock, "clock");
        this.clock = clock;
        return this;
    }

    public SdkMeterProviderBuilder setExemplarFilter(ExemplarFilter exemplarFilter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (SdkMeterProviderBuilder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) exemplarFilter);
        }
        this.exemplarFilter = exemplarFilter;
        return this;
    }

    public SdkMeterProviderBuilder setMinimumCollectionInterval(Duration duration) {
        boolean isNegative;
        long nanos;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (SdkMeterProviderBuilder) iPatchRedirector.redirect((short) 7, (Object) this, (Object) duration);
        }
        Objects.requireNonNull(duration, "duration");
        isNegative = duration.isNegative();
        Utils.checkArgument(!isNegative, "duration must not be negative");
        nanos = duration.toNanos();
        this.minimumCollectionIntervalNanos = nanos;
        return this;
    }

    public SdkMeterProviderBuilder setResource(Resource resource) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (SdkMeterProviderBuilder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) resource);
        }
        Objects.requireNonNull(resource, "resource");
        this.resource = resource;
        return this;
    }
}
