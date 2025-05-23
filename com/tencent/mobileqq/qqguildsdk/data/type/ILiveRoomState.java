package com.tencent.mobileqq.qqguildsdk.data.type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: P */
@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes17.dex */
public @interface ILiveRoomState {
    public static final int CLOSED = 2;
    public static final int INVALID = 0;
    public static final int KEEP_ALIVE = 6;
    public static final int LAGGING = 4;
    public static final int LIVING = 1;
    public static final int PAUSED = 3;
    public static final int RESTART = 5;
}
