package kotlinx.coroutines.scheduling;

import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.internal.SystemPropsKt;
import kotlinx.coroutines.internal.SystemPropsKt__SystemProps_commonKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\"\u0010\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004\u00a2\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u00018\u0000X\u0081\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000\"\u0010\u0010\u0006\u001a\u00020\u00078\u0000X\u0081\u0004\u00a2\u0006\u0002\n\u0000\"\u0010\u0010\b\u001a\u00020\u00018\u0000X\u0081\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u0010\u0010\u000b\u001a\u00020\u00078\u0000X\u0081\u0004\u00a2\u0006\u0002\n\u0000\"\u0012\u0010\f\u001a\u00020\r8\u0000@\u0000X\u0081\u000e\u00a2\u0006\u0002\n\u0000\"\u0019\u0010\u000e\u001a\u00020\u000f*\u00020\u00108\u00c0\u0002X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u0011\u00a8\u0006\u0012"}, d2 = {"BLOCKING_DEFAULT_PARALLELISM", "", "CORE_POOL_SIZE", "DEFAULT_DISPATCHER_NAME", "", "DEFAULT_SCHEDULER_NAME", "IDLE_WORKER_KEEP_ALIVE_NS", "", "MAX_POOL_SIZE", "TASK_NON_BLOCKING", "TASK_PROBABLY_BLOCKING", "WORK_STEALING_TIME_RESOLUTION_NS", "schedulerTimeSource", "Lkotlinx/coroutines/scheduling/SchedulerTimeSource;", "isBlocking", "", "Lkotlinx/coroutines/scheduling/Task;", "(Lkotlinx/coroutines/scheduling/Task;)Z", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class TasksKt {

    @JvmField
    public static final int BLOCKING_DEFAULT_PARALLELISM;

    @JvmField
    public static final int CORE_POOL_SIZE;

    @NotNull
    public static final String DEFAULT_DISPATCHER_NAME = "Dispatchers.Default";

    @NotNull
    public static final String DEFAULT_SCHEDULER_NAME = "DefaultDispatcher";

    @JvmField
    public static final long IDLE_WORKER_KEEP_ALIVE_NS;

    @JvmField
    public static final int MAX_POOL_SIZE;
    public static final int TASK_NON_BLOCKING = 0;
    public static final int TASK_PROBABLY_BLOCKING = 1;

    @JvmField
    public static final long WORK_STEALING_TIME_RESOLUTION_NS;

    @JvmField
    @NotNull
    public static SchedulerTimeSource schedulerTimeSource;

    static {
        long systemProp$default;
        int systemProp$default2;
        int coerceAtLeast;
        int systemProp$default3;
        int coerceIn;
        int systemProp$default4;
        long systemProp$default5;
        systemProp$default = SystemPropsKt__SystemProps_commonKt.systemProp$default("kotlinx.coroutines.scheduler.resolution.ns", JsonGrayBusiId.UI_RESERVE_100000_110000, 0L, 0L, 12, (Object) null);
        WORK_STEALING_TIME_RESOLUTION_NS = systemProp$default;
        systemProp$default2 = SystemPropsKt__SystemProps_commonKt.systemProp$default("kotlinx.coroutines.scheduler.blocking.parallelism", 16, 0, 0, 12, (Object) null);
        BLOCKING_DEFAULT_PARALLELISM = systemProp$default2;
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(SystemPropsKt.getAVAILABLE_PROCESSORS(), 2);
        systemProp$default3 = SystemPropsKt__SystemProps_commonKt.systemProp$default("kotlinx.coroutines.scheduler.core.pool.size", coerceAtLeast, 1, 0, 8, (Object) null);
        CORE_POOL_SIZE = systemProp$default3;
        coerceIn = RangesKt___RangesKt.coerceIn(SystemPropsKt.getAVAILABLE_PROCESSORS() * 128, systemProp$default3, CoroutineScheduler.MAX_SUPPORTED_POOL_SIZE);
        systemProp$default4 = SystemPropsKt__SystemProps_commonKt.systemProp$default("kotlinx.coroutines.scheduler.max.pool.size", coerceIn, 0, CoroutineScheduler.MAX_SUPPORTED_POOL_SIZE, 4, (Object) null);
        MAX_POOL_SIZE = systemProp$default4;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        systemProp$default5 = SystemPropsKt__SystemProps_commonKt.systemProp$default("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 0L, 0L, 12, (Object) null);
        IDLE_WORKER_KEEP_ALIVE_NS = timeUnit.toNanos(systemProp$default5);
        schedulerTimeSource = NanoTimeSource.INSTANCE;
    }

    public static final boolean isBlocking(@NotNull Task task) {
        if (task.taskContext.getTaskMode() == 1) {
            return true;
        }
        return false;
    }
}
