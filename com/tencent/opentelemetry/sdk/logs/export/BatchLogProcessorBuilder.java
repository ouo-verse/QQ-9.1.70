package com.tencent.opentelemetry.sdk.logs.export;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.internal.Utils;
import com.tencent.opentelemetry.api.metrics.MeterProvider;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* loaded from: classes22.dex */
public final class BatchLogProcessorBuilder {
    static IPatchRedirector $redirector_ = null;
    private static final long DEFAULT_EXPORT_TIMEOUT_MILLIS = 30000;
    private static final int DEFAULT_MAX_EXPORT_BATCH_SIZE = 512;
    private static final int DEFAULT_MAX_QUEUE_SIZE = 2048;
    private static final long DEFAULT_SCHEDULE_DELAY_MILLIS = 200;
    private long exporterTimeoutNanos;
    private final LogExporter logExporter;
    private int maxExportBatchSize;
    private int maxQueueSize;
    private MeterProvider meterProvider;
    private long scheduleDelayNanos;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BatchLogProcessorBuilder(LogExporter logExporter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) logExporter);
            return;
        }
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.scheduleDelayNanos = timeUnit.toNanos(DEFAULT_SCHEDULE_DELAY_MILLIS);
        this.maxQueueSize = 2048;
        this.maxExportBatchSize = 512;
        this.exporterTimeoutNanos = timeUnit.toNanos(30000L);
        this.meterProvider = com.tencent.opentelemetry.api.metrics.a.c();
        Objects.requireNonNull(logExporter, "logExporter");
        this.logExporter = logExporter;
    }

    public BatchLogProcessor build() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (BatchLogProcessor) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return new BatchLogProcessor(this.logExporter, this.meterProvider, this.scheduleDelayNanos, this.maxQueueSize, this.maxExportBatchSize, this.exporterTimeoutNanos);
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

    public BatchLogProcessorBuilder setExporterTimeout(long j3, TimeUnit timeUnit) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (BatchLogProcessorBuilder) iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), timeUnit);
        }
        Objects.requireNonNull(timeUnit, "unit");
        if (j3 < 0) {
            z16 = false;
        }
        Utils.checkArgument(z16, "timeout must be non-negative");
        this.exporterTimeoutNanos = timeUnit.toNanos(j3);
        return this;
    }

    public BatchLogProcessorBuilder setMaxExportBatchSize(int i3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (BatchLogProcessorBuilder) iPatchRedirector.redirect((short) 5, (Object) this, i3);
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

    public BatchLogProcessorBuilder setMaxQueueSize(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (BatchLogProcessorBuilder) iPatchRedirector.redirect((short) 4, (Object) this, i3);
        }
        this.maxQueueSize = i3;
        return this;
    }

    public BatchLogProcessorBuilder setMeterProvider(MeterProvider meterProvider) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (BatchLogProcessorBuilder) iPatchRedirector.redirect((short) 6, (Object) this, (Object) meterProvider);
        }
        Objects.requireNonNull(meterProvider, "meterProvider");
        this.meterProvider = meterProvider;
        return this;
    }

    public BatchLogProcessorBuilder setScheduleDelay(long j3, TimeUnit timeUnit) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (BatchLogProcessorBuilder) iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), timeUnit);
        }
        Objects.requireNonNull(timeUnit, "unit");
        if (j3 < 0) {
            z16 = false;
        }
        Utils.checkArgument(z16, "delay must be non-negative");
        this.scheduleDelayNanos = timeUnit.toNanos(j3);
        return this;
    }
}
