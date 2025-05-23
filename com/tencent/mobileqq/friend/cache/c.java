package com.tencent.mobileqq.friend.cache;

import com.tencent.mobileqq.persistence.Entity;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public interface c<K, V extends Entity> {
    boolean a(List<V> list);

    V b(K k3);

    V c(K k3);

    boolean d(V v3);
}
