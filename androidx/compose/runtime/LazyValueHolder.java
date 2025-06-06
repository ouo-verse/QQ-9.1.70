package androidx.compose.runtime;

import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u00a2\u0006\u0002\u0010\u0005R\u001b\u0010\u0006\u001a\u00028\u00008BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00028\u00008VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\b\u00a8\u0006\r"}, d2 = {"Landroidx/compose/runtime/LazyValueHolder;", "T", "Landroidx/compose/runtime/State;", "valueProducer", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "current", "getCurrent", "()Ljava/lang/Object;", "current$delegate", "Lkotlin/Lazy;", "value", HippyTextInputController.COMMAND_getValue, "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes39.dex */
public final class LazyValueHolder<T> implements State<T> {

    /* renamed from: current$delegate, reason: from kotlin metadata */
    private final Lazy current;

    public LazyValueHolder(Function0<? extends T> valueProducer) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(valueProducer, "valueProducer");
        lazy = LazyKt__LazyJVMKt.lazy(valueProducer);
        this.current = lazy;
    }

    private final T getCurrent() {
        return (T) this.current.getValue();
    }

    @Override // androidx.compose.runtime.State
    public T getValue() {
        return getCurrent();
    }
}
