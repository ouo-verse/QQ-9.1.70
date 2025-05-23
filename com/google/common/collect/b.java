package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: P */
@GwtCompatible
/* loaded from: classes2.dex */
abstract class b<K, V> implements Map.Entry<K, V> {
    @Override // java.util.Map.Entry
    public boolean equals(@NullableDecl Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (!com.google.common.base.g.a(getKey(), entry.getKey()) || !com.google.common.base.g.a(getValue(), entry.getValue())) {
            return false;
        }
        return true;
    }

    @Override // java.util.Map.Entry
    public abstract K getKey();

    @Override // java.util.Map.Entry
    public abstract V getValue();

    @Override // java.util.Map.Entry
    public int hashCode() {
        int hashCode;
        K key = getKey();
        V value = getValue();
        int i3 = 0;
        if (key == null) {
            hashCode = 0;
        } else {
            hashCode = key.hashCode();
        }
        if (value != null) {
            i3 = value.hashCode();
        }
        return hashCode ^ i3;
    }

    @Override // java.util.Map.Entry
    public V setValue(V v3) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return getKey() + ContainerUtils.KEY_VALUE_DELIMITER + getValue();
    }
}
