package h0;

import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;

/* compiled from: P */
/* loaded from: classes.dex */
public final class b<K, V> extends ArrayMap<K, V> {

    /* renamed from: d, reason: collision with root package name */
    private int f403946d;

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public void clear() {
        this.f403946d = 0;
        super.clear();
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public int hashCode() {
        if (this.f403946d == 0) {
            this.f403946d = super.hashCode();
        }
        return this.f403946d;
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public V put(K k3, V v3) {
        this.f403946d = 0;
        return (V) super.put(k3, v3);
    }

    @Override // androidx.collection.SimpleArrayMap
    public void putAll(SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        this.f403946d = 0;
        super.putAll(simpleArrayMap);
    }

    @Override // androidx.collection.SimpleArrayMap
    public V removeAt(int i3) {
        this.f403946d = 0;
        return (V) super.removeAt(i3);
    }

    @Override // androidx.collection.SimpleArrayMap
    public V setValueAt(int i3, V v3) {
        this.f403946d = 0;
        return (V) super.setValueAt(i3, v3);
    }
}
