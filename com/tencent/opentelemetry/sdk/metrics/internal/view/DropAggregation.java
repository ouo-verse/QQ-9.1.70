package com.tencent.opentelemetry.sdk.metrics.internal.view;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.sdk.metrics.Aggregation;
import com.tencent.opentelemetry.sdk.metrics.internal.aggregator.Aggregator;
import com.tencent.opentelemetry.sdk.metrics.internal.aggregator.AggregatorFactory;
import com.tencent.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor;
import com.tencent.opentelemetry.sdk.metrics.internal.exemplar.ExemplarFilter;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class DropAggregation implements Aggregation, AggregatorFactory {
    static IPatchRedirector $redirector_;
    private static final Aggregation INSTANCE;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22765);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new DropAggregation();
        }
    }

    DropAggregation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static Aggregation getInstance() {
        return INSTANCE;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.AggregatorFactory
    public <T> Aggregator<T> createAggregator(InstrumentDescriptor instrumentDescriptor, ExemplarFilter exemplarFilter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Aggregator) iPatchRedirector.redirect((short) 2, (Object) this, (Object) instrumentDescriptor, (Object) exemplarFilter);
        }
        return (Aggregator<T>) com.tencent.opentelemetry.sdk.metrics.internal.aggregator.a.c();
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.AggregatorFactory
    public boolean isCompatibleWithInstrument(InstrumentDescriptor instrumentDescriptor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) instrumentDescriptor)).booleanValue();
        }
        return true;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "DropAggregation";
    }
}
