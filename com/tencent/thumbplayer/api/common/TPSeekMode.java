package com.tencent.thumbplayer.api.common;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes26.dex */
public @interface TPSeekMode {
    public static final int TP_SEEK_MODE_ACCURATE_POSITION = 3;
    public static final int TP_SEEK_MODE_DEFAULT = 0;
    public static final int TP_SEEK_MODE_NEXT_CLIP = 4;
    public static final int TP_SEEK_MODE_NEXT_KEY_FRAME = 2;
    public static final int TP_SEEK_MODE_PREVIOUS_KEY_FRAME = 1;
}
