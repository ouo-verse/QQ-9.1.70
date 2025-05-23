package com.tencent.thumbplayer.api.richmedia;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes26.dex */
public @interface TPRichMediaDataCallbackType {
    public static final int TP_RICH_MEDIA_DATA_CALLBACK_TYPE_DIRECT = 0;
    public static final int TP_RICH_MEDIA_DATA_CALLBACK_TYPE_UNKNOWN = -1;
    public static final int TP_RICH_MEDIA_DATA_CALLBACK_TYPE_WITH_AUDIO_FRAME = 2;
    public static final int TP_RICH_MEDIA_DATA_CALLBACK_TYPE_WITH_VIDEO_FRAME = 1;
}
