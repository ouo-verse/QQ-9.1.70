package com.tencent.opentelemetry.sdk.metrics.internal.data;

import com.google.auto.value.AutoValue;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.sdk.metrics.data.ValueAtQuantile;
import javax.annotation.concurrent.Immutable;

/* compiled from: P */
@AutoValue
@Immutable
/* loaded from: classes22.dex */
public abstract class ImmutableValueAtQuantile implements ValueAtQuantile {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableValueAtQuantile() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static ValueAtQuantile create(double d16, double d17) {
        return new AutoValue_ImmutableValueAtQuantile(d16, d17);
    }
}
