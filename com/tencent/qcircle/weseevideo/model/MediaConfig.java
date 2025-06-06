package com.tencent.qcircle.weseevideo.model;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MediaConfig {
    public static final int AUDIO_CHANNEL_MONO = 1;
    public static final int AUDIO_CHANNEL_STEREO = 2;
    public static final String AUDIO_ENCRYPTED_PCM_SUFFIX = ".ecm";
    public static final int AUDIO_INPUT_BUFFER_SIZE = 4096;
    public static final int AUDIO_OUTPUT_BUFFER_SIZE = 8192;
    public static final String AUDIO_PCM_FILE_POSTFIX = ".pcm";
    public static final int AUDIO_SAMPLE_RATE_IN_HZ = 44100;
    public static final int CAMERA_PREVIEW_HEIGHT_H = 640;
    public static final int CAMERA_PREVIEW_HEIGHT_L = 320;
    public static final int CAMERA_PREVIEW_WIDTH_H = 480;
    public static final int CAMERA_PREVIEW_WIDTH_L = 240;
    public static final String VIDEO_AAC_FILE_POSTFIX = ".m4a";
    public static final String VIDEO_FILE_POSTFIX = ".mp4";
    public static final int VIDEO_FRAME_RATE = 25;
    public static final int VIDEO_OUTPUT_HEIGHT = 480;
    public static final int VIDEO_OUTPUT_RIGHT_MARGIN = 12;
    public static final int VIDEO_OUTPUT_TOP_MARGIN = 15;
    public static final int VIDEO_OUTPUT_WATERMARK_HEIGHT = 31;
    public static final int VIDEO_OUTPUT_WATERMARK_WIDTH = 70;
    public static final int VIDEO_OUTPUT_WIDTH = 480;
    public static final float WATER_MARKER_BG_COLOR_ALPHA_END = 0.8f;
    public static final float WATER_MARKER_BG_COLOR_ALPHA_START = 0.0f;
    public static final int WATER_MARKER_DURATION = 1500;
    public static final float WATER_MARKER_SCALE_END = 1.1f;
    public static final float WATER_MARKER_SCALE_START = 1.0f;
    public static final int WATER_MARKER_WATER_MARKER_BLUR_RADIUS_END = 10;
    public static final int WATER_MARKER_WATER_MARKER_BLUR_RADIUS_START = 1;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class MuiscPlayer {
        public static final int ERROR_INIT_FAILED = -1000;
        public static final int ERROR_PLAYER_AUDIO_TRACK_WRITE_FAIL = -2000;
        public static final int ERROR_PLAYER_DECODER_DATA_FAILED = -2010;
        public static final int ERROR_PLAYER_DECODER_GETINFO_FAILED = -2007;
        public static final int ERROR_PLAYER_DECODER_INIT_FAILED = -2006;
        public static final int ERROR_PLAYER_FILE_NOT_FOUND = -2001;
        public static final int ERROR_PLAYER_FILE_SIZE_ZERO = -2008;
        public static final int ERROR_PLAYER_ILLEGAL_STATE = -2002;
        public static final int ERROR_PLAYER_INIT_EXCEPTION = -2004;
        public static final int ERROR_PLAYER_IO_EXCEPTION = -2003;
        public static final int ERROR_PLAYER_NOT_CREATED = -2009;
        public static final int ERROR_PLAYER_SOURCE_NOT_FOUND = -2005;
    }
}
