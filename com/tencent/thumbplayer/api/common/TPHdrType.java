package com.tencent.thumbplayer.api.common;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes26.dex */
public @interface TPHdrType {
    public static final int TP_HDR_TYPE_DOLBYVISION = 2;
    public static final int TP_HDR_TYPE_HDR10 = 0;
    public static final int TP_HDR_TYPE_HDR10PLUS = 1;
    public static final int TP_HDR_TYPE_HDRVIVID = 4;
    public static final int TP_HDR_TYPE_HLG = 3;
    public static final int TP_HDR_TYPE_NONE = -1;
}
