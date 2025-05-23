package com.tencent.opentelemetry.sdk.metrics.internal.data;

import com.google.auto.value.AutoValue;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.sdk.metrics.data.AggregationTemporality;
import com.tencent.opentelemetry.sdk.metrics.data.DoublePointData;
import com.tencent.opentelemetry.sdk.metrics.data.PointData;
import com.tencent.opentelemetry.sdk.metrics.data.SumData;
import java.util.Collection;
import java.util.Collections;
import javax.annotation.concurrent.Immutable;

/* compiled from: P */
@AutoValue
@Immutable
/* loaded from: classes22.dex */
public abstract class ImmutableSumData<T extends PointData> implements SumData<T> {
    static IPatchRedirector $redirector_;
    static final ImmutableSumData<DoublePointData> EMPTY;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20086);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            EMPTY = create(false, AggregationTemporality.CUMULATIVE, Collections.emptyList());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableSumData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static <T extends PointData> ImmutableSumData<T> create(boolean z16, AggregationTemporality aggregationTemporality, Collection<T> collection) {
        return new AutoValue_ImmutableSumData(collection, z16, aggregationTemporality);
    }

    public static <T extends PointData> ImmutableSumData<T> empty() {
        return EMPTY;
    }
}
