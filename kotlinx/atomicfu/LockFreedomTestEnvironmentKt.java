package kotlinx.atomicfu;

import kotlin.Metadata;
import kotlinx.atomicfu.LockFreedomTestEnvironment;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\u001a\u0006\u0010\u0007\u001a\u00020\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0003X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"MAX_PARK_NANOS", "", "PAUSE_EVERY_N_STEPS", "", "SHUTDOWN_CHECK_MS", "STALL_LIMIT_MS", "STATUS_DONE", "pauseLockFreeOp", "", "atomicfu"}, k = 2, mv = {1, 4, 3})
/* loaded from: classes28.dex */
public final class LockFreedomTestEnvironmentKt {
    private static final long MAX_PARK_NANOS = 1000000;
    private static final int PAUSE_EVERY_N_STEPS = 1000;
    private static final long SHUTDOWN_CHECK_MS = 10;
    private static final long STALL_LIMIT_MS = 15000;
    private static final int STATUS_DONE = Integer.MAX_VALUE;

    public static final void pauseLockFreeOp() {
        Thread currentThread = Thread.currentThread();
        if (!(currentThread instanceof LockFreedomTestEnvironment.TestThread)) {
            currentThread = null;
        }
        LockFreedomTestEnvironment.TestThread testThread = (LockFreedomTestEnvironment.TestThread) currentThread;
        if (testThread != null) {
            testThread.pauseImpl$atomicfu();
        }
    }
}
