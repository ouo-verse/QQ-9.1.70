package com.tencent.upload.network.base;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/* compiled from: P */
@Target({ElementType.METHOD})
/* loaded from: classes27.dex */
public @interface ConnCallback {
    int id() default -1;

    String name() default "";
}
