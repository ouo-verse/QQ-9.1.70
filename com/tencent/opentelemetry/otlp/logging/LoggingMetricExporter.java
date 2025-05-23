package com.tencent.opentelemetry.otlp.logging;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.opentelemetry.sdk.common.CompletableResultCode;
import com.tencent.opentelemetry.sdk.metrics.InstrumentType;
import com.tencent.opentelemetry.sdk.metrics.data.AggregationTemporality;
import com.tencent.opentelemetry.sdk.metrics.data.MetricData;
import com.tencent.opentelemetry.sdk.metrics.export.MetricExporter;
import com.tencent.opentelemetry.sdk.metrics.export.a;
import java.util.Collection;
import java.util.Iterator;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: P */
/* loaded from: classes22.dex */
public class LoggingMetricExporter implements MetricExporter {
    static IPatchRedirector $redirector_;
    private static final Logger logger;
    private final AggregationTemporality aggregationTemporality;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(FileMsg.RESULT_CODE_HTTP_SERVER_OTHER);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            logger = Logger.getLogger(LoggingMetricExporter.class.getName());
        }
    }

    LoggingMetricExporter(AggregationTemporality aggregationTemporality) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aggregationTemporality);
        } else {
            this.aggregationTemporality = aggregationTemporality;
        }
    }

    public static LoggingMetricExporter create() {
        return create(AggregationTemporality.CUMULATIVE);
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.export.MetricExporter, java.io.Closeable, java.lang.AutoCloseable
    public /* synthetic */ void close() {
        a.a(this);
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.export.MetricExporter
    public CompletableResultCode export(Collection<MetricData> collection) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (CompletableResultCode) iPatchRedirector.redirect((short) 3, (Object) this, (Object) collection);
        }
        logger.info("Received a collection of " + collection.size() + " metrics for export.");
        Iterator<MetricData> it = collection.iterator();
        while (it.hasNext()) {
            logger.log(Level.INFO, "metric: {0}", it.next());
        }
        return CompletableResultCode.ofSuccess();
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.export.MetricExporter
    public CompletableResultCode flush() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (CompletableResultCode) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        CompletableResultCode completableResultCode = new CompletableResultCode();
        for (Handler handler : logger.getHandlers()) {
            try {
                handler.flush();
            } catch (Throwable unused) {
                return completableResultCode.fail();
            }
        }
        return completableResultCode.succeed();
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.export.MetricExporter
    public AggregationTemporality getAggregationTemporality(InstrumentType instrumentType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AggregationTemporality) iPatchRedirector.redirect((short) 2, (Object) this, (Object) instrumentType);
        }
        return this.aggregationTemporality;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.export.MetricExporter
    public CompletableResultCode shutdown() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (CompletableResultCode) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        flush();
        return CompletableResultCode.ofSuccess();
    }

    public static LoggingMetricExporter create(AggregationTemporality aggregationTemporality) {
        return new LoggingMetricExporter(aggregationTemporality);
    }
}
