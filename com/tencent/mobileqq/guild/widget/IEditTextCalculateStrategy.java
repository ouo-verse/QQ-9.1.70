package com.tencent.mobileqq.guild.widget;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: P */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes14.dex */
public @interface IEditTextCalculateStrategy {
    public static final int ASCII_HALF_CALCULATE_STRATEGY = 0;
    public static final int NORMAL_CALCULATE_STRATEGY = 1;
}
