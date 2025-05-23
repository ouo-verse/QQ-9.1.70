package com.tencent.thumbplayer.api.common;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes26.dex */
public @interface TPAudioAVSyncStrategy {
    public static final int TP_AUDIO_AVSYNC_STRATEGY_ADAPTIVE = 2;
    public static final int TP_AUDIO_AVSYNC_STRATEGY_NORMAL = 0;
    public static final int TP_AUDIO_AVSYNC_STRATEGY_PERSISTENT_FREERUN = 1;
}
