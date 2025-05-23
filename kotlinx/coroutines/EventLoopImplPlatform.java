package kotlinx.coroutines;

import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlinx.coroutines.EventLoopImplBase;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b \u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0004J\b\u0010\r\u001a\u00020\bH\u0004R\u0012\u0010\u0003\u001a\u00020\u0004X\u00a4\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/EventLoopImplPlatform;", "Lkotlinx/coroutines/EventLoop;", "()V", MosaicConstants$JsProperty.PROP_THREAD, "Ljava/lang/Thread;", "getThread", "()Ljava/lang/Thread;", "reschedule", "", "now", "", "delayedTask", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "unpark", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public abstract class EventLoopImplPlatform extends EventLoop {
    @NotNull
    protected abstract Thread getThread();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void reschedule(long now, @NotNull EventLoopImplBase.DelayedTask delayedTask) {
        DefaultExecutor.INSTANCE.schedule(now, delayedTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void unpark() {
        Thread thread = getThread();
        if (Thread.currentThread() != thread) {
            AbstractTimeSource timeSource = AbstractTimeSourceKt.getTimeSource();
            if (timeSource == null) {
                LockSupport.unpark(thread);
            } else {
                timeSource.unpark(thread);
            }
        }
    }
}
