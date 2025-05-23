package androidx.arch.core.internal;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.arch.core.internal.SafeIterableMap;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class FastSafeIterableMap<K, V> extends SafeIterableMap<K, V> {
    private HashMap<K, SafeIterableMap.Entry<K, V>> mHashMap = new HashMap<>();

    public Map.Entry<K, V> ceil(K k3) {
        if (contains(k3)) {
            return this.mHashMap.get(k3).mPrevious;
        }
        return null;
    }

    public boolean contains(K k3) {
        return this.mHashMap.containsKey(k3);
    }

    @Override // androidx.arch.core.internal.SafeIterableMap
    protected SafeIterableMap.Entry<K, V> get(K k3) {
        return this.mHashMap.get(k3);
    }

    @Override // androidx.arch.core.internal.SafeIterableMap
    public V putIfAbsent(@NonNull K k3, @NonNull V v3) {
        SafeIterableMap.Entry<K, V> entry = get(k3);
        if (entry != null) {
            return entry.mValue;
        }
        this.mHashMap.put(k3, put(k3, v3));
        return null;
    }

    @Override // androidx.arch.core.internal.SafeIterableMap
    public V remove(@NonNull K k3) {
        V v3 = (V) super.remove(k3);
        this.mHashMap.remove(k3);
        return v3;
    }
}
