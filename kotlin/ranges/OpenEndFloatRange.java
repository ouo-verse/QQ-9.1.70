package kotlin.ranges;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u00a2\u0006\u0002\u0010\u0005J\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0096\u0002J\u0013\u0010\u000e\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\fH\u0016J\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0002H\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u000e\u0010\u0006\u001a\u00020\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\t\u00a8\u0006\u0019"}, d2 = {"Lkotlin/ranges/OpenEndFloatRange;", "Lkotlin/ranges/OpenEndRange;", "", "start", "endExclusive", "(FF)V", "_endExclusive", "_start", "getEndExclusive", "()Ljava/lang/Float;", "getStart", "contains", "", "value", "equals", "other", "", "hashCode", "", "isEmpty", "lessThanOrEquals", "a", "b", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes28.dex */
final class OpenEndFloatRange implements OpenEndRange<Float> {
    private final float _endExclusive;
    private final float _start;

    public OpenEndFloatRange(float f16, float f17) {
        this._start = f16;
        this._endExclusive = f17;
    }

    private final boolean lessThanOrEquals(float a16, float b16) {
        if (a16 <= b16) {
            return true;
        }
        return false;
    }

    @Override // kotlin.ranges.OpenEndRange
    public /* bridge */ /* synthetic */ boolean contains(Float f16) {
        return contains(f16.floatValue());
    }

    public boolean equals(@Nullable Object other) {
        boolean z16;
        boolean z17;
        if (!(other instanceof OpenEndFloatRange)) {
            return false;
        }
        if (!isEmpty() || !((OpenEndFloatRange) other).isEmpty()) {
            OpenEndFloatRange openEndFloatRange = (OpenEndFloatRange) other;
            if (this._start == openEndFloatRange._start) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                return false;
            }
            if (this._endExclusive == openEndFloatRange._endExclusive) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Float.valueOf(this._start).hashCode() * 31) + Float.valueOf(this._endExclusive).hashCode();
    }

    @Override // kotlin.ranges.OpenEndRange
    public boolean isEmpty() {
        if (this._start >= this._endExclusive) {
            return true;
        }
        return false;
    }

    @NotNull
    public String toString() {
        return this._start + "..<" + this._endExclusive;
    }

    public boolean contains(float value) {
        return value >= this._start && value < this._endExclusive;
    }

    @Override // kotlin.ranges.OpenEndRange
    @NotNull
    public Float getEndExclusive() {
        return Float.valueOf(this._endExclusive);
    }

    @Override // kotlin.ranges.OpenEndRange
    @NotNull
    public Float getStart() {
        return Float.valueOf(this._start);
    }
}
