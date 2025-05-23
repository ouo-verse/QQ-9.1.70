package com.tencent.luan.ioc;

import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface InjectAnalysisService {
    InjectConstructor<?> getInjectConstructor(Class<?> cls);

    List<InjectMethod> getInjectMethods(Class<?> cls);

    List<ProvideMethod<?>> getProvideMethods(Class<?> cls);

    boolean isValid();
}
