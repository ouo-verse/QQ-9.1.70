package kotlin.sequences;

import java.util.Comparator;
import kotlin.BuilderInference;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"kotlin/sequences/SequencesKt__SequenceBuilderKt", "kotlin/sequences/SequencesKt__SequencesJVMKt", "kotlin/sequences/SequencesKt__SequencesKt", "kotlin/sequences/SequencesKt___SequencesJvmKt", "kotlin/sequences/SequencesKt___SequencesKt"}, k = 4, mv = {1, 7, 1}, xi = 49)
/* loaded from: classes28.dex */
public final class SequencesKt extends SequencesKt___SequencesKt {
    SequencesKt() {
    }

    @NotNull
    public static /* bridge */ /* synthetic */ Sequence emptySequence() {
        return SequencesKt__SequencesKt.emptySequence();
    }

    @NotNull
    public static /* bridge */ /* synthetic */ Sequence filter(@NotNull Sequence sequence, @NotNull Function1 function1) {
        return SequencesKt___SequencesKt.filter(sequence, function1);
    }

    @NotNull
    public static /* bridge */ /* synthetic */ Sequence flatten(@NotNull Sequence sequence) {
        return SequencesKt__SequencesKt.flatten(sequence);
    }

    @LowPriorityInOverloadResolution
    @NotNull
    public static /* bridge */ /* synthetic */ Sequence generateSequence(@Nullable Object obj, @NotNull Function1 function1) {
        return SequencesKt__SequencesKt.generateSequence(obj, (Function1<? super Object, ? extends Object>) function1);
    }

    @NotNull
    public static /* bridge */ /* synthetic */ Sequence map(@NotNull Sequence sequence, @NotNull Function1 function1) {
        return SequencesKt___SequencesKt.map(sequence, function1);
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static /* bridge */ /* synthetic */ Sequence sequence(@BuilderInference @NotNull Function2 function2) {
        return SequencesKt__SequenceBuilderKt.sequence(function2);
    }

    @NotNull
    public static /* bridge */ /* synthetic */ Sequence sortedWith(@NotNull Sequence sequence, @NotNull Comparator comparator) {
        return SequencesKt___SequencesKt.sortedWith(sequence, comparator);
    }
}
