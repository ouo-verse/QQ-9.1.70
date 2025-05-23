package com.tencent.local_edit.annotation;

/* loaded from: classes7.dex */
public @interface FormPart {
    String name() default "";

    boolean required() default true;

    String value() default "";
}
