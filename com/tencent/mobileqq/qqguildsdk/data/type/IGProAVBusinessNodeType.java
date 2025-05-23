package com.tencent.mobileqq.qqguildsdk.data.type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD, ElementType.TYPE_USE})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes17.dex */
public @interface IGProAVBusinessNodeType {
    public static final int DISPLAY_GAME = 1;
    public static final int DISPLAY_LISTEN_TOGETHER = 5;
    public static final int DISPLAY_LOBBY_APP = 6;
    public static final int DISPLAY_SCREEN_SHARE = 2;
    public static final int DISPLAY_WORLD = 3;
    public static final int UNKNOWN = 0;
}
