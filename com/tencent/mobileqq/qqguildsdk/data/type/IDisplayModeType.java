package com.tencent.mobileqq.qqguildsdk.data.type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: P */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes17.dex */
public @interface IDisplayModeType {
    public static final int MODE_EVERY_TIME = 2;
    public static final int MODE_ONCE_PER_LIVE = 1;
    public static final int MODE_USELESS = 0;
}
