package com.tencent.mobileqq.qqguildsdk.data.type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: P */
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes17.dex */
public @interface IGuildUnNotifyFlag {
    public static final int ASSISTANT = 2;
    public static final int SHIELD = 3;
    public static final int UN_NOTIFY_CLOSE = 0;
    public static final int UN_NOTIFY_OPEN = 1;
}
