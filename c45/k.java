package c45;

import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public final class k {
    public static final <K, V, C extends Map<K, V>> void a(Map.Entry<? extends K, ? extends V> entry, C c16) {
        c16.put(entry.getKey(), entry.getValue());
    }
}
