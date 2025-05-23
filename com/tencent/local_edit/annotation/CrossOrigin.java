package com.tencent.local_edit.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: P */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes7.dex */
public @interface CrossOrigin {
    String allowCredentials() default "";

    String[] allowedHeaders() default {};

    String[] exposedHeaders() default {};

    long maxAge() default -1;

    RequestMethod[] methods() default {};

    String[] origins() default {};

    String[] value() default {};
}
