package kotlinx.atomicfu;

import ADV_REPORT.mobile_adv_report_req;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u001e\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u001a$\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\tH\u0086\b\u00f8\u0001\u0000\u001a$\u0010\u0005\u001a\u00020\u0004*\u00020\n2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\tH\u0086\b\u00f8\u0001\u0000\u001a$\u0010\u0005\u001a\u00020\u000b*\u00020\f2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\tH\u0086\b\u00f8\u0001\u0000\u001a5\u0010\u0005\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\r2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00020\tH\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000e\u001a$\u0010\u000f\u001a\u00020\u0010*\u00020\u00072\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00120\tH\u0086\b\u00f8\u0001\u0000\u001a$\u0010\u000f\u001a\u00020\u0010*\u00020\n2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00120\tH\u0086\b\u00f8\u0001\u0000\u001a$\u0010\u000f\u001a\u00020\u0010*\u00020\f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00120\tH\u0086\b\u00f8\u0001\u0000\u001a0\u0010\u000f\u001a\u00020\u0010\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\r2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00120\tH\u0086\b\u00f8\u0001\u0000\u001a$\u0010\u0013\u001a\u00020\u0012*\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\tH\u0086\b\u00f8\u0001\u0000\u001a$\u0010\u0013\u001a\u00020\u0012*\u00020\n2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\tH\u0086\b\u00f8\u0001\u0000\u001a$\u0010\u0013\u001a\u00020\u0012*\u00020\f2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\tH\u0086\b\u00f8\u0001\u0000\u001a0\u0010\u0013\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\r2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00020\tH\u0086\b\u00f8\u0001\u0000\u001a$\u0010\u0014\u001a\u00020\u0006*\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\tH\u0086\b\u00f8\u0001\u0000\u001a$\u0010\u0014\u001a\u00020\u0004*\u00020\n2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\tH\u0086\b\u00f8\u0001\u0000\u001a$\u0010\u0014\u001a\u00020\u000b*\u00020\f2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\tH\u0086\b\u00f8\u0001\u0000\u001a5\u0010\u0014\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\r2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00020\tH\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000e\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u0015"}, d2 = {"atomicArrayOfNulls", "Lkotlinx/atomicfu/AtomicArray;", "T", "size", "", "getAndUpdate", "", "Lkotlinx/atomicfu/AtomicBoolean;", "function", "Lkotlin/Function1;", "Lkotlinx/atomicfu/AtomicInt;", "", "Lkotlinx/atomicfu/AtomicLong;", "Lkotlinx/atomicfu/AtomicRef;", "(Lkotlinx/atomicfu/AtomicRef;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "loop", "", "action", "", "update", "updateAndGet", "atomicfu"}, k = 2, mv = {1, 4, 3})
/* loaded from: classes28.dex */
public final class AtomicFU_commonKt {
    @NotNull
    public static final <T> AtomicArray<T> atomicArrayOfNulls(int i3) {
        return new AtomicArray<>(i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Object] */
    public static final <T> T getAndUpdate(@NotNull AtomicRef<T> getAndUpdate, @NotNull Function1<? super T, ? extends T> function) {
        ?? r06;
        Intrinsics.checkNotNullParameter(getAndUpdate, "$this$getAndUpdate");
        Intrinsics.checkNotNullParameter(function, "function");
        do {
            r06 = (Object) getAndUpdate.getValue();
        } while (!getAndUpdate.compareAndSet(r06, function.invoke(r06)));
        return r06;
    }

    @NotNull
    public static final <T> Void loop(@NotNull AtomicRef<T> loop, @NotNull Function1<? super T, Unit> action) {
        Intrinsics.checkNotNullParameter(loop, "$this$loop");
        Intrinsics.checkNotNullParameter(action, "action");
        while (true) {
            action.invoke(loop.getValue());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> void update(@NotNull AtomicRef<T> update, @NotNull Function1<? super T, ? extends T> function) {
        mobile_adv_report_req mobile_adv_report_reqVar;
        Intrinsics.checkNotNullParameter(update, "$this$update");
        Intrinsics.checkNotNullParameter(function, "function");
        do {
            mobile_adv_report_reqVar = (Object) update.getValue();
        } while (!update.compareAndSet(mobile_adv_report_reqVar, function.invoke(mobile_adv_report_reqVar)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T updateAndGet(@NotNull AtomicRef<T> updateAndGet, @NotNull Function1<? super T, ? extends T> function) {
        mobile_adv_report_req mobile_adv_report_reqVar;
        T invoke;
        Intrinsics.checkNotNullParameter(updateAndGet, "$this$updateAndGet");
        Intrinsics.checkNotNullParameter(function, "function");
        do {
            mobile_adv_report_reqVar = (Object) updateAndGet.getValue();
            invoke = function.invoke(mobile_adv_report_reqVar);
        } while (!updateAndGet.compareAndSet(mobile_adv_report_reqVar, invoke));
        return invoke;
    }

    @NotNull
    public static final Void loop(@NotNull AtomicBoolean loop, @NotNull Function1<? super Boolean, Unit> action) {
        Intrinsics.checkNotNullParameter(loop, "$this$loop");
        Intrinsics.checkNotNullParameter(action, "action");
        while (true) {
            action.invoke(Boolean.valueOf(loop.getValue()));
        }
    }

    @NotNull
    public static final Void loop(@NotNull AtomicInt loop, @NotNull Function1<? super Integer, Unit> action) {
        Intrinsics.checkNotNullParameter(loop, "$this$loop");
        Intrinsics.checkNotNullParameter(action, "action");
        while (true) {
            action.invoke(Integer.valueOf(loop.getValue()));
        }
    }

    public static final boolean getAndUpdate(@NotNull AtomicBoolean getAndUpdate, @NotNull Function1<? super Boolean, Boolean> function) {
        boolean value;
        Intrinsics.checkNotNullParameter(getAndUpdate, "$this$getAndUpdate");
        Intrinsics.checkNotNullParameter(function, "function");
        do {
            value = getAndUpdate.getValue();
        } while (!getAndUpdate.compareAndSet(value, function.invoke(Boolean.valueOf(value)).booleanValue()));
        return value;
    }

    @NotNull
    public static final Void loop(@NotNull AtomicLong loop, @NotNull Function1<? super Long, Unit> action) {
        Intrinsics.checkNotNullParameter(loop, "$this$loop");
        Intrinsics.checkNotNullParameter(action, "action");
        while (true) {
            action.invoke(Long.valueOf(loop.getValue()));
        }
    }

    public static final void update(@NotNull AtomicBoolean update, @NotNull Function1<? super Boolean, Boolean> function) {
        boolean value;
        Intrinsics.checkNotNullParameter(update, "$this$update");
        Intrinsics.checkNotNullParameter(function, "function");
        do {
            value = update.getValue();
        } while (!update.compareAndSet(value, function.invoke(Boolean.valueOf(value)).booleanValue()));
    }

    public static final boolean updateAndGet(@NotNull AtomicBoolean updateAndGet, @NotNull Function1<? super Boolean, Boolean> function) {
        boolean value;
        boolean booleanValue;
        Intrinsics.checkNotNullParameter(updateAndGet, "$this$updateAndGet");
        Intrinsics.checkNotNullParameter(function, "function");
        do {
            value = updateAndGet.getValue();
            booleanValue = function.invoke(Boolean.valueOf(value)).booleanValue();
        } while (!updateAndGet.compareAndSet(value, booleanValue));
        return booleanValue;
    }

    public static final int getAndUpdate(@NotNull AtomicInt getAndUpdate, @NotNull Function1<? super Integer, Integer> function) {
        int value;
        Intrinsics.checkNotNullParameter(getAndUpdate, "$this$getAndUpdate");
        Intrinsics.checkNotNullParameter(function, "function");
        do {
            value = getAndUpdate.getValue();
        } while (!getAndUpdate.compareAndSet(value, function.invoke(Integer.valueOf(value)).intValue()));
        return value;
    }

    public static final void update(@NotNull AtomicInt update, @NotNull Function1<? super Integer, Integer> function) {
        int value;
        Intrinsics.checkNotNullParameter(update, "$this$update");
        Intrinsics.checkNotNullParameter(function, "function");
        do {
            value = update.getValue();
        } while (!update.compareAndSet(value, function.invoke(Integer.valueOf(value)).intValue()));
    }

    public static final int updateAndGet(@NotNull AtomicInt updateAndGet, @NotNull Function1<? super Integer, Integer> function) {
        int value;
        int intValue;
        Intrinsics.checkNotNullParameter(updateAndGet, "$this$updateAndGet");
        Intrinsics.checkNotNullParameter(function, "function");
        do {
            value = updateAndGet.getValue();
            intValue = function.invoke(Integer.valueOf(value)).intValue();
        } while (!updateAndGet.compareAndSet(value, intValue));
        return intValue;
    }

    public static final long getAndUpdate(@NotNull AtomicLong getAndUpdate, @NotNull Function1<? super Long, Long> function) {
        long value;
        Intrinsics.checkNotNullParameter(getAndUpdate, "$this$getAndUpdate");
        Intrinsics.checkNotNullParameter(function, "function");
        do {
            value = getAndUpdate.getValue();
        } while (!getAndUpdate.compareAndSet(value, function.invoke(Long.valueOf(value)).longValue()));
        return value;
    }

    public static final void update(@NotNull AtomicLong update, @NotNull Function1<? super Long, Long> function) {
        long value;
        Intrinsics.checkNotNullParameter(update, "$this$update");
        Intrinsics.checkNotNullParameter(function, "function");
        do {
            value = update.getValue();
        } while (!update.compareAndSet(value, function.invoke(Long.valueOf(value)).longValue()));
    }

    public static final long updateAndGet(@NotNull AtomicLong updateAndGet, @NotNull Function1<? super Long, Long> function) {
        long value;
        long longValue;
        Intrinsics.checkNotNullParameter(updateAndGet, "$this$updateAndGet");
        Intrinsics.checkNotNullParameter(function, "function");
        do {
            value = updateAndGet.getValue();
            longValue = function.invoke(Long.valueOf(value)).longValue();
        } while (!updateAndGet.compareAndSet(value, longValue));
        return longValue;
    }
}
