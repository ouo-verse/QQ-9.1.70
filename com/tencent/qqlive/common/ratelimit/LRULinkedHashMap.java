package com.tencent.qqlive.common.ratelimit;

import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class LRULinkedHashMap<K, V> extends LinkedHashMap<K, V> {
    private static final long serialVersionUID = 1;
    private final int maxCapacity;

    public LRULinkedHashMap(int i3) {
        super(i3, 0.75f, true);
        this.maxCapacity = i3;
    }

    @Override // java.util.LinkedHashMap
    protected boolean removeEldestEntry(Map.Entry<K, V> entry) {
        if (size() > this.maxCapacity) {
            return true;
        }
        return false;
    }
}
