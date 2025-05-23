package com.tencent.luan.ioc;

import com.tencent.luan.ioc.wrapper.ObjectWrapper;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface InjectConstructor<T> {
    boolean needInject();

    T newInstance(Injector injector);

    String uniqueKey();

    ObjectWrapper<T> wrapper();
}
