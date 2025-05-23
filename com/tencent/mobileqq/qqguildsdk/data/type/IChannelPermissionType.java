package com.tencent.mobileqq.qqguildsdk.data.type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.SOURCE)
@Deprecated
/* loaded from: classes17.dex */
public @interface IChannelPermissionType {
    public static final int PERMISSION_ADMIN = 2;
    public static final int PERMISSION_ALL = 1;
    public static final int PERMISSION_INVALID = 0;
}
