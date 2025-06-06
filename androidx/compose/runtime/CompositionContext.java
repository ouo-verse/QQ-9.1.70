package androidx.compose.runtime;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.tooling.CompositionData;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b'\u0018\u00002\u00020\u0001B\u0007\b\u0000\u00a2\u0006\u0002\u0010\u0002J*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0011\u0010\u0015\u001a\r\u0012\u0004\u0012\u00020\u00120\u0016\u00a2\u0006\u0002\b\u0017H \u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001cH \u00a2\u0006\u0002\b\u001dJ\r\u0010\u001e\u001a\u00020\u0012H\u0010\u00a2\u0006\u0002\b\u001fJ-\u0010 \u001a\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010#0!j\u0002`$H\u0010\u00a2\u0006\u0002\b%J\u0015\u0010&\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001cH \u00a2\u0006\u0002\b'J\u0015\u0010(\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H \u00a2\u0006\u0002\b)J\u0015\u0010*\u001a\u00020\u00122\u0006\u0010+\u001a\u00020,H \u00a2\u0006\u0002\b-J\u001d\u0010.\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010/\u001a\u000200H \u00a2\u0006\u0002\b1J\u0017\u00102\u001a\u0004\u0018\u0001002\u0006\u0010\u001b\u001a\u00020\u001cH\u0010\u00a2\u0006\u0002\b3J\u001b\u00104\u001a\u00020\u00122\f\u00105\u001a\b\u0012\u0004\u0012\u00020706H\u0010\u00a2\u0006\u0002\b8J\u0015\u00109\u001a\u00020\u00122\u0006\u0010:\u001a\u00020;H\u0010\u00a2\u0006\u0002\b<J\u0015\u0010=\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H \u00a2\u0006\u0002\b>J\r\u0010?\u001a\u00020\u0012H\u0010\u00a2\u0006\u0002\b@J\u0015\u0010A\u001a\u00020\u00122\u0006\u0010:\u001a\u00020;H\u0010\u00a2\u0006\u0002\bBJ\u0015\u0010C\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H \u00a2\u0006\u0002\bDR\u0012\u0010\u0003\u001a\u00020\u0004X\u00a0\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX\u00a0\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\fX\u00a0\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\fX\u00a0\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u000e\u00a8\u0006E"}, d2 = {"Landroidx/compose/runtime/CompositionContext;", "", "()V", "collectingParameterInformation", "", "getCollectingParameterInformation$runtime_release", "()Z", "compoundHashKey", "", "getCompoundHashKey$runtime_release", "()I", "effectCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getEffectCoroutineContext$runtime_release", "()Lkotlin/coroutines/CoroutineContext;", "recomposeCoroutineContext", "getRecomposeCoroutineContext$runtime_release", "composeInitial", "", "composition", "Landroidx/compose/runtime/ControlledComposition;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "composeInitial$runtime_release", "(Landroidx/compose/runtime/ControlledComposition;Lkotlin/jvm/functions/Function2;)V", "deletedMovableContent", "reference", "Landroidx/compose/runtime/MovableContentStateReference;", "deletedMovableContent$runtime_release", "doneComposing", "doneComposing$runtime_release", "getCompositionLocalScope", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "Landroidx/compose/runtime/CompositionLocal;", "Landroidx/compose/runtime/State;", "Landroidx/compose/runtime/CompositionLocalMap;", "getCompositionLocalScope$runtime_release", "insertMovableContent", "insertMovableContent$runtime_release", "invalidate", "invalidate$runtime_release", "invalidateScope", "scope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "invalidateScope$runtime_release", "movableContentStateReleased", "data", "Landroidx/compose/runtime/MovableContentState;", "movableContentStateReleased$runtime_release", "movableContentStateResolve", "movableContentStateResolve$runtime_release", "recordInspectionTable", "table", "", "Landroidx/compose/runtime/tooling/CompositionData;", "recordInspectionTable$runtime_release", "registerComposer", "composer", "Landroidx/compose/runtime/Composer;", "registerComposer$runtime_release", "registerComposition", "registerComposition$runtime_release", "startComposing", "startComposing$runtime_release", "unregisterComposer", "unregisterComposer$runtime_release", "unregisterComposition", "unregisterComposition$runtime_release", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes39.dex */
public abstract class CompositionContext {
    public static final int $stable = 0;

    public abstract void composeInitial$runtime_release(ControlledComposition composition, Function2<? super Composer, ? super Integer, Unit> content);

    public abstract void deletedMovableContent$runtime_release(MovableContentStateReference reference);

    public abstract boolean getCollectingParameterInformation$runtime_release();

    public PersistentMap<CompositionLocal<Object>, State<Object>> getCompositionLocalScope$runtime_release() {
        return CompositionContextKt.access$getEmptyCompositionLocalMap$p();
    }

    public abstract int getCompoundHashKey$runtime_release();

    /* renamed from: getEffectCoroutineContext$runtime_release */
    public abstract CoroutineContext getEffectCoroutineContext();

    public abstract CoroutineContext getRecomposeCoroutineContext$runtime_release();

    public abstract void insertMovableContent$runtime_release(MovableContentStateReference reference);

    public abstract void invalidate$runtime_release(ControlledComposition composition);

    public abstract void invalidateScope$runtime_release(RecomposeScopeImpl scope);

    public abstract void movableContentStateReleased$runtime_release(MovableContentStateReference reference, MovableContentState data);

    public MovableContentState movableContentStateResolve$runtime_release(MovableContentStateReference reference) {
        Intrinsics.checkNotNullParameter(reference, "reference");
        return null;
    }

    public void recordInspectionTable$runtime_release(Set<CompositionData> table) {
        Intrinsics.checkNotNullParameter(table, "table");
    }

    public void registerComposer$runtime_release(Composer composer) {
        Intrinsics.checkNotNullParameter(composer, "composer");
    }

    public abstract void registerComposition$runtime_release(ControlledComposition composition);

    public void unregisterComposer$runtime_release(Composer composer) {
        Intrinsics.checkNotNullParameter(composer, "composer");
    }

    public abstract void unregisterComposition$runtime_release(ControlledComposition composition);

    public void doneComposing$runtime_release() {
    }

    public void startComposing$runtime_release() {
    }
}
