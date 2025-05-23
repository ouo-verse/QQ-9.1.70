package com.tencent.shadow.dynamic.host;

import android.content.Context;
import java.io.File;

/* compiled from: P */
/* loaded from: classes25.dex */
public class Constant {
    public static final long FROM_ID_INSTALL_PLUGIN = 1001;
    public static final long FROM_ID_NOOP = 1000;
    public static final long FROM_ID_START_ACTIVITY = 1003;
    public static final long FROM_ID_START_SERVICE = 1004;
    public static final long FROM_ID_STOP_SERVICE = 1005;
    public static final long FROM_ID_UNINSTALL_PLUGIN = 1002;
    public static final String KEY_CLASSNAME = "KEY_ACTIVITY_CLASSNAME";
    public static final String KEY_EXTRAS = "KEY_EXTRAS";
    public static final String KEY_PLUGIN_PART_KEY = "KEY_PLUGIN_PART_KEY";
    public static final String KEY_PLUGIN_UUID = "KEY_PLUGIN_UUID";
    public static final String KEY_PLUGIN_ZIP_PATH = "pluginZipPath";

    Constant() {
    }

    public static String getPluginInstalledPath(Context context, String str) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(context.getFilesDir().getAbsolutePath());
        String str2 = File.separator;
        sb5.append(str2);
        sb5.append("ShadowPluginManager");
        sb5.append(str2);
        sb5.append("UnpackedPlugin");
        sb5.append(str2);
        sb5.append(str);
        return sb5.toString();
    }
}
