package com.tencent.thumbplayer.api.common;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes26.dex */
public @interface TPAudioRouteType {
    public static final int TP_AUDIO_ROUTE_TYPE_IN_BLUETOOTH_A2DP = 102;
    public static final int TP_AUDIO_ROUTE_TYPE_IN_BUILT_IN_MICROPHONE = 100;
    public static final int TP_AUDIO_ROUTE_TYPE_IN_HEADPHONE = 101;
    public static final int TP_AUDIO_ROUTE_TYPE_IN_OTHERS = 199;
    public static final int TP_AUDIO_ROUTE_TYPE_OUT_BLUETOOTH_A2DP = 2;
    public static final int TP_AUDIO_ROUTE_TYPE_OUT_BUILT_IN_SPEAKER = 0;
    public static final int TP_AUDIO_ROUTE_TYPE_OUT_HEADPHONE = 1;
    public static final int TP_AUDIO_ROUTE_TYPE_OUT_OTHERS = 99;
    public static final int TP_AUDIO_ROUTE_TYPE_UNKNOWN = -1;
}
