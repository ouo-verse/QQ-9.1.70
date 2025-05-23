package com.tencent.mobileqq.pluginsdk;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes16.dex */
public final class PluginConst {
    static IPatchRedirector $redirector_ = null;
    public static final String KEY_BINDER_TYPE = "key_binder_type";
    public static final String KEY_PLUGIN_BINDER = "plugin_binder";
    public static final String PARAMS_REMOTE_CONNECT_AT_LAUNCH = "params_remote_connect_at_launch";
    public static final String STAT_EXTRACT_APK_COST = "pluginApkCost";
    public static final String STAT_EXTRACT_DEX2OAT_COST = "pluginOatCost";
    public static final String STAT_EXTRACT_DOWNLOAD_COST = "pluginDownloadCost";
    public static final String STAT_EXTRACT_LIB_COST = "pluginLibCost";
    public static final String STAT_LAUNCH_CLASSLOADER = "pluginLoaderCost";
    public static final String STAT_LAUNCH_COMPONENT = "launchComponent";
    public static final String STAT_LAUNCH_PROCESS = "launchProcName";
    public static final String STAT_LAUNCH_TIME_START = "launchTimeStart";
    public static final String STAT_LAUNCH_TOTAL = "launchTotal";
    public static final String TAG = "plugin_tag";
    public static final int VALUE_BINDER_TYPE_MANAGER = 1;
    public static final int VALUE_BINDER_TYPE_NONE = -1;
    public static final int VALUE_BINDER_TYPE_TRANSFER = 0;

    public PluginConst() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
