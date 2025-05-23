package org.aspectj.lang.reflect;

import java.lang.reflect.Type;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface InterTypeFieldDeclaration extends InterTypeDeclaration {
    Type getGenericType();

    String getName();

    AjType<?> getType();
}
