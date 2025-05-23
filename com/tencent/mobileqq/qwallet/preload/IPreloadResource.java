package com.tencent.mobileqq.qwallet.preload;

import java.io.Serializable;

/* loaded from: classes16.dex */
public interface IPreloadResource extends Serializable {
    public static final String ABI_32 = "32";
    public static final String ABI_64 = "64";
    public static final int FROM_TYPE_AVGAME_CJ = 3;
    public static final int FROM_TYPE_MOBILE_QQ = 0;
    public static final int FROM_TYPE_MOGGY = 1;
    public static final int FROM_TYPE_NONE = 0;
    public static final int FROM_TYPE_REDBAO = 2;
    public static final int FROM_TYPE_SEARCH_POP = 4;
    public static final int FROM_TYPE_SPRING_HB = 5;
    public static final String PARAM_KEY_MODULE = "module";
    public static final String PARAM_KEY_RES = "resource";
    public static final String PARAM_KEY_SCENE = "scene";
    public static final int PRELOAD_DOWNLOAD_NOTIFY_THRESHOLD = 1048576;
    public static final int TYPE_GIF = 2;
    public static final int TYPE_KUIKLY_FONT = 6;
    public static final int TYPE_KUIKLY_PAG = 7;
    public static final int TYPE_MP3 = 3;
    public static final int TYPE_PNG = 1;
    public static final int TYPE_VIDEO = 5;
    public static final int TYPE_ZIP = 4;

    String getResDownloadUrl(kl2.a aVar);

    String getResId();

    int getType();

    String getUrl();

    boolean isResFileExist(kl2.a aVar);
}
