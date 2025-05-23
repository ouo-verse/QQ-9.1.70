package com.tencent.opentelemetry.sdk.metrics.internal.aggregator;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.sdk.metrics.data.ExemplarData;
import com.tencent.thumbplayer.api.common.TPErrorType;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
final class AutoValue_HistogramAccumulation extends HistogramAccumulation {
    static IPatchRedirector $redirector_;
    private final long[] getCounts;
    private final List<ExemplarData> getExemplars;
    private final double getMax;
    private final double getMin;
    private final double getSum;
    private final boolean hasMinMax;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_HistogramAccumulation(double d16, boolean z16, double d17, double d18, long[] jArr, List<ExemplarData> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Double.valueOf(d16), Boolean.valueOf(z16), Double.valueOf(d17), Double.valueOf(d18), jArr, list);
            return;
        }
        this.getSum = d16;
        this.hasMinMax = z16;
        this.getMin = d17;
        this.getMax = d18;
        if (jArr != null) {
            this.getCounts = jArr;
            if (list != null) {
                this.getExemplars = list;
                return;
            }
            throw new NullPointerException("Null getExemplars");
        }
        throw new NullPointerException("Null getCounts");
    }

    public boolean equals(Object obj) {
        long[] counts;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, obj)).booleanValue();
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HistogramAccumulation)) {
            return false;
        }
        HistogramAccumulation histogramAccumulation = (HistogramAccumulation) obj;
        if (Double.doubleToLongBits(this.getSum) == Double.doubleToLongBits(histogramAccumulation.getSum()) && this.hasMinMax == histogramAccumulation.hasMinMax() && Double.doubleToLongBits(this.getMin) == Double.doubleToLongBits(histogramAccumulation.getMin()) && Double.doubleToLongBits(this.getMax) == Double.doubleToLongBits(histogramAccumulation.getMax())) {
            long[] jArr = this.getCounts;
            if (histogramAccumulation instanceof AutoValue_HistogramAccumulation) {
                counts = ((AutoValue_HistogramAccumulation) histogramAccumulation).getCounts;
            } else {
                counts = histogramAccumulation.getCounts();
            }
            if (Arrays.equals(jArr, counts) && this.getExemplars.equals(histogramAccumulation.getExemplars())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.HistogramAccumulation
    long[] getCounts() {
        return this.getCounts;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.HistogramAccumulation
    List<ExemplarData> getExemplars() {
        return this.getExemplars;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.HistogramAccumulation
    double getMax() {
        return this.getMax;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.HistogramAccumulation
    double getMin() {
        return this.getMin;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.HistogramAccumulation
    double getSum() {
        return this.getSum;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.aggregator.HistogramAccumulation
    boolean hasMinMax() {
        return this.hasMinMax;
    }

    public int hashCode() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        int doubleToLongBits = (((int) ((Double.doubleToLongBits(this.getSum) >>> 32) ^ Double.doubleToLongBits(this.getSum))) ^ 1000003) * 1000003;
        if (this.hasMinMax) {
            i3 = TPErrorType.TP_ERROR_TYPE_SELF_DEV_PLAYER_DECODER_SUBTITLE_STREAM;
        } else {
            i3 = 1237;
        }
        return ((((((((doubleToLongBits ^ i3) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.getMin) >>> 32) ^ Double.doubleToLongBits(this.getMin)))) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.getMax) >>> 32) ^ Double.doubleToLongBits(this.getMax)))) * 1000003) ^ Arrays.hashCode(this.getCounts)) * 1000003) ^ this.getExemplars.hashCode();
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "HistogramAccumulation{getSum=" + this.getSum + ", hasMinMax=" + this.hasMinMax + ", getMin=" + this.getMin + ", getMax=" + this.getMax + ", getCounts=" + Arrays.toString(this.getCounts) + ", getExemplars=" + this.getExemplars + "}";
    }
}
