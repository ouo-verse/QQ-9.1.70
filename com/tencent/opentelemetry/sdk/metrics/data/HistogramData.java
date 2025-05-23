package com.tencent.opentelemetry.sdk.metrics.data;

import java.util.Collection;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface HistogramData extends Data<HistogramPointData> {
    AggregationTemporality getAggregationTemporality();

    @Override // com.tencent.opentelemetry.sdk.metrics.data.Data
    Collection<HistogramPointData> getPoints();
}
