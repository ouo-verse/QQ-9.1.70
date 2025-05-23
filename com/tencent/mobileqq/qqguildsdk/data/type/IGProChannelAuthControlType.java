package com.tencent.mobileqq.qqguildsdk.data.type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes17.dex */
public @interface IGProChannelAuthControlType {
    public static final int GPROCHANNELAUTHCONTROLTYPE_ACTIVITY = 5;
    public static final int GPROCHANNELAUTHCONTROLTYPE_EDIT = 4;
    public static final int GPROCHANNELAUTHCONTROLTYPE_SPEAK = 2;
}
