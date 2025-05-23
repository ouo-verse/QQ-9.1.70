package com.tencent.opentelemetry.sdk.metrics.internal.aggregator;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.context.Context;

/* compiled from: P */
/* loaded from: classes22.dex */
public final /* synthetic */ class a<T> {
    public static Object a(Aggregator aggregator, double d16, Attributes attributes, Context context) {
        IPatchRedirector iPatchRedirector = Aggregator.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, aggregator, Double.valueOf(d16), attributes, context);
        }
        AggregatorHandle<T> createHandle = aggregator.createHandle();
        createHandle.recordDouble(d16, attributes, context);
        return createHandle.accumulateThenReset(attributes);
    }

    public static Object b(Aggregator aggregator, long j3, Attributes attributes, Context context) {
        IPatchRedirector iPatchRedirector = Aggregator.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, aggregator, Long.valueOf(j3), attributes, context);
        }
        AggregatorHandle<T> createHandle = aggregator.createHandle();
        createHandle.recordLong(j3, attributes, context);
        return createHandle.accumulateThenReset(attributes);
    }

    public static Aggregator<Object> c() {
        IPatchRedirector iPatchRedirector = Aggregator.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (Aggregator) iPatchRedirector.redirect((short) 1);
        }
        return DropAggregator.INSTANCE;
    }
}
