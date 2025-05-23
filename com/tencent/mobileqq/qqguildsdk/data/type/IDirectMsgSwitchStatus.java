package com.tencent.mobileqq.qqguildsdk.data.type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: P */
@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes17.dex */
public @interface IDirectMsgSwitchStatus {
    public static final int ALL = 2;
    public static final int DEFAULT = 0;
    public static final int NONE = 3;
    public static final int USER_LOGIN = 1;
}
