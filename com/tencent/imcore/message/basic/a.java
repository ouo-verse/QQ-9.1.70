package com.tencent.imcore.message.basic;

import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface a<T> {
    List<T> getInstances();

    void register(Class<? extends T> cls);

    void unregister(Class<? extends T> cls);

    List<Class<? extends T>> values();
}
