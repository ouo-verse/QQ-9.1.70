package com.tencent.mobileqq.qqguildsdk.data.type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: P */
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes17.dex */
public @interface IChannelLiveType {
    public static final int ARENA_VALOR_LIVE = 1;
    public static final int ON_DEMAND = 2;
    public static final int PC_ASSISTANT = 3;
    public static final int PUSH_FLOW = 0;
}
