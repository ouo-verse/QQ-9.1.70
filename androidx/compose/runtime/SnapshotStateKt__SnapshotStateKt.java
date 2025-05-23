package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u001c\n\u0000\u001a\u0012\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002\u001a+\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0004\"\u0002H\u0002\u00a2\u0006\u0002\u0010\u0005\u001a\u001e\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\t0\u0007\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\t\u001aO\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\t0\u0007\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\t2*\u0010\n\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\t0\u000b0\u0004\"\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\t0\u000b\u00a2\u0006\u0002\u0010\f\u001a/\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00020\u000e\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u000f\u001a\u0002H\u00022\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0011\u00a2\u0006\u0002\u0010\u0012\u001a!\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0014\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0015\u001a\u0002H\u0002H\u0007\u00a2\u0006\u0002\u0010\u0016\u001a4\u0010\u0017\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001bH\u0086\n\u00a2\u0006\u0002\u0010\u001c\u001a<\u0010\u001d\u001a\u00020\u001e\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001b2\u0006\u0010\u000f\u001a\u0002H\u0002H\u0086\n\u00a2\u0006\u0002\u0010\u001f\u001a\u001c\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020!\u001a4\u0010\"\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\t0\u0007\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\t*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\t0\u000b0#\u00a8\u0006$"}, d2 = {"mutableStateListOf", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "T", DTParamKey.REPORT_KEY_VISUAL_ELEMENTS, "", "([Ljava/lang/Object;)Landroidx/compose/runtime/snapshots/SnapshotStateList;", "mutableStateMapOf", "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "K", "V", "pairs", "Lkotlin/Pair;", "([Lkotlin/Pair;)Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "mutableStateOf", "Landroidx/compose/runtime/MutableState;", "value", "policy", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "(Ljava/lang/Object;Landroidx/compose/runtime/SnapshotMutationPolicy;)Landroidx/compose/runtime/MutableState;", "rememberUpdatedState", "Landroidx/compose/runtime/State;", "newValue", "(Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", HippyTextInputController.COMMAND_getValue, "thisObj", "", "property", "Lkotlin/reflect/KProperty;", "(Landroidx/compose/runtime/State;Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", HippyTextInputController.COMMAND_setValue, "", "(Landroidx/compose/runtime/MutableState;Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "toMutableStateList", "", "toMutableStateMap", "", "runtime_release"}, k = 5, mv = {1, 6, 0}, xi = 48, xs = "androidx/compose/runtime/SnapshotStateKt")
/* loaded from: classes39.dex */
public final /* synthetic */ class SnapshotStateKt__SnapshotStateKt {
    public static final <T> T getValue(State<? extends T> state, Object obj, KProperty<?> property) {
        Intrinsics.checkNotNullParameter(state, "<this>");
        Intrinsics.checkNotNullParameter(property, "property");
        return state.getValue();
    }

    public static final <T> SnapshotStateList<T> mutableStateListOf() {
        return new SnapshotStateList<>();
    }

    public static final <K, V> SnapshotStateMap<K, V> mutableStateMapOf() {
        return new SnapshotStateMap<>();
    }

    public static final <T> MutableState<T> mutableStateOf(T t16, SnapshotMutationPolicy<T> policy) {
        Intrinsics.checkNotNullParameter(policy, "policy");
        return ActualAndroid_androidKt.createSnapshotMutableState(t16, policy);
    }

    public static final <T> void setValue(MutableState<T> mutableState, Object obj, KProperty<?> property, T t16) {
        Intrinsics.checkNotNullParameter(mutableState, "<this>");
        Intrinsics.checkNotNullParameter(property, "property");
        mutableState.setValue(t16);
    }

    public static final <T> SnapshotStateList<T> toMutableStateList(Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        SnapshotStateList<T> snapshotStateList = new SnapshotStateList<>();
        snapshotStateList.addAll(collection);
        return snapshotStateList;
    }

    public static final <K, V> SnapshotStateMap<K, V> toMutableStateMap(Iterable<? extends Pair<? extends K, ? extends V>> iterable) {
        Map<? extends K, ? extends V> map;
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        SnapshotStateMap<K, V> snapshotStateMap = new SnapshotStateMap<>();
        map = MapsKt__MapsKt.toMap(iterable);
        snapshotStateMap.putAll(map);
        return snapshotStateMap;
    }

    public static final <T> SnapshotStateList<T> mutableStateListOf(T... elements) {
        List list;
        Intrinsics.checkNotNullParameter(elements, "elements");
        SnapshotStateList<T> snapshotStateList = new SnapshotStateList<>();
        list = ArraysKt___ArraysKt.toList(elements);
        snapshotStateList.addAll(list);
        return snapshotStateList;
    }

    public static final <K, V> SnapshotStateMap<K, V> mutableStateMapOf(Pair<? extends K, ? extends V>... pairs) {
        Map<? extends K, ? extends V> map;
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        SnapshotStateMap<K, V> snapshotStateMap = new SnapshotStateMap<>();
        map = MapsKt__MapsKt.toMap(pairs);
        snapshotStateMap.putAll(map);
        return snapshotStateMap;
    }

    public static final <T> State<T> rememberUpdatedState(T t16, Composer composer, int i3) {
        composer.startReplaceableGroup(-1058319986);
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = mutableStateOf$default(t16, null, 2, null);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        MutableState mutableState = (MutableState) rememberedValue;
        mutableState.setValue(t16);
        composer.endReplaceableGroup();
        return mutableState;
    }

    public static /* synthetic */ MutableState mutableStateOf$default(Object obj, SnapshotMutationPolicy snapshotMutationPolicy, int i3, Object obj2) {
        if ((i3 & 2) != 0) {
            snapshotMutationPolicy = SnapshotStateKt.structuralEqualityPolicy();
        }
        return SnapshotStateKt.mutableStateOf(obj, snapshotMutationPolicy);
    }
}
