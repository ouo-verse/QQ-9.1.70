package com.tencent.mobileqq.qqguildsdk.data.type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: P */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes17.dex */
public @interface IConfigStatusType {
    public static final int STATUS_SHOW_OFF = 1;
    public static final int STATUS_SHOW_ON = 2;
    public static final int STATUS_UNKNOWN = 0;
}
