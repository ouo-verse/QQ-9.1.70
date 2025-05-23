package com.tencent.qqlive.tvkplayer.moduleupdate.api;

import com.tencent.thumbplayer.api.common.ITPModuleLoader;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface ITVKModuleLibraryLoader {
    public static final String LIBNAME_CKEYGENERATOR = "ckeygenerator";
    public static final String LIBNAME_CKGUARD = "ckguard";
    public static final String LIBNAME_DOWNLOAD_PROXY = "DownloadProxy";
    public static final String LIBNAME_TPCORE_TVIDEO = "TPCore-tvideo";
    public static final String MODULE_CKEYGENERATOR = "ckeygenerator";
    public static final String MODULE_CKGUARD = "ckguard";
    public static final String MODULE_DOWNLOAD_PROXY = "DownloadProxy";
    public static final String MODULE_TPCORE_TVIDEO = "TPCore";

    ITPModuleLoader getModuleLoader();
}
