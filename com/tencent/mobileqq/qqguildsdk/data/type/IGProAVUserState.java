package com.tencent.mobileqq.qqguildsdk.data.type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes17.dex */
public @interface IGProAVUserState {
    public static final int APPLYING = 2;
    public static final int DOWNING = 5;
    public static final int INVITED = 7;
    public static final int QUEUE_INVITED = 9;
    public static final int REFUSED = 6;
    public static final int SILENCE = 1;
    public static final int SPEAKING = 4;
    public static final int SPEAK_QUEUE = 8;
    public static final int UNKNOWN = 0;
    public static final int WAITING = 3;
}
