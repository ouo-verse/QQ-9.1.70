package com.tencent.thumbplayer.api.common;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes26.dex */
public @interface TPMediaType {
    public static final int TP_MEDIA_TYPE_ATTACHMENT = 4;
    public static final int TP_MEDIA_TYPE_AUDIO = 1;
    public static final int TP_MEDIA_TYPE_DATA = 2;
    public static final int TP_MEDIA_TYPE_SUBTITLE = 3;
    public static final int TP_MEDIA_TYPE_UNKNOWN = -1;
    public static final int TP_MEDIA_TYPE_VIDEO = 0;
}
