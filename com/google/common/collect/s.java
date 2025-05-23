package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.CompatibleWith;
import java.util.Collection;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: P */
@GwtCompatible
/* loaded from: classes2.dex */
public interface s<K, V> {
    Map<K, Collection<V>> asMap();

    Collection<Map.Entry<K, V>> entries();

    Collection<V> get(@NullableDecl K k3);

    boolean isEmpty();

    @CanIgnoreReturnValue
    Collection<V> removeAll(@NullableDecl @CompatibleWith("K") Object obj);

    int size();
}
