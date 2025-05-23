package com.tencent.opentelemetry.sdk.metrics.internal.export;

import com.google.auto.value.AutoValue;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.sdk.metrics.InstrumentType;
import com.tencent.opentelemetry.sdk.metrics.data.AggregationTemporality;
import com.tencent.opentelemetry.sdk.metrics.export.MetricReader;
import java.util.Set;
import javax.annotation.concurrent.Immutable;

/* compiled from: P */
@AutoValue
@Immutable
/* loaded from: classes22.dex */
public abstract class CollectionInfo {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CollectionInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static CollectionInfo create(CollectionHandle collectionHandle, Set<CollectionHandle> set, MetricReader metricReader) {
        return new AutoValue_CollectionInfo(collectionHandle, set, metricReader);
    }

    public final AggregationTemporality getAggregationTemporality(InstrumentType instrumentType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AggregationTemporality) iPatchRedirector.redirect((short) 2, (Object) this, (Object) instrumentType);
        }
        return getReader().getAggregationTemporality(instrumentType);
    }

    public abstract Set<CollectionHandle> getAllCollectors();

    public abstract CollectionHandle getCollector();

    public abstract MetricReader getReader();
}
