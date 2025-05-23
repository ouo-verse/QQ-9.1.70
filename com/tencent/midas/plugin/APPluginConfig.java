package com.tencent.midas.plugin;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;

/* loaded from: classes9.dex */
public class APPluginConfig {
    static final String KERNEL_FILE_NAME = "MidasPay.zip";
    static String PLUGIN_BACKUP_TEMP_DIR_NAME = "midaspluginsBKTemp";
    public static String PLUGIN_DIR_NAME = "midasplugins";
    static String PLUGIN_EMPTY_RES_DIR_NAME = "midasemptyRes";
    static String PLUGIN_LIB_DIR_NAME = "midaslib";
    static String PLUGIN_ODEX_DIR_NAME = "midasodex";
    static String PLUGIN_UPDATE_DIR_NAME = "midaspluginsTemp";
    static String SIGN_FILE_NAME = "MidasSign.ini";
    static int libExtend;

    public static File getLibPath(Context context) {
        return context.getDir(PLUGIN_LIB_DIR_NAME + "_" + libExtend, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File getOptimizedDexPath(Context context) {
        return context.getDir(PLUGIN_ODEX_DIR_NAME, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File getPluginBackUpPath(Context context) {
        return context.getDir(PLUGIN_BACKUP_TEMP_DIR_NAME, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File getPluginDexOfOat(Context context) {
        try {
            return new File(context.getDir(PLUGIN_DIR_NAME, 0).getPath() + File.separator + "oat");
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File getPluginEmptyResPath(Context context) {
        return context.getDir(PLUGIN_EMPTY_RES_DIR_NAME, 0);
    }

    public static File getPluginPath(Context context) {
        return context.getDir(PLUGIN_DIR_NAME, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File getPluginUpdatePath(Context context) {
        return context.getDir(PLUGIN_UPDATE_DIR_NAME, 0);
    }

    public static void setPluginDirName(String str) {
        if (!TextUtils.isEmpty(str)) {
            PLUGIN_DIR_NAME = str;
        }
    }

    public static void setSignFileName(String str) {
        if (!TextUtils.isEmpty(str)) {
            SIGN_FILE_NAME = str;
        }
    }
}
