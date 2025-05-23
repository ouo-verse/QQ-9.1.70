package com.tencent.thumbplayer.common;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes26.dex */
public class TPHashMapBuilder<K, V> {
    private Map<K, V> map = new HashMap();

    public Map<K, V> build() {
        return this.map;
    }

    public TPHashMapBuilder<K, V> put(K k3, V v3) {
        this.map.put(k3, v3);
        return this;
    }

    public Map<K, V> readOnly() {
        return Collections.unmodifiableMap(this.map);
    }
}
