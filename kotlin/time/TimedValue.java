package kotlin.time;

import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@SinceKotlin(version = "1.3")
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0018\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\r\u001a\u00028\u0000H\u00c6\u0003\u00a2\u0006\u0002\u0010\u000bJ\u0016\u0010\u000e\u001a\u00020\u0005H\u00c6\u0003\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\bJ-\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001R\u0019\u0010\u0004\u001a\u00020\u0005\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0003\u001a\u00028\u0000\u00a2\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u0006\u001a"}, d2 = {"Lkotlin/time/TimedValue;", "T", "", "value", "duration", "Lkotlin/time/Duration;", "(Ljava/lang/Object;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getDuration-UwyO8pc", "()J", "J", HippyTextInputController.COMMAND_getValue, "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component2", "component2-UwyO8pc", "copy", "copy-RFiDyg4", "(Ljava/lang/Object;J)Lkotlin/time/TimedValue;", "equals", "", "other", "hashCode", "", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
@ExperimentalTime
/* loaded from: classes28.dex */
public final /* data */ class TimedValue<T> {
    private final long duration;
    private final T value;

    public /* synthetic */ TimedValue(Object obj, long j3, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, j3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: copy-RFiDyg4$default, reason: not valid java name */
    public static /* synthetic */ TimedValue m1978copyRFiDyg4$default(TimedValue timedValue, Object obj, long j3, int i3, Object obj2) {
        if ((i3 & 1) != 0) {
            obj = timedValue.value;
        }
        if ((i3 & 2) != 0) {
            j3 = timedValue.duration;
        }
        return timedValue.m1980copyRFiDyg4(obj, j3);
    }

    public final T component1() {
        return this.value;
    }

    /* renamed from: component2-UwyO8pc, reason: not valid java name and from getter */
    public final long getDuration() {
        return this.duration;
    }

    @NotNull
    /* renamed from: copy-RFiDyg4, reason: not valid java name */
    public final TimedValue<T> m1980copyRFiDyg4(T value, long duration) {
        return new TimedValue<>(value, duration, null);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TimedValue)) {
            return false;
        }
        TimedValue timedValue = (TimedValue) other;
        if (Intrinsics.areEqual(this.value, timedValue.value) && Duration.m1831equalsimpl0(this.duration, timedValue.duration)) {
            return true;
        }
        return false;
    }

    /* renamed from: getDuration-UwyO8pc, reason: not valid java name */
    public final long m1981getDurationUwyO8pc() {
        return this.duration;
    }

    public final T getValue() {
        return this.value;
    }

    public int hashCode() {
        int hashCode;
        T t16 = this.value;
        if (t16 == null) {
            hashCode = 0;
        } else {
            hashCode = t16.hashCode();
        }
        return (hashCode * 31) + Duration.m1854hashCodeimpl(this.duration);
    }

    @NotNull
    public String toString() {
        return "TimedValue(value=" + this.value + ", duration=" + ((Object) Duration.m1875toStringimpl(this.duration)) + ')';
    }

    TimedValue(T t16, long j3) {
        this.value = t16;
        this.duration = j3;
    }
}
