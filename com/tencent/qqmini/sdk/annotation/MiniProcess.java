package com.tencent.qqmini.sdk.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes23.dex */
public @interface MiniProcess {
    Class internalUI() default Object.class;

    String name();

    ProcessType processType() default ProcessType.MINI_APP;

    Class receiver();

    int supportRuntimeType();

    Class ui();
}
