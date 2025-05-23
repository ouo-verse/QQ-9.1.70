package com.tencent.qqlive.playerinterface;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes22.dex */
public @interface QAdPlayerConstants$QAdVideoStatus {
    public static final int Q_AD_STATUS_AD_PAUSED = 6;
    public static final int Q_AD_STATUS_AD_PLAYING = 5;
    public static final int Q_AD_STATUS_AD_PREPARED = 4;
    public static final int Q_AD_STATUS_AD_PREPARING = 3;
    public static final int Q_AD_STATUS_AD_REQUESTING = 1;
    public static final int Q_AD_STATUS_AD_REQUEST_RECEIVED = 2;
    public static final int Q_AD_STATUS_DONE = 7;
    public static final int Q_AD_STATUS_NONE = 0;
}
