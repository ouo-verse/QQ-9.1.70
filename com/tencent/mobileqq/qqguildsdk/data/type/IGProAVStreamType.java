package com.tencent.mobileqq.qqguildsdk.data.type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes17.dex */
public @interface IGProAVStreamType {
    public static final int FLV = 4;
    public static final int HLS = 5;
    public static final int NO = 1;
    public static final int QWE_RTC = 3;
    public static final int TRTC = 2;
    public static final int UNKNOWN = 0;
}
