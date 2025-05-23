package com.tencent.mobileqq.qqguildsdk.data.type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes17.dex */
public @interface IChannelAuthControlSwitchPermissionType {
    public static final int ALL = 0;
    public static final int PORTION = 1;
}
