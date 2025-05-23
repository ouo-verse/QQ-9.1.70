package com.tencent.thumbplayer.api.common;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes26.dex */
public @interface TPBufferStrategy {
    public static final int TP_BUFFER_STRATEGY_AUTO = -1;
    public static final int TP_BUFFER_STRATEGY_DISABLED = 0;
    public static final int TP_BUFFER_STRATEGY_JITTER = 2;
    public static final int TP_BUFFER_STRATEGY_NORMAL = 1;
}
