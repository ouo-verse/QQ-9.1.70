package com.tencent.thumbplayer.api.common;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes26.dex */
public @interface TPAudioDecoderType {
    public static final int TP_AUDIO_DECODER_DOLBY = 4;
    public static final int TP_AUDIO_DECODER_FFMPEG = 1;
    public static final int TP_AUDIO_DECODER_MEDIACODEC = 2;
    public static final int TP_AUDIO_DECODER_STANDALONE = 5;
    public static final int TP_AUDIO_DECODER_UNKNOWN = -1;
}
