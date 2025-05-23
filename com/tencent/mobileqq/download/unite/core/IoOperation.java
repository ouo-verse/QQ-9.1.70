package com.tencent.mobileqq.download.unite.core;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: P */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.LOCAL_VARIABLE})
@Documented
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes10.dex */
public @interface IoOperation {
    String value() default "";
}
