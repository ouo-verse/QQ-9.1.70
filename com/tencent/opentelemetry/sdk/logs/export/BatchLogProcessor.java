package com.tencent.opentelemetry.sdk.logs.export;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.api.common.AttributeKey;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.api.metrics.LongCounter;
import com.tencent.opentelemetry.api.metrics.Meter;
import com.tencent.opentelemetry.api.metrics.MeterProvider;
import com.tencent.opentelemetry.api.metrics.ObservableLongMeasurement;
import com.tencent.opentelemetry.sdk.common.CompletableResultCode;
import com.tencent.opentelemetry.sdk.internal.DaemonThreadFactory;
import com.tencent.opentelemetry.sdk.logs.LogProcessor;
import com.tencent.opentelemetry.sdk.logs.data.LogData;
import com.tencent.opentelemetry.sdk.logs.export.BatchLogProcessor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes22.dex */
public final class BatchLogProcessor implements LogProcessor {
    static IPatchRedirector $redirector_;
    private static final AttributeKey<Boolean> LOG_PROCESSOR_DROPPED_LABEL;
    private static final AttributeKey<String> LOG_PROCESSOR_TYPE_LABEL;
    private static final String LOG_PROCESSOR_TYPE_VALUE;
    private static final String WORKER_THREAD_NAME;
    private final AtomicBoolean isShutdown;
    private final Worker worker;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public static final class Worker implements Runnable {
        static final /* synthetic */ boolean $assertionsDisabled;
        static IPatchRedirector $redirector_;
        private static final Logger logger;
        private final ArrayList<LogData> batch;
        private volatile boolean continueWork;
        private final Attributes droppedAttrs;
        private final Attributes exportedAttrs;
        private final long exporterTimeoutNanos;
        private final AtomicReference<CompletableResultCode> flushRequested;
        private final LogExporter logExporter;
        private final AtomicInteger logsNeeded;
        private final int maxExportBatchSize;
        private long nextExportTime;
        private final LongCounter processedLogsCounter;
        private final Queue<LogData> queue;
        private final long scheduleDelayNanos;
        private final BlockingQueue<Boolean> signal;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9432);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 4)) {
                redirector.redirect((short) 4);
            } else {
                $assertionsDisabled = true;
                logger = Logger.getLogger(Worker.class.getName());
            }
        }

        /* synthetic */ Worker(LogExporter logExporter, MeterProvider meterProvider, long j3, int i3, long j16, Queue queue, AnonymousClass1 anonymousClass1) {
            this(logExporter, meterProvider, j3, i3, j16, queue);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, this, logExporter, meterProvider, Long.valueOf(j3), Integer.valueOf(i3), Long.valueOf(j16), queue, anonymousClass1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addLog(LogData logData) {
            if (!this.queue.offer(logData)) {
                this.processedLogsCounter.add(1L, this.droppedAttrs);
            } else if (this.queue.size() >= this.logsNeeded.get()) {
                this.signal.offer(Boolean.TRUE);
            }
        }

        private void exportCurrentBatch() {
            if (this.batch.isEmpty()) {
                return;
            }
            try {
                try {
                    CompletableResultCode export = this.logExporter.export(Collections.unmodifiableList(this.batch));
                    export.join(this.exporterTimeoutNanos, TimeUnit.NANOSECONDS);
                    if (export.isSuccess()) {
                        this.processedLogsCounter.add(this.batch.size(), this.exportedAttrs);
                    } else {
                        logger.log(Level.FINE, "Exporter failed");
                    }
                } catch (RuntimeException e16) {
                    logger.log(Level.WARNING, "Exporter threw an Exception", (Throwable) e16);
                }
            } finally {
                this.batch.clear();
            }
        }

        private void flush() {
            int size = this.queue.size();
            while (size > 0) {
                LogData poll = this.queue.poll();
                if (!$assertionsDisabled && poll == null) {
                    throw new AssertionError();
                }
                this.batch.add(poll);
                size--;
                if (this.batch.size() >= this.maxExportBatchSize) {
                    exportCurrentBatch();
                }
            }
            exportCurrentBatch();
            CompletableResultCode completableResultCode = this.flushRequested.get();
            if (completableResultCode != null) {
                completableResultCode.succeed();
                this.flushRequested.set(null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public CompletableResultCode forceFlush() {
            if (androidx.lifecycle.c.a(this.flushRequested, null, new CompletableResultCode())) {
                this.signal.offer(Boolean.TRUE);
            }
            CompletableResultCode completableResultCode = this.flushRequested.get();
            if (completableResultCode == null) {
                return CompletableResultCode.ofSuccess();
            }
            return completableResultCode;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$new$0(Queue queue, ObservableLongMeasurement observableLongMeasurement) {
            observableLongMeasurement.record(queue.size(), com.tencent.opentelemetry.api.common.f.c(BatchLogProcessor.LOG_PROCESSOR_TYPE_LABEL, BatchLogProcessor.LOG_PROCESSOR_TYPE_VALUE));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$shutdown$1(CompletableResultCode completableResultCode, CompletableResultCode completableResultCode2, CompletableResultCode completableResultCode3) {
            if (completableResultCode.isSuccess() && completableResultCode2.isSuccess()) {
                completableResultCode3.succeed();
            } else {
                completableResultCode3.fail();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$shutdown$2(final CompletableResultCode completableResultCode, final CompletableResultCode completableResultCode2) {
            this.continueWork = false;
            final CompletableResultCode shutdown = this.logExporter.shutdown();
            shutdown.whenComplete(new Runnable() { // from class: com.tencent.opentelemetry.sdk.logs.export.c
                @Override // java.lang.Runnable
                public final void run() {
                    BatchLogProcessor.Worker.lambda$shutdown$1(CompletableResultCode.this, shutdown, completableResultCode2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public CompletableResultCode shutdown() {
            final CompletableResultCode completableResultCode = new CompletableResultCode();
            final CompletableResultCode forceFlush = forceFlush();
            forceFlush.whenComplete(new Runnable() { // from class: com.tencent.opentelemetry.sdk.logs.export.a
                @Override // java.lang.Runnable
                public final void run() {
                    BatchLogProcessor.Worker.this.lambda$shutdown$2(forceFlush, completableResultCode);
                }
            });
            return completableResultCode;
        }

        private void updateNextExportTime() {
            this.nextExportTime = System.nanoTime() + this.scheduleDelayNanos;
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            updateNextExportTime();
            while (this.continueWork) {
                if (this.flushRequested.get() != null) {
                    flush();
                }
                while (!this.queue.isEmpty() && this.batch.size() < this.maxExportBatchSize) {
                    this.batch.add(this.queue.poll());
                }
                if (this.batch.size() >= this.maxExportBatchSize || System.nanoTime() >= this.nextExportTime) {
                    exportCurrentBatch();
                    updateNextExportTime();
                }
                if (this.queue.isEmpty()) {
                    try {
                        long nanoTime = this.nextExportTime - System.nanoTime();
                        if (nanoTime > 0) {
                            this.logsNeeded.set(this.maxExportBatchSize - this.batch.size());
                            this.signal.poll(nanoTime, TimeUnit.NANOSECONDS);
                            this.logsNeeded.set(Integer.MAX_VALUE);
                        }
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
            }
        }

        Worker(LogExporter logExporter, MeterProvider meterProvider, long j3, int i3, long j16, final Queue<LogData> queue) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, logExporter, meterProvider, Long.valueOf(j3), Integer.valueOf(i3), Long.valueOf(j16), queue);
                return;
            }
            this.logsNeeded = new AtomicInteger(Integer.MAX_VALUE);
            this.flushRequested = new AtomicReference<>();
            this.continueWork = true;
            this.logExporter = logExporter;
            this.scheduleDelayNanos = j3;
            this.maxExportBatchSize = i3;
            this.exporterTimeoutNanos = j16;
            this.queue = queue;
            this.signal = new ArrayBlockingQueue(1);
            Meter build = meterProvider.meterBuilder("io.opentelemetry.sdk.logs").build();
            build.gaugeBuilder("queueSize").ofLongs().setDescription("The number of logs queued").setUnit("1").buildWithCallback(new Consumer() { // from class: com.tencent.opentelemetry.sdk.logs.export.b
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    BatchLogProcessor.Worker.lambda$new$0(queue, (ObservableLongMeasurement) obj);
                }
            });
            this.processedLogsCounter = build.counterBuilder("processedLogs").setUnit("1").setDescription("The number of logs processed by the BatchLogProcessor. [dropped=true if they were dropped due to high throughput]").build();
            this.droppedAttrs = com.tencent.opentelemetry.api.common.f.d(BatchLogProcessor.LOG_PROCESSOR_TYPE_LABEL, BatchLogProcessor.LOG_PROCESSOR_TYPE_VALUE, BatchLogProcessor.LOG_PROCESSOR_DROPPED_LABEL, Boolean.TRUE);
            this.exportedAttrs = com.tencent.opentelemetry.api.common.f.d(BatchLogProcessor.LOG_PROCESSOR_TYPE_LABEL, BatchLogProcessor.LOG_PROCESSOR_TYPE_VALUE, BatchLogProcessor.LOG_PROCESSOR_DROPPED_LABEL, Boolean.FALSE);
            this.batch = new ArrayList<>(i3);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9242);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        WORKER_THREAD_NAME = BatchLogProcessor.class.getSimpleName() + "_WorkerThread";
        LOG_PROCESSOR_TYPE_LABEL = com.tencent.opentelemetry.api.common.e.h("logProcessorType");
        LOG_PROCESSOR_DROPPED_LABEL = com.tencent.opentelemetry.api.common.e.b("dropped");
        LOG_PROCESSOR_TYPE_VALUE = BatchLogProcessor.class.getSimpleName();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BatchLogProcessor(LogExporter logExporter, MeterProvider meterProvider, long j3, int i3, int i16, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, logExporter, meterProvider, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j16));
            return;
        }
        this.isShutdown = new AtomicBoolean(false);
        Worker worker = new Worker(logExporter, meterProvider, j3, i16, j16, new ArrayBlockingQueue(i3), null);
        this.worker = worker;
        new DaemonThreadFactory(WORKER_THREAD_NAME).newThread(worker).start();
    }

    public static BatchLogProcessorBuilder builder(LogExporter logExporter) {
        return new BatchLogProcessorBuilder(logExporter);
    }

    @Override // com.tencent.opentelemetry.sdk.logs.LogProcessor, java.io.Closeable, java.lang.AutoCloseable
    public /* synthetic */ void close() {
        com.tencent.opentelemetry.sdk.logs.b.a(this);
    }

    @Override // com.tencent.opentelemetry.sdk.logs.LogProcessor
    public void emit(LogData logData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) logData);
        } else if (logData != null) {
            this.worker.addLog(logData);
        }
    }

    @Override // com.tencent.opentelemetry.sdk.logs.LogProcessor
    public CompletableResultCode forceFlush() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return this.worker.forceFlush();
        }
        return (CompletableResultCode) iPatchRedirector.redirect((short) 4, (Object) this);
    }

    ArrayList<LogData> getBatch() {
        return this.worker.batch;
    }

    @Override // com.tencent.opentelemetry.sdk.logs.LogProcessor
    public CompletableResultCode shutdown() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (CompletableResultCode) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (!this.isShutdown.getAndSet(true)) {
            return this.worker.shutdown();
        }
        return CompletableResultCode.ofSuccess();
    }
}
