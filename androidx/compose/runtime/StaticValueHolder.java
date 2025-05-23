package androidx.compose.runtime;

import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\b\u001a\u00028\u0000H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0006J\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u0000H\u00c6\u0001\u00a2\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001R\u0016\u0010\u0003\u001a\u00028\u0000X\u0096\u0004\u00a2\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0013"}, d2 = {"Landroidx/compose/runtime/StaticValueHolder;", "T", "Landroidx/compose/runtime/State;", "value", "(Ljava/lang/Object;)V", HippyTextInputController.COMMAND_getValue, "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Landroidx/compose/runtime/StaticValueHolder;", "equals", "", "other", "", "hashCode", "", "toString", "", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes39.dex */
public final /* data */ class StaticValueHolder<T> implements State<T> {
    private final T value;

    public StaticValueHolder(T t16) {
        this.value = t16;
    }

    public final T component1() {
        return getValue();
    }

    public final StaticValueHolder<T> copy(T value) {
        return new StaticValueHolder<>(value);
    }

    @Override // androidx.compose.runtime.State
    public T getValue() {
        return this.value;
    }

    public int hashCode() {
        if (getValue() == null) {
            return 0;
        }
        return getValue().hashCode();
    }

    public String toString() {
        return "StaticValueHolder(value=" + getValue() + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StaticValueHolder copy$default(StaticValueHolder staticValueHolder, Object obj, int i3, Object obj2) {
        if ((i3 & 1) != 0) {
            obj = staticValueHolder.getValue();
        }
        return staticValueHolder.copy(obj);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof StaticValueHolder) && Intrinsics.areEqual(getValue(), ((StaticValueHolder) other).getValue());
    }
}
