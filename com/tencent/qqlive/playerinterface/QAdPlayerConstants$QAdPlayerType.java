package com.tencent.qqlive.playerinterface;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes22.dex */
public @interface QAdPlayerConstants$QAdPlayerType {
    public static final int PLAYER_TYPE_EXTERNAL_URL = 5;
    public static final int PLAYER_TYPE_LOCAL_FILE = 4;
    public static final int PLAYER_TYPE_OFFLINE = 3;
    public static final int PLAYER_TYPE_ONLINE_LIVE = 1;
    public static final int PLAYER_TYPE_ONLINE_VOD = 2;
}
