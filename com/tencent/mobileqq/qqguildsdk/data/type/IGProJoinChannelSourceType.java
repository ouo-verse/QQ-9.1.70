package com.tencent.mobileqq.qqguildsdk.data.type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes17.dex */
public @interface IGProJoinChannelSourceType {
    public static final int CHANNEL_LIST = 1;
    public static final int PUSH = 3;
    public static final int SHARE_LINK = 2;
    public static final int UNKNOWN = 0;
}
