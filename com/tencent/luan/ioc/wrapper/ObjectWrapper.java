package com.tencent.luan.ioc.wrapper;

import com.tencent.luan.ioc.Injector;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface ObjectWrapper<T> {
    ObjectWrapper<T> combine(T t16);

    ObjectHolder<T> createObjectIfAbsent(Injector injector);

    boolean needCache();
}
