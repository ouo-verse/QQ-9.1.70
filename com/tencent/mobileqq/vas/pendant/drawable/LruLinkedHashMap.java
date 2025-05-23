package com.tencent.mobileqq.vas.pendant.drawable;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: P */
/* loaded from: classes20.dex */
public class LruLinkedHashMap<K, V> extends LinkedHashMap<K, V> {
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private static final long serialVersionUID = 1;
    private final Lock lock;
    protected final int maxCapacity;

    public LruLinkedHashMap(int i3) {
        super(i3, 0.75f, true);
        this.lock = new ReentrantLock();
        this.maxCapacity = i3;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        try {
            this.lock.lock();
            return (V) super.get(obj);
        } finally {
            this.lock.unlock();
        }
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public V put(K k3, V v3) {
        try {
            this.lock.lock();
            return (V) super.put(k3, v3);
        } finally {
            this.lock.unlock();
        }
    }

    @Override // java.util.LinkedHashMap
    protected boolean removeEldestEntry(Map.Entry<K, V> entry) {
        if (size() > this.maxCapacity) {
            return true;
        }
        return false;
    }
}
