package com.tencent.mobileqq.qqguildsdk.data.type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes17.dex */
public @interface IGProAVDevOpt {
    public static final int CLOSE = 11;
    public static final int FORCE_CLOSE = 13;
    public static final int IN_ACTIVE = 15;
    public static final int MUTE = 14;
    public static final int OPEN = 12;
    public static final int UNKNOWN = 0;
}
