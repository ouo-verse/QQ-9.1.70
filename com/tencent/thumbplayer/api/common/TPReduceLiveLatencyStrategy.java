package com.tencent.thumbplayer.api.common;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes26.dex */
public @interface TPReduceLiveLatencyStrategy {
    public static final int TP_REDUCE_LIVE_LATENCY_STRATEGY_NONE = 0;
    public static final int TP_REDUCE_LIVE_LATENCY_STRATEGY_SKIP_FRAME = 2;
    public static final int TP_REDUCE_LIVE_LATENCY_STRATEGY_SPEED_UP = 1;
}
