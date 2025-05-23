package androidx.core.util;

import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class Pair<F, S> {
    public final F first;
    public final S second;

    public Pair(F f16, S s16) {
        this.first = f16;
        this.second = s16;
    }

    @NonNull
    public static <A, B> Pair<A, B> create(A a16, B b16) {
        return new Pair<>(a16, b16);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        if (!ObjectsCompat.equals(pair.first, this.first) || !ObjectsCompat.equals(pair.second, this.second)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode;
        F f16 = this.first;
        int i3 = 0;
        if (f16 == null) {
            hashCode = 0;
        } else {
            hashCode = f16.hashCode();
        }
        S s16 = this.second;
        if (s16 != null) {
            i3 = s16.hashCode();
        }
        return hashCode ^ i3;
    }

    @NonNull
    public String toString() {
        return "Pair{" + this.first + " " + this.second + "}";
    }
}
