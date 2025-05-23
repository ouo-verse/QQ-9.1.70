package com.tencent.raft.raftannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: P */
@Inherited
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes25.dex */
public @interface RaftArg {
    String method() default "";

    String name() default "";

    boolean valueBoolean() default false;

    Class<?> valueClass() default Void.class;

    double valueDouble() default 0.0d;

    float valueFloat() default 0.0f;

    int valueInt() default 0;

    String valueString() default "";
}
