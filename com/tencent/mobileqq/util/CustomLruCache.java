package com.tencent.mobileqq.util;

import android.support.v4.util.LruCache;

/* compiled from: P */
/* loaded from: classes20.dex */
public class CustomLruCache<K, V> extends LruCache<K, V> {
    public CustomLruCache(int i3) {
        super(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.util.LruCache
    public V create(K k3) {
        return (V) super.create(k3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.util.LruCache
    public void entryRemoved(boolean z16, K k3, V v3, V v16) {
        super.entryRemoved(z16, k3, v3, v16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.util.LruCache
    public int sizeOf(K k3, V v3) {
        return super.sizeOf(k3, v3);
    }
}
