package com.tencent.thumbplayer.api.common;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes26.dex */
public @interface TPVideoDecoderType {
    public static final int TP_VIDEO_DECODER_FFMPEG = 101;
    public static final int TP_VIDEO_DECODER_MEDIACODEC = 102;
    public static final int TP_VIDEO_DECODER_STANDALONE = 104;
    public static final int TP_VIDEO_DECODER_UNKNOWN = -1;
}
