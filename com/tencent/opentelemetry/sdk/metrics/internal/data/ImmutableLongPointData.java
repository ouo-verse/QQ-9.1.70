package com.tencent.opentelemetry.sdk.metrics.internal.data;

import com.google.auto.value.AutoValue;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.sdk.metrics.data.ExemplarData;
import com.tencent.opentelemetry.sdk.metrics.data.LongPointData;
import java.util.Collections;
import java.util.List;
import javax.annotation.concurrent.Immutable;

@AutoValue
@Immutable
/* loaded from: classes22.dex */
public abstract class ImmutableLongPointData implements LongPointData {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableLongPointData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static LongPointData create(long j3, long j16, Attributes attributes, long j17) {
        return create(j3, j16, attributes, j17, Collections.emptyList());
    }

    public static LongPointData create(long j3, long j16, Attributes attributes, long j17, List<ExemplarData> list) {
        return new AutoValue_ImmutableLongPointData(j3, j16, attributes, list, j17);
    }
}
