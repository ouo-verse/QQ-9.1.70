package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.Deque;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@GwtIncompatible
/* loaded from: classes2.dex */
public final class SequentialExecutor implements Executor {

    /* renamed from: m, reason: collision with root package name */
    private static final Logger f35153m = Logger.getLogger(SequentialExecutor.class.getName());

    /* renamed from: d, reason: collision with root package name */
    private final Executor f35154d;

    /* renamed from: e, reason: collision with root package name */
    @GuardedBy(SemanticAttributes.MessagingDestinationKindValues.QUEUE)
    private final Deque<Runnable> f35155e;

    /* renamed from: f, reason: collision with root package name */
    @GuardedBy(SemanticAttributes.MessagingDestinationKindValues.QUEUE)
    private WorkerRunningState f35156f;

    /* renamed from: h, reason: collision with root package name */
    @GuardedBy(SemanticAttributes.MessagingDestinationKindValues.QUEUE)
    private long f35157h;

    /* renamed from: i, reason: collision with root package name */
    private final QueueWorker f35158i;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private final class QueueWorker implements Runnable {
        final /* synthetic */ SequentialExecutor this$0;

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0050, code lost:
        
            r1 = r1 | java.lang.Thread.interrupted();
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x0051, code lost:
        
            r3.run();
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0055, code lost:
        
            r2 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0056, code lost:
        
            com.google.common.util.concurrent.SequentialExecutor.f35153m.log(java.util.logging.Level.SEVERE, "Exception while executing runnable " + r3, (java.lang.Throwable) r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x004a, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:?, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void e() {
            boolean z16 = false;
            boolean z17 = false;
            while (true) {
                try {
                    synchronized (this.this$0.f35155e) {
                        if (!z16) {
                            WorkerRunningState workerRunningState = this.this$0.f35156f;
                            WorkerRunningState workerRunningState2 = WorkerRunningState.RUNNING;
                            if (workerRunningState != workerRunningState2) {
                                SequentialExecutor.e(this.this$0);
                                this.this$0.f35156f = workerRunningState2;
                                z16 = true;
                            }
                        }
                        Runnable runnable = (Runnable) this.this$0.f35155e.poll();
                        if (runnable == null) {
                            this.this$0.f35156f = WorkerRunningState.IDLE;
                        }
                    }
                    if (z17) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                    return;
                } finally {
                    if (z17) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                e();
            } catch (Error e16) {
                synchronized (this.this$0.f35155e) {
                    this.this$0.f35156f = WorkerRunningState.IDLE;
                    throw e16;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum WorkerRunningState {
        IDLE,
        QUEUING,
        QUEUED,
        RUNNING
    }

    static /* synthetic */ long e(SequentialExecutor sequentialExecutor) {
        long j3 = sequentialExecutor.f35157h;
        sequentialExecutor.f35157h = 1 + j3;
        return j3;
    }

    @Override // java.util.concurrent.Executor
    public void execute(final Runnable runnable) {
        WorkerRunningState workerRunningState;
        com.google.common.base.j.m(runnable);
        synchronized (this.f35155e) {
            WorkerRunningState workerRunningState2 = this.f35156f;
            if (workerRunningState2 != WorkerRunningState.RUNNING && workerRunningState2 != (workerRunningState = WorkerRunningState.QUEUED)) {
                long j3 = this.f35157h;
                Runnable runnable2 = new Runnable() { // from class: com.google.common.util.concurrent.SequentialExecutor.1
                    @Override // java.lang.Runnable
                    public void run() {
                        runnable.run();
                    }
                };
                this.f35155e.add(runnable2);
                WorkerRunningState workerRunningState3 = WorkerRunningState.QUEUING;
                this.f35156f = workerRunningState3;
                boolean z16 = true;
                try {
                    this.f35154d.execute(this.f35158i);
                    if (this.f35156f == workerRunningState3) {
                        z16 = false;
                    }
                    if (z16) {
                        return;
                    }
                    synchronized (this.f35155e) {
                        if (this.f35157h == j3 && this.f35156f == workerRunningState3) {
                            this.f35156f = workerRunningState;
                        }
                    }
                    return;
                } catch (Error | RuntimeException e16) {
                    synchronized (this.f35155e) {
                        WorkerRunningState workerRunningState4 = this.f35156f;
                        if ((workerRunningState4 != WorkerRunningState.IDLE && workerRunningState4 != WorkerRunningState.QUEUING) || !this.f35155e.removeLastOccurrence(runnable2)) {
                            z16 = false;
                        }
                        if (!(e16 instanceof RejectedExecutionException) || z16) {
                            throw e16;
                        }
                    }
                    return;
                }
            }
            this.f35155e.add(runnable);
        }
    }
}
