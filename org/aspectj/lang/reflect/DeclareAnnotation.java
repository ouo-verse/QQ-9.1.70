package org.aspectj.lang.reflect;

import java.lang.annotation.Annotation;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface DeclareAnnotation {

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public enum Kind {
        Field,
        Method,
        Constructor,
        Type
    }

    Annotation getAnnotation();

    String getAnnotationAsText();

    AjType<?> getDeclaringType();

    Kind getKind();

    SignaturePattern getSignaturePattern();

    TypePattern getTypePattern();
}
