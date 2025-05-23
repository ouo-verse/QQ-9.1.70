package kl3;

import android.util.ArrayMap;
import android.util.ArraySet;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class a {
    public static <K, V> Map<K, V> a() {
        return new ArrayMap();
    }

    public static <K, V> Map<K, V> b(int i3) {
        return new ArrayMap(i3);
    }

    public static <E> Set<E> c() {
        return new ArraySet();
    }
}
