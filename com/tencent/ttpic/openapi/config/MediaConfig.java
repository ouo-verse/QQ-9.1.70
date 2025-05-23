package com.tencent.ttpic.openapi.config;

import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;

/* compiled from: P */
/* loaded from: classes27.dex */
public class MediaConfig {
    public static int BPS_HIGH = 5242880;
    public static int BPS_LOW = 5242880;
    public static int BPS_MEDIUM = 5242880;
    public static int GIF_OUTPUT_TEX_HEIGHT = 720;
    public static int GIF_OUTPUT_TEX_WIDTH = 720;
    public static int GIF_OUTPUT_WATERMARK_HEIGHT = 50;
    public static int GIF_OUTPUT_WATERMARK_WIDTH = 180;
    public static float GIF_PLAY_RATE = 0.5f;
    public static long GIF_SAMPLE_TIME_MS = 200;
    public static int INTERMIDIATE_IMAGE_WIDTH_HIGH = 1080;
    public static int INTERMIDIATE_IMAGE_WIDTH_LOW = 540;
    public static int INTERMIDIATE_IMAGE_WIDTH_MEDIUM = 720;
    public static int MS_VIDEO_FRAME_RATE = 25;
    public static final String VIDEO_AAC_FILE_POSTFIX = ".m4a";
    public static int VIDEO_FRAME_RATE = 25;
    public static int VIDEO_IMAGE_HEIGHT = 640;
    public static int VIDEO_IMAGE_WIDTH = 480;
    public static int VIDEO_OUTPUT_HEIGHT = 960;
    public static int VIDEO_OUTPUT_HEIGHT_LONG = 1280;
    public static int VIDEO_OUTPUT_HEIGHT_SHORT = 720;
    public static int VIDEO_OUTPUT_WATERMARK_HEIGHT = 55;
    public static int VIDEO_OUTPUT_WATERMARK_WIDTH = 140;
    public static int VIDEO_OUTPUT_WIDTH = 720;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public enum ENCODE_SIZE {
        HIGH(720, 1280),
        MEDIUM(PlayerResources.ViewId.CANVAS_VIDEO_TOTAL_TRAFFIC_TEXT, 1024),
        LOW(432, 768);

        public final int height;
        public final int width;

        ENCODE_SIZE(int i3, int i16) {
            this.width = i3;
            this.height = i16;
        }
    }

    public static int getDowngradeWidth(int i3) {
        if (i3 <= 0) {
            return ENCODE_SIZE.HIGH.width;
        }
        if (i3 == ENCODE_SIZE.HIGH.width) {
            return ENCODE_SIZE.MEDIUM.width;
        }
        if (i3 == ENCODE_SIZE.MEDIUM.width) {
            return ENCODE_SIZE.LOW.width;
        }
        return -1;
    }
}
