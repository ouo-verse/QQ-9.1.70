package com.tencent.mobileqq.qroute.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: P */
@Target({ElementType.FIELD})
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes17.dex */
public @interface ConfigInject {
    String configPath();

    int version() default 0;
}
