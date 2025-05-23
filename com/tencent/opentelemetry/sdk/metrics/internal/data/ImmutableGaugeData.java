package com.tencent.opentelemetry.sdk.metrics.internal.data;

import com.google.auto.value.AutoValue;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.sdk.metrics.data.DoublePointData;
import com.tencent.opentelemetry.sdk.metrics.data.GaugeData;
import com.tencent.opentelemetry.sdk.metrics.data.PointData;
import java.util.Collection;
import java.util.Collections;
import javax.annotation.concurrent.Immutable;

/* compiled from: P */
@AutoValue
@Immutable
/* loaded from: classes22.dex */
public abstract class ImmutableGaugeData<T extends PointData> implements GaugeData<T> {
    static IPatchRedirector $redirector_;
    private static final ImmutableGaugeData<DoublePointData> EMPTY;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20405);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            EMPTY = create(Collections.emptyList());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableGaugeData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static <T extends PointData> ImmutableGaugeData<T> create(Collection<T> collection) {
        return new AutoValue_ImmutableGaugeData(collection);
    }

    public static <T extends PointData> ImmutableGaugeData<T> empty() {
        return EMPTY;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.data.Data
    public abstract Collection<T> getPoints();
}
