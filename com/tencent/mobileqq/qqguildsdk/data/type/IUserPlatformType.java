package com.tencent.mobileqq.qqguildsdk.data.type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes17.dex */
public @interface IUserPlatformType {
    public static final int PLATFORM_MOBILE = 1;
    public static final int PLATFORM_MOBILE_WEB = 10362;
    public static final int PLATFORM_PAD = 2;
    public static final int PLATFORM_PCORMAC = 3;
    public static final int PLATFORM_PCQQ_WEB = 10363;
    public static final int PLATFORM_PC_WEB = 10361;
    public static final int PLATFORM_UNKONW = 0;
}
