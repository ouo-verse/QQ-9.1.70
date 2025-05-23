package com.tencent.mtt.hippy.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes20.dex */
public @interface HippyTurboProp {
    boolean expose() default false;
}
