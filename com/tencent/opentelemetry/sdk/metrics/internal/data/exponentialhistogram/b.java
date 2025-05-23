package com.tencent.opentelemetry.sdk.metrics.internal.data.exponentialhistogram;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.sdk.metrics.data.ExemplarData;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public final /* synthetic */ class b {
    public static ExponentialHistogramPointData a(int i3, double d16, long j3, ExponentialHistogramBuckets exponentialHistogramBuckets, ExponentialHistogramBuckets exponentialHistogramBuckets2, long j16, long j17, Attributes attributes, List<ExemplarData> list) {
        IPatchRedirector iPatchRedirector = ExponentialHistogramPointData.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (ExponentialHistogramPointData) iPatchRedirector.redirect((short) 1, Integer.valueOf(i3), Double.valueOf(d16), Long.valueOf(j3), exponentialHistogramBuckets, exponentialHistogramBuckets2, Long.valueOf(j16), Long.valueOf(j17), attributes, list);
        }
        return ImmutableExponentialHistogramPointData.create(i3, d16, j3, exponentialHistogramBuckets, exponentialHistogramBuckets2, j16, j17, attributes, list);
    }
}
