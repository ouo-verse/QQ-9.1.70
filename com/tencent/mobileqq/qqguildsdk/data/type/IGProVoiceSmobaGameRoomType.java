package com.tencent.mobileqq.qqguildsdk.data.type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes17.dex */
public @interface IGProVoiceSmobaGameRoomType {
    public static final int ROOM_TYPE_DEFAULT = 0;
    public static final int ROOM_TYPE_SMOBA = 1;
}
