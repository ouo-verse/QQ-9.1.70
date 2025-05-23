package com.tencent.mobileqq.qqguildsdk.data.type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: P */
@Target({ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD, ElementType.LOCAL_VARIABLE})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes17.dex */
public @interface ISpeakThresholdLimitType {
    public static final int DEFAULT = 0;
    public static final int JOIN_TIME = 4;
    public static final int NONE = 1;
    public static final int REAL_NAME = 2;
}
