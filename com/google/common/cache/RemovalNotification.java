package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import java.util.AbstractMap;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: P */
@GwtCompatible
/* loaded from: classes2.dex */
public final class RemovalNotification<K, V> extends AbstractMap.SimpleImmutableEntry<K, V> {
    private static final long serialVersionUID = 0;
    private final RemovalCause cause;

    RemovalNotification(@NullableDecl K k3, @NullableDecl V v3, RemovalCause removalCause) {
        super(k3, v3);
        this.cause = (RemovalCause) com.google.common.base.j.m(removalCause);
    }

    public static <K, V> RemovalNotification<K, V> create(@NullableDecl K k3, @NullableDecl V v3, RemovalCause removalCause) {
        return new RemovalNotification<>(k3, v3, removalCause);
    }

    public RemovalCause getCause() {
        return this.cause;
    }

    public boolean wasEvicted() {
        return this.cause.wasEvicted();
    }
}
