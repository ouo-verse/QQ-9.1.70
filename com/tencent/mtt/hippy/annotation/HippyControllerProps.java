package com.tencent.mtt.hippy.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes20.dex */
public @interface HippyControllerProps {
    public static final String ARRAY = "array";
    public static final String BOOLEAN = "boolean";
    public static final String DEFAULT = "";
    public static final String MAP = "map";
    public static final String NUMBER = "number";
    public static final String STRING = "string";

    boolean defaultBoolean() default false;

    double defaultNumber() default 0.0d;

    String defaultString() default "";

    String defaultType() default "";

    String name() default "name";
}
