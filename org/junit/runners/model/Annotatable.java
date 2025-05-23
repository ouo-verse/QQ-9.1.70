package org.junit.runners.model;

import java.lang.annotation.Annotation;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface Annotatable {
    <T extends Annotation> T getAnnotation(Class<T> cls);

    Annotation[] getAnnotations();
}
