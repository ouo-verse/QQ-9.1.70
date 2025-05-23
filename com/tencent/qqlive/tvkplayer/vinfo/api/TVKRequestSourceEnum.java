package com.tencent.qqlive.tvkplayer.vinfo.api;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes23.dex */
public @interface TVKRequestSourceEnum {
    public static final int SOURCE_FROM_ASSET_PLAYER = 0;
    public static final int SOURCE_FROM_BATCH_VINFO_REQUESTER = 4;
    public static final int SOURCE_FROM_DOWNLOAD_REQUESTER = 2;
    public static final int SOURCE_FROM_PRELOADER = 1;
    public static final int SOURCE_FROM_QQLIVE_REQUESTER = 3;
}
