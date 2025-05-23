package com.tencent.hydevteam.pluginframework.installedplugin;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.hydevteam.common.annotation.API;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.rfix.loader.utils.RFixConstants;
import java.io.File;

@API
/* loaded from: classes7.dex */
public class PluginRunningPath {
    static IPatchRedirector $redirector_;

    public PluginRunningPath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @API
    public static String getPluginDataDir(Context context, String str) {
        String str2 = getPluginRootDir(context, str) + "data" + File.separator;
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str2;
    }

    @API
    public static String getPluginLibDir(Context context, String str, String str2) {
        boolean isEmpty = TextUtils.isEmpty(str2);
        String str3 = RFixConstants.SO_PATH;
        if (!isEmpty) {
            str3 = RFixConstants.SO_PATH + "_" + str2;
        }
        String str4 = getPluginRootDir(context, str) + str3 + File.separator;
        File file = new File(str4);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str4;
    }

    @API
    public static String getPluginNewLibDir(Context context, String str, String str2) {
        return getPluginLibDir(context, str, str2);
    }

    @API
    public static String getPluginOptDexDir(Context context, String str, String str2) {
        String str3 = "optDex";
        if (!TextUtils.isEmpty(str2)) {
            str3 = "optDex_" + str2;
        }
        String str4 = getPluginRootDir(context, str) + str3 + File.separator;
        File file = new File(str4);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str4;
    }

    @API
    public static String getPluginRootDir(Context context, String str) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(context.getDir("HYDTPlugins", 0).getAbsolutePath());
        String str2 = File.separator;
        sb5.append(str2);
        sb5.append(str);
        sb5.append(str2);
        String sb6 = sb5.toString();
        File file = new File(sb6);
        if (!file.exists()) {
            file.mkdirs();
        }
        return sb6;
    }

    @API
    public static String getPluginTmpDir(Context context, String str, String str2) {
        String str3 = "tmp";
        if (!TextUtils.isEmpty(str2)) {
            str3 = "tmp_" + str2;
        }
        String str4 = getPluginRootDir(context, str) + str3 + File.separator;
        File file = new File(str4);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str4;
    }

    @API
    public static boolean isPreOdexFileExists(Context context, String str, String str2, String str3) {
        return new File(getPluginOptDexDir(context, str, str2), str3 + ".preload").exists();
    }
}
