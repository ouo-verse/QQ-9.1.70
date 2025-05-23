package com.tencent.oskplayer.player;

import android.graphics.Rect;

/* loaded from: classes22.dex */
public interface IExo2MediaPlayer extends ISegmentMediaPlayer {
    public static final int EXO_MEDIA_ERROR_EXTRA_CONN = -3;
    public static final int EXO_MEDIA_ERROR_EXTRA_NETWORK = -2;
    public static final int EXO_MEDIA_ERROR_EXTRA_UNKNOWN = -1;
    public static final int EXO_MEDIA_ERROR_RESPONSE_403 = -10;
    public static final int EXO_MEDIA_ERROR_RESPONSE_404 = -11;
    public static final int EXO_MEDIA_ERROR_RESPONSE_500 = -12;
    public static final int EXO_MEDIA_ERROR_RESPONSE_502 = -13;
    public static final int EXO_MEDIA_ERROR_RESPONSE_OTHER = -30;
    public static final int EXO_MEDIA_ERROR_WHAT_EXTRACTOR = -4001;
    public static final int EXO_MEDIA_ERROR_WHAT_IO = -4000;
    public static final int EXO_MEDIA_ERROR_WHAT_UNKNOWN = -4999;
    public static final int EXO_MEIDA_ERROR_ILLEGAL_STATE = -4002;
    public static final int EXO_MEIDA_ERROR_MEDIACODEC_DECODER_INIT = -4003;

    String getAudioDecoderName();

    String getAudioMIMEType();

    int getVideoBitrate();

    String getVideoDecoderName();

    Rect getVideoDimension();

    String getVideoMIMEType();

    void setRate(float f16);
}
