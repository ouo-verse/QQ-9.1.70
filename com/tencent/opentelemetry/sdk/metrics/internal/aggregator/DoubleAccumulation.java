package com.tencent.opentelemetry.sdk.metrics.internal.aggregator;

import com.google.auto.value.AutoValue;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.sdk.metrics.data.ExemplarData;
import java.util.Collections;
import java.util.List;
import javax.annotation.concurrent.Immutable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@AutoValue
@Immutable
/* loaded from: classes22.dex */
public abstract class DoubleAccumulation {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DoubleAccumulation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DoubleAccumulation create(double d16, List<ExemplarData> list) {
        return new AutoValue_DoubleAccumulation(d16, list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract List<ExemplarData> getExemplars();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract double getValue();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DoubleAccumulation create(double d16) {
        return create(d16, Collections.emptyList());
    }
}
