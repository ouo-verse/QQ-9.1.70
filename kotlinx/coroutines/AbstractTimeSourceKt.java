package kotlinx.coroutines;

import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.internal.InlineOnly;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\t\u0010\u0006\u001a\u00020\u0007H\u0081\b\u001a\t\u0010\b\u001a\u00020\u0007H\u0081\b\u001a\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0007H\u0081\b\u001a\t\u0010\u000e\u001a\u00020\nH\u0081\b\u001a\t\u0010\u000f\u001a\u00020\nH\u0081\b\u001a\t\u0010\u0010\u001a\u00020\nH\u0081\b\u001a\u0011\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0081\b\u001a\t\u0010\u0014\u001a\u00020\nH\u0081\b\u001a\u0019\u0010\u0015\u001a\u00060\u0016j\u0002`\u00172\n\u0010\u0018\u001a\u00060\u0016j\u0002`\u0017H\u0081\b\"\u001c\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0019"}, d2 = {"timeSource", "Lkotlinx/coroutines/AbstractTimeSource;", "getTimeSource", "()Lkotlinx/coroutines/AbstractTimeSource;", "setTimeSource", "(Lkotlinx/coroutines/AbstractTimeSource;)V", "currentTimeMillis", "", "nanoTime", "parkNanos", "", "blocker", "", "nanos", "registerTimeLoopThread", "trackTask", "unTrackTask", "unpark", MosaicConstants$JsProperty.PROP_THREAD, "Ljava/lang/Thread;", "unregisterTimeLoopThread", "wrapTask", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class AbstractTimeSourceKt {

    @Nullable
    private static AbstractTimeSource timeSource;

    @InlineOnly
    private static final long currentTimeMillis() {
        AbstractTimeSource timeSource2 = getTimeSource();
        if (timeSource2 == null) {
            return System.currentTimeMillis();
        }
        return timeSource2.currentTimeMillis();
    }

    @Nullable
    public static final AbstractTimeSource getTimeSource() {
        return timeSource;
    }

    @InlineOnly
    private static final long nanoTime() {
        AbstractTimeSource timeSource2 = getTimeSource();
        if (timeSource2 == null) {
            return System.nanoTime();
        }
        return timeSource2.nanoTime();
    }

    @InlineOnly
    private static final void parkNanos(Object obj, long j3) {
        AbstractTimeSource timeSource2 = getTimeSource();
        if (timeSource2 == null) {
            LockSupport.parkNanos(obj, j3);
        } else {
            timeSource2.parkNanos(obj, j3);
        }
    }

    @InlineOnly
    private static final void registerTimeLoopThread() {
        AbstractTimeSource timeSource2 = getTimeSource();
        if (timeSource2 != null) {
            timeSource2.registerTimeLoopThread();
        }
    }

    public static final void setTimeSource(@Nullable AbstractTimeSource abstractTimeSource) {
        timeSource = abstractTimeSource;
    }

    @InlineOnly
    private static final void trackTask() {
        AbstractTimeSource timeSource2 = getTimeSource();
        if (timeSource2 != null) {
            timeSource2.trackTask();
        }
    }

    @InlineOnly
    private static final void unTrackTask() {
        AbstractTimeSource timeSource2 = getTimeSource();
        if (timeSource2 != null) {
            timeSource2.unTrackTask();
        }
    }

    @InlineOnly
    private static final void unpark(Thread thread) {
        AbstractTimeSource timeSource2 = getTimeSource();
        if (timeSource2 == null) {
            LockSupport.unpark(thread);
        } else {
            timeSource2.unpark(thread);
        }
    }

    @InlineOnly
    private static final void unregisterTimeLoopThread() {
        AbstractTimeSource timeSource2 = getTimeSource();
        if (timeSource2 != null) {
            timeSource2.unregisterTimeLoopThread();
        }
    }

    @InlineOnly
    private static final Runnable wrapTask(Runnable runnable) {
        AbstractTimeSource timeSource2 = getTimeSource();
        if (timeSource2 != null) {
            return timeSource2.wrapTask(runnable);
        }
        return runnable;
    }
}
