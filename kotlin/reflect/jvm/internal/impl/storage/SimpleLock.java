package kotlin.reflect.jvm.internal.impl.storage;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface SimpleLock {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        Companion() {
        }

        @NotNull
        public final DefaultSimpleLock simpleLock(@Nullable Runnable runnable, @Nullable Function1<? super InterruptedException, Unit> function1) {
            if (runnable != null && function1 != null) {
                return new CancellableSimpleLock(runnable, function1);
            }
            return new DefaultSimpleLock(null, 1, null);
        }
    }

    void lock();

    void unlock();
}
