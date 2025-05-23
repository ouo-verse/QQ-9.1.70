package com.tencent.opentelemetry.sdk.metrics.internal.data.exponentialhistogram;

import com.google.auto.value.AutoValue;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.sdk.metrics.data.AggregationTemporality;
import java.util.Collection;
import java.util.Collections;

/* compiled from: P */
@AutoValue
/* loaded from: classes22.dex */
public abstract class ImmutableExponentialHistogramData implements ExponentialHistogramData {
    static IPatchRedirector $redirector_;
    private static final ExponentialHistogramData EMPTY;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21937);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            EMPTY = a.a(AggregationTemporality.CUMULATIVE, Collections.emptyList());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableExponentialHistogramData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static ExponentialHistogramData create(AggregationTemporality aggregationTemporality, Collection<ExponentialHistogramPointData> collection) {
        return new AutoValue_ImmutableExponentialHistogramData(aggregationTemporality, collection);
    }

    public static ExponentialHistogramData empty() {
        return EMPTY;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ExponentialHistogramData
    public abstract AggregationTemporality getAggregationTemporality();

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ExponentialHistogramData, com.tencent.opentelemetry.sdk.metrics.data.Data
    public abstract Collection<ExponentialHistogramPointData> getPoints();
}
