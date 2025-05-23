package com.tencent.opentelemetry.sdk.metrics.internal.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.sdk.metrics.data.AggregationTemporality;
import com.tencent.opentelemetry.sdk.metrics.data.HistogramPointData;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes22.dex */
final class AutoValue_ImmutableHistogramData extends ImmutableHistogramData {
    static IPatchRedirector $redirector_;
    private final AggregationTemporality aggregationTemporality;
    private final Collection<HistogramPointData> points;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_ImmutableHistogramData(AggregationTemporality aggregationTemporality, Collection<HistogramPointData> collection) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aggregationTemporality, (Object) collection);
        } else {
            if (aggregationTemporality != null) {
                this.aggregationTemporality = aggregationTemporality;
                if (collection != null) {
                    this.points = collection;
                    return;
                }
                throw new NullPointerException("Null points");
            }
            throw new NullPointerException("Null aggregationTemporality");
        }
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, obj)).booleanValue();
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableHistogramData)) {
            return false;
        }
        ImmutableHistogramData immutableHistogramData = (ImmutableHistogramData) obj;
        if (this.aggregationTemporality.equals(immutableHistogramData.getAggregationTemporality()) && this.points.equals(immutableHistogramData.getPoints())) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.data.HistogramData
    public AggregationTemporality getAggregationTemporality() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AggregationTemporality) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.aggregationTemporality;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.data.HistogramData, com.tencent.opentelemetry.sdk.metrics.data.Data
    public Collection<HistogramPointData> getPoints() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Collection) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.points;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return ((this.aggregationTemporality.hashCode() ^ 1000003) * 1000003) ^ this.points.hashCode();
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "ImmutableHistogramData{aggregationTemporality=" + this.aggregationTemporality + ", points=" + this.points + "}";
    }
}
