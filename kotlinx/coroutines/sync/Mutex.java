package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.selects.SelectClause2;
import org.aspectj.lang.JoinPoint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0001H&J\u001d\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0001H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0014\u0010\u000e\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0001H&J\u0014\u0010\u000f\u001a\u00020\f2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0001H&R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004R \u0010\u0005\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u00000\u0006X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/sync/Mutex;", "", "isLocked", "", "()Z", "onLock", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnLock", "()Lkotlinx/coroutines/selects/SelectClause2;", "holdsLock", "owner", JoinPoint.SYNCHRONIZATION_LOCK, "", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryLock", JoinPoint.SYNCHRONIZATION_UNLOCK, "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public interface Mutex {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes28.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Object lock$default(Mutex mutex, Object obj, Continuation continuation, int i3, Object obj2) {
            if (obj2 == null) {
                if ((i3 & 1) != 0) {
                    obj = null;
                }
                return mutex.lock(obj, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lock");
        }

        public static /* synthetic */ boolean tryLock$default(Mutex mutex, Object obj, int i3, Object obj2) {
            if (obj2 == null) {
                if ((i3 & 1) != 0) {
                    obj = null;
                }
                return mutex.tryLock(obj);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryLock");
        }

        public static /* synthetic */ void unlock$default(Mutex mutex, Object obj, int i3, Object obj2) {
            if (obj2 == null) {
                if ((i3 & 1) != 0) {
                    obj = null;
                }
                mutex.unlock(obj);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: unlock");
        }
    }

    @NotNull
    SelectClause2<Object, Mutex> getOnLock();

    boolean holdsLock(@NotNull Object owner);

    boolean isLocked();

    @Nullable
    Object lock(@Nullable Object obj, @NotNull Continuation<? super Unit> continuation);

    boolean tryLock(@Nullable Object owner);

    void unlock(@Nullable Object owner);
}
