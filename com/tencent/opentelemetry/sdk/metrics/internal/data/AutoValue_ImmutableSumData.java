package com.tencent.opentelemetry.sdk.metrics.internal.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.sdk.metrics.data.AggregationTemporality;
import com.tencent.opentelemetry.sdk.metrics.data.PointData;
import com.tencent.thumbplayer.api.common.TPErrorType;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes22.dex */
final class AutoValue_ImmutableSumData<T extends PointData> extends ImmutableSumData<T> {
    static IPatchRedirector $redirector_;
    private final AggregationTemporality aggregationTemporality;
    private final boolean monotonic;
    private final Collection<T> points;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_ImmutableSumData(Collection<T> collection, boolean z16, AggregationTemporality aggregationTemporality) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, collection, Boolean.valueOf(z16), aggregationTemporality);
            return;
        }
        if (collection != null) {
            this.points = collection;
            this.monotonic = z16;
            if (aggregationTemporality != null) {
                this.aggregationTemporality = aggregationTemporality;
                return;
            }
            throw new NullPointerException("Null aggregationTemporality");
        }
        throw new NullPointerException("Null points");
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, obj)).booleanValue();
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableSumData)) {
            return false;
        }
        ImmutableSumData immutableSumData = (ImmutableSumData) obj;
        if (this.points.equals(immutableSumData.getPoints()) && this.monotonic == immutableSumData.isMonotonic() && this.aggregationTemporality.equals(immutableSumData.getAggregationTemporality())) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.data.SumData
    public AggregationTemporality getAggregationTemporality() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (AggregationTemporality) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.aggregationTemporality;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.data.Data
    public Collection<T> getPoints() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Collection) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.points;
    }

    public int hashCode() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        int hashCode = (this.points.hashCode() ^ 1000003) * 1000003;
        if (this.monotonic) {
            i3 = TPErrorType.TP_ERROR_TYPE_SELF_DEV_PLAYER_DECODER_SUBTITLE_STREAM;
        } else {
            i3 = 1237;
        }
        return ((hashCode ^ i3) * 1000003) ^ this.aggregationTemporality.hashCode();
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.data.SumData
    public boolean isMonotonic() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.monotonic;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "ImmutableSumData{points=" + this.points + ", monotonic=" + this.monotonic + ", aggregationTemporality=" + this.aggregationTemporality + "}";
    }
}
