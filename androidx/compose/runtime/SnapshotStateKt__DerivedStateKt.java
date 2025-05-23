package androidx.compose.runtime;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a \u0010\n\u001a\b\u0012\u0004\u0012\u0002H\f0\u000b\"\u0004\b\u0000\u0010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u000e\u001a0\u0010\u000f\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u00102\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00100\u000eH\u0082\b\u00a2\u0006\u0004\b\u0013\u0010\u0014\u001aj\u0010\u0015\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u00102%\u0010\u0016\u001a!\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u000b\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00060\u00042%\u0010\u0019\u001a!\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u000b\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00060\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00100\u000eH\u0000\"J\u0010\u0000\u001a>\u0012:\u00128\u00124\u00122\u0012\u0014\u0012\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0014\u0012\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0003j\u0002`\u00070\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000*d\b\u0002\u0010\u001a\".\u0012\u0014\u0012\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0014\u0012\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u00032.\u0012\u0014\u0012\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0014\u0012\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0003\u00a8\u0006\u001b"}, d2 = {"derivedStateObservers", "Landroidx/compose/runtime/SnapshotThreadLocal;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "Lkotlin/Pair;", "Lkotlin/Function1;", "Landroidx/compose/runtime/DerivedState;", "", "Landroidx/compose/runtime/DerivedStateObservers;", "isCalculationBlockRunning", "", "derivedStateOf", "Landroidx/compose/runtime/State;", "T", "calculation", "Lkotlin/Function0;", "notifyObservers", BdhLogUtil.LogTag.Tag_Req, "derivedState", "block", "notifyObservers$SnapshotStateKt__DerivedStateKt", "(Landroidx/compose/runtime/DerivedState;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "observeDerivedStateRecalculations", "start", "Lkotlin/ParameterName;", "name", "done", "DerivedStateObservers", "runtime_release"}, k = 5, mv = {1, 6, 0}, xi = 48, xs = "androidx/compose/runtime/SnapshotStateKt")
/* loaded from: classes39.dex */
public final /* synthetic */ class SnapshotStateKt__DerivedStateKt {
    private static final SnapshotThreadLocal<PersistentList<Pair<Function1<DerivedState<?>, Unit>, Function1<DerivedState<?>, Unit>>>> derivedStateObservers = new SnapshotThreadLocal<>();
    private static final SnapshotThreadLocal<Boolean> isCalculationBlockRunning = new SnapshotThreadLocal<>();

    public static final <T> State<T> derivedStateOf(Function0<? extends T> calculation) {
        Intrinsics.checkNotNullParameter(calculation, "calculation");
        return new DerivedSnapshotState(calculation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <R> R notifyObservers$SnapshotStateKt__DerivedStateKt(DerivedState<?> derivedState, Function0<? extends R> function0) {
        PersistentList persistentList = (PersistentList) derivedStateObservers.get();
        if (persistentList == null) {
            persistentList = ExtensionsKt.persistentListOf();
        }
        int size = persistentList.size();
        int i3 = 0;
        for (int i16 = 0; i16 < size; i16++) {
            ((Function1) ((Pair) persistentList.get(i16)).component1()).invoke(derivedState);
        }
        try {
            return function0.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            int size2 = persistentList.size();
            while (i3 < size2) {
                ((Function1) ((Pair) persistentList.get(i3)).component2()).invoke(derivedState);
                i3++;
            }
            InlineMarker.finallyEnd(1);
        }
    }

    public static final <R> void observeDerivedStateRecalculations(Function1<? super State<?>, Unit> start, Function1<? super State<?>, Unit> done, Function0<? extends R> block) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(done, "done");
        Intrinsics.checkNotNullParameter(block, "block");
        SnapshotThreadLocal<PersistentList<Pair<Function1<DerivedState<?>, Unit>, Function1<DerivedState<?>, Unit>>>> snapshotThreadLocal = derivedStateObservers;
        PersistentList<Pair<Function1<DerivedState<?>, Unit>, Function1<DerivedState<?>, Unit>>> persistentList = snapshotThreadLocal.get();
        try {
            PersistentList<Pair<Function1<DerivedState<?>, Unit>, Function1<DerivedState<?>, Unit>>> persistentList2 = snapshotThreadLocal.get();
            if (persistentList2 == null) {
                persistentList2 = ExtensionsKt.persistentListOf();
            }
            snapshotThreadLocal.set(persistentList2.add((PersistentList<Pair<Function1<DerivedState<?>, Unit>, Function1<DerivedState<?>, Unit>>>) TuplesKt.to(start, done)));
            block.invoke();
            snapshotThreadLocal.set(persistentList);
        } catch (Throwable th5) {
            derivedStateObservers.set(persistentList);
            throw th5;
        }
    }
}
