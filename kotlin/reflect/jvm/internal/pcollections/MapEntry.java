package kotlin.reflect.jvm.internal.pcollections;

import com.huawei.hms.framework.common.ContainerUtils;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes28.dex */
final class MapEntry<K, V> implements Serializable {
    public final K key;
    public final V value;

    public MapEntry(K k3, V v3) {
        this.key = k3;
        this.value = v3;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MapEntry)) {
            return false;
        }
        MapEntry mapEntry = (MapEntry) obj;
        K k3 = this.key;
        if (k3 == null) {
            if (mapEntry.key != null) {
                return false;
            }
        } else if (!k3.equals(mapEntry.key)) {
            return false;
        }
        V v3 = this.value;
        V v16 = mapEntry.value;
        if (v3 == null) {
            if (v16 != null) {
                return false;
            }
        } else if (!v3.equals(v16)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode;
        K k3 = this.key;
        int i3 = 0;
        if (k3 == null) {
            hashCode = 0;
        } else {
            hashCode = k3.hashCode();
        }
        V v3 = this.value;
        if (v3 != null) {
            i3 = v3.hashCode();
        }
        return hashCode ^ i3;
    }

    public String toString() {
        return this.key + ContainerUtils.KEY_VALUE_DELIMITER + this.value;
    }
}
