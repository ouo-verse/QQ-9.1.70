package androidx.compose.runtime;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0003\u001as\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052/\b\u0001\u0010\b\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00050\t\u00a2\u0006\u0002\b\rH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000e\u001ai\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052/\b\u0001\u0010\b\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00050\t\u00a2\u0006\u0002\b\rH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000f\u001a_\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052/\b\u0001\u0010\b\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00050\t\u00a2\u0006\u0002\b\rH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010\u001am\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\u0016\u0010\u0011\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u0012\"\u0004\u0018\u00010\u00052/\b\u0001\u0010\b\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00050\t\u00a2\u0006\u0002\b\rH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013\u001aU\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022/\b\u0001\u0010\b\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00050\t\u00a2\u0006\u0002\b\rH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0015"}, d2 = {"produceState", "Landroidx/compose/runtime/State;", "T", "initialValue", "key1", "", "key2", "key3", "producer", "Lkotlin/Function2;", "Landroidx/compose/runtime/ProduceStateScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "keys", "", "(Ljava/lang/Object;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "runtime_release"}, k = 5, mv = {1, 6, 0}, xi = 48, xs = "androidx/compose/runtime/SnapshotStateKt")
/* loaded from: classes39.dex */
public final /* synthetic */ class SnapshotStateKt__ProduceStateKt {
    public static final <T> State<T> produceState(T t16, Function2<? super ProduceStateScope<T>, ? super Continuation<? super Unit>, ? extends Object> producer, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(producer, "producer");
        composer.startReplaceableGroup(10454275);
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t16, null, 2, null);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        MutableState mutableState = (MutableState) rememberedValue;
        EffectsKt.LaunchedEffect(Unit.INSTANCE, new SnapshotStateKt__ProduceStateKt$produceState$1(producer, mutableState, null), composer, 0);
        composer.endReplaceableGroup();
        return mutableState;
    }

    public static final <T> State<T> produceState(T t16, Object obj, Function2<? super ProduceStateScope<T>, ? super Continuation<? super Unit>, ? extends Object> producer, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(producer, "producer");
        composer.startReplaceableGroup(-1928268701);
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t16, null, 2, null);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        MutableState mutableState = (MutableState) rememberedValue;
        EffectsKt.LaunchedEffect(obj, new SnapshotStateKt__ProduceStateKt$produceState$2(producer, mutableState, null), composer, 8);
        composer.endReplaceableGroup();
        return mutableState;
    }

    public static final <T> State<T> produceState(T t16, Object obj, Object obj2, Function2<? super ProduceStateScope<T>, ? super Continuation<? super Unit>, ? extends Object> producer, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(producer, "producer");
        composer.startReplaceableGroup(-1703169085);
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t16, null, 2, null);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        MutableState mutableState = (MutableState) rememberedValue;
        EffectsKt.LaunchedEffect(obj, obj2, new SnapshotStateKt__ProduceStateKt$produceState$3(producer, mutableState, null), composer, 72);
        composer.endReplaceableGroup();
        return mutableState;
    }

    public static final <T> State<T> produceState(T t16, Object obj, Object obj2, Object obj3, Function2<? super ProduceStateScope<T>, ? super Continuation<? super Unit>, ? extends Object> producer, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(producer, "producer");
        composer.startReplaceableGroup(1807205155);
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t16, null, 2, null);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        MutableState mutableState = (MutableState) rememberedValue;
        EffectsKt.LaunchedEffect(obj, obj2, obj3, new SnapshotStateKt__ProduceStateKt$produceState$4(producer, mutableState, null), composer, 584);
        composer.endReplaceableGroup();
        return mutableState;
    }

    public static final <T> State<T> produceState(T t16, Object[] keys, Function2<? super ProduceStateScope<T>, ? super Continuation<? super Unit>, ? extends Object> producer, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        Intrinsics.checkNotNullParameter(producer, "producer");
        composer.startReplaceableGroup(490154582);
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t16, null, 2, null);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        MutableState mutableState = (MutableState) rememberedValue;
        EffectsKt.LaunchedEffect(Arrays.copyOf(keys, keys.length), (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) new SnapshotStateKt__ProduceStateKt$produceState$5(producer, mutableState, null), composer, 8);
        composer.endReplaceableGroup();
        return mutableState;
    }
}
