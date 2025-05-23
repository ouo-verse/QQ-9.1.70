package com.tencent.opentelemetry.sdk.metrics.internal.exemplar;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.sdk.common.Clock;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

/* compiled from: P */
/* loaded from: classes22.dex */
public final /* synthetic */ class c {
    public static ExemplarReservoir a(ExemplarFilter exemplarFilter, ExemplarReservoir exemplarReservoir) {
        IPatchRedirector iPatchRedirector = ExemplarReservoir.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ExemplarReservoir) iPatchRedirector.redirect((short) 2, (Object) exemplarFilter, (Object) exemplarReservoir);
        }
        if (exemplarFilter == b.b()) {
            return d();
        }
        return new FilteredExemplarReservoir(exemplarFilter, exemplarReservoir);
    }

    public static ExemplarReservoir b(Clock clock, int i3, Supplier<Random> supplier) {
        IPatchRedirector iPatchRedirector = ExemplarReservoir.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ExemplarReservoir) iPatchRedirector.redirect((short) 3, (Object) clock, i3, (Object) supplier);
        }
        return new FixedSizeExemplarReservoir(clock, i3, supplier);
    }

    public static ExemplarReservoir c(Clock clock, List<Double> list) {
        IPatchRedirector iPatchRedirector = ExemplarReservoir.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ExemplarReservoir) iPatchRedirector.redirect((short) 4, (Object) clock, (Object) list);
        }
        return HistogramBucketExemplarReservoir.create(clock, list);
    }

    public static ExemplarReservoir d() {
        IPatchRedirector iPatchRedirector = ExemplarReservoir.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (ExemplarReservoir) iPatchRedirector.redirect((short) 1);
        }
        return NoExemplarReservoir.INSTANCE;
    }
}
