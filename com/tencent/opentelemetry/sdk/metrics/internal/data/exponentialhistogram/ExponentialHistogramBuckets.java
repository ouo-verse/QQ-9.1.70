package com.tencent.opentelemetry.sdk.metrics.internal.data.exponentialhistogram;

import java.util.List;
import javax.annotation.concurrent.Immutable;

/* compiled from: P */
@Immutable
/* loaded from: classes22.dex */
public interface ExponentialHistogramBuckets {
    List<Long> getBucketCounts();

    int getOffset();

    long getTotalCount();
}
