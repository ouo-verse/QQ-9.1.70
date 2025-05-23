package com.airbnb.lottie.model;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Pair;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class MutablePair<T> {

    @Nullable
    T first;

    @Nullable
    T second;

    private static boolean objectsEqual(Object obj, Object obj2) {
        if (obj != obj2 && (obj == null || !obj.equals(obj2))) {
            return false;
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        if (!objectsEqual(pair.first, this.first) || !objectsEqual(pair.second, this.second)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode;
        T t16 = this.first;
        int i3 = 0;
        if (t16 == null) {
            hashCode = 0;
        } else {
            hashCode = t16.hashCode();
        }
        T t17 = this.second;
        if (t17 != null) {
            i3 = t17.hashCode();
        }
        return hashCode ^ i3;
    }

    public void set(T t16, T t17) {
        this.first = t16;
        this.second = t17;
    }

    public String toString() {
        return "Pair{" + this.first + " " + this.second + "}";
    }
}
