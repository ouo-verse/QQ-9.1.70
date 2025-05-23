package com.tencent.opentelemetry.sdk.metrics.internal.aggregator;

import com.google.auto.value.AutoValue;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.sdk.metrics.data.ExemplarData;
import java.util.Collections;
import java.util.List;
import javax.annotation.concurrent.Immutable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@AutoValue
@Immutable
/* loaded from: classes22.dex */
public abstract class HistogramAccumulation {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HistogramAccumulation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static HistogramAccumulation create(double d16, boolean z16, double d17, double d18, long[] jArr) {
        return create(d16, z16, d17, d18, jArr, Collections.emptyList());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract long[] getCounts();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract List<ExemplarData> getExemplars();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract double getMax();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract double getMin();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract double getSum();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean hasMinMax();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static HistogramAccumulation create(double d16, boolean z16, double d17, double d18, long[] jArr, List<ExemplarData> list) {
        return new AutoValue_HistogramAccumulation(d16, z16, d17, d18, jArr, list);
    }
}
