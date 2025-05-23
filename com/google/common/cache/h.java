package com.google.common.cache;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.cache.LocalCache;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: P */
@GwtIncompatible
/* loaded from: classes2.dex */
interface h<K, V> {
    long getAccessTime();

    int getHash();

    @NullableDecl
    K getKey();

    @NullableDecl
    h<K, V> getNext();

    h<K, V> getNextInAccessQueue();

    h<K, V> getNextInWriteQueue();

    h<K, V> getPreviousInAccessQueue();

    h<K, V> getPreviousInWriteQueue();

    LocalCache.s<K, V> getValueReference();

    long getWriteTime();

    void setAccessTime(long j3);

    void setNextInAccessQueue(h<K, V> hVar);

    void setNextInWriteQueue(h<K, V> hVar);

    void setPreviousInAccessQueue(h<K, V> hVar);

    void setPreviousInWriteQueue(h<K, V> hVar);

    void setValueReference(LocalCache.s<K, V> sVar);

    void setWriteTime(long j3);
}
