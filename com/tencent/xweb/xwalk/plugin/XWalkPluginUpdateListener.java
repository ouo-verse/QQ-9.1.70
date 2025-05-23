package com.tencent.xweb.xwalk.plugin;

/* loaded from: classes27.dex */
public interface XWalkPluginUpdateListener {
    public static final int ERRCODE_CONFIG_DOWNLOAD_FAILED = -5;
    public static final int ERRCODE_CONFIG_PARSE_FAILED = -6;
    public static final int ERRCODE_IGNORE = 1;
    public static final int ERRCODE_NONE = 0;
    public static final int ERRCODE_NO_AVAILABLE_UPDATE = -8;
    public static final int ERRCODE_NO_NEED_TO_FETCH_CONFIG = -3;
    public static final int ERRCODE_NO_NETWORK = -2;
    public static final int ERRCODE_NO_PLUGIN_IN_CONFIG = -7;
    public static final int ERRCODE_OTHERS_IS_UPDATING = -4;
    public static final int ERRCODE_PLUGIN_ONLY_DOWNLOAD_ERROR = -10;
    public static final int ERRCODE_PLUGIN_ONLY_INSTALL_ERROR = -11;
    public static final int ERRCODE_PLUGIN_UPDATE_ERROR = -9;
    public static final int ERRCODE_USER_CANCEL = -1;

    void onXWalkPluginUpdateCompleted(int i3);

    void onXWalkPluginUpdateProgress(int i3);

    void onXWalkPluginUpdateStarted();
}
