package com.tencent.mobileqq.qqguildsdk.data.type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes17.dex */
public @interface ILiveRoomPlatform {
    public static final int DEFAULT = 0;
    public static final int PAD = 2;
    public static final int PC_OR_MAC = 3;
    public static final int PHONE = 1;
}
