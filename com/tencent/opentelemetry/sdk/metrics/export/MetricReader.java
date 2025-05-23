package com.tencent.opentelemetry.sdk.metrics.export;

import com.tencent.opentelemetry.sdk.common.CompletableResultCode;
import com.tencent.opentelemetry.sdk.metrics.InstrumentType;
import com.tencent.opentelemetry.sdk.metrics.data.AggregationTemporality;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface MetricReader {
    CompletableResultCode flush();

    AggregationTemporality getAggregationTemporality(InstrumentType instrumentType);

    void register(CollectionRegistration collectionRegistration);

    CompletableResultCode shutdown();
}
