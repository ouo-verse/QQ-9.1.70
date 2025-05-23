package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArrayMap;
import androidx.compose.runtime.collection.IdentityArraySet;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u001a\u001a\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\r\u001a\u00020\u000e\u001a$\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u001a\u0010\u000f\u001a\u00020\u00042\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\r\u001a\u00020\u000e\u001a$\u0010\u000f\u001a\u00020\u00042\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013\u001a\u000e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0001\u001aI\u0010\u0016\u001a\u00020\u0011\"\b\b\u0000\u0010\u0017*\u00020\u0001\"\b\b\u0001\u0010\u0018*\u00020\u0001*\u0016\u0012\u0004\u0012\u0002H\u0017\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0018\u0018\u00010\u001a0\u00192\u0006\u0010\u0012\u001a\u0002H\u00172\u0006\u0010\u001b\u001a\u0002H\u0018H\u0002\u00a2\u0006\u0002\u0010\u001c\u001a7\u0010\u001d\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u001e*\u0012\u0012\u0004\u0012\u0002H\u001e0\u001fj\b\u0012\u0004\u0012\u0002H\u001e` 2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020#0\"H\u0082\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u001e\u0010\u0002\u001a\u00020\u0003*\u00020\u00048GX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006$"}, d2 = {"PendingApplyNoModifications", "", "recomposeCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "Landroidx/compose/runtime/ControlledComposition;", "getRecomposeCoroutineContext$annotations", "(Landroidx/compose/runtime/ControlledComposition;)V", "getRecomposeCoroutineContext", "(Landroidx/compose/runtime/ControlledComposition;)Lkotlin/coroutines/CoroutineContext;", "Composition", "Landroidx/compose/runtime/Composition;", "applier", "Landroidx/compose/runtime/Applier;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/compose/runtime/CompositionContext;", "ControlledComposition", "invalidateGroupsWithKey", "", "key", "", "simulateHotReload", "context", "addValue", "K", "V", "Landroidx/compose/runtime/collection/IdentityArrayMap;", "Landroidx/compose/runtime/collection/IdentityArraySet;", "value", "(Landroidx/compose/runtime/collection/IdentityArrayMap;Ljava/lang/Object;Ljava/lang/Object;)V", "removeValueIf", "E", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "predicate", "Lkotlin/Function1;", "", "runtime_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes39.dex */
public final class CompositionKt {
    private static final Object PendingApplyNoModifications = new Object();

    public static final Composition Composition(Applier<?> applier, CompositionContext parent) {
        Intrinsics.checkNotNullParameter(applier, "applier");
        Intrinsics.checkNotNullParameter(parent, "parent");
        return new CompositionImpl(parent, applier, null, 4, null);
    }

    public static final ControlledComposition ControlledComposition(Applier<?> applier, CompositionContext parent) {
        Intrinsics.checkNotNullParameter(applier, "applier");
        Intrinsics.checkNotNullParameter(parent, "parent");
        return new CompositionImpl(parent, applier, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <K, V> void addValue(IdentityArrayMap<K, IdentityArraySet<V>> identityArrayMap, K k3, V v3) {
        if (identityArrayMap.contains(k3)) {
            IdentityArraySet<V> identityArraySet = identityArrayMap.get(k3);
            if (identityArraySet != null) {
                identityArraySet.add(v3);
                return;
            }
            return;
        }
        IdentityArraySet<V> identityArraySet2 = new IdentityArraySet<>();
        identityArraySet2.add(v3);
        Unit unit = Unit.INSTANCE;
        identityArrayMap.set(k3, identityArraySet2);
    }

    @ExperimentalComposeApi
    public static final CoroutineContext getRecomposeCoroutineContext(ControlledComposition controlledComposition) {
        CoroutineContext recomposeContext;
        Intrinsics.checkNotNullParameter(controlledComposition, "<this>");
        CompositionImpl compositionImpl = controlledComposition instanceof CompositionImpl ? (CompositionImpl) controlledComposition : null;
        return (compositionImpl == null || (recomposeContext = compositionImpl.getRecomposeContext()) == null) ? EmptyCoroutineContext.INSTANCE : recomposeContext;
    }

    public static final void invalidateGroupsWithKey(int i3) {
        HotReloader.INSTANCE.invalidateGroupsWithKey$runtime_release(i3);
    }

    private static final <E> void removeValueIf(HashSet<E> hashSet, Function1<? super E, Boolean> function1) {
        Iterator<E> it = hashSet.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator()");
        while (it.hasNext()) {
            if (function1.invoke(it.next()).booleanValue()) {
                it.remove();
            }
        }
    }

    public static final void simulateHotReload(Object context) {
        Intrinsics.checkNotNullParameter(context, "context");
        HotReloader.INSTANCE.simulateHotReload$runtime_release(context);
    }

    @ExperimentalComposeApi
    public static final Composition Composition(Applier<?> applier, CompositionContext parent, CoroutineContext recomposeCoroutineContext) {
        Intrinsics.checkNotNullParameter(applier, "applier");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(recomposeCoroutineContext, "recomposeCoroutineContext");
        return new CompositionImpl(parent, applier, recomposeCoroutineContext);
    }

    @ExperimentalComposeApi
    public static final ControlledComposition ControlledComposition(Applier<?> applier, CompositionContext parent, CoroutineContext recomposeCoroutineContext) {
        Intrinsics.checkNotNullParameter(applier, "applier");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(recomposeCoroutineContext, "recomposeCoroutineContext");
        return new CompositionImpl(parent, applier, recomposeCoroutineContext);
    }

    @ExperimentalComposeApi
    public static /* synthetic */ void getRecomposeCoroutineContext$annotations(ControlledComposition controlledComposition) {
    }
}
