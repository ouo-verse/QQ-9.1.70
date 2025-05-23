package com.tencent.qqlive.tvkplayer.tools.utils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKHashMapBuilder<K, V> {
    private static final String TAG = "TVKPlayer[TVKHashMapBuilder]";
    private Map<K, V> map = new HashMap();

    public Map<K, V> build() {
        return this.map;
    }

    public TVKHashMapBuilder<K, V> put(K k3, V v3) {
        if (k3 == null) {
            TVKLogUtil.w(TAG, "key is null ,return");
        }
        if (v3 == null) {
            TVKLogUtil.w(TAG, "put key:" + k3 + ", value is null ,return");
        }
        this.map.put(k3, v3);
        return this;
    }

    public Map<K, V> readOnly() {
        return Collections.unmodifiableMap(this.map);
    }
}
