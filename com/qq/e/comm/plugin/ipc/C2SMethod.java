package com.qq.e.comm.plugin.ipc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: P */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes3.dex */
public @interface C2SMethod {
    String action();

    String module();

    String[] params() default {""};

    String[] results() default {""};
}
