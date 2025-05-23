package com.tencent.imcore.message.basic;

import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface c<K, V> {
    void a(K k3, Class<? extends V> cls);

    V get(K k3);

    List<Class<? extends V>> values();
}
