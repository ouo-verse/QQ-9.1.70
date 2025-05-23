package kotlin.reflect.jvm.internal.impl.storage;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public class DefaultSimpleLock implements SimpleLock {

    @NotNull
    private final Lock lock;

    public DefaultSimpleLock() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final Lock getLock() {
        return this.lock;
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.SimpleLock
    public void lock() {
        this.lock.lock();
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.SimpleLock
    public void unlock() {
        this.lock.unlock();
    }

    public DefaultSimpleLock(@NotNull Lock lock) {
        Intrinsics.checkNotNullParameter(lock, "lock");
        this.lock = lock;
    }

    public /* synthetic */ DefaultSimpleLock(Lock lock, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new ReentrantLock() : lock);
    }
}
