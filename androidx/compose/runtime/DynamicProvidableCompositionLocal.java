package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B!\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u00a2\u0006\u0002\u0010\u0007J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010\n\u001a\u00028\u0000H\u0011\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Landroidx/compose/runtime/DynamicProvidableCompositionLocal;", "T", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "policy", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "defaultFactory", "Lkotlin/Function0;", "(Landroidx/compose/runtime/SnapshotMutationPolicy;Lkotlin/jvm/functions/Function0;)V", "provided", "Landroidx/compose/runtime/State;", "value", "provided$runtime_release", "(Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes39.dex */
public final class DynamicProvidableCompositionLocal<T> extends ProvidableCompositionLocal<T> {
    private final SnapshotMutationPolicy<T> policy;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DynamicProvidableCompositionLocal(SnapshotMutationPolicy<T> policy, Function0<? extends T> defaultFactory) {
        super(defaultFactory);
        Intrinsics.checkNotNullParameter(policy, "policy");
        Intrinsics.checkNotNullParameter(defaultFactory, "defaultFactory");
        this.policy = policy;
    }

    @Override // androidx.compose.runtime.CompositionLocal
    public State<T> provided$runtime_release(T t16, Composer composer, int i3) {
        composer.startReplaceableGroup(-84026900);
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = SnapshotStateKt.mutableStateOf(t16, this.policy);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        MutableState mutableState = (MutableState) rememberedValue;
        mutableState.setValue(t16);
        composer.endReplaceableGroup();
        return mutableState;
    }
}
