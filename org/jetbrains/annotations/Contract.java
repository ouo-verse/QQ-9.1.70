package org.jetbrains.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: P */
@Target({ElementType.METHOD})
@Documented
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes29.dex */
public @interface Contract {
    boolean pure() default false;

    String value() default "";
}
