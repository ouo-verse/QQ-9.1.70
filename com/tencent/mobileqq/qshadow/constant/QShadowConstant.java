package com.tencent.mobileqq.qshadow.constant;

import android.content.Context;
import com.tencent.bugly.library.BuglyAppVersionMode;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.File;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QShadowConstant {
    static IPatchRedirector $redirector_ = null;
    public static final String KEY_LOAD_INFO = "QShadowLoadInfo";
    public static final String PLUGINS_CONFIG_FILE = "plugins";
    public static final String PLUGIN_ASSET_ROOT_PATH = "qshadow-plugins";
    public static final String PLUGIN_CONFIG_FILE = "config.json";

    QShadowConstant() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String getAssetRootPath(String str) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(PLUGIN_ASSET_ROOT_PATH);
        String str2 = File.separator;
        sb5.append(str2);
        sb5.append(str);
        sb5.append(str2);
        sb5.append(BuglyAppVersionMode.RELEASE);
        return sb5.toString();
    }

    public static String getPluginRootPath(Context context, String str) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(context.getFilesDir().getAbsolutePath());
        String str2 = File.separator;
        sb5.append(str2);
        sb5.append(PLUGIN_ASSET_ROOT_PATH);
        sb5.append(str2);
        sb5.append(str);
        return sb5.toString();
    }
}
