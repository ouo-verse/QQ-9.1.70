package com.tencent.mobileqq.qqguildsdk.data.type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes17.dex */
public @interface IRefreshUserProfileType {
    public static final int TYPE_DIRECT_MSG = 2;
    public static final int TYPE_NORMAL = 1;
}
