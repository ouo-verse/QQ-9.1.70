package com.tencent.thumbplayer.api.common;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes26.dex */
public @interface TPSwitchDataSourceMode {
    public static final int TP_SWITCH_DATA_SOURCE_MODE_AFTER_ALL_BUFFERED_DATA_CONSUMED = 3;
    public static final int TP_SWITCH_DATA_SOURCE_MODE_BYTE_ALIGN_WHEN_NEXT_REQUEST = 4;
    public static final int TP_SWITCH_DATA_SOURCE_MODE_DEFAULT = 0;
    public static final int TP_SWITCH_DATA_SOURCE_MODE_FAST_WITH_KEEP_NO_BUFFERING = 2;
    public static final int TP_SWITCH_DATA_SOURCE_MODE_IMMEDIATELY = 1;
}
