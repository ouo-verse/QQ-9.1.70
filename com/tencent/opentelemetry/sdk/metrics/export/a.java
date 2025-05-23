package com.tencent.opentelemetry.sdk.metrics.export;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.sdk.metrics.InstrumentType;
import com.tencent.opentelemetry.sdk.metrics.data.AggregationTemporality;
import com.tencent.opentelemetry.sdk.metrics.export.MetricExporter;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes22.dex */
public final /* synthetic */ class a {
    public static void a(MetricExporter metricExporter) {
        IPatchRedirector iPatchRedirector = MetricExporter.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) metricExporter);
        } else {
            metricExporter.shutdown().join(10L, TimeUnit.SECONDS);
        }
    }

    public static AggregationTemporality b(InstrumentType instrumentType) {
        IPatchRedirector iPatchRedirector = MetricExporter.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (AggregationTemporality) iPatchRedirector.redirect((short) 1, (Object) instrumentType);
        }
        return AggregationTemporality.CUMULATIVE;
    }

    public static AggregationTemporality c(InstrumentType instrumentType) {
        IPatchRedirector iPatchRedirector = MetricExporter.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AggregationTemporality) iPatchRedirector.redirect((short) 2, (Object) instrumentType);
        }
        int i3 = MetricExporter.AnonymousClass1.$SwitchMap$com$tencent$opentelemetry$sdk$metrics$InstrumentType[instrumentType.ordinal()];
        if (i3 != 1 && i3 != 2) {
            return AggregationTemporality.DELTA;
        }
        return AggregationTemporality.CUMULATIVE;
    }
}
