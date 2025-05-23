package com.tencent.mobileqq.qqguildsdk.data.type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: P */
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes17.dex */
public @interface IAuthControlSwitchType {
    public static final int ACTIVITY = 5;
    public static final int EDIT = 4;
    public static final int LIVE = 3;
    public static final int SC_INVALID = 0;
    public static final int SPEAK = 2;
    public static final int VIEW = 1;
}
