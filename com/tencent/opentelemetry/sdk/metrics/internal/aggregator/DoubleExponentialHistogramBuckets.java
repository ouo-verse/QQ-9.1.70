package com.tencent.opentelemetry.sdk.metrics.internal.aggregator;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.sdk.internal.PrimitiveLongList;
import com.tencent.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ExponentialHistogramBuckets;
import com.tencent.opentelemetry.sdk.metrics.internal.state.ExponentialCounter;
import com.tencent.opentelemetry.sdk.metrics.internal.state.ExponentialCounterFactory;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes22.dex */
public final class DoubleExponentialHistogramBuckets implements ExponentialHistogramBuckets {
    static IPatchRedirector $redirector_;
    private static final double LOG_BASE2_E;
    private final ExponentialCounterFactory counterFactory;
    private ExponentialCounter counts;
    private int scale;
    private double scaleFactor;
    private long totalCount;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23602);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            LOG_BASE2_E = 1.0d / Math.log(2.0d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DoubleExponentialHistogramBuckets(int i3, int i16, ExponentialCounterFactory exponentialCounterFactory) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), exponentialCounterFactory);
            return;
        }
        this.counterFactory = exponentialCounterFactory;
        this.counts = exponentialCounterFactory.newCounter(i16);
        this.scale = i3;
        this.scaleFactor = computeScaleFactor(i3);
        this.totalCount = 0L;
    }

    private static double computeScaleFactor(int i3) {
        return Math.scalb(LOG_BASE2_E, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DoubleExponentialHistogramBuckets diff(DoubleExponentialHistogramBuckets doubleExponentialHistogramBuckets, DoubleExponentialHistogramBuckets doubleExponentialHistogramBuckets2) {
        DoubleExponentialHistogramBuckets copy = doubleExponentialHistogramBuckets.copy();
        copy.mergeWith(doubleExponentialHistogramBuckets2, false);
        return copy;
    }

    private int getIndexByExponent(double d16) {
        return Math.getExponent(d16) >> (-this.scale);
    }

    private int getIndexByLogarithm(double d16) {
        return (int) Math.floor(Math.log(d16) * this.scaleFactor);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DoubleExponentialHistogramBuckets merge(DoubleExponentialHistogramBuckets doubleExponentialHistogramBuckets, DoubleExponentialHistogramBuckets doubleExponentialHistogramBuckets2) {
        if (doubleExponentialHistogramBuckets2.counts.isEmpty()) {
            return doubleExponentialHistogramBuckets;
        }
        if (doubleExponentialHistogramBuckets.counts.isEmpty()) {
            return doubleExponentialHistogramBuckets2;
        }
        DoubleExponentialHistogramBuckets copy = doubleExponentialHistogramBuckets.copy();
        copy.mergeWith(doubleExponentialHistogramBuckets2, true);
        return copy;
    }

    private void mergeWith(DoubleExponentialHistogramBuckets doubleExponentialHistogramBuckets, boolean z16) {
        long min;
        int max;
        int i3;
        if (doubleExponentialHistogramBuckets.counts.isEmpty()) {
            return;
        }
        int min2 = Math.min(this.scale, doubleExponentialHistogramBuckets.scale);
        int i16 = this.scale - min2;
        int i17 = doubleExponentialHistogramBuckets.scale - min2;
        if (this.counts.isEmpty()) {
            min = doubleExponentialHistogramBuckets.getOffset() >> i17;
            max = doubleExponentialHistogramBuckets.counts.getIndexEnd() >> i17;
        } else {
            min = Math.min(getOffset() >> i16, doubleExponentialHistogramBuckets.getOffset() >> i17);
            max = Math.max(this.counts.getIndexEnd() >> i16, doubleExponentialHistogramBuckets.counts.getIndexEnd() >> i17);
        }
        downscale(i16 + getScaleReduction(min, max));
        int i18 = doubleExponentialHistogramBuckets.scale - this.scale;
        if (z16) {
            i3 = 1;
        } else {
            i3 = -1;
        }
        for (int offset = doubleExponentialHistogramBuckets.getOffset(); offset <= doubleExponentialHistogramBuckets.counts.getIndexEnd(); offset++) {
            if (!this.counts.increment(offset >> i18, i3 * doubleExponentialHistogramBuckets.counts.get(offset))) {
                throw new IllegalStateException("Failed to merge exponential histogram buckets.");
            }
        }
        this.totalCount += i3 * doubleExponentialHistogramBuckets.totalCount;
    }

    private boolean sameBucketCounts(DoubleExponentialHistogramBuckets doubleExponentialHistogramBuckets) {
        if (this.totalCount != doubleExponentialHistogramBuckets.totalCount) {
            return false;
        }
        int min = Math.min(this.counts.getIndexStart(), doubleExponentialHistogramBuckets.counts.getIndexStart());
        if (min == Integer.MIN_VALUE) {
            min = Math.max(this.counts.getIndexStart(), doubleExponentialHistogramBuckets.counts.getIndexStart());
        }
        int max = Math.max(this.counts.getIndexEnd(), doubleExponentialHistogramBuckets.counts.getIndexEnd());
        while (min <= max) {
            if (this.counts.get(min) != doubleExponentialHistogramBuckets.counts.get(min)) {
                return false;
            }
            min++;
        }
        return true;
    }

    private int valueToIndex(double d16) {
        double abs = Math.abs(d16);
        if (this.scale > 0) {
            return getIndexByLogarithm(abs);
        }
        return getIndexByExponent(abs);
    }

    public void clear() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.totalCount = 0L;
            this.counts.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DoubleExponentialHistogramBuckets copy() {
        return new DoubleExponentialHistogramBuckets(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void downscale(int i3) {
        if (i3 == 0) {
            return;
        }
        if (i3 >= 0) {
            if (!this.counts.isEmpty()) {
                ExponentialCounter copy = this.counterFactory.copy(this.counts);
                copy.clear();
                for (int indexStart = this.counts.getIndexStart(); indexStart <= this.counts.getIndexEnd(); indexStart++) {
                    long j3 = this.counts.get(indexStart);
                    if (j3 > 0 && !copy.increment(indexStart >> i3, j3)) {
                        throw new IllegalStateException("Failed to create new downscaled buckets.");
                    }
                }
                this.counts = copy;
            }
            int i16 = this.scale - i3;
            this.scale = i16;
            this.scaleFactor = computeScaleFactor(i16);
            return;
        }
        throw new IllegalStateException("Cannot downscale by negative amount. Was given " + i3 + ".");
    }

    public boolean equals(@Nullable Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, obj)).booleanValue();
        }
        if (!(obj instanceof DoubleExponentialHistogramBuckets)) {
            return false;
        }
        DoubleExponentialHistogramBuckets doubleExponentialHistogramBuckets = (DoubleExponentialHistogramBuckets) obj;
        if (this.scale != doubleExponentialHistogramBuckets.scale || !sameBucketCounts(doubleExponentialHistogramBuckets)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ExponentialHistogramBuckets
    @Nonnull
    public List<Long> getBucketCounts() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        if (this.counts.isEmpty()) {
            return Collections.emptyList();
        }
        int indexEnd = (this.counts.getIndexEnd() - this.counts.getIndexStart()) + 1;
        long[] jArr = new long[indexEnd];
        for (int i3 = 0; i3 < indexEnd; i3++) {
            ExponentialCounter exponentialCounter = this.counts;
            jArr[i3] = exponentialCounter.get(exponentialCounter.getIndexStart() + i3);
        }
        return PrimitiveLongList.wrap(jArr);
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ExponentialHistogramBuckets
    public int getOffset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        if (this.counts.isEmpty()) {
            return 0;
        }
        return this.counts.getIndexStart();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getScale() {
        return this.scale;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getScaleReduction(double d16) {
        long valueToIndex = valueToIndex(d16);
        return getScaleReduction(Math.min(valueToIndex, this.counts.getIndexStart()), Math.max(valueToIndex, this.counts.getIndexEnd()));
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ExponentialHistogramBuckets
    public long getTotalCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
        }
        return this.totalCount;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return ((((getOffset() ^ 1000003) * 1000003) ^ getBucketCounts().hashCode()) * 1000003) ^ this.scale;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean record(double d16) {
        if (d16 != 0.0d) {
            boolean increment = this.counts.increment(valueToIndex(d16), 1L);
            if (increment) {
                this.totalCount++;
            }
            return increment;
        }
        throw new IllegalStateException("Illegal attempted recording of zero at bucket level.");
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return "DoubleExponentialHistogramBuckets{scale: " + this.scale + ", offset: " + getOffset() + ", counts: " + this.counts + " }";
    }

    int getScaleReduction(long j3, long j16) {
        int i3 = 0;
        while ((j16 - j3) + 1 > this.counts.getMaxSize()) {
            j3 >>= 1;
            j16 >>= 1;
            i3++;
        }
        return i3;
    }

    DoubleExponentialHistogramBuckets(DoubleExponentialHistogramBuckets doubleExponentialHistogramBuckets) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) doubleExponentialHistogramBuckets);
            return;
        }
        ExponentialCounterFactory exponentialCounterFactory = doubleExponentialHistogramBuckets.counterFactory;
        this.counterFactory = exponentialCounterFactory;
        this.counts = exponentialCounterFactory.copy(doubleExponentialHistogramBuckets.counts);
        this.scale = doubleExponentialHistogramBuckets.scale;
        this.scaleFactor = doubleExponentialHistogramBuckets.scaleFactor;
        this.totalCount = doubleExponentialHistogramBuckets.totalCount;
    }
}
