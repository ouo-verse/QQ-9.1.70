package com.tencent.opentelemetry.sdk.metrics.internal.aggregator;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.context.Context;
import com.tencent.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor;

/* compiled from: P */
/* loaded from: classes22.dex */
abstract class AbstractSumAggregator<T> implements Aggregator<T> {
    static IPatchRedirector $redirector_;
    private final boolean isMonotonic;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractSumAggregator(InstrumentDescriptor instrumentDescriptor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) instrumentDescriptor);
        } else {
            this.isMonotonic = MetricDataUtils.isMonotonicInstrument(instrumentDescriptor);
        }
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public /* synthetic */ Object accumulateDoubleMeasurement(double d16, Attributes attributes, Context context) {
        return a.a(this, d16, attributes, context);
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public /* synthetic */ Object accumulateLongMeasurement(long j3, Attributes attributes, Context context) {
        return a.b(this, j3, attributes, context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean isMonotonic() {
        return this.isMonotonic;
    }
}
