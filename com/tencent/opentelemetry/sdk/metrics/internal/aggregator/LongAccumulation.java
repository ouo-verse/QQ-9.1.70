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
public abstract class LongAccumulation {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LongAccumulation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static LongAccumulation create(long j3, List<ExemplarData> list) {
        return new AutoValue_LongAccumulation(j3, list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract List<ExemplarData> getExemplars();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract long getValue();

    static LongAccumulation create(long j3) {
        return create(j3, Collections.emptyList());
    }
}
