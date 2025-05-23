package com.tencent.mobileqq.qqguildsdk.data.type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: P */
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes17.dex */
public @interface ITerminateLiveStreamServiceType {
    public static final int PROGRAM_LIVE_BY_CLIENT = 5;
    public static final int PROGRAM_LIVE_BY_UNDER_CARRIAGE = 3;
    public static final int PROGRAM_LIVE_BY_WHITELIST = 4;
    public static final int STREAM_LIVE_BY_CLIENT = 2;
    public static final int UNKNOW_VALUE = 0;
    public static final int WAN_ZE_ONE_KEY_LIVE = 1;
}
