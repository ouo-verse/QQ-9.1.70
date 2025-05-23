package com.tencent.opentelemetry.sdk.metrics.internal.data;

import com.google.auto.value.AutoValue;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.sdk.metrics.data.SummaryPointData;
import com.tencent.opentelemetry.sdk.metrics.data.ValueAtQuantile;
import java.util.Collections;
import java.util.List;
import javax.annotation.concurrent.Immutable;

@AutoValue
@Immutable
/* loaded from: classes22.dex */
public abstract class ImmutableSummaryPointData implements SummaryPointData {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableSummaryPointData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static ImmutableSummaryPointData create(long j3, long j16, Attributes attributes, long j17, double d16, List<ValueAtQuantile> list) {
        return new AutoValue_ImmutableSummaryPointData(j3, j16, attributes, Collections.emptyList(), j17, d16, list);
    }
}
