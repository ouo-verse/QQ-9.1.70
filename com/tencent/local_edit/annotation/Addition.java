package com.tencent.local_edit.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: P */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes7.dex */
public @interface Addition {
    boolean[] booleanType() default {};

    byte[] byteType() default {};

    char[] charType() default {};

    double[] doubleType() default {};

    float[] floatType() default {};

    int[] intTypeType() default {};

    long[] longType() default {};

    short[] shortType() default {};

    String[] stringType() default {};

    String[] value() default {};
}
