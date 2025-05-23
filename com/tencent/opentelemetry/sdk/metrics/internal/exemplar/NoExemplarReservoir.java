package com.tencent.opentelemetry.sdk.metrics.internal.exemplar;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.context.Context;
import com.tencent.opentelemetry.sdk.metrics.data.ExemplarData;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
class NoExemplarReservoir implements ExemplarReservoir {
    static IPatchRedirector $redirector_;
    static final ExemplarReservoir INSTANCE;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22052);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new NoExemplarReservoir();
        }
    }

    NoExemplarReservoir() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.exemplar.ExemplarReservoir
    public List<ExemplarData> collectAndReset(Attributes attributes) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this, (Object) attributes);
        }
        return Collections.emptyList();
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.exemplar.ExemplarReservoir
    public void offerMeasurement(double d16, Attributes attributes, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, Double.valueOf(d16), attributes, context);
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.exemplar.ExemplarReservoir
    public void offerMeasurement(long j3, Attributes attributes, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), attributes, context);
    }
}
