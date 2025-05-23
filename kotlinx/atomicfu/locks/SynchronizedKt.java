package kotlinx.atomicfu.locks;

import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import org.aspectj.lang.JoinPoint;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\r\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002H\u0087\b\u001a1\u0010\u0003\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u00042\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00040\tH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\n\u001a-\u0010\u000b\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u0004*\u00060\u0001j\u0002`\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00040\tH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\f*\n\u0010\r\"\u00020\u00012\u00020\u0001*\n\u0010\u000e\"\u00020\u00062\u00020\u0006\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u000f"}, d2 = {"reentrantLock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/atomicfu/locks/ReentrantLock;", "synchronized", "T", JoinPoint.SYNCHRONIZATION_LOCK, "", "Lkotlinx/atomicfu/locks/SynchronizedObject;", "block", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "withLock", "(Ljava/util/concurrent/locks/ReentrantLock;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ReentrantLock", "SynchronizedObject", "atomicfu"}, k = 2, mv = {1, 4, 3})
/* loaded from: classes28.dex */
public final class SynchronizedKt {
    @InlineOnly
    private static final ReentrantLock reentrantLock() {
        return new ReentrantLock();
    }

    @InlineOnly
    /* renamed from: synchronized, reason: not valid java name */
    private static final <T> T m1983synchronized(Object obj, Function0<? extends T> function0) {
        T invoke;
        synchronized (obj) {
            try {
                invoke = function0.invoke();
                InlineMarker.finallyStart(1);
            } catch (Throwable th5) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th5;
            }
        }
        InlineMarker.finallyEnd(1);
        return invoke;
    }

    @InlineOnly
    private static final <T> T withLock(ReentrantLock reentrantLock, Function0<? extends T> function0) {
        reentrantLock.lock();
        try {
            return function0.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            reentrantLock.unlock();
            InlineMarker.finallyEnd(1);
        }
    }
}
