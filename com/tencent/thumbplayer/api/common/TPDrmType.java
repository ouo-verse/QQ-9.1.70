package com.tencent.thumbplayer.api.common;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes26.dex */
public @interface TPDrmType {
    public static final int TP_DRM_TYPE_CHINADRM_2_0 = 3;
    public static final int TP_DRM_TYPE_NONE = -1;
    public static final int TP_DRM_TYPE_UNITEND = 2;
    public static final int TP_DRM_TYPE_WIDEVINE = 0;
}
