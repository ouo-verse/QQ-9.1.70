package com.tencent.opentelemetry.sdk.metrics.internal.data.exponentialhistogram;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.sdk.metrics.data.PointData;
import javax.annotation.concurrent.Immutable;

@Immutable
/* loaded from: classes22.dex */
public interface ExponentialHistogramPointData extends PointData {
    public static final IPatchRedirector $redirector_ = null;

    long getCount();

    ExponentialHistogramBuckets getNegativeBuckets();

    ExponentialHistogramBuckets getPositiveBuckets();

    int getScale();

    double getSum();

    long getZeroCount();
}
