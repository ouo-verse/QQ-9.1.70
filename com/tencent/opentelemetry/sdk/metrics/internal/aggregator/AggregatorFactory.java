package com.tencent.opentelemetry.sdk.metrics.internal.aggregator;

import com.tencent.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor;
import com.tencent.opentelemetry.sdk.metrics.internal.exemplar.ExemplarFilter;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface AggregatorFactory {
    <T> Aggregator<T> createAggregator(InstrumentDescriptor instrumentDescriptor, ExemplarFilter exemplarFilter);

    boolean isCompatibleWithInstrument(InstrumentDescriptor instrumentDescriptor);
}
