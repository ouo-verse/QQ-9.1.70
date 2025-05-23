package com.tencent.opentelemetry.sdk.metrics.internal.data;

import com.google.auto.value.AutoValue;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.sdk.metrics.data.SummaryData;
import com.tencent.opentelemetry.sdk.metrics.data.SummaryPointData;
import java.util.Collection;
import java.util.Collections;
import javax.annotation.concurrent.Immutable;

/* compiled from: P */
@AutoValue
@Immutable
/* loaded from: classes22.dex */
public abstract class ImmutableSummaryData implements SummaryData {
    static IPatchRedirector $redirector_;
    private static final ImmutableSummaryData EMPTY;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20015);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            EMPTY = create(Collections.emptyList());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableSummaryData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static ImmutableSummaryData create(Collection<SummaryPointData> collection) {
        return new AutoValue_ImmutableSummaryData(collection);
    }

    public static ImmutableSummaryData empty() {
        return EMPTY;
    }
}
