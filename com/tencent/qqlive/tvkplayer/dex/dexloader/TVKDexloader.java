package com.tencent.qqlive.tvkplayer.dex.dexloader;

import android.content.Context;
import com.tencent.qqlive.tvkplayer.dex.sdkupdate.TVKUpdateUtils;
import dalvik.system.DexClassLoader;
import java.io.File;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKDexloader {
    private static final String TAG = "TVKPlayer[TVKDexloader]";

    public static ClassLoader getClassLoader(Context context, String str, String str2) {
        DexClassLoader dexClassLoader = null;
        if (str == null) {
            TVKUpdateUtils.e(TAG, "filePath error, jarPath: null, soPath: " + str2);
            return null;
        }
        if (context == null) {
            TVKUpdateUtils.e(TAG, "context error, jarPath: " + str + ", soPath: " + str2);
            return null;
        }
        TVKUpdateUtils.i(TAG, "jarPath: " + str + ", soPath: " + str2);
        String absolutePath = context.getDir("assets", 0).getAbsolutePath();
        if (new File(str).exists()) {
            try {
                dexClassLoader = new DexClassLoader(str, absolutePath, str2, context.getApplicationContext().getClassLoader());
            } catch (Exception unused) {
                TVKUpdateUtils.e(TAG, "DexClassLoader failed! ");
            }
            try {
                return (ClassLoader) Class.forName("dalvik.system.LexClassLoader").getConstructor(String.class, String.class, String.class, ClassLoader.class).newInstance(absolutePath + File.separator + new File(str).getName().replaceAll("\\.[a-zA-Z0-9]+", ".lex"), absolutePath, str, context.getApplicationContext().getClassLoader());
            } catch (Exception e16) {
                TVKUpdateUtils.e(TAG, e16);
                return dexClassLoader;
            }
        }
        TVKUpdateUtils.i(TAG, "files do not exist, creat dexclassloader failed");
        return null;
    }
}
