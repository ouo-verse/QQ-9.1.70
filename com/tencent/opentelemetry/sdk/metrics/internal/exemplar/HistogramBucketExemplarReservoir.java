package com.tencent.opentelemetry.sdk.metrics.internal.exemplar;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.context.Context;
import com.tencent.opentelemetry.sdk.common.Clock;
import com.tencent.opentelemetry.sdk.metrics.internal.aggregator.ExplicitBucketHistogramUtils;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class HistogramBucketExemplarReservoir extends AbstractFixedSizeExemplarReservoir {
    static IPatchRedirector $redirector_;
    private final double[] boundaries;

    HistogramBucketExemplarReservoir(Clock clock, double[] dArr) {
        super(clock, dArr.length + 1);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) clock, (Object) dArr);
        } else {
            this.boundaries = dArr;
        }
    }

    public static HistogramBucketExemplarReservoir create(Clock clock, List<Double> list) {
        return new HistogramBucketExemplarReservoir(clock, ExplicitBucketHistogramUtils.createBoundaryArray(list));
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.exemplar.AbstractFixedSizeExemplarReservoir
    protected int reservoirIndexFor(double d16, Attributes attributes, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, this, Double.valueOf(d16), attributes, context)).intValue();
        }
        return ExplicitBucketHistogramUtils.findBucketIndex(this.boundaries, d16);
    }
}
