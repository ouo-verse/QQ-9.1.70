package com.tencent.opentelemetry.sdk.metrics.internal.data.exponentialhistogram;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.sdk.metrics.data.AggregationTemporality;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes22.dex */
public final /* synthetic */ class a {
    public static ExponentialHistogramData a(AggregationTemporality aggregationTemporality, Collection<ExponentialHistogramPointData> collection) {
        IPatchRedirector iPatchRedirector = ExponentialHistogramData.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (ExponentialHistogramData) iPatchRedirector.redirect((short) 1, (Object) aggregationTemporality, (Object) collection);
        }
        return ImmutableExponentialHistogramData.create(aggregationTemporality, collection);
    }
}
