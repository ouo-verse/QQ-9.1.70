package kotlinx.atomicfu;

import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import kotlinx.atomicfu.TraceBase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003J\u000e\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003J\u001f\u0010\f\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u00012\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u0016H\u0086\nJ\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000b\u001a\u00020\u0003J'\u0010\u000e\u001a\u00020\u00182\b\u0010\u0014\u001a\u0004\u0018\u00010\u00012\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u00162\u0006\u0010\u000b\u001a\u00020\u0003H\u0086\nJ\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR$\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00038F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001c"}, d2 = {"Lkotlinx/atomicfu/AtomicBoolean;", "", "v", "", "trace", "Lkotlinx/atomicfu/TraceBase;", "(ZLkotlinx/atomicfu/TraceBase;)V", "_value", "", "getTrace", "()Lkotlinx/atomicfu/TraceBase;", "value", HippyTextInputController.COMMAND_getValue, "()Z", HippyTextInputController.COMMAND_setValue, "(Z)V", "compareAndSet", "expect", "update", "getAndSet", "thisRef", "property", "Lkotlin/reflect/KProperty;", "lazySet", "", "toString", "", "Companion", "atomicfu"}, k = 1, mv = {1, 4, 3})
/* loaded from: classes28.dex */
public final class AtomicBoolean {

    @NotNull
    private static final Companion Companion = new Companion(null);

    @Deprecated
    private static final AtomicIntegerFieldUpdater<AtomicBoolean> FU = AtomicIntegerFieldUpdater.newUpdater(AtomicBoolean.class, "_value");
    private volatile int _value;

    @NotNull
    private final TraceBase trace;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R2\u0010\u0003\u001a&\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005 \u0006*\u0012\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lkotlinx/atomicfu/AtomicBoolean$Companion;", "", "()V", "FU", "Ljava/util/concurrent/atomic/AtomicIntegerFieldUpdater;", "Lkotlinx/atomicfu/AtomicBoolean;", "kotlin.jvm.PlatformType", "atomicfu"}, k = 1, mv = {1, 4, 3})
    /* loaded from: classes28.dex */
    private static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public AtomicBoolean(boolean z16, @NotNull TraceBase trace) {
        Intrinsics.checkNotNullParameter(trace, "trace");
        this.trace = trace;
        this._value = z16 ? 1 : 0;
    }

    public final boolean compareAndSet(boolean expect, boolean update) {
        InterceptorKt.getInterceptor().beforeUpdate(this);
        boolean compareAndSet = FU.compareAndSet(this, expect ? 1 : 0, update ? 1 : 0);
        if (compareAndSet) {
            TraceBase traceBase = this.trace;
            if (traceBase != TraceBase.None.INSTANCE) {
                traceBase.append("CAS(" + expect + ", " + update + ')');
            }
            InterceptorKt.getInterceptor().afterRMW(this, expect, update);
        }
        return compareAndSet;
    }

    public final boolean getAndSet(boolean value) {
        boolean z16;
        InterceptorKt.getInterceptor().beforeUpdate(this);
        int andSet = FU.getAndSet(this, value ? 1 : 0);
        TraceBase traceBase = this.trace;
        if (traceBase != TraceBase.None.INSTANCE) {
            traceBase.append("getAndSet(" + value + "):" + andSet);
        }
        AtomicOperationInterceptor interceptor = InterceptorKt.getInterceptor();
        if (andSet == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        interceptor.afterRMW(this, z16, value);
        if (andSet != 1) {
            return false;
        }
        return true;
    }

    @NotNull
    public final TraceBase getTrace() {
        return this.trace;
    }

    public final boolean getValue(@Nullable Object thisRef, @NotNull KProperty<?> property) {
        Intrinsics.checkNotNullParameter(property, "property");
        return getValue();
    }

    public final void lazySet(boolean value) {
        InterceptorKt.getInterceptor().beforeUpdate(this);
        FU.lazySet(this, value ? 1 : 0);
        TraceBase traceBase = this.trace;
        if (traceBase != TraceBase.None.INSTANCE) {
            traceBase.append("lazySet(" + value + ')');
        }
        InterceptorKt.getInterceptor().afterSet(this, value);
    }

    public final void setValue(@Nullable Object thisRef, @NotNull KProperty<?> property, boolean value) {
        Intrinsics.checkNotNullParameter(property, "property");
        setValue(value);
    }

    @NotNull
    public String toString() {
        return String.valueOf(getValue());
    }

    public final boolean getValue() {
        return this._value != 0;
    }

    public final void setValue(boolean z16) {
        InterceptorKt.getInterceptor().beforeUpdate(this);
        this._value = z16 ? 1 : 0;
        TraceBase traceBase = this.trace;
        if (traceBase != TraceBase.None.INSTANCE) {
            traceBase.append("set(" + z16 + ')');
        }
        InterceptorKt.getInterceptor().afterSet(this, z16);
    }
}
