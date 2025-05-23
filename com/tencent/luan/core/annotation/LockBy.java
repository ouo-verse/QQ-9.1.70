package com.tencent.luan.core.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: P */
@Target({ElementType.FIELD})
@Documented
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes7.dex */
public @interface LockBy {
    String value();
}
