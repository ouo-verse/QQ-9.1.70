package com.tencent.richframework.data.base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* compiled from: P */
/* loaded from: classes25.dex */
public class DataClassUtil {
    public static Class getParameterizedTypeRealClass(Class cls, Class cls2) {
        for (Type type : cls.getGenericInterfaces()) {
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                if (parameterizedType.getRawType() == cls2) {
                    Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                    if (actualTypeArguments.length != 1) {
                        return null;
                    }
                    return (Class) actualTypeArguments[0];
                }
            }
        }
        if (cls.getSuperclass() == null) {
            return null;
        }
        return getParameterizedTypeRealClass(cls.getSuperclass(), cls2);
    }
}
