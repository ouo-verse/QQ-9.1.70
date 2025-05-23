package com.tencent.thumbplayer.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes26.dex */
public @interface TPOptionalParamValueAnnotation {
    boolean booleanValue() default false;

    float floatValue() default 0.0f;

    int intValue() default 0;

    long longValue() default 0;

    int[] queueIntValue() default {};

    String[] queueStringValue() default {};

    String stringValue() default "";

    Class<?> type() default Object.class;
}
