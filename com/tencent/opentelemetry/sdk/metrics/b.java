package com.tencent.opentelemetry.sdk.metrics;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.sdk.metrics.internal.view.DefaultAggregation;
import com.tencent.opentelemetry.sdk.metrics.internal.view.DropAggregation;
import com.tencent.opentelemetry.sdk.metrics.internal.view.ExplicitBucketHistogramAggregation;
import com.tencent.opentelemetry.sdk.metrics.internal.view.LastValueAggregation;
import com.tencent.opentelemetry.sdk.metrics.internal.view.SumAggregation;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public final /* synthetic */ class b {
    public static Aggregation a() {
        IPatchRedirector iPatchRedirector = Aggregation.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Aggregation) iPatchRedirector.redirect((short) 2);
        }
        return DefaultAggregation.getInstance();
    }

    public static Aggregation b() {
        IPatchRedirector iPatchRedirector = Aggregation.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (Aggregation) iPatchRedirector.redirect((short) 1);
        }
        return DropAggregation.getInstance();
    }

    public static Aggregation c() {
        IPatchRedirector iPatchRedirector = Aggregation.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Aggregation) iPatchRedirector.redirect((short) 5);
        }
        return ExplicitBucketHistogramAggregation.getDefault();
    }

    public static Aggregation d(List<Double> list) {
        IPatchRedirector iPatchRedirector = Aggregation.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Aggregation) iPatchRedirector.redirect((short) 6, (Object) list);
        }
        return ExplicitBucketHistogramAggregation.create(list);
    }

    public static Aggregation e() {
        IPatchRedirector iPatchRedirector = Aggregation.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Aggregation) iPatchRedirector.redirect((short) 4);
        }
        return LastValueAggregation.getInstance();
    }

    public static Aggregation f() {
        IPatchRedirector iPatchRedirector = Aggregation.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Aggregation) iPatchRedirector.redirect((short) 3);
        }
        return SumAggregation.getInstance();
    }
}
