package com.tencent.richframework.engineer.test.api;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: P */
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes25.dex */
public @interface RFWTestDataSourceList {
    String[] keys();

    String[] objNames();
}
