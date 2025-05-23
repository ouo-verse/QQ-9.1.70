package kotlinx.atomicfu;

import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import com.tencent.qqmini.miniapp.core.EventListener;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import kotlinx.atomicfu.TraceBase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003J\u0006\u0010\u0013\u001a\u00020\u0003J\u000e\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003J\u0006\u0010\u0015\u001a\u00020\u0003J\u0006\u0010\u0016\u001a\u00020\u0003J\u000e\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003J\u001f\u0010\t\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u00012\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u001aH\u0086\nJ\u0006\u0010\u001b\u001a\u00020\u0003J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u0003J\u0011\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u000e\u001a\u00020\u0003H\u0086\nJ\u0011\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\u000e\u001a\u00020\u0003H\u0086\nJ'\u0010\u000b\u001a\u00020\u001d2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00012\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u001a2\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\nJ\b\u0010 \u001a\u00020!H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006#"}, d2 = {"Lkotlinx/atomicfu/AtomicLong;", "", "value", "", "trace", "Lkotlinx/atomicfu/TraceBase;", "(JLkotlinx/atomicfu/TraceBase;)V", "getTrace", "()Lkotlinx/atomicfu/TraceBase;", HippyTextInputController.COMMAND_getValue, "()J", HippyTextInputController.COMMAND_setValue, "(J)V", "addAndGet", EventListener.KEY_DELTA, "compareAndSet", "", "expect", "update", "decrementAndGet", "getAndAdd", "getAndDecrement", "getAndIncrement", "getAndSet", "thisRef", "property", "Lkotlin/reflect/KProperty;", "incrementAndGet", "lazySet", "", "minusAssign", "plusAssign", "toString", "", "Companion", "atomicfu"}, k = 1, mv = {1, 4, 3})
/* loaded from: classes28.dex */
public final class AtomicLong {

    @NotNull
    private static final Companion Companion = new Companion(null);

    @Deprecated
    private static final AtomicLongFieldUpdater<AtomicLong> FU = AtomicLongFieldUpdater.newUpdater(AtomicLong.class, "value");

    @NotNull
    private final TraceBase trace;
    private volatile long value;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R2\u0010\u0003\u001a&\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005 \u0006*\u0012\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lkotlinx/atomicfu/AtomicLong$Companion;", "", "()V", "FU", "Ljava/util/concurrent/atomic/AtomicLongFieldUpdater;", "Lkotlinx/atomicfu/AtomicLong;", "kotlin.jvm.PlatformType", "atomicfu"}, k = 1, mv = {1, 4, 3})
    /* loaded from: classes28.dex */
    private static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public AtomicLong(long j3, @NotNull TraceBase trace) {
        Intrinsics.checkNotNullParameter(trace, "trace");
        this.trace = trace;
        this.value = j3;
    }

    public final long addAndGet(long delta) {
        InterceptorKt.getInterceptor().beforeUpdate(this);
        long addAndGet = FU.addAndGet(this, delta);
        TraceBase traceBase = this.trace;
        if (traceBase != TraceBase.None.INSTANCE) {
            traceBase.append("addAndGet(" + delta + "):" + addAndGet);
        }
        InterceptorKt.getInterceptor().afterRMW(this, addAndGet - delta, addAndGet);
        return addAndGet;
    }

    public final boolean compareAndSet(long expect, long update) {
        InterceptorKt.getInterceptor().beforeUpdate(this);
        boolean compareAndSet = FU.compareAndSet(this, expect, update);
        if (compareAndSet) {
            TraceBase traceBase = this.trace;
            if (traceBase != TraceBase.None.INSTANCE) {
                traceBase.append("CAS(" + expect + ", " + update + ')');
            }
            InterceptorKt.getInterceptor().afterRMW(this, expect, update);
        }
        return compareAndSet;
    }

    public final long decrementAndGet() {
        InterceptorKt.getInterceptor().beforeUpdate(this);
        long decrementAndGet = FU.decrementAndGet(this);
        TraceBase traceBase = this.trace;
        if (traceBase != TraceBase.None.INSTANCE) {
            traceBase.append("decAndGet():" + decrementAndGet);
        }
        InterceptorKt.getInterceptor().afterRMW(this, decrementAndGet + 1, decrementAndGet);
        return decrementAndGet;
    }

