package com.tencent.mobileqq.qqguildsdk.data.type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: P */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes17.dex */
public @interface IGuildScheduleListGetType {
    public static final int DEFAULT = 0;
    public static final int TYPE_BACKWARD = 2;
    public static final int TYPE_FORWARD = 1;
}
