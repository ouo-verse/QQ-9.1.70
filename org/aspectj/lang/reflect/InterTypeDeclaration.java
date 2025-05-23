package org.aspectj.lang.reflect;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface InterTypeDeclaration {
    AjType<?> getDeclaringType();

    int getModifiers();

    AjType<?> getTargetType() throws ClassNotFoundException;
}
