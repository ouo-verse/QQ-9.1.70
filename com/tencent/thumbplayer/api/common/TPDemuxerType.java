package com.tencent.thumbplayer.api.common;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes26.dex */
public @interface TPDemuxerType {
    public static final int TP_DEMUXER_TYPE_FFMPEG = 0;
    public static final int TP_DEMUXER_TYPE_STANDALONE = 1;
    public static final int TP_DEMUXER_TYPE_UNKNOWN = -1;
    public static final int TP_DEMUXER_TYPE_WEBRTC = 2;
    public static final int TP_DEMUXER_TYPE_WEBRTC_ENGINE = 3;
}
