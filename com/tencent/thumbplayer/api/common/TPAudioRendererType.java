package com.tencent.thumbplayer.api.common;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes26.dex */
public @interface TPAudioRendererType {
    public static final int TP_AUDIO_RENDERER_TYPE_AAUDIO = 2;
    public static final int TP_AUDIO_RENDERER_TYPE_AUDIOSINK = 14;
    public static final int TP_AUDIO_RENDERER_TYPE_AUDIOTRACK = 1;
    public static final int TP_AUDIO_RENDERER_TYPE_NONE = -1;
    public static final int TP_AUDIO_RENDERER_TYPE_OBOE = 3;
    public static final int TP_AUDIO_RENDERER_TYPE_OPENAL = 5;
    public static final int TP_AUDIO_RENDERER_TYPE_OPENSL = 4;
}
