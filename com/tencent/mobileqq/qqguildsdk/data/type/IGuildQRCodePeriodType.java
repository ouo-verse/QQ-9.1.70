package com.tencent.mobileqq.qqguildsdk.data.type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes17.dex */
public @interface IGuildQRCodePeriodType {
    public static final int QQ_GPRO_QR_CODE_PERIOD_TYPE_24_HOURS = 1;
    public static final int QQ_GPRO_QR_CODE_PERIOD_TYPE_30_DAYS = 2;
    public static final int QQ_GPRO_QR_CODE_PERIOD_TYPE_7_DAYS = 0;
    public static final int QQ_GPRO_QR_CODE_PERIOD_TYPE_FOREVER = 3;
}
