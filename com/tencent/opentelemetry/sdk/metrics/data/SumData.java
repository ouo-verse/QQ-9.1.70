package com.tencent.opentelemetry.sdk.metrics.data;

import com.tencent.opentelemetry.sdk.metrics.data.PointData;
import javax.annotation.concurrent.Immutable;

/* compiled from: P */
@Immutable
/* loaded from: classes22.dex */
public interface SumData<T extends PointData> extends Data<T> {
    AggregationTemporality getAggregationTemporality();

    boolean isMonotonic();
}
