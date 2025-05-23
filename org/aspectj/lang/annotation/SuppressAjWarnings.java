package org.aspectj.lang.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes29.dex */
public @interface SuppressAjWarnings {
    String[] value() default {""};
}
