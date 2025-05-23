package com.tencent.mobileqq.qqguildsdk.data.type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes17.dex */
public @interface IGProChannelAuthControlPermission {
    public static final int GPROCHANNELAUTHCONTROLPERMISSION_ALL = 0;
    public static final int GPROCHANNELAUTHCONTROLPERMISSION_SPECIFIED = 1;
}
