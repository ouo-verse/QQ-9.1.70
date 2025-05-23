package com.tencent.qqlive.playerinterface;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes22.dex */
public @interface QAdPlayerConstants$QAdCompleteReason {
    public static final int FINISH = 1;
    public static final int GET_AD_ERROR = 4;
    public static final int OTHER = 0;
    public static final int PLAYER_ERROR = 3;
    public static final int SKIP = 2;
    public static final int TIME_OUT = 5;
    public static final int USER_RETURN = 6;
}
