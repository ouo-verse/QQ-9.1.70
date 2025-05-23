package com.tencent.opentelemetry.sdk.metrics.internal.data;

import com.google.auto.value.AutoValue;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.sdk.metrics.data.DoublePointData;
import com.tencent.opentelemetry.sdk.metrics.data.ExemplarData;
import java.util.Collections;
import java.util.List;
import javax.annotation.concurrent.Immutable;

@AutoValue
@Immutable
/* loaded from: classes22.dex */
public abstract class ImmutableDoublePointData implements DoublePointData {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableDoublePointData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static DoublePointData create(long j3, long j16, Attributes attributes, double d16) {
        return create(j3, j16, attributes, d16, Collections.emptyList());
    }

    public static DoublePointData create(long j3, long j16, Attributes attributes, double d16, List<ExemplarData> list) {
        return new AutoValue_ImmutableDoublePointData(j3, j16, attributes, list, d16);
    }
}
