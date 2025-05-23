package com.tencent.opentelemetry.sdk.trace.export;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.api.logging.DefaultPrintLogger;
import com.tencent.opentelemetry.context.Context;
import com.tencent.opentelemetry.sdk.common.CompletableResultCode;
import com.tencent.opentelemetry.sdk.internal.DaemonThreadFactory;
import com.tencent.opentelemetry.sdk.trace.ReadWriteSpan;
import com.tencent.opentelemetry.sdk.trace.ReadableSpan;
import com.tencent.opentelemetry.sdk.trace.SpanProcessor;
import com.tencent.opentelemetry.sdk.trace.data.SpanData;
import com.tencent.opentelemetry.sdk.trace.export.BatchSpanProcessor;
import com.tencent.opentelemetry.sdk.trace.i;
import com.tencent.opentelemetry.sdk.trace.internal.JcTools;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes22.dex */
public final class BatchSpanProcessor implements SpanProcessor {
    static IPatchRedirector $redirector_;
    private static final String WORKER_THREAD_NAME;
    private final AtomicBoolean isShutdown;
    private final Worker worker;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public static final class Worker implements Runnable {
        static final /* synthetic */ boolean $assertionsDisabled;
        static IPatchRedirector $redirector_;
        private static final String TAG;
        private final ArrayList<SpanData> batch;
        private volatile boolean continueWork;
        private final long exporterTimeoutNanos;
        private final AtomicReference<CompletableResultCode> flushRequested;
        private final int maxExportBatchSize;
        private long nextExportTime;
        private final Queue<ReadableSpan> queue;
        private final long scheduleDelayNanos;
        private final BlockingQueue<Boolean> signal;
        private final SpanExporter spanExporter;
        private final AtomicInteger spansNeeded;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11803);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 4)) {
                redirector.redirect((short) 4);
            } else {
                $assertionsDisabled = true;
                TAG = Worker.class.getName();
            }
        }

        /* synthetic */ Worker(SpanExporter spanExporter, long j3, int i3, long j16, Queue queue, AnonymousClass1 anonymousClass1) {
            this(spanExporter, j3, i3, j16, queue);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, this, spanExporter, Long.valueOf(j3), Integer.valueOf(i3), Long.valueOf(j16), queue, anonymousClass1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addSpan(ReadableSpan readableSpan) {
            if (!this.queue.offer(readableSpan)) {
                if (DefaultPrintLogger.isDebug()) {
                    DefaultPrintLogger.d(TAG, "addSpan drop attribute");
                }
            } else if (this.queue.size() >= this.spansNeeded.get()) {
                this.signal.offer(Boolean.TRUE);
            }
        }

        private void exportCurrentBatch() {
            if (this.batch.isEmpty()) {
                return;
            }
            try {
                try {
                    CompletableResultCode export = this.spanExporter.export(Collections.unmodifiableList(this.batch));
                    export.join(this.exporterTimeoutNanos, TimeUnit.NANOSECONDS);
                    if (DefaultPrintLogger.isDebug()) {
                        DefaultPrintLogger.d(TAG, "Exporter result = " + export.isSuccess());
                    }
                } catch (RuntimeException e16) {
                    if (DefaultPrintLogger.isDebug()) {
                        DefaultPrintLogger.e(TAG, "Exporter threw an Exception", e16);
                    }
                }
            } finally {
                this.batch.clear();
            }
        }

        private void flush() {
            int size = this.queue.size();
            while (size > 0) {
                ReadableSpan poll = this.queue.poll();
                if (!$assertionsDisabled && poll == null) {
                    throw new AssertionError();
                }
                this.batch.add(poll.toSpanData());
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
        public static /* synthetic */ void lambda$shutdown$0(CompletableResultCode completableResultCode, CompletableResultCode completableResultCode2, CompletableResultCode completableResultCode3) {
            if (completableResultCode.isSuccess() && completableResultCode2.isSuccess()) {
                completableResultCode3.succeed();
            } else {
                completableResultCode3.fail();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$shutdown$1(final CompletableResultCode completableResultCode, final CompletableResultCode completableResultCode2) {
            this.continueWork = false;
            final CompletableResultCode shutdown = this.spanExporter.shutdown();
            shutdown.whenComplete(new Runnable() { // from class: com.tencent.opentelemetry.sdk.trace.export.b
                @Override // java.lang.Runnable
                public final void run() {
                    BatchSpanProcessor.Worker.lambda$shutdown$0(CompletableResultCode.this, shutdown, completableResultCode2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public CompletableResultCode shutdown() {
            final CompletableResultCode completableResultCode = new CompletableResultCode();
            final CompletableResultCode forceFlush = forceFlush();
            forceFlush.whenComplete(new Runnable() { // from class: com.tencent.opentelemetry.sdk.trace.export.a
                @Override // java.lang.Runnable
                public final void run() {
                    BatchSpanProcessor.Worker.this.lambda$shutdown$1(forceFlush, completableResultCode);
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
                    this.batch.add(this.queue.poll().toSpanData());
                }
                if (this.batch.size() >= this.maxExportBatchSize || System.nanoTime() >= this.nextExportTime) {
                    exportCurrentBatch();
                    updateNextExportTime();
                }
                if (this.queue.isEmpty()) {
                    try {
                        long nanoTime = this.nextExportTime - System.nanoTime();
                        if (nanoTime > 0) {
                            this.spansNeeded.set(this.maxExportBatchSize - this.batch.size());
                            this.signal.poll(nanoTime, TimeUnit.NANOSECONDS);
                            this.spansNeeded.set(Integer.MAX_VALUE);
                        }
                    } catch (Throwable th5) {
                        if (DefaultPrintLogger.isDebug()) {
                            DefaultPrintLogger.e(TAG, "Worker run  threw an Exception", th5);
                        }
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
            }
        }

        Worker(SpanExporter spanExporter, long j3, int i3, long j16, Queue<ReadableSpan> queue) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, spanExporter, Long.valueOf(j3), Integer.valueOf(i3), Long.valueOf(j16), queue);
                return;
            }
            this.spansNeeded = new AtomicInteger(Integer.MAX_VALUE);
            this.flushRequested = new AtomicReference<>();
            this.continueWork = true;
            this.spanExporter = spanExporter;
            this.scheduleDelayNanos = j3;
            this.maxExportBatchSize = i3;
            this.exporterTimeoutNanos = j16;
            this.queue = queue;
            this.signal = new ArrayBlockingQueue(1);
            this.batch = new ArrayList<>(i3);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11765);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        WORKER_THREAD_NAME = BatchSpanProcessor.class.getSimpleName() + "_WorkerThread";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BatchSpanProcessor(SpanExporter spanExporter, long j3, int i3, int i16, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, spanExporter, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j16));
            return;
        }
        this.isShutdown = new AtomicBoolean(false);
        Worker worker = new Worker(spanExporter, j3, i16, j16, JcTools.newFixedSizeQueue(i3), null);
        this.worker = worker;
        try {
            new DaemonThreadFactory(WORKER_THREAD_NAME).newThread(worker).start();
        } catch (Throwable th5) {
            if (DefaultPrintLogger.isDebug()) {
                DefaultPrintLogger.e("BatchSpanProcessor", "Init workerThread threw an Exception", th5);
            }
        }
    }

    public static BatchSpanProcessorBuilder builder(SpanExporter spanExporter) {
        return new BatchSpanProcessorBuilder(spanExporter);
    }

    @Override // com.tencent.opentelemetry.sdk.trace.SpanProcessor, java.io.Closeable, java.lang.AutoCloseable
    public /* synthetic */ void close() {
        i.a(this);
    }

    @Override // com.tencent.opentelemetry.sdk.trace.SpanProcessor
    public CompletableResultCode forceFlush() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            return this.worker.forceFlush();
        }
        return (CompletableResultCode) iPatchRedirector.redirect((short) 7, (Object) this);
    }

    ArrayList<SpanData> getBatch() {
        return this.worker.batch;
    }

    @Override // com.tencent.opentelemetry.sdk.trace.SpanProcessor
    public boolean isEndRequired() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.opentelemetry.sdk.trace.SpanProcessor
    public boolean isStartRequired() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.opentelemetry.sdk.trace.SpanProcessor
    public void onEnd(ReadableSpan readableSpan) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) readableSpan);
        } else if (readableSpan.getSpanContext().isSampled()) {
            this.worker.addSpan(readableSpan);
        }
    }

    @Override // com.tencent.opentelemetry.sdk.trace.SpanProcessor
    public void onStart(Context context, ReadWriteSpan readWriteSpan) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) readWriteSpan);
        }
    }

    @Override // com.tencent.opentelemetry.sdk.trace.SpanProcessor
    public void reopen() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            this.isShutdown.set(false);
            this.worker.continueWork = true;
        }
    }

    @Override // com.tencent.opentelemetry.sdk.trace.SpanProcessor
    public CompletableResultCode shutdown() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (CompletableResultCode) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        if (!this.isShutdown.getAndSet(true)) {
            return this.worker.shutdown();
        }
        return CompletableResultCode.ofSuccess();
    }
}
