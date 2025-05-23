package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlow;

/* compiled from: P */
@Metadata(d1 = {"androidx/compose/runtime/SnapshotStateKt__DerivedStateKt", "androidx/compose/runtime/SnapshotStateKt__ProduceStateKt", "androidx/compose/runtime/SnapshotStateKt__SnapshotFlowKt", "androidx/compose/runtime/SnapshotStateKt__SnapshotMutationPolicyKt", "androidx/compose/runtime/SnapshotStateKt__SnapshotStateKt"}, k = 4, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes39.dex */
public final class SnapshotStateKt {
    public static final <T extends R, R> State<R> collectAsState(Flow<? extends T> flow, R r16, CoroutineContext coroutineContext, Composer composer, int i3, int i16) {
        return SnapshotStateKt__SnapshotFlowKt.collectAsState(flow, r16, coroutineContext, composer, i3, i16);
    }

    public static final <T> State<T> derivedStateOf(Function0<? extends T> function0) {
        return SnapshotStateKt__DerivedStateKt.derivedStateOf(function0);
    }

    public static final <T> T getValue(State<? extends T> state, Object obj, KProperty<?> kProperty) {
        return (T) SnapshotStateKt__SnapshotStateKt.getValue(state, obj, kProperty);
    }

    public static final <T> SnapshotStateList<T> mutableStateListOf() {
        return SnapshotStateKt__SnapshotStateKt.mutableStateListOf();
    }

    public static final <K, V> SnapshotStateMap<K, V> mutableStateMapOf() {
        return SnapshotStateKt__SnapshotStateKt.mutableStateMapOf();
    }

    public static final <T> MutableState<T> mutableStateOf(T t16, SnapshotMutationPolicy<T> snapshotMutationPolicy) {
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf(t16, snapshotMutationPolicy);
    }

    public static /* synthetic */ MutableState mutableStateOf$default(Object obj, SnapshotMutationPolicy snapshotMutationPolicy, int i3, Object obj2) {
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(obj, snapshotMutationPolicy, i3, obj2);
    }

    public static final <T> SnapshotMutationPolicy<T> neverEqualPolicy() {
        return SnapshotStateKt__SnapshotMutationPolicyKt.neverEqualPolicy();
    }

    public static final <R> void observeDerivedStateRecalculations(Function1<? super State<?>, Unit> function1, Function1<? super State<?>, Unit> function12, Function0<? extends R> function0) {
        SnapshotStateKt__DerivedStateKt.observeDerivedStateRecalculations(function1, function12, function0);
    }

    public static final <T> State<T> produceState(T t16, Object obj, Object obj2, Object obj3, Function2<? super ProduceStateScope<T>, ? super Continuation<? super Unit>, ? extends Object> function2, Composer composer, int i3) {
        return SnapshotStateKt__ProduceStateKt.produceState(t16, obj, obj2, obj3, function2, composer, i3);
    }

    public static final <T> SnapshotMutationPolicy<T> referentialEqualityPolicy() {
        return SnapshotStateKt__SnapshotMutationPolicyKt.referentialEqualityPolicy();
    }

    public static final <T> State<T> rememberUpdatedState(T t16, Composer composer, int i3) {
        return SnapshotStateKt__SnapshotStateKt.rememberUpdatedState(t16, composer, i3);
    }

    public static final <T> void setValue(MutableState<T> mutableState, Object obj, KProperty<?> kProperty, T t16) {
        SnapshotStateKt__SnapshotStateKt.setValue(mutableState, obj, kProperty, t16);
    }

    public static final <T> Flow<T> snapshotFlow(Function0<? extends T> function0) {
        return SnapshotStateKt__SnapshotFlowKt.snapshotFlow(function0);
    }

    public static final <T> SnapshotMutationPolicy<T> structuralEqualityPolicy() {
        return SnapshotStateKt__SnapshotMutationPolicyKt.structuralEqualityPolicy();
    }

    public static final <T> SnapshotStateList<T> toMutableStateList(Collection<? extends T> collection) {
        return SnapshotStateKt__SnapshotStateKt.toMutableStateList(collection);
    }

    public static final <K, V> SnapshotStateMap<K, V> toMutableStateMap(Iterable<? extends Pair<? extends K, ? extends V>> iterable) {
        return SnapshotStateKt__SnapshotStateKt.toMutableStateMap(iterable);
    }

    public static final <T> State<T> collectAsState(StateFlow<? extends T> stateFlow, CoroutineContext coroutineContext, Composer composer, int i3, int i16) {
        return SnapshotStateKt__SnapshotFlowKt.collectAsState(stateFlow, coroutineContext, composer, i3, i16);
    }

    public static final <T> SnapshotStateList<T> mutableStateListOf(T... tArr) {
        return SnapshotStateKt__SnapshotStateKt.mutableStateListOf(tArr);
    }

    public static final <K, V> SnapshotStateMap<K, V> mutableStateMapOf(Pair<? extends K, ? extends V>... pairArr) {
        return SnapshotStateKt__SnapshotStateKt.mutableStateMapOf(pairArr);
    }

    public static final <T> State<T> produceState(T t16, Object obj, Object obj2, Function2<? super ProduceStateScope<T>, ? super Continuation<? super Unit>, ? extends Object> function2, Composer composer, int i3) {
        return SnapshotStateKt__ProduceStateKt.produceState(t16, obj, obj2, function2, composer, i3);
    }

    public static final <T> State<T> produceState(T t16, Object obj, Function2<? super ProduceStateScope<T>, ? super Continuation<? super Unit>, ? extends Object> function2, Composer composer, int i3) {
        return SnapshotStateKt__ProduceStateKt.produceState(t16, obj, function2, composer, i3);
    }

    public static final <T> State<T> produceState(T t16, Function2<? super ProduceStateScope<T>, ? super Continuation<? super Unit>, ? extends Object> function2, Composer composer, int i3) {
        return SnapshotStateKt__ProduceStateKt.produceState(t16, function2, composer, i3);
    }

    public static final <T> State<T> produceState(T t16, Object[] objArr, Function2<? super ProduceStateScope<T>, ? super Continuation<? super Unit>, ? extends Object> function2, Composer composer, int i3) {
        return SnapshotStateKt__ProduceStateKt.produceState((Object) t16, objArr, (Function2) function2, composer, i3);
    }
}
