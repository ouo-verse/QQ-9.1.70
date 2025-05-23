package com.tencent.qqlive.tvkplayer.moduleupdate.api;

import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface ITVKModuleDownloader {
    public static final int MODULE_DOWNLOAD_TIMEOUT_MS = 30000;

    void downloadModuleFile(@NonNull String str, @NonNull TVKModuleInfo tVKModuleInfo) throws Exception;

    TVKModuleInfo getUpdateModuleInfo(@NonNull String str, @NonNull String str2);
}
