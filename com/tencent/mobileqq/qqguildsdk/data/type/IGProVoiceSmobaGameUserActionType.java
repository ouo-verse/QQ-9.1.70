package com.tencent.mobileqq.qqguildsdk.data.type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes17.dex */
public @interface IGProVoiceSmobaGameUserActionType {
    public static final int USER_ACTION_DEFAULT = 0;
    public static final int USER_ACTION_JOIN = 10;
    public static final int USER_ACTION_QUIT_ACTIVE = 20;
    public static final int USER_ACTION_QUIT_PASSIVE = 21;
}
