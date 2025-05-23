package com.tencent.opentelemetry.sdk.metrics.internal.data.exponentialhistogram;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.sdk.metrics.data.AggregationTemporality;
import com.tencent.opentelemetry.sdk.metrics.data.Data;
import java.util.Collection;
import javax.annotation.concurrent.Immutable;

/* compiled from: P */
@Immutable
/* loaded from: classes22.dex */
public interface ExponentialHistogramData extends Data<ExponentialHistogramPointData> {
    public static final IPatchRedirector $redirector_ = null;

    AggregationTemporality getAggregationTemporality();

    @Override // com.tencent.opentelemetry.sdk.metrics.data.Data
    Collection<ExponentialHistogramPointData> getPoints();
}