    public final long getAndAdd(long delta) {
        InterceptorKt.getInterceptor().beforeUpdate(this);
        long andAdd = FU.getAndAdd(this, delta);
        TraceBase traceBase = this.trace;
        if (traceBase != TraceBase.None.INSTANCE) {
            traceBase.append("getAndAdd(" + delta + "):" + andAdd);
        }
        InterceptorKt.getInterceptor().afterRMW(this, andAdd, andAdd + delta);
        return andAdd;
    }

    public final long getAndDecrement() {
        InterceptorKt.getInterceptor().beforeUpdate(this);
        long andDecrement = FU.getAndDecrement(this);
        TraceBase traceBase = this.trace;
        if (traceBase != TraceBase.None.INSTANCE) {
            traceBase.append("getAndDec():" + andDecrement);
        }
        InterceptorKt.getInterceptor().afterRMW(this, andDecrement, andDecrement - 1);
        return andDecrement;
    }

    public final long getAndIncrement() {
        InterceptorKt.getInterceptor().beforeUpdate(this);
        long andIncrement = FU.getAndIncrement(this);
        TraceBase traceBase = this.trace;
        if (traceBase != TraceBase.None.INSTANCE) {
            traceBase.append("getAndInc():" + andIncrement);
        }
        InterceptorKt.getInterceptor().afterRMW(this, andIncrement, andIncrement + 1);
        return andIncrement;
    }

    public final long getAndSet(long value) {
        InterceptorKt.getInterceptor().beforeUpdate(this);
        long andSet = FU.getAndSet(this, value);
        TraceBase traceBase = this.trace;
        if (traceBase != TraceBase.None.INSTANCE) {
            traceBase.append("getAndSet(" + value + "):" + andSet);
        }
        InterceptorKt.getInterceptor().afterRMW(this, andSet, value);
        return andSet;
    }

    @NotNull
    public final TraceBase getTrace() {
        return this.trace;
    }

    public final long getValue() {
        return this.value;
    }

    public final long incrementAndGet() {
        InterceptorKt.getInterceptor().beforeUpdate(this);
        long incrementAndGet = FU.incrementAndGet(this);
        TraceBase traceBase = this.trace;
        if (traceBase != TraceBase.None.INSTANCE) {
            traceBase.append("incAndGet():" + incrementAndGet);
        }
        InterceptorKt.getInterceptor().afterRMW(this, incrementAndGet - 1, incrementAndGet);
        return incrementAndGet;
    }

    public final void lazySet(long value) {
        InterceptorKt.getInterceptor().beforeUpdate(this);
        FU.lazySet(this, value);
        TraceBase traceBase = this.trace;
        if (traceBase != TraceBase.None.INSTANCE) {
            traceBase.append("lazySet(" + value + ')');
        }
        InterceptorKt.getInterceptor().afterSet(this, value);
    }

    public final void minusAssign(long delta) {
        getAndAdd(-delta);
    }

    public final void plusAssign(long delta) {
        getAndAdd(delta);
    }

    public final void setValue(long j3) {
        InterceptorKt.getInterceptor().beforeUpdate(this);
        this.value = j3;
        TraceBase traceBase = this.trace;
        if (traceBase != TraceBase.None.INSTANCE) {
            traceBase.append("set(" + j3 + ')');
        }
        InterceptorKt.getInterceptor().afterSet(this, j3);
    }

    @NotNull
    public String toString() {
        return String.valueOf(this.value);
    }

    public final long getValue(@Nullable Object thisRef, @NotNull KProperty<?> property) {
        Intrinsics.checkNotNullParameter(property, "property");
        return getValue();
    }

    public final void setValue(@Nullable Object thisRef, @NotNull KProperty<?> property, long value) {
        Intrinsics.checkNotNullParameter(property, "property");
        setValue(value);
    }
}
