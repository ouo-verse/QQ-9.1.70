package com.tencent.thumbplayer.api.common;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes26.dex */
public @interface TPContainerType {
    public static final int TP_CONTAINER_TYPE_DASH = 2;
    public static final int TP_CONTAINER_TYPE_HLS = 1;
    public static final int TP_CONTAINER_TYPE_UNKNOWN = 0;
}
