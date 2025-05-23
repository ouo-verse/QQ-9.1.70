package com.tencent.opentelemetry.sdk.metrics.internal.aggregator;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.sdk.metrics.internal.state.ExponentialCounterFactory;

/* compiled from: P */
/* loaded from: classes22.dex */
final class ExponentialBucketStrategy {
    static IPatchRedirector $redirector_;
    private final ExponentialCounterFactory counterFactory;
    private final int maxBuckets;
    private final int scale;

    ExponentialBucketStrategy(int i3, int i16, ExponentialCounterFactory exponentialCounterFactory) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), exponentialCounterFactory);
            return;
        }
        this.scale = i3;
        this.maxBuckets = i16;
        this.counterFactory = exponentialCounterFactory;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ExponentialBucketStrategy newStrategy(int i3, int i16, ExponentialCounterFactory exponentialCounterFactory) {
        return new ExponentialBucketStrategy(i3, i16, exponentialCounterFactory);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DoubleExponentialHistogramBuckets newBuckets() {
        return new DoubleExponentialHistogramBuckets(this.scale, this.maxBuckets, this.counterFactory);
    }
}
