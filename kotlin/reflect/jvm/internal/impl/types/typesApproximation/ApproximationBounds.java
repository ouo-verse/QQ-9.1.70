package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class ApproximationBounds<T> {
    private final T lower;
    private final T upper;

    public ApproximationBounds(T t16, T t17) {
        this.lower = t16;
        this.upper = t17;
    }

    public final T component1() {
        return this.lower;
    }

    public final T component2() {
        return this.upper;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ApproximationBounds)) {
            return false;
        }
        ApproximationBounds approximationBounds = (ApproximationBounds) obj;
        if (Intrinsics.areEqual(this.lower, approximationBounds.lower) && Intrinsics.areEqual(this.upper, approximationBounds.upper)) {
            return true;
        }
        return false;
    }

    public final T getLower() {
        return this.lower;
    }

    public final T getUpper() {
        return this.upper;
    }

    public int hashCode() {
        int hashCode;
        T t16 = this.lower;
        int i3 = 0;
        if (t16 == null) {
            hashCode = 0;
        } else {
            hashCode = t16.hashCode();
        }
        int i16 = hashCode * 31;
        T t17 = this.upper;
        if (t17 != null) {
            i3 = t17.hashCode();
        }
        return i16 + i3;
    }

    @NotNull
    public String toString() {
        return "ApproximationBounds(lower=" + this.lower + ", upper=" + this.upper + ')';
    }
}
