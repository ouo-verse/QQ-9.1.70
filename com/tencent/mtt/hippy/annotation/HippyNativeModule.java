package com.tencent.mtt.hippy.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: P */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes20.dex */
public @interface HippyNativeModule {

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public enum Thread {
        BRIDGE,
        MAIN,
        DOM
    }

    boolean init() default false;

    String name();

    String[] names() default {};

    Thread thread() default Thread.BRIDGE;
}
