package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;

/* compiled from: P */
@GwtCompatible
/* loaded from: classes2.dex */
public interface i<K, V> {
    void onRemoval(RemovalNotification<K, V> removalNotification);
}
