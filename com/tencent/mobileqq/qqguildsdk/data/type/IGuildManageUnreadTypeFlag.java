package com.tencent.mobileqq.qqguildsdk.data.type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: P */
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes17.dex */
public @interface IGuildManageUnreadTypeFlag {
    public static final int MANAGE_UNREAD_TYPE_DOT = 4;
    public static final int MANAGE_UNREAD_TYPE_GRAY = 2;
    public static final int MANAGE_UNREAD_TYPE_RED = 1;
}
