package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010&\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0010\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0001*\u0006\b\u0001\u0010\u0002 \u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00028\u0001\u00a2\u0006\u0002\u0010\u0006J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0016\u0010\u0004\u001a\u00028\u0000X\u0096\u0004\u00a2\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0005\u001a\u00028\u0001X\u0096\u0004\u00a2\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b\u00a8\u0006\u0013"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/MapEntry;", "K", "V", "", "key", "value", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getKey", "()Ljava/lang/Object;", "Ljava/lang/Object;", HippyTextInputController.COMMAND_getValue, "equals", "", "other", "", "hashCode", "", "toString", "", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes39.dex */
public class MapEntry<K, V> implements Map.Entry<K, V>, KMappedMarker {
    private final K key;
    private final V value;

    public MapEntry(K k3, V v3) {
        this.key = k3;
        this.value = v3;
    }

    @Override // java.util.Map.Entry
    public boolean equals(Object other) {
        Map.Entry entry = other instanceof Map.Entry ? (Map.Entry) other : null;
        return entry != null && Intrinsics.areEqual(entry.getKey(), getKey()) && Intrinsics.areEqual(entry.getValue(), getValue());
    }

    @Override // java.util.Map.Entry
    public K getKey() {
        return this.key;
    }

    @Override // java.util.Map.Entry
    public V getValue() {
        return this.value;
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        K key = getKey();
        int hashCode = key != null ? key.hashCode() : 0;
        V value = getValue();
        return hashCode ^ (value != null ? value.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public V setValue(V v3) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(getKey());
        sb5.append('=');
        sb5.append(getValue());
        return sb5.toString();
    }
}
