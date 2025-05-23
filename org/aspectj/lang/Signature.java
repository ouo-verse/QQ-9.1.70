package org.aspectj.lang;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface Signature {
    Class getDeclaringType();

    String getDeclaringTypeName();

    int getModifiers();

    String getName();

    String toLongString();

    String toShortString();

    String toString();
}
