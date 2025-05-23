package com.tencent.opentelemetry.sdk.metrics.export;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.internal.Utils;
import com.tencent.opentelemetry.sdk.internal.DaemonThreadFactory;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.util.Objects;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* loaded from: classes22.dex */
public final class PeriodicMetricReaderBuilder {
    static IPatchRedirector $redirector_ = null;
    static final long DEFAULT_SCHEDULE_DELAY_MINUTES = 1;

    @Nullable
    private ScheduledExecutorService executor;
    private long intervalNanos;
    private final MetricExporter metricExporter;

    public PeriodicMetricReaderBuilder(MetricExporter metricExporter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) metricExporter);
        } else {
            this.intervalNanos = TimeUnit.MINUTES.toNanos(1L);
            this.metricExporter = metricExporter;
        }
    }

    public PeriodicMetricReader build() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (PeriodicMetricReader) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        ScheduledExecutorService scheduledExecutorService = this.executor;
        if (scheduledExecutorService == null) {
            scheduledExecutorService = ProxyExecutors.newScheduledThreadPool(1, new DaemonThreadFactory("PeriodicMetricReader"));
        }
        return new PeriodicMetricReader(this.metricExporter, this.intervalNanos, scheduledExecutorService);
    }

    public PeriodicMetricReaderBuilder setExecutor(ScheduledExecutorService scheduledExecutorService) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (PeriodicMetricReaderBuilder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) scheduledExecutorService);
        }
        Objects.requireNonNull(scheduledExecutorService, "executor");
        this.executor = scheduledExecutorService;
        return this;
    }

    public PeriodicMetricReaderBuilder setInterval(long j3, TimeUnit timeUnit) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (PeriodicMetricReaderBuilder) iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), timeUnit);
        }
        Objects.requireNonNull(timeUnit, "unit");
        if (j3 <= 0) {
            z16 = false;
        }
        Utils.checkArgument(z16, "interval must be positive");
        this.intervalNanos = timeUnit.toNanos(j3);
        return this;
    }
}
