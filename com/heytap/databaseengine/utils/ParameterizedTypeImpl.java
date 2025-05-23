package com.heytap.databaseengine.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/* loaded from: classes2.dex */
public class ParameterizedTypeImpl implements ParameterizedType {
    private Class clazz;

    public ParameterizedTypeImpl(Class cls) {
        this.clazz = cls;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type[] getActualTypeArguments() {
        return new Type[]{this.clazz};
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getOwnerType() {
        return null;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getRawType() {
        return List.class;
    }
}
