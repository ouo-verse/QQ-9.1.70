package com.tencent.mobileqq.qqguildsdk.data.type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes17.dex */
public @interface IGProAVGameState {
    public static final int DEFAULT = 0;
    public static final int GAME_STATUS_IN_GAME = 3;
    public static final int GAME_STATUS_IN_ROOM = 2;
    public static final int GAME_STATUS_START = 1;
}
