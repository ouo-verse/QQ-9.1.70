package com.tencent.opentelemetry.sdk.metrics.internal.export;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.sdk.metrics.export.CollectionRegistration;
import java.util.Collection;
import java.util.Collections;

/* compiled from: P */
/* loaded from: classes22.dex */
public final /* synthetic */ class b {
    public static MetricProducer a(CollectionRegistration collectionRegistration) {
        IPatchRedirector iPatchRedirector = MetricProducer.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (MetricProducer) iPatchRedirector.redirect((short) 1, (Object) collectionRegistration);
        }
        if (collectionRegistration instanceof MetricProducer) {
            return (MetricProducer) collectionRegistration;
        }
        throw new IllegalArgumentException("unrecognized CollectionRegistration, custom MetricReader implementations are not currently supported");
    }

    public static MetricProducer b() {
        IPatchRedirector iPatchRedirector = MetricProducer.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MetricProducer) iPatchRedirector.redirect((short) 2);
        }
        return new MetricProducer() { // from class: com.tencent.opentelemetry.sdk.metrics.internal.export.a
            @Override // com.tencent.opentelemetry.sdk.metrics.internal.export.MetricProducer
            public final Collection collectAllMetrics() {
                return Collections.emptyList();
            }
        };
    }
}
