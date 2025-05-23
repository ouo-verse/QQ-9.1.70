package com.tencent.mobileqq.qqguildsdk.data.type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: P */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes17.dex */
public @interface ISecurityActionType {
    public static final int ACTION_LOW_CREDIT_POINTS = 200;
    public static final int Action_DROP = 4;
    public static final int Action_FREQUENCY = 2;
    public static final int Action_LACK_CERTIFICATION = 102;
    public static final int Action_LOCKED_SITE = 103;
    public static final int Action_PERMISSION_DENIED = 101;
    public static final int Action_RESET = 1;
    public static final int Action_SAFE = 0;
    public static final int Action_SENEITIVE = 3;
}
