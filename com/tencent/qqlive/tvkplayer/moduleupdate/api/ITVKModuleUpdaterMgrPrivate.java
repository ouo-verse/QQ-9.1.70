package com.tencent.qqlive.tvkplayer.moduleupdate.api;

import androidx.annotation.NonNull;
import java.io.FileNotFoundException;

/* loaded from: classes23.dex */
public interface ITVKModuleUpdaterMgrPrivate {
    public static final String LIB_CONFIG = "lib.config";
    public static final String MODULE_UPDATE_LOCK_SUFFIX = "_update.lock";

    @NonNull
    TVKModuleInfo getModuleInfo(@NonNull String str) throws FileNotFoundException, IllegalStateException;

    String getModulePath(@NonNull String str, @NonNull String str2) throws IllegalStateException;

    void init();
}
