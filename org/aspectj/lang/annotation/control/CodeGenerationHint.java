package org.aspectj.lang.annotation.control;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: P */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes29.dex */
public @interface CodeGenerationHint {
    String ifNameSuffix() default "";
}
