package com.tencent.mobileqq.qqguildsdk.data.type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: P */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes17.dex */
public @interface IGetBindClientServiceType {
    public static final int GET_BIND_CLIENT_LIST = 1;
    public static final int GET_SPECIFY_CLIENT = 2;
    public static final int GET_UNKNOWN = 0;
}
