package com.tencent.mobileqq.qqguildsdk.data.type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes17.dex */
public @interface IGProAVThemeType {
    public static final int CHAT = 1;
    public static final int LISTEN = 4;
    public static final int LIVE = 3;
    public static final int LOBBY_GAME = 6;
    public static final int PLAY = 2;
    public static final int SCREEN_SHARE = 7;
    public static final int UNKNOWN = 0;
    public static final int WORLD = 5;
}
