package com.tencent.mobileqq.qqguildsdk.data.type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes17.dex */
public @interface IGProVoiceSmobaGameOperType {
    public static final int CREATE_OPER = 1;
    public static final int DEFAULT_OPER = 0;
    public static final int DISMISS_OPER = 2;
}
