package kotlinx.atomicfu;

import com.google.common.util.concurrent.b;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import kotlinx.atomicfu.TraceBase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u001e*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u001eB\u0017\b\u0000\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001b\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u0014J$\u0010\t\u001a\u00028\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u00022\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u0017H\u0086\n\u00a2\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\fJ,\u0010\u000b\u001a\u00020\u001a2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00022\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u00172\u0006\u0010\u0003\u001a\u00028\u0000H\u0086\n\u00a2\u0006\u0002\u0010\u001bJ\b\u0010\u001c\u001a\u00020\u001dH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR&\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00028\u0000@FX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u001f"}, d2 = {"Lkotlinx/atomicfu/AtomicRef;", "T", "", "value", "trace", "Lkotlinx/atomicfu/TraceBase;", "(Ljava/lang/Object;Lkotlinx/atomicfu/TraceBase;)V", "getTrace", "()Lkotlinx/atomicfu/TraceBase;", HippyTextInputController.COMMAND_getValue, "()Ljava/lang/Object;", HippyTextInputController.COMMAND_setValue, "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "compareAndSet", "", "expect", "update", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "getAndSet", "(Ljava/lang/Object;)Ljava/lang/Object;", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "lazySet", "", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "toString", "", "Companion", "atomicfu"}, k = 1, mv = {1, 4, 3})
/* loaded from: classes28.dex */
public final class AtomicRef<T> {

    @NotNull
    private static final Companion Companion = new Companion(null);

    @Deprecated
    private static final AtomicReferenceFieldUpdater<AtomicRef<?>, Object> FU = AtomicReferenceFieldUpdater.newUpdater(AtomicRef.class, Object.class, "value");

    @NotNull
    private final TraceBase trace;
    private volatile T value;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R^\u0010\u0003\u001aR\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0006*\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00010\u0001 \u0006*(\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0006*\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lkotlinx/atomicfu/AtomicRef$Companion;", "", "()V", "FU", "Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;", "Lkotlinx/atomicfu/AtomicRef;", "kotlin.jvm.PlatformType", "atomicfu"}, k = 1, mv = {1, 4, 3})
    /* loaded from: classes28.dex */
    private static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public AtomicRef(T t16, @NotNull TraceBase trace) {
        Intrinsics.checkNotNullParameter(trace, "trace");
        this.trace = trace;
        this.value = t16;
    }

    public final boolean compareAndSet(T expect, T update) {
        InterceptorKt.getInterceptor().beforeUpdate(this);
        boolean a16 = b.a(FU, this, expect, update);
        if (a16) {
            TraceBase traceBase = this.trace;
            if (traceBase != TraceBase.None.INSTANCE) {
                traceBase.append("CAS(" + expect + ", " + update + ')');
            }
            InterceptorKt.getInterceptor().afterRMW(this, expect, update);
        }
        return a16;
    }

    public final T getAndSet(T value) {
        InterceptorKt.getInterceptor().beforeUpdate(this);
        T t16 = (T) FU.getAndSet(this, value);
        TraceBase traceBase = this.trace;
        if (traceBase != TraceBase.None.INSTANCE) {
            traceBase.append("getAndSet(" + value + "):" + t16);
        }
        InterceptorKt.getInterceptor().afterRMW(this, t16, value);
        return t16;
    }

    @NotNull
    public final TraceBase getTrace() {
        return this.trace;
    }

    public final T getValue() {
        return this.value;
    }

    public final void lazySet(T value) {
        InterceptorKt.getInterceptor().beforeUpdate(this);
        FU.lazySet(this, value);
        TraceBase traceBase = this.trace;
        if (traceBase != TraceBase.None.INSTANCE) {
            traceBase.append("lazySet(" + value + ')');
        }
        InterceptorKt.getInterceptor().afterSet((AtomicRef<AtomicRef<T>>) this, (AtomicRef<T>) value);
    }

    public final void setValue(T t16) {
        InterceptorKt.getInterceptor().beforeUpdate(this);
        this.value = t16;
        TraceBase traceBase = this.trace;
        if (traceBase != TraceBase.None.INSTANCE) {
            traceBase.append("set(" + t16 + ')');
        }
        InterceptorKt.getInterceptor().afterSet((AtomicRef<AtomicRef<T>>) this, (AtomicRef<T>) t16);
    }

    @NotNull
    public String toString() {
        return String.valueOf(this.value);
    }

    public final T getValue(@Nullable Object thisRef, @NotNull KProperty<?> property) {
        Intrinsics.checkNotNullParameter(property, "property");
        return getValue();
    }

    public final void setValue(@Nullable Object thisRef, @NotNull KProperty<?> property, T value) {
        Intrinsics.checkNotNullParameter(property, "property");
        setValue(value);
    }
}
