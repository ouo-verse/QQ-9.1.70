package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Map;

/* compiled from: P */
@GwtCompatible
/* loaded from: classes2.dex */
public interface g<K, V> extends Map<K, V> {
    g<V, K> inverse();
}
