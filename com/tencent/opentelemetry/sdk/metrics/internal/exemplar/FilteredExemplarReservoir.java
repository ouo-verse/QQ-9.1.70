package com.tencent.opentelemetry.sdk.metrics.internal.exemplar;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.context.Context;
import com.tencent.opentelemetry.sdk.metrics.data.ExemplarData;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
class FilteredExemplarReservoir implements ExemplarReservoir {
    static IPatchRedirector $redirector_;
    private final ExemplarFilter filter;
    private final ExemplarReservoir reservoir;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FilteredExemplarReservoir(ExemplarFilter exemplarFilter, ExemplarReservoir exemplarReservoir) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) exemplarFilter, (Object) exemplarReservoir);
        } else {
            this.filter = exemplarFilter;
            this.reservoir = exemplarReservoir;
        }
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.exemplar.ExemplarReservoir
    public List<ExemplarData> collectAndReset(Attributes attributes) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this, (Object) attributes);
        }
        return this.reservoir.collectAndReset(attributes);
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.exemplar.ExemplarReservoir
    public void offerMeasurement(long j3, Attributes attributes, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), attributes, context);
        } else if (this.filter.shouldSampleMeasurement(j3, attributes, context)) {
            this.reservoir.offerMeasurement(j3, attributes, context);
        }
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.exemplar.ExemplarReservoir
    public void offerMeasurement(double d16, Attributes attributes, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Double.valueOf(d16), attributes, context);
        } else if (this.filter.shouldSampleMeasurement(d16, attributes, context)) {
            this.reservoir.offerMeasurement(d16, attributes, context);
        }
    }
}
