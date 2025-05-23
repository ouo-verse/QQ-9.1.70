package org.aspectj.lang.reflect;

import java.lang.reflect.Type;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface InterTypeConstructorDeclaration extends InterTypeDeclaration {
    AjType<?>[] getExceptionTypes();

    Type[] getGenericParameterTypes();

    AjType<?>[] getParameterTypes();
}
