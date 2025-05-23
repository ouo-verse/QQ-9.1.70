package com.tencent.mobileqq.qqguildsdk.data.type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes17.dex */
public @interface IChannelUserPermissionFilterType {
    public static final int ACTIVITY_PERMISSION = 32;
    public static final int ALL_PERMISSION = 1;
    public static final int EDIT_PERMISSION = 16;
    public static final int INVALID = 0;
    public static final int LIVE_PERMISSION = 8;
    public static final int SPEAK_PERMISSION = 4;
    public static final int VIEW_PERMISSION = 2;
}
