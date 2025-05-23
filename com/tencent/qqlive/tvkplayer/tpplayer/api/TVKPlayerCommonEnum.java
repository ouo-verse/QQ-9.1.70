package com.tencent.qqlive.tvkplayer.tpplayer.api;

import com.tencent.qqlive.tvkplayer.tpplayer.tools.TVKPlayerMsgValueMap;

/* loaded from: classes23.dex */
public class TVKPlayerCommonEnum {
    public static final int DOLBY_VISON_RENDER_TYPE_DVMA = 1;
    public static final int DOLBY_VISON_RENDER_TYPE_SYSTEM = 2;

    @TVKPlayerMsgValueMap.MapAudioDecoderType(4)
    public static final int PLAYER_AUDIO_DECODER_DOLBY = 4;

    @TVKPlayerMsgValueMap.MapAudioDecoderType(1)
    public static final int PLAYER_AUDIO_DECODER_FFMPEG = 1;

    @TVKPlayerMsgValueMap.MapAudioDecoderType(2)
    public static final int PLAYER_AUDIO_DECODER_MEDIACODEC = 2;

    @TVKPlayerMsgValueMap.MapAudioDecoderType(5)
    public static final int PLAYER_AUDIO_DECODER_STANDALONE = 5;

    @TVKPlayerMsgValueMap.MapAudioDecoderType(-1)
    public static final int PLAYER_DECODER_UNKNOWN = 0;

    @TVKPlayerMsgValueMap.MapPlayerType(1)
    public static final int PLAYER_DESC_ID_ANDROID_PLAYER = 1;

    @TVKPlayerMsgValueMap.MapPlayerType(2)
    public static final int PLAYER_DESC_ID_THUMB_PLAYER = 2;

    @TVKPlayerMsgValueMap.MapPlayerType(0)
    public static final int PLAYER_DESC_ID_UNKNOWN = 0;

    @TVKPlayerMsgValueMap.MapVideoDecoderType(101)
    public static final int PLAYER_VIDEO_DECODER_FFMPEG = 101;

    @TVKPlayerMsgValueMap.MapVideoDecoderType(102)
    public static final int PLAYER_VIDEO_DECODER_MEDIACODEC = 102;

    @TVKPlayerMsgValueMap.MapVideoDecoderType(104)
    public static final int PLAYER_VIDEO_DECODER_STANDALONE = 104;
}
