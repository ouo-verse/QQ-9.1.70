package kotlinx.coroutines.scheduling;

import com.google.common.util.concurrent.b;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlinx.coroutines.debug.internal.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0000\b\u0000\u0018\u00002\u00020*B\u0007\u00a2\u0006\u0004\b\u0001\u0010\u0002J!\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0011\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u000bH\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0000\u00a2\u0006\u0004\b\u001a\u0010\u0019J\u001f\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0005H\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001e\u001a\u00020\r*\u0004\u0018\u00010\u0003H\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fR\u001e\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030 8\u0002@\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020#8@@\u0000X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020#8@@\u0000X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b'\u0010%\u00a8\u0006)"}, d2 = {"Lkotlinx/coroutines/scheduling/WorkQueue;", "<init>", "()V", "Lkotlinx/coroutines/scheduling/Task;", "task", "", "fair", "add", "(Lkotlinx/coroutines/scheduling/Task;Z)Lkotlinx/coroutines/scheduling/Task;", "addLast", "(Lkotlinx/coroutines/scheduling/Task;)Lkotlinx/coroutines/scheduling/Task;", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalQueue", "", "offloadAllWorkTo", "(Lkotlinx/coroutines/scheduling/GlobalQueue;)V", "poll", "()Lkotlinx/coroutines/scheduling/Task;", "pollBuffer", SemanticAttributes.MessagingDestinationKindValues.QUEUE, "pollTo", "(Lkotlinx/coroutines/scheduling/GlobalQueue;)Z", "victim", "", "tryStealBlockingFrom", "(Lkotlinx/coroutines/scheduling/WorkQueue;)J", "tryStealFrom", "blockingOnly", "tryStealLastScheduled", "(Lkotlinx/coroutines/scheduling/WorkQueue;Z)J", "decrementIfBlocking", "(Lkotlinx/coroutines/scheduling/Task;)V", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "buffer", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "", "getBufferSize$kotlinx_coroutines_core", "()I", "bufferSize", "getSize$kotlinx_coroutines_core", "size", "kotlinx-coroutines-core", ""}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class WorkQueue {
    private static final /* synthetic */ AtomicReferenceFieldUpdater lastScheduledTask$FU = AtomicReferenceFieldUpdater.newUpdater(WorkQueue.class, Object.class, "lastScheduledTask");
    private static final /* synthetic */ AtomicIntegerFieldUpdater producerIndex$FU = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "producerIndex");
    private static final /* synthetic */ AtomicIntegerFieldUpdater consumerIndex$FU = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "consumerIndex");
    private static final /* synthetic */ AtomicIntegerFieldUpdater blockingTasksInBuffer$FU = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "blockingTasksInBuffer");

    @NotNull
    private final AtomicReferenceArray<Task> buffer = new AtomicReferenceArray<>(128);

    @NotNull
    private volatile /* synthetic */ Object lastScheduledTask = null;

    @NotNull
    private volatile /* synthetic */ int producerIndex = 0;

    @NotNull
    private volatile /* synthetic */ int consumerIndex = 0;

    @NotNull
    private volatile /* synthetic */ int blockingTasksInBuffer = 0;

    public static /* synthetic */ Task add$default(WorkQueue workQueue, Task task, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        return workQueue.add(task, z16);
    }

    private final Task addLast(Task task) {
        boolean z16 = true;
        if (task.taskContext.getTaskMode() != 1) {
            z16 = false;
        }
        if (z16) {
            blockingTasksInBuffer$FU.incrementAndGet(this);
        }
        if (getBufferSize$kotlinx_coroutines_core() == 127) {
            return task;
        }
        int i3 = this.producerIndex & 127;
        while (this.buffer.get(i3) != null) {
            Thread.yield();
        }
        this.buffer.lazySet(i3, task);
        producerIndex$FU.incrementAndGet(this);
        return null;
    }

    private final void decrementIfBlocking(Task task) {
        if (task != null) {
            boolean z16 = true;
            if (task.taskContext.getTaskMode() != 1) {
                z16 = false;
            }
            if (z16) {
                blockingTasksInBuffer$FU.decrementAndGet(this);
            }
        }
    }

    private final Task pollBuffer() {
        Task andSet;
        while (true) {
            int i3 = this.consumerIndex;
            if (i3 - this.producerIndex == 0) {
                return null;
            }
            int i16 = i3 & 127;
            if (consumerIndex$FU.compareAndSet(this, i3, i3 + 1) && (andSet = this.buffer.getAndSet(i16, null)) != null) {
                decrementIfBlocking(andSet);
                return andSet;
            }
        }
    }

    private final boolean pollTo(GlobalQueue queue) {
        Task pollBuffer = pollBuffer();
        if (pollBuffer == null) {
            return false;
        }
        queue.addLast(pollBuffer);
        return true;
    }

    private final long tryStealLastScheduled(WorkQueue victim, boolean blockingOnly) {
        Task task;
        do {
            task = (Task) victim.lastScheduledTask;
            if (task == null) {
                return -2L;
            }
            if (blockingOnly) {
                boolean z16 = true;
                if (task.taskContext.getTaskMode() != 1) {
                    z16 = false;
                }
                if (!z16) {
                    return -2L;
                }
            }
            long nanoTime = TasksKt.schedulerTimeSource.nanoTime() - task.submissionTime;
            long j3 = TasksKt.WORK_STEALING_TIME_RESOLUTION_NS;
            if (nanoTime < j3) {
                return j3 - nanoTime;
            }
        } while (!b.a(lastScheduledTask$FU, victim, task, null));
        add$default(this, task, false, 2, null);
        return -1L;
    }

    @Nullable
    public final Task add(@NotNull Task task, boolean fair) {
        if (fair) {
            return addLast(task);
        }
        Task task2 = (Task) lastScheduledTask$FU.getAndSet(this, task);
        if (task2 == null) {
            return null;
        }
        return addLast(task2);
    }

    public final int getBufferSize$kotlinx_coroutines_core() {
        return this.producerIndex - this.consumerIndex;
    }

    public final int getSize$kotlinx_coroutines_core() {
        if (this.lastScheduledTask != null) {
            return getBufferSize$kotlinx_coroutines_core() + 1;
        }
        return getBufferSize$kotlinx_coroutines_core();
    }

    public final void offloadAllWorkTo(@NotNull GlobalQueue globalQueue) {
        Task task = (Task) lastScheduledTask$FU.getAndSet(this, null);
        if (task != null) {
            globalQueue.addLast(task);
        }
        do {
        } while (pollTo(globalQueue));
    }

    @Nullable
    public final Task poll() {
        Task task = (Task) lastScheduledTask$FU.getAndSet(this, null);
        if (task == null) {
            return pollBuffer();
        }
        return task;
    }

    public final long tryStealBlockingFrom(@NotNull WorkQueue victim) {
        int i3 = victim.consumerIndex;
        int i16 = victim.producerIndex;
        AtomicReferenceArray<Task> atomicReferenceArray = victim.buffer;
        while (true) {
            boolean z16 = true;
            if (i3 == i16) {
                break;
            }
            int i17 = i3 & 127;
            if (victim.blockingTasksInBuffer == 0) {
                break;
            }
            Task task = atomicReferenceArray.get(i17);
            if (task != null) {
                if (task.taskContext.getTaskMode() != 1) {
                    z16 = false;
                }
                if (z16 && a.a(atomicReferenceArray, i17, task, null)) {
                    blockingTasksInBuffer$FU.decrementAndGet(victim);
                    add$default(this, task, false, 2, null);
                    return -1L;
                }
            }
            i3++;
        }
        return tryStealLastScheduled(victim, true);
    }

    public final long tryStealFrom(@NotNull WorkQueue victim) {
        Task pollBuffer = victim.pollBuffer();
        if (pollBuffer != null) {
            add$default(this, pollBuffer, false, 2, null);
            return -1L;
        }
        return tryStealLastScheduled(victim, false);
    }
}
