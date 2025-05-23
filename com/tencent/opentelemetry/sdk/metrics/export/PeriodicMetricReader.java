package com.tencent.opentelemetry.sdk.metrics.export;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.api.logging.DefaultPrintLogger;
import com.tencent.opentelemetry.sdk.common.CompletableResultCode;
import com.tencent.opentelemetry.sdk.metrics.InstrumentType;
import com.tencent.opentelemetry.sdk.metrics.data.AggregationTemporality;
import com.tencent.opentelemetry.sdk.metrics.data.MetricData;
import com.tencent.opentelemetry.sdk.metrics.export.PeriodicMetricReader;
import com.tencent.opentelemetry.sdk.metrics.internal.export.MetricProducer;
import java.util.Collection;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;

/* loaded from: classes22.dex */
public final class PeriodicMetricReader implements MetricReader {
    static IPatchRedirector $redirector_;
    private static final String TAG;
    private final MetricExporter exporter;
    private final long intervalNanos;
    private final Object lock;
    private volatile MetricProducer metricProducer;
    private final Scheduled scheduled;

    @Nullable
    private volatile ScheduledFuture<?> scheduledFuture;
    private final ScheduledExecutorService scheduler;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public final class Scheduled implements Runnable {
        static IPatchRedirector $redirector_;
        private final AtomicBoolean exportAvailable;

        /* synthetic */ Scheduled(PeriodicMetricReader periodicMetricReader, AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) periodicMetricReader, (Object) anonymousClass1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$doRun$0(CompletableResultCode completableResultCode, CompletableResultCode completableResultCode2) {
            if (!completableResultCode.isSuccess() && DefaultPrintLogger.isDebug()) {
                DefaultPrintLogger.d(PeriodicMetricReader.TAG, "Exporter failed");
            }
            completableResultCode2.succeed();
            this.exportAvailable.set(true);
        }

        CompletableResultCode doRun() {
            final CompletableResultCode completableResultCode = new CompletableResultCode();
            if (this.exportAvailable.compareAndSet(true, false)) {
                try {
                    Collection<MetricData> collectAllMetrics = PeriodicMetricReader.this.metricProducer.collectAllMetrics();
                    if (collectAllMetrics.isEmpty()) {
                        if (DefaultPrintLogger.isDebug()) {
                            DefaultPrintLogger.d(PeriodicMetricReader.TAG, "No metric data to export - skipping export.");
                        }
                        completableResultCode.succeed();
                        this.exportAvailable.set(true);
                    } else {
                        final CompletableResultCode export = PeriodicMetricReader.this.exporter.export(collectAllMetrics);
                        export.whenComplete(new Runnable() { // from class: com.tencent.opentelemetry.sdk.metrics.export.c
                            @Override // java.lang.Runnable
                            public final void run() {
                                PeriodicMetricReader.Scheduled.this.lambda$doRun$0(export, completableResultCode);
                            }
                        });
                    }
                } catch (Throwable th5) {
                    this.exportAvailable.set(true);
                    if (DefaultPrintLogger.isDebug()) {
                        DefaultPrintLogger.w(PeriodicMetricReader.TAG, "Exporter threw an Exception", th5);
                    }
                    completableResultCode.fail();
                }
            } else {
                if (DefaultPrintLogger.isDebug()) {
                    DefaultPrintLogger.w(PeriodicMetricReader.TAG, "Exporter busy. Dropping metrics.");
                }
                completableResultCode.fail();
            }
            return completableResultCode;
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                doRun();
            }
        }

        CompletableResultCode shutdown() {
            return PeriodicMetricReader.this.exporter.shutdown();
        }

        Scheduled() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.exportAvailable = new AtomicBoolean(true);
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PeriodicMetricReader.this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13736);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            TAG = PeriodicMetricReader.class.getName();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PeriodicMetricReader(MetricExporter metricExporter, long j3, ScheduledExecutorService scheduledExecutorService) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, metricExporter, Long.valueOf(j3), scheduledExecutorService);
            return;
        }
        this.lock = new Object();
        this.metricProducer = com.tencent.opentelemetry.sdk.metrics.internal.export.b.b();
        this.exporter = metricExporter;
        this.intervalNanos = j3;
        this.scheduler = scheduledExecutorService;
        this.scheduled = new Scheduled(this, null);
    }

    public static PeriodicMetricReaderBuilder builder(MetricExporter metricExporter) {
        return new PeriodicMetricReaderBuilder(metricExporter);
    }

    public static PeriodicMetricReader create(MetricExporter metricExporter) {
        return builder(metricExporter).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$shutdown$0(CompletableResultCode completableResultCode, CompletableResultCode completableResultCode2) {
        if (!completableResultCode.isSuccess()) {
            completableResultCode2.fail();
        } else {
            completableResultCode2.succeed();
        }
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.export.MetricReader
    public CompletableResultCode flush() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (CompletableResultCode) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.scheduled.doRun();
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.export.MetricReader
    public AggregationTemporality getAggregationTemporality(InstrumentType instrumentType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AggregationTemporality) iPatchRedirector.redirect((short) 2, (Object) this, (Object) instrumentType);
        }
        return this.exporter.getAggregationTemporality(instrumentType);
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.export.MetricReader
    public void register(CollectionRegistration collectionRegistration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) collectionRegistration);
        } else {
            this.metricProducer = com.tencent.opentelemetry.sdk.metrics.internal.export.b.a(collectionRegistration);
            start();
        }
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.export.MetricReader
    public CompletableResultCode shutdown() {
        final CompletableResultCode shutdown;
        Runnable runnable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (CompletableResultCode) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        final CompletableResultCode completableResultCode = new CompletableResultCode();
        ScheduledFuture<?> scheduledFuture = this.scheduledFuture;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.scheduler.shutdown();
        try {
            try {
                ScheduledExecutorService scheduledExecutorService = this.scheduler;
                TimeUnit timeUnit = TimeUnit.SECONDS;
                scheduledExecutorService.awaitTermination(5L, timeUnit);
                this.scheduled.doRun().join(5L, timeUnit);
                shutdown = this.scheduled.shutdown();
                runnable = new Runnable() { // from class: com.tencent.opentelemetry.sdk.metrics.export.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        PeriodicMetricReader.lambda$shutdown$0(CompletableResultCode.this, completableResultCode);
                    }
                };
            } catch (InterruptedException unused) {
                this.scheduler.shutdownNow();
                Thread.currentThread().interrupt();
                shutdown = this.scheduled.shutdown();
                runnable = new Runnable() { // from class: com.tencent.opentelemetry.sdk.metrics.export.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        PeriodicMetricReader.lambda$shutdown$0(CompletableResultCode.this, completableResultCode);
                    }
                };
            }
            shutdown.whenComplete(runnable);
            return completableResultCode;
        } catch (Throwable th5) {
            final CompletableResultCode shutdown2 = this.scheduled.shutdown();
            shutdown2.whenComplete(new Runnable() { // from class: com.tencent.opentelemetry.sdk.metrics.export.b
                @Override // java.lang.Runnable
                public final void run() {
                    PeriodicMetricReader.lambda$shutdown$0(CompletableResultCode.this, completableResultCode);
                }
            });
            throw th5;
        }
    }

    void start() {
        synchronized (this.lock) {
            if (this.scheduledFuture != null) {
                return;
            }
            ScheduledExecutorService scheduledExecutorService = this.scheduler;
            Scheduled scheduled = this.scheduled;
            long j3 = this.intervalNanos;
            this.scheduledFuture = scheduledExecutorService.scheduleAtFixedRate(scheduled, j3, j3, TimeUnit.NANOSECONDS);
        }
    }
}
