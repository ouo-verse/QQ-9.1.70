package androidx.compose.runtime;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0000\u001a(\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00010\u000b\u00a2\u0006\u0002\b\fH\u0000\u00a2\u0006\u0002\u0010\r\u001a.\u0010\u000e\u001a\u0002H\u000f\"\u0004\b\u0000\u0010\u000f2\u0006\u0010\b\u001a\u00020\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u0002H\u000f0\u000b\u00a2\u0006\u0002\b\fH\u0000\u00a2\u0006\u0002\u0010\u0010*\u001e\b\u0000\u0010\u0011\u001a\u0004\b\u0000\u0010\u0012\"\b\u0012\u0004\u0012\u0002H\u00120\u00132\b\u0012\u0004\u0012\u0002H\u00120\u0013*\f\b\u0000\u0010\u0014\"\u00020\u00152\u00020\u0015\u00a8\u0006\u0016"}, d2 = {"ensureMutable", "", "it", "", "identityHashCode", "", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "invokeComposable", "composer", "Landroidx/compose/runtime/Composer;", "composable", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/runtime/Composer;Lkotlin/jvm/functions/Function2;)V", "invokeComposableForResult", "T", "(Landroidx/compose/runtime/Composer;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "AtomicReference", "V", "Ljava/util/concurrent/atomic/AtomicReference;", "TestOnly", "Lorg/jetbrains/annotations/TestOnly;", "runtime_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes39.dex */
public final class ActualJvm_jvmKt {
    public static final void ensureMutable(Object it) {
        Intrinsics.checkNotNullParameter(it, "it");
    }

    public static final int identityHashCode(Object obj) {
        return System.identityHashCode(obj);
    }

    public static final void invokeComposable(Composer composer, Function2<? super Composer, ? super Integer, Unit> composable) {
        Intrinsics.checkNotNullParameter(composer, "composer");
        Intrinsics.checkNotNullParameter(composable, "composable");
        ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(composable, 2)).invoke(composer, 1);
    }

    public static final <T> T invokeComposableForResult(Composer composer, Function2<? super Composer, ? super Integer, ? extends T> composable) {
        Intrinsics.checkNotNullParameter(composer, "composer");
        Intrinsics.checkNotNullParameter(composable, "composable");
        return (T) ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(composable, 2)).invoke(composer, 1);
    }
}
