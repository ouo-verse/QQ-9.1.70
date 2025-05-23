package com.tencent.luan.ioc.index;

import com.tencent.luan.ioc.InjectConstructor;
import com.tencent.luan.ioc.InjectMethod;
import com.tencent.luan.ioc.ProvideMethod;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface IndexInjectInfoService {
    List<ProvideMethod<?>> getAllDeclareProvideMethods(Class<?> cls);

    InjectMethod getAllInjectMethods(Class<?> cls);

    InjectConstructor<?> getDeclareInjectConstructor(Class<?> cls);
}
