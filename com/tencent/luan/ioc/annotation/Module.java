package com.tencent.luan.ioc.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/* compiled from: P */
@Target({ElementType.TYPE})
@Documented
/* loaded from: classes7.dex */
public @interface Module {
    String[] value();
}
