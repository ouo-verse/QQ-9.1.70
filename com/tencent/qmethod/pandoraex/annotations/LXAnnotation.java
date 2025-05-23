package com.tencent.qmethod.pandoraex.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: P */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes22.dex */
public @interface LXAnnotation {
    String lx_description() default "";

    String lx_module() default "";

    boolean lx_show() default false;

    int lx_useflag() default 1;
}
