package com.tencent.gathererga.core.internal.provider;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: P */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes6.dex */
public @interface InfoID {
    int id() default 0;

    String[] permissions() default {};
}
