package com.tencent.ecommerce.richtext.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes5.dex */
public @interface VComponentProp {
    public static final String NOT_INIT = "NOTINIT";

    boolean initToHostView() default false;

    String name();

    String nativeReturnMethod() default "NOTINIT";
}
