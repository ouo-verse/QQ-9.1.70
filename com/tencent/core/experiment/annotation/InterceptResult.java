package com.tencent.core.experiment.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes5.dex */
public @interface InterceptResult {
    public static final int throwException = 0;
    public static final int voidReturn = 1;
}
