package com.tencent.thumbplayer.api.common;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes26.dex */
public @interface TPPixelFormat {
    public static final int TP_PIXEL_FORMAT_MEDIACODEC = 167;
    public static final int TP_PIXEL_FORMAT_RGB565 = 37;
    public static final int TP_PIXEL_FORMAT_RGBA = 26;
    public static final int TP_PIXEL_FORMAT_UNKNOWN = -1;
    public static final int TP_PIXEL_FORMAT_YUV420P = 0;
    public static final int TP_PIXEL_FORMAT_YUVJ420P = 12;
}
