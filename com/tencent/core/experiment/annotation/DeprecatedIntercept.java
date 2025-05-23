package com.tencent.core.experiment.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: P */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes5.dex */
public @interface DeprecatedIntercept {
    @InterceptResult
    int result() default 0;
}
