package org.aspectj.lang.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface InterTypeMethodDeclaration extends InterTypeDeclaration {
    AjType<?>[] getExceptionTypes();

    Type[] getGenericParameterTypes();

    Type getGenericReturnType();

    String getName();

    AjType<?>[] getParameterTypes();

    AjType<?> getReturnType();

    TypeVariable<Method>[] getTypeParameters();
}
