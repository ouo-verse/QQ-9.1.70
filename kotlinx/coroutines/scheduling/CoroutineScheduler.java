package kotlinx.coroutines.scheduling;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.AbstractTimeSource;
import kotlinx.coroutines.AbstractTimeSourceKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b\u0000\u0018\u0000 X2\u00020\\2\u00020]:\u0003XYZB+\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0001\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0004H\u0086\b\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0004H\u0082\b\u00a2\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0001H\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u001d\u001a\u00020\n2\n\u0010\u001a\u001a\u00060\u0018j\u0002`\u00192\u0006\u0010\u001c\u001a\u00020\u001b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0004H\u0082\b\u00a2\u0006\u0004\b\u001f\u0010\u0011J\u0015\u0010!\u001a\b\u0018\u00010 R\u00020\u0000H\u0002\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u0013H\u0082\b\u00a2\u0006\u0004\b#\u0010\u0015J\u0010\u0010$\u001a\u00020\u0001H\u0082\b\u00a2\u0006\u0004\b$\u0010\u0017J-\u0010&\u001a\u00020\u00132\n\u0010\u001a\u001a\u00060\u0018j\u0002`\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010%\u001a\u00020\f\u00a2\u0006\u0004\b&\u0010'J\u001b\u0010)\u001a\u00020\u00132\n\u0010(\u001a\u00060\u0018j\u0002`\u0019H\u0016\u00a2\u0006\u0004\b)\u0010*J\u0010\u0010+\u001a\u00020\u0004H\u0082\b\u00a2\u0006\u0004\b+\u0010,J\u0010\u0010-\u001a\u00020\u0001H\u0082\b\u00a2\u0006\u0004\b-\u0010\u0017J\u001b\u0010/\u001a\u00020\u00012\n\u0010.\u001a\u00060 R\u00020\u0000H\u0002\u00a2\u0006\u0004\b/\u00100J\u0015\u00101\u001a\b\u0018\u00010 R\u00020\u0000H\u0002\u00a2\u0006\u0004\b1\u0010\"J\u0019\u00102\u001a\u00020\f2\n\u0010.\u001a\u00060 R\u00020\u0000\u00a2\u0006\u0004\b2\u00103J)\u00106\u001a\u00020\u00132\n\u0010.\u001a\u00060 R\u00020\u00002\u0006\u00104\u001a\u00020\u00012\u0006\u00105\u001a\u00020\u0001\u00a2\u0006\u0004\b6\u00107J\u0010\u00108\u001a\u00020\u0004H\u0082\b\u00a2\u0006\u0004\b8\u0010,J\u0015\u00109\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b9\u0010:J\u0015\u0010<\u001a\u00020\u00132\u0006\u0010;\u001a\u00020\u0004\u00a2\u0006\u0004\b<\u0010=J\u0017\u0010?\u001a\u00020\u00132\u0006\u0010>\u001a\u00020\fH\u0002\u00a2\u0006\u0004\b?\u0010@J\r\u0010A\u001a\u00020\u0013\u00a2\u0006\u0004\bA\u0010\u0015J\u000f\u0010B\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\bB\u0010CJ\u0010\u0010D\u001a\u00020\fH\u0082\b\u00a2\u0006\u0004\bD\u0010EJ\u0019\u0010F\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u0004H\u0002\u00a2\u0006\u0004\bF\u0010GJ\u000f\u0010H\u001a\u00020\fH\u0002\u00a2\u0006\u0004\bH\u0010EJ+\u0010I\u001a\u0004\u0018\u00010\n*\b\u0018\u00010 R\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010%\u001a\u00020\fH\u0002\u00a2\u0006\u0004\bI\u0010JR\u0017\u0010\u0010\u001a\u00020\u00018\u00c2\u0002@\u0002X\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bK\u0010\u0017R\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0007X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0002\u0010LR\u0017\u0010\u001f\u001a\u00020\u00018\u00c2\u0002@\u0002X\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bM\u0010\u0017R\u0016\u0010O\u001a\u00020N8\u0006@\u0007X\u0087\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010Q\u001a\u00020N8\u0006@\u0007X\u0087\u0004\u00a2\u0006\u0006\n\u0004\bQ\u0010PR\u0016\u0010\u0005\u001a\u00020\u00048\u0006@\u0007X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010RR\u0013\u0010S\u001a\u00020\f8F@\u0006\u00a2\u0006\u0006\u001a\u0004\bS\u0010ER\u0016\u0010\u0003\u001a\u00020\u00018\u0006@\u0007X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010LR\u0016\u0010\u0007\u001a\u00020\u00068\u0006@\u0007X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010TR\"\u0010V\u001a\u000e\u0012\n\u0012\b\u0018\u00010 R\u00020\u00000U8\u0006@\u0007X\u0087\u0004\u00a2\u0006\u0006\n\u0004\bV\u0010W\u00a8\u0006["}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "", "corePoolSize", "maxPoolSize", "", "idleWorkerKeepAliveNs", "", "schedulerName", "<init>", "(IIJLjava/lang/String;)V", "Lkotlinx/coroutines/scheduling/Task;", "task", "", "addToGlobalQueue", "(Lkotlinx/coroutines/scheduling/Task;)Z", "state", "availableCpuPermits", "(J)I", "blockingTasks", "", "close", "()V", "createNewWorker", "()I", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lkotlinx/coroutines/scheduling/TaskContext;", "taskContext", "createTask", "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/TaskContext;)Lkotlinx/coroutines/scheduling/Task;", "createdWorkers", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "currentWorker", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "decrementBlockingTasks", "decrementCreatedWorkers", "tailDispatch", "dispatch", "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/TaskContext;Z)V", "command", "execute", "(Ljava/lang/Runnable;)V", "incrementBlockingTasks", "()J", "incrementCreatedWorkers", "worker", "parkedWorkersStackNextIndex", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;)I", "parkedWorkersStackPop", "parkedWorkersStackPush", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;)Z", "oldIndex", "newIndex", "parkedWorkersStackTopUpdate", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;II)V", "releaseCpuPermit", "runSafely", "(Lkotlinx/coroutines/scheduling/Task;)V", "timeout", "shutdown", "(J)V", "skipUnpark", "signalBlockingWork", "(Z)V", "signalCpuWork", "toString", "()Ljava/lang/String;", "tryAcquireCpuPermit", "()Z", "tryCreateWorker", "(J)Z", "tryUnpark", "submitToLocalQueue", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;Lkotlinx/coroutines/scheduling/Task;Z)Lkotlinx/coroutines/scheduling/Task;", "getAvailableCpuPermits", "I", "getCreatedWorkers", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalBlockingQueue", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalCpuQueue", "J", "isTerminated", "Ljava/lang/String;", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "workers", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "Companion", "Worker", "WorkerState", "kotlinx-coroutines-core", "Ljava/util/concurrent/Executor;", "Ljava/io/Closeable;"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class CoroutineScheduler implements Executor, Closeable {
    private static final long BLOCKING_MASK = 4398044413952L;
    private static final int BLOCKING_SHIFT = 21;
    private static final int CLAIMED = 0;
    private static final long CPU_PERMITS_MASK = 9223367638808264704L;
    private static final int CPU_PERMITS_SHIFT = 42;
    private static final long CREATED_MASK = 2097151;
    public static final int MAX_SUPPORTED_POOL_SIZE = 2097150;
    public static final int MIN_SUPPORTED_POOL_SIZE = 1;
    private static final int PARKED = -1;
    private static final long PARKED_INDEX_MASK = 2097151;
    private static final long PARKED_VERSION_INC = 2097152;
    private static final long PARKED_VERSION_MASK = -2097152;
    private static final int TERMINATED = 1;

    @NotNull
    private volatile /* synthetic */ int _isTerminated;

    @NotNull
    volatile /* synthetic */ long controlState;

    @JvmField
    public final int corePoolSize;

    @JvmField
    @NotNull
    public final GlobalQueue globalBlockingQueue;

    @JvmField
    @NotNull
    public final GlobalQueue globalCpuQueue;

    @JvmField
    public final long idleWorkerKeepAliveNs;

    @JvmField
    public final int maxPoolSize;

    @NotNull
    private volatile /* synthetic */ long parkedWorkersStack;

    @JvmField
    @NotNull
    public final String schedulerName;

    @JvmField
    @NotNull
    public final AtomicReferenceArray<Worker> workers;

    @JvmField
    @NotNull
    public static final Symbol NOT_IN_STACK = new Symbol("NOT_IN_STACK");
    private static final /* synthetic */ AtomicLongFieldUpdater parkedWorkersStack$FU = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "parkedWorkersStack");
    static final /* synthetic */ AtomicLongFieldUpdater controlState$FU = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "controlState");
    private static final /* synthetic */ AtomicIntegerFieldUpdater _isTerminated$FU = AtomicIntegerFieldUpdater.newUpdater(CoroutineScheduler.class, "_isTerminated");

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes28.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[WorkerState.valuesCustom().length];
            iArr[WorkerState.PARKING.ordinal()] = 1;
            iArr[WorkerState.BLOCKING.ordinal()] = 2;
            iArr[WorkerState.CPU_ACQUIRED.ordinal()] = 3;
            iArr[WorkerState.DORMANT.ordinal()] = 4;
            iArr[WorkerState.TERMINATED.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "", "(Ljava/lang/String;I)V", "CPU_ACQUIRED", "BLOCKING", "PARKING", "DORMANT", "TERMINATED", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes28.dex */
    public enum WorkerState {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static WorkerState[] valuesCustom() {
            WorkerState[] valuesCustom = values();
            return (WorkerState[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
        }
    }

    public CoroutineScheduler(int i3, int i16, long j3, @NotNull String str) {
        this.corePoolSize = i3;
        this.maxPoolSize = i16;
        this.idleWorkerKeepAliveNs = j3;
        this.schedulerName = str;
        if (!(i3 >= 1)) {
            throw new IllegalArgumentException(("Core pool size " + i3 + " should be at least 1").toString());
        }
        if (!(i16 >= i3)) {
            throw new IllegalArgumentException(("Max pool size " + i16 + " should be greater than or equals to core pool size " + i3).toString());
        }
        if (!(i16 <= 2097150)) {
            throw new IllegalArgumentException(("Max pool size " + i16 + " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (j3 > 0) {
            this.globalCpuQueue = new GlobalQueue();
            this.globalBlockingQueue = new GlobalQueue();
            this.parkedWorkersStack = 0L;
            this.workers = new AtomicReferenceArray<>(i16 + 1);
            this.controlState = i3 << 42;
            this._isTerminated = 0;
            return;
        }
        throw new IllegalArgumentException(("Idle worker keep alive time " + j3 + " must be positive").toString());
    }

    private final boolean addToGlobalQueue(Task task) {
        boolean z16 = true;
        if (task.taskContext.getTaskMode() != 1) {
            z16 = false;
        }
        if (z16) {
            return this.globalBlockingQueue.addLast(task);
        }
        return this.globalCpuQueue.addLast(task);
    }

    private final int blockingTasks(long state) {
        return (int) ((state & BLOCKING_MASK) >> 21);
    }

    private final int createNewWorker() {
        int coerceAtLeast;
        boolean z16;
        synchronized (this.workers) {
            if (isTerminated()) {
                return -1;
            }
            long j3 = this.controlState;
            int i3 = (int) (j3 & 2097151);
            boolean z17 = false;
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i3 - ((int) ((j3 & BLOCKING_MASK) >> 21)), 0);
            if (coerceAtLeast >= this.corePoolSize) {
                return 0;
            }
            if (i3 >= this.maxPoolSize) {
                return 0;
            }
            int i16 = ((int) (this.controlState & 2097151)) + 1;
            if (i16 > 0 && this.workers.get(i16) == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                Worker worker = new Worker(i16);
                this.workers.set(i16, worker);
                if (i16 == ((int) (2097151 & controlState$FU.incrementAndGet(this)))) {
                    z17 = true;
                }
                if (z17) {
                    worker.start();
                    return coerceAtLeast + 1;
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    private final int createdWorkers(long state) {
        return (int) (state & 2097151);
    }

    private final Worker currentWorker() {
        Worker worker;
        Thread currentThread = Thread.currentThread();
        if (currentThread instanceof Worker) {
            worker = (Worker) currentThread;
        } else {
            worker = null;
        }
        if (worker == null || !Intrinsics.areEqual(CoroutineScheduler.this, this)) {
            return null;
        }
        return worker;
    }

    private final void decrementBlockingTasks() {
        controlState$FU.addAndGet(this, PARKED_VERSION_MASK);
    }

    private final int decrementCreatedWorkers() {
        return (int) (controlState$FU.getAndDecrement(this) & 2097151);
    }

    public static /* synthetic */ void dispatch$default(CoroutineScheduler coroutineScheduler, Runnable runnable, TaskContext taskContext, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            taskContext = NonBlockingContext.INSTANCE;
        }
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        coroutineScheduler.dispatch(runnable, taskContext, z16);
    }

    private final int getAvailableCpuPermits() {
        return (int) ((this.controlState & CPU_PERMITS_MASK) >> 42);
    }

    private final int getCreatedWorkers() {
        return (int) (this.controlState & 2097151);
    }

    private final long incrementBlockingTasks() {
        return controlState$FU.addAndGet(this, 2097152L);
    }

    private final int incrementCreatedWorkers() {
        return (int) (controlState$FU.incrementAndGet(this) & 2097151);
    }

    private final int parkedWorkersStackNextIndex(Worker worker) {
        Object nextParkedWorker = worker.getNextParkedWorker();
        while (nextParkedWorker != NOT_IN_STACK) {
            if (nextParkedWorker == null) {
                return 0;
            }
            Worker worker2 = (Worker) nextParkedWorker;
            int indexInArray = worker2.getIndexInArray();
            if (indexInArray != 0) {
                return indexInArray;
            }
            nextParkedWorker = worker2.getNextParkedWorker();
        }
        return -1;
    }

    private final Worker parkedWorkersStackPop() {
        while (true) {
            long j3 = this.parkedWorkersStack;
            Worker worker = this.workers.get((int) (2097151 & j3));
            if (worker == null) {
                return null;
            }
            long j16 = (2097152 + j3) & PARKED_VERSION_MASK;
            int parkedWorkersStackNextIndex = parkedWorkersStackNextIndex(worker);
            if (parkedWorkersStackNextIndex >= 0 && parkedWorkersStack$FU.compareAndSet(this, j3, parkedWorkersStackNextIndex | j16)) {
                worker.setNextParkedWorker(NOT_IN_STACK);
                return worker;
            }
        }
    }

    private final long releaseCpuPermit() {
        return controlState$FU.addAndGet(this, 4398046511104L);
    }

    private final void signalBlockingWork(boolean skipUnpark) {
        long addAndGet = controlState$FU.addAndGet(this, 2097152L);
        if (skipUnpark || tryUnpark() || tryCreateWorker(addAndGet)) {
            return;
        }
        tryUnpark();
    }

    private final Task submitToLocalQueue(Worker worker, Task task, boolean z16) {
        if (worker == null) {
            return task;
        }
        if (worker.state == WorkerState.TERMINATED) {
            return task;
        }
        if (task.taskContext.getTaskMode() == 0 && worker.state == WorkerState.BLOCKING) {
            return task;
        }
        worker.mayHaveLocalTasks = true;
        return worker.localQueue.add(task, z16);
    }

    private final boolean tryAcquireCpuPermit() {
        long j3;
        do {
            j3 = this.controlState;
            if (((int) ((CPU_PERMITS_MASK & j3) >> 42)) == 0) {
                return false;
            }
        } while (!controlState$FU.compareAndSet(this, j3, j3 - 4398046511104L));
        return true;
    }

    private final boolean tryCreateWorker(long state) {
        int coerceAtLeast;
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(((int) (2097151 & state)) - ((int) ((state & BLOCKING_MASK) >> 21)), 0);
        if (coerceAtLeast < this.corePoolSize) {
            int createNewWorker = createNewWorker();
            if (createNewWorker == 1 && this.corePoolSize > 1) {
                createNewWorker();
            }
            if (createNewWorker > 0) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ boolean tryCreateWorker$default(CoroutineScheduler coroutineScheduler, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = coroutineScheduler.controlState;
        }
        return coroutineScheduler.tryCreateWorker(j3);
    }

    private final boolean tryUnpark() {
        Worker parkedWorkersStackPop;
        do {
            parkedWorkersStackPop = parkedWorkersStackPop();
            if (parkedWorkersStackPop == null) {
                return false;
            }
        } while (!Worker.workerCtl$FU.compareAndSet(parkedWorkersStackPop, -1, 0));
        LockSupport.unpark(parkedWorkersStackPop);
        return true;
    }

    public final int availableCpuPermits(long state) {
        return (int) ((state & CPU_PERMITS_MASK) >> 42);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        shutdown(10000L);
    }

    @NotNull
    public final Task createTask(@NotNull Runnable block, @NotNull TaskContext taskContext) {
        long nanoTime = TasksKt.schedulerTimeSource.nanoTime();
        if (block instanceof Task) {
            Task task = (Task) block;
            task.submissionTime = nanoTime;
            task.taskContext = taskContext;
            return task;
        }
        return new TaskImpl(block, nanoTime, taskContext);
    }

    public final void dispatch(@NotNull Runnable block, @NotNull TaskContext taskContext, boolean tailDispatch) {
        boolean z16;
        AbstractTimeSource timeSource = AbstractTimeSourceKt.getTimeSource();
        if (timeSource != null) {
            timeSource.trackTask();
        }
        Task createTask = createTask(block, taskContext);
        Worker currentWorker = currentWorker();
        Task submitToLocalQueue = submitToLocalQueue(currentWorker, createTask, tailDispatch);
        if (submitToLocalQueue != null && !addToGlobalQueue(submitToLocalQueue)) {
            throw new RejectedExecutionException(Intrinsics.stringPlus(this.schedulerName, " was terminated"));
        }
        if (tailDispatch && currentWorker != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (createTask.taskContext.getTaskMode() == 0) {
            if (z16) {
                return;
            }
            signalCpuWork();
            return;
        }
        signalBlockingWork(z16);
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NotNull Runnable command) {
        dispatch$default(this, command, null, false, 6, null);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [int, boolean] */
    public final boolean isTerminated() {
        return this._isTerminated;
    }

    public final boolean parkedWorkersStackPush(@NotNull Worker worker) {
        long j3;
        long j16;
        int indexInArray;
        if (worker.getNextParkedWorker() != NOT_IN_STACK) {
            return false;
        }
        do {
            j3 = this.parkedWorkersStack;
            j16 = (2097152 + j3) & PARKED_VERSION_MASK;
            indexInArray = worker.getIndexInArray();
            worker.setNextParkedWorker(this.workers.get((int) (2097151 & j3)));
        } while (!parkedWorkersStack$FU.compareAndSet(this, j3, j16 | indexInArray));
        return true;
    }

    public final void parkedWorkersStackTopUpdate(@NotNull Worker worker, int oldIndex, int newIndex) {
        while (true) {
            long j3 = this.parkedWorkersStack;
            int i3 = (int) (2097151 & j3);
            long j16 = (2097152 + j3) & PARKED_VERSION_MASK;
            if (i3 == oldIndex) {
                if (newIndex == 0) {
                    i3 = parkedWorkersStackNextIndex(worker);
                } else {
                    i3 = newIndex;
                }
            }
            if (i3 >= 0 && parkedWorkersStack$FU.compareAndSet(this, j3, j16 | i3)) {
                return;
            }
        }
    }

    public final void runSafely(@NotNull Task task) {
        try {
            task.run();
        } catch (Throwable th5) {
            try {
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th5);
                AbstractTimeSource timeSource = AbstractTimeSourceKt.getTimeSource();
                if (timeSource == null) {
                }
            } finally {
                AbstractTimeSource timeSource2 = AbstractTimeSourceKt.getTimeSource();
                if (timeSource2 != null) {
                    timeSource2.unTrackTask();
                }
            }
        }
    }

    public final void shutdown(long timeout) {
        int i3;
        Task findTask;
        if (!_isTerminated$FU.compareAndSet(this, 0, 1)) {
            return;
        }
        Worker currentWorker = currentWorker();
        synchronized (this.workers) {
            i3 = (int) (this.controlState & 2097151);
        }
        if (1 <= i3) {
            int i16 = 1;
            while (true) {
                int i17 = i16 + 1;
                Worker worker = this.workers.get(i16);
                Intrinsics.checkNotNull(worker);
                if (worker != currentWorker) {
                    while (worker.isAlive()) {
                        LockSupport.unpark(worker);
                        worker.join(timeout);
                    }
                    worker.localQueue.offloadAllWorkTo(this.globalBlockingQueue);
                }
                if (i16 == i3) {
                    break;
                } else {
                    i16 = i17;
                }
            }
        }
        this.globalBlockingQueue.close();
        this.globalCpuQueue.close();
        while (true) {
            if (currentWorker == null) {
                findTask = null;
            } else {
                findTask = currentWorker.findTask(true);
            }
            if (findTask == null) {
                findTask = this.globalCpuQueue.removeFirstOrNull();
            }
            if (findTask == null && (findTask = this.globalBlockingQueue.removeFirstOrNull()) == null) {
                break;
            } else {
                runSafely(findTask);
            }
        }
        if (currentWorker != null) {
            currentWorker.tryReleaseCpu(WorkerState.TERMINATED);
        }
        this.parkedWorkersStack = 0L;
        this.controlState = 0L;
    }

    public final void signalCpuWork() {
        if (tryUnpark() || tryCreateWorker$default(this, 0L, 1, null)) {
            return;
        }
        tryUnpark();
    }

    @NotNull
    public String toString() {
        int i3;
        int i16;
        int i17;
        int i18;
        ArrayList arrayList = new ArrayList();
        int length = this.workers.length();
        int i19 = 0;
        if (1 < length) {
            i16 = 0;
            int i26 = 0;
            i17 = 0;
            i18 = 0;
            int i27 = 1;
            while (true) {
                int i28 = i27 + 1;
                Worker worker = this.workers.get(i27);
                if (worker != null) {
                    int size$kotlinx_coroutines_core = worker.localQueue.getSize$kotlinx_coroutines_core();
                    int i29 = WhenMappings.$EnumSwitchMapping$0[worker.state.ordinal()];
                    if (i29 != 1) {
                        if (i29 != 2) {
                            if (i29 != 3) {
                                if (i29 != 4) {
                                    if (i29 == 5) {
                                        i18++;
                                    }
                                } else {
                                    i17++;
                                    if (size$kotlinx_coroutines_core > 0) {
                                        StringBuilder sb5 = new StringBuilder();
                                        sb5.append(size$kotlinx_coroutines_core);
                                        sb5.append('d');
                                        arrayList.add(sb5.toString());
                                    }
                                }
                            } else {
                                i26++;
                                StringBuilder sb6 = new StringBuilder();
                                sb6.append(size$kotlinx_coroutines_core);
                                sb6.append('c');
                                arrayList.add(sb6.toString());
                            }
                        } else {
                            i16++;
                            StringBuilder sb7 = new StringBuilder();
                            sb7.append(size$kotlinx_coroutines_core);
                            sb7.append('b');
                            arrayList.add(sb7.toString());
                        }
                    } else {
                        i19++;
                    }
                }
                if (i28 >= length) {
                    break;
                }
                i27 = i28;
            }
            i3 = i19;
            i19 = i26;
        } else {
            i3 = 0;
            i16 = 0;
            i17 = 0;
            i18 = 0;
        }
        long j3 = this.controlState;
        return this.schedulerName + '@' + DebugStringsKt.getHexAddress(this) + "[Pool Size {core = " + this.corePoolSize + ", max = " + this.maxPoolSize + "}, Worker States {CPU = " + i19 + ", blocking = " + i16 + ", parked = " + i3 + ", dormant = " + i17 + ", terminated = " + i18 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.globalCpuQueue.getSize() + ", global blocking queue size = " + this.globalBlockingQueue.getSize() + ", Control State {created workers= " + ((int) (2097151 & j3)) + ", blocking tasks = " + ((int) ((BLOCKING_MASK & j3) >> 21)) + ", CPUs acquired = " + (this.corePoolSize - ((int) ((CPU_PERMITS_MASK & j3) >> 42))) + "}]";
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\b\u0080\u0004\u0018\u00002\u00020GB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u00a2\u0006\u0004\b\u0003\u0010\u0004B\t\b\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0001H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0001H\u0002\u00a2\u0006\u0004\b\n\u0010\tJ\u0017\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0013\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0001H\u0002\u00a2\u0006\u0004\b\u0015\u0010\tJ\u000f\u0010\u0016\u001a\u00020\u000fH\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0001\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0007H\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0011\u0010\u001d\u001a\u0004\u0018\u00010\u000bH\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0007H\u0016\u00a2\u0006\u0004\b\u001f\u0010\u001cJ\u000f\u0010 \u001a\u00020\u0007H\u0002\u00a2\u0006\u0004\b \u0010\u001cJ\u000f\u0010!\u001a\u00020\u000fH\u0002\u00a2\u0006\u0004\b!\u0010\u0017J\u000f\u0010\"\u001a\u00020\u0007H\u0002\u00a2\u0006\u0004\b\"\u0010\u001cJ\u0015\u0010%\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020#\u00a2\u0006\u0004\b%\u0010&J\u0019\u0010(\u001a\u0004\u0018\u00010\u000b2\u0006\u0010'\u001a\u00020\u000fH\u0002\u00a2\u0006\u0004\b(\u0010\u0012J\u000f\u0010)\u001a\u00020\u0007H\u0002\u00a2\u0006\u0004\b)\u0010\u001cR*\u0010*\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00018\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010\tR\u0016\u00100\u001a\u00020/8\u0006@\u0007X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00102\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00105\u001a\u0002048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R$\u00108\u001a\u0004\u0018\u0001078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u0016\u0010>\u001a\u00020\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010+R\u0014\u0010B\u001a\u00020?8\u00c6\u0002@\u0006\u00a2\u0006\u0006\u001a\u0004\b@\u0010AR\u0016\u0010C\u001a\u00020#8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010E\u001a\u0002048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u00106\u00a8\u0006F"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "", "index", "<init>", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;I)V", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;)V", "taskMode", "", "afterTask", "(I)V", "beforeTask", "Lkotlinx/coroutines/scheduling/Task;", "task", "executeTask", "(Lkotlinx/coroutines/scheduling/Task;)V", "", "scanLocalQueue", "findAnyTask", "(Z)Lkotlinx/coroutines/scheduling/Task;", "findTask", "mode", "idleReset", "inStack", "()Z", "upperBound", "nextInt", "(I)I", "park", "()V", "pollGlobalQueues", "()Lkotlinx/coroutines/scheduling/Task;", TencentLocation.RUN_MODE, "runWorker", "tryAcquireCpuPermit", "tryPark", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "newState", "tryReleaseCpu", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;)Z", "blockingOnly", "trySteal", "tryTerminateWorker", "indexInArray", "I", "getIndexInArray", "()I", "setIndexInArray", "Lkotlinx/coroutines/scheduling/WorkQueue;", "localQueue", "Lkotlinx/coroutines/scheduling/WorkQueue;", "mayHaveLocalTasks", "Z", "", "minDelayUntilStealableTaskNs", "J", "", "nextParkedWorker", "Ljava/lang/Object;", "getNextParkedWorker", "()Ljava/lang/Object;", "setNextParkedWorker", "(Ljava/lang/Object;)V", "rngState", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "getScheduler", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "scheduler", "state", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "terminationDeadline", "kotlinx-coroutines-core", "Ljava/lang/Thread;"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes28.dex */
    public final class Worker extends BaseThread {
        static final /* synthetic */ AtomicIntegerFieldUpdater workerCtl$FU = AtomicIntegerFieldUpdater.newUpdater(Worker.class, "workerCtl");
        private volatile int indexInArray;

        @JvmField
        @NotNull
        public final WorkQueue localQueue;

        @JvmField
        public boolean mayHaveLocalTasks;
        private long minDelayUntilStealableTaskNs;

        @Nullable
        private volatile Object nextParkedWorker;
        private int rngState;

        @JvmField
        @NotNull
        public WorkerState state;
        private long terminationDeadline;

        @NotNull
        volatile /* synthetic */ int workerCtl;

        Worker() {
            setDaemon(true);
            this.localQueue = new WorkQueue();
            this.state = WorkerState.DORMANT;
            this.workerCtl = 0;
            this.nextParkedWorker = CoroutineScheduler.NOT_IN_STACK;
            this.rngState = Random.INSTANCE.nextInt();
        }

        private final void afterTask(int taskMode) {
            if (taskMode == 0) {
                return;
            }
            CoroutineScheduler.controlState$FU.addAndGet(CoroutineScheduler.this, CoroutineScheduler.PARKED_VERSION_MASK);
            if (this.state != WorkerState.TERMINATED) {
                this.state = WorkerState.DORMANT;
            }
        }

        private final void beforeTask(int taskMode) {
            if (taskMode != 0 && tryReleaseCpu(WorkerState.BLOCKING)) {
                CoroutineScheduler.this.signalCpuWork();
            }
        }

        private final void executeTask(Task task) {
            int taskMode = task.taskContext.getTaskMode();
            idleReset(taskMode);
            beforeTask(taskMode);
            CoroutineScheduler.this.runSafely(task);
            afterTask(taskMode);
        }

        private final Task findAnyTask(boolean scanLocalQueue) {
            boolean z16;
            Task pollGlobalQueues;
            Task pollGlobalQueues2;
            if (scanLocalQueue) {
                if (nextInt(CoroutineScheduler.this.corePoolSize * 2) == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16 && (pollGlobalQueues2 = pollGlobalQueues()) != null) {
                    return pollGlobalQueues2;
                }
                Task poll = this.localQueue.poll();
                if (poll == null) {
                    if (!z16 && (pollGlobalQueues = pollGlobalQueues()) != null) {
                        return pollGlobalQueues;
                    }
                } else {
                    return poll;
                }
            } else {
                Task pollGlobalQueues3 = pollGlobalQueues();
                if (pollGlobalQueues3 != null) {
                    return pollGlobalQueues3;
                }
            }
            return trySteal(false);
        }

        private final void idleReset(int mode) {
            this.terminationDeadline = 0L;
            if (this.state == WorkerState.PARKING) {
                this.state = WorkerState.BLOCKING;
            }
        }

        private final boolean inStack() {
            if (this.nextParkedWorker != CoroutineScheduler.NOT_IN_STACK) {
                return true;
            }
            return false;
        }

        private final void park() {
            if (this.terminationDeadline == 0) {
                this.terminationDeadline = System.nanoTime() + CoroutineScheduler.this.idleWorkerKeepAliveNs;
            }
            LockSupport.parkNanos(CoroutineScheduler.this.idleWorkerKeepAliveNs);
            if (System.nanoTime() - this.terminationDeadline >= 0) {
                this.terminationDeadline = 0L;
                tryTerminateWorker();
            }
        }

        private final Task pollGlobalQueues() {
            if (nextInt(2) == 0) {
                Task removeFirstOrNull = CoroutineScheduler.this.globalCpuQueue.removeFirstOrNull();
                if (removeFirstOrNull == null) {
                    return CoroutineScheduler.this.globalBlockingQueue.removeFirstOrNull();
                }
                return removeFirstOrNull;
            }
            Task removeFirstOrNull2 = CoroutineScheduler.this.globalBlockingQueue.removeFirstOrNull();
            if (removeFirstOrNull2 == null) {
                return CoroutineScheduler.this.globalCpuQueue.removeFirstOrNull();
            }
            return removeFirstOrNull2;
        }

        private final void runWorker() {
            loop0: while (true) {
                boolean z16 = false;
                while (!CoroutineScheduler.this.isTerminated() && this.state != WorkerState.TERMINATED) {
                    Task findTask = findTask(this.mayHaveLocalTasks);
                    if (findTask != null) {
                        this.minDelayUntilStealableTaskNs = 0L;
                        executeTask(findTask);
                    } else {
                        this.mayHaveLocalTasks = false;
                        if (this.minDelayUntilStealableTaskNs != 0) {
                            if (!z16) {
                                z16 = true;
                            } else {
                                tryReleaseCpu(WorkerState.PARKING);
                                Thread.interrupted();
                                LockSupport.parkNanos(this.minDelayUntilStealableTaskNs);
                                this.minDelayUntilStealableTaskNs = 0L;
                            }
                        } else {
                            tryPark();
                        }
                    }
                }
            }
            tryReleaseCpu(WorkerState.TERMINATED);
        }

        private final boolean tryAcquireCpuPermit() {
            boolean z16;
            if (this.state == WorkerState.CPU_ACQUIRED) {
                return true;
            }
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            while (true) {
                long j3 = coroutineScheduler.controlState;
                if (((int) ((CoroutineScheduler.CPU_PERMITS_MASK & j3) >> 42)) == 0) {
                    z16 = false;
                    break;
                }
                if (CoroutineScheduler.controlState$FU.compareAndSet(coroutineScheduler, j3, j3 - 4398046511104L)) {
                    z16 = true;
                    break;
                }
            }
            if (!z16) {
                return false;
            }
            this.state = WorkerState.CPU_ACQUIRED;
            return true;
        }

        private final void tryPark() {
            if (!inStack()) {
                CoroutineScheduler.this.parkedWorkersStackPush(this);
                return;
            }
            this.workerCtl = -1;
            while (inStack() && this.workerCtl == -1 && !CoroutineScheduler.this.isTerminated() && this.state != WorkerState.TERMINATED) {
                tryReleaseCpu(WorkerState.PARKING);
                Thread.interrupted();
                park();
            }
        }

        private final Task trySteal(boolean blockingOnly) {
            long tryStealFrom;
            int i3 = (int) (CoroutineScheduler.this.controlState & 2097151);
            if (i3 < 2) {
                return null;
            }
            int nextInt = nextInt(i3);
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            long j3 = Long.MAX_VALUE;
            for (int i16 = 0; i16 < i3; i16++) {
                nextInt++;
                if (nextInt > i3) {
                    nextInt = 1;
                }
                Worker worker = coroutineScheduler.workers.get(nextInt);
                if (worker != null && worker != this) {
                    if (blockingOnly) {
                        tryStealFrom = this.localQueue.tryStealBlockingFrom(worker.localQueue);
                    } else {
                        tryStealFrom = this.localQueue.tryStealFrom(worker.localQueue);
                    }
                    if (tryStealFrom == -1) {
                        return this.localQueue.poll();
                    }
                    if (tryStealFrom > 0) {
                        j3 = Math.min(j3, tryStealFrom);
                    }
                }
            }
            if (j3 == Long.MAX_VALUE) {
                j3 = 0;
            }
            this.minDelayUntilStealableTaskNs = j3;
            return null;
        }

        private final void tryTerminateWorker() {
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            synchronized (coroutineScheduler.workers) {
                if (coroutineScheduler.isTerminated()) {
                    return;
                }
                if (((int) (coroutineScheduler.controlState & 2097151)) <= coroutineScheduler.corePoolSize) {
                    return;
                }
                if (!workerCtl$FU.compareAndSet(this, -1, 1)) {
                    return;
                }
                int indexInArray = getIndexInArray();
                setIndexInArray(0);
                coroutineScheduler.parkedWorkersStackTopUpdate(this, indexInArray, 0);
                int andDecrement = (int) (CoroutineScheduler.controlState$FU.getAndDecrement(coroutineScheduler) & 2097151);
                if (andDecrement != indexInArray) {
                    Worker worker = coroutineScheduler.workers.get(andDecrement);
                    Intrinsics.checkNotNull(worker);
                    coroutineScheduler.workers.set(indexInArray, worker);
                    worker.setIndexInArray(indexInArray);
                    coroutineScheduler.parkedWorkersStackTopUpdate(worker, andDecrement, indexInArray);
                }
                coroutineScheduler.workers.set(andDecrement, null);
                Unit unit = Unit.INSTANCE;
                this.state = WorkerState.TERMINATED;
            }
        }

        @Nullable
        public final Task findTask(boolean scanLocalQueue) {
            Task removeFirstOrNull;
            if (tryAcquireCpuPermit()) {
                return findAnyTask(scanLocalQueue);
            }
            if (scanLocalQueue) {
                removeFirstOrNull = this.localQueue.poll();
                if (removeFirstOrNull == null) {
                    removeFirstOrNull = CoroutineScheduler.this.globalBlockingQueue.removeFirstOrNull();
                }
            } else {
                removeFirstOrNull = CoroutineScheduler.this.globalBlockingQueue.removeFirstOrNull();
            }
            if (removeFirstOrNull == null) {
                return trySteal(true);
            }
            return removeFirstOrNull;
        }

        public final int getIndexInArray() {
            return this.indexInArray;
        }

        @Nullable
        public final Object getNextParkedWorker() {
            return this.nextParkedWorker;
        }

        @NotNull
        /* renamed from: getScheduler, reason: from getter */
        public final CoroutineScheduler getThis$0() {
            return CoroutineScheduler.this;
        }

        public final int nextInt(int upperBound) {
            int i3 = this.rngState;
            int i16 = i3 ^ (i3 << 13);
            int i17 = i16 ^ (i16 >> 17);
            int i18 = i17 ^ (i17 << 5);
            this.rngState = i18;
            int i19 = upperBound - 1;
            if ((i19 & upperBound) == 0) {
                return i18 & i19;
            }
            return (i18 & Integer.MAX_VALUE) % upperBound;
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            runWorker();
        }

        public final void setIndexInArray(int i3) {
            String valueOf;
            StringBuilder sb5 = new StringBuilder();
            sb5.append(CoroutineScheduler.this.schedulerName);
            sb5.append("-worker-");
            if (i3 == 0) {
                valueOf = "TERMINATED";
            } else {
                valueOf = String.valueOf(i3);
            }
            sb5.append(valueOf);
            setName(sb5.toString());
            this.indexInArray = i3;
        }

        public final void setNextParkedWorker(@Nullable Object obj) {
            this.nextParkedWorker = obj;
        }

        public final boolean tryReleaseCpu(@NotNull WorkerState newState) {
            boolean z16;
            WorkerState workerState = this.state;
            if (workerState == WorkerState.CPU_ACQUIRED) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                CoroutineScheduler.controlState$FU.addAndGet(CoroutineScheduler.this, 4398046511104L);
            }
            if (workerState != newState) {
                this.state = newState;
            }
            return z16;
        }

        public Worker(int i3) {
            this();
            setIndexInArray(i3);
        }
    }

    public /* synthetic */ CoroutineScheduler(int i3, int i16, long j3, String str, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, i16, (i17 & 4) != 0 ? TasksKt.IDLE_WORKER_KEEP_ALIVE_NS : j3, (i17 & 8) != 0 ? TasksKt.DEFAULT_SCHEDULER_NAME : str);
    }
}
