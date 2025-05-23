package com.tencent.ecommerce.richtext.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: P */
@Inherited
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes5.dex */
public @interface JSMethod {
    public static final String NOT_SET = "_";

    String alias() default "_";

    boolean uiThread() default true;
}
