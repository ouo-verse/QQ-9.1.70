package com.tencent.opentelemetry.sdk.trace.export;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.internal.Utils;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* loaded from: classes22.dex */
public final class BatchSpanProcessorBuilder {
    static IPatchRedirector $redirector_ = null;
    static final int DEFAULT_EXPORT_TIMEOUT_MILLIS = 30000;
    static final int DEFAULT_MAX_EXPORT_BATCH_SIZE = 512;
    static final int DEFAULT_MAX_QUEUE_SIZE = 2048;
    static final long DEFAULT_SCHEDULE_DELAY_MILLIS = 5000;
    private long exporterTimeoutNanos;
    private int maxExportBatchSize;
    private int maxQueueSize;
    private long scheduleDelayNanos;
    private final SpanExporter spanExporter;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BatchSpanProcessorBuilder(SpanExporter spanExporter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) spanExporter);
            return;
        }
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.scheduleDelayNanos = timeUnit.toNanos(5000L);
        this.maxQueueSize = 2048;
        this.maxExportBatchSize = 512;
        this.exporterTimeoutNanos = timeUnit.toNanos(30000L);
        Objects.requireNonNull(spanExporter, "spanExporter");
        this.spanExporter = spanExporter;
    }

    public BatchSpanProcessor build() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (BatchSpanProcessor) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return new BatchSpanProcessor(this.spanExporter, this.scheduleDelayNanos, this.maxQueueSize, this.maxExportBatchSize, this.exporterTimeoutNanos);
    }

    long getExporterTimeoutNanos() {
        return this.exporterTimeoutNanos;
    }

    int getMaxExportBatchSize() {
        return this.maxExportBatchSize;
    }

    int getMaxQueueSize() {
        return this.maxQueueSize;
    }

    long getScheduleDelayNanos() {
        return this.scheduleDelayNanos;
    }

    public BatchSpanProcessorBuilder setExporterTimeout(long j3, TimeUnit timeUnit) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (BatchSpanProcessorBuilder) iPatchRedirector.redirect((short) 4, this, Long.valueOf(j3), timeUnit);
        }
        Objects.requireNonNull(timeUnit, "unit");
        Utils.checkArgument(j3 >= 0, "timeout must be non-negative");
        this.exporterTimeoutNanos = timeUnit.toNanos(j3);
        return this;
    }

    public BatchSpanProcessorBuilder setMaxExportBatchSize(int i3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (BatchSpanProcessorBuilder) iPatchRedirector.redirect((short) 7, (Object) this, i3);
        }
        if (i3 > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        Utils.checkArgument(z16, "maxExportBatchSize must be positive.");
        this.maxExportBatchSize = i3;
        return this;
    }

    public BatchSpanProcessorBuilder setMaxQueueSize(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (BatchSpanProcessorBuilder) iPatchRedirector.redirect((short) 6, (Object) this, i3);
        }
        this.maxQueueSize = i3;
        return this;
    }

    public BatchSpanProcessorBuilder setScheduleDelay(long j3, TimeUnit timeUnit) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (BatchSpanProcessorBuilder) iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), timeUnit);
        }
        Objects.requireNonNull(timeUnit, "unit");
        Utils.checkArgument(j3 >= 0, "delay must be non-negative");
        this.scheduleDelayNanos = timeUnit.toNanos(j3);
        return this;
    }

    public BatchSpanProcessorBuilder setExporterTimeout(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? setExporterTimeout(j3, TimeUnit.NANOSECONDS) : (BatchSpanProcessorBuilder) iPatchRedirector.redirect((short) 5, (Object) this, j3);
    }

    public BatchSpanProcessorBuilder setScheduleDelay(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? setScheduleDelay(j3, TimeUnit.NANOSECONDS) : (BatchSpanProcessorBuilder) iPatchRedirector.redirect((short) 3, (Object) this, j3);
    }
}
