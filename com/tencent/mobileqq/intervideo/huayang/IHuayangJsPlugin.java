package com.tencent.mobileqq.intervideo.huayang;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;

@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IHuayangJsPlugin extends QRouteApi {
    public static final String ACTION_JS_CHECK_VERSION = "checkVersion";
    public static final String ACTION_JS_DOWNLOAD = "download";
    public static final String ACTION_JS_SIIENT_DOWNLOAD = "slientDownload";
    public static final String EXTRA_KEY_DOWNLOAD_PROGRESS = "key_progress";
    public static final String EXTRA_KEY_DOWNLOAD_TOTALSIZE = "key_totalSize";
    public static final String EXTRA_KEY_ERRORMSG = "key_error_msg";
    public static final String EXTRA_KEY_INSTALLED_PLUGIN = "key_installedplugin";
    public static final String EXTRA_KEY_ISCACHE = "key_isCache";
    public static final String EXTRA_KEY_SATTE = "key_state";
    public static final String NAMESPACE = "huayang";
    public static final int STATE_CHECK_VERSION = 0;
    public static final int STATE_DOWANLOADING = 1;
    public static final int STATE_DOWANLODAD_COMPLETE = 2;
    public static final int STATE_DOWANLODAD_FAILED = 3;
    public static final int STATE_LAUNCHERING = 8;
    public static final int STATE_LAUNCHER_FAILED = 10;
    public static final int STATE_LAUNCHER_SUCC = 9;
    public static final int STATE_LOADING = 4;
    public static final int STATE_LOAD_COMPLETE = 6;
    public static final int STATE_LOAD_FALIED = 7;
    public static final int STATE_PRELOAD_FALIED = 5;
    public static final int STATE_STOP_LOAD = 10;

    String getBackNotifyAction(String str);

    String getCacheUserNotifyAction(String str);

    String getDownloadNotifyAction(String str);

    String getLauncherNotifyAction(String str);

    WebViewPlugin init();

    boolean isHyPkg(String str);

    boolean isODPkg(String str);
}
