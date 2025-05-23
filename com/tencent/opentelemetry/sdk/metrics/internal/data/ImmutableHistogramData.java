package com.tencent.opentelemetry.sdk.metrics.internal.data;

import com.google.auto.value.AutoValue;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.sdk.metrics.data.AggregationTemporality;
import com.tencent.opentelemetry.sdk.metrics.data.HistogramData;
import com.tencent.opentelemetry.sdk.metrics.data.HistogramPointData;
import java.util.Collection;
import java.util.Collections;
import javax.annotation.concurrent.Immutable;

/* compiled from: P */
@AutoValue
@Immutable
/* loaded from: classes22.dex */
public abstract class ImmutableHistogramData implements HistogramData {
    static IPatchRedirector $redirector_;
    private static final ImmutableHistogramData EMPTY;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20252);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            EMPTY = create(AggregationTemporality.CUMULATIVE, Collections.emptyList());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableHistogramData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static ImmutableHistogramData create(AggregationTemporality aggregationTemporality, Collection<HistogramPointData> collection) {
        return new AutoValue_ImmutableHistogramData(aggregationTemporality, collection);
    }

    public static ImmutableHistogramData empty() {
        return EMPTY;
    }
}
