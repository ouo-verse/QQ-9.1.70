package com.tencent.qqmini.sdk.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes23.dex */
public @interface JsPlugin {
    boolean lazyLoad() default true;

    Restriction restriction() default Restriction.NONE;

    boolean secondary() default false;
}
