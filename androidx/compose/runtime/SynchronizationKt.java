package androidx.compose.runtime;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.aspectj.lang.JoinPoint;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0000\u001a-\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0006H\u0081\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\b"}, d2 = {"createSynchronizedObject", "Landroidx/compose/runtime/SynchronizedObject;", "synchronized", BdhLogUtil.LogTag.Tag_Req, JoinPoint.SYNCHRONIZATION_LOCK, "block", "Lkotlin/Function0;", "(Landroidx/compose/runtime/SynchronizedObject;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "runtime_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes39.dex */
public final class SynchronizationKt {
    public static final SynchronizedObject createSynchronizedObject() {
        return new SynchronizedObject();
    }

    /* renamed from: synchronized, reason: not valid java name */
    public static final <R> R m18synchronized(SynchronizedObject lock, Function0<? extends R> block) {
        R invoke;
        Intrinsics.checkNotNullParameter(lock, "lock");
        Intrinsics.checkNotNullParameter(block, "block");
        synchronized (lock) {
            try {
                invoke = block.invoke();
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
}
