package com.tencent.thumbplayer.api.common;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes26.dex */
public @interface TPAudioTrackGetLatencyStrategy {
    public static final int TP_AUDIOTRACK_GET_LATENCY_STRATEGY_GET_HARDWARE_LATENCY = 1;
    public static final int TP_AUDIOTRACK_GET_LATENCY_STRATEGY_GET_HARDWARE_LATENCY_ONLY_BLUETOOTH = 2;
    public static final int TP_AUDIOTRACK_GET_LATENCY_STRATEGY_GET_TIMESTAMP = 0;
    public static final int TP_AUDIOTRACK_GET_LATENCY_STRATEGY_GET_TIMESTAMP_ONLY_BLUETOOTH_WHEN_LATENCY_HUGE_DIFF = 3;
}
