package com.tencent.luggage.wxaapi;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: P */
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes9.dex */
@interface Since {
    String version() default "1.0.0";
}
